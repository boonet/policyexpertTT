package stepdefinitions;

import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.io.IOException;
import java.util.List;

public class MiscellaneousStepDef extends BasePageActions{


    @Given("^I choose (.*) for joint policy holder$")
        public void jointPolicyHolder(String decision) throws IOException, InterruptedException {
        clickElementByXPath("JointPolicy_"+decision.toLowerCase());
    }

    @And("^my insurance is held for \"([^\"]*)\"$")
    public void myInsuranceIsHeldFor(String time) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        selectElementByXpath(time,"Insurance_heldfor");
    }


    @And("^claims made earlier is a \"([^\"]*)\"$")
    public void claimsMadeEarlierIsA(String claims) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        clickElementByXPath("Insurance_claimsmade_"+claims.toLowerCase());
    }


    @And("^policy should start \"([^\"]*)\"$")
    public void policyShouldStart(String start) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        clickElementByXPath("Policy_start_"+start.toLowerCase());
    }

    @And("^my policy requirements for \"([^\"]*)\" are as$")
    public void myPolicyRequirementsForAreAs(String type, DataTable dataTable) throws Throwable {
        selectElementByXpath(type,"Policy_type");
        List<String> req = dataTable.asList(String.class);
        enterTextByLocator(req.get(0),"Policy_currentvalue");
        enterTextByLocator(req.get(1),"Policy_rebuildcost");
        clickElementByXPath("Policy_upgrade_"+req.get(2));
        selectElementByXpath(req.get(3),"Policy_excess");
    }

    @When("^I compare quotes$")
    public void iCompareQuotes() throws IOException, InterruptedException {
        clickElementByXPath("Policy_compare_Quotes");
    }


    @Then("^I should be on the quote listings page$")
    public void shouldBeOnQuoteListings() throws Throwable {
        shouldVerify("Amend details","Results_amendbutton");
    }

    @And("^I close the browser$")
    public void iCloseTheBrowser() throws Exception {
        tearDown();
    }
}

