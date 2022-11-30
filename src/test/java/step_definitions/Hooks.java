package step_definitions;

import java.net.URL;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.chrome.ChromeDriver;
import cucumber.api.Scenario;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;


public class Hooks {
    public static WebDriver driver;
    private static String driverDirectory = System.getProperty("user.dir") + "/webDrivers/usr/bin";
    private ChromeOptions chromeOptions = new ChromeOptions();
    String os = System.getProperty("os.name").toLowerCase();
    public String browser = System.getProperty("browser".toUpperCase());

    @Before
    public void openBrowser() throws Exception {
        java.util.logging.Logger.getLogger("com.gargoylesoftware").setLevel(Level.OFF);
        System.setProperty("org.apache.commons.logging.Log", "org.apache.commons.logging.impl.NoOpLog");
        String os = System.getProperty("os.name").toLowerCase();

        if (browser == null) {
            browser = System.getenv("browser");
            if (os.contains("win")) {
                browser = "chrome";
            }
        }
        switch (browser.toLowerCase()) {

            case "chrome":
                HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
                chromeOptions.setExperimentalOption("prefs", chromePrefs);
                if (os.contains("win")) {
//                    System.setProperty("webdriver.chrome.driver", driverDirectory + "/chrome/chromedriver.exe");
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver(chromeOptions);
                    driver.manage().deleteAllCookies();
//                    driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
//                    driver.manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS);
                    driver.manage().window().maximize();
                    //chromeOptions.addArguments("--disable-gpu");
                    chromeOptions.setPageLoadStrategy(PageLoadStrategy.EAGER);
                    //AGRESSIVE: chromeOptions.setPageLoadStrategy(PageLoadStrategy.NONE); // https://www.skptricks.com/2018/08/timed-out-receiving-message-from-renderer-selenium.html
                    chromeOptions.addArguments("start-maximized"); // https://stackoverflow.com/a/26283818/1689770
                    //chromeOptions.addArguments("enable-automation"); // https://stackoverflow.com/a/43840128/1689770
//                    chromeOptions.addArguments("--headless"); // only if you are ACTUALLY running headless
                    //chromeOptions.addArguments("--no-sandbox"); //https://stackoverflow.com/a/50725918/1689770
                    chromeOptions.addArguments("--disable-infobars"); //https://stackoverflow.com/a/43840128/1689770
                    //chromeOptions.addArguments("--disable-dev-shm-usage"); //https://stackoverflow.com/a/50725918/1689770
                    //chromeOptions.addArguments("--disable-browser-side-navigation"); //https://stackoverflow.com/a/49123152/1689770
                    //chromeOptions.addArguments("--incognito");

                } /*else {
                    //System.setProperty("webdriver.chrome.driver", driverDirectory + "/chrome/chromedriver.exe");
                    WebDriverManager.chromedriver().setup();
                    chromeOptions.addArguments("--start-maximized");
                    driver = new ChromeDriver(chromeOptions);
                    driver.manage().deleteAllCookies();
                }*/
                break;

            case "chromeWindows":
                //System.setProperty("webdriver.chrome.driver", driverDirectory + "/chrome/chromedriver.exe");
                WebDriverManager.chromedriver().setup();
                chromeOptions.addArguments("--start-maximized");
                driver = new ChromeDriver(chromeOptions);
                driver.manage().deleteAllCookies();
                break;

            case "firefox":
                if (os.contains("win")) {
                    //System.setProperty("webdriver.gecko.driver", driverDirectory + "/geckoFirefox/geckodriver.exe");
                    WebDriverManager.firefoxdriver().setup();
                    //System.setProperty(FirefoxDriver.SystemProperty.DRIVER_USE_MARIONETTE, "true");
                    //System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "E:\\WorkSpace\\Projects\\Paymate\\Automation\\PaymateAutomation\\WebDrivers\\usr\\bin\\geckoFirefox\\Logs\\Logs.txt");
                    //DesiredCapabilities capabilities = DesiredCapabilities.firefox();
                    driver = new FirefoxDriver(/*capabilities*/);
                    driver.manage().deleteAllCookies();

                } else {
                    //System.setProperty("webdriver.gecko.driver", driverDirectory + "/geckoFirefox/geckodriver");
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    driver.manage().deleteAllCookies();
                    driver.manage().window().maximize();


                }
                break;

            case "chromeheadless":
//                System.setProperty("webdriver.chrome.driver", driverDirectory + "/chrome/chromedriver.exe");
                WebDriverManager.chromedriver().setup();
                chromeOptions.addArguments("headless");
                chromeOptions.addArguments("window-size=1200x600");
                driver = new ChromeDriver(chromeOptions);
                driver.manage().deleteAllCookies();
                break;

            case "ie":
                DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();

                capabilities.setCapability(CapabilityType.BROWSER_NAME, "IE");

                capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);

                capabilities.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);

               // System.setProperty("webdriver.ie.driver", driverDirectory + "/IEDriver/IEDriverServer.exe");
                WebDriverManager.edgedriver().setup();
                driver = new InternetExplorerDriver();
                driver.manage().deleteAllCookies();
                driver.manage().window().maximize();

                break;

            case "safari":
                driver = new SafariDriver();
                break;

            case "htmlunit":
                driver = new HtmlUnitDriver();
                ((HtmlUnitDriver) driver).findElementByClassName("class").click();
                ((HtmlUnitDriver) driver).setJavascriptEnabled(true);
        }

        System.out.println("The Browser used for this test is: " + browser.toUpperCase());

    }


    @After
    public void embedScreenshot(Scenario scenario) throws Exception {

        if (scenario.isFailed()) {
            try {
                System.out.println("" + scenario);
                scenario.write("Current Page URL is " + new URL(driver.getCurrentUrl()));
                byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
                scenario.embed(screenshot, "image/png");
            } catch (WebDriverException somePlatformsDontSupportScreenshots) {
                System.err.println(somePlatformsDontSupportScreenshots.getMessage());
            }
        }
        driver.quit();
    }

}