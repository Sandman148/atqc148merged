package com.softserve.edu.oms.pages;

import com.softserve.edu.atqc.controls.ILabel;
import com.softserve.edu.atqc.controls.ILabelClickable;
import com.softserve.edu.atqc.controls.ILink;
import com.softserve.edu.atqc.controls.ISelect;
import com.softserve.edu.atqc.controls.ITextField;
import com.softserve.edu.atqc.controls.Label;
import com.softserve.edu.atqc.controls.LabelClickable;
import com.softserve.edu.atqc.controls.Link;
import com.softserve.edu.atqc.controls.Select;
import com.softserve.edu.atqc.controls.TextField;

/**
 * @author Andrew
 *
 */
public class ItemManagementPage {

	public static enum ItemManagementPageFields {
		PRODUCT_NAME("Product Name"), 
		DESCRIPTION("Description");
		private String field;

		private ItemManagementPageFields(String field) {
			this.field = field;
		}

		@Override
		public String toString() {
			return this.field;
		}
	}
	
	private class ItemManagementPageUIMap {
		public final ILink addProduct;
		public final ISelect field;
		public final ITextField searchField;
		public final ILink logout;

		public ItemManagementPageUIMap() {
			this.addProduct = Link.getByPartialLinkText("Add Product");
			this.field = Select.getById("field");
			this.searchField = TextField.getById("searchField");
			this.logout = Link.getByXpath("//a[@href='/OMS/logout.htm']");
		}
	}
	
	private class ItemManagementPageUIMapAjax {
		public final ILabel productsFound;
		private ILabel name;
		private ILabel description;
		private ILabel price;
		private ILabel nameTwo;
		private ILabel descriptionTwo;
		private ILabel priceTwo;
		private ILabelClickable nameHeader;
		private ILabelClickable descriptionHeader;
		private ILabelClickable priceHeader;

		public ItemManagementPageUIMapAjax() {
			this.productsFound = Label.getById("recordsFound");
			
			if (Integer.parseInt(productsFound.getText()) == 0) {
				this.nameHeader = LabelClickable.getByXpath("//thead/tr/th[1]/a");
				this.descriptionHeader = LabelClickable.getByXpath("//thead/tr/th[2]/a");
				this.priceHeader = LabelClickable.getByXpath("//thead/tr/th[3]/a");
			}else if (Integer.parseInt(productsFound.getText()) == 1) {
				this.nameHeader = LabelClickable.getByXpath("//thead/tr/th[1]/a");
				this.descriptionHeader = LabelClickable.getByXpath("//thead/tr/th[2]/a");
				this.priceHeader = LabelClickable.getByXpath("//thead/tr/th[3]/a");
				this.name = Label.getByXpath("//tbody/tr[1]/td[1]");
//				this.name = Label.getByXpath(".//*[@id='table']/tbody/tr[1]/td[1]");
				this.description = Label.getByXpath("//tbody/tr[1]/td[2]");
				this.price = Label.getByXpath("//tbody/tr[1]/td[3]");
			}else{	
				this.name = Label.getByXpath("//tbody/tr[1]/td[1]");
//				this.name = Label.getByXpath(".//*[@id='table']/tbody/tr[1]/td[1]");
				this.description = Label.getByXpath("//tbody/tr[1]/td[2]");
				this.price = Label.getByXpath("//tbody/tr[1]/td[3]");
				this.nameTwo = Label.getByXpath("//tbody/tr[2]/td[1]");
				this.descriptionTwo = Label.getByXpath("//tbody/tr[2]/td[2]");
				this.priceTwo = Label.getByXpath("//tbody/tr[2]/td[3]");
				this.nameHeader = LabelClickable.getByXpath("//thead/tr/th[1]/a");
				this.descriptionHeader = LabelClickable.getByXpath("//thead/tr/th[2]/a");
				this.priceHeader = LabelClickable.getByXpath("//thead/tr/th[3]/a");
			}

//TODO				this.delete = Link.getByXpath("//thead/tr[1]/th[1]");
			
		}

		public ItemManagementPageUIMapAjax(String name) {
			this.productsFound = Label.getById("recordsFound");
		
			//TODO check the xpathes
//			this.name = Label.getByXpath("//tbody//td[3][text()='" + name + "']/preceding-sibling::td[2]");
//			this.description = Label.getByXpath("//tbody//td[3][text()='" + name + "']/preceding-sibling::td[1]");
//			this.price = Label.getByXpath("//tbody//td[3][text()='" + name + "']");
			
//			this.name = Label.getByXpath("//tbody/tr[1]/td[1]");
//			this.description = Label.getByXpath("//tbody/tr[1]/td[2]");
//			this.price = Label.getByXpath("//tbody/tr[1]/td[3]");
			
			if (Integer.parseInt(productsFound.getText()) == 0) {
				this.nameHeader = LabelClickable.getByXpath("//thead/tr/th[1]/a");
				this.descriptionHeader = LabelClickable.getByXpath("//thead/tr/th[2]/a");
				this.priceHeader = LabelClickable.getByXpath("//thead/tr/th[3]/a");
			}else if (Integer.parseInt(productsFound.getText()) == 1) {
				this.nameHeader = LabelClickable.getByXpath("//thead/tr/th[1]/a");
				this.descriptionHeader = LabelClickable.getByXpath("//thead/tr/th[2]/a");
				this.priceHeader = LabelClickable.getByXpath("//thead/tr/th[3]/a");
				this.name = Label.getByXpath("//tbody/tr[1]/td[1]");
//				this.name = Label.getByXpath(".//*[@id='table']/tbody/tr[1]/td[1]");
				this.description = Label.getByXpath("//tbody/tr[1]/td[2]");
				this.price = Label.getByXpath("//tbody/tr[1]/td[3]");
			}else{	
				this.name = Label.getByXpath("//tbody/tr[1]/td[1]");
//				this.name = Label.getByXpath(".//*[@id='table']/tbody/tr[1]/td[1]");
				this.description = Label.getByXpath("//tbody/tr[1]/td[2]");
				this.price = Label.getByXpath("//tbody/tr[1]/td[3]");
				this.nameTwo = Label.getByXpath("//tbody/tr[2]/td[1]");
				this.descriptionTwo = Label.getByXpath("//tbody/tr[2]/td[2]");
				this.priceTwo = Label.getByXpath("//tbody/tr[2]/td[3]");
				this.nameHeader = LabelClickable.getByXpath("//thead/tr/th[1]/a");
				this.descriptionHeader = LabelClickable.getByXpath("//thead/tr/th[2]/a");
				this.priceHeader = LabelClickable.getByXpath("//thead/tr/th[3]/a");
			}
								
		}

	}

	// Elements
    private ItemManagementPageUIMap controls;
	// AJAX Elements
    private ItemManagementPageUIMapAjax controlsAjax;
	// Alert Elements
	//private IAlertLight controlsAlert = null;

    public ItemManagementPage() {
        controls = new ItemManagementPageUIMap();
        controlsAjax = new ItemManagementPageUIMapAjax();
    }
	
    // getters controls

   	public ILink getAddProduct() {
   		return this.controls.addProduct;
   	}

   	public ISelect getField() {
   		return this.controls.field;
   	}

   	public ITextField getSearchField() {
   		return this.controls.searchField;
   	}

   	public ILink getLogout() {
   		return this.controls.logout;
   	}
   	   	
 // getters controlsAjax

 	public ILabel getProductsFound() {
 		return this.controlsAjax.productsFound;
 	}

 	public ILabel getName() {
 		return this.controlsAjax.name;
 	}

 	public ILabel getDescription() {
 		return this.controlsAjax.description;
 	}

 	public ILabel getPrice() {
 		return this.controlsAjax.price;
 	}
 		
	public ILabel getNameTwo() {
		return this.controlsAjax.nameTwo;
	}

	public ILabel getDescriptionTwo() {
		return this.controlsAjax.descriptionTwo;
	}

	public ILabel getPriceTwo() {
		return this.controlsAjax.priceTwo;
	}
		
	public ILabelClickable getNameHeader() {
		return this.controlsAjax.nameHeader;
	}

	public ILabelClickable getDescriptionHeader() {
		return this.controlsAjax.descriptionHeader;
	}

	public ILabelClickable getPriceHeader() {
		return this.controlsAjax.priceHeader;
	}
	
	// public WebElement getSearchButton() {
	// return searchButton;
	// }

	// setters controls

	public void addProductClick() {
		this.controls.addProduct.click();
	}

	public void selectColumnFields(ItemManagementPageFields field) {
		this.controls.field.selectByVisibleText(field.toString());
	}
	
	public void searchFieldClick() {
		this.controls.searchField.click();
	}

	public void searchFieldClear() {
		this.controls.searchField.clear();
	}

	public void searchFieldSendKeys(String text) {
		this.controls.searchField.sendKeys(text);
	}

	public void logoutClick() {
		this.controls.logout.click();
	}
	
	// setters controlsAjax

	public void resetTable() {
		if (this.controlsAjax.name.isStalenessOf()) {
			controlsAjax = new ItemManagementPageUIMapAjax();
		}
	}
		
	public void resetTable(String name) {
		if (this.controlsAjax.name.isStalenessOf()) {
			controlsAjax = new ItemManagementPageUIMapAjax(name);
		}
	}
	
	public void resetPage() {
		if (this.controls.logout.isStalenessOf()) {
			controls = new ItemManagementPageUIMap();
		}
	}
		
//	public void resetPage(String name) {
// (this.controlsAjax.name.isStalenessOf()) {
//			controlsAjax = new ItemManagementPageUIMapAjax(name);
//		}
//	}

//TODO develop delete click	
//	public void deleteClick() {
//		this.controlsAjax.delete.click();
//		// this.controlsAlert = new Alert();
//	}
	
	public void alertAccept() {
//		if (this.controlsAlert != null) {
//		this.controlsAlert.click();
//		this.controlsAlert = null;
//        controls = new ItemManagementPageUIMap();
//        controlsAjax = new ItemManagementPageUIMapAjax();
//	}
	}

	public void alertDismiss() {
//		if (this.controlsAlert != null) {
//			this.controlsAlert.click();
//			this.controlsAlert = null;
//		}
	}	
	
}
