package pages;


import java.nio.file.Paths;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.Page.ScreenshotOptions;

import framework.*;

public class PaymentPage{
	
	Page page = FrameworkConfig.page;
	
	public void enterAddressDetails(String title,String fname,String lname,String addr1,String addr2,String city,String state,String zip) {		
		page.fill("//div[normalize-space(.)='Title *']/div/input[normalize-space(@type)='text']",title);
        page.fill("//div[normalize-space(.)='First name *']/div/input[normalize-space(@type)='text']",fname);
        page.fill("//div[normalize-space(.)='Last name *']/div/input[normalize-space(@type)='text']",lname);
        page.fill("//div[normalize-space(.)='Address line1 *']/div/input[normalize-space(@type)='text']",addr1);
        page.fill("//div[normalize-space(.)='Address line2 *']/div/input[normalize-space(@type)='text']",addr2);
        page.fill("//div[normalize-space(.)='City *']/div/input[normalize-space(@type)='text']",city);
        page.fill("//div[normalize-space(.)='State/Province/Region *']/div/input[normalize-space(@type)='text']",state);
        page.fill("//div[normalize-space(.)='ZIP/Postcode *']/div/input[normalize-space(@type)='text']",zip);
        page.click("text='Next'");
	}
	public void enterPaymentDetails(String cardNo,String name,String expMonth,String expYear,String securityCode) {
		 page.fill("//div[normalize-space(.)='Card number *']/div/input[normalize-space(@type)='text']",cardNo);
	     page.fill("//div[normalize-space(.)='Name on card *']/div/input[normalize-space(@type)='text']",name);
	     page.fill("//div[normalize-space(.)='Expiry month *']/div/input[normalize-space(@type)='text']",expMonth);
	     page.fill("//div[normalize-space(.)='Expiry year *']/div/input[normalize-space(@type)='text']",expYear);
	     page.fill("//div[normalize-space(.)='Security code *']/div/input[normalize-space(@type)='text']",securityCode);
	     page.click("text='Confirm'");
		
	}
	public void paymentSuccessful() {
		ScreenshotOptions options = new ScreenshotOptions();
		options.path = Paths.get("target/report.png");
		options.fullPage = true;
		page.screenshot(options);
		
	}
}
