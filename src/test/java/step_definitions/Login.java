package step_definitions;

import baseClass.Environments;
import baseClass.Utils;
import baseClass.mainDriver;
import cucumber.api.DataTable;
import cucumber.api.PendingException;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import pageFactory.pmxAdmin_POM;
import userData.loginData;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.*;
import org.testng.Assert;
import pageFactory.Login_POM;
import pageFactory.forgotPassword_POM;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class Login extends mainDriver {
    public String SignupPage;
    public Utils util = new Utils();
    public pmxAdmin_POM pmxAdmin = new pmxAdmin_POM(driver);
    public Login_POM login = new Login_POM(driver);
    public loginData data = new loginData();
    public forgotPassword_POM fp = new forgotPassword_POM(driver);
    public WebElement registerLoginLink;
    public WebElement forgotPasswordLink;
    public String linksText;
    public String userName;
    public static String emailid;
    public String cpText;


    @When("^I navigate to paymate login page$")
    public void INavigateToPaymateLoginPage() throws InterruptedException {
        util.log4j("*****************************verify Login filed Label*********************************");
        Boolean logoPresent = login.companuLogo.isDisplayed();
        String onLogin = login.loginpagetext.getText();
        // Assert.assertEquals();
        Assert.assertTrue(logoPresent);
        util.log4j("I checked PayMate logo");
        Assert.assertEquals(onLogin, "Login to your account");
        util.log4j("I checked Login Login with your PayMate Account");
    }

   /* @Then("^I see the User Name Place Holder$")
    public void iSeeTheUserNamePlaceHolder() {
        // Write code here that turns the phrase above into concrete actions
        String userNamePlaceholder = login.userNameLabel.getAttribute("label");
        Assert.assertEquals(userNamePlaceholder, "User Name");
        util.log4j();
    }*/

    @And("^I Enter Valid User Name As\"([^\"]*)\"$")
    public void IEnterValidUserNameAs(String userName) {
        util.log4j("I enter a valid username in username field");
        login.UserName.sendKeys(userName);
    }


    @And("^I click on login button$")
    public void IClickOnLoginButton() throws InterruptedException {
        Assert.assertEquals(login.loginButton.isEnabled(), true);
        util.impliciteWait();
        util.log4j("I click on login button");
        login.loginButton.click();
        Thread.sleep(5000);
    }

    @Then("^I should be able to click and should navigate to business dash board page$")
    public void IShouldBeAbleToClickAndShouldNavigateToBusinessDashBoardPage() throws InterruptedException {
        util.waitUntilWebElelemntShouldBeDisplay(driver,login.pageTitle,30);
        String checktext = login.pageTitle.getText();
        System.out.println("Line 598: "+checktext);
//        Assert.assertTrue(checktext.contains(firstName));
    }

    @Then("^I should not be loggedIn$")
    public void IShouldNotBeLoggedIn() {
        Assert.assertEquals(login.loginpagetext.getText(), "Login to your account");
    }

    @And("^I should be see proper validation message for user name and for password in red color$")
    public void IShouldBeSeeProperValidationMessageForUserNameAndForPasswordInRedColor() {
        // Code for user Name text and color
        String text = login.usernamevalidation.getText();
        String textcolor = login.usernamevalidation.getCssValue("color");
        if (textcolor.equals("rgba(213, 0, 0, 1)")) {
            Assert.assertEquals(text, "Please enter username.");
            Assert.assertEquals(textcolor.toString(), "rgba(213, 0, 0, 1)");
        } else if (textcolor.equals("rgb(213, 0, 0)")) {
            Assert.assertEquals(text, "Please enter username.");
            Assert.assertEquals(textcolor.toString(), "rgb(213, 0, 0)");
        }
        //code for Password text and color
        String text1 = login.passval.getText();
        String textcolor2 = login.passval.getCssValue("color");
        if (textcolor2.equals("rgba(213, 0, 0, 1)")) {
            Assert.assertEquals(text1, "Please enter your password.");
            Assert.assertEquals(textcolor2, "rgba(213, 0, 0, 1)");
        } else if (textcolor2.equals("rgb(213, 0, 0)")) {
            Assert.assertEquals(text1, "Please enter your password.");
            Assert.assertEquals(textcolor2, "rgb(213, 0, 0)");
        }
        util.log4j("I see enter username and password message in red color");
    }

    @When("^I enter invalid user name as \"([^\"]*)\"$")
    public void IEnterInvalidUserNameAs(String arg0) throws Throwable {
        util.log4j("Entering a invalid username in username field");
        login.UserName.sendKeys(arg0);
    }

    @And("^I enter invalid password as  \"([^\"]*)\"$")
    public void IEnterInvalidPasswordAs(String arg0) {
        util.log4j("Entering a invalid password in password field");
        login.password.sendKeys(arg0);
    }

    @And("^I should be see proper validation message in red color$")
    public void IShouldBeSeeProperValidationMessageInRedColor() {
//        util.setWebDriverFluentWait(1, 30, By.xpath("//*[@id='form1']/div[3]"));
        Assert.assertEquals(login.invalidemailandpassword.getText(),"Please enter a valid username or password");
       /* String validationmessage = login.invalidemailandpassword.getText();
        String validationmessagecolor = login.invalidemailandpassword.getCssValue("color");
        if (validationmessagecolor.equals("rgba(255, 255, 255, 1)")) {
            Assert.assertEquals(validationmessage, "Please enter a valid username or password");
            Assert.assertEquals(validationmessagecolor, "rgba(255, 255, 255, 1)");
        } else if (validationmessage.equals("rgb(255, 255, 255)")) {
            Assert.assertEquals(validationmessage, "Please enter a valid username or password");
            Assert.assertEquals(validationmessagecolor, "rgb(255, 255, 255)");
        }*/
    }

    @Then("^I Should not be Login$")
    public void IShouldNotBeLogin() {
        Assert.assertEquals(login.loginpagetext.getText(), "Login with your PayMate Account");
    }


    @And("^I should be see proper validation message as \"([^\"]*)\" In Red Color$")
    public void IShouldBeSeeProperValidationMessageAsInRedColor(String message) {
        util.webdriverWait(30, By.xpath("//*[@id='form1']/div[3]/div"));
        String validationmessage1 = login.firstTimeinvalidpasswordmessage.getText();
        String message1validationcolor = login.firstTimeinvalidpasswordmessage.getCssValue("color");
        if (message1validationcolor.equals("rgba(255, 255, 255, 1)")) {
            Assert.assertEquals(validationmessage1, message);
            Assert.assertEquals(message1validationcolor, "rgba(255, 255, 255, 1)");
        } else if (message1validationcolor.equals("rgb(255, 255, 255)")) {
            Assert.assertEquals(validationmessage1, message);
            Assert.assertEquals(message1validationcolor, "rgba(255, 255, 255)");
        }

    }

    @And("^I should get Email$")
    public void IShouldGetEmail() {
        try {
            util.OpenMail(data.loginUserName);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }

    @And("^I enter valid user name as \"([^\"]*)\"$")
    public void iEnterValidUserNameAs(String arg0) throws Throwable {
        util.log4j("I enter valid username as: "+arg0);
        login.UserName.sendKeys(SignUp.emailid);
    }

    @And("I will enter valid user name as {string}")
    public void iWillEnterValidUserNameAs(String arg0) {
        util.log4j("I enter valid username as: "+arg0);
        util.waitUntilWebElelemntShouldBeDisplay(driver,login.UserName,30);
        login.UserName.sendKeys(arg0);
    }

    @And("^I enter valid password as \"([^\"]*)\"$")
    public void iEnterValidPasswordAs(String arg0) throws Throwable {
        util.log4j("I enter valid password as :"+arg0);
        util.waitUntilWebElelemntShouldBeDisplay(driver,login.password,30);
        login.password.sendKeys(arg0);
    }


    @Then("^I should be land on Forget Password Page$")
    public void iShouldBeLandOnForgetPasswordPage() throws Throwable {
        System.out.println("Forgot Password text =" + fp.forgotPasswordPageTitle.getText());
        Assert.assertEquals(fp.forgotPasswordPageTitle.getText(), "Forgot password");
    }

    @Then("^I should see forgot password link and register now$")
    public void iShouldSeeForgotPasswordLinkAndRegisterNow() {
        registerLoginLink = login.SignupLink;
        String text = registerLoginLink.getText();
        Assert.assertEquals(text, "Register Now!");
        util.log4j("I verify Register Now! link is present");
        forgotPasswordLink = login.forgotPasswordLink1;
        String text2 = forgotPasswordLink.getText();
        Assert.assertEquals(text2, "Forgot Password?");
        util.log4j("I verify Forgot Password link is present");
    }

    @And("^I click on register now link$")
    public void iClickOnRegisterNowLink() throws InterruptedException {
        util.log4j("Clicking on Register now Link");
        util.waitAndClick(fp.loginButton);
//        login.loginLink.click();
        Thread.sleep(3000L);
        login.SignupLink.click();
        Thread.sleep(3000L);
        SignupPage = login.registerTitle.getText();
        Assert.assertEquals(SignupPage, "Create your PayMate account");
    }

    @Then("^I see user name label as \"([^\"]*)\"$")
    public void iSeeUserNameLabelAs(String arg0) {
        String uLabel = login.userNameLabel1.getText();
        //System.out.println("\nUser Name Label: " + uLabel);
        Assert.assertEquals(uLabel, arg0);
        util.log4j("I check user name label: " + arg0);
    }

    @And("^I see Password Label As \"([^\"]*)\"$")
    public void iSeePasswordLabelAs(String arg0) {
        String pLabel = login.passwordLabel.getText();
        //System.out.println("\nPassword Label: " + pLabel);
        Assert.assertEquals(pLabel, arg0);
        util.log4j("I check password label: " + arg0);
    }

    @When("^I Open mail and Click on Link$")
    public void iOpenMailAndClickOnLink() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        util.openNewTab();
        util.getMail(data.loginUserName);
        for (util.i = 0; util.i < util.links.size(); util.i++) {
            util.mailliks = util.links.get(util.i).getText();
            if (util.mailliks.equals("here")) {

                util.links.get(util.i).click();

                Thread.sleep(3000L);
                System.out.println("\nCurrent window Url: " + driver.getCurrentUrl());
                util.focusOnTab();

            }

        }
    }


    @When("^I enter valid user name \"([^\"]*)\" and following invalid password \"([^\"]*)\"$")
    public void iEnterValidUserNameAndFollowingInvalidPassword(String arg0, String arg1) throws Throwable {
      util.log4j("I enter valid username and invalid password");
        this.userName = arg0;
        login.UserName.sendKeys(arg0);
        login.password.sendKeys(arg1);
    }


    @Then("^I should get following validation msg\"([^\"]*)\" and mail should be open for particular validation msg$")
    public void iShouldGetFollowingValidationMsgAndMailShouldBeOpenForParticularValidationMsg(String arg0) throws Throwable {
        util.webdriverWait(30, By.xpath("//div[@class='inline-element']"));
        WebElement element = driver.findElement(By.xpath("//div[@class='inline-element']"));
        String textMessage = element.getText();
        switch (arg0) {
            case "Please enter the correct email / password. You have 2 login attempts left":
                Assert.assertTrue(arg0.equals(textMessage), "Validation message is not matched");
                System.out.println("Validation message is: " + textMessage);
                break;

            case "Please enter the correct email / password. You have 1 login attempts left.Click on Forgot Password to reset password.":
                Assert.assertTrue(arg0.equals(textMessage), "Validation message is not matched");
                System.out.println("Validation message is: " + textMessage);
                util.OpenMail(userName);
                util.getEmailBodyYopmail();
                break;

            case "Your account has been blocked due to 3 failed login attempts. To reset your password please click on Forgot Password.":
                Assert.assertTrue(arg0.equals(textMessage));
                System.out.println("Validation message is: " + textMessage);
                util.OpenMail(userName);
//                util.getMail(emailid);
                util.getEmailBodyYopmail();
                break;

        }

    }


    @Then("I enter admin username as {string}")
    public void iEnterAdminUsernameAs(String arg0) {
        pmxAdmin.adminUsername.sendKeys(arg0);
    }

    @Then("I enter admin password as {string}")
    public void iEnterAdminPasswordAs(String arg0) {
        pmxAdmin.adminPassword.sendKeys(arg0);
    }

    @And("I click on Login button for admin page")
    public void iClickOnLoginButtonForAdminPage() throws InterruptedException {
        pmxAdmin.adminLoginButton.click();
        Thread.sleep(5000L);
//        util.waitUntilWebElelemntShouldBeDisplay(driver,pmxAdmin.adminHomePageText,30);
        System.out.println("Line 318: "+pmxAdmin.adminHomePageText.getText());
        Assert.assertEquals(pmxAdmin.adminHomePageText.getText(),"Welcome to PayMate");
    }




    @And("I click on the following {string}")
    public void iClickOnTheFollowing(String arg0) throws InterruptedException {
        System.out.println("Line 329: "+arg0);
//        Thread.sleep(3000);
        List<WebElement> listFooter = login.footerLinks;
        for (int i = 0; i < listFooter.size(); i++) {
//            System.out.println(login.footerLinks.get(i).getText());
            String text = listFooter.get(i).getText();
            if (arg0.equals("Terms of use") && arg0.equals(text)) {
                System.out.println("Text is: " +arg0);
                util.waitAndClick(listFooter.get(i));
                util.switchToTab();
                Thread.sleep(200L);
                cpText = login.tncText.getAttribute("innerHTML");
                System.out.println("Line 338:"+cpText);
                break;
            } else if(arg0.equals("Privacy policy") && arg0.equals(text)){
                System.out.println("Text is: " +arg0);
                util.click(listFooter.get(i), driver);
                util.switchToTab();
                Thread.sleep(200L);
                cpText = login.privacyPolicyText.getAttribute("innerHTML");
                System.out.println("Line 338:"+cpText);

            } else if(arg0.equals("Help") && arg0.equals(text)){
                System.out.println("Text is: " +arg0);
                util.click(listFooter.get(i), driver);
                util.switchToTab();
                Thread.sleep(200L);
                cpText = login.helpText.getText();
                System.out.println("Line 338:"+cpText);

            } else if(arg0.equals("Charges") && arg0.equals(text)){
                System.out.println("Text is: " +arg0);
                util.click(listFooter.get(i), driver);
                Thread.sleep(200L);
                util.switchToTab();
                cpText = login.chargesText.getAttribute("innerHTML");
                System.out.println("Line 338:"+cpText);

            } else if(arg0.equals("Contact Us") && arg0.equals(text)){
                System.out.println("Text is: " +arg0);
                util.click(listFooter.get(i), driver);
                Thread.sleep(200L);
                cpText = login.contactUsText.getAttribute("innerHTML");
                System.out.println("Line 338:"+cpText);

            }
        }
    }

    @Then("I should land on particular page for static links")
    public void iShouldLandOnParticularPageForStaticLinks() {
        System.out.println("I am on " + cpText + " page");
    }

    @And("I will enter valid user name for HDFC as {string}")
    public void iWillEnterValidUserNameForHDFCAs(String arg0) {
        util.log4j("I enter valid username as: "+arg0);
        login.UserName.sendKeys(arg0);
    }

    @And("I enter valid password for HDFC as {string}")
    public void iEnterValidPasswordForHDFCAs(String arg0) {
        util.log4j("I enter valid password as :"+arg0);
        util.waitUntilWebElelemntShouldBeDisplay(driver,login.password,30);
        login.password.sendKeys(arg0);
    }

    @Then("I click on Login button for HDFC")
    public void iClickOnLoginButtonForHDFC() {
        Assert.assertEquals(login.loginButton.isEnabled(), true);
        util.impliciteWait();
        util.log4j("I click on login button");
        login.loginButton.click();
    }

    @Then("I enter otp and click on verify button")
    public void iEnterOtpAndClickOnVerifyButton() throws InterruptedException {
        util.log4j("Entering OTP");
//        Assert.assertEquals(login.verifyMobileText.getText(),"Verify Mobile Number ");
        util.waitUntilWebElelemntShouldBeDisplay(driver,login.otp1,30);
        Thread.sleep(3000L);
//        Assert.assertTrue(login.otpField.isEnabled());
        util.log4j("I enter otp and click verify");
        login.otp1.sendKeys("1");
        login.otp2.sendKeys("2");
        login.otp3.sendKeys("3");
        login.otp4.sendKeys("4");
        login.otp5.sendKeys("5");
        login.otp6.sendKeys("6");
        login.verifyButtonHDFC.click();
//        util.waitUntilWebElelemntShouldBeDisplay(driver,login.pageTitle,10);
    }

    @When("I should see forgot password link and register now for HDFC")
    public void iShouldSeeForgotPasswordLinkAndRegisterNowForHDFC() {
        registerLoginLink = login.SignupLink;
        String text = registerLoginLink.getText();
        Assert.assertEquals(text, "Sign up here");
        util.log4j("I verify Sign up here link is present");
        forgotPasswordLink = login.forgotPasswordHDFC;
        String text2 = forgotPasswordLink.getText();
        Assert.assertEquals(text2, "Forgot Password");
        util.log4j("I verify Forgot Password link is present");
    }

    @Then("I click on forgot password link for HDFC")
    public void iClickOnForgotPasswordLinkForHDFC() {
        util.log4j("Clicking on Forgot Password Link");
        util.waitElementShouldBeClickable(fp.forgotPasswordLinkHDFC);
        fp.forgotPasswordLinkHDFC.click();
        try {
            Thread.sleep(3000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @And("I click on on Sign up here link")
    public void iClickOnOnSignUpHereLink() throws InterruptedException {
        util.waitAndClick(fp.closeForgotPassword);
        login.SignupLink.click();
        Thread.sleep(3000L);
        SignupPage = login.signUpTitleHDFC.getText();
        Assert.assertEquals(SignupPage, "Sign up on PayMate !");
    }

    @When("I navigate to paymate login page for HDFC portal")
    public void iNavigateToPaymateLoginPageForHDFCPortal() {
        util.log4j("*****************************verify Login field Label*********************************");
        Boolean logoPresent = login.companyLogoHDFC.isDisplayed();
        String onLogin = login.loginPageTextHDHFC.getText();
        // Assert.assertEquals();
        Assert.assertTrue(logoPresent);
        util.log4j("I checked PayMate logo");
        Assert.assertEquals(onLogin, "Login Now !");
        util.log4j("I checked text Login Now !");
    }

    @Then("I see user name label for HDFC as {string}")
    public void iSeeUserNameLabelForHDFCAs(String arg0) {
        String uLabel = login.userIDLabelHDFC.getText();
        System.out.println("\nUser Name Label: " + uLabel);
        Assert.assertEquals(uLabel, arg0);
        util.log4j("I check user name label: " + arg0);
    }

    @And("I see Password Label for HDFC As {string}")
    public void iSeePasswordLabelForHDFCAs(String arg0) {
        String pLabel = login.passwordLabelHDFC.getText();
        System.out.println("\nPassword Label: " + pLabel);
        Assert.assertEquals(pLabel, arg0);
        util.log4j("I check password label: " + arg0);
    }

    @Then("I should not be loggedIn in HDFC")
    public void iShouldNotBeLoggedInInHDFC() {
        Assert.assertEquals(login.loginPageTextHDHFC.getText(), "Login Now !");
    }

    @And("I should be see proper validation message for user name and for password in red color for HDFC")
    public void iShouldBeSeeProperValidationMessageForUserNameAndForPasswordInRedColorForHDFC() {
        String text = login.usernamevalidation.getText();
        Assert.assertEquals(text, "Please enter registered email id.");
        String text1 = login.passval.getText();
        Assert.assertEquals(text1, "Please enter your password.");
    }

    @And("I click on the following {string} for HDFC")
    public void iClickOnTheFollowingForHDFC(String arg0) throws InterruptedException {
        System.out.println("Line 329: "+arg0);
//        Thread.sleep(3000);
        List<WebElement> listFooter = login.footerLinks;
        for (int i = 0; i < listFooter.size(); i++) {
//            System.out.println(login.footerLinks.get(i).getText());
            String text = listFooter.get(i).getText();
            if (arg0.equals("Terms of use") && arg0.equals(text)) {
                System.out.println("Text is: " +arg0);
                util.waitAndClick(listFooter.get(i));
                util.switchToTab();
                Thread.sleep(200L);
                cpText = login.tncTextHDFC.getAttribute("innerHTML");
                System.out.println("Line 338:"+cpText);
                break;
            } else if(arg0.equals("Privacy policy") && arg0.equals(text)){
                System.out.println("Text is: " +arg0);
                util.click(listFooter.get(i), driver);
                util.switchToTab();
                Thread.sleep(200L);
                cpText = login.privacyPolicyText.getAttribute("innerHTML");
                System.out.println("Line 338:"+cpText);

            } else if(arg0.equals("Help") && arg0.equals(text)){
                System.out.println("Text is: " +arg0);
                util.click(listFooter.get(i), driver);
                Thread.sleep(200L);
                util.switchToTab();
                Thread.sleep(200L);
                cpText = login.helpText.getText();
                System.out.println("Line 338:"+cpText);

            } else if(arg0.equals("Charges") && arg0.equals(text)){
                System.out.println("Text is: " +arg0);
                util.click(listFooter.get(i), driver);
                Thread.sleep(200L);
                util.switchToTab();
                cpText = login.chargesText.getAttribute("innerHTML");
                System.out.println("Line 338:"+cpText);

            } else if(arg0.equals("Contact Us") && arg0.equals(text)){
                System.out.println("Text is: " +arg0);
                util.click(listFooter.get(i), driver);
                Thread.sleep(200L);
                cpText = login.contactUsText.getAttribute("innerHTML");
                System.out.println("Line 338:"+cpText);

            }
        }
    }

    @And("I will enter valid user name in UAE as {string}")
    public void iWillEnterValidUserNameInUAEAs(String arg0) {
        util.log4j("I enter valid username as: "+arg0);
        util.waitUntilWebElelemntShouldBeDisplay(driver,login.userNameFieldUAE,10);
        login.userNameFieldUAE.sendKeys(arg0);
    }

    @And("I enter valid password in UAE as {string}")
    public void iEnterValidPasswordInUAEAs(String arg0) {
        util.log4j("I enter valid username as: "+arg0);
        util.waitUntilWebElelemntShouldBeDisplay(driver,login.passwordFieldUAE,10);
        login.passwordFieldUAE.sendKeys(arg0);
    }

    @And("I click on login button in UAE")
    public void iClickOnLoginButtonInUAE() throws InterruptedException {
        Assert.assertEquals(login.loginButtonUAE.isEnabled(), true);
        util.impliciteWait();
        util.log4j("I click on login button");
        login.loginButtonUAE.click();
        if(login.continueButtonUae.isEnabled()){
            System.out.println("Click Continue");
            util.waitAndClick(login.continueButtonUae);
        }
        Thread.sleep(3000);
    }
}


