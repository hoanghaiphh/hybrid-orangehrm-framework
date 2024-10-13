package commons;

import com.aventstack.extentreports.Status;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.BeforeMethod;
import reportConfig.ExtentManager;

import java.lang.reflect.Method;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

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

    protected String getRandomDriverLicense() {
        Random r = new Random();
        return (1000 + r.nextInt(9000)) + "-" + (1000 + r.nextInt(9000)) + "-" + (1000 + r.nextInt(9000));
    }

    protected String getRandomGender() {
        int randNumber = new Random().nextInt(2);
        if (randNumber == 0) {
            return "Male";
        } else {
            return "Female";
        }
    }

    protected String getRandomMaritalStatus() {
        int randNumber = new Random().nextInt(3);
        if (randNumber == 0) {
            return "Single";
        } else if (randNumber == 1) {
            return "Married";
        } else {
            return "Other";
        }
    }

    protected String getRandomNationality() {
        int randNumber = new Random().nextInt(3);
        if (randNumber == 0) {
            return "British";
        } else if (randNumber == 1) {
            return "Australian";
        } else {
            return "American";
        }
    }

    protected String getRandomDateWithinYearRange(int startYear, int endYear) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate startDate = LocalDate.of(startYear, 1, 1);
        LocalDate endDate = LocalDate.of(endYear, 12, 31);

        long startEpochDay = startDate.toEpochDay();
        long endEpochDay = endDate.toEpochDay();
        long randomDay = ThreadLocalRandom.current().nextLong(startEpochDay, endEpochDay);

        LocalDate randomDate = LocalDate.ofEpochDay(randomDay);

        return randomDate.format(formatter);
    }

}
