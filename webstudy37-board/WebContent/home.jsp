<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">
<title>게시판 홈페이지</title>
<!-- Bootstrap core CSS -->
<link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<!-- Custom styles for this template -->
<link href="css/mystyle.css?ver=1" rel="stylesheet">
<script type="text/javascript" src="javascript/myjs.js?ver=2"></script>
</head>

<body>
	<!--  header  -->
	<div class="header_container">
		<jsp:include page="layout/header.jsp" />
	</div>
	<!--  body -->
	<div class="container">
		<div class="row">
			<jsp:include page="layout/body/${url}" />
			<jsp:include page="layout/body/right.jsp" />
		</div>
	</div>
	<!-- footer -->
	<footer class="py-5 bg-dark">
		<jsp:include page="layout/footer/footer.jsp" />
	</footer>

	<script src="vendor/jquery/jquery.min.js"></script>
	<script src="vendor/popper/popper.min.js"></script>
	<script src="vendor/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>
