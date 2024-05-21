package dsalgoPOM;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import dsalgo_commonlibraries.CommonLibraries;
import dsalgo_webdriver_manager.DriverManager;

public class GraphPage {
	
	By graphGetStarted = By.xpath("//a[@href='graph']");
	By graph = By.xpath("//a[@href='graph']");
	By graphRepresentations = By.xpath("//a[@href='/graph/graph-representations/']");
	By practicequestions = By.xpath("//a[@href='/graph/practice']");
	protected By trybuttonWE = By.linkText("Try here>>>");
	By formPageWE= By.id("answer_form");
	By graphpageWE = By.xpath("//h4[@class='bg-secondary text-white']");
	By graphPageWE1 = By.xpath("//p[@class='bg-secondary text-white']");
	By texteditorarea = By.xpath("//div//pre[@class='CodeMirror-line-like']/span");
	By txteditorarea_1 = By.xpath("//form[@id='answer_form']//pre[@class=' CodeMirror-line ']/span/span");
	By tryhere_btn = By.xpath("//a[@href='/tryEditor']");
	protected By editTextArea = By.xpath("//form[@id='answer_form']/div/div/div/textarea");
	public By runItButtonWE =By.xpath("//button[@onclick=\"runit()\"]");
	By consolemsg = By.xpath("//*[@id='output']");
	By signOut = By.xpath("//a[@href='/logout']");
	public WebDriverWait wait;
	public WebDriver driver;
	Alert alert;
	WebElement txtarea;
	
	public GraphPage (WebDriver driver){
		this.driver = driver;
		wait = new WebDriverWait(driver,Duration.ofSeconds(10));
	}
	
public void clickHyperLink(String argument) {
		    if(argument.equals("Get Started")) 
		    {
		         driver.findElement(graphGetStarted).click();
		    }
			else if(argument.equals("Graph")){
				
				 driver.findElement(graph).click();
			}
			else if(argument.equals("Graph Representations")){
				 
				 driver.findElement(graphRepresentations).click();
			}
		    else if(argument.equals("Practice Questions")){
				
				driver.findElement(practicequestions).click();
			}
		
	}


	public void clickRun() {
		
		
		driver.findElement(trybuttonWE).click();
	}
	
	public String getTryButtonText() {
		return driver.findElement(trybuttonWE).getText();
	}

	public void clickbutton() {
		driver.findElement(runItButtonWE).click();
		
	}


	public void validatetexteditor1(String validtext) throws InterruptedException 
		{
			Thread.sleep(1000);
			txtarea = driver.switchTo().activeElement();
			Actions actions = new Actions(driver);
			actions.moveToElement(txtarea).click().perform();
			txtarea.sendKeys(validtext);
						
		}
	
	public String alertpopup()
	{
	    alert = driver.switchTo().alert();
		String alertmsg = driver.switchTo().alert().getText();			
		return alertmsg;
	}


	public void navigateback() {
		
		driver.navigate().back();
		
	}

	public void cleartextarea()
	{
		Actions actions = new Actions(driver);
		actions.moveToElement(txtarea).click().perform();
		CommonLibraries.TextIndentation(driver, txtarea, 0,0 , false);
		txtarea.sendKeys(Keys.CONTROL + "a");
		txtarea.sendKeys(Keys.DELETE);
	
	}


	public String getconsolemsg() {
		
		return driver.findElement(consolemsg).getText();
	}


	public String getcurrentpage() {
		 return(driver.getCurrentUrl());
	}


	public String queuepagename(String argument) {
		
		if(argument.equals("Graph")) {
		   return(driver.findElement(graphpageWE).getText());	
		 }
		else if(argument.equals("GraphInGraph")) {
			return(driver.findElement(graphPageWE1).getText());
		}
		else if(argument.equals("tryEditor")) {
			return(driver.findElement(tryhere_btn).getText());
		}
		else if(argument.equals("Graph Representations")) {
			return(driver.findElement(graphPageWE1).getText());
		}
	return null;

		
	}


	public String getRunButton() {
		return driver.findElement(runItButtonWE).getText();
		
	}


	public void clickAlertButton() {
		
		driver.switchTo().alert().dismiss();
	}


	public void clickSignOut() {
		
		driver.findElement(signOut).click();
	}

}
