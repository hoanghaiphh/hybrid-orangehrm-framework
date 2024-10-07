package pageObjects.PIM.EmployeeList;

import org.openqa.selenium.WebDriver;
import pageObjects.PIMPageObject;
import pageUIs.BasePageUI;
import pageUIs.PIM.EmployeeList.EmployeeListPUI;

public class EmployeeListPO extends PIMPageObject {
    private WebDriver driver;

    public EmployeeListPO(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void deleteEmployee(String employeeId) {
        waitForElementClickable(driver, EmployeeListPUI.DYNAMIC_DELETE_BUTTON, employeeId);
        clickOnElement(driver, EmployeeListPUI.DYNAMIC_DELETE_BUTTON, employeeId);
    }

    public void confirmDeleteEmployee() {
        waitForElementClickable(driver, EmployeeListPUI.CONFIRM_DELETE_BUTTON);
        clickOnElement(driver, EmployeeListPUI.CONFIRM_DELETE_BUTTON);
        waitForElementInvisible(driver, BasePageUI.AJAX_LOADING);
    }
}
