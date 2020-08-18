<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>
<a href="calendar/calendar">planner</a>
<a href="kakaomap://route?sp=37.51119865054613,127.02165424220854&ep=37.5705756133826,126.98531278713301&by=PUBLICTRANSIT">kakao</a>
</body>
</html>
