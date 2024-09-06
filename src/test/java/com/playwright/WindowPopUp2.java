package com.playwright;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

//NOT WORKING

public class WindowPopUp2 {

	public static void main(String[] args) {
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		BrowserContext brContext = browser.newContext();
		Page page = brContext.newPage();
		
		page.navigate("https://www.orangehrm.com/");
		
		Page newPage = brContext.waitForPage(() ->{
			page.click("img[alt='linkedin logo']"); 
		});
		
		brContext.onPage(page2 -> {
			page2.waitForLoadState();
		  System.out.println(page2.title());
		});
		
		//newPage.waitForLoadState();
		  
		//System.out.println("The popup page title is : " +newPage.title()); 
		newPage.close(); 
		System.out.println("The parent page title : "+page.title()); 
		page.close();
		
		brContext.close();
		browser.close();
		playwright.close();
	}

}
