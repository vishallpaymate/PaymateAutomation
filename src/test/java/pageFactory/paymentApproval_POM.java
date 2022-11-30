package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import step_definitions.Hooks;

import java.util.List;

public class paymentApproval_POM {

    @FindBy(xpath = "//a[contains(text(),'Account Settings')]")
    public WebElement getAccountSettings;

    @FindBy(xpath = "//a[contains(text(),'Workflow Settings')]")
    public WebElement getWorkflowSettings;

    @FindBy(xpath = "//a[contains(text(),'User Settings')]")
    public WebElement getUserSettings;

    @FindBy(xpath = "//h1[contains(text(),'Payment Limits')]")
    public WebElement paymentLimitsText;

    @FindBy(xpath = "//span[contains(text(),'Start limit should be less then end limit.')]")
    public WebElement startLimitLessText;

    @FindBy(xpath = "//span[contains(text(),'End limit should be greater then start limit.')]")
    public WebElement endLimitGreaterText;

    @FindBy(xpath = "//*[contains(text(),'Start limit and end limit cannot be same.')]")
    public WebElement sameLimitValMsg;

    @FindBy(xpath = "//*[contains(text(),'Limits saved successfully.')]")
    public WebElement limitSavedValMsg;

    @FindBy(xpath = "//h1[contains(text(),'Manage Workflow')]")
    public WebElement manageWorkflowText;

    @FindBy(xpath = "//h1[contains(text(),'Contact Approval')]")
    public WebElement contactApprovalsText;

    @FindBy(xpath = "//*[text()='Design New Workflow']")
    public WebElement designWorkflowText;

    @FindBy(xpath = "//*[text()='Add New Limit']")
    public WebElement addnewLimitButton;

    @FindBy(xpath = "//*[@id='#accordion']/div[@aria-expanded='false']")
    public List<WebElement> designWorkflowSteps;

    @FindBy(xpath = "//a[text()='Design New Workflow']")
    public WebElement designWorkflowButton;

    @FindBy(xpath = "//label[text()='Select Payment Limit']")
    public WebElement selectPaymentLimitLabel;

    @FindBy(xpath = "//*[text()='keyboard_arrow_down']")
    public WebElement paymentLimitDownArrow;

    @FindBy(xpath = "//*[@id='ContentPlaceHolder1_ddlPaymentLimit_select']/li[3]")
    public WebElement selectPaymentLimit;

    @FindBy(xpath = "//*[@class='select2-selection__choice' and contains(text(),'maker')]")
    public WebElement selectMaker;

    @FindBy(id = "ContentPlaceHolder1_btnEditWorkFlow")
    public WebElement editWorkflow;

    @FindBy(xpath = "//*[@id='ui-id-8']//input[@class='select2-search__field']")
    public WebElement enterMaker;

    @FindBy(xpath = "//*[@id='ContentPlaceHolder1_divaddslab']//input[@class='select2-search__field']")
    public WebElement enterApprover;

    @FindBy(xpath = "//*[@id='ui-id-2']//span[@class='select2-selection__choice__remove']")
    public WebElement removeMaker;

    @FindBy(xpath = "//*[@id='ui-id-42']//span[@class='select2-selection__choice__remove']")
    public WebElement removePayer;

    @FindBy(xpath = "//*[text()='Please select makers to create workflow']")
    public WebElement makerValMsg;

    @FindBy(xpath = "//*[text()='Please add approver(s) level(s).']")
    public WebElement approverValMsg;

    @FindBy(xpath = "//*[text()='Level Added Successfully.']")
    public WebElement levelAddedValMsg;

    @FindBy(xpath = "//*[text()='Please enter minimum approver.']")
    public WebElement minimumApproverValMsg;

    @FindBy(xpath = "//*[text()='Please add payer to create workflow.']")
    public WebElement addPayerValmsg;

    @FindBy(xpath = "//*[@class='select2-selection__choice' and contains(text(),'payer')]")
    public WebElement selectPayer;

    @FindBy(xpath = "//*[text()='No Maker Needed']")
    public WebElement noMakerNeededLabel;

    @FindBy(xpath = "//*[text()='No Payer Needed']")
    public WebElement noPayerNeededLabel;

    @FindBy(xpath = "//*[@id='ui-id-24']//input[@value='Cancel']")
    public WebElement payerCancelButton;

    @FindBy(name = "ctl00$ContentPlaceHolder1$btnnext")
    public WebElement nextButtonMaker;

    @FindBy(name = "ctl00$ContentPlaceHolder1$btnApproversNext")
    public WebElement nextButtonApprover;

    @FindBy(xpath = "//*[@id='ui-id-1' and @aria-expanded='true']")
    public WebElement makerTab;

    @FindBy(xpath = "//*[text()='Step 3: Select Payers' and @aria-expanded='true']")
    public WebElement payerTab;

    @FindBy(name = "ctl00$ContentPlaceHolder1$BtnWorkflowsave")
    public WebElement saveWorkflowButton;

    @FindBy(name = "ctl00$ContentPlaceHolder1$btnCancel")
    public WebElement cancelWorkflowButton;

    @FindBy(xpath = "//*[text()='Step 2: Select Approvers' and @aria-expanded='true']")
    public WebElement approverTab;

    @FindBy(name = "ctl00$ContentPlaceHolder1$ucddlApprovers$ddlMultiSelect")
    public WebElement selectApprover;

    @FindBy(name = "ctl00$ContentPlaceHolder1$txtApproverCount")
    public WebElement minimumApprover;

    @FindBy(name = "ctl00$ContentPlaceHolder1$btnAddLevel")
    public WebElement addLevelButton;

    @FindBy(xpath = "//*[text()='Level Added Successfully.']")
    public WebElement levelAddedSuccessfulymsg;

    @FindBy(xpath = "//*[text()='Workflow saved successfully.']")
    public WebElement workflowAddedSuccessfulymsg;

    @FindBy(id = "btnBack")
    public WebElement backButton;

    @FindBy(xpath = "//*[text()='edit']")
    public WebElement editButtonApprover;

    @FindBy(xpath = "//*[text()='delete']")
    public WebElement deleteButtonApprover;

//    @FindBy(xpath = "//*[@class='select2-selection__choice']")
//    public WebElement selectMaker;

    @FindBy(name = "ctl00$ContentPlaceHolder1$btnCancel")
    public WebElement deisgnWorklfowCancelButton;

    @FindBy(xpath = "//*[@id='ui-id-3' and @aria-selected='true']")
    public WebElement manageLimitExpanded;

    @FindBy(xpath = "//*[@id='ui-id-1' and @aria-selected='true']")
    public WebElement setLimitExpanded;

    @FindBy(xpath = "//*[@id='ui-id-1']")
    public WebElement setLimit;

    @FindBy(id = "ContentPlaceHolder1_gvManageLimits_lbtnEdit_1")
    public WebElement editLimitButton;

    @FindBy(name = "ctl00$ContentPlaceHolder1$txtLimitName")
    public WebElement limitName;

    @FindBy(name = "ctl00$ContentPlaceHolder1$txtStartLimit")
    public WebElement startLimit;

    @FindBy(name = "ctl00$ContentPlaceHolder1$txtEndLimit")
    public WebElement endLimit;

    @FindBy(xpath = "//*[@class='col-xs-12 col-sm-6']//input")
    public List<WebElement> setLimitFields;

    @FindBy(xpath = "//span[contains(text(),'Please enter valid limit Name')]")
    public WebElement limitNameValidation;

    @FindBy(xpath = "//span[contains(text(),'Please enter Start Limit.')]")
    public WebElement startLimitValidation;

    @FindBy(xpath = "//*[contains(text(),'Limit within start limit and end limit range already defined.')]")
    public WebElement limitAlreadyValMsg;

    @FindBy(xpath = "//*[contains(text(),'Limit name already defined.')]")
    public WebElement limitNameAlreadyMsg;

    @FindBy(xpath = "//span[contains(text(),'Please enter End Limit.')]")
    public WebElement endLimitValidation;

    @FindBy(xpath = "//*[contains(text(),'Limit Name')]")
    public WebElement limitNameLabel;

    @FindBy(xpath = "//*[@id='ui-id-2']//div[2]//label")
    public WebElement startLimitLabel;

    @FindBy(xpath = "//label[contains(text(),'End Limit')]")
    public WebElement endLimitLabel;

    @FindBy(name = "ctl00$ContentPlaceHolder1$btnAddAnother")
    public WebElement addAnotherButton;

    @FindBy(name = "ctl00$ContentPlaceHolder1$btndirectConfirm")
    public WebElement continueButton;

    @FindBy(name = "ctl00$ContentPlaceHolder1$btncancelup")
    public WebElement cancelButton;

    @FindBy(xpath = "//*[@id='Ulmenu']/li[10]/ul/li[4]//li[@class='']")
    public List<WebElement> getWorkflowMenus;

    @FindBy(xpath = "//*[@id='Ulmenu']/li[8]/ul/li[3]//li/a")
    public List<WebElement> getUserSettingsMenus;

    @FindBy(xpath = "//*[@class='col-lg-12 col-md-12 col-sm-12 col-xs-12 text-right']/input")
    public List<WebElement> setLimitButtons;

    @FindBy(xpath = "//*[text()='Add User']")
    public WebElement addUser;

    @FindBy(name = "ctl00$ContentPlaceHolder1$btnSave")
    public WebElement saveButtonAddUser;

    @FindBy(id = "txtFirstName")
    public WebElement firstNameAddUser;

    @FindBy(id = "ContentPlaceHolder1_txtLastName")
    public WebElement lastNameAdduser;

    @FindBy(id = "ContentPlaceHolder1_txtEmail")
    public WebElement emailAddUser;

    @FindBy(id = "ddlRole_select")
    public WebElement roleSelectAddUser;

    @FindBy(xpath = "//div[@class='alert-strip success-alert']")
    public WebElement userSavedValMsg;

    @FindBy(xpath = "//ul[@id='ddlRole_select']/li")
    public List<WebElement> selectUserRole;

    @FindBy(xpath = "//*[text()='Design Workflow']")
    public WebElement designWorkflowHeading;

    @FindBy(xpath = "//*[text()='Makers']")
    public WebElement makerHeading;

    @FindBy(xpath = "//*[text()='Select Makers & Approvers to create a Contact Addition Approval Workflow']")
    public WebElement contactApprovalText;

    @FindBy(xpath = "//*[text()='Select makers who can add or edit contact.']")
    public WebElement makerText;

    @FindBy(xpath = "//*[text()='No Maker Needed (Select this option if you are integrated with PayMate for Contact management)']")
    public WebElement noMakerText;

    @FindBy(css = ".dvMaker")
    public WebElement makerDropdown;

    @FindBy(xpath = "//*[text()='Approvers']")
    public WebElement approverHeading;

    @FindBy(xpath = "//*[text()='Select Approvers who will approve Contact when it is added or updated']")
    public WebElement approverText;

    @FindBy(id = "ContentPlaceHolder1_txtApproverCount")
    public WebElement minimumApproverContactWorklfow;

    @FindBy(name = "ctl00$ContentPlaceHolder1$ucddlApprovers$ddlMultiSelect")
    public WebElement approverDropdown;

    @FindBy(name = "ctl00$ContentPlaceHolder1$BtnWorkflowsave")
    public WebElement saveWorkflowContactApproval;

    @FindBy(name = "ctl00$ContentPlaceHolder1$btnCancel")
    public WebElement clearButtonContactApproval;

    @FindBy(xpath = "//*[@id='ContentPlaceHolder1_divMakers']//span[@class='select2-selection__choice__remove']")
    public WebElement removeMakerContactApproval;

    @FindBy(xpath = "//*[text()='Please add maker to create workflow.']")
    public WebElement addMakerValmsgContactApprovaL;

    @FindBy(xpath = "//*[@id='ContentPlaceHolder1_divMakers']//input[@class='select2-search__field']")
    public WebElement enterMakerContactApproval;

    @FindBy(xpath = "//*[text()='Please add approver to create workflow.']")
    public WebElement addApproverValmsgContactApprovaL;

    @FindBy(xpath = "//*[@id='ContentPlaceHolder1_divaddslab']//input[@class='select2-search__field']")
    public WebElement enterApproverContactApproval;

    @FindBy(xpath = "//*[text()='Please enter minimum approver']")
    public WebElement minimumApproverValMsgContactApproval;

    @FindBy(xpath = "//*[text()='Workflow saved successfully.']")
    public WebElement workflowSavedValMsgContactApproval;

    @FindBy(xpath = "//*[text()='Workflow deleted successfully']")
    public WebElement workflowDeletedValMsgContactApproval;

    @FindBy(name = "ctl00$ContentPlaceHolder1$btnEditWorkFlow")
    public WebElement editWorkflowContactApproval;

    @FindBy(name = "ctl00$ContentPlaceHolder1$BtnDeleteWorkflow")
    public WebElement deleteWorkflowContactApproval;

    @FindBy(xpath = "//a[text()='Set Password']")
    public WebElement setPasswordButton;





    public paymentApproval_POM(WebDriver driver) {
        driver = Hooks.driver;
        PageFactory.initElements(driver, this);
    }
}


