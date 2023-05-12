package biz.ejb.stateless.StudentBean;

import entity.jpa.many2many1.Student_m2m1;

import javax.annotation.Resource;
import javax.ejb.*;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.*;
import java.util.ArrayList;

/**
 * @ClassName:StudentBean_m2m1
 * @Description: TODO
 * @Author:Dazz1e
 * @Date:2023/5/8 下午 3:38
 * Version V1.0
 */
@Stateless
@LocalBean
@TransactionManagement(TransactionManagementType.BEAN)
public class StudentBean_m2m1 implements StudentBeanLocal_m2m1{
   @PersistenceContext(unitName = "many2many1")
    private EntityManager manager;
   @Resource
   private UserTransaction userTransaction;
   public StudentBean_m2m1() {

   }
    public void addStudents(ArrayList<Student_m2m1> student) {
        try {
            userTransaction.begin();
            for (Student_m2m1 s : student)
                manager.persist(s);
            userTransaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public Student_m2m1 findStudentById(Integer studentId) {

        Student_m2m1 student = manager.find(Student_m2m1.class , studentId);
        return student;
    }
    public Student_m2m1 updateStudent(Student_m2m1 student) {
        Student_m2m1 s = manager.find(Student_m2m1.class, student.getId());
        if (s == null) return null;
        s.setMajor(student.getMajor());
        s.setGender(student.getGender());
        s.setName(student.getName());
        try {
            userTransaction.begin();
            s = manager.merge(s);
            userTransaction.commit();
            return s;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public void deleteStudent(Integer studentId){
        Student_m2m1 student = manager.find(Student_m2m1.class , studentId) ;
        if (student == null) return;
        try {
            userTransaction.begin();
            student = manager.merge(student);
            manager.remove(student);
            userTransaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

