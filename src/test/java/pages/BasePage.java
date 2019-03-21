package pages;

import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static io.appium.java_client.touch.offset.PointOption.point;
import static java.time.Duration.ofMillis;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Sleeper;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
//import utils.main.common;
import utils.tools.QaComparator;

public abstract class BasePage extends QaComparator{

    protected Logger log = LoggerFactory.getLogger(this.getClass());


	 /**
     * The driver
     */
    public static AppiumDriver<MobileElement> driver;
    TouchAction touchAction;
	private Dimension size;

    private static final int KEYBOARD_ANIMATION_DELAY = 1000;
    private static final int XML_REFRESH_DELAY = 1000;

	public PersonPage personPage;


    /**
     * get the current Selenium web driver
     *
     * @return WebDriver
     */

    public BasePage() {
    }


    public AppiumDriver<MobileElement> getDriver() {
        return driver;
    }


    protected BasePage(AppiumDriver driver){
        this.driver = driver;
        log.info("driver is"+ driver);
        //PageFactory.initElements(new AppiumFieldDecorator(driver, 5, TimeUnit.SECONDS), this);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);


    }






	public void waitForVisibilityOf(final By locator, final int time) {
        final WebDriverWait wait = new WebDriverWait(driver, time);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void waitForInvisibilityOf(final By locator, final int time) {
        final WebDriverWait wait = new WebDriverWait(driver, time);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    /* This is temporary method for download until the in cell progress bas is Implemented */
    public void waitForInvisibilityOfdownload(final By locator) {
        final WebDriverWait wait = new WebDriverWait(driver, 100000);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    /* Parent method to wait for a certain view to be clicked on screen. */
    public void waitForClickabilityOf(final By locator, final int time) {
        final WebDriverWait wait = new WebDriverWait(driver, time);
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    /* Scroll in to view of an element on the screen. */
    public void scrollIntoView(final By elementLocator) throws InterruptedException {
        final WebDriverWait wait = new WebDriverWait(driver, 50);
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(elementLocator));
        final MobileElement element = driver.findElements(elementLocator).get(0);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        Sleeper.SYSTEM_SLEEPER.sleep(Duration.ofMillis(500));
    }

    /* Parent method to perform a click by resource ID */
    public void click(final By locator) {

        driver.findElement(locator).click();

    }

    /* Parent method to get list size */
    public int getCount(final By itemlocator) {

        return driver.findElements(itemlocator).size();

    }






    public void navigateToSecondScreen() {
    	By locator_plusicon=By.id("com.eliasnogueira.workshop:id/fab");


		click(locator_plusicon);
	}



      /**
     * Tries three times to send text to element properly.
     *
     * Note: This method was needed because Appium sometimes sends text to textboxes incorrectly.
     *
     * @param input String to be sent
     * @param element WebElement to receive text, cannot be a secure text field.
     * @param appendNewLine true to append a new line character to incoming string when sending to element, else false
     *
     * @return true if keys were successfully sent, otherwise false.
     */
    protected boolean sendKeysToElement(String input, MobileElement element, boolean appendNewLine) throws InterruptedException {
        final int MAX_ATTEMPTS = 3;
        int attempts = 0;

        do {
            element.clear();
            Thread.sleep(KEYBOARD_ANIMATION_DELAY);

            if (appendNewLine) {
                element.sendKeys(input + "\n");
            } else {
                element.sendKeys(input);
            }

            Thread.sleep(XML_REFRESH_DELAY);
        } while (!element.getText().contains(input) && ++attempts < MAX_ATTEMPTS);

        return element.getText().contains(input);
    }



    public void swipeRightToLeft() throws InterruptedException {

        touchAction = new TouchAction(driver);
        getDriver().context("NATIVE_APP");
        size = driver.manage().window().getSize();
        System.out.println(size);

        final int startx = (int) (size.width * 0.80);
        final int endx = (int) (size.width * 0.10);
        final int starty = size.height / 2;
        System.out.println("startx = " + startx + " ,endx = " + endx + " , starty = " + starty);

        // Swipe from Right to Left.
       touchAction.press(point(startx, starty)).waitAction(waitOptions(ofMillis(500))).moveTo(point(endx, starty)).release().perform();
        Thread.sleep(2000);
    }

    public void swipeLeftToRight() throws InterruptedException {

        touchAction = new TouchAction(driver);
        getDriver().context("NATIVE_APP");
        size = driver.manage().window().getSize();
        System.out.println(size);

        final int startx = (int) (size.width * 0.80);
        final int endx = (int) (size.width * 0.10);
        final int starty = size.height / 2;
        System.out.println("startx = " + startx + " ,endx = " + endx + " , starty = " + starty);

        // Swipe from Left to Right.
       touchAction.press(point(endx, starty)).waitAction(waitOptions(ofMillis(500))).moveTo(point(startx, starty)).release().perform();
        Thread.sleep(2000);

    }

    public void swipeTopToButtom() throws InterruptedException {

        touchAction = new TouchAction(driver);
        getDriver().context("NATIVE_APP");
        size = driver.manage().window().getSize();
        System.out.println(size);

        final int starty = (int) (size.height * 0.80);
        final int endy = (int) (size.height * 0.10);
        final int startx = size.width / 2;
        System.out.println("starty = " + starty + " ,endy = " + endy + " , startx = " + startx);

        // Swipe from Top to Bottom.
        touchAction.press(point(startx, endy)).waitAction(waitOptions(ofMillis(500))).moveTo(point(startx, starty)).release().perform();
        Thread.sleep(2000);

    }

    public void swipeBottomToTop() throws InterruptedException {

        touchAction = new TouchAction(driver);
        getDriver().context("NATIVE_APP");
        size = driver.manage().window().getSize();
        System.out.println(size);

        final int starty = (int) (size.height * 0.80);
        final int endy = (int) (size.height * 0.10);
        final int startx = size.width / 2;
        System.out.println("starty = " + starty + " ,endy = " + endy + " , startx = " + startx);

        // Swipe from Bottom to Top.
        touchAction.press(point(startx, starty)).waitAction(waitOptions(Duration.ofMillis(500))).moveTo(point(startx, endy)).release().perform();
        Thread.sleep(2000);

    }

    /* Parent method to send keys to a edit text view from keyboard */
    public void sentkeys(final By itemlocator, final String keyword) {

        driver.findElement(itemlocator).sendKeys(keyword);
    }


}
