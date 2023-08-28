package com.rocktester.newtours.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

public class FlightConfirmationPage {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(xpath = "//table[@id='confirm-table']/tbody/tr[td[contains(descendant::text(), 'Flight Confirmation')]]")
    private WebElement flightConfirmationNumber;

    @FindBy(xpath = "//table[@id='confirm-table']/tbody/tr/td[contains(descendant::text(), 'Total Price')]/following-sibling::td/font")
    private WebElement flightTotalPrice;

    @FindBy(linkText = "SIGN-OFF")
    private WebElement signOffLink;

    public FlightConfirmationPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.of(30, ChronoUnit.SECONDS));
        PageFactory.initElements(this.driver, this);
    }

    public String getFlightConfirmationNumber() {
        this.wait.until(ExpectedConditions.visibilityOf(this.flightConfirmationNumber));
        System.out.println("Flight confirmation number is : " + flightConfirmationNumber.getText().split("#")[1]);
        System.out.println("Total price is: " + flightTotalPrice.getText());
        return flightConfirmationNumber.getText().split("#")[1];
    }

    public String getFlightTotalPrice() {
        this.wait.until(ExpectedConditions.visibilityOf(this.flightTotalPrice));
        return flightTotalPrice.getText();
    }

    public void clickSignOff() {
        this.signOffLink.click();
    }


}
