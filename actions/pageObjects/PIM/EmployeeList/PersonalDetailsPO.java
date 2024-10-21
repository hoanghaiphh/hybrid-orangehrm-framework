package pageObjects.PIM.EmployeeList;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import pageObjects.PimPO;
import pageUIs.PIM.EmployeeList.PersonalDetailsPUI;

public class PersonalDetailsPO extends PimPO {
    private WebDriver driver;

    public PersonalDetailsPO(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public String getValueOfFirstNameTextbox() {
        waitForElementVisible(driver, PersonalDetailsPUI.FIRST_NAME_TEXTBOX);
        return getAttributeValue(driver, PersonalDetailsPUI.FIRST_NAME_TEXTBOX, "value");
    }

    public String getValueOfMiddleNameTextbox() {
        waitForElementVisible(driver, PersonalDetailsPUI.MIDDLE_NAME_TEXTBOX);
        return getAttributeValue(driver, PersonalDetailsPUI.MIDDLE_NAME_TEXTBOX, "value");
    }

    public String getValueOfLastNameTextbox() {
        waitForElementVisible(driver, PersonalDetailsPUI.LAST_NAME_TEXTBOX);
        return getAttributeValue(driver, PersonalDetailsPUI.LAST_NAME_TEXTBOX, "value");
    }

    public String getValueOfEmployeeIdTextbox() {
        waitForElementVisible(driver, PersonalDetailsPUI.EMPLOYEE_ID_TEXTBOX);
        return getAttributeValue(driver, PersonalDetailsPUI.EMPLOYEE_ID_TEXTBOX, "value");
    }

    public void sendKeysToDriverLicenseNumberTextbox(String driverLicense) {
        waitForElementVisible(driver, PersonalDetailsPUI.DRIVER_LICENSE_NUMBER_TEXTBOX);
        clearAllElementsText(driver, PersonalDetailsPUI.DRIVER_LICENSE_NUMBER_TEXTBOX);
        sendKeysToElement(driver, PersonalDetailsPUI.DRIVER_LICENSE_NUMBER_TEXTBOX, driverLicense);
    }

    public void sendKeysToLicenseExpiryDateTextbox(String licenseExpiryDate) {
        waitForElementVisible(driver, PersonalDetailsPUI.LICENSE_EXPIRY_DATE_TEXTBOX);
        clearAllElementsText(driver, PersonalDetailsPUI.LICENSE_EXPIRY_DATE_TEXTBOX);
        sendKeysToElement(driver, PersonalDetailsPUI.LICENSE_EXPIRY_DATE_TEXTBOX, licenseExpiryDate);
    }

    public void selectOptionInNationalityDropdown(String nationality) {
        waitForElementVisible(driver, PersonalDetailsPUI.NATIONALITY_DROPDOWN_PARENT);
        selectOptionInCustomDropdown(driver,
                PersonalDetailsPUI.NATIONALITY_DROPDOWN_PARENT,
                PersonalDetailsPUI.NATIONALITY_DROPDOWN_OPTIONS,
                nationality);
    }

    public void selectOptionInMaritalStatusDropdown(String maritalStatus) {
        waitForElementVisible(driver, PersonalDetailsPUI.MARITAL_STATUS_DROPDOWN_PARENT);
        selectOptionInCustomDropdown(driver,
                PersonalDetailsPUI.MARITAL_STATUS_DROPDOWN_PARENT,
                PersonalDetailsPUI.MARITAL_STATUS_DROPDOWN_OPTIONS,
                maritalStatus);
    }

    public void sendKeysToDateOfBirthTextbox(String dateOfBirth) {
        waitForElementVisible(driver, PersonalDetailsPUI.DATE_OF_BIRTH_TEXTBOX);
        clearAllElementsText(driver, PersonalDetailsPUI.DATE_OF_BIRTH_TEXTBOX);
        sendKeysToElement(driver, PersonalDetailsPUI.DATE_OF_BIRTH_TEXTBOX, dateOfBirth);
    }

    public void selectGenderRadio(String gender) {
        if (!isElementSelected(driver, PersonalDetailsPUI.DYNAMIC_GENDER_RADIO, gender)) {
            clickOnElementByJS(driver, PersonalDetailsPUI.DYNAMIC_GENDER_RADIO, gender);
        }
    }

    public void clickOnPersonalDetailsSaveButton() {
        waitForElementClickable(driver, PersonalDetailsPUI.PERSONAL_DETAILS_SAVE_BUTTON);
        clickOnElement(driver, PersonalDetailsPUI.PERSONAL_DETAILS_SAVE_BUTTON);
    }

    public String getValueOfDriverLicenseNumberTextbox() {
        waitForElementVisible(driver, PersonalDetailsPUI.DRIVER_LICENSE_NUMBER_TEXTBOX);
        return getAttributeValue(driver, PersonalDetailsPUI.DRIVER_LICENSE_NUMBER_TEXTBOX, "value");
    }

    public String getValueOfLicenseExpiryDateTextbox() {
        waitForElementVisible(driver, PersonalDetailsPUI.LICENSE_EXPIRY_DATE_TEXTBOX);
        return getAttributeValue(driver, PersonalDetailsPUI.LICENSE_EXPIRY_DATE_TEXTBOX, "value");
    }

    public String getSelectedOptionInNationalityDropdown() {
        waitForElementVisible(driver, PersonalDetailsPUI.NATIONALITY_DROPDOWN_PARENT);
        return getElementText(driver, PersonalDetailsPUI.NATIONALITY_DROPDOWN_PARENT);
    }

    public String getSelectedOptionInMaritalStatusDropdown() {
        waitForElementVisible(driver, PersonalDetailsPUI.MARITAL_STATUS_DROPDOWN_PARENT);
        return getElementText(driver, PersonalDetailsPUI.MARITAL_STATUS_DROPDOWN_PARENT);
    }

    public String getValueOfDateOfBirthTextbox() {
        waitForElementVisible(driver, PersonalDetailsPUI.DATE_OF_BIRTH_TEXTBOX);
        return getAttributeValue(driver, PersonalDetailsPUI.DATE_OF_BIRTH_TEXTBOX, "value");
    }

    public boolean isGenderRadioSelected(String gender) {
        waitForElementSelected(driver, PersonalDetailsPUI.DYNAMIC_GENDER_RADIO, gender);
        return isElementSelected(driver, PersonalDetailsPUI.DYNAMIC_GENDER_RADIO, gender);
    }

    public void sendKeysToFirstNameTextbox(String firstName) {
        waitForElementVisible(driver, PersonalDetailsPUI.FIRST_NAME_TEXTBOX);
        sendKeysToElement(driver, PersonalDetailsPUI.FIRST_NAME_TEXTBOX, Keys.chord(Keys.CONTROL, "a", Keys.BACK_SPACE));
        sendKeysToElement(driver, PersonalDetailsPUI.FIRST_NAME_TEXTBOX, firstName);
    }

    public void sendKeysToLastNameTextbox(String lastName) {
        waitForElementVisible(driver, PersonalDetailsPUI.LAST_NAME_TEXTBOX);
        sendKeysToElement(driver, PersonalDetailsPUI.LAST_NAME_TEXTBOX, Keys.chord(Keys.CONTROL, "a", Keys.BACK_SPACE));
        sendKeysToElement(driver, PersonalDetailsPUI.LAST_NAME_TEXTBOX, lastName);
    }

}
