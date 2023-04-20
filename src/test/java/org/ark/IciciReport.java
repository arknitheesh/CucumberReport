package org.ark;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class IciciReport extends BaseClass {

	
	@Given("Launch ICICI Url")
	public void launchICICIUrl() {
		
		launchUrl("https://www.icicibank.com/");
	    
	}

	@When("Mouse hover to Login and Select personal Banking")
	public void mouseHoverToLoginAndSelectPersonalBanking() throws InterruptedException {
		Actions mouse = new Actions(driver);
		
		//Move mouse to Profile window for select login
		WebElement bankLogin = driver.findElement(By.id("loginsection"));
		mouse.moveToElement(bankLogin).perform();
		
		Thread.sleep(1000);
		//Select your banking mode (Personal, Corporate , NRI ...etc)
		WebElement personalBanking = driver.findElement(By.xpath("(//a[text()='Personal'])[2]"));
		personalBanking.click();
	}
	
	//user id and password from data table
	@When("Enter User id")
	public void enterUserId(io.cucumber.datatable.DataTable data) throws InterruptedException {
		Thread.sleep(2000);
		
		List<String> users = data.asList();
		
		WebElement user = driver.findElement(By.name("DUMMY1"));
		user.click();
		
		Thread.sleep(1000);
		WebElement userNames = driver.findElement(By.xpath("//input[@title='User Id']"));
		userNames.sendKeys(users.get(0));
	}

	@When("Enter Password")
	public void enterPassword(io.cucumber.datatable.DataTable pass) throws InterruptedException {
		Thread.sleep(1000);
	    
		List<List<String>> passs = pass.asLists();
		
	    WebElement password = driver.findElement(By.xpath("//input[@title='Password']"));
	    password.sendKeys(passs.get(0).get(1));
	   
	}

	
	
	
	//user id from scenario outline
	@When("Enter User {string} id")
	public void enterUserId(String username) throws InterruptedException {
		Thread.sleep(2000);
		
		WebElement user = driver.findElement(By.name("DUMMY1"));
		user.click();
		Thread.sleep(1000);
		WebElement userNames = driver.findElement(By.xpath("//input[@title='User Id']"));
		userNames.sendKeys(username);
		
	    
	}

	@When("Enter {string} Password")
	public void enterPassword(String pass) throws InterruptedException {
	    Thread.sleep(1000);
	    
	    WebElement password = driver.findElement(By.xpath("//input[@title='Password']"));
	    password.sendKeys(pass);
	    
	}

	@When("Select Fund Transfer Option")
	public void selectFundTransferOption() {
	    
		WebElement LoginOption = driver.findElement(By.xpath("//div[text()='Dashboard']"));
		LoginOption.click();
		WebElement option = driver.findElement(By.xpath("//a[text()='Fund Transfer']"));
		option.click();
	}

	@When("Click Login")
	public void clickLogin() {
	   WebElement loginBtn = driver.findElement(By.xpath("//input[@value='Login']"));
	   loginBtn.click();
	}

	@Then("Close the session")
	public void closeTheSession() throws IOException {
		
		TakesScreenshot screenshot = (TakesScreenshot)driver;
		File type =  screenshot.getScreenshotAs(OutputType.FILE);
		File Path = new File("./Reports/new.png");
		FileUtils.copyFile(type, Path);
		
	    
	}
	
}
