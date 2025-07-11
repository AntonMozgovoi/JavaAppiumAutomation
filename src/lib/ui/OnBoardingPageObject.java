package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;


public class OnBoardingPageObject extends MainPageObject
{
    public static final String
        SECOND_SCREEN = "xpath://*[@text='New ways to explore']",
        THIRD_SCREEN = "xpath://*[@text='Reading lists with sync']",
        FOURTH_SCREEN = "xpath://*[@text='Data & Privacy']",
        ONBOARDING_DONE_BUTTON = "id:org.wikipedia:id/fragment_onboarding_done_button",
        WOODMARCK = "id:org.wikipedia:id/main_toolbar_wordmark";

    public OnBoardingPageObject (AppiumDriver driver)
    {
        super (driver);
    }

    /* МЕТОДЫ СВАЙПА К ЭЛЕМЕНТАМ */

    public void swipeToSecondScreen()
    {
        this.swipeLeftToFindElement(
                SECOND_SCREEN,
                "Cannot find the end of the article",
                20
        );
    }

    public void swipeToThirdScreen()
    {
        this.swipeLeftToFindElement(
                THIRD_SCREEN,
                "Cannot find the end of the article",
                20
        );
    }

    public void swipeToFourthScreen()
    {
        this.swipeLeftToFindElement(
                FOURTH_SCREEN,
                "Cannot find the end of the article",
                20
        );
    }

    /* МЕТОДЫ СВАЙПА К ЭЛЕМЕНТАМ */
    /* МЕТОДЫ ПОИСКА ТЕКСТА СТРАНИЦЫ */

    public String GetTextFromSecondPage()
    {
        WebElement page_text = this.waitForElementPresent(SECOND_SCREEN, "Cannot find text on second page", 15);
        return page_text.getAttribute("text");
    }

    public String GetTextFromThirdPage()
    {
        WebElement page_text = this.waitForElementPresent(THIRD_SCREEN, "Cannot find text on third page", 15);
        return page_text.getAttribute("text");
    }

    public String GetTextFromFourthPage()
    {
        WebElement page_text = this.waitForElementPresent(FOURTH_SCREEN, "Cannot find text on fourth page", 15);
        return page_text.getAttribute("text");
    }

    /* МЕТОДЫ ПОИСКА ТЕКСТА СТРАНИЦЫ */

    public void click_button_start()
    {
        this.waitForElementAndClick(
                ONBOARDING_DONE_BUTTON,
                "Cannot find button 'Get started'",
                10);
    }

    public void open_main_page()
    {
        this.waitForElementPresent(
                WOODMARCK,
                "The main page didn't open",
                15

        );
    }
}
