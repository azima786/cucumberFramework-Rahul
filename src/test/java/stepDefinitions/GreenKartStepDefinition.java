package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.Iterator;
import java.util.Set;

public class GreenKartStepDefinition {
WebDriver driver;
public String productNameLandingPage;
public String productNameOffersPage;

    @Given("^user is on GreenKart landing page$")
    public void user_is_on_greenkart_landing_page() throws Throwable {
        System.setProperty("webdriver.chrome.driver", "/Users/azima.keshwani/Documents/chromeDriver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");

    }

    @When("user searched with shortname {string} and extract actual name of product")
    public void user_searched_with_shortname_something_and_extract_actual_name_of_product(String shortname) throws Throwable {
driver.findElement(By.xpath("//input[@type='search']")).sendKeys(shortname);
Thread.sleep(4000);
 productNameLandingPage = driver.findElement(By.cssSelector("h4.product-name")).getText().split("-")[0].trim();
        System.out.println(productNameLandingPage + " extracted from homepage");


    }

    @Then("user searches for {string} shortname on offers page")
    public void user_searches_for_shortname_on_offers_page(String shortname) throws InterruptedException {
driver.findElement(By.linkText("Top Deals")).click();
Set<String> s1 = driver.getWindowHandles();
Iterator<String> i1 = s1.iterator();
String parentWindow = i1.next();
String childWindow = i1.next();
driver.switchTo().window(childWindow);
        driver.findElement(By.xpath("//input[@type='search']")).sendKeys(shortname);
        Thread.sleep(4000);
         productNameOffersPage = driver.findElement(By.cssSelector("tr td:nth-child(1)")).getText();

    }

    @Then("validate product name matches with landing page")
    public void validate_product_name_matches_with_landing_page() {
        Assert.assertEquals(productNameLandingPage, productNameOffersPage);
    }
}
