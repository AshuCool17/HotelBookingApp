/**
 * 
 */

package com.mindtree.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

/**
 * @author Ashutosh
 *
 */
@SuppressWarnings("deprecation")
public class HibernateUtil {

	public static SessionFactory sessionFactory;
	public static Session session;

	private HibernateUtil() {
	}

	private void getSessionFactory() {

		/*if (sessionFactory == null) {
			InputStream inputStream = getClass().getClassLoader().getResourceAsStream("com/mindtree/resource/application.properties");
			try {
				Properties properties = new Properties();
				properties.load(inputStream);
				Configuration configuration = new Configuration();
				ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(properties).build();
				sessionFactory = configuration.buildSessionFactory(serviceRegistry);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}*/
		if (sessionFactory == null) {
			Configuration configuration = new AnnotationConfiguration();
	          configuration = configuration.configure();
	          StandardServiceRegistryBuilder standardServiceRegistryBuilder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
	          StandardServiceRegistry standardServiceRegistry =  standardServiceRegistryBuilder.build();
	          sessionFactory = configuration.buildSessionFactory(standardServiceRegistry);
	      }
	}
	public static Session getSession() {
		HibernateUtil hibernateUtil = new HibernateUtil();

		if (session == null) {
			hibernateUtil.getSessionFactory();
			session = sessionFactory.openSession();
		}
		return session;
	}

}
