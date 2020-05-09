package com.cts.service;

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
		for (Vendor vendor : vendors) {
			long vendorId = vendor.getVendorId();
			vendor.setProducts(psp.getProduct(vendorId));
		}
		return vendors;
	}

	public Vendor addVendor(Vendor vendor) {
		return repo.save(vendor);
	}

	public Vendor getVendorById(long vendorId) {
		return repo.findById(vendorId).get();
	}

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
