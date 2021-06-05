package kodlamaio.northwind.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlamaio.northwind.entities.concretes.Product;

public interface ProductDao extends JpaRepository<Product, Integer> {
	//SELECT * FROM products WHERE product_name = abc
	Product getByProductName(String productName);
	
	//SELECT * FROM products WHERE product_name = abc AND category_id = 1
	Product getByProductNameAndCategory_CategoryId(String productName, int categoryId);
	
	//SELECT * FROM products WHERE product_name = abc OR category_id = 1
	List<Product> getByProductNameOrCategory_CategoryId(String productName, int categoryId);
	
	//SELECT * FROM products WHERE category_id IN(1,2,3,4)
	List<Product> getByCategoryIn(List<Integer> categories);
	
	List<Product> getByProductNameContains(String productName);
	
	List<Product> getByProductNameStartsWith(String productName);
	
	//SELECT * FROM products WHERE product_name = bisey AND category_id = bisey
	@Query("From Product where productName =:productName and category.categoryId=:categoryId")
	List<Product> getByNameAndCategory_CategoryId(String productName, int categoryId);
	
	
}
