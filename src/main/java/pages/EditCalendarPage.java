package pages;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.GlobalVariables;

public class EditCalendarPage {
    protected IOSDriver driver;


    @iOSXCUITFindBy(accessibility = "Delete Calendar")
    private RemoteWebElement deleteCalendar;
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`name == \"Delete Calendar\"`]")
    private RemoteWebElement deleteConfirmationButton;


    public EditCalendarPage(IOSDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @Step("Delete button is loaded")
    public boolean deleteCalendarLoaded() {
        return new WebDriverWait(driver, GlobalVariables.globalTimeout).until(ExpectedConditions.visibilityOf(deleteCalendar)).isDisplayed();
    }
    @Step("Delete popup confirmation button is loaded")
    public boolean deleteConfirmationButtonLoaded() {
        return new WebDriverWait(driver, GlobalVariables.globalTimeout).until(ExpectedConditions.visibilityOf(deleteConfirmationButton)).isDisplayed();
    }


    @Step("Click to delete calendar")
    public void clickDeleteCalendar() {
        deleteCalendar.click();
    }
    @Step("Click to delete calendar")
    public void clickDeleteConfirmationButton() {
        deleteConfirmationButton.click();
    }
}
