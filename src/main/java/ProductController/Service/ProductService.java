package ProductController.Service;

import java.util.List;

import ProductController.Dao.ProductDao;
import ProductController.Entity.Product;

public class ProductService {
	public static  ProductDao Dao = new ProductDao();
	public static  boolean updateProduct(Product product) {
		// TODO Auto-generated method stub
		
		
		boolean IsUpdate =Dao.updateProduct(product);
		
		return IsUpdate;
	}

	public static List<Product> getAllProduct() {
		// TODO Auto-generated method stub
		return Dao.getAllProduct();
	}
	
	
	
	
	
	
	
	

}
