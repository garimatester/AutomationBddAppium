package pages;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

/**
 * @author garima
 * This is the page class for the second screen opened in app
 * contains all elements locators for the respective page
 *
 * Responsible doing all the interactions for PersonActivity
 * extends to BasePage for common interaction methods like sendkeys, click etc
 */



public class PersonPage extends BasePage{

	protected Logger log = LoggerFactory.getLogger(this.getClass());


	public WebElement name;

	String  locator_name="com.eliasnogueira.workshop:id/txt_nome";


	public MobileElement endereco;

	String  locator_endereco="com.eliasnogueira.workshop:id/txt_endereco";


	public MobileElement hobbies;


	String locator_hobbies="com.eliasnogueira.workshop:id/txt_hobbies";


	public MobileElement button;

	String locator_button="com.eliasnogueira.workshop:id/button";





	public PersonPage(AppiumDriver<MobileElement> driver) {
		super()	;

	}



	/**
	 *
	 * This function checks that if a particular element is present
	 * on screen or not
	 * called from corresponding class PersonPageTest
	 * @return boolean result
	 */



	public boolean checkElementPresence(String element) {

		MobileElement mobileElement=driver.findElementById(locator_name);
		boolean result=false;
		if((mobileElement.isDisplayed())) {
			result= true;
		}
		log.info("element"+ element +"is present:"+ result);
		return result;


	}


	/**
	 *
	 * This function fills the text boxes
	 * on screen
	 * called from corresponding class PersonPageTest
	 * @return boolean result
	 * @throws InterruptedException
	 */


	public boolean fillTextValues(String element, String text) throws InterruptedException {
		boolean result=false;
		log.info("id"+ "com.eliasnogueira.workshop:id/"+ element);
		String id= "com.eliasnogueira.workshop:id/"+ element;
		MobileElement mobileElement=driver.findElementById(id);
		result=sendKeysToElement(text, mobileElement, false); //BasePage method is called
		log.info("name text is filled"+ result);
		return result;


	}


	/**
	 *
	 * This function returns text for an element
	 *
	 * called from corresponding class PersonPageTest
	 * @return String text
	 */

	public String checkElementText(String element) {

		log.info("id"+ "com.eliasnogueira.workshop:id/"+ element);
		String id= "com.eliasnogueira.workshop:id/"+ element;
		MobileElement mobileElement=driver.findElementById(id);
		String text=mobileElement.getText();
		return text;
	}


	/*public  void submitbutton() {
		button.click();

	}*/

}
