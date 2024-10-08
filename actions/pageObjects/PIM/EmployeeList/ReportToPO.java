package pageObjects.PIM.EmployeeList;

import org.openqa.selenium.WebDriver;
import pageObjects.PimPO;

public class ReportToPO extends PimPO {
    private WebDriver driver;

    public ReportToPO(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

}
