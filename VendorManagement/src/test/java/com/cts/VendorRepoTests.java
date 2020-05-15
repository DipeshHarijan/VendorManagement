package com.cts;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.cts.entity.Vendor;
import com.cts.repository.VendorRepository;


@SpringBootTest
@RunWith(SpringRunner.class)
public class VendorRepoTests {
	
	

	
	@MockBean
	private VendorRepository repo;

	@Test
	public void findByTest() {
		Vendor vendor=new Vendor(1L,"Name","city","7995174182","name@gmail.com");
		when( repo.findById(1L)).thenReturn((vendor));
		assertSame(1L, repo.findById(vendor.getVendorId()).getVendorId());

	}
	@SuppressWarnings("unchecked")
	@Test
	public void findallTest() {
	@SuppressWarnings("rawtypes")
	List vendor=new LinkedList();
	vendor.add(new Vendor(1,"Name","city","7995174182","name@gmail.com"));
	vendor.add(new Vendor(2,"Name as","city as","7095174182","nameas@gmail.com"));
		when( repo.findAll()).thenReturn(vendor);
		List result=(List) repo.findAll();
		verify(repo).findAll();

	}
	
			
	}



