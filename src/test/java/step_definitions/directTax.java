package step_definitions;

import baseClass.Utils;
import baseClass.mainDriver;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pageFactory.addContact_POM;
import pageFactory.directTax_POM;

import java.util.List;

public class directTax extends mainDriver {
    public directTax_POM dtax = new directTax_POM(driver);
    public addContact_POM con = new addContact_POM(driver);
    public Utils u = new Utils();

    @Then("I click on Direct tax link")
    public void iClickOnDirectTaxLink() throws InterruptedException {
        u.log4j("I click on Direct Tax Link");
        u.click(dtax.getDirectTaxLink, driver);
        Thread.sleep(300);
    }

    @Then("I should see following links for Direct Tax Payment")
    public void iShouldSeeFollowingLinksForDirectTaxPayment(DataTable getTable) {
        List<List<String>> getCells = getTable.cells();
        for (int i = 0; i < getCells.size(); i++) {
            String getCell_str = getCells.get(i).get(0);
            switch (getCell_str) {
                case "Add PAN/TAN":
                    boolean bool_isDisplay = dtax.addPanTanLink.isDisplayed();
                    Assert.assertEquals(true, bool_isDisplay);
                    boolean bool_isEnabled = dtax.addPanTanLink.isEnabled();
                    Assert.assertEquals(true, bool_isEnabled);
                    u.log4j("I see link: " + getCell_str);
                    break;
                case "Manage PAN/TAN":
                    WebElement ele = dtax.managePanTanLink;
                    boolean bool1_isDisplay = ele.isEnabled();
                    Assert.assertEquals(true, bool1_isDisplay);
                    boolean bool1_isEnable = ele.isEnabled();
                    Assert.assertEquals(true, bool1_isEnable);
                    u.log4j("I see link: " + getCell_str);
                    break;
                case "Pay Tax":
                    boolean bool2_isDisplay = dtax.payTaxLink.isDisplayed();
                    Assert.assertEquals(true, bool2_isDisplay);
                    boolean bool2_isEnable =  dtax.payTaxLink.isEnabled();
                    Assert.assertEquals(true, bool2_isEnable);
                    u.log4j("I see link: " + getCell_str);
                    break;

            }
        }
    }
}
