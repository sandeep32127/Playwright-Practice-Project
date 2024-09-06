package com.playwright;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class DynamicTable2 {

	public static void main(String[] args) {
		Playwright playwright = Playwright.create();
		Browser browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));
		Page page = browser.newPage();
		
		page.navigate("https://primeng.org/");
		Locator tableRow = page.locator("table#pn_id_1-table tr");
		tableRow.locator(":scope", new Locator.LocatorOptions().setHasText("Lenna Paprocki")).
		locator("div.p-checkbox").click();
		
		tableRow.locator(":scope").allTextContents().forEach(e -> System.out.println(e));
		
		playwright.close();
	}

}
