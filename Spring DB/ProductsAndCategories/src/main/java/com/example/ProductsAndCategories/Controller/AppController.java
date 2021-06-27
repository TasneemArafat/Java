package com.example.ProductsAndCategories.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.ProductsAndCategories.Service.AppService;
import com.example.ProductsAndCategories.models.Category;
import com.example.ProductsAndCategories.models.CategoryProduct;
import com.example.ProductsAndCategories.models.Product;

@Controller
public class AppController {
	
	private final AppService appService;
	

	public AppController(AppService appService) {
		super();
		this.appService = appService;
	}

	@RequestMapping("/products/new")
	public String newProduct(@ModelAttribute("product") Product product) {
		return "newProduct.jsp";
	}
	
	@RequestMapping(value="/products/new", method=RequestMethod.POST)
	public String createProduct(@ModelAttribute("product") Product product,Model model) {
		appService.addProduct(product);
		return "redirect:/products/"+product.getId();
	}
	
	@RequestMapping("/categories/new")
	public String newCategory(@ModelAttribute("category") Category category) {
		return "newCategory.jsp";
	}
	
	@RequestMapping(value="/categories/new", method=RequestMethod.POST)
	public String createCategory(@ModelAttribute("category") Category category,Model model) {
		appService.addCategory(category);
		return "redirect:/categories/"+category.getId();
	}
	
	@RequestMapping("/products/{id}")
	public String showProduct(@PathVariable("id") Long id,Model model) {
		model.addAttribute("product",appService.findProductById(id));
		model.addAttribute("Categories",appService.UnaddedCategories(appService.findProductById(id)));
		return "showProduct.jsp";
	}
	
	@RequestMapping(value="/products/{id}", method=RequestMethod.POST)
	public String addCategoryToProduct(@PathVariable("id") Long id, Model model,@RequestParam("category_id") Long category_id) {
		Product product = appService.findProductById(id);
        Category category = appService.findCategoryById(category_id);
        appService.addCategoryToProduct(product, category);
		return "redirect:/products/"+id;
	}
	
	@RequestMapping("/categories/{id}")
	public String showCategory(@PathVariable("id") Long id,Model model) {
		model.addAttribute("category",appService.findCategoryById(id));
		model.addAttribute("Products",appService.UnaddedProducts(appService.findCategoryById(id)));
		return "showCategory.jsp";
	}
	
	@RequestMapping(value="/categories/{id}", method=RequestMethod.POST)
	public String addProductToCategory(@PathVariable("id") Long id, Model model,@RequestParam("product_id") Long product_id) {
		Category category = appService.findCategoryById(id);
		Product product = appService.findProductById(product_id);
        appService.addCategoryToProduct(product, category);
		return "redirect:/categories/"+id;
	}
}
