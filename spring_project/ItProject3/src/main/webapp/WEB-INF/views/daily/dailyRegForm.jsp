<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/sessionCheck.jsp" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<form action="dailyReg" method="post" enctype="multipart/form-data">

		dloc		<input type="text" name="dloc">	<br>
		dloclon		<input type="text" name="dloclon"><br>
		dloclat		<input type="text" name="dloclat"><br>
		dmsg		<input type="text" name="dmsg"><br>
		dphoto		<input type="file" name="dphoto"><br>
		dtype		<select name="dtype">
					<option value="1">빨강</option>
					<option value="2">파랑</option>
					<option value="3">초록</option>
					<option value="4">분홍</option>
					<option value="5">하양</option>
				
					</select>
					<br>
		pidx		<input type="text" name="pidx"><br>
		ddate(날짜)	<input type="text" name="ddate"><br>
		ddidx(날짜순서)<input type="text" name="ddidx"><br>
		
		
			<input type="submit" value="제출">
		
</form>

</body>
</html>