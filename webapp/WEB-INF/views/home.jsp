<%-- <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%> --%>
 
<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
	

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<%@ include file="/WEB-INF/views/includeheader.jsp" %>
<script src="${pageContext.request.contextPath}/resources/js/home.js"></script>
</head>
<body data-link="${pageContext.request.contextPath}">
	<h1>
		<%-- home page.	${pageContext.request.contextPath}/resources/scripts/common.js" --%>
	</h1>
	<table border="1">
		<c:forEach items="${allStudent}" var="student">
			<tr>
				<td>${student.stuid }</td>
				<td>${student.stuname }</td>
				<td>${student.lvlyear }</td>
				<td>${student.score }</td>
			</tr>
		</c:forEach>
	</table>
	<div>stuID: <input type="text" value="" name="stuid" id="stuId"></div><br>
<form id="frmStudent" action="" method="post">
	<div>stuname: <input type="text" name="stuname" id="stuname"></div>
	<div>lvlyear: <input type="text" name="lvlyear" id="lvlyear"></div>
	<div>score: <input type="text" name="score" id="score"></div>
</form>
<button type="button" id="btnAdd">Add</button>
<button type="button" id="btnUpdate">Update</button>
<button type="button" id="btnSearch">Search</button>
<button type="button" id="btnDelete">delete</button>
</body>
</html>