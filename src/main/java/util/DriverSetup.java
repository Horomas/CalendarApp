package util;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Listeners;
import pages.*;

import org.testng.annotations.BeforeMethod;
//import pages.*;

import java.net.MalformedURLException;
import java.net.URI;

import java.net.URISyntaxException;
import java.time.Duration;

@Listeners({ ITestListenerUtility.class })
public class DriverSetup extends ConfigReader {

    public static IOSDriver driver;

    protected Helpers helpers;

    protected StartingPage startingPage;
    protected PopUpStartingPage popUpStartingPage;
    protected NewEventPage newEventPage;
    protected MonthPage monthPage;
    protected CalendarPage calendarPage;
    protected AddCalendarColourPage addCalendarColourPage;
    protected EditCalendarPage editEventPage;

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
        calendarPage = new CalendarPage(driver);
        addCalendarColourPage = new AddCalendarColourPage(driver);
        editEventPage = new EditCalendarPage(driver);

    }
    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }
}

