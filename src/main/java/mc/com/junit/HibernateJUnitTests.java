package mc.com.junit;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Assert;
import org.junit.Test;

import mc.com.hibernate.HibernateUtil;

public class HibernateJUnitTests {
	private static Logger log = Logger.getLogger(HibernateJUnitTests.class);
	
	@Test
	public void test() {
		System.out.println("****************************************");
		SessionFactory sessionFactory =	 HibernateUtil.getSessionFactory();
		Assert.assertNotNull(sessionFactory);
		log.info("SessionFactory  = "+sessionFactory);
		
		Session session= sessionFactory.openSession();
		Assert.assertNotNull(session);
		log.info("Session = "+session);
		
		session.close();
		System.out.println("****************************************");
		
	}

}
