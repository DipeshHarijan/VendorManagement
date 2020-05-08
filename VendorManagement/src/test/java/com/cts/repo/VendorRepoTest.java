package com.cts.repo;


import static org.assertj.core.api.Assertions.linesOf;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.cts.entity.Vendor;
import com.cts.repository.VendorRepository;


@SpringBootTest
@RunWith(SpringRunner.class)
public class VendorRepoTest {

	@MockBean
	private VendorRepository repo;

	@Test
	public void findByTest() {
		Vendor vendor=new Vendor(1L,"nikhila damraju","elr","7995172182","nikki@gmail.com");
		when( repo.findById(1L)).thenReturn(Optional.of(vendor));		
	}
	@SuppressWarnings("unchecked")
	@Test
	public void findallTest() {
	List vendor=new LinkedList();
		 vendor.add(new Vendor(1L,"nikhila","vjy","7999999182","nikki@gmail.com"));
		 vendor.add(new Vendor(2L,"poonam","hyd","7999992142","poonam@gmail.com"));
		when( repo.findAll()).thenReturn(vendor);
		Iterable<Vendor> result=repo.findAll();
		verify(repo).findAll();
				
			
	}

}