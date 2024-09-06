package com.playwright;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class MultipleBrowserContext {

	public static void main(String[] args) {
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		
		BrowserContext context1 = browser.newContext();
		//BrowserContext context2 = browser.newContext();
		
		/*
		 * Page page1 = context1.newPage(); Page page2 = context2.newPage();
		 * 
		 * page1.navigate("https://google.com"); page2.navigate("https://amazon.com");
		 */
		
		Page page1 = context1.newPage();
		Page page2 = context1.newPage();
		
		page1.navigate("https://google.com");
		page2.navigate("https://amazon.com");
	}

}
