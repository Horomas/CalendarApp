package util;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Listeners;
import pages.*;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeMethod;
//import pages.*;

import java.net.MalformedURLException;
import java.net.URI;

import java.net.URISyntaxException;
import java.time.Duration;

import org.openqa.selenium.Platform;

@Listeners({ ITestListenerUtility.class })
public class DriverSetup extends ConfigReader {

    public static IOSDriver driver;

    protected Helpers helpers;

    protected StartingPage startingPage;
    protected PopUpStartingPage popUpStartingPage;
    protected NewEventPage newEventPage;
    protected MonthPage monthPage;

    @BeforeMethod
    public void setUp() {

        XCUITestOptions options = new XCUITestOptions();
        options.setDeviceName(getProperty("device.name"))
                .setPlatformVersion(getProperty("platform.version"))
                .setBundleId(getProperty("bundle.id"))
                .setNoReset(false)
                .setAutoAcceptAlerts(true);

        try {
            driver = new IOSDriver(new URI(GlobalVariables.localAppiumServerUrl).toURL(), options);
        } catch (MalformedURLException | URISyntaxException e) {
            throw new RuntimeException(e);
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

        helpers = new Helpers();
        startingPage = new StartingPage(driver);
        popUpStartingPage = new PopUpStartingPage(driver);
        newEventPage = new NewEventPage(driver);
        monthPage = new MonthPage(driver);


    }
    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }
}

