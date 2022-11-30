package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import step_definitions.Hooks;

import java.util.List;

public class directTax_POM {

    @FindBy(xpath = "//*[text()='Direct Tax Payment']")
    public WebElement getDirectTaxLink;

    @FindBy(xpath = "//*[text()='Add PAN/TAN']")
    public WebElement addPanTanLink;

    @FindBy(xpath = "//*[text()='Manage PAN/TAN']")
    public WebElement managePanTanLink;

    @FindBy(xpath = "//*[text()='Pay Tax']")
    public WebElement payTaxLink;



    public directTax_POM(WebDriver driver) {
        driver = Hooks.driver;
        PageFactory.initElements(driver, this);
    }
}