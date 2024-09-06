package com.playwright;

import java.nio.file.Paths;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class AppLoginUsingJson {

	public static void main(String[] args) throws InterruptedException {
		Playwright playwright = Playwright.create();
		Browser browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));
		
		BrowserContext brContext = browser.newContext(new Browser.NewContextOptions().setStorageStatePath(Paths.get("applogin.json")));
		Page page = brContext.newPage();
		
		page.navigate("https://magento.softwaretestingboard.com/");
		
		Thread.sleep(4000);
		
		browser.close();
		playwright.close();
	}

}
