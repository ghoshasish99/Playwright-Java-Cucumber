package pages;

import java.util.Date;


import com.microsoft.playwright.Page;

import framework.FrameworkConfig;

public class LoginPage{
	
	//FrameworkInitialize framework = new FrameworkInitialize();
	//Page page = framework.InitializePlaywrightPage();
	Page page = FrameworkConfig.page;
	
	public void launch(String url) {
		page.navigate(url);
	}
	public void login(String username,String password) {
		page.fill("#email", username);
		page.fill("#password",password);
		page.click("text='Log In'");
	}
	public void createUser(String fname,String lname, String email, String password) {
		Date date = new Date();
		email = email.replace("testuser", "testuser"+date);
		page.click("text='Create Your E-Shop Account'");
		page.fill("//div[normalize-space(.)='First name *']/div/input[normalize-space(@type)='text']", fname);
		page.fill("//div[normalize-space(.)='Last name *']/div/input[normalize-space(@type)='text']",lname);
		page.fill("//div[normalize-space(.)='Email *']/div/input[normalize-space(@type)='text']", email);
		page.fill("input[type='password']", password);
		page.fill("//div[normalize-space(.)='Confirm password *']/div/input[normalize-space(@type)='password']", password);
		page.click("text='Create Your E-Shop Account'");
	}
	public void loginUnsuccessful() {
		page.waitForSelector("[class='MuiTypography-root MuiTypography-caption MuiTypography-colorSecondary MuiTypography-alignCenter']");
		
	}
	public void createUserSuccessful() {
		page.waitForSelector("input[aria-label='Product search']");		
	}
	public void alreadyLoggedIn(String email,String password) {
		this.createUser("Ashish", "Ghosh", email, password);
		this.createUserSuccessful();	
	}
}
