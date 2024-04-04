package pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
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

    @AndroidFindBy(xpath = "//android.widget.Button[contains(@content-desc, 'Staying from')]")
    private RemoteWebElement tripDatesPopup;


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




    public TripInformationEntryPage(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public boolean tripInformationEntryPageLoaded() {
        return new WebDriverWait(driver, GlobalVariables.globalTimeout).until(ExpectedConditions.visibilityOf(enterDestinationField)).isDisplayed();
    }

    public boolean tripDatesPopupButtonLoaded() {
        return new WebDriverWait(driver, GlobalVariables.globalTimeout).until(ExpectedConditions.visibilityOf(tripDatesPopup)).isDisplayed();
    }

    public boolean selectFirstOptionAvailable() {
        return new WebDriverWait(driver, GlobalVariables.globalTimeout).until(ExpectedConditions.visibilityOf(selectFirst)).isDisplayed();
    }

    public boolean selectDateStartLoaded() {
        return new WebDriverWait(driver, GlobalVariables.globalTimeout).until(ExpectedConditions.visibilityOf(enterDateStart)).isDisplayed();
    }
    public boolean selectDateEndLoaded() {
        return new WebDriverWait(driver, GlobalVariables.globalTimeout).until(ExpectedConditions.visibilityOf(enterDateEnd)).isDisplayed();
    }
    public boolean selectDateButtonLoaded() {
        return new WebDriverWait(driver, GlobalVariables.globalTimeout).until(ExpectedConditions.visibilityOf(selectDatesButton)).isDisplayed();
    }

    public boolean enterDestination() {
        return new WebDriverWait(driver, GlobalVariables.globalTimeout).until(ExpectedConditions.visibilityOf(destinationFieldPopup)).isDisplayed();
    }

    public boolean roomSelectionLoaded() {
        return new WebDriverWait(driver, GlobalVariables.globalTimeout).until(ExpectedConditions.visibilityOf(chooseRooms)).isDisplayed();
    }
    public boolean increaseRoomsLoaded() {
        return new WebDriverWait(driver, GlobalVariables.globalTimeout).until(ExpectedConditions.visibilityOf(increaseRooms)).isDisplayed();
    }
    public boolean increaseAdultsLoaded() {
        return new WebDriverWait(driver, GlobalVariables.globalTimeout).until(ExpectedConditions.visibilityOf(increaseAdults)).isDisplayed();
    }
    public boolean increaseChildrenLoaded() {
        return new WebDriverWait(driver, GlobalVariables.globalTimeout).until(ExpectedConditions.visibilityOf(increaseChildren)).isDisplayed();
    }
    public boolean applyButtonToTripInformation() {
        return new WebDriverWait(driver, GlobalVariables.globalTimeout).until(ExpectedConditions.visibilityOf(applyChangesToTripInformation)).isDisplayed();
    }
    public boolean searchForTripLoaded() {
        return new WebDriverWait(driver, GlobalVariables.globalTimeout).until(ExpectedConditions.visibilityOf(searchForTrip)).isDisplayed();
    }

    public boolean searchDateLoaded() {
        return new WebDriverWait(driver, GlobalVariables.globalTimeout).until(ExpectedConditions.visibilityOf(searchDataDestination)).isDisplayed();
    }

    public boolean searchDestinationLoaded() {
        return new WebDriverWait(driver, GlobalVariables.globalTimeout).until(ExpectedConditions.visibilityOf(searchDataDate)).isDisplayed();
    }

    public void clickTripDatesButton() {
        tripDatesPopup.click();
    }

    public void clickDestinationField() {
        enterDestinationField.click();
    }

    public void clickFirst() {
        selectFirst.click();
    }

    public void enterDestination(String destination) {
        destinationFieldPopup.clear();
        destinationFieldPopup.sendKeys(destination);
    }

    public boolean getTripDataDate(String date) {
        String text = searchDataDate.getText();
        return text.equals(date);
    }
    public boolean getTripDataDestination(String destination) {
        String text = searchDataDestination.getText();
        return text.equals(destination);
    }

    public void clickStartDate() {
        enterDateStart.click();
    }

    public void clickEndDate() {
        enterDateEnd.click();
    }

    public void clickSelectDatesButton() {
        selectDatesButton.click();
    }

    public void clickRoomSelection() {
        chooseRooms.click();
    }
    public void clickRoomIncreaseButton() {
        increaseRooms.click();
    }
    public void clickAdultIncreaseButton() {
        increaseAdults.click();
    }
    public void clickChildrenIncreaseButton() {
        increaseChildren.click();
    }

    public void clickApplyChangesToTrip() {
        applyChangesToTripInformation.click();
    }

    public void clickSearchForTripButton() {
        searchForTrip.click();
    }


}