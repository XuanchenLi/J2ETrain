package jluee.client.jpa;
import entity.jpa.one2one2.Address2;
import entity.jpa.one2one2.Student2;

import javax.persistence.*;
import java.util.*;

public class OneOneClient2 {


 public static void main(String[] args) throws Exception 
  {   	  
	   EntityManagerFactory factory =
       Persistence.createEntityManagerFactory("JPARelation2",null);
	   EntityManager  manager = factory.createEntityManager();
      try 
      {          createStudent(manager);
				 showAll(manager);
				 queryFromMaintained(manager);
				  
      } 
      finally 
      {
         manager.close();
         factory.close();
      }
   }
   public static void createStudent(EntityManager manager) 
   {
			Student2 p=new Student2();
                
			p.setName("Bill2");
			p.setGender("male");
			p.setMajor("computer");
			Address2 ad=new Address2 ();
	        ad.setDetail("辽宁省沈阳市2号");
	        ad.setProvince("辽宁省");
	        ad.setCity("沈阳市");
	        ad.setZip("130012");
            p.setAddress(ad);
            ad.setStudent(p);
            EntityTransaction transaction = manager.getTransaction();
            transaction.begin();
            manager.persist(p);
            transaction.commit();
   }
  public static void showAll(EntityManager manager)
   {
   	     EntityTransaction transaction = manager.getTransaction();
   	     transaction.begin();
  	     Query q=manager.createQuery("from Student2 c");
         List results=q.getResultList();
         transaction.commit();
         Iterator it=results.iterator();
         while(it.hasNext())
        {
        	  Student2 p=(Student2)it.next();
        	  System.out.print(p.getId()+"\t");
         	  System.out.print(p.getName()+"\t");
              System.out.println(p.getGender()+"\t");
         }
   }
  
  public static void queryFromMaintained(EntityManager manager) {  
	     
	  EntityTransaction transaction = manager.getTransaction();
	  transaction.begin();
	  Address2 address = manager.find(Address2.class, 1);
	  Student2 student =address.getStudent();
	  transaction.commit();
	  System.out.println("id=  "+student.getId());
	  System.out.println("name=  "+student.getName());  
	  System.out.println("manjor=   "+student.getMajor()); 
	}  
}






