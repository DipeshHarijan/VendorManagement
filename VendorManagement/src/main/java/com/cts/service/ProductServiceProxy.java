package com.cts.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.cts.model.Product;

@FeignClient(name = "product-service")
public interface ProductServiceProxy {

	@GetMapping( value = "/products/vendor/{vendorId}")
	List<Product> getProduct(@PathVariable(name = "vendorId") Long vendorId);
	
	@GetMapping("/products/all")
	List<Product> getAll();

}
