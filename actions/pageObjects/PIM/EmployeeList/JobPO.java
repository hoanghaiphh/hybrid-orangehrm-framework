package pageObjects.PIM.EmployeeList;

import org.openqa.selenium.WebDriver;
import pageObjects.PimPO;

public class JobPO extends PimPO {
    private WebDriver driver;

    public JobPO(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

}
