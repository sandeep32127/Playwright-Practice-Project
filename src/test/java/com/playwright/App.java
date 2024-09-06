package com.playwright;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class App {

	public static void main(String[] args) {
		Playwright playwright = Playwright.create();
		Browser browser = playwright.webkit().launch(new BrowserType.LaunchOptions().setHeadless(false));
		//Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false));
		Page page = browser.newPage();
		page.navigate("https://google.com");
		System.out.println(page.title());
		browser.close();
		playwright.close();
	}

}
