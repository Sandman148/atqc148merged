package com.softserve.edu.oms.tests;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.softserve.edu.atqc.span.AssertWrapper;
import com.softserve.edu.atqc.tools.BrowserRepository;
import com.softserve.edu.atqc.tools.IBrowser;
import com.softserve.edu.atqc.tools.WebDriverUtils;
import com.softserve.edu.oms.data.IProduct;
import com.softserve.edu.oms.data.ProductRepository;
import com.softserve.edu.oms.data.UrlRepository.Urls;
import com.softserve.edu.oms.data.UserRepository;
import com.softserve.edu.oms.logics.ItemManagementPageLogic;
import com.softserve.edu.oms.pages.ItemManagementPage.ItemManagementPageFields;
import com.softserve.edu.oms.spans.StartApplication;

/**
 * @author Andrew
 *
 */
public class SearchProductTest {
	
	@DataProvider
	public Object[][] productNameOneProvider() {
		return new Object[][] { {
				BrowserRepository.getFirefoxByTemporaryProfile(),
//				Urls.SSU_HOST.toString(),
				Urls.LOCAL_HOST.toString(),
				ProductRepository.getSearchProductOne()},
		// { BrowserRepository.getChromeByTemporaryProfile() }
		};
	}

	@Test(dataProvider = "productNameOneProvider")
	public void checkSearchProductByNameOne(IBrowser browser, String url, 
			IProduct searchProductOne) throws InterruptedException {
		
		// Preconditions - load OMS, login as Supervisor, click Item Management tab
		ItemManagementPageLogic itemManagementPageLogic = StartApplication.load(browser, url)
				  .successSupervisorLogin(UserRepository.getSupervisorUser()).
				  gotoItemManagement();
		
		// Steps - search product One by name
		itemManagementPageLogic.searchProductByName(ItemManagementPageFields.PRODUCT_NAME, 
				searchProductOne);
			
		// Check
		 AssertWrapper.get()
		 		.forElement(itemManagementPageLogic.getItemManagementPage().getName())
		 			.isVisible()
		 			.valueMatch(searchProductOne.getProductName());
	 
		// Return to previous state
		itemManagementPageLogic.logout();
		
		// Assert
		  AssertWrapper.get().check();
	}
	
	@DataProvider
	public Object[][] productNameTwoProvider() {
		return new Object[][] { {
				BrowserRepository.getFirefoxByTemporaryProfile(),
//				Urls.SSU_HOST.toString(),
				Urls.LOCAL_HOST.toString(),
				ProductRepository.getSearchProductTwo()},
		// { BrowserRepository.getChromeByTemporaryProfile() }
		};
	}

	@Test(dataProvider = "productNameTwoProvider")
	public void checkSearchProductByPartialName(IBrowser browser, String url, 
			IProduct searchProductTwo) throws InterruptedException {
		
		// Preconditions - load OMS, login as Supervisor, click Item Management tab
		ItemManagementPageLogic itemManagementPageLogic = StartApplication.load(browser, url)
				  .successSupervisorLogin(UserRepository.getSupervisorUser()).
				  gotoItemManagement();
		
		// Steps - search product Two by name
		itemManagementPageLogic.searchProductByName(ItemManagementPageFields.PRODUCT_NAME,
				searchProductTwo); 
				
		// Check
		AssertWrapper.get()
 				.forElement(itemManagementPageLogic.getItemManagementPage().getName().getText().substring(0, 11))
// 					.isVisible()
 					.valueMatch(searchProductTwo.getProductName());
		// Return to previous state
		itemManagementPageLogic.logout();

		// Assert
		  AssertWrapper.get().check();
	}
	
	@DataProvider
	public Object[][] productDescriptionProvider() {
		return new Object[][] { {
				BrowserRepository.getFirefoxByTemporaryProfile(),
//				Urls.SSU_HOST.toString(),
				Urls.LOCAL_HOST.toString(),
				ProductRepository.getSearchProductThree()},
		// { BrowserRepository.getChromeByTemporaryProfile() }
		};
	}
	
	@Test(dataProvider = "productDescriptionProvider")
	public void checkSearchProductByDescriptionOne(IBrowser browser, String url, 
			IProduct searchProductThree) throws InterruptedException {
		
		// Preconditions - load OMS, login as Supervisor, click Item Management tab
		ItemManagementPageLogic itemManagementPageLogic = StartApplication.load(browser, url)
				  .successSupervisorLogin(UserRepository.getSupervisorUser()).
				  gotoItemManagement();
		
		// Steps - search product Three by description
		itemManagementPageLogic.searchProductByDescription(ItemManagementPageFields.DESCRIPTION, 
				searchProductThree);
		
		// Check
		 AssertWrapper.get()
	 			.forElement(itemManagementPageLogic.getItemManagementPage().getName())
	 				.isVisible()
	 				.valueMatch(searchProductThree.getProductName());
		 
		// Return to previous state
		itemManagementPageLogic.logout();
		
		// Assert
		  AssertWrapper.get().check();
	}
	
	@DataProvider
	public Object[][] invalidProductNameProvider() {
		return new Object[][] { {
				BrowserRepository.getFirefoxByTemporaryProfile(),
//				Urls.SSU_HOST.toString(),
				Urls.LOCAL_HOST.toString(),
				ProductRepository.getInvalidProduct()},
		// { BrowserRepository.getChromeByTemporaryProfile() }
		};
	}
	
	@Test(dataProvider = "invalidProductNameProvider")
	public void checkInvalidSearchProduct(IBrowser browser, String url,
			IProduct invalidProduct) throws InterruptedException {
		
		// Preconditions - load OMS, login as Supervisor, click Item Management tab
		ItemManagementPageLogic itemManagementPageLogic = StartApplication.load(browser, url)
				  .successSupervisorLogin(UserRepository.getSupervisorUser()).
				  gotoItemManagement();
		
		// Steps - search invalid product by name
		itemManagementPageLogic.searchProductByName(ItemManagementPageFields.PRODUCT_NAME,
				invalidProduct);
		
		// Check		
		AssertWrapper.get()
 				.forElement(itemManagementPageLogic.getItemManagementPage().getProductsFound())
 					.isVisible()
 					.valueMatch(invalidProduct.getProductCount());
		
		// Return to previous state
		itemManagementPageLogic.logout();

	}
			
	@AfterSuite
	public static void tearDownAfterClass() throws Exception {
		WebDriverUtils.get().stop();
	}

}
