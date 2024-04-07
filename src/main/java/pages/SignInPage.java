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

public class SignInPage {
    protected AndroidDriver driver;

    @AndroidFindBy(id = "com.booking:id/facet_profile_header_sign_in_cta")
    private RemoteWebElement signInButton;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Settings']")
    private RemoteWebElement settingsButton;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Genius loyalty program']")
    private RemoteWebElement geniusLoyaltyButton;



    public SignInPage(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @Step("Sign in button is loaded")
    public boolean signInButtonLoaded() {
        return new WebDriverWait(driver, GlobalVariables.globalTimeout).until(ExpectedConditions.visibilityOf(signInButton)).isDisplayed();
    }

    @Step("Settings button loaded")
    public boolean signSettingsButtonLoaded() {
        return new WebDriverWait(driver, GlobalVariables.globalTimeout).until(ExpectedConditions.visibilityOf(settingsButton)).isDisplayed();
    }

    @Step("Genius Loyalty button is loaded")
    public boolean geniusLoyaltyButtonLoaded() {
        return new WebDriverWait(driver, GlobalVariables.globalTimeout).until(ExpectedConditions.visibilityOf(geniusLoyaltyButton)).isDisplayed();
    }
    @Step("Click settings button")
    public void clickSettingsButton() {
        settingsButton.click();
    }
    @Step("Click Genius Loyalty button")
    public void clickGeniusLoyaltyButton() {
        geniusLoyaltyButton.click();
    }

}

