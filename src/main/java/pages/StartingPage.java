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

public class StartingPage {

    protected IOSDriver driver;


    @iOSXCUITFindBy(accessibility = "Today")
    private RemoteWebElement todaySectionButton;
    @iOSXCUITFindBy(accessibility = "Calendars")
    private RemoteWebElement calendarSectionButton;
    @iOSXCUITFindBy(accessibility = "Add")
    private RemoteWebElement addButton;

    public StartingPage(IOSDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
    @Step("Calendar section button is loaded")
    public boolean todayHomePageLoaded() {
        return new WebDriverWait(driver, GlobalVariables.globalTimeout).until(ExpectedConditions.visibilityOf(todaySectionButton)).isDisplayed();
    }
    @Step("Add button is loaded")
    public boolean addButtonLoaded() {
        return new WebDriverWait(driver, GlobalVariables.globalTimeout).until(ExpectedConditions.visibilityOf(addButton)).isDisplayed();
    }
    @Step("Calendar section button is loaded")
    public boolean calendarSectionButtonLoaded() {
        return new WebDriverWait(driver, GlobalVariables.globalTimeout).until(ExpectedConditions.visibilityOf(calendarSectionButton)).isDisplayed();
    }

    @Step("Calendar section button is pressed")
    public void clickTodaySectionButton() {
        todaySectionButton.click();
    }

    @Step("Calendar section button is pressed")
    public void clickCalendarSectionButton() {
        calendarSectionButton.click();
    }
    @Step("Add button is pressed")
    public void clickAddButton() {
        addButton.click();
    }
}
