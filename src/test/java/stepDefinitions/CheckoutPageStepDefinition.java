package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import pageObjects.CheckoutPage;
import pageObjects.LandingPage;
import utils.TestContextSetup;

public class CheckoutPageStepDefinition {
    TestContextSetup testcontextsetup;

    public CheckoutPage checkoutPage;
    public CheckoutPageStepDefinition(TestContextSetup testcontextsetup) {

        this.testcontextsetup = testcontextsetup;
        this.checkoutPage = testcontextsetup.pageObjectManager.getCheckoutPage();
    }

    @Then("^user proceeds to Checkout and validate the (.+) items in checkout page$")
    public void user_proceeds_to_checkout_and_validate_the_items_in_checkout_page(String veg) throws Throwable {
checkoutPage.CheckOutItems();
Thread.sleep(2000);

    }

    @And("^verify user has ability to enter promo code and place the order$")
    public void verify_user_has_ability_to_enter_promo_code_and_place_the_order() throws Throwable {

Assert.assertTrue(checkoutPage.VerifyPromoBtn());
Assert.assertTrue(checkoutPage.VerifyPlaceOrder());

    }



}
