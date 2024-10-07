package pageObjects.PIM.EmployeeList;

import org.openqa.selenium.WebDriver;
import pageObjects.PIMPageObject;

public class ImmigrationPO extends PIMPageObject {
    private WebDriver driver;

    public ImmigrationPO(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

}
