package com.cts.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cts.entity.Vendor;
import com.cts.service.VendorService;

@RestController
@RequestMapping(value = "/vendor")
public class VendorController {

	@Autowired
	VendorService service;

	@RequestMapping(method = RequestMethod.POST, value = "/addvendor")
	void addVendor(@RequestBody Vendor vendor) {
		service.addVendor(vendor);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/{vendorId}")
	void deleteVendorById(@PathVariable long vendorId) {
		service.deleteVendor(vendorId);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/vendor")
	void updateVendor(@RequestBody Vendor vendor) {
		service.updateVendor(vendor);

	}

	@RequestMapping("/{vendorId}")
	Optional<Vendor> getVendorById(@PathVariable long vendorId) {
		return service.getVendorById(vendorId);
	}
}
