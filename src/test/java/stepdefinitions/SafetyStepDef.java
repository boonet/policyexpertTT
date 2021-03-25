package stepdefinitions;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;

import java.io.IOException;
import java.util.List;

public class SafetyStepDef extends BasePageActions{



    @And("^I fill all the safety details of the property as$")
    public void fillSafetyFeaturesOfProperty(DataTable data) throws IOException, InterruptedException {
        List<String> safety = data.asList(String.class);
        clickElementByXPath("Safety_windowkey_"+safety.get(0).toLowerCase());
        clickElementByXPath("Safety_selfcontained_"+safety.get(1).toLowerCase());
        clickElementByXPath("Safety_frenchdoors_"+safety.get(2).toLowerCase());
        clickElementByXPath("Safety_externaldoors_"+safety.get(3).toLowerCase());
        clickElementByXPath("Safety_alarm_"+safety.get(4).toLowerCase());

    }
}
