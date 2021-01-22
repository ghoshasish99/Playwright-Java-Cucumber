package stepdefinitions;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.*;

public class Stepdefs {
	

	LoginPage loginPage = new LoginPage();
	SearchPage searchPage = new SearchPage();
	PaymentPage paymentPage = new PaymentPage();
	
	@Given("User launched eshop login page")
	public void user_launched_eshop_login_page() {
		try {
		loginPage.launch("http://awswrkshpalb-1570520390.us-west-2.elb.amazonaws.com:3000/cts-shop/login");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	@When("User create account with {string}, {string}, {string} and {string}")
	public void user_create_account_with_and(String fname,String lname, String email, String password) {
		loginPage.createUser(fname, lname, email, password);
	}

	@Then("User account should get created")
	public void user_account_should_get_created() {
		loginPage.createUserSuccessful();
	}

	@When("User logged in eshop using the invalid emailid {string} and the invalid password {string}")
	public void user_logged_in_eshop_using_the_invalid_emailid_and_the_invalid_password(String username,String password) {
		loginPage.login(username, password);
	}

	@Then("User should not get logged in")
	public void user_should_not_get_logged_in() {
		loginPage.loginUnsuccessful();
	}
	
	@When("User logged in eshop using the valid emailid {string} and the valid password {string}")
	public void user_logged_in_eshop_using_the_valid_emailid_and_the_valid_password(String email, String password) {
		loginPage.alreadyLoggedIn(email, password);
	}

	@When("User searches for the {string}")
	public void user_searches_for_the(String item) {
		searchPage.searchProduct(item);
	}

	@Then("User should be able to view and add the product {string}")
	public void user_should_be_able_to_view_and_add_the_product(String item) {
		searchPage.searchSuccessful(item);
		searchPage.addProduct();
		searchPage.addSuccessful();
	}
	
	@When("User Address details with {string},{string}, {string}, {string},{string},{string},{string}, {string}")
	public void user_address_details_with(String title,String fname,String lname,String addr1,String addr2,String city,String state,String zip) {
		paymentPage.enterAddressDetails(title, fname, lname, addr1, addr2, city, state, zip);
	}

	@When("User Payment details with {string}, {string}, {string},{string},{string}")
	public void user_payment_details_with(String cardNo,String name,String expMonth,String expYear,String securityCode) {
		paymentPage.enterPaymentDetails(cardNo, name, expMonth, expYear, securityCode);
	}

	@Then("User should get the Confirmation of Order")
	public void user_should_get_the_confirmation_of_order() {
		paymentPage.paymentSuccessful();
	}
}
