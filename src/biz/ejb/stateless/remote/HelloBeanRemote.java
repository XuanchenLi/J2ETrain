package biz.ejb.stateless.remote;

import javax.ejb.Remote;

@Remote
public interface HelloBeanRemote {
	public String sayHello(String name);
}
