package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TripInformationEntryPage;
import util.DriverSetup;
import util.Helpers;

public class FavoritingTest extends DriverSetup {

    @Test(testName = "Favoriting test")
    public void calendarTest() {

        Assert.assertTrue(cookiePage.cookiePageLoaded(), "Cookie page is not loaded");
        cookiePage.clickAcceptCookieButton();
        try {
            // Attempt to assert that the notifications page is loaded
            Assert.assertTrue(acceptNotificationsPage.notificationsPageLoaded(), "Notifications page is not loaded");
            // If the assertion passes, click the accept notifications button
            acceptNotificationsPage.clickAcceptNotificationsButton();
        } catch (AssertionError e) {
            // Handle the assertion error if the notifications page is not loaded
            System.out.println("Assertion failed: " + e.getMessage());
            // Optionally, rethrow the exception or perform other actions
        }

        try {
            // Attempt to assert that the notifications popup button is loaded
            Assert.assertTrue(acceptNotificationsPage.notificationsPopupButtonLoaded(), "Notifications pop-up page is not loaded");
            // If the assertion passes, click the allow notifications popup button
            acceptNotificationsPage.clickAllowNotificationsPopUpButton();
        } catch (AssertionError e) {
            // Handle the assertion error if the notifications popup button is not loaded
            System.out.println("Assertion failed: " + e.getMessage());
            // Optionally, rethrow the exception or perform other actions
        }

        Assert.assertTrue(loginPage.loginPageLoaded(), "Login skip page is not loaded");
        loginPage.clickLoginSkipButton();

        Assert.assertTrue(tripInformationEntryPage.tripInformationEntryPageLoaded(), "Trip information entry page is not loaded");
        tripInformationEntryPage.clickDestinationField();
        tripInformationEntryPage.enterDestination("Skopje");
        Assert.assertTrue(tripInformationEntryPage.selectFirstOptionAvailable(), "Results are not visible");
        tripInformationEntryPage.clickFirst();
        Assert.assertTrue(tripInformationEntryPage.selectDateStartLoaded(), "Start date is not available");
        tripInformationEntryPage.clickStartDate();
        Assert.assertTrue(tripInformationEntryPage.selectDateEndLoaded(), "End date is not available");
        tripInformationEntryPage.clickEndDate();
        Assert.assertTrue(tripInformationEntryPage.selectDateButtonLoaded(), "Confirm button was not found");
        tripInformationEntryPage.clickSelectDatesButton();
        Assert.assertTrue(tripInformationEntryPage.roomSelectionLoaded(), "Room selection was not loaded");
        tripInformationEntryPage.clickRoomSelection();
        Assert.assertTrue(tripInformationEntryPage.increaseRoomsLoaded(), "Room increase options was not loaded");
        tripInformationEntryPage.clickRoomIncreaseButton();
        Assert.assertTrue(tripInformationEntryPage.increaseAdultsLoaded(), "Adults increase options was not loaded");
        tripInformationEntryPage.clickAdultIncreaseButton();
        Assert.assertTrue(tripInformationEntryPage.applyButtonToTripInformation(), "Apply button to trip information was not loaded");
        tripInformationEntryPage.clickApplyChangesToTrip();
        Assert.assertTrue(tripInformationEntryPage.searchForTripLoaded(), "Search for trip was not loaded");
        tripInformationEntryPage.clickSearchForTripButton();
        Assert.assertTrue(tripInformationEntryPage.searchDestinationLoaded(), "Search trip destination was not loaded");
        Assert.assertTrue(tripInformationEntryPage.getTripDataDestination("Skopje"), "Text does not equal 'Skopje'");
        Assert.assertTrue(tripInformationEntryPage.searchDateLoaded(), "Search trip destination was not loaded");
        Assert.assertTrue(tripInformationEntryPage.getTripDataDate("Apr 24 - Apr 28"), "Text does not equal 'Apr 24 - Apr 28'");
        Assert.assertTrue(searchResultsPage.favouritesFirstResultLoaded(), "Favourite first search result is loaded");
        searchResultsPage.clickFavouriteFirstButton();
    }
}
