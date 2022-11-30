package step_definitions;

import baseClass.BusinessReports;
import baseClass.Environments;
import baseClass.Utils;
import baseClass.mainDriver;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import pageFactory.*;
import java.io.*;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class payments extends mainDriver {
    public String companyNameFromEmail;
    public Environments environments;
    public addContact_POM con = new addContact_POM(driver);
    public BusinessReports businessReports = new BusinessReports();
    public pmxAdmin_POM pmxAdmin = new pmxAdmin_POM(driver);
    public reports_POM reports_pom = new reports_POM(driver);
    public String propertyFileData;
    public String PayThrough;
    public Utils utils = new Utils();
    public String filePath = "C:\\Users\\Sam\\Downloads";
    public String fileName = "SampleBulkUploadRequest.xls";
    public String paymentFileName = "SampleBulkUploadPayable.xlsx";
    public int cell_size;
    public List<List<String>> cell_List;
    public ArrayList<String> arrayList;
    public requestPayment_POM req = new requestPayment_POM(driver);
    public payments_POM pay = new payments_POM(driver);
    public String cpText;
    public String email_Web;
    public List<WebElement> ListCompnayName;
    public String xpressBal;
    public String contactName_Str;
    public String msg;
    public String reference_code_Str;
    public String accountNumber_Str;
    public String propertiesFileUrl = "E:\\Office\\PaymateAutomation\\PaymateAutomation\\Files\\userNamePasswords.properties";
    public String bankName;
    public String ifscCode_Str;
    public String bankName_Str;
    public String payFromWeb;
    public String amount_Str;
    public String invoiceNumber;
    public String invoiceDate;
    public String transactionId;
    public String invoiceFile;
    public String gstType_Str;
    public String paymentModeFromPA;
    public String gst_Str;
    public String gstRate_Str;
    public String tdsType_Str;
    public String tds_Str;
    public String remarks_Str;
    public String xpressBalAmount;
    public String payableAmount;
    public String bankRefNumber;
    public String bankStatus;
    public String transID;
    public String net_terms;


    @When("I click on Payments")
    public void iClickOnPayments() throws InterruptedException {
        Thread.sleep(3000);
        utils.click(con.getDashBoardMenu, driver);
        utils.click(pay.getPayments, driver);
        utils.log4j("I clicked on payments link");

    }

    @Then("I see following options for Payments menu")
    public void iSeeFollowingOptionsForPaymentsMenu(DataTable dataTable) {
        List<List<String>> listDataTable = dataTable.cells();
        List<WebElement> listCollection = pay.getPaymentMenus;
        for (int i = 0; i < listCollection.size(); i++) {
            utils.setWebDriverFluentWait(1, 30, By.xpath("//*[@id='Ulmenu']/li[2]/ul/li/a"));
            String text = listCollection.get(i).getText();
            //System.out.println("*****************\n" + text);
            String dataTableText = listDataTable.get(i + 1).get(0);
            System.out.println("--------------------------\n" + dataTableText);
            if (dataTableText.equals("Make Payment")) {
                Assert.assertTrue(text.equals(dataTableText), "Make Payment is not displaying");
                utils.log4j(dataTableText + "  menu is displayed");
            } else if (text.equals(dataTableText) && text.equals("Bill Payments")) {
                Assert.assertTrue(text.equals(dataTableText), "Bill Payments is not displaying");
                utils.log4j(dataTableText + "  menu is displayed");
            } else if (text.equals(dataTableText) && text.equals("Requests Received")) {
                Assert.assertTrue(text.equals(dataTableText), "Requests Received is not displaying");
                utils.log4j(dataTableText + "  menu is displayed");
            } else if (text.equals(dataTableText) && text.equals("Invoices Received")) {
                Assert.assertTrue(text.equals(dataTableText), "Invoices Received is not displaying");
                utils.log4j(dataTableText + "  menu is displayed");
            } else if (text.equals(dataTableText) && text.equals("Pending Approvals")) {
                Assert.assertTrue(text.equals(dataTableText), "Pending Approvals is not displaying");
                utils.log4j(dataTableText + "  menu is displayed");
            }else if (text.equals(dataTableText) && text.equals("GST Payments")) {
                Assert.assertTrue(text.equals(dataTableText), "GST Payments is not displaying");
                utils.log4j(dataTableText + "  menu is displayed");
            } /*else {
                Assert.assertTrue(false, "");
            }*/
        }
    }

    @And("I click on following {string} for Payments")
    public void iClickOnFollowingForPayments(String arg0) throws InterruptedException {
        List<WebElement> listCollection = pay.getPaymentMenus;
        for (int i = 0; i < listCollection.size(); i++) {
            System.out.println(pay.getPaymentMenus.get(i).getText());
            String text = listCollection.get(i).getAttribute("innerText");
            Thread.sleep(2000);
            if (arg0.equals("Make Payment") && arg0.equals(text)) {
                System.out.println("Text is: " + arg0);
                utils.click(listCollection.get(i), driver);
                Thread.sleep(2000L);
                cpText = con.getPageTitle.getText();
                break;
            } else if (arg0.equals("Requests Received") && arg0.equals(text)) {
                utils.click(listCollection.get(i), driver);
                cpText = con.getPageTitle.getText();
            } else if (arg0.equals("Invoices Received") && arg0.equals(text)) {
                utils.click(listCollection.get(i), driver);
                cpText = con.getPageTitle.getText();
            } else if (arg0.equals("Pending Approvals") && arg0.equals(text)) {
                utils.click(listCollection.get(i), driver);
                cpText = con.getPageTitle.getText();
            }else if (arg0.equals("GST Payments") && arg0.equals(text)) {
                utils.click(listCollection.get(i), driver);
                cpText = con.getPageTitle.getText();
            }
        }

    }


    @When("I logout of PMX")
    public void iLogoutOfPMX() throws Exception {
        utils.pmxLogout();
        Thread.sleep(2000);
    }


    @And("I verify all fields and labels on Make Payment page")
    public void iVerifyAllFieldsAndLabelsOnMakePaymentPage() {
        /*Bulk Payment Section*/
        utils.waitAndClick(pay.bulkPaymentTab);
        Assert.assertTrue(pay.bulkPaymentTabsSelected.isDisplayed());
        Assert.assertEquals(pay.payFromBulkLabel.getText(), "Pay From *");
        Assert.assertTrue(pay.payFromBulk.isDisplayed());
        Assert.assertEquals(pay.payThroughBulkLabel.getText(), "Pay Through *");
        Assert.assertTrue(pay.payThroughBulk.isDisplayed());
        Assert.assertTrue(pay.bulkUploadField.isEnabled());
        Assert.assertTrue(pay.continueButtonBulk.isDisplayed());
        Assert.assertTrue(pay.cancelButtonBulk.isDisplayed());

        /*Single Payment Section*/
        utils.waitAndClick(pay.singlePaymentTab);
        Assert.assertTrue(pay.singlePaymentTabSelected.isDisplayed());
        Assert.assertEquals(pay.companyNameLabel.getText(), "Enter Contact Name or Company Name *");
        Assert.assertTrue(pay.companyName.isDisplayed());
//        Assert.assertTrue(pay.addContactLink.isDisplayed());
        Assert.assertEquals(pay.referenceCodeLabel.getText(), "Reference Code");
        Assert.assertTrue(pay.referenceCode.isDisplayed());
        Assert.assertEquals(pay.accountNumberLabel.getText(), "Account Number *");
        Assert.assertTrue(pay.ifscCode.isDisplayed());
        Assert.assertEquals(pay.ifscCodeLabel.getText(), "IFS Code *");
        Assert.assertTrue(pay.bankName.isDisplayed());
        Assert.assertEquals(pay.bankNameLabel.getText(), "Bank Name *");
        Assert.assertTrue(pay.branchAddress.isDisplayed());
        Assert.assertEquals(pay.branchAddLabel.getText(), "Branch Address *");
        Assert.assertEquals(pay.enterAmountLabel.getText(), "Enter Amount *");
        Assert.assertTrue(pay.enterAmount.isDisplayed());
        Assert.assertTrue(pay.addAdditionalDetails.isDisplayed());
        utils.waitAndClick(pay.addAdditionalDetails);
        utils.waitUntilWebElelemntShouldBeDisplay(driver, pay.invoiceNumberLabel, 20);
        Assert.assertEquals(pay.invoiceNumberLabel.getText(), "Invoice No");
        Assert.assertTrue(pay.invoiceNumber.isDisplayed());
        Assert.assertEquals(pay.invoiceDateLabel.getText(), "Invoice Date");
        Assert.assertTrue(pay.invoiceDate.isDisplayed());
        Assert.assertEquals(pay.invoiceUploadLabel.getText(), "Choose file to upload");
        Assert.assertTrue(pay.invoiceUpload.isEnabled());
        Assert.assertEquals(pay.gstTypeLabel.getText(), "GST Type");
        Assert.assertTrue(pay.gstType.isDisplayed());
        Assert.assertEquals(pay.gstRateLabel.getText(), "GST Rate(If applicable)");
        Assert.assertTrue(pay.gstRate.isDisplayed());
        Assert.assertEquals(pay.tdsTypeLabel.getText(), "TDS Type");
        Assert.assertTrue(pay.tdsType.isDisplayed());
        Assert.assertEquals(pay.tdsLabel.getText(), "TDS");
        Assert.assertTrue(pay.tds.isDisplayed());
        Assert.assertEquals(pay.remarksLabel.getText(), "Remarks");
        Assert.assertTrue(pay.remarks.isDisplayed());
        Assert.assertEquals(pay.payFromLabel.getText(), "Pay From *");
        Assert.assertTrue(pay.payFrom.isDisplayed());
        Assert.assertEquals(pay.payThroughLabel.getText(), "Pay through *");
        Assert.assertTrue(pay.payThrough.isDisplayed());
        Assert.assertEquals(pay.typeOfPaymentLabel.getText(), "Type of payment *");
        Assert.assertTrue(pay.typeOfPayment.isDisplayed());
        Assert.assertEquals(pay.scheduleOfPaymentLabel.getText(), "Schedule for Payment");
        Assert.assertTrue(pay.scheduleOfPayment.isDisplayed());
        Assert.assertEquals(pay.applyDiscountLabel.getText(), "Apply Discount");
        Assert.assertFalse(pay.applyDiscountCheckbox.isSelected());
        Assert.assertTrue(pay.bookAnotherButton.isDisplayed());
        Assert.assertTrue(pay.bookAnotherButton.isEnabled());
        Assert.assertTrue(pay.continueButton.isDisplayed());
        Assert.assertTrue(pay.continueButton.isEnabled());
        Assert.assertTrue(pay.cancelButton.isDisplayed());
        Assert.assertTrue(pay.cancelButton.isEnabled());

        /*Booked Transactions Section*/
        utils.waitAndClick(pay.bookedTransactionsTab);
        Assert.assertTrue(pay.bookedTransactionsTabSelected.isDisplayed());
        Assert.assertEquals(pay.bookedTransactionsHeading.getText(), "Click make payment below to confirm the booked payments");
        Assert.assertEquals(pay.noTransactionFoundText.getAttribute("innerText"), "You have no transactions");


    }

    @And("I click on continue button for Make payment page")
    public void iClickOnContinueButtonForMakePaymentPage() {
        utils.waitAndClick(pay.continueButton);
    }

    @Then("I verify all validation messages for mandatory fields")
    public void iVerifyAllValidationMessagesForMandatoryFields() {
        Assert.assertEquals(pay.companyNameValMsg.getText(), "Please enter a valid contact name");
        Assert.assertEquals(pay.accountNumberValMsg.getText(), "Please enter valid bank account number");
        Assert.assertEquals(pay.ifscCodeValMsg.getText(), "Please enter IFSC.");
        Assert.assertEquals(pay.enterAmountValMsg.getText(), "Please enter amount");
        Assert.assertEquals(pay.payFromValMsg.getText(), "Please select Pay from");
        Assert.assertEquals(pay.payThroughValMsg.getText(), "Please select Pay through");
    }

    @When("I validate intial Balance in express account")
    public void iValidateIntialBalanceInExpressAccount() {
        xpressBal = pay.xpressAccountBalance.getText();
    }

    @And("I enter following details in Single Payment tab and click continue")
    public void iEnterFollowingDetailsInSinglePaymentTabAndClickContinue(DataTable dataTable) throws InterruptedException, ParseException, IOException {
        Thread.sleep(3000);
        String month = null;
        String year = null;
        String date1 = null;
        arrayList = new ArrayList<>();
        utils.log4j("--------------Make a Payment------------");
        List<List<String>> listDataTable = dataTable.cells();
        for (int i = 1; i < listDataTable.size(); i++) {
            contactName_Str = listDataTable.get(i).get(0);
            reference_code_Str = listDataTable.get(i).get(1);
            accountNumber_Str = listDataTable.get(i).get(2);
            ifscCode_Str = listDataTable.get(i).get(3);
            bankName_Str = listDataTable.get(i).get(4);
            amount_Str = listDataTable.get(i).get(5);
            invoiceNumber = listDataTable.get(i).get(6);
            invoiceDate = listDataTable.get(i).get(7);
            invoiceFile = listDataTable.get(i).get(8);
            net_terms = listDataTable.get(i).get(9);
            gstType_Str = listDataTable.get(i).get(10);
            gstRate_Str = listDataTable.get(i).get(11);
            tdsType_Str = listDataTable.get(i).get(12);
            tds_Str = listDataTable.get(i).get(13);
            remarks_Str = listDataTable.get(i).get(14);
            pay.companyName.sendKeys(contactName_Str);
            WebElement compName = driver.findElement(By.xpath("//*[@id='ddlSearchContact']/option[text()='" + contactName_Str + "']"));
            utils.mouseMove(compName);
            String reference_Web = driver.findElement(By.xpath("//*[@id='dvsearchable']/div/table/thead[2]/tr/td[3]")).getText();
            System.out.println("reference_Web" + reference_Web);
            if (compName.getText().contains(contactName_Str) && reference_Web.equalsIgnoreCase(reference_code_Str)) {
                compName.click();
            }
            Thread.sleep(3000);
           /* List<WebElement> listCompanyName = pay.companyNameOptions;
            System.out.println("Size: "+listCompanyName.size());
            for (int j = 1; j <= listCompanyName.size(); j++) {
                String contact_web = pay.companyNameOptions.get(j).getAttribute("innerText");
                System.out.println("Web Contact: " + contact_web);
                utils.mouseMove(pay.companyNameOptions.get(j));
                String reference_Web = driver.findElement(By.xpath("//*[@id='dvsearchable']/div/table/thead[2]/tr/td[3]")).getText();

                if (contact_web.equalsIgnoreCase(contactName_Str) && reference_Web.equalsIgnoreCase(reference_code_Str)) {
                    utils.setWebDriverFluentWait(1, 30, By.xpath("//*[@id='ddlSearchContact']/option[" + j + "]"));
                    //utils.click()
                    //System.out.println("+++++++++++++++++++++" + email_Web);
                    listCompanyName.get(j).click();
                    // System.out.println("I selected company name: " + contact_web);
                    utils.log4j("I selected company name: " + contact_web);
                    Thread.sleep(5000);
                }
            }*/
//            System.out.println("Ref code: "+pay.referenceCode.getAttribute("value"));
//            Assert.assertEquals(pay.referenceCode.getAttribute("value"),reference_code_Str);
            if (pay.referenceCode.getAttribute("value").isEmpty()) {
                pay.referenceCode.sendKeys(reference_code_Str);
            } else {
                System.out.println("Ref code: " + pay.referenceCode.getAttribute("value"));
                Assert.assertEquals(pay.referenceCode.getAttribute("value"), reference_code_Str);
                utils.log4j("Reference code is present");
            }
            if (pay.accountNumber.getAttribute("value").isEmpty()) {
                pay.referenceCode.sendKeys(accountNumber_Str);
            } else {
                Assert.assertEquals(pay.accountNumber.getAttribute("value"), accountNumber_Str);
                utils.log4j("Account number is present");
            }
            if (pay.ifscCode.getAttribute("value").isEmpty()) {
                pay.ifscCode.sendKeys(ifscCode_Str);
            } else {
                Assert.assertEquals(pay.ifscCode.getAttribute("value"), ifscCode_Str);
                utils.log4j("IFSC code is present");
            }
            if (pay.bankName.getAttribute("value").isEmpty()) {
                pay.bankName.sendKeys(bankName_Str);
            } else {
                Assert.assertEquals(pay.bankName.getAttribute("value"), bankName_Str);
                utils.log4j("Bank Name is present");
            }

            pay.enterAmount.sendKeys(amount_Str);
            utils.waitAndClick(pay.addAdditionalDetails);
            utils.getCurrentDataTime();
            //System.out.println("current date: " + utils.date);
            utils.getCurrentDataTime();
            String datein = utils.addOneDay(utils.date);
            if (invoiceDate.equals(datein)) {
                Assert.assertTrue(false, "Enter valid date  " + "Please select past dates or Current date only. ");
            }
            //System.out.println(idate);
            String[] spliDate = invoiceDate.split("/");
            for (String d : spliDate) {
                month = spliDate[1];
                year = spliDate[2];
                date1 = spliDate[0];

            }
            utils.waitAndClick(pay.invoiceDate);
//            driver.findElement(By.cssSelector("#txtInvoiceDate")).click();
            utils.log4j("I clicked on calender icon");
            driver.findElement(By.xpath("//*[@class='ui-datepicker-year']")).click();
            utils.log4j("I clicked on year drop down");
            List<WebElement> yearList = driver.findElements(By.xpath("//*[@class='ui-datepicker-year']/option"));
            for (int j = 0; j < yearList.size(); j++) {
                String yearWeb = yearList.get(j).getAttribute("innerText");
                //System.out.println(yearWeb);
                if (yearWeb.equals(year)) {
                    utils.click(yearList.get(j), driver);
                    utils.log4j("I select year: " + yearWeb);
                    break;
                }
            }
            Select select = new Select(driver.findElement(By.xpath("//*[@class='ui-datepicker-month']")));

            List<WebElement> listMonth = driver.findElements(By.xpath("//*[@class='ui-datepicker-month']/option"));
            for (int k = 0; k < listMonth.size(); k++) {
                String months = listMonth.get(k).getAttribute("innerText");
                //System.out.println(month);
                if (month.equals(months)) {
                    select.selectByIndex(k);
                    utils.log4j("I selected month is: " + months);
                    break;
                }
            }
            List<WebElement> listDay = driver.findElements(By.xpath("//*[@class='ui-state-default']"));
            for (int m = 0; m < listDay.size(); m++) {
                String day = listDay.get(m).getText();
                //System.out.println(day);
                if (day.equals(date1)) {
                    listDay.get(m).click();
                    utils.log4j("I selected day is: " + day);
                    break;
                } else {
                    utils.log4j("Current Date will taken as default if not specified");
                }
            }
            pay.invoiceNumber.sendKeys(invoiceNumber);
            pay.netTerms.sendKeys(net_terms);
            utils.readPropertiesFile(propertiesFileUrl);
            propertyFileData = utils.obj.getProperty("card");
            utils.waitAndClick(pay.payFrom);
            Thread.sleep(300L);
            utils.log4j("I Clicked On PayFrom DropDown");
            List<WebElement> listPayFrom = pay.payFromList;
            for (WebElement webElement : listPayFrom) {
                payFromWeb = webElement.getText();
                //System.out.println(payFrom);
                if (propertyFileData.equalsIgnoreCase(payFromWeb) && propertyFileData.equalsIgnoreCase("Credit card")) {
                    payFromWeb = webElement.getText();
                    //System.out.println(payFromWeb);
                    webElement.click();
                    utils.log4j("I Select Pay From Is: " + payFromWeb);
                    Thread.sleep(500L);
                    driver.findElement(By.xpath("//*[@for='ddlPayThrough_select']/i")).click();
                    utils.log4j("I Click On Pay Through DropDown");
                    Thread.sleep(500L);
                    PayThrough = driver.findElement(By.xpath("//*[@class='cc mdl-menu__item']")).getText();
                    utils.log4j("I Select PayThrough:  " + PayThrough);
                    driver.findElement(By.xpath("//*[@class='cc mdl-menu__item']")).click();
                    break;

                } else if (payFromWeb.equalsIgnoreCase(propertyFileData) && propertyFileData.equalsIgnoreCase("Net Banking")) {
                    payFromWeb = webElement.getText();

                    webElement.click();
                    utils.log4j("I Select Pay From Is: " + payFromWeb);
                    Thread.sleep(500L);
                    driver.findElement(By.xpath("//*[@for='ddlPayThrough_select']/i")).click();
                    utils.log4j("I Click On Pay Through DropDown");
                    Thread.sleep(500L);
                    List<WebElement> listBanksName = req.getBankNameList;
                    for (WebElement webElement1 : listBanksName) {
                        bankName = webElement1.getText();
                        if (bankName.equalsIgnoreCase("Corporation Bank")) {
                            webElement1.click();
                            utils.log4j("I Select Bank Is: " + bankName);
                        }
                    }

                } else if (payFromWeb.equalsIgnoreCase(propertyFileData) && propertyFileData.equalsIgnoreCase("Xpress Account")) {
                    payFromWeb = webElement.getText();
                    webElement.click();
                    utils.log4j("I Select Pay From Is: " + payFromWeb);
                }

            }

            utils.waitAndClick(pay.continueButton);
            Thread.sleep(3000);
        }
    }

    @Then("I see booked transaction tab is expanded for Payments")
    public void iSeeBookedTransactionTabIsExpandedForPayments() {
        String bookedTransactionExpaned = pay.bookedTransactionsTab.getAttribute("aria-expanded");
        if (bookedTransactionExpaned.equals("true")) {
            utils.log4j("Booked transaction tab is expanded");
        } else {
            Assert.assertTrue(false, "Booked transaction tab is not expanded");
        }
    }

    @And("I should redirect on Pending Approvals page")
    public void iShouldRedirectOnPendingApprovalsPage() {
        Assert.assertEquals(con.getPageTitle.getText(), "Vendor Payments");
    }

    @And("I sort the transactions in Descending order by Date")
    public void iSortTheTransactionsInDescendingOrderByDate() throws InterruptedException {
        Thread.sleep(3000);
        utils.waitAndClick(pay.dateColumn);
        utils.waitAndClick(pay.dateColumn);
        Assert.assertTrue(pay.sortDescending.isDisplayed());
    }


    @Then("I select transaction and click on approve")
    public void iSelectTransactionAndClickOnApprove() throws InterruptedException {
        transactionId = req.getTransactionIdFromPendingApproval.getText();
        System.out.println("trans id: " + transactionId);
        System.out.println("Size is:" + pay.approveCheckboxes.size());
        List<WebElement> listApprove = pay.approveCheckboxes;
        for (int i = 0; i < listApprove.size(); i++) {
            listApprove.get(i).click();
            break;
        }
        utils.waitAndClick(req.getApproveButton);
    }


    @And("I navigate to Process Transaction window and verify details")
    public void iNavigateToProcessTransactionWindowAndVerifyDetails() {
        utils.waitUntilWebElelemntShouldBeDisplay(driver, pay.processTransactionsTitle, 30);
        Assert.assertEquals(pay.processTransactionsTitle.getText(), "Process Transactions");
        String str_sub = pay.transAmount.getText();
        String transAmt = str_sub.replace(",", "");
        System.out.println("trans amt: " + transAmt);
        Assert.assertEquals(transAmt, amount_Str);
        xpressBal = pay.xpressBalAmt.getText();
        System.out.println("xpress bal: " + xpressBal);
    }

    @Then("I click on Make Payment button and validate message")
    public void iClickOnMakePaymentButtonAndValidateMessage() {
        utils.waitAndClick(pay.makePaymentButton);
        utils.waitUntilWebElelemntShouldBeDisplay(driver, pay.makePaymentSuccessfulValMsg, 30);
//        Assert.assertEquals(pay.makePaymentSuccessfulValMsg.getText(), "1 Payment(s) approved");
    }

    @And("I go to Reports menu and check Payment report")
    public void iGoToReportsMenuAndCheckPaymentReport() throws InterruptedException {
        utils.waitElementShouldBeClickable(con.dashBoardMenu);
        utils.clickDashboardMenu();
        Thread.sleep(2000L);
        utils.click(req.getReports, driver);
        List<WebElement> reportsTabList = req.getReportsMenuVendor;
        for (WebElement element : reportsTabList) {
//            utils.waitListOFElementShouldBeClickable(req.getReportsMenuVendor);
            String text = element.getText();
            if (text.equals("Vendor Payments")) {
                System.out.println("Text is: " + text);
                element.click();
                Thread.sleep(2000L);
                break;
            }
        }
        utils.pageLoadTime();
        Assert.assertEquals(con.getPageTitle.getText(), "Vendor Payments");
        utils.click(con.getFilterClick, driver);
        req.getTransactionIdReport.sendKeys(transactionId);
        utils.click(con.getFilterButton, driver);
        Thread.sleep(1000L);
        bankRefNumber = pay.bankRefNoPaymentsReport.getText();
    }

    @And("I navigate to Settlement Reports")
    public void iNavigateToSettlementReports() throws InterruptedException {
        utils.waitAndClick(pmxAdmin.reportsMenu);
        utils.waitAndClick(pmxAdmin.settelementReports);
        utils.waitUntilWebElelemntShouldBeDisplay(driver, pmxAdmin.settelementReportsTitle, 30);
        Assert.assertEquals(pmxAdmin.settelementReportsTitle.getText(), "Settlements Report");
    }

    @And("I click on Bulk payment tab")
    public void iClickOnBulkPaymentTab() throws InterruptedException {
        Thread.sleep(2000);
        utils.waitAndClick(pay.bulkPaymentTab);
        Assert.assertTrue(pay.bulkPaymentTabsSelected.isDisplayed());
    }

    @And("I download sample payment file and enter details")
    public void iDownloadSamplePaymentFileAndEnterDetails(DataTable dataTable) throws Throwable {
        utils.deleteOldFile("C:\\Users\\Sam\\Downloads\\SampleBulkUploadPayable.xlsx");
        List<List<String>> listDataTable = dataTable.cells();
        for (int j = 1; j < listDataTable.size(); j++) {
            amount_Str = listDataTable.get(j).get(5);
            System.out.println("Line 565: "+amount_Str);
        }

        Thread.sleep(3000L);
        utils.waitAndClick(pay.bulkPayableDownloadlink);
        Thread.sleep(1000);
        cell_List = dataTable.cells();
        cell_size = cell_List.size();
        System.out.println("Cell size: " + cell_size);
        File file = new File(filePath + "\\" + paymentFileName);
        FileInputStream inputStream = new FileInputStream(file);
        Workbook wb = null;
        String fileExtensionName = paymentFileName.substring(paymentFileName.indexOf("."));
        System.out.println("File Extension is: " + fileExtensionName);
        if(fileExtensionName.equals(".xlsx")){
            //If it is xlsx file then create object of XSSFWorkbook class
            wb = new XSSFWorkbook(inputStream);
        }else if(fileExtensionName.equals(".xls")){
            //If it is xls file then create object of XSSFWorkbook class
            wb = new HSSFWorkbook(inputStream);
        }
        Sheet sheet = wb.getSheet("Sheet1");
        int rowCount = sheet.getLastRowNum()-sheet.getFirstRowNum();
        Row row = sheet.getRow(0);
        System.out.println("row.getLastCellNum(): " + row.getLastCellNum());
        for (int i = 1; i <= cell_size; i++) {
            row = sheet.createRow(i);
            for (int j = 0; j < sheet.getRow(0).getLastCellNum(); j++) {
             Cell cell = row.createCell(j);
                cell.setCellValue(cell_List.get(i - 1).get(j));
            }
            inputStream.close();
            FileOutputStream outputStream = new FileOutputStream(file);
            wb.write(outputStream);

        }

    }

    @And("I upload the payment file")
    public void iUploadThePaymentFile() throws InterruptedException, IOException {
        Actions actions = new Actions(driver);
        actions.moveToElement(pay.bulkUploadField).build().perform();
        pay.bulkUploadField.sendKeys("C:\\Users\\Sam\\Downloads\\SampleBulkUploadPayable.xlsx");
        //u.click(con.getFileUpoadField,driver);
        utils.readPropertiesFile(propertiesFileUrl);
        propertyFileData = utils.obj.getProperty("card");
        utils.waitAndClick(pay.payFromBulk);
        Thread.sleep(300L);
        utils.log4j("I Clicked On PayFrom DropDown");
        List<WebElement> listPayFrom = pay.payFromBulkList;
        for (WebElement webElement : listPayFrom) {
            payFromWeb = webElement.getText();
            //System.out.println(payFrom);
            if (propertyFileData.equalsIgnoreCase(payFromWeb) && propertyFileData.equalsIgnoreCase("Credit card")) {
                payFromWeb = webElement.getText();
                //System.out.println(payFromWeb);
                webElement.click();
                utils.log4j("I Select Pay From Is: " + payFromWeb);
                Thread.sleep(500L);
                driver.findElement(By.xpath("//*[@for='ddlPayThrough_select']/i")).click();
                utils.log4j("I Click On Pay Through DropDown");
                Thread.sleep(500L);
                PayThrough = driver.findElement(By.xpath("//*[@class='cc mdl-menu__item']")).getText();
                utils.log4j("I Select PayThrough:  " + PayThrough);
                driver.findElement(By.xpath("//*[@class='cc mdl-menu__item']")).click();
                break;

            } else if (payFromWeb.equalsIgnoreCase(propertyFileData) && propertyFileData.equalsIgnoreCase("Net Banking")) {
                payFromWeb = webElement.getText();

                webElement.click();
                utils.log4j("I Select Pay From Is: " + payFromWeb);
                Thread.sleep(500L);
                driver.findElement(By.xpath("//*[@for='ddlPayThrough_select']/i")).click();
                utils.log4j("I Click On Pay Through DropDown");
                Thread.sleep(500L);
                List<WebElement> listBanksName = req.getBankNameList;
                for (WebElement webElement1 : listBanksName) {
                    bankName = webElement1.getText();
                    if (bankName.equalsIgnoreCase("Corporation Bank")) {
                        webElement1.click();
                        utils.log4j("I Select Bank Is: " + bankName);
                    }
                }

            } else if (payFromWeb.equalsIgnoreCase(propertyFileData) && propertyFileData.equalsIgnoreCase("Xpress Account")) {
                payFromWeb = webElement.getText();
                webElement.click();
                utils.log4j("I Select Pay From Is: " + payFromWeb);
            }

        }
        utils.waitAndClick(pay.continueButtonBulk);
        utils.setWebDriverFluentWait(1, 30, By.xpath("//*[@id='ContentPlaceHolder1_gvUploadedRequests']/tbody/tr/td[3]"));
        List<WebElement> countErrorMsg = driver.findElements(By.xpath("//*[@id='ContentPlaceHolder1_gvUploadedRequests']/tbody/tr/td[3]"));
        System.out.println("Count of error msg is: " + countErrorMsg.size());
        int cnt = countErrorMsg.size();
        for (int p = 0; p < cnt; p++) {
            String errorMsgIs = countErrorMsg.get(p).getText();
            System.out.println("errorMsgIs: " + errorMsgIs.length());
            if (errorMsgIs.length() == 0) {
                System.out.println("Error msg are there \n" + errorMsgIs);
                switch (errorMsgIs) {
                    case "Amount Field":
                        Assert.assertTrue(errorMsgIs.equals("Amount field(s) is required"));
                        break;
                    case "No Beneficiary":
                        Assert.assertTrue(errorMsgIs.equals("Invalid Beneficiary Name, Please provide XpressID, Account No. field is required., IFSCode field is required."));
                        break;
                    case "Valid xpressid":
                        Assert.assertTrue(errorMsgIs.equals("Please enter valid XpressID"));
                        break;
                }

            }else {
                System.out.println("There is no error msg");
            }
        }
    }

    @And("I check the uploaded data in booked transactions tab")
    public void iCheckTheUploadedDataInBookedTransactionsTab() {
        List<WebElement> list_uploadedData = pay.bulkUploadedData;
        System.out.println("list_uploadedData: " + list_uploadedData.size());
        for (int i = 0; i < list_uploadedData.size(); i++) {
            String table_values = list_uploadedData.get(i).getText();
            System.out.println("After upload contact data: " + table_values);
        }
    }

    @And("I click on Confirm button for Bulk Payments upload")
    public void iClickOnConfirmButtonForBulkPaymentsUpload() throws InterruptedException {
        utils.waitAndClick(pay.bulkPaymentConfirm);
        Thread.sleep(2000);
    }

    @And("I filter using Bank reference number for the transaction")
    public void iFilterUsingBankReferenceNumberForTheTransaction() throws InterruptedException {
        Thread.sleep(2000);
        pmxAdmin.bankRefNumberFilter.sendKeys(bankRefNumber);
        utils.waitAndClick(pmxAdmin.filterButtonAdmin);
        Thread.sleep(3000);

    }

    @And("I validate bank status is {string}")
    public void iValidateBankStatusIs(String arg0) {
        bankStatus = pmxAdmin.bankStatusAdmin.getText();
        System.out.println("bank status: " + bankStatus);
        Assert.assertEquals(bankStatus,arg0);
    }

    @Then("I click on get status icon from action column")
    public void iClickOnGetStatusIconFromActionColumn() throws InterruptedException {
        transID = pmxAdmin.transactionIDAdmin.getText();
        utils.waitAndClick(pmxAdmin.plusIcon);
        if (bankStatus.equalsIgnoreCase("SENT TO BENEFICIARY")) {
            utils.waitAndClick(pmxAdmin.getStatusIcon);
        }
        Thread.sleep(3000);
    }

    @And("I filter transaction using Transaction ID")
    public void iFilterTransactionUsingTransactionID() throws InterruptedException {
        pmxAdmin.bankRefNumberFilter.clear();
        pmxAdmin.transactionIDFilter.sendKeys(transID);
        utils.waitAndClick(pmxAdmin.filterButtonAdmin);
        Thread.sleep(2000);
    }

    @Then("I see validation msg for make payment")
    public void iSeeValidationMsgForMakePayment() {
        utils.waitUntilElelemntShouldBeDisplay(driver, By.xpath("//div[@class='alert-strip success-alert']"), 30);
        msg = req.getvalidationMsgStrip.getText();
        System.out.println("Msg is: "+msg);
        utils.retryingToFindElement(req.getvalidationMsgStrip, "getText");
        Assert.assertTrue(msg.equals("1 Payment(s) booked and sent for approval."));
    }

    @And("I click on Approver button and validate message")
    public void iClickOnApproverButtonAndValidateMessage() {
        utils.waitAndClick(pay.makePaymentButton);
        utils.waitUntilWebElelemntShouldBeDisplay(driver, pay.makePaymentSuccessfulValMsg, 30);
        Assert.assertEquals(pay.makePaymentSuccessfulValMsg.getText(), "1 Payment(s) approved");

    }

    @And("I click on Make Payment button and validate message for payment flow")
    public void iClickOnMakePaymentButtonAndValidateMessageForPaymentFlow() throws InterruptedException {
        utils.waitAndClick(pay.makePaymentButton);
        Thread.sleep(5000);
//        utils.waitUntilWebElelemntShouldBeDisplay(driver, pay.awaitingPaymentValMsg, 30);
        Assert.assertEquals(pay.awaitingPaymentValMsg.getText(), "1 Payment(s) awaitaing payment");

    }
}





