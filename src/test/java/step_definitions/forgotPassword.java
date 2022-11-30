package step_definitions;

import baseClass.Environments;
import baseClass.Utils;
import baseClass.mainDriver;
import org.openqa.selenium.Keys;
import userData.loginData;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import pageFactory.Login_POM;
import pageFactory.forgotPassword_POM;

import static step_definitions.Hooks.driver;

public class forgotPassword extends mainDriver {
    public Utils util = new Utils();
    public Hooks hooks = new Hooks();
    public Login_POM login = new Login_POM(driver);
    public String mailusername;
    public String mailpassword;
    public forgotPassword_POM fp = new forgotPassword_POM(driver);
    public loginData data = new loginData();

    @When("^I am on login page$")
    public void IAmOnLoginPage() {
        // Verify Company Logo
        util.log4j("I verify company logo is present");
        Boolean logoPresent = login.companuLogo.isDisplayed();
        Assert.assertTrue(logoPresent);
        //Verify i Am Login Page
        String onLogin = login.loginpagetext.getText();
        util.log4j("I verify I am on the login page");
        Assert.assertEquals(onLogin, "Login to your account");
    }

    @Then("^I should see forgot password link with clickable Link$")
    public void IShouldSeeForgotPasswordLinkWithClickableLink() {
       util.log4j("I verify forgot Password link is present and clickable");
        boolean linkclickable = fp.forgotPasswordLink.isEnabled();
        boolean linkdisplay = fp.forgotPasswordLink.isDisplayed();
        Assert.assertEquals(linkclickable, true);
        Assert.assertEquals(linkdisplay, true);
        Assert.assertEquals(linkdisplay, true);
    }

    @When("^I click on forgot password link$")
    public void IClickOnForgotPasswordLink() throws InterruptedException {
        util.log4j("Clicking on Forgot Password Link");
        util.waitElementShouldBeClickable(fp.forgotPasswordLink);
        fp.forgotPasswordLink.click();
        try {
            Thread.sleep(3000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    @Then("^I should be land on forgot password page$")
    public void IShouldBeLandOnForgotPasswordPage() throws InterruptedException {
        String fptext = fp.forgotPasswordPageTitle.getText();
        System.out.println("\nForgotPassowrd: " + fptext);
        util.log4j("I verify i am the Forgot Password page");
        Assert.assertEquals(fptext, "Forgot Password");
    }

    @And("^I should see user name field$")
    public void IShouldSeeUserNameField() {
        // Write code here that turns the phrase above into concrete actions
        boolean userNameDisplay = fp.forgotpasswordUserName.isDisplayed();
        Assert.assertEquals(userNameDisplay, true);

    }

    @And("^I should see reset my password button with clickable$")
    public void IShouldSeeResetMyPasswordButtonWithClickable() {
       util.log4j("I verify Reset Password button is present and clickable");
        boolean forgotButtonEnable = fp.ResetMyPasswordButton.isEnabled();
        boolean forgotPasswordButtonDisplay = fp.ResetMyPasswordButton.isDisplayed();
        Assert.assertEquals(forgotButtonEnable, true);
        Assert.assertEquals(forgotPasswordButtonDisplay, true);
    }

    @And("^I should see login link$")
    public void IShouldSeeLoginLink() {
        util.log4j("I verify Login link is present");
        boolean loginlinkdisplay = fp.loginButton.isDisplayed();
        boolean loginlinkEnable = fp.loginButton.isEnabled();
        Assert.assertEquals(loginlinkdisplay, true);
        Assert.assertEquals(loginlinkEnable, true);
    }

    @And("^I click on reset my password without user name$")
    public void IClickOnResetMyPasswordWithoutUserName() throws InterruptedException {
       util.log4j("Clicking on Reset My Password link");
        fp.ResetMyPasswordButton.click();
        Thread.sleep(3000L);

    }

    @Then("^I should see proper validation message in red color$")
    public void IShouldSeeProperValidationMessageInRedColor() {
        util.log4j("I verify that Please enter a valid username message is coming and is red in color");
        Assert.assertEquals(fp.emptyUserNameValidationMessage.getText(), "Please enter a valid username.");
        String forgotPasswordtextcolor = fp.emptyUserNameValidationMessage.getCssValue("color");
        if (hooks.browser.equalsIgnoreCase("chrome")) {
            Assert.assertEquals(forgotPasswordtextcolor.toString(), "rgba(213, 0, 0, 1)");
        } else if (hooks.browser.equalsIgnoreCase("firefox")) {
            Assert.assertEquals(forgotPasswordtextcolor.toString(), "rgb(213, 0, 0)");
        }
    }

    @And("^I should be on same page$")
    public void IShouldBeOnSamePage() {
        util.log4j("I verify i am on Forgot Password Page");
        Assert.assertEquals(fp.forgotPasswordPageTitle.getText(), "Forgot Password");
    }


    @And("^I enter unregister user name$")
    public void IEnterUnregisterUserName() {
        util.log4j("I enter an unregistered username in user name field");
        fp.forgotpasswordUserName.sendKeys("vijaydeshpande@gmail.com");

    }

    @And("^I click on reset my password button$")
    public void IClickOnResetMyPasswordButton() throws InterruptedException {
        util.log4j("Clicking on reset my password button");
        fp.ResetMyPasswordButton.click();
        Thread.sleep(300L);
    }

    @Then("^I should see proper validation message as \"([^\"]*)\" in red color$")
    public void IShouldSeeProperValidationMessageAsInRedColor(String validationMessage) throws Throwable {
        util.setWebDriverFluentWait(1, 30, By.xpath("//*[@id='form1']/div[3]"));
        Assert.assertEquals(fp.UserValidationMessage.getText(), validationMessage);
        util.log4j("I verify proper validation message as :"+validationMessage);
    }

    @And("^I should be on forgot password page$")
    public void IShouldBeOnForgotPasswordPage() {
        util.log4j("I verify i am on Forgot password page");
        Assert.assertEquals(fp.forgotPasswordPageTitle.getText(), "Forgot password");
    }


    @Then("^I should see Proper validation message as \"([^\"]*)\" in green color$")
    public void IShouldSeeProperValidationMessageAsInGreenColor(String validUserName) throws InterruptedException {
        util.setWebDriverFluentWait(2, 40, By.xpath("//*[@id='form1']/div[3]/div"));
        String msg = fp.Successfullymsg.getText();
        Assert.assertEquals(msg, validUserName);
        util.log4j("I verify validation message is in green color as: "+msg);
        String successcolor = fp.Successfullymsg.getCssValue("color");
        if (hooks.browser.equalsIgnoreCase("chrome")) {
            Assert.assertEquals(successcolor, "rgba(255, 255, 255, 1)");
            System.out.println(successcolor);
        } else if (hooks.browser.equalsIgnoreCase("firefox")) {
            Assert.assertEquals(successcolor, "rgb(255, 255, 255)");
        }

    }

    @And("^I should see button text as \"([^\"]*)\"$")
    public void IShouldSeeButtonTextAs(String arg0) {
        String scriptText = (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].getAttribute('value')", fp.ResetMyPasswordButton);
        util.log4j("I verify resend email button has text as: "+scriptText);
        Assert.assertEquals(scriptText, arg0);
    }

    @And("^I should get email on my user id as \"([^\"]*)\"$")
    public void iShouldGetEmailOnMyUserIdAs(String arg0) throws Throwable {
       util.log4j("I verify email address is: "+arg0);
        util.OpenMail(arg0);
        util.getEmailBody();
    }


    @Then("^I should be land on change password page$")
    public void IShouldBeLandOnChangePasswordPage() throws InterruptedException {
        Thread.sleep(5000);
        String chnagePassword = fp.ChangePasswordScreen.getText();
        util.log4j("I verify i am on the change password page with text"+chnagePassword);
        Assert.assertEquals(chnagePassword, "Change Password");
    }

    @When("^I open forgot password mail id as \"([^\"]*)\"$")
    public void  iOpenForgotPasswordMailIdAs(String arg0) throws Throwable {
        util.log4j("I verify open forgot password email is: "+arg0);
        util.openNewTab();
        util.switchToTab();
        try {
            util.OpenMail(arg0);

        } catch (InterruptedException e) {
            e.printStackTrace();

        }
        String otp = driver.findElement(By.xpath("//*[@id='mail']//span")).getText();
        System.out.println("OTP is: "+otp);
        /*String uidAndPAss = driver.findElement(By.xpath("//*[@id='mailmillieu']/div[2]/table/tbody/tr[2]/td/table/tbody/tr/td/p[1]/b")).getText();
        mailpassword = uidAndPAss.substring(uidAndPAss.lastIndexOf(":") + 2);
        System.out.println("UPAss: "+mailpassword);
        mailusername = uidAndPAss.substring(uidAndPAss.indexOf(":") + 1, uidAndPAss.indexOf("Password"));*/
        util.switchToTab();
    }

    @And("^I open up a new tab with this URL$")
    public void iOpenUpANewTabWithThisURL() throws Throwable {
        //util.openNewTab();
        Environments e = new Environments();
        driver.navigate().to(e.driver.getCurrentUrl());
        System.out.println("This is url getting from Env : " + e.driver.getCurrentUrl());
    }

    @And("^I Enter valid mail UserName$")
    public void iEnterValidMailUserName() {
        login.UserName.sendKeys(data.loginUserName);
    }

    @And("^I enter confirm pass and new pass as \"([^\"]*)\"$")
    public void iEnterConfirmPassAndNewPassAs(String arg0) throws Throwable {
        util.log4j("I enter new and confirm passwords as :"+ arg0+ arg0);
        util.toFocousOnElement(driver, fp.CurrentPassword);
        Actions action = new Actions(driver);
        action.moveToElement(fp.CurrentPassword);
        action.click();
        action.sendKeys(mailpassword);
        action.build().perform();

        fp.NewPassword.sendKeys(arg0);
        fp.ConfirmPassword.sendKeys(arg0);
        fp.SaveButton.click();
    }


    @And("^I should see proper validation message as \"([^\"]*)\"$")
    public void IShouldSeeProperValidationMessageAs(String arg0) throws Throwable {
        util.log4j("I verify that validation message is proper for password change");
        util.setWebDriverFluentWait(2, 40, By.xpath("//*[@id='form1']/div[3]/div"));
        String msg = fp.Successfullymsg.getText();
        Assert.assertEquals(msg, arg0);
        String successcolor = fp.Successfullymsg.getCssValue("color");
        if (hooks.browser.equalsIgnoreCase("chrome")) {
            Assert.assertEquals(successcolor, "rgba(255, 255, 255, 1)");
        } else if (hooks.browser.equalsIgnoreCase("firefox")) {
            Assert.assertEquals(successcolor, "rgb(255, 255, 255)");
        }

    }

    @And("^I should be land on login page$")
    public void IShouldBeLandOnLoginPage() throws Throwable {
        Thread.sleep(5000L);
        //util.setWebDriverFluentWait(2, 40, By.xpath("//div[@id='UpnlHome']/div[1] | //*[contains(text(),'Login with')]"));
        String logintext = login.verfiyLoginPage.getText();
        System.out.println("Login page text: "+logintext);
        Assert.assertEquals(logintext, "Login to your account");

    }

    @And("^I enter current password$")
    public void iEnterCurrentPassword() {
        util.log4j("I enter current password as :"+mailpassword);
        util.webdriverWait(30, By.name("ctl00$cphContents$txtParanShabd"));
        fp.CurrentPassword.sendKeys(mailpassword);
    }


    @And("^I click on save$")
    public void iClickOnSave() {
        util.log4j("Clicking on save");
        fp.SaveButton.click();

    }


    @And("^I enter email password$")
    public void iEnterEmailPassword() throws Throwable {
        util.log4j("I enter email password as: "+mailpassword);
        login.password.sendKeys(mailpassword);
        driver.findElement(By.id("cphContents_btnLogin")).click();
        Thread.sleep(3000L);
        System.out.println("\nAfter Click on Login: " + driver.getCurrentUrl());
    }

    @And("^I should be see forgot password label as \"([^\"]*)\"$")
    public void iShouldBeSeeForgotPasswordLabelAs(String arg0) throws Throwable {
        util.log4j("I verify that there is a field on the page with label as:"+arg0 );
        String label = fp.emailAddressLabel.getText();
        Assert.assertEquals(label, arg0);
    }

    @And("^I should see proper label for current password as \"([^\"]*)\",new password as \"([^\"]*)\",confirm password as \"([^\"]*)\"$")
    public void iShouldSeeProperLabelForCurrentPasswordAsNewPasswordAsConfirmPasswordAs(String arg0, String arg1, String arg2) throws Throwable {
        String CpText = fp.CpLabel.getText();
        String npText = fp.NpLabel.getText();
        String confText = fp.confPLabel.getText();
        util.log4j("I verify labels for current, new and confirm password"+CpText + npText + confText);
        Assert.assertEquals(CpText, arg0);
        Assert.assertEquals(npText, arg1);
        Assert.assertEquals(confText, arg2);
    }


    @And("^I enter new password as same last five password \"([^\"]*)\"$")
    public void iEnterNewPasswordAsSameLastFivePassword(String arg0) throws Throwable {
        util.log4j("I enter the new password same as the previous 5 passwords");
        fp.NewPassword.sendKeys(arg0);
        fp.ConfirmPassword.sendKeys(arg0);
    }

    @And("^I enter valid user name \"([^\"]*)\"$")
    public void iEnterValidUserName(String arg0) throws Throwable {
        util.log4j("I enter valid username as: "+arg0);
//        login.UserName.sendKeys(arg0);
        fp.forgotpasswordUserName.sendKeys(arg0);
        fp.emailAddressField.sendKeys(Keys.TAB);
    }

    @And("^I should get password change confirmation mail id as \"([^\"]*)\"$")
    public void iShouldGetPasswordChangeConfirmationMailIdAs(String arg0) throws Throwable {
        util.log4j("I verify password change confirmation in email");
        util.focusOnTab();
        util.getMail(arg0);
        util.getEmailBody();
        //System.out.println(driver.findElement(By.xpath("//*[@id='mailhaut']/div[1]")).getText());
    }

    @And("I enter valid user name in username field as {string}")
    public void iEnterValidUserNameInUsernameFieldAs(String arg0) {
        util.log4j("I enter valid username as: "+arg0);
        util.waitUntilWebElelemntShouldBeDisplay(driver,login.UserName,30);
        login.UserName.sendKeys(arg0);
    }

    @And("I should get password change confirmation email id as {string}")
    public void iShouldGetPasswordChangeConfirmationEmailIdAs(String arg0) throws InterruptedException {
        util.log4j("I verify password change confirmation in email");
        util.focusOnTab();
        util.getMails(arg0);
        util.getEmailBody();
    }

    @And("I should see Get OTP button")
    public void iShouldSeeGetOTPButton() {
        fp.getOTPButton.isDisplayed();
        boolean otpbtn = fp.getOTPButton.isEnabled();
        Assert.assertFalse(otpbtn);
    }

    @And("I Enter invalid email id  as {string}")
    public void iEnterInvalidEmailIdAs(String arg0) {
        fp.emailAddressField.sendKeys(arg0);
        fp.emailAddressField.sendKeys(Keys.TAB);
    }

    @And("I click on Get OTP button")
    public void iClickOnGetOTPButton() {
        util.waitAndClick(fp.getOTPButton);
    }

    @And("I see Resend OTP and Edit Email buttons")
    public void iSeeResendOTPAndEditEmailButtons() {
//        Assert.assertTrue(fp.resendOTPButton.isDisplayed());
        Assert.assertTrue(fp.editEmailButton.isDisplayed());
    }

    @And("I see OTP message title as {string}")
    public void iSeeOTPMessageTitleAs(String arg0) {
//        System.out.println(fp.otpMessage.getText());
       Assert.assertEquals(fp.otpMessage.getText(),arg0);
    }

    @And("I see OTP input fields are present")
    public void iSeeOTPInputFieldsArePresent() {
        Assert.assertTrue(fp.otpFields.isDisplayed());
    }

    @Then("I enter otp from email in otp field")
    public void iEnterOtpFromEmailInOtpField() {
        util.waitUntilWebElelemntShouldBeDisplay(driver,fp.otpFields,30);
        for(int i=0;i<fp.listOtpFields.size();i++){
            int a = i+1;
//            System.out.println("Value of a: "+a);
            fp.listOtpFields.get(i).sendKeys(String.valueOf(a));
        }
        util.waitAndClick(fp.submitOTP);
    }

    @And("I see new password and confirm password fields")
    public void iSeeNewPasswordAndConfirmPasswordFields() {
        util.waitUntilWebElelemntShouldBeDisplay(driver,fp.newPasswordField,30);
        Assert.assertTrue(fp.newPasswordField.isDisplayed());
        Assert.assertTrue(fp.confirmPasswordField.isDisplayed());
    }

    @And("I enter valid new password on Set password page as {string}")
    public void iEnterValidNewPasswordOnSetPasswordPageAs(String arg0) throws InterruptedException {
        Thread.sleep(2000);
        fp.newPasswordField.sendKeys(arg0);
    }

    @And("I enter confirm password on Set password page as {string}")
    public void iEnterConfirmPasswordOnSetPasswordPageAs(String arg0) {
        fp.confirmPasswordField.sendKeys(arg0);
    }
}

