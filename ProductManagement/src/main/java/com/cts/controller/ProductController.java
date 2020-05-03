package com.cts.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cts.entity.Product;
import com.cts.service.ProductService;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("/products")
@Api(value = "The Product Controller", description = "Rest controller for products")
public class ProductController {

	@Autowired
	private ProductService service;

	@GetMapping("/all")
	List<Product> getAll() {
		return service.getProducts();
	}

	@GetMapping("/{productId}")
	Product getById(@PathVariable Long productId) {
		return service.getProductById(productId);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/add")
	void addProduct(@RequestBody Product product) {
		service.addProduct(product);
	}

	@RequestMapping(method = RequestMethod.PUT)
	void updateProduct(@RequestBody Product product) {
		service.updateProduct(product);
	}

	@GetMapping("/name/{productName}")
	List<Product> getProductsByName(@PathVariable String productName) {
		return service.getProductsByName(productName);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/{productId}")
	void deleteProductById(@PathVariable Long productId) {
		service.deleteProduct(productId);
	}
	
	@GetMapping(value="/vendor/{vendorId}")
	List<Product> getProductsByVendorId(@PathVariable Long vendorId){
		return service.getProductByVendorId(vendorId);
	}

}
