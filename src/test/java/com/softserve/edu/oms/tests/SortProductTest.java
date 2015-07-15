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
import com.softserve.edu.oms.spans.StartApplication;

/**
 * @author Andrew
 *
 */
public class SortProductTest {

	@DataProvider
	public Object[][] sortByNameProvider() {
		return new Object[][] { {
				BrowserRepository.getFirefoxByTemporaryProfile(),
//				Urls.SSU_HOST.toString(),
				Urls.LOCAL_HOST.toString(),
				ProductRepository.getSearchProductOne(),
				ProductRepository.getSearchProductThree(),
				ProductRepository.getSearchProductFour(),
				ProductRepository.getSearchProductFive()}
		// { BrowserRepository.getChromeByTemporaryProfile() }
		};
	}

	@Test(dataProvider = "sortByNameProvider")
	public void checkSortItemsByName(IBrowser browser, String url, 
			IProduct searchProductOne, IProduct searchProductThree, 
			IProduct searchProductFour, IProduct searchProductFive) throws InterruptedException {
		
		// Preconditions - load OMS, login as Supervisor, click Item Management tab
		ItemManagementPageLogic itemManagementPageLogic = StartApplication.load(browser, url)
				  .successSupervisorLogin(UserRepository.getSupervisorUser()).
				  gotoItemManagement();
			
		//Steps - click name header
		itemManagementPageLogic.sortProductsByName();
							
		// Check
		
		 AssertWrapper.get()
	 		.forElement(itemManagementPageLogic.getItemManagementPage().getName())
	 			.isVisible()
	 			.valueMatch(searchProductFour.getProductName());
		 
		 AssertWrapper.get()
	 		.forElement(itemManagementPageLogic.getItemManagementPage().getNameTwo())
	 			.isVisible()
	 			.valueMatch(searchProductThree.getProductName()); 
		
//		Assert.assertEquals(searchProductFour.getProductName(),
//				itemManagementPageLogic.getItemManagementPage().getName().getText());
//		Assert.assertEquals(searchProductThree.getProductName(),
//				itemManagementPageLogic.getItemManagementPage().getNameTwo().getText());
		
		//Steps - click name header again
		itemManagementPageLogic.sortProductsByName();
		
		//Check
		
		AssertWrapper.get()
 			.forElement(itemManagementPageLogic.getItemManagementPage().getName())
 				.isVisible()
 				.valueMatch(searchProductOne.getProductName());
	 
		AssertWrapper.get()
 			.forElement(itemManagementPageLogic.getItemManagementPage().getNameTwo())
 				.isVisible()
 				.valueMatch(searchProductFive.getProductName());
		
//		Assert.assertEquals(searchProductOne.getProductName(),
//				itemManagementPageLogic.getItemManagementPage().getName().getText());
//		Assert.assertEquals(searchProductFive.getProductName(),
//				itemManagementPageLogic.getItemManagementPage().getNameTwo().getText());

		// Return to previous state
		itemManagementPageLogic.logout();
		
		// Assert
		  AssertWrapper.get().check();
	}
	
	@DataProvider
	public Object[][] sortByPriceProvider() {
		return new Object[][] { {
				BrowserRepository.getFirefoxByTemporaryProfile(),
//				Urls.SSU_HOST.toString(),
				Urls.LOCAL_HOST.toString(),
				ProductRepository.getProductNameOne(),
				ProductRepository.getProductNameFive(),
				ProductRepository.getProductNameSix(),
				ProductRepository.getProductNameTen()}
		// { BrowserRepository.getChromeByTemporaryProfile() }
		};
	}

	@Test(dataProvider = "sortByPriceProvider")
	public void checkSortItemsByPrice(IBrowser browser, String url, 
			IProduct productNameOne, IProduct productNameFive, 
			IProduct productNameSix, IProduct productNameTen) throws InterruptedException {
		
		// Preconditions - load OMS, login as Supervisor, click Item Management tab
		ItemManagementPageLogic itemManagementPageLogic = StartApplication.load(browser, url)
				  .successSupervisorLogin(UserRepository.getSupervisorUser()).
				  gotoItemManagement();
		
		//Steps - click price header
		itemManagementPageLogic.sortProductsByPrice();
					
		// Check
		
		 AssertWrapper.get()
	 		.forElement(itemManagementPageLogic.getItemManagementPage().getName())
	 			.isVisible()
	 			.valueMatch(productNameOne.getProductName());
		 
		 AssertWrapper.get()
	 		.forElement(itemManagementPageLogic.getItemManagementPage().getNameTwo())
	 			.isVisible()
	 			.valueMatch(productNameSix.getProductName());
		
//		Assert.assertEquals(productNameOne.getProductName(),
//				itemManagementPageLogic.getItemManagementPage().getName().getText());
//		Assert.assertEquals(productNameSix.getProductName(),
//				itemManagementPageLogic.getItemManagementPage().getNameTwo().getText());
		
		//Steps - click price header again
		itemManagementPageLogic.sortProductsByPrice();
		
		//Check
		
		 AssertWrapper.get()
	 		.forElement(itemManagementPageLogic.getItemManagementPage().getName())
	 			.isVisible()
	 			.valueMatch(productNameFive.getProductName());
		 
		 AssertWrapper.get()
	 		.forElement(itemManagementPageLogic.getItemManagementPage().getNameTwo())
	 			.isVisible()
	 			.valueMatch(productNameTen.getProductName());
		
//		Assert.assertEquals(productNameFive.getProductName(),
//				itemManagementPageLogic.getItemManagementPage().getName().getText());
//		Assert.assertEquals(productNameTen.getProductName(),
//				itemManagementPageLogic.getItemManagementPage().getNameTwo().getText());
		
		// Return to previous state
		itemManagementPageLogic.logout();
		
		// Assert
		  AssertWrapper.get().check();
	}
			
	@AfterSuite
	public static void tearDownAfterClass() throws Exception {
		WebDriverUtils.get().stop();
	}

}
