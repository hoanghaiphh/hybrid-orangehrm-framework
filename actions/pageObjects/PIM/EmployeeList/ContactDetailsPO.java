package pageObjects.PIM.EmployeeList;

import org.openqa.selenium.WebDriver;
import pageObjects.PimPO;

public class ContactDetailsPO extends PimPO {
    private WebDriver driver;

    public ContactDetailsPO(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

}
