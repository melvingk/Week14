package com.qa.BoundaryTesting;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import Utils.Constants;

public class TestBoundary {
	WebDriver driver = null;

	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver", Constants.driverlocation);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(Constants.url);

	}

	@Test
	public void lessThanHour() {
		ChallengeSixPage page = PageFactory.initElements(driver, ChallengeSixPage.class);
		/* Testing time less than an hour */
		page.textbox("05/11/2017 12:19");
		WebElement checkElement = driver.findElement(By.className("values-tested"));
		assertEquals("1", checkElement.getText());

	}

	@Test

	public void yearTest() {
		String testVariable1 = "01/01/2018 00:00";
		String testVariable2 = "31/12/2016 23:59";

		ChallengeSixPage page = PageFactory.initElements(driver, ChallengeSixPage.class);
		/* Tests the last day of 2016 before the end of the year 2017 */
		page.textbox(testVariable1);
		WebElement checkElement = driver.findElement(By.className("values-tested"));
		assertEquals(("1"), checkElement.getText());
		/* Tests the first day of 2018 before the end of the year 2017 */
		page.textbox(testVariable2);
		WebElement checkElement2 = driver.findElement(By.className("values-tested"));
		assertEquals(("2"), checkElement2.getText());

	}

	@Test

	public void monthTest() {
		String testVariable1 = "01/00/2017 12:24";
		String testVariable2 = "01/13/2017 12:24";

		ChallengeSixPage page = PageFactory.initElements(driver, ChallengeSixPage.class);
		/* Tests the lowest number a month cannot be */
		page.textbox(testVariable1);
		WebElement checkElement = driver.findElement(By.className("values-tested"));
		assertEquals("1", checkElement.getText());
		/* Tests the highest number a month cannot be */
		page.textbox(testVariable2);
		WebElement checkElement2 = driver.findElement(By.className("values-tested"));
		assertEquals("2", checkElement2.getText());

	}

	@Test

	public void dayTest() {

		String testVariable1 = "00/11/2017 12:24";
		String testVariable2 = "31/06/2017 12:24";
		String testVariable3 = "32/03/2017 05:44";

		ChallengeSixPage page = PageFactory.initElements(driver, ChallengeSixPage.class);
		/* Tests the lowest number a day cannot be */
		page.textbox(testVariable1);
		WebElement checkElement = driver.findElement(By.className("values-tested"));
		assertEquals("1", checkElement.getText());
		/* Tests the highest number a day cannot be in a month that has 30 days */
		page.textbox(testVariable2);
		WebElement checkElement2 = driver.findElement(By.className("values-tested"));
		assertEquals("2", checkElement2.getText());
		/* Tests the highest number a day cannot be in a month that has 31 days */
		page.textbox(testVariable3);
		WebElement checkElement3 = driver.findElement(By.className("values-tested"));
		assertEquals("3", checkElement3.getText());

	}

	@Test

	public void leapYearTest() {
		String testVariable1 = "29/02/2017 00:00";

		ChallengeSixPage page = PageFactory.initElements(driver, ChallengeSixPage.class);
		/* Tests the leap year date that doesn't exist in the year 2017 */
		page.textbox(testVariable1);
		WebElement checkElement = driver.findElement(By.className("values-tested"));
		assertEquals("1", checkElement.getText());

	}

	@Test

	public void timeChangeTestOne() {
		String testVariable1 = "26/03/2017 02:00";
		String testVariable2 = "26/03/2017 02:59";
		String testVariable3 = "29/10/2017 03:00";

		ChallengeSixPage page = PageFactory.initElements(driver, ChallengeSixPage.class);
		/* Tests time on the date when clocks go forward by +1hour */
		page.textbox(testVariable1);
		WebElement checkElement = driver.findElement(By.className("values-tested"));
		assertEquals("1", checkElement.getText());
		/*
		 * Tests the highest invalid hour on the date when clocks go forward by +1hour
		 */
		page.textbox(testVariable2);
		WebElement checkElement2 = driver.findElement(By.className("values-tested"));
		assertEquals("2", checkElement2.getText());
		/* Tests time on the date when clocks go back by -1hour */
		page.textbox(testVariable3);
		WebElement checkElement3 = driver.findElement(By.className("values-tested"));
		assertEquals("3", checkElement3.getText());

	}

	@Test

	public void testHour() {

		String testVariable1 = "28/02/2017 24:00";
		String testVariable2 = "31/12/2017 -1:59";
		ChallengeSixPage page = PageFactory.initElements(driver, ChallengeSixPage.class);
		/* Tests the maximum an hour cannot be */
		page.textbox(testVariable1);
		WebElement checkElement = driver.findElement(By.className("values-tested"));
		assertEquals("1", checkElement.getText());
		/* Tests the minimum an hour cannot be */
		page.textbox(testVariable2);
		WebElement checkElement2 = driver.findElement(By.className("values-tested"));
		assertEquals("2", checkElement2.getText());

	}

	@Test

	public void testMinute() {

		String testVariable1 = "01/01/2017 00:60";
		String testVariable2 = "01/01/2017 00:-1";
		/* Tests the maximum a minute cannot be */
		ChallengeSixPage page = PageFactory.initElements(driver, ChallengeSixPage.class);
		page.textbox(testVariable1);
		WebElement checkElement = driver.findElement(By.className("values-tested"));
		assertEquals("1", checkElement.getText());
		page.textbox(testVariable2);
		WebElement checkElement2 = driver.findElement(By.className("values-tested"));
		assertEquals("2", checkElement2.getText());
	}

	@After
	public void teardown() throws InterruptedException {
		Thread.sleep(3000);
		driver.close();
		driver.quit();
	}

}
