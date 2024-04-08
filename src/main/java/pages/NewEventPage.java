package pages;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.GlobalVariables;

public class NewEventPage {

    protected IOSDriver driver;


    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Add']")
    private RemoteWebElement newEventPageContent;

    @iOSXCUITFindBy(accessibility = "Title")
    private RemoteWebElement titleField;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton[@name='Date and Time Picker']/XCUIElementTypeButton[1])[1]")
    private RemoteWebElement startDateEntryField;
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton[@name='Date and Time Picker']/XCUIElementTypeButton[1])")
    private RemoteWebElement endDateEntryField;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton[@name='Date and Time Picker']/XCUIElementTypeButton[2])[1]")
    private RemoteWebElement startTimeEntryField;
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton[@name='Date and Time Picker']/XCUIElementTypeButton[2])[1]")
    private RemoteWebElement endTimeEntryField;
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`name == \"24\"`]")
    private RemoteWebElement pickStartDate;
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`name == \"25\"`]")
    private RemoteWebElement pickEndDate;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypePickerWheel[1]") //sendkeys
    private RemoteWebElement hoursEntry;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypePickerWheel[2]") // sendkeys
    private RemoteWebElement minutesEntry;
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeCell[`name == 'Travel Time'`]/XCUIElementTypeOther[1]/XCUIElementTypeOther")
    private RemoteWebElement travelTimeField;
    @iOSXCUITFindBy(accessibility = "30 minutes")
    private RemoteWebElement chooseTravelTimeLength;

    @iOSXCUITFindBy(className = "XCUIElementTypeSwitch")
    private RemoteWebElement allDayEventSwitch;
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton[@name='Add'])[2]")
    private RemoteWebElement addButton;


    public NewEventPage(IOSDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
    @Step("Title field is loaded")
    public boolean titleFieldLoaded() {
        return new WebDriverWait(driver, GlobalVariables.globalTimeout).until(ExpectedConditions.visibilityOf(titleField)).isDisplayed();
    }

    @Step("Calendar section button is loaded")
    public boolean newEventPageContentLoaded() {
        return new WebDriverWait(driver, GlobalVariables.globalTimeout).until(ExpectedConditions.visibilityOf(newEventPageContent)).isDisplayed();
    }
    @Step("Start date entry field is loaded")
    public boolean startDateEntryFieldLoaded() {
        return new WebDriverWait(driver, GlobalVariables.globalTimeout).until(ExpectedConditions.visibilityOf(startDateEntryField)).isDisplayed();
    }
    @Step("End date entry field is loaded")
    public boolean endDateEntryFieldLoaded() {
        return new WebDriverWait(driver, GlobalVariables.globalTimeout).until(ExpectedConditions.visibilityOf(endDateEntryField)).isDisplayed();
    }

//    @Step("Start time entry field is loaded")
//    public boolean startTimeEntryFieldLoaded() {
//        return new WebDriverWait(driver, GlobalVariables.globalTimeout).until(ExpectedConditions.visibilityOf(startTimeEntryField)).isDisplayed();
//    }

    @Step("Start time entry field is loaded")
    public boolean startTimeEntryFieldLoaded() {
        try {
            return new WebDriverWait(driver, GlobalVariables.globalTimeout)
                    .until(ExpectedConditions.visibilityOf(startTimeEntryField))
                    .isDisplayed();
        } catch (TimeoutException e) {
            System.out.println("Event start time is not visible within time" + e.getMessage());
            return false;
        } catch (NoSuchElementException e) {
            System.out.println("The event start time was not found: " + e.getMessage());
            return false;
        }
    }
    @Step("End time entry field is loaded")
    public boolean endTimeEntryFieldLoaded() {
        return new WebDriverWait(driver, GlobalVariables.globalTimeout).until(ExpectedConditions.visibilityOf(endTimeEntryField)).isDisplayed();
    }
    @Step("Necessary start date is loaded")
    public boolean pickStartDateLoaded() {
        return new WebDriverWait(driver, GlobalVariables.globalTimeout).until(ExpectedConditions.visibilityOf(pickStartDate)).isDisplayed();
    }
    @Step("Necessary end date is loaded")
    public boolean pickEndDateLoaded() {
        return new WebDriverWait(driver, GlobalVariables.globalTimeout).until(ExpectedConditions.visibilityOf(pickEndDate)).isDisplayed();
    }

    @Step("Enter start hours for the event")
    public boolean hoursEntryLoaded() {
        return new WebDriverWait(driver, GlobalVariables.globalTimeout).until(ExpectedConditions.visibilityOf(hoursEntry)).isDisplayed();
    }
    @Step("Enter start minutes is loaded")
    public boolean minutesEntryLoaded() {
        return new WebDriverWait(driver, GlobalVariables.globalTimeout).until(ExpectedConditions.visibilityOf(minutesEntry)).isDisplayed();
    }

    @Step("Enter travel time field is loaded")
    public boolean travelTimeFieldLoaded() {
        return new WebDriverWait(driver, GlobalVariables.globalTimeout).until(ExpectedConditions.visibilityOf(travelTimeField)).isDisplayed();
    }
    @Step("Pick travel length time is loaded")
    public boolean chooseTravelTimeLengthLoaded() {
        return new WebDriverWait(driver, GlobalVariables.globalTimeout).until(ExpectedConditions.visibilityOf(chooseTravelTimeLength)).isDisplayed();
    }
    @Step("Switch all day event status")
    public boolean allDayEventSwitchLoaded() {
        return new WebDriverWait(driver, GlobalVariables.globalTimeout).until(ExpectedConditions.visibilityOf(allDayEventSwitch)).isDisplayed();
    }
    @Step("Switch all day event status")
    public boolean addButtonLoaded() {
        return new WebDriverWait(driver, GlobalVariables.globalTimeout).until(ExpectedConditions.visibilityOf(addButton)).isDisplayed();
    }



    @Step("Add button is pressed")
    public void clickNewEventPageContent() {
        newEventPageContent.click();
    }
    @Step("Start date is pressed")
    public void clickStartDateEntryField() {
        startDateEntryField.click();
    }
    @Step("End date is pressed")
    public void clickEndDateEntryField() {
        endDateEntryField.click();
    }

    @Step("Start time is pressed")
    public void clickStartTimeEntryField() {
        startTimeEntryField.click();
    }
    @Step("End time is pressed")
    public void clickEndTimeEntryField() {
        endTimeEntryField.click();
    }

    @Step("Chosen start date is picked")
    public void clickPickStartDate() {
        pickStartDate.click();
    }
    @Step("Chosen start date is picked")
    public void clickPickEndDate() {
        pickEndDate.click();
    }

    @Step("Click travel time field")
    public void clickTravelTimeField() {
        travelTimeField.click();
    }
    @Step("Choose travel time")
    public void clickChooseTravelTimeLength() {
        chooseTravelTimeLength.click();
    }
    @Step("Click on all day event")
    public void clickAllDayEventSwitch() {
        allDayEventSwitch.click();
    }
    @Step("Click new event title")
    public void clickTitleField() {
        titleField.click();
    }
    @Step("Click add button")
    public void clickAddButton() {
        addButton.click();
    }

    @Step("Enter hours for event start")
    public void enterHoursEntry(String hours) {
        hoursEntry.click();
        hoursEntry.sendKeys(hours);
    }

    @Step("Enter minutes for event start")
    public void enterMinutesEntry(String minutes) {
        minutesEntry.click();
        minutesEntry.sendKeys(minutes);
    }
    @Step("Enter destination")
    public void enterTitle(String destination) {
        titleField.clear();
        titleField.sendKeys(destination);
    }
}
