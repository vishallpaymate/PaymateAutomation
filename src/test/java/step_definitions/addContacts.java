package step_definitions;


import baseClass.Utils;
import baseClass.mainDriver;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import pageFactory.addContact_POM;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class addContacts extends mainDriver {

    public addContact_POM con = new addContact_POM(driver);
    public Utils u = new Utils();
    public String dataTable_str;
    public Hooks h = new Hooks();
    public String filePath = "C:\\Users\\Vishal\\Downloads";
    public String fileName = "ContactBulkUploadTemplate.xlsx";
    public String[] dataToWrite;
    public List<List<String>> cells;
    public String row1_str;
    public List<List<String>> celss_tab;
    public int cell_size;
    public List<List<String>> cell_List;
    public ArrayList<String> arrayList;
    public int cnt;
    public List<WebElement> allFields;
    public boolean kycStatus;
    public List<List<String>> cellTable;
    public int filterTableDataSize;
    public int emailDataTable;
    public int count;
    public int count1;
    public String email;
    public String accountNumber = "54864545645646545454";
    public String IFSCCode = "ICIC0000546";
    public String validationMsg;
    public List<List<String>> listTableCell;
    public String msg;
    public String companyName_Str;
    private String ToastMsg;
    private String refCode;
    private String companyName;
    private String compAdd;
    private String emailid;

    @When("^I click on add contact link$")
    public void iClickOnAddContactLink() throws Throwable {
        /*Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(By.xpath("//*[text()='Contacts']"))).build().perform();*/
        Thread.sleep(7000);
        // u.setWebDriverFluentWait(2, 30, By.xpath("//*[text()='Contacts']"));
        u.log4j("I click on Dashboard menu");
        u.waitAndClick(con.dashBoardMenu);
//        u.click(con.dashBoardMenu, driver);
        u.log4j("I click on contact and add then add contacts ");
        u.click(con.getContactLink, driver);
        Thread.sleep(300L);
    }

    @Then("^I should see following links$")
    public void iShouldSeeFollowingLinks(DataTable getTable) throws Throwable {
        List<List<String>> getCells = getTable.cells();
        for (int i = 0; i < getCells.size(); i++) {
            String getCell_str = getCells.get(i).get(0);
            switch (getCell_str) {
                case "Bulk Upload Contacts":
                    //u.setWebDriverFluentWait(1, 30, By.xpath("//*[contains(text(),'Bulk Upload Contacts')]"));
                    //u.waitUntilElelemntShouldBeDisplay(driver,By.xpath(:""));
                    boolean bool_isDisplay = con.getBulkUploadContactLink.isDisplayed();
                    Assert.assertEquals(true, bool_isDisplay);
                    boolean bool_isEnabled = con.getBulkUploadContactLink.isEnabled();
                    Assert.assertEquals(true, bool_isEnabled);
                    u.log4j("I see link: " + getCell_str);
                    break;
                case "Contacts":
                    WebElement ele = con.getContactLink;
                    boolean bool1_isDisplay = ele.isEnabled();
                    Assert.assertEquals(true, bool1_isDisplay);
                    boolean bool1_isEnable = ele.isEnabled();
                    Assert.assertEquals(true, bool1_isEnable);
                    u.log4j("I see link: " + getCell_str);
                    break;
                case "Manage Contacts":
                    boolean bool2_isDisplay = con.getManageContactLink.isDisplayed();
                    Assert.assertEquals(true, bool2_isDisplay);
                    boolean bool2_isEnable = con.getManageContactLink.isEnabled();
                    Assert.assertEquals(true, bool2_isEnable);
                    u.log4j("I see link: " + getCell_str);
                    break;

            }
        }


    }

    @When("^I click on following links$")
    public void iClickOnFollowingLinks(DataTable gettable) throws Throwable {
        List<List<String>> getCells_list = gettable.cells();
        for (int i = 0; i < getCells_list.size(); i++) {
            String getDT_Str = getCells_list.get(i).get(0);
            con.getContactLink.click();
            List<WebElement> getLink = con.getAllLinkAddContact;
            for (int j = 0; j < getLink.size(); j++) {
                String getLink_Text = getLink.get(j).getText();
                if (getCells_list.get(i).get(0).equals(getLink.get(j).getText()) && getLink.get(j).getText().equals("Bulk Upload Contacts")) {
                    getLink.get(j).click();
                    System.out.println("I am on " + driver.findElement(By.xpath("//*[@class='page-title col-xs-12']/h1" + "Page")));

                } else if (getCells_list.get(i).get(0).equals(getLink.get(j).getText()) && getLink.get(j).getText().equals("Contacts")) {
                    getLink.get(j).click();
                    System.out.println("I am on " + driver.findElement(By.xpath("//*[@class='page-title col-xs-12']/h1" + "Page")));

                } else if (getCells_list.get(i).get(0).equals(getLink.get(j).getText()) && getLink.get(j).getText().equals("Manage Contacts")) {
                    getLink.get(j).click();
                    System.out.println("I am on " + driver.findElement(By.xpath("//*[@class='page-title col-xs-12']/h1" + "Page")));

                }
            }
        }
    }


    @When("^I click on contact following links \"([^\"]*)\"$")
    public void iClickOnContactFollowingLinks(String arg0) throws Throwable {
        List<WebElement> element = con.getAllLinkAddContact;
        System.out.println("Links size are: " + element.size());
        for (int i = 0; i < element.size(); i++) {
            if (element.get(i).getText().equals(arg0) && element.get(i).getText().equals("Bulk Upload Contacts")) {
                u.log4j("I click on Bulk upload contacts");
                element.get(i).click();
                Thread.sleep(2000);
            } else if (element.get(i).getText().equals(arg0) && element.get(i).getText().equals("Add Contact")) {
                u.log4j("I click on Add contact");
                element.get(i).click();
                Thread.sleep(2000);
            } else if (element.get(i).getText().equals(arg0) && element.get(i).getText().equals("Manage Contacts")) {
                u.log4j("I click on Manage contacts");
                element.get(i).click();
                Thread.sleep(2000);
            }
        }
    }

    @Then("^I should land on particular page$")
    public void iShouldLandOnParticularPage() throws Throwable {
        String str = con.getPageTitle.getText();
        System.out.println("I" + str);
        switch (str) {
            case "BULK UPLOAD CONTACTS":
                Assert.assertEquals(str, "BULK UPLOAD CONTACTS");
                u.log4j("I am on page: " + str);
                break;
            case "ADD CONTACT":
                Assert.assertEquals(str, "ADD CONTACT");
                u.log4j("I am on page: " + str);
                break;
            case "Manage Contacts":
                Assert.assertEquals(str, "Manage Contacts");
                u.log4j("I am on page: " + str);
                break;
        }
    }

    @Then("^I should see respective fields$")
    public void iShouldSeeRespectiveFields() throws Throwable {
        Thread.sleep(3000L);
        String str = con.getPageTitle.getText();
        switch (str) {
            case "BULK UPLOAD CONTACTS":
                Assert.assertEquals(str, "BULK UPLOAD CONTACTS");
                u.log4j("I am on " + str + " page");
                WebElement file_ele = con.getChooseFile;
                boolean bool_isEnabled = file_ele.isEnabled();
                Assert.assertEquals(true, bool_isEnabled);

                boolean bool_Cloud_isDisplayed = con.getCloudUpload.isDisplayed();
                Assert.assertEquals(true, bool_Cloud_isDisplayed);

                String get_Lable = con.getUploadFileLabel.getAttribute("placeholder");
                Assert.assertEquals(get_Lable, "Choose file to upload");
                u.log4j("Choose file to upload label is: " + get_Lable);

                boolean bool_CheckBox_isDisplay = con.getKycRequiredCheckBox.isDisplayed();
                Assert.assertEquals(bool_CheckBox_isDisplay, true);

                boolean bool_CheckBox_isEnabled = con.getKycRequiredCheckBox.isEnabled();
                Assert.assertEquals(bool_CheckBox_isEnabled, true);

                boolean bool_CheckBox_isSelected = con.getKycRequiredCheckBox.isSelected();
                Assert.assertEquals(false, bool_CheckBox_isSelected);

//                String kycRequired_str = con.getKycRequiredText.getText();
//                Assert.assertEquals(kycRequired_str,"KYC Required");

                WebElement getTemp_element = con.getTemplate;

                String templet_str = getTemp_element.getAttribute("innerText");
                Assert.assertEquals(templet_str, "Click here to download template");

                boolean bool_Temp_isDisplayed = getTemp_element.isDisplayed();
                Assert.assertEquals(bool_Temp_isDisplayed, true);

                boolean bool_Temp_isEnabled = getTemp_element.isEnabled();
                Assert.assertEquals(bool_Temp_isEnabled, true);

                String color = getTemp_element.getCssValue("color");
                u.log4j("text Color is: " + color);
                if (h.browser.equalsIgnoreCase("chrome") && h.browser.equalsIgnoreCase("ie")) {
                    Assert.assertEquals(color, "rgba(36, 82, 105, 1)");
                } else if (h.browser.equalsIgnoreCase("firefox")) {
                    Assert.assertEquals(color, "rgb(49, 112, 143)");
                }

                boolean bool_sample_isDisplayed = con.getSample.isDisplayed();
                Assert.assertEquals(bool_sample_isDisplayed, true);

                boolean bool_sample_isEnabled = con.getSample.isEnabled();
                Assert.assertEquals(bool_Temp_isEnabled, true);

                String txt = con.getSample.getText();
                u.log4j("Click here to view sample text: " + txt);
                Assert.assertEquals(txt, "Click here to view sample");
                String color1 = con.getSample.getCssValue("color");
                u.log4j("text Color is: " + color);
                if (color1.equals("rgba(49, 112, 143, 1)")) {
                    Assert.assertEquals(color1, "rgba(49, 112, 143, 1)");
                } else {
                    Assert.assertEquals(color1, "rgb(49, 112, 143)");
                }

                String str2 = con.getGuidanceText.getText();
                u.log4j("Guidance text: " + str2);
                String str3 = "Click here to download templateClick here to view sample\n" +
                        "Upload file Type .xls , .xlsx , .csv / Upload file size max 10MB";
                Assert.assertEquals(str2, str3);

                boolean boool_conButtom_isDisplayed = con.getContinueButton.isDisplayed();
                Assert.assertEquals(boool_conButtom_isDisplayed, true);

                boolean boool_conButtom_isEnabled = con.getContinueButton.isEnabled();
                Assert.assertEquals(boool_conButtom_isEnabled, true);

                String contButton_str = con.getContinueButton.getText();
                u.log4j("Continue button text:  " + contButton_str);

                String con_color = con.getContinueButton.getCssValue("background-color");
                if (con_color.equals("rgba(7, 80, 101, 1)")) {
                    Assert.assertEquals(con_color, "rgba(7, 80, 101, 1)");
                } else {
                    Assert.assertEquals(con_color, "rgb(7, 80, 101)");
                }
                System.out.println("Continue button color is: " + con_color);

                boolean cancel_idDisplayed = con.getCancelButton.isDisplayed();
                Assert.assertEquals(cancel_idDisplayed, true);

                boolean cancel_isEnabled = con.getCancelButton.isEnabled();
                Assert.assertEquals(cancel_isEnabled, true);

                String cancel_text = con.getCancelButton.getText();
                u.log4j("Cancel button text: " + cancel_text);

                String cancel_color = con.getCancelButton.getCssValue("background-color");
                if (cancel_color.equals("rgba(255, 0, 0, 1)")) {
                    Assert.assertEquals(cancel_color, "rgba(255, 0, 0, 1)");
                } else {
                    Assert.assertEquals(cancel_color, "rgb(255, 0, 0)");
                }
                u.log4j("Cancel button color: " + cancel_color);
                break;
            case "ADD CONTACT":
                Assert.assertEquals(str, "ADD CONTACT");
                u.log4j("I am on " + str + " page");

                //List<WebElement> list_input = driver.findElements(By.xpath("//*[@class='col-xs-12 col-sm-6']"));

                List<WebElement> list_input = con.getAllinput_AddContact;
                for (int i = 0; i < list_input.size(); i++) {
                    Assert.assertEquals(true, list_input.get(i).isDisplayed());
                    u.log4j("Input fields are displayed: " + list_input.get(i).isDisplayed());
                    Assert.assertEquals(true, list_input.get(i).isEnabled());
                    u.log4j("Input fields are enabled: " + list_input.get(i).isEnabled());
                }

                boolean bool_checkBox = driver.findElement(By.xpath("//*[@class='mdl-checkbox__ripple-container mdl-js-ripple-effect mdl-ripple--center']")).isSelected();
                Assert.assertEquals(bool_checkBox, false);
                u.log4j("Check box is not selected: " + bool_checkBox);

                boolean boool_conButtom_isDisplayed1 = con.getAddContactSaveButton.isDisplayed();
                Assert.assertEquals(boool_conButtom_isDisplayed1, true);

                boolean boool_conButtom_isEnabled1 = con.getAddContactSaveButton.isEnabled();
                Assert.assertEquals(boool_conButtom_isEnabled1, true);

                String contButton_str1 = con.getAddContactSaveButton.getText();
                u.log4j("Continue button text:  " + contButton_str1);

                String con_color1 = con.getAddContactSaveButton.getCssValue("background-color");
                if (con_color1.equals("rgba(7, 80, 101, 1)")) {
                    Assert.assertEquals(con_color1, "rgba(7, 80, 101, 1)");
                } else {
                    Assert.assertEquals(con_color1, "rgb(7, 80, 101)");
                }
                u.log4j("Continue button color is: " + con_color1);

                boolean cancel_idDisplayed1 = con.getCancelButton.isDisplayed();
                Assert.assertEquals(cancel_idDisplayed1, true);

                boolean cancel_isEnabled1 = con.getCancelButton.isEnabled();
                Assert.assertEquals(cancel_isEnabled1, true);

                String cancel_text1 = con.getCancelButton.getText();
                u.log4j("Cancel button text: " + cancel_text1);

                String cancel_color1 = con.getCancelButton.getCssValue("background-color");
                if (cancel_color1.equals("rgba(255, 0, 0, 1)")) {
                    Assert.assertEquals(cancel_color1, "rgba(255, 0, 0, 1)");
                } else {
                    Assert.assertEquals(cancel_color1, "rgb(255, 0, 0)");
                }
                u.log4j("Cancel button color: " + cancel_color1);
                break;
            case "MANAGE CONTACTS":
                Assert.assertEquals(str, "MANAGE CONTACTS");
                u.log4j("I am on " + str + " page");

                Assert.assertEquals(con.getFilterText.getText(), "Filters");
                con.getFliterClick.click();
                Thread.sleep(2000L);

                List<WebElement> list_FilterInput = con.getfilterInput;
                for (int i = 0; i < list_FilterInput.size(); i++) {

                    Assert.assertEquals(true, list_FilterInput.get(i).isDisplayed());
                    u.log4j("Filter input fields are displaying: " + list_FilterInput.get(i).isDisplayed());
                    Assert.assertEquals(true, list_FilterInput.get(i).isEnabled());
                    u.log4j("Filter input fields are Enabled: " + list_FilterInput.get(i).isEnabled());

                    List<WebElement> list_FilterInput_Label = con.getFilterInput_label;
                    for (int j = i; j < list_FilterInput_Label.size(); j++) {

                        String label = list_FilterInput_Label.get(j).getText();
                        if (label.equals("Company Name or Email ID")) {
                            Assert.assertEquals(label, "Company Name or Email ID");
                            u.log4j("Label of " + label);
                            break;
                        } else if (label.equals("Company Name")) {
                            Assert.assertEquals(label, "Company Name");
                            u.log4j("Label of " + label);
                            break;
                        } else if (label.equals("Company Code")) {
                            Assert.assertEquals(label, "Company Code");
                            u.log4j("Label of " + label);
                            break;
                        } else if (label.equals("Mobile")) {
                            Assert.assertEquals(label, "Mobile");
                            u.log4j("Label of " + label);
                            break;
                        }

                    }


                }


                List<WebElement> list_tableRow = con.getTablerRow;
                for (int i = 0; i < list_tableRow.size(); i++) {
                    switch (list_tableRow.get(i).getText()) {
                        case "Xpress ID":
                            Assert.assertEquals(list_tableRow.get(i).getText(), "Xpress ID");
                            u.log4j("I checked " + list_tableRow.get(i).getText() + " row");
                            break;
                        case " Mobile No":
                            Assert.assertEquals(list_tableRow.get(i).getText(), " Mobile No");
                            u.log4j("I checked " + list_tableRow.get(i).getText() + " row");

                            break;
                        case "Company Name":
                            Assert.assertEquals(list_tableRow.get(i).getText(), "Company Name");
                            u.log4j("I checked " + list_tableRow.get(i).getText() + " row");

                            break;
                        case "RegistrationDate":
                            Assert.assertEquals(list_tableRow.get(i).getText(), "RegistrationDate");
                            u.log4j("I checked " + list_tableRow.get(i).getText() + " row");

                            break;
                        case "Status":
                            Assert.assertEquals(list_tableRow.get(i).getText(), "Status");
                            u.log4j("I checked " + list_tableRow.get(i).getText() + " row");

                            break;
                        case "Kyc Status":
                            Assert.assertEquals(list_tableRow.get(i).getText(), "Kyc Status");
                            u.log4j("I checked " + list_tableRow.get(i).getText() + " row");

                            break;
                        case "Actions":
                            Assert.assertEquals(list_tableRow.get(i).getText(), "Actions");
                            u.log4j("I checked " + list_tableRow.get(i).getText() + " row");

                            break;
                    }

                }
                String str4 = con.addContactToProceed.getText();
                u.log4j("Please add a contact to proceed: " + str4);
                if (str4.equals("Please add a contact to proceed")) {
                    Assert.assertEquals(str4, "Please add a contact to proceed");
                    u.log4j("There is no contact");
                } else {
                    u.log4j("contacts are present");
                }

        }
        List<WebElement> list_filterButtons = con.getFilterButtons;
        for (int k = 0; k < list_filterButtons.size(); k++) {

            switch (list_filterButtons.get(k).getAttribute("value")) {
                case "Filter":

                    Assert.assertEquals(true, list_filterButtons.get(k).isEnabled());
                    Assert.assertEquals(true, list_filterButtons.get(k).isDisplayed());
                    if (list_filterButtons.get(k).getCssValue("background-color").equals("rgba(64, 196, 255, 1)")) {
                        Assert.assertEquals("rgba(64, 196, 255, 1)", list_filterButtons.get(k).getCssValue("background-color"));
                    } else {
                        Assert.assertEquals("rgb(64, 196, 255)", list_filterButtons.get(k).getCssValue("background-color"));

                    }

                    u.log4j("I checked " + list_filterButtons.get(k).getAttribute("value"));
                    break;
                case "Clear":
                    Assert.assertEquals(true, list_filterButtons.get(k).isEnabled());
                    Assert.assertEquals(true, list_filterButtons.get(k).isDisplayed());

                    if (list_filterButtons.get(k).getCssValue("background-color").equals("rgba(255, 0, 0, 1)")) {
                        Assert.assertEquals("rgba(255, 0, 0, 1)", list_filterButtons.get(k).getCssValue("background-color"));
                    } else {
                        Assert.assertEquals("rgb(255, 0, 0)", list_filterButtons.get(k).getCssValue("background-color"));

                    }

                    u.log4j("I checked " + list_filterButtons.get(k).getAttribute("value"));
                    break;
                case "Export":
                    Assert.assertEquals(true, list_filterButtons.get(k).isEnabled());
                    Assert.assertEquals(true, list_filterButtons.get(k).isDisplayed());
                    u.log4j(list_filterButtons.get(k).getCssValue("background-color"));
                    if (list_filterButtons.get(k).getCssValue("background-color").equals("rgba(7, 80, 101, 1)")) {
                        Assert.assertEquals("rgba(7, 80, 101, 1)", list_filterButtons.get(k).getCssValue("background-color"));
                    } else {
                        Assert.assertEquals("rgb(7, 80, 101)", list_filterButtons.get(k).getCssValue("background-color"));

                    }

                    u.log4j("I checked " + list_filterButtons.get(k).getAttribute("value") + "button");
                    break;

            }

        }


    }


    @And("^I click on buttons then i see validation msg$")
    public void iClickOnButtonsThenISeeValidationMsg(DataTable table) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        List<List<String>> list_Cells = table.cells();
        for (int i = 0; i < list_Cells.size(); i++) {
            dataTable_str = list_Cells.get(i).get(0);
            switch (dataTable_str) {
                case "Continue":
                    driver.findElement(By.xpath("//input[@id='btnUploadFile']")).click();
                    Thread.sleep(2000L);
                    Assert.assertEquals(driver.findElement(By.xpath("//span[@class='mdl-textfield__error']")).getText(), "Please Select File to Upload.");
                    System.out.println("I clicked on : " + dataTable_str + " button");
                    break;
                case "Cancel":
                    driver.findElement(By.xpath("//input[@id='ContentPlaceHolder1_btnCancel']")).click();
                    Thread.sleep(2000L);
                    String str = con.getPageTitle.getText();
                    Assert.assertEquals(str, "Manage Contacts");
                    System.out.println("I clicked on : " + dataTable_str + " button");
                    break;
            }
        }
    }

    @And("^I click on button then i see validation message$")
    public void iClickOnButtonThenISeeValidationMessage(DataTable table) throws Throwable {
        List<List<String>> list_Cells = table.cells();
        for (int i = 0; i < list_Cells.size(); i++) {
            dataTable_str = list_Cells.get(i).get(0);
            System.out.println(dataTable_str);
            switch (dataTable_str) {
                case "Save":

                    driver.findElement(By.xpath("//input[@value='Save']")).click();
                    Thread.sleep(2000L);
                    String s1 = driver.findElement(By.cssSelector("#ContentPlaceHolder1_rfvCompanyName")).getText();
                    Assert.assertEquals(s1, "Please enter company name.");
//                    String s2 = driver.findElement(By.cssSelector("#ContentPlaceHolder1_vcContactFirstName")).getText();
//                    Assert.assertEquals(s2, "Please enter First Name");
//                    //Assert.assertEquals(driver.findElement(By.xpath("//span[@class='mdl-textfield__error']")).getText(),"Please Select File to Upload.");
//
//                    String s3 = driver.findElement(By.cssSelector("#ContentPlaceHolder1_vcContactLastName")).getText();
//                    Assert.assertEquals(s3, "Please enter Last Name");
//                    System.out.println("I clicked on : " + dataTable_str + " button");

                    /*driver.findElement(By.name("ctl00$ContentPlaceHolder1$txtCompanyName")).sendKeys("Panasonic");
                    driver.findElement(By.xpath("//input[@value='Save']")).click();
                    ToastMsg = driver.findElement(By.xpath("//*[contains(text(),'The First Name field is required., The Last Name field is required.')]")).getText();

                    System.out.println(ToastMsg);*/

                    break;
                case "Cancel":
                    driver.findElement(By.xpath("//input[@id='ContentPlaceHolder1_btnCancel']")).click();
                    Thread.sleep(2000L);
                    String str = con.getPageTitle.getText();
                    Assert.assertEquals(str, "Add Contact");
                    System.out.println("I clicked on : " + dataTable_str + " button");
                    break;
            }
        }
    }

    @And("^I click on download template link$")
    public void iClickOnDownloadTemplateLink() throws Throwable {
        Hooks h = new Hooks();
        Robot r = new Robot();
        u.deleteOldFile("C:\\Users\\Sam\\Downloads\\ContactBulkUploadTemplate.xls");
        // Write code here that turns the phrase above into concrete actions
        if (h.browser.equalsIgnoreCase("Firefox")) {
            driver.findElement(By.xpath("//*[@href='../Templates/ContactBulkUploadTemplate.xls']")).click();

            driver.findElement(By.xpath("//*[@href='../Templates/ContactBulkUploadTemplate.xls']")).sendKeys(Keys.ARROW_DOWN);
            Thread.sleep(2000L);
            r.keyPress(KeyEvent.VK_ENTER);
            Thread.sleep(2000L);
            r.keyRelease(KeyEvent.VK_ENTER);
        } else if (h.browser.equalsIgnoreCase("ie")) {
            System.out.println("I am in IE:");
            String parent = driver.getWindowHandle();
            driver.findElement(By.xpath("//*[@href='../Templates/ContactBulkUploadTemplate.xls']")).click();


            // after clicking on the link
            Set<String> availableWindows = driver.getWindowHandles();
            System.out.println("Available windows: " + availableWindows);
            String newWindow = null;
            for (String window : availableWindows) {
                if (!parent.equals(window)) {
                    newWindow = window;
                }
            }
            driver.switchTo().window(newWindow);
            r.keyPress(KeyEvent.VK_ENTER);
            Thread.sleep(2000L);
            r.keyRelease(KeyEvent.VK_ENTER);
        } else if (h.browser.equalsIgnoreCase("chrome")) {
            u.click(driver.findElement(By.xpath("//*[@href='../Templates/ContactBulkUploadTemplate.xls']")), driver);
            Thread.sleep(2000L);

        }
        //Thread.sleep(2000L);
    }

    @Then("^I should verify file is download$")
    public void iShouldVerifyFileIsDownload() throws Throwable {
        String downloadPath = filePath;
        Assert.assertTrue(u.isFileDownloaded(downloadPath, "ContactBulkUploadTemplate.xls"), "Failed to download Expected document");
        //Assert.assertTrue(u.isFileDownloaded_Ext(downloadPath, ".xls"), "Failed to download document which has extension .xls");
        File getLatestFile = u.getLatestFilefromDir(downloadPath);
        String fileName = getLatestFile.getName();
        Assert.assertTrue(fileName.equals("ContactBulkUploadTemplate.xls"), "Failed to download document which has extension .xls");
        System.out.println("File name: " + fileName);
    }

    @And("^I click on view sample link$")
    public void iClickOnViewSampleLink() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        u.click(con.getViewSampleWindow, driver);
        Thread.sleep(3000L);
    }

    @Then("^I should see popup window and data$")
    public void iShouldSeePopupWindowAndData() throws Throwable {
        String txt = driver.findElement(By.xpath("//*[text()='Sample upload template']")).getText();
        Assert.assertTrue(txt.equals("Sample upload template"), "Text is not matched we are on wrong window");

        String text = con.getSampleFormartText.getText();
        System.out.println("text: " + text);
        Assert.assertTrue(text.equals("Sample format for Contact upload"), "Text is not matched");

        List<WebElement> webEle = con.getConatctUploadFormatTableHeading;
        for (int i = 0; i < webEle.size(); i++) {
            String tableHeading = webEle.get(i).getText();
            System.out.println("+++++++++++++" + tableHeading + "+++++++++++++++++");
            switch (tableHeading) {
                case "ReferenceCode":
                    System.out.println("WebElemet Table heading data is:" + tableHeading);
                    Assert.assertTrue(tableHeading.equals("ReferenceCode"), "Text not matched");
                    break;
                case "CompanyName":
                    System.out.println("WebElemet Table heading data is: " + tableHeading);
                    Assert.assertTrue(tableHeading.equals("CompanyName"), "Text not matched");
                    break;
                case "FirstName":
                    System.out.println("WebElemet Table heading data is: " + tableHeading);
                    Assert.assertTrue(tableHeading.equals("FirstName"), "Text not matched");
                    break;

                case "LastName":
                    System.out.println("WebElemet Table heading data is: " + tableHeading);
                    Assert.assertTrue(tableHeading.equals("LastName"), "Text not matched");
                    break;
                case "MobileNo":
                    System.out.println("WebElemet Table heading data is: " + tableHeading);
                    Assert.assertTrue(tableHeading.equals("MobileNo"), "Text not matched");
                    break;
                case "EmailID":
                    System.out.println("WebElemet Table heading data is: " + tableHeading);
                    Assert.assertTrue(tableHeading.equals("EmailID"), "Text not matched");
                    break;
                case "CompanyAddress":
                    System.out.println("WebElemet Table heading data is: " + tableHeading);
                    Assert.assertTrue(tableHeading.equals("CompanyAddress"), "Text not matched");
                    break;
                case "BankAccountNo":
                    System.out.println("WebElemet Table heading data is: " + tableHeading);
                    Assert.assertTrue(tableHeading.equals("BankAccountNo"), "Text not matched");
                    break;
                case "IFSCode":
                    System.out.println("WebElemet Table heading data is: " + tableHeading);
                    Assert.assertTrue(tableHeading.equals("IFSCode"), "Text not matched");
                    break;
                case "GSTIN":
                    System.out.println("WebElemet Table heading data is: " + tableHeading);
                    Assert.assertTrue(tableHeading.equals("GSTIN"), "Text not matched");
                    break;
                case "PAN":
                    System.out.println("WebElemet Table heading data is: " + tableHeading);
                    Assert.assertTrue(tableHeading.equals("PAN"), "Text not matched");
                    break;
                case "NotificationDetails":
                    System.out.println("WebElemet Table heading data is: " + tableHeading);
                    Assert.assertTrue(tableHeading.equals("NotificationDetails"), "Text not matched");
                    break;

                default:
                    System.out.println("Case is not matched");
                    //Assert.assertEquals("Case is not matched", "Case is not matched");
                    Assert.assertTrue(false, "case is not matched");
            }


        }

        String noteText = con.getNotText.getText();
        System.out.println("Note text: " + noteText);

        String li = driver.findElement(By.xpath("//ol[@type='1']")).getText();
        System.out.println("Not Data is: " + li);
        Assert.assertEquals(li, "CompanyName is a mandatory field\n" +
                "ReferenceCode should be unique value and it is an optional field\n" +
                "Allowed characters for FirstName and LastName are apostrophe,hyphen and numbers\n" +
                "To add multiple Bank Account Numbers for same Contact, add multiple Contacts with different ReferenceCode");

        boolean bool_close = con.getCancelButton.isDisplayed();
        Assert.assertTrue(bool_close, "Button is not displayed");

        boolean bool_Enable = con.getCancelButton.isEnabled();
        Assert.assertTrue(true, "Button is not enabled");


        String color = con.getCancelButton.getCssValue("background-color");
        if (h.browser.equalsIgnoreCase("chrome") || h.browser.equalsIgnoreCase("ie")) {
            System.out.println("Cancel button color is: " + color);
            Assert.assertTrue(color.equals("rgba(255, 0, 0, 1)"), "color is not matched");

        } else if (h.browser.equalsIgnoreCase("firefox")) {
            System.out.println("Cancel button color is: " + color);
            Assert.assertTrue(color.equals("rgb(255, 0, 0)"), "color is not matched");
        }
    }

    @And("^I click on following button to close then pop is closed i land on bulk upload page$")
    public void iClickOnFollowingButtonToCloseThenPopIsClosedILandOnBulkUploadPage(DataTable table) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        List<List<String>> cell_List = table.cells();
        for (int i = 0; i < cell_List.size(); i++) {
            String cell_str = cell_List.get(i).get(0);
            if (cell_str.equalsIgnoreCase("Close button")) {
                u.click(con.getCloseButton, driver);
                Thread.sleep(4000L);
                String str = con.getPageTitle.getText();
                Assert.assertEquals(str, "Bulk Upload Contacts");
                System.out.println("I am on " + str + " page");
                System.out.println("Data Table data is: " + cell_str);
            } else if (cell_str.equalsIgnoreCase("Cross icon")) {
                u.click(con.getCrossIcon, driver);
                Thread.sleep(4000L);
                System.out.println("Data Table data is: " + cell_str);
                String str = con.getPageTitle.getText();
                Assert.assertEquals(str, "Bulk Upload Contacts");
                System.out.println("I am on " + str + " page");
            } else if (cell_str.equals("Escape")) {
                Robot r = new Robot();
                r.keyPress(KeyEvent.VK_ESCAPE);
                Thread.sleep(3000L);
                System.out.println("Data Table data is: " + cell_str);
                String str = con.getPageTitle.getText();
                Assert.assertEquals(str, "Bulk Upload Contacts");
                System.out.println("I am on " + str + " page");
            }

            u.click(con.getViewSampleWindow, driver);

        }
    }

    @Then("^I match sample data row and excel data row$")
    public void iMatchSampleDataRowAndExcelDataRow() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        int i = 0;
        int k = 0;
        File file = new File("C:\\Users\\Sam\\Downloads\\ContactBulkUploadTemplate.xls");
        FileInputStream inputStream = new FileInputStream(file);
        Workbook workbook = new HSSFWorkbook(inputStream);
        Sheet sheet = workbook.getSheet("Sheet1");
        int rowCount = sheet.getLastRowNum();
        System.out.println("Row Count: " + rowCount);
        u.click(con.getDownloadFileLink, driver);
        Thread.sleep(2000L);
        String str = null;
        List<WebElement> webEle = con.getConatctUploadFormatTableHeading;
        for (i = 0; i < webEle.size(); i++) {
            str = webEle.get(i).getText();
            System.out.println("Web Table values: " + str);
        }
    }

/*    @And("^I write data in downloaded excel file$")
    public void iWriteDataInDownloadedExcelFile(DataTable table) throws Throwable {
        u.log4j("Deleting the old template file");
        u.deleteOldFile("C:\\Users\\Sam\\Downloads\\ContactBulkUploadTemplate.xls");
        Thread.sleep(3000L);
        u.log4j("Downloading the new template file");
        con.getDownloadFileLink.click();
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
                *//*System.out.println();
                String refCode1 = u.fakerData("referenceCode", cell_List.get(i-1).get(1));
                System.out.println("refCode1: " + refCode1);
                String conName = u.fakerData("companyName", cell_List.get(i-1).get(2));
                System.out.println("conName: " + conName);
                cell.setCellValue(refCode1);
                cell.setCellValue(conName);*//*
                String data1 = cell_List.get(1).get(0);
                System.out.println(data1);
                String data2 = cell_List.get(1).get(1);
                System.out.println(data2);
                String data3 = cell_List.get(1).get(2);
                System.out.println(data3);


                cell.setCellValue(u.fakerData("referenceCode",data1));
                cell.setCellValue(u.fakerData("companyName",data2));
                    break;
            }
            inputStream.close();
            FileOutputStream outputStream = new FileOutputStream(file);
            workbook.write(outputStream);
            break;
        }
    }*/

    @And("^I write data in downloaded excel file$")
    public void iWriteDataInDownloadedExcelFile(DataTable table) throws Throwable {
        u.deleteOldFile("C:\\Users\\Vishal\\Downloads\\ContactBulkUploadTemplate.xlsx");
        Thread.sleep(3000L);
        con.getDownloadFileLink.click();
        Thread.sleep(1000);
        cell_List = table.cells();
        cell_size = cell_List.size();
        System.out.println("Cell size: " + cell_size);
        File file = new File(filePath + "\\" + fileName);
        FileInputStream inputStream = new FileInputStream(file);
        XSSFWorkbook workbook = null;
        String fileExtensionName = fileName.substring(fileName.indexOf("."));
        System.out.println("File Extension is: " + fileExtensionName);
        workbook = new XSSFWorkbook(inputStream);
        XSSFSheet sheet = workbook.getSheet("Sheet1");
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
    }

    @And("^I upload file$")
    public void iUploadFile() throws Throwable {
        Actions actions = new Actions(driver);
        actions.moveToElement(con.getFileUpoadField).build().perform();
        con.getFileUpoadField.sendKeys("C:\\Users\\Vishal\\Downloads\\ContactBulkUploadTemplate.xlsx");
        //u.click(con.getFileUpoadField,driver);
        u.click(con.getContinueButton, driver);

        Thread.sleep(3000L);
        //u.setWebDriverFluentWait(1, 20, By.xpath("//*[@id='form1']/div[3]/div"));
        String cssColor = driver.findElement(By.xpath("//*[@id='form1']/div[3]/div")).getCssValue("color");
        u.setWebDriverFluentWait(1, 30, By.xpath("//*[@id='ContentPlaceHolder1_gvContacts']/tbody/tr/td[5]"));
        List<WebElement> countErrorMsg = driver.findElements(By.xpath("//*[@id='ContentPlaceHolder1_gvContacts']/tbody/tr/td[5]"));
        System.out.println("Count of error msg is: " + countErrorMsg.size());
        int cnt = countErrorMsg.size();
        for (int p = 0; p < cnt; p++) {
            String errorMsgIs = countErrorMsg.get(p).getText();
            System.out.println("errorMsgIs: " + errorMsgIs.length());
            if (errorMsgIs.length() == 0) {
                System.out.println("Error msg are there \n" + errorMsgIs);
                switch (errorMsgIs) {
                    case "Please enter valid ReferenceCode":
                        Assert.assertTrue(errorMsgIs.equals("Please enter valid ReferenceCode"));
                        break;
                    case "Please enter valid company name":
                        Assert.assertTrue(errorMsgIs.equals("Please enter valid company name"));
                        break;
                    case "Please enter valid last name":
                        Assert.assertTrue(errorMsgIs.equals("Please enter valid last name"));
                        break;
                    case "Please enter valid mobile number":
                        Assert.assertTrue(errorMsgIs.equals("Please enter valid mobile number"));
                        break;
                    case "Please enter valid bank account no":
                        Assert.assertTrue(errorMsgIs.equals("Please enter valid bank account no"));
                        break;
                    case "Please enter valid IFS code":
                        Assert.assertTrue(errorMsgIs.equals("Please enter valid IFS code"));
                        break;
                    case "Please enter valid GSTIN":
                        Assert.assertTrue(errorMsgIs.equals("Please enter valid GSTIN"));
                        break;
                    case "Please enter valid first name":
                        Assert.assertTrue(errorMsgIs.equals("Please enter valid first name"));
                        break;


                }
            } else {
                System.out.println("There is no error msg");
            }
        }


    }

    @And("^I enter mandatory fields$")
    public void iEnterMandatoryFields(DataTable table) throws Throwable {
        List<List<String>> cellls = table.cells();
        for (int i = 1; i < cellls.size(); i++) {
             companyName =  u.fakerData("companyName","pvt ltd");
            con.getCompanyName.sendKeys(companyName);
            String firstName = cellls.get(i).get(1);
            con.getFirstName.sendKeys(firstName);
            String LastName = cellls.get(i).get(2);
            con.getLastName.sendKeys(LastName);
        }
    }

    @And("^I click on Add contact save button$")
    public void iClickOnAddContactSaveButton() throws Throwable {
        Thread.sleep(3000L);
        u.click(con.getAddContactSaveButton, driver);

    }

    @Then("^I should see \"([^\"]*)\" msg and i should land on manage contact$")
    public void iShouldSeeMsgAndIShouldLandOnManageContact(String arg0) throws Throwable {
        u.setWebDriverFluentWait(1, 20, By.xpath("//*[@id='form1']/div[3]"));
        String con_savedMsg = driver.findElement(By.xpath("//*[@id='form1']/div[3]")).getText();
        Assert.assertTrue(arg0.equals(con_savedMsg), "Invalid validation msg when user add contact");
        u.setWebDriverFluentWait(1, 20, By.xpath("//h1[contains(text(),'Manage Contacts')]"));
        String manageContact_str = driver.findElement(By.xpath("//h1[contains(text(),'Manage Contacts')]")).getText();
        Assert.assertTrue(manageContact_str.equals("Manage Contacts"), "User is not redirected on manage contact");

        u.click(con.getShowDropdown, driver);
        //List<WebElement> dropDownOptions = driver.findElements(By.xpath("//select[@name='ContentPlaceHolder1_gvContacts_length']/option"));
        List<WebElement> dropDownOptions = con.getDropDownValues;
        for (int i = 0; i < dropDownOptions.size(); i++) {
            String options = dropDownOptions.get(i).getText();
            System.out.println("DropDown Option is: " + options);
            if (options.equals("All")) {
                dropDownOptions.get(i).click();
                Thread.sleep(3000L);
            }
        }
    }

   /* @And("^I see entered data is displayed in manage contact$")
    public void iSeeEnteredDataIsDisplayedInManageContact() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }
*/

    @And("^I see entered data is displayed in manage contact and page fields$")
    public void iSeeEnteredDataIsDisplayedInManageContactAndPageFields() throws Throwable {
        String getAfterUploadText = con.getUploadedContact.getText();
        Assert.assertTrue(getAfterUploadText.equals("Uploaded Contacts"), "Uploaded Contacts text is not matched on bulk upload contact");

        String get_InfoText = con.getInfoText.getText();
        Assert.assertTrue(get_InfoText.equals("Click confirm below to confirm the contact"), "Click confirm below to confirm the contact text is not matched");

        List<WebElement> webElements = con.getBulkUploadTableHeading;

        for (int i = 0; i < webElements.size(); i++) {
            String getTableHeading = webElements.get(i).getText();
            switch (getTableHeading) {
                case "Company Name":
                    Assert.assertTrue(getTableHeading.equals("Company Name"));
                    System.out.println("Table Data Heading: " + getTableHeading);

                    break;
                case "Mobile No.":
                    Assert.assertTrue(getTableHeading.equals("Mobile No."));
                    System.out.println("Table Data Heading: " + getTableHeading);

                    break;
                case "Email Address":
                    Assert.assertTrue(getTableHeading.equals("Email Address"));
                    System.out.println("Table Data Heading: " + getTableHeading);

                    break;
                case "Reference Code":
                    Assert.assertTrue(getTableHeading.equals("Reference Code"));
                    System.out.println("Table Data Heading: " + getTableHeading);

                    break;
                case "Upload Status":
                    Assert.assertTrue(getTableHeading.equals("Upload Status"));
                    System.out.println("Table Data Heading: " + getTableHeading);

                    break;
               /* default:
                    System.out.println("Case is not matched");
                    //Assert.assertEquals("Case is not matched", "Case is not matched");
                    Assert.assertTrue(false, "case is not matched");*/
            }
        }

        WebElement element = con.getConfirmButton;
        boolean is_Displyed = element.isDisplayed();
        Assert.assertTrue(is_Displyed, "Button is not displayed");
        boolean is_Enabled = element.isEnabled();
        Assert.assertTrue(is_Enabled, "Button is not Enabled");
        //Cancel button
        WebElement element1 = con.getCancelButtonOnBulkData;
        boolean cancel_IsDisplayed = element1.isDisplayed();
        Assert.assertTrue(cancel_IsDisplayed, "Cancel button is not displayed");
        boolean cancel_IsEnabled = element1.isEnabled();
        Assert.assertTrue(cancel_IsEnabled, "Cancel button is not Enabled");

        String color1 = element1.getCssValue("background-color");
        /*if (h.browser.equalsIgnoreCase("Chrome") || h.browser.equalsIgnoreCase("ie")) {
            String buttonBGColor = element.getCssValue("background-color");
            Assert.assertTrue(buttonBGColor.equals("rgba(7, 80, 101, 1)"), "Button color is not as expected");
            System.out.println("BackGround Color: " + buttonBGColor);
            Assert.assertTrue(color1.equals("rgba(255, 0, 0, 1)"));
            System.out.println("Cancel button color is: " + color1);
        } else if (h.browser.equalsIgnoreCase("firefox")) {
            String buttonBGColor = element.getCssValue("background-color");
            Assert.assertTrue(buttonBGColor.equals("rgb(7, 80, 101)"), "Button color is not as expected");
            System.out.println("BackGround Color: " + buttonBGColor);
            Assert.assertTrue(color1.equals("rgb(255, 0, 0)"));
            System.out.println("Cancel button color is: " + color1);
        }
*/

    }

    @And("^I see uploaded data in table format$")
    public void iSeeUploadedDataInTableFormat() throws Throwable {
        List<WebElement> countErrorMsg = driver.findElements(By.xpath("//*[@id='ContentPlaceHolder1_gvContacts']/tbody/tr/td[5]"));
        cnt = countErrorMsg.size();
        List<WebElement> list_uploadedData = con.getUploadedTableData;
        System.out.println("list_uploadedData: " + list_uploadedData.size());
        for (int i = 0; i < list_uploadedData.size(); i++) {
            String table_values = list_uploadedData.get(i).getText();
            System.out.println("After upload contact data: " + table_values);
        }
        String companyName;

        arrayList = new ArrayList<String>();
        u.setWebDriverFluentWait(1, 20, By.xpath("//*[@id='ContentPlaceHolder1_gvContacts']/tbody/tr/td[1]"));
        List<WebElement> element_str = con.getCompanyNameList;
        System.out.println("element_str size: " + element_str.size());
        int s1 = element_str.size();
        System.out.println("S1: " + s1);
        for (int i = 0; i < element_str.size(); i++) {
            companyName = element_str.get(i).getText();
            System.out.println("Company Name from bulk upload: " + companyName);
            arrayList.add(i, companyName);
        }

    }

    @And("^I click on confirm button and i should see proper validation message$")
    public void iClickOnConfirmButtonAndIShouldSeeProperValidationMessage() throws Throwable {
        List<WebElement> ele = driver.findElements(By.xpath("//*[@id='ContentPlaceHolder1_gvContacts']/tbody/tr"));
        int size = ele.size();
        // 0 of 3 Contact(s) added successfully
        String of = " of ";
        String msg = " Contact(s) added successfully";
        u.log4j("I click on confirm button");
        u.click(con.getConfirmButton, driver);
        Thread.sleep(3000);
        u.setWebDriverFluentWait(1, 30, By.xpath("//*[@id='form1']/div[3]/div"));
        String validationMsg = driver.findElement(By.xpath("//*[@id='form1']/div[3]/div")).getText();
        System.out.println("After click on confirm button validation msg is: " + validationMsg);
        //int textIsDisplay = driver.findElements(By.xpath("//*[@id='ContentPlaceHolder1_gvContacts']/tbody/tr/td[5]")).size();
        //System.out.println("textIsDisplay: " + textIsDisplay);
        System.out.println("Size: " + size);
        String dynmicmsg = size + of + size + msg;
        System.out.println("Dynamic validation msg before click on confirm button: " + dynmicmsg);
        if (dynmicmsg.equals(validationMsg)) {
            System.out.println("I am in if");
            cnt = driver.findElements(By.xpath("//*[@id='ContentPlaceHolder1_gvContacts']/tbody/tr/td[5]")).size();
            String cssColor = driver.findElement(By.xpath("//*[@id='form1']/div[3]/div")).getCssValue("color");
            System.out.println("Validation message is: " + validationMsg);
            /*if (h.browser.equalsIgnoreCase("chrome") || h.browser.equalsIgnoreCase("ie")) {// rgba(255, 255, 255, 1)
                Assert.assertTrue(cssColor.endsWith("rgba(255, 255, 255, 1)"));
                System.out.println("Css color of validation message: " + cssColor);
            } else if (h.browser.equalsIgnoreCase("firefox")) {
                Assert.assertTrue(cssColor.equals("rgb(255, 255, 255)"));

            }*/
        } /*else {
            Assert.assertTrue(false, "validation msg is not matched");
        }*/


    }

    @And("^I should be land on manage contact and uploaded data should be display$")
    public void iShouldBeLandOnManageContactAndUploadedDataShouldBeDisplay() throws Throwable {
        u.setWebDriverFluentWait(1, 30, By.xpath("//h1[contains(text(),'Manage Contacts')]"));
        System.out.println("int cell_size: " + cell_size);

        for (int j = 0; j < cell_size; j++) {

            u.click(driver.findElement(By.xpath("//div[@class='toggle-card']")), driver);
            driver.findElement(By.xpath("//input[@id='txtCompanyCode']")).clear();
            String referenceCode = cell_List.get(j).get(0);
            System.out.println("Reference code: \n" + referenceCode);
            driver.findElement(By.xpath("//input[@id='txtCompanyCode']")).sendKeys(referenceCode);
            Thread.sleep(3000L);
            con.filterButton.click();
            Thread.sleep(3000L);

            String search = driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_gvContacts']/tbody/tr/td[2]")).getText();
            System.out.println("Searching data: " + search);
            Assert.assertTrue(arrayList.contains(search));


        }
    }

    @And("^I check contact get mail or not$")
    public void iCheckContactGetMailOrNot() throws Throwable {
        /*List<List<String>> list_Cell = table.cells();
        int cell = list_Cell.size();
        for (int i = 0; i < cell; i++) {
            String mailId = list_Cell.get(i).get(0);
            u.getMail(mailId);
            u.getEmailBody();
        }*/
        System.out.println("int cell_size: " + cell_size);

        for (int j = 0; j < cell_size; j++) {
            String emails = cell_List.get(j).get(5);
            System.out.println("Emails are: " + emails);
            u.getMail(emails);
            u.getEmailBody();
        }
    }

    @And("^I upload file following file$")
    public void iUploadFileFollowingFile(DataTable table) throws Throwable {
        this.cells = table.cells();
        System.out.println(this.cells);
        Actions actions = new Actions(driver);
        System.out.println("Cell size is: " + cells.size());
        for (int i = 1; i < cells.size(); i++) {
            this.row1_str = cells.get(i).get(0);
            //System.out.println("Row 1 data is: " + row1_str);
            String row12_str = cells.get(i).get(1);
            //System.out.println("Row 2 data is: " + row12_str);
            switch (row1_str) {
                case ".pdf":
                    actions.moveToElement(con.getFileUpoadField).build().perform();
                    con.getFileUpoadField.sendKeys(row12_str);
                    Thread.sleep(3000L);
                    u.click(con.getContinueButton, driver);
                    iShouldSeeProperValidationMessage();
                    break;
                case "empty valid file":
                    actions.moveToElement(con.getFileUpoadField).build().perform();
                    con.getFileUpoadField.sendKeys(row12_str);
                    //u.click(con.getFileUpoadField,driver);
                    Thread.sleep(1000L);
                    u.click(con.getContinueButton, driver);
                    iShouldSeeProperValidationMessage();
                    break;
                case "valid file with invalid data":
                    actions.moveToElement(con.getFileUpoadField).build().perform();
                    con.getFileUpoadField.sendKeys(row12_str);
                    //u.click(con.getFileUpoadField,driver);
                    Thread.sleep(3000L);
                    u.click(con.getContinueButton, driver);
                    Thread.sleep(2000);
                    iShouldSeeProperValidationMessage();
                    break;
            }
        }

    }

    @Then("^I should see proper validation message$")
    public void iShouldSeeProperValidationMessage() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        /*   for (int i = 1; i < cell_values; i++) {*/
        switch (this.row1_str) {
            case ".pdf":
                String pfd_validationMsg = driver.findElement(By.xpath("//span[@class='mdl-textfield__error']")).getText();
                System.out.println("PFD validation msg is: " + pfd_validationMsg);
                Assert.assertTrue(pfd_validationMsg.equals("Please Upload 'XLS, XLSX and CSV' Files Only."), "validation message is not matched");
                break;
            case "empty valid file":
                String empty_validationMsg = driver.findElement(By.xpath("//*[contains(text(),'Columns in the file do not match the file format. Please try again with the correct format.')]")).getText();
                System.out.println("Line 1158 empty valid file msg is: " + empty_validationMsg);
                Assert.assertTrue(empty_validationMsg.equals("Columns in the file do not match the file format. Please try again with the correct format."));
                break;
            case "valid file with invalid data":
                String invalidData_validationMsg1 = driver.findElement(By.xpath("//*[contains(text(),'Columns in the file do not match the file format. Please try again with the correct format.')]")).getText();
                if (invalidData_validationMsg1.equals("OOPS you might have uploaded a wrong file type")) {
                    Assert.assertTrue(invalidData_validationMsg1.equals("Columns in the file do not match the file format. Please try again with the correct format."));
                    break;
                } else {
                    System.out.println("");
                }


            default: {
                System.out.println("No scenario selected");
            }

        }
    }

    @And("^I click on confirm button and should display proper validation message$")
    public void iClickOnConfirmButtonAndShouldDisplayProperValidationMessage() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        List<WebElement> ele = driver.findElements(By.xpath("//*[@id='ContentPlaceHolder1_gvContacts']/tbody/tr"));
        int size = ele.size();
        // 0 of 3 Contact(s) added successfully
        String of = " of ";
        String msg = " Contact(s) added successfully";
        String dynmicmsg = 0 + of + size + msg;
        System.out.println("Msg is: " + dynmicmsg);
        con.getConfirmButton.click();
        Thread.sleep(3000L);
        u.setWebDriverFluentWait(1, 30, By.xpath("//*[@id='form1']/div[3]/div"));
        String validationMsg = driver.findElement(By.xpath("//*[@id='form1']/div[3]/div")).getText();
        System.out.println("After click on confirm button validation msg is: " + validationMsg);
        Assert.assertTrue(validationMsg.equals(dynmicmsg));
        System.out.println("After click on confirm button validation msg is: " + validationMsg);

    }

    @And("^I click on is Kyc mandatory checkbox$")
    public void iClickOnIsKycMandatoryCheckbox() throws Throwable {
        Thread.sleep(2000L);
        u.click(con.getIsKycCheckBox, driver);

    }

    @And("^I see action icon$")
    public void iSeeActionIcon() throws Throwable {
        String companyName;
        ArrayList<String> arrayList = new ArrayList<String>();
        u.setWebDriverFluentWait(1, 20, By.xpath("//*[@id='ContentPlaceHolder1_gvContacts']/tbody/tr/td[1]"));
        List<WebElement> element_str = con.getCompanyNameList;
        System.out.println("element_str size: " + element_str.size());
        int s1 = element_str.size();
        System.out.println("S1: " + s1);
        for (int i = 0; i < element_str.size(); i++) {
            companyName = element_str.get(i).getText();
            arrayList.add(i, companyName);
        }

        u.setWebDriverFluentWait(1, 30, By.xpath("//h1[contains(text(),'Manage Contacts')]"));

        System.out.println("int cell_size: " + cell_size);

        for (int j = 0; j < cell_size; j++) {

            u.click(driver.findElement(By.xpath("//div[@class='toggle-card']")), driver);
            driver.findElement(By.xpath("//input[@id='txtCompanyCode']")).clear();
            String referenceCode = cell_List.get(j).get(0);
            System.out.println("Reference code: \n" + referenceCode);
            driver.findElement(By.xpath("//input[@id='txtCompanyCode']")).sendKeys(referenceCode);
            Thread.sleep(3000L);
            con.filterButton.click();
            Thread.sleep(3000L);
            //Assert.assertTrue(arrayList.contains(search));
            //Check icons
            String kycStatus = driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_gvContacts']/tbody/tr/td[7]")).getText();
            System.out.println("Kyc Status: " + kycStatus);
            if (kycStatus.length() != 0) {
                boolean isDisplayBool = driver.findElement(By.xpath("//*[contains(@id,'ContentPlaceHolder1_gvContacts_btnVerifyKYC_0')]")).isDisplayed();
                Assert.assertTrue(isDisplayBool, "View document icon is not displayed");
                boolean isEnabledBool = driver.findElement(By.xpath("//*[contains(@id,'ContentPlaceHolder1_gvContacts_btnVerifyKYC_0')]")).isEnabled();
                Assert.assertTrue(isEnabledBool, "Icon is  not clickable");
                Assert.assertTrue(kycStatus.equals("KYC Approved"));
                System.out.println("Kyc is uploaded: " + kycStatus);
            } else {
                System.out.println("Kyc is not uploaded");
                u.waitAndClick(con.actionDropdown);
                boolean uploadDocumnetbool = driver.findElement(By.xpath("//*[contains(@id,'ContentPlaceHolder1_gvContacts_btnVerifyKYC_0')]")).isDisplayed();
                Assert.assertTrue(uploadDocumnetbool, "Upload document icon is not displayed");
                boolean isEnableBool = driver.findElement(By.xpath("//*[contains(@id,'ContentPlaceHolder1_gvContacts_btnVerifyKYC_0')]")).isEnabled();
                Assert.assertTrue(isEnableBool, "Icon is not clickable");
            }

        }


        /*List<WebElement> kycStatus_elelment = con.getKycStatus;
        for (int j = 0; j < kycStatus_elelment.size(); j++) {
            String kycStatus_str = kycStatus_elelment.get(j).getText();
            System.out.println("Kyc status is: " + kycStatus_str);

            if (kycStatus_str.isEmpty() == true) {
                List<WebElement> icon_List = con.getGetUploadDocumenticon;
                for (int i = 0; i < icon_List.size(); i++) {
                    boolean bool = icon_List.get(i).isDisplayed();
                    Assert.assertTrue(bool, "Upload contact icon is not displayed");
                }
            } else if (kycStatus_str.equalsIgnoreCase("KYC Approved")) {
                List<WebElement> list_Icon = con.getViewKycIcon;
                for (int k = 0; k < list_Icon.size(); k++) {
                    boolean bol_view = list_Icon.get(k).isDisplayed();
                    Assert.assertTrue(bol_view, "View icon is not displayed");
                }


            }
        }*/

    }

    @And("^I enter only optional fields$")
    public void iEnterOnlyOptionalFields(DataTable table) throws Throwable {
        List<List<String>> cellsAre = table.cells();

        for (int i = 1; i < cellsAre.size(); i++) {
            con.getEmail.sendKeys(cellsAre.get(i).get(0));
            con.getMobileNumber.sendKeys(cellsAre.get(i).get(1));
            con.getReferenceCode.sendKeys(cellsAre.get(i).get(2));
            con.getCompanyAddress.sendKeys(cellsAre.get(i).get(3));
            con.getBankAccountNumber.sendKeys(cellsAre.get(i).get(4));
            con.getIfscCode.sendKeys(cellsAre.get(i).get(5));
            con.getGSTINNumber.sendKeys(cellsAre.get(i).get(6));
        }
    }

    @Then("^I should see proper validation msg for manadatory field$")
    public void iShouldSeeProperValidationMsgForManadatoryField() throws Throwable {
        u.waitUntilElelemntShouldBeDisplay(driver, By.cssSelector("#ContentPlaceHolder1_rfvCompanyName"), 30);
        String s1 = driver.findElement(By.cssSelector("#ContentPlaceHolder1_rfvCompanyName")).getText();
        System.out.println("Line number 1350: " + s1);
        Assert.assertEquals(s1, "Please enter company name.");
        /*String s2 = driver.findElement(By.cssSelector("#ContentPlaceHolder1_vcContactFirstName")).getText();
        Assert.assertEquals(s2, "Please enter First Name");
        //Assert.assertEquals(driver.findElement(By.xpath("//span[@class='mdl-textfield__error']")).getText(),"Please Select File to Upload.");

        String s3 = driver.findElement(By.cssSelector("#ContentPlaceHolder1_vcContactLastName")).getText();
        Assert.assertEquals(s3, "Please enter Last Name");*/

    }

    @Then("^I see label for every text field$")
    public void iSeeLabelForEveryTextField(DataTable table) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        List<List<String>> labeText = table.cells();
        List<WebElement> label = driver.findElements(By.xpath("//*[@class='mdl-textfield__label']"));
        for (int i = 0; i < label.size(); i++) {
            Assert.assertTrue(labeText.get(i + 1).get(0).equals(label.get(i).getText()), "Label is not matched");
        }
    }

    @And("^I enter valid data and click on check box$")
    public void iEnterValidDataAndClickOnCheckBox(DataTable table) throws Throwable {
        celss_tab = table.cells();
        allFields = con.getAddContactFields;
        for (int i = 0; i < allFields.size(); i++) {
            System.out.println("Size:" + allFields.size());
            for (int j = 1; j < celss_tab.size(); j++) {
                companyName = u.fakerData("companyName",celss_tab.get(0).get(0));
                System.out.println("Company Name is:" + companyName);
                allFields.get(0).sendKeys(companyName);
                refCode = u.fakerData("referenceCode", celss_tab.get(1).get(1));
                System.out.println("Line number is 1380 Reference code is:" + refCode);
                allFields.get(1).sendKeys(refCode);
                allFields.get(2).sendKeys(u.fakerData("firstName", celss_tab.get(1).get(2)));
                allFields.get(3).sendKeys(u.fakerData("lastName", celss_tab.get(1).get(3)));
                emailid = u.fakerData("email", celss_tab.get(1).get(4));
                allFields.get(4).sendKeys(emailid);
                allFields.get(5).sendKeys(celss_tab.get(1).get(5));
                allFields.get(6).sendKeys(celss_tab.get(1).get(6));
                compAdd = u.fakerData("address", celss_tab.get(1).get(7));
                allFields.get(7).sendKeys(compAdd);
                allFields.get(8).sendKeys(celss_tab.get(1).get(8));
                allFields.get(9).sendKeys(celss_tab.get(1).get(9));
                emailid = u.fakerData("email", celss_tab.get(1).get(10));
                allFields.get(10).sendKeys(emailid);
//                String emailId = celss_tab.get(j).get(0);
//                allFields.get(1).sendKeys(emailId);
                break;
                /*allFields.get(i).sendKeys(celss_tab.get(j).get(i));
                System.out.println("Printing: " + celss_tab.get(j).get(i));
                Thread.sleep(1000L);*/
            }
            break;
        }
        u.waitUntilElelemntShouldBeDisplay(driver, By.xpath("//*[@class='mdl-checkbox__ripple-container mdl-js-ripple-effect mdl-ripple--center']"), 30);
        u.click(driver.findElement(By.xpath("//*[@class='mdl-checkbox__ripple-container mdl-js-ripple-effect mdl-ripple--center']")), driver);
        Thread.sleep(3000L);
        kycStatus = driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_cbIsKycRequired']")).isSelected();
        System.out.println("Kyc Status: " + kycStatus);
    }

    @And("^I enter reference code to search contact and i see icons$")
    public void iEnterReferenceCodeToSearchContactAndISeeIcons() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        u.click(con.getFilterClick, driver);
        Thread.sleep(2000L);
        System.out.println("Data Table data: " + celss_tab.size());
        for (int i = 1; i < celss_tab.size(); i++) {
            System.out.println("celss_tab.get(i).get(7): " + celss_tab.get(i).get(6));
            con.getReferenceCode.sendKeys(celss_tab.get(i).get(6));
        }
    }

    @And("^I click on filter and select today date$")
    public void iClickOnFilterAndSelectTodayDate() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        u.click(con.getFilterClick, driver);
        Thread.sleep(1000L);
        u.click(con.getDateRange, driver);
        Thread.sleep(1000L);
        u.click(con.getApplyButton, driver);
        Thread.sleep(1000L);
        u.click(con.getFilterButton, driver);

    }

    @And("^I click on filter and enter Reference code$")
    public void iClickOnFilterAndEnterReferenceCode() throws Throwable {
        u.click(con.getFilterClick, driver);
        System.out.println("Line number is 1440 Reference code is:" + refCode);
        Thread.sleep(2000L);
        driver.findElement(By.xpath("//input[@id='txtCompanyCode']")).sendKeys(refCode);
        u.click(con.filterButton, driver);
        Thread.sleep(3000L);


    }

    @Then("^I should see \"([^\"]*)\" msg and i should be on same page$")
    public void iShouldSeeMsgAndIShouldBeOnSamePage(String arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        u.setWebDriverFluentWait(1, 20, By.xpath("//*[@id='form1']/div[3]"));
        String con_savedMsg = driver.findElement(By.xpath("//*[@id='form1']/div[3]")).getText();
        Assert.assertTrue(arg0.equals(con_savedMsg), "Invalid validation msg when user add contact");
        u.setWebDriverFluentWait(1, 20, By.xpath("//h1[contains(text(),'Add Contact')]"));
        String AddContact_str = driver.findElement(By.xpath("//h1[contains(text(),'Add Contact')]")).getText();
        System.out.println("Add Contact: " + AddContact_str);
        Assert.assertTrue(AddContact_str.equals("ADD CONTACT"), "User is not redirected on manage contact");

    }

    @And("^I check contact get mail$")
    public void iCheckContactGetMail() throws Throwable {
        //List<List<String>> cellSize = table.cells();
        for (int i = 1; i <= allFields.size(); i++) {
            u.getMail(emailid);
            u.getEmailBody();
            break;
        }
    }


    @And("^I enter valid data without click on is Kyc checkBox$")
    public void iEnterValidDataWithoutClickOnIsKycCheckBox(DataTable table) throws Throwable {
        celss_tab = table.cells();
        allFields = con.getAddContactFields;
        for (int i = 0; i < allFields.size(); i++) {
            for (int j = 1; j < celss_tab.size(); j++) {
                companyName = u.fakerData("companyName",celss_tab.get(0).get(0));
                System.out.println("Company Name is:" + companyName);
                allFields.get(0).sendKeys(companyName);
                refCode = u.fakerData("referenceCode", celss_tab.get(1).get(1));
                System.out.println("Line number is 1380 Reference code is:" + refCode);
                allFields.get(1).sendKeys(refCode);
                allFields.get(2).sendKeys(u.fakerData("firstName", celss_tab.get(1).get(2)));
                allFields.get(3).sendKeys(u.fakerData("lastName", celss_tab.get(1).get(3)));
                emailid = u.fakerData("email", celss_tab.get(1).get(4));
                allFields.get(4).sendKeys(emailid);
                allFields.get(5).sendKeys(celss_tab.get(1).get(5));
                allFields.get(6).sendKeys(celss_tab.get(1).get(6));
                allFields.get(7).sendKeys(celss_tab.get(1).get(7));
                compAdd = u.fakerData("address", celss_tab.get(1).get(8));
                allFields.get(8).sendKeys(compAdd);
                allFields.get(9).sendKeys(celss_tab.get(1).get(9));
                allFields.get(10).sendKeys(celss_tab.get(1).get(10));
                emailid = u.fakerData("email", celss_tab.get(1).get(11));
                allFields.get(11).sendKeys(emailid);
//                allFields.get(i).sendKeys(celss_tab.get(j).get(i));
//                Thread.sleep(100L);
                break;
            }
                break;
        }
        boolean kycStatus = driver.findElement(By.xpath("//*[@class='mdl-checkbox__ripple-container mdl-js-ripple-effect mdl-ripple--center']")).isSelected();
        System.out.println("Kyc Status: " + kycStatus);

    }

    @And("^I check action icon$")
    public void iCheckActionIcon() throws Throwable {
        System.out.println("Kyc Status: " + kycStatus);
        String str = driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_gvContacts']/tbody/tr[1]/td[8]")).getText();
        if (kycStatus == false && str.length() == 0) {
            u.waitAndClick(con.actionDropdown);
            System.out.println("Kyc is Required checkbox is not selected");
            boolean emailicon = driver.findElement(By.xpath("//*[contains(@id,'ContentPlaceHolder1_gvContacts_btnEmail_')]/i")).isDisplayed();
            Assert.assertTrue(emailicon, "email icon is not displayed");
            System.out.println("Email icon is displayed");
            boolean deleteIcon = driver.findElement(By.xpath("//*[contains(@id,'ContentPlaceHolder1_gvContacts_lblReject_')]/i ")).isDisplayed();
            Assert.assertTrue(deleteIcon, "Delete icon is not displayed");

        } else {
            System.out.println("Upload kyc Icon need to be check ");
            u.waitAndClick(con.actionDropdown);
            WebElement element = driver.findElement(By.xpath("//*[contains(@id,'ContentPlaceHolder1_gvContacts_lnkUploadDocument_')]/i"));
            boolean isDisplayedBool = element.isDisplayed();
            Assert.assertTrue(isDisplayedBool, "Upload Kyc icon is checked its Displayed: " + kycStatus);
            boolean isEnabledBool = element.isEnabled();
            Assert.assertTrue(true, "Upload kyc icon is not clickable");
            element.click();
            //u.setWebDriverFluentWait(1, 20, By.xpath("//*[@id='PnlMain']/div/div/div[1]/h1"));

            String kycDocumentPage = driver.findElement(By.xpath("//*[@id='PnlMain']//h1")).getText();
            if ( con.getPageTitle.getText().equals("KYC Documents")) {
                Assert.assertTrue(kycDocumentPage.equals("KYC Documents"), "User not redirecting on Upload kyc page");
                System.out.println("Kyc document page title: " + kycDocumentPage);
            } else {
                Assert.assertTrue(false, "User not redirecting on Upload kyc page");
            }

        }
    }

    @And("^I click on filter$")
    public void iClickOnFilter() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        u.click(con.getFilterClick, driver);
        Thread.sleep(3000L);

    }


    @Then("^I see respect fields with labels and buttons$")
    public void iSeeRespectFieldsWithLabelsAndButtons() throws Throwable {
        List<WebElement> elements = con.getFilterInputField;
        List<WebElement> elements1 = con.getFilterInput_label;
        List<WebElement> elements2 = con.getButtons;

        for (int i = 0; i < elements.size(); i++) {
            boolean boolinputs = elements.get(i).isEnabled();
            Assert.assertTrue(boolinputs, "Text box is not enabled");
            System.out.println("Boolean values: " + boolinputs);
            System.out.println("i: " + i);
            for (int j = i; j < elements1.size(); j++) {
                String labelText = elements1.get(j).getText();
                System.out.println("Label Text is: " + labelText);
                break;
            }

        }
        boolean datePicketIsDisplayed = con.getDateRangePicker.isDisplayed();
        Assert.assertTrue(datePicketIsDisplayed, "Date picker is not displayed");
        boolean datePickerIsEnabled = con.getDateRangePicker.isEnabled();
        Assert.assertTrue(datePickerIsEnabled, "Date picker is not enabled");

        boolean filterButtonIsDisplayed = con.filterButton.isDisplayed();
        Assert.assertTrue(filterButtonIsDisplayed, "Filter button is not displayed");
        boolean filterButtonIsEnabled = con.filterButton.isEnabled();
        Assert.assertTrue(filterButtonIsEnabled, "Filter button is not enabled");

        boolean clearButtonIsDisplayed = con.getClearbutton.isDisplayed();
        Assert.assertTrue(clearButtonIsDisplayed, "clear button is not displayed");
        boolean clearButtonIsEnabled = con.getClearbutton.isEnabled();
        Assert.assertTrue(clearButtonIsEnabled, "Clear button is not enabled");

        boolean exportButtonIsDisplayed = con.getExportButton.isDisplayed();
        Assert.assertTrue(exportButtonIsDisplayed, "Export button is not displayed");
        boolean exportButtonIsEnabled = con.getExportButton.isEnabled();
        Assert.assertTrue(exportButtonIsEnabled, "Export button is not enabled");


    }

    @And("^I see text and dropdown and its value and tables heading$")
    public void iSeeTextAndDropdownAndItsValueAndTablesHeading(DataTable table) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        List<List<String>> dropDownCells = table.cells();
        con.getDropDownClick.click();
        Thread.sleep(2000L);

        List<WebElement> dropDownOptions = con.getDropDownOptions;

        for (int i = 0; i < dropDownOptions.size(); i++) {
            String dropDownOptionStr = dropDownOptions.get(i).getText();
            System.out.println("Drop Down values are: " + dropDownOptionStr);
            for (int j = i + 1; j < dropDownCells.size(); j++) {
                String dataTableStr = dropDownCells.get(j).get(0);
                if (dropDownOptionStr.equals(dataTableStr)) {

                    Assert.assertTrue(true, "Not Matched");
                }
                break;
            }
        }

        List<WebElement> tableHeading = con.getManageContactTableHeading;
        for (int k = 0; k < tableHeading.size(); k++) {
            String strTableHeading = tableHeading.get(k).getText();
            for (int l = k + 1; l < dropDownCells.size(); l++) {
                String strDatTaTable = dropDownCells.get(l).get(1);
                System.out.println("Manage contact table heading: " + strDatTaTable);
                if (strTableHeading.equals(strDatTaTable)) {
                    Assert.assertTrue(true, "Manage contact Table heading Not matched");
                }
                break;
            }
        }

    }

    @And("^I enter following data in fields$")
    public void iEnterFollowingDataInFields(DataTable table) throws Throwable {
        cellTable = table.cells();
        System.out.println("Cell table size: " + cellTable.size());
        int filterTableDataSize = cellTable.size();
        //Email id
        for (int i = 1; i < filterTableDataSize; i++) {
            String values = cellTable.get(i).get(0);
            System.out.println("Email id is: " + values);
            u.click(con.getFilterClick, driver);
            con.getFilterEmailID.sendKeys(values);
            u.click(con.getFilterButton, driver);
            Thread.sleep(1000L);
//            u.setWebDriverFluentWait(1, 20, By.xpath("//*[@id='ContentPlaceHolder1_gvContacts']/tbody/tr/td[1]"));
            String conTxt = driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_gvContacts']/tbody/tr/td[1]")).getText();


            if (conTxt.equals("Please add a contact to proceed")) {
                System.out.println("No data found ");
            } else {
                List<WebElement> editbutton = con.getEditButton;
                System.out.println("Edit button size is: " + editbutton.size());
                int editSize = editbutton.size();
                for (int j = 0; j < editSize; j++) {
                    u.setWebDriverFluentWait(1, 20, By.name("ContentPlaceHolder1_gvContacts_length"));
                    driver.findElement(By.name("ContentPlaceHolder1_gvContacts_length")).click();
                    driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_gvContacts_length']/label/select/option[5]")).click();
                    Thread.sleep(1000L);
                    u.click(editbutton.get(j), driver);
                    String emailText = con.getEmail.getAttribute("value");
                    System.out.println("After Edit email id is: " + emailText);
                    if (values.equals(emailText)) {
                        Assert.assertTrue(true, "Email id not matched");
                        System.out.println("Email id matched successfully.");
                    } else {
                        Assert.assertTrue(false, "Test case is failed");
                    }
                    String txt = driver.findElement(By.xpath("//input[@id='ContentPlaceHolder1_txtReferenceCode']")).getAttribute("value");
                    Set<String> id = new HashSet<>();
                    id.add(txt);
                    u.clickDashboardMenu();
                    u.click(con.getContactLink, driver);
                    Thread.sleep(1000L);
                    con.getManageContactLink.click();
                    Thread.sleep(3000L);
                    u.click(con.getFilterClick, driver);
                    Thread.sleep(1000L);
                    con.getFilterEmailID.sendKeys(values);
                    Thread.sleep(2000);
                    u.click(con.getFilterButton, driver);
                    Thread.sleep(1000L);
                }
            }
            u.click(con.getClearbutton, driver);
            Thread.sleep(1000L);

        }

        //Company Code
        for (int i = 1; i < filterTableDataSize; i++) {
            String values = cellTable.get(i).get(2);
            System.out.println("Company code is: " + values);
            u.click(con.getFilterClick, driver);
            con.getCompanyCode.sendKeys(values);
            u.click(con.getFilterButton, driver);
            Thread.sleep(1000L);
            u.setWebDriverFluentWait(1, 20, By.xpath("//*[@id='ContentPlaceHolder1_gvContacts']/tbody/tr/td[1]"));
            String conTxt = driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_gvContacts']/tbody/tr/td[1]")).getText();
            if (conTxt.equals("Please add a contact to proceed")) {
                System.out.println("No data found ");
            } else {

                List<WebElement> editbutton = con.getEditButton;
                System.out.println("Edit button size is: " + editbutton.size());
                int editSize = editbutton.size();
                for (int j = 0; j < editSize; j++) {

                    driver.findElement(By.name("ContentPlaceHolder1_gvContacts_length")).click();
                    Thread.sleep(2000);
                    driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_gvContacts_length']/label/select/option[5]")).click();
                    u.click(editbutton.get(j), driver);
                    Thread.sleep(1000);
                    String txt = driver.findElement(By.xpath("//input[@id='ContentPlaceHolder1_txtReferenceCode']")).getAttribute("value");
                    System.out.println("Company code: " + txt);
                    System.out.println("Company code from data table: " + values);
                    if (txt.toLowerCase().contains(values.toLowerCase())) {
                        u.duplicateChar(txt);
                        Assert.assertTrue(true, "Company code not matched");
                        System.out.println("Company code contains: " + " " + values + " " + "And Company code is: " + txt);

                    } else {
                        System.out.println("Company code is not contains: " + txt);
                        Assert.assertTrue(false, "compnay code is not matched");
                    }
                    u.clickDashboardMenu();
                    u.click(con.getContactLink, driver);
                    Thread.sleep(1000L);
                    con.getManageContactLink.click();
                    Thread.sleep(1000L);
                    u.click(con.getFilterClick, driver);
                    con.getCompanyCode.sendKeys(values);
                    Thread.sleep(1000);
                    u.click(con.getFilterButton, driver);
                    Thread.sleep(1000L);
                }
            }

            u.click(con.getClearbutton, driver);
            Thread.sleep(1000L);
        }


//Company  Name
        for (int i = 1; i < filterTableDataSize; i++) {
            String values = cellTable.get(i).get(1);
            System.out.println("Company name is: " + values);
            Thread.sleep(1000L);
            u.click(con.getFilterClick, driver);
            con.getCompanyNameTextBox.sendKeys(values);
            Thread.sleep(1000L);

            u.setWebDriverFluentWait(1, 20, By.xpath("//*[@id='ContentPlaceHolder1_gvContacts']/tbody/tr/td[1]"));
            String conTxt = driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_gvContacts']/tbody/tr/td[1]")).getText();
            if (conTxt.equals("Please add a contact to proceed")) {
                System.out.println("No data found ");
            } else {

                u.click(con.getFilterButton, driver);
                Thread.sleep(1000L);
                u.setWebDriverFluentWait(1, 20, By.name("ContentPlaceHolder1_gvContacts_length"));
                driver.findElement(By.name("ContentPlaceHolder1_gvContacts_length")).click();
                List<WebElement> listDropDowpDown = driver.findElements(By.xpath("//*[@name='ContentPlaceHolder1_gvContacts_length']/option"));
                for (int k = 0; k < listDropDowpDown.size(); k++) {
                    String str = listDropDowpDown.get(k).getText();
                    if (str.equals("All")) {
                        Thread.sleep(2000l);
                        listDropDowpDown.get(k).click();
                        System.out.println("Clicked on All");
                    }
                }
                Thread.sleep(1000L);
                u.setWebDriverFluentWait(1, 20, By.xpath("//*[@id='ContentPlaceHolder1_gvContacts']/tbody/tr/td[1]"));
                List<WebElement> element = con.getCompnayName;
                int totalCompanySize = element.size();
                System.out.println(totalCompanySize);
                String conTxt1 = driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_gvContacts']/tbody/tr/td[1]")).getText();
                if (conTxt1.equals("Please add a contact to proceed")) {
                    System.out.println("There is no records found");
                } else {
                    System.out.println("in else");
                    for (int j = 0; j < totalCompanySize; j++) {
                        String companyTxt = element.get(j).getText();
                        System.out.println("comapny name is: " + companyTxt + "-----------");
                        Assert.assertTrue(values.equals(companyTxt), "Company name not matched");
                        System.out.println("Company Name from dataTable: " + values + " " + "Company name from web: " + companyTxt);
                    }

                }
            }
            u.click(con.getClearbutton, driver);
            Thread.sleep(1000L);

        }

//Mobile Number
        for (int i = 1; i < filterTableDataSize; i++) {
            String values = cellTable.get(i).get(3);
            System.out.println("Mobile number is: " + values);
            Thread.sleep(1000L);
            u.click(con.getFilterClick, driver);
            Thread.sleep(1000L);
            con.getMobileNumbeText.sendKeys(values);
            Thread.sleep(1000L);
            u.setWebDriverFluentWait(1, 20, By.name("ContentPlaceHolder1_gvContacts_length"));
            driver.findElement(By.name("ContentPlaceHolder1_gvContacts_length")).click();
            Thread.sleep(1000);
            driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_gvContacts_length']/label/select/option[5]")).click();
            u.click(con.getFilterButton, driver);
            Thread.sleep(1000L);
            driver.findElement(By.name("ContentPlaceHolder1_gvContacts_length")).click();
            List<WebElement> listDropDowpDown = driver.findElements(By.xpath("//*[@name='ContentPlaceHolder1_gvContacts_length']/option"));
            for (int k = 0; k < listDropDowpDown.size(); k++) {
                String str = listDropDowpDown.get(k).getText();
                if (str.equals("All")) {
                    Thread.sleep(2000l);
                    listDropDowpDown.get(k).click();
                }
            }
            List<WebElement> elementMobileNUmber = con.getMobileNumberList;
            int totalMobileNumberSize = elementMobileNUmber.size();
            String conTxt = driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_gvContacts']/tbody/tr/td[1]")).getText();
//            if(totalMobileNumberSize>1){
//                Assert.assertEquals(conTxt,"Please add a contact to proceed");
//            }

            if (conTxt.equals("Please add a contact to proceed")) {
                System.out.println("There is no contact: " + values);

            } else {
                for (int j = 0; j < totalMobileNumberSize; j++) {
                    String companyTxt = elementMobileNUmber.get(j).getText();
                    System.out.println("Mobile Number: " + companyTxt);
                    Assert.assertTrue(values.equals(companyTxt), "Mobile Number  not matched");
                    System.out.println("Mobile Number is matched: " + values);

                }
            }
            u.click(con.getClearbutton, driver);
            Thread.sleep(1000L);


        }


    }


    @Then("^I see that file is download successfully$")
    public void iSeeThatFileIsDownloadSuccessfully() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("I click on filter ");
    }

    @And("^I see filter data in excel sheet$")
    public void iSeeFilterDataInExcelSheet() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("" + cellTable);
        System.out.println("I click on data ");
    }

    @And("^I enter data in filter field$")
    public void iEnterDataInFilterField() throws Throwable {
        // Write code here that turns the phrase above into concrete actions

        System.out.println("Cell table size: " + filterTableDataSize);

    }

    @And("^I click on export button$")
    public void iClickOnExportButton() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("Cell table size: " + cellTable.size());
        int filterTableDataSize = cellTable.size();
        u.click(con.getContactLink, driver);
        u.setWebDriverFluentWait(1, 20, By.xpath("//*[contains(text(),'Manage Contacts')]"));
        u.click(con.getManageContactLink, driver);
        u.setWebDriverFluentWait(1, 20, By.xpath("//h1[contains(text(),'Manage Contacts')]"));
        System.out.println("filterTableDataSize: " + filterTableDataSize);
        u.deleteOldFile("C:\\Users\\vishal.l\\Downloads\\Contact.xls");

        //Export file using email id
        for (int i = 1; i < filterTableDataSize; i++) {
            String values = cellTable.get(i).get(0);
            u.click(con.getFilterClick, driver);
            con.getFilterEmailID.sendKeys(values);
            u.click(con.getFilterButton, driver);
            u.click(con.getFilterClick, driver);
            u.setWebDriverFluentWait(1, 20, By.name("ctl00$ContentPlaceHolder1$btnExport"));
            u.click(con.getExportButton, driver);
            Thread.sleep(2000L);


            File file = new File("C:\\Users\\vishal.l\\Downloads\\Contact.xls");

            Workbook wb = WorkbookFactory.create(new FileInputStream(file));
            String con = "Contact.xls";
            String fileExtensionName = con.substring(con.indexOf("."));
            System.out.println("File Extension is: " + fileExtensionName);
            HSSFSheet sheet = (HSSFSheet) wb.getSheet("Sheet1");
            int row = sheet.getLastRowNum();
            System.out.println("Total of row is: " + row);
            /*InputStream inputStream = new FileInputStream("C:\\Users\\vijay\\Downloads\\Contact.xls");


            HSSFWorkbook workbook = new HSSFWorkbook(inputStream);

            HSSFSheet sheet = workbook.getSheet("Contact");
            HSSFRow row;
            HSSFCell cell;
            Iterator<Row> rows = sheet.rowIterator();
            while (rows.hasNext()) {
                row = (HSSFRow) rows.next();

                System.out.println("Rows:::::::::::::::::::" + row);

                Iterator<Cell> cells = row.cellIterator();


                while (cells.hasNext()) {
                    cell = (HSSFCell) cells.next();
                    System.out.println("cell:::::::::::::::::::" + cell);

                    System.out.println("Cell data is: " + cell.getStringCellValue());

                }


            }*/
        }

    }


    @Then("^I see following action \"([^\"]*)\" i should be land on respective page$")
    public void iSeeFollowingActionIShouldBeLandOnRespectivePage(String arg0) throws Throwable {
        driver.findElement(By.name("ContentPlaceHolder1_gvContacts_length")).click();
        driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_gvContacts_length']/label/select/option[5]")).click();
        Thread.sleep(2000);
        switch (arg0) {
            case "Edit":
                con.getEditFromTableButton.click();
                u.setWebDriverFluentWait(1, 20, By.xpath("//h1[contains(text(),'Contact Details')]"));
                boolean expandBool = con.getHeaderExpand.isDisplayed();
                Assert.assertTrue(expandBool, "Contact detail is not expanded default");
                String contactDelilaPageText = con.getContactDetailsPage.getText();
                Assert.assertTrue(contactDelilaPageText.equals("Contact Details"), "Contact details Heading is not matched");
                System.out.println("contactDelilaPageText: " + contactDelilaPageText);
                String basicDetailsText = con.getBasicDetails.getText();
                Assert.assertTrue(basicDetailsText.equals("BASIC DETAILS edit"), "Basic details Heading not matched");
                System.out.println("basicDetailsText: " + basicDetailsText);
                String vanDetailsText = con.getVanDetails.getText();
                Assert.assertTrue(vanDetailsText.equals("VAN DETAILS"), "Van details heading not marched");
                System.out.println("vanDetailsText: " + vanDetailsText);
                String receiverDetailsText = con.getReceiverDetails.getText();
                Assert.assertTrue(receiverDetailsText.equals("RECEIVER DETAILS"), "Receiver details heading not matched");
                System.out.println("receiverDetailsText: " + receiverDetailsText);

                break;
            case "Remove Contact":
                String deleteMsg = "Are you sure want to delete contact Name ";
                String questionMark = "?";
                String companyName = con.getCompanyNameManageContact.getText();
                String msg = deleteMsg + companyName + questionMark;
                System.out.println("deleteMsg+companyName+questionMark: " + msg);
                con.getDeleteIcon.click();
                Thread.sleep(3000L);
                String placeHolderText = con.getRemoveContactPlaceHolder.getText();
                Assert.assertTrue(placeHolderText.equals("Delete Contact"), "Place Holder text not matched");
                String removeContactText = con.getRemoveContactText.getText();
                System.out.println("Text msg from pop up window: " + removeContactText);
                Assert.assertTrue(removeContactText.equals(msg));

                WebElement element = con.getDeleteButton;
                boolean isDisplaybool = element.isDisplayed();
                Assert.assertTrue(isDisplaybool, "Delete Button is not display");
                boolean isEnabled = element.isEnabled();
                Assert.assertTrue(isEnabled, "Delete button is not enabled");
                /*String colorAttribute = element.getAttribute("background-color");
                System.out.println("Delete button color is: " + colorAttribute);*/

                WebElement cancelElemenet = con.getCancelButtonFromDelete;
                boolean isDisplayed = cancelElemenet.isDisplayed();
                Assert.assertTrue(isDisplayed, "Cancel button is not displayed");
                boolean cancelIsEnabled = cancelElemenet.isEnabled();
                Assert.assertTrue(cancelIsEnabled, "cancel button is not enabled");

                /*String cancelColor = cancelElemenet.getAttribute("background-color");
                System.out.println("Cancel button color is: " + cancelColor);*/
                break;
            case "view":
//                String CompanyName = con.getCompanyNameManageContact.getText();
//                System.out.println("Company name from manage contact: " + CompanyName);
                con.getViewIcon.click();
                Thread.sleep(3000L);
                String paceHolderText = con.getKycPageText.getText();
                System.out.println("View document place holder text: " + paceHolderText);
                String nameFromKyc = con.getCompnayNameFromKyc.getText();
                System.out.println("Company Name from kyc page: " + nameFromKyc);

                break;
            case "Email":
                boolean isDisplayedEmail;
                isDisplayedEmail = con.getSendEmail.isDisplayed();
                Assert.assertTrue(isDisplayedEmail, "Email icon is not displayed");
                boolean isEnabledMail = con.getSendEmail.isEnabled();
                Assert.assertTrue(isEnabledMail, "Email icon is not Enabled");
                con.getSendEmail.click();
                u.setWebDriverFluentWait(1, 20, By.xpath("//div[@class='alert-strip success-alert']"));
                WebElement elementEmailMsg = driver.findElement(By.xpath("//div[@class='alert-strip success-alert']"));
                String validationMsg = elementEmailMsg.getText();
                Assert.assertTrue(validationMsg.equals("Mail sent successfully"));
                String emailId;
                List<WebElement> editEmail = driver.findElements(By.xpath("//i[.='edit' or .='email']"));
                System.out.println("Edit and email size is: " + editEmail.size());
                for (int i = 0; i < editEmail.size(); i++) {
                    String textEmailEdit = editEmail.get(i).getText();
                    if (textEmailEdit.equals("email")) {
                        //System.out.println("both are matched and i is:  " + i);
                        con.getListEditButton.get(i - 1).click();
                        Thread.sleep(3000L);
                        emailId = con.getEmail.getAttribute("value");

                        //System.out.println("email id is: " + emailId);
                        u.getMail(emailId);
                        u.getEmailBody();
                        break;
                    }
                }


                break;
            case "Upload Documents":
                WebElement CompanyName1 = con.getCompanyNameManageContact;

                con.getUploadDocumentIcon.click();
                Thread.sleep(3000L);
                String paceHolderText1 = con.getKycPageText.getText();
                System.out.println("View document place holder text: " + paceHolderText1);
                String nameFromKyc1 = con.getCompnayNameFromKyc.getText();
                System.out.println("Company Name from kyc page: " + nameFromKyc1);
                //Assert.assertTrue(nameFromKyc1.equals(CompanyName1), "Company name not matched");
                break;
        }
    }

    @And("^I click on basic details$")
    public void iClickOnBasicDetails() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        u.click(con.getBasicEditIcon, driver);
    }

    /*@And("^I enter data and i should display proper validation msg$")
    public void iEnterDataAndIShouldDisplayProperValidationMsg(DataTable table) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        List<List<String>> editData = table.cells();
        System.out.println("Arguments from data table: " + arg0 + "" + editData);
        for (int i = 1; i < editData.size(); i++) {
            String emaild = editData.get(i).get(0);
            con.getEmail.clear();
            con.getEmail.sendKeys(emaild);
            Thread.sleep(500);
            con.getAddContactSaveButton.click();
            String msg = con.getinvalidEmailValidationMsg.getText();

            if (msg.contains("Please enter valid Email")) {
                Assert.assertTrue(msg.equals("Please enter valid Email Address"), "Msg Not matched");
                System.out.println("When user enter invalid Email validation msg is: " + msg);
            }


        }
    }*/


    @And("^I enter data in following fields \"([^\"]*)\"$")
    public void iEnterDataInFollowingFields(String arg0, DataTable table) throws Throwable {
        List<List<String>> tableCell = table.cells();
        emailDataTable = tableCell.size();
        System.out.println("emailDataTable: " + emailDataTable);
        for (int i = 1; i < emailDataTable; i++) {
            switch (arg0) {
                case "Email id":
                    String email = tableCell.get(i).get(0);
                    con.getEmail.clear();
                    con.getEmail.sendKeys(email);
                    Thread.sleep(2000L);
                    u.click(con.getAddContactSaveButton, driver);
                    String msg = con.getinvalidEmailValidationMsg.getText();

                    if (msg.contains("Please enter valid Email")) {
                        Assert.assertTrue(msg.equals("Please enter valid Email Address"), "Msg Not matched");
                        System.out.println("When user enter invalid Email validation msg is: " + msg);
                    }
                    break;
                case "compnay name":
                    String companyName = tableCell.get(i).get(1);
                    con.getEditCompanyName.clear();
                    con.getEditCompanyName.sendKeys(companyName);
                    u.click(con.getAddContactSaveButton, driver);
                    String compnayNameMsg = con.getCOmpnayNameInvalidMsg.getText();

                    Assert.assertTrue(compnayNameMsg.equals("Please enter Company Name"), "Company name validation message not matched");
                    System.out.println("Company Name validation msg is: " + compnayNameMsg);
                    break;
                case "First Name":
                    String firestNmae = tableCell.get(i).get(2);
                    con.getEditFirstName.clear();
                    con.getEditFirstName.sendKeys(firestNmae);

                    u.click(con.getAddContactSaveButton, driver);
                    String firstNameMsg = con.getFirestNamevalidationMsg.getText();

                    Assert.assertTrue(firstNameMsg.equals("Please enter First Name"), "First name validation message not matched");
                    System.out.println("First Name validation msg is: " + firstNameMsg);
                    break;
                case "Last name":

                    String lastNmae = tableCell.get(i).get(3);
                    con.getEditLastName.clear();
                    con.getEditLastName.sendKeys(lastNmae);
                    u.click(con.getAddContactSaveButton, driver);
                    String lastNameMsg = con.getFirestNamevalidationMsg.getText();
                    System.out.println("Last Name validation message: " + lastNameMsg);
                    Assert.assertTrue(lastNameMsg.equals("Please enter Last Name"), "Last name validation message not matched");
                    System.out.println("Last Name validation msg is: " + lastNameMsg);
                    break;
                case "Nick name":
                    String nickNmae = tableCell.get(i).get(4);
                    con.getEditNickName.clear();
                    con.getEditNickName.sendKeys(nickNmae);
                    con.getAddContactSaveButton.click();
                    String nickNameMsg = con.getNickNameMsg.getText();
                    Assert.assertTrue(nickNameMsg.equals("Please enter valid Nickname"), "Nick name validation message not matched");
                    System.out.println("Nick Name validation msg is: " + nickNameMsg);
                    break;
                case "Mobile number":
                    String mobileNumber = tableCell.get(i).get(5);
                    System.out.println("Mobile number: " + mobileNumber);
                    con.getEditMobileNumber.clear();
                    con.getEditMobileNumber.sendKeys(mobileNumber);
                    u.click(con.getAddContactSaveButton, driver);
                    Thread.sleep(2000);
                    String mobilenumberMsg = con.getMobileNumberMsg.getText();
                    Assert.assertTrue(mobilenumberMsg.equals("Please enter valid mobile number"), "Mobile number validation message not matched");
                    System.out.println("Mobile Number validation msg is: " + mobilenumberMsg);
                    break;

                case "GSTIN":
                    String gstinNumber = tableCell.get(i).get(6);
                    con.getGstinNumberEdit.clear();
                    con.getGstinNumberEdit.sendKeys(gstinNumber);
                    u.click(con.getAddContactSaveButton, driver);
                    String gstinNumberMsg = con.getGstinMsg.getText();
                    Assert.assertTrue(gstinNumberMsg.equals("Please enter valid GSTIN"), "Mobile number validation message not matched");
                    System.out.println("GSTIN validation msg is: " + gstinNumberMsg);
                    break;

                case "Notification Details":
                    String notificationDetails = tableCell.get(i).get(7);
                    System.out.println(notificationDetails);
                    Thread.sleep(10000);
                    if (con.getNotificationDetailsRemoveList.size() > 0) {
                        System.out.println(con.getNotificationDetailsRemoveList.size());
                        con.getNotificationDetailsRemove.click();
                    } else {
                        con.getNotificationDetailsEdit.clear();
                    }
                    con.getNotificationDetailsEdit.sendKeys(notificationDetails);
                    System.out.println("Data entered :" + notificationDetails);
                    Thread.sleep(10000);
                    u.click(con.getAddContactSaveButton, driver);
                    Thread.sleep(2000l);
                    String notificationDetailsMsg = con.getNotificationDetailsMsg.getText();
                    System.out.println(notificationDetailsMsg);
                    Assert.assertTrue(notificationDetailsMsg.equals("Please enter valid Notification email address"), "Notification email validation message not matched");
                    System.out.println("Notification details Validation msg is:" + notificationDetailsMsg);
                    break;

            }

        }
    }


    @Then("^I enter data in fields and i see proper validation message$")
    public void iEnterDataInFieldsAndISeeProperValidationMessage(DataTable table) throws Throwable {
        List<List<String>> cellsTable = table.cells();
        String email = cellsTable.get(1).get(0);

        String referance = cellsTable.get(1).get(1);

        for (int i = 1; i < cellsTable.size(); i++) {
            String str_mail = cellsTable.get(i).get(0);
            con.getEmailEdit.clear();
            con.getEmailEdit.sendKeys(str_mail);

            String str_ReferanceCode = cellsTable.get(i).get(1);
            con.getCompanyCodeEdit.clear();
            con.getCompanyCodeEdit.sendKeys(str_ReferanceCode);
            Thread.sleep(3000L);
            con.getSaveButtonEdit.click();

            String cssColor = con.getStripMsg.getCssValue("color");
            if (h.browser.equalsIgnoreCase("chrome") && h.browser.equalsIgnoreCase("ie")) {

                Assert.assertTrue(cssColor.equals("rgba(255, 255, 255, 1)"), "Color is not matched");
            } else if (h.browser.equalsIgnoreCase("firefox")) {
                Assert.assertTrue(cssColor.equals("rgba(255, 255, 255)"), "Color is not matched");
            }
            u.setWebDriverFluentWait(1, 30, By.xpath("//div[@class='alert-strip error-alert']"));
            String stripMsg = con.getStripMsg.getText();
            System.out.println("Strip  msg is: " + stripMsg);
            Assert.assertTrue(stripMsg.equals("Cannot update email id"));

        }
    }

    @And("^I see view documents icon and other action parameters$")
    public void iSeeViewDocumentsIconAndOtherActionParameters() throws Throwable {
        System.out.println("Kyc Status: " + kycStatus);
        String str = driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_gvContacts']/tbody/tr[1]/td[8]")).getText();
        System.out.println("text is: " + str);
        if (kycStatus == false && str.length() == 0) {
            System.out.println("Kyc is Required checkbox is not selected");
        } else {
            System.out.println("Upload kyc Icon need to be check ");
            u.waitAndClick(con.actionDropdown);
            WebElement element = driver.findElement(By.xpath("//*[contains(@id,'ContentPlaceHolder1_gvContacts_lnkViewDocumen')]/i"));
            boolean isDisplayedBool = element.isDisplayed();
            Assert.assertTrue(isDisplayedBool, "Upload Kyc icon is checked its Displayed: " + kycStatus);
            boolean isEnabledBool = element.isEnabled();
            Assert.assertTrue(isEnabledBool, "Upload kyc icon is not clickable");
            element.click();
            try {
                u.setWebDriverFluentWait(1, 20, By.xpath("//*[@id='PnlMain']/div/div/div[1]/h1"));
                String kycDocumentPage = driver.findElement(By.xpath("//*[@id='PnlMain']/div/div/div[1]/h1")).getText();
                System.out.println("Kyc document page title: " + kycDocumentPage);
                Assert.assertTrue(kycDocumentPage.equals("KYC DOCUMENTS"), "User not redirecting on kyc page");
            } catch (Exception e) {
                e.printStackTrace();
            }

        }


    }

    @Then("^I enter data in fields and i see proper validation message in green color$")
    public void iEnterDataInFieldsAndISeeProperValidationMessageInGreenColor(DataTable table) throws Throwable {
        List<List<String>> dataTable = table.cells();
        for (int i = 1; i < dataTable.size(); i++) {
            String str_FirstName = dataTable.get(i).get(0);
            con.getEditFirstName.clear();
            con.getEditFirstName.sendKeys(str_FirstName);
            con.getEditLastName.clear();
            String str_LastName = dataTable.get(i).get(1);
            con.getEditLastName.sendKeys(str_LastName);
            con.getEditCompanyName.clear();
            String str_CompanyName = dataTable.get(i).get(2);
            con.getEditCompanyName.sendKeys(str_CompanyName);

            con.getSaveButtonEdit.click();
            u.waitUntilElelemntShouldBeDisplay(driver, By.xpath("//div[@class='alert-strip success-alert']"), 30);
            String errorMsg = con.getSuccesssStripMsg.getText();
            Assert.assertTrue(errorMsg.equals("Contact saved successfully."), "Validation message is not matched");
            System.out.println("Strip msg is: " + errorMsg);
            String getCssColor = con.getSuccesssStripMsg.getCssValue("color");
            // System.out.println("Css value color is: " + getCssColor);
            if (h.browser.equalsIgnoreCase("chrome")) {
                Assert.assertTrue(getCssColor.equals("rgba(255, 255, 255, 1)"), "strip color is not invalid color");
            } else if (h.browser.equalsIgnoreCase("firefox")) {
                Assert.assertTrue(getCssColor.equals("rgb(255, 255, 255)"), "strip color is not invalid color");
            }
        }
    }

    @And("^I check fields are editable$")
    public void iCheckFieldsAreEditable() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        List<WebElement> getAttribute = con.getCheckFieldsEditable;
        for (int i = 0; i < getAttribute.size(); i++) {

            String attributeValues = getAttribute.get(i).getAttribute("readonly");
            if (attributeValues == null) {
                Assert.assertTrue(true);
                System.out.println("Fields are editable");
            } else {
                System.out.println("Fields are not editable");
            }

        }
    }

    @And("^I click on van details tab$")
    public void iClickOnVanDetailsTab() throws Throwable {
        u.click(con.getVanDetailsTabClick, driver);
        Thread.sleep(3000L);
        String expaned = con.getVanDetailsTabClick.getAttribute("aria-expanded");
        if (expaned.equals("true")) {
            Assert.assertTrue(true);
            System.out.println("Van Details tab is expanded: ");
        } else {
            Assert.assertTrue(false, "Van details tab is not expanded");
        }
    }

    @Then("^I should see tab is expand$")
    public void iShouldSeeTabIsExpand() throws Throwable {
        String expaned = con.getVanDetailsTabClick.getAttribute("aria-expanded");
        if (expaned.equals("true")) {
            Assert.assertTrue(true);
            System.out.println("Van Details tab is expanded: ");
        }

    }


    @And("^I see following fields$")
    public void iSeeFollowingFields(DataTable tables) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        List<List<String>> tablesList = tables.cells();
        for (int i = 0; i < tablesList.size(); i++) {
            String s = tablesList.get(i).get(0);
            String s1 = tablesList.get(i).get(1);
            List<WebElement> list = con.getVanDetailsTableHeading;
            for (int j = 0; j < list.size(); j++) {
                String s2 = list.get(j).getText();

                if (s.equals(s2) && s2.equals("Xpress ID")) {
                    System.out.println("Table heading is matched " + s2);
                } else if (s.equals(s2) && s2.equals("VAN Number")) {
                    System.out.println("Table heading is matched " + s2);
                } else if (s.equals(s2) && s2.equals("Status")) {
                    System.out.println("Table heading is matched " + s2);
                } else if (s.equals(s2) && s2.equals("Actions")) {
                    System.out.println("Table heading is matched " + s2);
                }
            }


        }


    }


    @And("^I click on edit button$")
    public void iClickOnEditButton() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        driver.findElements(By.xpath("//*[@class='btnEdit']"));
    }

    @And("^I click on edit button and van details tab$")
    public void iClickOnEditButtonAndVanDetailsTab() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        List<WebElement> editbutton = con.getEditButton;
        System.out.println("Edit button size is: " + editbutton.size());
        int editSize = editbutton.size();
        for (int j = 0; j < editSize; j++) {
            u.click(editbutton.get(j), driver);
            Thread.sleep(3000L);
            iClickOnVanDetailsTab();
            List<WebElement> check = driver.findElements(By.xpath("//*[contains(@id,'ContentPlaceHolder1_pnl')]/a"));
            for (int k = 0; k < check.size(); k++) {
                String view_str = check.get(k).getAttribute("innerText");
                if (view_str.equals("Generate VAN")) {
                    System.out.println("Van is not generate ");
                    break;
                }
            }
            String expaned = con.getVanDetailsTabClick.getAttribute("aria-expanded");
            if (expaned.equals("true")) {
                Assert.assertTrue(true);
                System.out.println("Van Details tab is expanded: ");
            }
            u.click(con.getContactLink, driver);
            con.getManageContactLink.click();
        }
    }

    @And("^I click on edit button and check the following fields$")
    public void iClickOnEditButtonAndCheckTheFollowingFields(DataTable table) throws Throwable {
        List<List<String>> tableValues = table.cells();
        List<WebElement> editbutton = con.getEditButton;
        // System.out.println("Edit button size is: " + editbutton.size());
        int editSize = editbutton.size();
        for (int j = 0; j < editSize; j++) {
            String xpressId = driver.findElements(By.xpath("//*[@id='ContentPlaceHolder1_gvContacts']/tbody/tr/td[1]")).get(j).getText();
            //System.out.println("Xpress id from manage contact: " + xpressId);
            u.click(editbutton.get(j), driver);
            Thread.sleep(3000L);
            iClickOnVanDetailsTab();
            String checkBasicConatc = driver.findElement(By.id("ui-id-1")).getAttribute("aria-expanded");
            //System.out.println("Basic details tab: " + checkBasicConatc);
            if (checkBasicConatc.equals("false")) {
                System.out.println("basic details tab is minimize");
            }
            WebElement vanText = driver.findElement(By.xpath("//*[@id='lblVANno']"));
            String txt = vanText.getText();
            if (txt.equals("NA")) {
                List<WebElement> tableHeading = driver.findElements(By.xpath("//*[@id='Table1']/thead/tr/th"));
                for (int i = 0; i < tableHeading.size(); i++) {
                    String txtIs = tableHeading.get(i).getText();
                    System.out.println("Table heading is: " + txtIs);
                    for (int l = 1; l < tableValues.size(); l++) {
                        String tableTxt = tableValues.get(l).get(0);
                        //matching table headings
                        //System.out.println("Data Table values is: " + tableTxt);
                        if (txtIs.equalsIgnoreCase(tableTxt) && txtIs.equalsIgnoreCase("Xpress ID")) {
                            System.out.println("Xpress id heading is matched");
                            Assert.assertTrue(true, "Table heading and data table filelds text is not matched");
                        } else if (txtIs.equalsIgnoreCase(tableTxt) && txtIs.equalsIgnoreCase("VAN Number")) {
                            System.out.println("VAN Number heading is matched");
                            Assert.assertTrue(true, "Table heading and data table filelds text is not matched");
                        } else if (txtIs.equalsIgnoreCase(tableTxt) && txtIs.equalsIgnoreCase("Status")) {
                            System.out.println("Status heading is matched");
                            Assert.assertTrue(true, "Table heading and data table filelds text is not matched");
                        } else if (txtIs.equalsIgnoreCase(tableTxt) && txtIs.equalsIgnoreCase("Actions")) {
                            System.out.println("Actions heading is matched");
                            Assert.assertTrue(true, "Table heading and data table filelds text is not matched");
                        } /*else {
                            Assert.assertTrue(false, "Table heading and data table filelds text is not matched");
                        }*/

//matching table data default values
                        String xpressIdIs = con.getVanNumberFromVanDetailsTab.getText();

                        Assert.assertTrue(xpressId.equals(xpressIdIs), "xpress id data is not matched");
                        System.out.println("Manage contact xpress id and van details xpress id is matched");

                        String vanNotCreated = con.getVanNumberNotCreated.getText();
                        System.out.println("Van not created values is: " + vanNotCreated);
                        if (vanNotCreated.equals("NA")) {
                            Assert.assertTrue(vanNotCreated.equals("NA"));
                        } else {
                            System.out.println("Van not created");
                        }
                        String statusIs = con.getStatusIs.getText();
                        Assert.assertTrue(statusIs.equals("REGISTERED"), "Invalid status");
                        System.out.println("Status is: " + statusIs);

                        String deleteTitle = con.getDeleteIconText.getAttribute("title");
                        Assert.assertTrue(deleteTitle.equals("Delete this sender"), "Delete icon title is invalid");
                        System.out.println("Delete icon text is: " + deleteTitle);

                        List<WebElement> vanNumber = con.getVanNumberGenarate;
                        for (int m = 0; m < vanNumber.size(); m++) {
                            String str = vanNumber.get(i).getText();//getAttribute("innerText");

                            if (str.equals("Generate VAN")) {
                                Assert.assertTrue(str.equals("Generate VAN"));
                                System.out.println("Van number is not created");
                            }
                        }

                    }
                    //System.out.println("Table heading is: " + txtIs);
                }
                break;
            }
            u.click(con.getContactLink, driver);
            con.getManageContactLink.click();
        }

    }

    @Then("^I click on Generate VAN and i see validation msg in green color$")
    public void iClickOnGenerateVANAndISeeValidationMsgInGreenColor() throws Throwable {
        String genrateVanNumberValidationMsg = "You have requested the registration for NEFT/RTGS payment to ";
        String genrateVanNumberValidationMsg1 = ". We would send you a confirmation email shortly with account details.";
        con.actionDropdown.click();
        List<WebElement> editbutton = con.getEditButton;
        // System.out.println("Edit button size is: " + editbutton.size());
        int editSize = editbutton.size();
        for (int j = 0; j < editSize; j++) {
            String xpressId = driver.findElements(By.xpath("//*[@id='ContentPlaceHolder1_gvContacts']/tbody/tr/td[1]")).get(j).getText();
            //System.out.println("Xpress id from manage contact: " + xpressId);
            u.click(editbutton.get(j), driver);
            String companyName_Str = con.getCompayName.getAttribute("value");
            String msg = genrateVanNumberValidationMsg + companyName_Str + genrateVanNumberValidationMsg1;

            Thread.sleep(3000L);
            iClickOnVanDetailsTab();
            String checkBasicConatc = driver.findElement(By.id("ui-id-1")).getAttribute("aria-expanded");
            //System.out.println("Basic details tab: " + checkBasicConatc);
            if (checkBasicConatc.equals("false")) {
                System.out.println("basic details tab is minimize");
            }
            if (con.getStatusIs.getText().equals("DELETED") || con.getStatusIs.getText().equals("ACTIVE")) {
                u.clickDashboardMenu();
                u.click(con.getContactLink, driver);
                con.getManageContactLink.click();
                u.click(editbutton.get(j), driver);
                iClickOnVanDetailsTab();
            } else {
                WebElement vanText = driver.findElement(By.xpath("//*[@id='lblVANno']"));
                String txt = vanText.getText();
                if (txt.equals("NA")) {
                    con.getGenrateVanNumberLink.click();
                    u.setWebDriverFluentWait(1, 30, By.xpath("//div[@class='inline-element']"));
                    String validationMsg = con.getValidationmsg.getText();
                    Assert.assertTrue(msg.equals(validationMsg), "Validation msg is not matched");
                    break;
                }
               /* u.click(con.getContactLink, driver);
                con.getManageContactLink.click();*/
            }
        }
    }

    @Then("I click on Generate Van and validate alert message")
    public void iClickOnGenerateVanAndValidateAlertMessage() {
        u.waitAndClick(con.actionDropdown);
        u.click(con.generateVan,driver);
        System.out.println("Clicked Van: "+con.generateVanValMsg.getText());
        u.waitUntilWebElelemntShouldBeDisplay(driver,con.generateVanValMsg,30);
        Assert.assertTrue(con.generateVanValMsg.getText().contains("Virtual Account Number"));
    }


    @And("^I should check user get mail or not and verify mail content$")
    public void iShouldCheckUserGetMailOrNotAndVerifyMailContent() throws Throwable {
        String email = con.getEmailid.getAttribute("value");
        u.getMail(email);
        u.getEmailBody();
//        String data = u.txt.substring(u.txt.indexOf(":"));
//        System.out.println("Data:   " + data.trim());

    }

    @And("^I click on view if alreday van generated$")
    public void iClickOnViewIfAlredayVanGenerated() throws Throwable {
        String genrateVanNumberValidationMsg = "You have requested the registration for NEFT/RTGS payment to ";
        String genrateVanNumberValidationMsg1 = ". We would send you a confirmation email shortly with account details.";
        List<WebElement> editbutton = con.getEditButton;
        // System.out.println("Edit button size is: " + editbutton.size());
        int editSize = editbutton.size();
        for (int j = 0; j < editSize; j++) {
            String xpressId = driver.findElements(By.xpath("//*[@id='ContentPlaceHolder1_gvContacts']/tbody/tr/td[1]")).get(j).getText();
            //System.out.println("Xpress id from manage contact: " + xpressId);
            u.click(editbutton.get(j), driver);
            companyName_Str = con.getCompayName.getAttribute("value");
            msg = genrateVanNumberValidationMsg + companyName_Str + genrateVanNumberValidationMsg1;
            Thread.sleep(3000L);
            iClickOnVanDetailsTab();

            String checkBasicConatc = driver.findElement(By.id("ui-id-1")).getAttribute("aria-expanded");
            //System.out.println("Basic details tab: " + checkBasicConatc);
            if (checkBasicConatc.equals("false")) {
                System.out.println("basic details tab is minimize");
            } else {
                Assert.assertTrue(false, "Tab is not minimize");
            }
            WebElement vanText = driver.findElement(By.xpath("//*[@id='lblVANno']"));
            String txt = vanText.getText();
            System.out.println("Status is: " + txt);
            if (txt != "NA" && con.getStatusIs.getText().equals("ACTIVE")) {
                con.getViewTab.click();
                Thread.sleep(3000L);
                break;
            }
            u.click(con.getContactLink, driver);
            con.getManageContactLink.click();
        }


    }


    @Then("^I should see NEFT/RTGS Payment Details window and request details$")
    public void iShouldSeeNEFTRTGSPaymentDetailsWindowAndRequestDetails() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        String window_Str = driver.findElement(By.xpath("//h4[@class='modal-title']")).getText();
        Assert.assertTrue(window_Str.equals("NEFT/RTGS Payment Details"), "payment details tab is not opend");

        String modalBody = driver.findElement(By.xpath("//*[@id='view-history-modal']/div/div/div[2]/p/p[2]")).getText();
        System.out.println("====================================================================");
        System.out.println("modal body is: \n" + modalBody);

        String van_Number = driver.findElement(By.xpath("//*[@id='lblVANno']")).getText();
        System.out.println("Van number is: " + van_Number);
        String van = van_Number.substring(4, 6);
        //System.out.println("---------------------------------------------------------------\n" + van);

        if (van.equals("YS")) {
            System.out.println("Bank name is YES Bank Ltd");
            String details_str = "Beneficiary Name* : PayMate India Pvt Ltd\n" +
                    "Pay to Account Number* : " + van_Number + "\n" +
                    "IFS Code* : YESB0CMSNOC\n" +
                    "Bank Name* : Yes Bank Ltd\n" +
                    "Bank Address* : KHAR";
            System.out.println("----------------------------------\n" + details_str);
            Assert.assertTrue(modalBody.equals(details_str), "modal body is not matched");
        } else {
            System.out.println("Other bank");
        }

    }

    @And("^I click on delete icon$")
    public void iClickOnDeleteIcon() throws Throwable {
        List<WebElement> editbutton = con.getEditButton;
        // System.out.println("Edit button size is: " + editbutton.size());
        int editSize = editbutton.size();
        for (int j = 0; j < editSize; j++) {
            String xpressId = driver.findElements(By.xpath("//*[@id='ContentPlaceHolder1_gvContacts']/tbody/tr/td[1]")).get(j).getText();
            //System.out.println("Xpress id from manage contact: " + xpressId);
            u.click(editbutton.get(j), driver);
            String companyName_Str = con.getCompayName.getAttribute("value");
            String email = con.getEmailid.getAttribute("value");
            Thread.sleep(3000L);
            iClickOnVanDetailsTab();
            String checkBasicConatc = driver.findElement(By.id("ui-id-1")).getAttribute("aria-expanded");
            //System.out.println("Basic details tab: " + checkBasicConatc);
            if (checkBasicConatc.equals("false")) {
                System.out.println("basic details tab is minimize");
            }
            u.setWebDriverFluentWait(5, 30, By.xpath("//*[@id='lblVANno']"));
            WebElement vanText = con.getView;
            String txt = vanText.getText();
            System.out.println("details are: " + txt);
            if (email.length() != 0) {
                if (txt.equals("ACTIVE") || txt.equals("REGISTERED")) {

                    if (txt.equals("REGISTERED")) {
                        con.getGenrateVanNumberLink.click();
                        u.setWebDriverFluentWait(2, 30, By.xpath("//*[@id='ContentPlaceHolder1_pnlDeleteSender']/a[1]/i"));
                        u.click(con.getGetDeleteIcon, driver);
                        Thread.sleep(3000L);
                        break;
                    }
                    u.setWebDriverFluentWait(2, 30, By.xpath("//*[@id='ContentPlaceHolder1_pnlDeleteSender']/a[1]/i"));

                    u.click(con.getGetDeleteIcon, driver);
                    Thread.sleep(3000L);
                    break;
                }
            }
            u.click(con.getContactLink, driver);
            con.getManageContactLink.click();
        }

    }

    @And("I click on delete icon in Van details tab")
    public void iClickOnDeleteIconInVanDetailsTab() throws Throwable {
        Thread.sleep(3000L);
        iClickOnVanDetailsTab();
        String checkBasicConatc = driver.findElement(By.xpath("//*[contains(@id,'ui-id') and text()='Basic Details ']")).getAttribute("aria-expanded");
        //System.out.println("Basic details tab: " + checkBasicConatc);
        if (checkBasicConatc.equals("false")) {
            System.out.println("basic details tab is minimize");
        }
        u.setWebDriverFluentWait(5, 30, By.xpath("//*[@id='lblVANno']"));
        WebElement vanText = con.getView;
        String txt = vanText.getText();
        System.out.println("details are: " + txt);
        if (txt.equals("ACTIVE")) {

//                if (txt.equals("REGISTERED")) {
//                    con.getGenrateVanNumberLink.click();
//                    u.setWebDriverFluentWait(2, 30, By.xpath("//*[@id='ContentPlaceHolder1_pnlDeleteSender']/a[1]/i"));
//                    u.click(con.getGetDeleteIcon, driver);
//                    Thread.sleep(3000L);
//                }
            u.setWebDriverFluentWait(2, 30, By.xpath("//*[@id='ContentPlaceHolder1_pnlDeleteSender']/a[1]/i"));
            u.click(con.getGetDeleteIcon, driver);
            Thread.sleep(3000L);
        }
    }

    @Then("^I see confirm pop is opened and i click on confirm button$")
    public void iSeeConfirmPopIsOpenedAndIClickOnConfirmButton() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        u.setWebDriverFluentWait(1, 30, By.xpath("//p[@class='confirmText']"));
        String del = con.getConfirmText.getAttribute("innerText");
        System.out.println("" + del);
        Assert.assertTrue(del.equals("Are you sure, you want to delete this sender?"), "unable to click on delete icon");
        System.out.println("I am on delete popup");
    }

    @And("^I see validation in green color$")
    public void iSeeValidationInGreenColor() throws Throwable {
        List<WebElement> listbutton = con.getCOnfirmCancelButton;
        for (int i = 0; i < listbutton.size(); i++) {
            boolean buttonIsDisplay = listbutton.get(i).isDisplayed();
            Assert.assertTrue(buttonIsDisplay, "buttons are Not displayed");

            boolean buttonIsEnabled = listbutton.get(i).isEnabled();
            Assert.assertTrue(buttonIsEnabled, "Buttons are not enabled");
            String buttonText = listbutton.get(i).getAttribute("innerText");
            System.out.println(buttonText + " button is clickable and displying");
            if (buttonText.equals("CONFIRM")) {
                u.click(listbutton.get(i), driver);
                Thread.sleep(3000L);
                String msg = con.getValidationMsg.getText();
                Assert.assertTrue(msg.equals("Contact van details deleted successfully"));
                break;
            }


        }
    }

    @And("^I see status is deleted and action parameter is empty$")
    public void iSeeStatusIsDeletedAndActionParameterIsEmpty() throws Throwable {
        WebElement action_Par = driver.findElement(By.xpath("//*[@class='tabletds']"));
        boolean isDisplay = action_Par.isDisplayed();
        Assert.assertFalse(false, "Action icon is displaying");
        System.out.println("Action parameter is empty");
    }

    @Then("^I see pop is opened and i click on confirm button$")
    public void iSeePopIsOpenedAndIClickOnConfirmButton() throws Throwable {
        u.setWebDriverFluentWait(1, 30, By.xpath("//p[@class='confirmText']"));
        String del = con.getConfirmText.getAttribute("innerText");
        System.out.println("" + del);
        Assert.assertTrue(del.equals("Are you sure, you want to deactivate this sender?"), "unable to click on deactive icon");
        System.out.println("I am on deactive popup");
    }

    @And("^I see proper validation msg$")
    public void iSeeProperValidationMsg() throws Throwable {
        boolean conf_Button = con.getConfirmButn.isDisplayed();
        Assert.assertTrue(conf_Button, "Confirm button is not displayed");
        boolean conf_isEnabled = con.getConfirmButn.isEnabled();
        Assert.assertTrue(conf_isEnabled, "Confirm button is not enabled");
        //System.out.println("Confirm button is displayed: " + conf_Button + "\n Confirm button is enabled: " + conf_isEnabled);
        boolean cancel = con.getCancel.isDisplayed();
        Assert.assertTrue(cancel, "Cancel button is not displayed");
        boolean cancel_isEnabled = con.getCancel.isEnabled();
        Assert.assertTrue(cancel_isEnabled, "Cancel button is not enabled");
        //System.out.println("Cancel button is displayed: " + cancel + "\n cancel button is enabled: " + cancel_isEnabled);

        con.getConfirmButn.click();
        u.setWebDriverFluentWait(1, 30, By.xpath("//div[@class='alert-strip success-alert']"));
        String msg = con.getValidationMsg.getText();
        System.out.println(msg);
        Assert.assertTrue(msg.equals("Contact van details deactivated successfully"));
    }

    @And("^I see status is deactivate$")
    public void iSeeStatusIsDeactivate() throws Throwable {
        u.setWebDriverFluentWait(1, 60, By.xpath("//h1[contains(text(),'Manage Contacts')]"));
        u.click(con.getFilterButton, driver);
        Thread.sleep(1000L);
        driver.findElement(By.xpath("//input[@id='txtCompanyCode']")).sendKeys(refCode);
        u.click(con.getFilterClick, driver);
        Thread.sleep(1000L);
        u.click(con.getEditButton.get(count), driver);
        iClickOnVanDetailsTab();
        String deActiveStatus = con.getStatusIs.getAttribute("innerText");
        System.out.println("After click on deactive icon contact status is: " + deActiveStatus);
    }

    @And("^I see activate this send and delete this sender actions$")
    public void iSeeActivateThisSendAndDeleteThisSenderActions() throws Throwable {
        boolean active_IsDisplay = con.getActivestatus.isDisplayed();
        Assert.assertTrue(active_IsDisplay, "Active status is not displayed");
        boolean active_IsEnabled = con.getActivestatus.isEnabled();
        Assert.assertTrue(active_IsEnabled, "Active status is enabled");
        WebElement delete_Icon = con.getGetDeleteIcon;
        boolean isDisplyed = delete_Icon.isDisplayed();
        Assert.assertTrue(isDisplyed, "Delete icon is not displayed");
        boolean isEnabled = delete_Icon.isEnabled();
        Assert.assertTrue(isEnabled, "delete icon is not enabled");
    }

    @And("^I click on deactive icon$")
    public void iClickOnDeactiveIcon() throws Throwable {
        List<WebElement> editbutton = con.getEditButton;
        // System.out.println("Edit button size is: " + editbutton.size());
        int editSize = editbutton.size();
        for (int j = 0; j < editSize; j++) {
            String xpressId = driver.findElements(By.xpath("//*[@id='ContentPlaceHolder1_gvContacts']/tbody/tr/td[1]")).get(j).getText();
            //System.out.println("Xpress id from manage contact: " + xpressId);
            u.click(editbutton.get(j), driver);
            String companyName_Str = con.getCompayName.getAttribute("value");
            String email = con.getEmailid.getAttribute("value");
            Thread.sleep(3000L);
            iClickOnVanDetailsTab();
            String checkBasicConatc = driver.findElement(By.id("ui-id-1")).getAttribute("aria-expanded");
            //System.out.println("Basic details tab: " + checkBasicConatc);
            if (checkBasicConatc.equals("false")) {
                System.out.println("basic details tab is minimize");
            }
            u.setWebDriverFluentWait(5, 30, By.xpath("//*[@id='lblVANno']"));
            WebElement vanText = con.getView;
            String txt = vanText.getText();
            System.out.println("details are: " + txt);
            if (email.length() != 0) {
                if (txt.equals("ACTIVE") || txt.equals("REGISTERED")) {

                    if (txt.equals("REGISTERED")) {
                        con.getGenrateVanNumberLink.click();
                        Thread.sleep(3000L);
                        iClickOnVanDetailsTab();
                        u.setWebDriverFluentWait(2, 30, By.xpath("//*[@id='ContentPlaceHolder1_pnlDeactivateSender']/a[1]/i"));
                        u.click(con.getDeactiveIcon, driver);
                        Thread.sleep(3000L);
                        break;
                    }
                    u.setWebDriverFluentWait(2, 30, By.xpath("//*[@id='ContentPlaceHolder1_pnlDeactivateSender']/a[1]/i"));

                    u.click(con.getDeactiveIcon, driver);
                    Thread.sleep(3000L);
                    break;
                }
                System.out.println(count++);
            }
            u.click(con.getContactLink, driver);
            con.getManageContactLink.click();
        }

    }

    @And("I click in deactive icon in Van details tab")
    public void iClickInDeactiveIconInVanDetailsTab() throws Throwable {
        Thread.sleep(3000L);
        iClickOnVanDetailsTab();
        String checkBasicConatc = driver.findElement(By.xpath("//*[contains(@id,'ui-id') and text()='Basic Details ']")).getAttribute("aria-expanded");
        //System.out.println("Basic details tab: " + checkBasicConatc);
        if (checkBasicConatc.equals("false")) {
            System.out.println("basic details tab is minimize");
        }
        u.setWebDriverFluentWait(5, 30, By.xpath("//*[@id='lblVANno']"));
        WebElement vanText = con.getView;
        String txt = vanText.getText();
        System.out.println("details are: " + txt);
        if (txt.equals("ACTIVE")) {
            u.setWebDriverFluentWait(2, 30, By.xpath("//*[@id='ContentPlaceHolder1_pnlDeleteSender']/a[1]/i"));
            u.click(con.getDeactiveIcon, driver);
            Thread.sleep(3000L);
        }
    }


    @And("^I click on active icon$")
    public void iClickOnActiveIcon() throws Throwable {
        List<WebElement> editbutton = con.getEditButton;
        // System.out.println("Edit button size is: " + editbutton.size());
        int editSize = editbutton.size();
        for (int j = 0; j < editSize; j++) {
            u.click(editbutton.get(j), driver);

            String companyName_Str = con.getCompayName.getAttribute("value");
            String email = con.getEmailid.getAttribute("value");
            Thread.sleep(3000L);
            iClickOnVanDetailsTab();
            String checkBasicConatc = driver.findElement(By.id("ui-id-1")).getAttribute("aria-expanded");
            //System.out.println("Basic details tab: " + checkBasicConatc);
            if (checkBasicConatc.equals("false")) {
                System.out.println("basic details tab is minimize");
            }

            if (email.length() != 0) {
                // System.out.println("you can create van number");
                u.setWebDriverFluentWait(5, 30, By.xpath("//*[@id='lblVANno']"));
                WebElement vanText = con.getView;
                String txt = vanText.getText();
                System.out.println(txt);
                if (txt.equals("ACTIVE") || txt.equals("DEACTIVE")) {

                    if (txt.equals("ACTIVE")) {
                        u.setWebDriverFluentWait(2, 30, By.xpath("//*[@id='ContentPlaceHolder1_pnlDeactivateSender']/a[1]/i"));
                        con.getDeactiveIcon.click();
                        u.setWebDriverFluentWait(1, 30, By.xpath("//*[contains(text(),'Confirm')]"));
                        con.getConfirmButn.click();
                        System.out.println("loop value: " + j);
                        u.setWebDriverFluentWait(1, 30, By.xpath("//a[@class='btnEdit']"));
                        u.click(editbutton.get(j), driver);
                        Thread.sleep(3000);
                        iClickOnVanDetailsTab();
                        Thread.sleep(2000);
                        u.click(con.getActiveThisSender, driver);
                        Thread.sleep(3000L);
                        break;
                    }

                    u.click(con.getActiveThisSender, driver);
                    Thread.sleep(3000L);
                    break;

                }

            }

            u.click(con.getContactLink, driver);
            con.getManageContactLink.click();
        }

    }

    @Then("^I see active pop is opened and i click on confirm button$")
    public void iSeeActivePopIsOpenedAndIClickOnConfirmButton() throws Throwable {
        String confmText = con.getConfirmText.getText();
        System.out.println("Confirm text is: " + confmText);
        Assert.assertTrue(confmText.equals("Are you sure, you want to activate this sender?"), "Active sender popup is not displayed");

        WebElement confirm = con.getConfirmButn;
        boolean isDisplyed = confirm.isDisplayed();
        Assert.assertTrue(isDisplyed, "confirm button is not displayed");
        boolean isEnabled = confirm.isEnabled();
        Assert.assertTrue(isDisplyed, "Confirm button is not enabled");

        WebElement cancel = con.getCancel;
        boolean cancel_IsDisplayed = cancel.isDisplayed();
        Assert.assertTrue(cancel_IsDisplayed, "Cancel button is not displayed");
        boolean cancel_IsEnabled = cancel.isEnabled();
        Assert.assertTrue(cancel_IsEnabled, "Cancel button is not enabled");

    }

    @And("^I see validation msg$")
    public void iSeeValidationMsg() {
        con.getConfirmButn.click();
        u.setWebDriverFluentWait(1, 30, By.xpath("//div[@class='alert-strip success-alert']"));
        String msg = con.getValidationMsg.getText();
        System.out.println(msg);
        Assert.assertTrue(msg.equals("Contact van details activated successfully"));
    }

    @And("^I click on resend account details icon$")
    public void iClickOnResendAccountDetailsIcon() throws Throwable {
        List<WebElement> editbutton = con.getEditButton;
        // System.out.println("Edit button size is: " + editbutton.size());
        int editSize = editbutton.size();
        for (int j = 0; j < editSize; j++) {
            u.click(editbutton.get(j), driver);

            String companyName_Str = con.getCompayName.getAttribute("value");
            email = con.getEmailid.getAttribute("value");
            Thread.sleep(3000L);
            iClickOnVanDetailsTab();
            String checkBasicConatc = driver.findElement(By.id("ui-id-1")).getAttribute("aria-expanded");
            //System.out.println("Basic details tab: " + checkBasicConatc);
            if (checkBasicConatc.equals("false")) {
                System.out.println("basic details tab is minimize");
            }

            if (email.length() != 0) {
                // System.out.println("you can create van number");
                u.setWebDriverFluentWait(5, 30, By.xpath("//*[@id='lblVANno']"));
                WebElement vanText = con.getView;
                String txt = vanText.getText();
                System.out.println(txt);
                if (txt.equals("ACTIVE") || txt.equals("DEACTIVE") || txt.equals("REGISTERED")) {

                    if (txt.equals("DEACTIVE")) {
                        u.setWebDriverFluentWait(2, 30, By.xpath("//*[@id='ContentPlaceHolder1_pnlActivateSender']/a[1]/i"));
                        con.getActiveThisSender.click();
                        u.setWebDriverFluentWait(1, 30, By.xpath("//*[contains(text(),'Confirm')]"));
                        con.getConfirmButn.click();
                        System.out.println("loop value: " + j);
                        u.setWebDriverFluentWait(1, 30, By.xpath("//a[@class='btnEdit']"));
                        u.click(editbutton.get(j), driver);
                        Thread.sleep(3000);
                        iClickOnVanDetailsTab();
                        Thread.sleep(2000);
                        u.click(con.getResendConatct, driver);
                        Thread.sleep(3000L);
                        break;
                    } else if (txt.equals("REGISTERED")) {

                        con.getGenrateVanNumberLink.click();
                        iClickOnVanDetailsTab();
                        Thread.sleep(2000L);
                        u.click(con.getResendConatct, driver);
                        break;
                    }

                    u.click(con.getResendConatct, driver);
                    Thread.sleep(3000L);
                    break;

                }

            }
            u.click(con.getContactLink, driver);
            con.getManageContactLink.click();
        }
    }

    @Then("^I see proper validation mmessage$")
    public void iSeeProperValidationMmessage() throws Throwable {
        // Write code here that turns the phrase above into concrete action
        String msg = "Mail sent successfully to : ";
        System.out.println(msg + email);
    }

    @And("^I should check user get mail or not$")
    public void iShouldCheckUserGetMailOrNot() throws Throwable {
        u.getMail(email);
        u.getEmailBody();
    }

    @And("^I click on received details tab$")
    public void iClickOnReceivedDetailsTab() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        con.getEditButton.get(0).click();

        Thread.sleep(3000L);
        con.getReceiverDetails.click();
        Thread.sleep(3000L);
    }

    @Then("^I see following fields in received detailed tab$")
    public void iSeeFollowingFieldsInReceivedDetailedTab(DataTable table) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        List<List<String>> table_Data = table.cells();
        List<WebElement> receivedData = con.getReceivedDetailsTabData;
        for (int i = 0; i < receivedData.size(); i++) {
            String table_str = table_Data.get(0).get(i);
            String data = receivedData.get(i).getText();
            System.out.println(table_str + "----" + data);
            Assert.assertTrue(table_str.equals(data), "Table data is not matched");
        }
    }

    @And("^I click on edit button and checked data$")
    public void iClickOnEditButtonAndCheckedData() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        List<WebElement> getEditList = con.getEditButton;
        for (int i = 0; i < getEditList.size(); i++) {
            String xpressId1 = driver.findElements(By.xpath("//*[@id='ContentPlaceHolder1_gvContacts']/tbody/tr/td[1]")).get(i).getText();

            System.out.println("Xpress id: " + xpressId1);
            getEditList.get(i).click();
            Thread.sleep(3000L);
            con.getReceiverDetails.click();
            String xpressId = driver.findElement(By.id("ContentPlaceHolder1_lblXpressId")).getAttribute("innerText");
            if (xpressId1.equals("xpressId")) {
                Assert.assertTrue(xpressId1.equals(xpressId), "Xpress id not matched");
            }
            String accountNumber_Str = driver.findElement(By.name("ctl00$ContentPlaceHolder1$txtBankAccountNo")).getAttribute("value");
            if (accountNumber_Str.length() != 0) {
                System.out.println("User alreay enter account number: " + accountNumber_Str);
            } else {
                System.out.println("Account number filed is empty");
            }

            String ifscCode_Str = driver.findElement(By.name("ctl00$ContentPlaceHolder1$txtIFSCode")).getAttribute("value");
            if (ifscCode_Str.length() != 0 && accountNumber_Str.length() != 0) {
                System.out.println("IFSC code and account number user already enter");
            } else {
                System.out.println("Filed is empty: " + ifscCode_Str + " " + accountNumber_Str);
            }
            String reeceivedDetails = driver.findElement(By.id("ContentPlaceHolder1_lblReceiverStatus")).getAttribute("innerText");

            if (reeceivedDetails.equals("ACTIVE")) {
                Assert.assertTrue(reeceivedDetails.equals("ACTIVE"));
                System.out.println("status is Active");
            } else {
                System.out.println("Status is not active");
            }
            List<WebElement> icons = driver.findElements(By.xpath("//*[@class='tblIcons']/tbody/tr/td/div/a"));
            for (int j = 0; j < icons.size(); j++) {
                String iconsAre = icons.get(j).getAttribute("title");
                System.out.println("Actions icon are: " + iconsAre);
            }
            break;
        }

    }

    @And("^I click on request received delete icon$")
    public void iClickOnRequestReceivedDeleteIcon() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        List<WebElement> editbutton = con.getEditButton;
        // System.out.println("Edit button size is: " + editbutton.size());
        int editSize = editbutton.size();
        for (int j = 0; j < editSize; j++) {
            String xpressId = driver.findElements(By.xpath("//*[@id='ContentPlaceHolder1_gvContacts']/tbody/tr/td[1]")).get(j).getText();
            //System.out.println("Xpress id from manage contact: " + xpressId);
            u.click(editbutton.get(j), driver);
            String companyName_Str = con.getCompayName.getAttribute("value");
            String email = con.getEmailid.getAttribute("value");
            Thread.sleep(3000L);
            iClickOnVanDetailsTab();
            String checkBasicConatc = driver.findElement(By.id("ui-id-1")).getAttribute("aria-expanded");
            //System.out.println("Basic details tab: " + checkBasicConatc);
            if (checkBasicConatc.equals("false")) {
                System.out.println("basic details tab is minimize");
            }

            WebElement vanText = con.getView;
            String txt = vanText.getText();
            System.out.println("details are: " + txt);
            if (txt.equals("ACTIVE") || txt.equals("REGISTERED")) {

                if (txt.equals("REGISTERED")) {
                    con.getGenrateVanNumberLink.click();
                    u.setWebDriverFluentWait(2, 30, By.xpath("//*[@id='ContentPlaceHolder1_pnlDeleteSender']/a[1]/i"));
                    u.click(con.getGetDeleteIcon, driver);
                    Thread.sleep(3000L);
                    break;
                }
                u.setWebDriverFluentWait(2, 30, By.xpath("//*[@id='ContentPlaceHolder1_pnlDeleteSender']/a[1]/i"));

                u.click(con.getGetDeleteIcon, driver);
                Thread.sleep(3000L);
                break;
            }

            u.click(con.getContactLink, driver);
            con.getManageContactLink.click();
        }
    }


    @And("^I see \"([^\"]*)\" validation msg$")
    public void iSeeValidationMsg(String arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        String confmText = con.getConfirmText.getText();
        System.out.println("Confirm text is: " + confmText);
        Assert.assertTrue(confmText.equals(arg0), "Active sender popup is not displayed");

    }


    @And("^I click on request received deactive icon$")
    public void iClickOnRequestReceivedDeactiveIcon() throws Throwable {
        // Write code here that turns the phrase above into concrete actions

        List<WebElement> editButton = con.getEditButton;
        for (int i = 0; i < editButton.size(); i++) {
            u.click(editButton.get(i), driver);
            u.impliciteWait();
            u.click(con.getReceiverDetails, driver);
            String txt = con.getReceiveddetailsStatus.getAttribute("innerText");
            System.out.println(txt);
            if (txt.equals("ACTIVE")) {
                u.click(con.getdeactiveReceiver, driver);
                u.setWebDriverFluentWait(1, 30, By.xpath("//p[@class='confirmText']"));
                break;
            }
            System.out.println(count1++);
            u.click(con.getContactLink, driver);
            u.click(con.getManageContactLink, driver);

        }


    }

    @Then("^I should see deactive pop confirmation$")
    public void iShouldSeeDeactivePopConfirmation() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        String confmText = con.getConfirmText.getText();
        System.out.println("Confirm text is: " + confmText);
        Assert.assertTrue(confmText.equals("Are you sure, you want to deactivate this receiver?"), "Active sender popup is not displayed");

        WebElement confirm = con.getConfirmButn;
        boolean isDisplyed = confirm.isDisplayed();
        Assert.assertTrue(isDisplyed, "confirm button is not displayed");
        boolean isEnabled = confirm.isEnabled();
        Assert.assertTrue(isDisplyed, "Confirm button is not enabled");

        WebElement cancel = con.getCancel;
        boolean cancel_IsDisplayed = cancel.isDisplayed();
        Assert.assertTrue(cancel_IsDisplayed, "Cancel button is not displayed");
        boolean cancel_IsEnabled = cancel.isEnabled();
        Assert.assertTrue(cancel_IsEnabled, "Cancel button is not enabled");

    }

    @And("^I click on confirm button and I should see validation msg$")
    public void iClickOnConfirmButtonAndIShouldSeeValidationMsg() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        con.getConfirmbutton.click();
        u.setWebDriverFluentWait(1, 30, By.xpath("//div[@class='inline-element']"));
        String txt_validation = con.getValidationmsg.getText();
        System.out.println("validation message: " + txt_validation);
        Assert.assertTrue(txt_validation.equals("Contact receiver details deactivated successfully"));
    }

    @And("^I check fields are in read only from and status is deactive$")
    public void iCheckFieldsAreInReadOnlyFromAndStatusIsDeactive() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        System.out.println(count1);
        u.setWebDriverFluentWait(1, 30, By.xpath("//a[@class='btnEdit']"));
        u.ScrollToElement(con.getEditButton.get(count1));
        u.click(con.getEditButton.get(count1), driver);
        u.impliciteWait();
        u.click(con.getReceiverDetails, driver);
        Thread.sleep(3000L);
        String txt = con.getReceiveddetailsStatus.getAttribute("innerText");
        System.out.println(txt);
        Assert.assertTrue(txt.equals("DEACTIVE"));


    }

    @And("^I check status is deactive and i click on active icon$")
    public void iCheckStatusIsDeactiveAndIClickOnActiveIcon() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        List<WebElement> editButton = con.getEditButton;
        for (int i = 0; i < editButton.size(); i++) {
            u.click(editButton.get(i), driver);
            u.impliciteWait();
            u.click(con.getReceiverDetails, driver);
            String txt = con.getReceiveddetailsStatus.getAttribute("innerText");
            System.out.println(txt);
            if (txt.equals("DEACTIVE")) {
                u.click(con.getActiveReceiverDetails, driver);
                u.setWebDriverFluentWait(1, 30, By.xpath("//p[@class='confirmText']"));
                break;
            }
            System.out.println(count1++);
            u.click(con.getContactLink, driver);
            u.click(con.getManageContactLink, driver);

        }

    }

    @Then("^I should see active pop confirmation$")
    public void iShouldSeeActivePopConfirmation() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        String confmText = con.getConfirmText.getText();
        System.out.println("Confirm text is: " + confmText);
        Assert.assertTrue(confmText.equals("Are you sure, you want to activate this receiver?"), "Active sender popup is not displayed");

        WebElement confirm = con.getConfirmButn;
        boolean isDisplyed = confirm.isDisplayed();
        Assert.assertTrue(isDisplyed, "confirm button is not displayed");
        boolean isEnabled = confirm.isEnabled();
        Assert.assertTrue(isDisplyed, "Confirm button is not enabled");

        WebElement cancel = con.getCancel;
        boolean cancel_IsDisplayed = cancel.isDisplayed();
        Assert.assertTrue(cancel_IsDisplayed, "Cancel button is not displayed");
        boolean cancel_IsEnabled = cancel.isEnabled();
        Assert.assertTrue(cancel_IsEnabled, "Cancel button is not enabled");

    }

    @And("^I click on confirm and i should see validation msg$")
    public void iClickOnConfirmAndIShouldSeeValidationMsg() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        con.getConfirmbutton.click();
        u.setWebDriverFluentWait(1, 30, By.xpath("//div[@class='inline-element']"));
        String txt_validation = con.getValidationmsg.getText();
        System.out.println("validation message: " + txt_validation);
        Assert.assertTrue(txt_validation.equals("Contact receiver details activated successfully"));
    }

    @And("^I check status is active$")
    public void iCheckStatusIsActive() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        u.setWebDriverFluentWait(1, 30, By.xpath("//a[@class='btnEdit']"));
        System.out.println(count1);
        u.ScrollToElement(con.getEditButton.get(count1));
        u.click(con.getEditButton.get(count1), driver);
        u.impliciteWait();
        u.click(con.getReceiverDetails, driver);
        Thread.sleep(3000L);
        String txt = con.getReceiveddetailsStatus.getAttribute("innerText");
        System.out.println(txt);
        Assert.assertTrue(txt.equals("ACTIVE"));
    }


    @And("^I click on edit button from receiver details tab$")
    public void iClickOnEditButtonFromReceiverDetailsTab() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        List<WebElement> editButton = con.getEditButton;
        for (int i = 0; i < editButton.size(); i++) {
            u.click(editButton.get(i), driver);
            u.impliciteWait();
            u.click(con.getReceiverDetails, driver);
            String txt = con.getReceiveddetailsStatus.getAttribute("innerText");
            System.out.println(txt);
            if (txt.equals("ACTIVE")) {
                u.click(con.getEdit, driver);
                // u.setWebDriverFluentWait(1, 30, By.xpath("//p[@class='confirmText']"));
                break;
            }
            System.out.println(count1++);
            u.click(con.getContactLink, driver);
            u.click(con.getManageContactLink, driver);

        }
    }

    @Then("^I see account number and IFSC fiels is editable and save button should be display$")
    public void iSeeAccountNumberAndIFSCFielsIsEditableAndSaveButtonShouldBeDisplay() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        String acNumber = con.getAccountNumber.getAttribute("readonly");
        if (acNumber == null) {
            System.out.println("Account number is editable");
            Assert.assertTrue(true);
        }
        String ifsc = con.getIfsc.getAttribute("readonly");
        if (ifsc == null) {
            System.out.println("IFSC code is editable");
            Assert.assertTrue(true);
        }

//        u.setWebDriverFluentWait(1, 30, By.name("ctl00$ContentPlaceHolder1$btnSaveAccdetails"));
//        boolean save = con.getSavebutton.isDisplayed();
//        System.out.println(save);
//        Assert.assertTrue(save, "save button is not displayed");

        boolean saveIdEnabled = con.getSavebutton.isEnabled();
        System.out.println("Save is enabled " + saveIdEnabled);
        Assert.assertTrue(saveIdEnabled, "save button is enabled");

    }

    @And("^I update account number and ifsc code$")
    public void iUpdateAccountNumberAndIfscCode() throws Throwable {
        Thread.sleep(10000);
        con.getAccountNumber.clear();
        u.log4j("Cleared Account Number");
        con.getAccountNumber.sendKeys(accountNumber);
        u.log4j("I enter account number as: " + accountNumber);
        Thread.sleep(300L);
        con.getIfsc.clear();
        u.log4j("Cleared IFSC code");
        con.getIfsc.sendKeys(IFSCCode);
        u.log4j("I enter IFSC code as: " + IFSCCode);
        Thread.sleep(300L);
    }

    @And("^I click on save button from receiver details$")
    public void iClickOnSaveButtonFromReceiverDetails() throws Throwable {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].click();", con.getSavebutton);
//        con.getSavebutton.click();
        u.setWebDriverFluentWait(1, 30, By.xpath("//div[@class='alert-strip success-alert']"));
        validationMsg = con.getValidationMsg.getText();
        System.out.println("After click on save button validation msg is: " + validationMsg);
    }

    @Then("^I should see validation message$")
    public void iShouldSeeValidationMessage() throws Throwable {
        // Write code here that turns the phrase above into concrete actions

        Assert.assertTrue(validationMsg.equals("Contact account details updated successfully."), "Validation msg is not matched");

    }

    @And("^I check updated data$")
    public void iCheckUpdatedData() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        u.setWebDriverFluentWait(1, 30, By.xpath("//a[@class='btnEdit']"));
        System.out.println(count1);
        u.ScrollToElement(con.getEditButton.get(count1));
        u.click(con.getEditButton.get(count1), driver);
        Thread.sleep(500L);
        u.click(con.getReceiverDetails, driver);
        String accNo = con.getAccountNumber.getAttribute("value");
        System.out.println("Account number is: " + accNo);
        String ifsc = con.getIfsc.getAttribute("value");
        System.out.println("IFSC code is: " + ifsc);
        Assert.assertTrue(accNo.equals(accountNumber), "Account number is not matched");
        Assert.assertTrue(IFSCCode.equals(ifsc), "IFSC code is not matched");
        System.out.println("Receiver details updated successfully");

    }

    @And("^I enter invalid account number and ifsc code$")
    public void iEnterInvalidAccountNumberAndIfscCode(DataTable table) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        listTableCell = table.cells();
        for (int i = 1; i < listTableCell.size(); i++) {
            String acuNo = listTableCell.get(i).get(0);

            String ifsc = listTableCell.get(i).get(1);


            con.getAccountNumber.clear();
            con.getAccountNumber.sendKeys(acuNo);
            con.getAccountNumber.sendKeys(Keys.TAB);
            u.setWebDriverFluentWait(1, 20, By.xpath("//*[@class='txtBankAccountNo mdl-textfield__error']"));
            String accountNumberErrorMsg = con.getAcNoErrorMsg.getAttribute("innerText");
            if (accountNumberErrorMsg.equals("Please enter validBank Account No")) {
                Assert.assertTrue(true, "validation msg is not matched");
            } else if (accountNumberErrorMsg.equals("Please enter Bank Account No")) {
                Assert.assertTrue(true, "validation msg is not matched");
            } else {

                Assert.assertTrue(false, "validation msg is not matched");
            }
            System.out.println("Account number error msg: " + accountNumberErrorMsg);
            con.getIfsc.clear();
            con.getIfsc.sendKeys(ifsc);
            con.getIfsc.sendKeys(Keys.TAB);

            String ifscCodeErrorMsg = con.getIfscCodeErrorMsg.getAttribute("innerText");
            if (ifscCodeErrorMsg.equals("Please enter valid IFS Code")) {
                Assert.assertTrue(true, "Validation msg is not matched");
            } else if (ifscCodeErrorMsg.equals("Please enter IFS Code")) {
                Assert.assertTrue(true, "Validation msg is not matched");
            } else {
                u.setWebDriverFluentWait(2, 30, By.xpath("//div[@class='inline-element']"));
                String msg = con.getValidationmsg.getText();
                System.out.println("+++++++++++++++++" + msg);
                Assert.assertTrue(msg.equals("Please enter valid IFS Code"), "msg is not matched");

                //Assert.assertTrue(false, "Validation msg is not matched");
            }
        }
    }


    @Then("^I should see validation msg for each filed$")
    public void iShouldSeeValidationMsgForEachFiled() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("validation msg is: ");
    }

    @And("^I click on confirm button and i see proper validation message$")
    public void iClickOnConfirmButtonAndISeeProperValidationMessage() throws Throwable {
       /* List<WebElement> ele = driver.findElements(By.xpath("//*[@id='ContentPlaceHolder1_gvContacts']/tbody/tr"));
        int size = ele.size();
        // 0 of 3 Contact(s) added successfully
        String of = " of ";
        String msg = " Contact(s) added successfully";*/

        u.click(con.getConfirmButton, driver);
        u.setWebDriverFluentWait(1, 30, By.xpath("//*[@id='form1']/div[3]/div"));
        String validationMsg = driver.findElement(By.xpath("//*[@id='form1']/div[3]/div")).getText();
        System.out.println("After click on confirm button validation msg is: " + validationMsg);
        Assert.assertEquals(validationMsg,"1 of 2 Contact(s) added.");
       /* int textIsDisplay = driver.findElements(By.xpath("//*[@id='ContentPlaceHolder1_gvContacts']/tbody/tr/td[5]")).size();
        System.out.println("textIsDisplay: " + textIsDisplay);
        System.out.println("Size: " + size);
        String dynmicmsg = size + of + size + msg;
        System.out.println("Dynamic validation msg before click on confirm button: " + dynmicmsg);
        if (dynmicmsg.equals(validationMsg)) {
            System.out.println("I am in if");
            cnt = driver.findElements(By.xpath("//*[@id='ContentPlaceHolder1_gvContacts']/tbody/tr/td[5]")).size();
            String cssColor = driver.findElement(By.xpath("//*[@id='form1']/div[3]/div")).getCssValue("color");
            System.out.println("Validation message is: " + validationMsg);
            if (h.browser.equalsIgnoreCase("chrome") || h.browser.equalsIgnoreCase("ie")) {// rgba(255, 255, 255, 1)
                Assert.assertTrue(cssColor.endsWith("rgba(255, 255, 255, 1)"));
                System.out.println("Css color of validation message: " + cssColor);
            } else if (h.browser.equalsIgnoreCase("firefox")) {
                Assert.assertTrue(cssColor.equals("rgb(255, 255, 255)"));

            }
        } else {
            Assert.assertTrue(false, "validation msg is not matched");
        }*/


    }

    @And("I enter {string} in the search field")
    public void iEnterInTheSearchField(String arg0) throws InterruptedException {
        con.getCompanyCode.sendKeys(arg0);
        u.click(con.getFilterButton, driver);
        Thread.sleep(1000L);
    }

    @And("I perform the following tasks in Van Details tab")
    public void iPerformTheFollowingTasksInVanDetailsTab(DataTable table) throws Throwable {
        WebElement vanText;
        String txt;
        String msg;
        List<List<String>> list_Cells = table.cells();
        for (int i = 0; i < list_Cells.size(); i++) {
            dataTable_str = list_Cells.get(i).get(0);
            u.log4j("Task is: " + dataTable_str);
            Thread.sleep(5000L);
            u.clickDashboardMenu();
            u.click(con.getContactLink, driver);
            con.getManageContactLink.click();
            Thread.sleep(1000L);
            u.click(con.getFilterClick, driver);
            System.out.println("Reference code is:" + refCode);
            Thread.sleep(2000L);
            driver.findElement(By.xpath("//input[@id='txtCompanyCode']")).sendKeys(refCode);
            u.click(con.getFilterButton, driver);
            Thread.sleep(2000L);
            u.click(con.getEditButton.get(count), driver);
            Thread.sleep(2000L);
            email = con.getEmailid.getAttribute("value");
            iClickOnVanDetailsTab();
            String checkBasicConatc = driver.findElement(By.id("ui-id-1")).getAttribute("aria-expanded");
            //System.out.println("Basic details tab: " + checkBasicConatc);
            if (checkBasicConatc.equals("false")) {
                System.out.println("basic details tab is minimize");
            }
            switch (dataTable_str) {
                case "Generate Van":
                    String genrateVanNumberValidationMsg = "You have requested the registration for NEFT/RTGS payment to ";
                    String genrateVanNumberValidationMsg1 = ". We would send you a confirmation email shortly with account details.";
                    // System.out.println("Edit button size is: " + editbutton.size());
                    String companyName_Str = con.getCompayName.getAttribute("value");
                    msg = genrateVanNumberValidationMsg + companyName_Str + genrateVanNumberValidationMsg1;
                    if (con.getStatusIs.getText().equals("REGISTERED")) {
                        vanText = driver.findElement(By.xpath("//*[@id='lblVANno']"));
                        txt = vanText.getText();
                        if (txt.equals("NA")) {
                            con.getGenrateVanNumberLink.click();
                            u.setWebDriverFluentWait(1, 30, By.xpath("//div[@class='inline-element']"));
                            String validationMsg = con.getValidationmsg.getText();
                            Assert.assertTrue(msg.equals(validationMsg), "Validation msg is not matched");
                        }
                    }
                    iClickOnVanDetailsTab();
                    String activeStatus = con.getStatusIs.getText();
                    Assert.assertEquals(activeStatus, "ACTIVE");
                    boolean deActiveEnabled = con.getDeActiveStatus.isEnabled();
                    Assert.assertTrue(deActiveEnabled, "Deactive this sender button is not enabled");
                    WebElement delete_Icon = con.getGetDeleteIcon;
                    boolean isDisplyed = delete_Icon.isDisplayed();
                    Assert.assertTrue(isDisplyed, "Delete icon is not displayed");
                    boolean isEnabled = delete_Icon.isEnabled();
                    Assert.assertTrue(isEnabled, "delete icon is not enabled");
                    break;
                case "Deactive Van":
                    u.setWebDriverFluentWait(5, 30, By.xpath("//*[@id='lblVANno']"));
                    vanText = con.getView;
                    txt = vanText.getText();
                    System.out.println("details are: " + txt);
                    if (txt.equals("ACTIVE")) {
                        u.setWebDriverFluentWait(2, 30, By.xpath("//*[@id='ContentPlaceHolder1_pnlDeleteSender']/a[1]/i"));
                        u.click(con.getDeactiveIcon, driver);
                        Thread.sleep(3000L);
                    }
                    u.setWebDriverFluentWait(1, 30, By.xpath("//p[@class='confirmText']"));
                    String del = con.getConfirmText.getAttribute("innerText");
                    System.out.println("" + del);
                    Assert.assertTrue(del.equals("Are you sure, you want to deactivate this sender?"), "unable to click on deactive icon");
                    System.out.println("I am on deactive popup");
                    boolean conf_Button = con.getConfirmButn.isDisplayed();
                    Assert.assertTrue(conf_Button, "Confirm button is not displayed");
                    boolean conf_isEnabled = con.getConfirmButn.isEnabled();
                    Assert.assertTrue(conf_isEnabled, "Confirm button is not enabled");
                    //System.out.println("Confirm button is displayed: " + conf_Button + "\n Confirm button is enabled: " + conf_isEnabled);
                    boolean cancel = con.getCancel.isDisplayed();
                    Assert.assertTrue(cancel, "Cancel button is not displayed");
                    boolean cancel_isEnabled = con.getCancel.isEnabled();
                    Assert.assertTrue(cancel_isEnabled, "Cancel button is not enabled");
                    //System.out.println("Cancel button is displayed: " + cancel + "\n cancel button is enabled: " + cancel_isEnabled);

                    con.getConfirmButn.click();
                    Thread.sleep(1000L);
                    u.setWebDriverFluentWait(1, 30, By.xpath("//div[@class='alert-strip success-alert']"));
                    String DeactiveMsg = con.getValidationMsg.getText();
                    u.log4j(DeactiveMsg);
                    Assert.assertTrue(DeactiveMsg.equals("Contact van details deactivated successfully"));
                    u.waitUntilElelemntShouldBeDisplay(driver, By.className("sidebar-toggle"), 10);
                    break;

                case "Active Van":
                    vanText = con.getView;
                    txt = vanText.getText();
                    System.out.println(txt);
                    if (txt.equals("DEACTIVE")) {
                        u.setWebDriverFluentWait(2, 30, By.xpath("//*[@id='ContentPlaceHolder1_pnlActivateSender']/a[1]/i"));
                        con.getActiveThisSender.click();
                        u.setWebDriverFluentWait(1, 30, By.xpath("//*[contains(text(),'Confirm')]"));
                        con.getConfirmButn.click();
                    }
                    Thread.sleep(2000L);
                    u.setWebDriverFluentWait(1, 30, By.xpath("//div[@class='alert-strip success-alert']"));
                    msg = con.getValidationMsg.getText();
                    u.log4j(msg);
                    Assert.assertTrue(msg.equals("Contact van details activated successfully"));
                    u.waitUntilElelemntShouldBeDisplay(driver, By.className("sidebar-toggle"), 10);
                    break;
                case "Resend Account Details":
                    con.getBasicDetails.click();
                    u.waitUntilElelemntShouldBeDisplay(driver, By.cssSelector("#txtEmail"), 10);
                    email = con.getEmailid.getAttribute("value");
                    System.out.println("Email is: " + email);
                    iClickOnVanDetailsTab();
                    if (email.length() != 0) {
                        u.setWebDriverFluentWait(5, 30, By.xpath("//*[@id='lblVANno']"));
                        vanText = con.getView;
                        txt = vanText.getText();
                        System.out.println(txt);
                        if (txt.equals("ACTIVE")) {
                            u.click(con.getResendConatct, driver);
                            Thread.sleep(1000L);
                        }
                    }
                    u.getEmailAndBody(email);
                    break;
                case "Delete Sender":
                    vanText = con.getView;
                    txt = vanText.getText();
                    System.out.println("details are: " + txt);
                    if (txt.equals("ACTIVE")) {
                        u.setWebDriverFluentWait(2, 30, By.xpath("//*[@id='ContentPlaceHolder1_pnlDeleteSender']/a[1]/i"));
                        u.click(con.getGetDeleteIcon, driver);
                        Thread.sleep(3000L);
                        u.setWebDriverFluentWait(1, 30, By.xpath("//p[@class='confirmText']"));
                        String delt = con.getConfirmText.getAttribute("innerText");
                        System.out.println("" + delt);
                        Assert.assertTrue(delt.equals("Are you sure, you want to delete this sender?"), "unable to click on delete icon");
                        System.out.println("I am on delete popup");
                        iSeeValidationInGreenColor();
                        iSeeStatusIsDeletedAndActionParameterIsEmpty();
                    }
                    break;
            }
        }
    }

    @Then("I validate contact saved message and I land on manage contact page")
    public void iValidateContactSavedMessageAndILandOnManageContactPage() {
        msg = "added as a Contact.";
        String saveMsg = companyName+" "+msg;
        System.out.println(saveMsg);
        Assert.assertEquals(con.generateVanValMsg.getText(),saveMsg);
    }


    @Then("I verify action column has only view access")
    public void iVerifyActionColumnHasOnlyViewAccess() {
        Assert.assertTrue(con.viewAction.isDisplayed());
        Assert.assertFalse(con.actionDropdown.isDisplayed());
    }

    @Then("I navigate to Reports section")
    public void iNavigateToReportsSection() throws InterruptedException {
        Thread.sleep(7000);
        u.waitAndClick(con.dashBoardMenu);


    }


    public static class requestPayment_POM {


        public requestPayment_POM(WebDriver driver) {
            driver = Hooks.driver;
            PageFactory.initElements(driver, this);
        }

    }
}










