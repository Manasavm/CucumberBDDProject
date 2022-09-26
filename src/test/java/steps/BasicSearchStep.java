package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import pages.SearchPage;
import pages.DriverBase;

public class BasicSearchStep {

    public WebDriver driver;
    SearchPage searchPage;
    DriverBase driverBase;


    public BasicSearchStep() {
        driverBase = new DriverBase();
        driver = driverBase.getWebDriver();
        searchPage = new SearchPage(driver);
    }

    @Given("User is on VLM page")
    public void user_is_on_vlm_page() {
        searchPage.openVeteranPage();
    }
    @Then("search for veteran in search bar")
    public void search_for_veteran_in_search_bar() {
        System.out.println("step2");
    }
    @Then("user clicks on search bar")
    public void user_clicks_on_search_bar() {
        System.out.println("Step3");
    }
    @Then("scroll down and select veteran")
    public void scroll_down_and_select_veteran() {
        System.out.println("step4");
    }
}
