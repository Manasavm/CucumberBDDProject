package traingsteps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;

public class LoginSteps {

    @Given("^User is on NetBanking landing page$")
    public void user_is_on_netbanking_landing_page() throws Throwable {
        //code to navigate to login url
        System.out.println("navigated to login url");

    }
    @Given("^validate the browser$")
    public void validate_the_browser() throws Throwable {
        System.out.println("deciding the browser to open");
    }

    @When("^Browser is triggered$")
    public void browser_is_triggered() throws Throwable {
        System.out.println("Browser is triggered");
    }

    @Then("^check if browser is started$")
    public void check_if_browser_is_started() throws Throwable {
        System.out.println("Browser is started");
    }
    @When("^User login into application with username and password$")
    public void user_login_into_application_with_username_and_password() throws Throwable {
        //code to login
        System.out.println("Logged in success");
    }

    @Then("^Home page is populated$")
    public void home_page_is_populated() throws Throwable {
        //home page validation
        System.out.println("Validated home page");
    }
    @When("^User login into application with \"([^\"]*)\" and password \"([^\"]*)\"$")
    public void user_login_into_application_with_something_and_password_something(String arg1, String arg2) throws Throwable {
        System.out.println(arg1);
        System.out.println(arg2);
    }

    @Then("^Cards displayed are \"([^\"]*)\"$")
    public void cards_displayed_are(String arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        System.out.println(arg1);
    }
    @When("^User sign up with following details$")
    public void user_sign_up_with_following_details(DataTable data) throws Throwable {
        List<List<String>>  obj=data.asLists();
        System.out.println(obj.get(0).get(0));
        System.out.println(obj.get(0).get(1));
        System.out.println(obj.get(0).get(2));
        System.out.println(obj.get(0).get(3));
        System.out.println(obj.get(0).get(4));
    }
    @When("^User login in to application with (.+) and password (.+)$")
    public void user_login_into_application_with_and_password(String username, String password) throws Throwable {
        System.out.println(username);
        System.out.println(password);

    }

    @Given("validate the browsers")
    public void validateTheBrowsers() {
        System.out.println("Background Step1 ");
    }

    @When("browser is triggered")
    public void browserIsTriggered() {
        System.out.println("Backgroung step2 ");
    }

    @Then("check the browser if started")
    public void checkTheBrowserIfStarted() {
        System.out.println("Background step3");
    }

}
