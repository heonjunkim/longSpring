<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="rootPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
 <meta name='viewport' content='width=device-width, initial-scale=1'>
<title>나의 홈페이지</title>
</head>
<body>

<style>

h4#login-fail {
	margin: 5px auto;
	background-color: red;
	color: yellow;
	border-radius: 15px;
	padding: 8px; 
}
</style>

<section id="login-body">
	<form method="POST" action="${rootPath}/login">
		<h2>로그인</h2>		
		<c:if test= "${not empty SPRING_SECURITY_LAST_EXCEPTION}">
			<h4 id="login-fail"> ${SPRING_SECURITY_LAST_EXCEPTION.message}</h4>
			<c:remove var="SPRING_SECURITY_LAST_EXCEPTION" scope="session"/>				
		</c:if>		
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
		<input name="username" placeholder="아이디">
		<input name="password" type="password" placeholder="비밀번호">
		<button>로그인</button>
		<button type="button">회원가입</button>
	</form>
</section>	

</body>
</html>

