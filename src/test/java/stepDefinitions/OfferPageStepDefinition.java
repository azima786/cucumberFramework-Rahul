package stepDefinitions;

import io.cucumber.java.en.Then;
import org.testng.Assert;
import pageObjects.LandingPage;
import pageObjects.OffersPage;
import pageObjects.PageObjectManager;
import utils.TestContextSetup;

import java.util.Iterator;
import java.util.Set;

public class OfferPageStepDefinition {

public String productNameOffersPage;
    TestContextSetup testcontextsetup;
    PageObjectManager pageObjectManager;
    public OfferPageStepDefinition(TestContextSetup testcontextsetup) {
        this.testcontextsetup =testcontextsetup;
    }

    @Then("^user searches for (.+) shortname on offers page$")
    public void user_searches_for_shortname_on_offers_page(String shortname) throws InterruptedException {
        switchToOffersPage();
      //  pageObjectManager = new PageObjectManager(testcontextsetup.driver);
       OffersPage offersPage=  testcontextsetup.pageObjectManager.getOffersPage();
      //  OffersPage offersPage = new OffersPage(testcontextsetup.driver);
        offersPage.searchItem(shortname);
        Thread.sleep(6000);
       productNameOffersPage = offersPage.getSearchText();


    }

    public void switchToOffersPage(){
        //if(testcontextsetup.driver.getCurrentUrl().equalsIgnoreCase("https://rahulshettyacademy.com/seleniumPractise/#/offers"))

      //  pageObjectManager = new PageObjectManager(testcontextsetup.driver);
        LandingPage landingPage =  testcontextsetup.pageObjectManager.getLandingPage();
        landingPage.selectTopDealsPage();
        testcontextsetup.genericUtils.SwitchWindowToChild();
//        Set<String> s1 = testcontextsetup.driver.getWindowHandles();
//        Iterator<String> i1 = s1.iterator();
//        String parentWindow = i1.next();
//        String childWindow = i1.next();
//        testcontextsetup.driver.switchTo().window(childWindow);
    }

    @Then("validate product name matches with landing page")
    public void validate_product_name_matches_with_landing_page() {
        System.out.println(testcontextsetup.productNameLandingPage);
        Assert.assertEquals(testcontextsetup.productNameLandingPage, productNameOffersPage);
    }
}
