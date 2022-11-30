package pageFactory;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import step_definitions.Hooks;


import java.util.List;

public class SignUp_POM
{
    //Singup Page Wel come text
    @FindBy(xpath = "//div[@id='cphContents_pnlContents']/div[1]")
    public WebElement SignupWelComeText;

    @FindBy(xpath = "//*[@id='cphContents_pnlContents']/p")
    public WebElement signUpWelComeTextHDFC;

    //First Name label
    @FindBy(xpath = "//*[@id='cphContents_pnlContents']/div[2]/div/div/label")
    public WebElement FNLabel;

    @FindBy(xpath = "//*[@id='cphContents_pnlContents']/div[1]/label")
    public WebElement fnLabelHDFC;

    //Last Name label
    @FindBy(xpath = "//*[@id='cphContents_pnlContents']/div[3]/div/div/label")
    public WebElement LNLabel;

    @FindBy(xpath = "//*[@id='cphContents_pnlContents']/div[2]/label")
    public WebElement lnlabelHDFC;

    //email Label
    @FindBy(xpath = "//*[@id='cphContents_pnlContents']/div[4]/div/div/label")
    public WebElement EmailLabel;

    @FindBy(xpath = "//*[@id='cphContents_pnlContents']/div[4]/label")
    public WebElement emailLabelHDFC;

    // Mobile number Label
    @FindBy(xpath = "//*[@id='cphContents_pnlContents']/div[5]/div/div/label")
    public WebElement MNLabel;

    @FindBy(xpath = "//*[@id='cphContents_pnlContents']/div[3]/label")
    public WebElement mnLabelHDFC;

    // Check box
    @FindBy(xpath = "//*[@id='cphContents_pnlContents']/div[7]/div/label/span[1]")
    public WebElement checkBox;

    @FindBy(xpath = "//*[@id='cphContents_pnlContents']/div[5]//span[1]")
    public WebElement checkboxHDFC;

    @FindBy(xpath = "//*[@id='cphContents_pnlContents']/div[5]/label")
    public WebElement checkboxTextHDFC;

    //SignUp Button
    @FindBy(id = "cphContents_btnSubmit")
    public WebElement signUpButton;

    //SignIn link
    @FindBy(xpath = "//a[@href='Login.aspx']")
    public WebElement SignInLink;

    @FindBy(xpath = "//a[text()='Login Here ']")
    public WebElement signInLinkHDFC;

    @FindBy(xpath = "//a[@id='loginhereview-trigger']")
    public WebElement loginLinkHDFC;

    //Login Page
    @FindBy(xpath = "//*[@id='UpnlHome']/div[1]")
    public WebElement loginPage;

    //Signup Text link
    @FindBy(xpath = "//a[@href='Signup.aspx']")
    public WebElement SignupLink;

    @FindBy(xpath = "/html/body/table/tbody/tr[2]/td/table/tbody/tr/td/p")
    public WebElement verifyEmailText;

    //Forgot Password Link
    @FindBy(xpath = "//a[@href='ForgotPassword.aspx']")
    public WebElement FpLink;

    @FindBy(xpath = "//a[text()='Forgot Password']")
    public WebElement fpLinkHDFC;

    //Forgot Password text
    @FindBy(xpath = "//*[@id='UpnlHome']/h4")
    public WebElement FpText;

    @FindBy(xpath = "//h2[text()='Forgot Password']")
    public WebElement fpTitle;

    @FindBy(xpath = "//*[@class='forgotPassword-wrapper']/span")
    public WebElement fpText;

    @FindBy(name = "ctl00$cphContents$txtUserName")
    public WebElement fpRegEmailField;

//*****************************************SignUp For Enter Data*******************************************************************
 //Sign Up First name
 @FindBy(id = "txtFirstName")
 public WebElement FirestName;

 //Sign Up Last Name
 @FindBy(id = "txtLastName")
 public WebElement LastName;

 //Email
 @FindBy(id = "txtEmailaddress")
 public WebElement Email;

 //Mobile Number
 @FindBy(id = "txtMobileno")
 public WebElement MobileNumber;

 // Accept Button on T&C page
    @FindBy(className = "mdl-button__ripple-container")
    public WebElement acceptButton;

    @FindBy(id = "termsAcceptBtn")
    public WebElement acceptTermsHDFC;

//Submit button name
    @FindBy(name ="ctl00$cphContents$btnSubmit")
    public  WebElement SubmitButton;

    @FindBy(xpath ="//a[text()='Verify Email Address']")
    public  WebElement verifytEmailButtonHDFC;

    @FindBy(xpath ="//a[text()=' Add new business']")
    public  WebElement addBusinessUae;

//verify Email Page
    @FindBy(xpath = "//div[contains(text(),'We have sent you an email. Please check your mail')]")
    public WebElement verfiyEmailPage;

    @FindBy(xpath = "//p[contains(text(),'We have sent you an email. Please check your mailbox and click on the link to verify and confirm your email address.')]")
    public WebElement verfiyEmailPageHDFC;

// Resend email Link
    @FindBy(xpath = "//*[@id='cphContents_lnkResendEmail']")
    public WebElement resendEmail;
    //Change your Email Address link
    @FindBy(xpath = "//*[@id='cphContents_lblChangeEmail']")
    public WebElement changeEmail;
    //
//verify mobile number text
    @FindBy(xpath = "//h4[@class='text-center']")
    public WebElement Text;

    //OTP text
    @FindBy(xpath = "//*[@id='cphContents_pnlContents']/div[1]")
    public WebElement otpText;
    //OTP text box Label
@FindBy(xpath = "//*[@id='cphContents_pnlContents']/div[2]/div/div/div/label")
public WebElement otpTextBoxLabel;
//
    //Create password page
    @FindBy(xpath = "//h4[contains(text(),'Create a password')]")
    public WebElement getCreatePasswordText;

    @FindBy(xpath = "//h1[(text()='Create a password for your account')]")
    public WebElement getCreatePasswordTextHDFC;
//resene Otp Link
    @FindBy(id = "cphContents_lnkResendMobile")
    public WebElement ResendOtpLink;
    //Change mobile Number link
    @FindBy(id = "cphContents_lnkChangeMobile")
    public WebElement changemobileNumber;

    //Submit Button
    @FindBy(name = "ctl00$cphContents$btnSubmit")
    public WebElement submiButton;
//Enter OTP Text Box
    @FindBy(name = "ctl00$cphContents$txtOTP")
    public WebElement EnterOTP;

    //OTP sucesss message
    @FindBy(xpath = "//*[@id='form1']/div[3]")
    public WebElement EnterOtpValidationMessage;

    //Enter Password
    @FindBy(css = "#cphContents_txtPassword")
    public WebElement getEnterPasswordField;

    @FindBy(name = "ctl00$cphContents$txtPassword")
    public WebElement getEnterPasswordFieldHDFC;

    // Enter password Label
    @FindBy(xpath = "//div[@id='cphContents_pnlContents']//div[1]//div[1]//div[1]//div[1]//label[1]")
    public WebElement getEnterPasswordLabel;

    @FindBy(xpath = "//*[@id='cphContents_pnlContents']/div[1]/label")
    public WebElement enterPasswordLabelHdfc;

    @FindBy(xpath = "//*[@id='cphContents_pnlContents']/div[2]/label")
    public WebElement confirmPasswordLabelHdfc;

    @FindBy(id = "cphContents_txtCurrentParanShabd")
    public WebElement currentPassword;

    //ReEnter Password
    @FindBy(css = "#cphContents_txtConfirmPassword")
    public WebElement getReEnterPasswordField;

    @FindBy(name = "ctl00$cphContents$txtConfirmPassword")
    public WebElement confirmPasswordFieldHdfc;

    //ReEnter Password Label
    @FindBy(xpath = "//label[contains(text(),'Re-Enter Password')]")
    public WebElement getreEnterPasswordLabel;



    //Password guidance text
    @FindBy(xpath = "//div[@class='mdl-textfield']")
    public WebElement getPasswordGuidanceText;

    @FindBy(xpath = "//*[@id='cphContents_pnlContents']/p")
    public WebElement getPasswordGuidanceTextHdfc;

    //Business Page text
    @FindBy(xpath = "//*[contains(text(),'Help us know your business better')]")
    public WebElement getBusinessPageText;

    //Business name
    @FindBy(css = "#txtBusinessName")
    public WebElement getBusinessNameField;

    @FindBy(css = "#cphContents_txtGSTIN")
    public WebElement getBusinessGSTINField;

    @FindBy(id = "txtCompanyName")
    public WebElement businessNameFieldUae;

    @FindBy(id = "txtCompanyNickName")
    public WebElement businessNickFieldUae;

    @FindBy(id = "txtContactName")
    public WebElement contactFieldUae;

    @FindBy(id = "txtContactDesignation")
    public WebElement contactDesgnFieldUae;

    @FindBy(id = "txtCompanyEmailId")
    public WebElement emailFieldUae;

    @FindBy(xpath = "//*[@id='ddlCountry_select']/li")
    public List<WebElement> countryFieldUae;

    @FindBy(xpath = "//*[@for='ddlCountry_select']/i")
    public WebElement countryDrodDownUae;

    @FindBy(id = "txtCompanyMobileNo")
    public WebElement mobileFieldUae;

    @FindBy(xpath = "//ul[@id='ddlParentCompany_select']/li")
    public List<WebElement> typeOfBusinessUae;

    @FindBy(xpath = "//*[@for='ddlParentCompany_select']/i")
    public WebElement businessTypeDrodDownUae;

    @FindBy(xpath = "//ul[@id='cmbCategory_select']/li")
    public List<WebElement> categoryOfBusinessUae;

    @FindBy(xpath = "//*[@for='cmbCategory_select']/i")
    public WebElement categoryDownUae;

    @FindBy(xpath = "//ul[@id='cmbSubcategory_select']/li")
    public List<WebElement> subCategoryOfBusinessUae;

    @FindBy(xpath = "//*[@for='cmbSubcategory_select']/i")
    public WebElement subCategoryDropDownUae;

    @FindBy(xpath = "//ul[@id='ddlSaleRelationshipUser_select']/li")
    public List<WebElement> salesRepUae;

    @FindBy(xpath = "//*[@for='ddlSaleRelationshipUser_select']/i")
    public WebElement salesRepDropdownUae;

    @FindBy(xpath = "//ul[@id='ddlAddressProofStateName_select']/li")
    public List<WebElement> emirateFieldUae;

    @FindBy(xpath = "//*[@for='ddlAddressProofStateName_select']/i")
    public WebElement emirateDropdownUae;

    @FindBy(id = "txtAddressProofStreetAddress")
    public WebElement addressFieldUae;

    @FindBy(id = "txtAddressProofDocumentPostalCode")
    public WebElement postalCodeUae;

    @FindBy(id = "IsCardManagementAdmin")
    public WebElement cardMgmtCheckbox;

    @FindBy(id = "IsFinanceManagementAdmin")
    public WebElement financeMgmtCheckbox;

    @FindBy(id = "IsUserManagementAdmin")
    public WebElement userMgmtCheckbox;

    @FindBy(id = "IsVendorManagementAdmin")
    public WebElement conMgmtCheckbox;

    @FindBy(id = "btnSavesubmit")
    public WebElement nextButtonUae;

    @FindBy(xpath = "//div[@id='divTransactionCurrency' and @aria-selected='true']")
    public WebElement tCurrencyTab;

    @FindBy(xpath = "//*[@id='PayableCurrency_1__IsChecked' and @value='true']")
    public WebElement payableCurrCheckbox;

    @FindBy(xpath = "//*[@id='RecievableCurrency_1__IsChecked' and @value='true']")
    public WebElement receivableCurrCheckbox;

    @FindBy(id = "btnCompanyCurrencySubmit")
    public WebElement submitCurrUae;

    @FindBy(id = "btnEnterPrisesDetailsSubmit")
    public WebElement submitSubscription;

    @FindBy(xpath = "//div[@id='divBusinessSubscription' and @aria-selected='true']")
    public WebElement busSubTab;

    @FindBy(xpath = "//div[@id='divCharges' and @aria-selected='true']")
    public WebElement tranxChargesTab;

    @FindBy(id = "btnChargeSubmit")
    public WebElement submitCharges;

    @FindBy(id = "btnChargeNext")
    public WebElement submitChargeNext;

    @FindBy(xpath = "//ul[@id='ddlIssueBank_select']/li")
    public List<WebElement> issuingBank;

    @FindBy(xpath = "//*[@for='ddlIssueBank_select']/i")
    public WebElement issuingBankDropdown;

    @FindBy(xpath = "//ul[@id='ddlRelationshipUser_select']/li")
    public List<WebElement> repManager;

    @FindBy(xpath = "//label[@for='ddlRelationshipUser_select']/i")
    public WebElement repMangrDropdown;

    @FindBy(xpath = "//ul[@id='ddlAcquiringBank_select']/li")
    public List<WebElement> acquiringBank;

    @FindBy(xpath = "//*[@for='ddlAcquiringBank_select']/i")
    public WebElement acquiringBankDropdown;

    @FindBy(xpath = "//ul[@id='ddlChargesMode_select']/li")
    public List<WebElement> chargeMode;

    @FindBy(xpath = "//*[@for='ddlChargesMode_select']/i")
    public WebElement chargeModeDropdown;

    @FindBy(xpath = "//*[@for='ddlCurrency_select']/i")
    public WebElement currecnyDropdown;

    @FindBy(xpath = "//ul[@id='ddlCurrency_select']/li")
    public List<WebElement> traxCurrency;

    @FindBy(xpath = "//*[@for='ddlTId_select']/i")
    public WebElement traxGatewayDropdown;

    @FindBy(xpath = "//ul[@id='ddlTId_select']/li")
    public List<WebElement> traxGateway;

    @FindBy(xpath = "//ul[@id='ddlCommissionType_select']/li")
    public List<WebElement> commType;

    @FindBy(xpath = "//*[@for='ddlCommissionType_select']/i")
    public WebElement commTypeDropdown;

    @FindBy(id = "txtBusinessCharge")
    public WebElement commCharge;

    @FindBy(xpath = "//div[@id='divSettlementCharges' and @aria-selected='true']")
    public WebElement settleChargesTab;

    @FindBy(xpath = "//*[@for='ddlsettlementChargesMode_select']/i")
    public WebElement settleChargeModeDropdown;

    @FindBy(xpath = "//ul[@id='ddlsettlementChargesMode_select']/li")
    public List<WebElement> settleChargeMode;

    @FindBy(xpath = "//*[@for='ddlsettlementCurrency_select']/i")
    public WebElement settlementCurrDropdown;

    @FindBy(xpath = "//ul[@id='ddlsettlementCurrency_select']/li")
    public List<WebElement> settlementCurr;

    @FindBy(xpath = "//*[@for='ddlsettlementBank_select']/i")
    public WebElement settlementBankDropdown;

    @FindBy(xpath = "//ul[@id='ddlsettlementBank_select']/li")
    public List<WebElement> settlementBank;

    @FindBy(xpath = "//*[@for='ddlsettlementCommissionType_select']/i")
    public WebElement settlementCommTypeDropdown;

    @FindBy(id = "txtsettlementBusinessCharge")
    public WebElement settlementCommCharge;

    @FindBy(xpath = "//ul[@id='ddlsettlementCommissionType_select']/li")
    public List<WebElement> settlementCommtType;

    @FindBy(id = "btnsettlementChargeSubmit")
    public WebElement submitSettlement;

    @FindBy(id = "btnSaveAndCountinuesubmit")
    public WebElement saveSettlement;

    @FindBy(xpath = "//div[@id='divQuestion' and @aria-selected='true']")
    public WebElement complianceTab;

    @FindBy(id = "BtnQuestionare")
    public WebElement saveComplaince;

    @FindBy(xpath = "//h1[text()='Manage Business Configuration']")
    public WebElement manageBusinessUaeTitle;

    @FindBy(id = "chkKYCRequired")
    public WebElement kycCheckboxUae;



//Business name Label
    @FindBy(xpath = "//label[contains(text(),'Business Name')]")
    public WebElement getBusinessFieldLabel;

    @FindBy(xpath = "//label[contains(text(),'GSTIN')]")
    public WebElement getBusinessGSTINLabel;

//SubBusiness Name filed
    @FindBy(css = "#txtBusinessnickname")
    public WebElement getSubBusinessName;

    //subBusiness Name Label
    @FindBy(xpath = "//*[contains(text(),'Business Nick Name')]")
    public WebElement getSubBusinessNameLabel;

    //Type of business field
    @FindBy(css = "#cphContents_cmbtypeofbusiness_select")
    public WebElement getTypeOfBusinessFiled;

    @FindBy(css = "#cphContents_cmbtypeofbusiness")
    public WebElement getTypeOfBusinessFiledHdfc;

    @FindBy(xpath = "//*[@id='cphContents_pnlContents']//div[3]/img")
    public WebElement typeofBusinessDownArrowHdfc;

    @FindBy(css = "#cphContents_cmbCategory")
    public WebElement categoryOfBusinessHdfc;

    @FindBy(xpath = "//*[@id='cphContents_pnlContents']//div[4]/img")
    public WebElement categoryOfBusinessDownArrowHdfc;

    @FindBy(css = "#cphContents_cmbSubcategory")
    public WebElement subCategoryOfBusinessHdfc;

    @FindBy(xpath = "//h3[text()='Congratulations!']")
    public WebElement congratualtionTxt;

    @FindBy(xpath = "//*[text()='You have successfully created your account.']")
    public WebElement accountSuccessfullTxt;

    @FindBy(id = "txtSubscriptionCardNo")
    public WebElement enterCardNoHdfc;

    @FindBy(id = "txtCardHolder")
    public WebElement cardHolderHdfc;

    @FindBy(id = "txtSubscriptionExpDate")
    public WebElement cardExpiryHdfc;

    @FindBy(name = "ctl00$btnContinue")
    public WebElement submitCardHdfc;

    @FindBy(id = "txtPayCVV")
    public WebElement enterCvvHdfc;

    @FindBy(name = "ctl00$btnSubscriptionPayNow")
    public WebElement payNowHdfc;

    @FindBy(id = "password")
    public WebElement enterPasswordHdfc;

    @FindBy(name = "UsernamePasswordEntry")
    public WebElement submitPasswordHdfc;

    @FindBy(xpath = "//*[@id='cphContents_pnlContents']//div[5]/img")
    public WebElement subCategoryOfBusinessDownArrowHdfc;

    //Type of Business DropDown list
    @FindBy(xpath = "//ul[@id='cphContents_cmbtypeofbusiness_select']/li")
    public List<WebElement> getTypeOfBusinessValue;

    @FindBy(xpath = "//ul[@id='cphContents_ddlIndustry_select']/li")
    public List<WebElement> getTypeofIndustry;

    @FindBy(id = "cphContents_ddlIndustry_select")
    public WebElement typeofIndustry;

    @FindBy(name = "ctl00$cphContents$txtPinCode")
    public WebElement businessPincode;

    @FindBy(name = "ctl00$cphContents$txtCity")
    public WebElement businessCity;

    @FindBy(css = "#cphContents_cmbCategory_select")
    public WebElement getCategorydropdown;

    //Select category dropDown field
    @FindBy(css = "#UpnlHome")
    public WebElement getCategoryDropDownField;

    //select category DropDown value
    @FindBy(xpath = "//ul[@id='cphContents_cmbCategory_select']/li")
    public List<WebElement>  getCategoryDropDownValue;

    //select Sub Category field
    @FindBy(css= "#cphContents_cmbSubcategory_select")
    public WebElement getSubCategoryField;

    @FindBy(id= "cphContents_ddlState_select")
    public WebElement getStateField;

    @FindBy(id= "cphContents_ddlRegion_select")
    public WebElement getRegionField;

    //   select sub category values
    @FindBy(xpath = "//ul[@id='cphContents_cmbSubcategory_select']/li")
    public List <WebElement> getSubCategoryValue;

    @FindBy(xpath = "//ul[@id='cphContents_ddlState_select']/li")
    public List <WebElement> getStateValue;

    @FindBy(xpath = "//ul[@id='cphContents_ddlRegion_select']/li")
    public List <WebElement> getRegionValue;

    //webSite/Social page/blog filed
    @FindBy(css = "#txtwebsitredescription")
    public WebElement getSocialPageField;

    //website/Social Page/Blog field Label
    @FindBy(xpath = "//*[contains(text(),'Website/Social Page/Blog')]")
    public WebElement getSocialPageLabel;

    //Business definition field
    @FindBy(css = "#txtbusinessdescription")
    public WebElement getBusinessDefinitionField;

    //Business definition label
    @FindBy(xpath = "//*[contains(text(),'Business Definition')]")
    public WebElement getGetBusinessDefinitionLabel;
    //Submit button
    @FindBy(css = "#cphContents_btnSave")
    public WebElement getSubmitButton;
    //Submit button
    @FindBy(css = "#cphContents_btnSubmit")
    public WebElement getCompleteSignUp;

    //msg
    @FindBy(xpath = "//*[(text()='Signup completed. Welcome to PayMate!')]")
    public WebElement msg;

    //Error message
    @FindBy(xpath = "//span[@class='mdl-textfield__error']")
    public List<WebElement> getErrorMessage;
//SignIn link
    @FindBy(xpath = "//u[contains(text(),'Register Now!')]")
    public WebElement getSignInLink;

    //First Name Focus
    @FindBy(xpath = "//*[@class='mdl-textfield mdl-js-textfield mdl-textfield--floating-label is-upgraded is-error is-invalid']")
    public WebElement getFirstNameFocus;

    //First Name validation message
  /*  @FindBy(xpath = "//*[@class='mdl-textfield__input']")
    public List<WebElement> getFields;
  */
  @FindBy(xpath = "//span[@id='cphContents_cvFirstName']")
  public WebElement getFirestNameMsg;
  //Last Name
    @FindBy(xpath = "//span[@id='cphContents_cvLastName']")
    public WebElement getLastNameMsg;
    //Email
    @FindBy(xpath = "//span[@id='cphContents_cvEmailaddress']")
    public WebElement getEmalMsg;

    //Mobile Number
    @FindBy(xpath = "//span[@id='cphContents_cvmobileno']")
    public WebElement getMobileNumbermsg;

    // Terms and condition
    @FindBy(xpath = "//div[@class='inline-element']")
    public WebElement getTCMsg;

    //Start Agian Button
    @FindBy(xpath = "//input[@id='cphContents_btnStartAgain']")
    public WebElement getStartAgianButton;

    //continue button
    @FindBy(xpath = "//input[@id='cphContents_btnContinue']")
    public WebElement getContinueButton;

    // Already Regsiter validation message
    @FindBy(xpath = "//div[@class='inline-element']")
    public WebElement getAlredayEmailregistermsg;

    // welcome paymate complete signUp page
    @FindBy(xpath = "//div[@id='cphContents_pnlContents']/div[2]")
    public WebElement getCompletSignUpPage;
//
    @FindBy(xpath = "//div[@id='cphContents_pnlContents']/div[1]")
    public WebElement getWelComeToPaymate;

    @FindBy(xpath = "//a[@id='cphContents_lnkResendEmail']")
    public  WebElement getResendEmailLink;

    @FindBy(xpath = "//a[@id='cphContents_lblChangeEmail']")
    public WebElement getChangeEmail;

    @FindBy(xpath = "//div[@class='alert-strip success-alert']")
    public WebElement getResendValidationMessage;

    @FindBy(xpath = "//div[@class='msg']")
    public WebElement getOnRegistrationpageText;

    @FindBy(xpath = "//span[text()='Please enter the company name']")
    public WebElement companyNameValUae;

    @FindBy(xpath = "//span[text()='Please enter the contact name']")
    public WebElement contactNameValUae;

    @FindBy(xpath = "//span[text()='Please enter the contact designation']")
    public WebElement contactDesgnValUae;

    @FindBy(xpath = "//span[text()='Please select the country']")
    public WebElement countryValUae;

    @FindBy(xpath = "//span[contains(text(),'e-mail id')]")
    public WebElement emailValUae;

    @FindBy(xpath = "//span[text()='Please enter the mobile number']")
    public WebElement mobileValUae;

    @FindBy(xpath = "//span[text()='Please select the business type']")
    public WebElement businessTypeValUae;

    @FindBy(xpath = "//span[text()='Please select the category name']")
    public WebElement categoryNameValUae;

    @FindBy(xpath = "//span[text()='Please select a sub category name']")
    public WebElement subCategoryNameValUae;

    @FindBy(xpath = "//span[text()='Select Sales Representative']")
    public WebElement salesRepresntativeValUae;

    @FindBy(xpath = "//span[text()='Please enter the address']")
    public WebElement addressValUae;

    @FindBy(xpath = "//span[text()='Please select the state']")
    public WebElement stateValUae;

    @FindBy(xpath = "//span[text()='Please enter P.O.Box']")
    public WebElement poBoxValUae;

  public SignUp_POM(WebDriver driver)
    {
        driver = Hooks.driver;
        //This initElements method will create all WebElements
        PageFactory.initElements(driver, this);
    }
}
