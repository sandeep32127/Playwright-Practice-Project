package com.playwright;

import java.nio.file.Paths;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Download;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class DownloadFile {

	public static void main(String[] args) {
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("msedge").setHeadless(false));
		Page page = browser.newPage();
		
		page.navigate("https://chromedriver.storage.googleapis.com/index.html?path=114.0.5735.90/");
		
		Download download = page.waitForDownload(() -> {
			page.click("a:text('chromedriver_win32.zip')");
		});
		
		System.out.println("download URL : "+ download.url());
		System.out.println("The download page title : "+download.page().title());
		System.out.println("The failure reason : "+download.failure());
		
		System.out.println("The download path is : "+download.path().toString());
		
		download.saveAs(Paths.get("sandeep_chrome.zip"));
		
		System.out.println("The file name is : "+download.suggestedFilename());
	}

}
