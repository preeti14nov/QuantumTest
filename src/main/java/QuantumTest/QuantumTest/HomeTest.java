package QuantumTest.QuantumTest;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;


public class HomeTest extends QuantumTest.Generic.BaseLib {
	
	@Test(groups = "Regression")
	public void TC_001_VerifyHomePage() {
		test = extent.createTest("TC001");
		homePage.verifyHomePage();
		test.log(Status.PASS, "This Test Passed");
		}
	@Test(groups = "Regression")
	public void TC_002_SearchForAddress()
	{
		test = extent.createTest("TC002");
		homePage.searchForAddress();
		test.log(Status.PASS, "This Test Passed");
	}
	@Test(groups = "Regression")
	public void TC_003_validateCommunity() {
		test = extent.createTest("TC003");
		homePage.validateCommunity();
		test.log(Status.PASS, "This Test Passed");
	}
	@Test(groups = "Regression")
	public void TC_004_validateSchoolQuery() {
		test = extent.createTest("TC004");
		homePage.validateSchoolQuery();
		test.log(Status.PASS, "This Test Passed");
	}
	@Test(groups = "Regression")
	public void TC_005_Medical() {
		test = extent.createTest("TC005");
		homePage.validateMedical();
		test.log(Status.PASS, "This Test Passed");
	}
	@Test(groups = "Regression")
	public void TC_006_HawkerCentre() {
		test = extent.createTest("TC006");
		homePage.validateHawkerCentres();
		test.log(Status.PASS, "This Test Passed");
	}

	



}
