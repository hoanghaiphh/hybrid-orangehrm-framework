package pageObjects.PIM.EmployeeList;

import org.openqa.selenium.WebDriver;
import pageObjects.PimPO;
import pageUIs.PIM.EmployeeList.EmployeeListPUI;

public class EmployeeListPO extends PimPO {
    private WebDriver driver;

    public EmployeeListPO(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void clickOnEmployeeDeleteButton(String employeeId) {
        waitForElementClickable(driver, EmployeeListPUI.DYNAMIC_EMPLOYEE_DELETE_BUTTON, employeeId);
        clickOnElement(driver, EmployeeListPUI.DYNAMIC_EMPLOYEE_DELETE_BUTTON, employeeId);
    }

    public void clickOnDialogPopupDeleteButton() {
        waitForElementClickable(driver, EmployeeListPUI.DIALOG_POPUP_DELETE_BUTTON);
        clickOnElement(driver, EmployeeListPUI.DIALOG_POPUP_DELETE_BUTTON);
    }

    public void sendKeysToEmployeeIdTextbox(String employeeId) {
        waitForElementVisible(driver, EmployeeListPUI.EMPLOYEE_ID_TEXTBOX);
        clearElementText(driver, EmployeeListPUI.EMPLOYEE_ID_TEXTBOX);
        sendKeysToElement(driver, EmployeeListPUI.EMPLOYEE_ID_TEXTBOX, employeeId);
    }

    public void clickOnEmployeeSearchButton() {
        waitForElementClickable(driver, EmployeeListPUI.EMPLOYEE_SEARCH_BUTTON);
        clickOnElement(driver, EmployeeListPUI.EMPLOYEE_SEARCH_BUTTON);
        waitForLoading();
    }

    public String getEmployeeSearchResult() {
        waitForElementVisible(driver, EmployeeListPUI.EMPLOYEE_SEARCH_RESULT);
        return getElementText(driver, EmployeeListPUI.EMPLOYEE_SEARCH_RESULT);
    }
}
