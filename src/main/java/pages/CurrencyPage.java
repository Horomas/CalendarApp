package pages;


import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.GlobalVariables;

public class CurrencyPage {
    protected AndroidDriver driver;

    @AndroidFindBy(className = "android.widget.EditText")
    private RemoteWebElement currencySelectionField;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Euro']")
    private RemoteWebElement selectEURO;

    public CurrencyPage(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public boolean currencySelectionFieldLoaded() {
        return new WebDriverWait(driver, GlobalVariables.globalTimeout).until(ExpectedConditions.visibilityOf(currencySelectionField)).isDisplayed();
    }

    public boolean euroLoaded() {
        return new WebDriverWait(driver, GlobalVariables.globalTimeout).until(ExpectedConditions.visibilityOf(selectEURO)).isDisplayed();
    }

    public void clickCurrencySelectionButton() {
        currencySelectionField.click();
    }
    public void clickEuro() {
        selectEURO.click();
    }

    public void enterCurrency(String currency) {
        currencySelectionField.clear();
        currencySelectionField.sendKeys(currency);
    }

}

