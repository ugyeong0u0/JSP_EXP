//package edu.fisa.config;
//import java.util.Arrays;
//import java.util.HashSet;
//import java.util.List;
//import java.util.Set;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import springfox.documentation.builders.ApiInfoBuilder;
//import springfox.documentation.builders.PathSelectors;
//import springfox.documentation.builders.RequestHandlerSelectors;
//import springfox.documentation.service.ApiInfo;
//import springfox.documentation.service.ApiKey;
//import springfox.documentation.service.AuthorizationScope;
//import springfox.documentation.service.SecurityReference;
//import springfox.documentation.spi.DocumentationType;
//import springfox.documentation.spi.service.contexts.SecurityContext;
//import springfox.documentation.spring.web.plugins.Docket;
//import springfox.documentation.swagger2.annotations.EnableSwagger2;
//
//@Configuration
//@EnableSwagger2
//public class SwaggerConfig {
//	@Bean
//	public Docket restAPI() {
//		return new Docket(DocumentationType.SWAGGER_2)
//
//				// ApiInfoBuilder 생성
//				.select()
//
//				// api: 대상 패키지 설정
//				.apis(RequestHandlerSelectors.any())
//
//				// path: 특정 path 조건에 맞는 api들을 다시 필터링하여 문서화
//		          .paths(PathSelectors.any())
//
//				.build()
//				// api 스펙이 작성되어 있는 패키지 생성
//				.apiInfo(apiInfo());
//	}
//
//	// 문서를 설명하기 위한 메서드
//	private ApiInfo apiInfo() {
//		return new ApiInfoBuilder().title("우리FISA 상품 응모 REST API")
//				.description("개발 API 문서입니다")
//				.version("1.0")
//				.build();
//	}
//}
