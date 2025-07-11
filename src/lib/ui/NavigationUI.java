package lib.ui;

import io.appium.java_client.AppiumDriver;


public class NavigationUI extends MainPageObject{

    private static final String
            MY_LIST_LINK = "id:org.wikipedia:id/nav_tab_reading_lists";
    public NavigationUI(AppiumDriver driver)
    {
        super(driver);
    }

    public void clickMyList()
    {
        this.waitForElementAndClick(
                MY_LIST_LINK,
                "Cannot open Saved List",
                5
        );
    }

}
