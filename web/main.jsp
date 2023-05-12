<%--
  Created by IntelliJ IDEA.
  User: 24686
  Date: 2023/3/8
  Time: 下午 2:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Welcome</title>
</head>
<body>
用户名：<%=(String) request.getAttribute("username")%>
<br>
用户身份：<%=(String) request.getAttribute("type")%>
<br>
<a href="login.jsp">退出</a>
</body>
</html>
