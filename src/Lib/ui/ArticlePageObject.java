package Lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;

public class ArticlePageObject extends MainPageObject {
    private static final String
            TITLE = "xpath://*[@text='{SUBSTRING}']",
            TITLE_DESCRIPTION = "id:pcs-edit-section-title-description",
            FOOTER_ELEMENT = "xpath://*[@text='View article in browser']",
            BOOKMARK_BUTTON = "xpath://android.widget.ImageView[@content-desc='More options']",
            ADD_TO_MY_LIST_BUTTON = "xpath://*[@text='Add to reading list']",
            CREATE_NEW_LIST_BUTTON = "id:org.wikipedia:id/onboarding_button",
            MY_LIST_NAME_INPUT = "id:org.wikipedia:id/text_input",
            MY_LIST_OK_BUTTON = "xpath://*[@text='OK']",
            MY_LIST_NAME_FOLDER_TPL = "//*[@text='{NAMEFOLDER}']",
            CLOSE_ARTICLE_BUTTON = "xpath://android.widget.ImageButton[@content-desc='Navigate up']",
            BACK_BUTTON_FROM_SEARCH = "xpath://android.widget.FrameLayout[@content-desc='My lists']";

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
        return this.waitForElementPresent((title_xpath), "Cannot find article title on page!", 15);
    }

    public String getArticleTitle(String substring) {
        WebElement title_element = waitForTitleElementWithSubstring(substring);
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
                BOOKMARK_BUTTON,
                "Cannot find menu bookmark",
                5
        );


        this.waitForElementAndClick(
                ADD_TO_MY_LIST_BUTTON,
                "Cannot find menu button 'add to..'",
                5
        );

        this.waitForElementAndClick(
                CREATE_NEW_LIST_BUTTON,
                "Cannot find button for create list",
                5
        );

        this.waitForElementAndClear(
                MY_LIST_NAME_INPUT,
                "Cannot find and clear field to create a new list",
                5
        );

        this.waitForElementAndSendKeys(
                MY_LIST_NAME_INPUT,
                name_of_folder,
                "Cannot find and send keys for field to create a new list",
                5
        );

        this.waitForElementAndClick(
                MY_LIST_OK_BUTTON,
                "Cannot find button 'OK'",
                5
        );
    }

    public void addArticleToSavedList(String name_of_folder)
    {
        String list_folder_xpath = getMylistFolderElement(name_of_folder);
        this.waitForElementAndClick(
                BOOKMARK_BUTTON,
                "Cannot find menu bookmark",
                5
        );


        this.waitForElementAndClick(
                ADD_TO_MY_LIST_BUTTON,
                "Cannot find menu button 'add to..'",
                5
        );

        this.waitForElementAndClick(
                list_folder_xpath,
                "Cannot find created list for article '"+name_of_folder+"'",
                5
        );

    }

    public void closeArticle()
    {
        this.waitForElementAndClick(
                CLOSE_ARTICLE_BUTTON,
                "Cannot find button 'back'",
                5
        );
    }

    public void backFromSearchMenu()
    {
        this.waitForElementAndClick(
                BACK_BUTTON_FROM_SEARCH,
                "Cannot find button 'back' from search menu",
                5
        );
    }

    public void waitForTitleDescription()
    {
        this.assertElementPresent(
                TITLE_DESCRIPTION,
                "we have not found title description after opening article"

        );

    }
}