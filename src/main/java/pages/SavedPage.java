package pages;


import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.GlobalVariables;

public class SavedPage {
    protected AndroidDriver driver;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='1 properties']")
    private RemoteWebElement favouriteList;
    @AndroidFindBy(accessibility = "Search")
    private RemoteWebElement backToSearch;

    public SavedPage(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public boolean savedPageLoaded() {
        return new WebDriverWait(driver, GlobalVariables.globalTimeout).until(ExpectedConditions.visibilityOf(favouriteList)).isDisplayed();
    }

    public boolean backToSearchLoaded() {
        return new WebDriverWait(driver, GlobalVariables.globalTimeout).until(ExpectedConditions.visibilityOf(backToSearch)).isDisplayed();
    }

    public void clickFavouritesListButton() {
        favouriteList.click();
    }
    public void clickBackToSearchButton() {
        backToSearch.click();
    }

}

