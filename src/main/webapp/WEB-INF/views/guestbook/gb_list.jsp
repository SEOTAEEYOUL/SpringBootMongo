<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp" %>
게시물수 : ${map.count} 건
<c:forEach var="dto" items="${map.list}">
<!-- 개별값은 dto 이고, map 에 담긴 list -->

<form method="post" action="${path}/gbEdit.do">
<!-- post 방식으로 컨트로러에 gbEdit.do로 맵핑한다. -->
	<input type="hidden" name="_id" value="${dto._id}">
	<!-- dto 에 있는 _id(키값) 을 받고, _id 라는 이름에 변수로 저장하고, 히든타입으로 넘긴다. -->

	<table border="1" style="width:600px;">
		<tr align="center">
		<!--  width 는 칸을 % 크기로 나눈것 -->
			<td width="20%">이름</td>
			<td width="30%">${dto.name}</td>
			<td width="20%">날짜</td>
			<td width="30%">
			<!--  날짜에 패턴(타입을 지정) -->
				<fmt:formatDate value="${dto.post_date}" pattern="yyyy-MM-dd HH:mm:ss"/>
			</td>
		</tr>
		<tr>
			<td align="center">이메일</td>
			<td colspan="3">${dto.email}</td>
		</tr>
		<tr>
			<td colspan="4">${dto.content}</td>
		</tr>
		<tr>
			<td colspan="4" align="center">
				비밀번호 <input type="password" name="passwd">
				<input type="submit" value="편집">
			</td>
		</tr>
	</table>		
</form>
</c:forEach>