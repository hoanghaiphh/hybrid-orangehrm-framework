package pageObjects;

import org.openqa.selenium.WebDriver;
import pageUIs.BasePageUI;
import pageUIs.PIMPageUI;

public class PIMPageObject extends BasePageObject {
    private WebDriver driver;

    public PIMPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void clickOnLink(String linkText) {
        waitForElementClickable(driver, PIMPageUI.DYNAMIC_LINK, linkText);
        clickOnElement(driver, PIMPageUI.DYNAMIC_LINK, linkText);
        waitForElementInvisible(driver, BasePageUI.AJAX_LOADING);
    }
}
