package pages;


import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.GlobalVariables;

public class PrivacyPolicyPage {
    protected AndroidDriver driver;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Privacy and Cookies policy']")
    private RemoteWebElement privacyPolicyContent;

    public PrivacyPolicyPage(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public boolean privacyPolicyContentLoaded() {
        return new WebDriverWait(driver, GlobalVariables.globalTimeout).until(ExpectedConditions.visibilityOf(privacyPolicyContent)).isDisplayed();
    }


}

