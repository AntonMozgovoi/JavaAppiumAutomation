package lib.ui.ios;

import io.appium.java_client.AppiumDriver;
import lib.ui.ArticlePageObject;

public class iOSArticlePageObject extends ArticlePageObject
{
    static {
        TITLE = "id:Java (programming language)";
        FOOTER_ELEMENT = "id:View article in browser";
        ADD_TO_LIST_BUTTON = "id:Save for later";
        NAVIGATE_BUTTON = "id:Back]";


    }

    public iOSArticlePageObject(AppiumDriver driver)
        {
            super(driver);
     }
}


