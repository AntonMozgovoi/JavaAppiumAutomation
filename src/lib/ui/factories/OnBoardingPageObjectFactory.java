package lib.ui.factories;
import io.appium.java_client.AppiumDriver;
import lib.Platform;
import lib.ui.OnBoardingPageObject;
import lib.ui.android.AndroidOnBoardingPageObject;
import lib.ui.ios.iOSOnBoardingPageObject;

public class OnBoardingPageObjectFactory
{

    public static OnBoardingPageObject get(AppiumDriver driver)
    {
        if (Platform.getInstance().isAndroid()) {
            return new AndroidOnBoardingPageObject(driver);
        } else {
            return new iOSOnBoardingPageObject(driver);
        }
    }
}
