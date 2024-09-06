package com.playwright;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class TextSelector2 {

	public static void main(String[] args) {
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		BrowserContext context = browser.newContext();
		Page page = context.newPage();
		
		page.navigate("https://demo.opencart.com/en-gb?route=account/login");
		
		String text = page.locator("h2:has-text('New Customer')").textContent();
		System.out.println(text);
		
		String textContent = page.locator("'Returning Customer'").textContent();
		System.out.println(textContent);
		
		page.locator("div.text-end button:has-text('Login')").click();//div.text-end button[type='submit']
	}

}
