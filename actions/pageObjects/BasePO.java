package pageObjects;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.BasePUI;

public class BasePO extends BasePage {
    private WebDriver driver;

    public BasePO(WebDriver driver) {
        this.driver = driver;
    }

    public void waitForLoading() {
        waitForAllElementsInvisible(driver, BasePUI.LOADING_SPINNER);
    }

    public PimPO clickOnSidePanelLink(String linkText) {
        waitForElementClickable(driver, BasePUI.DYNAMIC_SIDEPANEL_LINK, linkText);
        clickOnElement(driver, BasePUI.DYNAMIC_SIDEPANEL_LINK, linkText);
        waitForLoading();
        return PageGenerator.getPIMPage(driver);
    }

    public String getToastMessage() {
        waitForElementVisible(driver, BasePUI.TOAST_MESSAGE);
        return getElementText(driver, BasePUI.TOAST_MESSAGE);
    }

}
