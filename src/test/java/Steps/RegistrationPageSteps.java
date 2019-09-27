package Steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class RegistrationPageSteps {
    @Given("^User open the registartion screen$")
    public void user_open_the_registartion_screen() {
        System.out.println("Open registartion link");
    }

    @When("^enter the user detals$")
    public void enter_the_user_detals() {
        System.out.println("ENter the regristation detais");
    }

    @Then("^lands on success screen$")
    public void lands_on_success_screen() {
        System.out.println("Lands on success screen");
    }
}
