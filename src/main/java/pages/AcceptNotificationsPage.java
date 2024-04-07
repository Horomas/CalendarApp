package pages;


import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.qameta.allure.Step;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.GlobalVariables;

public class AcceptNotificationsPage {
    protected AndroidDriver driver;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='OK']")
    private RemoteWebElement acceptNotificationsButton;

    @AndroidFindBy(id = "com.android.permissioncontroller:id/permission_allow_button")
    private RemoteWebElement allowNotificationsPopUpButton;


    public AcceptNotificationsPage(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

//    public boolean notificationsPageLoaded() {
//        return new WebDriverWait(driver, GlobalVariables.globalTimeout).until(ExpectedConditions.visibilityOf(acceptNotificationsButton)).isDisplayed();
//    }
//
//    public boolean notificationsPageLoaded() {
//        try {
//            // Attempt to wait for the visibility of the allowNotificationsPopUpButton and check if it is displayed
//            return new WebDriverWait(driver, GlobalVariables.globalTimeout)
//                    .until(ExpectedConditions.visibilityOf(acceptNotificationsButton))
//                    .isDisplayed();
//        } catch (NoSuchElementException e) {
//            // Handle the case where the allowNotificationsPopUpButton is not found
//            System.out.println("The notifications popup button was not found: " + e.getMessage());
//            return false;
//        }
//    }
    @Step("Notifications page is loaded")
    public boolean notificationsPageLoaded() {
        try {
            // Attempt to wait for the visibility of the allowNotificationsPopUpButton and check if it is displayed
            return new WebDriverWait(driver, GlobalVariables.globalTimeout)
                    .until(ExpectedConditions.visibilityOf(acceptNotificationsButton))
                    .isDisplayed();
        } catch (TimeoutException e) {
            // Handle the case where the element is not found within the timeout period
            System.out.println("The notifications popup button was not found within the timeout period: " + e.getMessage());
            return false;
        } catch (NoSuchElementException e) {
            // Handle the case where the allowNotificationsPopUpButton is not found at all
            System.out.println("The notifications popup button was not found: " + e.getMessage());
            return false;
        }
    }
    @Step("Notifications popup is loaded")
    public boolean notificationsPopupButtonLoaded() {
        try {
            // Attempt to wait for the visibility of the allowNotificationsPopUpButton and check if it is displayed
            return new WebDriverWait(driver, GlobalVariables.globalTimeout)
                    .until(ExpectedConditions.visibilityOf(allowNotificationsPopUpButton))
                    .isDisplayed();
        } catch (TimeoutException e) {
            // Handle the case where the element is not found within the timeout period
            System.out.println("The notifications popup button was not found within the timeout period: " + e.getMessage());
            return false;
        } catch (NoSuchElementException e) {
            // Handle the case where the allowNotificationsPopUpButton is not found at all
            System.out.println("The notifications popup button was not found: " + e.getMessage());
            return false;
        }
    }
    @Step("Notifications are accepted")
    public void clickAcceptNotificationsButton() {
            acceptNotificationsButton.click();
    }

    @Step("Notifications are accepted")
    public void clickAllowNotificationsPopUpButton() {
            allowNotificationsPopUpButton.click();
    }
}

