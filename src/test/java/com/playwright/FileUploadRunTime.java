package com.playwright;

import java.nio.charset.StandardCharsets;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.FilePayload;

public class FileUploadRunTime {

	public static void main(String[] args) throws InterruptedException {
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		Page page = browser.newPage();
		page.navigate("https://cgi-lib.berkeley.edu/ex/fup.html");
		
		page.setInputFiles("input[name='upfile']", new FilePayload("sandy.txt", "text/plain", 
				"This is sandeep , m here".getBytes(StandardCharsets.UTF_8)));
		
		page.click("input[value='Press']");
		
		Thread.sleep(4000);
		
		browser.close();
		playwright.close();
	}

}
