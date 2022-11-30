package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import step_definitions.Hooks;

import java.util.List;

public class invoice_POM {

    @FindBy(xpath = "//*[text()='Invoicing']")
    public WebElement invoicingLink;

    @FindBy(xpath = "//*[text()='Track Invoices']")
    public WebElement trackInvoicesLink;

    @FindBy(xpath = "//*[text()='Send Invoices']")
    public WebElement sendInvoicesLink;

    @FindBy(xpath = "//*[@id='Ulmenu']/li[5]/ul/li[3]/a")
    public WebElement invoiceSettingsLink;

    @FindBy(xpath = "//*[text()='Customize Invoices']")
    public WebElement customizeInvoicesLink;

    @FindBy(xpath = "//h1[text()='Send Invoices']")
    public WebElement sendInvoicesTitle;

    @FindBy(xpath = "//h1[text()='Track Invoices']")
    public WebElement trackInvoicesTitle;

    @FindBy(xpath = "//h1[text()='CUSTOMIZE INVOICE']")
    public WebElement customizeInvoicesTitle;

//    @FindBy(xpath = "//*[@id='Ulmenu']/li[5]//ul//li")
//    public List<WebElement> invoicingLinks;

    @FindBy(xpath = "//*[@class='sub-menu toggled']/ul/li")
    public List<WebElement> invoicingLinks;

    @FindBy(name = "ctl00$ContentPlaceHolder1$ucPO$txtPONo")
    public WebElement purchaseOrderNumber;

    @FindBy(xpath = "//*[text()='Purchase Order Number ']")
    public WebElement purchaseOrderNumberLabel;

    @FindBy(id = "txtInvoiceNo")
    public WebElement invoiceNumber;

    @FindBy(xpath = "//*[text()='Invoice Number ']")
    public WebElement invoiceNumberLabel;

    @FindBy(id = "txtPODate")
    public WebElement issueDate;

    @FindBy(xpath = "//*[text()='Issue Date  ']")
    public WebElement issueDateLabel;

    @FindBy(id = "txtPODeliverDate")
    public WebElement paymentDueDate;

    @FindBy(xpath = "//*[text()='Payment Due Date  ']")
    public WebElement paymentDueDateLabel;

    @FindBy(xpath = "//label[text()='Payment Terms']")
    public WebElement paymentTermsLabel;

    @FindBy(id = "ContentPlaceHolder1_ucPO_ddlDefaultPaymentTerms_select")
    public WebElement paymentTerms;

    @FindBy(xpath = "//*[text()='VENDOR ADDRESS']")
    public WebElement vendorAddressLabel;

    @FindBy(id = "txtBAFirstName")
    public WebElement firstName;

    @FindBy(xpath = "//label[text()='First Name']")
    public WebElement firstNameLabel;

    @FindBy(id = "txtBAFirstName")
    public WebElement lastName;

    @FindBy(xpath = "//label[text()='Last Name']")
    public WebElement lastNameLabel;

    @FindBy(id = "ContentPlaceHolder1_ucPO_SearchContact_txtSearchContact")
    public WebElement vendorCompanyName;

    @FindBy(xpath = "//*[text()='Enter Contact Name or Company Name ']")
    public WebElement vendorCompanyNameLabel;

    @FindBy(id = "txtBACompanyName")
    public WebElement baCompanyName;

    @FindBy(xpath = "//*[@id='dvAddressDetails']//div[3]/div/label[text()='Company Name']")
    public WebElement baCompanyNameLabel;

    @FindBy(xpath = "//*[text()='Deliver date should not be empty.']")
    public WebElement deliverDateValMsg;

    @FindBy(xpath = "//*[text()='SHIPPING ADDRESS']")
    public WebElement shippingAddressLabel;

    @FindBy(id = "txtSACompanyName")
    public WebElement saCompanyName;

    @FindBy(xpath = "//*[@id='dvAddressDetails']/div[3]//div/label[text()='Company Name']")
    public WebElement saCompanyNameLabel;

    @FindBy(id = "txtBAEmail")
    public WebElement baEmail;

    @FindBy(id = "txtSAEmail")
    public WebElement saEmail;

    @FindBy(xpath = "//*[@id='dvAddressDetails']//div[4]//label[text()='Email']")
    public WebElement baEmailLabel;

    @FindBy(xpath = "//*[@id='dvAddressDetails']/div[3]//label[text()='Email']")
    public WebElement saEmailLabel;

    @FindBy(id = "txtSAPhone")
    public WebElement saPhoneNumber;

    @FindBy(xpath = "//*[@id='dvAddressDetails']/div[3]//label[text()='Phone Number']")
    public WebElement saPhoneLabel;

    @FindBy(id = "txtVAPhone")
    public WebElement vendorPhoneNumber;

    @FindBy(xpath = "//*[@id='dvAddressDetails']/div[2]//label[text()='Phone Number']")
    public WebElement vendorPhoneLabel;

    @FindBy(id = "txtBAAddress")
    public WebElement baAddress;

    @FindBy(xpath = "//*[@id='dvAddressDetails']/div[1]//label[text()='Address']")
    public WebElement baAddressLabel;

    @FindBy(id = "txtVAAddress")
    public WebElement vendorAddress;

    @FindBy(xpath = "//*[@id='dvAddressDetails']/div[2]//label[text()='Address']")
    public WebElement vaAddressFieldLabel;

    @FindBy(id = "txtSAAddress")
    public WebElement shippingAddress;

    @FindBy(xpath = "//*[@id='dvAddressDetails']/div[3]//label[text()='Address']")
    public WebElement saAddressFieldLabel;

    @FindBy(id = "txtBACity")
    public WebElement baCity;

    @FindBy(xpath = "//*[@id='dvAddressDetails']/div[1]//div/label[text()='City']")
    public WebElement baCityLabel;

    @FindBy(id = "txtBAPincode")
    public WebElement baPincode;

    @FindBy(xpath = "//*[@id='dvAddressDetails']/div[1]/div[3]//label[text()='Pincode']")
    public WebElement baPincodeLabel;

    @FindBy(id = "txtVACity")
    public WebElement vendorCity;

    @FindBy(xpath = "//*[@id='dvAddressDetails']/div[2]//label[text()='City']")
    public WebElement vendorCityLabel;

    @FindBy(id = "txtVAPincode")
    public WebElement vendorPincode;

    @FindBy(xpath = "//*[@id='dvAddressDetails']/div[2]/div//label[text()='Pincode']")
    public WebElement vendorPincodeLabel;

    @FindBy(id = "txtSACity")
    public WebElement saCity;

    @FindBy(xpath = "//*[@id='dvAddressDetails']/div[3]/div[4]/div[1]/div/label[text()='City']")
    public WebElement saCityLabel;

    @FindBy(id = "txtSAPincode")
    public WebElement saPincode;

    @FindBy(xpath = "//*[@id='dvAddressDetails']/div[3]//label[text()='Pincode']")
    public WebElement saPincodeLabel;

    @FindBy(id = "ddlBACountry_select")
    public WebElement baCountry;

    @FindBy(xpath = "//*[@id='dvAddressDetails']/div[1]//label[2][text()='Country']")
    public WebElement baCountryLabel;

    @FindBy(id = "ddlBAState_select")
    public WebElement baState;

    @FindBy(xpath = "//*[@id='dvAddressDetails']/div[1]//label[2][text()='State']")
    public WebElement baStateLabel;

    @FindBy(id = "ddlVACountry_select")
    public WebElement vaCountry;

    @FindBy(xpath = "//*[@id='dvAddressDetails']/div[2]//label[2][text()='Country']")
    public WebElement vaCountryLabel;

    @FindBy(id = "ddlVAState_select")
    public WebElement vaState;

    @FindBy(xpath = "//*[@id='dvAddressDetails']/div[2]//label[2][text()='State']")
    public WebElement vaStateLabel;

    @FindBy(id = "ddlSACountry_select")
    public WebElement saCountry;

    @FindBy(xpath = "//*[@id='dvAddressDetails']/div[3]/div[5]/div[1]/div/label[2][text()='Country']")
    public WebElement saCountryLabel;

    @FindBy(id = "ddlSAState_select")
    public WebElement saState;

    @FindBy(xpath = "//*[@id='dvAddressDetails']/div[3]//label[2][text()='State']")
    public WebElement saStateLabel;

    @FindBy(id = "ContentPlaceHolder1_ucPO_chkSameAsBilling")
    public WebElement shipAddressCheckbox;

    @FindBy(id = "ContentPlaceHolder1_ucPO_divNewRecord")
    public WebElement addNewLineItemButton;

    @FindBy(xpath = "//*[text()='Add New Line Item']")
    public WebElement addNewLineItemLabel;

    @FindBy(xpath = "//*[text()='Notes/Comments for the vendor']")
    public WebElement notesLabel;

    @FindBy(name = "ctl00$ContentPlaceHolder1$ucPO$txtNotes")
    public WebElement notesTextbox;

    @FindBy(name = "ctl00$ContentPlaceHolder1$ucPO$btnPreview")
    public WebElement previewButton;

    @FindBy(name = "ctl00$ContentPlaceHolder1$ucPO$btnCancelPO")
    public WebElement cancelButton;

    @FindBy(name = "ctl00$ContentPlaceHolder1$ucPO$btnSavePO")
    public WebElement saveInvoiceButton;

    @FindBy(name = "ctl00$ContentPlaceHolder1$ucPO$btnCreateInvoice")
    public WebElement generateInvoiceButton;

    @FindBy(xpath = "//*[text()='Invoice No cannot be empty..']")
    public WebElement invoiceEmptyValMsg;

    @FindBy(xpath = "//*[text()='Deliver date should not be empty.']")
    public WebElement paymentDueDateValMsg;

    @FindBy(xpath = "//*[text()='Please enter contact name']")
    public WebElement vendorCompanyNameValMsg;

    @FindBy(xpath = "//*[text()='Please enter Phone Number']")
    public WebElement vendorPhoneNumberValMsg;

    @FindBy(xpath = "//*[text()='Please enter Email Id']")
    public WebElement vendorEmailValMsg;

    @FindBy(xpath = "//*[text()='Please Enter Vendor Address']")
    public WebElement vendorAddressValMsg;

    @FindBy(xpath = "//*[text()='Please Select Vendor State']")
    public WebElement vendorStateValMsg;

    @FindBy(xpath = "//*[text()='Please Enter Shipping Address']")
    public WebElement shippingAddressValMsg;

    @FindBy(xpath = "//*[text()='Please Select Shipping State']")
    public WebElement shippingStateValMsg;






    public invoice_POM(WebDriver driver) {
        driver = Hooks.driver;
        PageFactory.initElements(driver, this);
    }
}
