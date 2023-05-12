package control;

import biz.ejb.stateless.UserBean.UserBean;
import entity.User;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;
import java.util.List;

@WebServlet(name = "SearchUserListServlet")
public class SearchUserListServlet extends HttpServlet {
    @EJB
    private UserBean userBean;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        Writer out = response.getWriter();
        List<User> users = userBean.getAllUsers();
        out.write("<table border=\"1\" style=\"margin:0 auto\">");
        for(User user : users) {
            out.write("<tr> <td>" + user.getUsername() + "</td> <td>" + (user.getType() == 0 ? "普通用户" : "管理员") + "</td> </tr>");
        }
        out.write("</table>");
        out.flush();
        //out.close();
    }
}
