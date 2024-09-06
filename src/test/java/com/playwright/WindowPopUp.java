package com.playwright;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class WindowPopUp {

	public static void main(String[] args) throws InterruptedException {
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		BrowserContext brContext = browser.newContext();
		Page page = brContext.newPage();
		
		page.navigate("https://www.orangehrm.com/");
		
		Page popup = page.waitForPopup(() -> {
		 page.click("img[alt='linkedin logo']"); 
		}); 
		
		popup.wait(6000);
		//popup.waitForLoadState();
		  
		System.out.println("The popup page title is : " +popup.url()); 
		popup.close(); 
		System.out.println("The parent page title : "+page.title()); 
		page.close();
		
		brContext.close();
		browser.close();
		playwright.close();
	}
}
