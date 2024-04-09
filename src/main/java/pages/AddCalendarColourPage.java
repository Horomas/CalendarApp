package pages;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.GlobalVariables;

public class AddCalendarColourPage {
    protected IOSDriver driver;


    @iOSXCUITFindBy(accessibility = "Blue")
    private RemoteWebElement chooseBlue;
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton[@name='Add Calendar'])[2]")
    private RemoteWebElement backButton;
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`name == \"Done\"`][1]")
    private RemoteWebElement addCalendarDone;



    public AddCalendarColourPage(IOSDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
    @Step("Calendar blue colour button is loaded")
    public boolean chooseBlueLoaded() {
        return new WebDriverWait(driver, GlobalVariables.globalTimeout).until(ExpectedConditions.visibilityOf(chooseBlue)).isDisplayed();
    }
    @Step("Calendar section button is loaded")
    public boolean backButtonLoaded() {
        return new WebDriverWait(driver, GlobalVariables.globalTimeout).until(ExpectedConditions.visibilityOf(backButton)).isDisplayed();
    }

    @Step("Done adding calendar")
    public boolean addCalendarDoneLoaded() {
        return new WebDriverWait(driver, GlobalVariables.globalTimeout).until(ExpectedConditions.visibilityOf(addCalendarDone)).isDisplayed();
    }


    @Step("Change colour to blue")
    public void clickChooseBlue() {
        chooseBlue.click();
    }
    @Step("Change colour to blue")
    public void clickBackButton() {
        backButton.click();
    }
    @Step("Click on done")
    public void clickAddCalendarDone() {
        addCalendarDone.click();
    }


}
