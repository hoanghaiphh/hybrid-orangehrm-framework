package pageObjects;

import org.openqa.selenium.WebDriver;
import pageObjects.PIM.AddEmployeePO;
import pageObjects.PIM.EmployeeList.*;

public class PageGenerator {

    public static LoginPO getLoginPage(WebDriver driver) {
        return new LoginPO(driver);
    }

    public static DashboardPO getDashboardPage(WebDriver driver) {
        return new DashboardPO(driver);
    }

    public static PimPO getPIMPage(WebDriver driver) {
        return new PimPO(driver);
    }

    public static AddEmployeePO getAddEmployeePage(WebDriver driver) {
        return new AddEmployeePO(driver);
    }

    public static EmployeeListPO getEmployeeListPage(WebDriver driver) {
        return new EmployeeListPO(driver);
    }

    public static ContactDetailsPO getContactDetailsPage(WebDriver driver) {
        return new ContactDetailsPO(driver);
    }

    public static DependentsPO getDependentsPage(WebDriver driver) {
        return new DependentsPO(driver);
    }

    public static EmergencyContactsPO getEmergencyContactsPage(WebDriver driver) {
        return new EmergencyContactsPO(driver);
    }

    public static ImmigrationPO getImmigrationPage(WebDriver driver) {
        return new ImmigrationPO(driver);
    }

    public static JobPO getJobPage(WebDriver driver) {
        return new JobPO(driver);
    }

    public static MembershipsPO getMembershipsPage(WebDriver driver) {
        return new MembershipsPO(driver);
    }

    public static PersonalDetailsPO getPersonalDetailsPage(WebDriver driver) {
        return new PersonalDetailsPO(driver);
    }

    public static QualificationsPO getQualificationsPage(WebDriver driver) {
        return new QualificationsPO(driver);
    }

    public static ReportToPO getReportToPage(WebDriver driver) {
        return new ReportToPO(driver);
    }

    public static SalaryPO getSalaryPage(WebDriver driver) {
        return new SalaryPO(driver);
    }

    public static ProfilePicturePO getProfilePicturePage(WebDriver driver) {
        return new ProfilePicturePO(driver);
    }

}
