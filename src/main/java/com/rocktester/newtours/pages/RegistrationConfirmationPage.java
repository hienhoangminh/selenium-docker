package com.rocktester.newtours.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

public class RegistrationConfirmationPage {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(partialLinkText = "sign-in")
    private WebElement signInLink;

    @FindBy(id = "flight-link")
    private WebElement flightLink;

    public RegistrationConfirmationPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.of(30, ChronoUnit.SECONDS));
        PageFactory.initElements(this.driver, this);
    }

    public void clickOnFlightLink() {
        this.wait.until(ExpectedConditions.visibilityOf(this.signInLink));
        this.flightLink.click();
    }

}
