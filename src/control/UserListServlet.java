package control;

import biz.ejb.stateful.UserListBean;
import biz.ejb.stateless.UserBean.UserBean;
import entity.User;

import javax.ejb.EJB;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "UserListServlet")
public class UserListServlet extends HttpServlet {
    @EJB
    private UserBean userBean;
    private static final String USER_LIST_SESSION_KEY = "UserList";
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
        }else {
            //System.out.println("121dsdd");
        }
        String userName = request.getParameter("name");
        if (userName != null && userName.length() > 0) {
            User u = userBean.getUserByName(userName);
            userListBean.addUser(u);
        }
        response.sendRedirect("/JSPTrain/UserList.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
