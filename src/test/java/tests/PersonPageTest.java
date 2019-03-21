package tests;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.PersonPage;


/**
 * @author garima
 * This is the test class for the second screen opened in app
 * contains all bdd step definition for the respective feature file
 * {@PersonPageTest.feature}
 * extends to BaseTest for driver initialization ,quit etc
 * see {@code}
 * @
 */

public class PersonPageTest extends BaseTest {


	protected Logger log = LoggerFactory.getLogger(this.getClass());
	private PersonPage personPage;



	//@Override
	@Given("^I navigate to the person page$")
	public void setUpThisPage() {
		personPage = new PersonPage(driver);
		personPage.navigateToSecondScreen();

	}


	/* @Given("the package \"([^\"]*)\" is launched")
    public void package_is_launched(String string) {
    	log.info("BeforeSuite takes care of launching the app");
    	String actual=driver.getCapabilities().getCapability("appPackage").toString();
    	compareObjectValue("checking app package installed", string, actual, true);

    }*/

	@Then("check that \"([^\"]*)\"  \"([^\"]*)\"")
	public void check_That(String element, String presence) {
		boolean expected=false;
		if(presence.equals("true")||presence.equals("false"))
		{
			expected= Boolean.valueOf(presence);
		}
		boolean current=personPage.checkElementPresence(element);
		personPage.compareObjectValue("elements presence", expected, current, false);

	}

     @When("^I enter \"([^\"]*)\" to \"([^\"]*)\"$")
	public void I_enter_input_to_name(String text, String element) {
		try {
			personPage.fillTextValues(element, text);
		}

		catch (InterruptedException e) {
			e.printStackTrace();
		}
	}


     @Then("^\"([^\"]*)\" should be visible on \"([^\"]*)\"$")
 	public void text_should_be_visible(String text, String element) {

    	 String current= personPage.checkElementText(element);
 		personPage.compareObjectValue("text presence", text, current, false);



 	}


	@Override
	public void setUpPage() {
		// TODO Auto-generated method stub

	}








}



