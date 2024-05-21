package dsalgoPOM;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import dsalgo_stepdefinition.BaseTest;
import dsalgo_webdriver_manager.DriverManager;

public class HomePage{
     
	WebDriver driver;
	By home_msg = By.xpath("//div[@class='content']/p");
	By startBtn = By.xpath("//button[@class='btn']");
	By register_msg = By.xpath("//div[@class='alert alert-primary']");
	private String msg;
    
 public HomePage(WebDriver driver)
 {
	 	 	 this.driver = driver;
	 	 	 System.out.println(this.driver + " at HomePage Constructor");
 }
 
 public HomePage( )
 {
 }
 
 
 public String getmessage() throws IOException
 {	
	 JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", driver.findElement(home_msg));
	File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	System.out.println(System.getProperty("user.dir")+"\\src\\test\\resources\\Screenshots\\"+"Highlight"+"_"+System.currentTimeMillis() +".png");
	FileUtils.copyFile(scrFile, new File(System.getProperty("user.dir")+"\\src\\test\\resources\\Screenshots\\"+"Highlight" + "_"+System.currentTimeMillis() +".png"));
	return msg = driver.findElement(home_msg).getText();	 
 }
 public void clickButton()
 {
	 driver.findElement(startBtn).click(); 
 }
 public String getTitle()
 {
	 return driver.getTitle();
 }
 public String RegisterSuccess()
 {	
 	 return msg=driver.findElement(register_msg).getText();
 	 
 }


}
