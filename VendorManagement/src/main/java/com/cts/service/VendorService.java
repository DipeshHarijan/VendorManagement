package com.cts.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
			ArrayList<Product> pro = new ArrayList<>();
			products.stream().forEach(product -> {
				if (vendor.getVendorId() == product.getVendorId()) {
					pro.add(product);
				}
			});
			vendor.setProducts(pro);
		});
		return vendors;
	}

	public void addVendor(Vendor vendor) {
		repo.save(vendor);
	}

	public Vendor getVendorById(long vendorId) {
		return repo.findById(vendorId).orElse(new Vendor());
	}
		
//		return repo.findById(vendorId).get();
	

	public void updateVendor(Vendor vendor) {
		repo.save(vendor);
	}

	public void deleteVendor(long vendorId) {
		repo.deleteById(vendorId);
	}

	public List<Product> getProductByVendorId(Long vendorId) {
		return psp.getProduct(vendorId);
	}

}
