package biz.ejb.stateless.StudentBean;


import entity.jpa.many2many1.Student_m2m1;

import javax.ejb.Local;
import javax.persistence.EntityTransaction;
import javax.transaction.UserTransaction;
import java.util.ArrayList;

@Local
public interface StudentBeanLocal_m2m1 {
    public void addStudents(ArrayList<Student_m2m1> students);
    public Student_m2m1 findStudentById(Integer studentId );
    public Student_m2m1 updateStudent(Student_m2m1 student);
    public void deleteStudent(Integer studentld);
}
