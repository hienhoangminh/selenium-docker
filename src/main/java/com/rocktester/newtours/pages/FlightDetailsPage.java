package com.rocktester.newtours.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.List;

public class FlightDetailsPage {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(name = "passCount")
    private WebElement passengers;

    @FindBy(name = "fromPort")
    private WebElement fromPort;

    @FindBy(name = "fromMonth")
    private WebElement fromMonth;

    @FindBy(name = "fromDay")
    private WebElement fromDate;

    @FindBy(name = "toPort")
    private WebElement toPort;

    @FindBy(name = "toMonth")
    private WebElement toMonth;

    @FindBy(name = "toDay")
    private WebElement toDate;

    @FindBy(css = "input[name='servClass']")
    private List<WebElement> servingClasses;

    @FindBy(name = "findFlights")
    private WebElement submitButton;

    public FlightDetailsPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.of(30, ChronoUnit.SECONDS));
        PageFactory.initElements(this.driver, this);
    }

    public FlightDetailsPage selectNumberOfPassengers(String passenger) {
        this.wait.until(ExpectedConditions.elementToBeClickable(passengers));
        Select passengerDropdown = new Select(passengers);
        passengerDropdown.selectByValue(passenger);
        return this;
    }

    public FlightDetailsPage selectDepartingPort(String departingPort) {
        Select departingPorts = new Select(this.fromPort);
        departingPorts.selectByValue(departingPort);
        return this;
    }

    public FlightDetailsPage selectDepartingMonth(String month) {
        Select fromMonths = new Select(this.fromMonth);
        fromMonths.selectByValue(month);
        return this;
    }

    public FlightDetailsPage selectDepartingDate(String date) {
        Select fromDates = new Select(this.fromDate);
        fromDates.selectByValue(date);
        return this;
    }

    public FlightDetailsPage selectArrivalPort(String port) {
        Select arrivalPorts = new Select(this.toPort);
        arrivalPorts.selectByValue(port);
        return this;
    }

    public FlightDetailsPage selectArrivingMonth(String month) {
        Select toMonths = new Select(this.toMonth);
        toMonths.selectByValue(month);
        return this;
    }

    public FlightDetailsPage selectArrivingDate(String date) {
        Select toDates = new Select(this.toDate);
        toDates.selectByValue(date);
        return this;
    }

    public FlightDetailsPage selectServiceClass(String value) {
        this.wait.until(ExpectedConditions.visibilityOfAllElements(servingClasses));
        WebElement serviceClass = this.servingClasses.stream()
                .filter(e -> e.getAttribute("value")
                        .equals(value))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("There is no service class with name " + value));
        serviceClass.click();
        return this;
    }

    public void clickSubmitButton() {
        this.submitButton.click();
    }

}
