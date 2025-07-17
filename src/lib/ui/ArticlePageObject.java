package lib.ui;

import io.appium.java_client.AppiumDriver;
import lib.Platform;
import org.openqa.selenium.WebElement;

abstract public class ArticlePageObject extends MainPageObject
{
    protected static String
        TITLE,
        FOOTER_ELEMENT,
        SAVE_ARTICLE_BUTTON,
        ADD_TO_LIST_BUTTON,
        OK_BUTTON,
        MY_LIST_NAME_INPUT,
        NAVIGATE_BUTTON,
        CLOSE_WIKIPEDIA_GAMES,
        TITLE_CONTENT;

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
        if (Platform.getInstance().isAndroid()) {
            return title_element.getAttribute("text");
        } else {
            return title_element.getAttribute("name");
        }
    }


    public void swipeToFooter()
    {
        if(Platform.getInstance().isAndroid()) {
            this.swipeUpToFindElement(
                    FOOTER_ELEMENT,
                    "Cannot find the end of the article",
                    40
            );
        } else {
            this.swipeUpTillElementAppear(FOOTER_ELEMENT,
            "Cannot find the end of article",
            40);
        }
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

    public void addArticlesToMySaved(){
        this.waitForElementAndClick(ADD_TO_LIST_BUTTON, "Cannot find option to add article to reading list",5);
    }
}
