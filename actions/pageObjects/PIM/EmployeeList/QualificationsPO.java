package pageObjects.PIM.EmployeeList;

import org.openqa.selenium.WebDriver;
import pageObjects.PimPO;

public class QualificationsPO extends PimPO {
    private WebDriver driver;

    public QualificationsPO(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

}
