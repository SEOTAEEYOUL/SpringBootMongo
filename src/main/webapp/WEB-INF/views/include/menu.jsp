<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!--  HOME, 메모장, 방명록 페이지로 가는 링크를 추가 -->
<a href="${path}/">Home</a> |
<a href="${path}/memo.do">메모장</a> |
<a href="${path}/guestbook.do">방명록</a> |
<div style="text-align:right;">
	<c:choose>
		<c:when test="${sessionScope.userid == null }">
			<a href="${path}/member/login.do">로그인</a>
		</c:when>

		<c:otherwise>
			${sessionScope.name} 님이 로그인 중 입니다.
			<a href="${path}/member/logout.do">로그아웃</a>
			
		</c:otherwise>
	</c:choose>	
</div>
<hr>