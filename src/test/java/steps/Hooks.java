package steps;


import io.cucumber.java.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;


public class Hooks {

  private static RemoteWebDriver driver;

  @Before
  public static void openBrowser() throws MalformedURLException {
    WebDriverManager.chromedriver().setup();
    driver = new ChromeDriver();
    driver.manage().window().maximize();
//    DesiredCapabilities cap = DesiredCapabilities.chrome();
//    URL u = new URL("http://localhost:4444/wd/hub");
//    driver = new RemoteWebDriver(u, cap);
  }

  @After
  public static void tearDown() {
    driver.quit();
  }

  public static WebDriver getDriver() {
    return driver;
  }

}