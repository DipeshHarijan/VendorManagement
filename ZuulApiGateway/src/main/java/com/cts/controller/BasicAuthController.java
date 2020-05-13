package com.cts.controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cts.ZuulApiGatewayApplication;
@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("/vendor")
public class BasicAuthController {

	@GetMapping(path = "/basicauth")
	public ZuulApiGatewayApplication Bean() {
		return new ZuulApiGatewayApplication ();
	}	
}