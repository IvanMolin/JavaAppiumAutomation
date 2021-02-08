package Lib.ui;

import io.appium.java_client.AppiumDriver;


public class SearchPageObject extends MainPageObject{

    private static final String
    SEARCH_INIT_ELEMENT = "xpath://*[contains(@text,'Search Wikipedia')]",
    SEARCH_INPUT = "xpath://*[contains(@text,'Search…')]",
    SEARCH_CANCEL_BUTTON = "id:org.wikipedia:id/search_close_btn",
    SEARCH_RESULT_BY_SUBSTRING_TPL = "xpath://*[@resource-id='org.wikipedia:id/page_list_item_container']//*[@text='{SUBSTRING}']";

    public SearchPageObject (AppiumDriver driver)
    {
        super(driver);
    }
    /* TEMPLATES METHODS */
    private static String getResultSearchElement(String substring)
    {
        return SEARCH_RESULT_BY_SUBSTRING_TPL.replace("{SUBSTRING}", substring);
    }
    /* TEMPLATES METHODS */
    public void initSearchInput ()
    {
        this.waitForElementAndClick(SEARCH_INIT_ELEMENT, "Cannot find and click search init element",5);
        this.waitForElementPresent(SEARCH_INIT_ELEMENT, "Cannot find search input after clicking search init element");
    }

    public void waitForCancelButtonToAppear ()
    {
        this.waitForElementPresent(SEARCH_CANCEL_BUTTON, "Cannot find search cancel button!", 5);
    }

    public void waitForCancelButtonToDisappear ()
    {
        this.waitForElementNotPresent(SEARCH_CANCEL_BUTTON, "Search cancel button is still present!", 5);
    }

    public void clickCancelSearch()
    {
        this.waitForElementAndClick(SEARCH_CANCEL_BUTTON, "Cannot find and click search cancel button",5);
    }

    public void typeSearchLine (String search_Line)
    {
        this.waitForElementAndSendKeys(SEARCH_INPUT, search_Line, "Cannot find and type into search input", 5);
    }

    public void waitForSearchResult(String substring)
    {
        String search_result_xpath = getResultSearchElement(substring);
        this.waitForElementPresent(search_result_xpath, "Cannot find search result with substring" + substring);
    }

    public void DoNotWaitForSearchResult(String substring)
    {
        String search_result_xpath = getResultSearchElement(substring);
        this.waitForElementNotPresent(search_result_xpath, "Cannot find search result with substring" + substring,5);
    }

    public void clickByArticleWithSubstring(String substring)
    {
        String search_result_xpath = getResultSearchElement(substring);
        this.waitForElementAndClick(search_result_xpath, "Cannot find and click search result with substring" + substring, 5);
    }
}
