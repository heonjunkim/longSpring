<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootpath" value="${pageContext.request.contextPath}" />
<link rel="stylesheet" 
	href="${rootPath}/static/css/station.css?ver=2020-12-09" />
<script>
	document.addEventListener("DOMContentLoaded",function() {
		// table에 이벤트 핸들링 설정
		document.querySelector("table.station-list")
					.addEventListener("click", function(e){
			
			// 실제로 이벤트가 발생하는 곳은 TD tag이므로
			// 클릭된 TD 의 부모(closest) tag인 TR에서 data-id로
			// 설정된 값을 가져와서 busstop_id에 보관하라
			const busstop_id= e.target.closest("TR").dataset.id
			const data = {
				station : busstop_id				
			}
			fecth("${rootPath}/bis/busstop",
					{
					body :  JSON.stringify(data)
						method : 'POST',
						headers : {"Content-Type" : "application/json"}			
					},
					)
					.then(function(result){
						alert(result)
					})
					.catch(function(error){
						alert("서버 통신오류")
					});
			})
	})
</script>
<article class="station">
	<table class="station-list">
		<tr>
			<th>정류소ID</th>
			<th>정류소명</th>
			<th>다음정류소</th>
		</tr>
		<c:forEach items="${ST_LIST}" var="st">
			<tr data-id="${st.BUSSTOP_ID}" class="st_tr">
				<td>${st.STATION_NUM}</td>
				<td>${st.BUSSTOP_NAME}</td>
				<td>${st.NEXT_BUSSTOP}</td>
			</tr>
		</c:forEach>
	</table>
</article>
