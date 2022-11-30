package pageFactory;
import baseClass.mainDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import step_definitions.Hooks;

import java.util.List;

public class Login_POM
{
    //invalid user Name passowed
    @FindBy(xpath = "//div[@class='alert-strip error-alert']")
    public WebElement getInvalidUserNameMsg;

    //Password validation locater
    @FindBy(xpath = "//span[@id='cphContents_rfvParanShabd']")
    public WebElement passval;

    //Company Logo locater
    @FindBy(xpath = "//div[@class='logo']")
    public WebElement companuLogo;

    @FindBy(xpath = "//*[@class='col-md-12']//li[2]//img")
    public WebElement companyLogoHDFC;

    //Login page welcome message Locater
    @FindBy(xpath = "//div[@class='msg']")
    public WebElement loginpagetext;

    @FindBy(xpath = "//p[text()='Login Now !']")
    public WebElement loginPageTextHDHFC;

    //validation message locater when user enter 1st time invalid message
    @FindBy(xpath = "//*[@id='form1']/div[3]/div")
    public WebElement firstTimeinvalidpasswordmessage;
    //Home page locater

    @FindBy(xpath = "//h1[contains(text(),'Welcome to PayMate')]")
    public WebElement homePageText;
    //user name validation locater

    @FindBy(xpath = "//span[@id='cphContents_cvParanNaam']")
    public WebElement usernamevalidation;
    //user name text field locater

    @FindBy(xpath = "//input[@id='txtParanNaam']")
    public WebElement UserName;

    @FindBy(name = "UserName")
    public WebElement userNameFieldUAE;

    @FindBy(name = "Password")
    public WebElement passwordFieldUAE;

    @FindBy(xpath = "//input[@id='login']")
    public WebElement loginButtonUAE;

    @FindBy(xpath = "//a[text()='Continue']")
    public WebElement continueButtonUae;

    @FindBy(xpath = "//a[contains(text(),'Login')]")
    public WebElement loginButtonEmail;

    //user Name label locater
    @FindBy(xpath = "//span[@id='cphContents_rfvParanShabd']")
    public  WebElement userNameLabel;
    //password validation locater
    @FindBy(xpath = "//input[@name='ctl00$cphContents$txtParanNaam']")
    public WebElement passwordValidation;

    @FindBy(xpath = "//*[text()='Please enter a valid username or password']")
    public WebElement invalidemailandpassword;

    @FindBy(id = "txtParanShabd")
    public WebElement password;

    @FindBy(xpath = "//*[@id='cphContents_btnLogin']")
    public WebElement loginButton;

    @FindBy(className = "input-field otp-field")
    public WebElement otpField;

    @FindBy(id = "cphContents_txtOTP1")
    public WebElement otp1;

    @FindBy(name = "ctl00$cphContents$txtOTP2")
    public WebElement otp2;

    @FindBy(name = "ctl00$cphContents$txtOTP3")
    public WebElement otp3;

    @FindBy(name = "ctl00$cphContents$txtOTP4")
    public WebElement otp4;

    @FindBy(name = "ctl00$cphContents$txtOTP5")
    public WebElement otp5;

    @FindBy(name = "ctl00$cphContents$txtOTP6")
    public WebElement otp6;


    @FindBy(name = "ctl00$cphContents$btnSubmit")
    public WebElement verifyButtonHDFC;

    @FindBy(xpath = "//p[text()='Verify Mobile Number ']")
    public WebElement verifyMobileText;

    @FindBy(xpath = "//*[@id='PnlMain']//h1")
    public WebElement pageTitle;

    @FindBy(xpath = ".//*[@id='form1']/div[3]")
    public WebElement validationMessage;

    @FindBy(xpath = "//div[@id='UpnlHome']/div[1] | //*[contains(text(),'Login with')]")
    public  WebElement verfiyLoginPage;

    @FindBy(xpath = "//*[text()='Login Now !']")
    public  WebElement verfiyLoginPageHdfc;

//Forgot password link
    @FindBy(xpath = "//*[@id='UpnlHome']/div[6]/div/div[2]/a")
    public WebElement ForgotPasswordLink;
    //user Name Label
    @FindBy(xpath = "//*[@id='UpnlHome']/div[2]/div/div/label")
    public WebElement userNameLabel1;

    @FindBy(xpath = "//*[@id='cphContents_dvLogin']/div[1]/label")
    public WebElement userIDLabelHDFC;

    //Password Filed  Label
    @FindBy(xpath = "//*[@id='UpnlHome']/div[3]/div/div/label")
    public WebElement passwordLabel;

    @FindBy(xpath = "//*[@id='cphContents_dvLogin']/div[2]/label")
    public WebElement passwordLabelHDFC;

    @FindBy(xpath = "//*[text()='Login with your PayMate Account']")
    public WebElement loginPaymateText;

    //Signup Text link
    @FindBy(xpath = "//a[@href='Signup.aspx']")
    public WebElement SignupLink;

    //Forgot Password Link
    @FindBy(xpath = "//a[@href='ForgotPassword.aspx']")
    public WebElement forgotPasswordLink1;

    @FindBy(xpath = "//a[@id='forgot-psswd']")
    public WebElement forgotPasswordHDFC;

    //Login link
    @FindBy(xpath="//a[@href='Login.aspx']")
    public WebElement loginLink;

    //Signup Page title
    @FindBy(xpath = "//div[@id='cphContents_pnlContents']/div[1]")
    public WebElement registerTitle;

    @FindBy(xpath = "//*[text()='Sign up on PayMate !']")
    public WebElement signUpTitleHDFC;

    @FindBy(xpath = "//*[text()='Terms and Conditions']")
    public WebElement tncText;

    @FindBy(xpath = "//*[text()='GENERAL TERMS AND CONDITIONS']")
    public WebElement tncTextHDFC;

    @FindBy(xpath = "//h1[contains(text(),'Privacy Policy')]")
    public WebElement privacyPolicyText;

    @FindBy(xpath = "//*[text()='Knowledge base']")
    public WebElement helpText;

    @FindBy(xpath = "//*[contains(text(),'Charges')]")
    public WebElement chargesText;

    @FindBy(xpath = "//h3[contains(text(),'Request a Demo')]")
    public WebElement contactUsText;

    @FindBy(xpath = "//*[@class='col-md-6 col-xs-12 footer-links']/a")
    public List<WebElement> footerLinks;


    public Login_POM(WebDriver driver)
    {
        driver = Hooks.driver;
        PageFactory.initElements(driver, this);
    }
}
