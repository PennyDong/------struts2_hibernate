<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
	import="java.util.List,
	dao.voteDao,
	dao.impl.memberDaoImpl,
	entity.member"
 %>
 <%
 List<member> vote = new memberDaoImpl().queryAll();
 %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TestVote</title>
</head>
<body>
	<table align="center" border=1>
	<tr>
		<td >候選人<td/>
		<td>票數</td>
		<td>投票</td>
	</tr>
	<% for(member m:vote){%>
	<tr>
		<td><%=m.getName()%></td>
		<td><%=m.getQuantity()%></td>
		<td><a href="memberAction?i=<%=+m.getId()%>">投票</a></td>
	</tr>
	<% }%>
	</table>
</body>
</html>