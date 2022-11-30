package step_definitions;

import baseClass.Utils;
import baseClass.mainDriver;
//import cucumber.api.DataTable;
import cucumber.api.java.bs.A;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import com.github.javafaker.Faker;
import io.cucumber.datatable.DataTable;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import pageFactory.*;

import java.util.List;


public class paymentApproval extends mainDriver {
    public Utils utils = new Utils();
    Faker faker = new Faker();
    public SignUp_POM signup = new SignUp_POM(driver);
    public paymentApproval_POM paymentApprovalPom = new paymentApproval_POM(driver);
    public addContact_POM con = new addContact_POM(driver);
    public Login_POM login = new Login_POM(driver);
    public forgotPassword_POM fp = new forgotPassword_POM(driver);
    public Utils u = new Utils();
    public static String emailid;
    public static String firstName;
    public static String lastName;
    public String cpText;
    public String password;
    public String mailpassword;


    @When("I click on Account Settings")
    public void iClickOnAccountSettings() throws InterruptedException {
        Thread.sleep(5000);
        utils.click(con.getDashBoardMenu, driver);
        paymentApprovalPom.getAccountSettings.click();
    }

    @Then("I click on Workflow Settings")
    public void iClickOnWorkflowSettings() {
        paymentApprovalPom.getWorkflowSettings.click();
    }

    @Then("I see following workflow options")
    public void iSeeFollowingWorkflowOptions(DataTable dataTable) throws Throwable {
        List<List<String>> listDataTable = dataTable.cells();
        List<WebElement> listWorkflow = paymentApprovalPom.getWorkflowMenus;
        for (int i = 0; i < listWorkflow.size(); i++) {
            String text = listWorkflow.get(i).getText();
            String dataTableText = listDataTable.get(i + 1).get(0);
            if (text.equals(dataTableText) && text.equals("Payment Limits")) {
                Assert.assertTrue(text.equals(dataTableText), "Paymanet Limits menu not present");
                utils.log4j(dataTableText + "  menu is displayed");
            } else if (text.equals(dataTableText) && text.equals("Payment Workflows")) {
                Assert.assertTrue(text.equals(dataTableText), "Payment Workflows menu not present");
                utils.log4j(dataTableText + "  menu is displayed");
            } else if (text.equals(dataTableText) && text.equals("Payment Approvals")) {
                Assert.assertTrue(text.equals(dataTableText), "Payment Approvals menu not present");
                utils.log4j(dataTableText + "  menu is displayed");
                }
            else if(text.equals(dataTableText) && text.equals("Contact Approvals")){
                Assert.assertTrue(text.equals(dataTableText),"Contact Approvals menu not present");
                utils.log4j(dataTableText + "  menu is displayed");
            }
//            else {
//                Assert.assertTrue(false, "");
//            }
        }
    }

    @Then("I click on Workflow menu {string}")
    public void iClickOnWorkflowMenu(String arg0) throws InterruptedException {
        List<WebElement> listWorkflow = paymentApprovalPom.getWorkflowMenus;
        for (int i = 0; i < listWorkflow.size(); i++) {
            System.out.println(paymentApprovalPom.getWorkflowMenus.get(i).getText());
            String text = listWorkflow.get(i).getAttribute("innerText");
            if (arg0.equals("Payment Limits") && arg0.equals(text)) {
                System.out.println("Text is: " + arg0);
                listWorkflow.get(i).click();
//                utils.click(listWorkflow.get(i), driver);
                Thread.sleep(200L);
                cpText = paymentApprovalPom.paymentLimitsText.getText();
                utils.waitAndClick(paymentApprovalPom.setLimit);
                Assert.assertTrue(paymentApprovalPom.setLimitExpanded.isDisplayed(), "Set Limit is not expanded");
                break;
            } else if (arg0.equals("Payment Workflows") && arg0.equals(text)) {
                System.out.println("Text is: " + arg0);
                listWorkflow.get(i).click();
//                utils.click(listWorkflow.get(i), driver);
                Thread.sleep(200L);
                cpText = paymentApprovalPom.manageWorkflowText.getText();
                System.out.println("Cp text:"+cpText);
//                Assert.assertTrue(paymentApprovalPom.manageLimitExpanded.isDisplayed(), "Manage Limit is not expanded");
            } else if(arg0.equals("Contact Approvals") && arg0.equals(text)){
                System.out.println("Text is: " + arg0);
                listWorkflow.get(i).click();
//                utils.click(listWorkflow.get(i), driver);
                Thread.sleep(200L);
                cpText = paymentApprovalPom.contactApprovalsText.getText();
            }
        }

    }

    @Then("I should be land on particular page for workflow links")
    public void iShouldBeLandOnParticularPageForWorkflowLinks() {
        System.out.println("I am on " + cpText + " page");
    }

    @Then("I verify all fields are present on Set Limit Page")
    public void iVerifyAllFieldsArePresentOnSetLimitPage() throws InterruptedException {
//        utils.waitAndClick(paymentApprovalPom.setLimit);
        Assert.assertEquals(paymentApprovalPom.limitNameLabel.getText(), "Limit Name *");
//        System.out.println("Line 115:"+paymentApprovalPom.startLimitLabel.getText());
        Assert.assertEquals(paymentApprovalPom.startLimitLabel.getText(), "Start Limit *");
//        System.out.println("Line 100:"+paymentApprovalPom.endLimitLabel.getAttribute("innerText"));
        Assert.assertEquals(paymentApprovalPom.endLimitLabel.getAttribute("innerText"), "End Limit *");
        Thread.sleep(200L);
        Assert.assertTrue(paymentApprovalPom.addAnotherButton.isDisplayed());
        Assert.assertTrue(paymentApprovalPom.continueButton.isDisplayed());
        Assert.assertTrue(paymentApprovalPom.cancelButton.isDisplayed());

    }

    @Then("I click on continue button on set limit page")
    public void iClickOnContinueButtonOnSetLimitPage() {
        utils.click(paymentApprovalPom.continueButton, driver);
    }

    @Then("I verify validation messages for all fields")
    public void iVerifyValidationMessagesForAllFields() {
        Assert.assertEquals(paymentApprovalPom.limitNameValidation.getText(), "Please enter valid limit Name");
        Assert.assertEquals(paymentApprovalPom.startLimitValidation.getText(), "Please enter Start Limit.");
        Assert.assertEquals(paymentApprovalPom.endLimitValidation.getText(), "Please enter End Limit.");
    }

    @And("I click on {string} on set limit page")
    public void iClickOnOnSetLimitPage(String arg0) {
        List<WebElement> listButtons = paymentApprovalPom.setLimitButtons;
        for (int i = 0; i < listButtons.size(); i++) {
            System.out.println("Line 126: " + paymentApprovalPom.setLimitButtons.get(i).getAttribute("value"));
            String text = listButtons.get(i).getAttribute("value");
            if (arg0.equals("Add Another") && arg0.equals(text)) {
//                System.out.println("Text is: " + arg0);
                utils.click(listButtons.get(i), driver);
                break;
            } else if (arg0.equals("Continue") && arg0.equals(text)) {
//                System.out.println("Text is: " + arg0);
                utils.click(listButtons.get(i), driver);
            } else if (arg0.equals("Cancel") && arg0.equals(text)) {
//                System.out.println("Text is: " + arg0);
                utils.click(listButtons.get(i), driver);
                Assert.assertTrue(paymentApprovalPom.manageLimitExpanded.isDisplayed(), "Manage Limit is not expanded");
            }

        }
    }

    @Then("I enter inputs in all fields on set limit page")
    public void iEnterInputsInAllFieldsOnSetLimitPage() {
        paymentApprovalPom.limitName.sendKeys("test1");
        paymentApprovalPom.startLimit.sendKeys("100");
        paymentApprovalPom.endLimit.sendKeys("500");
    }

    @Then("I enter start limit less than end limit and check validation messages")
    public void iEnterStartLimitLessThanEndLimitAndCheckValidationMessages() {
        paymentApprovalPom.limitName.sendKeys("test");
        paymentApprovalPom.startLimit.sendKeys("100");
        paymentApprovalPom.endLimit.sendKeys("50");
        paymentApprovalPom.continueButton.click();
        Assert.assertEquals(paymentApprovalPom.startLimitLessText.getText(), "Start limit should be less then end limit.");
        Assert.assertEquals(paymentApprovalPom.endLimitGreaterText.getText(), "End limit should be greater then start limit.");

    }

    @Then("I enter same values in start and end limit fields and check validation message")
    public void iEnterSameValuesInStartAndEndLimitFieldsAndCheckValidationMessage() throws InterruptedException {
        paymentApprovalPom.cancelButton.click();
        Thread.sleep(2000L);
        utils.waitAndClick(paymentApprovalPom.setLimit);
        Assert.assertTrue(paymentApprovalPom.setLimitExpanded.isDisplayed(), "Set Limit is not expanded");
        utils.waitElementShouldBeClickable(paymentApprovalPom.limitName);
        paymentApprovalPom.limitName.sendKeys("test");
        paymentApprovalPom.startLimit.sendKeys("100");
        paymentApprovalPom.endLimit.sendKeys("100");
        paymentApprovalPom.continueButton.click();
//        utils.waitUntilWebElelemntShouldBeDisplay(driver,paymentApprovalPom.sameLimitValMsg,30);
//        Thread.sleep(2000L);
//        System.out.println("Line 175: "+paymentApprovalPom.sameLimitValMsg.getText());
        Assert.assertEquals(paymentApprovalPom.sameLimitValMsg.getText(), "Start limit and end limit cannot be same.");

    }

    @And("I verify limit saved validation message")
    public void iVerifyLimitSavedValidationMessage() {
        System.out.println("Line 184: " + paymentApprovalPom.limitSavedValMsg.getText());
        Assert.assertEquals(paymentApprovalPom.limitSavedValMsg.getText(), "Limits saved successfully.");
    }

    @And("I verify all column names for Manage Limit")
    public void iVerifyAllColumnNamesForManageLimit(DataTable table) {
        List<List<String>> columnText = table.cells();
        List<WebElement> columns = driver.findElements(By.xpath("//th[@class='sorting']"));
        for (int i = 0; i < columns.size(); i++) {
            System.out.println("Line 194: " + columns.get(i).getAttribute("innerHTML"));
            System.out.println("Column data:" + columnText.get(i + 1).get(0));
            Assert.assertTrue(columnText.get(i + 1).get(0).equals(columns.get(i).getText()), "Column name is not matched");
        }
    }

    @Then("I verify first row as unlimited limit and default values")
    public void iVerifyFirstRowAsUnlimitedLimitAndDefaultValues(DataTable table) {
        List<List<String>> defaultValues = table.cells();
        List<WebElement> defaultVal = driver.findElements(By.xpath("//td[text()='Unlimited' or text()='0']"));
//        System.out.println(defaultVal.size());
        for (int i = 0; i < defaultVal.size(); i++) {
            System.out.println("Line 205: " + defaultVal.get(i).getAttribute("innerHTML"));
            System.out.println("Values data :" + defaultValues.get(i + 1).get(0));
            Assert.assertTrue(defaultValues.get(i + 1).get(0).equals(defaultVal.get(i).getText()), "Value not matched");
        }
    }

    @Then("I verify limit range already defined message")
    public void iVerifyLimitRangeAlreadyDefinedMessage() {
        System.out.println("Line 214: " + paymentApprovalPom.limitAlreadyValMsg.getText());
        Assert.assertEquals(paymentApprovalPom.limitAlreadyValMsg.getText(), "Limit within start limit and end limit range already defined.");
    }

    @Then("I verify limit name already defined message")
    public void iVerifyLimitNameAlreadyDefinedMessage() {
        System.out.println("Line 220: " + paymentApprovalPom.limitNameAlreadyMsg.getAttribute("innerHTML"));
        Assert.assertEquals(paymentApprovalPom.limitNameAlreadyMsg.getText(), "Limit name already defined.");
    }

    @Then("I verify limit added in manage limit section")
    public void iVerifyLimitAddedInManageLimitSection(DataTable table) {
        List<List<String>> addedLimit = table.cells();
        List<WebElement> defaultVal = driver.findElements(By.xpath("//td[text()='test1' or text()='500.00' or text()='100.00']"));
//        System.out.println(defaultVal.size());
        for (int i = 0; i < defaultVal.size(); i++) {
            System.out.println("Line 224: " + defaultVal.get(i).getAttribute("innerHTML"));
            System.out.println("Values data :" + addedLimit.get(i + 1).get(0));
            Assert.assertTrue(addedLimit.get(i + 1).get(0).equals(defaultVal.get(i).getAttribute("innerHTML")), "Value not matched");
        }
        Assert.assertTrue(paymentApprovalPom.editLimitButton.isDisplayed());
    }


    @And("I check Design Workflow button is present")
    public void iCheckDesignWorkflowButtonIsPresent() {
        Assert.assertEquals(paymentApprovalPom.designWorkflowText.getText(), "DESIGN NEW WORKFLOW");
        Assert.assertTrue(paymentApprovalPom.designWorkflowButton.isDisplayed());
        paymentApprovalPom.designWorkflowButton.click();

    }

    @Then("I verify select payment limit dropdown is present")
    public void iVerifySelectPaymentLimitDropdownIsPresent() throws InterruptedException {
        Thread.sleep(3000);
//        utils.waitUntilWebElelemntShouldBeDisplay(driver,paymentApprovalPom.selectPaymentLimit,20);
        Assert.assertTrue(paymentApprovalPom.selectPaymentLimitLabel.isDisplayed());
    }

    @And("I click on Design Workflow button")
    public void iClickOnDesignWorkflowButton() {
        utils.waitAndClick(paymentApprovalPom.designWorkflowButton);

    }

    @Then("I verify Add new Limit button is present")
    public void iVerifyAddNewLimitButtonIsPresent() {
        Assert.assertTrue(paymentApprovalPom.addnewLimitButton.isDisplayed());
    }

    @Then("I verify steps for makers approvers and payers is present and disabled")
    public void iVerifyStepsForMakersApproversAndPayersIsPresentAndDisabled(DataTable table) {
        List<List<String>> listDataTable = table.cells();
        List<WebElement> listSteps = paymentApprovalPom.designWorkflowSteps;
        for (int i = 0; i < listSteps.size(); i++) {
            System.out.println(paymentApprovalPom.designWorkflowSteps.get(i).getText());
            String text = listSteps.get(i).getAttribute("innerText");
            String dataTableText = listDataTable.get(i + 1).get(0);
            if (text.equals(dataTableText) && text.equals("Step 1: Select Makers")) {
                Assert.assertEquals(text.equals(dataTableText),"STEP 1: SELECT MAKERS");
                utils.log4j(dataTableText + "  step is displayed");
            }
        }


    }

    @Then("I verify cancel button is present")
    public void iVerifyCancelButtonIsPresent() {
        Assert.assertTrue(paymentApprovalPom.deisgnWorklfowCancelButton.isDisplayed());
    }

    @And("I click on Add new Limit button")
    public void iClickOnAddNewLimitButton() {
        utils.waitAndClick(paymentApprovalPom.addnewLimitButton);
    }

    @Then("I verify i am on set limit page")
    public void iVerifyIAmOnSetLimitPage() throws InterruptedException {
        Thread.sleep(500);
        Assert.assertEquals(paymentApprovalPom.paymentLimitsText.getText(),"Payment Limits");
        Assert.assertTrue(paymentApprovalPom.setLimitExpanded.isDisplayed(), "Set Limit is not expanded");
    }

    @And("I select a payment limit from dropdown")
    public void iSelectAPaymentLimitFromDropdown() {
        utils.waitAndClick(paymentApprovalPom.paymentLimitDownArrow);
        utils.waitAndClick(paymentApprovalPom.selectPaymentLimit);
    }

    @And("I verify a user is present in the Select Makers dropdown box")
    public void iVerifyAUserIsPresentInTheSelectMakersDropdownBox() {
        Assert.assertTrue(paymentApprovalPom.selectMaker.isDisplayed());
    }

    @And("I verify No Maker needed checkbox and Next button are present")
    public void iVerifyNoMakerNeededCheckboxAndNextButtonArePresent() {
        Assert.assertTrue(paymentApprovalPom.makerTab.isDisplayed());
        Assert.assertTrue(paymentApprovalPom.noMakerNeededLabel.isDisplayed());
        Assert.assertTrue(paymentApprovalPom.nextButtonMaker.isDisplayed());

    }

    @And("I click on next button for maker")
    public void iClickOnNextButtonForMaker() {
        utils.waitAndClick(paymentApprovalPom.nextButtonMaker);
    }

    @And("I select approvers from select approver dropdown box and enter minimum approvers")
    public void iSelectApproversFromSelectApproverDropdownBoxAndEnterMinimumApprovers() {
        Assert.assertTrue(paymentApprovalPom.approverTab.isDisplayed());
        Select approver = new Select(paymentApprovalPom.selectApprover);
        approver.selectByIndex(0);
        Assert.assertTrue(paymentApprovalPom.minimumApprover.isDisplayed());
        paymentApprovalPom.minimumApprover.sendKeys("1");
    }

    @And("I verify Add level and Back buttons are present")
    public void iVerifyAddLevelAndBackButtonsArePresent() {
        Assert.assertTrue(paymentApprovalPom.addLevelButton.isDisplayed());
        Assert.assertTrue(paymentApprovalPom.backButton.isDisplayed());
    }


    @And("I click on Add level button and verify message")
    public void iClickOnAddLevelButtonAndVerifyMessage() {
        utils.waitAndClick(paymentApprovalPom.addLevelButton);
        Assert.assertEquals(paymentApprovalPom.levelAddedSuccessfulymsg.getText(),"Level Added Successfully.");

    }


    @And("I click next button for Approver")
    public void iClickNextButtonForApprover() {
        utils.waitAndClick(paymentApprovalPom.nextButtonApprover);
    }

    @And("I verify edit and delete actions button are present in approver tab")
    public void iVerifyEditAndDeleteActionsButtonArePresentInApproverTab() {
        Assert.assertTrue(paymentApprovalPom.editButtonApprover.isDisplayed());
        Assert.assertTrue(paymentApprovalPom.deleteButtonApprover.isDisplayed());
    }

    @And("I verify a user is present in the Select Payers dropdown box")
    public void iVerifyAUserIsPresentInTheSelectPayersDropdownBox() {
        Assert.assertTrue(paymentApprovalPom.payerTab.isDisplayed());
        Assert.assertTrue(paymentApprovalPom.selectPayer.isDisplayed());
    }

    @And("I verify No payer Needed checkbox and Cancel button are present in payers tab")
    public void iVerifyNoPayerNeededCheckboxAndCancelButtonArePresentInPayersTab() {
        Assert.assertTrue(paymentApprovalPom.noPayerNeededLabel.isDisplayed());
        Assert.assertTrue(paymentApprovalPom.payerCancelButton.isDisplayed());
    }

    @And("I verify Save Workflow and Cancel buttons are present")
    public void iVerifySaveWorkflowAndCancelButtonsArePresent() {
        Assert.assertTrue(paymentApprovalPom.saveWorkflowButton.isDisplayed());
        Assert.assertTrue(paymentApprovalPom.cancelWorkflowButton.isDisplayed());
    }

    @Then("I click on Save Workflow button and verify message")
    public void iClickOnSaveWorkflowButtonAndVerifyMessage() {
        utils.waitAndClick(paymentApprovalPom.saveWorkflowButton);
        Assert.assertEquals(paymentApprovalPom.workflowAddedSuccessfulymsg.getAttribute("innerHTML"),"Workflow saved successfully.");
    }


    @And("I remove the Maker user and click Next to verify validation message")
    public void iRemoveTheMakerUserAndClickNextToVerifyValidationMessage() {
        utils.waitAndClick(paymentApprovalPom.removeMaker);
        utils.waitAndClick(paymentApprovalPom.nextButtonMaker);
        Assert.assertEquals(paymentApprovalPom.makerValMsg.getAttribute("innerHTML"),"Please select makers to create workflow");
        utils.waitAndClick(paymentApprovalPom.noMakerNeededLabel);
//        utils.waitElementShouldBeClickable(paymentApprovalPom.enterMaker);
        utils.click(paymentApprovalPom.enterMaker,driver);
        paymentApprovalPom.enterMaker.sendKeys(Keys.ENTER);
        utils.waitAndClick(paymentApprovalPom.nextButtonMaker);

    }

    @And("I click on Add level with no approver and validate message")
    public void iClickOnAddLevelWithNoApproverAndValidateMessage() {
        Assert.assertTrue(paymentApprovalPom.approverTab.isDisplayed());
        utils.waitAndClick(paymentApprovalPom.addLevelButton);
        Assert.assertEquals(paymentApprovalPom.approverValMsg.getAttribute("innerHTML"),"Please add approver(s) level(s).");
    }

    @And("I click Add level with minimum approver as blank and validate message")
    public void iClickAddLevelWithMinimumApproverAsBlankAndValidateMessage() {
        utils.waitAndClick(paymentApprovalPom.enterApprover);
        paymentApprovalPom.enterApprover.sendKeys(Keys.ENTER);
        utils.waitAndClick(paymentApprovalPom.addLevelButton);
        Assert.assertEquals(paymentApprovalPom.minimumApproverValMsg.getAttribute("innerHTML"),"Please enter minimum approver.");
        paymentApprovalPom.minimumApprover.sendKeys("1");
        utils.waitAndClick(paymentApprovalPom.addLevelButton);
//        Assert.assertEquals(paymentApprovalPom.levelAddedSuccessfulymsg.getAttribute("innerHTML"),"Level Added Successfully.");
        utils.waitAndClick(paymentApprovalPom.nextButtonApprover);

    }

    @Then("I click on save workflow with no payer and validate message")
    public void iClickOnSaveWorkflowWithNoPayerAndValidateMessage() throws InterruptedException {
        Assert.assertTrue(paymentApprovalPom.payerTab.isDisplayed());
        Thread.sleep(2000);
//        utils.waitAndClick(paymentApprovalPom.removePayer);
        paymentApprovalPom.removePayer.click();
        utils.waitAndClick(paymentApprovalPom.saveWorkflowButton);
        Assert.assertEquals(paymentApprovalPom.addPayerValmsg.getAttribute("innerHTML"),"Please add payer to create workflow.");
    }

    @And("I click on User Settings")
    public void iClickOnUserSettings() {
        paymentApprovalPom.getUserSettings.click();
    }

    @Then("I see following user settings links")
    public void iSeeFollowingUserSettingsLinks(DataTable dataTable) {
        List<List<String>> listDataTable = dataTable.cells();
        List<WebElement> listWorkflow = paymentApprovalPom.getUserSettingsMenus;
        for (int i = 0; i < listWorkflow.size(); i++) {
            String text = listWorkflow.get(i).getText();
            String dataTableText = listDataTable.get(i + 1).get(0);
            if (text.equals(dataTableText) && text.equals("Add User")) {
                Assert.assertTrue(text.equals(dataTableText), "Add user menu not present");
                utils.log4j(dataTableText + "  menu is displayed");
            } else if (text.equals(dataTableText) && text.equals("Manage Users")) {
                Assert.assertTrue(text.equals(dataTableText), "Manage Users menu not present");
                utils.log4j(dataTableText + "  menu is displayed");
            } else if (text.equals(dataTableText) && text.equals("Mobile User Configuration")) {
                Assert.assertTrue(text.equals(dataTableText), "Mobile User Configuration menu not present");
                utils.log4j(dataTableText + "  menu is displayed");
            }
        }
    }

    @And("And I enter {string} and {string} and {string} and {string}")
    public void andIEnterAndAndAnd(String arg0, String arg1, String arg2, String arg3) {
        u.impliciteWait();
        firstName = u.fakerData("firstName",arg0);
       paymentApprovalPom.firstNameAddUser.sendKeys(arg0);
        lastName = u.fakerData("lastName",arg1);
       paymentApprovalPom.lastNameAdduser.sendKeys(arg1);
        emailid = (u.fakerData("email",arg2));
        u.log4j("Email is "+emailid);
       paymentApprovalPom.emailAddUser.sendKeys(emailid);
       paymentApprovalPom.roleSelectAddUser.click();
        List<WebElement> value = paymentApprovalPom.selectUserRole;
        int totalvalues = value.size();
        for (int i = 0; i < totalvalues; i++) {
            String valuesAre = value.get(i).getText();
            System.out.println("\n Role types are: " + valuesAre);
            if (valuesAre.equals(arg3)) {
                value.get(i).click();
                break;
            }

        }
    }

    @And("I click on Add User and navigate to Add user page")
    public void iClickOnAddUserAndNavigateToAddUserPage() {
        paymentApprovalPom.addUser.click();
    }

    @And("I click on Save button on Add user page")
    public void iClickOnSaveButtonOnAddUserPage() {
        paymentApprovalPom.saveButtonAddUser.click();

    }

    @And("I validate user saved message")
    public void iValidateUserSavedMessage() {
        u.waitUntilWebElelemntShouldBeDisplay(driver,paymentApprovalPom.userSavedValMsg,30);
        Assert.assertEquals(paymentApprovalPom.userSavedValMsg.getText(),"Success! User saved successfully");
    }

    @And("I should get mail for add user {string} i should see login link")
    public void iShouldGetMailForAddUserIShouldSeeLoginLink(String arg0) throws InterruptedException {
        u.getMail(emailid);
//        u.getEmailBody();
 /*       password = driver.findElement(By.xpath("/html/body/table/tbody/tr[2]/td//tr/td/b")).getText();
        mailpassword = password.substring(password.lastIndexOf(":") + 2);
        System.out.println("UPAss: "+mailpassword);*/
        u.waitAndClick(paymentApprovalPom.setPasswordButton);
        u.switchToTab();
       /* int linkCount = u.links.size();
        System.out.println("After registration links are: " +linkCount);
        for (int i = 0; i < linkCount; i++) {
            String linksText = u.links.get(i).getAttribute("innerHTML");
            System.out.println("Links text are: " + linksText);
            try {
                linksText.equalsIgnoreCase("Login");
                System.out.println("I clicked on: " + u.links.get(i).getAttribute("innerHTML"));
                u.links.get(i).click();
                break;
            } catch (NoSuchElementException e) {
                e.printStackTrace();
            }
        }*/
    }

    @And("I enter valid user name for adduser as {string}")
    public void iEnterValidUserNameForAdduserAs(String arg0) {
        u.log4j("I enter valid username as: "+emailid);
        login.UserName.sendKeys(emailid);
    }

    @And("I enter valid password from email")
    public void iEnterValidPasswordFromEmail() {
        u.log4j("I enter valid username as: "+mailpassword);
        login.password.sendKeys(mailpassword);
    }

    @And("I enter current and new password and click save")
    public void iEnterCurrentAndNewPasswordAndClickSave() {
        signup.currentPassword.sendKeys(mailpassword);
        fp.NewPassword.sendKeys("Paymate@123");
        fp.ConfirmPassword.sendKeys("Paymate@123");
        fp.SaveButton.click();
    }

    @Then("I verify all fields and text in Makers section")
    public void iVerifyAllFieldsAndTextInMakersSection() {
        Assert.assertEquals(paymentApprovalPom.designWorkflowHeading.getText(),"Design Workflow");
        Assert.assertEquals(paymentApprovalPom.contactApprovalText.getText(),"Select Makers & Approvers to create a Contact Addition Approval Workflow");
        Assert.assertEquals(paymentApprovalPom.makerHeading.getText(),"Makers");
        Assert.assertEquals(paymentApprovalPom.makerText.getText(),"Select makers who can add or edit contact.");
        Assert.assertEquals(paymentApprovalPom.noMakerText.getText(),"No Maker Needed (Select this option if you are integrated with PayMate for Contact management)");
        Assert.assertTrue(paymentApprovalPom.makerDropdown.isDisplayed());

    }

    @Then("I verify all fields and text in Approver section")
    public void iVerifyAllFieldsAndTextInApproverSection() {
        Assert.assertEquals(paymentApprovalPom.approverHeading.getText(),"Approvers");
        Assert.assertEquals(paymentApprovalPom.approverText.getText(),"Select Approvers who will approve Contact when it is added or updated");
        Assert.assertTrue(paymentApprovalPom.minimumApproverContactWorklfow.isDisplayed());
        Assert.assertTrue(paymentApprovalPom.approverDropdown.isDisplayed());
    }

    @And("I verify Save Workflow and Clear buttons are present")
    public void iVerifySaveWorkflowAndClearButtonsArePresent() {
        Assert.assertTrue(paymentApprovalPom.saveWorkflowContactApproval.isDisplayed());
        Assert.assertTrue(paymentApprovalPom.clearButtonContactApproval.isDisplayed());
    }


    @And("I remove Maker user and click Save Workflow and validate message")
    public void iRemoveMakerUserAndClickSaveWorkflowAndValidateMessage() {
        utils.waitAndClick(paymentApprovalPom.removeMakerContactApproval);
        utils.waitAndClick(paymentApprovalPom.removeMakerContactApproval);
        utils.waitAndClick(paymentApprovalPom.saveWorkflowContactApproval);
        utils.waitUntilWebElelemntShouldBeDisplay(driver,paymentApprovalPom.addMakerValmsgContactApprovaL,30);
        Assert.assertEquals(paymentApprovalPom.addMakerValmsgContactApprovaL.getText(),"Please add maker to create workflow.");
        utils.waitAndClick(paymentApprovalPom.noMakerText);
        utils.waitAndClick(paymentApprovalPom.enterMakerContactApproval);
        paymentApprovalPom.enterMakerContactApproval.sendKeys(Keys.ENTER);
    }

    @And("I click Save Workflow with empty approver and validate message")
    public void iClickSaveWorkflowWithEmptyApproverAndValidateMessage() {
        utils.waitAndClick(paymentApprovalPom.saveWorkflowContactApproval);
        utils.waitUntilWebElelemntShouldBeDisplay(driver,paymentApprovalPom.addApproverValmsgContactApprovaL,30);
        Assert.assertEquals(paymentApprovalPom.addApproverValmsgContactApprovaL.getText(),"Please add approver to create workflow.");
    }

    @And("I enter approvers from select approvers dropdown box")
    public void iEnterApproversFromSelectApproversDropdownBox() {
        utils.waitAndClick(paymentApprovalPom.enterApproverContactApproval);
        paymentApprovalPom.enterApproverContactApproval.sendKeys(Keys.ENTER);
        paymentApprovalPom.minimumApproverContactWorklfow.sendKeys("1");
    }

    @Then("I click Save workflow button and validate message")
    public void iClickSaveWorkflowButtonAndValidateMessage() {
        utils.waitAndClick(paymentApprovalPom.saveWorkflowContactApproval);
        utils.waitUntilWebElelemntShouldBeDisplay(driver,paymentApprovalPom.workflowSavedValMsgContactApproval,30);
        Assert.assertEquals(paymentApprovalPom.workflowSavedValMsgContactApproval.getText(),"Workflow saved successfully.");
    }

    @Then("I navigate to Contact Approval Workflow page")
    public void iNavigateToContactApprovalWorkflowPage() throws InterruptedException {
        utils.waitUntilWebElelemntShouldBeDisplay(driver,paymentApprovalPom.editWorkflowContactApproval,30);
        paymentApprovalPom.editWorkflowContactApproval.isDisplayed();
        paymentApprovalPom.deleteWorkflowContactApproval.isDisplayed();
        Assert.assertEquals(con.getPageTitle.getText(),"Contact Approval Workflow");
    }


    @And("I click on Set Password button")
    public void iClickOnSetPasswordButton() {
    }

    @And("I validate {string} added message")
    public void iValidateAddedMessage(String arg0) {
        u.waitUntilWebElelemntShouldBeDisplay(driver,paymentApprovalPom.userSavedValMsg,30);
        System.out.println("Msg is: "+paymentApprovalPom.userSavedValMsg.getText());
        if(paymentApprovalPom.userSavedValMsg.getText().contains("Transaction Maker")){
            Assert.assertEquals(paymentApprovalPom.userSavedValMsg.getText(),"Transaction Maker added. The user will receive an email to set up their account.");
        } else if(paymentApprovalPom.userSavedValMsg.getText().contains("Transaction Approver")) {
            Assert.assertEquals(paymentApprovalPom.userSavedValMsg.getText(),"Transaction Approver added. The user will receive an email to set up their account.");
        } else if(paymentApprovalPom.userSavedValMsg.getText().contains("Payer")) {
            Assert.assertEquals(paymentApprovalPom.userSavedValMsg.getText(),"Payer added. The user will receive an email to set up their account.");
        } else if(paymentApprovalPom.userSavedValMsg.getText().contains("MIS User")) {
            Assert.assertEquals(paymentApprovalPom.userSavedValMsg.getText(),"MIS User added. The user will receive an email to set up their account.");
        }
    }

    @And("And I enter {string} and {string} and {string} and {string} for single user multiple business")
    public void andIEnterAndAndAndForSingleUserMultipleBusiness(String arg0, String arg1, String arg2, String arg3) {
        u.impliciteWait();
        paymentApprovalPom.firstNameAddUser.sendKeys("Makeruser");
        paymentApprovalPom.lastNameAdduser.sendKeys("test");
        paymentApprovalPom.emailAddUser.sendKeys("makeruser@mailinator.com");
        paymentApprovalPom.roleSelectAddUser.click();
        List<WebElement> value = paymentApprovalPom.selectUserRole;
        int totalvalues = value.size();
        for (int i = 0; i < totalvalues; i++) {
            String valuesAre = value.get(i).getText();
            System.out.println("\n Role types are: " + valuesAre);
            if (valuesAre.equals("Approver")) {
                value.get(i).click();
                break;
            }

        }

    }

    @And("I click on Edit workflow")
    public void iClickOnEditWorkflow() {
        utils.waitAndClick(paymentApprovalPom.editWorkflowContactApproval);
    }
}