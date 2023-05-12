package jluee.client.jpa;
import entity.jpa.many2many2.Student_m2m2;
import entity.jpa.many2many2.Teacher_m2m2;

import javax.persistence.*;
import java.util.*;

public class ManyManyClient2 {


 public static void main(String[] args) throws Exception 
  {   	  
     EntityManagerFactory factory =
       Persistence.createEntityManagerFactory("many2many2",null);
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
	   Student_m2m2 s=new Student_m2m2();
	   s.setName("Student1");
	   s.setGender("male");
	   s.setMajor("computer technology");
	   Teacher_m2m2 t1=new Teacher_m2m2();
	   t1.setTeacherName("TeacherA");
	   t1.setAge(31);
	   t1.setGender("male");
	   s.getTeachers().add(t1);
	   Teacher_m2m2 t2=new Teacher_m2m2();
	   t2.setTeacherName("TeacherB");
	   t2.setAge(36);
	   t2.setGender("female");
	   s.getTeachers().add(t2);
     EntityTransaction transaction = manager.getTransaction();
     transaction.begin();
      manager.persist(s);
      
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
        	 Student_m2m2 p=(Student_m2m2)it.next();
        	  System.out.print(p.getId()+"\t");
         	  System.out.print(p.getName()+"\t");
        		  System.out.println(p.getGender()+"\t");
         }
   }
}






