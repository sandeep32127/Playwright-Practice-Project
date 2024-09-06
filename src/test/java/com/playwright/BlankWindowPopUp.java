package com.playwright;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class BlankWindowPopUp {

	public static void main(String[] args) {
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		BrowserContext context = browser.newContext();
		Page page = context.newPage();
		
		page.navigate("https://google.com");
		
		Page popup = page.waitForPopup(() -> {
			page.click("a[target='_blank']");//a[target='_blank']    //target='_blank'
		});
		popup.waitForLoadState();
		popup.navigate("https://google.com");
		System.out.println("The title is : " + popup.title());
		popup.close();
		System.out.println("The title of the parent page : "+ page.title());
		page.close();
		
		context.close();
		browser.close();
		playwright.close();
	}

}
