package pageObjects.PIM.EmployeeList;

import org.openqa.selenium.WebDriver;
import pageObjects.PimPO;
import pageUIs.BasePUI;
import pageUIs.PIM.EmployeeList.EmployeeListPUI;

public class EmployeeListPO extends PimPO {
    private WebDriver driver;

    public EmployeeListPO(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void deleteEmployeeById(String employeeId) {
        waitForElementClickable(driver, EmployeeListPUI.DYNAMIC_DELETE_BUTTON, employeeId);
        clickOnElement(driver, EmployeeListPUI.DYNAMIC_DELETE_BUTTON, employeeId);
    }

    public void confirmDeleteEmployee() {
        waitForElementClickable(driver, EmployeeListPUI.CONFIRM_DELETE_BUTTON);
        clickOnElement(driver, EmployeeListPUI.CONFIRM_DELETE_BUTTON);
        waitForElementInvisible(driver, BasePUI.AJAX_LOADING);
    }

}
