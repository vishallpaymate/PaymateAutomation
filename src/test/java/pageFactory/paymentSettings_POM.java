package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import step_definitions.Hooks;

import java.util.List;

public class paymentSettings_POM {

    @FindBy(xpath = "//a[text()='Payment Settings']")
    public WebElement paymentSettings;

    @FindBy(xpath = "//*[@id='Ulmenu']/li[9]/ul/li[not(contains(@class,'hidden'))]/a")
    public List<WebElement> paymentSettingsMenu;

    @FindBy(xpath = "//*[text()='Manage Cards']")
    public WebElement manageCardsLink;




    public paymentSettings_POM(WebDriver driver) {
        driver = Hooks.driver;
        PageFactory.initElements(driver, this);
    }
}
