package pageObjects.PIM.EmployeeList;

import org.openqa.selenium.WebDriver;
import pageObjects.PimPO;

public class MembershipsPO extends PimPO {
    private WebDriver driver;

    public MembershipsPO(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

}
