package pages;

import static org.junit.Assert.assertTrue;

import com.microsoft.playwright.Page;

import framework.*;

public class SearchPage {
	
	Page page = FrameworkConfig.page;
	
	public void searchProduct(String item) {
		page.fill("input[aria-label='Product search']",item);
		page.click("button[aria-label='Search']");
	}
	public void searchSuccessful(String item) {
		assertTrue(page.textContent("div.productlistdetails > div > h6:nth-child(1) > a").contains(item));
	}
	public void addProduct() {
		page.click("div.productlistdetails > div > h6:nth-child(1) > a");
		page.click("text='Add to your basket'");
	}
	public void addSuccessful() {
		page.click(".MuiBadge-root .MuiSvgIcon-root path");
		page.click("text='Proceed to checkout'");		
	}
}
