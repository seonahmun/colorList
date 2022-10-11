<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Color Log</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resource/color.css">
<script src="https://code.jquery.com/jquery-3.4.1.js"></script>
</head>
<body>
	<header class="page-header">
		<a href="/" ><h3>&#128204; 색상선택</h3></a>
		<a href="/history"><h3>&#128203; 히스토리</h3></a>
	</header>

	<div class="color-select">
		<ul>
		${colorList}
		</ul>
	</div>


</body>
</html>