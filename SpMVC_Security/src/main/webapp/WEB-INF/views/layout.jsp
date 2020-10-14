<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<c:set var="rootPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <title>world</title>
</head>
<style>

section#content {
	/*
	html, body의 height : 100 %로 설정하고,
	body를 flex로 설정
	flex-direction : column으로 설정
	header, nav, content, footer를 각각 배열하고
	
	content가 있는 box에만 flex: 1 로설정하면
	세로방향 전체 가득찬 layout이 만들어진다.
	*/
	flex: 1;
	/* content box 에 포함되는 내용이 넘치면 자동으로 scroll bar를 형성 */
	overflow: auto;
}
nav#main-nav ul {
}

nav#main-nav li {
	padding : 8px 16px; 
	margin: 0px 5px;
	color : white;
	border-bottom: 3px solid transpart;
}
</style>
<body>
    <tiles:insertAttribute name="header"/>
    <tiles:insertAttribute name="menu"/>
    <section id="content">
    	<tiles:insertAttribute name="content"/>
    </section>
    <tiles:insertAttribute name="footer"/>
</body>
</html>