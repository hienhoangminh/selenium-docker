package com.rocktester.newtours.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BookFlightPage {

    private WebDriver driver;

    @FindBy(name = "reserveFlights")
    private WebElement submitButton;

    public BookFlightPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    public void clickOnSubmitButton() {
        this.submitButton.click();
    }

}
