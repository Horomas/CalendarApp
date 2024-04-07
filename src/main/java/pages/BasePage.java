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
    @AndroidFindBy(accessibility = "Search")
    private RemoteWebElement backToSearch;


    public BasePage(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
    @Step("Back button is loaded")
    public boolean backButtonLoaded() {
        return new WebDriverWait(driver, GlobalVariables.globalTimeout).until(ExpectedConditions.visibilityOf(backButton)).isDisplayed();
    }
    @Step("Search section button is loaded")
    public boolean searchSectionButtonLoaded() {
        return new WebDriverWait(driver, GlobalVariables.globalTimeout).until(ExpectedConditions.visibilityOf(searchSectionButton)).isDisplayed();
    }

    @Step("Saved section button is loaded")
    public boolean savedSectionButtonLoaded() {
        return new WebDriverWait(driver, GlobalVariables.globalTimeout).until(ExpectedConditions.visibilityOf(savedSectionButton)).isDisplayed();
    }
    @Step("Sign in button is loaded")
    public boolean signInSectionButtonLoaded() {
        return new WebDriverWait(driver, GlobalVariables.globalTimeout).until(ExpectedConditions.visibilityOf(signInSectionButton)).isDisplayed();
    }

    @Step("Search section button is loaded")
    public boolean backToSearchLoaded() {
        return new WebDriverWait(driver, GlobalVariables.globalTimeout).until(ExpectedConditions.visibilityOf(backToSearch)).isDisplayed();
    }
    @Step("Click Back Button")
    public void clickBackButton() {
        backButton.click();
    }
    @Step("Click search section button")
    public void clickSearchSectionButton() {
        searchSectionButton.click();
    }
    @Step("Click saved section button")
    public void clickSavedSectionButton() {
        savedSectionButton.click();
    }
    @Step("Click sign in button")
    public void clickSignInSectionButton() {
        signInSectionButton.click();
    }

    @Step("Click search section button")
    public void clickBackToSearchButton() {
        backToSearch.click();
    }


}
