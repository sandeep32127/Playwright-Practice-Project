package com.playwright;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class FrameConcept {

	public static void main(String[] args) {
		
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false));
		BrowserContext context = browser.newContext();
		Page page = context.newPage();
		
		page.navigate("https://www.hyrtutorials.com/p/frames-practice.html");
		String textContent = page.frameLocator("iframe#frm2").locator("div.basicControls h1:has-text('Basic Controls in HTML')").textContent();
		System.out.println(textContent);
	}

}
