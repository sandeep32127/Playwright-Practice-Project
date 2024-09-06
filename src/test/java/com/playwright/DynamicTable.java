package com.playwright;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class DynamicTable {

	public static void main(String[] args) {
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		Page page = browser.newPage();
		
		page.navigate("https://datatables.net/");
		Locator tableLocator = page.locator("table#example tr");
		tableLocator.locator(":scope", new Locator.LocatorOptions().
				setHasText("Ashton Cox")).
				locator("td.dtr-control").
				click();
		
		tableLocator.locator(":scope").allInnerTexts().forEach(System.out::println);
		
		browser.close();
		playwright.close();
	}

}
