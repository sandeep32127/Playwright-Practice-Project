package com.playwright;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Locator.LocatorOptions;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class DynamicTable3 {

	public static void main(String[] args) throws InterruptedException {
		Playwright playwright = Playwright.create();
		Browser browser = playwright.webkit().launch(new BrowserType.LaunchOptions().setHeadless(false));
		BrowserContext context = browser.newContext();
		
		Page page = context.newPage();
		page.navigate("https://primeng.org/");
		Locator tableLocator = page.locator("table#pn_id_1-table tr");
		
		tableLocator.locator(":scope", new LocatorOptions().
				setHasText(" Josephine Darakjy ")).
		locator("p-tablecheckbox.p-element").click();
		
		tableLocator.locator(":scope").allTextContents().forEach(e -> System.out.println(e));
		
		Thread.sleep(5000);
		page.context().browser().close();
	}
}
