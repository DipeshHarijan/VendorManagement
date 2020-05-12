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
public class VendorServiceTest {

	@Mock
	private VendorRepository repo;

	@InjectMocks
	private VendorService service;

	@Test
	public void addVendorTest(){
	      Vendor vendor=new Vendor(1L, "Mahadeva","Gadag","8971364833","mahadeva@gmail.com");
	      Mockito.when(repo.save(vendor)).thenReturn(vendor);	
	      assertSame("Gadag" ,service.addVendor(vendor).getCity());
	}

	@Test
	public void getVendorByIdTest() {
		Vendor vendor=new Vendor(1L, "Mahadeva","Gadag","8971364833","mahadeva@gmail.com");
		Mockito.when(repo.findById(1L)).thenReturn(Optional.of(vendor));
		assertSame("mahadeva@gmail.com", service.getVendorById(vendor.getVendorId()).getEmailId());
	}

	@Test
	public void updateVendorTest() {
		Vendor vendor=new Vendor(1L, "Mahadeva","Gadag","8971364833","mahadeva@gmail.com");
	      Mockito.when(repo.save(vendor)).thenReturn(vendor);	
	      assertSame("8971364833",service.updateVendor(vendor).getMobileNo());
	}


}