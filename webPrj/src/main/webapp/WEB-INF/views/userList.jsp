<%@page import="model.User"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>User List</h2>
<table border="1">
    <tr>
        <th> ID </th>
        <th> 성함 </th>
        <th> 생년월일 </th>
        <th>Adult/Child</th>
        <th>Best Movie</th>
        <th>Worst Movie</th>
        <th>비밀번호</th>
    </tr>
    <%
        ArrayList<User> users = (ArrayList<User>) request.getAttribute("userList");
        for (User user : users) {
    %>
    <tr>
        <td><%= user.getUser_id() %></td>
        <td><%= user.getName() %></td>
        <td><%= user.getBirth() %></td>
        <td><%= user.getAdult_child() %></td>
        <td><%= user.getBest_movie() %></td>
        <td><%= user.getWorst_movie() %></td>
        <td><%= user.getPw() %> </td>>
    </tr>
    <%
        }
    %>
</table>
</body>
</html>