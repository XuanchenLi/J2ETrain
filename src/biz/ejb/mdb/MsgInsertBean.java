package biz.ejb.mdb;

import dao.BaseDao;
import dao.MessageDao;
import entity.TimeMessage;

import javax.annotation.Resource;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.ejb.MessageDrivenContext;
import javax.jms.*;
import javax.naming.Context;
import javax.naming.InitialContext;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName:MsgInsertBean
 * @Description: TODO
 * @Author:Dazz1e
 * @Date:2023/4/15 下午 5:00
 * Version V1.0
 */
@MessageDriven(
        activationConfig = {
                @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue"),
                @ActivationConfigProperty(propertyName = "destination", propertyValue = "queue/test")
        }
)
public class MsgInsertBean implements MessageListener {
    /*
    private static final String DEFAULT_CONNECTION_FACTORY = "jms/RemoteConnectionFactory";
    private static final String DEFAULT_DESTINATION = "jms/queue/test";

    private static final String DEFAULT_USERNAME = "testJMS";
    private static final String DEFAULT_PASSWORD = "zkxaihxb2";
    private static final String INITIAL_CONTEXT_FACTORY = "org.jboss.naming.remote.client.InitialContextFactory";
    private static final String PROVIDER_URL = "remote://localhost:4447";

     */
    private MessageDao messageDao = new MessageDao();
    @Resource
    private MessageDrivenContext mdc;
    public MsgInsertBean() {}
    @Override
    public void onMessage(Message message) {
        ObjectMessage msg = null;
        try {
            if (message instanceof ObjectMessage) {
                msg = (ObjectMessage) message;
                TimeMessage tMsg = (TimeMessage)msg.getObject();
                tMsg.setRecvTime(new Date());
                messageDao.InsertMessage(tMsg);
                System.out.println("MDB Insert Message: " + tMsg);
            }
        } catch (JMSException e) {
            e.printStackTrace();
            mdc.setRollbackOnly();
        }
    }
    /*
    public static void main(String[] args) {
        Context context=null;
        Connection connection=null;
        MsgInsertBean mdb=null;
        try {
            final Properties env = new Properties();
            env.put(Context.INITIAL_CONTEXT_FACTORY, INITIAL_CONTEXT_FACTORY);
            env.put(Context.PROVIDER_URL,  PROVIDER_URL);
            env.put(Context.SECURITY_PRINCIPAL, DEFAULT_USERNAME);
            env.put(Context.SECURITY_CREDENTIALS, DEFAULT_PASSWORD);

            context = new InitialContext(env);
            ConnectionFactory connectionFactory = (ConnectionFactory) context.lookup(DEFAULT_CONNECTION_FACTORY);
            Destination destination = (Destination) context.lookup(DEFAULT_DESTINATION);

            connection = connectionFactory.createConnection(DEFAULT_USERNAME, DEFAULT_PASSWORD);
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            MessageConsumer consumer = session.createConsumer(destination);
            mdb = new MsgInsertBean();
            consumer.setMessageListener(mdb);
            connection.start();
            while(true) {

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

     */
}
