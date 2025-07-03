package tests;

import lib.CoreTestCase;
import lib.ui.SearchPageObject;
import org.junit.Test;


public class ExThirdTest extends CoreTestCase{

    @Test
    public void testCancelSearch()
    {
        SearchPageObject SearchPageObject = new SearchPageObject(driver);

        SearchPageObject.clickSkipButton(); // клик по кнопке Skip
        SearchPageObject.initSearchInput(); // Клик по строке поиска
        SearchPageObject.typeSearchLine("Java"); // Ввод текста для поиска
        SearchPageObject.waitForSearchResultList(); // Ожидание списка
        int amount_of_search_results = SearchPageObject.getAmountOfFoundArticles();    // Проверка количества элементов результата поиска
        assertTrue(
                "Cannot find anything by the request",
                amount_of_search_results > 0
        );
        SearchPageObject.clickCancelSearch(); // Очистка строки поиска
        SearchPageObject.waitForSearchListIsEmpty(); // Элементы списка больше не отображаются
    }
}

