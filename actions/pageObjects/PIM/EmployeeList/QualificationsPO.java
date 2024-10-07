package pageObjects.PIM.EmployeeList;

import org.openqa.selenium.WebDriver;
import pageObjects.PIMPageObject;

public class QualificationsPO extends PIMPageObject {
    private WebDriver driver;

    public QualificationsPO(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

}
