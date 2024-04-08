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


    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`name == 'Continue'`]")
    private RemoteWebElement acceptWelcomeButton;

    public MonthPage(IOSDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @Step("Accept Welcome to calendar button is loaded")
    public boolean acceptWelcomePageLoaded() {
        try {
            return new WebDriverWait(driver, GlobalVariables.globalTimeout)
                    .until(ExpectedConditions.visibilityOf(acceptWelcomeButton))
                    .isDisplayed();
        } catch (TimeoutException e) {
            System.out.println("The notifications popup button was not found within the timeout period: " + e.getMessage());
            return false;
        } catch (NoSuchElementException e) {
            System.out.println("The notifications popup button was not found: " + e.getMessage());
            return false;
        }
    }

    @Step("Click accept welcome to calendar button")
    public void clickAcceptanceWelcomePageLoaded() {
        acceptWelcomeButton.click();
    }

}
