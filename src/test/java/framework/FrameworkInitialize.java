package framework;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;

public class FrameworkInitialize {

	public Page InitializePlaywrightPage() {
		BrowserInitialize browserinitialize = new BrowserInitialize();

		BrowserType.LaunchOptions options = new BrowserType.LaunchOptions();
		options.headless = true;

		//Get Browser
		Browser browser = browserinitialize.launchBrowser("chromium", options);

		Browser.NewContextOptions conOptions = new Browser.NewContextOptions();
		conOptions.locale = "en/US";
		
		//Get Context
		BrowserContext browserContext = browserinitialize.newBrowserContext(browser, conOptions);
		
		//Get Page
		Page page = browserinitialize.page(browserContext);

		return page;

	}
}