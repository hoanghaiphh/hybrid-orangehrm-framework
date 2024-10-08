package pageObjects.PIM.EmployeeList;

import org.openqa.selenium.WebDriver;
import pageObjects.PimPO;

public class EmergencyContactsPO extends PimPO {
    private WebDriver driver;

    public EmergencyContactsPO(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

}
