package userData;

import baseClass.Environments;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class loop
{
    @Test
    public void login()
    {
        System.setProperty("webdriver.chrome.driver","E:\\WorkSpace\\Projects\\Paymate\\Automation\\PaymateAutomation\\WebDrivers\\usr\\bin\\chrome\\chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.navigate().to("https://dev.paymate.in/Beta/PMX3.0/Login.aspx");
    }
}
