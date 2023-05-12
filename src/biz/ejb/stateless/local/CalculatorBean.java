package biz.ejb.stateless.local;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 * Session Bean implementation class CalculatorBean
 */
@Stateless
@LocalBean
public class CalculatorBean implements CalculatorBeanLocal {

    /**
     * Default constructor. 
     */
    public CalculatorBean() {
        // TODO Auto-generated constructor stub
    }
    public int add(int x,int y)
    {
	  System.out.println("\n\t[CalculatorBean]  add() invoked.");
      return (x+y);
    }


}
