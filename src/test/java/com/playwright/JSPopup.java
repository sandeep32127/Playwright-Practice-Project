package com.playwright;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class JSPopup {

	public static void main(String[] args)  throws InterruptedException{
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		
		Page page = browser.newPage();
		page.onDialog(dialogue -> {
			String message = dialogue.message();
			System.out.println("The message displayed in the alert : " +message);
			dialogue.accept("have eneterd the alert from Sandeep");
		});
		
		page.navigate("https://the-internet.herokuapp.com/javascript_alerts");
		
		page.click("//button[text() = 'Click for JS Alert']");
		String result = page.textContent("#result");
		System.out.println(result);
		Thread.sleep(2000);
		
		page.click("//button[text() = 'Click for JS Confirm']");
		result = page.textContent("#result");
		System.out.println(result);
		Thread.sleep(2000);
		
		page.click("//button[text() = 'Click for JS Prompt']");
		result = page.textContent("#result");
		System.out.println(result);
		Thread.sleep(3000);
		
		page.close();
		browser.close();
		playwright.close();
	}

}
