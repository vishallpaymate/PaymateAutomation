package step_definitions;

import baseClass.Utils;
import baseClass.mainDriver;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pageFactory.Login_POM;
import pageFactory.changePasswoird_POM;

import java.util.List;

public class ChangePassword extends mainDriver {
    public changePasswoird_POM cp = new changePasswoird_POM(driver);
    public Utils u = new Utils();
    Login_POM login = new Login_POM(driver);

    @When("^I click on profile icon$")
    public void iClickOnProfileIcon() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        u.click(cp.getProfileIcon, driver);
        // cp.getProfileIcon.click();
        Thread.sleep(3000L);
    }

    @And("^I click on change password field$")
    public void iClickOnChangePasswordField() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        u.click(cp.getChangePasswordLink, driver);
        // cp.getChangePasswordLink.click();
        u.impliciteWait();

    }

    @Then("^I should land on change password page$")
    public void iShouldLandOnChangePasswordPage() throws Throwable {
       u.log4j("I verify that i am on the change password page");
        String cpTitle = cp.getChangePsswordTitle.getText();
        System.out.println("\n Change Password Page Title Text: " + cpTitle);
        Assert.assertEquals(cpTitle, "CHANGE PASSWORD");
    }

    @And("^I see current password filed with label$")
    public void iSeeCurrentPasswordFiledWithLabel() throws Throwable {
        u.log4j("I verify that there is a label with text current password");
        /*boolean cpFieldDisplay = cp.getCurrentPassword.isDisplayed();
        Assert.assertEquals(cpFieldDisplay,true);*/
        boolean cpFieldEnable = cp.getCurrentPassword.isEnabled();
        Assert.assertEquals(cpFieldEnable, true);
        //Label
        String labelText = cp.getChangePasswordLabel.getText();
        System.out.println("\n Current Password Label Text: " + labelText);
        Assert.assertEquals(labelText, "Current Password");
    }

    @And("^I see new password field with label$")
    public void iSeeNewPasswordFieldWithLabel() throws Throwable {
        u.log4j("I verify that there is a label with text new password");
        boolean npDisplay = cp.getNewPasswordField.isDisplayed();
        Assert.assertEquals(npDisplay, true);
        boolean npEnable = cp.getNewPasswordField.isEnabled();
        Assert.assertEquals(npEnable, true);
        //Label
        String npLabel = cp.getNewPasswordLabel.getText();
        System.out.println("\n New Password Label Text: " + npLabel);
        Assert.assertEquals(npLabel, "New Password");
    }

    @And("^I see confirm password field with label$")
    public void iSeeConfirmPasswordFieldWithLabel() throws Throwable {
        u.log4j("I verify that there is a label with text confirm password");
        boolean confirmDisplay = cp.getConfirmPasswordField.isDisplayed();
        Assert.assertEquals(confirmDisplay, true);
        boolean confirmEnable = cp.getConfirmPasswordField.isEnabled();
        Assert.assertEquals(confirmEnable, true);
    }

    @And("^I see save and cancel button$")
    public void iSeeSaveAndCancelButton() throws Throwable {
        u.log4j("I verify save and cancel buttons are present");
        boolean saveButtonDisplay = cp.getSaveButton.isDisplayed();
        System.out.println("---------save Button---------: " + saveButtonDisplay);
        Assert.assertEquals(saveButtonDisplay, true);
        boolean saveButtonEnable = cp.getSaveButton.isEnabled();
        System.out.println("---------save Button---------: " + saveButtonEnable);
        Assert.assertEquals(saveButtonEnable, true);
        //Cancel Button
        boolean cancelButtonDisplay = cp.getCancelButton.isDisplayed();
        System.out.println("---------Cancel Button---------: " + cancelButtonDisplay);
        Assert.assertEquals(cancelButtonDisplay, true);
        boolean cancelButtonEnable = cp.getCancelButton.isDisplayed();
        System.out.println("---------Cancel Button---------: " + cancelButtonEnable);
        Assert.assertEquals(cancelButtonEnable, true);
    }

    @And("^I see password guidance text as \"([^\"]*)\"$")
    public void iSeePasswordGuidanceTextAs(String arg0) throws Throwable {
        u.log4j("I verify that there is a label with password guidance");
        String text = cp.getPasswordGuidanceText.getText();
        System.out.println("Password guidance text: " + text);
        Assert.assertEquals(text, arg0);
    }

    @When("^I click on change password link \"([^\"]*)\"$")
    public void iClickOnChangePasswordLink(String arg0) throws Throwable {
        if (arg0.equals("DashBoard profile")) {
            u.log4j("I click on change password link from Dashboard profile");
            u.click(cp.getProfileIcon, driver);
            u.click(cp.getChangePasswordLink, driver);

            //cp.getChangePasswordLink.click();
            u.impliciteWait();

        } else if (arg0.equals("Profile settings")) {
            u.clickDashboardMenu();
            u.log4j("I click on change password link from Profile settings");
            u.sideBarScrollDown(cp.getProfileSettings);
            u.webdriverWait(30, By.xpath("//a[contains(text(),'Profile Settings')]"));
            u.click(cp.getProfileSettings, driver);
            //cp.getProfileSettings.click();
            u.mouseMove(cp.getChnagePassword);
            u.sideBarScrollDown(cp.getChnagePassword);
            u.click(cp.getChnagePassword, driver);
            //cp.getChnagePassword.click();

        }
    }

    @And("^I click on buttons\"([^\"]*)\"$")
    public void iClickOnButtons(String arg0) throws Throwable {
        if (arg0.equals("Save")) {
            u.log4j("I click on save button");
            u.click(cp.getSaveButton, driver);
            List<WebElement> list = cp.getErrorMessage;
            int totalerrorMsg = list.size();
            System.out.println("Total is: " + totalerrorMsg);
            for (int i = 0; i < totalerrorMsg; i++) {
                String errorMsg = cp.getErrorMessage.get(i).getText();
                System.out.println("Error message are " + errorMsg);
                String color = cp.getErrorMessage.get(i).getCssValue("color");
                System.out.println("Error message is in" + color);
                if (errorMsg.equals("Please enter your current password.")) {
                    u.log4j("I verify message Please enter your current password in red color");
                    Assert.assertEquals(errorMsg, "Please enter your current password.");
                    System.out.println("Error message matched");
                    if (color.equals("rgba(213, 0, 0, 1)")) {
                        Assert.assertEquals(color, "rgba(213, 0, 0, 1)");
                        System.out.println("Color is matched");
                    } else {
                        Assert.assertEquals(color, "rgb(213, 0, 0)");
                        System.out.println("Color is matched");
                    }
                } else if (errorMsg.equals("Please enter new password.")) {
                    u.log4j("I verify message Please enter new password in red color");
                    Assert.assertEquals(errorMsg, "Please enter new password.");
                    System.out.println("Error message matched");
                    if (color.equals("rgba(213, 0, 0, 1)")) {
                        Assert.assertEquals(color, "rgba(213, 0, 0, 1)");
                        System.out.println("Color is matched");
                    } else {
                        Assert.assertEquals(color, "rgb(213, 0, 0)");
                        System.out.println("Color is matched");
                    }
                } else if (errorMsg.equals("Please enter confirm password.")) {
                    u.log4j("I verify message Please enter confirm new password in red color");
                    Assert.assertEquals(errorMsg, "Please enter confirm password.");
                    System.out.println("Error message matched");
                    if (color.equals("rgba(213, 0, 0, 1)")) {
                        Assert.assertEquals(color, "rgba(213, 0, 0, 1)");
                        System.out.println("Color is matched");
                    } else {
                        Assert.assertEquals(color, "rgb(213, 0, 0)");
                        System.out.println("Color is matched");
                    }
                }
            }
        } else if (arg0.equals("Cancel")) {
            u.log4j("I click on cancel button");
            u.click(cp.getCancelButton, driver);

            String txt = driver.findElement(By.xpath("//h1[contains(text(),'Welcome to PayMate')]")).getText();

            Assert.assertEquals(txt, "WELCOME TO PAYMATE");
            u.log4j("I verify that user lands on the dashboard page");
        }

    }

    @And("^I enter valid current password \"([^\"]*)\"$")
    public void iEnterValidCurrentPassword(String arg0) throws Throwable {
        u.log4j("I enter a valid current password as:"+arg0);
        cp.getGetCurrentPassword.sendKeys(arg0);
    }

    @And("^I enter valid new password as \"([^\"]*)\"$")
    public void iEnterValidNewPasswordAs(String arg0) throws Throwable {
        u.log4j("I enter a new valid password as:"+arg0);
        cp.getNewPassword.sendKeys(arg0);
    }


    @And("^I enter valid confirm password as \"([^\"]*)\"$")
    public void iEnterValidConfirmPasswordAs(String arg0) throws Throwable {
        u.log4j("I enter a valid password in confirm password field as:"+arg0);
        cp.getConfirmPassword.sendKeys(arg0);
    }

    @Then("^I should see Proper validation message \"([^\"]*)\" in green color$")
    public void iShouldSeeProperValidationMessageInGreenColor(String arg0) throws Throwable {
        u.setWebDriverFluentWait(2, 40, By.xpath("//*[@id='form1']/div[3]/div"));
        String txt = driver.findElement(By.xpath("//*[@id='form1']/div[3]/div")).getText();
        System.out.println("validation message is: " + txt);
        u.log4j("I verify password updated message is coming and is green in color");
        Assert.assertEquals(txt, "You have updated your password successfully");
        String clr = driver.findElement(By.xpath("//*[@id='form1']/div[3]/div")).getCssValue("color");
        if (clr.equals("rgba(255, 255, 255, 1)")) {

            Assert.assertEquals(clr, "rgba(255, 255, 255, 1)");
        } else {
            Assert.assertEquals(clr, "rgb(255, 255, 255)");
        }
    }

    @And("^I enter last five password and i should see proper validation msg in red color$")
    public void iEnterLastFivePasswordAndIShouldSeeProperValidationMsgInRedColor(DataTable table) throws InterruptedException {
        List<List<String>> list = table.cells();
        System.out.println("Total cells are: " + list.size());
        for (int i = 0; i < list.size(); i++) {
            WebElement ele = cp.getCurrentPassword;
            String data = ele.getAttribute("value");
            System.out.println("Data in current password: " + data);
            if (data.isEmpty()) {
                cp.getCurrentPassword.sendKeys("Paymate@1");
            }
            String values = list.get(i).get(0);
            System.out.println("Data Table values are: " + values);
            cp.getNewPassword.sendKeys(values);
            Thread.sleep(3000L);
            cp.getConfirmPassword.sendKeys(values);
            Thread.sleep(3000L);
            cp.getSaveButton.click();
            Thread.sleep(3000L);

            String txt = driver.findElement(By.xpath("//div[@class='alert-strip error-alert']")).getText();
            System.out.println("Validation message is: " + txt);
            if (txt.equals("Current password and New password cannot be same.")) {
                u.log4j("I verify message Current password and New password cannot be same.");
                Assert.assertTrue(txt.equals("Current password and New password cannot be same."), "Validation msg is not matched");

            } else if (txt.equals("Your new password cannot be the same as your previous 5 password(s).")) {
                u.log4j("I verify messageYour new password cannot be the same as your previous 5 password(s).");
                Assert.assertEquals(txt, "Your new password cannot be the same as your previous 5 password(s).", "Validation msg is not matched");
            }
        }

    }

    @And("^I enter valid passwords \"([^\"]*)\"$")
    public void iEnterValidPasswords(String arg0) throws InterruptedException {
        u.log4j("I enter a valid password as"+arg0);
        cp.getCurrentPassword.sendKeys(arg0);
        cp.getNewPassword.sendKeys(arg0);
        cp.getConfirmPassword.sendKeys(arg0);
        u.click(cp.getSaveButton, driver);
        //cp.getSaveButton.click();
        Thread.sleep(3000L);
    }

    @Then("^I should see validation message \"([^\"]*)\" in red color$")
    public void iShouldSeeValidationMessageInRedColor(String arg0) throws Throwable {
        u.log4j("I verify validation message in red color is:"+arg0);
        String txt = cp.getSamePassValidationMsg.getText();
        System.out.println("Validation msg is: " + txt);
        Assert.assertEquals(txt, arg0);

        String clr = cp.getSamePassValidationMsg.getCssValue("color");
        System.out.println("Validation message color is: " + clr);
        if (clr.equals("rgb(213, 0, 0)")) {
            Assert.assertEquals(clr, "rgb(213, 0, 0)");
        } else {
            Assert.assertEquals(clr, "rgba(213, 0, 0, 1)");
        }
    }

    @Then("^I should see proper validation message \"([^\"]*)\" in red color$")
    public void iShouldSeeProperValidationMessageInRedColor(String arg0) throws Throwable {
       u.log4j("I verify that password mismatch error message is coming in red color");
        String txt = cp.getPasswordMissMatchValidationMsg.getText();
        System.out.println("Validation msg when user enter miss match password: " + txt);
        Assert.assertEquals(txt, arg0);
        String clr = cp.getPasswordMissMatchValidationMsg.getCssValue("color");
        System.out.println("Validation message color is: " + clr);
        if (clr.equals("rgb(213, 0, 0)")) {
            Assert.assertEquals(clr, "rgb(213, 0, 0)");
        } else {
            Assert.assertEquals(clr, "rgba(213, 0, 0, 1)");
        }
    }


    @And("^I enter password do not meet password policy then I should see validation msg as \"([^\"]*)\" in red color$")
    public void iEnterPasswordDoNotMeetPasswordPolicyThenIShouldSeeValidationMsgAsInRedColor(String arg0, DataTable table) throws Throwable {
        List<List<String>> list = table.cells();
        int total = list.size();
        for (int i = 0; i < total; i++) {
            String values = list.get(i).get(0);
            System.out.println("Data Table values are: " + values);
            cp.getNewPassword.sendKeys(values);
            Thread.sleep(2000L);
            cp.getConfirmPassword.sendKeys(values);
            WebElement ele = cp.getSamePassValidationMsg;
            String txt = ele.getText();
            u.log4j("I verify password doesnt meet password policy message is coming and is red in color");
            Assert.assertEquals(txt, arg0);
            String clr = cp.getSamePassValidationMsg.getCssValue("color");
            System.out.println("Validation message color is: " + clr);
            if (clr.equals("rgb(213, 0, 0)")) {
                Assert.assertEquals(clr, "rgb(213, 0, 0)");
            } else {
                Assert.assertEquals(clr, "rgba(213, 0, 0, 1)");
            }
            //cp.getSaveButton.click();
            cp.getNewPassword.clear();
            cp.getConfirmPassword.clear();
        }
    }

    @And("^I click on save button$")
    public void iClickOnSaveButton() throws Throwable {
        u.log4j("I click on save button");
        u.click(cp.getSaveButton, driver);
    }
}

