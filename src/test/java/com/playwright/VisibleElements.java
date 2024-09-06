package com.playwright;

import java.util.List;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class VisibleElements {

	public static void main(String[] args) {
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false));
		
		Page page = browser.newPage();
		page.navigate("https://www.amazon.com/");
		
		//int count = page.locator("a:visible").count();
		List<String> allInnerTexts = page.locator("a:visible").allInnerTexts();
		
		for (String text : allInnerTexts) {
			System.out.println(text);
		}
		
		System.out.println("-----------------");
		
		int count = page.locator("input >> visible=true").count();
		
		System.out.println("The input count is : " + count);
		
		int count2 = page.locator("xpath=//img >> visible=true").count();
		System.out.println("The images count is : " + count2);
	}

}
