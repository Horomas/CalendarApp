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

public class CookiePage {
    protected AndroidDriver driver;

    @AndroidFindBy(id = "com.booking:id/bt_accept")
    private RemoteWebElement cookieAcceptButton;


    public CookiePage(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @Step("Cookie page is Loaded")
    public boolean cookiePageLoaded() {
        return new WebDriverWait(driver, GlobalVariables.globalTimeout).until(ExpectedConditions.visibilityOf(cookieAcceptButton)).isDisplayed();
    }


    @Step("Cookies are accepted")
    public void clickAcceptCookieButton() {
            cookieAcceptButton.click();
    }
}

