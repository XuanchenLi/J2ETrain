package jluee.client.jpa;
import entity.jpa.one2many1.Student_o2m1;
import entity.jpa.one2many1.Teacher_o2m1;

import javax.persistence.*;
import java.util.*;

public class OneManyClient1 {


 public static void main(String[] args) throws Exception 
  {   	  
     EntityManagerFactory factory =
       Persistence.createEntityManagerFactory("one2many1",null);
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
	   Student_o2m1 p=new Student_o2m1();
	   p.setName("学生一");
	   p.setGender("male");
	   p.setMajor("computer technology");
	   Teacher_o2m1 t=new Teacher_o2m1();
	   t.setTeacherName("老师甲");
	   t.setAge(31);
	   t.setGender("male");
	   t.getStudents().add(p);
	   Student_o2m1 p2=new Student_o2m1();
	   p2.setName("学生二");
	   p2.setGender("male");
	   p2.setMajor("computer Science");
	   t.getStudents().add(p2);
     EntityTransaction transaction = manager.getTransaction();
     transaction.begin();
      manager.persist(t);
      
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
        	 Student_o2m1 p=(Student_o2m1)it.next();
        	  System.out.print(p.getId()+"\t");
         	  System.out.print(p.getName()+"\t");
        		  System.out.println(p.getGender()+"\t");
         }
   }
}






