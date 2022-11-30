package step_definitions;

import baseClass.Utils;
import baseClass.mainDriver;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import io.cucumber.datatable.DataTable;
import pageFactory.addContact_POM;
import pageFactory.invoice_POM;

import java.util.List;

public class invoicing extends  mainDriver {

    public invoice_POM inv = new invoice_POM(driver);
    public addContact_POM con = new addContact_POM(driver);
    public Utils u = new Utils();

    @When("I click on Invoicing link")
    public void iClickOnInvoicingLink() throws InterruptedException {
        Thread.sleep(5000);
        u.log4j("I click on Dashboard menu");
        u.waitAndClick(con.dashBoardMenu);
        u.log4j("I click on invoicing link ");
        u.click(inv.invoicingLink, driver);
    }

    @Then("I should see the following links under Invoicing")
    public void iShouldSeeTheFollowingLinksUnderInvoicing(DataTable dataTable)  {
        List<List<String>> getCells = dataTable.cells();
        for (int i = 0; i < getCells.size(); i++) {
            String getCell_str = getCells.get(i).get(0);
            switch (getCell_str) {
                case "Send Invoices":
                    u.waitUntilWebElelemntShouldBeDisplay(driver,inv.sendInvoicesLink,20);
                    boolean bool_isDisplay = inv.sendInvoicesLink.isDisplayed();
                    Assert.assertEquals(true, bool_isDisplay);
                    boolean bool_isEnabled = inv.sendInvoicesLink.isEnabled();
                    Assert.assertEquals(true, bool_isEnabled);
                    u.log4j("I see link: " + getCell_str);
                    break;

                case "Track Invoices":
                    u.waitUntilWebElelemntShouldBeDisplay(driver,inv.trackInvoicesLink,20);
                    boolean bool1_isDisplay = inv.trackInvoicesLink.isDisplayed();
                    Assert.assertEquals(true, bool1_isDisplay);
                    boolean bool1_isEnable = inv.trackInvoicesLink.isEnabled();
                    Assert.assertEquals(true, bool1_isEnable);
                    u.log4j("I see link: " + getCell_str);
                    break;

                case "Settings":
                    boolean bool2_isDisplay = inv.invoiceSettingsLink.isDisplayed();
                    Assert.assertEquals(true, bool2_isDisplay);
                    boolean bool2_isEnable = inv.invoiceSettingsLink.isEnabled();
                    Assert.assertEquals(true, bool2_isEnable);
                    u.log4j("I see link: " + getCell_str);
                    break;

                case "Customize Invoices":
                    inv.invoiceSettingsLink.click();
                    u.waitUntilWebElelemntShouldBeDisplay(driver,inv.customizeInvoicesLink,20);
                    boolean bool3_isDisplay = inv.customizeInvoicesLink.isDisplayed();
                    Assert.assertEquals(true, bool3_isDisplay);
                    boolean bool3_isEnable = inv.customizeInvoicesLink.isEnabled();
                    Assert.assertEquals(true, bool3_isEnable);
                    u.log4j("I see link: " + getCell_str);
                    break;
            }

        }
    }

    @And("I click on invoicing following links {string}")
    public void iClickOnInvoicingFollowingLinks(String arg0) throws InterruptedException {
        List<WebElement> element = inv.invoicingLinks;
        System.out.println("Links size are: " + element.size());
        for (int i = 0; i < element.size(); i++) {
            System.out.println("Line 84:" +element.get(i).getText());
            if (element.get(i).getText().equals(arg0) && element.get(i).getText().equals("Send Invoices")) {
                u.log4j("I click on Send Invoices");
                element.get(i).click();
                Thread.sleep(2000);
                break;
            } else if (element.get(i).getText().equals(arg0) && element.get(i).getText().equals("Track Invoices")) {
                u.log4j("I click on Track Invoices");
                element.get(i).click();
                Thread.sleep(2000);
                break;
            } else if (element.get(i).getText().equals(arg0) && element.get(i).getText().equals("Settings")) {
                u.log4j("I click on Customize Invoices");
                element.get(i).click();
                inv.customizeInvoicesLink.click();
                Thread.sleep(2000);
                break;
            }
        }
    }

    @Then("I should land on particular page for invoicing links")
    public void iShouldLandOnParticularPageForInvoicingLinks() {
        String str = con.getPageTitle.getText();
        switch (str) {
            case "Send Invoices":
                Assert.assertEquals(str, "Send Invoices");
                u.log4j("I am on page: " + str);
                break;
            case "Track Invoices":
                Assert.assertEquals(str, "Track Invoices");
                u.log4j("I am on page: " + str);
                break;
            case "Customize Invoices":
                Assert.assertEquals(str, "CUSTOMIZE INVOICE");
                u.log4j("I am on page: " + str);
                break;
        }
    }

    @Then("I verify all fields on Send Invoices page")
    public void iVerifyAllFieldsOnSendInvoicesPage() {
//        System.out.println("Line 125: "+inv.firstNameLabel.getText());
        Assert.assertTrue(inv.purchaseOrderNumber.isDisplayed());
        u.log4j("Purchase order Number field is displayed.");
        Assert.assertEquals(inv.purchaseOrderNumberLabel.getText(),"Purchase Order Number");
        u.log4j("Purchase Order Number label is present.");
        Assert.assertTrue(inv.invoiceNumber.isDisplayed());
        u.log4j("Invoice Number field is displayed.");
        Assert.assertEquals(inv.invoiceNumberLabel.getText(),"Invoice Number *");
        u.log4j("Invoice Number label is present.");
        Assert.assertTrue(inv.issueDate.isDisplayed());
        u.log4j("Issue date field is displayed.");
        Assert.assertEquals(inv.issueDateLabel.getText(),"Issue Date *");
        u.log4j("Issue date label is present.");
        Assert.assertTrue(inv.paymentDueDate.isDisplayed());
        u.log4j("Payment Due date field is displayed.");
        Assert.assertEquals(inv.paymentDueDateLabel.getText(),"Payment Due Date *");
        u.log4j("Payment Due date label is present.");
        Assert.assertTrue(inv.paymentTerms.isDisplayed());
        u.log4j("Payment Terms field is dispalyed");
        Assert.assertEquals(inv.paymentTermsLabel.getText(),"Payment Terms");
        u.log4j("Payment Terms label is present");
        Assert.assertTrue(inv.firstName.isDisplayed());
        u.log4j("First Name field is displayed");
        Assert.assertEquals(inv.firstNameLabel.getText(),"First Name *");
        u.log4j("First Name label is present");
        Assert.assertTrue(inv.lastName.isDisplayed());
        u.log4j("Last Name field is displayed");
        Assert.assertEquals(inv.lastNameLabel.getText(),"Last Name *");
        u.log4j("Last Name label is present");
        Assert.assertTrue(inv.vendorCompanyName.isDisplayed());
        u.log4j("Vendor Company Name field is displayed");
        Assert.assertEquals(inv.vendorCompanyNameLabel.getText(),"Enter Contact Name or Company Name *");
        u.log4j("Vendor Company Name label is present");
        Assert.assertTrue(inv.baCompanyName.isDisplayed());
        u.log4j("Billing address company name field is displayed");
        Assert.assertEquals(inv.baCompanyNameLabel.getText(),"Company Name *");
        u.log4j("Billing address company name label is present");
        Assert.assertTrue(inv.baEmail.isDisplayed());
        u.log4j("Billing address email field is displayed");
        Assert.assertEquals(inv.baEmailLabel.getText(),"Email *");
        u.log4j("Billing address email is present");
        Assert.assertTrue(inv.baAddress.isDisplayed());
        u.log4j("Billing address field is displayed");
        Assert.assertTrue(inv.vendorAddress.isDisplayed());
        u.log4j("Vendor address field is displayed");
        Assert.assertEquals(inv.vendorAddressLabel.getText(),"VENDOR ADDRESS");
        u.log4j("Vendor address lable is present");
        Assert.assertTrue(inv.shippingAddress.isDisplayed());
        u.log4j("Shipping address field is displayed");
        Assert.assertEquals(inv.shippingAddressLabel.getText(),"SHIPPING ADDRESS");
        u.log4j("Shipping address label is present");
        Assert.assertTrue(inv.baCity.isDisplayed());
        u.log4j("Billing address city is displayed");
        Assert.assertEquals(inv.baCityLabel.getText(),"City");
        u.log4j("Billing address city label is present");
        Assert.assertTrue(inv.baPincode.isDisplayed());
        u.log4j("Billing address pincode field is displayed");
        Assert.assertEquals(inv.baPincodeLabel.getText(),"Pincode");
        u.log4j("Billing address pincode label is present");
        Assert.assertTrue(inv.vendorCity.isDisplayed());
        u.log4j("Vendor address city field is dispalyed");
        Assert.assertEquals(inv.vendorCityLabel.getText(),"City");
        u.log4j("Vendor address city label is present");
        Assert.assertTrue(inv.vendorPincode.isDisplayed());
        u.log4j("Vendor address pincode field is displayed");
        Assert.assertEquals(inv.vendorPincodeLabel.getText(),"Pincode");
        u.log4j("Vendor address pincode label is present");
        Assert.assertTrue(inv.saCity.isDisplayed());
        u.log4j("Shipping address city field is dispalyed");
        Assert.assertEquals(inv.saCityLabel.getText(),"City");
        u.log4j("Shipping address city label is present");
        Assert.assertTrue(inv.saPincode.isDisplayed());
        u.log4j("Shipping address pincode field is displayed");
        Assert.assertEquals(inv.saPincodeLabel.getText(),"Pincode");
        u.log4j("Shipping address pincode label is present");
        Assert.assertTrue(inv.baCountry.isDisplayed());
        u.log4j("Billing address country field is displayed");
        Assert.assertEquals(inv.baCountryLabel.getText(),"Country *");
        u.log4j("Billing address country label is present");
        Assert.assertTrue(inv.baState.isDisplayed());
        u.log4j("Billing address state field is displayed");
        Assert.assertEquals(inv.baStateLabel.getText(),"State *");
        u.log4j("Billing address state label is present");
        Assert.assertTrue(inv.vaCountry.isDisplayed());
        u.log4j("Vendor address country field is displayed");
        Assert.assertEquals(inv.vaCountryLabel.getText(),"Country *");
        u.log4j("Vendor address country label is present");
        Assert.assertTrue(inv.vaState.isDisplayed());
        u.log4j("Vendor address state field is displayed");
        Assert.assertEquals(inv.vaStateLabel.getText(),"State *");
        u.log4j("Vendor addresss state label is present");
        Assert.assertTrue(inv.saCountry.isDisplayed());
        u.log4j("Shipping address country field is displayed");
        Assert.assertEquals(inv.saCountryLabel.getText(),"Country *");
        u.log4j("Shipping address country label is present");
        Assert.assertTrue(inv.saState.isDisplayed());
        u.log4j("Shipping address state field is displayed");
        Assert.assertEquals(inv.saStateLabel.getText(),"State *");
        u.log4j("Shipping address state label is present");
        Assert.assertTrue(inv.shipAddressCheckbox.isEnabled());
        u.log4j("Ship to this address checkbox is enabled");
        Assert.assertTrue(inv.addNewLineItemButton.isEnabled());
        u.log4j("Add new line button is enabled");
        Assert.assertEquals(inv.addNewLineItemLabel.getText(),"ADD NEW LINE ITEM");
        u.log4j("Add new line label is present");
        Assert.assertTrue(inv.notesTextbox.isEnabled());
        u.log4j("Notes textbox is enabled");
        Assert.assertTrue(inv.previewButton.isDisplayed());
        u.log4j("Preview button is displayed");
        Assert.assertTrue(inv.previewButton.isEnabled());
        u.log4j("Preview button is enabled");
        Assert.assertTrue(inv.cancelButton.isDisplayed());
        u.log4j("Cancel button is displayed");
        Assert.assertTrue(inv.cancelButton.isEnabled());
        u.log4j("Cancel button is enabled");
        Assert.assertTrue(inv.saveInvoiceButton.isDisplayed());
        u.log4j("Save Invoice button is displayed");
        Assert.assertTrue(inv.saveInvoiceButton.isEnabled());
        u.log4j("Save Invoice button is enabled");
        Assert.assertTrue(inv.generateInvoiceButton.isDisplayed());
        u.log4j("Generate Invoice button is displayed");
        Assert.assertTrue(inv.generateInvoiceButton.isEnabled());
        u.log4j("Generate Invoice button is enabled");
    }

    @And("I click on preview button")
    public void iClickOnPreviewButton() {
      u.waitAndClick(inv.previewButton);
    }

    @Then("I verify validation messages for all mandatory fields on Send invoice page")
    public void iVerifyValidationMessagesForAllMandatoryFieldsOnSendInvoicePage() {
        Assert.assertEquals(inv.invoiceEmptyValMsg.getText(),"Invoice No cannot be empty..");
        inv.invoiceNumber.sendKeys("test");
        u.waitAndClick(inv.previewButton);
        Assert.assertEquals(inv.paymentDueDateValMsg.getText(),"Deliver date should not be empty.");
        Assert.assertEquals(inv.vendorCompanyNameValMsg.getText(),"Please enter contact name");
        Assert.assertEquals(inv.vendorPhoneNumberValMsg.getText(),"Please enter Phone Number");
        Assert.assertEquals(inv.vendorEmailValMsg.getText(),"Please enter Email Id");
        Assert.assertEquals(inv.vendorStateValMsg.getText(),"Please Select Vendor State");
        Assert.assertEquals(inv.shippingAddressValMsg.getText(),"Please Enter Shipping Address");
        Assert.assertEquals(inv.shippingStateValMsg.getText(),"Please Select Shipping State");

    }
}