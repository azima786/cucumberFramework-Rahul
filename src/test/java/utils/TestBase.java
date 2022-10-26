package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

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
        String browser = prop.getProperty("browser");
        String url = prop.getProperty("QAUrl");

        if(driver==null){
            if(browser.equalsIgnoreCase("chrome")){
        System.setProperty("webdriver.chrome.driver", (System.getProperty("user.dir"))+"//src//test//resources//chromedriver107.exe");
       driver = new ChromeDriver();

            }
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));

            driver.get(url);
        }
        return driver;

    }
}
