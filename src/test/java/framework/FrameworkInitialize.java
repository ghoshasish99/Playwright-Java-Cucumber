package framework;

import java.nio.file.Paths;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Page;

public class FrameworkInitialize {

	public Page InitializePlaywrightPage() {

		BrowserInitialize browserinitialize = new BrowserInitialize();
		Browser browser = browserinitialize.launchBrowser(new LaunchOptions().withHeadless(false)
				.withExecutablePath(Paths.get("C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe")));

		Browser.NewContextOptions conOptions = new Browser.NewContextOptions();
		conOptions.locale = "en/US";

		// Get Context
		BrowserContext browserContext = browserinitialize.newBrowserContext(browser, conOptions);

		// Get Page
		Page page = browserinitialize.page(browserContext);

		return page;

	}
}