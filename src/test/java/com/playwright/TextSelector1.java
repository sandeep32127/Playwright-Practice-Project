package com.playwright;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class TextSelector1 {

	public static void main(String[] args) {
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		BrowserContext browserContext = browser.newContext();
		
		Page page = browserContext.newPage();
		page.navigate("https://www.orangehrm.com/en/30-day-free-trial");
		
		Locator locator = page.locator("text=Privacy Policy");
		
		System.out.println("The total count is : " + locator.count());
		
		for (int i = 0; i < locator.count(); i++) {
			System.out.println(locator.nth(i).textContent().trim());
		}
		
		for (int i = 0; i < locator.count(); i++) {
			String text = locator.nth(i).textContent();
			if(text.trim().equals("Privacy Policy")) {
				locator.nth(i).click();
				break;
			}
		}
		
		
		  page.close(); browserContext.close(); browser.close();
		 
	}

}
