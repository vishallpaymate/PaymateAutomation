package step_definitions;

import baseClass.Utils;
import baseClass.mainDriver;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pageFactory.pmxAdmin_POM;

import java.util.concurrent.TimeUnit;

public class pmxAdmin extends mainDriver {
    public Utils util = new Utils();
    public pmxAdmin_POM pmxAdmin = new pmxAdmin_POM(driver);
    Faker faker = new Faker();
    String path = System.getProperty("user.dir");
    String filespath = path + "\\InvalidFiles\\test.pdf";

    @And("I go to Add Business from Business Management menu")
    public void iGoToAddBusinessFromBusinessManagementMenu() throws InterruptedException {
//        actions.moveToElement(pmxAdmin.businessManagementMenu).build().perform();
//        pmxAdmin.businessManagementMenu.click();
        util.waitAndClick(pmxAdmin.businessManagementMenu);
        util.waitAndClick(pmxAdmin.businessesMenu);
        util.waitAndClick(pmxAdmin.addBusiness);
        Assert.assertEquals(pmxAdmin.addBusinessPageText.getText(), "Add Business");
    }

    @Then("I expand Business Details section and click next")
    public void iExpandBusinessDetailsSectionAndClickNext() throws InterruptedException {
//        util.waitAndClick(pmxAdmin.businessDetailsSection);
        Assert.assertTrue(pmxAdmin.businessDetailsSection.isDisplayed(), "Business Details is not expanded");
        Thread.sleep(2000);
//        pmxAdmin.businessDetailsNextButton.click();
        util.waitAndClick(pmxAdmin.businessDetailsNextButton);

    }

    @Then("I check validation for all mandatory fields")
    public void iCheckValidationForAllMandatoryFields() {
//        util.waitUntilWebElelemntShouldBeDisplay(driver,pmxAdmin.businessValidationMsg,30);
        Assert.assertEquals(pmxAdmin.businessNameValidationMsg.getText(), "Please enter Business Name");
        pmxAdmin.enterBusinessName.sendKeys("test");
        util.waitAndClick(pmxAdmin.businessDetailsNextButton);
        Assert.assertEquals(pmxAdmin.businessFirstNameValidationMsg.getText(), "Please First Name");
        pmxAdmin.enterFirstName.sendKeys("test");
        util.waitAndClick(pmxAdmin.businessDetailsNextButton);
        Assert.assertEquals(pmxAdmin.businessLastNameValidationMsg.getText(), "Please Last Name");
        pmxAdmin.enterLastName.sendKeys("test");
        util.waitAndClick(pmxAdmin.businessDetailsNextButton);
        Assert.assertEquals(pmxAdmin.businessEmailValidationMsg.getText(), "Please enter your Emaiid");
        pmxAdmin.enterEmailID.sendKeys("test");
        util.waitAndClick(pmxAdmin.businessDetailsNextButton);
        Assert.assertEquals(pmxAdmin.validEmailValidationMsg.getText(), "Please enter valid Emaiid");
        pmxAdmin.enterEmailID.sendKeys("test@t.com");
        util.waitAndClick(pmxAdmin.businessDetailsNextButton);
        Assert.assertEquals(pmxAdmin.businessMobileValidationMsg.getText(), "Please enter mobile number");
        pmxAdmin.enterMobileNo.sendKeys("test");
        util.waitAndClick(pmxAdmin.businessDetailsNextButton);
        Assert.assertEquals(pmxAdmin.validMobileValidationMsg.getText(), "Please enter valid mobile number");
        pmxAdmin.enterMobileNo.clear();
        pmxAdmin.enterMobileNo.sendKeys("6666666666");
        util.waitAndClick(pmxAdmin.businessDetailsNextButton);
        System.out.println("Line 59:" + pmxAdmin.businessTypeValidationMsg.getAttribute("innerHTML"));
        Assert.assertEquals(pmxAdmin.businessTypeValidationMsg.getAttribute("innerHTML"), "Please Select business type");
        Select businessType = new Select(pmxAdmin.typeOfBusiness);
        businessType.selectByVisibleText("Proprietorship");
        util.waitAndClick(pmxAdmin.businessDetailsNextButton);
        Assert.assertEquals(pmxAdmin.categoryValidationMsg.getText(), "Please Select category");
        Select businessCategory = new Select(pmxAdmin.categoryOfBusiness);
        businessCategory.selectByVisibleText("Baby");
        util.waitAndClick(pmxAdmin.businessDetailsNextButton);
        Assert.assertEquals(pmxAdmin.subCategoryValidationMsg.getText(), "Please Select category");
//        Select businessSubCategory = new Select(pmxAdmin.subCategoryOfBusiness);
//        businessSubCategory.selectByVisibleText("Clothing");
//        util.waitAndClick(pmxAdmin.businessDetailsNextButton);

    }

    @Then("I enter all details in Business Details Field and click next")
    public void iEnterAllDetailsInBusinessDetailsFieldAndClickNext() throws InterruptedException {
        String cpname = faker.company().name();
        pmxAdmin.enterBusinessName.sendKeys(cpname);
        util.log4j("I enter business name as:" + cpname);
        pmxAdmin.enterFirstName.sendKeys(faker.name().lastName());
        pmxAdmin.enterLastName.sendKeys(faker.name().lastName());
        pmxAdmin.enterEmailID.sendKeys(faker.name().firstName() + "pvt@yopmail.com");
        pmxAdmin.enterMobileNo.sendKeys("6666666666");
        Select businessType = new Select(pmxAdmin.typeOfBusiness);
        businessType.selectByVisibleText("Proprietorship");
        Select businessCategory = new Select(pmxAdmin.categoryOfBusiness);
        businessCategory.selectByVisibleText("Baby");
        Select businessSubCategory = new Select(pmxAdmin.subCategoryOfBusiness);
        businessSubCategory.selectByVisibleText("Clothing");
        util.waitAndClick(pmxAdmin.businessDetailsNextButton);
        Thread.sleep(5000);
    }


    @Then("I select Subscription Plan and click save")
    public void iSelectSubscriptionPlanAndClickSave() throws InterruptedException {
        Thread.sleep(5000);
//        util.waitUntilWebElelemntShouldBeDisplay(driver,pmxAdmin.subscriptionPlanSection,30);
        Assert.assertEquals(pmxAdmin.subscriptionPlanSection.getText(), "Subscription Plan");
        util.waitAndClick(pmxAdmin.subscriptionPlanSection);
        Assert.assertTrue(pmxAdmin.subscriptionPlanSectionExpanded.isDisplayed(), "Subscription Plan is not expanded");
        Select subPlan = new Select(pmxAdmin.selectSubscriptionPlan);
//        subPlan.selectByVisibleText("AI");
        subPlan.selectByIndex(1);
        util.waitAndClick(pmxAdmin.saveButton);
        Thread.sleep(10000);
//        util.waitUntilWebElelemntShouldBeDisplay(driver,pmxAdmin.uploadDocumentsPageTitle,30);
        Assert.assertEquals(pmxAdmin.uploadDocumentsPageTitle.getText(), "Upload your documents");
    }

    @And("I am on Upload Documents Page where I enter all mandatory fields and click Confirm")
    public void iAmOnUploadDocumentsPageWhereIEnterAllMandatoryFieldsAndClickConfirm() throws InterruptedException {
        Thread.sleep(5000);
        Assert.assertEquals(pmxAdmin.uploadDocumentsPageTitle.getText(), "Upload your documents");
        pmxAdmin.nameOnPan.sendKeys("test");
        pmxAdmin.panNumber.sendKeys("ARVQK9423M");
        System.out.println("Line 121: " + filespath);
       /* Actions actions = new Actions(driver);
        actions.moveToElement(pmxAdmin.panImageUpload).build().perform();*/
//        util.waitUntilWebElelemntShouldBeDisplay(driver,pmxAdmin.panImageUpload,30);
        pmxAdmin.panImageUpload.sendKeys(filespath);
        pmxAdmin.enterAddress.sendKeys("test");
        pmxAdmin.enterCity.sendKeys("test");
        Select state = new Select(pmxAdmin.selectState);
        state.selectByIndex(1);
        pmxAdmin.enterPinCode.sendKeys("123456");
        Select addressDoc = new Select(pmxAdmin.selectAddressDoc);
        addressDoc.selectByIndex(1);
        pmxAdmin.addressDocUpload.sendKeys(filespath);


    }

    @And("I go to Add user Page from Settings menu")
    public void iGoToAddUserPageFromSettingsMenu() {
        util.waitAndClick(pmxAdmin.settingsMenu);
        util.waitAndClick(pmxAdmin.userSettingsMenu);
        util.waitAndClick(pmxAdmin.addUser);
        util.waitUntilWebElelemntShouldBeDisplay(driver, pmxAdmin.addUserPage, 10);
        Assert.assertEquals(pmxAdmin.addUserPage.getText(), "Add User");
    }

    @Then("I click on Save button")
    public void iClickOnSaveButton() {
        util.waitAndClick(pmxAdmin.saveButton);
    }

    @Then("I check validation for all mandatory fields for add user Page")
    public void iCheckValidationForAllMandatoryFieldsForAddUserPage() {

    }

    @Then("I login to admin portal")
    public void iLoginToAdminPortal() throws InterruptedException {
        driver.navigate().to("https://dev.paymate.in/Beta/PayMateAdmin/Login.aspx");
        util.waitUntilWebElelemntShouldBeDisplay(driver, pmxAdmin.adminUsername, 30);
        pmxAdmin.adminUsername.sendKeys("vishall@yopmail.com");
        pmxAdmin.adminPassword.sendKeys("Paymate@1");
        pmxAdmin.adminLoginButton.click();
        Thread.sleep(5000L);
        System.out.println("Line 318: " + pmxAdmin.adminHomePageText.getText());
        Assert.assertEquals(pmxAdmin.adminHomePageText.getText(), "Welcome to PayMate");
        Thread.sleep(5000);
    }


    @And("I go to Manage Business from Business Management menu")
    public void iGoToManageBusinessFromBusinessManagementMenu() {
        util.waitAndClick(pmxAdmin.businessManagementMenu);
        util.waitAndClick(pmxAdmin.businessesMenu);
        util.waitAndClick(pmxAdmin.manageBusiness);
        Assert.assertEquals(pmxAdmin.manageBusinessTitle.getText(), "Manage Business Documents");
    }

    @Then("I navigate to admin portal")
    public void iNavigateToAdminPortal() {
        driver.navigate().to("https://dev.paymate.in/Beta/PayMateAdmin/Login.aspx");
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
    }

    @And("I go to Manage Documents from Business Management menu")
    public void iGoToManageDocumentsFromBusinessManagementMenu() {
        util.waitAndClick(pmxAdmin.businessManagementMenu);
        util.waitAndClick(pmxAdmin.businessesMenu);
        util.waitAndClick(pmxAdmin.manageDocuments);
        Assert.assertEquals(pmxAdmin.manageBusinessDocsTitle.getText(), "Manage Business Documents");
    }


    @And("I enter {string} in the Email field and click filter")
    public void iEnterInTheEmailFieldAndClickFilter(String arg0) {
        pmxAdmin.businessEmailFilter.sendKeys(arg0);
        Select docStatus = new Select(pmxAdmin.docStatus);
        docStatus.selectByVisibleText("Document Status");
        util.waitAndClick(pmxAdmin.filterButtonAdmin);
    }

    @Then("I click on Configuration Settings icon")
    public void iClickOnConfigurationSettingsIcon() throws InterruptedException {
        Thread.sleep(500);
        try {
            util.waitAndClick(pmxAdmin.configurationSettings);
        } catch (org.openqa.selenium.StaleElementReferenceException ex) {
            util.waitAndClick(pmxAdmin.configurationSettings);
        }
//        util.waitAndClick(pmxAdmin.configurationSettings);
        Assert.assertEquals(pmxAdmin.kycUploadTitle.getText(), "KYC Uploaded Documents");
    }


    @And("I click on Approve Pan button and verify message")
    public void iClickOnApprovePanButtonAndVerifyMessage() throws InterruptedException {
        Thread.sleep(3000);
        try {
            util.waitAndClick(pmxAdmin.approvePanReason);
            driver.switchTo().alert().accept();
        } catch (org.openqa.selenium.StaleElementReferenceException ex) {
            util.waitAndClick(pmxAdmin.approvePanReason);
            driver.switchTo().alert().accept();
        }
        pmxAdmin.docVerificationReason.sendKeys("test");
        util.waitAndClick(pmxAdmin.saveReason);
 /*       util.waitUntilWebElelemntShouldBeDisplay(driver,pmxAdmin.getStatusPan,30);
        Thread.sleep(5000);
        util.waitAndClick(pmxAdmin.approvePanReason);
        driver.switchTo().alert().accept();
        pmxAdmin.docVerificationReason.sendKeys("test");
        util.waitAndClick(pmxAdmin.saveReason);*/
    }

        @And("I click on Approve Business document and verify message")
        public void iClickOnApproveBusinessDocumentAndVerifyMessage () {
            util.waitAndClick(pmxAdmin.approveBusinessDocument);
        }

        @And("I click on Approve Address document and verify message")
        public void iClickOnApproveAddressDocumentAndVerifyMessage () {
            util.waitAndClick(pmxAdmin.approveBusinessDocument);
        }
    }
