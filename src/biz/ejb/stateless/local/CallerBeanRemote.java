package biz.ejb.stateless.local;

import javax.ejb.Remote;

@Remote
public interface CallerBeanRemote {
	public String testMethod();
    public String callEJBOne(int a, int b);


}
