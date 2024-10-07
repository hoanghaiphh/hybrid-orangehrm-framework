package pageObjects.PIM.EmployeeList;

import org.openqa.selenium.WebDriver;
import pageObjects.PIMPageObject;

public class SalaryPO extends PIMPageObject {
    private WebDriver driver;

    public SalaryPO(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

}
