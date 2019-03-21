package tests;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.HomePage;



/**
 * @author garima
 * This is the test class for the first screen opened in app
 * contains all bdd step definition for the respective feature file
 *{@HomePageTest.feature}
 * extends to BaseTest for driver initialization ,quit etc
 * see {@BaseTest}
 *
 */

public class HomePageTest extends BaseTest {

	private HomePage homePage;

	protected Logger log = LoggerFactory.getLogger(this.getClass());






	/**
	 * go to homepage
	 *
	 */

	@Override
	@Given("^I navigate to the home page$")
	public void setUpPage() {
		homePage = new HomePage(driver);

	}


	@Given("^package is launched$")
	public void package_is_launched() {
		log.info("BeforeSuite takes care of launching the app and driver is"+ driver);
		String actual=driver.getCapabilities().getCapability("appPackage").toString();
		//homePage.compareObjectValue("checking app package installed", string, actual, true);

	}

	@Then("check that \"([^\"]*)\" is \"([^\"]*)\"")
	public void check_That(String element, String presence) {
		log.info("presence is"+ presence);
		boolean expected=false;
		if(presence.equals("true")||presence.equals("false"))
		{
			expected= Boolean.valueOf(presence);
		}
		boolean current=homePage.checkElementPresence(element);
		homePage.compareObjectValue("elements presence", expected, current, false);
	}

	@When("^i click on plus icon$")
	public void i_click_on_plus_icon() {
		//homePage.navigateToPersonPage();
	}


	@Then("check that it opens up person form")
	public void check_that_it_opens_up_person_form() {
		// Write code here that turns the phrase above into concrete actions
		//log.info("current activity"+ ((StartsActivity) driver).currentActivity());
		//String  current=((StartsActivity) driver).currentActivity();
		//homePage.compareObjectValue("activity is changed", "expected", current, false);



	}



}



