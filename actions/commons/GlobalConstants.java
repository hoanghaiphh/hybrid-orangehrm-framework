package commons;

import java.io.File;

public class GlobalConstants {
    // System Information
    public static final String PROJECT_PATH = System.getProperty("user.dir");
    public static final String OS_NAME = System.getProperty("os.name");
    public static final String SEPARATOR = System.getProperty("file.separator");
    public static final String JAVA_VERSION = System.getProperty("java.version");

    // App Information
    public static final String URL = "http://localhost:90/orangehrm-5.7/web/index.php/auth/login";
    public static final String ADMIN_USERNAME = "haiph";
    public static final String ADMIN_PASSWORD = "blUEstAr.1510";

    // Waiting time
    public static final long SHORT_TIMEOUT = 3;
    public static final long LONG_TIMEOUT = 30;

    // Directory
    public static final String UPLOAD_FOLDER_PATH = PROJECT_PATH + SEPARATOR + "uploadFiles" + SEPARATOR;
    public static final String EXTENT_REPORTS_FOLDER_PATH = PROJECT_PATH + SEPARATOR + "extentReports" + SEPARATOR;
}
