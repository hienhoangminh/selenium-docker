package com.rocktester.newtours.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

public class BookingAddressPage {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(id = "input_53_addr_line1")
    private WebElement streetAddressTxt;

    @FindBy(id = "input_53_addr_line2")
    private WebElement streetAddressLineTwoTxt;

    @FindBy(id = "input_53_city")
    private WebElement cityTxt;

    @FindBy(id = "input_53_state")
    private WebElement stateTxt;

    @FindBy(id = "input_53_postal")
    private WebElement postalTxt;

    @FindBy(name = "buyFlights")
    private WebElement submitButton;

    public BookingAddressPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.of(30, ChronoUnit.SECONDS));
        PageFactory.initElements(this.driver, this);
    }

    public BookingAddressPage inputStreetAddress(String address) {
        this.wait.until(ExpectedConditions.elementToBeClickable(this.submitButton));
        this.streetAddressTxt.sendKeys(address);
        return this;
    }

    public BookingAddressPage inputStreetAddressTwoLine(String address) {
        this.streetAddressLineTwoTxt.sendKeys(address);
        return this;
    }

    public BookingAddressPage inputCity(String city) {
        this.cityTxt.sendKeys(city);
        return this;
    }

    public BookingAddressPage inputState(String state) {
        this.stateTxt.sendKeys(state);
        return this;
    }

    public BookingAddressPage inputPostal(String postalCode) {
        this.postalTxt.sendKeys(postalCode);
        return this;
    }

    public void clickSubmitButton() {
        this.submitButton.click();
    }


}
