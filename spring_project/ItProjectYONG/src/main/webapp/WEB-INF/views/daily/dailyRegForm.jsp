<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="../daily/dailyReg" method="post">
		${date}
		${pidx}
		<input type="text" name="dloc">
		<input type="text" name="date" value="${date}">
		<input type="text" name="pidx" value="${pidx}">
		<input type="text" name="dloclon">
		<input type="text" name="dloclat">
		<input type="text" name="dmsg">
		<input type="submit" value="완료">
</form>
</body>
</html>