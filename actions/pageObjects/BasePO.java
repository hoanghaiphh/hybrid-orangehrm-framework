package pageObjects;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.BasePUI;

public class BasePO extends BasePage {
    private WebDriver driver;

    public BasePO(WebDriver driver) {
        this.driver = driver;
    }

    public PimPO openPIMPage() {
        waitForElementClickable(driver, BasePUI.PIM_MENU);
        clickOnElement(driver, BasePUI.PIM_MENU);
        waitForElementInvisible(driver, BasePUI.AJAX_LOADING);
        return PageGenerator.getPIMPage(driver);
    }

}
