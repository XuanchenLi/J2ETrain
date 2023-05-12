package biz.ejb.stateless.local;

import javax.ejb.Local;

@Local
public interface CalculatorBeanLocal {
	 public int add(int x,int y);

}
