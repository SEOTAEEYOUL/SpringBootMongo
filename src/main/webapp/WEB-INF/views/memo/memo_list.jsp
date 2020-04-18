<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp" %>
<%-- @ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" --%>
<%-- @ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" --%>

<table border="1" style="width:700px;">
	<tr>
		<th>No</th>
		<th>이름</th>
		<th>메모</th>
		<th>날짜</th>
	</tr>
	<c:forEach var="row" items="${map.items}" varStatus="status"> <!--  varStatus 는 변수명를 붙인것 -->
	<!-- 컨트롤러에서 보낸 map 의 itmes 안에 있는 값들을 하나씩 출력 -->
	<tr>
		<td>${status.count}</td>
		<!-- 원래 {row.id} 가 키값인데 이렇게 쓰면 숫자 뒤에 소숫점이 붙어 나오고, status 를 쓰면 중간에 값이 빠질일이 없이 제대로 출력된다. -->
		<!--  index 0부터, count 1 부터이기 때문에 count 를 사용해서 소수점을 제외하고 출력시킨다. -->
		
		<td>${row.writer}</td>
		<td>
			<a href="#" onClick="memo_view('${row._id}')">${row.memo}</a>
		</td>
		<td>
		    <fmt:formatDate value="${row.post_date}" pattern="yyyy-MM-dd HH:mm:ss"/>
		</td>
	</tr>
	</c:forEach>
</table>