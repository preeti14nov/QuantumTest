package QuantumTest.Pageobject;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import QuantumTest.Generic.*;

public class HomePage {
	WebDriver driver;

	@FindBy(xpath="//span[contains(text(),'Singapore')]")
	private WebElement headerText;
	@FindBy(xpath="//input[contains(@placeholder,'Search for Address')]")
	private WebElement searchText;
	@FindBy(id="search-input-wrapper")
	private WebElement searchText1;
	@FindBy(xpath="//div[@class='autocom-box']/li[1]")
	private WebElement searchResult;
	@FindBy(xpath="//div[@class='markerInfoHeader']")
	private WebElement location;
	@FindBy(xpath="//img[@class='markerInfoClose']")
	private WebElement closeLocation;
	@FindBy(xpath="//div[@id='Community']")
	private WebElement community;
	@FindBy(id="popup-modal-text")
	private WebElement popup;
	@FindBy(xpath="//button[@text()='OK']")
	private WebElement okBtn;
	@FindBy(id="SchoolQueryInfo")
	private WebElement schoolQuery;
	@FindBy(xpath="//div[@id='schoolQuerySelectBlock']/div[1]")
	private WebElement kinderGarten;
	@FindBy(xpath="//div[contains(text(),'Disclaimer')]")
	private WebElement disclaimerText;
	@FindBy(xpath="//div[contains(text(),'Agree')]")
	private WebElement agreeBtn;
	@FindBy(xpath="//div[@id='optionSchoolSearch_kindergarten']/div")
	private List<WebElement> options;
	@FindBy(id="Medical")
	private WebElement medical;
	@FindBy(xpath="//span[contains(text(),'Search this area')]")
	private WebElement serachThisArea;
	@FindBy(id="HawkerCentres")
	private WebElement hawkerCentres;
	
	
	

	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public void verifyHomePage(){
		BasePage.sleepForMilliSecond(2000);
		Assert.assertTrue(BasePage.isPresentAndDisplayed(headerText));
		

	}
	public void searchForAddress() {
		BasePage.sleepForMilliSecond(2000);
		try {
		searchText.click();
		BasePage.sleepForMilliSecond(2000);
		searchText.sendKeys(ExcelUtils.readData("TestData", 1, 1));
		}
		catch(Exception e) {
			searchText1.click();
			BasePage.sleepForMilliSecond(2000);
			searchText1.sendKeys(ExcelUtils.readData("TestData", 1, 1));
		}
		BasePage.sleepForMilliSecond(5000);
		searchResult.click();
		BasePage.sleepForMilliSecond(2000);
		Assert.assertTrue(BasePage.isPresentAndDisplayed(location));
		closeLocation.click();
		
		
	}
	public void validateCommunity() {
		BasePage.sleepForMilliSecond(2000);
		community.click();
		if(popup.isDisplayed()) {
			try {
			okBtn.click();
			}
			catch(Exception e) {
			}
			
		}
		
	}
	public void validateSchoolQuery() {
		BasePage.sleepForMilliSecond(2000);
		schoolQuery.click();
		try {
		kinderGarten.click();
		}
		catch(Exception e) {
			BasePage.sleepForMilliSecond(2000);
			kinderGarten.click();
		}
		Assert.assertTrue(disclaimerText.isDisplayed());
		agreeBtn.click();
		Assert.assertTrue(options.get(0).isDisplayed());
		Assert.assertTrue(options.get(1).isDisplayed());
		
	}
	public void validateMedical() {
		BasePage.sleepForMilliSecond(2000);
		medical.click();
		try {
		serachThisArea.click();
		}
		catch(Exception e) {
	}
	}
	public void validateHawkerCentres() {
		BasePage.sleepForMilliSecond(2000);
		hawkerCentres.click();
		try {
		serachThisArea.click();
		}
		catch(Exception e) {
		}
		
	
	}
	
}


