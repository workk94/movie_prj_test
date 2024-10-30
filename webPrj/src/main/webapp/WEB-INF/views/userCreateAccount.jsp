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
<h2> 여기는 회원가입 페이지 입니다. </h2>

<div class="container">

	<!-- 회원가입 로고 출력 -->
	<div> <img class="logo" src="https://cdn-icons-png.flaticon.com/128/5087/5087579.png"> </div>

	<!-- 회원가입 필드 -->
	<div class="field">
		<label> 아이디 </label>
		<input type="text">
	</div>

	<div class="field">
		<label> 비밀번호 </label>
		<input type="password">
	</div>

	<div class="field">
		<label> 비밀번호 재확인 </label>
		<input type="password">
	</div>

	<div class="field">
		<label> 이름 </label>
		<input type="text">
	</div>

	<div class="field">
		<label>	생년월일 </label>
			<div class="birth">
				<input type="number" placeholder="2001년" class="birthY">
					<select class="birthM">
				    	<option value="">월</option>
						<option value="">1월</option>
						<option value="">2월</option>
						<option value="">3월</option>
						<option value="">4월</option>
						<option value="">5월</option>
						<option value="">6월</option>
						<option value="">7월</option>
						<option value="">8월</option>
						<option value="">9월</option>
						<option value="">10월</option>
						<option value="">11월</option>
						<option value="">12월</option>
					</select>
     			<input type="number" placeholder="일" class="birthD">
		     </div>
	</div>

	<!-- 4. 필드(성별) -->
	<div class="field gender">
		<label> 성인 / 미성년 </label>
    		<div>
    		<label><input type="radio" name="gender" class="genderS">성인</label>
        	<label><input type="radio" name="gender" class="genderS">미성년자</label>
       		<label><input type="radio" name="gender" class="genderS">선택안함</label>
     		</div>
	</div>
	<!-- 5.취향조사 -->
		<div class="row">
			<div class="field">
				<label> 가장 좋아하는 영화 <em>*</em></label>
				<textarea rows="2" required placeholder="가장 좋아하는 영화를 입력해주세요."></textarea>
				<label> 이유 </label>
				<textarea rows="5" placeholder="그 이유를 입력해주세요."></textarea>
			</div>
		</div>
		<div class="row">
			<div class="field">
				<label> 가장 별로였던 영화 <em>*</em></label>
				<textarea rows="2" required placeholder="가장 아쉬웠던 영화를 입력해주세요."></textarea>
				<label> 이유 </label>
				<textarea rows="5" placeholder="그 이유를 입력해주세요."></textarea>
			</div>
		</div>

			<!-- 6. 가입하기 버튼 -->
	<input type="submit" value="가입하기" class="green">
</div>

<h3> 회원 전체 조회</h3> 
<a href="userList">
<button> 전체 조회 </button> 
</a>

</main>

</body>
</html>