package biz;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.Objects;

/**
 * @ClassName:JNDIBiz
 * @Description: TODO
 * @Author:Dazz1e
 * @Date:2023/3/15 下午 2:25
 * Version V1.0
 */
public class JNDIBiz {
    private Context cxt;

    public JNDIBiz(){
        try {
            cxt = new InitialContext();
        } catch (NamingException e) {
            e.printStackTrace();
        }
    }
    public void bind(String name, Object val) throws NamingException {
        cxt.bind(name, val);
    }

    public void reBind(String name, Object val) throws NamingException {
        cxt.rebind(name, val);
    }

    public void unBind(String name) throws NamingException {
        cxt.unbind(name);
    }

    public Object search(String name) throws NamingException {
        return cxt.lookup(name);
    }

}
