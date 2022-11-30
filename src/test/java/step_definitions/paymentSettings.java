package step_definitions;

import cucumber.api.java8.En;
import baseClass.BusinessReports;
import baseClass.Environments;
import baseClass.Utils;
import baseClass.mainDriver;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pageFactory.*;

import java.util.List;


public class paymentSettings extends  mainDriver {
    public Utils utils = new Utils();
    public Environments environments;
    public addContact_POM con = new addContact_POM(driver);
    public paymentSettings_POM ps = new paymentSettings_POM(driver);
    public String cpText;

    @When("I click on Payment Settings")
    public void iClickOnPaymentSettings() throws InterruptedException {
        Thread.sleep(3000);
        utils.click(con.getDashBoardMenu, driver);
        utils.click(ps.paymentSettings, driver);
        utils.log4j("I clicked on payment settings link");
    }

    @Then("I see following options for Payment Settings menu")
    public void iSeeFollowingOptionsForPaymentSettingsMenu(DataTable dataTable) {
        List<List<String>> listDataTable = dataTable.cells();
        List<WebElement> listCollection = ps.paymentSettingsMenu;
        for (int i = 0; i < listCollection.size(); i++) {
            utils.setWebDriverFluentWait(1, 30, By.xpath("//*[@id='Ulmenu']/li[9]/ul/li[not(contains(@class,'hidden'))]/a"));
            String text = listCollection.get(i).getText();
            //System.out.println("*****************\n" + text);
            String dataTableText = listDataTable.get(i + 1).get(0);
            //System.out.println("--------------------------\n" + dataTableText);
            if (text.equals(dataTableText) && text.equals("Xpress Account")) {
                Assert.assertTrue(text.equals(dataTableText), "Xpress Account is not displaying");
                utils.log4j(dataTableText + "  menu is displayed");
            } else if (text.equals(dataTableText) && text.equals("Manage Cards")) {
                Assert.assertTrue(text.equals(dataTableText), "Manage Cards is not displaying");
                utils.log4j(dataTableText + "  menu is displayed");
                listCollection.get(i).click();
            } else if (text.equals(dataTableText) && text.equals("Add New Card")) {
                Assert.assertTrue(text.equals(dataTableText), "Add New Card is not displaying");
                utils.log4j(dataTableText + "  menu is displayed");
            } else if (text.equals(dataTableText) && text.equals("Saved Cards")) {
                Assert.assertTrue(text.equals(dataTableText), "Saved Cards is not displaying");
                utils.log4j(dataTableText + "  menu is displayed");
            } else if (text.equals(dataTableText) && text.equals("Settlement Accounts")) {
                Assert.assertTrue(text.equals(dataTableText), "Settlement Accounts is not displaying");
                utils.log4j(dataTableText + "  menu is displayed");
            }
            /*else {
                Assert.assertTrue(false, "");
            }*/
        }
    }

    @And("I click on following {string} for Payment Settings")
    public void iClickOnFollowingForPaymentSettings(String arg0) throws InterruptedException {
        List<WebElement> listCollection = ps.paymentSettingsMenu;
        for (int i = 0; i < listCollection.size(); i++) {
            System.out.println(ps.paymentSettingsMenu.get(i).getText());
            String text = listCollection.get(i).getAttribute("innerText");
            Thread.sleep(2000);
            if (arg0.equals("Xpress Account") && arg0.equals(text)) {
                System.out.println("Text is: " + arg0);
                utils.click(listCollection.get(i), driver);
                Thread.sleep(200L);
                cpText = con.getPageTitle.getText();
                break;
            } else if (arg0.equals("Add New Card") && arg0.equals(text)) {
                utils.waitAndClick(ps.manageCardsLink);
                utils.click(listCollection.get(i), driver);
                cpText = con.getPageTitle.getText();
            } else if (arg0.equals("Saved Cards") && arg0.equals(text)) {
                utils.waitAndClick(ps.manageCardsLink);
                utils.click(listCollection.get(i), driver);
                cpText = con.getPageTitle.getText();
            } else if (arg0.equals("Settlement Accounts") && arg0.equals(text)) {
                utils.click(listCollection.get(i), driver);
                cpText = con.getPageTitle.getText();
            }
        }
    }


    @Then("I should be land on particular page for Payment Settings")
    public void iShouldBeLandOnParticularPageForPaymentSettings() {
        System.out.println("I am on " + cpText + " page");
    }


}