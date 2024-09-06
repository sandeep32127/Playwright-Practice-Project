package com.playwright;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.*;

public class ExampleInspector {
  public static void main(String[] args) {
    try (Playwright playwright = Playwright.create()) {
      Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
        .setHeadless(false));
      BrowserContext context = browser.newContext();
      Page page = context.newPage();
      page.navigate("https://www.google.com/");
      page.getByLabel("Search", new Page.GetByLabelOptions().setExact(true)).click();
      page.getByLabel("Search", new Page.GetByLabelOptions().setExact(true)).fill("testing");
      page.getByRole(AriaRole.COMBOBOX, new Page.GetByRoleOptions().setName("Search")).click();
      page.getByRole(AriaRole.COMBOBOX, new Page.GetByRoleOptions().setName("Search")).click();
      page.getByRole(AriaRole.COMBOBOX, new Page.GetByRoleOptions().setName("Search")).fill("testing selenium checks");
      page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Selenium Testing: Detailed")).click();
      page.navigate("https://www.google.com/search?q=testing+selenium+checks&sca_esv=0e526ec8824269be&ei=3r6xZq3uF6rvseMPidvS0QU&ved=0ahUKEwit1bP12t-HAxWqd2wGHYmtNFoQ4dUDCBA&uact=5&oq=testing+selenium+checks&gs_lp=Egxnd3Mtd2l6LXNlcnAiF3Rlc3Rpbmcgc2VsZW5pdW0gY2hlY2tzMgUQIRigATIFECEYoAEyBRAhGJ8FMgUQIRifBTIFECEYnwUyBRAhGJ8FMgUQIRifBTIFECEYnwUyBRAhGJ8FMgUQIRifBUj9KVDWDljKJ3ACeAGQAQCYAcECoAGMHKoBCDAuMy4xMi4xuAEDyAEA-AEBmAISoAK3HsICChAAGLADGNYEGEfCAg0QABiABBiwAxhDGIoFwgIFEAAYgATCAggQABiABBixA8ICCxAAGIAEGLEDGIMBwgILEAAYgAQYkQIYigXCAgcQABiABBgKwgIGEAAYFhgewgIIEAAYFhgeGA_CAgsQABiABBiGAxiKBcICCBAAGIAEGKIEmAMAiAYBkAYKkgcIMi4wLjE1LjGgB6hn&sclient=gws-wiz-serp");
      page.getByRole(AriaRole.COMBOBOX, new Page.GetByRoleOptions().setName("Search")).click(new Locator.ClickOptions()
        .setButton(MouseButton.RIGHT));
    }
  }
}
