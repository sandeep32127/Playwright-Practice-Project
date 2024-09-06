package com.playwright;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class NthElementSelector {

	public static void main(String[] args) {
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false));
		Page page = browser.newPage();
		
		page.navigate("https://amazon.com");
		String textContent = page.locator("div.navFooterLinkCol ul li >> nth=0").textContent().trim();
		System.out.println(textContent);
		
		String textContent2 = page.locator("div.navFooterLinkCol ul li >> nth=-1").textContent().trim();
		System.out.println(textContent2);
	}

}
