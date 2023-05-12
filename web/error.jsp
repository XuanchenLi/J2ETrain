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
    <title>错误</title>
</head>
<body>
错误信息：<%=(String)request.getAttribute( "error")%>
<br>
<a href="login.jsp">返回</a>
</body>
</html>
