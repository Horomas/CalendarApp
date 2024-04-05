package pages;


import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.GlobalVariables;

public class SettingsPage {
    protected AndroidDriver driver;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Currency']")
    private RemoteWebElement currencySelectionButton;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Privacy Policy']")
    private RemoteWebElement privacyPolicyField;
    @AndroidFindBy(xpath = "//androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View[1]/android.view.View[2]/android.widget.TextView[2]")
    private RemoteWebElement selectedCurrency;

    public SettingsPage(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public boolean currencySelectionLoaded() {
        return new WebDriverWait(driver, GlobalVariables.globalTimeout).until(ExpectedConditions.visibilityOf(currencySelectionButton)).isDisplayed();
    }
    public boolean selectedCurrencyLoaded() {
        return new WebDriverWait(driver, GlobalVariables.globalTimeout).until(ExpectedConditions.visibilityOf(selectedCurrency)).isDisplayed();
    }
    public boolean privacyPolicyFieldLoaded() {
        return new WebDriverWait(driver, GlobalVariables.globalTimeout).until(ExpectedConditions.visibilityOf(privacyPolicyField)).isDisplayed();
    }

    public void clickCurrencySelectionButton() {
        currencySelectionButton.click();
    }
    public void clickPrivacyPolicyField() {
        privacyPolicyField.click();
    }


    public String getSelectedCurrency() {
        return selectedCurrency.getText();
    }
}

