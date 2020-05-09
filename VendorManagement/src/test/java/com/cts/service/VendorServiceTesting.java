package com.cts.service;


import static org.junit.Assert.assertSame;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.cts.entity.Vendor;
import com.cts.repository.VendorRepository;

@RunWith(MockitoJUnitRunner.Silent.class)
public class VendorServiceTesting {
	
	@Mock
	private VendorRepository repo;
	
	@InjectMocks
	private VendorService service;
	
	@Test
	public void addVendorTest(){
	      Vendor vendor=new Vendor(1L, "Mahadeva","Gadag","8971364833","mahadeva@gmail.com");
	      Mockito.when(repo.save(vendor)).thenReturn(vendor);	
	      assertSame(1L,service.addVendor(vendor).getVendorId());
	}

	@Test
	public void getVendorByIdTest() {
		Vendor vendor=new Vendor(1L, "Mahadeva","Gadag","8971364833","mahadeva@gmail.com");
		Mockito.when(repo.findById(1L)).thenReturn(Optional.of(vendor));
		assertSame(1L, service.getVendorById(vendor.getVendorId()).getVendorId());
	}
	
	@Test
	public void updateVendorTest() {
		Vendor vendor=new Vendor(1L, "Mahadeva","Gadag","8971364833","mahadeva@gmail.com");
	      Mockito.when(repo.save(vendor)).thenReturn(vendor);	
	      assertSame(1L,service.addVendor(vendor).getVendorId());
	}

	
}

//Service testing is done
	
	

	
	
	
	
	
	
	
	
	
	
