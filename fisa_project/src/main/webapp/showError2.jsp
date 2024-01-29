<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page isErrorPage="true" %>
    
    <% System.out.println("---- showError2.jsp"); %>
    
<% String url = application.getContextPath() + "/"; %>

<!DOCTYPE html>
<html>
<head>
<title>비회원응모</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Raleway">
<style>
body,h1 {font-family: "Raleway", sans-serif}
body, html {height: 100%}
.bgimg {
  background-image: url('https://img.freepik.com/premium-vector/an-apologetic-cat-with-a-sorry-sign_629534-2874.jpg');
  min-height: 100%;
  background-position: center;
  background-size: cover;
}
</style>
</head>

<body>

<div class="bgimg w3-display-container w3-animate-opacity w3-text-white">
  <div class="w3-display-topleft w3-padding-large w3-xlarge">
  </div>
  <div class="w3-display-middle">
    <h1 class="w3-jumbo w3-animate-top">로그인 후 응모 가능합니다</h1>
    <hr class="w3-border-grey" style="margin:auto;width:40%">
    <p class="w3-large w3-center w3-animate-opacity w3-text-red"><a href="${pageContext.request.contextPath}/login.html">로그인 화면으로 이동하기</a></p>
  </div>
  <div class="w3-display-bottomleft w3-padding-large">
    Powered by <a href="${pageContext.request.contextPath}/pants.jsp" target="_blank">fisa_limit</a>
  </div>
</div>

</body>
</html>
