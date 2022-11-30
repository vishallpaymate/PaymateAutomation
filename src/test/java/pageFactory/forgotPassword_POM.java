package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import step_definitions.Hooks;

import java.util.List;

public class forgotPassword_POM {
    // Forgot password Label
    @FindBy(xpath = " //*[@id='UpnlHome']/div[2]/div/div/div/label")
    public WebElement fplabel;

    @FindBy(xpath = "//*[text()='Email Address']")
    public WebElement emailAddressLabel;

//Current password label
    @FindBy(xpath = "//*[@id='UpnlHome']/div[1]/div/div/div/label")
    public WebElement CpLabel;
    //New Password label
    @FindBy(xpath ="//*[@id='UpnlHome']/div[2]/div/div/div/label")
    public WebElement NpLabel;
    //Confirm password label
    @FindBy(xpath ="//*[@id='UpnlHome']/div[3]/div/div/div/label")
    public WebElement confPLabel;

    @FindBy(xpath = "//*[text()='Forgot Password?']")
    public WebElement forgotPasswordLink;

    @FindBy(xpath = "//*[text()='Forgot Password']")
    public WebElement forgotPasswordLinkHDFC;

    @FindBy(xpath = "//*[@id='closeTnC']/img")
    public WebElement closeForgotPassword;

    @FindBy(xpath = "//*[@id='form1']/div[3]/div")
    public WebElement Successfullymsg;

    @FindBy(xpath = "//div[@class='alert-strip success-alert']")
    public WebElement successFullyMsgHDFC;

    @FindBy(xpath = "//*[@id='txtUserName']")
    public WebElement forgotpasswordUserName;

    @FindBy(id = "btnGetOTP")
    public WebElement getOTPButton;

    @FindBy(name = "ctl00$cphContents$txtUserName")
    public WebElement emailAddressField;

    @FindBy(xpath = "//*[text()='Resend']")
    public WebElement resendOTPButton;

    @FindBy(name = "ctl00$cphContents$btnEditEmail")
    public WebElement editEmailButton;

    @FindBy(id = "cphContents_Label1")
    public WebElement otpMessage;

    @FindBy(css = ".input-field")
    public WebElement otpFields;

    @FindBy(xpath = "//*[@class='input-field otp-field text-center']/input[not(contains(@type,'hidden'))]")
    public List<WebElement> listOtpFields;

    @FindBy(id = "cphContents_lblOTPError")
    public WebElement incorrectOTPError;

    @FindBy(name = "ctl00$cphContents$btnVerifyOtp")
    public WebElement submitOTP;

    @FindBy(id = "cphContents_txtPassword")
    public WebElement newPasswordField;

    @FindBy(id = "cphContents_txtConfirmPassword")
    public WebElement confirmPasswordField;

    @FindBy(xpath = "//*[@id='cphContents_dvEmailVerification']/div[1]")
    public WebElement forgotPasswordPageTitle;

//    @FindBy(xpath ="//*[@id='UpnlHome']/h4")
//    public WebElement forgotPasswordPageTitle;

    @FindBy(xpath = "//*[@id='cphContents_btnRecover']")
    public WebElement ResetMyPasswordButton;

    @FindBy(xpath = "//*[@id='UpnlHome']/div[4]/div/a")
    public WebElement loginLink;

    @FindBy(name = "ctl00$cphContents$btnLogin")
    public WebElement loginButton;

    @FindBy(xpath = "//*[@id='cphContents_cvUserName']")
    public WebElement emptyUserNameValidationMessage;

    @FindBy(xpath = "//*[@id='form1']/div[3]")
    public WebElement UserValidationMessage;

    @FindBy(xpath = "//div[@id='UpnlHome']/h4")
    public WebElement ChangePasswordScreen;

    @FindBy(name = "ctl00$cphContents$txtCurrentParanShabd")
    public WebElement CurrentPassword;

    @FindBy(name = "ctl00$cphContents$txtParanShabd")
    public WebElement NewPassword;

    @FindBy(name = "ctl00$cphContents$txtConfirmParanShabd")
    public  WebElement ConfirmPassword;

    @FindBy(name = "ctl00$cphContents$btnSave")
    public WebElement SaveButton;

    @FindBy(id = "cphContents_btnCancel")
    public WebElement cancelButton;

    @FindBy(xpath = "//div[@class='inline-element']")

    public WebElement getAlredayRefisterValidation;
    @FindBy(xpath = "//div[@class='mdl-textfield']")
    public WebElement getPasswordGuidanceText;


    public forgotPassword_POM(WebDriver driver)
    {
        driver = Hooks.driver;
        //This initElements method will create all WebElements
        PageFactory.initElements(driver, this);
    }

}
