package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import step_definitions.Hooks;

import java.util.List;

public class addContact_POM {
    @FindBy(xpath = "//*[text()='Contacts']")
    public WebElement getContactLink;

    @FindBy(xpath = "//*[contains(text(),'Bulk Upload Contacts')]")
    public WebElement getBulkUploadContactLink;

    @FindBy(xpath = "//*[contains(text(),'Add Contact')]")
    public WebElement getAddContactLink;

    @FindBy(className= "sidebar-toggle")
    public WebElement dashBoardMenu;

    @FindBy(xpath= "//*[text()='Reports']")
    public WebElement reportsMenu;

    @FindBy(xpath= "//*[@class='sidebar-toggle']")
    public WebElement getDashBoardMenu;

    @FindBy(xpath= "//*[@class='fa fa-bars material-icons']")
    public WebElement getDashBoardMenus;

    @FindBy(xpath = "//*[contains(text(),'Manage Contacts')]")
    public WebElement getManageContactLink;

    @FindBy(xpath = "//*[@id='Ulmenu']/li/ul/li")
    public List<WebElement> getAllLinkAddContact;

//    @FindBy(xpath = "//*[@class='page-title col-xs-12']/h1")
//    public WebElement getPageTitle;

    @FindBy(xpath = "//*[@id='PnlMain']//h1")
    public WebElement getPageTitle;

//Bulk Upload contact page

    @FindBy(xpath = "//*[@name='ctl00$ContentPlaceHolder1$fupContacts']")
    public WebElement getChooseFile;

    @FindBy(xpath = "/html/body/table/tbody/tr[2]/td/table/tbody/tr/td/p/a[1]")
    public WebElement signUpButtonEmail;

    @FindBy(xpath = "/html/body/table/tbody/tr[2]/td/table/tbody/tr/td/p/a[1]")
    public List<WebElement> signUpButtonEmailList;

    @FindBy(xpath = "/html/body/center/div/table/tbody/tr[2]/td/a")
    public WebElement signupUpButtonEmailHdfc;

    @FindBy(xpath = "//i[contains(text(),'cloud_upload')]")
    public WebElement getCloudUpload;

    @FindBy(xpath = "//input[@id='file_info']")
    public WebElement getUploadFileLabel;

    @FindBy(xpath = "//*[@id='cbIsKycRequired']")
    public WebElement getKycRequiredCheckBox;

    @FindBy(xpath = "//*[contains(text(),'KYC Required')]")
    public WebElement getKycRequiredText;

    @FindBy(xpath = "//*[@href='../Templates/ContactBulkUploadTemplate.xls']")
    public WebElement getTemplate;

    @FindBy(xpath = "//a[contains(text(),'Click here to view sample')]")
    public WebElement getSample;

    @FindBy(xpath = "//span[@class='mdl-textfield__message']")
    public WebElement getGuidanceText;

    @FindBy(xpath = "//*[@name='ctl00$ContentPlaceHolder1$btnUploadFile']")
    public WebElement getContinueButton;

    @FindBy(xpath = "//*[@name='ctl00$ContentPlaceHolder1$btnCancel']")
    public WebElement getCancelButton;

    @FindBy(xpath = "//*[@name='ctl00$ContentPlaceHolder1$btnSave']")
    public WebElement getAddContactSaveButton;

    @FindBy(xpath = "//*[@class='col-xs-12 col-sm-6' and not(contains(@style,'display:none'))]")
    public List<WebElement> getAllinput_AddContact;

    @FindBy(xpath = "//*[@class='toggle-card']/span")
    public WebElement getFilterText;

    @FindBy(xpath = "//*[@class='card'][1]")
    public WebElement getFliterClick;

    @FindBy(xpath = "//*[@class='mdl-textfield mdl-js-textfield mdl-textfield--floating-label is-upgraded']")
    public List<WebElement> getfilterInput;

    @FindBy(xpath = "//*[@class='mdl-textfield mdl-js-textfield mdl-textfield--floating-label is-upgraded']/label")
    public List<WebElement> getFilterInput_label;

    @FindBy(xpath = "//*[@class='col-xs-12 text-right']/input")
    public List<WebElement> getFilterButtons;

    @FindBy(xpath = "//*[@class='grvCarddisplay table-bordered griditem dataTable no-footer dtr-inline']/thead/tr/th")
    public List<WebElement> getTablerRow;

    //No contact added in manage contacts page
//    @FindBy(xpath = "//*[@class='sorting_1']")
//    public WebElement getNoContacttxt;

    @FindBy(xpath = "//*[@id='ContentPlaceHolder1_gvContacts']/tbody/tr/td[1]")
    public WebElement addContactToProceed;

    @FindBy(xpath = "//b[contains(text(),'Sample format for Contact upload')]")
    public WebElement getSampleFormartText;

    @FindBy(xpath = "//*[@class='cf']/tr/th")
    public List<WebElement> getConatctUploadFormatTableHeading;

    @FindBy(xpath = "//b[contains(text(),'Note -')]")
    public WebElement getNotText;

    @FindBy(xpath = "//input[@value='close']")
    public WebElement getCloseButton;

    @FindBy(xpath = "//*[text()='Click here to view sample']")
    public WebElement getViewSampleWindow;

    @FindBy(xpath = "//div[@class='modal-content card']//button[@type='button'][contains(text(),'×')]")
    public WebElement getCrossIcon;


    @FindBy(xpath = "//*[@href='../Templates/ContactBulkUploadTemplate.xlsx']")
    public WebElement getDownloadFileLink;

    @FindBy(name = "ctl00$ContentPlaceHolder1$fupContacts")
    public WebElement getFileUpoadField;

    @FindBy(xpath = "//*[text()='Uploaded Contacts']")
    public WebElement getUploadedContact;

    @FindBy(xpath = "//*[@class='mdl-textfield']/p")
    public WebElement getInfoText;

    @FindBy(xpath = "//*[@id='ContentPlaceHolder1_gvContacts']/thead/tr/th")
    public List<WebElement> getBulkUploadTableHeading;

    @FindBy(xpath = "//*[@id='ContentPlaceHolder1_btnConfirm']")
    public WebElement getConfirmButton;

    @FindBy(id = "ContentPlaceHolder1_btnCancelConfirm")
    public WebElement getCancelButtonOnBulkData;

    @FindBy(xpath = "//*[@id='ContentPlaceHolder1_gvContacts']/tbody/tr/td")
    public List<WebElement> getUploadedTableData;

    @FindBy(css = "#cbIsKycRequired")
    public WebElement getIsKycCheckBox;

    @FindBy(xpath = "//select[@name='ContentPlaceHolder1_gvContacts_length']")
    public WebElement getShowDropdown;

    @FindBy(xpath = "//select[@name='ContentPlaceHolder1_gvContacts_length']/option")
    public List<WebElement> getDropDownValues;

    @FindBy(xpath = "//*[starts-with(@id,'ContentPlaceHolder1_gvContacts_lnkUploadDocument')]")
    public List<WebElement> getUploadDocumenticon;

    @FindBy(xpath = "//*[starts-with(@id,'ContentPlaceHolder1_gvContacts_lnkViewDocument')]")
    public List<WebElement> getViewDocumentsIcon;


    @FindBy(xpath = "//form[@id='form1']//tr//td[7]")
    public List<WebElement> getKycStatusStr;

    @FindBy(css = "#ContentPlaceHolder1_txtCompanyName")
    public WebElement getCompanyName;

    @FindBy(xpath = "//*[@name='ctl00$ContentPlaceHolder1$txtFirstName']")
    public WebElement getFirstName;

    @FindBy(xpath = "//*[@name='ctl00$ContentPlaceHolder1$txtLastName']")
    public WebElement getLastName;

    @FindBy(xpath = "//*[@name='ctl00$ContentPlaceHolder1$txtEmail']")
    public WebElement getEmail;

    @FindBy(xpath = "//*[@name='ctl00$ContentPlaceHolder1$txtNickName']")
    public WebElement getNickName;

    @FindBy(xpath = "//*[@name='ctl00$ContentPlaceHolder1$txtMobileNo']")
    public WebElement getMobileNumber;

    @FindBy(xpath = "//*[@name='ctl00$ContentPlaceHolder1$txtReferenceCode']")
    public WebElement getReferenceCode;

    @FindBy(xpath = "//*[@name='ctl00$ContentPlaceHolder1$txtCompanyAddress']")
    public WebElement getCompanyAddress;

    @FindBy(xpath = "//*[@name='ctl00$ContentPlaceHolder1$txtBankAccountNo']")
    public WebElement getBankAccountNumber;

    @FindBy(xpath = "//*[@name='ctl00$ContentPlaceHolder1$txtIFSCode']")
    public WebElement getIfscCode;

    @FindBy(xpath = "//*[@name='ctl00$ContentPlaceHolder1$txtGSTIN']")
    public WebElement getGSTINNumber;

    @FindBy(xpath = "//*[contains(@class,'mdl-textfield__input') and not(contains(@style,'display: none'))]")
    public List<WebElement> getAddContactFields;

    @FindBy(xpath = "//*[@class='toggle-card']")
    public WebElement getFilterClick;

    @FindBy(css = ".dropdown-toggle-split")
    public WebElement actionDropdown;

    @FindBy(css = ".btnView")
    public WebElement viewAction;

    @FindBy(id = "ContentPlaceHolder1_gvContacts_btnGenerateVan_0")
    public WebElement generateVan;

    @FindBy(xpath = "//div[@class='alert-strip success-alert']")
    public WebElement generateVanValMsg;

    @FindBy(xpath = "//input[@id='ContentPlaceHolder1_txtDateRange']")
    public WebElement getDateRange;

    @FindBy(xpath = "//button[text()='Apply']")
    public WebElement getApplyButton;

    @FindBy(xpath = "//input[@id='ContentPlaceHolder1_btnFilter']")
    public WebElement getFilterButton;

    @FindBy(name = "ctl00$ContentPlaceHolder1$btnFilter")
    public WebElement filterButton;

    @FindBy(xpath = "//*[@id='ContentPlaceHolder1_gvContacts']/tbody/tr/td[1]")
    public List<WebElement> getCompanyNameList;

    @FindBy(xpath = "//*[@role='row']/td[2]")
    public List<WebElement> getManageCompanyName;

    @FindBy(xpath = "//*[starts-with(@id,'ContentPlaceHolder1_gvContacts_lnkUploadDocument_')]")
    public List<WebElement> getGetUploadDocumenticon;

    @FindBy(xpath = "//*[starts-with(@id,'ContentPlaceHolder1_gvContacts_Label1_')]")
    public List<WebElement> getKycStatus;

    @FindBy(xpath = "//*[starts-with(@id,'ContentPlaceHolder1_gvContacts_lnkViewDocument_')]")
    public List<WebElement> getViewKycIcon;

    @FindBy(xpath = "//*[@class='mdl-textfield mdl-js-textfield mdl-textfield--floating-label is-upgraded']")
    public List<WebElement> getFilterInputField;

    @FindBy(xpath = "//*[contains(@id,'ContentPlaceHolder1_')]")
    public List<WebElement> getButtons;

    @FindBy(id = "ContentPlaceHolder1_txtDateRange")
    public WebElement getDateRangePicker;

    @FindBy(name = "ctl00$ContentPlaceHolder1$btnCancel")
    public WebElement getClearbutton;

    @FindBy(name = "ctl00$ContentPlaceHolder1$btnExport")
    public WebElement getExportButton;

    @FindBy(xpath = "//*[@name='ContentPlaceHolder1_gvContacts_length']")
    public WebElement getDropDownClick;

    @FindBy(xpath = "//*[@name='ContentPlaceHolder1_gvContacts_length']/option")
    public List<WebElement> getDropDownOptions;

    @FindBy(xpath = "//*[@id='ContentPlaceHolder1_gvContacts']/thead/tr/th")
    public List<WebElement> getManageContactTableHeading;

    @FindBy(xpath = "//*[@name='ctl00$ContentPlaceHolder1$txtName']")
    public WebElement getFilterEmailID;

    @FindBy(xpath = "//a[contains(text(),'Next')]")
    public WebElement getNextButton;

    @FindBy(id = "txtCompanyName")
    public WebElement getCompanyNameTextBox;

    @FindBy(name = "ctl00$ContentPlaceHolder1$txtCompanyCode")
    public WebElement getCompanyCode;

    @FindBy(xpath = "//a[@class='btnEdit']")
    public List<WebElement> getEditButton;

    @FindBy(xpath = "//*[@id='ContentPlaceHolder1_gvContacts']/tbody/tr/td[2]")
    public List<WebElement> getCompnayName;

    @FindBy(id = "txtMobileNo")
    public WebElement getMobileNumbeText;

    @FindBy(xpath = "//*[@id='ContentPlaceHolder1_gvContacts']/tbody/tr/td[3]")
    public List<WebElement> getMobileNumberList;

    @FindBy(xpath = "//td[@class='sorting_1']")
    public WebElement guidanceText;

    @FindBy(xpath = "//input[@id='ContentPlaceHolder1_txtDateRange']")
    public WebElement getCalenderClick;

    @FindBy(xpath = "//*[@id='ContentPlaceHolder1_gvContacts']/tbody/tr[1]/td[8]/a[1]/i")
    public WebElement getEditFromTableButton;

    @FindBy(xpath = "//*[contains(@id,'ContentPlaceHolder1_gvContacts_lblReject_')]/i")
    public WebElement getDeleteIcon;

    @FindBy(xpath = "//*[contains(@id,'ContentPlaceHolder1_gvContacts_lnkViewDocument_')]/i")
    public WebElement getViewIcon;

    @FindBy(xpath = "//*[contains(@id,'ContentPlaceHolder1_gvContacts_btnEmail_')]/i ")
    public WebElement getSendEmail;

    @FindBy(xpath = "//*[contains(@id,'ContentPlaceHolder1_gvContacts_lnkUploadDocument_')]/i ")
    public WebElement getUploadDocumentIcon;

    @FindBy(xpath = "//h1[contains(text(),'Contact Details')]")
    public WebElement getContactDetailsPage;

    @FindBy(css = "#ui-id-1")
    public WebElement getBasicDetails;

    @FindBy(css = "#ui-id-3")
    public WebElement getVanDetails;

    @FindBy(css = "#ui-id-5")
    public WebElement getReceiverDetails;

    @FindBy(xpath = "//*[@aria-selected='true']")
    public WebElement getHeaderExpand;

    @FindBy(css = "#ContentPlaceHolder1_h1")
    public WebElement getRemoveContactPlaceHolder;

    @FindBy(xpath = "//*[@id='ContentPlaceHolder1_gvContacts']/tbody/tr/td[2]")
    public WebElement getCompanyNameManageContact;

    @FindBy(xpath = "//*[@id='dvRejectReasonUpdate']/div/div/div[2]/div/div/label")
    public WebElement getRemoveContactText;

    @FindBy(css = "#ContentPlaceHolder1_btnRejectionReasonSave")
    public WebElement getDeleteButton;

    @FindBy(css = "#ContentPlaceHolder1_btnRejectionReasonCancel")
    public WebElement getCancelButtonFromDelete;

    @FindBy(xpath = "//h1[contains(text(),'KYC Documents')]")
    public WebElement getKycPageText;

    @FindBy(css = "#ContentPlaceHolder1_lblContactName")
    public WebElement getCompnayNameFromKyc;

    @FindBy(xpath = "//*[@id='ContentPlaceHolder1_gvContacts']/tbody/tr/td[8]/a[1]/i")
    public WebElement getEditButtonFr;

    @FindBy(xpath = "//i[@id='ContentPlaceHolder1_spnQBEdit']")
    public WebElement getBasicEditIcon;

    @FindBy(css = "#ContentPlaceHolder1_cvcontactEmail")
    public WebElement getinvalidEmailValidationMsg;

    @FindBy(xpath = "//div[@class='alert-strip success-alert']")
    public WebElement getValidationMsg;

    @FindBy(xpath = "//div[@class='alert-strip strip-hidden']")
    public WebElement getInvalidValidationMsg;
    @FindBy(css = "#txtCompanyName")
    public WebElement getEditCompanyName;

    @FindBy(css = "#ContentPlaceHolder1_cveditcompanyName")
    public WebElement getCOmpnayNameInvalidMsg;

    @FindBy(css = "#txtFirstName")
    public WebElement getEditFirstName;

    @FindBy(css = "#ContentPlaceHolder1_vcContactFirstName")
    public WebElement getFirestNamevalidationMsg;

    @FindBy(css = "#txtLastName")
    public WebElement getEditLastName;

    @FindBy(css = "#txtNickName")
    public WebElement getEditNickName;

    @FindBy(css = "#ContentPlaceHolder1_cvcontactnickname")
    public WebElement getNickNameMsg;

    @FindBy(css = "#txtMobileNo")
    public WebElement getEditMobileNumber;

    @FindBy(css = "#ContentPlaceHolder1_cvcontactMobileNo")
    public WebElement getMobileNumberMsg;

    @FindBy(css = "#txtGSTIN")
    public WebElement getGstinNumberEdit;

    @FindBy(css = ".tag-remove")
    public WebElement getNotificationDetailsRemove;

    @FindBy(css = ".tag-remove")
    public List<WebElement> getNotificationDetailsRemoveList;

    @FindBy(css = "#ContentPlaceHolder1_txtCcEmailAddress_tag")
    public WebElement getNotificationDetailsEdit;

    @FindBy(css = ".validfail")
    public WebElement getNotificationDetailsMsg;

    @FindBy(css = "#ContentPlaceHolder1_cvGSTIN")
    public WebElement getGstinMsg;

    @FindBy(xpath = "//*[@id='ContentPlaceHolder1_gvContacts']/tbody/tr/td[8]/a[1]/i")
    public List<WebElement> getListEditButton;

    @FindBy(xpath = "//*[contains(@id,'ContentPlaceHolder1_gvContacts_btnEmail_')]/i")
    public List<WebElement> getListSendEmail;

    @FindBy(id = "txtEmail")
    public WebElement getEmailEdit;

    @FindBy(id = "ContentPlaceHolder1_txtReferenceCode")
    public WebElement getCompanyCodeEdit;

    @FindBy(id = "ContentPlaceHolder1_btnSave")
    public WebElement getSaveButtonEdit;

    @FindBy(xpath = "//div[@class='alert-strip error-alert']")
    public WebElement getStripMsg;

    @FindBy(id = "txtCompanyName")
    public WebElement getCompnayNameEdit;

    @FindBy(xpath = "//*[contains(@name,'ctl00$ContentPlaceHolder1$txt')]")
    public List<WebElement> getCheckFieldsEditable;

    @FindBy(xpath = "//div[@class='alert-strip success-alert']")
    public WebElement getSuccesssStripMsg;

    @FindBy(xpath = "//*[contains(@id,'ui-id') and text()='VAN Details']")
    public WebElement getVanDetailsTabClick;

    @FindBy(xpath = "//*[@id='Table1']/thead/tr/th")
    public List<WebElement> getVanDetailsTableHeading;

    @FindBy(css = "#ContentPlaceHolder1_lblXpressIdS")
    public WebElement getVanNumberFromVanDetailsTab;

    @FindBy(css = "#lblVANno")
    public WebElement getVanNumberNotCreated;

    @FindBy(css = "#ContentPlaceHolder1_lblSenderStatus")
    public WebElement getStatusIs;

    @FindBy(xpath = "//*[@id='ContentPlaceHolder1_pnlDeleteSender']/a")
    public WebElement getDeleteIconText;

    @FindBy(xpath = "//a[contains(@id,'ContentPlaceHolder1_')]")
    public List<WebElement> getVanNumberGenarate;

    @FindBy(css = "#ContentPlaceHolder1_lbtnRegister")
    public WebElement getGenrateVanNumberLink;

    @FindBy(css = "#txtCompanyName")
    public WebElement getCompayName;

    @FindBy(xpath = "//div[@class='inline-element']")
    public WebElement getValidationmsg;

    @FindBy(css = "#txtEmail")
    public WebElement getEmailid;

    @FindBy(css = "#ContentPlaceHolder1_lbtnDetails")
    public WebElement getViewTab;

    @FindBy(xpath = "//*[@id='ContentPlaceHolder1_pnlDeleteSender']/a[1]/i")
    public WebElement getGetDeleteIcon;

    @FindBy(xpath = "//*[@id='dvModelConfirm']/div/div/div[3]/a")
    public List<WebElement> getCOnfirmCancelButton;

    @FindBy(css = "#ContentPlaceHolder1_lblSenderStatus")
    public WebElement getView;

    @FindBy(xpath = "//*[@id='ContentPlaceHolder1_pnlDeactivateSender']/a[1]/i")
    public WebElement getDeactiveIcon;

    @FindBy(xpath = "//p[@class='confirmText']")
    public WebElement getConfirmText;

    @FindBy(xpath = "//*[contains(text(),'Confirm')]")
    public WebElement getConfirmButn;

    @FindBy(xpath = "//*[contains(text(),'Cancel')]")
    public WebElement getCancel;

    @FindBy(xpath = "//*[@id='ContentPlaceHolder1_pnlActivateSender']/a[1]/i")
    public WebElement getActivestatus;

    @FindBy(xpath = "//*[@id='ContentPlaceHolder1_pnlDeactivateSender']/a[1]/i")
    public WebElement getDeActiveStatus;

    @FindBy(xpath = "//*[@id='ContentPlaceHolder1_pnlActivateSender']/a[1]/i")
    public WebElement getActiveThisSender;

    @FindBy(xpath = "//*[contains(text(),'email')]")
    public WebElement getResendConatct;

    @FindBy(xpath = "//*[@id='example']/thead/tr/th")
    public List<WebElement> getReceivedDetailsTabData;

    @FindBy(xpath = "//*[@id='ContentPlaceHolder1_pnlDeactivateReceiver']/a")
    public WebElement getdeactiveReceiver;

    @FindBy(xpath = "//*[@id='ContentPlaceHolder1_pnlActivateReceiver']/a")
    public WebElement getActiveReceiver;

    @FindBy(xpath = "//*[@id='ContentPlaceHolder1_lblReceiverStatus']")
    public WebElement getReceiveddetailsStatus;

    @FindBy(xpath = "//*[@id='dvModelConfirm']/div/div/div[3]/a[1]/span")
    public  WebElement getConfirmbutton;

    @FindBy(xpath = "//*[@id='ContentPlaceHolder1_pnlActivateReceiver']/a[1]/i")
    public WebElement getActiveReceiverDetails;

    @FindBy(xpath = "//*[@id='ContentPlaceHolder1_pnlEditReceiver']/a/i")
    public WebElement getEdit;

    @FindBy(name ="ctl00$ContentPlaceHolder1$txtBankAccountNo")
    public WebElement getAccountNumber;

    @FindBy(css = "#txtIFSCode")
    public WebElement getIfsc;

    @FindBy(className = "btn-success")
    public WebElement getSavebutton;

    @FindBy(id = "btnSaveAccdetails")
    public List<WebElement> getSavebuttonList;

    @FindBy(xpath = "//*[@class='txtBankAccountNo mdl-textfield__error']")
    public WebElement getAcNoErrorMsg;

    @FindBy(xpath = "//*[@class='cvcontactIFSC mdl-textfield__error']")
    public WebElement getIfscCodeErrorMsg;

    public addContact_POM(WebDriver driver) {
        driver = Hooks.driver;
        PageFactory.initElements(driver, this);
    }
}
