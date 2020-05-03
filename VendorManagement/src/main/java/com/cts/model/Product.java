package com.cts.model;

public class Product {

	private long productId;

	private String productName;

	private String productDescription;

	private float price;

	private Vendor vendor;

	public Product() {
		super();
	}
	
	

	public Product(long productId, String productName, String productDescription, float price, Vendor vendor2) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productDescription = productDescription;
		this.price = price;
		this.vendor = vendor2;
	}

	public Product(long i, String string, String string2, float j) {
		this.productId = i;
		this.productName = string;
		this.productDescription = string2;
		this.price=j;
	}



	public long getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public Vendor getVendor() {
		return vendor;
	}

	public void setVendor(Vendor vendor) {
		this.vendor = vendor;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", productDescription="
				+ productDescription + ", price=" + price + ", vendor=" + vendor + "]";
	}

}
