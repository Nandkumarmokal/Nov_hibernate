package ProductController;

import java.util.List;
import java.util.Scanner;

import ProductController.Dao.ProductDao;
import ProductController.Entity.Product;
import ProductController.Service.ProductService;
import ProductController.Utility.ProductUtility;

public class ProductController {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner =new Scanner(System.in);
		char ch;
		ProductDao Dao = new ProductDao();
		do
		{
			
			System.out.println("Press 1 for save Product Details");
			
			System.out.println("Press 2 for Show Product Details");
			
			System.out.println("Press 3 for Delete Product Details");
			
			System.out.println("Press 4 for Update Product Details");
			
			System.out.println("Press 5 for All Product Details");
			
			System.out.println("Press 6 for All Ascending Product Details");
			
			System.out.println("Press 7 for All Descending Product Details");
			
			int choice = scanner.nextInt();
		switch(choice)
		{
		case 1:{
			Product product=ProductUtility.prepareProductData(scanner);
		
		boolean  IsAdd=Dao.saveProduct(product);
		if(IsAdd)
		{
			System.out.println("Add Sucessfully");
		}
		else
		{
			System.out.println("Not Data Exist");
		}
		break;
		}
		case 2:System.out.println("Enter Product Id");{
		long productId = scanner.nextLong();
				Product dbproduct= Dao.showProductById(productId);
				if(dbproduct!=null)
				{
					System.out.println("Show Sucessfully");
				}
				else
				{
					System.out.println("Not Data Exist");
				}
		}
			break;
		case 3 :System.out.println("Enter Product Id ");
		long productId = scanner.nextLong();
		boolean IsDeleted = Dao.deleteProductById(productId);
		
		if(IsDeleted)
		{
			System.out.println("Deleted Sucessfully");
		}
		else
		{
			System.out.println("Not Data Exist");
		}
		break;
		case 4 :{
			Product product=ProductUtility.prepareProductData(scanner);
				boolean IsUpdate=ProductService.updateProduct(product);
				if(IsUpdate)
				{
					System.out.println("Update Sucessfully");
				}
				else
				{
					System.out.println("Not Data Exist");
				}
		break;	
		}
		case 5 :
			List<Product> Allproduct=ProductService.getAllProduct();
			if(Allproduct.isEmpty() || Allproduct==null)
			{
				System.out.println("Product Not Exists");
			}else
			{
				for(Product product :Allproduct )
				{
					System.out.println(product);
				}
			}
			break;
		default :
		
			break;
				
		}
		System.out.println("Do you want you continue y/n");
		
		ch = scanner.next().charAt(0);
	}while(ch=='y' || ch == 'Y');
		System.out.println("Exit");
	}	

}
