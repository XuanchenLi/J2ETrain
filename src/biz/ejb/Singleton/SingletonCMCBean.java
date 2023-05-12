package biz.ejb.Singleton;

import javax.ejb.*;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName:SingeltonCMCBean
 * @Description: TODO
 * @Author:Dazz1e
 * @Date:2023/3/29 下午 3:47
 * Version V1.0
 */
@Singleton
@LocalBean
@ConcurrencyManagement(ConcurrencyManagementType.CONTAINER)
public class SingletonCMCBean {
    public enum State {PAUSED, RUNNING, TERMINATED};
    private State state;

    @Lock(LockType.READ)
    @AccessTimeout(20000)
    public State getState() {
        return state;
    }

    @Lock(LockType.WRITE)
    @AccessTimeout(20000)
    public void setState(State state) {
        this.state = state;
        try{
            CountDownLatch latch = new CountDownLatch(1);
            latch.await(4, TimeUnit.SECONDS);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
