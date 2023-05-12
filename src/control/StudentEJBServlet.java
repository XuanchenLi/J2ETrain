package control;

import biz.ejb.stateless.StudentBean.StudentBean_m2m1;
import entity.jpa.many2many1.Student_m2m1;
import entity.jpa.many2many1.Teacher_m2m1;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import sun.org.mozilla.javascript.internal.json.JsonParser;

import javax.ejb.EJB;
import javax.persistence.EntityTransaction;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.UserTransaction;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Collection;

@WebServlet(name = "StudentEJBServlet")
public class StudentEJBServlet extends HttpServlet {
    @EJB
    StudentBean_m2m1 studentBean;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        String method = request.getParameter("method");
        Writer out = response.getWriter();
        System.out.println(method);
        if ("add".equals(method)) {
            String s = request.getParameter("students");
            String t = request.getParameter("teachers");
            ArrayList<Student_m2m1> ss = new ArrayList<>();
            ArrayList<Teacher_m2m1> ts = new ArrayList<>();
            try {
                JSONArray sJson = new JSONArray(s);
                JSONArray tJson = new JSONArray(t);
                for (int i = 0; i < tJson.length(); ++i) {
                    JSONObject obj = tJson.getJSONObject(i);
                    Teacher_m2m1 tea = new Teacher_m2m1();
                    tea.setTeacherName(obj.getString("name"));
                    tea.setAge(Integer.parseInt(obj.getString("age")));
                    tea.setGender(obj.getString("gender"));
                    ts.add(tea);
                }
                for (int i = 0; i < sJson.length(); ++i) {
                    JSONObject obj = sJson.getJSONObject(i);
                    Student_m2m1 stu = new Student_m2m1();
                    stu.setName(obj.getString("name"));
                    stu.setMajor(obj.getString("major"));
                    stu.setGender(obj.getString("gender"));
                    stu.setTeachers(ts);
                    ss.add(stu);
                }
                studentBean.addStudents(ss);
            } catch (Exception e) {
                e.printStackTrace();
            }finally {
                request.getRequestDispatcher("/studentEJB.jsp").forward(request, response);
            }
        }else if ("query".equals(method)) {
            try {
                String id = request.getParameter("id");
                Student_m2m1 stu = studentBean.findStudentById(new Integer(id));
                Collection<Teacher_m2m1> ts = stu.getTeachers();
                if (stu != null){
                    request.setAttribute("query_res", new JSONObject(stu).toString());
                }
            }catch (Exception e) {
                e.printStackTrace();
            }finally {
                request.getRequestDispatcher("/studentEJB.jsp").forward(request, response);
            }
        }else if ("update".equals(method)) {
            String s = request.getParameter("student");
            try {
                JSONObject obj = new JSONObject(s);
                Student_m2m1 stu = new Student_m2m1();
                stu.setId(Integer.parseInt(obj.getString("id")));
                stu.setName(obj.getString("name"));
                stu.setMajor(obj.getString("major"));
                stu.setGender(obj.getString("gender"));
                studentBean.updateStudent(stu);
            } catch (Exception e) {
                e.printStackTrace();
            }finally {
                request.getRequestDispatcher("/studentEJB.jsp").forward(request, response);
            }
        }else if ("remove".equals(method)) {
            try {
                String id = request.getParameter("id");
                studentBean.deleteStudent(new Integer(id));
            }catch (Exception e) {
                e.printStackTrace();
            }finally {
                request.getRequestDispatcher("/studentEJB.jsp").forward(request, response);
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
