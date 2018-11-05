package com.qa.BoundaryTesting;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ChallengeSixPage {

	
	@FindBy (xpath= "/html/body/div[2]/div/div/div/div/div[2]/form/div/div[1]/input")
	
	private WebElement textbox;
	
	public void textbox(String text) {
		textbox.clear();		
		textbox.sendKeys(text);
		textbox.submit();
		
	}
	
}
