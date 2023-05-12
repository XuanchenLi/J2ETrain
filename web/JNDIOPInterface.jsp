<%--
  Created by IntelliJ IDEA.
  User: 24686
  Date: 2023/3/15
  Time: 下午 2:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>JNDI</title>
</head>
<body>
<form action="" method="get">
    绑定名字：<input type="text" id="bindName" name="bindName">
    绑定值：<input type="text" id="bindVal" name="bindVal">
    <br>
    <br>
    <input type="submit" formaction="JNDIBindServlet" value="绑定" />
    <input type="submit" formaction="JNDISearchServlet" value="查询" />
    <input type="submit" formaction="JNDIRebindServlet" value="重新绑定" />
    <input type="submit" formaction="JNDIUnbindServlet" value="取消绑定" />
</form>
</body>
</html>
