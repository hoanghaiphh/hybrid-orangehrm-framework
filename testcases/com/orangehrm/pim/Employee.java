package com.orangehrm.pim;

import commons.BaseTest;
import commons.GlobalConstants;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.DashboardPO;
import pageObjects.LoginPO;
import pageObjects.PIM.AddEmployeePO;
import pageObjects.PIM.EmployeeList.*;
import pageObjects.PimPO;
import pageObjects.PageGenerator;

public class Employee extends BaseTest {

    private LoginPO loginPage;
    private DashboardPO dashboardPage;
    private PimPO pimPage;
    private EmployeeListPO employeeListPage;
    private AddEmployeePO addEmployeePage;
    private PersonalDetailsPO personalDetailsPage;
    private ContactDetailsPO contactDetailsPage;
    private EmergencyContactsPO emergencyContactsPage;
    private DependentsPO dependentsPage;
    private ImmigrationPO immigrationPage;
    private JobPO jobPage;
    private SalaryPO salaryPage;
    private ReportToPO reportToPage;
    private QualificationsPO qualificationsPage;
    private MembershipsPO membershipsPage;

    private String firstName, middleName, lastName, profilePicture, employeeId, usernamePrefix, password;

    @Parameters("browser")
    @BeforeClass
    public void beforeClass(String browserName) {
        driver = openBrowserWithUrl(browserName, GlobalConstants.URL);
        loginPage = PageGenerator.getLoginPage(driver);

        loginPage.inputAdminUsername(GlobalConstants.ADMIN_USERNAME);
        loginPage.inputAdminPassword(GlobalConstants.ADMIN_PASSWORD);
        dashboardPage = loginPage.loginToSystem();

        firstName = "Anh";
        middleName = "Ngoc";
        lastName = "Nguyen";
        profilePicture = GlobalConstants.UPLOAD_FOLDER_PATH + "profilePicture.jpg";
        usernamePrefix = (firstName + middleName.charAt(0) + lastName.charAt(0)).toLowerCase() + ".";
        password = "Abcd@1234!";
    }

    @Test
    public void Employee_01_Add_Employee() {
        log.info("Employee_01_Add_Employee - Step 01: Open PIM Page");
        pimPage = dashboardPage.openPIMPage();

        log.info("Employee_01_Add_Employee - Step 02: Open Add Employee Page");
        pimPage.openPageByLinkText("Add Employee");
        addEmployeePage = PageGenerator.getAddEmployeePage(driver);

        log.info("Employee_01_Add_Employee - Step 03: Input value to First Name Textbox: " + firstName);
        addEmployeePage.inputEmployeeFirstName(firstName);

        log.info("Employee_01_Add_Employee - Step 04: Input value to Middle Name Textbox: " + middleName);
        addEmployeePage.inputEmployeeMiddleName(middleName);

        log.info("Employee_01_Add_Employee - Step 05: Input value to Last Name Textbox: " + lastName);
        addEmployeePage.inputEmployeeLastName(lastName);

        log.info("Employee_01_Add_Employee - Step 06: Upload Profile Picture");
        addEmployeePage.uploadEmployeeProfilePicture(profilePicture);

        log.info("Employee_01_Add_Employee - Step 07: Get Employee ID");
        employeeId = addEmployeePage.getEmployeeId();

        log.info("Employee_01_Add_Employee - Step 08: Turn on Create Login Details Switch");
        addEmployeePage.turnOnCreateLoginDetails();

        log.info("Employee_01_Add_Employee - Step 09: Select Enabled Status Radio Button");
        addEmployeePage.selectEnabledStatus();

        log.info("Employee_01_Add_Employee - Step 10: Input value to Username Textbox: " + usernamePrefix + employeeId);
        addEmployeePage.inputEmployeeUsername(usernamePrefix + employeeId);

        log.info("Employee_01_Add_Employee - Step 11: Input value to Password Textbox: " + password);
        addEmployeePage.inputEmployeePassword(password);

        log.info("Employee_01_Add_Employee - Step 12: Input value to Confirm Password Textbox: " + password);
        addEmployeePage.confirmEmployeePassword(password);

        log.info("Employee_01_Add_Employee - Step 13: Save Employee Information");
        personalDetailsPage = addEmployeePage.saveInformation();
    }

    @Test
    public void Employee_02_Personal_Details() {

    }

    @Test
    public void Employee_03_Contact_Details() {
        personalDetailsPage.openPageByLinkText("Contact Details");
        contactDetailsPage = PageGenerator.getContactDetailsPage(driver);

    }

    @Test
    public void Employee_04_Emergency_Contacts() {
        contactDetailsPage.openPageByLinkText("Emergency Contacts");
        emergencyContactsPage = PageGenerator.getEmergencyContactsPage(driver);

    }

    @Test
    public void Employee_05_Dependents() {
        emergencyContactsPage.openPageByLinkText("Dependents");
        dependentsPage = PageGenerator.getDependentsPage(driver);

    }

    @Test
    public void Employee_06_Immigration() {
        dependentsPage.openPageByLinkText("Immigration");
        immigrationPage = PageGenerator.getImmigrationPage(driver);

    }

    @Test
    public void Employee_07_Job() {
        immigrationPage.openPageByLinkText("Job");
        jobPage = PageGenerator.getJobPage(driver);

    }

    @Test
    public void Employee_08_Salary() {
        jobPage.openPageByLinkText("Salary");
        salaryPage = PageGenerator.getSalaryPage(driver);

    }

    @Test
    public void Employee_09_Report_To() {
        salaryPage.openPageByLinkText("Report-to");
        reportToPage = PageGenerator.getReportToPage(driver);

    }

    @Test
    public void Employee_10_Qualifications() {
        reportToPage.openPageByLinkText("Qualifications");
        qualificationsPage = PageGenerator.getQualificationsPage(driver);

    }

    @Test
    public void Employee_11_Memberships() {
        qualificationsPage.openPageByLinkText("Memberships");
        membershipsPage = PageGenerator.getMembershipsPage(driver);

    }

    @Test
    public void Employee_12_Delete_Employee() {
        log.info("Employee_12_Delete_Employee - Step 01: Open Employee List Page");
        membershipsPage.openPageByLinkText("Employee List");
        employeeListPage = PageGenerator.getEmployeeListPage(driver);

        log.info("Employee_12_Delete_Employee - Step 02: Delete Employee by ID: " + employeeId);
        employeeListPage.deleteEmployeeById(employeeId);

        log.info("Employee_12_Delete_Employee - Step 03: Confirm Delete");
        employeeListPage.confirmDeleteEmployee();
    }

    @AfterClass(alwaysRun = true)
    public void afterClass() {
        closeBrowserDriver();
    }
}
