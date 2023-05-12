package jluee.client.statelessClient;

import javax.naming.*;

import java.util.*;

import biz.ejb.stateless.local.CallerBeanRemote;

public class StatelessLocalClient {
	public static void main(String[] args)  throws Exception
	{
		  String  result="";
		System.out.println("\n\n\t begin ...");
		   try{
			   Hashtable<String, String> jndiProperties = new Hashtable<String, String>();
	             jndiProperties.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
	             Context context = new InitialContext(jndiProperties);
	                
	                 final String appName = "";
	                 final String moduleName = "JSPTrain";
	                 final String distinctName = "";
	                 
	                System.out.println("ejb:" + appName + "/" + moduleName + "/" + distinctName +  "/CallerBean!biz.ejb.stateless.local.CallerBeanRemote");
	             
		  
           CallerBeanRemote remote=(CallerBeanRemote)context.lookup("ejb:" + appName + "/" + moduleName + "/" + distinctName +  "/CallerBean!biz.ejb.stateless.local.CallerBeanRemote");
           result=remote.callEJBOne(1000,2000);
//           remote.testMethod();
		   }
		   catch(Exception e){ e.printStackTrace(); }
		  System.out.println("ONE----result = "+result);
		  
	    
    }

}
