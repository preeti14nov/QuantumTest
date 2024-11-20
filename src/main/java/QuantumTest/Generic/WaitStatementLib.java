package QuantumTest.Generic;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitStatementLib {
	
	public static void explicitWaitForClickable (WebDriver driver, Duration time, WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver, time);
		wait.until(ExpectedConditions.elementToBeClickable(element));
		
		
	}
	public static void explicitWaitForVisiblity (WebDriver driver, Duration time, WebElement element)
	{
		WebDriverWait wait = new WebDriverWait (driver, time);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public static void explicitWaitForInVisiblity (WebDriver driver, Duration time, WebElement element)
	{
		WebDriverWait wait = new WebDriverWait (driver, time);
		wait.until(ExpectedConditions.invisibilityOf(element));
	
	}
	}
