package pageObjects.PIM;

import org.openqa.selenium.WebDriver;
import pageObjects.PimPO;
import pageUIs.PIM.AddEmployeePUI;

public class AddEmployeePO extends PimPO {
    private WebDriver driver;

    public AddEmployeePO(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void sendKeysToFirstNameTextbox(String firstName) {
        waitForElementVisible(driver, AddEmployeePUI.FIRST_NAME_TEXTBOX);
        clearElementText(driver, AddEmployeePUI.FIRST_NAME_TEXTBOX);
        sendKeysToElement(driver, AddEmployeePUI.FIRST_NAME_TEXTBOX, firstName);
    }

    public void sendKeysToMiddleNameTextbox(String middleName) {
        waitForElementVisible(driver, AddEmployeePUI.MIDDLE_NAME_TEXTBOX);
        clearElementText(driver, AddEmployeePUI.MIDDLE_NAME_TEXTBOX);
        sendKeysToElement(driver, AddEmployeePUI.MIDDLE_NAME_TEXTBOX, middleName);
    }

    public void sendKeysToLastNameTextbox(String lastName) {
        waitForElementVisible(driver, AddEmployeePUI.LAST_NAME_TEXTBOX);
        clearElementText(driver, AddEmployeePUI.LAST_NAME_TEXTBOX);
        sendKeysToElement(driver, AddEmployeePUI.LAST_NAME_TEXTBOX, lastName);
    }

    public void uploadProfilePicture(String profilePicturePath) {
        sendKeysToElement(driver, AddEmployeePUI.PROFILE_PICTURE_UPLOAD, profilePicturePath);
    }

    public String getValueOfEmployeeIdTextbox() {
        waitForElementVisible(driver, AddEmployeePUI.EMPLOYEE_ID_TEXTBOX);
        return getAttributeValue(driver, AddEmployeePUI.EMPLOYEE_ID_TEXTBOX, "value");
    }

    public void switchOnCreateLoginDetails() {
        if (!isElementSelected(driver, AddEmployeePUI.CREATE_LOGIN_DETAIL_CHECKBOX)) {
            waitForElementClickable(driver, AddEmployeePUI.CREATE_LOGIN_DETAIL_LABEL);
            clickOnElement(driver, AddEmployeePUI.CREATE_LOGIN_DETAIL_LABEL);
        }
    }

    public void sendKeysToEmployeeUsernameTextbox(String userName) {
        waitForElementVisible(driver, AddEmployeePUI.EMPLOYEE_USERNAME_TEXTBOX);
        clearElementText(driver, AddEmployeePUI.EMPLOYEE_USERNAME_TEXTBOX);
        sendKeysToElement(driver, AddEmployeePUI.EMPLOYEE_USERNAME_TEXTBOX, userName);
    }

    public void sendKeysToEmployeePasswordTextbox(String password) {
        waitForElementVisible(driver, AddEmployeePUI.EMPLOYEE_PASSWORD_TEXTBOX);
        clearElementText(driver, AddEmployeePUI.EMPLOYEE_PASSWORD_TEXTBOX);
        sendKeysToElement(driver, AddEmployeePUI.EMPLOYEE_PASSWORD_TEXTBOX, password);
    }

    public void sendKeysToEmployeeConfirmPasswordTextbox(String password) {
        waitForElementVisible(driver, AddEmployeePUI.EMPLOYEE_CONFIRM_PASSWORD_TEXTBOX);
        clearElementText(driver, AddEmployeePUI.EMPLOYEE_CONFIRM_PASSWORD_TEXTBOX);
        sendKeysToElement(driver, AddEmployeePUI.EMPLOYEE_CONFIRM_PASSWORD_TEXTBOX, password);
    }

    public void selectStatusEnabledRadioButton() {
        waitForElementClickable(driver, AddEmployeePUI.ENABLED_RADIO);
        clickOnElement(driver, AddEmployeePUI.ENABLED_RADIO);
    }

    public void clickOnAddEmployeeSaveButton() {
        waitForElementClickable(driver, AddEmployeePUI.ADD_EMPLOYEE_SAVE_BUTTON);
        clickOnElement(driver, AddEmployeePUI.ADD_EMPLOYEE_SAVE_BUTTON);
    }
}
