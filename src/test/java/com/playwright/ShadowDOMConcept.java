package com.playwright;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class ShadowDOMConcept {

	public static void main(String[] args) {
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		
		Page page = browser.newPage();
		
		/*
		 * page.navigate("https://books-pwakit.appspot.com/");
		 * page.locator("book-app[apptitle='BOOKS'] book-input-decorator input#input").
		 * fill("Testing Books"); String textContent =
		 * page.locator("book-app[apptitle='BOOKS'] book-home .books-desc").textContent(
		 * ); System.out.println(textContent);
		 */
		
		page.navigate("https://selectorshub.com/xpath-practice-page/");
		page.locator("div#userName div#app2 input#pizza").fill("nothing");
	}

}
