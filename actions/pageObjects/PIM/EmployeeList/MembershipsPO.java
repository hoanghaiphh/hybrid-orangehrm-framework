package pageObjects.PIM.EmployeeList;

import org.openqa.selenium.WebDriver;
import pageObjects.PIMPageObject;

public class MembershipsPO extends PIMPageObject {
    private WebDriver driver;

    public MembershipsPO(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

}
