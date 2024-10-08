package pageObjects.PIM.EmployeeList;

import org.openqa.selenium.WebDriver;
import pageObjects.PimPO;

public class ImmigrationPO extends PimPO {
    private WebDriver driver;

    public ImmigrationPO(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

}
