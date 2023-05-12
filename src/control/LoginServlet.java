package control;

import biz.UserBiz;
import entity.User;

import java.io.IOException;

public class LoginServlet extends javax.servlet.http.HttpServlet {
    private UserBiz userBiz = new UserBiz();
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User user = userBiz.loginService(username, password);
        if (user != null) {
            request.setAttribute("username", username);
            switch (user.getType()) {
                case 0:
                    request.setAttribute("type", "普通用户");
                    break;
                case 1:
                    request.setAttribute("type", "管理员");
                    break;
                default:
                    request.setAttribute("type", "");
            }
            request.getRequestDispatcher("main.jsp").forward(request, response);
        }else {
            request.setAttribute("error", "用户名或密码错误");
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }
}
