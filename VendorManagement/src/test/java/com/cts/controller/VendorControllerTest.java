package com.cts.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.cts.entity.Vendor;
import com.cts.service.VendorService;


@RunWith(SpringRunner.class)
@WebMvcTest(VendorController.class)
public class VendorControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private VendorService vendorService;
	
	@Test
	public void getAllTest() throws Exception{
		when(vendorService.getAll()).thenReturn(
				Arrays.asList(new Vendor(1,"Vendor1","City1","8272828873","vendor@gmail.com")));
		
		RequestBuilder request = MockMvcRequestBuilders
				.get("/vendor/getAll")
				.accept(MediaType.APPLICATION_JSON);
		
		MvcResult result = mockMvc.perform(request)
				.andExpect(status().isOk())
				.andExpect(content().json("[{vendorId:1,vendorName:Vendor1,city:City1,mobileNo:\"8272828873\",emailId:vendor@gmail.com}]"))
				.andReturn();
	}
	
	@Test
	public void getVendorByIdTest() throws Exception{
		when(vendorService.getVendorById(1)).thenReturn(new Vendor(1,"Vendor1","City1","8272828873","vendor@gmail.com"));
		
		RequestBuilder request = MockMvcRequestBuilders
				.get("/vendor/{vendorId}",1)
				.accept(MediaType.APPLICATION_JSON);
		
		MvcResult result = mockMvc.perform(request)
				.andExpect(status().isOk())
				.andExpect(content().json("{vendorId:1,vendorName:Vendor1,city:City1,mobileNo:\"8272828873\",emailId:vendor@gmail.com}"))
				.andReturn();
	}
	
	@Test
	public void addVendorTest() throws Exception{
		
		
		RequestBuilder request = MockMvcRequestBuilders
				.post("/vendor/add")
				.accept(MediaType.APPLICATION_JSON)
				.content("{\"vendorId\":1000, \"vendorName\": \"Ravi\", \"city\": \"Mirpur\", \"mobileNo\": \"9999999999\", \"emailId\": \"ravi@gmail.com\"}")
				.contentType(MediaType.APPLICATION_JSON);
		
		MvcResult result = mockMvc.perform(request)
				.andExpect(status().is(200))
				.andReturn();
	}
	
	@Test
	public void updateVendorTest() throws Exception{
		
		
		RequestBuilder request = MockMvcRequestBuilders
				.put("/vendor")
				.accept(MediaType.APPLICATION_JSON)
				.content("{\"vendorId\":1000, \"vendorName\": \"Ravi\", \"city\": \"Mirpur\", \"mobileNo\": \"9999999999\", \"emailId\": \"ravi@gmail.com\"}")
				.contentType(MediaType.APPLICATION_JSON);
		
		MvcResult result = mockMvc.perform(request)
				.andExpect(status().is(200))
				.andReturn();
	}
	
	@Test
	public void deleteVendorTest() throws Exception{
		//when(vendorService.getVendorById(1)).thenReturn(new Vendor(1,"Vendor1","City1","8272828873","vendor@gmail.com"));
		//doNothing().when(vendorService.deleteVendor(1));
		
		
		RequestBuilder request = MockMvcRequestBuilders
				.delete("/vendor/delete/{vendorId}",1);
				//.accept(MediaType.APPLICATION_JSON);
		
		MvcResult result = mockMvc.perform(request)
				.andExpect(status().isOk())
				.andReturn();
	}

}
