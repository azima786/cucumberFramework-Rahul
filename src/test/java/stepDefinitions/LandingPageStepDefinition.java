package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import pageObjects.LandingPage;
import utils.TestContextSetup;

public class LandingPageStepDefinition {
    TestContextSetup testcontextsetup;
    LandingPage landingPage;

    public LandingPageStepDefinition(TestContextSetup testcontextsetup) {
        this.testcontextsetup =testcontextsetup;
       this.landingPage = testcontextsetup.pageObjectManager.getLandingPage();
    }


    @Given("^user is on GreenKart landing page$")
    public void user_is_on_greenkart_landing_page() throws Throwable {
    Assert.assertTrue(landingPage.getTitleLandingPage().contains("GreenKart"));

    }

    @When("^user searched with shortname (.+) and extract actual name of product$")
    public void user_searched_with_shortname_something_and_extract_actual_name_of_product(String shortname) throws Throwable {

        landingPage.searchItem(shortname);
Thread.sleep(4000);
landingPage.getSearchText();
landingPage.getProductName();
 testcontextsetup.productNameLandingPage = landingPage.trimProductName();
       System.out.println(testcontextsetup.productNameLandingPage + " extracted from homepage");


    }

    @And("^added \"([^\"]*)\" items of the selected product to cart$")
    public void added_something_items_of_the_selected_product_to_cart(String quantity) throws Throwable {
landingPage.incrementQuantity(Integer.parseInt(quantity));
landingPage.setAddToCart();
    }

}
