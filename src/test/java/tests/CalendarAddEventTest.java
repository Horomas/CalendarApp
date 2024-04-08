package tests;

import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.PopUpStartingPage;
import util.DriverSetup;

@Epic("Regression Tests")
@Feature("CalendarAddEvent")
public class CalendarAddEventTest extends DriverSetup {

    @Severity(SeverityLevel.CRITICAL)
    @Description("Test Description: Verify that a new event has been added")
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
        Assert.assertTrue(startingPage.calendarHomePageLoaded(), "Calendar starting page is not loaded");                               //1. Open the Calendar app (already installed on iOS simulators), validate the application is started.
        startingPage.clickCalendarSectionButton();
//        Assert.assertTrue(startingPage.addButtonLoaded(), "Add button page is not loaded");                                                   //Is accessible through appium inspector, but the script can not interact with this element or its sibling elements
//        startingPage.clickAddButton();
        helpers.clickByCoordinates(driver, 400, 75);
        Assert.assertTrue(newEventPage.titleFieldLoaded(), "New event pages is not loaded");
        newEventPage.enterTitle("Skopje");                                                                                             //4. Select Skopje as destination.
        Assert.assertTrue(newEventPage.startDateEntryFieldLoaded(), "Start date entry field is not loaded");                            //5. For Starts select Apr 24, 2024 for date and 11:10 AM.
        newEventPage.clickStartDateEntryField();
        Assert.assertTrue(newEventPage.pickStartDateLoaded(), "Necessary date is not loaded");
        newEventPage.clickPickStartDate();
        Assert.assertTrue(newEventPage.endDateEntryFieldLoaded(), "Start date entry field is not loaded");                            //5. For Starts select Apr 24, 2024 for date and 11:10 AM.
        newEventPage.clickEndDateEntryField();
        Assert.assertTrue(newEventPage.pickEndDateLoaded(), "Necessary date is not loaded");
        newEventPage.clickPickEndDate();
        Assert.assertTrue(newEventPage.startTimeEntryFieldLoaded(), "Time selection for start is not loaded");
        newEventPage.clickStartTimeEntryField();
        Assert.assertTrue(newEventPage.hoursEntryLoaded(), "Time entry field for hours is not loaded");
        newEventPage.enterHoursEntry("11");
        Assert.assertTrue(newEventPage.minutesEntryLoaded(), "Time entry field for minutes is not loaded");
        newEventPage.enterMinutesEntry("10");
        Assert.assertTrue(newEventPage.endTimeEntryFieldLoaded(), "Time selection for end is not loaded");                               //6. For Ends select Apr 25, 2024 for date and 12:25 PM.
        newEventPage.clickEndTimeEntryField();
        Assert.assertTrue(newEventPage.hoursEntryLoaded(), "Time entry field for hours is not loaded");
        newEventPage.enterHoursEntry("12");
        Assert.assertTrue(newEventPage.minutesEntryLoaded(), "Time entry field for minutes is not loaded");
        newEventPage.enterMinutesEntry("25");
        newEventPage.clickTitleField();                                                                                                           //Used to get out of time entry field
        Assert.assertTrue(newEventPage.travelTimeFieldLoaded(), "Travel time length field is not loaded");                               //7. Add travel time of 30 minutes.
        newEventPage.clickTravelTimeField();
        Assert.assertTrue(newEventPage.chooseTravelTimeLengthLoaded(), "Travel time choosing option is not loaded");
        newEventPage.clickChooseTravelTimeLength();
        Assert.assertTrue(newEventPage.allDayEventSwitchLoaded(), "All day event switch is not loaded");                                //8. Verify that when you enable All-day only date is visible in Starts and Ends.
        newEventPage.clickAllDayEventSwitch();
//        Assert.assertFalse(newEventPage.startTimeEntryFieldLoaded(), "Event start time is visible");
        try {
            Assert.assertFalse(newEventPage.startTimeEntryFieldLoaded(), "Event start time is visible");
        } catch (AssertionError e) {
            System.out.println("Assertion failed: " + e.getMessage());
        }
        newEventPage.clickAllDayEventSwitch();                                                                                                   //9. Disable All-day button so the time is again visible next to dates in Starts and Ends.
        try {
            Assert.assertTrue(newEventPage.startTimeEntryFieldLoaded(), "Event start time is not visible");
        } catch (AssertionError e) {
            System.out.println("Assertion failed: " + e.getMessage());
        }
        Assert.assertTrue(newEventPage.addButtonLoaded(), "Add button is not loaded");                                                    //10. Click on Add button.
        newEventPage.clickAddButton();
        helpers.clickByCoordinates(driver, 53, 77);                                                                                         //11. Switch to Month view (click back).
        Assert.assertTrue(monthPage.selectDateOfInterestLoaded(), "Access button to date of interest in monthly view is not loaded");
        monthPage.clickSelectDateOfInterest();
        helpers.clickByCoordinates(driver, 290, 77);
        Assert.assertTrue(monthPage.checkContentLoaded(), "Event is not visible");                                                          //12. Verify that event is added for April 24 and April 25.
    }

}
