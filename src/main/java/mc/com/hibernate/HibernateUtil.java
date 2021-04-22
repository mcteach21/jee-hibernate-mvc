package mc.com.hibernate;

import java.util.Properties;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
 
public class HibernateUtil {
   private static SessionFactory sessionFactory = buildSessionFactory();
   private static Session session = null;
   
   private static SessionFactory buildSessionFactory()
   {
      try
      {   	      	  
         if (sessionFactory == null)
         {
        	Properties dbConnectionProperties = new Properties();
 	        try {
 	            HibernateUtil.class.getClassLoader();
				dbConnectionProperties.load(ClassLoader.getSystemClassLoader().getResourceAsStream("database.properties"));
 	        } catch(Exception e) {
 	            e.printStackTrace();
 	        }   
            System.out.println("properties ok..");             
        	 
            Configuration configuration = new Configuration().configure(HibernateUtil.class.getResource("/hibernate.cfg.xml"))
            		.addProperties(dbConnectionProperties);
            StandardServiceRegistryBuilder serviceRegistryBuilder = new StandardServiceRegistryBuilder();
            serviceRegistryBuilder.applySettings(configuration.getProperties());
            ServiceRegistry serviceRegistry = serviceRegistryBuilder.build();
            sessionFactory = configuration.buildSessionFactory(serviceRegistry);
         }
         
         return sessionFactory;
      } catch (Throwable ex)
      {
         System.err.println("Initial SessionFactory creation failed." + ex);
         throw new ExceptionInInitializerError(ex);
      }
   }
 
   public static SessionFactory getSessionFactory()
   {
      return sessionFactory;
   }
   public static Session getSession()
   {
	  if(session==null)
		  session=session.isOpen()?getSessionFactory().getCurrentSession():getSessionFactory().openSession();
      return session;
   }
   public static void shutdown()
   {
      getSessionFactory().close();
   }
}