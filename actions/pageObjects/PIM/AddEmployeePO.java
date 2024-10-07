package pageObjects.PIM;

import org.openqa.selenium.WebDriver;
import pageObjects.PIM.EmployeeList.PersonalDetailsPO;
import pageObjects.PIMPageObject;
import pageObjects.PageGenerator;
import pageUIs.BasePageUI;
import pageUIs.PIM.AddEmployeePUI;

public class AddEmployeePO extends PIMPageObject {
    private WebDriver driver;

    public AddEmployeePO(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void inputEmployeeFirstName(String firstName) {
        waitForElementVisible(driver, AddEmployeePUI.FIRST_NAME_TEXTBOX);
        clearElementText(driver, AddEmployeePUI.FIRST_NAME_TEXTBOX);
        sendKeysToElement(driver, AddEmployeePUI.FIRST_NAME_TEXTBOX, firstName);
    }

    public void inputEmployeeMiddleName(String middleName) {
        waitForElementVisible(driver, AddEmployeePUI.MIDDLE_NAME_TEXTBOX);
        clearElementText(driver, AddEmployeePUI.MIDDLE_NAME_TEXTBOX);
        sendKeysToElement(driver, AddEmployeePUI.MIDDLE_NAME_TEXTBOX, middleName);
    }

    public void inputEmployeeLastName(String lastName) {
        waitForElementVisible(driver, AddEmployeePUI.LAST_NAME_TEXTBOX);
        clearElementText(driver, AddEmployeePUI.LAST_NAME_TEXTBOX);
        sendKeysToElement(driver, AddEmployeePUI.LAST_NAME_TEXTBOX, lastName);
    }

    public void uploadEmployeeProfilePicture(String profilePicturePath) {
        sendKeysToElement(driver, AddEmployeePUI.PROFILE_PICTURE_UPLOAD, profilePicturePath);
    }

    public String getEmployeeId() {
        waitForElementVisible(driver, AddEmployeePUI.EMPLOYEE_ID_TEXTBOX);
        return getAttributeValue(driver, AddEmployeePUI.EMPLOYEE_ID_TEXTBOX, "value");
    }

    public void turnOnCreateLoginDetails() {
        waitForElementClickable(driver, AddEmployeePUI.CREATE_LOGIN_DETAIL_LABEL);
        if (!isElementSelected(driver, AddEmployeePUI.CREATE_LOGIN_DETAIL_CHECKBOX)) {
            clickOnElement(driver, AddEmployeePUI.CREATE_LOGIN_DETAIL_LABEL);
        }
    }

    public void inputEmployeeUsername(String userName) {
        waitForElementVisible(driver, AddEmployeePUI.USERNAME_TEXTBOX);
        clearElementText(driver, AddEmployeePUI.USERNAME_TEXTBOX);
        sendKeysToElement(driver, AddEmployeePUI.USERNAME_TEXTBOX, userName);
    }

    public void inputEmployeePassword(String password) {
        waitForElementVisible(driver, AddEmployeePUI.PASSWORD_TEXTBOX);
        clearElementText(driver, AddEmployeePUI.PASSWORD_TEXTBOX);
        sendKeysToElement(driver, AddEmployeePUI.PASSWORD_TEXTBOX, password);
    }

    public void confirmEmployeePassword(String password) {
        waitForElementVisible(driver, AddEmployeePUI.CONFIRM_PASSWORD_TEXTBOX);
        clearElementText(driver, AddEmployeePUI.CONFIRM_PASSWORD_TEXTBOX);
        sendKeysToElement(driver, AddEmployeePUI.CONFIRM_PASSWORD_TEXTBOX, password);
    }

    public void selectEnabledStatus() {
        waitForElementClickable(driver, AddEmployeePUI.ENABLED_LABEL);
        if (!isElementSelected(driver, AddEmployeePUI.ENABLED_RADIO)) {
            clickOnElement(driver, AddEmployeePUI.ENABLED_LABEL);
        }
    }

    public PersonalDetailsPO saveInformation() {
        waitForElementClickable(driver, AddEmployeePUI.SAVE_BUTTON);
        clickOnElement(driver, AddEmployeePUI.SAVE_BUTTON);
        waitForElementInvisible(driver, BasePageUI.AJAX_LOADING);
        return PageGenerator.getPersonalDetailsPage(driver);
    }
}
