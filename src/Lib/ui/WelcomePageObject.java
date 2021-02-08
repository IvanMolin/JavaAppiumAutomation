package Lib.ui;


import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class WelcomePageObject extends MainPageObject
{
    private static final String
    STEP_LEARN_MORE_LINK = "xpath://*[@name='Learn more about Wikipedia']",
    STEP_NEW_WAYS_TO_EXPLORE_TEXT = "xpath://*[@name='New ways to explore']",
    NEXT_LINK = "xpath://XCUIElementTypeButton[@name='Next']",
    STEP_ADD_OR_EDIT_PREFERRED_LANG_LINK = "xpath://*[@name='Search in nearly 300 languages']",
    STEP_LEARN_MORE_ABOUT_DATA_COLLECTED_LINK = "xpath://*[@name='Learn more about data collected']",
    GET_STARTED_BUTTON = "xpath://*[@name='Get started']";


    public WelcomePageObject(AppiumDriver driver)
    {
        super(driver);
    }

    public void waitForLearnMoreLink()
    {
        this.waitForElementPresent(STEP_LEARN_MORE_LINK, "Cannot find 'Learn more about Wikipedia'", 10);

    }

    public void waitForNewWayToExploreText()
    {
        this.waitForElementPresent(STEP_NEW_WAYS_TO_EXPLORE_TEXT, "Cannot find 'New ways to explore'", 10);

    }

    public void waitForAddOrEditPreferredLangText()
    {
        this.waitForElementPresent(STEP_ADD_OR_EDIT_PREFERRED_LANG_LINK, "Cannot find 'Search in nearly 300 languages'", 10);

    }
    public void waitForLearnMoreAboutDataCollectedText()
    {
        this.waitForElementPresent(STEP_LEARN_MORE_ABOUT_DATA_COLLECTED_LINK, "Cannot find 'Learn more about data collected'", 10);

    }

    public void clickNextButton()
    {
        this.waitForElementAndClick(NEXT_LINK, "Cannot find 'Next' link", 10);

    }

    public void clickGetStartedButton()
    {
        this.waitForElementAndClick(GET_STARTED_BUTTON, "Cannot find 'Get started' link", 10);

    }

}
