package com.playwright;


import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class ElementInsideElementHAS2 {

	public static void main(String[] args) {
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false));
		Page page = browser.newPage();
		
		page.navigate("https://amazon.com");
		page.locator("div.navFooterLinkCol:has-text('Careers')").allInnerTexts().forEach(e -> System.out.println(e));
	}

}
