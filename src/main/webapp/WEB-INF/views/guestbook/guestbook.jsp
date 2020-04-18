<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Guestbook</title>
<%@ include file="../include/header.jsp" %>
<script>
	// 페이지가 로딩되면 바로 gbList( ) 함수가 실행
	$(function( ) {
		gbList( );
	});

	function gbList( ) {
		// 비동기 방식으로 gbList.do 를 호출해서 안에 잇는 데이터를 받아옴
		$.ajax({
			url: "${path}/gbList.do",

			// 데이터가 이동되는게 성공했다면, 리스트가 출력된게 result 변수로 넘어옴
			success: function(result) {
				// id 가 gbList 인 값안에 result 값이 찍히게 된다.
				$("#gbList").html(result);
			}
		});
	}
</script>
</head>
<body>
<%@ include file="../include/menu.jsp" %>
<h2>방명록</h2>
<input type="button" value="글쓰기 " onClick="location.href='${path}/gbWrite.do'">
<div id="gbList">
</div>

</body>
</html>