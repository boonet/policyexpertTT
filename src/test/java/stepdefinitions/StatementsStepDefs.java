package stepdefinitions;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

import java.io.IOException;
import java.util.List;


public class StatementsStepDefs extends BasePageActions {


    @Then("^I fill the statements section with$")
    public void fillStatementsSection(DataTable data) throws IOException, InterruptedException {
        List<String> statements = data.asList(String.class);
        String agree = statements.get(0);
        switch (agree) {
            case "Agree":
                clickElementByXPath("Statements_Iagree");
                return;
            case "Disagree":
                clickElementByXPath("Statement_Idisagree");

        }
    }

    @And("^I \"([^\"]*)\" to statements about me$")
    public void iToStatementsAboutMe(String agree) throws Throwable {
        switch (agree) {
            case "Agree":
                clickElementByXPath("Statements_Iagree");
            case "Disagree":
                clickElementByXPath("Statement_Idisagree");
        }
    }

    @And("^I fill all the statements after disagreement as$")
    public void iFillAllTheStatementsAfterDisagreementAs(DataTable data) throws IOException, InterruptedException {
        List<String> statements = data.asList(String.class);
        clickElementByXPath("Statement_business_"+statements.get(0).toLowerCase());
        clickElementByXPath("Statement_bankruptcy_"+statements.get(1).toLowerCase());
        clickElementByXPath("Statement_ccj_"+statements.get(2).toLowerCase());
        clickElementByXPath("Statement_previousrefusal_"+statements.get(3).toLowerCase());
        clickElementByXPath("Statement_previouscancellation_"+statements.get(4).toLowerCase());
        clickElementByXPath("Statement_conviction_"+statements.get(5).toLowerCase());
    }
}

