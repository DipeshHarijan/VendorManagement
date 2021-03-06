package com.cts.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.entity.Vendor;
import com.cts.model.Product;
import com.cts.repository.VendorRepository;

@Service
public class VendorService {

	@Autowired
	VendorRepository repo;

	@Autowired
	ProductServiceProxy psp;

	public List<Vendor> getAll() {
		List<Vendor> vendors = (List<Vendor>) repo.findAll();
		List<Product> products = psp.getAll();
		vendors.stream().forEach(vendor -> {
			ArrayList<Product> list = new ArrayList<>();
			products.stream().forEach(product -> {
				if (vendor.getVendorId() == product.getVendorId()) {
					list.add(product);
				}
			});
			vendor.setProducts(list);
		});
		return vendors;
	}

	public List<Vendor> getOnlyVendors() {
		List<Vendor> vendors = (List<Vendor>) repo.findAll();
		vendors.stream().forEach(vendor -> vendor.setProducts(
				Arrays.asList(new Product(1001, "Fallback Product", "Product microservice unreachable", 0))));
		return vendors;

	}

	public Vendor addVendor(Vendor vendor) {
		return repo.save(vendor);
	}

	public com.cts.entity.Vendor getVendorById(long vendorId) {
		return repo.findById(vendorId).orElse(null);
	}

	public Vendor updateVendor(Vendor vendor) {
		return repo.save(vendor);
	}

	public void deleteVendor(long vendorId) {
		repo.deleteById(vendorId);
		;
	}

	public List<Product> getProductByVendorId(Long vendorId) {
		return psp.getProduct(vendorId);
	}

}
