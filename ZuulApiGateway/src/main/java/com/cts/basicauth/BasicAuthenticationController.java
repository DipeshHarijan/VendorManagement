package com.cts.basicauth;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class BasicAuthenticationController {

	@GetMapping(value = "/basicauth")
	public BasicAuthBean basicAuthentication() {
		return new BasicAuthBean("Login Successful");
	}
}
