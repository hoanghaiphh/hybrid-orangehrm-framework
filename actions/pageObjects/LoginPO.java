package pageObjects;

import org.openqa.selenium.WebDriver;
import pageUIs.LoginPUI;

public class LoginPO extends BasePageObject {
    private WebDriver driver;

    public LoginPO(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void inputAdminUsername(String adminUsername) {
        waitForElementVisible(driver, LoginPUI.USERNAME_TEXTBOX);
        clearElementText(driver, LoginPUI.USERNAME_TEXTBOX);
        sendKeysToElement(driver, LoginPUI.USERNAME_TEXTBOX, adminUsername);
    }

    public void inputAdminPassword(String adminPassword) {
        waitForElementVisible(driver, LoginPUI.PASSWORD_TEXTBOX);
        clearElementText(driver, LoginPUI.PASSWORD_TEXTBOX);
        sendKeysToElement(driver, LoginPUI.PASSWORD_TEXTBOX, adminPassword);
    }

    public DashboardPO loginToSystem() {
        waitForElementClickable(driver, LoginPUI.LOGIN_BUTTON);
        clickOnElement(driver, LoginPUI.LOGIN_BUTTON);
        return PageGenerator.getDashboardPage(driver);
    }
}
