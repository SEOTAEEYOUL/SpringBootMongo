<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Memo View</title>
<%@ include file="../include/header.jsp" %>
<script>
	$(function(){
		// 수정버튼을 클릭하면 실행되는 함수, 밑에 코드에서 매핑되어서
		// 컨트롤러의 memo_update.do url 로 매핑시킨다.
		$("#btnUpdate").click(function( ) {
			document.form1.action = "${path}/memo_update.do";
			document.form1.submit( );
		});

		// 삭제버튼을 클릭하면 실행되는 함수, 밑에 코드에 매핑되어서
		// 컨트롤러에 memo_delete.do url 로 매핑시킨다.
		$("#btnDelete").click(function( ) {
			if (confirm("삭제하겠습니까 ?")) {
				document.form1.action = "${path}/memo_delete.do";
				document.form1.submit( );
			}
		});
	});
</script>
</head>
<body>
<%@ include file="../include/menu.jsp" %>
<h2> 메모장 </h2>

<form name='form1' method="post">
<input type="hidden" name="_id" value="${dto._id}">
<table>
<tr>
<th>작성자</th><td><input name="writer" value="${dto.writer}"></td>
</tr>
<tr>
<th>메모</th><td><input name="memo" value="${dto.memo}"></td>
</tr>
<tr>
<th>날짜 </th>
<td><input name="post_date" value="${dto.post_date}" size=50 disabled/></td>
</tr>
</table>
<input type="button" value="수정" id="btnUpdate">
<input type="button" value="삭제" id="btnDelete">
<input type="button" value="목록" id="btnList" onClick="location.href='${path}/memo.do'">
</form>

</body>
</html>