package Tests;

import Lib.CoreTestCase;
import Lib.ui.SearchPageObject;
import org.junit.Test;

public class SearchTest extends CoreTestCase {
    //ex3
    @Test
    public void testCancelSearch() {
        SearchPageObject SearchPageObject = new SearchPageObject(driver);
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.waitForSearchResult("Island of Indonesia");
        SearchPageObject.waitForSearchResult("Programming language");
        SearchPageObject.waitForSearchResult("Object-oriented programming language");
        SearchPageObject.clickCancelSearch();
        SearchPageObject.DoNotWaitForSearchResult("Island of Indonesia");
        SearchPageObject.DoNotWaitForSearchResult("Programming language");
        SearchPageObject.DoNotWaitForSearchResult("Object-oriented programming language");

    }


    @Test
    public void testCancelSearch2 ()
    {
        SearchPageObject SearchPageObject = new SearchPageObject(driver);
        SearchPageObject.initSearchInput();
        SearchPageObject.waitForCancelButtonToAppear();
        SearchPageObject.clickCancelSearch();
        SearchPageObject.waitForCancelButtonToDisappear();

    }



    @Test
    public void testSearch()

    {

        SearchPageObject SearchPageObject = new SearchPageObject(driver);
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.waitForSearchResult("Object-oriented programming language");

    }
}
