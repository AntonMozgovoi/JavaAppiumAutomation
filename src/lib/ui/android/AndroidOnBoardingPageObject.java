package lib.ui.android;

import io.appium.java_client.AppiumDriver;
import lib.ui.OnBoardingPageObject;

public class AndroidOnBoardingPageObject extends OnBoardingPageObject
{
    static{
        SECOND_SCREEN = "xpath://*[@text='New ways to explore']";
        THIRD_SCREEN = "xpath://*[@text='Reading lists with sync']";
        FOURTH_SCREEN = "xpath://*[@text='Data & Privacy']";
        ONBOARDING_DONE_BUTTON = "id:org.wikipedia:id/fragment_onboarding_done_button";
        WOODMARCK = "id:org.wikipedia:id/main_toolbar_wordmark";

    }

    public AndroidOnBoardingPageObject(AppiumDriver driver)
    {
        super(driver);
    }
}
