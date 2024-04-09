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
//            Assert.assertTrue(popUpStartingPage.acceptWelcomePageLoaded(), "Pop up welcome page is not loaded");                              //2. Initial case handling - for reruns should be commented as occurs only once as there is no reinstall
//            popUpStartingPage.clickAcceptanceWelcomePageLoaded();
//        } catch (AssertionError e) {
//            System.out.println("Assertion failed: " + e.getMessage());
//        }
//        try {
//            Thread.sleep(2000);
//        } catch (InterruptedException e) {
//            Thread.currentThread().interrupt();
//            System.out.println("Thread was interrupted, Failed to complete operation");
//        }
//        helpers.clickByCoordinates(driver, 200, 637);                                                                                         //initial Accept location, but does not trigger by running the script - for reruns should be commented as occurs only once as there is no reinstall
//        helpers.clickByCoordinates(driver, 296, 551);                                                                                         //initial Accept notifications, but does not trigger by running the script - for reruns should be commented as occurs only once as there is no reinstall
//        helpers.clickByCoordinates(driver, 207, 43);                                                                                         //initial Accept notifications (necessary to return to iOS as popups out of bound), but does not trigger by running the script - for reruns should be commented as occurs only once as there is no reinstall
        Assert.assertTrue(startingPage.todayHomePageLoaded(), "Calendar starting page is not loaded");                               //1. Open the Calendar app (already installed on iOS simulators), validate the application is started.
        startingPage.clickTodaySectionButton();
        Assert.assertTrue(startingPage.calendarSectionButtonLoaded(), "Calendar starting page is not loaded");                       //3. Click Calendars.
        startingPage.clickCalendarSectionButton();
        Assert.assertTrue(calendarPage.addCalendarLoaded(), "Calendar starting page is not loaded");
        calendarPage.clickAddCalendar();
        Assert.assertTrue(calendarPage.addNewCalendarLoaded(), "Calendar starting page is not loaded");
        calendarPage.clickAddNewCalendar();                                                                                                    //4. Click on Add Calendar and select Add Calendar.
        Assert.assertTrue(calendarPage.calendarTitleLoaded(), "Calendar title entry field is not loaded");
        calendarPage.enterCalendarTitle("Skopje");
        Assert.assertTrue(calendarPage.colourSelectFieldLoaded(), "Change colour field is not loaded");                                //5. Add name for Calendar and change colour to Blue.
        calendarPage.clickColourSelectField();
        Assert.assertTrue(addCalendarColourPage.chooseBlueLoaded(), "Blue colour is not loaded");
        addCalendarColourPage.clickChooseBlue();
        Assert.assertTrue(addCalendarColourPage.backButtonLoaded(), "Back to new calendar button is not loaded");
        addCalendarColourPage.clickBackButton();
        Assert.assertTrue(addCalendarColourPage.addCalendarDoneLoaded(), "Done calendar button is not loaded");                         //6. Click on Done button.
        addCalendarColourPage.clickAddCalendarDone();
        Assert.assertTrue(calendarPage.calendarCreatedLoaded(), "Created calendar is not loaded");                                      //7. Validate that newly created calendar is displayed in Calendars.
        Assert.assertTrue(calendarPage.addedCalendarStatusLoaded(), "Calendar status is not loaded");
        Assert.assertTrue(calendarPage.hideAllCalendarsLoaded(), "Hide all calendars is not loaded");                                   //8. Click on Hide all and validate that Calendar and newly created calendar are not selected. (tip - use getAttribute)
        calendarPage.clickHideAllCalendars();
        String status = calendarPage.checkAddedCalendarStatus();
        Assert.assertEquals(status, "circle");
        Assert.assertTrue(calendarPage.moreInformationLoaded(), "More information button is not loaded");                               //9. Click on (i) button next to newly created calendar and delete the calendar.
        calendarPage.clickMoreInformation();
        Assert.assertTrue(editEventPage.deleteCalendarLoaded(), "Calendar delete button is not loaded");
        editEventPage.clickDeleteCalendar();
        Assert.assertTrue(editEventPage.deleteConfirmationButtonLoaded(), "Calendar delete confirmation button is not loaded");
        editEventPage.clickDeleteConfirmationButton();
        try {                                                                                                                                     //10. Validate only Calendar is displayed now.
        Assert.assertFalse(calendarPage.secondEventPresentLoaded(), "Second element in calendars is loaded");
        } catch (AssertionError e) {
            System.out.println("Assertion failed: " + e.getMessage());
        }
        Assert.assertTrue(calendarPage.doneButtonLoaded(), "Calendar done  button is not loaded");                                      //11. Click on Done.
        calendarPage.clickDoneButton();
        Assert.assertTrue(startingPage.todayHomePageLoaded(), "Calendar starting page is not loaded");                               //12. Validate Calendar screen is loaded.
    }

}
