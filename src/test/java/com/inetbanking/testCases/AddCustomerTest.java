package com.inetbanking.testCases;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.AddCustomerPage;
import com.inetbanking.pageObjects.LoginPage;

public class AddCustomerTest extends BaseTest {
	
	@Test
	public void addNewCustomer() throws InterruptedException, IOException {
		
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(userName);
		log.info("User name is provided");
		lp.setPassword(passWord);
		log.info("Password is provided");
		lp.clickLogin();
		
		AddCustomerPage addCust = new AddCustomerPage(driver);
		
		addCust.setNewCustomer();
		log.info("Provide Customer details");
		
		addCust.setCustomerName("Bhanu");
		addCust.setGender("male");
		addCust.setCustdob("01", "03", "84");
		addCust.setCustAddress("India");
		addCust.setCustCity("Hyd");
		addCust.setCustState("Tel");
		addCust.setCustPinno("500084");
		addCust.setCustTelephoneno("9885578478");
		String email = randomestring()+"@gmail.com";
		addCust.setCustEmailid(email);
		addCust.setCustSubmit();
		
		log.info("Validation process started");
		
		boolean res = driver.getPageSource().contains("Customer Registered Successfully!!!");
		
		if(res == true) {
			Assert.assertTrue(true);
			log.info("Test case passed....");
		}
		else {
			log.info("Test case failed...");
			captureScreen(driver, "AddCustomerTest");
			Assert.assertTrue(false);
		}
		
	}
	
}
