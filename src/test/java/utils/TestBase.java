package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class TestBase {

    public WebDriver driver;

    public WebDriver WebDriverManager() throws IOException {
        FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"//src//test//resources//global.properties");
        Properties prop = new Properties();
        prop.load(fis);
        String browser_properties = prop.getProperty("browser");
        String url = prop.getProperty("QAUrl");
        String browser_maven = prop.getProperty("browser");

        //ternary operation
        String browser = browser_maven!=null ? browser_maven : browser_properties;

        if(driver==null){
            if(browser.equalsIgnoreCase("chrome")){
        System.setProperty("webdriver.chrome.driver", (System.getProperty("user.dir"))+"//src//test//resources//chromedriver107.exe");
       driver = new ChromeDriver();

            }
            if(browser.equalsIgnoreCase("firefox")){
                System.setProperty("webdriver.gecko.driver", (System.getProperty("user.dir"))+"//src//test//resources//chromedriver107.exe");
                driver = new FirefoxDriver();
            }
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));

            driver.get(url);
        }
        return driver;

    }
}
