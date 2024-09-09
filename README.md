![image](https://github.com/user-attachments/assets/8f988286-7811-4070-8d5f-a2b27117853f)# fisa_limit



- **개발 환경**
    
    언어: JAVA17
    
    데이터베이스: MySql, Oracle
    
    라이브러리: lombok, JPA, hibernate, jdbc, log4j, jackson
    
    협업 툴: Git
    
    테스트: Junit4
    
    성능 테스트: jmeter
    

- **데이터베이스 분리**
    - 운영 디비 - Oracle
    - 개발 디비 - MySql

- 기본 설정
    
    **profile 설정**
    
    ```java
    server:
      port: 80
      servlet:
        context-path: /draw
    
    //2.4 이상의 버전 dev     
    spring:
      config:
        activate:
          on-profile: dev  
          
      datasource:
        driver-class-name: com.mysql.cj.jdbc.Driver
        password: user01
        url: jdbc:mysql://127.0.0.1:8889/fisa?useSSL=false&allowPublicKeyRetrieval=true
        username: user01
        
      jpa:
        database: mysql
        database-platform: org.hibernate.dialect.MySQL8Dialect
        generate-ddl: true
        hibernate:
          ddl-auto: create
        show-sql: true 
      mvc:        # jsp 사용을 위한 필수 설정, WEB-INF 폴더 직접 만들고, pom.xml에 설정, ProbonoController의 메소드 setViewName()확인하기
        view:
          prefix: /WEB-INF/
          suffix: .jsp
    ---
    //2.4 profile 분리 - prod
    spring:
      config:
        activate:
          on-profile: prod
      datasource:
        driver-class-name: oracle.jdbc.OracleDriver
        password: scott
        url: jdbc:oracle:thin:@127.0.0.1:9998:xe
        username: tiger
      jpa:
        database: oracle
        database-platform: org.hibernate.dialect.OracleDialect
        generate-ddl: true
        hibernate:
          ddl-auto: none
        show-sql: true 
      mvc:
        view:
          prefix: /WEB-INF/
          suffix: .jsp
    ```
    
    실행 설정
   ![image](https://github.com/user-attachments/assets/c65ea135-2439-44ad-a8ce-c30d7373e4f9)

    

- **개발 규칙**
    1. 자바: 카멜표기법
    2. DB: 스네이크 표기법
    3. bullder 패턴
    4. ToString 재사용
    5. 깃 브랜치 전략
    6. System.out.println을 지양하고 log4j or slf4j 지향할 것

- **git 전략**
    
    **Main - 운영 코드**
    
    - feature/shoes - ugyeong0u0
    - feature/pant - 김00
    - feature/top- 이00
    
    완성 시 브랜치 삭제 
    
    
## 3️⃣ Issue

### **헷갈린 코드 → 해결**

1. dto → entity

```java
//dto
public Product toEntity(ProductDto productDto) {
		return Product.builder()
				.productName(productDto.getProductName())
				.price(Integer.valueOf(productDto.getPrice()))
				.brand(productDto.getBrand())
				.size(Integer.valueOf(productDto.getSize()))
				.category(Category.top)
				.build();	
	}

@Transactional
public ProductDto productOne(Long productId) {
		Optional<Product> one = productRepository.findById(productId);
		ProductDto dto = new ProductDto().toDto(one.get());
	return dto;
}
```

1. entity → dto

```java
//dto
public ProductDto toDto(Product product) {
		return ProductDto.builder()
				.productName(product.getProductName())
				.price(product.getPrice())
				.brand(product.getBrand())
				.size(product.getSize())
				.category(product.getCategory())
				.build();
	}

@Transactional
public List<ProductDto> productAll() {
		List<Product> pro = productRepository.findAll();
		List<ProductDto> pList = pro.stream().map(p -> new ProductDto().toDto(p)).toList();
		return pList;
}
```

### 연관 관계 설정의 중요성

상품을 단순히 응모하기 때문에 중간 테이블을 추가로 설정하는 것을 완전히 놓쳤습니다. 

```java
@Entity
public class Product {

	@OneToMany(mappedBy = "product")
	private List<Customer> customerList = new ArrayList<>();

	public void addProduct(Customer c) {
		this.customerList.add(c);
		c.setProduct(this);
	}
}

public class Customer { //N -> 컬럼에 product_id 생성 

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "product_id")
	private Product product;
}
----------
@Entity
public class Product {

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "customer_id")
	private Customer customer;
}

@Table(name="customer")
@Entity
public class Customer {

	@OneToMany(mappedBy = "customer")
	private List<Product> productList = new ArrayList<>();
	
	public void addProduct(Product p) {
		p.setCustomer(this);
		this.productList.add(p);
	}
}
```

![image](https://github.com/user-attachments/assets/2a7fe76b-c758-4ff5-95c6-9f98d6156c4a)



변경된 방식 

```java
@Entity
public class Product {

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "customer_id")
	private Customer customer;
}

@Table(name="customer")
@Entity
public class Customer {

	@OneToMany(mappedBy = "customer")
	private List<Product> productList = new ArrayList<>();
	
	public void addProduct(Product p) {
		p.setCustomer(this);
		this.productList.add(p);
	}
}
```

연관 관계를 수정하고 나니 여러 상품들 중에서 

![image](https://github.com/user-attachments/assets/db9d87f2-357b-4d49-a2aa-66a50aeeaceb)



### 조회 시 고민했던 부분

1. **nativeQuery → JPQL**

nativeQuery

```java
@Query(value = "select * from product p inner join customer c on p.customer_id = c.customer_id "
			+ "where c.customer_id = :customerId", nativeQuery = true)
	Long findByCustomerId(@Param("customerId") Long customerId);
	List<ProductDto> findAllByCustomerId(@Param("customerId") Long customerId);
```

- **장점**
1. DB에 직접적으로 쿼리를 실행시켜 속도가 빠르다.
2. SQL 언어를 전체적으로 사용 가능하다.
3. 여러 조인이나 복잡한 쿼리를 작성할 때 직관적이며 이해하기 쉽다.

- **단점**
1. 특정 DB에대해 쿼리를 작성하기에 종속성이 높아질 수 있고 DB가 수정되면 쿼리를 다시 만들어야 한다.. (MySQL에서는 LIMIT / Oracle에서는 ROWNUM 등)
2. 결과를 Object 리스트로 반환 하기에 JPQL의 TypedQuery보다 안정성 부분에서 미흡하다.
3. 주의할 점으로 사용자에게 입력된 값을 매개변수로 바인딩하거나 따로 유효성 검사가 필요할 수 있다.

JPQL

```java
@Query(value = "select "
			+ "new edu.fisa.lab.customer.dto.ProductDto(p.productName, p.price, p.brand, p.size, p.category)"
			+ "from Product p join customer c "
			+ "where c.customerId = :customerId")
	List<ProductDto> findAllByCustomerId(@Param("customerId") Long customerId)
```

- **장점**
1. 객체 지향적인 쿼리로 DB 테이블 조인이 아닌 java에서 엔티티관계 및 상속 개념으로 봐야한다.
2. 반환 유형을 지정할 수 있다.
3. 특정 유형의 DB(MySQL, Oracle)에 연결된 것이 아니기에 데이터베이스 변경 시에도 유지, 보수 부분에서 유연하며 쿼리를 다시 작성할 필요가 없다.
4. 코드 실행 단계가 아닌 코드를 작성하는 시점에서 빠르게 오류를 발견할 수 있다.
- **단점**
1. 모든 SQL 기능을 지원하지 않아 쿼리 작성에 유연하지 않다
2. 여러 조인이나 복잡한 쿼리를 작성해야 할 때 어렵다.
3. 매핑하여 사용하는 만큼 DB에 직접적으로 쿼리를 실행하는 NativeQuery보다 속도적인 부분에서 차이가 있다.

**JPQL를 사용한 이유**

JPA는 ORM을 사용하기 때문에 DB를 변경할 때도 유연하게 처리할 수 있고 컴파일 시점에서 에러를 찾을 수 있기 때문에 JPQL를 사용했습니다.  

1. **리스트 전체 조회를 어떻게 할 것인가?**
- 처음엔 데이터 컬럼별로 하나씩 담아와서 find 메서드를 하나씩 다 구현하려 했습니다.
    - 비효율적이라 판단
        
        → 전체 데이터를 findAll()함수를 사용해서 조회한 후, List에 담아서 반환했습니다. 
        

1. **DTO VS entity 조회**
- entity를 통해서 조회
    - Product
- Dto 조회
    - ProductDto

entity 방식과 DTO 방식의 차이

: 조회에 따라 DTO를 여러 개 만들어야 할 수 있으므로 재사용성에 있어서는 좋지 않다.

dto entity 조회는 모든 필드를 조회하기 때문에 성능상 좋지 않지만 조회방식에 상관이 없어 재사용성에 좋다.

⇒ 이 프로젝트는 소수의 필드로 이루어져있기 때문에 둘 사이에 성능 차이는 크게 없다.

---

## 4️⃣ 성능 측정

### JMeter

• 응답속도나 단위 시간당 일 처리량 등을 측정

- thread Group 설정 : 1초동안 1000개 thread생성(사용자)
- Loop Count : Thread(사용자)가 행하는 작업의 반복횟수

![image](https://github.com/user-attachments/assets/24a453fe-b97e-427e-be54-d0e774e54a32)


- GET

![image](https://github.com/user-attachments/assets/c52cfa19-646b-438c-91f9-9341082d606b)


Graph tree

![image](https://github.com/user-attachments/assets/9829b10f-731d-4f5f-b54d-33c79ddb9826)


- `Throughput` : 단위 시간당 대상 서버(웹서버, WAS, DB 등)에서 처리되는 요청의 수를 말합니다. JMeter에서는 시간 단위를 보통 TPS(Transaction Per Second)로 표현합니다.
- `Deviation` : 표준편차
- 결과 보고서(chart-rersponseTime)
    
    [index.html](https://prod-files-secure.s3.us-west-2.amazonaws.com/e5e1ebf5-2501-431d-ace0-ffd31b125b42/66a79733-972d-4464-b023-784419321311/index.html)
    

- POST

![Untitled](https://prod-files-secure.s3.us-west-2.amazonaws.com/e5e1ebf5-2501-431d-ace0-ffd31b125b42/341012f1-0da7-4969-a114-0dc898fb4fa7/Untitled.png)

![Untitled](https://prod-files-secure.s3.us-west-2.amazonaws.com/e5e1ebf5-2501-431d-ace0-ffd31b125b42/24306c78-2aad-4a27-bcc6-0ee8230f26ce/Untitled.png)
