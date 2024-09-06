package com.playwright;

import java.nio.file.Paths;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class AppLogin {

	public static void main(String[] args) {
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		
		BrowserContext browserContext = browser.newContext();
		Page page = browserContext.newPage();
		page.navigate("https://magento.softwaretestingboard.com/customer/account/login");
		
		page.fill("#email", "sandeep321260@gmail.com");
		page.fill("input#pass[name='login[password]']", "Sandeep@321260");
		page.locator("button#send2").first().click();
		
		browserContext.storageState(new BrowserContext.StorageStateOptions().setPath(Paths.get("applogin.json")));
	}

}
