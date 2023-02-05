package ProductController.Utility;
import java.util.Scanner;

import ProductController.Entity.Product;

public class ProductUtility {
	
	public static Product prepareProductData(Scanner scanner)
	{
		System.out.println("Enter Product Id");
		long productId = scanner.nextLong();
		
		System.out.println("Enter ProductName");
		String productName = scanner.next();
		
		System.out.println("Enter SupplierId");
		long supplierId = scanner.nextLong();
		
		System.out.println("Enter categoryId");
		long categoryId = scanner.nextLong();
		
		System.out.println("Enter ProductQty");
		int productQty = scanner.nextInt();
		
		System.out.println("Enter productPrice");
		double productPrice = scanner.nextDouble();
		
		Product product=new Product(productId,productName,supplierId,categoryId,productQty,productPrice); 
		return product;
		
	}

}
