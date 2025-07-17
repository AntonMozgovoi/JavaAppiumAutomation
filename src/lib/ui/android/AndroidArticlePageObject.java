package lib.ui.android;

import io.appium.java_client.AppiumDriver;
import lib.ui.ArticlePageObject;

public class AndroidArticlePageObject extends ArticlePageObject
{
    static {
        TITLE = "id:org.wikipedia:id/view_page_title_text";
        FOOTER_ELEMENT = "xpath://*[@text = 'View article in browser']";
        SAVE_ARTICLE_BUTTON = "id:org.wikipedia:id/page_save";
        ADD_TO_LIST_BUTTON = "id:org.wikipedia:id/snackbar_action";
        OK_BUTTON = "xpath://*[@text='OK']";
        MY_LIST_NAME_INPUT = "xpath://*[contains(@text,'Name of this list')]";
        NAVIGATE_BUTTON = "xpath://*[@content-desc = 'Navigate up']";
        CLOSE_WIKIPEDIA_GAMES = "id:org.wikipedia:id/closeButton";
        TITLE_CONTENT = "xpath://*[@content-desc='Java (programming language)']";
    }

    public AndroidArticlePageObject(AppiumDriver driver)
    {
        super(driver);
    }
}
