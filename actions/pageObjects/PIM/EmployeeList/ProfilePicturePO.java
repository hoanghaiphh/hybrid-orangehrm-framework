package pageObjects.PIM.EmployeeList;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import pageObjects.PimPO;
import pageUIs.PIM.EmployeeList.ProfilePicturePUI;
import pageUIs.PimPUI;

public class ProfilePicturePO extends PimPO {
    private WebDriver driver;

    public ProfilePicturePO(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public Dimension getNaturalDimensionOfProfilePicture() {
        waitForElementVisible(driver, PimPUI.PROFILE_PICTURE_IMAGE);
        int naturalWidth = Integer.parseInt(getAttributeValue(driver, PimPUI.PROFILE_PICTURE_IMAGE, "naturalWidth"));
        int naturalHeight = Integer.parseInt(getAttributeValue(driver, PimPUI.PROFILE_PICTURE_IMAGE, "naturalHeight"));
        return new Dimension(naturalWidth, naturalHeight);
    }

    public void uploadProfilePicture(String profilePicturePath) {
        sendKeysToElement(driver, ProfilePicturePUI.PROFILE_PICTURE_UPLOAD, profilePicturePath);
    }

    public void clickOnChangeProfilePictureSaveButton() {
        waitForElementClickable(driver, ProfilePicturePUI.CHANGE_PROFILE_PICTURE_SAVE_BUTTON);
        clickOnElement(driver, ProfilePicturePUI.CHANGE_PROFILE_PICTURE_SAVE_BUTTON);
    }
}
