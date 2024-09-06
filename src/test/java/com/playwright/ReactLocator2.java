package com.playwright;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class ReactLocator2 {

	public static void main(String[] args) {
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		BrowserContext context = browser.newContext();
		Page page = context.newPage();
		
		page.navigate("https://asana.com/campaign/fac/think");
		page.locator("_react=input[id='signup-textbox']").fill("fd@ghm.vom");
		page.locator("_react=Anonymous[className='siteFooter__logo-icon']").allTextContents().stream().forEach(System.out::println);
	}

}
