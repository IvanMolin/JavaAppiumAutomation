package Tests;

import Lib.CoreTestCase;
import Lib.ui.ArticlePageObject;
import Lib.ui.SearchPageObject;
import org.junit.Test;
import org.openqa.selenium.By;

public class ArticleTests extends CoreTestCase

{
    @Test
    public void testCompareArticleTitle() {
        SearchPageObject SearchPageObject = new SearchPageObject(driver);
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.clickByArticleWithSubstring("Object-oriented programming language");

        ArticlePageObject ArticlePageObject = new ArticlePageObject(driver);
        String article_title = ArticlePageObject.getArticleTitle("a");

        assertEquals(
                "We see unexpected title",
                "Java (programming language)",
                article_title
        );
    }

    //ex6
    @Test
    public void testAssertTitle() {
        String search_line = "Java";
        String article = "Object-oriented programming language";


        SearchPageObject SearchPageObject = new SearchPageObject(driver);
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine(search_line);
        SearchPageObject.clickByArticleWithSubstring(article);

        ArticlePageObject ArticlePageObject = new ArticlePageObject(driver);
        ArticlePageObject.waitForTitleElementWithSubstring(article);
        String article_title = ArticlePageObject.getArticleTitle(article);
        //ищу title-description, так как у титла нет id, решил взять другой элемент
        ArticlePageObject.waitForTitleDescription();


    }

   }
