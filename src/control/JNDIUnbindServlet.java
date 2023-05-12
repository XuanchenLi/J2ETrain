package control;

import biz.JNDIBiz;

import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;

@WebServlet(name = "JNDIUnbindServlet")
public class JNDIUnbindServlet extends HttpServlet {
    private JNDIBiz jndiBiz = new JNDIBiz();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        Writer out = response.getWriter();
        String name = request.getParameter("bindName");
        //Object val = (Object)request.getParameter("bindVal");
        out.write("操作结果：");
        try {
            jndiBiz.unBind(name);
            out.write("解除绑定成功！");
        } catch (NamingException e) {
            out.write("解除绑定失败！");
        }finally {
            out.write("<br><a href='JNDIOPInterface.jsp'>返回</a>");
            out.close();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
