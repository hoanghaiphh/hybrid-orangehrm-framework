package commons;

import com.aventstack.extentreports.Status;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import reportConfig.ExtentManager;

import java.io.File;
import java.lang.reflect.Method;
import java.time.Duration;

public class BaseTest {
    protected WebDriver driver;

    public WebDriver getDriver() {
        return driver;
    }

    protected WebDriver openBrowserWithUrl(String browserName, String url) {
        BrowserList browserList = BrowserList.valueOf(browserName.toUpperCase());
        switch (browserList) {
            case FIREFOX:
                driver = new FirefoxDriver();
                break;
            case CHROME:
                driver = new ChromeDriver();
                break;
            case EDGE:
                driver = new EdgeDriver();
                break;
            case SAFARI:
                driver = new SafariDriver();
                break;
            default:
                throw new RuntimeException("Browser is not valid");
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT));
        driver.get(url);
        return driver;
    }

    protected void closeBrowserDriver() {
        if (driver != null) {
            String driverInstanceName = driver.toString();
            String browserDriverName = null;
            if (driverInstanceName.contains("Chrome")) {
                browserDriverName = "chromedriver";
            } else if (driverInstanceName.contains("Firefox")) {
                browserDriverName = "geckodriver";
            } else if (driverInstanceName.contains("Edge")) {
                browserDriverName = "msedgedriver";
            } else if (driverInstanceName.contains("Safari")) {
                browserDriverName = "safaridriver";
            }

            driver.manage().deleteAllCookies();
            driver.quit();

            try {
                String cmd = null;
                if (GlobalConstants.OS_NAME.contains("Window")) {
                    cmd = "taskkill /F /FI \"IMAGENAME eq " + browserDriverName + "*\"";
                } else {
                    cmd = "pkill " + browserDriverName;
                }
                Process process = Runtime.getRuntime().exec(cmd);
                process.waitFor();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @BeforeMethod
    protected void extentStartTest(Method method) {
        ExtentManager.startTest(method.getName() + " - Run on " + BasePage.getCurrentBrowserName(driver), method.getName());
    }

    protected void extentLog(String msg) {
        ExtentManager.getTest().log(Status.INFO, msg);
    }

}
