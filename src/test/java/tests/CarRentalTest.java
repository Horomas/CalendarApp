package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import util.DriverSetup;
import util.Helpers;

public class CarRentalTest extends DriverSetup {

    @Test(testName = "Car rental test")
    public void bookingTest2() {
        Assert.assertTrue(cookiePage.cookiePageLoaded(), "Cookie page is not loaded");                                                          //1. Start the Booking application and continue without sign in.
        cookiePage.clickAcceptCookieButton();
//        try {
//            // Attempt to assert that the notifications page is loaded
//            Assert.assertTrue(acceptNotificationsPage.notificationsPageLoaded(), "Notifications page is not loaded");
//            // If the assertion passes, click the accept notifications button
//            acceptNotificationsPage.clickAcceptNotificationsButton();
//        } catch (AssertionError e) {
//            // Handle the assertion error if the notifications page is not loaded
//            System.out.println("Assertion failed: " + e.getMessage());
//            // Optionally, rethrow the exception or perform other actions
//        }
//
//        try {
//            // Attempt to assert that the notifications popup button is loaded
//            Assert.assertTrue(acceptNotificationsPage.notificationsPopupButtonLoaded(), "Notifications pop-up page is not loaded");
//            // If the assertion passes, click the allow notifications popup button
//            acceptNotificationsPage.clickAllowNotificationsPopUpButton();
//        } catch (AssertionError e) {
//            // Handle the assertion error if the notifications popup button is not loaded
//            System.out.println("Assertion failed: " + e.getMessage());
//            // Optionally, rethrow the exception or perform other actions
//        }
        Assert.assertTrue(loginPage.loginPageLoaded(), "Login skip page is not loaded");
        loginPage.clickLoginSkipButton();
        Assert.assertTrue(tripInformationEntryPage.signInSectionButtonLoaded(), "Sign in section button is not loaded");                            //2. Navigate to Sign in tab.
        tripInformationEntryPage.clickSignInSectionButton();
        Assert.assertTrue(signInPage.geniusLoyaltyButtonLoaded(), "Genius loyalty section button is not loaded");                                   //3. Click on Genius loyalty program.
        signInPage.clickGeniusLoyaltyButton();
        Assert.assertTrue(geniusLoyaltyPage.aboutGeniusContentLoaded(), "Genius loyalty section button is not loaded");
        helpers.swipeVertically(driver, Helpers.Directions.UP,3);                                                                              //4. Scroll down to About Genius Levels and click on it.
        geniusLoyaltyPage.clickAboutGenius();
        helpers.swipeHorizontally(driver, Helpers.Directions.LEFT, 3);                                                                         //5. Swipe right to Genius Level 3 and validate that it is displayed.
        Assert.assertTrue(aboutGeniusPage.aboutGeniusContentLoaded(), "About Genius Level 3 is not loaded");
        Assert.assertTrue(aboutGeniusPage.gotItButtonLoaded(), "Got ot button is not loaded");
        aboutGeniusPage.clickGotItButton();                                                                                                                  //6. Click on Got it button.
        Assert.assertTrue(searchResultsPage.backToSearchLoaded(), "Back to search is not loaded");                                                  //7. Click on back button.
        searchResultsPage.clickBackToSearchButton();
        Assert.assertTrue(signInPage.savedButtonLoaded(), "Saved button is not loaded");                                                            //8. Navigate to Search tab.
        signInPage.clickSavedButton();

    }

}
