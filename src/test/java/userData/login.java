package userData;

import baseClass.mainDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class login extends mainDriver {
    @Test
    public void Login() {
        System.setProperty("webdriver.chrome.driver", "E:\\WorkSpace\\Projects\\Paymate\\Automation\\PaymateAutomation\\WebDrivers\\usr\\bin\\chrome\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.navigate().to("https://dev.paymate.in/Beta/PMX3.0/Login.aspx");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//input[@name='ctl00$cphContents$txtParanNaam']")).sendKeys("pri47@yopmail.com");
        driver.findElement(By.xpath("//input[@id='txtParanShabd']")).sendKeys("Paymate@123");
        driver.findElement(By.xpath("//input[@id='cphContents_btnLogin']")).click();;
        driver.navigate().to("https://dev.paymate.in/Beta/PMX3.0/Login.aspx");
    }
}
