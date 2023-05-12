package jluee.client.statelessClient;

import biz.ejb.stateless.remote.HelloBeanRemote;

import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class StatelessRemoteClient {

		 

	    /**

	     * @param args

	     */

	      	 public static void main(String[] args) {
	    	        // TODO Auto-generated method stub
	      		 Hashtable<String, String> jndiProperties = new Hashtable<String, String>();
	             jndiProperties.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
	             try {
	                 Context context = new InitialContext(jndiProperties);
	                
	                 final String appName = "";
	                 final String moduleName = "JSPTrain";
	                 final String distinctName = "";
	                System.out.println("ejb:" + appName + "/" + moduleName + "/" + distinctName + "/HelloBean!biz.ejb.stateless.remote.HelloBeanRemote");
	                 Object obj = context.lookup("ejb:" + appName + "/" + moduleName + "/" + distinctName + "/HelloBean!biz.ejb.stateless.remote.HelloBeanRemote");
	                
	                 HelloBeanRemote hwr =
	                         (HelloBeanRemote)obj;
	                 String say = hwr.sayHello("Jilin University");
	                 System.out.println(say);
	             } catch (NamingException e) {
	                 e.printStackTrace();
	             }
	 
	    	        
	        }
	 

	 

}
