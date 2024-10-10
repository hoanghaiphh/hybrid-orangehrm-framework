package pageUIs.PIM;

public class AddEmployeePUI {
    public static final String FIRST_NAME_TEXTBOX = "name=firstName";
    public static final String MIDDLE_NAME_TEXTBOX = "name=middleName";
    public static final String LAST_NAME_TEXTBOX = "name=lastName";
    public static final String PROFILE_PICTURE_UPLOAD = "css=input[type='file']";
    public static final String CREATE_LOGIN_DETAIL_LABEL = "css=div.oxd-switch-wrapper>label";
    public static final String CREATE_LOGIN_DETAIL_CHECKBOX = "css=div.oxd-switch-wrapper input";
    public static final String EMPLOYEE_ID_TEXTBOX = "xpath=//label[text()='Employee Id']/parent::div/following-sibling::div/input";
    public static final String EMPLOYEE_USERNAME_TEXTBOX = "xpath=//label[text()='Username']/parent::div/following-sibling::div/input";
    public static final String EMPLOYEE_PASSWORD_TEXTBOX = "xpath=//label[text()='Password']/parent::div/following-sibling::div/input";
    public static final String EMPLOYEE_CONFIRM_PASSWORD_TEXTBOX = "xpath=//label[text()='Confirm Password']/parent::div/following-sibling::div/input";
    public static final String ENABLED_RADIO = "xpath=//div[@class='oxd-radio-wrapper']/label[text()='Enabled']";
    public static final String ADD_EMPLOYEE_SAVE_BUTTON = "xpath=//h6[text()='Add Employee']/following-sibling::form//button[contains(string(),'Save')]";

}
