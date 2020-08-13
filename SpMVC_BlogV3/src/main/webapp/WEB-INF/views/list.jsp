<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
<head>
<%@ include file="/WEB-INF/views/include/include-head.jspf"%>
<style>
	#main {
		background-image: url("${rootPath}/static/images/img_001.jpg");
	}
</style>
</head>
<body>
	<%@ include file="/WEB-INF/views/include/include-header.jspf"%>
	<section id="main">
		<article id="button">
			<button>
				<a href="${rootPath}/input">블로그 작성 </a>
			</button>
		</article>

		<article id="blog_body">
			<section class="blog_title">
				<h3>${TITLE}
					- <span>${USER}</span>
				</h3>
			</section>
			<section class="blog_text">
				<h5>${CONTENT}</h5>
			</section>
		</article>
	</section>
	<%@ include file="/WEB-INF/views/include/include-footer.jspf"%>

</body>
</html>