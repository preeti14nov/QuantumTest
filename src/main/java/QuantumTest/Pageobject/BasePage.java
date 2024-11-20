package QuantumTest.Pageobject;

import java.awt.AWTException;
import java.awt.Robot;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;


public abstract class BasePage {
	public static WebDriver driver;


	public static boolean isPresentAndDisplayed(final WebElement element) {
		try {
			return element.isDisplayed();
		} catch (NoSuchElementException e) {
			return false;
		}
	}


	public static void pressEnter(WebDriver driver) {

		try {
			Robot r = new Robot();
			r.keyPress(java.awt.event.KeyEvent.VK_ENTER);
			r.keyRelease(java.awt.event.KeyEvent.VK_ENTER);

		} catch (AWTException e) {

			e.printStackTrace();
		}
	}
	public static void sleepForMilliSecond(int time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException ex) {

		}
	}


	public BasePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}



}
