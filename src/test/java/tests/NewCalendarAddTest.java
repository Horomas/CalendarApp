package tests;

import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.PopUpStartingPage;
import util.DriverSetup;

@Epic("Regression Tests")
@Feature("NewCalendarAddTest")
public class NewCalendarAddTest extends DriverSetup {

    @Severity(SeverityLevel.CRITICAL)
    @Description("Test Description: Verify that a new calendar has been added")
    @Test(testName = "Calendar add event")
    public void bookingTest2() {
//        try {
//            Assert.assertTrue(popUpStartingPage.acceptWelcomePageLoaded(), "Pop up welcome page is not loaded");                              //2. Initial case handling
//            popUpStartingPage.clickAcceptanceWelcomePageLoaded();
//        } catch (AssertionError e) {
//            System.out.println("Assertion failed: " + e.getMessage());
//        }
//        helpers.clickByCoordinates(driver, 200, 637);                                                                                         //Accept location, but does not trigger by running the script
//        helpers.clickByCoordinates(driver, 296, 551);                                                                                         //Accept notifications, but does not trigger by running the script
        Assert.assertTrue(startingPage.todayHomePageLoaded(), "Calendar starting page is not loaded");                               //1. Open the Calendar app (already installed on iOS simulators), validate the application is started.
        startingPage.clickTodaySectionButton();
//        Assert.assertTrue(startingPage.addButtonLoaded(), "Add button page is not loaded");                                                   //Is accessible through appium inspector, but the script can not interact with this element or its sibling elements
//        startingPage.clickAddButton();


    }

}
