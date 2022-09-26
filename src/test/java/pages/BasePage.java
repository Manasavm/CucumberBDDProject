package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage extends DriverBase {

    public WebDriver driver;
    public WebDriverWait wait;
    private static final int WAIT_TIMEOUT = 3000;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, WAIT_TIMEOUT);
    }


}
