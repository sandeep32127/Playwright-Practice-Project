package com.playwright;

import java.awt.Dimension;
import java.awt.Toolkit;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class MaximizeScreen {

	public static void main(String[] args) throws InterruptedException {
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		int width = (int) dimension.getWidth();
		int height = (int) dimension.getHeight();
		
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false));
		BrowserContext browserContext = browser.newContext(new Browser.NewContextOptions().setViewportSize(width, height));
		Page page = browserContext.newPage();
		
		page.navigate("https://amazon.com");
		
		Thread.sleep(4000);
		
		browser.close();
		playwright.close();
	}

}
