package Lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ArticlePageObject extends MainPageObject {
    private static final String
            TITLE = "//*[@text='{SUBSTRING}']",
            TITLE_DESCRIPTION = "pcs-edit-section-title-description",
            FOOTER_ELEMENT = "//*[@text='View article in browser']",
            BOOKMARK_BUTTON = "//android.widget.ImageView[@content-desc='More options']",
            ADD_TO_MY_LIST_BUTTON = "//*[@text='Add to reading list']",
            CREATE_NEW_LIST_BUTTON = "org.wikipedia:id/onboarding_button",
            MY_LIST_NAME_INPUT = "org.wikipedia:id/text_input",
            MY_LIST_OK_BUTTON = "//*[@text='OK']",
            MY_LIST_NAME_FOLDER_TPL = "//*[@text='{NAMEFOLDER}']",
            CLOSE_ARTICLE_BUTTON = "//android.widget.ImageButton[@content-desc='Navigate up']",
            BACK_BUTTON_FROM_SEARCH = "//android.widget.FrameLayout[@content-desc='My lists']";

    public ArticlePageObject(AppiumDriver driver)
    {
        super(driver);
    }

    /* TEMPLATES METHODS*/
    private static String getTitleElement(String substring)
    {
        return TITLE.replace("{SUBSTRING}", substring);
    }
    private static String getMylistFolderElement(String name_of_folder)
    {
        return MY_LIST_NAME_FOLDER_TPL.replace("{NAMEFOLDER}", name_of_folder);
    }
    /* TEMPLATES METHODS*/

    public WebElement waitForTitleElementWithSubstring(String substring) {
        String title_xpath = getTitleElement(substring);
        return this.waitForElementPresent(By.xpath(title_xpath), "Cannot find article title on page!", 15);
    }

    public String getArticleTitle(String substring) {
        WebElement title_element = waitForTitleElementWithSubstring(substring);
        return title_element.getAttribute("text");
    }

    public void swipeToFooter()
    {
        this.swipeUpToFindElement(
                By.xpath(FOOTER_ELEMENT),
                "Cannot find the end of the article",
                20
        );
    }

    public void addArticleToMyList(String name_of_folder)
    {
        this.waitForElementAndClick(
                By.xpath(BOOKMARK_BUTTON),
                "Cannot find menu bookmark",
                5
        );


        this.waitForElementAndClick(
                By.xpath(ADD_TO_MY_LIST_BUTTON),
                "Cannot find menu button 'add to..'",
                5
        );

        this.waitForElementAndClick(
                By.id(CREATE_NEW_LIST_BUTTON),
                "Cannot find button for create list",
                5
        );

        this.waitForElementAndClear(
                By.id(MY_LIST_NAME_INPUT),
                "Cannot find and clear field to create a new list",
                5
        );

        this.waitForElementAndSendKeys(
                By.id(MY_LIST_NAME_INPUT),
                name_of_folder,
                "Cannot find and send keys for field to create a new list",
                5
        );

        this.waitForElementAndClick(
                By.xpath(MY_LIST_OK_BUTTON),
                "Cannot find button 'OK'",
                5
        );
    }

    public void addArticleToSavedList(String name_of_folder)
    {
        String list_folder_xpath = getMylistFolderElement(name_of_folder);
        this.waitForElementAndClick(
                By.xpath(BOOKMARK_BUTTON),
                "Cannot find menu bookmark",
                5
        );


        this.waitForElementAndClick(
                By.xpath(ADD_TO_MY_LIST_BUTTON),
                "Cannot find menu button 'add to..'",
                5
        );

        this.waitForElementAndClick(
                By.xpath(list_folder_xpath),
                "Cannot find created list for article '"+name_of_folder+"'",
                5
        );

    }

    public void closeArticle()
    {
        this.waitForElementAndClick(
                By.xpath(CLOSE_ARTICLE_BUTTON),
                "Cannot find button 'back'",
                5
        );
    }

    public void backFromSearchMenu()
    {
        this.waitForElementAndClick(
                By.xpath(BACK_BUTTON_FROM_SEARCH),
                "Cannot find button 'back' from search menu",
                5
        );
    }

    public void waitForTitleDescription()
    {
        this.assertElementPresent(
                By.id(TITLE_DESCRIPTION),
                "we have not found title description after openning article"

        );

    }
}