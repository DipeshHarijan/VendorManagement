package com.cts.entity;


import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.cts.model.Product;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
//import lombok.Data;

//@Data
@ApiModel(description = "This is the vendor model")
@Entity(name = "vendors")
public class Vendor {
	@ApiModelProperty(value = "A unique key for each vendor")
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long vendorId;

	@ApiModelProperty(value = "Name of the vendor")
	@NotNull(message = "Name cannot be null")
	@Pattern(regexp = "[a-zA-Z]{2}[A-Za-z\\s]*", message = "name can only have alphabets with minimum length 2")
	@Size(min = 2, message = "name must have atleast 2 characters")
	private String vendorName;

	@Pattern(regexp = "[a-zA-Z]{2}[A-Za-z\\s]*", message = "city can only have alphabets")
	@ApiModelProperty(value = "Address city of the vendor")
	private String city;

	@ApiModelProperty(value = "10 digit mobile number of vendor")
	@Pattern(regexp = "[1-9]{1}[0-9]{9}", message = "mobile number must be of 10 digits and should not begin with 0")
	private String mobileNo;

	@Email
	@ApiModelProperty(value = "Email Id of the vendor")
	private String emailId;

	@Transient
	private List<Product> products;

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public long getVendorId() {
		return vendorId;
	}

	public void setVendorId(long vendorId) {
		this.vendorId = vendorId;
	}

	public Vendor(long vendorId, String vendorName, String city, String mobileNo, String emailId) {
		super();
		this.vendorId = vendorId;
		this.vendorName = vendorName;
		this.city = city;
		this.mobileNo = mobileNo;
		this.emailId = emailId;
	}

	public Vendor() {
		super();
	}

	public Vendor(long l) {
		this.vendorId = l;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getVendorName() {
		return vendorName;
	}

	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

}
