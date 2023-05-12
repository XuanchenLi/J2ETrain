<%--
  Created by IntelliJ IDEA.
  User: 24686
  Date: 2023/3/29
  Time: 下午 3:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<html>
<head>
    <title>用户列表</title>
</head>
<body>
    <jsp:include page="/SearchUserListServlet" flush="true"></jsp:include>
    <br>
    <form action="/JSPTrain/UserListServlet" method="post" name="form" >
        <table>
            <tr>
                <td>用户名：</td>
                <td><input type="text" id="username" name="name" /></td>
                <td id="test_user"></td>
            </tr>
            <tr>
                <td></td>
                <td ><input type="submit" id="add" value="添加至列表"/>
                </td>
            </tr>
        </table>
    </form>
    <a href="/JSPTrain/ShowSelectedUserServlet">展示选中的用户</a>
</body>
</html>
