package com.rbs.onlineshopping.ui.stepdefinition;

import org.testng.Assert;

import com.rbs.onlineshopping.ui.helpers.Browser;
import com.rbs.onlineshopping.ui.pageobjects.AddressPO;
import com.rbs.onlineshopping.ui.pageobjects.CartConfirmationPO;
import com.rbs.onlineshopping.ui.pageobjects.MyAccountPO;
import com.rbs.onlineshopping.ui.pageobjects.PaymentPO;
import com.rbs.onlineshopping.ui.pageobjects.ProductPO;
import com.rbs.onlineshopping.ui.pageobjects.ShippingPO;
import com.rbs.onlineshopping.ui.pageobjects.ShoppingCartSummaryPO;
import com.rbs.onlineshopping.ui.pageobjects.TShirtPO;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class OrderTshirt extends Browser {

	public OrderTshirt() throws Exception {
		super();
	}

	TShirtPO tshirt = new TShirtPO();
	ProductPO product = new ProductPO();
	MyAccountPO myaccount = new MyAccountPO();
	CartConfirmationPO confirm = new CartConfirmationPO();
	ShoppingCartSummaryPO cartsummary = new ShoppingCartSummaryPO();
	AddressPO address = new AddressPO();
	ShippingPO shipping = new ShippingPO();
	PaymentPO payment = new PaymentPO();

	@When("^User click on TShirt Tab$")
	public void user_click_on_TShirt_Tab() throws Throwable {
		myaccount.clickTShirtLink();

	}

	@Then("^User should land on \"([^\"]*)\" shopping Page$")
	public void user_should_land_on_shopping_Page(String strExpectedTextValue)
			throws Throwable {
		Assert.assertTrue(tshirt.verifyTShirtPage(strExpectedTextValue));
	}

	@Then("^User should see the Tshirts in my TShirt shopping page$")
	public void user_should_see_the_Tshirts_in_my_TShirt_shopping_page()
			throws Throwable {
		Assert.assertTrue(tshirt.verifyProductCount());
	}

	@Given("^User is on a TShirt shopping Page$")
	public void user_is_on_a_TShirt_shopping_Page() throws Throwable {

	}

	@When("^User sort the TShirt \"([^\"]*)\"$")
	public void user_sort_the_TShirt(String strSortByValue) throws Throwable {
		tshirt.sortTShirtBy(strSortByValue);
	}

	@When("^User open the required TShirt \"([^\"]*)\"$")
	public void user_open_the_required_TShirt(String strProductName)
			throws Throwable {
		tshirt.openTShirt(strProductName);
	}

	@When("^User select the Quanity/Size/Colour \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\"$")
	public void user_select_the_Quanity_Size_Colour(String strColour,
			String strSize, String strQuantity) throws Throwable {
		product.selectColourSizeQuantity(strColour, strSize, strQuantity);
	}

	@When("^User click on add to card button$")
	public void user_click_on_add_to_card_button() throws Throwable {
		product.clickAddtoCartBtn();
	}

	@Then("^User should see the selected TShirt in the add to cart confirmation page with \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\"$")
	public void user_should_see_the_selected_TShirt_in_the_add_to_cart_confirmation_page_with(
			String strProductName, String strColour, String strSize,
			String strQuantity) throws Throwable {
		Assert.assertTrue(confirm.verifyProductInfo(strProductName, strColour,
				strSize, strQuantity));
	}

	@Then("^User  shoud see the message \"([^\"]*)\"$")
	public void user_shoud_see_the_message(String strExpectedValue)
			throws Throwable {
		Assert.assertTrue(confirm.verifyAlertMessage(strExpectedValue));
	}

	@Given("^User is on the \"([^\"]*)\" page$")
	public void user_is_on_the_page(String strExpectedValue) throws Throwable {
		confirm.clickProceedCheckoutBtn();
		Assert.assertTrue(cartsummary.verifySummaryCartPage(strExpectedValue));
	}

	@Then("^User should  see the selected TShirt in the shopping cart summary page with \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\"$")
	public void user_should_see_the_selected_TShirt_in_the_shopping_cart_summary_page_with(
			String strProductName, String strColour, String strSize,
			String strQuantity) throws Throwable {
		Assert.assertTrue(cartsummary.VerifyProductinfo(strProductName,
				strColour, strSize, strColour));
	}

	@Given("^User is on \"([^\"]*)\" page$")
	public void user_is_on_page(String strExpectedTextValue) throws Throwable {
		cartsummary.clickProceedCheckoutBtn();
		Assert.assertTrue(address.verifyAddresstPage(strExpectedTextValue));
	}

	@When("^User click on delivery address update button$")
	public void user_click_on_delivery_address_update_button() throws Throwable {
		address.clickDeliveryAddressUpdateBtn();

	}

	@When("^User update the address Fields with \"([^\"]*)\"$")
	public void user_update_the_address_Fields_with(String strAddressValue)
			throws Throwable {
		address.enterAddress(strAddressValue);

	}

	@When("^User clicks on save button$")
	public void user_clicks_on_save_button() throws Throwable {
		address.clickSaveButton();

	}

	@Then("^User should see the updated address in the delivery item box \"([^\"]*)\"$")
	public void user_should_see_the_updated_address_in_the_delivery_item_box(
			String strAddressValue) throws Throwable {
		Assert.assertTrue(address.verifyUpdatedAddress(strAddressValue));
	}

	@Given("^User is on the shipping page with title \"([^\"]*)\"$")
	public void user_is_on_the_shipping_page_with_title(
			String strExpectedTextValue) throws Throwable {
		address.clickProceedCheckoutBtn();
		Assert.assertTrue(shipping.verifyShippingPage(strExpectedTextValue));
	}

	@Then("^User should able to select the Terms of service \"([^\"]*)\"$")
	public void user_should_able_to_select_the_Terms_of_service(
			String strTextValue) throws Throwable {
		shipping.checkTermsandService(strTextValue);
	}

	@Given("^User is on a Payment Page with title \"([^\"]*)\"$")
	public void user_is_on_a_Payment_Page_with_title(String strExpectedTextValue)
			throws Throwable {
		shipping.clickProceedCheckoutBtn();
		Assert.assertTrue(payment.verifyPaymentPage(strExpectedTextValue));
	}

	@When("^User select the paymentmode \"([^\"]*)\"$")
	public void user_select_the_paymentmode(String strExpectedTextValue)
			throws Throwable {
		shipping.clickProceedCheckoutBtn();

	}

}
