package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;

public class ArticlePageObject extends MainPageObject
{
    private static final String
        TITLE = "id:org.wikipedia:id/view_page_title_text",
        FOOTER_ELEMENT = "xpath://*[@text = 'View article in browser']",
        SAVE_ARTICLE_BUTTON = "id:org.wikipedia:id/page_save",
        ADD_TO_LIST_BUTTON = "id:org.wikipedia:id/snackbar_action",
        OK_BUTTON = "xpath://*[@text='OK']",
        MY_LIST_NAME_INPUT = "xpath://*[contains(@text,'Name of this list')]",
        NAVIGATE_BUTTON = "xpath://*[@content-desc = 'Navigate up']",
        CLOSE_WIKIPEDIA_GAMES = "id:org.wikipedia:id/closeButton",
        TITLE_CONTENT = "xpath://*[@content-desc='Java (programming language)']";

    public ArticlePageObject(AppiumDriver driver)
    {
        super(driver);
    }

    public void clickCloseButton()
    {
        this.waitForElementAndClick(CLOSE_WIKIPEDIA_GAMES, "Cannot find close button",5);
    }


    public WebElement waitForTitleElement()
    {
        return this.waitForElementPresent(TITLE, "Cannot find article title on page", 15);
    }


    public String getArticleTitle()
    {
        WebElement title_element = waitForTitleElement();
        return title_element.getAttribute("text");
    }


    public void swipeToFooter()
    {
        this.swipeUpToFindElement(
                FOOTER_ELEMENT,
                "Cannot find the end of the article",
                20
        );
    }

    public void addArticleToMyList(String name_of_folder)
    {
        this.waitForElementAndClick(
                SAVE_ARTICLE_BUTTON,
                "Cannot save article",
                5
        );

        this.waitForElementAndClick(
                ADD_TO_LIST_BUTTON,
                "Cannot add to list",
                5
        );

        this.waitForElementAndSendKeys(
                MY_LIST_NAME_INPUT,
                name_of_folder,
                "Cannot find field 'Name of this list'",
                5

        );
        this.waitForElementAndClick(
                OK_BUTTON,
                "Cannot find button 'OK'",
                5
        );
    }

    public void closeArticle()
    {
        this.waitForElementAndClick(
                NAVIGATE_BUTTON,
                "Cannot find 'Navigate up'",
                5
        );
    }

    public void getHeaderOfArticle()
    {
        this.waitForElementPresent(TITLE_CONTENT, "Cannot find article title on page", 15);
    }
}
