package control;

import biz.ejb.stateful.UserListBean;
import entity.User;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;
import java.util.List;
import java.util.regex.Pattern;

@WebServlet(name = "ShowSelectedUserServlet")
public class ShowSelectedUserServlet extends HttpServlet {
    private static final String USER_LIST_SESSION_KEY = "UserList";
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserListBean userListBean = (UserListBean) request.getSession().getAttribute(USER_LIST_SESSION_KEY);
        if (userListBean == null) {
            try {
                InitialContext ctx = new InitialContext();
                final String appName = "";
                final String moduleName = "JSPTrain";
                final String distinctName = "";

                userListBean = (UserListBean) ctx.lookup(
                        "ejb:" + appName + "/" + moduleName + "/" + distinctName
                                +  "/UserListBeanImpl!biz.ejb.stateful.UserListBean?stateful"
                );
                request.getSession().setAttribute(USER_LIST_SESSION_KEY, userListBean);
            }catch (NamingException e) {
                e.printStackTrace();
            }
        }
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        Writer out = response.getWriter();
        List<User> users = userListBean.getUserList();
        if (users.isEmpty()) {
            out.write("<h2>列表为空</h2>");
        }else {
            out.write("<table border=\"1\" style=\"margin:0 auto\">");
            for (User user : users) {
                out.write("<tr> <td>" + user.getUsername() + "</td> <td>" + (user.getType() == 0 ? "普通用户" : "管理员") + "</td> </tr>");
            }
            out.write("</table>");
        }
        out.flush();
        //out.close();
    }
}
