package pageObjects;

import org.openqa.selenium.WebDriver;

public class DashboardPO extends BasePageObject {
    private WebDriver driver;

    public DashboardPO(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

}
