package com.cts;

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
public class VendorRepoTests {
	
	
//	private VendorService service;
	
	
	@MockBean
	private VendorRepository repo;
	
	
	
	@Test
	public void findByTest() {
		Vendor vendor=new Vendor(1L,"Devi Bomma","vizag","7995172182","devi@gmail.com");
		when( repo.findById(1L)).thenReturn(Optional.of(vendor));
				
			
	}
	@SuppressWarnings("unchecked")
	@Test
	public void findallTest() {
	List vendor=new LinkedList();
		 vendor.add(new Vendor(1L,"Devi Bomma","vizag","7995172182","devi@gmail.com"));
		 vendor.add(new Vendor(2L,"satya Bomma","vizag","7995172142","satya@gmail.com"));
		when( repo.findAll()).thenReturn(vendor);
		List result=repo.findAll();
		verify(repo).findAll();
				
			
	}

}
