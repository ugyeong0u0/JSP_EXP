<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page isErrorPage="true" %>
    
    <% System.out.println("---- showError2.jsp"); %>
    
<% String url = application.getContextPath() + "/"; %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>잘못된 접근</title>
</head>

<body>
<br><br><br>

	<center>
		<h3>${requestScope.errorMsg}</h3>
		<h2>다시 메인에서 로그인 후 접근해주세요 </h2>
			
		<br><br><br>
		<a href="${pageContext.request.contextPath}/index.html">메인 화면으로 이동하기</a>
	</center>
	
</body>
</html>