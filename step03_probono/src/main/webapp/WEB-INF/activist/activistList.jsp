<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>모든 Activist list 화면</title>
</head>

<body>
<br><br><br>
<h3>재능 기부자 list</h3>
<hr> 

추가 학습 <p>

1. 기부자 id 클릭시엔 비동기로 요청해서 해당 기부자 정보 검색해서 하단에 출력하는 로직 <br><br>
2. table tag가 이미 존재하기는 하나 css 적용 기술로 안보이게 설정해 놨음 display='none' <br><br>
3. 재능 기부자 list에서 기부자 id 클릭하면 이미 존재했던 table이 보이게 되면서 비동기로 요청한 데이터가 출력 <br><br>
4. 주의사항 : js의\${}과 jsp의 \${} 표현 혼용 사용할 경우 jsp tag로 인지 따라서 js 파일에선  js의 \${} tag 사용시 \ 표기로 처리 해야 함


<br><hr><br>

<table border="1">
	<thead>
		<tr>
			<th>기부자 id</th><th>기부자 이름</th><th>주요 분야</th>
		</tr>
	</thead>
	
	<%-- 모든 기부자 정보 보기 : 기부자 id를 클릭하면 "재능 기부자"상세 보기 로직이 실행되어야 함 --%>
	<c:forEach items="${requestScope.activistAll}" var="data">
		 <tr>
		 	<td><span onclick="activistOneView('${data.id}')">${data.id}</a></td>
			<td>${data.name}</td>
		 	<td>${data.major}</td>
		 </tr>
	 </c:forEach>

</table>

<br><hr><br>

*** 선택된 기부자 보기 *** <br><br>
<div id="activistView" style="display: none;">
	<table border="1">
		<tr><th>activist_id</th><th>name</th><th>major</th></tr>
		<tr>
			<td id="activistId"></td>
			<td id="activistName"></td>
			<td id="activistMajor"</td>
		 </tr>
	</table>
</div>

<br><hr><br>
<font color="blue">재능 기부자 id를 클릭하면 상세 정보 확인이 가능합니다</font>
&nbsp;&nbsp;&nbsp;<a href="${pageContext.request.contextPath}/index.html">메인 화면 이동</a>


<script>
	//기부자 한명 정보 검색
	function activistOneView(v){		
		const xhttp = new XMLHttpRequest();		

		xhttp.onload = function() {			
			let data = JSON.parse(this.responseText);
			console.log('jsp tag로 인식 따라서 변수 인식 불가 ', `${data.id}`);
			console.log('특수 기호 사용으로 js의 tag로 인식 ', `\${data.id}`);
			
			
			let tableElement = document.getElementById("activistView").style.display = "block";

			document.getElementById("activistId").innerHTML = data.id;
			document.getElementById("activistName").innerHTML = data.name;
			document.getElementById("activistMajor").innerHTML = data.major;
		};
		
		xhttp.open( "GET", "activist?id="+v);
		xhttp.send();
	}	

</script>

</body>
</html>