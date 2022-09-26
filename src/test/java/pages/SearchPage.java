package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;



public class SearchPage extends BasePage {

    public SearchPage(WebDriver driver) {
        super(driver);
    }

    public void openVeteranPage() {
        String url = EnvironmentProperties.getInstance().getEnvUrl();
        driver.get(url);
    }
}

