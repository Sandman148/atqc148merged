package com.softserve.edu.oms.logics;

import com.softserve.edu.oms.data.IProduct;
import com.softserve.edu.oms.pages.ItemManagementPage;
import com.softserve.edu.oms.pages.ItemManagementPage.ItemManagementPageFields;
import com.softserve.edu.oms.pages.LoginPage;

/**
 * @author Andrew
 *
 */
public class ItemManagementPageLogic {
	// Elements
	private ItemManagementPage itemManagementPage;

	public ItemManagementPageLogic(ItemManagementPage itemManagementPage) {
		this.itemManagementPage = itemManagementPage;
	}

	// getters

	public ItemManagementPage getItemManagementPage() {
		return itemManagementPage;
	}

	// business

	public AddProductPageLogic gotoAddProductPage() {
		this.itemManagementPage.getAddProduct().click();
		// TODO AddProductPageLogic(new CreateNewUserPage());
		return new AddProductPageLogic();
	}
	
//	public void searchProduct(ItemManagementPageFields field,
//			IProduct product) {
//		this.itemManagementPage.selectColumnFields(field);
//		if (field.toString().equals("PRODUCT_NAME")){
//			this.itemManagementPage.searchFieldSendKeys(product.getProductName());
//		}else{
//			this.itemManagementPage.searchFieldSendKeys(product.getProductDescription());	
//		}
//		// Initialize AJAX Elements
//		this.itemManagementPage.resetTable(product.getProductName());
//	}

	public void searchProductByName(ItemManagementPageFields field,
			IProduct product) {
		this.itemManagementPage.selectColumnFields(field);
		this.itemManagementPage.searchFieldSendKeys(product.getProductName());
		// Initialize AJAX Elements
		this.itemManagementPage.resetTable(product.getProductName());
	}
	
	public void searchProductByDescription(ItemManagementPageFields field,
			IProduct product) {
		this.itemManagementPage.selectColumnFields(field);  
		this.itemManagementPage.searchFieldSendKeys(product.getProductDescription());
		// Initialize AJAX Elements
		this.itemManagementPage.resetTable(product.getProductName());
	}
	
	public void sortProductsByName() {
		this.itemManagementPage.getNameHeader().click(); 
		// Initialize Page Elements
		this.itemManagementPage.resetPage();
		// Initialize AJAX Elements
		this.itemManagementPage.resetTable();
	}
	
	public void sortProductsByPrice() {
		this.itemManagementPage.getPriceHeader().click(); 
		// Initialize Page Elements
		this.itemManagementPage.resetPage();
		// Initialize AJAX Elements
		this.itemManagementPage.resetTable();
	}

//TODO Develop delete product	
//	public void deleteByProductName(IProduct product) {
//		searchByLoginName(ItemManagementPageFields.PRODUCT_NAME, product);
//		this.itemManagementPage.deleteClick();
//		this.itemManagementPage.alertAccept();
//	}
	
	public LoginPageLogic logout() {
		this.itemManagementPage.getLogout().click();
		return new LoginPageLogic(new LoginPage());
	}

}
