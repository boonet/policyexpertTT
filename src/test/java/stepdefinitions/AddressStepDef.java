package stepdefinitions;

import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;

import java.io.IOException;
import java.util.List;

public class AddressStepDef extends BasePageActions{


    @Given("^I fill all the address related fields as$")
    public void fillAddressSection(DataTable data) throws Exception {
        List<String> address = data.asList(String.class);
        enterTextByLocator(address.get(0),"Address_address");
        clickElementByXPath("Address_enteraddress");
        clickElementByXPath("Address_enteraddress");
        enterTextByLocator(address.get(1),"Address_firstline");
        enterTextByLocator(address.get(2),"Address_secondline");
        enterTextByLocator(address.get(3),"Address_town");
        enterTextByLocator(address.get(4),"Address_postcode");
        clickElementByXPath("Address_savebutton");
        clickElementByXPath("Address_corresponding_"+address.get(5).toLowerCase());
        selectElementByXpath(address.get(6),"Address_propertytype");
        enterTextByLocator(address.get(7),"Address_propertydesc");
        enterTextByLocator(address.get(8),"Address_propertyyear");
        selectElementByXpath(address.get(9),"Address_bedrooms");
        selectElementByXpath(address.get(10),"Address_owner");
        selectElementByXpath(address.get(11),"Address_occupiedby");
        selectElementByXpath(address.get(12),"Address_occupiedwhen");
        clickElementByXPath("Address_trees_"+address.get(13).toLowerCase());
        clickElementByXPath("Address_flatroof_"+address.get(14).toLowerCase());

    }

    @And("^I \"([^\"]*)\" to statements about my property$")
    public void iToStatementsAboutMyProperty(String decision) throws Throwable {
        switch (decision) {
            case "Agree":
                clickElementByXPath("Property_Statement_agree");
                break;
            case "Disagree":
                clickElementByXPath("Property_Statement_disagree");
                break;
        }
    }
}
