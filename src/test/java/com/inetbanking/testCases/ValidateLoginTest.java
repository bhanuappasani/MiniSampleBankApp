package com.inetbanking.testCases;

import com.inetbanking.pageObjects.LoginPage;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ValidateLoginTest extends BaseTest {

    @Test
    public void loginTest() throws IOException{

		/*
		 * driver.get(baseUrl); log.info("Navigate to Login Page");
		 */

        LoginPage lp = new LoginPage(driver);
        lp.setUserName(userName);
        log.info("Provided UserName");
        lp.setPassword(passWord);
        log.info("Provided Password");
        lp.clickLogin();
        log.info("Clicked on Login Button");
        
        if(driver.getTitle().equals("GTPL Bank Manager HomePage")){
            Assert.assertTrue(true);
            log.info("Login Test passed");
        }
        else{
        	captureScreen(driver, "ValidateLoginTest");
            Assert.assertTrue(false);
            log.info("Login Test failed");
        }
    }
}
