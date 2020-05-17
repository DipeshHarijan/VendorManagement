package com.cts.controller;

import java.util.Arrays;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.entity.Vendor;
import com.cts.exception.VendorNotFoundException;
import com.cts.model.Product;
import com.cts.service.VendorService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@CrossOrigin
@RestController
@RequestMapping(value = "/vendor")
@Api(value = "The Vendor Controller", description = "Rest controller for vendor")
public class VendorController {

	@Autowired
	VendorService service;

	@ApiOperation(value = "Add a vendor", consumes = "A new vendor is JSON", notes = "Hit this URL to insert a new vendor's details")
	@PostMapping(value = "/add")
	public void addVendor(@Valid @RequestBody Vendor vendor) {
		service.addVendor(vendor);
	}

	@ApiOperation(value = "Delete a vendor", consumes = "An existing vendor id", notes = "Hit this URL to delete a vendor's details")
	@DeleteMapping(value = "/delete/{vendorId}")
	public void deleteVendorById(@PathVariable long vendorId) {
		service.deleteVendor(vendorId);
	}

	@ApiOperation(value = "Update a vendor's details", consumes = "An existing vendor in JSON", notes = "Hit this URL to update a vendor's details")
	@PutMapping
	public void updateVendor(@Valid @RequestBody Vendor vendor) {
		service.updateVendor(vendor);

	}

	@ApiOperation(value = "Retrieve a vendor's details", produces = "A vendor's details if it exists", notes = "Hit this URL to get a vendor's details")
	@GetMapping(value = "/get/{vendorId}")
	public Vendor getVendorById(@PathVariable long vendorId) {
		Vendor vendor = service.getVendorById(vendorId);
		if(vendor == null) {
			throw new VendorNotFoundException("vendorId:"+vendorId);
		}
		return vendor;
	}

	@HystrixCommand(fallbackMethod = "vendorsOnly")
	@ApiOperation(value = "Get all vendors", produces = "A list of vendors", notes = "Hit this URL to get all vendors details")
	@GetMapping(value = "/getAll")
	public List<Vendor> getAll() {
		return service.getAll();
	}
	
	public List<Vendor> vendorsOnly(){
		return service.getOnlyVendors();
	}

	@HystrixCommand(fallbackMethod = "fallback")
	@GetMapping("/{vendorId}")
	public List<Product> getProducts(@PathVariable(name = "vendorId") Long vendorId) {
		return service.getProductByVendorId(vendorId);
	}

	public List<Product> fallback(@PathVariable(name = "vendorId") Long vendorId) {
		return Arrays.asList(new Product(1001,"Fallback Product", "Product microservice unreachable", 0, vendorId));
	}

}
