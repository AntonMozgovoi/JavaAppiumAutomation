package lib.ui.ios;

import io.appium.java_client.AppiumDriver;
import lib.ui.OnBoardingPageObject;

public class iOSOnBoardingPageObject extends OnBoardingPageObject
{
    static{
        SECOND_SCREEN = "id:'New ways to explore']";
        THIRD_SCREEN = "id:'Reading lists with sync']";
        FOURTH_SCREEN = "id:'Data & Privacy']";
        ONBOARDING_DONE_BUTTON = "id:org.wikipedia:id/fragment_onboarding_done_button";
    }

    public iOSOnBoardingPageObject(AppiumDriver driver)
    {
        super(driver);
    }
}
