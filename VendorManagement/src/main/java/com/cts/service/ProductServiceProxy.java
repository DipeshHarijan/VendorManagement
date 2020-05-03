package com.cts.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cts.model.Product;

@FeignClient(name = "product-service")
public interface ProductServiceProxy {

	@RequestMapping(method = RequestMethod.GET, value = "/products/vendor/{vendorId}")
	List<Product> getProduct(@PathVariable(name = "vendorId") Long vendorId);

}
