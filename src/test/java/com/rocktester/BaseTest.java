package com.rocktester;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.time.temporal.ChronoUnit;

public class BaseTest {

    protected WebDriver driver;

    @BeforeClass
    public void setup() throws MalformedURLException {
        String host = "localhost";
        MutableCapabilities cap;
        if(System.getProperty("BROWSER") != null && System.getProperty("BROWSER").equalsIgnoreCase("firefox")){
            cap = new FirefoxOptions();
        }else{
            cap = new ChromeOptions();
        }
        if(System.getProperty("HUB_HOST") != null){
            host = System.getProperty("HUB_HOST");
        }
        String url = "http://" + host + ":4444/wd/hub";
        this.driver = new RemoteWebDriver(new URL(url), cap);
        driver.manage().timeouts().implicitlyWait(Duration.of(30, ChronoUnit.SECONDS));
        driver.manage().window().maximize();
    }

    @AfterClass
    public void tearDown() {
        this.driver.close();
        this.driver.quit();
    }

}
