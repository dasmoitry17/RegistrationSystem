<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>All Courses</title>
<style>
table, td, th {
	border: 1px solid black;
}

table {
	border-collapse: collapse;
	width: 100%;
}

th {
	height: 50px;
}

button {
	background-color: #008CBA;
	border: none;
	color: white;
	padding: 15px 32px;
	text-align: center;
	text-decoration: none;
	display: inline-block;
	font-size: 16px;
	border-radius: 12px;
}
</style>

</head>
<body>
                                                                                   <a href="logout">Logout</a>
<div style="margin-top: 40px; margin-right: 150px; margin-left: 150px;">
			<table>
				<thead>
					<tr style="background-color: #E0E0E1;">
						<th>FIRSTNAME</th>
						<th>LASTNAME</th>
						<th>GENDER</th>
						<th>Department</th>
						<th>Action</th>
						
					</tr>
				</thead>
			<form action="users/StdEnlist">	
				<s:iterator value="stdlist">
					<tr>
						<td><s:property value="%{firstName}" /></td>
						<td><s:property value="%{lastName}" /></td>
						<td><s:property value="%{gender}" /></td>
						<td><s:property value="%{department}" /></td>
						<td><input type="submit" name="add[<s:property value="%{id}"/>]" value="add"/></td>
						
					</tr>
				</s:iterator>
			</form>	
			</table>
		</div>

</body>
</html>