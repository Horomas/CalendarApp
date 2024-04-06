package pages;


import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
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



    public SearchResultsPage(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public boolean favouritesFirstResultLoaded() {
        return new WebDriverWait(driver, GlobalVariables.globalTimeout).until(ExpectedConditions.visibilityOf(favouriteFirst)).isDisplayed();
    }

    public boolean nameOfFirstFavouriteLoaded() {
        return new WebDriverWait(driver, GlobalVariables.globalTimeout).until(ExpectedConditions.visibilityOf(nameOfFirstFavourite)).isDisplayed();
    }




    public String textFromFirstFavourite() {
        return nameOfFirstFavourite.getText();
    }

    public void clickFavouriteFirstButton() {
        favouriteFirst.click();
    }


}

