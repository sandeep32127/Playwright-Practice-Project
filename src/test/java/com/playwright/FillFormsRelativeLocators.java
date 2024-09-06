package com.playwright;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class FillFormsRelativeLocators {

	public static void main(String[] args) {
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		
		Page page = browser.newPage();
		page.navigate("https://www.orangehrm.com/en/contact-sales/");
		
		page.locator("input[type='text']:below(#Form_getForm_FullName_Holder label)").first().fill("Sandeep Dalei");
		page.locator("input[name='Contact']:below(label:text('Phone Number'))").first().fill("1234567890");
		page.locator("input[type='email']:below(label:text('Email'))").first().fill("sand@gmail.com");
		
		browser.close();
		playwright.close();
	}

}
