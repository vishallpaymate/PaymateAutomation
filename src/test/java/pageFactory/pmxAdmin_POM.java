package pageFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import step_definitions.Hooks;

import java.util.List;

public class pmxAdmin_POM {

    @FindBy(name = "ctl00$cphContents$txtUserName")
    public WebElement adminUsername;

    @FindBy(name = "ctl00$cphContents$txtPassword")
    public WebElement adminPassword;

    @FindBy(id = "cphContents_btnLogin")
    public WebElement adminLoginButton;

    @FindBy(xpath = "//*[text()='Welcome to PayMate']")
    public WebElement adminHomePageText;

    @FindBy(xpath = "//*[text()='Business Management']")
    public WebElement businessManagementMenu;

    @FindBy(xpath = "//*[text()='Settings']")
    public WebElement settingsMenu;

    @FindBy(xpath = "//*[text()='User Settings']")
    public WebElement userSettingsMenu;

    @FindBy(xpath = "//*[text()='Add User']")
    public WebElement addUser;

//    @FindBy(xpath = "//*[@id='Ulmenu']/li[2]/a")
//    public WebElement businessManagementMenu;

    @FindBy(xpath = "//*[text()='Businesses']")
    public WebElement businessesMenu;

    @FindBy(xpath = "//*[text()='Add Business']")
    public WebElement addBusiness;

    @FindBy(xpath = "//*[text()='Manage Business']")
    public WebElement manageBusiness;

    @FindBy(xpath = "//*[text()='Manage Documents']")
    public WebElement manageDocuments;

    @FindBy(xpath = "//h4[text()='Add Business']")
    public WebElement addBusinessPageText;

    @FindBy(xpath = "//h4[text()='Manage Business']")
    public WebElement manageBusinessTitle;

    @FindBy(xpath = "//h4[text()='Manage Business Documents']")
    public WebElement manageBusinessDocsTitle;

    @FindBy(xpath = "//h4[text()='KYC Uploaded Documents']")
    public WebElement kycUploadTitle;

    @FindBy(id = "InternalCntHolder_btnPANApprove")
    public WebElement approvePan;

    @FindBy(id = "InternalCntHolder_btnPANApproveReason")
    public WebElement approvePanReason;

    @FindBy(id = "InternalCntHolder_btnDocumentApprove")
    public WebElement approveBusinessDocument;

    @FindBy(id = "InternalCntHolder_btnAddressApprove")
    public WebElement approveAddressDocument;

    @FindBy(id = "InternalCntHolder_txtApproveReason")
    public WebElement docVerificationReason;

    @FindBy(name = "ctl00$InternalCntHolder$btnApproveReason")
    public WebElement saveReason;

    @FindBy(id = "InternalCntHolder_btnGetStatus")
    public WebElement getStatusPan;

    @FindBy(xpath = "//*[text()='Business Details']")
    public WebElement businessDetailsSection;

    @FindBy(xpath = "//*[@class='anchor-heading' and @aria-expanded='true']")
    public WebElement businessDetailsSectionExpand;

    @FindBy(xpath = "//h5[text()='Subscription Plan']")
    public WebElement subscriptionPlanSection;

    @FindBy(xpath = "//a[@aria-expanded='true']")
    public WebElement subscriptionPlanSectionExpanded;

    @FindBy(xpath = "//h4[text()='Upload your documents']")
    public WebElement uploadDocumentsPageTitle;

    @FindBy(xpath = "//*[@id='InternalCntHolder_ddlsubscriptionPlan']")
    public WebElement selectSubscriptionPlan;

    @FindBy(name= "ctl00$InternalCntHolder$btnPayModeSave")
    public WebElement saveButton;

    @FindBy(name = "ctl00$InternalCntHolder$btnSubmit")
    public WebElement businessDetailsNextButton;

    @FindBy(name = "ctl00$InternalCntHolder$btnSave")
    public WebElement addUserSaveButton;

    @FindBy(name = "ctl00$InternalCntHolder$txtBusinessName")
    public WebElement enterBusinessName;

    @FindBy(xpath = "//td[text()='Please enter Business Name']")
    public WebElement businessNameValidationMsg;

    @FindBy(name = "ctl00$InternalCntHolder$txtFirstName")
    public WebElement enterFirstName;

    @FindBy(xpath = "//td[text()='Please  First Name']")
    public WebElement businessFirstNameValidationMsg;

    @FindBy(xpath = "//h4[text()='Add User']")
    public WebElement addUserPage;

    @FindBy(name = "ctl00$InternalCntHolder$txtLastName")
    public WebElement enterLastName;

    @FindBy(xpath = "//td[text()='Please  Last Name']")
    public WebElement businessLastNameValidationMsg;

    @FindBy(name = "ctl00$InternalCntHolder$txtEmailId")
    public WebElement enterEmailID;

    @FindBy(xpath = "//td[text()='Please enter your Emaiid']")
    public WebElement businessEmailValidationMsg;

    @FindBy(name = "ctl00$InternalCntHolder$txtMobileNo")
    public WebElement enterMobileNo;

    @FindBy(xpath = "//*[@id='cvmobileno_popupTable']//td[text()='Please enter valid mobile number']")
    public WebElement validMobileValidationMsg;

    @FindBy(xpath = "//td[text()='Please enter mobile number']")
    public WebElement businessMobileValidationMsg;

    @FindBy(xpath = "//*[@id='InternalCntHolder_ddlBusinessType']")
    public WebElement typeOfBusiness;

    @FindBy(xpath = "//*[@id='InternalCntHolder_ddlStatus']")
    public WebElement docStatus;

    @FindBy(xpath = "//td[text()='Please Select business type']")
    public WebElement businessTypeValidationMsg;

    @FindBy(xpath = "//*[@id='InternalCntHolder_ddlCategory']")
    public WebElement categoryOfBusiness;

    @FindBy(xpath = "//*[@id='cvesddlCategory_popupTable']//td[text()='Please Select category']")
    public WebElement categoryValidationMsg;

    @FindBy(xpath = "//*[@id='InternalCntHolder_ddlSubcategory']")
    public WebElement subCategoryOfBusiness;

    @FindBy(xpath = "//*[@id='cesfvddlSubcategory_popupTable']//td[text()='Please Select category']")
    public WebElement subCategoryValidationMsg;

    @FindBy(xpath = "//*[@id='vceBusinessEmailID_popupTable']//td[text()='Please enter valid Emaiid']")
    public WebElement validEmailValidationMsg;

    @FindBy(xpath = "//*[@id='InternalCntHolder_txtPanName']")
    public WebElement nameOnPan;

    @FindBy(xpath = "//td[text()='Please enter name as on card']")
    public WebElement panNameValMsg;

    @FindBy(xpath = "//*[@id='InternalCntHolder_txtPanNumber']")
    public WebElement panNumber;

    @FindBy(name = "ctl00$InternalCntHolder$txtEmail")
    public WebElement businessEmailFilter;

    @FindBy(xpath = "//td[text()='Please enter pan number']")
    public WebElement panNumberValMsg;

    @FindBy(xpath = "//td[text()='Please enter valid pan number']")
    public WebElement validPanNumberValMsg;

    @FindBy(xpath = "//input[@id='txtpan']")
    public WebElement panImageUpload;

    @FindBy(xpath = "//*[@id='cvePAN_popupTable']//td[text()='Please select file']")
    public WebElement uploadPanImageValMsg;

    @FindBy(id = "ddlUploadBusiness")
    public WebElement selectBusinessDocument;

    @FindBy(xpath = "//*[@id='txtDoc']")
    public WebElement businessDocUpload;

    @FindBy(xpath = "//*[@id='InternalCntHolder_txtAddress']")
    public WebElement enterAddress;

    @FindBy(xpath = "//td[text()='Please enter address.']")
    public WebElement enterAddressValMsg;

    @FindBy(xpath = "//*[@id='InternalCntHolder_txtCity']")
    public WebElement enterCity;

    @FindBy(xpath = "//td[text()='Please enter city.']")
    public WebElement enterCityValMsg;

    @FindBy(id = "ddlState")
    public WebElement selectState;

    @FindBy(xpath = "//td[text()='Please select State.']")
    public WebElement stateValMsg;

    @FindBy(xpath = "//*[@id='InternalCntHolder_txtPinCode']")
    public WebElement enterPinCode;

    @FindBy(xpath = "//td[text()='Please enter pin code.']")
    public WebElement enterPinCodeValMsg;

    @FindBy(xpath = "//td[text()='Please enter pin code.']")
    public WebElement validPinCodeValMsg;

    @FindBy(id = "ddlUploadAddress")
    public WebElement selectAddressDoc;

    @FindBy(xpath = "//td[text()='Please select address document.']")
    public WebElement addressDocValMsg;

    @FindBy(xpath = "//*[@id='txtAddressDoc']")
    public WebElement addressDocUpload;

    @FindBy(xpath = "//*[@id='cveAddressDoc_popupTable']//td[text()='Please select file']")
    public WebElement addressDocUploadValMsg;

    @FindBy(name = "ctl00$InternalCntHolder$btnSubmit")
    public WebElement confirmButton;

    @FindBy(xpath = "//*[text()='Reports']")
    public WebElement reportsMenu;

    @FindBy(xpath = "//*[@id='Ulmenu']/li[4]/ul/li[8]/a")
    public WebElement settelementReports;

    @FindBy(xpath = "//*[text()='Settlements Report']")
    public WebElement settelementReportsTitle;

    @FindBy(xpath = "//*[@id='InternalCntHolder_gvCompany_lbtnSetting_0']")
    public WebElement configurationSettings;

    @FindBy(id = "InternalCntHolder_txtBRN")
    public WebElement bankRefNumberFilter;

    @FindBy(id = "InternalCntHolder_txtTransactionID")
    public WebElement transactionIDFilter;

    @FindBy(name = "ctl00$InternalCntHolder$btnFilter")
    public WebElement filterButtonAdmin;

    @FindBy(xpath = "//*[@id='InternalCntHolder_gvSettlement']/tbody/tr/td[14]")
    public WebElement bankStatusAdmin;

    @FindBy(xpath = "//*[@id='InternalCntHolder_gvSettlement']/tbody/tr/td[3]")
    public WebElement transactionIDAdmin;

    @FindBy(xpath = "//*[@class='dtr-data']")
    public WebElement getStatusIcon;

    @FindBy(xpath = "//*[@id='InternalCntHolder_gvSettlement']/tbody/tr/td[1]")
    public WebElement plusIcon;







    public pmxAdmin_POM(WebDriver driver) {
        driver = Hooks.driver;
        PageFactory.initElements(driver, this);
    }
}
