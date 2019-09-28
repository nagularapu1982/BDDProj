package Steps;

import Pages.MotorsSearchPage;
import com.cucumber.listener.Reporter;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;


import static org.junit.Assert.*;
import static Steps.Hooks.driver;

public class MotorsSearch {

    MotorsSearchPage SearchPage;

    @Given("^successfully open Ebay motors application$")
    public void successfully_open_Ebay_motors_application(List<List<String>> list) {
        SearchPage = new MotorsSearchPage(driver);
        driver.getTitle().equals(list.get(0).get(1));
        SearchPage.ele_Heading.getText().equalsIgnoreCase(list.get(1).get(1));
        Reporter.addStepLog("User successfully open the application and verified the title and heading");

    }
    @When("^enter the postal code as (.+) and select the vehicle company as (.+)$")
    public void enter_the_postal_code_as_Client_and_select_the_vehicle_company_as_Ford(String PostalCode,String Company) throws InterruptedException {
        SearchPage.text_PostCode.sendKeys(PostalCode);
        Select selectCorrespondence= new Select(SearchPage.dd__Company);
        selectCorrespondence.selectByValue(Company);
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click()", SearchPage.btn_Search);

    }


    @Then("^user should be present with search cars results page with url (.+)$")
    public void userShouldBePresentWithSearchCarsResultsPageWithUrlSearchCar(String SearchURL) {
        assertTrue(driver.getCurrentUrl().contains(SearchURL));
        Reporter.addStepLog("User successfully Assert the "+SearchURL+" in the URL of the page");


    }

    @Then("^Get the results page count and print the results page count$")
    public void getTheResultsPageCount() {
        Reporter.addStepLog("No of the search results on the page: "+SearchPage.vechile_Results.size());
        Reporter.addStepLog("The page count of the search results: "+SearchPage.ele_PageCount.getText());

    }

    @When("^apply a model filter as (.+)$")
    public void applyAModelFilterAsModel(String model) {
        SearchPage.btn_Model.click();
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click()", SearchPage.btn_ModelSelection);
        for (WebElement element : SearchPage.list_Models){
            if(element.getText().contains(model)) {
                element.click();
                break;
            }
        }
        SearchPage.footer_Update.click();
        Reporter.addStepLog("User successfully applied the "+model+" model on results");
    }

    @When("^select to see full details of first result$")
    public void selectToSeeFullDetailsOfFirstResult() throws InterruptedException {
        Thread.sleep(3000);
        SearchPage.vechile_Results.get(0).click();
    }

    @Then("^output vehicle title and variant$")
    public void outputVehicleTitleAndVariant() {
        Reporter.addStepLog("Title of the vehicle from first result set is "+SearchPage.vehicle_Title.getText());
        Reporter.addStepLog("Varient of the vehicle from first result set is "+SearchPage.vehicle_Varient.getText());
    }

    @And("^verify the model as (.+)$")
    public void verifyTheModelAsModel(String Model) {
        Reporter.addStepLog("Assert the vehicle model from first results");
        assertTrue(SearchPage.vehicle_Title.getText().toLowerCase().contains(Model.toLowerCase()));

    }

    @And("^print vehicle distance from postcode as (.+)$")
    public void printVehicleDistanceFromPostcodeAsPostalCode(String Postalcode) {
        Reporter.addStepLog(SearchPage.miles_Away.getText()+" Mile away from "+Postalcode);

    }
}
