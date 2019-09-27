package Steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDefinations {

    @Given("^open the saas application$")
    public void open_the_saas_application() {
        System.out.println("Application Opened");
    }

    @When("^enter the login credentials$")
    public void enter_the_login_credentials() {
        System.out.println("User Login");
    }

    @Then("^user lands on home page$")
    public void user_lands_on_home_page() {
        System.out.println("Lands on the Home Page");
    }

}
