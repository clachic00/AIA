<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:url value="/index.do"/>
<script>
	alert("등록되었습니다.")
	location.href='<c:url value="/index.do"/>';
</script>