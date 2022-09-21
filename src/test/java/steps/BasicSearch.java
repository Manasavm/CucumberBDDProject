package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.BasicSearchPage;

public class BasicSearch {
    @Given("User is on VLM page")
    public void user_is_on_vlm_page() {
        // Write code here that turns the phrase above into concrete actions
        BasicSearchPage.openVeteranPage();
    }
    @Then("search for veteran in search bar")
    public void search_for_veteran_in_search_bar() {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("step2");
    }
    @Then("user clicks on search bar")
    public void user_clicks_on_search_bar() {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("Step3");
    }
    @Then("scroll down and select veteran")
    public void scroll_down_and_select_veteran() {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("step4");
    }
}
