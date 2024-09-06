package com.playwright;

import java.nio.file.Path;
import java.nio.file.Paths;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class FileUpload {

	public static void main(String[] args) throws InterruptedException{
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		
		Page page = browser.newPage();
		page.navigate("https://davidwalsh.name/demo/multiple-file-upload.php");
		
		/*
		 * page.setInputFiles("input#filesToUpload",
		 * Paths.get("C:\\Users\\Papu\\Downloads\\cc_application_form.pdf"));
		 * Thread.sleep(3000); page.setInputFiles("input#filesToUpload", new Path[0]);
		 * Thread.sleep(3000);
		 */
		
		
		  page.setInputFiles("input#filesToUpload", new Path[] {
		  Paths.get("applogin.json"),
		  Paths.get("C:\\Users\\Papu\\Downloads\\cc_application_form.pdf"),
		  Paths.get("C:\\Users\\Papu\\Downloads\\Chandan_LeaveSanctioned.pdf") });
		  
		  Thread.sleep(3000); page.setInputFiles("input#filesToUpload", new Path[0]);
		  Thread.sleep(3000);
		 
		
		page.close();
		playwright.close();
		
	}

}
