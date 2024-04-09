package pages;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITBy;
import io.appium.java_client.pagefactory.iOSXCUITFindAll;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.GlobalVariables;

public class CalendarPage {
    protected IOSDriver driver;


    @iOSXCUITFindBy(accessibility = "Add Calendar")
    private RemoteWebElement addCalendar;
    @iOSXCUITFindBy(xpath = "((//XCUIElementTypeButton[@name='Add Calendar'])[2])[1]")
    private RemoteWebElement addNewCalendar;
    @iOSXCUITFindBy(className = "XCUIElementTypeTextField")
    private RemoteWebElement calendarTitle;
    @iOSXCUITFindBy(accessibility = "Purple")
    private RemoteWebElement colourSelectField;
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`name == \"Skopje\"`]")
    private RemoteWebElement calendarCreated;
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeImage)[2]")
    private RemoteWebElement addedCalendarStatus;
    @iOSXCUITFindAll({
            @iOSXCUITBy(accessibility = "Hide All"),
            @iOSXCUITBy(accessibility = "Show All")
    })
    private RemoteWebElement hideAllCalendars;


    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTable/XCUIElementTypeCell[2]/XCUIElementTypeButton")
    private RemoteWebElement moreInformation;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTable/XCUIElementTypeCell[2]/XCUIElementTypeButton[@name='More Info']")
    private RemoteWebElement secondEventPresent;
   @iOSXCUITFindBy(accessibility = "Done")
    private RemoteWebElement doneButton;


    public CalendarPage(IOSDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
    @Step("Calendar section button is loaded")
    public boolean addCalendarLoaded() {
        return new WebDriverWait(driver, GlobalVariables.globalTimeout).until(ExpectedConditions.visibilityOf(addCalendar)).isDisplayed();
    }
    @Step("Option to add a new calendar to calendars")
    public boolean addNewCalendarLoaded() {
        return new WebDriverWait(driver, GlobalVariables.globalTimeout).until(ExpectedConditions.visibilityOf(addNewCalendar)).isDisplayed();
    }
    @Step("Calendar title field is loaded")
    public boolean calendarTitleLoaded() {
        return new WebDriverWait(driver, GlobalVariables.globalTimeout).until(ExpectedConditions.visibilityOf(calendarTitle)).isDisplayed();
    }
    @Step("Calendar colour choice field is loaded")
    public boolean colourSelectFieldLoaded() {
        return new WebDriverWait(driver, GlobalVariables.globalTimeout).until(ExpectedConditions.visibilityOf(colourSelectField)).isDisplayed();
    }
    @Step("New calendar is loaded")
    public boolean calendarCreatedLoaded() {
        return new WebDriverWait(driver, GlobalVariables.globalTimeout).until(ExpectedConditions.visibilityOf(calendarCreated)).isDisplayed();
    }
    @Step("Calendar status is loaded")
    public boolean addedCalendarStatusLoaded() {
        return new WebDriverWait(driver, GlobalVariables.globalTimeout).until(ExpectedConditions.visibilityOf(addedCalendarStatus)).isDisplayed();
    }
    @Step("Hide all calendars switch")
    public boolean hideAllCalendarsLoaded() {
        return new WebDriverWait(driver, GlobalVariables.globalTimeout).until(ExpectedConditions.visibilityOf(hideAllCalendars)).isDisplayed();
    }
    @Step("More information is loaded")
    public boolean moreInformationLoaded() {
        return new WebDriverWait(driver, GlobalVariables.globalTimeout).until(ExpectedConditions.visibilityOf(moreInformation)).isDisplayed();
    }
    @Step("Done button in calendars is loaded")
    public boolean doneButtonLoaded() {
        return new WebDriverWait(driver, GlobalVariables.globalTimeout).until(ExpectedConditions.visibilityOf(doneButton)).isDisplayed();
    }

    @Step("Second event element is loaded")
    public boolean secondEventPresentLoaded() {
        try {
            return new WebDriverWait(driver, GlobalVariables.globalTimeout)
                    .until(ExpectedConditions.visibilityOf(secondEventPresent))
                    .isDisplayed();
        } catch (TimeoutException e) {
            System.out.println("Second Calendars element is not visible within time" + e.getMessage());
            return false;
        } catch (NoSuchElementException e) {
            System.out.println("The element was not found: " + e.getMessage());
            return false;
        }
    }
    @Step("Enter minutes for event start")
    public void enterCalendarTitle(String title) {
        calendarTitle.click();
        calendarTitle.sendKeys(title);
    }
    @Step("Add button is pressed")
    public void clickAddCalendar() {
        addCalendar.click();
    }
    @Step("Add button is pressed")
    public String checkAddedCalendarStatus() {
        return addedCalendarStatus.getAttribute("name");
    }
    @Step("Add button is pressed")
    public void clickCalendarCreated() {
        calendarCreated.click();
    }
    @Step("Click on calendar colour choice button")
    public void clickColourSelectField() {
        colourSelectField.click();
    }
    @Step("Add new calendar button is pressed")
    public void clickAddNewCalendar() {
        addNewCalendar.click();
    }
    @Step("Add new calendar button is pressed")
    public void clickHideAllCalendars() {
        hideAllCalendars.click();
    }
    @Step("More information on the event")
    public void clickMoreInformation() {
        moreInformation.click();
    }

    @Step("Click on calendars done button")
    public void clickDoneButton() {
        doneButton.click();
    }
}
