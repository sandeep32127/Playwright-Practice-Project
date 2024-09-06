package com.playwright;

import java.util.List;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class XpathLocators {

	public static void main(String[] args) throws InterruptedException {
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false));
		Page page = browser.newPage();
		
		/*
		 * page.navigate("https://amazon.com"); List<String> textContents = page.
		 * locator("xpath=//div[contains(@class, 'navFooterLinkCol')]/ul//a[not(contains(text(),'Amazon'))]"
		 * ).allTextContents();
		 * 
		 * textContents.forEach(e -> System.out.println(e));
		 */
		
		page.navigate("https://selectorshub.com/xpath-practice-page/");
		//page.locator("//a[text() ='Joe.Root']/../preceding-sibling::td/input").click();
		
		Locator locator = page.locator("xpath=//table[@id = 'resultTable']/descendant::td/input[@type='checkbox']");
		
		for (int i = 0; i < locator.count(); i++) {
			locator.nth(i).click();
		}
		
		page.locator("(//table[@id = 'resultTable']/descendant::td/input[@type='checkbox'])[last()]").click();
		
		Thread.sleep(3000);
		
		page.close();
		browser.close();
		playwright.close();
	}

}
