package pages;

import com.codeborne.selenide.WebDriverRunner;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.cucumber.java.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

public class DriverBase {

    public WebDriver driver;
    Util util = new Util();
    private static ThreadLocal<WebDriver> driverThread = new ThreadLocal<>();

    public static DriverBase get() {
        return new DriverBase();
    }

    public WebDriver getDriver(String browser) {

        if (driverThread.get() == null) {
            switch (browser) {
                case "chrome-headed":
                    WebDriverManager.chromedriver().setup();
                    System.out.println("property for chrome driver:" + System.getProperty("webdriver.chrome.driver"));
                    ChromeOptions options = new ChromeOptions();
                    options.addArguments("--no-sandbox");
                    options.addArguments("--disable-dev-shm-usage");
                    options.addArguments("--start-maximized");
                    options.addArguments("--start-fullscreen");
                    driver = new ChromeDriver(options);
                    driverThread.set(driver);
                    break;
                case "chrome-headless":
                    WebDriverManager.chromedriver().setup();
                    System.out.println("property for chrome driver:" + System.getProperty("webdriver.chrome.driver"));
                    ChromeOptions options1 = new ChromeOptions();
                    options1.addArguments("--no-sandbox");
                    options1.addArguments("--headless");
                    options1.addArguments("--disable-dev-shm-usage");
                    options1.addArguments("--start-maximized");
                    options1.addArguments("--start-fullscreen");
                    driver = new ChromeDriver(options1);
                    driverThread.set(driver);
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    String projectDirectory = System.getProperty("user.dir");
                    System.out.println("property for firefox driver:" + System.getProperty("webdriver.gecko.driver"));
                    FirefoxProfile profile = new FirefoxProfile();
                    profile.setPreference("browser.download.folderList", 2);
                    profile.setPreference("browser.download.dir", projectDirectory);
                    profile.setPreference("browser.download.manager.showWhenStarting", false);
                    profile.setPreference("browser.helperApps.neverAsk.saveToDisk", "application/xls;text/csv;application/msexcel");
                    FirefoxOptions options2 = new FirefoxOptions();
                    options2.setHeadless(true);
                    options2.setProfile(profile);
                    options2.addArguments("--no-sandbox");
                    options2.addArguments("--disable-dev-shm-usage");
                    options2.addArguments("--start-maximized");
                    options2.addArguments("--start-fullscreen");
                    driver = new FirefoxDriver(options2);
                    driverThread.set(driver);
                    break;
            }
            WebDriverRunner.setWebDriver(driver);
        }
        return driverThread.get();
    }

    public WebDriver getWebDriver() {
        if (System.getProperty("browser") != null) {
            String browserName = getParameter("browser");
            driver = DriverBase.get().getDriver(browserName);
        } else {
            driver = DriverBase.get().getDriver(util.get_PropertyValue("environment.local.properties", "browser"));
        }
        return driver;
    }

    public static String getParameter(String name) {
        String value = System.getProperty(name);
        if (value == null)
            throw new RuntimeException(name + " is not a parameter!");
        if (value.isEmpty())
            throw new RuntimeException(name + " is empty!");
        return value;
    }

//    public void getScreenshot(Scenario scenario) {
//        if (scenario.isFailed()) {
//            try {
//                JavascriptExecutor jse = (JavascriptExecutor) driverThread.get();
//                jse.executeScript("document.body.style.zoom = '0.5'");
//                byte[] screenshot =
//                        ((TakesScreenshot) driverThread.get()).getScreenshotAs(OutputType.BYTES);
//                scenario.embed(screenshot, "image/png");
//                byte[] secondScreenshot =
//                        ((TakesScreenshot) driverThread.get()).getScreenshotAs(OutputType.BYTES);
//                scenario.embed(secondScreenshot, "image/png");
//            } catch (WebDriverException wde) {
//                System.err.println(wde.getMessage());
//            } catch (ClassCastException cce) {
//                cce.printStackTrace();
//            } finally {
//                //OnBoardingRestPage.deleteCompany();
//                DriverBase.get().quitDriver();
//            }
//        } else {
//            //OnBoardingRestPage.deleteCompany();
//        }
//    }

    @After
    public void quitDriver() {
        if (driverThread.get() != null) {
            driverThread.get().quit();
            driverThread.remove();
        }
    }

    public static WebDriver getDriverInstance() {
        return driverThread.get();
    }
}