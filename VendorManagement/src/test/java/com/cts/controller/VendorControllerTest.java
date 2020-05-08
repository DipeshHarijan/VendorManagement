package com.cts.controller;

import static org.hamcrest.CoreMatchers.containsString;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.*;

import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import org.springframework.test.web.servlet.RequestBuilder;

import static org.hamcrest.core.Is.is;
import com.cts.controller.VendorController;
import com.cts.entity.Vendor;
import com.cts.service.VendorService;
import com.google.common.base.Optional;

@RunWith(SpringRunner.class)
@WebMvcTest(VendorController.class)
public class VendorControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private VendorService vendorService;
	
	@InjectMocks
	private VendorController vendorController;
	 
	@Test
	public void getAllTest() throws Exception{
		when(vendorService.getAll()).thenReturn(
				Arrays.asList(new Vendor(1,"NikhilaDamaraju","hyd","8272456128","nikhila@gmail.com")));
		
		RequestBuilder request = MockMvcRequestBuilders
				.get("/vendor/getAll")
				.accept(MediaType.APPLICATION_JSON);
		
		MvcResult result = mockMvc.perform(request)
				.andExpect(status().isOk())
				.andExpect(content().json("[{vendorId:1,vendorName:NikhilaDamaraju,city:hyd,mobileNo:\"8272456128\",emailId:nikhila@gmail.com}]"))
				.andReturn();
	}
	
//	@Test
//	public void getVendorByIdTest() throws Exception{
//	
//		RequestBuilder request = MockMvcRequestBuilders
//				.get("/vendor/get/1")
//				.accept(MediaType.APPLICATION_JSON)
//				.content("{\"vendorId\":1, \"vendorName\": \"nikki\", \"city\": \"vjy\", \"mobileNo\": \"9999999999\", \"emailId\": \"nikki@gmail.com\"}")
//				.contentType(MediaType.APPLICATION_JSON);
//		
//		MvcResult result = mockMvc.perform(request)
//				.andExpect(status().isOk())
//				.andExpect(content().json("[{vendorId:1,vendorName:nikki,city:vjy,mobileNo:\"9999999999\",emailId:nikki@gmail.com}]"))
//				.andReturn();
//	}
	
	@Test
	public void addVendorTest() throws Exception{
				RequestBuilder request = MockMvcRequestBuilders
				.post("/vendor/add")
				.accept(MediaType.APPLICATION_JSON)
				.content("{\"vendorId\":1, \"vendorName\": \"nikki\", \"city\": \"vjy\", \"mobileNo\": \"9999999999\", \"emailId\": \"nikki@gmail.com\"}")
				.contentType(MediaType.APPLICATION_JSON);
				MvcResult result = mockMvc.perform(request)
				.andExpect(status().is(200))
				.andReturn();
	}
	@Test
	public void deleteVendorTest() throws Exception{
		RequestBuilder request = MockMvcRequestBuilders
				.delete("/vendor/delete/1")
				.accept(MediaType.APPLICATION_JSON)
				.content("{\"vendorId\":1, \"vendorName\": \"nikki\", \"city\": \"vjy\", \"mobileNo\": \"9999999999\", \"emailId\": \"nikki@gmail.com\"}")
				.contentType(MediaType.APPLICATION_JSON);
				MvcResult result = mockMvc.perform(request)
				.andExpect(status().is(200))
				.andReturn();
	}
	@Test
	public void updateVendorTest() throws Exception{
				RequestBuilder request = MockMvcRequestBuilders
				.put("/vendor/update/1")
				.accept(MediaType.APPLICATION_JSON)
				.content("{\"vendorId\":1, \"vendorName\": \"nikki\", \"city\": \"vjy\", \"mobileNo\": \"9999999999\", \"emailId\": \"nikki@gmail.com\"}")
				.contentType(MediaType.APPLICATION_JSON);
				MvcResult result = mockMvc.perform(request)
				.andExpect(status().is(200))
				.andReturn();
	}
	

}