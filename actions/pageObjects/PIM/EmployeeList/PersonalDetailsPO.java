package pageObjects.PIM.EmployeeList;

import org.openqa.selenium.WebDriver;
import pageObjects.PimPO;

public class PersonalDetailsPO extends PimPO {
    private WebDriver driver;

    public PersonalDetailsPO(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

}
