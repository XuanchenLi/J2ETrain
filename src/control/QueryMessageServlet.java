package control;

import dao.MessageDao;
import entity.TimeMessage;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;

@WebServlet(name = "QueryMessageServlet")
public class QueryMessageServlet extends HttpServlet {
    private MessageDao messageDao = new MessageDao();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        try {
            String stTime = request.getParameter("stTime");
            String edTime = request.getParameter("edTime");
            Date stDate = null;
            Date edDate = null;
            if (stTime == null || stTime.isEmpty()) {
                stDate = sdf.parse("1970-01-01T01:00:00");
            }else {
                stDate = sdf.parse(stTime);
            }
            if (edTime == null || edTime.isEmpty()) {
                edDate = new Date();
            }else {
                edDate = sdf.parse(edTime);
            }
            List<TimeMessage> resSet = messageDao.SelectMessageByTimeRange(
                    stDate, edDate
            );
            request.setAttribute("ResultSet", resSet);
            request.getRequestDispatcher("/QueryTimeMessage.jsp").forward(request, response);
        }catch (ParseException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
