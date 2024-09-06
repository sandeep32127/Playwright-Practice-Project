package com.playwright;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class RelativeLocators {
	
	static Page page;

	public static void main(String[] args) throws InterruptedException {
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		page = browser.newPage();
		
		page.navigate("https://selectorshub.com/xpath-practice-page/");
		
		//page.locator("input[type='checkbox']:left-of(:text('Joe.Root'))").first().click();
		selectChkBox("Joe.Root");
		selectChkBox("John.Smith");
		
		Thread.sleep(3000);
		
		String userRole = page.locator("td:right-of(:text('Joe.Root'))").first().textContent();
		System.out.println("The user role is :"+userRole);
		
		String textContent = page.locator("a:above(a:text('Joe.Root'))").first().textContent();
		System.out.println("The user name above is : "+textContent);
		
		String textContentBelow = page.locator("a:below(a:text('Joe.Root'))").first().textContent();
		System.out.println("The user name below is : "+textContentBelow);
		
		page.locator("td:near(:text('Joe.Root'),400)").allInnerTexts().forEach(e -> System.out.println(e));
		
		page.close();
		browser.close();
		playwright.close();
	}
	
	public static void selectChkBox(String uName) {
		page.locator("input[type='checkbox']:left-of(:text('"+uName+"'))").first().click();
	}

}
