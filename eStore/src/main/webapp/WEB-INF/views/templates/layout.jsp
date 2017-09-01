<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="../../../../favicon.ico">

<title><tiles:insertAttribute name="title"/></title>

<!-- Bootstrap core CSS -->
<link href="<c:url value="/resources/css/bootstrap.min.css"/>" rel="stylesheet">
<link href="<c:url value="/resources/css/main.css"/>" rel="stylesheet">


<!-- Custom styles for this template -->
<link href="<c:url value="/resources/css/carousel.css"/>" rel="stylesheet">


	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
	integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
	crossorigin="anonymous"></script>
<script src="<c:url value="/resources/js/bootstrap.min.js"/>"></script>

</head>
<body>
	<div>
		<tiles:insertAttribute name="header"/>
	</div>
	<div>
		<tiles:insertAttribute name="body"/>
	</div>
	<div>
		<tiles:insertAttribute name="footer"/>
	</div>


</body>
</html>
