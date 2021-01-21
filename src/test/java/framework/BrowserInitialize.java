package framework;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class BrowserInitialize {

	public Browser launchBrowser(String browserName, BrowserType.LaunchOptions launchOptions) {

		BrowserType browserType = null;
		switch (browserName) {
		case "chromium":
			browserType = Playwright.create().chromium();
		case "firefox":
			browserType = Playwright.create().firefox();
		case "webkit":
			browserType = Playwright.create().webkit();
		}
		return browserType.launch(launchOptions);
	}
	
	public BrowserContext newBrowserContext(Browser browser, Browser.NewContextOptions newContextOptions) {
		return browser.newContext(newContextOptions);		
	}
	
	public Page page(BrowserContext browserContext) {
		return browserContext.newPage();
		
	}
}
