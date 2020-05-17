package com.cts.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "This is the product model")
public class Product {

	@ApiModelProperty(value = "A unique key for each product")
	private long productId;

	@ApiModelProperty(value = "A unique name for each product")
	private String productName;

	@ApiModelProperty(value = "Description of the product")
	private String productDescription;

	@ApiModelProperty(value = "Price of the product")
	private float price;

	@ApiModelProperty(value = "A unique key for each vendor")
	private long vendorId;

	public Product(long productId, String productName, String productDescription, float price) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productDescription = productDescription;
		this.price = price;
	}

}
