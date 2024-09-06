package com.playwright;

import java.nio.file.Paths;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.*;

public class Example2 {
  public static void main(String[] args) {
    try (Playwright playwright = Playwright.create()) {
      Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
        .setHeadless(false));
      BrowserContext context = browser.newContext();
      
      context.tracing().start(new Tracing.StartOptions()
    		  .setScreenshots(true)
    		  .setSnapshots(true)
    		  .setSources(true));
      
      Page page = context.newPage();
      page.navigate("https://magento.softwaretestingboard.com/customer/account/login/");
      page.getByLabel("Email", new Page.GetByLabelOptions().setExact(true)).click();
      page.getByLabel("Email", new Page.GetByLabelOptions().setExact(true)).fill("sandeep321260@gmail.com");
      page.getByLabel("Password").click();
      //page.getByLabel("Password").fill("Sandeep@321260");
      page.fill("//input[@title = 'Password']", "Sandeep@321260");
      //page.pause();
      page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Sign In")).click();
      page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("My Orders")).click();
      
      context.tracing().stop(new Tracing.StopOptions()
    		  .setPath(Paths.get("trace.zip")));
    }
  }
}
