<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    
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
		<a href="drawAll" onclick="w3_close()" class="w3-bar-item w3-button">고객 응모 내역 페이지</a>
		<a href=showError.jsp onclick="w3_close()" class="w3-bar-item w3-button">에러</a>
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
		//로그인된 아이디가 있는지
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

		<!-- First Photo Grid-->
		<div class="w3-row-padding w3-padding-16 w3-center" id="food">
			<div class="w3-quarter">
				<img src="images/pant1.PNG" alt="Sandwich" style="width:100%">
				<h4>Thom Browne 4 Bar Cotton Loopback Sweatpants Navy (21FW)</h4>
				<p>가격 625,000원</p>
				<!-- 버튼 추가 -->
				<!-- 버튼 추가 -->
				<a href="#pant1" id="btn">
					<button onclick="drawView(1)" style="font-size:10px">응모하기</button>
				</a>
			</div>
			<div class="w3-quarter">
				<img src="images/pant2.PNG" alt="Steak" style="width:100%">
				<h4>Stussy Airbrush Icon Beach Pants Black</h4>
				<p>가격 220,000원</p>
				<!-- 버튼 추가 -->
				<a href="#pant2" id="btn">
					<button onclick="drawView(2)" style="font-size:10px">응모하기</button>
				</a>
			</div>
			<div class="w3-quarter">
				<img src="images/pant3.PNG" alt="Cherries" style="width:100%">
				<h4>Jordan x Travis Scott Shorts Light Iron Ore - Asia</h4>
				<p>가격 149,500원</p>
				<!-- 버튼 추가 -->
			<!-- 버튼 추가 -->
				<a href="#pant3" id="btn">
					<button onclick="drawView(3)" style="font-size:10px">응모하기</button>
				</a>
			</div>
			<div class="w3-quarter">
				<img src="images/pant4.PNG" alt="Pasta and Wine" style="width:100%">
				<h4>Burberry Check Swim Shorts Archive Beige</h4>
				<p>가격 374,000원</p>
				<!-- 버튼 추가 -->
				<a href="#pant4" id="btn">
					<button onclick="drawView(4)" style="font-size:10px">응모하기</button>
				</a>
			</div>
		</div>

		<!-- Second Photo Grid-->
		<div class="w3-row-padding w3-padding-16 w3-center">
			<div class="w3-quarter">
				<img src="images/pant5.PNG" alt="Popsicle" style="width:100%">
				<h4>Burberry Check Swim Shorts Archive Beige</h4>
				<p>가격 374,000원</p>
				<!-- 버튼 추가 -->
				<a href="#pant5" id="btn">
					<button onclick="drawView(5)" style="font-size:10px">응모하기</button>
				</a>
			</div>
			<div class="w3-quarter">
				<img src="images/pant6.PNG" alt="Salmon" style="width:100%">
				<h4>Maison Margiela Dirty Wash Jeans Dirty Wash</h4>
				<p>가격 490,000원</p>
				<!-- 버튼 추가 -->
				<a href="#pant6" id="btn">
					<button onclick="drawView(6)" style="font-size:10px">응모하기</button>
				</a>
			</div>
			<div class="w3-quarter">
				<img src="images/pant7.PNG" alt="Sandwich" style="width:100%">
				<h4>Jordan x Russell Westbrook Honor the Gift Men’s Pants</h4>
				<p>가격 205,000원</p>
				<!-- 버튼 추가 -->
				<a href="#pant1" id="btn">
					<button onclick="drawView(7)" style="font-size:10px">응모하기</button>
				</a>
			</div>
			<div class="w3-quarter">
				<img src="images/pant8.PNG" alt="Salmon" style="width:100%">
				<h4>Puma x AMI Sweatpants Jaffa Orange</h4>
				<p>가격 109,000원</p>
				<!-- 버튼 추가 -->
				<a href="#pant1" id="btn">
					<button onclick="drawView(8)" style="font-size:10px">응모하기</button>
				</a>
			</div>
		</div>

		<!-- Pagination -->
		<div class="w3-center w3-padding-32">
			<div class="w3-bar">
				<a href="#" class="w3-bar-item w3-button w3-hover-black">&laquo;</a>
				<a href="#" class="w3-bar-item w3-black w3-button">1</a>
				<a href="#" class="w3-bar-item w3-button w3-hover-black">2</a>
				<a href="#" class="w3-bar-item w3-button w3-hover-black">3</a>
				<a href="#" class="w3-bar-item w3-button w3-hover-black">4</a>
				<a href="#" class="w3-bar-item w3-button w3-hover-black">&raquo;</a>
			</div>
		</div>
	</div>

	<script>
		// Script to open and close sidebar
		function w3_open() {
			document.getElementById("mySidebar").style.display = "block";
		}

		function w3_close() {
			document.getElementById("mySidebar").style.display = "none";
		}

		//한명 정보 검색시 호출되는 함수
		function drawView(v){	
			var xhttp = new XMLHttpRequest();
			xhttp.onload = function() {
				if(xhttp.status ===200){
					alert(xhttp.responseText);
				}else{
					window.location.href ='showError2.jsp';
				}
				  
			};
			xhttp.open( "get", "drawCreate?productId="+v);
			xhttp.send();
		}
		
		function drawGet(){	
			var xhttp = new XMLHttpRequest();
			xhttp.open( "get", "drawAll");
			xhttp.send();
		}	
	</script>

</body>

</html>