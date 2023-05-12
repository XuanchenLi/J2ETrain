package biz.ejb.stateless.local;


import biz.ejb.stateless.local.CalculatorBeanLocal;

import javax.ejb.Stateless;
import javax.ejb.*;

/**
 * Session Bean implementation class CallerBean
 */
@Stateless
public class CallerBean implements CallerBeanRemote {
	@EJB
    CalculatorBeanLocal localbean;
    /**
     * Default constructor. 
     */
    public CallerBean() {
        // TODO Auto-generated constructor stub
    }
    public String testMethod()
    {
	   System.out.println("\n\n\t Bean testMethod() called....");
	   return "DONE----returned";
    }

public String callEJBOne(int a, int b)
    {
     int result=0;
	   try{
	   System.out.println("\n\n\t Bean callEJBOne(a,b) called....");
       result=localbean.add(a,b);
	   }
	   catch(Exception e){ e.printStackTrace(); }
	   return "DONE----result = "+result;
    }

}
