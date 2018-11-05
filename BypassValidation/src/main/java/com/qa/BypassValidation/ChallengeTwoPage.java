package com.qa.BypassValidation;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class ChallengeTwoPage  {
	
		
		@FindBy (xpath= "/html/body/div[2]/div/div/form/div/div/div/div/input")
		private WebElement textbox;
		
		public void textbox(String text) {
			textbox.sendKeys(text);
			textbox.submit();
		}
		
	}

