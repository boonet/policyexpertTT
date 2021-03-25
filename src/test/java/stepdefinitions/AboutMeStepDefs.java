package stepdefinitions;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import java.util.List;

import static utils.ConfigReader.getConfigValue;



public class AboutMeStepDefs extends BasePageActions {


	@Given("^I go to the homepage$")
	public void gotoHomepage() throws Exception {
		gotoUrl(getConfigValue("BaseUrl"));
	}

    @Then("^I fill the AboutMe section with$")
    public void fillAboutMeSection(DataTable data) throws Exception {

		 List<String> aboutme = data.asList(String.class);

			selectElementByXpath(aboutme.get(0),"AboutMe_title");
			enterTextByLocator(aboutme.get(1),"AboutMe_firstName");
			enterTextByLocator(aboutme.get(2),"AboutMe_lastName");
			selectElementByXpath(aboutme.get(3),"AboutMe_day");
			selectElementByXpath(aboutme.get(4),"AboutMe_month");
			selectElementByXpath(aboutme.get(5),"AboutMe_year");
			selectElementByXpath(aboutme.get(6),"AboutMe_marital");
			chooseCategoryByLocator(aboutme.get(7),"AboutMe_occupation");
			String smoke = aboutme.get(8);
			switch (smoke){
				case "No": clickElementByXPath("AboutMe_Smoke_No");
				case "Yes": clickElementByXPath("AboutMe_Smoke_Yes");
				default: clickElementByXPath("AboutMe_Smoke_No");
			}
			enterTextByLocator(aboutme.get(9),"AboutMe_mobile");
			enterTextByLocator(aboutme.get(10),"AboutMe_email");

	}
    }




