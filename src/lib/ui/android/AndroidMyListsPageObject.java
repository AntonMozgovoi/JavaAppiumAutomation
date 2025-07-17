package lib.ui.android;

import io.appium.java_client.AppiumDriver;
import lib.ui.MyListsPageObject;

public class AndroidMyListsPageObject extends MyListsPageObject{
    static{
        FOLDER_BY_NAME_TPL = "xpath://*[@text='{FOLDER_NAME}']";
        BUTTON_GOT_IT = "id:org.wikipedia:id/buttonView";
        ARTICLE_BY_TITLE_TPL = "xpath://*[@text='{TITLE}']";
    }

    public AndroidMyListsPageObject(AppiumDriver driver)
    {
        super(driver);
    }
}
