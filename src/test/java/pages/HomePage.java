package pages;



import java.util.List;

import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;



/**
 * @author garima
 * This is the page class for the first screen opened in app
 * contains all elements locators for the respective page
 *
 * Responsible doing all the interactions for ListActivity
 * extends to BasePage for common interaction methods like sendkeys, click etc
 */



public class HomePage extends BasePage{

    protected Logger log = LoggerFactory.getLogger(this.getClass());

	public MobileElement refreshButton;

	String locator_refreshButton="com.eliasnogueira.workshop:id/refresh";

	By locator_plusicon=By.id("com.eliasnogueira.workshop:id/fab");


	public HomePage(AppiumDriver<MobileElement> driver) {
		super(driver);

	}



	/*public  boolean refreshbuttonPresence() {
		System.out.println("driver"+ driver);
		refreshButton=driver.findElementsById(locator_refreshButton).get(0);
		boolean result= refreshButton.isDisplayed();
		System.out.println("result"+ result);
		return result;

	}
*/

	public boolean checkElementPresence(String element) {
		log.info("driver accessed here is"+ driver);
		log.info("id"+ "com.eliasnogueira.workshop:id/"+ element);
		List<MobileElement> mobileElement = driver.findElementsById("com.eliasnogueira.workshop:id/"+ element);
        boolean result=false;
		if((mobileElement.size())>0) {
		result= true;
        }
      log.info("element"+ element +"is present:"+ result);
		return result;


	}

	



}
