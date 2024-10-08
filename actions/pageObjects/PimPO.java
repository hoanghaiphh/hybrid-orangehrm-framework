package pageObjects;

import org.openqa.selenium.WebDriver;
import pageUIs.BasePUI;
import pageUIs.PimPUI;

public class PimPO extends BasePO {
    private WebDriver driver;

    public PimPO(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void openPageByLinkText(String linkText) {
        waitForElementClickable(driver, PimPUI.DYNAMIC_LINK, linkText);
        clickOnElement(driver, PimPUI.DYNAMIC_LINK, linkText);
        waitForElementInvisible(driver, BasePUI.AJAX_LOADING);
    }

}
