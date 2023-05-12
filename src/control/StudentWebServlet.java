package control;
import entity.jpa.one2many1.Student_o2m1;
import entity.jpa.one2many1.Teacher_o2m1;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Collection;

@WebServlet(name = "StudentWebServlet")
public class StudentWebServlet extends HttpServlet {
    @PersistenceUnit(unitName = "one2many1")
    private EntityManagerFactory emf;
    private EntityManager em = null;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        String method = request.getParameter("method");
        Writer out = response.getWriter();
        System.out.println(method);
        if (emf != null) {
            em= emf.createEntityManager();
        }
        if ("add".equals(method)) {
            String s = request.getParameter("students");
            String t = request.getParameter("teacher");
            ArrayList<Student_o2m1> ss = new ArrayList<>();
            Teacher_o2m1 tea = new Teacher_o2m1();
            try {
                JSONObject obj = new JSONObject(t);
                tea.setAge(Integer.parseInt(obj.getString("age")));
                tea.setGender(obj.getString("gender"));
                tea.setTeacherName(obj.getString("name"));
                JSONArray sArr = new JSONArray(s);
                for (int i = 0; i < sArr.length(); ++i) {
                    JSONObject so = sArr.getJSONObject(i);
                    Student_o2m1 stu = new Student_o2m1();
                    stu.setGender(so.getString("gender"));
                    stu.setMajor(so.getString("major"));
                    stu.setName(so.getString("name"));
                    ss.add(stu);
                }
                tea.setStudents(ss);
                this.addTeacher(tea);
            } catch (Exception e) {
                e.printStackTrace();
            }finally {
                request.getRequestDispatcher("/studentWeb.jsp").forward(request, response);
            }
        }else if ("query".equals(method)) {
            try {
                String id = request.getParameter("id");
                Teacher_o2m1 tea = this.findTeacherById(Integer.parseInt(id));
                if (tea != null) {
                    Collection<Student_o2m1> tmp = tea.getStudents();
                    System.out.println(new JSONObject(tea).toString());
                    request.setAttribute("query_res", new JSONObject(tea).toString());
                }
            }catch (Exception e) {
                e.printStackTrace();
            }finally {
                request.getRequestDispatcher("/studentWeb.jsp").forward(request, response);
            }
        }else if ("update".equals(method)) {
            String t = request.getParameter("teacher");
            try {
                JSONObject to = new JSONObject(t);
                Teacher_o2m1 tea = new Teacher_o2m1();

                tea.setId(Integer.parseInt(to.getString("id")));
                tea.setTeacherName(to.getString("name"));
                tea.setGender(to.getString("gender"));
                tea.setAge(Integer.parseInt(to.getString("age")));
                this.updateTeacher(tea);
            } catch (Exception e) {
                e.printStackTrace();
            }finally {
                request.getRequestDispatcher("/studentWeb.jsp").forward(request, response);
            }
        }else if ("remove".equals(method)) {
            try {
                String id = request.getParameter("id");
                this.deleteTeacher(Integer.parseInt(id));
            }catch (Exception e) {
                e.printStackTrace();
            }finally {
                request.getRequestDispatcher("/studentWeb.jsp").forward(request, response);
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
    private Teacher_o2m1 findTeacherById(int id) {
        if (em != null) {
            Teacher_o2m1 t = em.find(Teacher_o2m1.class, id);
            return t;
        }
        return null;
    }
    private void updateTeacher(Teacher_o2m1 t) {
        Teacher_o2m1 tt = em.find(Teacher_o2m1.class, t.getId());
        tt.setAge(t.getAge());
        tt.setGender(t.getGender());
        tt.setTeacherName(t.getTeacherName());
        if (em != null) {
            EntityTransaction et = em.getTransaction();
            et.begin();
            em.merge(tt);
            et.commit();
        }
    }
    private void deleteTeacher(int id) {
        if (em != null) {
            Teacher_o2m1 t = em.find(Teacher_o2m1.class, id);
            EntityTransaction et = em.getTransaction();
            et.begin();
            t = em.merge(t);
            em.remove(t);
            et.commit();
        }
    }
    private void addTeacher(Teacher_o2m1 t) {
        if (em != null) {
            EntityTransaction et = em.getTransaction();
            et.begin();
            em.persist(t);
            et.commit();
        }
    }
}
