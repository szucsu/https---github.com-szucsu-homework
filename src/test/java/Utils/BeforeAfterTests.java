
package Utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

/**
 * The Class BeforeAfterClass.
 */
public class BeforeAfterTests {

    protected static String configFile = "config.properties";

    /**
     * The getDriver().
     */
    protected static ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<>();

    /**
     * The Browser attach timeout milliseconds.
     */
    protected static int BrowserAttachTimeoutMilliseconds = 90000;
    static String driverFolder = System.getProperty("user.dir") + File.separator + "DRIVER" + File.separator;

    // Firefox Driver
    // static String driverName = "geckodriver";
    /**
     * The driver name.
     */
    // IE Driver
    // static String driverName = "IEDriverServer";

    // Chrome Driver
    private static String driverName = "chromedriver";

    /**
     * Gets the getDriver().
     *
     * @return the driver
     */
    public static WebDriver getDriver() {
        return driver.get();
    }

    @BeforeMethod(groups = {"Test"})
    public void setUp() {
        File file;
        if (System.getProperty("os.name").toLowerCase().contains("win")) {
            file = new File(driverFolder + driverName + ".exe");
        } else {
            file = new File(driverFolder + driverName);
        }
        HashMap<String, Object> chromePrefs = new HashMap<>();
        System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
        chromePrefs.put("profile.default_content_settings.popups", 0);
        chromePrefs.put("safebrowsing.enabled", true);

        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", chromePrefs);
        options.addArguments("allow-unchecked-dangerous-downloads");
        options.addArguments("--window-size=1920,1080");
        options.addArguments("start-maximized");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--ignore-ssl-errors=yes");
        options.addArguments("--ignore-certificate-errors");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        DesiredCapabilities cap = DesiredCapabilities.chrome();
        cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
        cap.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
        cap.setCapability(ChromeOptions.CAPABILITY, options);

        String environment;
        if (System.getProperty("environment") != null) {
            System.out.println("environment was set as " + System.getProperty("environment"));
            environment = ReadFileData.readFile(configFile, "URL." + System.getProperty("environment"));
        } else {
            System.setProperty("environment", "SAUCE");
            System.out.println("environment was not set using default DEV environment");
            environment = ReadFileData.readFile(configFile, "URL." + System.getProperty("environment"));
        }
        RemoteWebDriver remoteWebDriver = new ChromeDriver(options);
        driver.set(remoteWebDriver);

        getDriver().manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
        getDriver().navigate().to(environment);
        getDriver().manage().timeouts().implicitlyWait(BrowserAttachTimeoutMilliseconds, TimeUnit.MILLISECONDS);
    }

    @AfterMethod(groups = {"Test"})
    public void tearDown() {
        try {
            getDriver().quit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}