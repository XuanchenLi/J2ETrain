package jluee.client;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NameNotFoundException;
import javax.naming.NamingException;
import java.util.Properties;

/**
 * @ClassName:JNDIClient
 * @Description: TODO
 * @Author:Dazz1e
 * @Date:2023/3/15 下午 3:12
 * Version V1.0
 */
public class JNDIClient {
    public static void main(String[] args) throws Exception{
        Context cxt = null;
        Properties prop = new Properties();
        prop.put(Context.PROVIDER_URL, "remote://localhost:4447");
        prop.put(Context.INITIAL_CONTEXT_FACTORY,
                org.jboss.naming.remote.client.InitialContextFactory.class.getName());
        prop.put(Context.SECURITY_PRINCIPAL, System.getProperty("username", "testJNDI"));
        prop.put(Context.SECURITY_CREDENTIALS, System.getProperty("password", "zkxaihxb2"));
        try {
            cxt = new InitialContext(prop);
            String str = (String) cxt.lookup("School");
            System.out.println(str);
        }catch (NamingException e) {
            e.printStackTrace();
            System.out.println("对象不存在");
        }
    }
}
