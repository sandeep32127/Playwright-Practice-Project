package com.playwright;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class CommaSelectors {

	public static void main(String[] args) {
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false));
		
		Page page = browser.newPage();
		page.navigate("https://www.amazon.com/");
		page.locator("span:has-text('Sign in'), "
				+ "span:has-text('LogIn'), "
				+ "span:has-text('Log In'),"
				+ "span:has-text('signin'),"
				+ "span:has-text('login')").last().click();
	}

}
