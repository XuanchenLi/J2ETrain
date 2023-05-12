package jluee.client.jpa;
import entity.jpa.many2many3.Course;
import entity.jpa.many2many3.Student_m2m3;
import entity.jpa.many2many3.Teacher_m2m3;

import javax.persistence.*;
import java.util.*;

public class ManyManyClient3 {


 public static void main(String[] args) throws Exception 
  {   	  
     EntityManagerFactory factory =
       Persistence.createEntityManagerFactory("many2many3",null);
       EntityManager manager = factory.createEntityManager();
      try 
      {         
    	         testsave1(manager);
    	         
				 showAll(manager);
      } 
      finally 
      {
         manager.close();
         factory.close();
      }
   }
   public static void testsave1(EntityManager manager) 
   {
	   Course c1=new Course();
	   c1.setCourse("computer");
	   Course c2=new Course();
	   c2.setCourse("art");
	   Student_m2m3 s=new Student_m2m3();
	   s.setName("赵二");
	   s.setGender("male");
	   s.setMajor("computer technology");
	   c1.setStudent(s);
	   c2.setStudent(s);
	   Teacher_m2m3 t1=new Teacher_m2m3();
	   t1.setTeacherName("王一");
	   t1.setAge(31);
	   t1.setGender("male");
	   c1.setTeacher(t1);
	   c2.setTeacher(t1); 
     EntityTransaction transaction = manager.getTransaction();
     transaction.begin();
      manager.persist(c1);
      manager.persist(c2);
      
      transaction.commit();
   }
   
  
  public static void showAll(EntityManager manager)
   {
   	     EntityTransaction transaction = manager.getTransaction();
   	     transaction.begin();
  	     Query q=manager.createQuery("from Student c");
         List results=q.getResultList();
        transaction.commit();
         Iterator it=results.iterator();
         while(it.hasNext())
        {
        	  Student_m2m3 p=(Student_m2m3)it.next();
        	  System.out.print(p.getId()+"\t");
         	  System.out.print(p.getName()+"\t");
        	  System.out.println(p.getGender()+"\t");
         }
   }
}






