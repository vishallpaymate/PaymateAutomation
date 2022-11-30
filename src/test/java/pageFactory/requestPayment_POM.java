package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import step_definitions.Hooks;

import java.util.List;

public class requestPayment_POM {


    @FindBy(xpath = "//a[contains(text(),'Sales')]")
    public WebElement getSales;

    @FindBy(xpath = "//*[@id='Ulmenu']/li[2]/a")
    public WebElement getPayments;

    @FindBy(xpath = "//*[@id='Ulmenu']/li[2]/ul/li/a")
    public List<WebElement> getPaymentsMenu;

    @FindBy(xpath = "//*[@id='Ulmenu']/li[5]/ul/li/a")
    public List<WebElement> getCollectMenus;

    @FindBy(xpath = "//*[@id='Ulmenu']/li[2]/ul/li/a")
    public List<WebElement> getPaymentMenus;

    @FindBy(xpath = "//h1[text()='Collect Payment']")
    public WebElement getCollectionPaymentText;

    @FindBy(xpath = "//*[@id='ContentPlaceHolder1_gvBookedTransactions_lbtnEdit_0']/i")
    public WebElement getEditIcon;

    @FindBy(xpath = "//*[@id='ContentPlaceHolder1_gvBookedTransactions_adelete_0']/i")
    public WebElement getDeleteIcon;

    @FindBy(css = ".dropdown-toggle-split")
    public WebElement actionDropdown;

    @FindBy(css = "#ui-id-1")
    public WebElement getRequestAPayment;

    @FindBy(xpath = "//a[contains(text(),'Reports')]")
    public WebElement getReports;

    @FindBy(xpath = "//*[@id='Ulmenu']/li[7]/ul/li/a")
    public List<WebElement> getReportsMenu;

    @FindBy(xpath = "//*[@class='sub-menu toggled']//ul/li")
    public List<WebElement> getReportsMenuVendor;

    @FindBy(css = "#ContentPlaceHolder1_divbulkrequest")
    public WebElement getploadaBulkPaymentFileTab;

    @FindBy(css = "#ui-id-3")
    public WebElement getBookedTransactions;

    @FindBy(css = "#fupRequests")
    public WebElement getBulkPaymentFileUploads;

    @FindBy(xpath = "//*[@href='../Templates/SampleBulkUploadRequest.xls']")
    public WebElement getDownloadFileLink;

    @FindBy(xpath = "//a[contains(text(),'Click here to view sample')]")
    public WebElement getSampleText;

    @FindBy(name = "ctl00$ContentPlaceHolder1$fupRequests")
    public WebElement getFileUpoadField;

    @FindBy(xpath = "//*[@id='dvsearchable']/i")
    public WebElement getCompanyNameDropDown;

    @FindBy(xpath = "//*[@id='[dvsearchable']/i")
    public WebElement getCopnaynameDropDown;
    @FindBy(xpath = "//*[@id='dvsearchable']/label")
    public WebElement getCompnayNameDropDownLabel;

    @FindBy(xpath = "//*[@id='ddlSearchContact']/option[not(@class='none hidden')]")
    public List<WebElement> getCompanyNameOptions;

    @FindBy(xpath = "//span[text()='Add Contact']")
    public WebElement getAddContactLink;

    @FindBy(css = "#ddlCurrency_select")
    public WebElement getCurrencyDropDown;

    @FindBy(xpath = "//ul[@id='ddlCurrency_select']/li")
    public List<WebElement> getCurrencyDropDownOptions;

    @FindBy(css = "#txtAmount")
    public WebElement getAmountTextBox;

    @FindBy(xpath = "//*[@id='ui-id-2']/div[1]/div[4]/div/label")
    public WebElement getBaseAmountLabel;

    @FindBy(css = "#ddlGSTType_select")
    public WebElement getGstTypeDropDown;

    @FindBy(css = "#ddlGSTRate_select")
    public WebElement getGstAmountField;

    @FindBy(css = "#ContentPlaceHolder1_ddlNetTerms_select")
    public WebElement getNetTerms;

    @FindBy(css = "#txtInvoiceDate")
    public WebElement getInvoiceDateTextBox;

    @FindBy(css = "#fupInvoice")
    public WebElement getUploadInvoice;

    @FindBy(css = "#txtInvoiceNo")
    public WebElement getInvoiceNumber;

    @FindBy(css = "#txtRemarks")
    public WebElement getRemarks;

    @FindBy(xpath = "//*[@id='ContentPlaceHolder1_cbClientCharge']")
    public WebElement getMDRToCustomerCheckBox;

    @FindBy(css = "#txtClientCharges")
    public WebElement getCystomerChargesTextBox;

    @FindBy(css = "#txtBusinessCharges")
    public WebElement getBusinessChargesTextBox;

    @FindBy(css = "#btnBooknNext")
    public WebElement getBookAnotherButton;

    @FindBy(css = "#btndirectConfirm")
    public WebElement getContinueButton;

    @FindBy(css = "#btnCancelUpdate")
    public WebElement getCancelButton;

    @FindBy(css = "#ContentPlaceHolder1_ucSearchContact_cv")
    public WebElement getContactValidationMsg;

    @FindBy(css = "#ContentPlaceHolder1_cvAmount")
    public WebElement getBaseAmountValidationMsg;

    @FindBy(xpath = "//i[@class='mdl-icon-toggle__label material-icons scdown']")
    public WebElement getDropDownIcon;

    @FindBy(css = "#ui-id-1")
    public WebElement getRequestPaymentTab;

    @FindBy(css = "#cbSelect")
    public List<WebElement> getBookedTransactionsCheckBox;

    @FindBy(xpath = "//*[@id='ContentPlaceHolder1_gvBookedTransactions']/tbody/tr/td[2]")
    public List<WebElement> getListOfContact;

    @FindBy(xpath = "//a[contains(@id,'ContentPlaceHolder1_gvBookedTransactions_adelete_')]")
    public List<WebElement> getListDeleteIcon;

    @FindBy(xpath = "//*[@id='ContentPlaceHolder1_gvBookedTransactions']/tbody/tr/td[3]")
    public List<WebElement> getAmount;

    @FindBy(xpath = "//*[@id='cbSelect']")
    public List<WebElement> getCheckBox;

    @FindBy(css = "#ContentPlaceHolder1_btnConfirm")
    public WebElement getSendRequestButton;

    @FindBy(xpath = "//div[@class='alert-strip success-alert']")
    public WebElement getvalidationMsgStrip;

    @FindBy(xpath = "//h1[text()='Track Collections']")
    public WebElement getTrackCollectionPage;

    @FindBy(xpath = "//h1[text()='Purchase Orders Received']")
    public WebElement getPurchaseOrderPage;

    @FindBy(xpath = "//*[@id='ContentPlaceHolder1_gvRequests']/tbody/tr/td[1]")
    public WebElement getNoTranscationFound;

    @FindBy(css = "#ContentPlaceHolder1_btnFilter")
    public WebElement getFilterButton;

    @FindBy(xpath = "//*[@id='ddlCurrency_select']/li")
    public List<WebElement> getGetCurrencyDropDown;


    @FindBy(xpath = "//*[@id='ui-id-2']/div/div[1]/div[2]/div/div/label[1]/i")
    public WebElement getcurrencyDropDownClick;

    @FindBy(xpath = "//*[@id='ContentPlaceHolder1_gvBookedTransactions']/tbody/tr/td[1]")
    public WebElement getNoTransactionFound;

    @FindBy(xpath = "//*[@id='PnlMain']/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div/label[1]/i")
    public WebElement getAllCompanyNameDropDownClick;

    @FindBy(id = "ContentPlaceHolder1_txtDateRange")
    public WebElement getCalendar;

    @FindBy(xpath = "//button[@class='applyBtn btn btn-sm btn-success']")
    public WebElement getApplyButton;

    @FindBy(xpath = "//*[@id='ContentPlaceHolder1_gvRequests']/tbody/tr/td[1]")
    public List<WebElement> getCompanyNameFromTrackCollections;


    @FindBy(xpath = "//input[@class='cbSelectAll']")
    public WebElement getRadioButton;

    @FindBy(xpath = "//div[@id='ContentPlaceHolder1_dvBookedRequests']/div/p")
    public WebElement getGuidanceText;

    @FindBy(xpath = "//*[@id='ContentPlaceHolder1_gvBookedTransactions']/thead/tr/th")
    public List<WebElement> getTableHeading;

    @FindBy(xpath = "//*[@id='ContentPlaceHolder1_gvBookedTransactions']/tbody/tr/td[2]")
    public List<WebElement> getContactName;

    @FindBy(xpath = "//*[@id='ContentPlaceHolder1_gvBookedTransactions']/tbody/tr/td")
    public List<WebElement> getContactData;

    @FindBy(css = "#ContentPlaceHolder1_btnCancel")
    public WebElement getFilterClearButton;

    @FindBy(xpath = "//h1[text()='Requests Received']")
    public WebElement getRequestReceivedHeading;

    @FindBy(xpath = "//*[@id='cbxSelect']")
    public List<WebElement> getRequestReceivedCheckBox;

    @FindBy(xpath = "//div[@id='ContentPlaceHolder1_dvActions']//input[2]")
    public WebElement getSubmitFromrequestReceived;

    @FindBy(css = "#ContentPlaceHolder1_h2")
    public WebElement getAcceptRequestPopUpWindow;

    @FindBy(css = "#lblBaseAmt")
    public WebElement getBaseAmountFromAcceptRequestFrom;

    @FindBy(css = "#lblGST")
    public WebElement getGSTFromAcceptRequestFrom;

    @FindBy(css = "#lblPaymentTerms")
    public WebElement getPaymentTermsFromAcceptRequestFrom;

    @FindBy(css = "#lblRemarks")
    public WebElement getRemarksFromAcceptRequestFrom;

    @FindBy(css = "#lblDueDate")
    public WebElement getInvoiceDateFromAcceptRequestFrom;

    @FindBy(xpath = "//*[@id='dvDiscountPopup']/div/div/div[2]/div/div[3]/div[3]/div/label[1]/i")
    public WebElement getPayFrom;

    @FindBy(xpath = "//*[@id='ddlPayFrom_select']/li")
    public List<WebElement> getPayFromList;

    @FindBy(xpath = "//*[@id='dvDiscountPopup']/div/div/div[2]/div/div[3]/div[4]/div/label[1]/i")
    public WebElement getPayThrough;

    @FindBy(xpath = "//*[@class='cc mdl-menu__item']")
    public List<WebElement> getPayThoughList;

    @FindBy(css = "#btSaveDiscount")
    public WebElement getAcceptButtonFrom;

    @FindBy(xpath = "//*[@id='form1']/div[3]")
    public WebElement getSuccessStripMsg;

    @FindBy(xpath = "//*[@id='ddlPayThrough_select']/li")
    public List<WebElement> getBankList;

    @FindBy(css = "#ddlPayThrough_select")
    public WebElement getXpressID;

    @FindBy(xpath = "//*[@id='ContentPlaceHolder1_gvRequestPay']/tbody/tr/td[3]")
    public List<WebElement> getRequestReferenceNo;

    @FindBy(xpath = "//h1[contains(text(),'Pending Approvals')]")
    public WebElement getendingApprovalpage;

    @FindBy(css = "#ContentPlaceHolder1_txtTransactionID")
    public WebElement getTransactionId;

    @FindBy(name = "ctl00$ContentPlaceHolder1$txtAmount")
    public WebElement getEnterAmountFromRequestPaymentPage;

    @FindBy(name = "ctl00$ContentPlaceHolder1$txtRemarks")
    public WebElement getRemarksFromRequestPaymentPage;
    @FindBy(xpath = "//*[@id='ContentPlaceHolder1_gvApprovals']/thead/tr/th")
    public List<WebElement> getApprovalTableHeading;

    @FindBy(xpath = "//*[@id='ContentPlaceHolder1_gvApprovals']/tbody/tr/td")
    public List<WebElement> getApprovalData;

    @FindBy(xpath = "//*[contains(@id,'ContentPlaceHolder1_gvApprovals_lbnViewHistory_')]/i")
    public List<WebElement> getViewHistoryPendingApproval;

    @FindBy(xpath = "//*[@id='view-history-modal']/div/div/div[1]/h4")
    public WebElement getViewHistoryPageTitle;

    @FindBy(xpath = "//*[@class='mdl-custom-textfield']/label")
    public List<WebElement> getPaymentSummeryTabLabel;

    @FindBy(xpath = "//*[@id='view-history-modal']/div[1]/div/div/div/div/div/span")
    public List<WebElement> getPaymentSummeryData;

    @FindBy(xpath = "//*[@id='ContentPlaceHolder1_gvApprovals']/tbody/tr/td[1]")
    public List<WebElement> getCheckBoxApprovePage;

    @FindBy(css = "#ContentPlaceHolder1_btnapproved")
    public WebElement getApproveButton;

    @FindBy(css = "#myModalLabel")
    public WebElement getProcessTransactionsTitle;

    @FindBy(xpath = "//*[@id='ddlPayFrom_select']")
    public WebElement getPayFromApproval;

    @FindBy(css = "#ddlPayThrough_select")
    public WebElement getGetPayThroughApproval;

    @FindBy(xpath = "//input[@class='btn btn-success btnProcess']")
    public WebElement getMakePaymentButton;

    @FindBy(xpath = "//*[contains(text(),'Top-Up')]")
    public WebElement getTopAccountPageHeading;

    @FindBy(css = "#ContentPlaceHolder1_btnNBSubmit")
    public WebElement getPayNowButton;

    @FindBy(css = "#ContentPlaceHolder1_txtCVV")
    public WebElement getEnterCvvCode;

    @FindBy(id = "ContentPlaceHolder1_rpt_txtCVVs_0")
    public WebElement enterCvvCode;

    @FindBy(xpath = "//*[@id='PnlMain']/div/div[1]/h1")
    public WebElement getPaymentsPageReport;

    @FindBy(name = "ctl00$ContentPlaceHolder1$txtTxnID")
    public WebElement getTransactionIdReport;

    @FindBy(name = "ctl00$ContentPlaceHolder1$txtInvoiceNo")
    public WebElement getInvoiceNo;

    @FindBy(xpath = "//*[@name='ctl00$ContentPlaceHolder1$btnSubmit']")
    public WebElement getClickOnPayNow;

    @FindBy(xpath = "//*[text()='Your transaction has been successfully processed.']")
    public WebElement transactionSuccessfulValmsg;

    @FindBy(xpath = "//*[@id='ContentPlaceHolder1_gvmakePayment']/thead/tr/th")
    public List<WebElement> getPaymentReportTableHeading;

    @FindBy(xpath = "//*[@id='ContentPlaceHolder1_gvRequestPay']//th[not(contains(@class,'hidden'))]")
    public List<WebElement> getPaymentsReportTableHeading;

    @FindBy(xpath = "//*[@id='ContentPlaceHolder1_gvRequestPay']//td[not(contains(@class,'hidden'))]")
    public List<WebElement> getPaymentsReportTableData;

    @FindBy(xpath = "//*[@id='ContentPlaceHolder1_gvmakePayment']//tr[1]/td")
    public List<WebElement> getPaymentReportTableData;

    @FindBy(xpath = "//*[@id='ContentPlaceHolder1_gvmakePayment_lbnViewHistory_0']")
    public WebElement getGetViewHistoryFromReport;

    @FindBy(xpath = "//*[@id='ContentPlaceHolder1_gvReceivedPayment_lbnViewHistory_0']")
    public WebElement getGetViewHistoryFromCollectionReport;

    @FindBy(xpath = "//*[contains(text(),'Payment Summary')]")
    public WebElement getPaymentSummeryTitle;

    @FindBy(xpath = "//*[@class='col-xs-12']/div/div/div/span")
    public List<WebElement> getPaymentHistoryPage;


    @FindBy(xpath = "//label[starts-with(@id,'ContentPlaceHolder1_getTxnHistory_')]")
    public List<WebElement> getPaymentHisroryPageData;

    @FindBy(xpath = "//*[contains(text(),'Reports')]")
    public WebElement clickOnReport;

    @FindBy(xpath = "//*[@id='Ulmenu']/li[7]/ul/li[1]/a")
    public WebElement collectionReport;

    @FindBy(xpath = "//h1[contains(text(),'Collections')]")
    public WebElement collectionReportPageTitle;

    @FindBy(xpath = "//*[@id='ContentPlaceHolder1_gvReceivedPayment']/thead/tr/th")
    public List<WebElement> getCollectionPageTableHeading;

    @FindBy(xpath = "//*[@id='ContentPlaceHolder1_gvReceivedPayment']/tbody/tr/td")
    public List<WebElement> getCollectionPageData;

    @FindBy(xpath = "//*[@id='ContentPlaceHolder1_gvBookedTransactions']/tbody/tr/td[4]")
    public List<WebElement> getCurrencyCode;

    @FindBy(xpath = "//*[@id='ContentPlaceHolder1_gvBookedTransactions']/tbody/tr/td[5]")
    public List<WebElement> getDueDate;

    @FindBy(xpath = "//*[@id='ContentPlaceHolder1_gvBookedTransactions']/tbody/tr/td[6]")
    public List<WebElement> getBookedStatus;

    @FindBy(xpath = "//*[@id='ContentPlaceHolder1_gvRequestPay']/tbody/tr/td[5]")
    public WebElement getRequestDateFromRequestReceivedPage;

    @FindBy(xpath = "//form[@id='form1']//td[6]")
    public WebElement getInvoiceNoFromRequestReceived;

    @FindBy(xpath = "//*[@id='ContentPlaceHolder1_gvRequestPay']/tbody/tr/td[7]")
    public WebElement getAmountFromRR;

    @FindBy(xpath = "//*[@id='ContentPlaceHolder1_gvRequestPay']/tbody/tr/td[9]")
    public WebElement getCurrencyFromRR;

    @FindBy(xpath = "//*[@id='ContentPlaceHolder1_gvRequestPay']/tbody/tr/td[10]")
    public WebElement getStatusFromRR;


    @FindBy(xpath = "//a[contains(@id,'ContentPlaceHolder1_gvBookedTransactions_')]")
    public List<WebElement> getActionsIconTitle;
    @FindBy(xpath = "//a[contains(@id,'ContentPlaceHolder1_gvBookedTransactions_')]/i")
    public List<WebElement> getActionsIcon;

    @FindBy(xpath = "//*[@class='Grid_Normal gradeX tabletds odd']/td")
    public List<WebElement> getBasicTransactionInfo;

    @FindBy(xpath = "//*[@class=' tabletds']/th")
    public List<WebElement> getTransactionInfoTabeleHeading;

    @FindBy(xpath = "//*[@class='header']/h2")
    public WebElement getTransactionDetailsPageTitle;


    @FindBy(xpath = "//*[@class='mdl-data-table__cell--non-numeric']/strong")
    public List<WebElement> getDataTableHeading;

    @FindBy(xpath = "//*[contains(@class,'mdl-data-table__cell')]/span")
    public List<WebElement> getTableValues;

    @FindBy(xpath = "//*[contains(@class,'col-xs-12 col-sm-')]")
    public List<WebElement> getTopAccountDetails;

    @FindBy(xpath = "//ul[@name='ctl00$ContentPlaceHolder1$ddlGSTType']/li")
    public List<WebElement> getGstList;

    @FindBy(xpath = "//*[@for='ddlGSTRate_select']/i")
    public WebElement getGSTValuIcon;

    @FindBy(xpath = "//*[@name='ctl00$ContentPlaceHolder1$ddlGSTRate']/li")
    public List<WebElement> getGSTValueList;

    @FindBy(xpath = "//*[@for='ddlGSTType_select']/i")
    public WebElement getGstTypeClick;

    @FindBy(xpath = "//*[@for='ContentPlaceHolder1_ddlNetTerms_select']/i")
    public WebElement getPayOnReceiptClick;

    @FindBy(name = "ctl00$ContentPlaceHolder1$txtNetTerm")
    public WebElement enterNetTerm;


    @FindBy(xpath = "//*[@id='ContentPlaceHolder1_ddlNetTerms_select']/li")
    public List<WebElement> getPayOnReceiptValues;

    @FindBy(css = "#fupInvoice")
    public WebElement getAttachedAnInvoice;

    @FindBy(css = "#txtClientCharges")
    public WebElement getCustomerCharges;

    @FindBy(css = "#txtBusinessCharges")
    public WebElement getDefaultBusinessCharges;

    @FindBy(xpath = "//*[@id='ContentPlaceHolder1_gvBookedTransactions']/tbody/tr/td[2]")
    public WebElement getBusinessNameFromBookedTransactionPage;
    @FindBy(xpath = "//*[@id='ContentPlaceHolder1_gvBookedTransactions']/tbody/tr/td[3]")
    public WebElement getPayableAmountFromBookedTransactionPage;


    @FindBy(xpath = "//*[@id='ContentPlaceHolder1_gvBookedTransactions']/tbody/tr/td[4]")
    public WebElement getCurrencyFromBookedTransactionPage;

    @FindBy(xpath = "//*[@id='ContentPlaceHolder1_gvBookedTransactions']/tbody/tr/td[5]")
    public WebElement getDueDateFromBookedTransactionPage;

    @FindBy(xpath = "//*[@id='ContentPlaceHolder1_gvBookedTransactions']/tbody/tr/td[6]")
    public WebElement getStatusFromBookedTransactionPage;

    @FindBy(css = "#txtTotalAmount")
    public WebElement getTotalAmountToBeCollected;

    @FindBy(xpath = "//*[@id='ContentPlaceHolder1_gvBookedTransactions']/tbody/tr/td[3]")
    public WebElement getPayableAmountFromBookedTransaction;

    @FindBy(xpath = "//*[@id='ContentPlaceHolder1_gvRequestPay']/thead/tr/th")
    public List<WebElement> getRequestPaymentPageTableHeading;

    @FindBy(xpath = "//*[@id='cbxSelect']")
    public List<WebElement> getCheckBoxFromRRPage;

    @FindBy(xpath = "//*[@id='ContentPlaceHolder1_gvRequestPay_wrapper']/div[1]/div/div/span[2]")
    public WebElement getTotalRecordsCount;

    @FindBy(xpath = "//*[@id='ContentPlaceHolder1_gvRequestPay']/tbody/tr/td[3]")
    public List<WebElement> getTransactionIdRRPage;
    @FindBy(css = "#cbxSelect")
    public List<WebElement> getCheckBoxRequestReceived;

    @FindBy(xpath = "//span[@id='lblPayableAmount']")
    public WebElement getNetAmount;

    @FindBy(xpath = "//span[@id='lblPaymentTerms']")
    public WebElement getPaymentsTerms;

    @FindBy(xpath = "//span[@id='lblDueDate']")
    public WebElement getDueDateFromARF;

    @FindBy(xpath = "//span[@id='lblRemarks']")
    public WebElement getGetRequestAPayment;

    @FindBy(xpath = "//b[contains(text(),'Apply Dis')]")
    public WebElement getApplyDiscount;

    @FindBy(xpath = "//input[@id='ddlTypeOfDiscount_select']")
    public WebElement getTypeOfDiscount;

    @FindBy(xpath = "//ul[@id='ddlTypeOfDiscount_select']/li")
    public List<WebElement> getListOfTypeOfDiscount;

    @FindBy(xpath = "//input[@id='ddlDiscountType_select']")
    public WebElement getDiscountType;

    @FindBy(xpath = "//ul[@id='ddlDiscountType_select']/li")
    public List<WebElement> getDiscountTypeList;

    @FindBy(css = "#txtDiscount")
    public WebElement getDiscounttextBox;

    @FindBy(xpath = "//*[@id='ContentPlaceHolder1_gvRequestPay']/tbody/tr[1]/td[3]")
    public WebElement getReferenceNo;

    @FindBy(xpath = "//*[@id='ContentPlaceHolder1_gvApprovals']/tbody/tr/td[2]")
    public WebElement getTransactionIdFromPendingApproval;

    @FindBy(xpath = "//*[@id='ContentPlaceHolder1_gvApprovals']/tbody/tr/td[3]")
    public WebElement getDate;

    @FindBy(xpath = "//*[@id='ContentPlaceHolder1_gvApprovals']/tbody/tr/td[4]")
    public WebElement getCompanyNameFromPendingApprovalScreen;

    @FindBy(xpath = "//*[@id='ContentPlaceHolder1_gvApprovals']/tbody/tr/td[5]")
    public WebElement paymateModeFromPA;

    @FindBy(xpath = "//*[@id='ContentPlaceHolder1_gvApprovals']/tbody/tr/td[6]")
    public WebElement getPaidThroughFromPA;

    @FindBy(xpath = "//*[@id='ContentPlaceHolder1_gvApprovals']/tbody/tr/td[7]")
    public WebElement getTypeOfPayment;

    @FindBy(xpath = "//*[@id='ContentPlaceHolder1_gvApprovals']/tbody/tr/td[8]")
    public WebElement getRequestPayment;

    @FindBy(xpath = "//*[@id='ContentPlaceHolder1_gvApprovals']/tbody/tr/td[9]")
    public WebElement getPayableAmount;

    @FindBy(xpath = "//*[@id='ContentPlaceHolder1_gvApprovals']/tbody/tr/td[10]")
    public WebElement getStatusFromPA;

    @FindBy(xpath = "//*[@id='ContentPlaceHolder1_gvApprovals']/tbody/tr/td[11]")
    public WebElement viewIconPA;

    @FindBy(xpath = "//*[@id='ContentPlaceHolder1_gvApprovals']/thead/tr/th")
    public List<WebElement> getTableHeadingFromPA;

    @FindBy(xpath = "//ul[@id='ddlPayThrough_select']/li")
    public List<WebElement> getBankNameList;

    @FindBy(xpath = "//div[@class='col-xs-12 col-sm-6 col-md-3']/span")
    public List<WebElement> getPaymentSummeryData1;

    @FindBy(xpath = "//div[@class='mdl-custom-textfield']/label")
    public List<WebElement> getLabelDataFromPendingApproval;

    @FindBy(xpath = "//*[@name='ctl00$ContentPlaceHolder1$gvApprovals$ctl02$cbSelectRow']")
    public WebElement getFirstCheckBox;

    @FindBy(xpath = "//*[@class=' tabletds']/th")
    public List<WebElement> getTransactionProcessTableHeading;

    @FindBy(xpath = "//*[@class='Grid_Normal gradeX tabletds odd']/td")
    public List<WebElement> getTransactionProcessTableData;

    @FindBy(xpath = "//*[text()='Top-Up Account']")
    public WebElement getTopUpAccountPage;

    @FindBy(xpath = "//*[contains(@class,'tdhed')]")
    public List<WebElement> getExpressAccountTableHeading;

    @FindBy(xpath = "//*[@class='balance']/table//tr/td[2]/span")
    public List<WebElement> getExpressAccountTableData;

    @FindBy(xpath = "//a[contains(@id,'ContentPlaceHolder1_gvRequestPay_lbtnAccept_')]/i")
    public List<WebElement> getAcceptRequest;

    @FindBy(xpath = "//*[contains(@id,'ContentPlaceHolder1_gvRequestPay_lblpaynow_')]")
    public List<WebElement> getPayNow;

    @FindBy(xpath = "//*[@id='ContentPlaceHolder1_gvRequestPay']/tbody/tr/td[2]")
    public List<WebElement> getReferenceNumber;

    @FindBy(xpath = "//*[@id='ContentPlaceHolder1_gvRequestPay']//tr/td[4]")
    public List<WebElement> getRequestDateRR;

    @FindBy(xpath = "//h1[text()='Confirm Payment']")
    public WebElement getTopUpPageHeader;

    @FindBy(xpath = "//*[@id='ContentPlaceHolder1_gvRequestPay']//tr/td")
    public List<WebElement> getTableData;

    @FindBy(xpath = "//a[contains(@id,'panel')]")
    public List<WebElement> getPaymentModeOnTopUpPage;

    @FindBy(xpath = "//input[@id='ddlchoosecard_select']")
    public WebElement getSelectCard;

    @FindBy(id = "ContentPlaceHolder1_rpt_cbcard_0")
    public WebElement selectCard;

    @FindBy(xpath = "//*[@id='ddlchoosecard_select']/li")
    public List<WebElement> getListCards;

    @FindBy(xpath = "//*[@id='card_panel']/div/div/div[3]/div")
    public WebElement getCardType;

    @FindBy(xpath = "//*[text()='Request Summary']")
    public WebElement getRequestSummeryText;

    @FindBy(xpath = "//table[@id='ContentPlaceHolder1_getTxnHistory_gvDebitSumarry']//tr/th")
    public List<WebElement> getRequestSummeryReportTableHeading;
    @FindBy(xpath = "//*[@class='gradeX tabletds odd']/td")
    public List<WebElement> getPaymentSummeryTableData;

    //PMX Admin
    @FindBy(id = "InternalCntHolder_txtTxnID")
    public WebElement getTransactionID;

    @FindBy(id = "InternalCntHolder_txtcmpName")
    public WebElement getCompanyName;

    @FindBy(xpath = "//*[ text()='Trx. Time']")
    public WebElement getSortTrxTime;

    @FindBy(id = "InternalCntHolder_txtDateRange")
    public WebElement getDateRange;




    /* @FindBy(xpath = "//span[contains(text(),'Pass MDR to Customer on receiving payment')]")
public WebElement getMDRToCustomerCheckBox;*/
    public requestPayment_POM(WebDriver driver) {
        driver = Hooks.driver;
        PageFactory.initElements(driver, this);
    }
}
