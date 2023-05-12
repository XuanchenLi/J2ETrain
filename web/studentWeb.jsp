<%@ page import="org.json.JSONObject" %>
<%@ page import="org.json.JSONException" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="org.json.JSONArray" %>
<%@ page import="entity.jpa.one2many1.Student_o2m1" %>
<%@ page import="entity.jpa.one2many1.Teacher_o2m1" %>
<%--
  Created by IntelliJ IDEA.
  User: 24686
  Date: 2023/5/8
  Time: 下午 4:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>StudentWeb</title>
    <style>
        table{
            border: 1px solid;
            margin: auto;
            width: 500px;
        }

        td,th{
            text-align: center;
            border: 1px solid;
        }
        div{
            text-align: center;
            margin: 50px;
        }
    </style>
</head>
<body>
<div style="width: 100%;overflow: auto">
    <div style="width: 50%;float: left;margin: 0">
        <table id="stb">
            <caption>学生列表</caption>
            <tr>
                <th>姓名</th>
                <th>性别</th>
                <th>专业</th>
                <th>操作</th>
            </tr>
        </table>

        <div>
            <input type="text" id="sname" placeholder="请输入姓名">
            <input type="text" id="sgender"  placeholder="请输入性别">
            <input type="text" id="smajor"  placeholder="请输入专业">
            <input type="button" value="添加" id="s_add">

        </div>
    </div>
    <div style="width: 50%;float: left;margin: 0">
        <table id="ttb">
            <caption>教师</caption>
            <tr>
                <th>姓名</th>
                <th>性别</th>
                <th>年龄</th>
            </tr>
            <tr>
                <td>
                    <input type="text" id="tname" placeholder="请输入姓名">
                </td>
                <td>
                    <input type="text" id="tgender"  placeholder="请输入性别">
                </td>
                <td>
                    <input type="text" id="tage"  placeholder="请输入年龄">
                </td>
            </tr>
        </table>
    </div>
</div>
<div style="width: 100%">
    <table id="opts" style="margin: 10px;width: 90%">
        <tr>
            <td>
                <p>
                    <input type="text" id="qid" placeholder="教师ID">
                    <input type="button" id="q_btn" value="查询:">
                </p>
            </td>
            <td>
                <div style="margin: 0">
                    <p>
                        <input type="text" id="did" placeholder="教师ID">
                        <input type="button" id="del_btn" value="删除">
                    </p>
                </div>
            </td>
            <td>
                <div style="margin: 0">
                    <p>
                        <input type="text" id="uid" placeholder="教师ID">
                        <input type="text" id="uname" placeholder="请输入姓名">
                        <input type="text" id="ugender"  placeholder="请输入性别">
                        <input type="text" id="uage"  placeholder="请输入年龄">
                        <input type="button" id="up_btn" value="更新">
                    </p>
                </div>
            </td>
            <td>
                <input type="button" id="load_btn" value="添加">
            </td>
        </tr>
    </table>
</div>
<%
    String res = (String) request.getAttribute("query_res");
    Teacher_o2m1 tea = new Teacher_o2m1();
    ArrayList<Student_o2m1> ss = new ArrayList();;
    if (res != null) {
        try {
            JSONObject obj = new JSONObject(res);
            tea.setId(obj.getInt("id"));
            tea.setTeacherName(obj.getString("teacherName"));
            tea.setGender(obj.getString("gender"));
            tea.setAge(obj.getInt("age"));
            JSONArray tJson = obj.getJSONArray("students");
            for (int i = 0; i < tJson.length(); ++i) {
                JSONObject tobj = tJson.getJSONObject(i);
                Student_o2m1 s = new Student_o2m1();
                s.setId(tobj.getInt("id"));
                s.setName(tobj.getString("name"));
                s.setMajor(tobj.getString("major"));
                s.setGender(tobj.getString("gender"));
                ss.add(s);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
%>
<table style="margin-bottom: 10px">
    <caption>查询结果</caption>
    <tr>
        <th>ID</th>
        <th>姓名</th>
        <th>性别</th>
        <th>年龄</th>
    </tr>
    <tr>
        <td>
            <%=tea.getId()%>
        </td>
        <td>
            <%=tea.getTeacherName()%>
        </td>
        <td>
            <%=tea.getGender()%>
        </td>
        <td>
            <%=tea.getAge()%>
        </td>
    </tr>

</table>
<table>
    <tr>
        <th>ID</th>
        <th>姓名</th>
        <th>性别</th>
        <th>专业</th>
    </tr>
    <%for (Student_o2m1 s : ss) {
    %>
    <tr >
        <td>
            <%=s.getId()%>
        </td>
        <td>
            <%=s.getName()%>
        </td>
        <td>
            <%=s.getGender()%>
        </td>
        <td>
            <%=s.getMajor()%>
        </td>
            <%
            } %>


</table>

</body>
<script>
    document.getElementById("s_add").onclick = function () {
        //2.获取文本框的内容
        var major = document.getElementById("smajor").value;
        var name = document.getElementById("sname").value;
        var gender = document.getElementById("sgender").value;

        //3.创建td，赋值td的标签体
        var td_major = document.createElement("td");
        var text_major = document.createTextNode(major);
        td_major.appendChild(text_major);

        //name的td
        var td_name = document.createElement("td");
        var text_name = document.createTextNode(name);
        td_name.appendChild(text_name);

        //gender的td
        var td_gender = document.createElement("td");
        var text_gender = document.createTextNode(gender);
        td_gender.appendChild(text_gender);

        //a标签的td
        var td_a = document.createElement("td");
        var ele_a = document.createElement("a");
        ele_a.setAttribute("href","javascript:void(0);");
        ele_a.setAttribute("onclick","deltr(this);");
        var text_a = document.createTextNode("删除");
        ele_a.appendChild(text_a);
        td_a.appendChild(ele_a);

        //4.创建tr
        var tr = document.createElement("tr");
        //5.添加td到tr中
        tr.appendChild(td_name);
        tr.appendChild(td_gender);
        tr.appendChild(td_major);
        tr.appendChild(td_a);
        //6.获取table
        var table = document.getElementById("stb");
        //7.添加tr到table
        table.appendChild(tr);
    }
    function deltr(obj) {//obj是形参，接收this的，this代表是a标签
        var table = obj.parentNode.parentNode.parentNode;
        var tr = obj.parentNode.parentNode;
        table.removeChild(tr);
    }
    document.getElementById("load_btn").onclick = function () {
        var st = document.getElementById("stb");
        var sarr = [];
        for (var i = 1; i < st.rows.length; ++i) {
            var s = {};
            s.name = st.rows[i].cells[0].firstChild.nodeValue;
            s.gender = st.rows[i].cells[1].firstChild.nodeValue;
            s.major = st.rows[i].cells[2].firstChild.nodeValue;
            sarr.push(s);
        }
        var t = {}
        t.name = document.getElementById("tname").value;
        t.gender = document.getElementById("tgender").value;
        t.age = document.getElementById("tage").value;
        var params = {
            "method": "add",
            "students": JSON.stringify(sarr),
            "teacher": JSON.stringify(t)
        }
        httpPost("/JSPTrain/StudentWebServlet", params);
    }
    document.getElementById("up_btn").onclick = function () {
        var s = {};
        s.id = document.getElementById("uid").value;
        s.name = document.getElementById("uname").value;
        s.age = document.getElementById("uage").value;
        s.gender = document.getElementById("ugender").value;
        var params = {
            "method": "update",
            "teacher": JSON.stringify(s),
        }
        httpPost("/JSPTrain/StudentWebServlet", params);
    }
    document.getElementById("q_btn").onclick = function () {
        var params = {
            "method": "query",
            "id": document.getElementById("qid").value
        }
        httpPost("/JSPTrain/StudentWebServlet", params);
    }
    document.getElementById("del_btn").onclick = function () {
        var params = {
            "method": "remove",
            "id": document.getElementById("did").value
        }
        httpPost("/JSPTrain/StudentWebServlet", params);
    }
    function httpPost(URL, PARAMS) {
        var temp = document.createElement("form");
        temp.action = URL;
        temp.method = "post";
        temp.style.display = "none";

        for (var x in PARAMS) {
            var opt = document.createElement("textarea");
            opt.name = x;
            opt.value = PARAMS[x];
            temp.appendChild(opt);
        }
        document.body.appendChild(temp);
        temp.submit();

        return temp;
    }

</script>
</html>
