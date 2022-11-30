package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Factory;
import step_definitions.Hooks;

import java.util.List;

public class reports_POM {

    @FindBy(xpath = "//table[@id='ContentPlaceHolder1_getTxnHistory_gvDebitSumarry']//tr/th")
    public List<WebElement> getDebitSummaryTableHeading;

    @FindBy(xpath = "//table[@id='ContentPlaceHolder1_getTxnHistory_gvDebitSumarry']//tr/td")
    public List<WebElement> getDebitSummaryTableData;

    @FindBy(xpath = "//*[@id='ContentPlaceHolder1_getTxnHistory_gvDebitSumarry']/tbody/tr/td")
    public List<WebElement>getTableData;

    @FindBy(xpath = "//*[@id='ContentPlaceHolder1_getTxnHistory_gvDebitSumarry']/thead/tr/th")
    public List<WebElement> getTableHeading;

    @FindBy(xpath = "//*[@id='ContentPlaceHolder1_gvmakePayment']/thead/tr/th")
    public List<WebElement> getPaymentsPageTableHeading;

    @FindBy(xpath = "//*[@id='ContentPlaceHolder1_gvmakePayment']/tbody/tr/td")
    public List<WebElement>getPaymentsPageTableData;

    @FindBy(xpath = "//*[@id='ContentPlaceHolder1_gvReceivedPayment']/thead/tr/th")
    public List<WebElement> getCollectionsPageTableHeading;

    @FindBy(xpath = "//*[@id='ContentPlaceHolder1_gvReceivedPayment']/tbody/tr/td")
    public List<WebElement>getCollectionsPageTableData;

    @FindBy(xpath = "//*[@id='InternalCntHolder_gvReceivedPayment']/tbody/tr/th")
    public List<WebElement> getPMXPageTableHeading;

    @FindBy(xpath = "//*[@id='InternalCntHolder_gvReceivedPayment']/tbody/tr/td")
    public List<WebElement> getPMXPageTableData;

    @FindBy(xpath = "//*[@id='close-summary']")
    public WebElement getCloseButton;

    @FindBy(xpath = "//*[@id='ContentPlaceHolder1_gvBookedTransactions']/tbody/tr/td")
    public List<WebElement>getBookedTableData;

    @FindBy(xpath = "//*[@id='ContentPlaceHolder1_gvBookedTransactions']/thead/tr/th")
    public List<WebElement> getBookedTableHeading;

    @FindBy(xpath = "//*[@id='ContentPlaceHolder1_gvRequestPay_lbtinvoice_0']/i")
    public WebElement getAttachmentIcon;

    @FindBy(xpath = "//*[@id='ContentPlaceHolder1_gvRequestPay_lbtnAccept_0']/i")
    public WebElement getAcceptRequestIcon;

    @FindBy(xpath = "//*[@id='ContentPlaceHolder1_gvRequestPay_lblReject_0']/i")
    public WebElement getRejectIcon;

    @FindBy(xpath = "//*[@id='ContentPlaceHolder1_gvmakePayment_lbnViewHistory_0']/i")
    public WebElement getViewHistoryIcon;

    public reports_POM(WebDriver driver) {
        driver = Hooks.driver;
        PageFactory.initElements(driver, this);
    }
}