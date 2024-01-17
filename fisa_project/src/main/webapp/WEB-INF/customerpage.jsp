<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<% System.out.println("------");

System.out.println(request.getAttribute("productAll"));
%>
  
<% String url = application.getContextPath() + "/"; %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>


<head>
	<title>상품 응모 사이트</title>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">

	<!-- css 외부 파일을 inclue-->
	<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
	<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Karma">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">


	<!-- 현 html에 css로 꾸미는 것을 명시-->
	<style>
		body,
		h1,
		h2,
		h3,
		h4,
		h5,
		h6 {
			font-family: "Karma", sans-serif
		}

		.w3-bar-block .w3-bar-item {
			padding: 20px
		}
	</style>


</head>

<body>

	<!-- Sidebar -->
	<nav class="w3-sidebar w3-bar-block w3-card w3-top w3-xlarge w3-animate-left"
		style="display:none;z-index:2;width:40%;min-width:300px" id="mySidebar">
		<a href="javascript:void(0)" onclick="w3_close()" class="w3-bar-item w3-button">하의</a>
		<a href=top.jsp onclick="w3_close()" class="w3-bar-item w3-button">상의</a>
		<a href=shose.jsp onclick="w3_close()" class="w3-bar-item w3-button">신발</a>
		<a href=product.html onclick="w3_close()" class="w3-bar-item w3-button">상품 저장 페이지</a>
		<a href="productAll" onclick="w3_close()" class="w3-bar-item w3-button">전체 상품 조회 페이지</a>
		<a href="drawAll" onclick="drawGet()" class="w3-bar-item w3-button">고객 응모 내역 페이지</a>
	</nav>


	<!-- Top menu -->
	<div class="w3-top">
		<div class="w3-white w3-xlarge" style="max-width:1200px;margin:auto">
			<div class="w3-button w3-padding-16 w3-left" onclick="w3_open()">&#9776;</div>
			<div class="w3-center w3-padding-16"><img src="images/brand_logo.jpg" alt="Steak" style="width:100px;height:70px"></div>
		</div>
	</div>

	<!-- !PAGE CONTENT! -->
	<div class="w3-main w3-content w3-padding" style="max-width:1200px;margin-top:100px">

		<%
		//로그인된 아이디가 있는지 읽어와보기
		Long customerId =(Long)session.getAttribute("customerId");
		String name =(String)session.getAttribute("name");
		%>
		
		<%if(customerId==null){%>
			<a href="login.html" target="_self">
				<button style="font-size:15px">로그인</button>
			</a>
		<%}else{ %>	
			<%= name %> 님 환영합니다.
		<%} %>

		
		<br>
		<br> 내가 응모한 상품 조회
		<table border="1">
			<thead>
				<tr>
					<th>고객이름</th><th>상품명</th><th>price</th><th>브랜드</th><th>size</th>
					<th>category</th>
				</tr>
			</thead>
	
	<%-- 모든 기부자 정보 보기 : 기부자 id를 클릭하면 "재능 기부자"상세 보기 로직이 실행되어야 함 --%>
	<c:forEach items="${requestScope.drawAll}" var="data">
		 <tr>
			<td>${data.name}</td>
			<td>${data.productName}</td>
			<td>${data.price}</td>
			<td>${data.brand}</td>
			<td>${data.size}</td>
			<td>${data.category}</td>
		 </tr>
	 </c:forEach>

</table>
</div>
	<script>
		// Script to open and close sidebar
		function w3_open() {
			document.getElementById("mySidebar").style.display = "block";
		}

		function w3_close() {
			document.getElementById("mySidebar").style.display = "none";
		}

		function drawGet(){	
			var xhttp = new XMLHttpRequest();
			xhttp.open( "get", "drawAll");
			xhttp.send();
		}	
	</script>
</body>

</html>