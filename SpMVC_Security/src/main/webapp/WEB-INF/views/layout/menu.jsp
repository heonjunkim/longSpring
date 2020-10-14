<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	/*
spring security에서 ROLE 정보를 확인하여
권한에 따라서 메뉴를 보이고 보이지 않도록 하는 용도로 사용하는 taglib
*/
%>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>


<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<style>
* {
	box-sizing: border-box;
	margin: 0;
	padding: 0;
}

html, body {
	width: 100%;
	height: 100%;
}

body {
	display: flex;
	flex-direction: column;
}

header {
	height: 300px;
	background-color: rgb(60, 60, 60);
	width: 100%;
	color: white;
	text-align: center;
	position: relative;
	display: flex;
	flex-direction: column;
	justify-content: center;
	align-items: center;
	background-image: linear-gradient(10deg, green 50%, transparent 50%),
		linear-gradient(-60deg, yellow 30%, transparent 30%);
}

nav#main-nav ul {
	list-style: none;
	display: flex;
	background-color: rgb(40, 40, 40);
}

nav#main-nav li {
	padding: 12px;
	color: white;
	border-bottom: 3px solid transparent;
}

nav#main-nav li:hover {
	border-bottom: 3px solid dodgerblue;
	cursor: pointer;
}

nav#main-nav li:nth-child(3) {
	margin-left: auto;
}

footer {
	background-color: dodgerblue;
	color: white;
	text-align: center;
	padding: 0.2rem;
}
</style>
<script>
	window.addEventListener("load", function() {

		document.querySelector("#menu-home").addEventListener("click",
				function() {
					document.location.href = `${rootPath}/`
				});
		
		document.querySelector("#menu-center").addEventListener("click",
				function() {
					document.location.href = `${rootPath}/admin`
				});

		document.querySelector("#menu-join").addEventListener("click",
				function() {
					document.location.href = `${rootPath}/user/join`
				});
		document.querySelector("#menu-login").addEventListener("click",
				function() {
					document.location.href = `${rootPath}/user/login`
				});
		document.querySelector("#menu-mypage").addEventListener("click",
				function() {
					document.location.href = `${rootPath}/user/mypage`
				});
	});
</script>
<nav id="main-nav">
	<ul>
		<li id="menu-home">Home</li>
		<li id="menu-center">Center</li>
		<%
			/*
		isAnnoymous()
		현재 화면에서 로그인한 세션정보를 찾을 수 없으면
		회원가입, 로그인 메뉴를 보여라
		*/
		%>
		<sec:authorize access="isAnonymous()">
			<li id="menu-join">회원가입</li>
			<li id="menu-login">로그인</li>
		</sec:authorize>


		<%
			/*
		isAuthenticated()
		현재 화면에서 권한에 관계없이 로그인한 세션정보가 있으면			
		Mypage, 로그아웃 메뉴를 보여라
		*/
		%>
		<sec:authorize access="isAuthenticated()">
			<li id="menu-mypage">MyPage</li>
			<li>로그아웃</li>
		</sec:authorize>


		<%
			/*
		hasRole('ROLE_ADMIN')
		로그인 세션정보가 있고, ROLE(권한)정보가 ADMIN 이면		
		*/
		%>
		<sec:authorize access="hasRole('ROLE_ADMIN')">
			<li>관리자</li>
		</sec:authorize>

		<%
			/*
		hasRole('ROLE_USER')
		로그인 세션정보가 있고, ROLE(권한)정보가 USER 이면		
		*/
		%>
		<sec:authorize access="hasRole('ROLE_USER')">
			<li>일반 사용자</li>
		</sec:authorize>

		<%
			/*
		hasRole('ROLE_GUEST')
		로그인 세션정보가 있고, ROLE(권한)정보가 GUEST 이면		
		*/
		%>
		<sec:authorize access="hasRole('ROLE_GUEST')">
			<li>손님</li>
		</sec:authorize>

	</ul>
</nav>