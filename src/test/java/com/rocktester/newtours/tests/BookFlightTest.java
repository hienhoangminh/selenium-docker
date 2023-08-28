package com.rocktester.newtours.tests;

import com.rocktester.BaseTest;
import com.rocktester.newtours.pages.*;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.time.LocalDate;

public class BookFlightTest extends BaseTest {

    @Test
    @Parameters({"firstName", "lastName", "userName", "password", "noOfPassengers", "departurePort", "arrivalPort", "serviceClass", "expectedPrice"})
    public void testBookingFlightFlow(String firstName, String lastName, String userName, String password,
                                      String noOfPassengers, String departurePort, String arrivalPort,
                                      String serviceClass, String expectedPrice) {
        RegistrationPage registrationPage = new RegistrationPage(driver);
        RegistrationConfirmationPage registrationConfirmationPage = new RegistrationConfirmationPage(driver);
        FlightDetailsPage flightDetailsPage = new FlightDetailsPage(driver);
        BookFlightPage bookFlightPage = new BookFlightPage(driver);
        BookingAddressPage bookingAddressPage = new BookingAddressPage(driver);
        FlightConfirmationPage flightConfirmationPage = new FlightConfirmationPage(driver);
        registrationPage.goTo()
                .inputFirstName(firstName)
                .inputLastName(lastName)
                .inputUserName(userName)
                .inputPassword(password)
                .inputConfirmPassword(password)
                .clickSubmitButton();
        registrationConfirmationPage.clickOnFlightLink();
        flightDetailsPage.selectNumberOfPassengers(noOfPassengers)
                .selectDepartingPort(departurePort)
                .selectArrivalPort(arrivalPort)
                .selectServiceClass(serviceClass)
                .clickSubmitButton();
        bookFlightPage.clickOnSubmitButton();
        bookingAddressPage.inputStreetAddress("1234 Main Street")
                .inputStreetAddressTwoLine("#03-18 Building 2")
                .inputCity("Paris")
                .inputState("Ile-de-France")
                .inputPostal("37000")
                .clickSubmitButton();
        String confirmationNumber = flightConfirmationPage.getFlightConfirmationNumber();
        String totalPrice = flightConfirmationPage.getFlightTotalPrice();
        Assert.assertTrue(confirmationNumber.contains(String.valueOf(LocalDate.now().getYear())));
        Assert.assertEquals(expectedPrice, totalPrice);
    }

}
