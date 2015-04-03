package conn;

import model.Book;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class LibraryConfiguration {
	
	private static SessionFactory sessionFactory;

	public static void createSessionFactory() {
		Configuration configuration = new Configuration();
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties()).build();
		sessionFactory = configuration.addAnnotatedClass(Book.class)
				.buildSessionFactory(serviceRegistry);
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public static void closeSessionFactory() {
		sessionFactory.close();
	}

	public static Session createSession() {
		return sessionFactory.openSession();
	}

}
