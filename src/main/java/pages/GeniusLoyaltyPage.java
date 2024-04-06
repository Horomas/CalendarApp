package pages;



import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.*;

public class GeniusLoyaltyPage extends Helpers {
    protected AndroidDriver driver;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='About Genius Levels']")
    private RemoteWebElement aboutGeniusLink;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Genius loyalty program']")
    private RemoteWebElement aboutGeniusContent;


    public GeniusLoyaltyPage(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public boolean aboutGeniusLinkLoaded() {
        return new WebDriverWait(driver, GlobalVariables.globalTimeout).until(ExpectedConditions.visibilityOf(aboutGeniusLink)).isDisplayed();
    }
    public boolean aboutGeniusContentLoaded() {
        return new WebDriverWait(driver, GlobalVariables.globalTimeout).until(ExpectedConditions.visibilityOf(aboutGeniusContent)).isDisplayed();
    }
    public void clickAboutGenius() {
        aboutGeniusLinkLoaded();
        aboutGeniusLink.click();
    }

}

