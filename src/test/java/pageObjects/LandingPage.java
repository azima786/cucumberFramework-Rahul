package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LandingPage {
public WebDriver driver;

    By SearchBox = By.xpath("//input[@type='search']");
    By ProductName = By.cssSelector("h4.product-name");

    public LandingPage(WebDriver driver) {
this.driver=driver;
    }

    public void searchItem(String shortname){
       driver.findElement(SearchBox).sendKeys(shortname);
    }

    public void getSearchText(){
    driver.findElement(SearchBox).getText();
    }

    public String getProductName(){
        return driver.findElement(ProductName).getText();
    }

    public String trimProductName(){
        return getProductName().split("-")[0].trim();
    }


}
