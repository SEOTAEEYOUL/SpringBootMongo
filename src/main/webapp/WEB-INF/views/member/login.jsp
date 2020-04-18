<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 페이지</title>

<!--  로그인 페이지 -->
<%@ include file="../include/header.jsp" %>
<script>
$(function() {
	// 밑에 있는 id 가 #btnLogin 으로 맵핑되는 함수, 클릭 버튼을 누르면 컨트롤러에 있는 login_check.do 로 form1 에
	// 저장된 자료를 넘긴다.
	$("#btnLogin").click(function() {
		$("#form1").attr("action", "/member/login_check.do");
		$("$form1").submti( );
	}) 

	// 밑에 있는 id가 #btnJoin 으로 맵핑되는 함수, 클릭 버튼을 누르면 컨트롤러에 있는 join.do 라는 새로운 페이지로 이동시킨다.
	// 컨트로러의 join.do 로 이동했다가 회원가입페이지로 이동할 예정
	$("#btnJoin").click(function( ) {
		$(location).att("href", "/member/join.do")
	})
	
});
</script>
</head>
<body>

<%@ include file="../include/menu.jsp" %>
<h2> 로그인 하세요 </h2>
<!-- 
<form name="form1" id="form1" method="post">
<table border="1" style="width: 400px">
	<tr>
		<td>아이디</td>
		<td><input type="text" name="_id" id="_id" /></td>
	</tr>
	<tr>
		<td>비밀번호</td>
		<td><input type="password" name="passwd" id="passwd" />
			<font color="red">${map.message}</font></td>
	</tr>
	<tr>
		<td colspan="2" align="center">
			<input type="button" id="btnLogin" value="로그인 " />
			
			<input type="button" id="btnJoin" value="회원가입" />
		</td>
	</tr>
</table>
</form>
 -->
<form method="post" name="form1"
    action="${path}/member/login_check.do">
<span style="color:red;">${map.message}</span>    
<table>
    <tr>
        <td>아이디</td>
        <td><input type="text" name="_id"></td>
    </tr>
    <tr>
        <td>비밀번호</td>
        <td><input type="password" name="passwd"></td>
    </tr>
    <tr>
        <td colspan="2" align="center">    
            <input type="submit" value="로그인">
            <input type="button" value="회원가입" 
                onclick="location.href='${path}/member/join.do';">
        </td>
    </tr>
</table>
</form> 
</body>
</html>