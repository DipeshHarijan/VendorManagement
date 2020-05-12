package com.cts.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.cts.entity.Vendor;

@RunWith(SpringRunner.class)
@DataJpaTest
public class VendorRepositoryTest {
	
	@Autowired
	private VendorRepository repository;
	
	@Test
	public void testFindAll() {
		List<Vendor> vendors = (List<Vendor>) repository.findAll();
		assertEquals(6, vendors.size());
	}
	
	@Test
	public void testFindById() {
		Vendor vendor = repository.findById(5l).get();
		assertEquals("Dipesh", vendor.getName());
	}

}
