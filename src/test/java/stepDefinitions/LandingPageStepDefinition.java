package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import utils.TestContextSetup;

public class LandingPageStepDefinition {

//public String productNameLandingPage;

    TestContextSetup testcontextsetup;

    public LandingPageStepDefinition(TestContextSetup testcontextsetup) {
        this.testcontextsetup =testcontextsetup;
    }


    @Given("^user is on GreenKart landing page$")
    public void user_is_on_greenkart_landing_page() throws Throwable {
        System.setProperty("webdriver.chrome.driver", "/Users/azima.keshwani/Documents/chromeDriver/chromedriver.exe");
        testcontextsetup.driver = new ChromeDriver();
        testcontextsetup.driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");

    }

    @When("user searched with shortname {string} and extract actual name of product")
    public void user_searched_with_shortname_something_and_extract_actual_name_of_product(String shortname) throws Throwable {
        testcontextsetup.driver.findElement(By.xpath("//input[@type='search']")).sendKeys(shortname);
Thread.sleep(4000);
 testcontextsetup.productNameLandingPage = testcontextsetup.driver.findElement(By.cssSelector("h4.product-name")).getText().split("-")[0].trim();
        System.out.println(testcontextsetup.productNameLandingPage + " extracted from homepage");


    }

}
