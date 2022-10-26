package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LandingPage {
public WebDriver driver;

    By SearchBox = By.xpath("//input[@type='search']");
    By ProductName = By.cssSelector("h4.product-name");

    By topDeals = By.linkText("Top Deals");
    By increment = By.cssSelector("a.increment");
    By addToCart = By.cssSelector(".product-action button");

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

    public void selectTopDealsPage(){
        driver.findElement(topDeals).click();
    }

    public String getTitleLandingPage(){
        return driver.getTitle();
    }

    public void setAddToCart(){
        driver.findElement(addToCart).click();
    }

    public void incrementQuantity(int Quantity){
  int i = Quantity-1;
  while (i>0){
      driver.findElement(increment).click();
      i--;
  }


    }

}
