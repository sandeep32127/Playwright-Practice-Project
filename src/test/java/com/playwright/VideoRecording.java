package com.playwright;

import java.nio.file.Paths;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class VideoRecording {

	public static void main(String[] args) {
		Playwright playwright = Playwright.create();
		Browser browser = playwright.webkit().launch(new BrowserType.LaunchOptions().setHeadless(false));
		BrowserContext context = browser.newContext(new Browser.NewContextOptions().setRecordVideoDir(Paths.get("./videorecordings")).
				setRecordVideoSize(1500, 900));
		Page page = context.newPage();
		
		page.navigate("https://www.orangehrm.com/en/30-day-free-trial");
		
		page.fill("input#Form_getForm_subdomain", "sandytn");
		page.fill("input#Form_getForm_Name", "sandeep dalei");
		page.fill("input#Form_getForm_Email", "test@gmail.com");
		page.fill("input#Form_getForm_Contact", "9439583014");
		page.click("input#Form_getForm_action_submitForm");
		
		page.close();
		context.close();
		playwright.close();
	}

}
