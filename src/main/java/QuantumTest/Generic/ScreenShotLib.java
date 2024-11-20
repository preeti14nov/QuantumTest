package QuantumTest.Generic;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;


public class ScreenShotLib 
{
	public void getScreenShot(WebDriver driver, String filename, String browserName, String folderName)
	{
		if(browserName.equalsIgnoreCase("chrome")){
			TakesScreenshot ts = (TakesScreenshot) driver;
	        File srcFile = ts.getScreenshotAs(OutputType.FILE);
			String filepath = ".\\Screenshot\\Chrome";
			File file = new File(filepath);
			if(!file.exists()){
				file.mkdir();
			}
			File destFile = new File(folderName+"/" + filename+".png");
			try
			{
				FileUtils.copyFile(srcFile, destFile);
			} 
			catch (IOException e) 
			{
				e.printStackTrace();
				
			}
		}
		else if (browserName.equalsIgnoreCase("firefox")){
			 TakesScreenshot efw = (TakesScreenshot) driver;
			File srcFile = efw.getScreenshotAs(OutputType.FILE);
			String filepath = ".\\Screenshot\\Firefox";
			File file = new File(filepath);
			if(!file.exists()){
				file.mkdir();
			}
			File destFile = new File(folderName+"/" + filename+".png");
			
			
			try
			{
				FileUtils.copyFile(srcFile, destFile);
			} 
			catch (IOException e) 
			{
			
				e.printStackTrace();
				
			}
			
		}
		else if (browserName.equalsIgnoreCase("edge")){
			 TakesScreenshot efw = (TakesScreenshot) driver;
			File srcFile = efw.getScreenshotAs(OutputType.FILE);
			String filepath = ".\\Screenshot\\Edge";
			File file = new File(filepath);
			if(!file.exists()){
				file.mkdir();
			}
			File destFile = new File(folderName+"/" + filename+".png");
			
			
			try
			{
				FileUtils.copyFile(srcFile, destFile);
			} 
			catch (IOException e) 
			{
			
				e.printStackTrace();
				
			}
			
		}
		
		
	}
}	


