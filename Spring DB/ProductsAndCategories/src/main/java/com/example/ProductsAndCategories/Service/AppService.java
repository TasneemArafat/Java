package com.example.ProductsAndCategories.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.ProductsAndCategories.Repository.CategoryProductRepository;
import com.example.ProductsAndCategories.Repository.CategoryRepository;
import com.example.ProductsAndCategories.Repository.ProductRepository;
import com.example.ProductsAndCategories.models.Category;
import com.example.ProductsAndCategories.models.CategoryProduct;
import com.example.ProductsAndCategories.models.Product;

@Service
public class AppService {

	private final CategoryRepository categRepo;
	private final ProductRepository productRepo;
	private final CategoryProductRepository catProRepo;
	public AppService(CategoryRepository categRepo, ProductRepository productRepo,
			CategoryProductRepository catProRepo) {
		super();
		this.categRepo = categRepo;
		this.productRepo = productRepo;
		this.catProRepo = catProRepo;
	}
	
	public Product findProductById(Long id) {
		return productRepo.findById(id).orElse(null);
	}
	
	public Category findCategoryById(Long id) {
		return categRepo.findById(id).orElse(null);
	}
	
	public List<Product> UnaddedProducts(Category cat){
		return productRepo.findByCategoriesNotContains(cat);
	}
	
	public List<Category> UnaddedCategories(Product product){
		return categRepo.findByProductsNotContains(product);
		
	}
	
	public Product addProduct(Product pro) {
		return productRepo.save(pro);
	}
	
	public Category addCategory(Category cat) {
		return categRepo.save(cat);
	}
	
//	public CategoryProduct add(CategoryProduct cp) {
//		return catProRepo.save(cp);
//	}
	
	public void addCategoryToProduct(Product product,Category category) {         
		product.getCategories().add(category);         
		productRepo.save(product);     
	}
	
	public void addProductToCategory(Product product,Category category) {         
		category.getProducts().add(product);         
		categRepo.save(category);     
	}
}
