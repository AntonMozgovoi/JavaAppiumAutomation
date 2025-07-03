package tests;
import lib.CoreTestCase;
import lib.ui.ArticlePageObject;
import lib.ui.SearchPageObject;
import org.junit.Test;

public class ExSixTest extends CoreTestCase {

    @Test
    public void testElementPresent()

    {
        SearchPageObject SearchPageObject = new SearchPageObject(driver);

        SearchPageObject.clickSkipButton();
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.clickByArticleWithSubstring("Java (programming language)");

        ArticlePageObject ArticlePageObject = new ArticlePageObject(driver);
        ArticlePageObject.clickCloseButton();
        ArticlePageObject.getHeaderOfArticle();

    }

}

