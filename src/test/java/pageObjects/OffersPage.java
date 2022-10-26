package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OffersPage {
public WebDriver driver;

By SearchEditBox =    By.xpath("//input[@type='search']");
By productName = (By.cssSelector("tr td:nth-child(1)"));


    public OffersPage(WebDriver driver) {
       this.driver=driver;
    }

    public void searchItem(String shortname){
    driver.findElement(SearchEditBox).sendKeys(shortname);
}

public String getSearchText(){
  return driver.findElement(productName).getText();

}





}
