<%--
  Created by IntelliJ IDEA.
  User: 24686
  Date: 2023/3/8
  Time: 下午 2:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Login</title>
  </head>
  <h3>用户登录</h3>
  <form action="/JSPTrain/LoginServlet" method="post" name="form" >
    <table>
      <tr>
        <td>用户名：</td>
        <td><input type="text" id="username" name="username" /></td>
        <td id="test_user"></td>
      </tr>
      <tr>
        <td>密码：</td>
        <td><input type="password" id="password" name="password" /></td>
        <td id="test_pw"></td>
      </tr>
      <tr>
        <td></td>
        <td ><input type="submit" id="login" value="登录"/>
        </td>
      </tr>
    </table>
  </form>
  <br>
  <a href="UserList.jsp" >查询用户列表</a>
  <a href="studentEJB.jsp" >JPA-EJB CURD</a>
  <a href="studentWeb.jsp" >JPA-Web CURD</a>
  </body>
</html>
