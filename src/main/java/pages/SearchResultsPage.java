package pages;


import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.qameta.allure.Step;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.GlobalVariables;

public class SearchResultsPage {
    protected AndroidDriver driver;

    @AndroidFindBy(xpath = "(//android.widget.ImageView[@content-desc='Save property to list'])[1]")
    private RemoteWebElement favouriteFirst;
    @AndroidFindBy(xpath = "//android.view.View[@resource-id='sr_list']/android.view.View[2]/android.widget.TextView[1]")
    private RemoteWebElement nameOfFirstFavourite;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Filter']")
    private RemoteWebElement filterButton;
    @AndroidFindBy(xpath = "//androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View[1]/android.view.View[2]/android.view.View[3]/android.widget.TextView")
    private RemoteWebElement firstCarGearBoxContent;



    public SearchResultsPage(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @Step("Favourite first search results button is loaded")
    public boolean favouritesFirstResultLoaded() {
        return new WebDriverWait(driver, GlobalVariables.globalTimeout).until(ExpectedConditions.visibilityOf(favouriteFirst)).isDisplayed();
    }

    public boolean nameOfFirstFavouriteLoaded() {
        return new WebDriverWait(driver, GlobalVariables.globalTimeout).until(ExpectedConditions.visibilityOf(nameOfFirstFavourite)).isDisplayed();
    }
    @Step("Search car result filter is loaded")
    public boolean filterButtonLoaded() {
        return new WebDriverWait(driver, GlobalVariables.globalTimeout).until(ExpectedConditions.visibilityOf(filterButton)).isDisplayed();
    }

    @Step("Get first favourite search results name")
    public String textFromFirstFavourite() {
        return nameOfFirstFavourite.getText();
    }
    @Step("First search results cars gearbox content is loaded")
    public String textFirstCarGearbox() {
        return firstCarGearBoxContent.getText();
    }

    @Step("Click favourite first search result")
    public void clickFavouriteFirstButton() {
        favouriteFirst.click();
    }
    @Step("Click car search filter button")
    public void clickFilterButton() {
        filterButton.click();
    }


}

