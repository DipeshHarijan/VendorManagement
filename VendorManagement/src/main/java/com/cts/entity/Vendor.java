package com.cts.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "This is the vendor model")
@Entity(name = "vendors")
public class Vendor {
	@ApiModelProperty(value = "A unique key for each vendor")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long vendorId;

	@ApiModelProperty(value = "Name of the vendor")
	private String name;

	@ApiModelProperty(value = "Address city of the vendor")
	private String city;

	@ApiModelProperty(value = "10 digit mobile number of vendor")
	private String mobileNo;

	@ApiModelProperty(value = "Email Id of the vendor")
	private String emailId;

	

	public long getVendorId() {
		return vendorId;
	}

	public void setVendorId(long vendorId) {
		this.vendorId = vendorId;
	}

	public Vendor(long vendorId, String name, String city, String mobileNo, String emailId) {
		super();
		this.vendorId = vendorId;
		this.name = name;
		this.city = city;
		this.mobileNo = mobileNo;
		this.emailId = emailId;
	}
	

	public Vendor() {
		super();
	}

	public Vendor(long l) {
		this.vendorId=l;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	@Override
	public String toString() {
		return "Vendor [vendorId=" + vendorId + ", name=" + name + ", city=" + city + ", mobileNo=" + mobileNo
				+ ", emailId=" + emailId + "]";
	}

}
