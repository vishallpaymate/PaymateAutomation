package step_definitions;

import baseClass.Environments;
import baseClass.Utils;
import baseClass.mainDriver;
import com.github.javafaker.Faker;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;
import org.omg.PortableServer.THREAD_POLICY_ID;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import pageFactory.Login_POM;
import pageFactory.addContact_POM;
import pageFactory.forgotPassword_POM;
import pageFactory.uploadKyc_POM;
import userData.loginData;

import java.awt.*;
import java.io.IOException;
import java.util.*;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class UploadKyc extends mainDriver {
    public String SignupPage;
    public Utils util = new Utils();
    public Login_POM login = new Login_POM(driver);
    public loginData data = new loginData();
    public forgotPassword_POM fp = new forgotPassword_POM(driver);
    public WebElement registerLoginLink;
    public WebElement forgotPasswordLink;
    public String linksText;
    public Faker faker = new Faker();
    public uploadKyc_POM kyc = new uploadKyc_POM(driver);
    public addContact_POM con = new addContact_POM(driver);
    String path = System.getProperty("user.dir");
    String filespath = path + "\\InvalidFiles\\test.pdf";

    @When("^I click on upload kyc link from \"([^\"]*)\"$")
    public void iClickOnUploadKycLinkFrom(String arg0) throws Throwable {
        util.log4j("I click on Dashboard menu");
        Thread.sleep(5000L);
        util.waitElementShouldBeClickable(con.dashBoardMenu);
        con.dashBoardMenu.click();
//        util.click(con.dashBoardMenu, driver);
        if (arg0.equals("Business Settings")) {
            Actions action = new Actions(driver);
            // action.moveToElement(kyc.businessSettings).click();
            action.moveToElement(kyc.getbusinessSettings, 132, 585);
            util.click(kyc.getbusinessSettings, driver);
            // kyc.getbusinessSettings.click();
            util.impliciteWait();
            util.sideBarScrollDown(kyc.getbusinessSettings);
            util.click(kyc.getuploadKyc, driver);

        }
    }

    @Then("^I should be land on upload documents page$")
    public void iShouldBeLandOnUploadDocumentsPage() throws Throwable {
        String kycUYpload = kyc.getkycTitle.getText();
        Assert.assertEquals(kycUYpload, "UPLOADED DOCUMENTS");
    }


    @And("^I see business type dropdown and select business type and i should see respective fields$")
    public void iSeeBusinessTypeDropdownAndSelectBusinessTypeAndIShouldSeeRespectiveFields(DataTable table) throws
            InterruptedException {

        List<List<String>> values = table.cells();
        for (int j = 0; j < values.size(); j++) {
            util.click(kyc.getDropDownClick, driver);
            String dataTable_Str = values.get(j).get(0);
            util.setWebDriverFluentWait(2, 30, By.xpath("//*[@name='ctl00$ContentPlaceHolder1$ddlBusinessType']/li"));
            List<WebElement> businessDropdown = kyc.getBusinessDropDownValues;
            for (int i = 0; i < businessDropdown.size(); i++) {
                //System.out.println("Web Data Table values are: " + businessDropdown.get(i).getText());
                String web_str = businessDropdown.get(i).getText();
                if (web_str.equals(dataTable_Str)) {
                    System.out.println("Selected business type is: " + businessDropdown.get(i).getText());
                    businessDropdown.get(i).click();
                    List<WebElement> e = driver.findElements(By.xpath("//*[@class='col-xs-12 col-sm-6']"));
                    System.out.println("Size is: " + e.size());
                    if (e.size() < 19) {
                        System.out.println("Documents not uploaded");
                        List<WebElement> ele1 = driver.findElements(By.xpath("//*[@class='mdl-textfield mdl-js-textfield mdl-textfield--floating-label is-upgraded']/input"));
                        for (int k = 0; k < ele1.size(); k++) {
                            WebElement loopData = ele1.get(k);
                            boolean display = loopData.isDisplayed();
                            Assert.assertEquals(display, true);
                            boolean enable = loopData.isEnabled();
                            Assert.assertEquals(enable, true);

                        }
                    } else {
                        System.out.println("Documents already uploaded");
                        List<WebElement> doc_uploaded = driver.findElements(By.xpath("//*[@class='col-xs-12 col-sm-6']/span"));
                        for (int k = 0; k < doc_uploaded.size(); k++) {
                            String uploaded_Data = doc_uploaded.get(k).getText();
                            System.out.println("Uploaded data is: " + uploaded_Data);
                        }
                    }
                }


                   /*else
                   {
                       List<WebElement> ele2 = driver.findElements(By.xpath("//*[@class='col-xs-12 col-sm-6']/span"));
                       for(int l=0;l<ele1.size();l++)
                       {
                           System.out.println(ele2.get(l).getText());
                       }
                   }*/
            }
        }
    }

    @And("^I select business type and i click on upload button then i should see validation msg in red color$")
    public void iSelectBusinessTypeAndIClickOnUploadButtonThenIShouldSeeValidationMsgInRedColor(DataTable table) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        List<List<String>> cell_Data = table.cells();
        for (int i = 0; i < cell_Data.size(); i++) {
            util.click(kyc.getDropDownClick, driver);
            String str_values = cell_Data.get(i).get(0);
            util.setWebDriverFluentWait(2, 30, By.xpath("//*[@name='ctl00$ContentPlaceHolder1$ddlBusinessType']/li"));
            List<WebElement> businessDropdown = kyc.getBusinessDropDownValues;
            for (int j = 0; j < businessDropdown.size(); j++) {
                String str1 = businessDropdown.get(j).getText();
                if (cell_Data.get(i).get(0).equals(businessDropdown.get(j).getText())) {

                    System.out.println("Selected bdrop down value is: " + businessDropdown.get(j).getText());
                    businessDropdown.get(j).click();
                    List<WebElement> e = driver.findElements(By.xpath("//*[@class='col-xs-12 col-sm-6']"));
                    System.out.println("Size is: " + e.size());
                    if (e.size() < 19) {
                        System.out.println("Documents is not uploaded");
                        util.click(kyc.getUploadButton, driver);
                        Thread.sleep(2000);
                        if (str1.equals("Individuals")) {
                            List<WebElement> error_str = driver.findElements(By.xpath("//*[@class='mdl-textfield__error']"));
                            for (int k = 0; k < error_str.size(); k++) {
                                String error_color = error_str.get(k).getCssValue("color");
                                System.out.println("Error color is: " + error_color);
                                String error_Msg = error_str.get(k).getText();

                                switch (error_Msg) {
                                    case "Please enter name as on card.":
                                        Assert.assertEquals(error_Msg, "Please enter name as on card.");
                                        if (error_color.equals("rgb(213, 0, 0)")) {
                                            Assert.assertEquals(error_color, "rgb(213, 0, 0)");
                                        } else {
                                            Assert.assertEquals(error_color, "rgba(213, 0, 0, 1)");
                                        }
                                        break;
                                    case "Please enter pan number.":
                                        Assert.assertEquals(error_Msg, "Please enter pan number.");
                                        if (error_color.equals("rgb(213, 0, 0)")) {
                                            Assert.assertEquals(error_color, "rgb(213, 0, 0)");
                                        } else {
                                            Assert.assertEquals(error_color, "rgba(213, 0, 0, 1)");
                                        }
                                        break;

                                    case "Please enter address.":
                                        Assert.assertEquals(error_Msg, "Please enter address.");
                                        if (error_color.equals("rgb(213, 0, 0)")) {
                                            Assert.assertEquals(error_color, "rgb(213, 0, 0)");
                                        } else {
                                            Assert.assertEquals(error_color, "rgba(213, 0, 0, 1)");
                                        }
                                        break;
                                    case "Please enter city.":
                                        Assert.assertEquals(error_Msg, "Please enter city.");
                                        if (error_color.equals("rgb(213, 0, 0)")) {
                                            Assert.assertEquals(error_color, "rgb(213, 0, 0)");
                                        } else {
                                            Assert.assertEquals(error_color, "rgba(213, 0, 0, 1)");
                                        }
                                        break;
                                    case "Please select state.":
                                        Assert.assertEquals(error_Msg, "Please select state.");
                                        if (error_color.equals("rgb(213, 0, 0)")) {
                                            Assert.assertEquals(error_color, "rgb(213, 0, 0)");
                                        } else {
                                            Assert.assertEquals(error_color, "rgba(213, 0, 0, 1)");
                                        }
                                        break;
                                    case "Please enter pin code.":
                                        Assert.assertEquals(error_Msg, "Please enter pin code.");
                                        if (error_color.equals("rgb(213, 0, 0)")) {
                                            Assert.assertEquals(error_color, "rgb(213, 0, 0)");
                                        } else {
                                            Assert.assertEquals(error_color, "rgba(213, 0, 0, 1)");
                                        }
                                        break;


                                }
                            }
                        } else if (str1.equals("Companies")) {
                            List<WebElement> error_str = driver.findElements(By.xpath("//*[@class='mdl-textfield__error']"));
                            for (int k = 0; k < error_str.size(); k++) {
                                String error_color = error_str.get(k).getCssValue("color");
                                System.out.println("Error color is: " + error_color);
                                String error_Msg = error_str.get(k).getText();

                                switch (error_Msg) {
                                    case "Please enter name as on card.":
                                        Assert.assertEquals(error_Msg, "Please enter name as on card.");
                                        if (error_color.equals("rgb(213, 0, 0)")) {
                                            Assert.assertEquals(error_color, "rgb(213, 0, 0)");
                                        } else {
                                            Assert.assertEquals(error_color, "rgba(213, 0, 0, 1)");
                                        }
                                        break;
                                    case "Please enter pan number.":
                                        Assert.assertEquals(error_Msg, "Please enter pan number.");
                                        if (error_color.equals("rgb(213, 0, 0)")) {
                                            Assert.assertEquals(error_color, "rgb(213, 0, 0)");
                                        } else {
                                            Assert.assertEquals(error_color, "rgba(213, 0, 0, 1)");
                                        }
                                        break;
                                    case "Please enter Company Identification Number.":
                                        Assert.assertEquals(error_Msg, "Please enter Company Identification Number.");
                                        if (error_color.equals("rgb(213, 0, 0)")) {
                                            Assert.assertEquals(error_color, "rgb(213, 0, 0)");
                                        } else {
                                            Assert.assertEquals(error_color, "rgba(213, 0, 0, 1)");
                                        }
                                        break;
                                    case "Please enter address.":
                                        Assert.assertEquals(error_Msg, "Please enter address.");
                                        if (error_color.equals("rgb(213, 0, 0)")) {
                                            Assert.assertEquals(error_color, "rgb(213, 0, 0)");
                                        } else {
                                            Assert.assertEquals(error_color, "rgba(213, 0, 0, 1)");
                                        }
                                        break;
                                    case "Please enter city.":
                                        Assert.assertEquals(error_Msg, "Please enter city.");
                                        break;
                                    case "Please select state.":
                                        Assert.assertEquals(error_Msg, "Please select state.");
                                        if (error_color.equals("rgb(213, 0, 0)")) {
                                            Assert.assertEquals(error_color, "rgb(213, 0, 0)");
                                        } else {
                                            Assert.assertEquals(error_color, "rgba(213, 0, 0, 1)");
                                        }
                                        break;
                                    case "Please enter pin code.":
                                        Assert.assertEquals(error_Msg, "Please enter pin code.");
                                        if (error_color.equals("rgb(213, 0, 0)")) {
                                            Assert.assertEquals(error_color, "rgb(213, 0, 0)");
                                        } else {
                                            Assert.assertEquals(error_color, "rgba(213, 0, 0, 1)");
                                        }
                                        break;
                                }
                            }
                        } else if (str1.equals("Partnership firms")) {
                            List<WebElement> error_str = driver.findElements(By.xpath("//*[@class='mdl-textfield__error']"));
                            for (int k = 0; k < error_str.size(); k++) {
                                String error_color = error_str.get(k).getCssValue("color");
                                System.out.println("Error color is: " + error_color);
                                String error_Msg = error_str.get(k).getText();

                                switch (error_Msg) {
                                    case "Please enter name as on card.":
                                        Assert.assertEquals(error_Msg, "Please enter name as on card.");
                                        if (error_color.equals("rgb(213, 0, 0)")) {
                                            Assert.assertEquals(error_color, "rgb(213, 0, 0)");
                                        } else {
                                            Assert.assertEquals(error_color, "rgba(213, 0, 0, 1)");
                                        }
                                        break;
                                    case "Please enter pan number.":
                                        Assert.assertEquals(error_Msg, "Please enter pan number.");
                                        if (error_color.equals("rgb(213, 0, 0)")) {
                                            Assert.assertEquals(error_color, "rgb(213, 0, 0)");
                                        } else {
                                            Assert.assertEquals(error_color, "rgba(213, 0, 0, 1)");
                                        }
                                        break;
                                    case "Please enter Company Identification Number.":
                                        Assert.assertEquals(error_Msg, "Please enter Company Identification Number.");
                                        if (error_color.equals("rgb(213, 0, 0)")) {
                                            Assert.assertEquals(error_color, "rgb(213, 0, 0)");
                                        } else {
                                            Assert.assertEquals(error_color, "rgba(213, 0, 0, 1)");
                                        }
                                        break;
                                    case "Please enter address.":
                                        Assert.assertEquals(error_Msg, "Please enter address.");
                                        if (error_color.equals("rgb(213, 0, 0)")) {
                                            Assert.assertEquals(error_color, "rgb(213, 0, 0)");
                                        } else {
                                            Assert.assertEquals(error_color, "rgba(213, 0, 0, 1)");
                                        }
                                        break;
                                    case "Please enter city.":
                                        Assert.assertEquals(error_Msg, "Please enter city.");
                                        break;
                                    case "Please select state.":
                                        Assert.assertEquals(error_Msg, "Please select state.");
                                        if (error_color.equals("rgb(213, 0, 0)")) {
                                            Assert.assertEquals(error_color, "rgb(213, 0, 0)");
                                        } else {
                                            Assert.assertEquals(error_color, "rgba(213, 0, 0, 1)");
                                        }
                                        break;
                                    case "Please enter pin code.":
                                        Assert.assertEquals(error_Msg, "Please enter pin code.");
                                        if (error_color.equals("rgb(213, 0, 0)")) {
                                            Assert.assertEquals(error_color, "rgb(213, 0, 0)");
                                        } else {
                                            Assert.assertEquals(error_color, "rgba(213, 0, 0, 1)");
                                        }
                                        break;
                                }
                            }
                        }
                    } else {
                        System.out.println("Documents already uploaded");
                        List<WebElement> doc_uploaded = driver.findElements(By.xpath("//*[@class='col-xs-12 col-sm-6']/span"));
                        for (int k = 0; k < doc_uploaded.size(); k++) {
                            String uploaded_Data = doc_uploaded.get(k).getText();
                            System.out.println("Uploaded data is: " + uploaded_Data);
                        }

                    }
                }
            }

        }

    }

    @When("^I click on following links \"([^\"]*)\"$")
    public void iClickOnFollowingLinks(String arg0) throws Throwable {
        throw new PendingException();
    }

    @And("^I select business type \"([^\"]*)\"$")
    public void iSelectBusinessType(String arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        util.click(kyc.getDropDownClick, driver);
        Thread.sleep(2000L);
        List<WebElement> element = kyc.getBusinessDropDownValues;
        System.out.println("Size: " + element.size());
        for (int i = 1; i < element.size(); i++) {
            String str = element.get(i).getText();
            System.out.println("Drop Down data is: " + str);
            if (str.equals(arg0) && arg0.equals("Individuals")) {
                element.get(i).click();
                break;
            } else if (str.equals(arg0) && arg0.equals("Companies")) {
                element.get(i).click();
                break;
            } else if (str.equals(arg0) && arg0.equals("Partnership firms")) {
                element.get(i).click();
                break;
            }
        }
    }

    @And("^I enter all valid information and click on upload button$")
    public void iEnterAllValidInformationAndClickOnUploadButton(DataTable table) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        String str_name = null;
        String str_panNumber = null;
        String str_Pan_Url=null;
        List<WebElement> e = driver.findElements(By.xpath("//*[@class='col-xs-12 col-sm-6']"));
        System.out.println("Size is: " + e.size());
        if (e.size() < 19) {
            int count = 0;
            List<List<String>> cell = table.cells();
            for (int j = 1; j < cell.size(); j++) {
                str_name = cell.get(j).get(0);
                str_panNumber = cell.get(j).get(1);
                str_Pan_Url=cell.get(j).get(2);
            }


            System.out.println("Documents is not uploaded ");
            List<WebElement> list_Selected = driver.findElements(By.xpath("//*[@name='ctl00$ContentPlaceHolder1$ddlBusinessType']/option"));
            for (int i = 0; i < list_Selected.size(); i++) {
                String str_values = list_Selected.get(i).getAttribute("innerText");
                System.out.println("Selected values is: " + str_values);
                switch (str_values) {
                    case "Individuals":
                        driver.findElement(By.name("ctl00$ContentPlaceHolder1$txtPanName")).sendKeys(str_name);
                        Thread.sleep(1000L);
                        driver.findElement(By.name("ctl00$ContentPlaceHolder1$txtPanNumber")).sendKeys(str_panNumber);
                        Thread.sleep(1000L);
                       driver.findElement(By.name("ctl00$ContentPlaceHolder1$fuPanCard")).click();
                        Thread.sleep(1000L);
                        try {
                           // Runtime.getRuntime().exec("\"E:/WorkSpace/Projects/Paymate/Automation/PaymateAutomation/AutoIt/UploadFile.exe"+ ""+str_Pan_Url);
                            Runtime.getRuntime().exec("\"E:/WorkSpace/Projects/Paymate/Automation/PaymateAutomation/AutoIt/UploadFile.exe"+ ""+str_Pan_Url);
                            //"\"C:/Users/Casper/Desktop/Down.exe\"";
                        }catch (IOException io)
                        {
                            io.printStackTrace();
                        }
                        Thread.sleep(30000L);
                        break;

                    case "Companies":
                        driver.findElement(By.name("ctl00$ContentPlaceHolder1$txtPanName")).sendKeys(str_name);
                        Thread.sleep(1000L);
                        driver.findElement(By.name("ctl00$ContentPlaceHolder1$txtPanNumber")).sendKeys(str_panNumber);

                        break;
                    case "Partnership firms":
                        driver.findElement(By.name("ctl00$ContentPlaceHolder1$txtPanName")).sendKeys(str_name);
                        Thread.sleep(1000L);
                        driver.findElement(By.name("ctl00$ContentPlaceHolder1$txtPanNumber")).sendKeys(str_panNumber);

                        break;
                }
            }

        } else {
            System.out.println("Documents already uploaded");
            List<WebElement> doc_uploaded = driver.findElements(By.xpath("//*[@class='col-xs-12 col-sm-6']/span"));
            for (int k = 0; k < doc_uploaded.size(); k++) {
                String uploaded_Data = doc_uploaded.get(k).getText();
                System.out.println("Uploaded data is: " + uploaded_Data);
            }
        }

    }


    @Then("^I should see validation message \"([^\"]*)\" in green color$")
    public void iShouldSeeValidationMessageInGreenColor(String arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("msg is: " + arg0);
    }


    @Given("I click on upload kyc link")
    public void iClickOnUploadKycLink() throws InterruptedException {
       Thread.sleep(3000L);
       util.waitElementShouldBeClickable(kyc.getUploadKycLink);
        kyc.getUploadKycLink.click();
//       util.waitAndClick(kyc.getUploadKycLink);
       Assert.assertEquals(kyc.getkycTitle.getText(),"Uploaded Documents");
    }

    @Then("I enter details in all fields on uploaded documents page")
    public void iEnterDetailsInAllFieldsOnUploadedDocumentsPage() throws InterruptedException {
        String panName = faker.name().firstName();
        kyc.getNameOnPan.sendKeys(panName);
        kyc.getEnterPanNumber.sendKeys("ARVQK9423M");
        kyc.getUploadPanCardImage.sendKeys(filespath);
        kyc.businessDocDownArrow.click();
        WebElement bdoc = kyc.getBusinnessDocumentDropDownValue;
        bdoc.click();
       /* List<WebElement> busissnessDoc = kyc.getBusinnessDocumentDropDownValues;
        for (int i = 0; i < busissnessDoc.size(); i++) {
            System.out.println("Size:"+busissnessDoc.size());
            System.out.println("Line 469: "+busissnessDoc.get(i).getAttribute("innerHTML"));
                busissnessDoc.get(i).click();
            }*/
//        Select busissnessDoc = new Select(kyc.selectBusinessDoc);
//        busissnessDoc.selectByIndex(1);
        kyc.getUploadBusinessDocumentField.sendKeys(filespath);
        String address = faker.address().streetAddress();
        kyc.getAddressField.sendKeys(address);
        String city = faker.address().city();
        kyc.getCityTextBox.sendKeys(city);
        kyc.stateDownArrow.click();
        WebElement state = kyc.selectState;
        state.click();
        kyc.getPinCodeField.sendKeys("111111");
        kyc.addrDocDownArrow.click();
        WebElement addrDoc = kyc.selectAddrDoc;
        addrDoc.click();
        kyc.getUploadAddressDocument.sendKeys(filespath);
    }

    @Then("I click on upload button on uploaded documents page")
    public void iClickOnUploadButtonOnUploadedDocumentsPage() throws InterruptedException {
        util.waitAndClick(kyc.getUploadButton);
        Thread.sleep(30000);
//        util.waitUntilWebElelemntShouldBeDisplay(driver,kyc.uploadValMsg,30);
//        System.out.println("kyc msg: "+kyc.uploadValMsg.getText());
//        Assert.assertEquals(kyc.uploadValMsg.getAttribute("innerHTML"),"The KYC verification process may take up to 2 working days.");
    }

    @Then("I validate all fields on Uploaded documents page")
    public void iValidateAllFieldsOnUploadedDocumentsPage() {
        Assert.assertTrue(kyc.panName.isDisplayed());
        Assert.assertTrue(kyc.panNumber.isDisplayed());
        Assert.assertTrue(kyc.panImg.isDisplayed());
        Assert.assertTrue(kyc.panName.isDisplayed());
        Assert.assertTrue(kyc.businessDetailsImg.isDisplayed());
        Assert.assertTrue(kyc.addressField.isDisplayed());
        Assert.assertTrue(kyc.cityField.isDisplayed());
        Assert.assertTrue(kyc.stateField.isDisplayed());
        Assert.assertTrue(kyc.pincodeField.isDisplayed());
        Assert.assertTrue(kyc.addressDocImg.isDisplayed());

    }
}








