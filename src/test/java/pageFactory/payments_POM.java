package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import step_definitions.Hooks;

import java.util.List;

public class payments_POM {
    @FindBy(xpath = "//*[@id='Ulmenu']/li[2]/a")
    public WebElement getPayments;

    @FindBy(xpath = "//*[@id='Ulmenu']/li[2]/ul/li/a")
    public List<WebElement> getPaymentMenus;

    @FindBy(id = "ui-id-1")
    public WebElement  bulkPaymentTab;

    @FindBy(xpath = "//*[@id='ui-id-1' and @aria-selected='true']")
    public WebElement  bulkPaymentTabsSelected;

    @FindBy(id = "ui-id-3")
    public WebElement singlePaymentTab;

    @FindBy(xpath = "//*[@id='ui-id-3' and @aria-selected='true']")
    public WebElement singlePaymentTabSelected;

    @FindBy(id = "ui-id-5")
    public WebElement  bookedTransactionsTab;

    @FindBy(id = "txtTerms")
    public WebElement  netTerms;

    @FindBy(xpath = "//*[@id='ui-id-5' and @aria-selected='true']")
    public WebElement  bookedTransactionsTabSelected;

    @FindBy(id = "ContentPlaceHolder1_ucSearchContact_txtSearchContact")
    public WebElement  companyName;

    @FindBy(id = "ddlSearchContact")
    public WebElement  companyNameSelect;

    @FindBy(xpath = "//*[@id='ContentPlaceHolder1_pnlBook']//label[text()='Enter Contact Name or Company Name ']")
    public WebElement  companyNameLabel;

    @FindBy(xpath = "//*[@id='dvsearchable']/i")
    public WebElement  companyNameDownArrow;

    @FindBy(xpath = "//span[text()='Add Contact']")
    public WebElement addContactLink;

    @FindBy(css = "#ddlCurrency_select")
    public WebElement currencyDropDown;

    @FindBy(xpath = "//*[@id='ContentPlaceHolder1_pnlBook']//label[text()='Reference Code']")
    public WebElement referenceCodeLabel;

    @FindBy(id = "txtReferenceCode")
    public WebElement referenceCode;

    @FindBy(xpath = "//*[@id='ContentPlaceHolder1_pnlBook']//label[text()='Account Number ']")
    public WebElement accountNumberLabel;

    @FindBy(id = "ContentPlaceHolder1_txtBankAccountNo")
    public WebElement accountNumber;

    @FindBy(xpath = "//*[@id='ContentPlaceHolder1_pnlBook']//label[text()='IFS Code ']")
    public WebElement ifscCodeLabel;

    @FindBy(id = "txtIFSCode")
    public WebElement ifscCode;

    @FindBy(xpath = "//*[@id='ContentPlaceHolder1_pnlBook']//label[text()='Bank Name ']")
    public WebElement bankNameLabel;

    @FindBy(id = "ContentPlaceHolder1_txtBankName")
    public WebElement bankName;

    @FindBy(xpath = "//*[@id='ContentPlaceHolder1_pnlBook']//label[text()='Branch Address ']")
    public WebElement branchAddLabel;

    @FindBy(id = "ContentPlaceHolder1_txtBankAddress")
    public WebElement branchAddress;

    @FindBy(xpath = "//*[@id='ContentPlaceHolder1_pnlBook']//label[text()='Enter Amount ']")
    public WebElement enterAmountLabel;

    @FindBy(id = "txtAmount")
    public WebElement enterAmount;

    @FindBy(xpath = "//*[@id='ContentPlaceHolder1_pnlBook']/div[2]//button")
    public WebElement addAdditionalDetails;

    @FindBy(id = "txtInvoiceNo")
    public WebElement invoiceNumber;

    @FindBy(xpath = "//*[@id='ContentPlaceHolder1_pnlBook']//label[text()='Invoice No ']")
    public WebElement invoiceNumberLabel;

    @FindBy(xpath = "//*[@id='ContentPlaceHolder1_pnlBook']//label[text()='Invoice Date ']")
    public WebElement invoiceDateLabel;

    @FindBy(id = "txtInvoiceDate")
    public WebElement invoiceDate;

    @FindBy(xpath = "//*[@id='ContentPlaceHolder1_pnlBook']/div[2]/div[2]/div[3]/div/label")
    public WebElement invoiceUploadLabel;

    @FindBy(id = "fupInvoice")
    public WebElement invoiceUpload;

    @FindBy(xpath = "//*[@id='ContentPlaceHolder1_pnlBook']//label[text()='GST Type']")
    public WebElement gstTypeLabel;

    @FindBy(id = "ddlGSTType_select")
    public WebElement gstType;

    @FindBy(xpath = "//*[@for='ddlGSTType_select']/i")
    public WebElement gstTypeDownArrow;

    @FindBy(xpath = "//ul[@name='ctl00$ContentPlaceHolder1$ddlGSTType']/li")
    public List<WebElement> gstTypeList;

    @FindBy(xpath = "//*[@id='ContentPlaceHolder1_pnlBook']//label[text()='GST Rate(If applicable)']")
    public WebElement gstRateLabel;

    @FindBy(id = "ddlGSTRate_select")
    public WebElement gstRate;

    @FindBy(xpath = "//*[@name='ctl00$ContentPlaceHolder1$ddlGSTRate']/li")
    public List<WebElement> gstRateList;

    @FindBy(xpath = "//*[@for='ddlTDSType_select']/i")
    public WebElement tdsTypeDownArrow;

    @FindBy(xpath = "//*[@id='ContentPlaceHolder1_pnlBook']//label[text()='TDS Type']")
    public WebElement tdsTypeLabel;

    @FindBy(id = "ddlTDSType_select")
    public WebElement tdsType;

    @FindBy(xpath = "//*[@id='ContentPlaceHolder1_pnlBook']//label[text()='TDS ']")
    public WebElement tdsLabel;

    @FindBy(id = "txtTDS")
    public WebElement tds;

    @FindBy(xpath = "//*[@name='ctl00$ContentPlaceHolder1$ddlTDSType']/li")
    public List<WebElement> tdsList;

    @FindBy(xpath = "//*[@id='ContentPlaceHolder1_pnlBook']//label[text()='Remarks']")
    public WebElement remarksLabel;

    @FindBy(id = "txtRemarks")
    public WebElement remarks;

    @FindBy(xpath = "//*[@id='ContentPlaceHolder1_pnlBook']//label[text()='Pay From']")
    public WebElement payFromLabel;

    @FindBy(xpath = "//*[@for='ddlPayFrom_select']/i")
    public WebElement payFromDownArrow;

    @FindBy(id = "ddlPayFrom_select")
    public WebElement payFrom;

    @FindBy(xpath = "//*[@id='ddlPayFrom_select']/li")
    public List<WebElement> payFromList;

    @FindBy(xpath = "//*[@id='ContentPlaceHolder1_pnlBook']//label[text()='Pay through']")
    public WebElement payThroughLabel;

    @FindBy(id = "ddlPayThrough_select")
    public WebElement payThrough;

    @FindBy(xpath = "//*[@for='ddlPayThrough_select']/i")
    public WebElement payThroughDownArrow;

    @FindBy(xpath = "//*[@class='cc mdl-menu__item']")
    public List<WebElement> payThoughList;

    @FindBy(xpath = "//*[@id='ContentPlaceHolder1_pnlBook']//label[text()='Type of payment']")
    public WebElement typeOfPaymentLabel;

    @FindBy(id = "ddlPaymentType_select")
    public WebElement typeOfPayment;

    @FindBy(xpath = "//*[@for='ddlPaymentType_select']/i")
    public WebElement typeOfPaymentDownArrow;

    @FindBy(xpath = "//*[@name='ctl00$ContentPlaceHolder1$ddlPaymentType']/li")
    public List<WebElement> typeOfPaymentList;

    @FindBy(xpath = "//*[@id='ContentPlaceHolder1_pnlBook']//label[text()='Schedule for Payment']")
    public WebElement scheduleOfPaymentLabel;

    @FindBy(id = "txtDueDate")
    public WebElement scheduleOfPayment;

    @FindBy(id = "cbDiscount")
    public WebElement applyDiscountCheckbox;

    @FindBy(xpath = "//*[text()='Apply Discount']")
    public WebElement applyDiscountLabel;

    @FindBy(id = "txtTotalAmount")
    public WebElement payableAmount;

    @FindBy(css = "#btnBooknNext")
    public WebElement bookAnotherButton;

    @FindBy(css = "#btndirectConfirm")
    public WebElement continueButton;

    @FindBy(css = "#btnCancelUpdate")
    public WebElement cancelButton;

    @FindBy(name = "ctl00$ContentPlaceHolder1$btnUploadFile")
    public WebElement continueButtonBulk;

    @FindBy(name = "ctl00$ContentPlaceHolder1$btncancelup")
    public WebElement cancelButtonBulk;

    @FindBy(xpath = "//*[@id='ContentPlaceHolder1_pnlUpload']//label[text()='Pay From']")
    public WebElement payFromBulkLabel;

    @FindBy(id = "ddlPayFromBulk_select")
    public WebElement payFromBulk;

    @FindBy(xpath = "//*[@for='ddlPayFromBulk_select']/i")
    public WebElement payFromBulkDownArrow;

    @FindBy(xpath = "//*[@id='ddlPayFromBulk_select']/li")
    public List<WebElement> payFromBulkList;

    @FindBy(xpath = "//*[@id='ContentPlaceHolder1_pnlUpload']//label[text()='Pay Through']")
    public WebElement payThroughBulkLabel;

    @FindBy(id = "ddlPayThroughBulk_select")
    public WebElement payThroughBulk;

    @FindBy(xpath = "//*[@for='ddlPayThroughBulk_select']/i")
    public WebElement payThroughBulkDownArrow;

    @FindBy(id = "fupRequests")
    public WebElement bulkUploadField;

    @FindBy(xpath = "//*[text()='Click make payment below to confirm the booked payments ']")
    public WebElement bookedTransactionsHeading;

    @FindBy(xpath = "//*[@id='ContentPlaceHolder1_gvBookedTransactions']/tbody/tr/td[1]")
    public WebElement noTransactionFoundText;

    @FindBy(xpath = "//*[text()='Please enter a valid contact name']")
    public WebElement companyNameValMsg;

    @FindBy(xpath = "//*[text()='Please enter valid bank account number']")
    public WebElement accountNumberValMsg;

    @FindBy(xpath = "//*[text()='Please enter IFSC.']")
    public WebElement ifscCodeValMsg;

    @FindBy(xpath = "//*[text()='Please enter amount']")
    public WebElement enterAmountValMsg;

    @FindBy(xpath = "//*[text()='Please select Pay from']")
    public WebElement payFromValMsg;

    @FindBy(xpath = "//*[@id='ContentPlaceHolder1_cvPayThrough' and text()='Please select Pay through']")
    public WebElement payThroughValMsg;

    @FindBy(xpath = "//*[@id='ContentPlaceHolder1_RequiredFieldValidator1' and text()='Please select Pay From']")
    public WebElement payFromBulkValMsg;

    @FindBy(xpath = "//*[@id='ContentPlaceHolder1_cvPayTrhroughBulk' and text()='Please select Pay through']")
    public WebElement payThroughBulkValMsg;

    @FindBy(xpath = "//*[text()='Please Select File to Upload.']")
    public WebElement uploadBulkValMsg;

    @FindBy(id = "ContentPlaceHolder1_lblAvailableBalance")
    public WebElement xpressAccountBalance;

    @FindBy(xpath = "//*[@id='ddlSearchContact']/option[not(@class='none hidden')]")
    public List<WebElement> getCompanyNameOptions;

    @FindBy(xpath = "//*[@id='ddlSearchContact']/option[not(@class='none hidden' ) and not(@class='hidden')]")
    public List<WebElement> companyNameOptions;

    @FindBy(xpath = "//*[text()='Booked']")
    public WebElement dateColumn;

    @FindBy(className = "sorting_desc")
    public WebElement sortDescending;

    @FindBy(xpath = "//*[@class='cbSelectRow']")
    public List<WebElement> approveCheckboxes;

    @FindBy(xpath = "//*[text()='Process Transactions']")
    public WebElement processTransactionsTitle;

    @FindBy(className = "lblnetamount")
    public WebElement transAmount;

    @FindBy(xpath = "//*[@class='totalbalance amt']")
    public WebElement xpressBalAmt;

    @FindBy(css = ".btn-success")
    public WebElement makePaymentButton;

    @FindBy(xpath = "//*[text()='1 Payment(s) approved']")
    public WebElement makePaymentSuccessfulValMsg;

    @FindBy(xpath = "//*[text()='1 Payment(s) awaitaing payment']")
    public WebElement awaitingPaymentValMsg;

    @FindBy(xpath = "//*[@id='ContentPlaceHolder1_gvmakePayment']/tbody/tr/td[9]")
    public WebElement bankRefNoPaymentsReport;

    @FindBy(xpath = "//*[@href='../Templates/SampleBulkUploadPayable.xlsx']")
    public WebElement bulkPayableDownloadlink;

    @FindBy(name = "ctl00$ContentPlaceHolder1$fupRequests")
    public WebElement bulkPaymentFileUpload;

    @FindBy(xpath = "//*[@id='ContentPlaceHolder1_gvUploadedRequests']//td")
    public List<WebElement> bulkUploadedData;

    @FindBy(id = "ContentPlaceHolder1_btnDone")
    public WebElement bulkPaymentConfirm;





    public payments_POM(WebDriver driver) {
        driver = Hooks.driver;
        PageFactory.initElements(driver, this);
    }
}
