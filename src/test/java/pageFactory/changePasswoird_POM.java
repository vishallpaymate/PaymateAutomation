package pageFactory;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import step_definitions.Hooks;

import java.util.List;

public class changePasswoird_POM {
    //profile icon
    @FindBy(xpath = "//i[contains(text(),'person')]")
    public WebElement getProfileIcon;

    //Change Password Link
    @FindBy(xpath = "//div[contains(text(),'Change Password')]")
    public WebElement getChangePasswordLink;
    //*[@id='navbar-collapse']/ul/li/a[2]/i
    //Logout Link
    @FindBy(xpath = "//div[contains(text(),'Logout')]")
    public WebElement getLogoutLink;

    //Edit profile link
    @FindBy(xpath = "//div[contains(text(),'Edit Profile')]")
    public WebElement getEditProfile;

    //chnage Password title
    @FindBy(id = "ContentPlaceHolder1_headerTitle")
    public WebElement getChangePsswordTitle;

    //Current password Label
    @FindBy(xpath = "//*[@id='dvCompany']/div/div[1]/div/label")
    public WebElement getChangePasswordLabel;

    //Current Password field
    @FindBy(id = "ContentPlaceHolder1_txtCurrentParanShabd")
    public WebElement getCurrentPassword;

    //New Password field
    @FindBy(id = "ContentPlaceHolder1_txtParanShabd")
    public WebElement getNewPasswordField;

    //New Password Label
    @FindBy(xpath = "//*[@id='dvCompany']/div/div[2]/div/label")
    public WebElement getNewPasswordLabel;
    //confirm password Filed
    @FindBy(id = "ContentPlaceHolder1_txtConfirmParanShabd")
    public WebElement getConfirmPasswordField;

    //confirm Password Label
    @FindBy(xpath = "//*[@id='dvCompany']/div/div[3]/div/label")
    public WebElement getConfirmPasswordLabel;

    //password guidance text
    @FindBy(id = "ContentPlaceHolder1_dvRolecontrol")
    public WebElement getPasswordGuidanceText;

    //save button
    @FindBy(xpath = "//*[@id='btnSave']")
    public WebElement getSaveButton;
//Profile settings
    @FindBy(xpath = "//a[contains(text(),'Profile Settings')]")
    public WebElement getProfileSettings;
    //Cancel bUtton
    @FindBy(xpath = "//input[@value='Cancel']")
    public WebElement getCancelButton;
//chnage password link from profile settings
    @FindBy(linkText = "Change Password")
    public WebElement getChnagePassword;
    //Current password
    @FindBy(xpath = "//input[@name='ctl00$ContentPlaceHolder1$txtCurrentParanShabd']")
    public WebElement getGetCurrentPassword;

    //new password
    @FindBy(xpath = "//input[@id='ContentPlaceHolder1_txtParanShabd']")
    public WebElement getNewPassword;


    //confirm password
    @FindBy(xpath = "//input[@id='ContentPlaceHolder1_txtConfirmParanShabd']")
    public WebElement getConfirmPassword;

    //SaveButton
    @FindBy(css = "#ContentPlaceHolder1_btnSave")
    public WebElement getSave;

    //validation message when data is blank
    @FindBy(xpath = "//*[@class='mdl-textfield__error']")
    public List<WebElement> getErrorMessage;

    //same password as current password validation msg
    @FindBy(xpath = "//span[@id='ContentPlaceHolder1_cvParanShabd']")
    public WebElement getSamePassValidationMsg;

    //password missmatch
    @FindBy(xpath = "//span[@id='ContentPlaceHolder1_cvConfirmParanShabd']")
    public WebElement getPasswordMissMatchValidationMsg;
    // Your new password cannot be the same as your previous 5 password(s).
    // You have updated your password successfully
    public changePasswoird_POM(WebDriver driver) {
        driver = Hooks.driver;
        //This initElements method will create all WebElements
        PageFactory.initElements(driver, this);
    }

}
