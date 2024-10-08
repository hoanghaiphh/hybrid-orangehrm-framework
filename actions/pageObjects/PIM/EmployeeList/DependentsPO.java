package pageObjects.PIM.EmployeeList;

import org.openqa.selenium.WebDriver;
import pageObjects.PimPO;

public class DependentsPO extends PimPO {
    private WebDriver driver;

    public DependentsPO(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

}
