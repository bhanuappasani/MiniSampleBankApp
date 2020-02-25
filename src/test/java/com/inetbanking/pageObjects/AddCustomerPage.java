package com.inetbanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AddCustomerPage {
	
	WebDriver iDriver;
	
	public AddCustomerPage(WebDriver driver) {
		iDriver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//a[contains(text(),'New Customer')]")
	@CacheLookup
	WebElement lnkAddCustomer;
	
	@FindBy(how = How.NAME, using = "name")
	@CacheLookup
	WebElement txtCustomerName;
	
	@FindBy(how = How.NAME, using = "rad1")
	@CacheLookup
	WebElement radGender;
	
	@FindBy(how = How.ID_OR_NAME, using = "bod")
	@CacheLookup
	WebElement txtdate;
	
	@FindBy(how = How.NAME, using = "addr")
	@CacheLookup
	WebElement txtAddress;
	
	@FindBy(how = How.NAME, using = "city")
	@CacheLookup
	WebElement txtCity;
	
	@FindBy(how = How.NAME, using = "state")
	@CacheLookup
	WebElement txtState;
	
	@FindBy(how = How.NAME, using = "pinno")
	@CacheLookup
	WebElement txtPinCode;
	
	@FindBy(how = How.NAME, using = "telephoneno")
	@CacheLookup
	WebElement txtPhone;
	
	@FindBy(how = How.NAME, using = "emailid")
	@CacheLookup
	WebElement txtEmail;
	
	@FindBy(how = How.NAME, using = "sub")
	@CacheLookup
	WebElement btnSubmit;
	
	public void setNewCustomer() {
		lnkAddCustomer.click();
	}
	
	public void setCustomerName(String cname) {
		txtCustomerName.sendKeys(cname);
	}
	
	public void setGender(String cgender) {
		radGender.click();
	}
	
	public void setCustdob(String mm,String dd,String yy) {
		txtdate.sendKeys(mm);
		txtdate.sendKeys(dd);
		txtdate.sendKeys(yy);
		
	}

	public void setCustAddress(String caddress) {
		txtAddress.sendKeys(caddress);
	}

	public void setCustCity(String ccity) {
		txtCity.sendKeys(ccity);
	}

	public void setCustState(String cstate) {
		txtState.sendKeys(cstate);
	}

	public void setCustPinno(String cpinno) {
		txtPinCode.sendKeys(String.valueOf(cpinno));
	}

	public void setCustTelephoneno(String ctelephoneno) {
		txtPhone.sendKeys(ctelephoneno);
	}

	public void setCustEmailid(String cemailid) {
		txtEmail.sendKeys(cemailid);
	}

	public void setCustSubmit() {
		btnSubmit.click();
	}
}
