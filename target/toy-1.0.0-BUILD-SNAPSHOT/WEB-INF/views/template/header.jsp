<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>zumsim</title>
	<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
	<link rel="stylesheet" href="<c:url value="/css/main/main.css"/>" />
</head>
<body>
	<div class="container">
		<div class="side_menu_bar">
			<a href="<c:url value="/"/>"><img src="${pageContext.request.contextPath}/resources/images/davichi.jpeg" alt="홈으로" class="main_logo"></a>
			
			<div class="side_bar_list">
				<span class="glyphicon glyphicon-log-in">
					<a class="btn" href="<c:url value="/accounts/login.do"/>">로그인</a>
				</span>
				<span class="glyphicon glyphicon-user">
					<a class="btn" href="<c:url value="/accounts/sign.do"/>">회원가입</a>
				</span>
			</div>
		</div>
		<div class="wrap">
		
	
