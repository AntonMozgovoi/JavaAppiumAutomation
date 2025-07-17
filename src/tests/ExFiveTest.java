package tests;
import lib.CoreTestCase;
import lib.ui.OnBoardingPageObject;
import lib.ui.factories.OnBoardingPageObjectFactory;
import org.junit.Test;

public class ExFiveTest extends CoreTestCase {

    @Test
    public void testSwipeOnBoarding()
    {

        OnBoardingPageObject OnBoardingPageObject = OnBoardingPageObjectFactory.get(driver);
        OnBoardingPageObject.swipeToSecondScreen();
        String text_second_page = OnBoardingPageObject.GetTextFromSecondPage();
        assertEquals(
                "We see unexpected text",
                text_second_page,
                "New ways to explore"
        );
        OnBoardingPageObject.swipeToThirdScreen();
        String text_third_page = OnBoardingPageObject.GetTextFromThirdPage();
        assertEquals(
                "We see unexpected text",
                text_third_page,
                "Reading lists with sync"
        );
        OnBoardingPageObject.swipeToFourthScreen();
        String text_fourth_page = OnBoardingPageObject.GetTextFromFourthPage();
        assertEquals(
                "We see unexpected text",
                text_fourth_page,
                "Data & Privacy"
        );
        OnBoardingPageObject.click_button_start();
        OnBoardingPageObject.open_main_page();
    }
}
