package pages;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.GlobalVariables;

public class MonthPage {
    protected IOSDriver driver;


    @iOSXCUITFindBy(accessibility = "Wednesday, 24 April")
    private RemoteWebElement selectDateOfInterest;
    @iOSXCUITFindBy(accessibility = "Skopje")
    private RemoteWebElement checkContent;

    public MonthPage(IOSDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @Step("Choose date of interest in monthly view")
    public boolean selectDateOfInterestLoaded() {
        return new WebDriverWait(driver, GlobalVariables.globalTimeout).until(ExpectedConditions.visibilityOf(selectDateOfInterest)).isDisplayed();
    }
    @Step("Check the event exists")
    public boolean checkContentLoaded() {
        return new WebDriverWait(driver, GlobalVariables.globalTimeout).until(ExpectedConditions.visibilityOf(checkContent)).isDisplayed();
    }

    @Step("Click date of interest in monthly view")
    public void clickSelectDateOfInterest() {
        selectDateOfInterest.click();
    }

}
