package biz.ejb.Singleton;

import javax.ejb.ConcurrencyManagement;
import javax.ejb.ConcurrencyManagementType;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;

/**
 * @ClassName:SingletonBMCBean
 * @Description: TODO
 * @Author:Dazz1e
 * @Date:2023/3/29 下午 3:55
 * Version V1.0
 */
@Singleton
@LocalBean
@ConcurrencyManagement(ConcurrencyManagementType.BEAN)
public class SingletonBMCBean {
    public enum State {PAUSED, RUNNING, TERMINATED};
    private State state;

    public State getState() {
        return state;
    }

    public synchronized void setState1(State state) {
        this.state = state;
    }


    public void setState2(State state) {
        synchronized (this) {
            this.state = state;
        }
    }
}
