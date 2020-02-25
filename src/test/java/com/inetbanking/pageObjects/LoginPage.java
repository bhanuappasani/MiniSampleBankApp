package com.inetbanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    WebDriver ldriver;

    public LoginPage(WebDriver rdriver){
        ldriver = rdriver;
        PageFactory.initElements(rdriver,this);
    }

    @FindBy(name = "uid")
    @CacheLookup
    WebElement txtUserName;

    @FindBy(name = "password")
    @CacheLookup
    WebElement txtPassword;

    @FindBy(name = "btnLogin")
    @CacheLookup
    WebElement btnLogin;
    
    @FindBy(xpath = "//a[text()='Log out']")
    @CacheLookup
    WebElement logoutlink;

    public void setUserName(String userName){
        txtUserName.sendKeys(userName);
    }

    public void setPassword(String passWord){
        txtPassword.sendKeys(passWord);
    }

    public void clickLogin(){
        btnLogin.click();
    }
    
    public void clickLogout() {
    	logoutlink.click();
    }


}
