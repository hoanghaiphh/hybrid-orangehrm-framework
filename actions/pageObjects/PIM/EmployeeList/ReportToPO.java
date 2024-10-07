package pageObjects.PIM.EmployeeList;

import org.openqa.selenium.WebDriver;
import pageObjects.PIMPageObject;

public class ReportToPO extends PIMPageObject {
    private WebDriver driver;

    public ReportToPO(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

}
