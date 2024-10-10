package com.orangehrm.pim;

import commons.BaseTest;
import commons.GlobalConstants;
import org.openqa.selenium.Dimension;
import org.testng.Assert;
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

public class PIM_01_Employee extends BaseTest {

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
    private ProfilePicturePO profilePicturePage;

    private String firstName, middleName, lastName, profilePicture1, profilePicture2, employeeId, usernamePrefix, password;

    @Parameters("browser")
    @BeforeClass
    public void beforeClass(String browserName) {
        driver = openBrowserWithUrl(browserName, GlobalConstants.URL);
        loginPage = PageGenerator.getLoginPage(driver);

        loginPage.sendKeysToUsernameTextbox(GlobalConstants.ADMIN_USERNAME);
        loginPage.sendKeysToPasswordTextbox(GlobalConstants.ADMIN_PASSWORD);
        dashboardPage = loginPage.clickOnLoginButton();

        firstName = "Anh";
        middleName = "Ngoc";
        lastName = "Nguyen";
        profilePicture1 = GlobalConstants.UPLOAD_FOLDER_PATH + "profilePicture1.jpg";
        profilePicture2 = GlobalConstants.UPLOAD_FOLDER_PATH + "profilePicture2.jpg";
        usernamePrefix = (firstName + middleName.charAt(0) + lastName.charAt(0)).toLowerCase() + ".";
        password = "Abcd@1234!";
    }

    @Test
    public void Employee_01_Add_Employee() {
        extentLog("Employee_01_Add_Employee - Step 01: Open PIM page");
        pimPage = dashboardPage.clickOnSidePanelLink("PIM");

        extentLog("Employee_01_Add_Employee - Step 02: Open Add Employee page");
        pimPage.clickOnTopBarLink("Add Employee");
        addEmployeePage = PageGenerator.getAddEmployeePage(driver);

        extentLog("Employee_01_Add_Employee - Step 03: Input value into First Name textbox: " + firstName);
        addEmployeePage.sendKeysToFirstNameTextbox(firstName);

        extentLog("Employee_01_Add_Employee - Step 04: Input value into Middle Name textbox: " + middleName);
        addEmployeePage.sendKeysToMiddleNameTextbox(middleName);

        extentLog("Employee_01_Add_Employee - Step 05: Input value into Last Name textbox: " + lastName);
        addEmployeePage.sendKeysToLastNameTextbox(lastName);

        extentLog("Employee_01_Add_Employee - Step 06: Upload employee profile picture");
        addEmployeePage.uploadProfilePicture(profilePicture1);

        extentLog("Employee_01_Add_Employee - Step 07: Get employee ID");
        employeeId = addEmployeePage.getValueOfEmployeeIdTextbox();

        extentLog("Employee_01_Add_Employee - Step 08: Switch on Create Login Details");
        addEmployeePage.switchOnCreateLoginDetails();

        extentLog("Employee_01_Add_Employee - Step 09: Select status Enabled radio button");
        addEmployeePage.selectStatusEnabledRadioButton();

        extentLog("Employee_01_Add_Employee - Step 10: Input value into Username textbox: " + usernamePrefix + employeeId);
        addEmployeePage.sendKeysToEmployeeUsernameTextbox(usernamePrefix + employeeId);

        extentLog("Employee_01_Add_Employee - Step 11: Input value into Password textbox: " + password);
        addEmployeePage.sendKeysToEmployeePasswordTextbox(password);

        extentLog("Employee_01_Add_Employee - Step 12: Input value into Confirm Password textbox: " + password);
        addEmployeePage.sendKeysToEmployeeConfirmPasswordTextbox(password);

        extentLog("Employee_01_Add_Employee - Step 13: Save employee information");
        addEmployeePage.clickOnAddEmployeeSaveButton();

        extentLog("Employee_01_Add_Employee - Step 14: Verify that success message is displayed");
        Assert.assertTrue(addEmployeePage.isToastMessageDisplayed("Successfully Saved"));

        addEmployeePage.waitForLoading();
        personalDetailsPage = PageGenerator.getPersonalDetailsPage(driver);
    }

    @Test
    public void Employee_02_Change_Profile_Picture() {
        extentLog("Employee_02_Change_Profile_Picture - Step 01: Open Change Profile Picture page");
        personalDetailsPage.clickOnProfilePictureImage();
        profilePicturePage = PageGenerator.getProfilePicturePage(driver);

        extentLog("Employee_02_Change_Profile_Picture - Step 02: Get natural dimension of current profile picture");
        Dimension oldDimension = profilePicturePage.getNaturalDimensionOfProfilePicture();
        extentLog("Employee_02_Change_Profile_Picture - Step 02: Dimension = " + oldDimension);

        extentLog("Employee_02_Change_Profile_Picture - Step 03: Upload new profile picture");
        profilePicturePage.uploadNewProfilePicture(profilePicture2);

        extentLog("Employee_02_Change_Profile_Picture - Step 04: Save new profile picture");
        profilePicturePage.clickOnChangeProfilePictureSaveButton();

        extentLog("Employee_02_Change_Profile_Picture - Step 05: Verify that success message is displayed");
        Assert.assertTrue(profilePicturePage.isToastMessageDisplayed("Successfully Updated"));

        profilePicturePage.waitForLoading();

        extentLog("Employee_02_Change_Profile_Picture - Step 06: Get natural dimension of current profile picture");
        Dimension newDimension = profilePicturePage.getNaturalDimensionOfProfilePicture();
        extentLog("Employee_02_Change_Profile_Picture - Step 06: Dimension = " + newDimension);

        extentLog("Employee_02_Change_Profile_Picture - Step 07: Verify that profile picture has been changed");
        Assert.assertNotEquals(oldDimension, newDimension);
    }

    /*@Test
    public void Employee_03_Personal_Details() {
        profilePicturePage.clickOnTabsLink("Personal Details");
        personalDetailsPage = PageGenerator.getPersonalDetailsPage(driver);

    }*/

    /*@Test
    public void Employee_04_Contact_Details() {
        personalDetailsPage.clickOnTabsLink("Contact Details");
        contactDetailsPage = PageGenerator.getContactDetailsPage(driver);

    }*/

    /*@Test
    public void Employee_05_Emergency_Contacts() {
        contactDetailsPage.clickOnTabsLink("Emergency Contacts");
        emergencyContactsPage = PageGenerator.getEmergencyContactsPage(driver);

    }*/

    /*@Test
    public void Employee_06_Dependents() {
        emergencyContactsPage.clickOnTabsLink("Dependents");
        dependentsPage = PageGenerator.getDependentsPage(driver);

    }*/

    /*@Test
    public void Employee_07_Immigration() {
        dependentsPage.clickOnTabsLink("Immigration");
        immigrationPage = PageGenerator.getImmigrationPage(driver);

    }*/

    /*@Test
    public void Employee_08_Job() {
        immigrationPage.clickOnTabsLink("Job");
        jobPage = PageGenerator.getJobPage(driver);

    }*/

    /*@Test
    public void Employee_09_Salary() {
        jobPage.clickOnTabsLink("Salary");
        salaryPage = PageGenerator.getSalaryPage(driver);

    }*/

    /*@Test
    public void Employee_10_Report_To() {
        salaryPage.clickOnTabsLink("Report-to");
        reportToPage = PageGenerator.getReportToPage(driver);

    }*/

    /*@Test
    public void Employee_11_Qualifications() {
        reportToPage.clickOnTabsLink("Qualifications");
        qualificationsPage = PageGenerator.getQualificationsPage(driver);

    }*/

    /*@Test
    public void Employee_12_Memberships() {
        qualificationsPage.clickOnTabsLink("Memberships");
        membershipsPage = PageGenerator.getMembershipsPage(driver);

    }*/

    /*@Test
    public void Employee_13_Search_Employee() {

    }*/

    @Test
    public void Employee_14_Delete_Employee() {
        extentLog("Employee_14_Delete_Employee - Step 01: Open Employee List page");
        profilePicturePage.clickOnTopBarLink("Employee List"); // TODO: Temporary
        employeeListPage = PageGenerator.getEmployeeListPage(driver);

        extentLog("Employee_14_Delete_Employee - Step 02: Delete employee by ID: " + employeeId);
        employeeListPage.clickOnEmployeeDeleteButton(employeeId);

        extentLog("Employee_14_Delete_Employee - Step 03: Confirm delete");
        employeeListPage.clickOnDialogPopupDeleteButton();

        extentLog("Employee_14_Delete_Employee - Step 04: Verify that success message is displayed");
        Assert.assertTrue(employeeListPage.isToastMessageDisplayed("Successfully Deleted"));

        employeeListPage.waitForLoading();

        extentLog("Employee_14_Delete_Employee - Step 05: Input value into Employee ID textbox: " + employeeId);
        employeeListPage.sendKeysToEmployeeIdTextbox(employeeId);

        extentLog("Employee_14_Delete_Employee - Step 06: Search employee by employee ID: " + employeeId);
        employeeListPage.clickOnEmployeeSearchButton();

        extentLog("Employee_14_Delete_Employee - Step 07: Verify that no records found");
        Assert.assertEquals(employeeListPage.getEmployeeSearchResult(), "No Records Found");
    }

    @AfterClass(alwaysRun = true)
    public void afterClass() {
        closeBrowserDriver();
    }
}
