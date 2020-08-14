<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="http://code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
    <script src="http://code.jquery.com/jquery-1.10.2.js"></script>
    <script src="http://code.jquery.com/ui/1.11.4/jquery-ui.js"></script>

<script>




window.onload=function(){
	
  
	var sdd='${startdate}';
	var edd='${enddate}';
	
console.log(sdd);
console.log(edd);

var ar1 = sdd.split('-');
var ar2 = edd.split('-');

console.log(ar1);
console.log(ar2);


var curr = new Date(ar1[0], ar1[1], ar1[2]);
var end = new Date(ar2[0], ar2[1], ar2[2]);

console.log(curr);
console.log(end);



var betweenDay = (end.getTime() - curr.getTime()) / 1000 / 60 / 60 / 24;

console.log(curr.getTime());
console.log(end.getTime());

console.log(betweenDay);

console.log(curr.getFullYear()+','+curr.getMonth()+','+curr.getDate());
while (betweenDay > 0) {
betweenDay--;


curr.setDate(curr.getDate() + 1);
console.log(curr.getFullYear()+','+curr.getMonth()+','+curr.getDate());



}	


}





</script>



</head>
<body>

		${result }
		${startdate }
		${enddate }



</body>
</html>