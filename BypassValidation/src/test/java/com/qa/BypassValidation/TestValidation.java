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



public class TestValidation {
			
	WebDriver driver= null;
	final String url = "http://testingchallenges.thetestingmap.org/challenge2.php";
	
	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver", 
				"C://Users//USER//Desktop//HomeWork/chromedriver.exe");
	driver = new ChromeDriver();
	
	}
	@Test 
	
	public void testValidation() {
		driver.manage().window().maximize();
		driver.get(url);
		JavascriptExecutor jsExcutor = (JavascriptExecutor) driver;
		jsExcutor.executeScript("document.getElementsByClassName(\"inputbox\")[0].type= \"text\";");
		ChallengeTwoPage page= PageFactory.initElements(driver, ChallengeTwoPage.class);
		page.textbox("something");
		WebElement checkElement = driver.findElement(By.className("block_label"));
		assertEquals("YOU HAVE DONE IT. Please enter your name.*", checkElement.getText());
		
		
	}

	@After
	public void teardown() throws InterruptedException
	{
		Thread.sleep(3000);
		driver.close();
		driver.quit();
	}


}
