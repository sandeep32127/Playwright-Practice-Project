package com.playwright;

import java.util.List;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class ReactLocator {

	public static void main(String[] args) {
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		Page page = browser.newPage();
		page.navigate("https://asana.com/campaign/fac/think");
		
		page.locator("_react=input[name='email']").fill("sand@gmail.com");
		//page.locator("_react=Anonymous[href='https://app.asana.com/-/login']").click();
		List<String> allInnerTexts = page.locator("_react=Anonymous[className='-white']").allInnerTexts();
		
		allInnerTexts.stream().forEach(e -> System.out.println(e));
	}

}
