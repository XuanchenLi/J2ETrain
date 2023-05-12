package jluee.client.jms;

import entity.TimeMessage;
import sun.org.mozilla.javascript.internal.json.JsonParser;

import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;
import java.util.Properties;

import javax.jms.*;
import javax.naming.Context;
import javax.naming.InitialContext;

/**
 * <p>Description:JMS�ͻ�����Ϣ������ </p>
 */
public class JMSProducer {
	private static final Logger log = Logger.getLogger(JMSProducer.class.getName());

	private static final String DEFAULT_MESSAGE = "Welcome to JMS queue!";
	private static final String DEFAULT_CONNECTION_FACTORY = "jms/RemoteConnectionFactory";
	private static final String DEFAULT_DESTINATION = "jms/queue/test";
	private static final String DEFAULT_MESSAGE_COUNT = "1";

	private static final String DEFAULT_USERNAME = "test";
	private static final String DEFAULT_PASSWORD = "zkxaihxb2";
	private static final String INITIAL_CONTEXT_FACTORY = "org.jboss.naming.remote.client.InitialContextFactory";
	private static final String PROVIDER_URL = "remote://localhost:4447";

	public static void main(String[] args) throws Exception {
		Context context=null;
		Connection connection=null;
		try {
			// 设置JNDI
			System.out.println("设置JNDI访问环境信息也就是设置应用服务器的上下文信息!");
			final Properties env = new Properties();
			env.put(Context.INITIAL_CONTEXT_FACTORY, INITIAL_CONTEXT_FACTORY);// 初始化Context的工厂类
			env.put(Context.PROVIDER_URL,  PROVIDER_URL);// Context服务提供者的URL
			env.put(Context.SECURITY_PRINCIPAL, DEFAULT_USERNAME);
			env.put(Context.SECURITY_CREDENTIALS, DEFAULT_PASSWORD);//应用用户的登录名,密码
			// 初始化上下文
			context = new InitialContext(env);
			System.out.println ("获取连接工厂！");
			ConnectionFactory connectionFactory = (ConnectionFactory) context.lookup(DEFAULT_CONNECTION_FACTORY);
			System.out.println ("获取目的地!");
			Destination destination = (Destination) context.lookup(DEFAULT_DESTINATION);

			// 创建JMS连接、会话、生产者和消费者
			connection = connectionFactory.createConnection(DEFAULT_USERNAME, DEFAULT_PASSWORD);
			Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
			MessageProducer producer = session.createProducer(destination);
			connection.start();

			// 发送特定数目的消息
			ObjectMessage message = null;
			String opt = "";

			int msgCount = 0;
			do {
				for (int i = 0; i < 5; ++i) {
					long startTime = System.currentTimeMillis();
					for (int j = 0; j < 1; ++j) {
						msgCount++;
						TimeMessage msg = new TimeMessage();
						msg.setSendTime(new Date());
						msg.setContent("ID: " + msgCount);
						message = session.createObjectMessage(msg);
						producer.send(message);
						System.out.println ("message:"+message);
						System.out.println ("message:"+msg.toString());
					}
					long duration = System.currentTimeMillis() - startTime;
					if (duration < 1000) {
						Thread.sleep(1000 - duration);
					}
				}
				Scanner scanner = new Scanner(System.in);
				System.out.println("是否需要继续发送？(y/n)：");
				opt = scanner.nextLine();
			} while(opt.toLowerCase().equals("y"));
			
		} catch (Exception e) {
			log.severe(e.getMessage());
			throw e;
		} finally {
			if (context != null) {
				context.close();
			}
			// 关闭连接负责会话,生产商和消费者
			if (connection != null) {
				connection.close();
			}
		}
	}
}

