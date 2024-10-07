package pageObjects;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.BasePageUI;

public class BasePageObject extends BasePage {
    private WebDriver driver;

    public BasePageObject(WebDriver driver) {
        this.driver = driver;
    }

    public PIMPageObject openPIMPage() {
        waitForElementClickable(driver, BasePageUI.PIM_MENU);
        clickOnElement(driver, BasePageUI.PIM_MENU);
        return PageGenerator.getPIMPage(driver);
    }

}
