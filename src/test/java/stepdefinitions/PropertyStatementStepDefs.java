package stepdefinitions;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

import java.io.IOException;
import java.util.List;

public class PropertyStatementStepDefs extends BasePageActions {

    @And("^I fill all the property statements after disagreement as$")
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

