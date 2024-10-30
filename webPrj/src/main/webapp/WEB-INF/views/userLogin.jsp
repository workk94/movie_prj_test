<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/userStyle.css">

</head>
<body>

<main>
<h2> 여기는 로그인 페이지 입니다. </h2>

<div class="container">

<!-- 로그인 로고 출력 -->
<div> <img class="logo" src="https://cdn-icons-png.flaticon.com/512/5989/5989327.png"> </div>

<!-- 회원가입 필드 -->
<div class="field">
	<label> 아이디 </label>
	<input type="text">
</div>

<div class="field">
	<label> 비밀번호 </label>
	<input type="password">
</div>

	<input type="submit" value="로그인" class="green">

</div>

<h3> 회원 전체 조회</h3> 
<a href="userList">
<button> 전체 조회 </button> 
</a>

<h3> 회원 가입</h3> 
<a href="createAccount">
<button> 회원가입 </button> 
</a>
</main>

</body>
</html>