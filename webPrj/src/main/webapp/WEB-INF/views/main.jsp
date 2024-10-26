<%@ page contentType="text/html; charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>영화</title>
<script src="https://kit.fontawesome.com/d471660ae5.js"
	crossorigin="anonymous"></script>

<style>
* {
	margin: 0;
	padding: 0;
	box-sizing: border-box;
}

a {
	text-decoration: none;
}

header {
	height: 50px;
	padding: 2px;
	display: flex;
	justify-content: space-between;
	flex-wrap: wrap;
	background-color: #000000;
	color: white;
	align-items: center;
}

.logo {
	margin-left: 5px;
	padding: 2px;
}

.user-menu {
	margin-right: 5px;
	padding: 2px;
}

.user-menu a {
	color: white;
}

.m-user-menu {
	display: none;
}

.search-wrap {
	margin: 2px auto;
	display: flex;
	justify-content: center;
	align-items: center;
}

.search-wrap form {
	display: flex;
	justify-content: center;
	align-items: center;
}

.search-wrap input {
	padding: 4px;
	margin: 2px;
}

.items {
	box-sizing: border-box;
	display: flex;
	justify-content: center;
	align-items: center;
	flex-wrap: wrap;
	border: 1px solid black;
	padding: 10px;
}

.item {
	flex: 1;
	padding: 5px;
	border: 1px solid black;
	margin: 5px;
}

.item img {
	width: 100%;
	object-fit: contain;
}

.title {
	display: none;
	padding: 10px;
	margin: 10px;
}

.rank-label {
	border-radius: 3px;
	font-size: 15px;
	color: yellow;
	margin-left: 5px;
	padding: 2px;
	background-color: red;
}

.plot {
	padding: 10px;
	display: none;
}

.rating {
	display: none;
	padding: 10px;
}

.rating span {
	font-weight: bold;
}

main {
	height: calc(100vh - ( 50px +30px));
	background-color: white;
	display: flex;
	flex-direction: column;
}

.category {
	border: 1px solid black;
	margin: 10px;
}

.category ul {
	list-style: none;
	display: flex;
}

.category li {
	border-radius: 3px;
	background-color: #d94844;
	padding: 5px;
	margin: 3px;
}

.category li>a {
	color: white;
}

footer {
	height: 30px;
	background-color: black;
	color: white;
	text-align: center;
	line-height: 30px;
}

@media ( max-width : 768px) {
	header {
		height: fit-content;
	}
	.items {
		flex-direction: column;
		width: 100%;
	}
	.item {
		width: 100%;
	}
	.title {
		display: block;
	}
	.plot {
		display: block;
	}
	.rating {
		display: block;
	}
	.fa-star {
		color: yellow;
	}
	.search-wrap {
		width: 100%;
		order: 3;
	}
	.search-wrap form {
		width: 100%;
	}
	.search-wrap input {
		width: 100%;
	}
}
</style>
</head>
<body>
	<header>
		<div class="logo">로고</div>
		<div class="search-wrap">
			<form action="#">
				<input type="text" placeholder="검색" />
			</form>
		</div>
		<div class="user-menu">
			<a href="#">로그인</a> <a href="#">회원가입</a>
		</div>
	</header>

	<main>
		<div class="category">
			<ul>
				<li><a href="#">액션</a></li>
				<li><a href="#">공포</a></li>
				<li><a href="#">스릴러</a></li>
			</ul>
		</div>

		<h2>오늘의 박스오피스</h2>
		<div class="items">
			<c:forEach var="entry" items="${boxOffice}">
				<div class="item">
					<img src="${entry.value.img_url}" alt="${entry.value.title}" />
					<h3 class="title">
						${entry.value.title}
						<c:if test="${entry.key == 1}">
							<span class="rank-label">1위</span>
						</c:if>
					</h3>
					<div class="plot">${entry.value.plot}</div>
					<div class="rating">
						<span>등급: ${entry.value.rating}</span> <i class="fa-solid fa-star"></i>
					</div>
				</div>
			</c:forEach>

		</div>
	</main>

	<footer>푸터</footer>
</body>
</html>
