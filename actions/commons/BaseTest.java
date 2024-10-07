package commons;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.BeforeSuite;

import java.io.File;
import java.time.Duration;

public class BaseTest {
    protected WebDriver driver;
    protected final Logger log;

    protected BaseTest() {
        log = LogManager.getLogger(getClass());
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

    @BeforeSuite
    protected void clearReport() {
        deleteAllFilesInFolder(GlobalConstants.LOGS_FOLDER_PATH);
    }

    private void deleteAllFilesInFolder(String folder) {
        try {
            File[] listOfFiles = new File(folder).listFiles();
            for (File file : listOfFiles) {
                if (file.isFile() && !file.getName().equals("Fixed.log")) {
                    file.delete();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
