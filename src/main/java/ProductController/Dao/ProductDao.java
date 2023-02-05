package ProductController.Dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;

import ProductController.Config.HibernateConfig;
import ProductController.Entity.Product;

public class ProductDao {
	
	private SessionFactory sessionFactory = HibernateConfig.getsessionfactory();

	
	public boolean   saveProduct(Product product)
	{
		Session session=sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		boolean IsAdd =false;
		try
		{
		session.save(product);
		transaction.commit();
		IsAdd=true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}finally
		{
		session.close();
		}
			return IsAdd;
	}

	public boolean  deleteProductById(long productId) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		boolean IsDeleted =false;
		try
		{
		//Product product = new Product();
		//product.setProductId(productId);
			Product dbproduct=showProductById(productId);
			if(dbproduct!=null)
			{
		session.delete(dbproduct);
		//session
		transaction.commit();
		IsDeleted=true;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}finally
		{
		session.close();
		
		}
		return IsDeleted;
	}
	
		public Product	showProductById(long productId)
		{
			Session session =sessionFactory.openSession();
			Product product=null;
			
			try {
				product=session.get(Product.class, productId);
				System.out.println(product);
			
				
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}finally
			{
				session.close();
			}
			
			
			return product;
		}

		public boolean updateProduct(Product product) {
				Session session=sessionFactory.openSession();
				Transaction transaction = session.beginTransaction();
				boolean IsUpdate =false;
			try
			{
				session.update(product);
				transaction.commit();
				IsUpdate=true;
				
			}catch(Exception e)
			{
				e.printStackTrace();
			}finally
			{
				session.close();
			}
			return IsUpdate;
		}

		public List<Product> getAllProduct() {
			Session session=sessionFactory.openSession();
			List<Product> list = null;
			try
			{	
				Criteria criteria=session.createCriteria(Product.class);
				criteria.addOrder(Order.asc("productName"));
				list = criteria.list();
				criteria.addOrder(Order.desc("productName"));
				list = criteria.list();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			finally
			{
				session.close();
			}
			return list;
		}
	

}
