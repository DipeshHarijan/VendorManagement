package com.cts.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cts.entity.Product;

@Repository
public interface ProductManagementRepository extends CrudRepository<Product, Long> {

	List<Product> findAllByProductName(String productName);
	List<Product> findAllByVendorVendorId(Long id);

}
