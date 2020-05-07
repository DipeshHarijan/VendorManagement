package com.cts.model;

import java.util.List;

import lombok.Data;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Data
@ApiModel(description = "This is the vendor model")
public class Vendor {
	@ApiModelProperty(value = "A unique key for each vendor")
	private long vendorId;

	@ApiModelProperty(value = "Name of the vendor")
	private String name;

	@ApiModelProperty(value = "Address city of the vendor")
	private String city;

	@ApiModelProperty(value = "10 digit mobile number of vendor")
	private String mobileNo;

	@ApiModelProperty(value = "Email Id of the vendor")
	private String emailId;
	
	@ApiModelProperty(value = "List of products by vendor")
	private List<Product> products;

}
