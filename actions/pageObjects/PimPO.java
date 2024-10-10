package pageObjects;

import org.openqa.selenium.WebDriver;
import pageUIs.PimPUI;

public class PimPO extends BasePO {
    private WebDriver driver;

    public PimPO(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void clickOnTopBarLink(String linkText) {
        waitForElementClickable(driver, PimPUI.DYNAMIC_TOPBAR_NAV_LINK, linkText);
        clickOnElement(driver, PimPUI.DYNAMIC_TOPBAR_NAV_LINK, linkText);
        waitForLoading();
    }

    public void clickOnTabsLink(String linkText) {
        waitForElementClickable(driver, PimPUI.DYNAMIC_TABS_LINK, linkText);
        clickOnElement(driver, PimPUI.DYNAMIC_TABS_LINK, linkText);
        waitForLoading();
    }

    public void clickOnProfilePictureImage() {
        waitForElementClickable(driver, PimPUI.PROFILE_PICTURE_IMAGE);
        clickOnElement(driver, PimPUI.PROFILE_PICTURE_IMAGE);
        waitForLoading();
    }
}
