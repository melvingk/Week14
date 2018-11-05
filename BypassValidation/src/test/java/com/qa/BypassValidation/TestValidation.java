package com.qa.BypassValidation;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import utils.Constants;

public class TestValidation {

	WebDriver driver = null;

	@Before
	public void setup() {

		System.setProperty("webdriver.chrome.driver", Constants.driverLocation);
		driver = new ChromeDriver();

	}

	@Test

	public void testValidation() {
		driver.manage().window().maximize();
		driver.get(Constants.url);
		/* bypasses the HTML5 changing data type from number to text */
		JavascriptExecutor jsExcutor = (JavascriptExecutor) driver;
		jsExcutor.executeScript("document.getElementsByClassName(\"inputbox\")[0].type= \"text\";");
		ChallengeTwoPage page = PageFactory.initElements(driver, ChallengeTwoPage.class);
		page.textbox("something");
		WebElement checkElement = driver.findElement(By.className("block_label"));
		assertEquals("YOU HAVE DONE IT. Please enter your name.*", checkElement.getText());

	}

	@After
	public void teardown() throws InterruptedException {
		Thread.sleep(3000);
		driver.close();
		driver.quit();
	}

}
