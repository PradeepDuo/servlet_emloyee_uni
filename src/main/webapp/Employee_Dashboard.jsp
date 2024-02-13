<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" %>
    <%@  page import="com.dto.*,java.util.List"  %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h2>Tasks Assigned</h2>

<table style="border: 1px solid black;border-collapse: collapse">

	<tr >
		<th style="border: 1px solid black;border-collapse: collapse">Id</th>
		<th style="border: 1px solid black;border-collapse: collapse">Description</th>
		<th style="border: 1px solid black;border-collapse: collapse">Creation Time</th>
		<th style="border: 1px solid black;border-collapse: collapse">Completion Time</th>
		<th style="border: 1px solid black;border-collapse: collapse">Status</th>
	</tr style="border: 1px solid black;border-collapse: collapse">

	<%
	/* Register_Employee register=(Register_Employee)session.getAttribute("login");
	List<Task> tasks=register.getTasks(); */
	/* Task task=null; */
	/* for (Task task1 : tasks) { 
		System.out.println(task1); */
	%>
	<c:forEach var="task1" items="${tasks }">
	<tr style="border: 1px solid black;border-collapse: collapse"> 
	<td style="border: 1px solid black;border-collapse: collapse">${task1.getId()}</td>
	<td style="border: 1px solid black;border-collapse: collapse">${task1.getDescription() }</td> 
	<td style="border: 1px solid black;border-collapse: collapse">${task1.getCreationTime() }</td>
	<td style="border: 1px solid black;border-collapse: collapse">${task1.getCompleteTime() }</td>
	<td style="border: 1px solid black;border-collapse: collapse">${task1.getStatus()}</td>
	
	</tr>
	</c:forEach>
</table>
	<form action="update" method="post">
	<h2>Enter the ID you want to update: </h2>
	<input type="text" name="id" > <br>
	<input type="submit" value="update">
	</form>
	
	

</body>
</html>