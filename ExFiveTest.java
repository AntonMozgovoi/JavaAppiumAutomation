import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.net.URL;

public class ExFiveTest {

    private AppiumDriver driver;

    @Before
    public void setUp() throws Exception {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "AndroidTestDevice");
        capabilities.setCapability("platformVersion", "8.0");
        capabilities.setCapability("automationName", "Appium");
        capabilities.setCapability("appPackage", "org.wikipedia");
        capabilities.setCapability("appActivity", ".main.MainActivity");
        capabilities.setCapability("app", "C:/Users/Anton/Desktop/JavaAppiumAutomation/apks/org.wikipedia.apk");

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void testSwipeOnBoarding()
    {

        swipeLeftToFindElement(
                By.xpath("//*[@text='New ways to explore']"),
                "Cannot find text 'New ways to explore'",
                10
        );

        String first_title_text = waitForElementAndGetAttribute(
                By.xpath("//*[@text='New ways to explore']"),
                "text",
                "Cannot find title text",
                15
        );

        Assert.assertEquals(
                "text not founded",
                "New ways to explore",
                first_title_text);



        swipeLeftToFindElement(
                By.xpath("//*[@text='Reading lists with sync']"),
                "Cannot swipe to 'Reading lists with sync'",
                10
        );

        String second_title_text = waitForElementAndGetAttribute(
                By.xpath("//*[@text='Reading lists with sync']"),
                "text",
                "Cannot find title text",
                15
        );

        Assert.assertEquals(
                "text not founded",
                "Reading lists with sync",
                second_title_text);


        swipeLeftToFindElement(
                By.xpath("//*[@text='Data & Privacy']"),
                "Cannot swipe to 'Data & Privacy'",
                10
        );

        String third_title_text = waitForElementAndGetAttribute(
                By.xpath("//*[@text='Data & Privacy']"),
                "text",
                "Cannot find title text",
                15
        );

        Assert.assertEquals(
                "text not founded",
                "Data & Privacy",
                third_title_text);

        waitForElementAndClick(
                By.id("org.wikipedia:id/fragment_onboarding_done_button"),
                "Cannot find button 'Get started'",
                5
        );

        waitForElementPresent(
                By.id("org.wikipedia:id/main_toolbar_wordmark"),
                "The main page didn't open",
                10
        );


    }

    private WebElement waitForElementPresent(By by, String error_message, long timeoutInSeconds)
    {
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        wait.withMessage(error_message + "\n");
        return wait.until(
                ExpectedConditions.presenceOfElementLocated(by)
        );
    }

    private WebElement waitForElementPresent(By by, String error_message) {

        return waitForElementPresent(by, error_message, 5);
    }

    private WebElement waitForElementAndClick(By by, String error_message, long timeoutInSeconds)
    {
        WebElement element = waitForElementPresent(by, error_message, timeoutInSeconds);
        element.click();
        return element;
    }


    protected void swipeLeft(int timeOfSwipe)
    {
        TouchAction action = new TouchAction(driver);
        Dimension size = driver.manage().window().getSize();
        int y = size.height / 2;
        int start_x = (int)(size.width * 0.7);
        int end_x = (int)(size.width * 0.2);

        action.press(start_x, y).waitAction(timeOfSwipe).moveTo(end_x, y).release().perform();

    }

    protected void swipeLeftQuick()
    {
        swipeLeft(200);
    }

    protected void swipeLeftToFindElement(By by, String error_message, int max_swipes)
    {
        int already_swiped = 0;
        while (driver.findElements(by).size() == 0) {
            if (already_swiped > max_swipes){
                waitForElementPresent(by, "Cannot find element by swiping left. \n" + error_message, 0);
                return;
            }
            swipeLeftQuick();
            ++already_swiped;
        }

    }

    private String waitForElementAndGetAttribute(By by, String attribute, String error_message, long timeoutInSeconds)
    {
        WebElement element = waitForElementPresent(by, error_message, timeoutInSeconds);
        return element.getAttribute(attribute);
    }
}
