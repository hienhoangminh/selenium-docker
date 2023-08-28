package com.rocktester.newtours.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

public class RegistrationPage {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(name = "firstName")
    private WebElement firstNameTxt;

    @FindBy(name = "lastName")
    private WebElement lastNameTxt;

    @FindBy(name = "email")
    private WebElement userNameTxt;

    @FindBy(name = "password")
    private WebElement passwordTxt;

    @FindBy(name = "confirmPassword")
    private WebElement confirmPasswordTxt;

    @FindBy(name = "register")
    private WebElement submitBtn;

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.of(30, ChronoUnit.SECONDS));
        PageFactory.initElements(driver, this);
    }

    public RegistrationPage goTo() {
        this.driver.get("https://vins-udemy.s3.amazonaws.com/docker/docker-book-flight.html");
        this.wait.until(ExpectedConditions.visibilityOf(firstNameTxt));
        return this;
    }

    public RegistrationPage inputFirstName(String firstName) {
        this.firstNameTxt.sendKeys(firstName);
        return this;
    }

    public RegistrationPage inputLastName(String lastName) {
        this.lastNameTxt.sendKeys(lastName);
        return this;
    }

    public RegistrationPage inputUserName(String userName) {
        this.userNameTxt.sendKeys(userName);
        return this;
    }

    public RegistrationPage inputPassword(String password) {
        this.passwordTxt.sendKeys(password);
        return this;
    }

    public RegistrationPage inputConfirmPassword(String confirmPassword) {
        this.confirmPasswordTxt.sendKeys(confirmPassword);
        return this;
    }

    public void clickSubmitButton() {
        this.submitBtn.click();
    }

}
