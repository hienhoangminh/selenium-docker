package com.rocktester.search.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.List;

public class SearchPage {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(name = "q")
    private WebElement searchTxt;

    @FindBy(xpath = "//form[@id='searchbox_homepage']//button[contains(@class, 'searchbox_searchButton')]")
    private WebElement searchButton;

    @FindBy(linkText = "Videos")
    private WebElement videosLink;

    @FindBy(className = "tile--vid")
    private List<WebElement> allVideos;


    public SearchPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.of(30, ChronoUnit.SECONDS));
        PageFactory.initElements(driver, this);
    }

    public SearchPage goTo() {
        this.driver.get("https://duckduckgo.com");
        return this;
    }

    public SearchPage doSearch(String keyword) {
        this.wait.until(ExpectedConditions.visibilityOf(this.searchButton));
        this.searchTxt.sendKeys(keyword);
        this.searchButton.click();
        return this;
    }

    public SearchPage goToVideos() {
        this.wait.until(ExpectedConditions.visibilityOf(this.videosLink));
        this.videosLink.click();
        return this;
    }

    public int getResult() {
        By by = By.className("tile--vid");
        this.wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(by, 0));
        return this.allVideos.size();
    }


}
