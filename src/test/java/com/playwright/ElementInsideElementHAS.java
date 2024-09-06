package com.playwright;

import java.util.List;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class ElementInsideElementHAS {

	public static void main(String[] args) {
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		Page page = browser.newPage();
		page.navigate("https://www.orangehrm.com/en/30-day-free-trial");
		
		List<String> innerTexts = page.locator("select#Form_getForm_Country:has(option[value='India'])").allInnerTexts();
		
		innerTexts.forEach(System.out::println);
	}

}
