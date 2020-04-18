<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Memo </title>
<%@include file="../include/header.jsp" %>
<script>
	// 이 페이지가 호출되었을 때 memo_list( )가 제일 먼저 호출됨
	$(function(){
		memo_list( );

		// 메모를 쓰고 난 다음 확인 버튼을 누르면 밑에 있는 코드에 id값 :btnWriter 가 이 태그로 맵핑되고,
		// memo_insert( ) 함수가 실행된다.
		$("#btnWriter").click(function( ) {
			memo_insert( );
		})
	}) 
	
	function memo_insert( ) {
		var writer = $("#writer").val( ); // 메모를 작성한 작성자의 이름이 writer 변수에 담긴다.
		var memo   = $("#memo").val( );    // 작성한 메모가 memo 변수에 저장된다.

		$.ajax({
			type: "post",
			data: {"writer": writer, "memo": memo},
			url: "${path}/memo_insert.do",

			success: function( ) {
				memo_list( );
				$("#writer").val("");
				$("#memo").val("");
			}
		});
	}

	function memo_list( ) {
		// ajax 방식은 화면이 안 바뀌고 백그라운드에서만 실행되는 것
		$.ajax({
			url: "${path}/memo_list.do",
			success: function(result) {
				$("#memoList").html(result);
			}		
		});
	}

	function memo_view(num) {
		// memo_view.do?_id=5
		location.href = "${path}/memo_view.do?_id=" + num;
	}
</script>
</head>
<body>
<%@ include file="../include/menu.jsp" %>
<h2>한줄 메모장</h2>

이름:  <input id="writer">
메모 : <input id="memo" size="50">
<input type="button" value="확인" id="btnWriter">
<div id="memoList"></div>
</body>
</html>