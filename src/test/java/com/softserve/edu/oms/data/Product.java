package com.softserve.edu.oms.data;

interface IProductName {
	IProductDescription setProductName(String productName);
}

interface IProductDescription {
	IProductPrice setProductDescription(String productDescription);
}

interface IProductPrice {
	IProductCount setProductPrice(String productPrice);
}

interface IProductCount {
	IProductBuild setProductCount(String productCount);
}

interface IProductBuild {
	IProduct build();
}

/**
 * @author Andrew
 *
 */
public class Product implements IProductName, IProductDescription, IProductPrice, IProductCount, IProductBuild, IProduct {
	
	private String productName;
	private String productDescription;
	private String productPrice;
	private String productCount;
	
	private Product(){
	}
	
	private Product(String productName, String productDescription, String productPrice, String productCount) {
		this.productName = productName;
		this.productDescription = productDescription;
		this.productPrice = productPrice;
		this.productCount = productCount;
	}

	public static IProductName get() {
		return new Product();
	}
	
	public IProductDescription setProductName(String productName) {
		this.productName = productName;
		return this;
	}

	public IProductPrice setProductDescription(String productDescription) {
		this.productDescription = productDescription;
		return this;
	}
	
	public IProductCount setProductPrice(String productPrice) {
		this.productPrice = productPrice;
		return this;
	}	

	public IProductBuild setProductCount(String productCount) {
		this.productCount = productCount;
		return this;
	}

	public IProduct build() {
		return this;
	}

	// - - - - - - - - - - - - - - - - - - - -

	public String getProductName() {
		return productName;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public String getProductPrice() {
		return productPrice;
	}
	
	public String getProductCount() {
		return productCount;
	}

}
