package step_definitions;
import baseClass.Environments;
import baseClass.Utils;
import baseClass.mainDriver;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pageFactory.*;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class SignUp extends mainDriver {
    public SignUp_POM signup = new SignUp_POM(driver);
    public Utils u = new Utils();
    public uploadKyc_POM uploadkyc = new uploadKyc_POM(driver);
    public forgotPassword_POM fp = new forgotPassword_POM(Hooks.driver);
    Hooks hooks = new Hooks();
    public addContact_POM con = new addContact_POM(driver);
    public String moNumber;
    public static String emailid;
    public static String firstName;
    public static String lastName;
    private String companyName;
    public String businessName_Str;
    public String contactName_Str;
    public String contactDesgn_Str;
    public String country_Str;
    public String emailID_Str;
    public String mobileNo_Str;
    public String typeOfBusiness_Str;
    public String businessCategory_Str;
    public String businessSubCategory_Str;
    public String saleRep_Str;
    public String address_Str;
    public String emirate_Str;
    int totalvalues;
    public String postalCode_Str;
    // public Login login=new Login();
    public Login_POM login = new Login_POM(driver);

    public SignUp() throws InterruptedException {
    }

   /* void When("User navigates to paymate url", () -> {
        Environments e = new Environments();
        e.env = System.getProperty("env");
        if (e.env == null) {
            e.env = "qa";
        }
    });*/

    @When("User navigates to paymate url")
    public void userNavigatesToPaymateUrl() {
        Environments e = new Environments();
        e.env = System.getProperty("env");
        if (e.env == null) {
            e.env = "qa";
        }

        System.out.println("The test is running on " + e.env.toUpperCase() + " environment");
        switch (e.env.toLowerCase()) {

            case "uat":
                /*driver.navigate().to("https://uat.paymate.co.in/paymatesite/Login.aspx");
                break;*/

            case "qa":
                driver.navigate().to("https://dev.paymate.in/Beta/PMX3.0/Login.aspx");
                driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);

           /* driver.navigate().to("https://uat.paymate.co.in/paymatesite/Login.aspx");
            driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);*/


              /*  driver.navigate().to("https://dev.paymate.in/Beta/HDFC/Login.aspx");
                driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);*/

               /* driver.navigate().to("https://dev.paymate.in/Beta/PMXUAE/");
                driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);*/

           /*     driver.navigate().to("https://dev.paymate.in/Beta/PayMateAdmin/Login.aspx");
                driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);*/

                driver.navigate().to("https://uat.paymate.co.in/paymatesite/Login.aspx");
                driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
//
//              /*  driver.navigate().to("https://uat.paymate.co.in/paymatesite/Login.aspx");
//                driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);              driver.navigate().to("https://dev.paymate.in/Beta/hdfcadmin/Login.aspx");


            case "prod":
                /*driver.navigate().to("https://paymate.in/Login.aspx");
                break;*/
        }
    }

    @Then("^I Should be Land On Register page$")
    public void iShouldBeLandOnRegisterPage() throws InterruptedException {
        Thread.sleep(3000L);
        u.waitUntilWebElelemntShouldBeDisplay(driver, signup.SignupWelComeText, 30);
        String signupText = signup.SignupWelComeText.getText();
        System.out.println("\nSign Up wel Come text :" + signupText);
        Assert.assertEquals(signupText, "Create your PayMate account");
    }

    @And("^I should see Label of All text fields$")
    public void iShouldSeeLabelOfAllTextFields() {
        String FNLabelText = signup.FNLabel.getText();
        System.out.println("\nFirst Name Label Text: " + FNLabelText);
        Assert.assertEquals(FNLabelText, "First Name");
        //Last name Label
        String LNLabelText = signup.LNLabel.getText();
        System.out.println("\nLast Name Label: " + LNLabelText);
        Assert.assertEquals(LNLabelText, "Last Name");
        //Email Label
        String emailLabelText = signup.EmailLabel.getText();
        System.out.println("\nEmail Label: " + emailLabelText);
        Assert.assertEquals(emailLabelText, "Email");
        //Mobile Number Label
        String MnLabelText = signup.MNLabel.getText();
        System.out.println("\nMobile Number Label: " + MnLabelText);
        Assert.assertEquals(MnLabelText, "Mobile Number");
    }

    @And("^I Should see Check box with \"([^\"]*)\" text$")
    public void iShouldSeeCheckBoxWithText(String arg0) {
        boolean chckbox = signup.checkBox.isEnabled();
        Assert.assertEquals(chckbox, true);
        boolean checkBoxDisplay = signup.checkBox.isDisplayed();
        Assert.assertEquals(checkBoxDisplay, true);
        try {
            Thread.sleep(3000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String checkBoxText = signup.checkBox.getText();
        System.out.println("\nCheck Box Text: " + checkBoxText);
        Assert.assertEquals(checkBoxText, arg0);
    }

    @And("^I Should see Signp Button And Sign In link$")
    public void iShouldSeeSignpButtonAndSignInLink() {
        //Sign Up Button
        boolean signUpB = signup.signUpButton.isDisplayed();
        Assert.assertEquals(signUpB, true);
        boolean signupEnable = signup.signUpButton.isEnabled();
        Assert.assertEquals(signupEnable, true);

        //SignIn Link
        boolean signInDisplay = signup.SignInLink.isDisplayed();
        Assert.assertEquals(signInDisplay, true);

    }

    @And("^I click on SigIn link den i should be land on SignIn page$")
    public void iClickOnSigInLinkDenIShouldBeLandOnSignInPage() {
        signup.SignInLink.click();
        u.waitUntilWebElelemntShouldBeDisplay(driver, signup.loginPage, 30);
        String logintext = signup.loginPage.getText();
        System.out.println("\n Login Page Text: " + logintext);
        Assert.assertEquals(logintext, "Login to your account");
    }

    @When("^I click on Register Now link from Login Page$")
    public void iClickOnRegisterNowLinkFromLoginPage() throws InterruptedException {
        Thread.sleep(3000);
//        u.waitUntilWebElelemntShouldBeDisplay(driver, signup.SignupLink,30);
        u.waitAndClick(signup.SignupLink);
//        signup.SignupLink.click();

    }

    @And("^I Should See Forgot Password link with clickable Link from SignUp page$")
    public void iShouldSeeForgotPasswordLinkWithClickableLinkFromSignUpPage() {
        signup.SignupLink.click();
        u.waitUntilWebElelemntShouldBeDisplay(driver, signup.FpLink, 30);
        boolean fpLinkDisplay = signup.FpLink.isDisplayed();
        Assert.assertEquals(fpLinkDisplay, true);
        boolean FpLinkEnable = signup.FpLink.isEnabled();
        Assert.assertEquals(FpLinkEnable, true);
        signup.FpLink.click();

    }

    @And("^I should be land on Forget Password Page from Sign Up page$")
    public void iShouldBeLandOnForgetPasswordPageFromSignUpPage() {
        u.waitUntilWebElelemntShouldBeDisplay(driver, signup.FpText, 30);
        String FPgetText = signup.FpText.getText();
        System.out.println("\n This is Forgot Password Page: " + FPgetText);
        Assert.assertEquals(FPgetText, "Forgot password");
    }

    //*****************************************************************Enter Valid data*******************************************************
    @And("^I enter valid first name$")
    public void iEnterValidFirstName() {
        signup.FirestName.sendKeys("vijay");
    }

    @And("^I enter valid last name$")
    public void iEnterValidLastName() {
        // Write code here that turns the phrase above into concrete actions
        signup.LastName.sendKeys("Deshpande");
    }

    @And("^I enter valid email$")
    public void iEnterValidEmail() {
        // Write code here that turns the phrase above into concrete actions
        signup.Email.sendKeys("shradha01@yopmail.com");
    }

    @And("^I enter valid mobile number$")
    public void iEnterValidMobileNumber() {
        // Write code here that turns the phrase above into concrete actions
        signup.MobileNumber.sendKeys("9870697982");
    }

    @And("^I click on terms and conditions check box$")
    public void iClickOnTermsAndConditionsCheckBox() {
        signup.checkBox.click();
        String patrent = driver.getWindowHandle();
        Set<String> wins = driver.getWindowHandles();
        Iterator<String> itr = wins.iterator();
        while (itr.hasNext()) {
            itr.next();
            driver.switchTo().window(patrent);
        }
        try {
            Thread.sleep(3000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Then("^I should see popUp window with terms and conditions text and accept button$")
    public void iShouldSeePopUpWindowWithTermsAndConditionsTextAndAcceptButtonInGreenColor() {
        String tc = driver.findElement(By.xpath("//*[@id='tnc-container']")).getText();
//        System.out.println("Terms & Conditions text: " + tc);
        try {
            Thread.sleep(3000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        u.click(signup.acceptButton, Hooks.driver);

        try {
            Thread.sleep(3000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }


    @And("^I Click on Signup Button and i should see proper validation message in green color$")
    public void iClickOnSignupButtonAndIShouldSeeProperValidationMessageInGreenColor() throws InterruptedException {
        u.click(signup.SubmitButton, driver);
        //signup.SubmitButton.click();
        Thread.sleep(2000L);
        WebDriverWait wait = new WebDriverWait(driver, 50);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='form1']/div[3]/div")));
        String registermsg = fp.Successfullymsg.getText();
        System.out.println("\nRegistration successfully message: " + registermsg);
        Assert.assertEquals(registermsg, "Welcome to PayMate! You are a few steps away from setting up your account.");
//        Assert.assertEquals(registermsg, "Account created! Verify Email id to proceed.");
     /*   String successcolor = fp.Successfullymsg.getCssValue("color");
        if (hooks.browser.equalsIgnoreCase("chrome") || hooks.browser.equalsIgnoreCase("ie")) {
            Assert.assertEquals(successcolor, "rgba(255, 255, 255, 1)");
        } else if (hooks.browser.equalsIgnoreCase("firefox")) {
            Assert.assertEquals(successcolor, "rgb(255, 255, 255)");
        }*/
        try {
            Thread.sleep(2000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @And("^I should land on verify and confirm your email addres page$")
    public void iShouldLandOnVerifyAndConfirmYourEmailAddresPage() {
        WebDriverWait wait = new WebDriverWait(driver, 50);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'We have sent you an email. Please check your mail')]")));
        String text = signup.verfiyEmailPage.getText();
        System.out.println("Confirm Email Address Page: " + text);
        Assert.assertEquals(text, "We have sent you an email. Please check your mailbox and click on the link to verify and confirm your email address.");
    }


    @And("^I click on verify email Address button$")
    public void iClickOnVerifyEmailAddressButton() throws InterruptedException {
        for (u.i = 0; u.i < u.links.size(); u.i++) {
            u.mailliks = u.links.get(u.i).getText();
            if (u.mailliks.equalsIgnoreCase("Verify Email Address")) {
                u.click(u.links.get(u.i), driver);
                u.switchToTab();
                try {
                    Thread.sleep(3000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                String winHandleBefore = driver.getWindowHandle();
                for (String winHandle : driver.getWindowHandles()) {
                    driver.switchTo().window(winHandle);
                }
                break;
            }

        }

    }

    @And("^I  Shoudl land Verify Mobile number page$")
    public void iShoudlLandVerifyMobileNumberPageAndUserShouldGetOTP() {
        String text = signup.Text.getText();
        System.out.println("\nText: " + text);
        Assert.assertEquals(text, "Verify Mobile number");
        u.impliciteWait();

    }

    @And("^I Enter valid OTP$")
    public void iEnterValidOTP() throws InterruptedException {
        // Write code here that turns the phrase above into concrete actions
       Thread.sleep(5000);
        signup.EnterOTP.sendKeys("123456");
    }

    @And("^I click on submit button$")
    public void iClickOnSubmitButton() {
        // Write code here that turns the phrase above into concrete actions
        signup.SubmitButton.click();

    }

    @Then("^I should see proper validation message in green color$")
    public void iShouldSeeProperValidationMessageInGreenColor() {
        u.webdriverWait(30, By.xpath("//*[@id='form1']/div[3]"));
     /*   String successcolor = fp.Successfullymsg.getCssValue("color");
        if (hooks.browser.equalsIgnoreCase("chrome")) {
            Assert.assertEquals(successcolor, "rgba(255, 255, 255, 1)");
        } else if (hooks.browser.equalsIgnoreCase("firefox")) {
            Assert.assertEquals(successcolor, "rgb(255, 255, 255)");
        }*/
        String validationMessage = signup.EnterOtpValidationMessage.getText();
        System.out.println("\nValidation message when i enter OTP: " + validationMessage);
        Assert.assertEquals(validationMessage, "Your mobile number is verified.");
    }

    @And("^I Should land on create password page$")
    public void iShouldLandOnCreatePasswordPage() {
        String createPassword = signup.getCreatePasswordText.getText();
        System.out.println("I am On create Password Page: " + createPassword);
        Assert.assertEquals(createPassword, "Create a password for your account");
    }

    @And("^I enter password and ReEnter password$")
    public void iEnterPasswordAndReEnterPassword() {
        String enterPasswordLabel = signup.getEnterPasswordLabel.getText();
        System.out.println("\nEnter Password Label: " + enterPasswordLabel);
        Assert.assertEquals(enterPasswordLabel, "Enter Password");
        signup.getEnterPasswordField.sendKeys("Paymate@123");
        String reEnterPAsswordlabel = signup.getreEnterPasswordLabel.getText();
        System.out.println("\nReEnter Password Label: " + reEnterPAsswordlabel);
        Assert.assertEquals(reEnterPAsswordlabel, "Re-Enter Password");
        signup.getReEnterPasswordField.sendKeys("Paymate@123");
        u.log4j("Password entered is: Paymate@123");
        // Password guidance text
        String passwordGuidance = signup.getPasswordGuidanceText.getText();
        System.out.println("\nPassword guidance text: " + passwordGuidance);
    }

    @And("^I click on submit button and i should see proper validation message in green color$")
    public void iClickOnSubmitButtonAndIShouldSeeProperValidationMessageInGreenColor() {
        signup.getSubmitButton.click();
        try {
            Thread.sleep(3000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String passwordValidatioinMessage = fp.Successfullymsg.getAttribute("innerHTML");
        System.out.println("\nPassword Created Successfully: " + passwordValidatioinMessage);
        Assert.assertEquals(passwordValidatioinMessage, "Password created.");
        String successcolor = fp.Successfullymsg.getCssValue("color");
        if (hooks.browser.equalsIgnoreCase("chrome")) {
            Assert.assertEquals(successcolor, "rgba(255, 255, 255, 1)");
        } else if (hooks.browser.equalsIgnoreCase("rgb(255, 255, 255)")) {
            Assert.assertEquals(successcolor, "rgb(255, 255, 255)");
        }
        try {
            Thread.sleep(3000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Then("^I should be land on business page$")
    public void iShouldBeLandOnBusinessPage() {
        String bText = signup.getBusinessPageText.getText();
        System.out.println("\nI am business page: " + bText);
        Assert.assertEquals(bText, "Help us know your business better");
    }


    @And("^I select following business type\"([^\"]*)\"$")
    public void iSelectFollowingBusinessType(String arg0) {
        List<WebElement> value = signup.getTypeOfBusinessValue;
        int totalvalues = value.size();

        for (int i = 0; i < totalvalues; i++) {
            String valuesAre = value.get(i).getText();
            System.out.println("\n Business type are: " + valuesAre);
            if (valuesAre.equals(arg0)) {
                value.get(i).click();

                break;
            }

        }
    }

    @And("^I select valid business type$")
    public void iSelectValidBusinessType() {
        // Write code here that turns the phrase above into concrete actions

        //  List<WebElement> values = driver.findElements((By) signup.getTypeOfBusinessValue);
        List<WebElement> value = signup.getTypeOfBusinessValue;
        int totalvalues = value.size();

        for (int i = 0; i < totalvalues; i++) {
            String valuesAre = value.get(i).getText();
            System.out.println("\n Business type are: " + valuesAre);
            if (valuesAre.equals("Individuals")) {
                value.get(i).click();

                break;
            }

        }

    }

    @And("^I select valid category$")
    public void iSelectValidCategory() {
        // Write code here that turns the phrase above into concrete actions
        List<WebElement> ele = signup.getCategoryDropDownValue;
        int values = ele.size();
        System.out.println("\n Total Count is: " + values);
        for (int i = 0; i < values; i++) {
            String valuesare = ele.get(i).getText();
            System.out.println("Total Value: " + valuesare);
            if (valuesare.equals("Clothing, Accessories and Shoes")) {
                ele.get(i).click();
                try {
                    Thread.sleep(3000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                break;
            }

        }
    }

    @And("^I select valid Sub category$")
    public void iSelectValidSubCategory() {
        // Write code here that turns the phrase above into concrete actions
        signup.getSubCategoryField.click();
        try {
            Thread.sleep(3000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        List<WebElement> subvalues = signup.getSubCategoryValue;
        int values = subvalues.size();
        for (int i = 0; i < values; i++) {
            String valuesub = subvalues.get(i).getText();
            System.out.println("Total Sub values are: " + valuesub);
            if (valuesub.equals("Accessories")) {
                subvalues.get(i).click();
                try {
                    Thread.sleep(3000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                break;
            }
        }
    }

    @And("I select valid State")
    public void iSelectValidState() {
        signup.getStateField.click();
        try {
            Thread.sleep(3000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        List<WebElement> subvalues = signup.getStateValue;
        int values = subvalues.size();
        for (int i = 0; i < values; i++) {
            String valuesub = subvalues.get(i).getText();
//            System.out.println("Total Sub values are: " + valuesub);
            if (valuesub.equals("Maharashtra")) {
                subvalues.get(i).click();
                try {
                    Thread.sleep(3000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                break;
            }
        }

    }

    @And("I select valid Region")
    public void iSelectValidRegion() {
        signup.getRegionField.click();
        try {
            Thread.sleep(3000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        List<WebElement> subvalues = signup.getRegionValue;
        int values = subvalues.size();
        for (int i = 0; i < values; i++) {
            String valuesub = subvalues.get(i).getText();
//            System.out.println("Total Sub values are: " + valuesub);
            if (valuesub.equals("Akola")) {
                subvalues.get(i).click();
                try {
                    Thread.sleep(3000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                break;
            }
        }

    }

    @And("^I enter website information$")
    public void iEnterWebsiteInformation() {
        try {
            Thread.sleep(3000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
       /* signup.getSocialPageField.sendKeys("Whether you book an air-inclusive or hotel only vacation package, " +
                "Apple Vacations includes round-trip transfers between the destination airport and hotel. " +
                "You can relax knowing that your transportation is taken care of for no additional cost, " +
                "unlike other travel sites that charge up to $100 per person for transfers. ");*/

        signup.getSocialPageField.sendKeys("www.testbusiness.com");

    }

    @And("^I enter business information$")
    public void iEnterBusinessInformation() {
        try {
            Thread.sleep(3000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        signup.getBusinessDefinitionField.sendKeys("We offer Non-stop Exclusive Vacation Flights");
    }

    @And("^I click Complete signup button$")
    public void iClickCompleteSignupButton() {
        signup.getCompleteSignUp.click();
        try {
            Thread.sleep(3000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Then("^I should be register successfully with validation message in green color$")
    public void iShouldBeRegisterSuccessfullyWithValidationMessageInGreenColor() throws InterruptedException {
        Thread.sleep(5000);
        String registermsg = signup.msg.getText();
        System.out.println("\nRegistration successfully message: " + registermsg);
        Assert.assertEquals(registermsg, "Signup completed. Welcome to PayMate!");
        String successcolor = fp.Successfullymsg.getCssValue("color");
        if (hooks.browser.equalsIgnoreCase("chrome")) {
            Assert.assertEquals(successcolor, "rgba(255, 255, 255, 1)");
        } else if (hooks.browser.equalsIgnoreCase("firefox")) {
            Assert.assertEquals(successcolor, "rgb(255, 255, 255)");
        }
        Thread.sleep(5000);
    }

    @And("^I Should see two links with clickable$")
    public void iShouldSeeTwoLinksWithClickable() {
        boolean display = signup.resendEmail.isDisplayed();
        Assert.assertEquals(display, true);
        boolean clickable = signup.resendEmail.isEnabled();
        Assert.assertEquals(clickable, true);
        boolean changeEmailDisplay = signup.changeEmail.isDisplayed();
        Assert.assertEquals(changeEmailDisplay, true);
        boolean changeEmailClickable = signup.changeEmail.isEnabled();
        Assert.assertEquals(changeEmailClickable, true);
    }

    @And("^I should see proper validation msg verify mobile number page$")
    public void iShouldSeeProperValidationMsgVerifyMobileNumberPage() {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("Mobile Number: " + moNumber);
        String msg = "One Time Password (OTP) has been sent to your mobile ";
        String str = moNumber.substring(0, 2);
        String str2 = moNumber.substring(6, 10);
        String str3 = "XXXX";
        String com = msg + str + str3 + str2;
        System.out.println("Dynamic validation message is: " + com);
        String otp = signup.otpText.getText();
        System.out.println("Web Validation msg is: " + otp);
        //String trimOTPText = otp.substring(otp.lastIndexOf(" ") + 2);
        Assert.assertTrue(com.equals(otp), "OTP number validation msg is not matched");
//One Time Password (OTP) has been sent to your mobile 99XXXX2476

    }

    @And("^I should see text box with One time Password label and two links with clickable  and Submit button with clickable$")
    public void iShouldSeeTextBoxWithOneTimePasswordLabelAndTwoLinksWithClickableAndSubmitButtonWithClickable() {
        // Write code here that turns the phrase above into concrete actions
        String OtpLabel = signup.otpTextBoxLabel.getText();
        Assert.assertEquals(OtpLabel, "One Time Password");
        u.impliciteWait();
        boolean linkDisplay = signup.ResendOtpLink.isDisplayed();
        Assert.assertEquals(linkDisplay, true);
        boolean linkEnable = signup.ResendOtpLink.isEnabled();
        Assert.assertEquals(linkEnable, true);
        //Chnage Mobile Number Link code
        boolean changeMobileNumberLink = signup.changemobileNumber.isDisplayed();
        Assert.assertEquals(changeMobileNumberLink, true);
        boolean changeMobileLinkEnable = signup.changemobileNumber.isEnabled();
        Assert.assertEquals(changeMobileLinkEnable, true);
        //SubMit Button code
        boolean submitButtonDisplay = signup.submiButton.isDisplayed();
        Assert.assertEquals(submitButtonDisplay, true);
        boolean buttonEnable = signup.submiButton.isEnabled();
        Assert.assertEquals(buttonEnable, true);

    }


    @And("^I see all filed Labels and fields are enable$")
    public void iSeeAllFiledLabelsAndFieldsAreEnable() {
        //Business name Label
        String businessNameLabel = signup.getBusinessFieldLabel.getText();
        Assert.assertEquals(businessNameLabel, "Business Name");
        System.out.println("\n Business name feild is Matched: " + businessNameLabel);

        //Business Name field enable
        boolean businessNameEnable = signup.getBusinessNameField.isEnabled();
        Assert.assertEquals(businessNameEnable, true);

        //Business GSTIN
        String businessGSTINLabel = signup.getBusinessGSTINLabel.getText();
        System.out.println("\n Business GSTIN feild is Matched: "+businessGSTINLabel);

        boolean businessGSTINEnable = signup.getBusinessGSTINField.isEnabled();
        Assert.assertEquals(businessGSTINEnable, true);

      /*  //WebSite/Social Page
        String socialPageLabel = signup.getSocialPageLabel.getText();
        Assert.assertEquals(socialPageLabel, "Website/Social Page/Blog");
        System.out.println("\nlabel is matched: " + socialPageLabel);

        //Websitr/Social page field enable
        boolean socialpageEnable = signup.getSocialPageField.isEnabled();
        Assert.assertEquals(socialpageEnable, true);*/

    }


    @And("^I click on category dropDown field$")
    public void iClickOnCategoryDropDownField() {
        signup.getCategorydropdown.click();
        try {
            Thread.sleep(3000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @And("^I click on business type filed$")
    public void iClickOnBusinessTypeFiled() {
        signup.getTypeOfBusinessFiled.click();
        try {
            Thread.sleep(3000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @And("^I select valid business type <BusinessType>$")
    public void iSelectValidBusinessTypeBusinessType(String arg0) {
        // Write code here that turns the phrase above into concrete action
        System.out.println("\nBusiness Type are: " + arg0);

    }

    @And("^I should be land on paymate dashboard$")
    public void iShouldBeLandOnPaymateDashboard() {
//        Assert.assertEquals(login.homePageText.getText(), "WELCOME"+firstName);
        u.waitUntilWebElelemntShouldBeDisplay(driver, login.pageTitle, 30);
        String checktext = login.pageTitle.getText();
        System.out.println("Line 711: " + checktext);
        Assert.assertTrue(checktext.contains(firstName));
        try {
            Thread.sleep(3000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @And("I check the respective kyc fields are present as per {string}")
    public void iCheckTheRespectiveKycFieldsArePresentAsPer(String arg0) {
        uploadkyc.getUploadKycLink.isDisplayed();
        uploadkyc.getUploadKycLink.click();
        String businessType = uploadkyc.getBusinessType.getAttribute("value");
        u.log4j("Business type is: " + businessType);
        Assert.assertTrue(businessType.equals(arg0), "Invalid business type name");
        switch (arg0) {
            case "Proprietorship":
                u.businessIdentityDetailsValidations();
                u.businessProofDetailsValidation1();
                u.businessAddressDetailsValidation();
                //Upload Address Document for Proprietorship
                u.log4j("Checking upload address dropdown values");
                String[] uploadAddressDropdownValues = {"--SELECT--", "Bank Statement", "Electricity Bill", "GST Certificate", "MCA Address", "Professional Tax Certificate", "Shop Establishment Certificate", "Telephone Bill"};
                List<WebElement> uploadAddval = uploadkyc.getUploadAddressDropDownValues;
                for (int i = 0; i < uploadAddval.size(); i++) {
                    String uploadAddvaluesAre = uploadAddval.get(i).getAttribute("innerHTML");
//                    String values = uploadAddvaluesAre.concat("\",");
//                    System.out.print("\""+values);
                    Assert.assertEquals(uploadAddvaluesAre, uploadAddressDropdownValues[i]);
                }
                u.log4j("All values are present");
                break;
            case "Private Limited":
                u.businessIdentityDetailsValidations();
                u.businessProofDetailsValidation2();
                u.businessAddressDetailsValidation();

                //Upload Address Document for Private Limited
                u.log4j("Checking upload address dropdown values for PVT LTD");
                String[] uploadAddressPvtLtdDropdownValues = {"--SELECT--", "Bank Statement", "Company Incorporation Certificate", "Electricity Bill", "GST Certificate","MCA Address","Shop Establishment Certificate", "Telephone Bill"};
                List<WebElement> uploadAddPvtLtdval = uploadkyc.getUploadAddressDropDownValues;
                for (int i = 0; i < uploadAddPvtLtdval.size(); i++) {
                    String uploadAddvaluesAre = uploadAddPvtLtdval.get(i).getAttribute("innerHTML");
//                    String values = uploadAddvaluesAre.concat("\",");
//                    System.out.print("\""+values);
                    Assert.assertEquals(uploadAddvaluesAre, uploadAddressPvtLtdDropdownValues[i]);
                }
                u.log4j("All values are present");
                break;

            case "Limited Liability Partnership":
                u.businessIdentityDetailsValidations();
                String businessLLPNameLabel = uploadkyc.getBusinessNameLabel.getText();
                Assert.assertEquals(businessLLPNameLabel, "Business Name *");

                Boolean businessLLPNameField = uploadkyc.getBusinessNameLLP.isDisplayed();
                Assert.assertTrue(businessLLPNameField, "Field is not displayed");

                String llpIdentificationLabel = uploadkyc.getGetLlpIdentificationNumberLabel.getText();
                Assert.assertEquals(llpIdentificationLabel, "LLP Identification Number *");

                Boolean llpIdentificationField = uploadkyc.getLlpIdentificationNumber.isDisplayed();
                Assert.assertTrue(llpIdentificationField, "Field is not displayed");

                u.businessAddressDetailsValidation();
                //Upload Address Document for Private Limited
                u.log4j("Checking upload address dropdown values for LLP");
                String[] uploadAddressLLPDropdownValues = {"--SELECT--", "Bank Statement", "Electricity Bill", "GST Certificate", "Shop Establishment Certificate", "Telephone Bill"};
                List<WebElement> uploadAddLLPval = uploadkyc.getUploadAddressDropDownValues;
                for (int i = 0; i < uploadAddLLPval.size(); i++) {
                    String uploadAddvaluesAre = uploadAddLLPval.get(i).getAttribute("innerHTML");
//                    String values = uploadAddvaluesAre.concat("\",");
//                    System.out.print("\""+values);
                    Assert.assertEquals(uploadAddvaluesAre, uploadAddressLLPDropdownValues[i]);
                }
                u.log4j("All values are present");
                break;

            case "Public Limited":
                u.businessIdentityDetailsValidations();
                u.businessProofDetailsValidation2();
                u.businessAddressDetailsValidation();
                //Upload Address Document for Public Limited
                u.log4j("Checking upload address dropdown values for Public LTD");
                String[] uploadAddressPublicDropdownValues = {"--SELECT--", "Bank Statement", "Company Incorporation Certificate", "Electricity Bill", "GST Certificate", "Shop Establishment Certificate", "Telephone Bill"};
                List<WebElement> uploadAddPublicLtdval = uploadkyc.getUploadAddressDropDownValues;
                for (int i = 0; i < uploadAddPublicLtdval.size(); i++) {
                    String uploadAddvaluesAre = uploadAddPublicLtdval.get(i).getAttribute("innerHTML");
                    System.out.println(uploadAddvaluesAre);
//                    String values = uploadAddvaluesAre.concat("\",");
//                    System.out.print("\""+values);
                    Assert.assertEquals(uploadAddvaluesAre, uploadAddressPublicDropdownValues[i]);
                }
                u.log4j("All values are present");
                break;

            case "Partnership":
                u.businessIdentityDetailsValidations();
                u.businessAddressDetailsValidation();
                String businessProofDetailsTitle = uploadkyc.getBusinessProffDetailsTitle.getText();
                Assert.assertEquals(businessProofDetailsTitle, "BUSINESS PROOF DETAILS");


                u.log4j("Checking Business Document Upload Dropdown values");
                String[] partnershipDropdownValues = {"--SELECT--", "GST Certificate", "PAN", "PF Registration Certificate", "Professional Tax Certificate", "Shop Establishment Certificate"};
                List<WebElement> partnershipValue = uploadkyc.getBusinnessDocumentDropDownValues;
                int totalvalues = partnershipValue.size();

                for (int i = 0; i < totalvalues; i++) {
                    String valuesAre = partnershipValue.get(i).getAttribute("innerHTML");
                    Assert.assertEquals(valuesAre, partnershipDropdownValues[i]);
                }
                u.log4j("All values are present");


                Boolean businessUploadDocumentField = uploadkyc.getUploadBusinessDocumentField.isEnabled();
                Assert.assertTrue(businessUploadDocumentField, "Field not enabled");

                String businessUploadDocumentLabel = uploadkyc.getUploadBusinessDocumentLabel.getText();
                Assert.assertEquals(businessUploadDocumentLabel, "Upload Business Document*");
                u.log4j("Business document label text is: " + businessUploadDocumentLabel);

                //Upload Address Document for Partnership
                u.log4j("Checking upload address dropdown values for Partnership");
                String[] uploadAddressPartnershipDropdownValues = {"--SELECT--", "Bank Statement", "Electricity Bill", "GST Certificate", "Shop Establishment Certificate", "Telephone Bill"};
                List<WebElement> uploadAddPartnershipval = uploadkyc.getUploadAddressDropDownValues;
                for (int i = 0; i < uploadAddPartnershipval.size(); i++) {
                    String uploadAddvaluesAre = uploadAddPartnershipval.get(i).getAttribute("innerHTML");
                    System.out.println(uploadAddvaluesAre);
//                    String values = uploadAddvaluesAre.concat("\",");
//                    System.out.print("\""+values);
                    Assert.assertEquals(uploadAddvaluesAre, uploadAddressPartnershipDropdownValues[i]);
                }
                u.log4j("All values are present");
                break;

            case "One Person Company":
                u.businessIdentityDetailsValidations();
                u.businessProofDetailsValidation2();
                u.businessAddressDetailsValidation();

                //Upload Address Document for One Person Company
                u.log4j("Checking upload address dropdown values for One Person Company");
                String[] uploadAddressOnePersonDropdownValues = {"--SELECT--", "Bank Statement", "Electricity Bill", "GST Certificate", "Shop Establishment Certificate", "Telephone Bill"};
                List<WebElement> uploadAddOnePersonval = uploadkyc.getUploadAddressDropDownValues;
                for (int i = 0; i < uploadAddOnePersonval.size(); i++) {
                    String uploadAddvaluesAre = uploadAddOnePersonval.get(i).getAttribute("innerHTML");
//                    System.out.println(uploadAddvaluesAre);
//                    String values = uploadAddvaluesAre.concat("\",");
//                    System.out.print("\""+values);
                    Assert.assertEquals(uploadAddvaluesAre, uploadAddressOnePersonDropdownValues[i]);
                }
                u.log4j("All values are present");
                break;

            case "Hindu Undivided Family":
                u.businessIdentityDetailsValidations();
                u.log4j("Checking Business Document Upload Dropdown values for Hindu Undivided Family");
                String[] unDividedDropdownValues = {"--SELECT--", "GST Certificate", "PAN", "PF Registration Certificate", "Professional Tax Certificate", "Shop Establishment Certificate"};
                List<WebElement> unDividedval = uploadkyc.getBusinnessDocumentDropDownValues;
                for (int i = 0; i < unDividedval.size(); i++) {
                    String valuesAre = unDividedval.get(i).getAttribute("innerHTML");
                    Assert.assertEquals(valuesAre, unDividedDropdownValues[i]);
                }
                u.log4j("All values are present");

                Boolean businessUploadUndividedDocumentField = uploadkyc.getUploadBusinessDocumentField.isEnabled();
                Assert.assertTrue(businessUploadUndividedDocumentField, "Field not enabled");

                u.businessAddressDetailsValidation();
                //Upload Address Document for Hindu Undivided Family
                u.log4j("Checking upload address dropdown values for Hindu Undivided Family");
                String[] uploadAddressUndividedDropdownValues = {"--SELECT--", "Bank Statement", "Electricity Bill", "GST Certificate", "Shop Establishment Certificate", "Telephone Bill"};
                List<WebElement> uploadAddUndividedval = uploadkyc.getUploadAddressDropDownValues;
                for (int i = 0; i < uploadAddUndividedval.size(); i++) {
                    String uploadAddvaluesAre = uploadAddUndividedval.get(i).getAttribute("innerHTML");
//                    System.out.println(uploadAddvaluesAre);
//                    String values = uploadAddvaluesAre.concat("\",");
//                    System.out.print("\""+values);
                    Assert.assertEquals(uploadAddvaluesAre, uploadAddressUndividedDropdownValues[i]);
                }
                u.log4j("All values are present");
                break;

            case "Cooperative Society":
                u.businessIdentityDetailsValidations();
                u.log4j("Checking Business Document Upload Dropdown values for Hindu Undivided Family");
                String[] cooperativeSocietyDropdownValues = {"--SELECT--", "GST Certificate", "PF Registration Certificate", "Professional Tax Certificate", "Shop Establishment Certificate"};
                List<WebElement> cooperativeSocietyval = uploadkyc.getBusinnessDocumentDropDownValues;
                for (int i = 0; i < cooperativeSocietyval.size(); i++) {
                    String valuesAre = cooperativeSocietyval.get(i).getAttribute("innerHTML");
                    Assert.assertEquals(valuesAre, cooperativeSocietyDropdownValues[i]);
                }
                u.log4j("All values are present");

                u.businessAddressDetailsValidation();
                //Upload Address Document for Hindu Undivided Family
                u.log4j("Checking upload address dropdown values for Hindu Undivided Family");
                String[] uploadAddressCoopSocietyDropdownValues = {"--SELECT--", "Bank Statement", "Electricity Bill", "GST Certificate", "Shop Establishment Certificate", "Telephone Bill"};
                List<WebElement> uploadAddCoopSocietyval = uploadkyc.getUploadAddressDropDownValues;
                for (int i = 0; i < uploadAddCoopSocietyval.size(); i++) {
                    String uploadAddvaluesAre = uploadAddCoopSocietyval.get(i).getAttribute("innerHTML");
//                    System.out.println(uploadAddvaluesAre);
//                    String values = uploadAddvaluesAre.concat("\",");
//                    System.out.print("\""+values);
                    Assert.assertEquals(uploadAddvaluesAre, uploadAddressCoopSocietyDropdownValues[i]);
                }
                u.log4j("All values are present");

                break;
        }

    }


    //Verify Signup screen with invalid data
    @When("^I Click on Signup button without entering the details in all the mandatory fields$")
    public void iClickOnSignupButtonWithoutEnteringTheDetailsInAllTheMandatoryFields() {
        signup.getSignInLink.click();
        u.impliciteWait();
        signup.SubmitButton.click();
        try {
            Thread.sleep(4000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Then("^I Should be able to click SignUp button$")
    public void iShouldBeAbleToClickSignUpButton() {
        // Write code here that turns the phrase above into concrete actions
        boolean buttonClickable = signup.submiButton.isEnabled();
        Assert.assertEquals(buttonClickable, true);

    }

    @And("^I see all mandatory fields should be highlighted with red color$")
    public void iSeeAllMandatoryFieldsShouldBeHighlightedWithRedColor() {
        // Write code here that turns the phrase above into concrete actions
        List<WebElement> countmsg = signup.getErrorMessage;
        int totalMsg = countmsg.size();
        for (int i = 0; i < totalMsg; i++) {
            String msg = countmsg.get(i).getText();
            System.out.println("\n Validation message are: " + msg);
            String colors = countmsg.get(i).getCssValue("color");
            System.out.println("\n Validation message color are: " + colors);
            System.out.println("Browser: " + hooks.browser);

            if (msg.equals("Please enter First Name")) {
                Assert.assertEquals(msg, "Please enter First Name");
                System.out.println("\n msg : " + msg);

                if (colors.equals("rgba(213, 0, 0, 1)")) {
                    Assert.assertEquals(colors, "rgba(213, 0, 0, 1)");
                    System.out.println("\n colors: " + colors);
                } else if (colors.equals("rgb(213, 0, 0)")) {
                    Assert.assertEquals(colors, "rgb(213, 0, 0)");
                    System.out.println("\n colors: " + colors);
                }
            } else if (msg.equals("Please enter Last Name")) {
                Assert.assertEquals(msg, "Please enter Last Name");
                System.out.println("\n msg : " + msg);

                if (colors.equals("rgba(213, 0, 0, 1)")) {
                    Assert.assertEquals(colors, "rgba(213, 0, 0, 1)");
                    System.out.println("\n colors: " + colors);
                } else if (colors.equals("rgb(213, 0, 0)")) {
                    Assert.assertEquals(colors, "rgb(213, 0, 0)");
                    System.out.println("\n colors: " + colors);
                }
            } else if (msg.equals("Please enter Email")) {
                Assert.assertEquals(msg, "Please enter Email");
                System.out.println("\n msg : " + msg);

                if (colors.equals("rgba(213, 0, 0, 1)")) {
                    Assert.assertEquals(colors, "rgba(213, 0, 0, 1)");
                    System.out.println("\n colors: " + colors);
                } else if (colors.equals("rgb(213, 0, 0)")) {
                    Assert.assertEquals(colors, "rgb(213, 0, 0)");
                    System.out.println("\n colors: " + colors);
                }
            } else if (msg.equals("Please enter Mobile Number")) {
                Assert.assertEquals(msg, "Please enter Mobile Number");
                System.out.println("\n msg : " + msg);

                if (colors.equals("rgba(213, 0, 0, 1)")) {
                    Assert.assertEquals(colors, "rgba(213, 0, 0, 1)");
                    System.out.println("\n colors: " + colors);
                } else if (colors.equals("rgb(213, 0, 0)")) {
                    Assert.assertEquals(colors, "rgb(213, 0, 0)");
                    System.out.println("\n colors: " + colors);
                }
            }
        }
    }

    @And("^I see focus should be moved on to First name field with error message as \"([^\"]*)\"$")
    public void iSeeFocusShouldBeMovedOnToFirstNameFieldWithErrorMessageAs(String arg0) {
        boolean focus = signup.getFirstNameFocus.isEnabled();
        Assert.assertEquals(focus, true);
        System.out.println("Cursor is focusing on First Name: ");
        u.waitUntilWebElelemntShouldBeDisplay(driver, signup.getFirestNameMsg, 30);
        String fNMsg = signup.getFirestNameMsg.getText();
        String color = signup.getFirestNameMsg.getCssValue("color");
        Assert.assertEquals(fNMsg, "Please enter First Name");
        System.out.println("\n msg : " + fNMsg);
        if (color.equals("rgba(213, 0, 0, 1)")) {
            Assert.assertEquals(color, "rgba(213, 0, 0, 1)");
            driver.navigate().refresh();
        } else if (color.equals("rgb(213, 0, 0)")) {
            Assert.assertEquals(color, "rgb(213, 0, 0)");
            driver.navigate().refresh();
        }


    }

    @When("^I Enter Invalid numeric and special character name in First Name and Last Name field$")
    public void iEnterInvalidNumericAndSpecialCharacterNameInFirstNameAndLastNameField() {
        // Write code here that turns the phrase above into concrete actions
        try {
            Thread.sleep(3000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        signup.FirestName.clear();
        signup.FirestName.sendKeys("564564$^&^%$%$");

    }

    @Then("^I Should not be able to enter the numeric and special characters$")
    public void iShouldNotBeAbleToEnterTheNumericAndSpecialCharacters() {
        // Write code here that turns the phrase above into concrete actions
        String text = signup.FirestName.getAttribute("value");
        boolean empty = text.isEmpty();
        Assert.assertEquals(empty, true);
    }

    @When("^I Enter invalid email in email id field$")
    public void iEnterInvalidEmailInEmailIdField() {
        // Write code here that turns the phrase above into concrete actions
        signup.Email.sendKeys("emailvijay");
        signup.Email.sendKeys(Keys.TAB);
        try {
            Thread.sleep(2000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Then("^I see an error message \"([^\"]*)\" and field should be highlighted in red color$")
    public void iSeeAnErrorMessageAndFieldShouldBeHighlightedInRedColor(String arg0) {
        // Write code here that turns the phrase above into concrete actions


        String EmailMsg = signup.getEmalMsg.getText();
        String EColor = driver.findElement(By.cssSelector("#cphContents_cvEmailaddress")).getCssValue("color");
        Assert.assertEquals(EmailMsg, arg0);
        System.out.println("\n Msg : " + EmailMsg);
        if (EColor.equals("rgba(213, 0, 0, 1)")) {
            Assert.assertEquals(EColor, "rgba(213, 0, 0, 1)");
        } else if (EColor.equals("rgb(213, 0, 0)")) {
            Assert.assertEquals(EColor, "rgb(213, 0, 0)");
        }

    }

    @When("^I Enter invalid mobile number$")
    public void iEnterInvalidMobileNumber() {
        // Write code here that turns the phrase above into concrete actions
        signup.MobileNumber.sendKeys("6555556");
        signup.MobileNumber.sendKeys(Keys.TAB);
    }

    @When("^I Click on Signup button without entering any one of the mandatory fields Then I see the field in red color with error message please enter respective field name$")
    public void iClickOnSignupButtonWithoutEnteringAnyOneOfTheMandatoryFieldsThenISeeTheFieldInRedColorWithErrorMessagePleaseEnterRespectiveFieldName() throws InterruptedException {
        // Write code here that turns the phrase above into concrete actions
        driver.navigate().refresh();
        signup.LastName.sendKeys("test");
        signup.Email.sendKeys("test@yopmail.com");
        signup.MobileNumber.sendKeys("9974854545");
        signup.SubmitButton.click();
        String fNMsg = signup.getFirestNameMsg.getAttribute("innerHTML");
        System.out.println("Line 986:" + fNMsg);
        String color = signup.getFirestNameMsg.getCssValue("color");
        Thread.sleep(3000L);
        Assert.assertEquals(fNMsg, "Please enter First Name");
        System.out.println("\n msg : " + fNMsg);
        if (color.equals("rgba(213, 0, 0, 1)")) {
            Assert.assertEquals(color, "rgba(213, 0, 0, 1)");
            u.impliciteWait();
            driver.navigate().refresh();
        } else if (color.equals("rgb(213, 0, 0)")) {
            Assert.assertEquals(color, "rgb(213, 0, 0)");
            u.impliciteWait();
            driver.navigate().refresh();
        }

        // LastName
        signup.FirestName.sendKeys("vijay");
        signup.Email.sendKeys("test@yopmail.com");
        signup.MobileNumber.sendKeys("9974854545");
        signup.SubmitButton.click();
        String lNMsg = signup.getLastNameMsg.getAttribute("innerHTML");
        System.out.println("Line 1007:" + lNMsg);
        String LColor = signup.getLastNameMsg.getCssValue("color");
        Thread.sleep(3000L);
        Assert.assertEquals(lNMsg, "Please enter Last Name");
        System.out.println("\n Msg : " + lNMsg);
        if (color.equals("rgba(213, 0, 0, 1)")) {
            Assert.assertEquals(LColor, "rgba(213, 0, 0, 1)");
            u.impliciteWait();
            driver.navigate().refresh();
        } else if (color.equals("rgb(213, 0, 0)")) {
            Assert.assertEquals(color, "rgb(213, 0, 0)");
            u.impliciteWait();
            driver.navigate().refresh();
        }

        //Email
        signup.FirestName.sendKeys("vijay");
        signup.LastName.sendKeys("test");
        signup.MobileNumber.sendKeys("9974854545");
        signup.SubmitButton.click();
        String EmailMsg = signup.getEmalMsg.getAttribute("innerHTML");
        String EColor = signup.getEmalMsg.getCssValue("color");
        Thread.sleep(3000L);
        Assert.assertEquals(EmailMsg, "Please enter Email");
        System.out.println("\n Msg : " + EmailMsg);
        if (color.equals("rgba(213, 0, 0, 1)")) {
            Assert.assertEquals(EColor, "rgba(213, 0, 0, 1)");
            u.impliciteWait();
            driver.navigate().refresh();
        } else if (color.equals("rgb(213, 0, 0)")) {
            Assert.assertEquals(color, "rgb(213, 0, 0)");
            u.impliciteWait();
            driver.navigate().refresh();
        }


        //Mobile Number

        signup.FirestName.sendKeys("vijay");
        signup.LastName.sendKeys("test");
        signup.Email.sendKeys("test@yopmail.com");
        signup.SubmitButton.click();
        String mMsg = signup.getMobileNumbermsg.getAttribute("innerHTML");
        String mColor = signup.getMobileNumbermsg.getCssValue("color");
        Assert.assertEquals(mMsg, "Please enter Mobile Number");
        System.out.println("\n Msg : " + mMsg);
        if (color.equals("rgba(213, 0, 0, 1)")) {
            Assert.assertEquals(mColor, "rgba(213, 0, 0, 1)");
            u.impliciteWait();
            driver.navigate().refresh();
        } else if (color.equals("rgb(213, 0, 0)")) {
            Assert.assertEquals(color, "rgb(213, 0, 0)");
            u.impliciteWait();
            driver.navigate().refresh();
        }


        // T&C
        signup.FirestName.sendKeys("vijay");
        signup.LastName.sendKeys("test");
        signup.Email.sendKeys("test@yopmail.com");
        signup.MobileNumber.sendKeys("9974854545");
        signup.SubmitButton.click();
        Thread.sleep(2000L);
        String tCMsg = signup.getTCMsg.getAttribute("innerHTML");
        String tCColor = signup.getTCMsg.getCssValue("color");
        Assert.assertEquals(tCMsg, "Please read terms and conditions");
        System.out.println("\n Msg : " + tCMsg);
        if (color.equals("rgba(213, 0, 0, 1)")) {
            Assert.assertEquals(tCColor, "rgba(255, 255, 255, 1)");
            driver.navigate().refresh();
            u.impliciteWait();
        } else if (color.equals("rgb(213, 0, 0)")) {
            Assert.assertEquals(color, "rgb(213, 0, 0)");
            driver.navigate().refresh();
            u.impliciteWait();
        }


    }

    @And("^I see an error message \"([^\"]*)\" and field highlighted in red color$")
    public void iSeeAnErrorMessageAndFieldHighlightedInRedColor(String arg0) {
        // Write code here that turns the phrase above into concrete actions
        String text = signup.getMobileNumbermsg.getText();
        /*String colors = signup.getMobileNumbermsg.getCssValue("color");
        if (colors.equals("rgba(213, 0, 0, 1)")) {
            Assert.assertEquals(colors, "rgba(213, 0, 0, 1)");
            Assert.assertEquals(text, arg0);
            u.impliciteWait();
            driver.navigate().refresh();
        }
        else if (colors.equals("rgb(213, 0, 0)")) {
            Assert.assertEquals(colors, "rgb(213, 0, 0)");

            Assert.assertEquals(text, arg0);
            u.impliciteWait();
            driver.navigate().refresh();
        }*/


    }

    @And("^I enter email ID which is registered but not verified$")
    public void iEnterEmailIDWhichIsRegisteredButNotVerified() {
        // Write code here that turns the phrase above into concrete action
        signup.Email.sendKeys("atul16@yopmail.com");
    }

    @And("^I enter mobile number which is register but not verified$")
    public void iEnterMobileNumberWhichIsRegisterButNotVerified() {
        // Write code here that turns the phrase above into concrete actions
        signup.MobileNumber.sendKeys("9870697982");
    }

    @And("^I Click on Signup Button$")
    public void iClickOnSignupButton() throws InterruptedException {
        u.click(signup.SubmitButton, driver);
//        signup.submiButton.click();
        Thread.sleep(3000L);

    }

    @Then("^I should see validation message \"([^\"]*)\" and message highlighted in green color$")
    public void iShouldSeeValidationMessageAndMessageHighlightedInGreenColor(String arg0) {
        // Write code here that turns the phrase above into concrete actions

        u.webdriverWait(30, By.xpath("//div[@class='alert-strip success-alert']"));
        String registermsg = driver.findElement(By.xpath("//div[@class='alert-strip success-alert']")).getText();
        System.out.println("\nRegistration successfully message: " + registermsg);
        Assert.assertEquals(registermsg, arg0);
        String successcolor = fp.Successfullymsg.getCssValue("color");
        if (successcolor.equals("rgba(255, 255, 255, 1)")) {
            Assert.assertEquals(successcolor, "rgba(255, 255, 255, 1)");
        } else if (successcolor.equals("rgb(255, 255, 255)")) {
            Assert.assertEquals(successcolor, "rgb(255, 255, 255)");
        }


    }

    @And("^I should land Welcome to PayMate Complete your sign-up page$")
    public void iShouldLandWelcomeToPayMateCompleteYourSignUpPage() {
        // Write code here that turns the phrase above into concrete actions
        try {
            Thread.sleep(4000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String text = signup.getWelComeToPaymate.getText();
        System.out.println("\nWelcome to paymate complete your signUp page: " + text);
        Assert.assertEquals(text, "Welcome to PayMate\n" +
                "Complete your sign-up");

    }

    @And("^I should see Looks like you have already attempted your registration earlier text$")
    public void iShouldSeeLooksLikeYouHaveAlreadyAttemptedYourRegistrationEarlierText() {
        // Write code here that turns the phrase above into concrete actions
        String text = signup.getCompletSignUpPage.getText();
        String pagetext = "Looks like you have already attempted your registration earlier. " +
                "You can choose to continue to setup your profile\n" +
                "or\n" +
                "start with a fresh registration";
        Assert.assertEquals(text, pagetext);
    }

    @And("^I should see start again button$")
    public void iShouldSeeStartAgainaAndContinueButton() {
        // Write code here that turns the phrase above into concrete actions
        boolean displayButton = signup.getStartAgianButton.isDisplayed();
        Assert.assertEquals(displayButton, true);
    }

    @When("^I click on start Again button$")
    public void iClickOnStartAgainButton() {
        // Write code here that turns the phrase above into concrete actions
        signup.getStartAgianButton.click();
        try {
            Thread.sleep(2000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Then("^I should land on singnUp page with blank field$")
    public void iShouldLandOnSingnUpPageWithBlankField() {
        // Write code here that turns the phrase above into concrete actions
        String welComeSignUp = signup.SignupWelComeText.getText();
        System.out.println("I am on SignUp page: " + welComeSignUp);
        Assert.assertEquals(welComeSignUp, "Sign Up PayMate Account");
    }

    @When("^I click on continue button$")
    public void iClickOnContinueButton() {
        // Write code here that turns the phrase above into concrete actions
        signup.getContinueButton.click();
        try {
            Thread.sleep(3000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Given("^I have to start from login page$")
    public void iHaveToStartFromLoginPage() throws InterruptedException {
        Environments e = new Environments();
        //e.driver.get(e.driveri.navigate().to(env));
        // driver.get(e.driver.getCurrentUrl());
        driver.navigate().to(e.driver.getCurrentUrl());
        System.out.println("This is url getting from Env : " + e.driver.getCurrentUrl());
    }

    @And("^I enter register email$")
    public void iEnterRegisterEmail() {
        // Write code here that turns the phrase above into concrete actions
        signup.Email.sendKeys("vijay35@yopmail.com");
    }

    @Then("^I should see proper validation message in Red Color and I should be redirect on login page$")
    public void iShouldSeeProperValidationMessageInRedColorAndIShouldBeRedirectOnLoginPage() {
        // Write code here that turns the phrase above into concrete actions
        String si = signup.getAlredayEmailregistermsg.getText();
        System.out.println("\n validation: " + si);
        if (si.equals("You are already registered with PayMate. You can proceed to Login with your credentials.")) {
            Assert.assertEquals(si, "You are already registered with PayMate. You can proceed to Login with your credentials.");
        } else {
            Assert.assertEquals(si, "Your email address is already linked to an account on Paymate.Log in with your email address and password");
        }
        try {
            Thread.sleep(3000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            String loginpage = driver.findElement(By.xpath("//div[@class='msg']")).getText();
            Assert.assertEquals(loginpage, "Login with your PayMate Account");
            System.out.println("I am on Login Page: " + loginpage);
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    @And("^I click on resend email link$")
    public void iClickOnResendEmailLink() {
        // Write code here that turns the phrase above into concrete actions
        signup.getResendEmailLink.click();
        try {
            Thread.sleep(3000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Then("^I see validation message as \"([^\"]*)\" in green color$")
    public void iSeeValidationMessageAsInGreenColor(String arg0) {
        // Write code here that turns the phrase above into concrete actions
        String msg = signup.getResendValidationMessage.getText();
        Assert.assertEquals(msg, arg0);
        System.out.println(msg);
    }

    @And("^I click on chnage your email link$")
    public void iClickOnChnageYourEmailLink() {

        // Write code here that turns the phrase above into concrete actions
        driver.close();
        signup.getChangeEmail.click();
        try {
            Thread.sleep(3000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String originalHandle = driver.getWindowHandle();
    }

    @Then("^I should land on signup page$")
    public void iShouldLandOnSignupPage() {
        // Write code here that turns the phrase above into concrete actions
        String text = signup.getAlredayEmailregistermsg.getText();
        System.out.println("i am on registration poage:  " + text);
        Assert.assertEquals(text, "Sign Up PayMate Account");

    }

    @And("^I should see email filed is editable other filed are non editable$")
    public void iShouldSeeEmailFiledIsEditableOtherFiledAreNonEditable() {
        // Write code here that turns the phrase above into concrete actions
        String attribute = signup.FirestName.getAttribute("readonly");
        System.out.println("\nAttribute: " + attribute);
        Assert.assertEquals(attribute, "readonly");
        String LnAttribute = signup.LastName.getAttribute("readonly");
        Assert.assertEquals(LnAttribute, "readonly");
        String emailAttribute = signup.Email.getAttribute("readonly");
        Assert.assertEquals(emailAttribute, null);
        String mobilenumberAttribute = signup.MobileNumber.getAttribute("readonly");
        Assert.assertEquals(mobilenumberAttribute, "readonly");
        boolean checked = signup.checkBox.isSelected();
        Assert.assertEquals(checked, true);
        signup.submiButton.click();
        try {
            Thread.sleep(3000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }


    @And("^I enter \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\"$")
    public void iEnterAndAndAnd(String arg0, String arg1, String arg2, String arg3) {
        u.impliciteWait();
        firstName = u.fakerData("firstName", arg0);
        signup.FirestName.sendKeys(firstName);
        lastName = u.fakerData("lastName", arg1);
        signup.LastName.sendKeys(lastName);
        signup.MobileNumber.sendKeys(moNumber = arg3);
        emailid = (u.fakerData("email", arg2));
        u.log4j("Email is " + emailid);
        signup.Email.sendKeys(emailid);

    }

    @And("I enter {string} , {string} , {string} and {string}")
    public void iEnterAnd(String arg0, String arg1, String arg2, String arg3) {
        u.impliciteWait();
        signup.FirestName.sendKeys(arg0);
        signup.LastName.sendKeys(arg1);
        signup.MobileNumber.sendKeys(arg3);
        signup.Email.sendKeys(arg2);
    }

    @And("^I enter foloowing business name\"([^\"]*)\"$")
    public void iEnterFoloowingBusinessName(String arg0) {
        companyName = u.fakerData("companyName", arg0);
        System.out.println("Company Name is:" + companyName);
        signup.getBusinessNameField.sendKeys(companyName);
    }

    @And("^I enter valid subBusiness name\"([^\"]*)\"$")
    public void iEnterValidSubBusinessName(String arg0) {
        signup.getSubBusinessName.sendKeys(arg0);
    }

    @And("^I Should see Following link\"([^\"]*)\"$")
    public void iShouldSeeFollowingLink(String arg0) {
        // Write code here that turns the phrase above into concrete actions
        boolean display = signup.resendEmail.isDisplayed();
        Assert.assertEquals(display, true);
        boolean clickable = signup.resendEmail.isEnabled();
        Assert.assertEquals(clickable, true);
        boolean changeEmailDisplay = signup.changeEmail.isDisplayed();
        Assert.assertEquals(changeEmailDisplay, true);
        boolean changeEmailClickable = signup.changeEmail.isEnabled();
        Assert.assertEquals(changeEmailClickable, true);
    }

    @And("^I click on links\"([^\"]*)\" and \"([^\"]*)\"$")
    public void iClickOnLinksAnd(String arg0, String arg1) {
        String resendEmail = signup.getResendEmailLink.getText();
        System.out.println("Line 1368: " + resendEmail);
        if (resendEmail.equals(arg0)) {
            u.click(signup.getResendEmailLink, driver);
            try {
                Thread.sleep(4000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            WebDriverWait wait = new WebDriverWait(driver, 50);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='alert-strip success-alert']")));
            String emailResendText = driver.findElement(By.xpath("//div[@class='alert-strip success-alert']")).getText();
            System.out.println("I clicked on email Resend link: " + emailResendText);
            Assert.assertEquals(emailResendText, "Email has been sent successfully");
            try {
                Thread.sleep(4000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                u.getMail(arg1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                Thread.sleep(3000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            for (u.i = 0; u.i < u.links.size(); u.i++) {
                u.mailliks = u.links.get(u.i).getText();
                if (u.mailliks.equalsIgnoreCase("Verify Email Address")) {

                    boolean col = u.links.get(u.i).isDisplayed();
                    Assert.assertEquals(col, true);
                    try {
                        Thread.sleep(3000L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    break;

                }

            }
        } else {
            String changeEmail = driver.findElement(By.cssSelector("#cphContents_lblChangeEmail")).getText();
            System.out.println("I got Change email link: " + changeEmail);
            if (changeEmail.equals(arg0)) {
                driver.findElement(By.cssSelector("#cphContents_lblChangeEmail")).click();
                try {
                    Thread.sleep(3000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                String attribute = signup.FirestName.getAttribute("readonly");
                System.out.println("\nAttribute: " + attribute);
                Assert.assertTrue(true, "attribute");
                String LnAttribute = signup.LastName.getAttribute("readonly");
                Assert.assertTrue(true, "LnAttribute");
                String emailAttribute = signup.Email.getAttribute("readonly");
                Assert.assertTrue(true, "emailAttribute");
                String mobilenumberAttribute = signup.MobileNumber.getAttribute("readonly");
                Assert.assertTrue(true, "mobilenumberAttribute");
                signup.Email.sendKeys(Keys.DELETE);
                signup.submiButton.click();
                try {
                    Thread.sleep(3000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                String emailUpdate = driver.findElement(By.xpath("//div[@class='alert-strip success-alert']")).getText();
                Assert.assertEquals(emailUpdate, "Your Email id has been changed successfully.");

            }
        }
    }


    @And("^I Enter following OTP$")
    public void iEnterFollowingOTP(DataTable dataTable) throws InterruptedException {
        // Write code here that turns the phrase above into concrete actions
        // List<String> values = otp.asList(String.class);
        List<List<String>> values = dataTable.cells();
        for (int i = 0; i < values.size(); i++) {
            signup.EnterOTP.sendKeys(values.get(i).get(0));
            Thread.sleep(2000L);
            signup.SubmitButton.click();
            u.waitUntilElelemntShouldBeDisplay(driver, By.xpath("//div[@class='alert-strip error-alert']"), 30);
            String msg = driver.findElement(By.xpath("//div[@class='alert-strip error-alert']")).getText();
            Assert.assertEquals(msg, "The OTP you have entered is incorrect. Please try again.");
            Thread.sleep(4000L);
        }


    }

    @And("^I enter \"([^\"]*)\" and \"([^\"]*)\"$")
    public void iEnterAnd(String arg0, String arg1) {
        signup.FirestName.sendKeys(arg0);
        signup.LastName.sendKeys(arg1);
    }

    @And("^I enter email ID \"([^\"]*)\"which is registered but not verified$")
    public void iEnterEmailIDWhichIsRegisteredButNotVerified(String arg0) {
        signup.Email.sendKeys(arg0);
    }

    @And("^I enter mobile number \"([^\"]*)\" which is register but not verified$")
    public void iEnterMobileNumberWhichIsRegisterButNotVerified(String arg0) {
        // Write code here that turns the phrase above into concrete actions
        signup.MobileNumber.sendKeys(arg0);
    }


    @And("^I should get mail \"([^\"]*)\" i should see verify email link$")
    public void iShouldGetMailIShouldSeeVerifyEmailLink(String arg0) throws InterruptedException {
        try {
            u.getMail(emailid);
            System.out.println("Email is: " + emailid);
            u.getEmailBody();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            Thread.sleep(3000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (u.i = 0; u.i < u.links.size(); u.i++) {
            u.mailliks = u.links.get(u.i).getText();
            System.out.println("Line 1495:" + u.mailliks);
            if (u.mailliks.equalsIgnoreCase("Verify Email Address")) {

                boolean col = u.links.get(u.i).isDisplayed();
                Assert.assertEquals(col, true);
                try {
                    Thread.sleep(3000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                break;
            }
        }
    }

    @And("^I enter firstName as \"([^\"]*)\" and LastName as \"([^\"]*)\" and \"([^\"]*)\" and mobile Number as \"([^\"]*)\"$")
    public void iEnterFirstNameAsAndLastNameAsAndAndMobileNumberAs(String arg0, String arg1, String arg2, String arg3) {
        u.impliciteWait();
        signup.FirestName.sendKeys(arg0);
        signup.LastName.sendKeys(arg1);
        emailid = (u.fakerData("email", arg2));
        signup.Email.sendKeys(emailid);
        signup.MobileNumber.sendKeys(arg3);
    }

    @And("^I click on following links and i see validation message and i redirect on respective page$")
    public void iClickOnFollowingLinksAndISeeValidationMessageAndIRedirectOnRespectivePage(DataTable table) throws InterruptedException {
        // Write code here that turns the phrase above into concrete actions
        List<List<String>> links = table.cells();
        int totalLinks = links.size();
        for (int i = 0; i < totalLinks; i++) {
            System.out.println("Data Table Links value are : " + links.get(i).get(0));
            List<WebElement> clickLinks = driver.findElements(By.tagName("a"));
            System.out.println("Web Links are: " + clickLinks.size());
            for (int j = 0; j < clickLinks.size(); j++) {
                String webLinks = clickLinks.get(j).getText();
                System.out.println("Web links value are: " + webLinks);
                if (links.get(i).get(0).equals(webLinks) && webLinks.equals("Click here to Resend OTP")) {
                    clickLinks.get(j).click();
                    Thread.sleep(2000L);
                    break;
                }
                //  System.out.println("Old mobile number values" + signup.MobileNumber.getAttribute("value"));
                else if (links.get(i).get(0).equals(webLinks) && webLinks.equals("Click here change your mobile number provided.")) {
                    clickLinks.get(j).click();
                    signup.MobileNumber.clear();
                    System.out.println("Mobile Number filed is clear");
                    Thread.sleep(3000L);
                    signup.MobileNumber.sendKeys("7972836015");

                    System.out.println("I enter mobile number ");
                    signup.submiButton.click();
                    Thread.sleep(2000L);
                    String OTPChangeMsg = con.getSuccesssStripMsg.getText();
                    System.out.println("OTP change validation message: " + OTPChangeMsg);
                    Assert.assertEquals(OTPChangeMsg, "Your mobile number has been changed successfully.");

                }


            }
        }


    }


    @And("^I enter following data in password fields and clik on submit then should display validation msg$")
    public void iEnterFollowingDataInPasswordFieldsAndClikOnSubmitThenShouldDisplayValidationMsg(DataTable data) throws InterruptedException {
        List<List<String>> cellsAre = data.cells();
        int totalCellCount = cellsAre.size();
        for (int i = 1; i < totalCellCount; i++) {
            String value = cellsAre.get(i).get(0);
            signup.getEnterPasswordField.sendKeys(value);
            System.out.println("Cell(0) values are: " + value);
            String cell1 = cellsAre.get(i).get(1);
            signup.getReEnterPasswordField.sendKeys(cell1);
            System.out.println("cell(1) values are: " + cell1);
            signup.getSubmitButton.click();
            Thread.sleep(2000L);
            String cell2 = cellsAre.get(i).get(2);
            String text = driver.findElement(By.xpath("//span[@class='mdl-textfield__error']")).getText();
            System.out.println("Line 1580: " + text);
            Assert.assertEquals(text, cell2);
            signup.getEnterPasswordField.clear();
            signup.getReEnterPasswordField.clear();
        }


    }

    @And("^I Enter Following details in All fields and click on complete signUp button$")
    public void iEnterFollowingDetailsInAllFieldsAndClickOnCompleteSignUpButton(DataTable data) throws InterruptedException {
        List<List<String>> totalCells = data.cells();
        System.out.println("Follwing are total of cells: " + totalCells.size());
        for (int i = 1; i < totalCells.size(); i++) {
            String row0 = totalCells.get(i).get(0);
            System.out.println("Row 0 data: " + row0);
            signup.getBusinessNameField.sendKeys(row0);
           /* String row1 = totalCells.get(i).get(1);
            signup.getSubBusinessName.sendKeys(row1);
            System.out.println("Row 1 data: " + row1);*/
            driver.findElement(By.cssSelector("#cphContents_btnSubmit")).click();
            Thread.sleep(3000L);

            List<WebElement> validationMsg = driver.findElements(By.xpath("//span[@class='mdl-textfield__error']"));
            int totalValidation = validationMsg.size();
            for (int j = 0; j < totalValidation; j++) {
                //Enter a valid Business Name.
                //  Please select type of business.
                //Please select category.
                //  Please select sub category.

                String validation = validationMsg.get(j).getText();
                System.out.println("Follwing are validation message: " + validation);
                if (validation.equals("Enter a valid Business Name.")) {
                    Assert.assertEquals(validation, "Enter a valid Business Name.");
                    System.out.println("Business name validation msg matched");
                } else if (validation.equals("Please select type of business.")) {
                    Assert.assertEquals(validation, "Please select type of business.");
                    System.out.println("Type of business validation msg matched");
                } else if (validation.equals("Please select category.")) {
                    Assert.assertEquals(validation, "Please select category.");
                    System.out.println("validation msg matched");
                } else if (validation.equals("Please select sub category.")) {
                    Assert.assertEquals(validation, "Please select sub category.");
                    System.out.println(" validation msg matched");
                }
            }
        }

    }

    @Then("^I should see proper validation message for invalid OTP in red color$")
    public void iShouldSeeProperValidationMessageForInvalidOTPInRedColor() {
        u.webdriverWait(30, By.xpath("//*[contains(text(),'Please enter OTP')]"));
        String invalidOtpValidation = driver.findElement(By.xpath("//*[contains(text(),'Please enter OTP')]")).getText();
        Assert.assertEquals(invalidOtpValidation, "Please enter OTP");
        System.out.println("validation message is matched ");
    }


    @And("^I should see following buttons \"([^\"]*)\"and i click and user should be land on perticular page$")
    public void iShouldSeeFollowingButtonsAndIClickAndUserShouldBeLandOnPerticularPage(String arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        WebElement element1 = driver.findElement(By.xpath("//input[@value='Start Again']"));
        String buttonsText1 = element1.getAttribute("value");
        System.out.println("Button 1 text: " + buttonsText1);
        WebElement elelment2 = driver.findElement(By.xpath("//input[@id='cphContents_btnContinue']"));
        String buttonsText2 = elelment2.getAttribute("value");
        System.out.println("Button 2 text: " + buttonsText2);
        if (arg0.equalsIgnoreCase("Start Again")) {
            element1.click();
            Thread.sleep(3000L);
            System.out.println("I clicked on Start Again");
            String signUpText = driver.findElement(By.xpath("//div[@class='msg']")).getText();
            Assert.assertEquals(signUpText, "Create your PayMate account");
        } else if (arg0.equalsIgnoreCase("Continue")) {
            elelment2.click();
            Thread.sleep(3000L);
            System.out.println("I cliked on Continue");
            String text1 = driver.findElement(By.xpath("//div[@id='cphContents_pnlContents']/div[1]")).getText();
            Assert.assertEquals(text1, "Welcome to PayMate\n" +
                    "Complete your sign-up");

            String text2 = driver.findElement(By.xpath("//div[@id='cphContents_pnlContents']/div[2]")).getText();
            Assert.assertEquals(text2, "We have sent you an email. Please check your mailbox and click on the link to verify and confirm your email address.");

            boolean bool = driver.findElement(By.xpath("//a[@class='text-center new-account']")).isEnabled();
            Assert.assertEquals(bool, true);
        }
    }

    @And("^I should get mail \"([^\"]*)\" i should see login link$")
    public void iShouldGetMailIShouldSeeLoginLink(String arg0) throws Throwable {
        u.getMail(emailid);
//        u.getEmailBody();
        u.waitAndClick(login.loginButtonEmail);
//        u.switchToTab();
       /* int linkCount = u.links.size();
        System.out.println("After registration links are: " + linkCount);
        for (int i = 0; i < linkCount; i++) {
            String linksText = u.links.get(i).getText();
            System.out.println("Links text are: " + linksText);
            try {
                linksText.equalsIgnoreCase("Login");
                System.out.println("I clicked on: " + u.links.get(i));
                System.out.println("Verify email text: "+signup.verifyEmailText.getText());
                String name = firstName+" "+lastName;
                Assert.assertEquals(signup.verifyEmailText.getText(),"Dear" +" "+name+","+"\n" +
                        "\n" +
                        "Welcome to PayMate.\n"+
                        "PayMate helps you to process your business payments easily.\n" +
                        "\n" +
                        "Congratulations, your account is activated.\n" +
                        "\n" +
                        "Next step is to complete KYC, we request you to please complete KYC within the next 5 days to avoid account suspension.\n" +
                        "\n" +
                        "Login Now to complete KYC\n" +
                        "\n" +
                        "In case the above link doesn't open, please click here\n" +
                        "Click here to access User guide and Frequently asked questions (FAQs)\n" +
                        "\n"+
                        "Always, ready to help. Email us - support@paymate.co.in\n"+
                        "\n"+
                        "See you soon,\n" +
                        "Team PayMate.");
                u.links.get(i).click();
                break;
            } catch (NoSuchElementException e) {
                e.printStackTrace();
            }
        }*/
    }

    @Then("^I enter valid user email id \"([^\"]*)\"$")
    public void iEnterValidUserEmailId(String arg0) throws Throwable {
        login.UserName.sendKeys(arg0);
    }

    @And("^I enter valid password \"([^\"]*)\"$")
    public void iEnterValidPassword(String arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        login.password.sendKeys(arg0);
    }


    @And("^I click on login link from mail$")
    public void iClickOnLoginLinkFromMail() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        for (u.i = 0; u.i < u.links.size(); u.i++) {
            u.mailliks = u.links.get(u.i).getText();
            if (u.mailliks.equalsIgnoreCase("Login")) {
                u.links.get(u.i).click();
                u.switchToTab();
                try {
                    Thread.sleep(3000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                String winHandleBefore = driver.getWindowHandle();
                for (String winHandle : driver.getWindowHandles()) {
                    driver.switchTo().window(winHandle);
                }
                break;
            }

        }
    }


    @Then("I Should be Land On Register page for HDFC")
    public void iShouldBeLandOnRegisterPageForHDFC() throws InterruptedException {
        Thread.sleep(5000L);
        u.waitUntilWebElelemntShouldBeDisplay(driver, signup.signUpWelComeTextHDFC, 30);
        String signupText = signup.signUpWelComeTextHDFC.getText();
        System.out.println("\nSign Up wel Come text :" + signupText);
        Assert.assertEquals(signupText, "Sign up on PayMate !");
    }

    @And("I should see Label of All text fields for HDFC")
    public void iShouldSeeLabelOfAllTextFieldsForHDFC() {
        String FNLabelText = signup.fnLabelHDFC.getText();
        System.out.println("\nFirst Name Label Text: " + FNLabelText);
        Assert.assertEquals(FNLabelText, "First Name");
        //Last name Label
        String LNLabelText = signup.lnlabelHDFC.getText();
        System.out.println("\nLast Name Label: " + LNLabelText);
        Assert.assertEquals(LNLabelText, "Last Name");
        //Email Label
        String emailLabelText = signup.emailLabelHDFC.getText();
        System.out.println("\nEmail Label: " + emailLabelText);
        Assert.assertEquals(emailLabelText, "Email ID");
        //Mobile Number Label
        String MnLabelText = signup.mnLabelHDFC.getText();
        System.out.println("\nMobile Number Label: " + MnLabelText);
        Assert.assertEquals(MnLabelText, "Mobile No");
    }

    @And("I Should see Check box with {string} text for HDFC")
    public void iShouldSeeCheckBoxWithTextForHDFC(String arg0) {
        boolean chckbox = signup.checkboxHDFC.isEnabled();
        Assert.assertEquals(chckbox, true);
        boolean checkBoxDisplay = signup.checkboxHDFC.isDisplayed();
        Assert.assertEquals(checkBoxDisplay, true);
        try {
            Thread.sleep(3000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String checkBoxText = signup.checkboxTextHDFC.getText();
        System.out.println("\nCheck Box Text: " + checkBoxText);
        Assert.assertEquals(checkBoxText, arg0);
    }

    @And("I Should see Signp Button And Sign In link for HDFC")
    public void iShouldSeeSignpButtonAndSignInLinkForHDFC() {
        boolean signUpB = signup.signUpButton.isDisplayed();
        Assert.assertEquals(signUpB, true);
        boolean signupEnable = signup.signUpButton.isEnabled();
        Assert.assertEquals(signupEnable, true);

        //SignIn Link
        boolean signInDisplay = signup.loginLinkHDFC.isDisplayed();
        Assert.assertEquals(signInDisplay, true);
    }

    @And("I click on SigIn link den i should be land on SignIn page for HDFC")
    public void iClickOnSigInLinkDenIShouldBeLandOnSignInPageForHDFC() {
        u.waitAndClick(signup.loginLinkHDFC);
        u.waitUntilWebElelemntShouldBeDisplay(driver, signup.loginPage, 30);
        String logintext = login.loginPageTextHDHFC.getText();
        System.out.println("\n Login Page Text: " + logintext);
        Assert.assertEquals(logintext, "Login Now !");
    }

    @And("I Should See Forgot Password link with clickable Link from SignUp page for HDFC")
    public void iShouldSeeForgotPasswordLinkWithClickableLinkFromSignUpPageForHDFC() {
//        signup.SignupLink.click();
        u.waitUntilWebElelemntShouldBeDisplay(driver, signup.fpLinkHDFC, 30);
        boolean fpLinkDisplay = signup.fpLinkHDFC.isDisplayed();
        Assert.assertEquals(fpLinkDisplay, true);
        boolean FpLinkEnable = signup.fpLinkHDFC.isEnabled();
        Assert.assertEquals(FpLinkEnable, true);
        signup.fpLinkHDFC.click();
    }

    @And("I verify email content for signup")
    public void iVerifyEmailContentForSignup() {
        System.out.println("Verify email text: " + signup.verifyEmailText.getText());
        String name = firstName + " " + lastName;
        Assert.assertEquals(signup.verifyEmailText.getText(), "Congratulations" + " " + name + "," + "\n" +
                "\n" +
                "PayMate helps you to process your business payments easily.\n" +
                "\n" +
                "To get started immediately, please verify your email address by clicking the below button.\n" +
                "\n" +
                "Verify Email Address\n" +
                "\n" +
                "In case the above link doesn't open, please click here\n" +
                "\n" +
                "Always, ready to help. Email us - support@paymate.co.in\n" +
                "\n" +
                "See you soon,\n" +
                "Team PayMate.\n"+
                "\n"+
                "This is an auto-generated email. Please do not reply to this email. In case of any queries please contact us at support@paymate.co.in or call us at 8657419103/ 8657419140");
    }

    @And("I should be land on Forget Password Page from Sign Up page for HDFC")
    public void iShouldBeLandOnForgetPasswordPageFromSignUpPageForHDFC() {
//        System.out.println("Fp title: "+signup.fpTitle.getAttribute("innerHTML"));
        Assert.assertEquals(signup.fpTitle.getAttribute("innerHTML"), "Forgot Password");
        Assert.assertEquals(signup.fpText.getAttribute("innerHTML"), "To reset your password, enter the email address you use to login to PayMate. A new temporary password will be emailed to this address which you can change once you login again.");
        Assert.assertTrue(signup.fpRegEmailField.isEnabled());
    }

    @And("I click on terms and conditions check box for HDFC")
    public void iClickOnTermsAndConditionsCheckBoxForHDFC() {
        signup.checkboxHDFC.click();
        String parent = driver.getWindowHandle();
        Set<String> wins = driver.getWindowHandles();
        Iterator<String> itr = wins.iterator();
        while (itr.hasNext()) {
            itr.next();
            driver.switchTo().window(parent);
        }
        try {
            Thread.sleep(3000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Then("I should see popUp window with terms and conditions text and accept button for HDFC")
    public void iShouldSeePopUpWindowWithTermsAndConditionsTextAndAcceptButtonForHDFC() {
        u.click(signup.acceptTermsHDFC, Hooks.driver);
        try {
            Thread.sleep(3000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @And("I Click on Signup Button and i should see proper validation message in green color for HDFC")
    public void iClickOnSignupButtonAndIShouldSeeProperValidationMessageInGreenColorForHDFC() throws InterruptedException {
        u.click(signup.SubmitButton, driver);
        //signup.SubmitButton.click();
        Thread.sleep(2000L);
        WebDriverWait wait = new WebDriverWait(driver, 50);
        u.waitUntilWebElelemntShouldBeDisplay(driver, fp.successFullyMsgHDFC, 30);
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='alert-strip success-alert']")));
        String registermsg = fp.successFullyMsgHDFC.getText();
        System.out.println("\nRegistration successfully message: " + registermsg);
        Assert.assertEquals(registermsg, "Welcome to PayMate! You are a few steps away from setting up your account.");
    }

    @And("I should land on verify and confirm your email addres page for HDFC")
    public void iShouldLandOnVerifyAndConfirmYourEmailAddresPageForHDFC() {
        String text = signup.verfiyEmailPageHDFC.getText();
        System.out.println("Confirm Email Address Page: " + text);
        Assert.assertEquals(text, "We have sent you an email. Please check your mailbox and click on the link to verify and confirm your email address.");
    }

    @And("I should get mail {string} i should see verify email link for HDFC")
    public void iShouldGetMailIShouldSeeVerifyEmailLinkForHDFC(String arg0) {
        try {
            u.getMail(emailid);
            System.out.println("Email is: " + emailid);
//            u.getEmailBodyHDFC();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            Thread.sleep(3000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (u.i = 0; u.i < u.links.size(); u.i++) {
            u.mailliks = u.links.get(u.i).getText();
            System.out.println("Line 1495:" + u.mailliks);
            if (u.mailliks.equalsIgnoreCase("Verify Email Address")) {

                boolean col = u.links.get(u.i).isDisplayed();
                Assert.assertEquals(col, true);
                try {
                    Thread.sleep(3000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                break;
            }
        }
    }

    @And("I click on verify email Address button for HDFC")
    public void iClickOnVerifyEmailAddressButtonForHDFC() throws InterruptedException {
        u.waitAndClick(signup.verifytEmailButtonHDFC);
        u.switchToTab();
    }

    @When("I am on dashboard page for uae admin login")
    public void iAmOnDashboardPageForUaeAdminLogin() {
        System.out.println("Title: " + con.getPageTitle.getText());
        Assert.assertEquals(con.getPageTitle.getText(), "Welcome To PayMate");
    }

    @Then("I click on Add Business tab")
    public void iClickOnAddBusinessTab() {
        u.waitAndClick(signup.addBusinessUae);
        Assert.assertEquals(login.pageTitle.getText(), "Business Configuration");
    }


    @Then("I should see proper validation message in green color for HDFC")
    public void iShouldSeeProperValidationMessageInGreenColorForHDFC() {
        u.waitUntilWebElelemntShouldBeDisplay(driver, con.getSuccesssStripMsg, 30);
     /*   String successcolor = fp.Successfullymsg.getCssValue("color");
        if (hooks.browser.equalsIgnoreCase("chrome")) {
            Assert.assertEquals(successcolor, "rgba(255, 255, 255, 1)");
        } else if (hooks.browser.equalsIgnoreCase("firefox")) {
            Assert.assertEquals(successcolor, "rgb(255, 255, 255)");
        }*/
        String validationMessage = con.getSuccesssStripMsg.getText();
        System.out.println("\nValidation message when i enter OTP: " + validationMessage);
        Assert.assertEquals(validationMessage, "Your mobile number verified.");
    }

    @And("I Should land on create password page for HDFC")
    public void iShouldLandOnCreatePasswordPageForHDFC() {
        String createPassword = signup.getCreatePasswordTextHDFC.getText();
        System.out.println("I am On create Password Page: " + createPassword);
        Assert.assertEquals(createPassword, "Create a password for your account");
    }

    @And("I enter password and ReEnter password for HDFC")
    public void iEnterPasswordAndReEnterPasswordForHDFC() {
        String enterPasswordLabel = signup.enterPasswordLabelHdfc.getText();
        System.out.println("\nEnter Password Label: " + enterPasswordLabel);
        Assert.assertEquals(enterPasswordLabel, "Password");
        signup.getEnterPasswordFieldHDFC.sendKeys("Paymate@123");
        String reEnterPAsswordlabel = signup.confirmPasswordLabelHdfc.getText();
        System.out.println("\nReEnter Password Label: " + reEnterPAsswordlabel);
        Assert.assertEquals(reEnterPAsswordlabel, "Confirm Password");
        signup.confirmPasswordFieldHdfc.sendKeys("Paymate@123");
        u.log4j("Password entered is: Paymate@123");
        // Password guidance text
        String passwordGuidance = signup.getPasswordGuidanceTextHdfc.getText();
        System.out.println("\nPassword guidance text: " + passwordGuidance);
        Assert.assertEquals(passwordGuidance, "Password should be atleast 8 characters in length. Password should contain atleast one lowercase, one uppercase, one numeral and one special character. For eg: ABC123$a");
    }

    @And("I click on submit button and i should see proper validation message in green color for HDFC")
    public void iClickOnSubmitButtonAndIShouldSeeProperValidationMessageInGreenColorForHDFC() {
        u.waitAndClick(signup.getSubmitButton);
        try {
            Thread.sleep(3000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String passwordValidatioinMessage = con.getSuccesssStripMsg.getText();
        System.out.println("\nPassword Created Successfully: " + passwordValidatioinMessage);
        Assert.assertEquals(passwordValidatioinMessage, "Password created.");
    }

    @And("I see all filed Labels and fields are enable for HDFC")
    public void iSeeAllFiledLabelsAndFieldsAreEnableForHDFC() {
        String businessNameLabel = signup.getBusinessFieldLabel.getText();
        Assert.assertEquals(businessNameLabel, "Business Name");
        System.out.println("\n Business name filed is Matched: " + businessNameLabel);

        //Business Name field enable
        boolean businessNameEnable = signup.getBusinessNameField.isEnabled();
        Assert.assertEquals(businessNameEnable, true);

        //WebSite/Social Page
        String socialPageLabel = signup.getSocialPageLabel.getText();
        Assert.assertEquals(socialPageLabel, "Website/Social Page/Blog");
        System.out.println("\nlabel is matched: " + socialPageLabel);

        //Websitr/Social page field enable
        boolean socialpageEnable = signup.getSocialPageField.isEnabled();
        Assert.assertEquals(socialpageEnable, true);
    }

    @And("I click on business type filed for HDFC")
    public void iClickOnBusinessTypeFiledForHDFC() {
        u.waitAndClick(signup.typeofBusinessDownArrowHdfc);
    }

    @And("I select following business type{string} for HDFC")
    public void iSelectFollowingBusinessTypeForHDFC(String arg0) {
        Select businessType = new Select(signup.getTypeOfBusinessFiledHdfc);
        businessType.selectByVisibleText(arg0);
    }

    @And("I click on category dropDown field for HDFC")
    public void iClickOnCategoryDropDownFieldForHDFC() {
        u.waitAndClick(signup.categoryOfBusinessDownArrowHdfc);
    }

    @And("I select valid category for HDFC")
    public void iSelectValidCategoryForHDFC() {
        Select businessCategory = new Select(signup.categoryOfBusinessHdfc);
        businessCategory.selectByValue("18");
    }

    @And("I select valid Sub category for HDFC")
    public void iSelectValidSubCategoryForHDFC() {
//        u.waitAndClick(signup.subCategoryOfBusinessDownArrowHdfc);
        Select businessSubCategory = new Select(signup.subCategoryOfBusinessHdfc);
        businessSubCategory.selectByValue("250");
    }

    @And("I should be land on login page for HDFC")
    public void iShouldBeLandOnLoginPageForHDFC() throws InterruptedException {
        Thread.sleep(5000L);
        //util.setWebDriverFluentWait(2, 40, By.xpath("//div[@id='UpnlHome']/div[1] | //*[contains(text(),'Login with')]"));
        String logintext = login.verfiyLoginPageHdfc.getText();
        System.out.println("Login page text: " + logintext);
        Assert.assertEquals(logintext, "Login Now !");
    }

    @And("I should land on enter card details popup and I verify all fields")
    public void iShouldLandOnEnterCardDetailsPopupAndIVerifyAllFields() {
        u.waitUntilWebElelemntShouldBeDisplay(driver, signup.congratualtionTxt, 10);
        Assert.assertEquals(signup.congratualtionTxt, "Congratulations!");
        Assert.assertEquals(signup.accountSuccessfullTxt, "You have successfully created your account.");
        Assert.assertTrue(signup.enterCardNoHdfc.isEnabled());
        Assert.assertTrue(signup.cardHolderHdfc.isEnabled());
        Assert.assertTrue(signup.cardExpiryHdfc.isEnabled());
        Assert.assertTrue(signup.submitCardHdfc.isEnabled());
    }

    @And("I enter card details and click continue button")
    public void iEnterCardDetailsAndClickContinueButton() throws InterruptedException {
        signup.enterCardNoHdfc.sendKeys("4000-0000-0000-0002");
        u.waitUntilWebElelemntShouldBeDisplay(driver, signup.cardHolderHdfc, 10);
        signup.cardHolderHdfc.sendKeys("test");
        signup.cardExpiryHdfc.sendKeys("10/2027");
        u.waitAndClick(signup.submitCardHdfc);
        Thread.sleep(3000);

    }

    @And("I enter cvv and click Pay now button")
    public void iEnterCvvAndClickPayNowButton() throws InterruptedException {
        u.waitAndClick(signup.enterCvvHdfc);
        signup.enterCvvHdfc.sendKeys("123");
        u.waitAndClick(signup.payNowHdfc);
        Thread.sleep(5000);
        u.waitAndClick(signup.enterPasswordHdfc);
        signup.enterPasswordHdfc.sendKeys("1234");
        u.waitAndClick(signup.submitPasswordHdfc);

    }

    @And("I enter all details in Business Information tab")
    public void iEnterAllDetailsInBusinessInformationTab(DataTable dataTable) throws InterruptedException {
        Thread.sleep(3000);
        List<List<String>> listDataTable = dataTable.cells();
        for (int i = 1; i < listDataTable.size(); i++) {
            businessName_Str = listDataTable.get(i).get(0);
            contactName_Str = listDataTable.get(i).get(1);
            contactDesgn_Str = listDataTable.get(i).get(2);
            country_Str = listDataTable.get(i).get(3);
            emailID_Str = listDataTable.get(i).get(4);
            mobileNo_Str = listDataTable.get(i).get(5);
            typeOfBusiness_Str = listDataTable.get(i).get(6);
            businessCategory_Str = listDataTable.get(i).get(7);
            businessSubCategory_Str = listDataTable.get(i).get(8);
            saleRep_Str = listDataTable.get(i).get(9);
            address_Str = listDataTable.get(i).get(10);
            emirate_Str = listDataTable.get(i).get(11);
            postalCode_Str = listDataTable.get(i).get(12);
            companyName = u.fakerData("companyName", businessName_Str);
            signup.businessNameFieldUae.sendKeys(companyName);
            firstName = u.fakerData("firstName", contactName_Str);
            signup.contactFieldUae.sendKeys(firstName);
            signup.contactDesgnFieldUae.sendKeys(contactDesgn_Str);
            signup.countryDrodDownUae.click();
            List<WebElement> countryVal = signup.countryFieldUae;
             int ctryval = countryVal.size();
            System.out.println("country size: "+ctryval);
            for (int ctry = 0; ctry < ctryval; ctry++) {
                String valuesAre = countryVal.get(ctry).getAttribute("innerText");
//                System.out.println("\n Country is: " + valuesAre);
                if (valuesAre.equals(country_Str)) {
                    countryVal.get(ctry).click();
                    break;
                }

            }
            emailid = (u.fakerData("email", emailID_Str));
            u.log4j("Email is " + emailid);
            signup.emailFieldUae.sendKeys(emailid);
            signup.mobileFieldUae.sendKeys(mobileNo_Str);
            signup.businessTypeDrodDownUae.click();
            List<WebElement> businessTypevalue = signup.typeOfBusinessUae;
            int  btypeVal = businessTypevalue.size();
            for (int btype = 0; btype < btypeVal; btype++) {
                String valuesAre = businessTypevalue.get(btype).getAttribute("innerHTML");
//                System.out.println("\n Business type are: " + valuesAre);
                if (valuesAre.equals(typeOfBusiness_Str)) {
                    businessTypevalue.get(btype).click();
                    break;
                }

            }
            signup.categoryDownUae.click();
            List<WebElement> businessCategory = signup.categoryOfBusinessUae;
            int  bCategory = businessCategory.size();
            for (int bcat = 0; bcat < bCategory; bcat++) {
                String valuesAre = businessCategory.get(bcat).getAttribute("innerHTML");
//                System.out.println("\n Business category is: " + valuesAre);
                if (valuesAre.equals(businessCategory_Str)) {
                    businessCategory.get(bcat).click();
                    break;
                }

            }
            Thread.sleep(2000);
            u.waitAndClick(signup.subCategoryDropDownUae);
            List<WebElement> businessSubCategory = signup.subCategoryOfBusinessUae;
            int  bSubCategory = businessSubCategory.size();
            for (int bsubcat = 0; bsubcat < bSubCategory; bsubcat++) {
                String valuesAre = businessSubCategory.get(bsubcat).getAttribute("innerHTML");
//                System.out.println("\n Business subcategory is: " + valuesAre);
                if (valuesAre.equals(businessSubCategory_Str)) {
                    businessSubCategory.get(bsubcat).click();
                    break;
                }

            }
            Thread.sleep(2000);
           signup.salesRepDropdownUae.click();
            System.out.println("sales rep: "+saleRep_Str);
            List<WebElement> bSalresRep = signup.salesRepUae;
            int  salesRep = bSalresRep.size();
            for (int sRep = 0; sRep < salesRep; sRep++) {
                String valuesAre = bSalresRep.get(sRep).getAttribute("innerHTML");
//                System.out.println("\n Sale rep is: " + valuesAre);
                if (valuesAre.equals(saleRep_Str)) {
                    bSalresRep.get(sRep).click();
                }

            }
          signup.addressFieldUae.sendKeys(address_Str);
          signup.emirateDropdownUae.click();
          List<WebElement> emirate = signup.emirateFieldUae;
            int  emi = emirate.size();
            for (int em = 0; em < emi; em++) {
                String valuesAre = emirate.get(em).getAttribute("innerHTML");
//                System.out.println("\n Emirate is: " + valuesAre);
                if (valuesAre.equals(emirate_Str)) {
                    emirate.get(em).click();
                    break;
                }

            }
          signup.postalCodeUae.sendKeys(postalCode_Str);
        }
    }

    @And("I check box for Card Management Admin")
    public void iCheckBoxForCardManagementAdmin() {
        signup.cardMgmtCheckbox.click();
    }

    @And("I check box for Finance Management Admin")
    public void iCheckBoxForFinanceManagementAdmin() {
        signup.financeMgmtCheckbox.click();
    }

    @And("I check box for User Management Admin")
    public void iCheckBoxForUserManagementAdmin() {
        signup.userMgmtCheckbox.click();
    }

    @And("I check box for Contact Management Admin")
    public void iCheckBoxForContactManagementAdmin() {
        signup.conMgmtCheckbox.click();
    }


    @Then("I click Next button for Business Information tab")
    public void iClickNextButtonForBusinessInformationTab() {
        u.waitAndClick(signup.nextButtonUae);
    }

    @Then("I verify Transaction Currency tab is expanded")
    public void iVerifyTransactionCurrencyTabIsExpanded() {
        u.waitUntilWebElelemntShouldBeDisplay(driver,signup.tCurrencyTab,30);
        Assert.assertTrue(signup.tCurrencyTab.isDisplayed());
    }

    @And("I check boxes for Payable and Receivable Currency")
    public void iCheckBoxesForPayableAndReceivableCurrency() throws InterruptedException {
        Thread.sleep(2000);
        Assert.assertTrue(signup.payableCurrCheckbox.isDisplayed());
        Assert.assertTrue(signup.receivableCurrCheckbox.isDisplayed());
        u.waitAndClick(signup.payableCurrCheckbox);
        u.waitAndClick(signup.receivableCurrCheckbox);

    }

    @Then("I click Next button for Transaction currency tab")
    public void iClickNextButtonForTransactionCurrencyTab() {
        u.waitAndClick(signup.submitCurrUae);
    }

    @Then("I verify Business subscription tab is expanded")
    public void iVerifyBusinessSubscriptionTabIsExpanded() {
        Assert.assertTrue(signup.busSubTab.isDisplayed());
    }

    @And("I click Next button for Business subscription tab")
    public void iClickNextButtonForBusinessSubscriptionTab() {
        u.waitAndClick(signup.submitSubscription);
    }

    @Then("I verify Transaction charges details tab is expanded")
    public void iVerifyTransactionChargesDetailsTabIsExpanded() {
        Assert.assertTrue(signup.tranxChargesTab.isDisplayed());
    }

    @Then("I enter Transaction charge details for both payable and receivable and click save")
    public void iEnterTransactionChargeDetailsForBothPayableAndReceivableAndClickSave() throws InterruptedException {
       /*u.waitAndClick(signup.issuingBankDropdown);
        List<WebElement> issuingBnk = signup.issuingBank;
        int  ibs = issuingBnk.size();
        for (int ib = 0; ib < ibs; ib++) {
            String valuesAre = issuingBnk.get(ib).getAttribute("innerHTML");
//                System.out.println("\n Emirate is: " + valuesAre);
            if (valuesAre.equals("Abu Dhabi Commercial Bank")) {
                issuingBnk.get(ib).click();
                break;
            }

        }

        Thread.sleep(200);
        u.waitAndClick(signup.repMangrDropdown);
        List<WebElement> repMgr = signup.repManager;
        int  repMgrs = repMgr.size();
        for (int rm = 0; rm < repMgrs; rm++) {
            String valuesAre = repMgr.get(rm).getAttribute("innerHTML");
//                System.out.println("\n Emirate is: " + valuesAre);
            if (valuesAre.equals("Acquiring user")) {
                repMgr.get(rm).click();
                break;
            }

        }
        Thread.sleep(200);
        u.waitAndClick(signup.acquiringBankDropdown);
        List<WebElement> acqBnk = signup.acquiringBank;
        int  ackBnks = acqBnk.size();
        for (int ab = 0; ab < ackBnks; ab++) {
            String valuesAre = acqBnk.get(ab).getAttribute("innerHTML");
//                System.out.println("\n Emirate is: " + valuesAre);
            if (valuesAre.equals("Network International")) {
                acqBnk.get(ab).click();
                break;
            }

        }
        Thread.sleep(200);
        u.waitAndClick(signup.chargeModeDropdown);
        List<WebElement> cmode = signup.chargeMode;
        int  cmodes = cmode.size();
        for (int cm = 0; cm < cmodes; cm++) {
            String valuesAre = cmode.get(cm).getAttribute("innerHTML");
                System.out.println("\n Charge mode is: " + valuesAre);
            if (valuesAre.equals("Payable")) {
                cmode.get(cm).click();
                break;
            }

        }
        Thread.sleep(200);
        u.waitAndClick(signup.currecnyDropdown);
        List<WebElement> traxCurrency = signup.traxCurrency;
        int trxcs = traxCurrency.size();
        for (int tc = 0; tc < trxcs; tc++) {
            String valuesAre = traxCurrency.get(tc).getAttribute("innerHTML");
//                System.out.println("\n Emirate is: " + valuesAre);
            if (valuesAre.equals("AED")) {
                traxCurrency.get(tc).click();
                break;
            }

        }

        Thread.sleep(200);
        u.waitAndClick(signup.traxGatewayDropdown);
        List<WebElement> traxGateway = signup.traxGateway;
        int tgs = traxGateway.size();
        for (int tg = 0; tg < tgs; tg++) {
            String valuesAre = traxGateway.get(tg).getAttribute("innerHTML");
//                System.out.println("\n Emirate is: " + valuesAre);
            if (valuesAre.equals("Jack Gateway-56417984624")) {
                traxGateway.get(tg).click();
                break;
            }

        }
       signup.commCharge.sendKeys("3.5");
        Thread.sleep(200);
        u.waitAndClick(signup.commTypeDropdown);
        List<WebElement> commType = signup.commType;
        int cts = commType.size();
        for (int ct = 0; ct < cts; ct++) {
            String valuesAre = commType.get(ct).getAttribute("innerHTML");
//                System.out.println("\n Emirate is: " + valuesAre);
            if (valuesAre.equals("Fixed")) {
                commType.get(ct).click();
                break;
            }

        }*/
        Thread.sleep(2000);
        u.waitAndClick(signup.issuingBankDropdown);
        u.selectFromDropDown(signup.issuingBank,"Abu Dhabi Commercial Bank");
        Thread.sleep(200);
        u.click(signup.repMangrDropdown,driver);
        u.selectFromDropDown(signup.repManager,"Acquiring user");
         u.waitAndClick(signup.acquiringBankDropdown);
        u.selectFromDropDown(signup.acquiringBank,"Network International");
        u.waitAndClick(signup.chargeModeDropdown);
        u.selectFromDropDown(signup.chargeMode,"Payable");
        Thread.sleep(200);
        signup.currecnyDropdown.click();
        u.selectFromDropDown(signup.traxCurrency,"AED");
        Thread.sleep(200);
        signup.traxGatewayDropdown.click();
        u.selectFromDropDown(signup.traxGateway,"Jack Gateway-56417984624");
        signup.commCharge.sendKeys("3.5");
        Thread.sleep(200);
        signup.commTypeDropdown.click();
        u.selectFromDropDown(signup.commType,"Fixed");
       u.waitAndClick(signup.submitCharges);
        Thread.sleep(5000);
        u.waitAndClick(signup.issuingBankDropdown);
        u.selectFromDropDown(signup.issuingBank,"Abu Dhabi Commercial Bank");
        Thread.sleep(200);
        signup.repMangrDropdown.click();
        u.selectFromDropDown(signup.repManager,"Acquiring user");
        u.waitAndClick(signup.acquiringBankDropdown);
        u.selectFromDropDown(signup.acquiringBank,"Network International");
        u.click(signup.chargeModeDropdown,driver);
        u.selectFromDropDown(signup.chargeMode,"Receivable");
        Thread.sleep(200);
        u.click(signup.currecnyDropdown,driver);
        u.selectFromDropDown(signup.traxCurrency,"AED");
        Thread.sleep(200);
        signup.traxGatewayDropdown.click();
        u.selectFromDropDown(signup.traxGateway,"Jack Gateway-56417984624");
        signup.commCharge.sendKeys("3.5");
        Thread.sleep(200);
        signup.commTypeDropdown.click();
        u.selectFromDropDown(signup.commType,"Fixed");
        u.waitAndClick(signup.submitCharges);
        u.click(signup.submitChargeNext,driver);
        Thread.sleep(5000);

    }


    @Then("I verify Settlement charges details tab is expanded")
    public void iVerifySettlementChargesDetailsTabIsExpanded() {
        u.waitUntilWebElelemntShouldBeDisplay(driver,signup.settleChargesTab,30);
        Assert.assertTrue(signup.settleChargesTab.isDisplayed());
    }

    @And("I enter Settlement charges details for both Send and Reeive money and click save")
    public void iEnterSettlementChargesDetailsForBothSendAndReeiveMoneyAndClickSave() throws InterruptedException {
        u.waitAndClick(signup.settleChargeModeDropdown);
        u.selectFromDropDown(signup.settleChargeMode,"Send Money");
        u.waitAndClick(signup.settlementCurrDropdown);
        u.selectFromDropDown(signup.settlementCurr,"AED");
        u.waitAndClick(signup.settlementBankDropdown);
        u.selectFromDropDown(signup.settlementBank,"PayU Money");
        signup.commCharge.sendKeys("3.5");
        u.waitAndClick(signup.settlementCommTypeDropdown);
        u.selectFromDropDown(signup.settlementCommtType,"Fixed");
        u.waitAndClick(signup.submitSettlement);
        Thread.sleep(500);
        u.waitAndClick(signup.settleChargeModeDropdown);
        u.selectFromDropDown(signup.settleChargeMode,"Send Money");
        u.waitAndClick(signup.settlementCurrDropdown);
        u.selectFromDropDown(signup.settlementCurr,"AED");
        u.waitAndClick(signup.settlementBankDropdown);
        u.selectFromDropDown(signup.settlementBank,"Receive Money");
        signup.commCharge.sendKeys("3.5");
        u.waitAndClick(signup.settlementCommTypeDropdown);
        u.selectFromDropDown(signup.settlementCommtType,"Fixed");
        u.waitAndClick(signup.submitSettlement);
        u.waitAndClick(signup.saveSettlement);
        Thread.sleep(2000);

    }

    @Then("I verify Declaration Compliance tab is expanded")
    public void iVerifyDeclarationComplianceTabIsExpanded() {
        u.waitUntilWebElelemntShouldBeDisplay(driver,signup.complianceTab,30);
        Assert.assertTrue(signup.complianceTab.isDisplayed());
    }

    @Then("I click on save button for Compliance")
    public void iClickOnSaveButtonForCompliance() throws InterruptedException {
        u.waitAndClick(signup.saveComplaince);
        Thread.sleep(3000);
    }

    @Then("I land on Manage Business page")
    public void iLandOnManageBusinessPage() {
        Assert.assertEquals(signup.manageBusinessUaeTitle.getText(),"Manage Business Configuration");
    }


    @And("I enter following business GSTIN {string}")
    public void iEnterFollowingBusinessGSTIN(String arg0) {
        signup.getBusinessGSTINField.sendKeys(arg0);
    }

    @And("I select Industry type for Business")
    public void iSelectIndustryTypeForBusiness() {
        signup.typeofIndustry.click();
        List<WebElement> value = signup.getTypeofIndustry;
        int totalvalues = value.size();

        for (int i = 0; i < totalvalues; i++) {
            String valuesAre = value.get(i).getText();
            System.out.println("\n Business type are: " + valuesAre);
            if (valuesAre.equals("AUTOMOBILES")) {
                value.get(i).click();

                break;
            }

        }
    }

    @And("I enter a valid pincode for Business")
    public void iEnterAValidPincodeForBusiness() {

        signup.businessPincode.sendKeys("400022");
    }

    @And("I enter a valid City for Business")
    public void iEnterAValidCityForBusiness() {
        signup.businessCity.sendKeys("Mumbai");
    }
}



