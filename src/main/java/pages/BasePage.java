package pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.GlobalVariables;

public class BasePage {
    protected AndroidDriver driver;

    @AndroidFindBy(accessibility = "Navigate up")
    private RemoteWebElement backButton;

    @AndroidFindBy(accessibility = "Search")
    private RemoteWebElement searchSectionButton;

    @AndroidFindBy(accessibility = "Saved")
    private RemoteWebElement savedSectionButton;

    @AndroidFindBy(accessibility = "Sign in")
    public RemoteWebElement signInSectionButton;


    public BasePage(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public boolean backButtonLoaded() {
        return new WebDriverWait(driver, GlobalVariables.globalTimeout).until(ExpectedConditions.visibilityOf(backButton)).isDisplayed();
    }
    public boolean searchSectionButtonLoaded() {
        return new WebDriverWait(driver, GlobalVariables.globalTimeout).until(ExpectedConditions.visibilityOf(searchSectionButton)).isDisplayed();
    }
    public boolean savedSectionButtonLoaded() {
        return new WebDriverWait(driver, GlobalVariables.globalTimeout).until(ExpectedConditions.visibilityOf(savedSectionButton)).isDisplayed();
    }
    public boolean signInSectionButtonLoaded() {
        return new WebDriverWait(driver, GlobalVariables.globalTimeout).until(ExpectedConditions.visibilityOf(signInSectionButton)).isDisplayed();
    }

    public void clickBackButton() {
        backButton.click();
    }
    public void clickSearchSectionButton() {
        searchSectionButton.click();
    }
    public void clickSavedSectionButton() {
        savedSectionButton.click();
    }
    public void clickSignInSectionButton() {
        signInSectionButton.click();
    }

}
