<%--
  Created by IntelliJ IDEA.
  User: 24686
  Date: 2023/4/15
  Time: 下午 9:36
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>TimeMessage</title>
</head>
<body>
    <div style="padding: 1px">
        <div style="margin: 0 auto;">
            <form style="margin: 0 auto; width: 70%" action="/JSPTrain/QueryMessageServlet" method="post" name="form">
                <table style="margin: 0 auto;">
                    <tr>
                        <td>起始时间：</td>
                        <td><input type="datetime-local" step="1" name="stTime"/></td>

                    </tr>
                    <tr>
                        <td>结束时间：</td>
                        <td><input type="datetime-local" step="1" name="edTime" /></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td >
                            <input type="submit" id="query" value="查询"/>
                        </td>
                    </tr>
                </table>
            </form>
        </div>
        <div style="margin: 0 auto; padding: 1px;text-align: center">
            <table style="margin: 0 auto" class="gridtable">
                <tr>
                    <th>信息</th>
                    <th>发送时间</th>
                    <th>接收时间</th>
                </tr>
                <c:forEach items="${ResultSet}" var="msg">
                    <tr>
                        <td>${msg.content}</td>
                        <td>${msg.sendTime}</td>
                        <td>${msg.recvTime}</td>
                    </tr>
                </c:forEach>
            </table>
            <a style="" href="/JSPTrain/login.jsp" >返回</a>
        </div>
    </div>
</body>
<style type="text/css">
    table.gridtable {
        font-family: verdana,arial,sans-serif;
        font-size:11px;
        color:#333333;
        border-width: 1px;
        border-color: #666666;
        border-collapse: collapse;
    }
    table.gridtable th {
        border-width: 1px;
        padding: 8px;
        border-style: solid;
        border-color: #666666;
        background-color: #dedede;
    }
    table.gridtable td {
        border-width: 1px;
        padding: 8px;
        border-style: solid;
        border-color: #666666;
        background-color: #ffffff;
    }
</style>

</html>
