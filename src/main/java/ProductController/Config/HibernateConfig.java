package ProductController.Config;



import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import ProductController.Entity.Product;

public class HibernateConfig {

	public static SessionFactory getsessionfactory()
	{
		
		Configuration configuration = new Configuration();
		configuration.configure().addAnnotatedClass(Product.class);
		
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		return sessionFactory;
		
	}
	
}
