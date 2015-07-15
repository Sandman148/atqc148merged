package com.softserve.edu.oms.data;

/**
 * @author Andrew
 *
 */
public class ProductRepository {
	
	//Test data for products @Item Management page
	
	public static IProduct getSearchProductOne() {
		return Product.get()
			.setProductName("tomato")
			.setProductDescription("tasty")
			.setProductPrice("2")
			.setProductCount("1")
			.build();
	}
	
	public static IProduct getSearchProductTwo() {
		return Product.get()
			.setProductName("productName")
			.setProductDescription("productDescription")
			.setProductPrice("1")
			.setProductCount("9")
			.build();
	}
	
	public static IProduct getInvalidProduct() {
		return Product.get()
			.setProductName("Name")
			.setProductDescription("Description")
			.setProductPrice("1")
			.setProductCount("0")
			.build();
	}
	
	public static IProduct getSearchProductThree() {
		return Product.get()
			.setProductName("brains")
			.setProductDescription("ugly")
			.setProductPrice("3")
			.setProductCount("1")
			.build();
	}
	
	public static IProduct getSearchProductFour() {
		return Product.get()
			.setProductName("bear")
			.setProductDescription("i like it")
			.setProductPrice("4")
			.setProductCount("1")
			.build();
	}
	
	public static IProduct getSearchProductFive() {
		return Product.get()
			.setProductName("sweets")
			.setProductDescription("very nice")
			.setProductPrice("5")
			.setProductCount("1")
			.build();
	}	
	
	public static IProduct getProductNameOne() {
		return Product.get()
			.setProductName("productName1")
			.setProductDescription("productDescription1")
			.setProductPrice("1")
			.setProductCount("1")
			.build();
	}
	
	public static IProduct getProductNameFive() {
		return Product.get()
			.setProductName("productName5")
			.setProductDescription("productDescription5")
			.setProductPrice("5")
			.setProductCount("1")
			.build();
	}	
	
	public static IProduct getProductNameSix() {
		return Product.get()
			.setProductName("productName6")
			.setProductDescription("productDescription6")
			.setProductPrice("1")
			.setProductCount("1")
			.build();
	}	
	
	public static IProduct getProductNameTen() {
		return Product.get()
			.setProductName("productNam10")
			.setProductDescription("productDescription10")
			.setProductPrice("5")
			.setProductCount("1")
			.build();
	}	
	
//	public static IProduct getProductFromProperties() {
//		return (new PropertiesProduct()).getProduct();
//	}
//
//	public static List<IProduct> getAllProductsFromCSV() {
//		return (new CSVProducts()).getAllProducts();
//	}
//
//	public static List<IProduct> getAllProductsFromExcel() {
//		return (new ExcelProducts()).getAllProducts();
//	}

}
