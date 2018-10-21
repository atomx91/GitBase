<%@page language="java"%>
<%@page errorPage="/404.jsp"%>
<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/fmt' prefix='fmt'%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="${pageContext.request.contextPath}/login" method="post" style="text-align:center">
		<div style="margin-top:30px">
			<span>UserName</span> <input type="text" name="username" style="font-size:20px;margin-left:20px; width: 300px; height:20px" />
		</div>
		
		<div style="margin-top:15px">
			<span>Password</span> <input type="password" name="password" style="font-size:20px; margin-left:25px;width: 300px; height:20px"/>
		</div>
		<p name="alert" style="color:red"><c:out value ="${errorMsg}"/> </p>
		<input type="submit" value="Submit" style="width:100px; height:40px">
	</form>

</body>
</html>