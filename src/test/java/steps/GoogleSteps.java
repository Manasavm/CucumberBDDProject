package steps;

import io.cucumber.java.en.*;
import pages.mainPage;


public class GoogleSteps {

  @Given("^I open google page$")
  public void iWillOpenGooglePage() {
    mainPage.openGooglePage();
  }


  @Then("^I validate title and URL$")
  public void assertPageOpened() {
    mainPage.i_print_title_and_URL();
  }
}