package pageObjects.PIM.EmployeeList;

import org.openqa.selenium.WebDriver;
import pageObjects.PimPO;

public class SalaryPO extends PimPO {
    private WebDriver driver;

    public SalaryPO(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

}
