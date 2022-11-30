package step_definitions;


import baseClass.BusinessReports;
import baseClass.Environments;
import baseClass.Utils;
import baseClass.mainDriver;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import pageFactory.Login_POM;
import pageFactory.addContact_POM;
import pageFactory.reports_POM;
import pageFactory.requestPayment_POM;


import java.io.*;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class requestPayment extends mainDriver {
    public String companyNameFromEmail;
    public Environments environments;
    public addContact_POM con = new addContact_POM(driver);
    public BusinessReports businessReports = new BusinessReports();
    public reports_POM reports_pom = new reports_POM(driver);
    public String propertyFileData;
    public String PayThrough;
    public Utils utils = new Utils();
    public String filePath = "C:\\Users\\vishal.l\\Downloads";
    public String fileName = "SampleBulkUploadRequest.xls";
    public int cell_size;
    public List<List<String>> cell_List;
    public requestPayment_POM req = new requestPayment_POM(driver);
    public String cpText;
    public List<WebElement> ListCompnayName;
    public String currencyStr;
    public String companyNameLabel;
    // public List<List<String>> dataTableList;
    public ArrayList<String> arrayList;
    public ArrayList<String> arrayList1;
    public Login_POM login = new Login_POM(driver);
    public String c_name;
    public String linksText;
    public String compareDate;
    public ArrayList<String> arrayList2;
    public String email_Web;
    public String propertiesFileUrl = "E:\\Office\\PaymateAutomation\\PaymateAutomation\\Files\\userNamePasswords.properties";
    public List<List<String>> dataTable_List;
    public String referenceNo_str;
    public String str;
    public String currency_web;
    public String contactName_Str;
    public String Amount_Str;
    public String reference_code_Str;
    public String currency_Str;
    public String payFromStr;
    public String pageHeading_Str;
    public String companyName;
    public int j = 0;
    public String xpress_Id;
    List<WebElement> ListOfLinks;
    public String msg;
    public String baseAmount;
    public String amount_str;
    public String gstRate;

    public String paymentTerms;

    public String remarks;
    public float discTOComp;
    public String invoiceDate;
    public String payFromWeb;
    public String netTerms_st;
    public String gstAmount;
    public String invoiceNo;
    public String amount;
    public String remarksFromRequestPaymentPage;
    public String GST_Str;
    public String GST_Str_DT;
    public String GST_values_Web;
    public String GST_Rate_Str;
    public String payOnReceipt_WT;
    public String invoiceImgUrl;
    public String invoiceNumber;
    public String remarks_DT;
    public String mdrCharges_Dt;
    public double toPaid;
    public String transactionId;
    public String totalAmountToBeCollected;
    public String typeOfDiscount;
    public String discountType;
    public String discountAmt;
    public String baseAmountFromARF;
    public String paymentModeFromPA;
    public float payanleAmount;
    public String bankName;
    public String emailCompanyName;
    public float discountFromDT;
    public String payableAmount;
    public String accountBalance;
    public String currentTimeIs;
    public int count = 0;
    String amtInString = null;

    @When("^I click on Sales$")
    public void iClickOnSales() throws Throwable {
        Thread.sleep(3000);
        utils.click(con.getDashBoardMenu, driver);
        utils.click(req.getSales, driver);
        utils.log4j("I clicked on collection link");
    }

    @Then("^I see following options$")
    public void iSeeFollowingOptions(DataTable dataTable) throws Throwable {
        /*WebElement clickMenu = driver.findElement(By.xpath("//*[@id='header']/nav/div/div[1]/a[1]/i"));
        utils.click(clickMenu, driver);*/
        List<List<String>> listDataTable = dataTable.cells();
        List<WebElement> listCollection = req.getCollectMenus;
        for (int i = 0; i < listCollection.size(); i++) {
            utils.setWebDriverFluentWait(1, 30, By.xpath("//*[@id='Ulmenu']/li[3]/ul/li/a"));
            String text = listCollection.get(i).getText();
            //System.out.println("*****************\n" + text);
            String dataTableText = listDataTable.get(i + 1).get(0);
            //System.out.println("--------------------------\n" + dataTableText);

            if (text.equals(dataTableText) && text.equals("Collect Payment")) {
                Assert.assertTrue(text.equals(dataTableText), "sales Menus are not displaying");
                utils.log4j(dataTableText + "  menu is displayed");
            } else if (text.equals(dataTableText) && text.equals("Track Collections")) {
                Assert.assertTrue(text.equals(dataTableText), "sales Menus are displaying");
                utils.log4j(dataTableText + "  menu is displayed");
            } else if (text.equals(dataTableText) && text.equals("Purchase Orders Received")) {
                Assert.assertTrue(text.equals(dataTableText), "sales Menus are displaying");
                utils.log4j(dataTableText + "  menu is displayed");
            } else {
                Assert.assertTrue(false, "");
            }
        }
    }


    @And("^I click on following \"([^\"]*)\"$")
    public void iClickOnFollowing(String arg0) throws Throwable {
//                utils.clickDashboardMenu();
        List<WebElement> listCollection = req.getCollectMenus;
        for (int i = 0; i < listCollection.size(); i++) {
            //WebElement clickMenu = driver.findElement(By.xpath("//*[@id='header']/nav/div/div[1]/a[1]/i"));
//            utils.waitUntilElelemntShouldBeDisplay(driver, By.xpath("//*[@id='header']/nav/div/div[1]/a[1]/i"), 30);
//            WebElement clickMenu = driver.findElement(By.xpath("//*[@id='header']/nav/div/div[1]/a[1]/i"));
//            utils.click(clickMenu, driver);
//            utils.setWebDriverFluentWait(1, 30, By.xpath("//*[@id='Ulmenu']/li[3]/ul/li/a"));
            Thread.sleep(2000);
            System.out.println(req.getCollectMenus.get(i).getText());
            String text = listCollection.get(i).getAttribute("innerText");
            if (arg0.equals("Collect Payment") && arg0.equals(text)) {
                System.out.println("Text is: " + arg0);
                utils.click(listCollection.get(i), driver);
                Thread.sleep(200L);
                cpText = req.getCollectionPaymentText.getText();
                break;
            } else if (arg0.equals("Track Collections") && arg0.equals(text)) {
                utils.click(listCollection.get(i), driver);
                cpText = req.getTrackCollectionPage.getAttribute("innerText");
            } else if (arg0.equals("Purchase Orders Received") && arg0.equals(text)) {
                utils.click(listCollection.get(i), driver);
                cpText = req.getPurchaseOrderPage.getAttribute("innerText");
            }
        }
    }

    @Then("^I should be land on particular page$")
    public void iShouldBeLandOnParticularPage() throws Throwable {
        System.out.println("I am on " + cpText + " page");
    }


    @Then("^I see all fields and labels$")
    public void iSeeAllFieldsAndLabels() throws Throwable {
        String bool = req.getRequestAPayment.getAttribute("aria-expanded");
        if (bool.equals("true")) {
            System.out.println("Request a payment tab is expanded");
            /*boolean bulkRequestIdDisplyed = req.getploadaBulkPaymentFileTab.isDisplayed();
            System.out.println("bulkRequestIdDisplyed: " + bulkRequestIdDisplyed);
            if (bulkRequestIdDisplyed == true) {
                String bool0 = req.getploadaBulkPaymentFileTab.getAttribute("aria-expanded");
                Assert.assertTrue(bool0.equals("false"));
                System.out.println("Upload bulk payment tab is not expanded");
            } else {
                System.out.println("In  multi currency upload bulk payment is not allowed so tab is not displayed");
            }*/


            String bool1 = req.getBookedTransactions.getAttribute("aria-expanded");
            Assert.assertTrue(bool1.equals("false"));
            System.out.println("Booked transaction tab is not expanded");
            System.out.println("------------------------------------------------------------------------------------------");

            System.out.println("Following fields and Label and values:\n");

            String companyNameLabel = req.getCompnayNameDropDownLabel.getText();
            Assert.assertTrue(companyNameLabel.equals("Enter Contact Name or Company Name *"), "Company name label is not matched");
            System.out.println("Company Name label: " + companyNameLabel);
            boolean compnayNameIsDisplayed = req.getCompanyNameDropDown.isDisplayed();
            Assert.assertTrue(compnayNameIsDisplayed, "Enter Contact name or Company Name fields is not displayed");
            System.out.println("Enter Contact name or Company Name fields is displayed: " + compnayNameIsDisplayed);

            boolean companyNameIsEnabled = req.getCompanyNameDropDown.isEnabled();
            Assert.assertTrue(companyNameIsEnabled, "Enter Contact name or Company Name fields is not Clickable");
            System.out.println("Enter Contact name or Company Name fields is clickable: " + companyNameIsEnabled);
            ListCompnayName = req.getCompanyNameOptions;
            int getOptionsSize = ListCompnayName.size();
            if (getOptionsSize != 1) {
                for (int i = 0; i < getOptionsSize; i++) {
                    String contactStr = ListCompnayName.get(i).getAttribute("innerText");

                    System.out.println("Following are contact list: " + contactStr);
                }

            } else {
                System.out.println("There is no contact list its empty");
            }

        } else {
            Assert.assertTrue(false, "Request a payment tab is not expanded");
        }


        boolean contactLinkIdEnabled = req.getAddContactLink.isEnabled();
        Assert.assertTrue(contactLinkIdEnabled, "Add contact link is not clickable");
        System.out.println("Add contact filed is clickable: " + contactLinkIdEnabled);

        boolean addContactLinkIdDisplayed = req.getAddContactLink.isDisplayed();
        Assert.assertTrue(addContactLinkIdDisplayed, "Add contact link is not displayed");
        System.out.println("Add contact link is displayed: " + addContactLinkIdDisplayed);

        boolean currencyDropDownIsDisplayed = req.getCurrencyDropDown.isDisplayed();
        Assert.assertTrue(currencyDropDownIsDisplayed, "Select currency drop down is not displayed");

        List<WebElement> listCurrentOptions = req.getCurrencyDropDownOptions;
        System.out.println("size: " + listCurrentOptions.size());
        for (int j = 0; j < listCurrentOptions.size(); j++) {
            currencyStr = listCurrentOptions.get(j).getAttribute("textContent");
            System.out.println("Currency list is: " + currencyStr);
        }
        if (listCurrentOptions.get(0).getAttribute("textContent").equals("Select Currency")) {
            String gst = driver.findElement(By.xpath("//*[@id='ddlGSTType_select']")).getAttribute("disabled");
            if (gst.equals("true")) {
                System.out.println("                                     MULTI Currency                                                                          ");
                System.out.println("-------------------------------Following fields should not be display in multi currency------------------------------------\n");
                boolean isEnable = req.getGstTypeDropDown.isEnabled();
                Assert.assertFalse(isEnable, "Select GST dropDown is enabled");
                System.out.println("In multi currency select GST dropDown is not enabled");
                boolean GstAmountIsEnabled = req.getGstAmountField.isEnabled();
                Assert.assertFalse(GstAmountIsEnabled, "GST Amount filed is Enabled");
                System.out.println(" GST amount filed dropDown is not enabled");
                boolean checkBoixDisplayed = req.getMDRToCustomerCheckBox.isDisplayed();
                Assert.assertFalse(checkBoixDisplayed, "MDR charges check box is displaying");
                System.out.println("Pass MDR to Customer on receiving payment is not displaying");

                System.out.println("-------------------------------Following fields should  be display in multi currency------------------------------------\n");

                boolean netTermsIsEnabled = req.getNetTerms.isEnabled();

                Assert.assertTrue(netTermsIsEnabled, "Select Net Term for payment due date field is not Enabled");
                System.out.println("Select Net Term for payment due date field is displayed: " + netTermsIsEnabled);
                boolean netTermsIsDisplayed = req.getNetTerms.isDisplayed();
                Assert.assertTrue(netTermsIsDisplayed, "Select Net Term for payment due date field is not displayed");
                System.out.println("Select Net Term for payment due date field is displayed: " + netTermsIsDisplayed);

                boolean invoiceDate = req.getInvoiceDateTextBox.isDisplayed();
                Assert.assertTrue(invoiceDate, "Enter invoice date filed is not displayed");
                System.out.println("Enter invoice date field is displayed: " + invoiceDate);

                boolean invoiceDateIsEnabled = req.getInvoiceDateTextBox.isEnabled();
                Assert.assertTrue(invoiceDateIsEnabled, "Enter invoice date filed is not enabled");
                System.out.println("Enter invoice date filed is displayed: " + invoiceDateIsEnabled);

                /*boolean uploadInvoiceIsDisplayed = req.getUploadInvoice.isDisplayed();

                Assert.assertTrue(uploadInvoiceIsDisplayed, "Upload invoice filed is not displayed");
                System.out.println("Upload invoice field is displayed: " + uploadInvoiceIsDisplayed);*/

                boolean uploadInvoiceIsEnabled = req.getUploadInvoice.isEnabled();
                Assert.assertTrue(uploadInvoiceIsEnabled, "Upload invoice filed is not displayed");
                System.out.println("Upload invoice field is Enabled: " + uploadInvoiceIsEnabled);

                boolean invoiceNumberIsDisplayed = req.getInvoiceNumber.isDisplayed();
                Assert.assertTrue(invoiceNumberIsDisplayed, "Invoice number field is not displayed");
                System.out.println("Invoice number field is displayed: " + invoiceNumberIsDisplayed);


                boolean invoiceNumberIsEnabled = req.getInvoiceNumber.isEnabled();
                Assert.assertTrue(invoiceNumberIsEnabled, "Invoice number field is not Enabled");
                System.out.println("Invoice number field is Enabled: " + invoiceNumberIsEnabled);

                boolean remarksIsDisplayed = req.getRemarks.isDisplayed();
                Assert.assertTrue(remarksIsDisplayed, "Remark field is not displayed");
                System.out.println("Remark field is displaying: " + remarksIsDisplayed);
                boolean remarkIsEnabled = req.getRemarks.isEnabled();
                Assert.assertTrue(remarkIsEnabled, "Remark field is not Enabled");
                System.out.println("Remark field is Enabled: " + remarkIsEnabled);

                boolean bookAnotherButtonIsDisplayed = req.getBookAnotherButton.isDisplayed();
                Assert.assertTrue(bookAnotherButtonIsDisplayed, "Book Another button is not displayed");
                System.out.println("Book another button is displaying: " + bookAnotherButtonIsDisplayed);
                boolean bookAnotherButtonIsEnabled = req.getBookAnotherButton.isEnabled();
                Assert.assertTrue(bookAnotherButtonIsEnabled, "Book another button is not Enabled");
                System.out.println("Book another button is Enabled: " + bookAnotherButtonIsEnabled);
                String bookAnotherColor = req.getBookAnotherButton.getCssValue("color");
                Assert.assertEquals(bookAnotherColor, "rgba(255, 255, 255, 1)");

                boolean continueButtonIsDisplayed = req.getContinueButton.isDisplayed();
                Assert.assertTrue(continueButtonIsDisplayed, "Continue button is not displaying");
                System.out.println("Continue button is displaying: " + continueButtonIsDisplayed);

                boolean continueButtonIsEnabled = req.getContinueButton.isEnabled();
                Assert.assertTrue(continueButtonIsEnabled, "Continue button is not Enabled");
                System.out.println("Continue button is Enabled: " + continueButtonIsEnabled);
                String continueButton = req.getContinueButton.getCssValue("color");
                System.out.println("continueButton: " + continueButton);
                Assert.assertEquals(continueButton, "rgba(255, 255, 255, 1)");

                boolean cancelButton = req.getCancelButton.isDisplayed();
                Assert.assertTrue(cancelButton, "Cancel button is not displaying");
                boolean cancelButtonIdEnabled = req.getCancelButton.isEnabled();
                Assert.assertTrue(cancelButtonIdEnabled, "cancel button is not Enabled");
                String cancelButtoncolor = req.getContinueButton.getCssValue("color");
                System.out.println("continueButton: " + cancelButtoncolor);
            }


        } else {
           /* boolean isEnable = req.getGstTypeDropDown.isEnabled();
            System.out.println("isEnable: " + isEnable);*/
            System.out.println("                                     INR Currency                                                                          ");
            boolean isEnable = req.getGstTypeDropDown.isEnabled();
            Assert.assertTrue(isEnable, "Select GST dropDown is not enabled");
            System.out.println("In multi currency select GST dropDown is  enabled");
            boolean GstAmountIsEnabled = req.getGstAmountField.isEnabled();
            Assert.assertFalse(GstAmountIsEnabled, "GST Amount filed is Enabled");
            System.out.println(" GST amount filed dropDown is not enabled");
            boolean checkBoixDisplayed = req.getMDRToCustomerCheckBox.isDisplayed();
            Assert.assertTrue(checkBoixDisplayed, "MDR charges check box is not displaying");
            System.out.println("Pass MDR to Customer on receiving payment is  displaying");

            boolean netTermsIsEnabled = req.getNetTerms.isEnabled();

            Assert.assertTrue(netTermsIsEnabled, "Select Net Term for payment due date field is not Enabled");
            System.out.println("Select Net Term for payment due date field is displayed: " + netTermsIsEnabled);
            boolean netTermsIsDisplayed = req.getNetTerms.isDisplayed();
            Assert.assertTrue(netTermsIsDisplayed, "Select Net Term for payment due date field is not displayed");
            System.out.println("Select Net Term for payment due date field is displayed: " + netTermsIsDisplayed);

            boolean invoiceDate = req.getInvoiceDateTextBox.isDisplayed();
            Assert.assertTrue(invoiceDate, "Enter invoice date filed is not displayed");
            System.out.println("Enter invoice date field is displayed: " + invoiceDate);

            boolean invoiceDateIsEnabled = req.getInvoiceDateTextBox.isEnabled();
            Assert.assertTrue(invoiceDateIsEnabled, "Enter invoice date filed is not enabled");
            System.out.println("Enter invoice date filed is displayed: " + invoiceDateIsEnabled);

            /*boolean uploadInvoiceIsDisplayed = req.getUploadInvoice.isDisplayed();
            System.out.println("Upload invoice field is displayed: " + uploadInvoiceIsDisplayed);
            Assert.assertTrue(uploadInvoiceIsDisplayed, "Upload invoice filed is not displayed");
            System.out.println("Upload invoice field is displayed: " + uploadInvoiceIsDisplayed);*/

            boolean uploadInvoiceIsEnabled = req.getUploadInvoice.isEnabled();
            Assert.assertTrue(uploadInvoiceIsEnabled, "Upload invoice filed is not displayed");
            System.out.println("Upload invoice field is Enabled: " + uploadInvoiceIsEnabled);

            boolean invoiceNumberIsDisplayed = req.getInvoiceNumber.isDisplayed();
            Assert.assertTrue(invoiceNumberIsDisplayed, "Invoice number field is not displayed");
            System.out.println("Invoice number field is displayed: " + invoiceNumberIsDisplayed);


            boolean invoiceNumberIsEnabled = req.getInvoiceNumber.isEnabled();
            Assert.assertTrue(invoiceNumberIsEnabled, "Invoice number field is not Enabled");
            System.out.println("Invoice number field is Enabled: " + invoiceNumberIsEnabled);

            boolean remarksIsDisplayed = req.getRemarks.isDisplayed();
            Assert.assertTrue(remarksIsDisplayed, "Remark field is not displayed");
            System.out.println("Remark field is displaying: " + remarksIsDisplayed);
            boolean remarkIsEnabled = req.getRemarks.isEnabled();
            Assert.assertTrue(remarkIsEnabled, "Remark field is not Enabled");
            System.out.println("Remark field is Enabled: " + remarkIsEnabled);

            boolean bookAnotherButtonIsDisplayed = req.getBookAnotherButton.isDisplayed();
            Assert.assertTrue(bookAnotherButtonIsDisplayed, "Book Another button is not displayed");
            System.out.println("Book another button is displaying: " + bookAnotherButtonIsDisplayed);
            boolean bookAnotherButtonIsEnabled = req.getBookAnotherButton.isEnabled();
            Assert.assertTrue(bookAnotherButtonIsEnabled, "Book another button is not Enabled");
            System.out.println("Book another button is Enabled: " + bookAnotherButtonIsEnabled);
            String bookAnotherColor = req.getBookAnotherButton.getCssValue("color");
            Assert.assertEquals(bookAnotherColor, "rgba(255, 255, 255, 1)");

            boolean continueButtonIsDisplayed = req.getContinueButton.isDisplayed();
            Assert.assertTrue(continueButtonIsDisplayed, "Continue button is not displaying");
            System.out.println("Continue button is displaying: " + continueButtonIsDisplayed);

            boolean continueButtonIsEnabled = req.getContinueButton.isEnabled();
            Assert.assertTrue(continueButtonIsEnabled, "Continue button is not Enabled");
            System.out.println("Continue button is Enabled: " + continueButtonIsEnabled);
            String continueButton = req.getContinueButton.getCssValue("color");
            System.out.println("continueButton: " + continueButton);
            Assert.assertEquals(continueButton, "rgba(255, 255, 255, 1)");

            boolean cancelButton = req.getCancelButton.isDisplayed();
            Assert.assertTrue(cancelButton, "Cancel button is not displaying");
            boolean cancelButtonIdEnabled = req.getCancelButton.isEnabled();
            Assert.assertTrue(cancelButtonIdEnabled, "cancel button is not Enabled");
            String cancelButtoncolor = req.getContinueButton.getCssValue("color");
            System.out.println("continueButton: " + cancelButtoncolor);
        }
        boolean amountTextBoxIdDisplayed = req.getAmountTextBox.isDisplayed();
        Assert.assertTrue(amountTextBoxIdDisplayed, "Enter base Amount text box is not displayed");
        System.out.println("Enter base amount text filed is displayed: " + amountTextBoxIdDisplayed);
        boolean amountTextBoxIdIsEnabled = req.getAmountTextBox.isEnabled();
        Assert.assertTrue(amountTextBoxIdIsEnabled, "Enter base amount text filed is not Enabled");
        System.out.println("Enter base amount text filed is Enabled: " + amountTextBoxIdIsEnabled);
        String baseAmpountLabel = req.getBaseAmountLabel.getAttribute("innerText");

        Assert.assertTrue(baseAmpountLabel.equals("Enter a Base Amount *"), "Enter base amount label is not matched");
        System.out.println("Base amount label is: " + baseAmpountLabel);


    }

    @When("^I click on continue button from collect payment page$")
    public void iClickOnContinueButtonFromCollectPaymentPage() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        req.getContinueButton.click();
    }

    @Then("^I see proper validation msg for mandatory fields in red color$")
    public void iSeeProperValidationMsgForMandatoryFieldsInRedColor() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        String searchContact = req.getContactValidationMsg.getAttribute("innerText");
        System.out.println("searchContact: " + searchContact);
        Assert.assertTrue(searchContact.equals("Please enter contact name"), "validation msg is not matched");
        //assertEquals(searchContact.equals("Please enter contact name"), "validation msg is not matched");
        //System.out.println("searchContact: " + searchContact);
        String color = req.getContactValidationMsg.getCssValue("color");
        Assert.assertTrue(color.equals("rgba(213, 0, 0, 1)"), "validation msg color is no red");
        //System.out.println("Color: " + color);
        String baseAmountStr = req.getBaseAmountValidationMsg.getAttribute("innerText");
        Assert.assertTrue(baseAmountStr.equals("Please enter amount"), "Amount validation msg is not matched");
        String color1 = req.getBaseAmountValidationMsg.getCssValue("color");
        Assert.assertTrue(color1.equals("rgba(213, 0, 0, 1)"), "validation msg color is no red");
    }

    @And("^I  select contact name and  enter valid amount$")
    public void iSelectContactNameAndEnterValidAmount(DataTable dataTable) throws Throwable {

        arrayList1 = new ArrayList<>();
        arrayList = new ArrayList();
        dataTable_List = dataTable.cells();
        String area = req.getRequestPaymentTab.getAttribute("aria-expanded");
        if (area.equals("false")) {
            utils.click(req.getRequestPaymentTab, driver);
            for (int i = 1; i < dataTable_List.size(); i++) {
                String amount = dataTable_List.get(i).get(0);
                String contact = dataTable_List.get(i).get(1);
                String referenceCode = dataTable_List.get(i).get(2);
                String currency = dataTable_List.get(i).get(3);
                //utils.setWebDriverFluentWait(1, 30, By.cssSelector("#ContentPlaceHolder1_ucSearchContact_txtSearchContact"));
                utils.click(req.getCompanyNameDropDown, driver);
                Thread.sleep(2000L);
                driver.findElement(By.cssSelector("#ContentPlaceHolder1_ucSearchContact_txtSearchContact")).sendKeys(contact);
                List<WebElement> listCompanyName = req.getCompanyNameOptions;
                for (int j = 1; j < listCompanyName.size(); j++) {
                    String contact_web = req.getCompanyNameOptions.get(j).getAttribute("innerText");
//                    utils.mouseMove(req.getCompanyNameOptions.get(j));
                    String reference_Web = driver.findElement(By.xpath("//*[@id='dvsearchable']/div/table/thead[2]/tr/td[3]")).getText();
                    //System.out.println(contact_web);
                    email_Web = driver.findElement(By.xpath("//*[@id='dvsearchable']/div/table/thead[2]/tr/td[4]")).getText();


                    if (contact_web.equals(contact) && reference_Web.equals(referenceCode)) {
                        utils.setWebDriverFluentWait(1, 30, By.xpath("//*[@id='ddlSearchContact']/option[" + j + "]"));
                        //utils.click()
                        arrayList.add(email_Web);
                        //System.out.println("+++++++++++++++++++++" + email_Web);

                        listCompanyName.get(j).click();
                    }
                }
                utils.click(req.getcurrencyDropDownClick, driver);
                Thread.sleep(2000L);
                List<WebElement> listCurrencyDropDown = req.getGetCurrencyDropDown;
                for (int k = 1; k < listCurrencyDropDown.size(); k++) {
                    String currency_web = listCurrencyDropDown.get(k).getText();
                    //System.out.println(currency_web);
                    if (currency_web.equals(currency)) {
                        listCurrencyDropDown.get(k).click();
                    }

                }
                req.getAmountTextBox.sendKeys(amount);
                String amount_str = req.getAmountTextBox.getAttribute("value");
                System.out.println("Amount str: " + amount_str);
                utils.click(req.getBookAnotherButton, driver);

            }
        } else {
            for (int i = 1; i < dataTable_List.size(); i++) {
                String amount = dataTable_List.get(i).get(0);
                String contact = dataTable_List.get(i).get(1);
                String referenceCode = dataTable_List.get(i).get(2);
                String currency = dataTable_List.get(i).get(3);
                //utils.setWebDriverFluentWait(1, 30, By.cssSelector("#ContentPlaceHolder1_ucSearchContact_txtSearchContact"));
                utils.click(req.getCompanyNameDropDown, driver);
                Thread.sleep(2000L);
                List<WebElement> listCompanyName = req.getCompanyNameOptions;
                for (int j = 1; j < listCompanyName.size(); j++) {
                    String contact_web = req.getCompanyNameOptions.get(j).getAttribute("innerText");
                    // utils.mouseMove(req.getCompanyNameOptions.get(j));
                    String reference_Web = driver.findElement(By.xpath("//*[@id='dvsearchable']/div/table/thead[2]/tr/td[3]")).getText();
                    //System.out.println(contact_web);
                    email_Web = driver.findElement(By.xpath("//*[@id='dvsearchable']/div/table/thead[2]/tr/td[4]")).getText();

                    if (contact_web.equals(contact) && reference_Web.equals(referenceCode)) {
                        utils.setWebDriverFluentWait(1, 30, By.xpath("//*[@id='ddlSearchContact']/option[" + j + "]"));
                        //utils.click()
                        arrayList.add(email_Web);
                        // System.out.println("+++++++++++++++++++++" + email_Web);

                        listCompanyName.get(j).click();
                    }
                }
                utils.click(req.getcurrencyDropDownClick, driver);
                Thread.sleep(2000L);
                List<WebElement> listCurrencyDropDown = req.getGetCurrencyDropDown;
                for (int k = 1; k < listCurrencyDropDown.size(); k++) {
                    String currency_web = listCurrencyDropDown.get(k).getText();
                    //System.out.println(currency_web);
                    if (currency_web.equals(currency)) {
                        listCurrencyDropDown.get(k).click();
                    }

                }
                req.getAmountTextBox.sendKeys(amount);
                String amount_str = req.getAmountTextBox.getAttribute("value");
                String gstAmount = req.getGstAmountField.getAttribute("value");
                if (gstAmount.equals("GST Rate")) {
                    gstAmount = "@ 0.00%";

                }
                String netTerms_st = req.getNetTerms.getAttribute("value");
                if (netTerms_st.equals("Pay on receipt")) {
                    netTerms_st = "0";

                }

                String invoiceDate = req.getInvoiceDateTextBox.getAttribute("value");
                if (invoiceDate.isEmpty() == true) {
                    utils.getCurrentDataTime();
                    invoiceDate = utils.date;

                }

                String remarks_str = req.getRemarks.getAttribute("value");
                System.out.println("Remarks: " + remarks_str);
                System.out.println("invoiceDate: " + invoiceDate);
                System.out.println("netTerms_st: " + netTerms_st);
                System.out.println("gstAmount: " + gstAmount);
                arrayList1.add(remarks_str);
                arrayList1.add(invoiceDate);
                arrayList1.add(netTerms_st);
                arrayList1.add(gstAmount);
                arrayList1.add(amount_str);
                utils.click(req.getBookAnotherButton, driver);


            }
        }

    }

    @And("^I check booked transactions tab$")
    public void iCheckBookedTransactionsTab() throws Throwable {
        utils.click(req.getBookedTransactions, driver);
        String youHaveNoTransactopns_Str = req.getNoTransactionFound.getAttribute("innerText");
        //System.out.println("Msg is : " + youHaveNoTransactopns_Str);
        if (youHaveNoTransactopns_Str.equals("You have no transactions")) {
            System.out.println(" no contact found please enter valid contact");
            Assert.assertTrue(false);
        }
        Thread.sleep(3000L);
    }

    @Then("^I should see book transactions$")
    public void iShouldSeeBookTransactions() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        List<WebElement> listCheckBox = req.getBookedTransactionsCheckBox;
        for (int i = 0; i < listCheckBox.size(); i++) {
            boolean checkbox = listCheckBox.get(i).isDisplayed();
            Assert.assertTrue(checkbox, "Check box is not displaying");
            System.out.println("Check box is displayed");
        }

        List<WebElement> listContact = req.getListOfContact;
        for (int j = 0; j < listContact.size(); j++) {
            String contact_str = listContact.get(j).getAttribute("innerText");
            String amount_str = req.getAmount.get(j).getAttribute("innerText");
            String currencyCode_Str = req.getCurrencyCode.get(j).getAttribute("innerText");
            //System.out.println("Currency code is: " + currencyCode_Str);
            String dueDate_Str = req.getDueDate.get(j).getAttribute("innerText");
            //System.out.println("Due date is: " + dueDate_Str);
            String bookedStatus_str = req.getBookedStatus.get(j).getAttribute("innerText");
            //System.out.println("Status is: " + bookedStatus_str);
            // System.out.println(contact_str);
            //System.out.println("Company name from booked transactions: " + contact_str + "\n table size: " + datTableList.size());
            for (int k = 1; k < dataTable_List.size(); k++) {
                String tableContact = dataTable_List.get(k).get(1);
                String tableContact_Amount = dataTable_List.get(k).get(0);
                //System.out.println("table contact: " + tableContact);
                if (contact_str.equals(tableContact) && amount_str.equals(tableContact_Amount)) {
                    Assert.assertTrue(listContact.get(j).getAttribute("innerText").equals(companyName), "Contact name not matched");
                    System.out.println("company name is matched on booked transaction screen");
                    Assert.assertTrue(req.getAmount.get(j).getAttribute("innerText").equals(amount_str), "Amount is not matched");
                    System.out.println("Amount is matched on booked transaction screen");
                    Assert.assertTrue(req.getCurrencyCode.get(j).getAttribute("innerText").equals(currency_Str), "currency code is not matched");
                    System.out.println("currency code is matched on booked transaction screen");
                    Assert.assertTrue(req.getDueDate.get(j).getAttribute("innerText").equals(invoiceDate), "Due date is not matched");
                    System.out.println("Due date is matched on booked transaction screen");
                    Assert.assertTrue(bookedStatus_str.equals("Booked"), "status is not matched");
                    System.out.println("status is matched on booked transaction screen");

                }
            }

        }
    }

    @And("^I click on select all radio button$")
    public void iClickOnSelectAllRadioButton() throws Throwable {
        List<WebElement> listCheckBox = req.getCheckBox;
        for (int i = 0; i < listCheckBox.size(); i++) {
            utils.click(listCheckBox.get(i), driver);
            utils.log4j("I selected check box button");
        }
    }

    @And("^I click on send request button$")
    public void iClickOnSendRequestButton() throws Throwable {
        Assert.assertTrue(req.getSendRequestButton.isDisplayed(),"Send Request Button is not present");
        utils.click(req.getSendRequestButton, driver);
        Thread.sleep(2000L);
        utils.log4j("I clicked on send request button");
        currentTimeIs = utils.getCurrentTime();
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        Date dateobj = new Date();
        String newStr = df.format(dateobj);
        String strSpace = " ";
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("hh:mm a");
        LocalDateTime now = LocalDateTime.now();
        String currentTime = dtf.format(now);
        compareDate = newStr.concat(strSpace).concat(currentTime);
        //System.out.println("currentTimeIs: " + currentTimeIs);
        Thread.sleep(5000);
    }

    @Then("^I see validation msg in green color$")
    public void iSeeValidationMsgInGreenColor() throws Throwable {
        utils.waitUntilElelemntShouldBeDisplay(driver, By.xpath("//div[@class='alert-strip success-alert']"), 30);
        msg = req.getvalidationMsgStrip.getText();
        utils.retryingToFindElement(req.getvalidationMsgStrip, "getText");
        if(msg.equalsIgnoreCase("Request(s) sent successfully.")) {
            Assert.assertTrue(msg.equals("Request(s) sent successfully."));
        }else {
            System.out.println("msg is: "+msg);
            Assert.assertTrue(msg.equals("Payment collection request(s) sent."));
        }
        utils.log4j("After click on send request button validation msg is matched: " + msg);

    }

    @And("^I should redirect on track collections page$")
    public void iShouldRedirectOnTrackCollectionsPage() throws Throwable {
        utils.log4j("--------------------------------Track Collection page---------------------------------");
        String trackCollectionStr = req.getTrackCollectionPage.getText();
//        System.out.println("Line 694: "+trackCollectionStr);
        Thread.sleep(5000);
        Assert.assertTrue(trackCollectionStr.equals("Track Collections"), "Not redirecting on TRACK COLLECTIONS page");
        utils.log4j("I on " + trackCollectionStr + " page");
    }

    @And("^I verify track collection request and status$")
    public void iVerifyTrackCollectionRequestAndStatus() throws Throwable {
        for (int i = 1; i < dataTable_List.size(); i++) {
            String companyName = dataTable_List.get(i).get(1);
            utils.click(driver.findElement(By.xpath("//div[@class='toggle-card']")), driver);
            utils.click(req.getAllCompanyNameDropDownClick, driver);
            List<WebElement> companyNaefromDropDown = driver.findElements(By.xpath("//*[@id='ContentPlaceHolder1_ddlContacts_select']/li"));
            for (int j = 0; j < companyNaefromDropDown.size(); j++) {
                //utils.waitUntilElelemntShouldBeDisplay(driver, By.xpath("//*[@id='ContentPlaceHolder1_ddlContacts_select']/li["+j+"]"), 30);
                // utils.setWebDriverFluentWait(1, 30, By.xpath("//*[@id='ContentPlaceHolder1_ddlContacts_select']/li['j+']"));
                // utils.scrollTo(companyNaefromDropDown.get(j));
                utils.retryingToFindElement(companyNaefromDropDown.get(j), "getText");
                if (companyName.equals(utils.str)) {
                    utils.retryingToFindElement(companyNaefromDropDown.get(j), "click");
                    //utils.wait(300);
                    Thread.sleep(2000L);
                    utils.click(req.getCalendar, driver);
                    utils.click(req.getApplyButton, driver);
                    utils.click(req.getFilterButton, driver);
                    List<WebElement> listCompany = req.getCompanyNameFromTrackCollections;
                    for (int k = 0; k < listCompany.size(); k++) {
                        utils.setWebDriverFluentWait(1, 30, By.xpath("//*[@id='ContentPlaceHolder1_gvRequests']/tbody/tr/td[1]['+ k + ']"));
                        utils.retryingToFindElement(listCompany.get(k), "getText");
                        String compnay_Name = utils.str;
                        //listCompany.get(k).getText();
                        if (!"You have no transactions".equals(compnay_Name)) {
                            //Assert.assertTrue(compnay_Name.equals(companyName), "Not matching");
                            System.out.println(compnay_Name);
                        }

                    }
                }
                utils.click(driver.findElement(By.xpath("//div[@class='toggle-card']")), driver);
                utils.click(req.getFilterClearButton, driver);
                Thread.sleep(2000L);
                utils.click(driver.findElement(By.xpath("//div[@class='toggle-card']")), driver);
                utils.click(req.getAllCompanyNameDropDownClick, driver);
            }

        }

    }


    @And("^I click on booked transactions tab$")
    public void iClickOnBookedTransactionsTab() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        String str = req.getBookedTransactions.getAttribute("aria-selected");
        if (str.equals("false")) {
            req.getBookedTransactions.click();
            Thread.sleep(2000L);
        } else {
            System.out.println("Booked transaction tab already is clicked");
        }

    }

    @Then("^I see respective fields$")
    public void iSeeRespectiveFields() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        WebElement radioButton = req.getRadioButton;
        /*boolean radioButtonIsDisplayed = radioButton.isDisplayed();
        System.out.println("radioButtonIsDisplayed" + radioButtonIsDisplayed);
        Assert.assertTrue(radioButtonIsDisplayed, "Radio button is not displayed");*/
        boolean radioButtonIsEnabled = radioButton.isEnabled();
        // System.out.println("radioButtonIsEnabled" + radioButtonIsEnabled);
        Assert.assertTrue(radioButtonIsEnabled, "Radio button is not enabled");
        boolean radioButtonIsSelected = radioButton.isSelected();
        //System.out.println("radioButtonIsSelected" + radioButtonIsSelected);
        Assert.assertFalse(radioButtonIsSelected, "Radio button is selected");
    }

    @And("^I see transaction if there is any booked transaction other wise \"([^\"]*)\" msg should be display$")
    public void iSeeTransactionIfThereIsAnyBookedTransactionOtherWiseMsgShouldBeDisplay(String arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        String guidanceText = req.getGuidanceText.getText();
        System.out.println("" + guidanceText);
        Assert.assertTrue
                (
                        guidanceText.equals("Click send request below to confirm the booked requests")
                );

        int count = 0;
        System.out.println("Table heading");
        List<WebElement> listTableHeading = req.getTableHeading;
        for (WebElement ele : listTableHeading
        ) {

            String headingstr = ele.getText();
            System.out.println("" + headingstr);
            switch (headingstr) {
                case "Contact":
                    Assert.assertTrue(headingstr.equals("Contact"));
                    System.out.println(headingstr);
                    break;

                case "Payable Amount":
                    Assert.assertTrue(headingstr.equals("Payable Amount"));
                    System.out.println(headingstr);
                    break;
                case "Currency Code":
                    Assert.assertTrue(headingstr.equals("Currency Code"));
                    System.out.println(headingstr);
                    break;
                case "Due Date":
                    Assert.assertTrue(headingstr.equals("Due Date"));
                    System.out.println(headingstr);
                    break;
                case "Status":
                    Assert.assertTrue(headingstr.equals("Status"));
                    System.out.println(headingstr);
                    break;
                case "Action":
                    Assert.assertTrue(headingstr.equals("Action"));
                    System.out.println(headingstr);
                    break;
            }
        }
        String youHaveNoTransactopns_Str = req.getNoTransactionFound.getAttribute("innerText");
        //System.out.println("Msg is : " + youHaveNoTransactopns_Str);
        if (youHaveNoTransactopns_Str.equals(arg0)) {
            System.out.println("There is no booked transactions");
        } else {
            List<WebElement> listContact = req.getContactData;
            for (WebElement element : listContact
            ) {
                String text = element.getAttribute("innerText");
                System.out.println("Booked contact is: " + text);
            }

        }
    }


    @Then("^I see booked transaction tab is expanded$")
    public void iSeeBookedTransactionTabIsExpanded() throws Throwable {
        String bookedTransactionExpaned = req.getBookedTransactions.getAttribute("aria-expanded");
        if (bookedTransactionExpaned.equals("true")) {
            utils.log4j("Booked transaction tab is expanded");
        } else {
            Assert.assertTrue(false, "Booked transaction tab is not expanded");
        }

    }

    @Then("I check booked details in Booked transaction tab")
    public void iCheckBookedDetailsInBookedTransactionTab() {
        System.out.println("Line number 835");
        List<WebElement> bookedHeading = reports_pom.getBookedTableHeading;
        List<WebElement> bookedData = reports_pom.getBookedTableData;
        arrayList = new ArrayList<>();
        arrayList1 = new ArrayList<>();
        for (WebElement element : bookedHeading) {
            String heading = element.getText();
            String data = bookedData.get(count).getText();
            System.out.println(heading + ":" + data);

            switch (heading) {
                case "Contact":
                    Assert.assertTrue(heading.equals("Contact"), "Contact heading not matched");
                    arrayList.add(data);
                    break;
                case "Payable Amount":
                    Assert.assertTrue(heading.equals("Payable Amount"), "Payable Amount heading not matched");
                    BigDecimal total = utils.calculateGST(new BigDecimal(amount_str), new BigDecimal(GST_Rate_Str));
                    System.out.println(total.add(new BigDecimal(amount_str)));
                   amtInString = total.add(new BigDecimal(amount_str)).toString();
                    System.out.println(amtInString);
                    arrayList.add(data.replace(",",""));
                    break;
                case "Currency Code":
                    Assert.assertTrue(heading.equals("Currency Code"), "Currency Code heading not matched");
                    arrayList.add(data);
                    break;
                case "Due Date":
                    Assert.assertTrue(heading.equals("Due Date"), "Due Date heading not matched");
                    Assert.assertFalse(data.isEmpty());
                    break;
                case "Status":
                    Assert.assertTrue(heading.equals("Status"), "Status heading not matched");
                    Assert.assertTrue(data.equals("Booked"));
                    break;
                case "Action":
                    Assert.assertTrue(heading.equals("Action"), "Action heading not matched");
                    Assert.assertTrue(req.getEditIcon.isDisplayed(),"Edit icon not present");
                    req.actionDropdown.click();
                    utils.scrollDown();
                    Assert.assertTrue(req.getDeleteIcon.isDisplayed(),"Delete icon not present");
                    break;
            }
            count++;
        }

        arrayList1.add(contactName_Str);
        arrayList1.add(amtInString);
        arrayList1.add(currency_Str);
        System.out.println(arrayList.equals(arrayList1));
        System.out.println("Size of arraylist:" + arrayList.size() + "Array list 1 size" + arrayList1.size());
//        Assert.assertTrue(arrayList.equals(arrayList1), "Not Matched");


        System.out.println("Size of arraylist:" + arrayList.size() + "Array list 1 size" + arrayList1.size());
    }


    @And("^I  select company name and click on continue button$")
    public void iSelectCompanyNameAndClickOnContinueButton(DataTable dataTable) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        arrayList = new ArrayList<String>();
        arrayList1 = new ArrayList<String>();
        dataTable_List = dataTable.cells();

        for (int i = 1; i < dataTable_List.size(); i++) {
            contactName_Str = dataTable_List.get(i).get(0);
            // System.out.println(contactName_Str);
            Amount_Str = dataTable_List.get(i).get(1);
            //System.out.println(Amount_Str);
            reference_code_Str = dataTable_List.get(i).get(2);
            //System.out.println(reference_code_Str);
            currency_Str = dataTable_List.get(i).get(3);
            //System.out.println(currency_Str);

            utils.click(req.getCompanyNameDropDown, driver);
            Thread.sleep(2000L);
            List<WebElement> listCompanyName = req.getCompanyNameOptions;
            for (int j = 1; j < listCompanyName.size(); j++) {
                String contact_web = req.getCompanyNameOptions.get(j).getAttribute("innerText");
                //System.out.println("Web Contact: " + contact_web);
                utils.mouseMove(req.getCompanyNameOptions.get(j));
                String reference_Web = driver.findElement(By.xpath("//*[@id='dvsearchable']/div/table/thead[2]/tr/td[3]")).getText();
                //System.out.println("reference_Web" + reference_Web);
                email_Web = driver.findElement(By.xpath("//*[@id='dvsearchable']/div/table/thead[2]/tr/td[4]")).getAttribute("innerText");
                //System.out.println("email_Web: " + email_Web);
                if (contact_web.equals(contactName_Str) && reference_Web.equals(reference_code_Str)) {
                    utils.setWebDriverFluentWait(1, 30, By.xpath("//*[@id='ddlSearchContact']/option[" + j + "]"));
                    //utils.click()
                    arrayList.add(email_Web);
                    //System.out.println("+++++++++++++++++++++" + email_Web);
                    listCompanyName.get(j).click();
                    System.out.println("I selected company name: " + contact_web);
                    break;
                }
            }
            utils.click(req.getcurrencyDropDownClick, driver);
            Thread.sleep(2000L);
            List<WebElement> listCurrencyDropDown = req.getGetCurrencyDropDown;
            System.out.println(listCurrencyDropDown.size());
            for (int k = 0; k < listCurrencyDropDown.size(); k++) {
                currency_web = listCurrencyDropDown.get(k).getText();
                System.out.println("currency_web: " + currency_web);
                if (currency_web.equals(currency_Str)) {
                    listCurrencyDropDown.get(k).click();
                    System.out.println("I selected " + currency_web + "currency");
                    break;
                }
            }
            req.getAmountTextBox.sendKeys(Amount_Str);
            amount_str = req.getAmountTextBox.getAttribute("value");
            System.out.println("amount_str: " + amount_str);
            gstAmount = req.getGstAmountField.getAttribute("value");
            System.out.println("I enter " + amount_str + currency_web + "amount");
            if (gstAmount.equals("GST Rate")) {
                gstAmount = "@ 0.00%";

            }
            netTerms_st = req.getNetTerms.getAttribute("value");
            if (netTerms_st.equals("Pay on receipt")) {
                netTerms_st = "0";

            }

            invoiceDate = req.getInvoiceDateTextBox.getAttribute("value");
            if (invoiceDate.isEmpty() == true) {
                utils.getCurrentDataTime();
                invoiceDate = utils.date;

            }
            remarksFromRequestPaymentPage = req.getRemarksFromRequestPaymentPage.getAttribute("value");
            System.out.println("remarksFromRequestPaymentPage: " + remarksFromRequestPaymentPage);
            invoiceNo = req.getInvoiceNo.getAttribute("value");
            String remarks_str = req.getRemarks.getAttribute("value");
            System.out.println("Remarks is: " + remarks_str);
            System.out.println("Invoice date is: " + invoiceDate);
            System.out.println("Net Terms is: " + netTerms_st);
            System.out.println("GST amount is: " + gstAmount);

            /*arrayList1.add(remarks_str);
            arrayList1.add(invoiceDate);
            arrayList1.add(netTerms_st);
            arrayList1.add(gstAmount);
            arrayList1.add(amount_str);*/
            //utils.click(req.getBookAnotherButton, driver);
        }
    }

    @And("^I redirect on payment report page$")
    public void iRedirectOnPaymentReportPage() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        utils.waitUntilElelemntShouldBeDisplay(driver, By.xpath("//*[@id='PnlMain']/div/div[1]/h1"), 30);
        String reportPageText = req.getPaymentsPageReport.getAttribute("innerText");
        System.out.println("I am on " + reportPageText + "report page");
        Thread.sleep(1000L);
    }

    @And("^I check transaction report$")
    public void iCheckTransactionReport() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        // utils.click(driver.findElement(By.xpath("//*[@id='PnlMain']/div/div[2]/div[1]/div[1]")), driver);
        utils.log4j("--------------------------------TRANSACTION REPORT--------------------------------------------------");
        utils.click(driver.findElement(By.xpath("//div[@class='toggle-card']")), driver);
        Thread.sleep(500L);
        utils.log4j("I Clicked On Filter ");
        //System.out.println("Reference number: " + referenceNo_str);
        req.getTransactionIdReport.sendKeys(transactionId);
        Thread.sleep(500L);
        utils.log4j("I Enter Transction ID");
        utils.click(driver.findElement(By.name("ctl00$ContentPlaceHolder1$btnFilter")), driver);
        Thread.sleep(2000L);
        List<WebElement> listTableHeading = req.getPaymentReportTableHeading;
        for (int i = 0; i < listTableHeading.size(); i++) {
            String headingTable = listTableHeading.get(i).getText();

            String tableData = req.getPaymentReportTableData.get(i).getText();

            System.out.println(headingTable + " :" + tableData);
        }
        utils.click(req.getGetViewHistoryFromReport, driver);
        utils.waitUntilElelemntShouldBeDisplay(driver, By.xpath("//*[contains(text(),'Payment Summary')]"), 30);
        String paymentSummeryTxt = req.getPaymentSummeryTitle.getAttribute("innerText");
        System.out.println("i am on" + paymentSummeryTxt + "Page");

        List<WebElement> listPageData = req.getPaymentHistoryPage;

        for (int j = 0; j < listPageData.size(); j++) {
            String txt = listPageData.get(j).getText();

            String data = req.getPaymentHisroryPageData.get(j).getText();
            System.out.println(txt + ": " + data);
        }
    }

    @And("^I check collection report of request business$")
    public void iCheckCollectionReportOfRequestBusiness() throws Throwable {
        utils.PMXLogOut();
        utils.readPropertiesFile(propertiesFileUrl);
        String userName = utils.obj.getProperty("emailLogin");
        String password = utils.obj.getProperty("password_Login");
        utils.pMXLogin(userName, password);
        Thread.sleep(2000L);
        WebElement clickMenu = driver.findElement(By.xpath("//*[@id='header']/nav/div/div[1]/a[1]/i"));
        utils.click(clickMenu, driver);
        utils.log4j("I clicked On Menu");
        utils.click(req.clickOnReport, driver);
        utils.log4j("I clicked On Report Link");
        utils.click(req.collectionReport, driver);
        utils.log4j("I clicked On Collections Report");
        String pageTitle = req.collectionReportPageTitle.getText();
        Assert.assertTrue(pageTitle.equals("COLLECTIONS"), "user not redirecting on collection page");
        utils.log4j("I am on " + pageTitle + " page");
        Thread.sleep(1000L);
        utils.waitElementShouldBeClickable(con.getFilterClick);
        utils.click(con.getFilterClick,driver);
        utils.log4j("I Click On Filter");
        System.out.println("Reference number: " + referenceNo_str);
        req.getTransactionIdReport.sendKeys(referenceNo_str);
        utils.log4j("I Enter Transaction ID ");
        utils.click(driver.findElement(By.name("ctl00$ContentPlaceHolder1$btnFilter")), driver);
        utils.log4j("I Clicked on Filter Button");
        Thread.sleep(2000);
        utils.log4j("Checking field Company Name");
        businessReports.getReports("Company Name",reports_pom.getCollectionsPageTableData,reports_pom.getCollectionsPageTableHeading);
        businessReports.dataList2.add(businessReports.data);
        utils.log4j("Checking field Reference Code");
        businessReports.getReports("Reference Code",reports_pom.getCollectionsPageTableData,reports_pom.getCollectionsPageTableHeading);
        businessReports.dataList2.add(businessReports.data);
        utils.log4j("Checking field Transaction ID");
        businessReports.getReports("Transaction ID",reports_pom.getCollectionsPageTableData,reports_pom.getCollectionsPageTableHeading);
        Assert.assertFalse(businessReports.field,"Field is empty");
        utils.log4j("Checking field Transaction Date");
        businessReports.getReports("Transaction Date",reports_pom.getCollectionsPageTableData,reports_pom.getCollectionsPageTableHeading);
        Assert.assertFalse(businessReports.field,"Field is empty");
        utils.log4j("Checking field Payment From");
        businessReports.getReports("Payment From",reports_pom.getCollectionsPageTableData,reports_pom.getCollectionsPageTableHeading);
        Assert.assertFalse(businessReports.field,"Field is empty");
        utils.log4j("Checking field Received Amount");
        businessReports.getReports("Received Amount",reports_pom.getCollectionsPageTableData,reports_pom.getCollectionsPageTableHeading);
        businessReports.dataList2.add(businessReports.data.replace(",", ""));
        utils.log4j("Checking field Currency");
        businessReports.getReports("Currency",reports_pom.getCollectionsPageTableData,reports_pom.getCollectionsPageTableHeading);
        businessReports.dataList2.add(businessReports.data);
        utils.log4j("Checking field Invoice Number");
        businessReports.getReports("Invoice Number",reports_pom.getCollectionsPageTableData,reports_pom.getCollectionsPageTableHeading);
        businessReports.dataList2.add(businessReports.data);
        utils.log4j("Checking field Settlement Amount");
        businessReports.getReports("Settlement Amount",reports_pom.getCollectionsPageTableData,reports_pom.getCollectionsPageTableHeading);
        Assert.assertEquals(businessReports.data,"00.00");
        utils.log4j("Checking field Bank Reference No");
        businessReports.getReports("Bank Reference No",reports_pom.getCollectionsPageTableData,reports_pom.getCollectionsPageTableHeading);
        Assert.assertFalse(businessReports.field,"Field is not empty");
        utils.log4j("Checking field Settlement Status");
        businessReports.getReports("Settlement Status",reports_pom.getCollectionsPageTableData,reports_pom.getCollectionsPageTableHeading);
        Assert.assertEquals(businessReports.data,"Awaiting Payment");
        utils.log4j("Checking field Actions");
        businessReports.getReports("Actions",reports_pom.getCollectionsPageTableData,reports_pom.getCollectionsPageTableHeading);
        Assert.assertTrue(businessReports.field);
        arrayList = new ArrayList<>();
        arrayList.add(contactName_Str);
        arrayList.add(reference_code_Str);
        arrayList.add(amtInString);
        arrayList.add(currency_Str);
        arrayList.add(invoiceNumber);
        System.out.println(arrayList.equals(businessReports.dataList2));
        /*List<WebElement> tableHeadingList = req.getCollectionPageTableHeading;
        for (int k = 0; k < tableHeadingList.size(); k++) {
            String heading = tableHeadingList.get(k).getText();
            String data = req.getCollectionPageData.get(k).getText();
            requestPaymentDataToCompare req1 = new requestPaymentDataToCompare();
            List<String> list12 = new ArrayList<>();
            list12.add(req.getCollectionPageData.get(k).getText());
            req1.setListTitles(list12);
            System.out.println("List is:: " + list12);
        }
        // System.out.println(heading + " :" + data);

*/
    }

    @And("^I settle amount from PMX admin$")
    public void iSettleAmountFromPMXAdmin() throws Throwable {
        utils.log4j("----------------------------------PMX BACKEND ADMIN LOGIN------------------------------------");
        environments = new Environments();
        if (environments.env.equals("qa") || environments.env.equals(null)) {
            driver.navigate().to("https://dev.paymate.in/Beta/PayMateAdmin/Login.aspx");
            utils.log4j("I Enter URL");
        } else if (environments.env.equals("uat")) {
            driver.navigate().to("Uat");
            utils.log4j("I Enter URL");
        } else if (environments.env.equals("prod")) {
            driver.navigate().to("production");
            utils.log4j("I Enter URL");
        }

        driver.findElement(By.name("ctl00$cphContents$txtUserName")).sendKeys("vishall@yopmail.com");
        utils.log4j("I Enter User Name");
        driver.findElement(By.name("ctl00$cphContents$txtPassword")).sendKeys("Paymate@123");
        utils.log4j("I enter password");
        driver.findElement(By.name("ctl00$cphContents$btnLogin")).click();
        utils.log4j("I clicked on login button");
        Thread.sleep(2000L);
        utils.waitUntilElelemntShouldBeDisplay(driver, By.xpath("//*[@id='Ulmenu']/li[3]"), 30);
        utils.mouseMove(driver.findElement(By.xpath("//*[@id='Ulmenu']/li[3]")));
        utils.log4j("Mouse IS Moving To Settlement");
        Thread.sleep(1000L);
        utils.mouseMove(driver.findElement(By.xpath("//*[@id='Ulmenu']/li[3]/ul/li[1]/a")));
        Thread.sleep(1000L);
        utils.log4j("Mouse IS Moving To Received Payment");
        driver.findElement(By.xpath("//*[@id='Ulmenu']/li[3]/ul/li[1]/a")).click();
        utils.waitUntilElelemntShouldBeDisplay(driver, By.xpath("//*[@id='UpnlHome']/div[2]/div/div/h4"), 30);
        String settlementTextHeading = driver.findElement(By.xpath("//*[@id='UpnlHome']/div[2]/div/div/h4")).getText();
        Assert.assertTrue(settlementTextHeading.equals("Received Payments"), "user not redirecting on Received Payments page");
        utils.log4j("------------------------------------------ " + settlementTextHeading + " -------------------------------");

        utils.waitUntilWebElelemntShouldBeDisplay(driver, req.getCompanyName, 30);
//        req.getCompanyName.sendKeys(contactName_Str);
        req.getCompanyName.sendKeys("ihokrgaxx.LTD");
        System.out.println("Company name is: " + contactName_Str);
        /*WebElement element = driver.findElement(By.id("ddlParentCompany"));
        Select sel = new Select(element);
        element.click();
        utils.log4j("I clicked On Business Name Drop Down");
        List<WebElement> options = driver.findElements(By.xpath("//select[@id='ddlParentCompany']/option"));
        System.out.println(emailCompanyName);
        for (WebElement element1 : options) {
            String bName = element1.getText();
            //System.out.println("Business Name: " + bName);
            if (bName.equals(emailCompanyName)) {
                element1.click();
                utils.log4j("I Select Business Name   " + bName);
                break;
            }
        }*/
        utils.waitUntilWebElelemntShouldBeDisplay(driver, req.getDateRange, 30);
        utils.click(req.getDateRange, driver);
        utils.log4j("I Select Date Range");
        Thread.sleep(2000L);
        driver.findElement(By.xpath("//*[@class='applyBtn btn btn-sm btn-success']")).click();
        utils.log4j("I clicked On Apply Button");
        utils.waitUntilElelemntShouldBeDisplay(driver, By.name("ctl00$InternalCntHolder$btnFilter"), 30);
        utils.click(driver.findElement(By.name("ctl00$InternalCntHolder$btnFilter")), driver);
        utils.log4j("I clicked On Filter Button");
        Thread.sleep(2000L);
        System.out.println("PMX Heading size: "+reports_pom.getPMXPageTableHeading.size()+"----"+reports_pom.getPMXPageTableData.size()+" PMX Data size");
        businessReports.getReports("Business Name",reports_pom.getPMXPageTableData,reports_pom.getPMXPageTableHeading);
        Assert.assertFalse(businessReports.field);
        businessReports.getReports("Trx. ID",reports_pom.getPMXPageTableData,reports_pom.getPMXPageTableHeading);
        Assert.assertFalse(businessReports.field);
        businessReports.getReports("Trx. Date",reports_pom.getPMXPageTableData,reports_pom.getPMXPageTableHeading);
        Assert.assertFalse(businessReports.field);
        businessReports.getReports("Trx. Time",reports_pom.getPMXPageTableData,reports_pom.getPMXPageTableHeading);
        Assert.assertFalse(businessReports.field);
        businessReports.getReports("Company Name",reports_pom.getPMXPageTableData,reports_pom.getPMXPageTableHeading);
        businessReports.dataList3.add(businessReports.data);
        businessReports.getReports("Type of Payment",reports_pom.getPMXPageTableData,reports_pom.getPMXPageTableHeading);
        Assert.assertFalse(businessReports.field);
        businessReports.getReports("Amount",reports_pom.getPMXPageTableData,reports_pom.getPMXPageTableHeading);
        Assert.assertFalse(businessReports.field);
        businessReports.getReports("Currency",reports_pom.getPMXPageTableData,reports_pom.getPMXPageTableHeading);
        businessReports.dataList3.add(businessReports.data);
        businessReports.getReports("Status",reports_pom.getPMXPageTableData,reports_pom.getPMXPageTableHeading);
        Assert.assertEquals(businessReports.data,"Pending");
        arrayList = new ArrayList<>();
        arrayList.add(contactName_Str);
        arrayList.add(currency_Str);
        System.out.println(arrayList.equals(businessReports.dataList3));
        req.getSortTrxTime.click();
        Thread.sleep(2000L);
        System.out.println("Clicked once");
        utils.waitUntilWebElelemntShouldBeDisplay(driver, req.getSortTrxTime, 30);
        req.getSortTrxTime.click();
        Thread.sleep(2000L);
        System.out.println("Clicked twice");
//        List<WebElement> listTime = driver.findElements(By.xpath("//*[@id='InternalCntHolder_gvReceivedPayment']/tbody/tr/td[5]"));
        List<WebElement> listCheckBox = driver.findElements(By.id("cbSelect"));
        utils.waitUntilElelemntShouldBeDisplay(driver, By.id("cbSelect"), 30);
        listCheckBox.get(0).click();
       /* int count2 = 0;
        for (WebElement webElement : listTime) {
            String timeIs = webElement.getText();
            //System.out.println(timeIs);

            String fff = timeIs.substring(0, 5);
            //System.out.println(fff);
            String gg = timeIs.substring(8, 11);
            //System.out.println(gg);
            String conStr = fff.concat(gg);
            // System.out.println(conStr);
            //System.out.println(timeIs + "===" + currentTimeIs + "Time is matched");
            if (conStr.equals(currentTimeIs)) {
                //System.out.println(conStr + "===" + currentTimeIs + "Time is matched");
                utils.click(listCheckBox.get(count2), driver);
                List<WebElement> listData = driver.findElements(By.xpath("//*[@class='gradeX tabletds odd']/td"));
                for (WebElement element1 : listData) {
                    String dataIs = element1.getText();
                    System.out.println(dataIs);
                }*/
        utils.click(driver.findElement(By.id("btnCheck")), driver);
        String stText = driver.findElement(By.xpath("//h4[@id='myModalLabel']")).getText();
        System.out.println("I on " + stText + " Page");
        List<WebElement> listSetTransactions = driver.findElements(By.xpath("//*[@class='tblsum']//tr/th"));
        int count = 0;
        for (WebElement element1 : listSetTransactions) {
            String tableHeading = element1.getText();
            String data = driver.findElements(By.xpath("//span[contains(@id,'lbl')]")).get(count).getText();
            System.out.println(tableHeading);
            System.out.println(data);
            count++;
        }
        utils.click(driver.findElement(By.id("btnConfirm")), driver);
//                break;
//            }
//            count2++;
//        }

        utils.waitUntilElelemntShouldBeDisplay(driver, By.xpath("//*[@class='toast-message']"), 30);
        String toastMsg = driver.findElement(By.xpath("//*[@class='toast-message']")).getText();
        Assert.assertTrue(toastMsg.equals("Payments approved successfully"), "Invalid toast msg");
        System.out.println("Settlement of: " + toastMsg);
        System.out.println("Settlement is done");
    }




    @And("I check collection report and payment reports")
    public void iCheckCollectionReportAndPaymentReports(DataTable dataTable) throws InterruptedException, IOException {
        List<List<String>> data = dataTable.cells();
        ArrayList<String> arrayList3 = new ArrayList<>();
        System.out.println("ArrayList3 Data is :" + data.get(1).get(0));
        System.out.println("ArrayList3 Data is :" + data.get(1).get(1));
        System.out.println("ArrayList3 Data is :" + data.get(1).get(2));
        System.out.println("ArrayList3 Data is :" + data.get(1).get(3));
        arrayList3.add(data.get(1).get(0));
        arrayList3.add(data.get(1).get(1));
        arrayList3.add(data.get(1).get(2));
        arrayList3.add(data.get(1).get(3));
        utils.waitElementShouldBeClickable(con.dashBoardMenu);
        utils.clickDashboardMenu();
        Thread.sleep(2000L);
        utils.click(req.getReports, driver);
        List<WebElement> reportsTabList = req.getReportsMenu;
        for (WebElement element : reportsTabList) {
//            utils.waitListOFElementShouldBeClickable(req.getReportsMenu);
            String text = element.getAttribute("innerText");
            if (text.equals("Collections")) {
                System.out.println("Text is: " + text);
                utils.click(element, driver);
                Thread.sleep(2000L);
                break;
            }
        }
        utils.waitElementShouldBeClickable(con.getFilterClick);
        utils.click(con.getFilterClick, driver);
        req.getTransactionIdReport.sendKeys("005510071957");
//        req.getTransactionIdReport.sendKeys(referenceNo_str);
        utils.click(driver.findElement(By.cssSelector("#ContentPlaceHolder1_btnFilter")), driver);
        Thread.sleep(2000L);
        req.getGetViewHistoryFromCollectionReport.click();
        Thread.sleep(2000L);
        businessReports.getReports("Company Name", reports_pom.getTableData, reports_pom.getTableHeading);
        businessReports.dataList.add(businessReports.data);
        businessReports.getReports("Reference Code", reports_pom.getTableData, reports_pom.getTableHeading);
        businessReports.dataList.add(businessReports.data);
        businessReports.getReports("Payable Amount", reports_pom.getTableData, reports_pom.getTableHeading);
        businessReports.dataList.add(businessReports.data.replace(",", ""));

        businessReports.getReports("Currency", reports_pom.getTableData, reports_pom.getTableHeading);
        businessReports.dataList.add(businessReports.data);
        for (int i = 0; i < businessReports.dataList.size(); i++) {
            System.out.println(businessReports.dataList.get(i));
        }
        System.out.println(arrayList3.equals(businessReports.dataList));
        reports_pom.getCloseButton.click();
        utils.PMXLogOut();
        utils.log4j("I logOut Pmx");
        Thread.sleep(1000L);
        // System.out.println(arrayLis1=arrayList3);
        /*List<WebElement> test = driver.findElements(By.xpath("//*[starts-with(@id,'ContentPlaceHolder1_gv') or starts-with(@id,'ContentPlaceHolder1_get')]//tr/td"));
        for (int i = 0; i < test.size(); i++) {
            System.out.println(test.get(i).getText());

        }*/

    }

    @And("I check payment reports")
    public void iCheckPaymentReports() throws IOException, InterruptedException {
        String linkToclick = null;
        utils.readPropertiesFile(propertiesFileUrl);
        String email = utils.obj.getProperty("emailLogin");
        String password = utils.obj.getProperty("vendorPassword");
        System.out.println(email_Web+":"+password);
        utils.pMXLogin(email_Web, password);
        Thread.sleep(1000L);
        utils.waitElementShouldBeClickable(con.dashBoardMenu);
        utils.clickDashboardMenu();
        Thread.sleep(2000L);
        utils.click(req.getReports, driver);
        List<WebElement> reportsTabList = req.getReportsMenuVendor;
        for (WebElement element : reportsTabList) {
            utils.waitListOFElementShouldBeClickable(req.getReportsMenuVendor);
            String text = element.getText();
            if (text.equals("Payments")) {
                System.out.println("Text is: " + text);
                element.click();
                Thread.sleep(2000L);
                break;
            }
        }
        utils.pageLoadTime();
        Assert.assertEquals(con.getPageTitle.getText(), "Payments");
        utils.waitElementShouldBeClickable(con.getFilterClick);
        utils.click(con.getFilterClick, driver);
        System.out.println("Reference Number: "+referenceNo_str);
        req.getTransactionIdReport.sendKeys(referenceNo_str);
        utils.click(con.getFilterButton,driver);
        Thread.sleep(1000L);
//        utils.click(driver.findElement(By.cssSelector("#ContentPlaceHolder1_btnFilter")), driver);
        utils.waitUntilWebElelemntShouldBeDisplay(driver, req.getGetViewHistoryFromReport, 10);
        utils.click(req.getGetViewHistoryFromReport, driver);
        Thread.sleep(2000L);
        utils.log4j("Checking field Business Name");
        businessReports.getReports("Business Name", reports_pom.getPaymentsPageTableData, reports_pom.getPaymentsPageTableHeading);
        Assert.assertFalse(businessReports.field,"Field is empty");
        utils.log4j("Checking field Transaction ID");
        businessReports.getReports("Transaction ID", reports_pom.getPaymentsPageTableData, reports_pom.getPaymentsPageTableHeading);
        Assert.assertFalse(businessReports.field,"Field is empty");
        utils.log4j("Checking field Date");
        businessReports.getReports("Date", reports_pom.getPaymentsPageTableData, reports_pom.getPaymentsPageTableHeading);
        Assert.assertFalse(businessReports.field,"Field is empty");
        utils.log4j("Checking field Invoice No");
        businessReports.getReports("Invoice No", reports_pom.getPaymentsPageTableData, reports_pom.getPaymentsPageTableHeading);
        businessReports.dataList5.add(businessReports.data);
        utils.log4j("Checking field Type of Payment");
        businessReports.getReports("Type of Payment", reports_pom.getPaymentsPageTableData, reports_pom.getPaymentsPageTableHeading);
        Assert.assertFalse(businessReports.field,"Field is empty");
        utils.log4j("Checking field Paid Amount");
        businessReports.getReports("Paid Amount", reports_pom.getPaymentsPageTableData, reports_pom.getPaymentsPageTableHeading);
        businessReports.dataList5.add(businessReports.data.replace(",", ""));
        utils.log4j("Checking field Currency");
        businessReports.getReports("Currency", reports_pom.getPaymentsPageTableData, reports_pom.getPaymentsPageTableHeading);
        businessReports.dataList5.add(businessReports.data);
        utils.log4j("Checking field Bank Reference No");
        businessReports.getReports("Bank Reference No",reports_pom.getPaymentsPageTableData, reports_pom.getPaymentsPageTableHeading);
        Assert.assertFalse(businessReports.field,"Field is empty");
        utils.log4j("Checking field Status");
        businessReports.getReports("Status",reports_pom.getPaymentsPageTableData, reports_pom.getPaymentsPageTableHeading);
        Assert.assertEquals(businessReports.data,"Success");
        utils.log4j("Checking field Actions");
        businessReports.getReports("Actions",reports_pom.getPaymentsPageTableData, reports_pom.getPaymentsPageTableHeading);
        Assert.assertTrue(businessReports.field);
        arrayList2 = new ArrayList<>();
        arrayList2.add(invoiceNumber);
        arrayList2.add(amtInString);
        arrayList2.add(currency_Str);
//        Arrays.asList(arrayList2).removeAll(Arrays.asList(arrayList));
//        System.out.println("Array list 2: "+arrayList2);
//        System.out.println("Array List 1: "+arrayList);
//        System.out.println(arrayList2.size()+"array----datalist5"+businessReports.dataList5.size());
       /* for(int i=0;i<arrayList2.size();i++){
            System.out.println("Value in arraylist2: "+arrayList2.get(i));
        }*/
       /* for(int i=0;i<businessReports.dataList5.size();i++){
            System.out.println("Value in datalist5: "+businessReports.dataList5.get(i));
        }*/

        System.out.println(arrayList2.equals(businessReports.dataList5));

    }

    @And("^I enter following data and click on continue button$")
    public void iEnterFollowingDataAndClickOnContinueButton(DataTable dataTable) throws Throwable {
        String month = null;
        String year = null;
        String date1 = null;
        arrayList = new ArrayList<>();
        List<List<String>> listDataTable = dataTable.cells();
        System.out.println(listDataTable.size());
        utils.log4j("-----------------------------------REQUEST A PAYMENT----------------------------------------------");
        for (int i = 1; i < listDataTable.size(); i++) {
            contactName_Str = listDataTable.get(i).get(0);
            currency_Str = listDataTable.get(i).get(3);
            amount_str = listDataTable.get(i).get(1);
            GST_Str_DT = listDataTable.get(i).get(4);
            reference_code_Str = listDataTable.get(i).get(2);
            GST_Rate_Str = listDataTable.get(i).get(5);
            payOnReceipt_WT = listDataTable.get(i).get(6);
            System.out.println(reference_code_Str);
            utils.click(req.getCompanyNameDropDown, driver);
            invoiceDate = listDataTable.get(i).get(7);
            invoiceImgUrl = listDataTable.get(i).get(8);
            invoiceNumber = listDataTable.get(i).get(9);
            remarks_DT = listDataTable.get(i).get(10);
            mdrCharges_Dt = listDataTable.get(i).get(11);
            List<WebElement> listCompanyName = req.getCompanyNameOptions;
            for (int j = 1; j < listCompanyName.size(); j++) {
                String contact_web = req.getCompanyNameOptions.get(j).getText();
                System.out.println("Web Contact: " + contact_web);
                Thread.sleep(2000);
                utils.mouseMove(req.getCompanyNameOptions.get(j));
                String reference_Web = driver.findElement(By.xpath("//*[@id='dvsearchable']/div/table/thead[2]/tr/td[3]")).getText();
                //System.out.println("reference_Web" + reference_Web);
                email_Web = driver.findElement(By.xpath("//*[@id='dvsearchable']/div/table/thead[2]/tr/td[4]")).getAttribute("innerText");
                System.out.println("email_Web: " + email_Web);
                arrayList.add(email_Web);

                if (contact_web.equalsIgnoreCase(contactName_Str) && reference_Web.equalsIgnoreCase(reference_code_Str)) {
                    utils.setWebDriverFluentWait(1, 30, By.xpath("//*[@id='ddlSearchContact']/option[" + j + "]"));
                    //utils.click()
                    //System.out.println("+++++++++++++++++++++" + email_Web);
                    listCompanyName.get(j).click();
                    // System.out.println("I selected company name: " + contact_web);
                    utils.log4j("I selected company name: " + contact_web);
                    break;
                }
            }

            utils.click(req.getcurrencyDropDownClick, driver);
            utils.log4j("I clicked on currency drop down");
            List<WebElement> listCurrencyDropDown = req.getGetCurrencyDropDown;
            //System.out.println(listCurrencyDropDown.size());
            for (int k = 0; k < listCurrencyDropDown.size(); k++) {
                currency_web = listCurrencyDropDown.get(k).getAttribute("innerText");
                if (currency_web.equalsIgnoreCase(currency_Str)) {
                    listCurrencyDropDown.get(k).click();
                    utils.log4j("I selected currency option: " + currency_web);
                    break;
                }
            }

            req.getAmountTextBox.sendKeys(amount_str);
            utils.log4j("I enter request amount: " + amount_str);

            if (currency_Str.equalsIgnoreCase("INR")) {
                if (!currency_Str.equals(null) && GST_Str_DT.isEmpty() == false) {
                    utils.click(req.getGstTypeClick, driver);
                    utils.log4j("I clicked on GST Type dropDown");
                    List<WebElement> listGST = req.getGstList;
                    for (int l = 1; l < listGST.size(); l++) {
                        GST_Str = listGST.get(l).getAttribute("textContent");
                        if (GST_Str.equals(GST_Str_DT)) {
                            utils.setWebDriverFluentWait(1, 30, By.xpath("//ul[@name='ctl00$ContentPlaceHolder1$ddlGSTType']/li[" + l + "]"));
                            utils.click(listGST.get(l), driver);

                            break;
                        }
                    }

                    req.getGSTValuIcon.click();

                    List<WebElement> listValues = req.getGSTValueList;
                    for (int i1 = 1; i1 < listValues.size(); i1++) {
                        GST_values_Web = listValues.get(i1).getAttribute("innerText");

                        if (GST_Rate_Str.equals(GST_values_Web)) {
                            utils.click(listValues.get(i1), driver);
                            utils.log4j("I select GST value from drop down: " + GST_values_Web);
                            break;
                        }
                        double amt = Float.parseFloat(amount_str);
                        double gstValue = Float.parseFloat(GST_Rate_Str);
                        double t = utils.calculateGST(amt, gstValue);
                        //System.out.println("GST: " + t);
                        toPaid = t + amt;
                    }
                } else if (GST_Str_DT.isEmpty() == true) {
                    utils.log4j("GST is zero");
                    // System.out.println(amount_str);
                    double amt = Float.parseFloat(amount_str);
                    // System.out.println(GST_Rate_Str);
                    GST_Rate_Str = "0";
                    double gstValue = Float.parseFloat(GST_Rate_Str);
                    double t = utils.calculateGST(amt, gstValue);
                    //System.out.println("GST: " + t);
                    toPaid = t + amt;

                }
                //System.out.println("Contact name from data table is: " + contactNameDT);

                //System.out.println("To paid: " + toPaid);
            }
            Thread.sleep(500L);
            driver.findElement(By.id("txtTotalAmount")).click();
            Thread.sleep(200L);
            totalAmountToBeCollected = utils.getHiddenText(req.getTotalAmountToBeCollected);
            utils.log4j("Amount to be collected is: " + totalAmountToBeCollected);

            if (payOnReceipt_WT.isEmpty() == false) {
                req.enterNetTerm.sendKeys(payOnReceipt_WT);
              /*  utils.click(req.getPayOnReceiptClick, driver);
                List<WebElement> listValuesReceipt = req.getPayOnReceiptValues;
                for (int j = 0; j < listValuesReceipt.size(); j++) {
                    String payOnReceipt = listValuesReceipt.get(j).getText();
                    //System.out.println(payOnReceipt);
                    if (payOnReceipt_WT.equalsIgnoreCase(payOnReceipt)) {
                        utils.click(listValuesReceipt.get(j), driver);
                        break;
                    }

                }*/
                //System.out.println("invoce from data table is: " + invoiceDate);
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
                driver.findElement(By.cssSelector("#txtInvoiceDate")).click();
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
                    }
                }


            } else {
                utils.log4j("Current Date will taken as default if not specified");
            }
            if (invoiceImgUrl.isEmpty() == false)
                req.getAttachedAnInvoice.sendKeys(invoiceImgUrl);
            utils.log4j("I attached invoice is: " + invoiceImgUrl);
            if (invoiceNumber.isEmpty() == false)
                req.getInvoiceNo.sendKeys(invoiceNumber);
            utils.log4j("I enter invoice number is: " + invoiceNumber);
            if (remarks_DT.isEmpty() == false) req.getRemarks.sendKeys(remarks_DT);
            utils.log4j("I enter remarks is: " + remarks_DT);
            if (currency_Str.equalsIgnoreCase("INR") && mdrCharges_Dt.isEmpty() == false) {
                utils.click(req.getMDRToCustomerCheckBox, driver);
                utils.log4j("I clicked on Pass MDR to Customer on receiving payment check box");
                Thread.sleep(300L);
                req.getCustomerCharges.clear();
                //System.out.println("mdr charges: " + mdrCharges_Dt);
                req.getCustomerCharges.sendKeys(mdrCharges_Dt);
                utils.log4j("I set customer charges is: " + mdrCharges_Dt);
                String defaultBusinessCharges = req.getDefaultBusinessCharges.getAttribute("data-default");
                //System.out.println(defaultBusinessCharges);

               /* driver.findElement(By.xpath("//*[@id='ui-id-2']/div[8]/div")).click();
                Thread.sleep(200L);*/

              /*  float val1 = (float) FloatingDecimal.parseDouble(defaultBusinessCharges);
                System.out.println("Val 1:"+val1);
                float val2 = (float) FloatingDecimal.parseDouble(mdrCharges_Dt);
                System.out.println("Val 2:"+val2);
                float finalCal = val1 - val2;
                System.out.println("Line 1631:"+finalCal);
                utils.log4j("--------------------------------------" + finalCal + "----------------------------------------------------");
                //System.out.println(finalCal);
                //System.out.println(val2);
                String text = utils.getHiddenText(driver.findElement(By.id("txtBusinessCharges")));
                float getBusinessCharges = (float) FloatingDecimal.parseDouble(text);
                utils.log4j("Business charges is: " + getBusinessCharges);
                //System.out.println(val1);
                Thread.sleep(30L);
                if (finalCal == getBusinessCharges) {
                    Assert.assertTrue(true);
                } else {
                    Assert.assertTrue(false, "Invalid business charges ");
                }

            } else if (mdrCharges_Dt.isEmpty()) {

                utils.log4j("I set customer charges is: " + mdrCharges_Dt);
            }*/

                req.getContinueButton.click();
                utils.log4j("I clicked on continue button");

                Thread.sleep(3000L);
                //String extension = utils.getFileExtension(new File("C:\\Users\\vijay\\Pictures\\Screenshots\\Screenshot (2).png"));

                //System.out.println(extension);
                utils.log4j("----------------------------BOOKED TRANSACTIONS---------------------------------");
                String cName = req.getBusinessNameFromBookedTransactionPage.getAttribute("innerText");
                Assert.assertTrue(cName.equalsIgnoreCase(contactName_Str), "Company name not matched");
                utils.log4j("Contact Name is matched ");
                String currency = req.getCurrencyFromBookedTransactionPage.getAttribute("innerText");
                Assert.assertTrue(currency_Str.equalsIgnoreCase(currency), "Currency is not matched");

                utils.log4j("currency type is matched: " + currency);


                //System.out.println(date);
                // Assert.assertTrue(invoiceDate.equalsIgnoreCase(dueDate), "Due date is not matched");
                String tStatus = req.getStatusFromBookedTransactionPage.getText();
                //System.out.println(tStatus);
                Assert.assertTrue(tStatus.equals("Booked"), "Invalid status on Booked transaction page");
                utils.log4j("Booked transaction page status is: " + tStatus);
                String formaterAmt = String.format("%,.2f", toPaid);
                //System.out.println("formaterAmt: " + formaterAmt);
                payableAmount = req.getPayableAmountFromBookedTransaction.getText();
                Assert.assertTrue(formaterAmt.equalsIgnoreCase(payableAmount), "invalid Payable amount");
                utils.log4j("Payable amount is matched: " + payableAmount);
                //System.out.println("Payable amount is matched");


            }
        }
    }

    @Then("^I check user mail and click on login link$")
    public void iCheckUserMailAndClickOnLoginLink() throws Throwable {
        utils.PMXLogOut();
        utils.log4j("I logOut Pmx");
        Thread.sleep(1000L);
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            str = arrayList.get(i);
            // System.out.println("Email id is: " + str);
            //utils.getMailAndMakeContactPayment(str);
            utils.readPropertiesFile(propertiesFileUrl);
            //utils.log4j("-------------------------------EMAIL-------------------------------------------------");
            utils.getMail(email_Web);
            companyNameFromEmail = utils.txt.substring(0, utils.txt.indexOf(utils.txt) + 50);
            System.out.println(companyNameFromEmail);
            emailCompanyName = companyNameFromEmail.substring(companyNameFromEmail.indexOf("from") + 5);
            //System.out.println("Company Name from Email is:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::: " + emailCompanyName);
            List<WebElement> ListOfLinks = driver.findElements(By.xpath("//*[@valign='top']/div/a"));
            for (int j = 0; j < ListOfLinks.size(); j++) {
                //utils.retryingFindClick(ListOfLinks.get(j));
                linksText = ListOfLinks.get(j).getAttribute("innerText");
                System.out.println("Line 1705: "+linksText);
                String linkToclick = ListOfLinks.get(j).getAttribute("href");
                //utils.logOut();
                if (linksText.equals("Login")) {
                    utils.log4j("I am login to PMX");
                    driver.navigate().to(linkToclick);
                    utils.log4j("I URL from mail: " + linkToclick);
                    String password = utils.obj.getProperty("regPasswordLogin");
                    utils.pMXLogin(email_Web, password);
                    utils.click(driver.findElement(By.xpath("//a[@class='navbar-brand pmtlogo']")), driver);
                    utils.log4j("I click on PayMate logo to redirect on Home page");
                    utils.waitUntilElelemntShouldBeDisplay(driver, By.cssSelector("#ContentPlaceHolder1_lblXpressAccountBalance"), 30);
                    accountBalance = driver.findElement(By.cssSelector("#ContentPlaceHolder1_lblXpressAccountBalance")).getText();
                    utils.log4j("I checked Account Balance is: " + accountBalance);
                    /*utils.click(driver.findElement(By.xpath("//i[@class='fa fa-bars material-icons']")), driver);
                    utils.click(driver.findElement(By.xpath("//a[text()='Payments']")), driver);*/
                    utils.click(driver.findElement(By.xpath("//a [@href='../Payables/ReceivedPaymentRequests.aspx']")), driver);
                    utils.log4j("I clicked on Requests Received link");
                    utils.waitUntilElelemntShouldBeDisplay(driver, By.xpath("//*[@id='PnlMain']/div/div/h1"), 30);

                    //System.out.println(utils.accountBalance);
                }
            }
        }
    }

    @And("^I redirect on request received page$")
    public void iRedirectOnRequestReceivedPage() throws Throwable {
        ArrayList<Double> array = new ArrayList<Double>();
        String headingText = req.getRequestReceivedHeading.getText();
        utils.log4j("---------------------------------------------------REQUESTS RECEIVED PAGE---------------------------------------------------");
        // System.out.println("Request received page heading: " + headingText);
        Assert.assertTrue(headingText.equals("REQUESTS RECEIVED"), "user not redirected on REQUESTS RECEIVED page");
        utils.log4j("I am on request received page");
        companyName = driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_gvRequestPay']/tbody/tr[1]/td[4]")).getText();
        //System.out.println("I on " + headingText + " Page");
        utils.click(driver.findElement(By.className("toggle-card")), driver);
        utils.log4j("I click on filter");
        utils.click(driver.findElement(By.id("txtDateRange")), driver);
        utils.log4j("I open calendar and select default date");
        //utils.click(driver.findElement(By.className("applyBtn btn btn-sm btn-success")), driver);
        utils.click(driver.findElement(By.xpath("//button[contains(text(),'Apply')]")), driver);
        utils.log4j("I click on Apply button");
        utils.click(driver.findElement(By.name("ctl00$ContentPlaceHolder1$btnFilter")), driver);
        utils.log4j("I click on filter button");
        utils.waitUntilElelemntShouldBeDisplay(driver, By.xpath("//b[contains(text(),'Total Records :')]"), 30);
        String totalRecordText = driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_gvRequestPay_wrapper']/div[1]/div[2]/b[1]")).getText();
        // System.out.println("+++++++++++++++++++++++" + totalRecordText);
        Assert.assertTrue(totalRecordText.equalsIgnoreCase("Total Records :"), "Total Records text is not displaying");
        String totalAmount = driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_gvRequestPay_wrapper']/div[1]/div[2]/b[2]")).getText();
        Assert.assertTrue(totalAmount.equalsIgnoreCase("Total Amount :"), "Total Amount text is not displaying");
        utils.log4j("Total Amount Text is matching on " + headingText + " Page");

        List<WebElement> listTableHeading = req.getRequestPaymentPageTableHeading;
        for (WebElement webElement : listTableHeading) {

            utils.retryingToFindElement(webElement, "getText");
            //String tableHeadingIs = webElement.getText();
            switch (utils.str_sub) {
                case "RequestRefNo":
                    utils.log4j(utils.str_sub + " table heading is displaying");
                    break;
                case "RequestFrom":
                    utils.log4j(utils.str_sub + " table heading is displaying");
                    break;
                case "RequestDate":
                    utils.log4j(utils.str_sub + " table heading is displaying");
                    break;
                case "Invoice No.":
                    utils.log4j(utils.str_sub + " table heading is displaying");
                    break;
                case "Amount":
                    utils.log4j(utils.str_sub + " table heading is displaying");
                    break;
                case "Currency":
                    utils.log4j(utils.str_sub + " table heading is displaying");
                    break;
                case "Status":
                    utils.log4j(utils.str_sub + " table heading is displaying");
                    break;
                case "Action":
                    utils.log4j(utils.str_sub + " table heading is displaying");
                    break;
                default:
                    break;
            }
        }
        Thread.sleep(1000L);
        List<WebElement> listCheckBox = req.getCheckBoxFromRRPage;
        int checkBoxSize = listCheckBox.size();
        utils.retryingToFindElement(req.getTotalRecordsCount, "getText");
        utils.str = req.getTotalRecordsCount.getText();
        int totalCount = Integer.parseInt(utils.str);
        Assert.assertEquals(checkBoxSize, totalCount, "Invalid total records count");
        utils.log4j("Total Record matched: " + totalCount);
        String totalAmt = driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_gvRequestPay_wrapper']/div[1]/div[2]/span[3]")).getText();
        List<WebElement> listTotalAmount = driver.findElements(By.xpath("//*[@id='ContentPlaceHolder1_gvRequestPay']/tbody/tr/td[7]"));
        int sizeOfTotalAmount = listTotalAmount.size();
        for (int i = 0; i < sizeOfTotalAmount; i++) {
            utils.retryingToFindElement(listTotalAmount.get(i), "getText");
            //amount = listTotalAmount.get(i).getText();
            //  System.out.println("Amount is: " + amount);
            String formartStr = utils.str_sub.replace(",", "");
            //System.out.println("formartStr: " + formartStr);
            double ai = Float.parseFloat(formartStr);

            array.add(ai);


        }

        double sum = 0;
        for (int j = 0; j < array.size(); j++) {

            sum = sum + array.get(j);

        }

        String sumToCompair = String.format("%,.2f", sum);
        // System.out.println(totalAmt + "-----------------------" + sumToCompair);
        Assert.assertEquals(totalAmt, sumToCompair, "Invalid total amount on request received page");


        List<WebElement> listCheckBoxRR = req.getCheckBoxRequestReceived;
        for (int k = 0; k < listCheckBox.size(); k++) {
            utils.click(listCheckBoxRR.get(k), driver);
            utils.retryingToFindElement(req.getTransactionIdRRPage.get(k), "getText");
            transactionId = req.getTransactionIdRRPage.get(k).getText();
            System.out.println("Reference number RR: " + transactionId);

        }
        //System.out.println(utils.str_sub);
        utils.click(req.getSubmitFromrequestReceived, driver);
        utils.log4j("I clicked on Submit button from Request received page");

        utils.waitUntilElelemntShouldBeDisplay(driver, By.cssSelector("#ContentPlaceHolder1_h2"), 30);
        String acceptRequestFromText = req.getAcceptRequestPopUpWindow.getText();
        //System.out.println("-*--*--**-*-**-*-*-*-*-*-*-*-*----*-*-*-*-*-*-*-**---*-*---*---*-*-*--*-*:     " + acceptRequestFromText);
        utils.log4j("I on " + acceptRequestFromText + "Page");

        baseAmountFromARF = req.getBaseAmountFromAcceptRequestFrom.getText();
        //System.out.println(baseAmountFromARF + "------------------------" + amount_str);
        Assert.assertEquals(baseAmountFromARF, amount_str, "Invalid base amount is displaying on request accept  page");
        utils.log4j("Base Amount Is Matched on Request Accept page: " + baseAmountFromARF + "   " + amount_str);
        String gstFromARF = req.getGSTFromAcceptRequestFrom.getText();
        String s1 = "@";
        String s2 = ".00%";
        String gstToCompare = GST_Str_DT.concat(s1).concat(" " + GST_Rate_Str).concat(s2);
        System.out.println(gstFromARF + "--------------------------" + gstToCompare);

        String removeSpace = gstFromARF.replace(" ", "");
        System.out.println(removeSpace);


        if (gstToCompare.replace(" ", "").equalsIgnoreCase(removeSpace)) {
            Assert.assertEquals(gstToCompare.replace(" ", ""), removeSpace, "GST rate is not matched");
            utils.log4j("GST Rate IS Matched:  " + gstToCompare + "  " + gstFromARF);
        } else {
            Assert.assertTrue(false);
        }
        String getNetAmount = req.getNetAmount.getText();
        System.out.println(getNetAmount + "-------------------------" + totalAmountToBeCollected);
        Assert.assertTrue(getNetAmount.equals(totalAmountToBeCollected), "Invalid net amount is displaying on Accept request Page");
        utils.log4j("Net Amount is matched from on Accept Request Page");
        String getPaymentTerms = req.getPaymentsTerms.getText();
        System.out.println(getPaymentTerms + "----------------------" + payOnReceipt_WT);
        if (payOnReceipt_WT.isEmpty() == true) {
            Assert.assertTrue(getPaymentTerms.equals("Pay on receipt"), "Invalid net terms on Accept request Page");
            utils.log4j("Net Terms Matched On Accept Request Page " + getPaymentTerms);
        } else {
            Assert.assertTrue(getPaymentTerms.equals(payOnReceipt_WT), "Invalid net terms on Accept request Page");
            utils.log4j("Net Terms Matched On Accept Request Page " + getPaymentTerms);
        }
        String dueDate = req.getDueDateFromARF.getText();

        String remarksFromARF = req.getGetRequestAPayment.getText();
        //System.out.println(remarksFromARF + "--------------------------------------" + remarks_DT);
        Assert.assertTrue(remarksFromARF.equals(remarks_DT), "Remarks is not matched");
        utils.log4j("Remarks is matched on Accept Request Page");

        //for payment selection

        utils.readPropertiesFile(propertiesFileUrl);
        propertyFileData = utils.obj.getProperty("card");
        driver.findElement(By.xpath("//*[@for='ddlPayFrom_select']/i")).click();
        Thread.sleep(300L);
        utils.log4j("I Clicked On PayFrom DropDown");
        List<WebElement> listPayFrom = req.getPayFromList;
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


            } else if (payFromWeb.equalsIgnoreCase(propertyFileData) && propertyFileData.equalsIgnoreCase("xpress Account")) {
                payFromWeb = webElement.getText();
                webElement.click();
                utils.log4j("I Select Pay From Is: " + payFromWeb);
            }
        }


    }

    @And("^I select discount \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\"$")
    public void iSelectDiscountAndAnd(String arg0, String arg1, String arg2) throws Throwable {
        // Write code here that turns the phrase above into concrete actions

        utils.click(req.getApplyDiscount, driver);
        boolean typeOfDiscountIsDisplayed = req.getTypeOfDiscount.isDisplayed();
        Assert.assertTrue(typeOfDiscountIsDisplayed, "Type of discount field is not displayed");
        String defaulrText = req.getTypeOfDiscount.getAttribute("value");
        //System.out.println(defaulrText);
        Assert.assertTrue(defaulrText.equals("Type of Discount"), "default text  is invalid");

        driver.findElement(By.xpath("//*[@for='ddlTypeOfDiscount_select']/i")).click();
        Thread.sleep(2000L);
        List<WebElement> listTypeOfDiscount = req.getListOfTypeOfDiscount;
        for (int i = 0; i < listTypeOfDiscount.size(); i++) {
            String list = listTypeOfDiscount.get(i).getText();
            //System.out.println(list);
            if (arg0.equals("Apply Fixed Discount") && list.equalsIgnoreCase(arg0) && arg1.equals("Fixed")) {
                listTypeOfDiscount.get(i).click();
                utils.waitUntilElelemntShouldBeDisplay(driver, By.xpath("//input[@id='ddlDiscountType_select']"), 40);

                boolean discountTypeisDisplayed = req.getDiscountType.isDisplayed();
                Assert.assertTrue(discountTypeisDisplayed, "Discount type  is not displaying");
                String defaultTextOnDT = req.getDiscountType.getAttribute("value");
                //System.out.println(defaultTextOnDT);
                //utils.click(req.getDiscountType, driver);
                utils.waitElementShouldBeClickable(req.getDiscountType);
                driver.findElement(By.xpath("//*[@for='ddlDiscountType_select']/i")).click();
                Thread.sleep(2000L);
                List<WebElement> listDiscount = req.getDiscountTypeList;
                for (WebElement element : listDiscount) {
                    String valuesIs = element.getText();
                    if (valuesIs.equals("Fixed") && arg1.equals("Fixed")) {
                        element.click();
                        Thread.sleep(2000L);
                        req.getDiscounttextBox.sendKeys(arg2);

                        float baseAmont1 = Float.parseFloat(amount_str);
                        Thread.sleep(2000L);
                        driver.findElement(By.xpath("//div[@class='col-xs-12 col-sm-6 col-md-6']/strong")).click();
                        Thread.sleep(1000L);
                        payableAmount = driver.findElement(By.xpath("//*[@id='lblPayamount']")).getText();
                        float payableAmt = Float.parseFloat(payableAmount);
                        //System.out.println(payableAmt + "------------------------------------" + baseAmont1);

                        discountFromDT = Float.parseFloat(arg2);
                        discTOComp = discountFromDT;
                        float amt2 = baseAmont1 - discountFromDT;
                        //System.out.println(amt2);
                        float gst = Float.parseFloat(GST_Rate_Str);
                        float total = (gst * amt2) / 100;
                        payanleAmount = amt2 + total;
                        Assert.assertEquals(payableAmt, payanleAmount, "Invalid payable amount");
                        //System.out.println(payableAmt + "------------------------------" + "********************************************" + c);
                        /*float paybaleamount = Float.parseFloat(payableAmount);*/


                        break;
                    }
                }

            } else if (arg0.equals("Apply Fixed Discount") && list.equalsIgnoreCase("Apply Fixed Discount") && arg1.equals("Percentage")) {
                //System.out.println("else if");
                utils.click(listTypeOfDiscount.get(i), driver);
                utils.waitUntilElelemntShouldBeDisplay(driver, By.xpath("//input[@id='ddlDiscountType_select']"), 40);

                boolean discountTypeisDisplayed = req.getDiscountType.isDisplayed();
                Assert.assertTrue(discountTypeisDisplayed, "Discount type  is not displaying");
                String defaultTextOnDT = req.getDiscountType.getAttribute("value");
                System.out.println(defaultTextOnDT);
                //utils.click(req.getDiscountType, driver);
                utils.waitElementShouldBeClickable(req.getDiscountType);
                driver.findElement(By.xpath("//*[@for='ddlDiscountType_select']/i")).click();
                Thread.sleep(2000L);
                List<WebElement> listDiscount = req.getDiscountTypeList;
                for (WebElement element : listDiscount) {
                    String valuesIs = element.getText();
                    if (valuesIs.equals("Percentage") && arg1.equals("Percentage")) {
                        /*element.click();
                        Thread.sleep(2000L);
                        req.getDiscounttextBox.sendKeys(arg2);

                        Thread.sleep(2000L);

                        driver.findElement(By.xpath("//div[@class='col-xs-12 col-sm-6 col-md-6']/strong")).click();
                        Thread.sleep(1000L);
                        String PayableAmount = driver.findElement(By.xpath("//*[@id='lblPayamount']")).getText();*/

                        element.click();
                        Thread.sleep(2000L);
                        req.getDiscounttextBox.sendKeys(arg2);

                        float baseAmont1 = Float.parseFloat(amount_str);
                        Thread.sleep(2000L);
                        driver.findElement(By.xpath("//div[@class='col-xs-12 col-sm-6 col-md-6']/strong")).click();
                        Thread.sleep(1000L);
                        payableAmount = driver.findElement(By.xpath("//*[@id='lblPayamount']")).getText();
                        //Discount calculation is

                        float paybaleAmt = Float.parseFloat(payableAmount);
                        // System.out.println(paybaleAmt);

                        String baseamt = driver.findElement(By.xpath("//*[@id='lblBaseAmt']")).getText();
                        //System.out.println("Base amont: " + baseamt);
                        float value1 = Float.parseFloat(baseamt);

                        discountFromDT = Float.parseFloat(arg2);

                        discTOComp = (discountFromDT * value1) / 100;
                        //System.out.println("Discount value: " + discountValue);
                        float value3 = value1 - discTOComp;
                        //System.out.println("values 3: " + value3);
                        float gstConversion = Float.parseFloat(GST_Rate_Str);

                        float value4 = (gstConversion * value3) / 100;
                        // value3 + gstConversion;

                        System.out.println(" value 4: " + value4 + "value 1: " + value1);
                        payanleAmount = value3 + value4;
                        System.out.println("-*-*-*-*-*-*-*--*-*-*-*-*-*-*-*-*-*-*--" + payanleAmount);

                        Assert.assertEquals(paybaleAmt, payanleAmount, "invalid amount");
                        System.out.println("Payable amount with discount is matched");
                        break;
                    }
                }


            } else if (arg0.equalsIgnoreCase("Apply discount") && list.equalsIgnoreCase("Apply discount")) {
                utils.click(listTypeOfDiscount.get(i), driver);
                boolean bool = driver.findElement(By.xpath("//*[text()='No matching contract found Apply Fixed Discount.']")).isDisplayed();
                if (bool = true) {
                    String noDiscountMsg = driver.findElement(By.xpath("//*[text()='No matching contract found Apply Fixed Discount.']")).getText();
                    System.out.println(noDiscountMsg + "No matching contract found Apply Fixed Discount.");
                    Assert.assertTrue(noDiscountMsg.equals("No matching contract found Apply Fixed Discount."), "Invalid msg ");
                    float baseAmont1 = Float.parseFloat(amount_str);
                    Thread.sleep(2000L);
                    driver.findElement(By.xpath("//div[@class='col-xs-12 col-sm-6 col-md-6']/strong")).click();
                    Thread.sleep(1000L);
                    payableAmount = driver.findElement(By.xpath("//*[@id='lblPayamount']")).getText();
                    float payableAmt = Float.parseFloat(payableAmount);
                    //System.out.println(payableAmt + "------------------------------------" + baseAmont1);
                    boolean yes = arg2.isEmpty();
                    if (yes = true) {
                        arg2 = "0";
                        discountFromDT = Float.parseFloat(arg2);
                        discountFromDT = discTOComp;
                        float amt2 = baseAmont1 - discountFromDT;
                        //System.out.println(amt2);
                        float gst = Float.parseFloat(GST_Rate_Str);
                        float total = (gst * amt2) / 100;

                        payanleAmount = amt2 + total;
                    }
                    break;
                } else {
                    System.out.println("check which type of discount user having");
                }
            }

        }


    }

    @And("^I redirect on pending approval screen$")
    public void iRedirectOnPendingApprovalScreen() throws Throwable {
        driver.findElement(By.cssSelector("#btSaveDiscount")).click();
        System.out.println("I clicked on submit button");
        utils.waitUntilElelemntShouldBeDisplay(driver, By.xpath("//div[@class='alert-strip success-alert']"), 30);
        String validationMsgIs = req.getvalidationMsgStrip.getText();
        //System.out.println("VAlidation msg after click on submit button"+validationMsgIs);
        Assert.assertEquals(validationMsgIs, "Received payment request confirmed successfully.", "validation msg is not matched");
        utils.waitUntilElelemntShouldBeDisplay(driver, By.xpath("//h1[text()='Pending Approvals']"), 30);
        utils.log4j("-----------------------------------------PENDING APPROVALS------------------------------------");
        String pendingApprovalTxt = driver.findElement(By.xpath("//h1[text()='Pending Approvals']")).getText();
        // System.out.println(pendingApprovalTxt);
        Assert.assertEquals(pendingApprovalTxt, "PENDING APPROVALS", "Pending approval text is not matched");
        utils.log4j("I on " + pendingApprovalTxt + "  Page");
        utils.click(driver.findElement(By.className("toggle-card")), driver);
        utils.log4j("I Click on Filter");
        Thread.sleep(500L);
        req.getTransactionId.sendKeys(transactionId);
        utils.log4j("I Enter Transaction ID");
        //System.out.println("I enter transactionn id");
        Thread.sleep(500L);
        utils.click(driver.findElement(By.name("ctl00$ContentPlaceHolder1$btnFilter")), driver);

        utils.log4j("I Clicked on Filter Button");
        Thread.sleep(1000L);


            List<WebElement> tableHeading = req.getTableHeadingFromPA;
            for (WebElement webElement : tableHeading) {

                utils.retryingToFindElement(webElement, "getText");
            //String headingIs = webElement.getText();
            //System.out.println("Table heading is: " + headingIs);
            switch (utils.str_sub) {
                case "Transaction ID":
                    String transactionIdFromPendingApproval = req.getTransactionIdFromPendingApproval.getText();
                    //System.out.println("Transaction Id from Pending approval screen: " + transactionIdFromPendingApproval);
                    Assert.assertEquals(transactionId, transactionIdFromPendingApproval, "Transaction id is not matched");
                    utils.log4j("Transaction ID Is Matched on Pending Approval Screen");
                    break;
                case "Date":
                    String date = req.getDate.getText();
                    utils.log4j("Due Date Is: " + date);
                    break;
                case "Company Name":
                    String companyName = req.getCompanyNameFromPendingApprovalScreen.getText();
                    //System.out.println("Company Name from pending Approval: " + companyName);
                    Assert.assertEquals(companyName, emailCompanyName, "Company Name is not Matched");
                    utils.log4j("Compnay Name Is Matched");
                    break;
                case "Payment Mode":
                    paymentModeFromPA = req.paymateModeFromPA.getText();
                    /*System.out.println("paymentModeFromPA////////////////:  " + payFromWeb);
                    System.out.println("Payment mode from pending approval screen is: " + paymentModeFromPA);*/
                    Assert.assertEquals(paymentModeFromPA, payFromWeb, "Invalid payment from on pending approval screen");

                    utils.log4j("Payment Mode Is Matched");
                    //System.out.println("Payment mode from pending approval screen is: " + paymentModeFromPA);
                    break;
                case "Paid Through":
                    String paidThrough = req.getPaidThroughFromPA.getText();
                    if (paymentModeFromPA.equalsIgnoreCase("Credit card")) {
                        Assert.assertEquals(paidThrough, PayThrough, "Invalid card number on pending approval screen");
                        utils.log4j("Paid Through Is Matched");
                    } else if (paymentModeFromPA.equalsIgnoreCase("Net Banking")) {

                        Assert.assertEquals(paidThrough, PayThrough, "");
                        utils.log4j("Paid Through Is Matched");
                    } else if (paymentModeFromPA.equalsIgnoreCase(" Banking")) {
                        utils.log4j("Paid Through Is Matched");
                    }
                    //System.out.println("Paid through from pending approval: " + paidThrough + "Card id: " + PayThrough);
                    break;
                case "Type of Payment":
                    String typeOfPayment = req.getTypeOfPayment.getText();
                    Assert.assertEquals(typeOfPayment, "NEFT/RTGS", "Invalid type of payment on pending approval screen");
                    utils.log4j("Type Of Payment  Is Matched");
                    //System.out.println("Type of Payment is: " + typeOfPayment);
                    break;
                case "Request Type":
                    String requestType = req.getRequestPayment.getText();
                    Assert.assertEquals(requestType, ("Request Payment"), "Invalid request type on pending approval screen'");
                    utils.log4j("Request Type Is Not Matched");
                    //System.out.println("Request type is: " + requestType);
                    break;
                case "Payable Amount":
                    String payableAmpuntIs = req.getPayableAmount.getText();
                    String fAmont = payableAmpuntIs.replace(",", "");
                    float castAmount = Float.parseFloat(fAmont);
                    System.out.println("Payable amount is: " + payableAmpuntIs + "++++++++++++++++++++++++" + payanleAmount);
                    Assert.assertEquals(castAmount, payanleAmount, "Invalid payable amount on pending approval screen");
                    utils.log4j("PayAble Amount Is Matched On Approval Screen");
                    break;
                case "Status":
                    String statusIs = req.getStatusFromPA.getText();
                    Assert.assertEquals(statusIs, "Awaiting to approve", "Invalid status on pending approval screen");
                    utils.log4j("Status is Matched on Pending Approval Screen");
                    break;

                default:
                    System.out.println("");
                    break;

            }
        }

        utils.click(driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_gvApprovals_lbnViewHistory_0']")), driver);
        utils.log4j("I Clicked On View History Page");
        utils.waitUntilElelemntShouldBeDisplay(driver, By.xpath("//*[text()='Payment Summary']"), 30);
        List<WebElement> listPaymentSummeryData = req.getPaymentSummeryData1;
        List<WebElement> listData = req.getLabelDataFromPendingApproval;
        int i = 0;
        for (WebElement webElement1 : listPaymentSummeryData) {
            String webElementDataIs = webElement1.getText();

            switch (webElementDataIs) {
                case "Company Name":

                    companyName = webElement1.getText();
                    Assert.assertEquals(companyName, "Company Name", "Invalid text");
                    companyNameLabel = listData.get(i).getText();

                    System.out.println(companyNameLabel + "" + paymentModeFromPA);
                    Assert.assertEquals(companyNameLabel, emailCompanyName, "company name is not matched");
                    utils.log4j("Company Name Is Matched ViewHistory");
                    //ystem.out.println("Company Name: " + companyName + ":  " + companyNameLabel);
                    break;
                case "Account No":
                    companyName = webElement1.getText();
                    companyNameLabel = listData.get(i).getText();
                    utils.log4j("Account no Is:  " + companyNameLabel);
                    break;
                case "IFSC Code":
                    companyName = webElement1.getText();
                    companyNameLabel = listData.get(i).getText();
                    utils.log4j(companyName + "" + companyNameLabel);
                    //System.out.println("Company Name: " + companyName + ":  " + companyNameLabel);
                    break;
                case "Payment From":
                    companyName = webElement1.getText();
                    companyNameLabel = listData.get(i).getText();
                    System.out.println(companyNameLabel + ":   " + propertyFileData);
                    Assert.assertEquals(companyNameLabel, propertyFileData, "Payment from is not matched");
                    utils.log4j("Payment From Is Matched");
                    //System.out.println("Company Name: " + companyName + ":  " + companyNameLabel);
                    break;
                case "Payment Through":
                    companyName = webElement1.getText();
                    companyNameLabel = listData.get(i).getText();
                    //System.out.println("Company Name: " + companyName + ":  " + companyNameLabel);
                    break;
                case "Type of Payment":
                    companyName = webElement1.getText();
                    companyNameLabel = listData.get(i).getText();
                    Assert.assertEquals(companyNameLabel, "NEFT/RTGS", "Invalid type of payment");
                    utils.log4j("Type Of Payment Is Matched");
                    //System.out.println("Company Name: " + companyName + ":  " + companyNameLabel);
                    break;
                case "Scheduled Date":
                    companyName = webElement1.getText();
                    companyNameLabel = listData.get(i).getText();
                    //System.out.println("Company Name: " + companyName + ":  " + companyNameLabel);
                    break;
                case "Transaction ID":
                    companyName = webElement1.getText();
                    companyNameLabel = listData.get(i).getText();
                    Assert.assertEquals(companyNameLabel, transactionId, "Transaction id is not matched");
                    utils.log4j("Transaction ID Is Matched");
                    //System.out.println("Company Name: " + companyName + ":  " + companyNameLabel);
                    break;
                case "Booked Amount":
                    companyName = webElement1.getText();
                    companyNameLabel = listData.get(i).getText();
                    System.out.println(companyNameLabel + "" + amount_str);
                    Assert.assertEquals(companyNameLabel, amount_str, "Booked amount is not matched");
                    utils.log4j("Booked Payment Is Matched");
                    //System.out.println("Company Name: " + companyName + ":  " + companyNameLabel);
                    break;
                case "Discount":
                    companyName = webElement1.getText();
                    companyNameLabel = listData.get(i).getText();
                    float f = Float.parseFloat(companyNameLabel);
                    System.out.println(f + "" + discTOComp);
                    Assert.assertEquals(f, discTOComp, "Discount amount is not matched");
                    utils.log4j("Discount Is Matched");
                    // System.out.println("Company Name: " + companyName + ":  " + companyNameLabel);
                    break;
                case "TDS":
                    companyName = webElement1.getText();
                    companyNameLabel = listData.get(i).getText();
                    //System.out.println("Company Name: " + companyName + ":  " + companyNameLabel);
                    break;
                case "GST":
                    companyName = webElement1.getText();
                    companyNameLabel = listData.get(i).getText();
                    //System.out.println("GSTTTTTTTTTTTTTTTT: " + companyNameLabel);
                    //System.out.println("Company Name: " + companyName + ":  " + companyNameLabel);
                    break;
                case "Payable Amount":
                    companyName = webElement1.getText();
                    companyNameLabel = listData.get(i).getText();
                    System.out.println(payableAmount + "::::::::::::::" + companyNameLabel);
                    Assert.assertEquals(payableAmount.replace(",", ""), companyNameLabel, "Payable amount is not matched");
                    utils.log4j("Payable Amount Is Matched");
                    // System.out.println(payableAmount + ":::::::::::::::::::" + companyNameLabel);
                    //System.out.println("Company Name: " + companyName + ":  " + companyNameLabel);
                    break;
                default:
                    System.out.println("");
                    break;
            }
            i++;

        }

        driver.findElement(By.xpath("//*[@id='close-summary']")).click();
        utils.log4j("I closed View Summery");
        utils.click(req.getFirstCheckBox, driver);
        utils.log4j("I Select Check Box");
        utils.click(req.getApproveButton, driver);
        utils.log4j("I Click on Approve Button");
        utils.waitUntilElelemntShouldBeDisplay(driver, By.cssSelector("#myModalLabel"), 30);
        String processTransactionString = req.getProcessTransactionsTitle.getText();
        Thread.sleep(3000L);
        /*String payFromPT = driver.findElement(By.xpath("//*[@id='ddlPayFrom_select']/li")).getAttribute("innerText");
        System.out.println(payFromPT);
        */
        List<WebElement> transactionProcessTableHeading = req.getTransactionProcessTableHeading;
        int count = 0;
        for (WebElement webElement : transactionProcessTableHeading) {
            String tableHeadingPT = webElement.getText();
            String tableHeadingData = req.getTransactionProcessTableData.get(count).getText();


            switch (tableHeadingPT) {
                case "Business Name":
                    System.out.println(emailCompanyName + " :" + tableHeadingData);
                    Assert.assertEquals(emailCompanyName, tableHeadingData, "Company Name is not matched");
                    utils.log4j("Business Name is Matched");
                    break;
                case "Charge Amount":
                    System.out.println(payableAmount + " :" + tableHeadingData);
                    String cAmount = tableHeadingData.replace(",", "");
                    Assert.assertEquals(payableAmount.replace(",", ""), cAmount, "Invalid amount");
                    utils.log4j("Payable Amount Is Matched");
                    break;
                case "No. of Transactions":
                    System.out.println(tableHeadingPT + " :" + tableHeadingData);
                    Assert.assertEquals(tableHeadingData, "1", "No of transaction is not matched");
                    utils.log4j("No Of Transaction Is Matched");
                    break;
                default:
                    break;
            }

            count++;
        }
        int count1 = 0;
        if (propertyFileData.equalsIgnoreCase("Xpress Account")) {
            List<WebElement> listTableHeading = req.getExpressAccountTableHeading;
            for (WebElement element : listTableHeading) {
                String heading = element.getText();
                switch (heading) {
                    case "Xpress Account Balance :":
                        String data1 = driver.findElement(By.xpath("//*[@class='totalbalance amt']")).getText();
                        System.out.println(data1);
                        break;

                    case "Amount :":
                        String data = driver.findElement(By.xpath("//*[@class='totalamount ']")).getText();
                        System.out.println(data);
                        break;
                    case "Sub Total :":
                        String data2 = driver.findElement(By.xpath("//*[@class='payamount']")).getText();
                        System.out.println(data2);
                        break;
                    case "Xpress Charge :":
                        String data3 = driver.findElement(By.xpath("//*[@class='totalmsf']")).getText();
                        System.out.println(data3);
                        break;
                    case "Pay Amount :":
                        String data4 = driver.findElement(By.xpath("//*[@class='netpay']")).getText();
                        System.out.println(data4);
                        break;
                    default: {
                        break;
                    }
                }


                //System.out.println(heading);
            }
            count1++;
        }
        utils.click(req.getMakePaymentButton, driver);
        utils.log4j("I click On Make Payment Button");
        utils.waitUntilElelemntShouldBeDisplay(driver, By.xpath("//*[text()='Top-Up Account']"), 30);

    }

    @And("^I approve transaction and i redirect on top up account page$")
    public void iApproveTransactionAndIRedirectOnTopUpAccountPage() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        utils.log4j("-------------------------TOP UP PAGE----------------------------------------------------------");
        if (propertyFileData.equalsIgnoreCase("Credit Card")) {
            String headingIs = req.getTopUpAccountPage.getText();
            req.getEnterCvvCode.sendKeys("123");
            utils.log4j("I Enter CVV Code");
            utils.click(req.getClickOnPayNow, driver);
            utils.log4j("I clicked On Pay Now Button");
            currentTimeIs = utils.getCurrentTime();
            //System.out.println("currentTimeIs: " + currentTimeIs);
            //utils.waitUntilElelemntShouldBeDisplay(driver, By.id("ContentPlaceHolder1_spnMsg"), 30);
            //System.out.println(driver.findElement(By.id("ContentPlaceHolder1_spnMsg")).getText());

        } else if (propertyFileData.equalsIgnoreCase("Net Banking")) {
            utils.click(req.getClickOnPayNow, driver);
            utils.log4j("I clicked On Pay Now Button");
        }

        System.out.println(accountBalance);
    }

    @And("^I calculate payable amount$")
    public void iCalculatePayableAmount() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        float baseAmont1 = Float.parseFloat(amount_str);
        System.out.println(baseAmont1);
        discTOComp = discountFromDT;
        System.out.println(discTOComp);
        float amt2 = baseAmont1 - discountFromDT;
        System.out.println(amt2);
        float gst = Float.parseFloat(GST_Rate_Str);
        float total = (gst * amt2) / 100;
        payanleAmount = amt2 + total;
        System.out.println(payanleAmount);
    }

    @Then("^I should check mail and click on login link$")
    public void iShouldCheckMailAndClickOnLoginLink() throws Throwable {
        Thread.sleep(1000L);
        utils.PMXLogOut();
        utils.log4j("I logOut Pmx");
        Thread.sleep(3000L);
//        Assert.assertEquals(login.loginPaymateText.getText(),"Login with your PayMate Account");
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            str = arrayList.get(i);
            // System.out.println("Email id is: " + str);
            //utils.getMailAndMakeContactPayment(str);
            utils.readPropertiesFile(propertiesFileUrl);
            //utils.log4j("-------------------------------EMAIL-------------------------------------------------");
            System.out.println(email_Web);
            utils.getMail(email_Web);
//            companyNameFromEmail = utils.txt.substring(0, utils.txt.indexOf(utils.txt) + 50);
//            //System.out.println(companyNameFromEmail);
//            emailCompanyName = companyNameFromEmail.substring(companyNameFromEmail.indexOf("from") + 5);
            //System.out.println("Company Name from Email is:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::: " + emailCompanyName);
            utils.getEmailBody();
            List<WebElement> ListOfLinks = driver.findElements(By.xpath("//a[text()='Login']"));
            for (int j = 0; j < ListOfLinks.size(); j++) {
                //utils.retryingFindClick(ListOfLinks.get(j));
                linksText = ListOfLinks.get(j).getAttribute("innerText");
                String linkToclick = ListOfLinks.get(j).getAttribute("href");
//                utils.logOut();
                if (linksText.equals("Login")) {
                    utils.log4j("I login to PMX");
                    driver.navigate().to(linkToclick);
                    utils.log4j("I enter URL from mail: " + linkToclick);
                    String password = utils.obj.getProperty("regPasswordLogin");
                    utils.pMXLogin(email_Web, password);
                    break;
                    //System.out.println(utils.accountBalance);
                }
                break;
            }
            break;
        }
    }

    @And("I get redirected to request received page and I verify transaction details")
    public void iGetRedirectedToRequestReceivedPageAndIVerifyTransactionDetails() throws InterruptedException {
        ArrayList<Double> array = new ArrayList<Double>();
        String headingText = req.getRequestReceivedHeading.getText();
       /* utils.log4j("---------------------------------------------------" + headingText + "---------------------------------------------------");
        // System.out.println("Request received page heading: " + headingText);
        Assert.assertTrue(headingText.equals("Requests Received"), "user not redirected on REQUESTS RECEIVED page");
        utils.log4j("I am on request received page");
        Thread.sleep(1000L);
        con.getFilterClick.click();
        Thread.sleep(500L);
        utils.log4j("I Clicked On Filter ");
        utils.click(driver.findElement(By.xpath("//label[@for='ContentPlaceHolder1_ddlPaymentStatus_select']/i")), driver);
        utils.log4j("I Clicked On Payment Status");
        Thread.sleep(1000L);
        List<WebElement> listPaymentStatus = driver.findElements(By.xpath("//*[@id='ContentPlaceHolder1_ddlPaymentStatus_select']/li"));
        for (WebElement element : listPaymentStatus) {
            String paymentStatus = element.getText();
            if (paymentStatus.equals("Awaiting to accept")) {
                utils.click(element, driver);
                break;
            }
        }
        utils.click(driver.findElement(By.id("txtDateRange")), driver);
        utils.log4j("I open calendar and select default date");
        //utils.click(driver.findElement(By.className("applyBtn btn btn-sm btn-success")), driver);
        utils.click(driver.findElement(By.xpath("//button[contains(text(),'Apply')]")), driver);
        utils.log4j("I click on Apply button");
        utils.click(driver.findElement(By.name("ctl00$ContentPlaceHolder1$btnFilter")), driver);
        utils.log4j("I click on filter button");
        utils.click(driver.findElement(By.xpath("//select[@name='ContentPlaceHolder1_gvRequestPay_length']")), driver);
        Thread.sleep(2000L);
        List<WebElement> dropDownOptions = driver.findElements(By.xpath("//select[@name='ContentPlaceHolder1_gvRequestPay_length']/option"));
        for (int i = 0; i < dropDownOptions.size(); i++) {
            String options = dropDownOptions.get(i).getText();
            System.out.println("DropDown Option is: " + options);
            if (options.equals("All")) {
                dropDownOptions.get(i).click();
                Thread.sleep(3000L);
            }
        }
        utils.waitUntilElelemntShouldBeDisplay(driver, By.xpath("//b[contains(text(),'Total Records :')]"), 30);
        String totalRecordText = driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_gvRequestPay_wrapper']/div[1]/div/div/span[2]")).getAttribute("innerHTML");
         System.out.println("+++++++++++++++++++++++" + totalRecordText);
//        Assert.assertTrue(totalRecordText.equalsIgnoreCase("Total Records: "), "Total Records text is not displaying");
        String totalAmount = driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_gvRequestPay_wrapper']/div[1]/div/div/b[2]")).getText();
//        Assert.assertTrue(totalAmount.equalsIgnoreCase("Total Amount: "), "Total Amount text is not displaying");
        utils.log4j("Total Amount Text is matching on " + headingText + " Page");
        utils.retryingToFindElement(req.getTotalRecordsCount, "getText");
        utils.str_sub = req.getTotalRecordsCount.getText();
        int totalCount = Integer.parseInt(utils.str_sub);
        //System.out.println(listCheckBox.size() + ":::::::::::" + totalCount);
        // Assert.assertEquals(listCheckBox.size(), totalCount, "Invalid total records count");
        utils.log4j("Total Record matched: " + totalCount);
        String totalAmt = driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_gvRequestPay_wrapper']/div[1]/div/div/span[3]")).getText();
        System.out.println("Total amount is: " + totalAmount);
        List<WebElement> listTotalAmount = driver.findElements(By.xpath("//table[@id='ContentPlaceHolder1_gvRequestPay']//tr/td[7]"));
        for (int i = 0; i < listTotalAmount.size(); i++) {
            // utils.retryingToFindElement(listTotalAmount.get(i), "getText");
            //amount = listTotalAmount.get(i).getText();
            //  System.out.println("Amount is: " + amount);
            String str_sub = listTotalAmount.get(i).getText();
            String formartStr = str_sub.replace(",", "");
            System.out.println("formartStr: " + formartStr);
            double ai = Float.parseFloat(formartStr);
            array.add(ai);
        }

        double sum = 0;
        for (int j = 0; j < array.size(); j++) {

            sum = sum + array.get(j);

        }

        String sumToCompair = String.format("%,.2f", sum);
        // System.out.println(totalAmt + "-----------------------" + sumToCompair);
        Assert.assertEquals(totalAmt, sumToCompair, "Invalid total amount on request received page");
        List<WebElement> listTableHeading = req.getPaymentsReportTableHeading;
        arrayList = new ArrayList<>();
        arrayList1 = new ArrayList<>();
        int count = 0;
        for (WebElement webElement : listTableHeading) {
            String tableElement = webElement.getText();
            String tableData = req.getPaymentsReportTableData.get(count).getText();
//            System.out.println("Heading:"+listTableHeading.size()+"::::"+req.getPaymentsReportTableData.size()+"Data");
            utils.log4j("Table Heading of Transaction Report Page And Data Is: " + tableElement + " :" + tableData);
            switch (tableElement){
                case "RequestRefNo":
                    Assert.assertTrue(tableElement.equals("RequestRefNo"), "RequestRefNo heading not matched");
                    Assert.assertFalse(tableData.isEmpty());
                    break;
                case "RequestFrom":
                    Assert.assertTrue(tableElement.equals("RequestFrom"), "RequestFrom heading not matched");
                    Assert.assertFalse(tableData.isEmpty());
                    break;
                case "RequestDate":
                    Assert.assertTrue(tableElement.equals("RequestDate"), "RequestDate heading not matched");
                    Assert.assertFalse(tableData.isEmpty());
                    break;
                case "Invoice No.":
                    Assert.assertTrue(tableElement.equals("Invoice No."), "Invoice No. heading not matched");
                    arrayList.add(tableData);
                    break;
                case "Payment Type":
                    Assert.assertTrue(tableElement.equals("Payment Type"), "Payment Type heading not matched");
                    Assert.assertTrue(tableData.equals("RequestPayment"));
                    break;
                case "Amount":
                    Assert.assertTrue(tableElement.equals("Amount"), "Amount heading not matched");
                    arrayList.add(tableData.replace(",",""));
                    break;
                case "Currency":
                    Assert.assertTrue(tableElement.equals("Currency"), "Currency heading not matched");
                    arrayList.add(tableData);
                    break;
                case "Status":
                    Assert.assertTrue(tableElement.equals("Status"), "Status heading not matched");
                    System.out.println(tableData);
                    Assert.assertTrue(tableData.equals("Awaiting to accept"));
                    break;
                case "Action":
                    Assert.assertTrue(tableElement.equals("Action"), "Action heading not matched");
                    Assert.assertTrue(reports_pom.getAcceptRequestIcon.isDisplayed(),"Accept request icon not present");
                    req.actionDropdown.click();
                    Assert.assertTrue(reports_pom.getAttachmentIcon.isDisplayed(),"Attachment icon not present");
                    Assert.assertTrue(reports_pom.getRejectIcon.isDisplayed(),"Reject icon not present");
                    break;
            }
            count++;
        }
        arrayList1.add(invoiceNumber);
        arrayList1.add(amtInString);
        arrayList1.add(currency_Str);
        System.out.println(arrayList.equals(arrayList1));
        Assert.assertTrue(arrayList.equals(arrayList1), "Not Matched");*/
    }

    @And("^I click on Accept Request icon in action column to approve transaction$")
    public void iClickOnAcceptRequestIconInActionColumnToApproveTransaction() throws Throwable {
        String headingText = req.getRequestReceivedHeading.getText();
        ArrayList<Double> array = new ArrayList<Double>();
    /*    companyName = driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_gvRequestPay']/tbody/tr[1]/td[4]")).getText();
        //System.out.println("I on " + headingText + " Page");
        utils.click(driver.findElement(By.className("toggle-card")), driver);
        utils.log4j("I click on filter");
        utils.click(driver.findElement(By.xpath("//label[@for='ContentPlaceHolder1_ddlPaymentStatus_select']/i")), driver);
        utils.log4j("I Clicked On Payment Status");
        Thread.sleep(1000L);
        List<WebElement> listPaymentStatus = driver.findElements(By.xpath("//*[@id='ContentPlaceHolder1_ddlPaymentStatus_select']/li"));
        for (WebElement element : listPaymentStatus) {
            String paymentStatus = element.getText();
            if (paymentStatus.equals("Awaiting to accept")) {
                utils.click(element, driver);
                break;
            }
        }
        utils.click(driver.findElement(By.id("txtDateRange")), driver);
        utils.log4j("I open calendar and select default date");
        //utils.click(driver.findElement(By.className("applyBtn btn btn-sm btn-success")), driver);
        utils.click(driver.findElement(By.xpath("//button[contains(text(),'Apply')]")), driver);
        utils.log4j("I click on Apply button");
        utils.click(driver.findElement(By.name("ctl00$ContentPlaceHolder1$btnFilter")), driver);
        utils.log4j("I click on filter button");*/
//        Select select = new Select(driver.findElement(By.name("ContentPlaceHolder1_gvRequestPay_length")));
//        select.selectByVisibleText("All");
//        Thread.sleep(1000L);
      /*  utils.click(driver.findElement(By.xpath("//select[@name='ContentPlaceHolder1_gvRequestPay_length']")), driver);
        Thread.sleep(2000L);
        List<WebElement> dropDownOptions = driver.findElements(By.xpath("//select[@name='ContentPlaceHolder1_gvRequestPay_length']/option"));
        for (int i = 0; i < dropDownOptions.size(); i++) {
            String options = dropDownOptions.get(i).getText();
            System.out.println("DropDown Option is: " + options);
            if (options.equals("All")) {
                dropDownOptions.get(i).click();
                Thread.sleep(3000L);
            }
        }
        utils.waitUntilElelemntShouldBeDisplay(driver, By.xpath("//b[contains(text(),'Total Records :')]"), 30);
        String totalRecordText = driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_gvRequestPay_wrapper']/div[1]/div[2]/b[1]")).getText();
        // System.out.println("+++++++++++++++++++++++" + totalRecordText);
        Assert.assertTrue(totalRecordText.equalsIgnoreCase("Total Records :"), "Total Records text is not displaying");
        String totalAmount = driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_gvRequestPay_wrapper']/div[1]/div[2]/b[2]")).getText();
        Assert.assertTrue(totalAmount.equalsIgnoreCase("Total Amount :"), "Total Amount text is not displaying");
        utils.log4j("Total Amount Text is matching on " + headingText + " Page");*/

      /*  List<WebElement> listTableHeading = req.getRequestPaymentPageTableHeading;
        for (WebElement webElement : listTableHeading) {

            utils.retryingToFindElement(webElement, "getText");
            //String tableHeadingIs = webElement.getText();
            switch (utils.str_sub) {
                case "RequestRefNo":
                    utils.log4j(utils.str_sub + " table heading is displaying");
                    break;
                case "RequestFrom":
                    utils.log4j(utils.str_sub + " table heading is displaying");
                    break;
                case "RequestDate":
                    utils.log4j(utils.str_sub + " table heading is displaying");
                    break;
                case "Invoice No.":
                    utils.log4j(utils.str_sub + " table heading is displaying");
                    break;
                case "Amount":
                    utils.log4j(utils.str_sub + " table heading is displaying");
                    break;
                case "Currency":
                    utils.log4j(utils.str_sub + " table heading is displaying");
                    break;
                case "Status":
                    utils.log4j(utils.str_sub + " table heading is displaying");
                    break;
                case "Action":
                    utils.log4j(utils.str_sub + " table heading is displaying");
                    break;
                default:
                    System.out.println("");
                    break;
            }


        }*/
        /*Thread.sleep(1000L);
        utils.retryingToFindElement(req.getTotalRecordsCount, "getText");
        utils.str_sub = req.getTotalRecordsCount.getText();
        int totalCount = Integer.parseInt(utils.str_sub);
        //System.out.println(listCheckBox.size() + ":::::::::::" + totalCount);
        // Assert.assertEquals(listCheckBox.size(), totalCount, "Invalid total records count");
        utils.log4j("Total Record matched: " + totalCount);
        String totalAmt = driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_gvRequestPay_wrapper']/div[1]/div[2]/span[3]")).getText();
        System.out.println("Total amount is: " + totalAmt);
        List<WebElement> listTotalAmount = driver.findElements(By.xpath("//table[@id='ContentPlaceHolder1_gvRequestPay']//tr/td[7]"));
        for (int i = 0; i < listTotalAmount.size(); i++) {
            // utils.retryingToFindElement(listTotalAmount.get(i), "getText");
            //amount = listTotalAmount.get(i).getText();
            //  System.out.println("Amount is: " + amount);
            String str_sub = listTotalAmount.get(i).getText();
            String formartStr = str_sub.replace(",", "");
            System.out.println("formartStr: " + formartStr);
            double ai = Float.parseFloat(formartStr);
            array.add(ai);
        }

        double sum = 0;
        for (int j = 0; j < array.size(); j++) {

            sum = sum + array.get(j);

        }

        String sumToCompair = String.format("%,.2f", sum);
        // System.out.println(totalAmt + "-----------------------" + sumToCompair);
        Assert.assertEquals(totalAmt, sumToCompair, "Invalid total amount on request received page");*/

        List<WebElement> listAccept = req.getAcceptRequest;

        for (int i = listAccept.size(); i > 0; i--) {
            referenceNo_str = req.getReferenceNumber.get(i - 1).getText();
            System.out.println("Line number 2341: " + referenceNo_str);
            //utils.log4j("Getting reference code: " + referenceNo_str);
            listAccept.get(i - 1).click();
            utils.log4j("I clicked on Accept Button");
            utils.waitUntilElelemntShouldBeDisplay(driver, By.xpath("//*[text()='The payment request is accepted and sent for approval.']"), 30);
            String validationMsg = driver.findElement(By.xpath("//*[text()='The payment request is accepted and sent for approval.']")).getText();
            Assert.assertTrue(validationMsg.equals("The payment request is accepted and sent for approval."), "Validation msg is not matched");
            utils.log4j("I checked validation msg Is: " + validationMsg);
            utils.click(driver.findElement(By.className("toggle-card")), driver);
            utils.log4j("I click on filter");
            driver.findElement(By.cssSelector("#txtTxnID")).sendKeys(referenceNo_str);
            utils.log4j("I Enter Transaction Id: " + referenceNo_str);

            utils.click(driver.findElement(By.xpath("//label[@for='ContentPlaceHolder1_ddlPaymentStatus_select']/i")), driver);
            utils.log4j("I Clicked On Payment Status");
            Thread.sleep(1000L);
            List<WebElement> listPaymentStatus1 = driver.findElements(By.xpath("//*[@id='ContentPlaceHolder1_ddlPaymentStatus_select']/li"));
            for (WebElement element : listPaymentStatus1) {
                String paymentStatus = element.getText();
                if (paymentStatus.equals("Awaiting to pay")) {
                    utils.click(element, driver);
                    Thread.sleep(1000L);
                    break;
                }
            }
            utils.waitElementShouldBeClickable(driver.findElement(By.cssSelector("#btnFilter")));
            utils.click(driver.findElement(By.cssSelector("#btnFilter")), driver);
            utils.log4j("I Clicked On Filter Button");
            Thread.sleep(500L);
            List<WebElement> listData = req.getTableData;
            for (WebElement element : listData) {
                // utils.waitUntilElelemntShouldBeDisplay(driver, (By) element, 30);
                utils.retryingToFindElement(element, "getText");

                System.out.println(utils.str_sub);
            }
            driver.findElement(By.cssSelector("#ContentPlaceHolder1_gvRequestPay_lblpaynow_0")).click();
            utils.log4j("I clicked on PayNow Button");
            break;


        }


    }


    @And("^I redirect on top up account page$")
    public void iRedirectOnTopUpAccountPage() throws Throwable {
        propertyFileData = utils.obj.getProperty("card");
        String heading = req.getTopUpPageHeader.getText();
        utils.log4j("-------------------------" + heading + "---------------------------------");
        utils.readPropertiesFile(propertiesFileUrl);
        List<WebElement> listOfPaymentMode = req.getPaymentModeOnTopUpPage;
        for (WebElement element : listOfPaymentMode) {
            utils.retryingToFindElement(element, "getText");

            utils.log4j("payment doing from  " + propertyFileData);
            if (propertyFileData.equalsIgnoreCase("Credit Card") && propertyFileData.equalsIgnoreCase(utils.str_sub)) {
                System.out.println("Credit card");
//                req.selectCard.click();
                utils.click(req.selectCard,driver);
                Thread.sleep(3000L);
               /* List<WebElement> listOfCards = req.getListCards;
                for (WebElement element1 : listOfCards) {
                    String cardIs = element1.getText();
                    System.out.println(cardIs);
                    if (!cardIs.equalsIgnoreCase("--SELECT--")) {
                        utils.waitElementShouldBeClickable(element1);
                        utils.click(element1, driver);
                        utils.log4j("I Selected Card Is: " + cardIs);
                        utils.transactionDetails();
                        break;
                    }
                }*/
                req.enterCvvCode.sendKeys("123");
//                req.getClickOnPayNow.click();
                utils.click(req.getClickOnPayNow, driver);
                Thread.sleep(5000L);
 /*               utils.setWebDriverFluentWait(2,50,By.xpath("//*[text()='Your transaction has been successfully processed.']"));
               utils.waitUntilElelemntShouldBeDisplay(driver,By.xpath("//*[text()='Your transaction has been successfully processed.']"),30);*/
               Assert.assertEquals(req.transactionSuccessfulValmsg.getText(),"Your transaction has been successfully processed.");
                break;

            } else if (propertyFileData.equalsIgnoreCase("Net Banking") && propertyFileData.equalsIgnoreCase(utils.str_sub)) {
                System.out.println("Net Banking");
                element.click();
            }
        }

    }

    @And("^I check transaction report page$")
    public void iCheckTransactionReportPage() throws Throwable {
        utils.log4j("--------------------------------TRANSACTION REPORT--------------------------------------------------");
        utils.click(driver.findElement(By.xpath("//div[@class='toggle-card']")), driver);
        Thread.sleep(500L);
        utils.log4j("I Clicked On Filter ");
        //System.out.println("Reference number: " + referenceNo_str);
        req.getTransactionIdReport.sendKeys(referenceNo_str);
        Thread.sleep(500L);
        utils.log4j("I Enter Transction ID");
        utils.click(req.getFilterButton, driver);
        Thread.sleep(2000L);
        List<WebElement> listTableHeading = req.getPaymentReportTableHeading;
        for (WebElement webElement : listTableHeading) {
            String tableElement = webElement.getText();
            utils.log4j("Table Heading of Transaction Report Page: " + tableElement);
        }
        utils.click(req.getGetViewHistoryFromReport, driver);
        utils.waitUntilElelemntShouldBeDisplay(driver, By.xpath("//*[contains(text(),'Payment Summary')]"), 30);
        String paymentSummeryTxt = req.getPaymentSummeryTitle.getAttribute("innerText");
        System.out.println("i am on" + paymentSummeryTxt + "Page");

        List<WebElement> listPageData = req.getPaymentHistoryPage;

        for (WebElement webElement : listPageData) {
            String data = webElement.getText();
            utils.log4j("Payment summery data is: " + data);

        }
    }

    @And("^I check transaction payment report of register contact$")
    public void niCheckTransactionPaymentReportOfRegisterContact() throws Throwable {
        utils.log4j("--------------------------------TRANSACTION REPORT--------------------------------------------------");
        Thread.sleep(5000L);
        utils.waitElementShouldBeClickable(con.getFilterClick);
        utils.click(con.getFilterClick,driver);
//        con.getFilterClick.click();
        Thread.sleep(500L);
        utils.log4j("I Clicked On Filter ");
        System.out.println("Reference number line 2465: " + referenceNo_str);
        req.getTransactionIdReport.sendKeys(referenceNo_str);
        Thread.sleep(500L);
        utils.log4j("I Enter Transction ID");
        utils.click(req.getFilterButton, driver);
        Thread.sleep(2000L);
        utils.log4j("Checking field Business Name");
        businessReports.getReports("Business Name", reports_pom.getPaymentsPageTableData, reports_pom.getPaymentsPageTableHeading);
        Assert.assertFalse(businessReports.field,"Field is empty");
        utils.log4j("Checking field Transaction ID");
        businessReports.getReports("Transaction ID", reports_pom.getPaymentsPageTableData, reports_pom.getPaymentsPageTableHeading);
        Assert.assertFalse(businessReports.field,"Field is empty");
        utils.log4j("Checking field Date");
        businessReports.getReports("Date", reports_pom.getPaymentsPageTableData, reports_pom.getPaymentsPageTableHeading);
        Assert.assertFalse(businessReports.field,"Field is empty");
        utils.log4j("Checking field Invoice No");
        businessReports.getReports("Invoice No", reports_pom.getPaymentsPageTableData, reports_pom.getPaymentsPageTableHeading);
        businessReports.dataList.add(businessReports.data);
        utils.log4j("Checking field Type of Payment");
        businessReports.getReports("Type of Payment", reports_pom.getPaymentsPageTableData, reports_pom.getPaymentsPageTableHeading);
        Assert.assertFalse(businessReports.field,"Field is empty");
        utils.log4j("Checking field Paid Amount");
        businessReports.getReports("Paid Amount", reports_pom.getPaymentsPageTableData, reports_pom.getPaymentsPageTableHeading);
        businessReports.dataList.add(businessReports.data.replace(",", ""));
        utils.log4j("Checking field Currency");
        businessReports.getReports("Currency", reports_pom.getPaymentsPageTableData, reports_pom.getPaymentsPageTableHeading);
        businessReports.dataList.add(businessReports.data);
        utils.log4j("Checking field Bank Reference No");
        businessReports.getReports("Bank Reference No",reports_pom.getPaymentsPageTableData, reports_pom.getPaymentsPageTableHeading);
        Assert.assertFalse(businessReports.field,"Field is empty");
        utils.log4j("Checking field Status");
        businessReports.getReports("Status",reports_pom.getPaymentsPageTableData, reports_pom.getPaymentsPageTableHeading);
        Assert.assertEquals(businessReports.data,"Awaiting Payment");
        utils.log4j("Checking field Actions");
        businessReports.getReports("Actions",reports_pom.getPaymentsPageTableData, reports_pom.getPaymentsPageTableHeading);
        Assert.assertTrue(businessReports.field);
        arrayList = new ArrayList<>();
        arrayList.add(invoiceNumber);
        arrayList.add(amtInString);
        arrayList.add(currency_Str);
        /*for (int i = 0; i < businessReports.dataList.size(); i++) {
            System.out.println(businessReports.dataList.get(i));
        }*/
        System.out.println( arrayList.equals(businessReports.dataList));
        /*List<WebElement> listTableHeading = req.getPaymentReportTableHeading;
        int count = 0;
        for (WebElement webElement : listTableHeading) {
            String tableElement = webElement.getText();
            String tableData = req.getPaymentReportTableData.get(count).getText();
            utils.log4j("Table Heading of Transaction Report Page And Data Is: " + tableElement + " :" + tableData);
            count++;
        }

        utils.click(req.getGetViewHistoryFromReport, driver);
        utils.waitUntilElelemntShouldBeDisplay(driver, By.xpath("//*[contains(text(),'Payment Summary')]"), 30);
        String paymentSummeryTxt = req.getPaymentSummeryTitle.getAttribute("innerText");
        System.out.println("i am on" + paymentSummeryTxt + "Page");
        String summeryText = req.getRequestSummeryText.getText();
        utils.log4j("Checking " + summeryText + " Report Data");
        //utils.log4j("Checking " + summeryText + " Report Data");
        List<WebElement> listTableHeading1 = req.getRequestSummeryReportTableHeading;
        int count1 = 0;
        for (WebElement webElement : listTableHeading1) {
            String tableElement = webElement.getText();
            String tableData = req.getPaymentSummeryTableData.get(count1).getAttribute("innerText");
            utils.log4j(tableElement + " :" + tableData);
            count1++;
        }*/

    }

    @And("^I check collection report and payment report$")
    public void iCheckCollectionReportAndPaymentReport() throws Throwable {
        String linkToclick = null;
        utils.readPropertiesFile(propertiesFileUrl);
        String email = utils.obj.getProperty("emailLogin");
        String password = utils.obj.getProperty("password_Login");
        utils.getMails(email);
        List<WebElement> ListOfLinks = driver.findElements(By.xpath("//*[@valign='top']/div/a"));
        for (int j = 0; j < ListOfLinks.size(); j++) {
            //utils.retryingFindClick(ListOfLinks.get(j));
            linksText = ListOfLinks.get(j).getAttribute("innerText");
            linkToclick = ListOfLinks.get(j).getAttribute("href");

        }
        //System.out.println("Links from email: " + linkToclick);
        driver.navigate().to(linkToclick);
//        utils.pMXLogin(email, password);
        Thread.sleep(1000);
        utils.waitElementShouldBeClickable(con.getFilterClick);
        utils.click(con.getFilterClick, driver);
//        req.getTransactionIdReport.sendKeys("005510071957");
        req.getTransactionIdReport.sendKeys(referenceNo_str);
        utils.click(driver.findElement(By.cssSelector("#ContentPlaceHolder1_btnFilter")), driver);
        Thread.sleep(2000L);
        req.getGetViewHistoryFromCollectionReport.click();
        Thread.sleep(2000L);
        utils.log4j("Checking field Company Name");
        businessReports.getReports("Company Name",reports_pom.getCollectionsPageTableData,reports_pom.getCollectionsPageTableHeading);
        businessReports.dataList4.add(businessReports.data);
        utils.log4j("Checking field Reference Code");
        businessReports.getReports("Reference Code",reports_pom.getCollectionsPageTableData,reports_pom.getCollectionsPageTableHeading);
        businessReports.dataList4.add(businessReports.data);
        utils.log4j("Checking field Transaction ID");
        businessReports.getReports("Transaction ID",reports_pom.getCollectionsPageTableData,reports_pom.getCollectionsPageTableHeading);
        Assert.assertFalse(businessReports.field,"Field is empty");
        utils.log4j("Checking field Transaction Date");
        businessReports.getReports("Transaction Date",reports_pom.getCollectionsPageTableData,reports_pom.getCollectionsPageTableHeading);
        Assert.assertFalse(businessReports.field,"Field is empty");
        utils.log4j("Checking field Payment From");
        businessReports.getReports("Payment From",reports_pom.getCollectionsPageTableData,reports_pom.getCollectionsPageTableHeading);
        Assert.assertFalse(businessReports.field,"Field is empty");
        utils.log4j("Checking field Received Amount");
        businessReports.getReports("Received Amount",reports_pom.getCollectionsPageTableData,reports_pom.getCollectionsPageTableHeading);
        businessReports.dataList4.add(businessReports.data.replace(",", ""));
        utils.log4j("Checking field Currency");
        businessReports.getReports("Currency",reports_pom.getCollectionsPageTableData,reports_pom.getCollectionsPageTableHeading);
        businessReports.dataList4.add(businessReports.data);
        utils.log4j("Checking field Invoice Number");
        businessReports.getReports("Invoice Number",reports_pom.getCollectionsPageTableData,reports_pom.getCollectionsPageTableHeading);
        businessReports.dataList4.add(businessReports.data);
        utils.log4j("Checking field Settlement Amount");
        businessReports.getReports("Settlement Amount",reports_pom.getCollectionsPageTableData,reports_pom.getCollectionsPageTableHeading);
//        Assert.assertEquals(businessReports.data,"00.00");
        Assert.assertFalse(businessReports.field,"Field is empty");
        utils.log4j("Checking field Bank Reference No");
        businessReports.getReports("Bank Reference No",reports_pom.getCollectionsPageTableData,reports_pom.getCollectionsPageTableHeading);
        Assert.assertFalse(businessReports.field,"Field is not empty");
        utils.log4j("Checking field Settlement Status");
        businessReports.getReports("Settlement Status",reports_pom.getCollectionsPageTableData,reports_pom.getCollectionsPageTableHeading);
        Assert.assertEquals(businessReports.data,"Success");
        utils.log4j("Checking field Actions");
        businessReports.getReports("Actions",reports_pom.getCollectionsPageTableData,reports_pom.getCollectionsPageTableHeading);
        Assert.assertTrue(businessReports.field);
        arrayList = new ArrayList<>();
        arrayList.add(contactName_Str);
        arrayList.add(reference_code_Str);
        arrayList.add(amtInString);
        arrayList.add(currency_Str);
        arrayList.add(invoiceNumber);
        System.out.println(arrayList.equals(businessReports.dataList4));
        utils.PMXLogOut();
        utils.log4j("I logOut Pmx");
        Thread.sleep(1000L);
       /* System.out.println(email_Web+":"+password);
        utils.pMXLogin(email_Web, password);
        Thread.sleep(1000L);
        utils.waitElementShouldBeClickable(con.dashBoardMenu);
        utils.clickDashboardMenu();
        Thread.sleep(2000L);
        utils.click(req.getReports, driver);
        List<WebElement> reportsTabList = req.getReportsMenuVendor;
        for (WebElement element : reportsTabList) {
            utils.waitListOFElementShouldBeClickable(req.getReportsMenuVendor);
            String text = element.getText();
            if (text.equals("Payments")) {
                System.out.println("Text is: " + text);
                element.click();
                Thread.sleep(2000L);
                break;
            }
        }
        utils.pageLoadTime();
        Assert.assertEquals(con.getPageTitle.getText(), "PAYMENTS MADE REPORT");
        utils.waitElementShouldBeClickable(con.getFilterClick);
        utils.click(con.getFilterClick, driver);
        System.out.println("Reference Number: "+referenceNo_str);
        req.getTransactionIdReport.sendKeys(referenceNo_str);
        utils.click(con.getFilterButton,driver);
        Thread.sleep(1000L);
//        utils.click(driver.findElement(By.cssSelector("#ContentPlaceHolder1_btnFilter")), driver);
        utils.waitUntilWebElelemntShouldBeDisplay(driver, req.getGetViewHistoryFromReport, 10);
        utils.click(req.getGetViewHistoryFromReport, driver);
        Thread.sleep(2000L);
        utils.log4j("Checking field Business Name");
        businessReports.getReports("Business Name", reports_pom.getPaymentsPageTableData, reports_pom.getPaymentsPageTableHeading);
        Assert.assertFalse(businessReports.field,"Field is empty");
        utils.log4j("Checking field Transaction ID");
        businessReports.getReports("Transaction ID", reports_pom.getPaymentsPageTableData, reports_pom.getPaymentsPageTableHeading);
        Assert.assertFalse(businessReports.field,"Field is empty");
        utils.log4j("Checking field Date");
        businessReports.getReports("Date", reports_pom.getPaymentsPageTableData, reports_pom.getPaymentsPageTableHeading);
        Assert.assertFalse(businessReports.field,"Field is empty");
        utils.log4j("Checking field Invoice No");
        businessReports.getReports("Invoice No", reports_pom.getPaymentsPageTableData, reports_pom.getPaymentsPageTableHeading);
        businessReports.dataList5.add(businessReports.data);
        utils.log4j("Checking field Type of Payment");
        businessReports.getReports("Type of Payment", reports_pom.getPaymentsPageTableData, reports_pom.getPaymentsPageTableHeading);
        Assert.assertFalse(businessReports.field,"Field is empty");
        utils.log4j("Checking field Paid Amount");
        businessReports.getReports("Paid Amount", reports_pom.getPaymentsPageTableData, reports_pom.getPaymentsPageTableHeading);
        businessReports.dataList5.add(businessReports.data.replace(",", ""));
        utils.log4j("Checking field Currency");
        businessReports.getReports("Currency", reports_pom.getPaymentsPageTableData, reports_pom.getPaymentsPageTableHeading);
        businessReports.dataList5.add(businessReports.data);
        utils.log4j("Checking field Bank Reference No");
        businessReports.getReports("Bank Reference No",reports_pom.getPaymentsPageTableData, reports_pom.getPaymentsPageTableHeading);
        Assert.assertFalse(businessReports.field,"Field is empty");
        utils.log4j("Checking field Status");
        businessReports.getReports("Status",reports_pom.getPaymentsPageTableData, reports_pom.getPaymentsPageTableHeading);
        Assert.assertEquals(businessReports.data,"Success");
        utils.log4j("Checking field Actions");
        businessReports.getReports("Actions",reports_pom.getPaymentsPageTableData, reports_pom.getPaymentsPageTableHeading);
        Assert.assertTrue(businessReports.field);
        arrayList2 = new ArrayList<>();
        arrayList2.add(invoiceNumber);
        arrayList2.add(amtInString);
        arrayList2.add(currency_Str);
//        Arrays.asList(arrayList2).removeAll(Arrays.asList(arrayList));
//        System.out.println("Array list 2: "+arrayList2);
//        System.out.println("Array List 1: "+arrayList);
//        System.out.println(arrayList2.size()+"array----datalist5"+businessReports.dataList5.size());
       *//* for(int i=0;i<arrayList2.size();i++){
            System.out.println("Value in arraylist2: "+arrayList2.get(i));
        }*//*
       *//* for(int i=0;i<businessReports.dataList5.size();i++){
            System.out.println("Value in datalist5: "+businessReports.dataList5.get(i));
        }*//*

        System.out.println(arrayList2.equals(businessReports.dataList5));*/

    }

    @And("I navigate to Requests Received page")
    public void iNavigateToRequestsReceivedPage() throws InterruptedException {
        Thread.sleep(3000);
        utils.clickDashboardMenu();
        utils.click(req.getPayments, driver);
        List<WebElement> listPayments = req.getPaymentsMenu;
        for (int i = 0; i < listPayments.size(); i++) {
            utils.waitListOFElementShouldBeClickable(req.getPaymentsMenu);
            System.out.println(req.getPaymentsMenu.get(i).getText());
            String text = listPayments.get(i).getText();
            if (text.equals("Requests Received")) {
                System.out.println("Text is: " + text);
                utils.click(listPayments.get(i), driver);
                Thread.sleep(2000L);
                break;
            }
        }
    }


    @And("I click on Upload Bulk Payment Request File tab")
    public void iClickOnUploadBulkPaymentRequestFileTab() {
        req.getploadaBulkPaymentFileTab.click();
    }


    @And("I verify different tabs are present on the collect payment page")
    public void iVerifyDifferentTabsArePresentOnTheCollectPaymentPage(DataTable dataTable) {
        List<List<String>> tabs = dataTable.cells();
        for (int i = 0; i < tabs.size(); i++) {
            String tab = tabs.get(i).get(0);

            if (tab.equalsIgnoreCase("UPLOAD A BULK PAYMENT REQUEST FILE")) {
                req.getploadaBulkPaymentFileTab.isDisplayed();
                Assert.assertEquals(req.getploadaBulkPaymentFileTab.getText(), tab);
            } else if (tab.equalsIgnoreCase("REQUEST A PAYMENT")) {
                req.getRequestPaymentTab.isDisplayed();
                Assert.assertEquals(req.getRequestPaymentTab.getText(), tab);
            } else if (tab.equalsIgnoreCase("BOOKED TRANSACTIONS")) {
                req.getBookedTransactions.isDisplayed();
                Assert.assertEquals(req.getBookedTransactions.getText(), tab);
            }


        }

    }

    @And("I verify all fields are present in Bulk Payment tab")
    public void iVerifyAllFieldsArePresentInBulkPaymentTab() {
        req.getBulkPaymentFileUploads.isEnabled();
        System.out.println("Line 3141: "+req.getSampleText.getAttribute("innerHTML"));
        Assert.assertEquals(req.getSampleText.getAttribute("innerHTML"), "Click here to view sample");
    }


    @And("I upload a file for Bulk Payment Request in upload field")
    public void iUploadAFileForBulkPaymentRequestInUploadField(DataTable table) throws IOException, InterruptedException {
        utils.log4j("Deleting the old template file");
        utils.deleteOldFile("C:\\Users\\vishal.l\\Downloads\\SampleBulkUploadRequest.xls");
        Thread.sleep(3000L);
        utils.log4j("Downloading the new template file");
        req.getDownloadFileLink.click();
        Thread.sleep(1000);
        cell_List = table.cells();
        cell_size = cell_List.size();
        System.out.println("Cell size: " + cell_size);
        File file = new File(filePath + "\\" + fileName);
        FileInputStream inputStream = new FileInputStream(file);
        HSSFWorkbook workbook = null;
        String fileExtensionName = fileName.substring(fileName.indexOf("."));
        System.out.println("File Extension is: " + fileExtensionName);
        workbook = new HSSFWorkbook(inputStream);
        HSSFSheet sheet = workbook.getSheet("Sheet1");
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
            workbook.write(outputStream);

        }
        Actions actions = new Actions(driver);
        actions.moveToElement(req.getFileUpoadField).build().perform();
        req.getFileUpoadField.sendKeys("C:\\Users\\vishal.l\\Downloads\\SampleBulkUploadRequest.xls");
        //u.click(con.getFileUpoadField,driver);
        utils.click(con.getContinueButton, driver);
    }

    @And("I click on continue button and check data in Booked transactions tab")
    public void iClickOnContinueButtonAndCheckDataInBookedTransactionsTab() throws InterruptedException {
            Thread.sleep(2000);
            String bookedTransactionExpaned = req.getBookedTransactions.getAttribute("aria-expanded");
            if (bookedTransactionExpaned.equals("true")) {
             utils.log4j("Booked transaction tab is expanded");
            } else {
            Assert.assertTrue(false, "Booked transaction tab is not expanded");
            }
    }


}

