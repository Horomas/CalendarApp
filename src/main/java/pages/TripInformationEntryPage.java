package pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.qameta.allure.Step;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.GlobalVariables;

public class TripInformationEntryPage {

    protected AndroidDriver driver;

    @AndroidFindBy(accessibility = "Enter your destination")
    private RemoteWebElement enterDestinationField;

    @AndroidFindBy(id = "com.booking:id/facet_with_bui_free_search_booking_header_toolbar_content")
    private RemoteWebElement destinationFieldPopup;


    @FindAll({
        @FindBy(xpath = "//androidx.recyclerview.widget.RecyclerView[@resource-id='com.booking:id/facet_disambiguation_content']/android.view.ViewGroup[1]"),
        @FindBy(xpath = "(//android.widget.ImageView[@resource-id='com.booking:id/view_disambiguation_destination_icon'])[1]"),
        @FindBy(xpath = "//androidx.compose.ui.platform.ComposeView[@resource-id='com.booking:id/facet_with_bui_free_search_booking_header_content']/android.view.View/android.view.View/android.view.View[1]")
    })
    private RemoteWebElement selectFirst;


    @AndroidFindBy(accessibility = "24 April 2024")
    private RemoteWebElement enterDateStart;

    @AndroidFindBy(accessibility = "28 April 2024")
    private RemoteWebElement enterDateEnd;
    @AndroidFindBy(accessibility = "24 April 2024")
    private RemoteWebElement enterDatePickup;

    @AndroidFindBy(accessibility = "27 April 2024")
    private RemoteWebElement enterDateDropoff;
    @AndroidFindBy(id = "com.booking:id/calendar_confirm")
    private RemoteWebElement confirmChosenDates;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='8:15 AM']")
    private RemoteWebElement choosePickupTime;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='11:00 AM']")
    private RemoteWebElement chooseDropoffTime;


    @AndroidFindBy(id = "com.booking:id/facet_date_picker_confirm")
    private RemoteWebElement selectDatesButton;


    @AndroidFindBy(xpath = "//android.widget.Button[contains(@content-desc, 'room')]")
    private RemoteWebElement chooseRooms;
    @AndroidFindBy(xpath = "//android.view.ViewGroup[@resource-id='com.booking:id/group_config_rooms_count']//android.widget.Button[@content-desc='Increase']")
    private RemoteWebElement increaseRooms;
    @AndroidFindBy(xpath = "//android.view.ViewGroup[@resource-id='com.booking:id/group_config_adults_count']//android.widget.Button[@content-desc='Increase']")
    private RemoteWebElement increaseAdults;
    @AndroidFindBy(xpath = "//android.view.ViewGroup[@resource-id='com.booking:id/group_config_children_count']//android.widget.Button[@content-desc='Increase']")
    private RemoteWebElement increaseChildren;
    @AndroidFindBy(id = "com.booking:id/group_config_apply_button")
    private RemoteWebElement applyChangesToTripInformation;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Accommodation search box']/android.view.View/android.widget.Button")
    private RemoteWebElement searchForTrip;
    @AndroidFindBy(id = "com.booking:id/searchbox_destination")
    private RemoteWebElement searchDataDestination;
    @AndroidFindBy(id = "com.booking:id/searchbox_dates")
    private RemoteWebElement searchDataDate;

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.booking:id/facet_entry_point_item_label' and @text='Car rental']")
    private RemoteWebElement carRentalButton;
    @AndroidFindBy(accessibility = "Selected, you will return the car to the same location")
    private RemoteWebElement returnSameLocationSwitch;
    @AndroidFindBy(accessibility = "Enter a pick-up location")
    private RemoteWebElement pickupLocationField;
    @AndroidFindBy(accessibility = "Enter a drop-off location")
    private RemoteWebElement dropoffLocationField;

    @AndroidFindBy(id = "com.booking:id/search_query_edittext")
    private RemoteWebElement enterDestionation;
    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.booking:id/ape_rc_view_location_name' and @text='Skopje']")
    private RemoteWebElement choosingPickupContent;
    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.booking:id/ape_rc_view_location_name' and @text='Ohrid']")
    private RemoteWebElement choosingDropoffContent;
    @AndroidFindBy(accessibility = "Pick-up date: 2024-04-08")
    private RemoteWebElement choosePickupDateField;
    @AndroidFindBy(accessibility = "Pick-up time: 10:00:00.000")
    private RemoteWebElement choosePickupTimeField;
    @AndroidFindBy(accessibility = "Drop-off time: 10:00:00.000")
    private RemoteWebElement chooseDropoffTimeField;
    @AndroidFindBy(accessibility = "Enter the driver's age")
    private RemoteWebElement driversAgeField;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Search']")
    private RemoteWebElement searchButton;



    public TripInformationEntryPage(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @Step("Trip information entry field is loaded")
    public boolean tripInformationEntryPageLoaded() {
        return new WebDriverWait(driver, GlobalVariables.globalTimeout).until(ExpectedConditions.visibilityOf(enterDestinationField)).isDisplayed();
    }


    @Step("First option from search is available")
    public boolean selectFirstOptionAvailable() {
        return new WebDriverWait(driver, GlobalVariables.globalTimeout).until(ExpectedConditions.visibilityOf(selectFirst)).isDisplayed();
    }

    @Step("Start date is loaded")
    public boolean selectDateStartLoaded() {
        return new WebDriverWait(driver, GlobalVariables.globalTimeout).until(ExpectedConditions.visibilityOf(enterDateStart)).isDisplayed();
    }
    @Step("End date is loaded")
    public boolean selectDateEndLoaded() {
        return new WebDriverWait(driver, GlobalVariables.globalTimeout).until(ExpectedConditions.visibilityOf(enterDateEnd)).isDisplayed();
    }
    @Step("Confirm dates button is loaded")
    public boolean selectDateButtonLoaded() {
        return new WebDriverWait(driver, GlobalVariables.globalTimeout).until(ExpectedConditions.visibilityOf(selectDatesButton)).isDisplayed();
    }

    @Step("Enter destination popup field is loaded")
    public boolean enterDestination() {
        return new WebDriverWait(driver, GlobalVariables.globalTimeout).until(ExpectedConditions.visibilityOf(destinationFieldPopup)).isDisplayed();
    }

    @Step("Trip detail change field is loaded")
    public boolean roomSelectionLoaded() {
        return new WebDriverWait(driver, GlobalVariables.globalTimeout).until(ExpectedConditions.visibilityOf(chooseRooms)).isDisplayed();
    }
    @Step("Increase rooms button is loaded")
    public boolean increaseRoomsLoaded() {
        return new WebDriverWait(driver, GlobalVariables.globalTimeout).until(ExpectedConditions.visibilityOf(increaseRooms)).isDisplayed();
    }
    @Step("Increase adults button is loaded")
    public boolean increaseAdultsLoaded() {
        return new WebDriverWait(driver, GlobalVariables.globalTimeout).until(ExpectedConditions.visibilityOf(increaseAdults)).isDisplayed();
    }

    @Step("Apply changes to trip details button is loaded")
    public boolean applyButtonToTripInformation() {
        return new WebDriverWait(driver, GlobalVariables.globalTimeout).until(ExpectedConditions.visibilityOf(applyChangesToTripInformation)).isDisplayed();
    }
    @Step("Show search results button are loaded")
    public boolean searchForTripLoaded() {
        return new WebDriverWait(driver, GlobalVariables.globalTimeout).until(ExpectedConditions.visibilityOf(searchForTrip)).isDisplayed();
    }

    @Step("Search data loaded")
    public boolean searchDateLoaded() {
        return new WebDriverWait(driver, GlobalVariables.globalTimeout).until(ExpectedConditions.visibilityOf(searchDataDestination)).isDisplayed();
    }

    @Step("Search results for trips is loaded")
    public boolean searchDestinationLoaded() {
        return new WebDriverWait(driver, GlobalVariables.globalTimeout).until(ExpectedConditions.visibilityOf(searchDataDate)).isDisplayed();
    }
    @Step("Car rental link is loaded")
    public boolean carRentalButtonLoaded() {
        return new WebDriverWait(driver, GlobalVariables.globalTimeout).until(ExpectedConditions.visibilityOf(carRentalButton)).isDisplayed();
    }
    @Step("Return same location switch is loaded")
    public boolean returnSameLocationSwitchLoaded() {
        return new WebDriverWait(driver, GlobalVariables.globalTimeout).until(ExpectedConditions.visibilityOf(returnSameLocationSwitch)).isDisplayed();
    }
    @Step("Pick up location field is loaded")
    public boolean pickupLocationFieldLoaded() {
        return new WebDriverWait(driver, GlobalVariables.globalTimeout).until(ExpectedConditions.visibilityOf(pickupLocationField)).isDisplayed();
    }
    @Step("Drop off location field is loaded")
    public boolean dropoffLocationFieldLoaded() {
        return new WebDriverWait(driver, GlobalVariables.globalTimeout).until(ExpectedConditions.visibilityOf(dropoffLocationField)).isDisplayed();
    }
    @Step("Search results for pickup location loaded")
    public boolean choosePickupContentLoaded() {
        return new WebDriverWait(driver, GlobalVariables.globalTimeout).until(ExpectedConditions.visibilityOf(choosingPickupContent)).isDisplayed();
    }
    @Step("Search results for dropoff location loaded")
    public boolean chooseDropoffContentLoaded() {
        return new WebDriverWait(driver, GlobalVariables.globalTimeout).until(ExpectedConditions.visibilityOf(choosingDropoffContent)).isDisplayed();
    }
    @Step("Choose car pickup date is loaded")
    public boolean chooseCarPickupDateLoaded() {
        return new WebDriverWait(driver, GlobalVariables.globalTimeout).until(ExpectedConditions.visibilityOf(choosePickupDateField)).isDisplayed();
    }
    @Step("Choose pick up time is loaded")
    public boolean choosePickupTimeFieldLoaded() {
        return new WebDriverWait(driver, GlobalVariables.globalTimeout).until(ExpectedConditions.visibilityOf(choosePickupTimeField)).isDisplayed();
    }
    @Step("Choose dropoff time field is loaded")
    public boolean chooseDropoffTimeFieldLoaded() {
        return new WebDriverWait(driver, GlobalVariables.globalTimeout).until(ExpectedConditions.visibilityOf(chooseDropoffTimeField)).isDisplayed();
    }

    @Step("Pick up time button is loaded")
    public boolean choosePickupTimeLoaded() {
        return new WebDriverWait(driver, GlobalVariables.globalTimeout).until(ExpectedConditions.visibilityOf(choosePickupTime)).isDisplayed();
    }
    @Step("Choose dropoff time is loaded")
    public boolean chooseDropoffTimeLoaded() {
        return new WebDriverWait(driver, GlobalVariables.globalTimeout).until(ExpectedConditions.visibilityOf(chooseDropoffTime)).isDisplayed();
    }

    @Step("Drivers age entry field is loaded")
    public boolean driversAgeFieldLoaded() {
        return new WebDriverWait(driver, GlobalVariables.globalTimeout).until(ExpectedConditions.visibilityOf(driversAgeField)).isDisplayed();
    }
    @Step("Search button for cars is loaded")
    public boolean searchButtonLoaded() {
        return new WebDriverWait(driver, GlobalVariables.globalTimeout).until(ExpectedConditions.visibilityOf(searchButton)).isDisplayed();
    }



    @Step("Enter destination")
    public void enterDestination(String destination) {
        destinationFieldPopup.clear();
        destinationFieldPopup.sendKeys(destination);
    }
    @Step("Enter pickup location")
    public void enterPickupLocation(String destination) {
        enterDestionation.clear();
        enterDestionation.sendKeys(destination);
    }
    @Step("Enter dropoff location")
    public void enterDropoffLocation(String destination) {
        enterDestionation.clear();
        enterDestionation.sendKeys(destination);
    }
    @Step("Confirm search results dates")
    public boolean getTripDataDate(String date) {
        String text = searchDataDate.getText();
        return text.equals(date);
    }
    @Step("Confirm search results is for Skopje")
    public boolean getTripDataDestination(String destination) {
        String text = searchDataDestination.getText();
        return text.equals(destination);
    }


    @Step("Click destination field button")
    public void clickDestinationField() {
        enterDestinationField.click();
    }

    @Step("Click on first option")
    public void clickFirst() {
        selectFirst.click();
    }

    @Step("Click on start date")
    public void clickStartDate() {
        enterDateStart.click();
    }
    @Step("Click on start date")
    public void clickEndDate() {
        enterDateEnd.click();
    }

    @Step("Click confirm selected dates")
    public void clickSelectDatesButton() {
        selectDatesButton.click();
    }

    @Step("Click trip details change field")
    public void clickRoomSelection() {
        chooseRooms.click();
    }
    @Step("Click increase rooms")
    public void clickRoomIncreaseButton() {
        increaseRooms.click();
    }
    @Step("Click increase adult count")
    public void clickAdultIncreaseButton() {
        increaseAdults.click();
    }

    @Step("Click apply trip changes button")
    public void clickApplyChangesToTrip() {
        applyChangesToTripInformation.click();
    }


    @Step("Click search for trip button")
    public void clickSearchForTripButton() {
        searchForTrip.click();
    }

    @Step("Click rental car button")
    public void clickCarRentalButton() {
        carRentalButton.click();
    }
    @Step("Click return same location switch")
    public void clickReturnSameLocationSwitch() {
        returnSameLocationSwitch.click();
    }
    @Step("Click pick up location field")
    public void clickPickupLocationField() {
        pickupLocationField.click();
    }
    @Step("Click dropoff location field")
    public void clickDropoffLocationField() {
        dropoffLocationField.click();
    }
    @Step("Click choose pick up location from search")
    public void clickChoosePickupContent() {
        choosingPickupContent.click();
    }
    @Step("Click choose drop off location from search")
    public void clickDropoffPickupContent() {
        choosingDropoffContent.click();
    }
    @Step("Click choose pick up date")
    public void clickChoosePickupDateField() {
        choosePickupDateField.click();
    }
    @Step("Click choose pickup time")
    public void clickChoosePickupTimeField() {
        choosePickupTimeField.click();
    }
    @Step("Click choose dropoff time")
    public void clickChooseDropoffTimeField() {
        chooseDropoffTimeField.click();
    }
    @Step("Enter the pickup date")
    public void clickEnterDatePickup() {
        enterDatePickup.click();
    }
    @Step("Enter the dropoff date")
    public void clickEnterDateDropoff() {
        enterDateDropoff.click();
    }
    @Step("Click chosen pick up time")
    public void clickChoosePickupTime() {
        choosePickupTime.click();
    }
    @Step("Click chosen drop off time")
    public void clickChooseDropoffTime() {
        chooseDropoffTime.click();
    }
    @Step("Click chosen date confirm button")
    public void clickConfirmChosenDates() {
        confirmChosenDates.click();
    }
    @Step("Click car search button")
    public void clickSearchButton() {
        searchButton.click();
    }
    @Step("Click drivers age field")
    public void clickDriversAgeField() {
        driversAgeField.click();
    }


}