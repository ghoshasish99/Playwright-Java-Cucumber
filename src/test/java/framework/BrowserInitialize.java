package framework;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class BrowserInitialize {

	public Browser launchBrowser(BrowserType.LaunchOptions launchOptions) {
        Playwright playwright = Playwright.create();
        BrowserType browserType = playwright.chromium();
		return browserType.launch(launchOptions);
	}
	
	public BrowserContext newBrowserContext(Browser browser, Browser.NewContextOptions newContextOptions) {
		return browser.newContext(newContextOptions);		
	}
	
	public Page page(BrowserContext browserContext) {
		return browserContext.newPage();
		
	}
}
