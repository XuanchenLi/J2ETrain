package jluee.client.jpa;
import entity.jpa.one2many2.Student_o2m2;
import entity.jpa.one2many2.Teacher_o2m2;

import javax.persistence.*;
import java.util.*;

public class OneManyClient2 {


 public static void main(String[] args) throws Exception 
  {   	  
     EntityManagerFactory factory =
       Persistence.createEntityManagerFactory("one2many2",null);
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
	   Teacher_o2m2 t=new Teacher_o2m2();
	   t.setTeacherName("Mike");
	   t.setAge(31);
	   t.setGender("male");
	   
	   Student_o2m2 p=new Student_o2m2();
	   p.setName("wangwu6");
	   p.setMajor("economic");
	   p.setGender("female");
	   p.setTeacher(t);
	   
	   Student_o2m2 p2=new Student_o2m2();
	   p2.setName("wangwu2");
	   p2.setMajor("Math");
	   p2.setGender("male");
	   p2.setTeacher(t);
	   
	   t.getStudents().add(p);
	   t.getStudents().add(p2);
	   
	   EntityTransaction transaction = manager.getTransaction();
	   transaction.begin();
	   manager.persist(t);
	   //manager.persist(p);
	   //manager.persist(p2);
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
        	 Student_o2m2 p=(Student_o2m2)it.next();
        	  System.out.print(p.getId()+"\t");
         	  System.out.print(p.getName()+"\t");
        		  System.out.println(p.getGender()+"\t");
         }
   }
}






