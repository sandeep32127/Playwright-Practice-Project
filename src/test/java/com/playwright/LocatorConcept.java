package com.playwright;

import java.util.Iterator;
import java.util.List;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class LocatorConcept {

	public static void main(String[] args) {
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		
		BrowserContext browserContext = browser.newContext();
		Page page = browserContext.newPage();
		page.navigate("https://www.orangehrm.com/en/30-day-free-trial");
		
		/*
		 * Locator locator = page.locator("text = Contact Sales");
		 * System.out.println("The total number of locators : "+ locator.count());
		 * locator.last().hover(); locator.last().click();
		 */
		
		Locator locatorcountryOptions = page.locator("select#Form_getForm_Country option");
		
		System.out.println("The total number of countris are : " + locatorcountryOptions.count());
		
		for (int i = 0; i < locatorcountryOptions.count(); i++) {
			String country = locatorcountryOptions.nth(i).textContent();
			System.out.println(country.trim());
		}
		
		System.out.println("-----------------------------");
		
		List<String> contents = locatorcountryOptions.allTextContents();
		
		contents.stream().forEach(x -> System.out.println(x.trim()));
	}

}
