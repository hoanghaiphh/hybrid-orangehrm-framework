package pageObjects.PIM.EmployeeList;

import org.openqa.selenium.WebDriver;
import pageObjects.PIMPageObject;

public class DependentsPO extends PIMPageObject {
    private WebDriver driver;

    public DependentsPO(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

}
