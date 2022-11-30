package baseClass;

import com.github.javafaker.Faker;
import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;
import cucumber.api.java.eo.Se;
import org.apache.commons.configuration.Configuration;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.log4j.PropertyConfigurator;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.tika.utils.DateUtils;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pageFactory.Login_POM;
import pageFactory.addContact_POM;
import pageFactory.uploadKyc_POM;

import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import static org.openqa.selenium.Keys.*;

public class Utils extends mainDriver {
    private static String driverDirectory = System.getProperty("user.dir") + "/webDrivers/usr/bin";
    private ChromeOptions chromeOptions = new ChromeOptions();
    // public WebDriver driver;
    public DesiredCapabilities cap;
    public WebDriverWait webDriverWait;
    public JavascriptExecutor jse = (JavascriptExecutor) driver;
    public uploadKyc_POM uploadkyc = new uploadKyc_POM(driver);
    public String text;
    // public emailSubjects emailsub = new emailSubjects();
    private String text2;
    public int i;
    public String mailliks;
    public List<WebElement> links;
    public int j;
    public File file;
    public FileInputStream inputStream;
    public HSSFSheet sheet;
    public Row row;
    public addContact_POM con = new addContact_POM(driver);
    public Workbook workbook;
    public String txt;
    public String compnayName;
    public List<WebElement> listCompanyName;
    public String str;
    public String linksText;
    public Login_POM lp = new Login_POM(driver);
    public Properties obj = new Properties();
    public FileInputStream ojFile;
    public String date;
    public String strCurrentValue;
    public String str_sub;
    public String accountBalance;
    ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
    //  public Utils() {
    //driver = Hooks.driver;
    // }

    public void getCurrentDataTime() {
        DateFormat df = new SimpleDateFormat("dd/MMM/yyyy");
        Date dateobj = new Date();
        date = df.format(dateobj);
        //System.out.println("Date is: " + date);
    }

    public String addOneDay(String dateAdd) throws ParseException {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MMM/yyyy");
        Calendar c = Calendar.getInstance();
        c.setTime(sdf.parse(dateAdd));
        c.add(Calendar.DATE, 1);  // number of days to add
        dateAdd = sdf.format(c.getTime());  // dt is now the new date
        System.out.println("+1111111111: " + dateAdd);
        return dateAdd;
    }


    public static HashMap<String, String> paymentMode() {
        HashMap<String, String> hashMap = new HashMap<String, String>();
        hashMap.put("Credit Card", "4111111111111111_vishal_24/2022_123");
        hashMap.put("Net Banking", "Corporation Bank");
        return hashMap;
    }


    public String calculateDueDate(String dateAdd, int count) throws ParseException {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MMM/yyyy");
        Calendar c = Calendar.getInstance();
        c.setTime(sdf.parse(dateAdd));
        c.add(Calendar.DATE, count);  // number of days to add
        dateAdd = sdf.format(c.getTime());  // dt is now the new date
        return dateAdd;
    }

    public void duplicateString(String enterString, String enterMsg) {
        ArrayList<String> array = new ArrayList<String>();
        array.add(enterString);

        for (int i = 0; i < array.size(); i++) {
            String array1 = array.get(i);
            for (int j = 0; j < array.size(); j++) {
                String array2 = array.get(j);
                if (array1 == array2) {
                    System.out.println(enterMsg);
                }
            }
        }
    }

    public double calculateGST(double GST, double amt) {
        double total = (GST * amt) / 100;
        return total;
    }

    public BigDecimal calculateGST(BigDecimal GST, BigDecimal amt) {
        BigDecimal a = new BigDecimal(100);
        BigDecimal total = GST.multiply(amt).divide(a);
        return total;
    }

    public void duplicateChar(String enterString) {
        int count = 0;
        for (int i = 0; i < enterString.length(); i++) {
            for (int j = 0; j < enterString.length(); j++) {

                if (enterString.charAt(i) == enterString.charAt(j)) {
                    count++;
                }
            }
            //System.out.println(enterString.charAt(i) + "------" + count);
            count = 0;
        }
    }

    public void handelPopUp(String alertEvent) {

        switch (alertEvent) {
            case "gettext": {
                String alerttext = driver.switchTo().alert().getText();
                System.out.println("This Is Alert Text: " + alerttext);
                break;
            }
            case "accept": {
                driver.switchTo().alert().accept();
                System.out.println("Popup Accepted Successfully: ");
            }
            case "cancel": {
                driver.switchTo().alert().dismiss();
                System.out.println("Popup Closed Successfully");
            }
            case "switch": {
                driver.switchTo().alert();
            }

        }

        driver.switchTo().alert().getText();
        driver.switchTo().alert().accept();

    }

    public void handelWindows() {

        String parent = driver.getWindowHandle();
        Set<String> s1 = driver.getWindowHandles();
        Iterator<String> I1 = s1.iterator();

        while (I1.hasNext()) {
            String child_window = I1.next();
            if (!parent.equals(child_window)) {
                driver.switchTo().window(child_window);
                System.out.println(driver.switchTo().window(child_window).getTitle());
                System.out.println(driver.getCurrentUrl());
            }
        }
    }

    public void title() {
        String title = driver.getTitle();
        System.out.println(title);
    }

    public void click(WebElement element, WebDriver driver) {

        jse.executeScript("arguments[0].click();", element);
    }

    public void typeText(By by, String value) {
        jse.executeScript("document.getElementById().value = '';");
    }

    public void waitElementShouldBeClickable(WebElement element) {

        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void waitAndClick(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    public void waitListOFElementShouldBeClickable(List<WebElement> element) {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfAllElements(element));
    }

    public void pageLoadTime() {
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
    }

    public static String fakerData(String type, String value) {
        Faker faker = new Faker();

        FakeValuesService fakeValuesService;
        switch (type) {
            case "email":
                fakeValuesService = new FakeValuesService(
                        new Locale("en-GB"), new RandomService());
                value = fakeValuesService.bothify(value + "###@mailinator.com");

                //System.out.println(email);
                break;
            case "address":
                String streetName = faker.address().streetName();
                String number = faker.address().buildingNumber();
                String city = faker.address().city();
                String country = faker.address().country();

                value = String.format("%s\n%s\n%s\n%s",
                        number,
                        streetName,
                        city,
                        country);
                break;
            case "firstName":
                value = faker.name().firstName();
                break;
            case "lastName":
                value = faker.name().lastName();
                break;
            case "referenceCode":
                fakeValuesService = new FakeValuesService(
                        new Locale("en-GB"), new RandomService());
                value = fakeValuesService.bothify("######");
                break;
            case "companyName":
                value = faker.company().name().concat(" .LTD");
                break;

        }
        return value;
    }


    public void getMarqueeText() {

        Assert.assertEquals(driver.findElement(By.tagName("//marquee")).getText(), " Note : Payments made after 17:00 hours (5pm) will be processed in the next working day.");
        System.out.println(driver.findElement(By.tagName("//marquee")).getText());
    }

    public void waitAndClick(WebDriver driver, By by) {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(by));
        driver.findElement(by).click();
    }

    public void ScrollToElement(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public String waitAndGetText(WebDriver driver, By by) {
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(by));
        String text = driver.findElement(by).getText();
        System.out.println(text);
        return text;
    }


    public void waitUntilElelemntShouldBeDisplay(WebDriver driver, By by, long timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public void waitUntilWebElelemntShouldBeDisplay(WebDriver driver, WebElement element, long timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void selectFromDropDown(List<WebElement> elements,String val) throws InterruptedException {
        int eleSize = elements.size();
        for (int i = 0; i < eleSize; i++) {
            String valuesAre = elements.get(i).getAttribute("innerHTML");
//                System.out.println("\n Value is: " + valuesAre);
            if (valuesAre.equals(val)) {
                elements.get(i).click();
                break;
            }
            Thread.sleep(200);
        }
    }


    public void visibilityIfElement(WebDriver driver, By by, long timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public void waitAndSwitchToNewWindow(WebDriver driver, By by) {
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(by));
        if (driver.findElement(by).isDisplayed()) {
            driver.switchTo().activeElement();
        }
    }

    public void scrollUp() {
        jse.executeScript("scroll(0, -250);");

    }

    public void scrollDown() {
        jse.executeScript("scroll(132, 585);");
    }

    public void sideBarScrollDown(WebElement element) {
        jse.executeScript("arguments[0].scrollIntoView();", element);
    }

    public void scrollRight() {
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(2000,0)");
    }

    public void scrollToViewAndClick(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        element.click();
    }

    public void scrollTo(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);

    }


    public boolean retryingToFindElement(WebElement element, String event) {
        boolean result = false;
        int attemptCount = 0;
        switch (event) {
            case "getText":
                while (attemptCount < 4) {
                    try {

                        str_sub = element.getText();
                        log4j("Retrying to find element");
                        //System.out.println("Line number 244");
                        result = true;
                        break;

                    } catch (org.openqa.selenium.StaleElementReferenceException e) {

                    }
                    attemptCount++;
                }
                break;
            case "click":
                while (attemptCount < 4) {
                    try {

                        click(element, driver);
                        log4j("Retrying to find element");
                        result = true;
                        break;

                    } catch (org.openqa.selenium.StaleElementReferenceException e) {

                    }
                    attemptCount++;
                }
                break;

        }
        return result;
    }


    public void toFocousOnElement(WebDriver driver, WebElement element) {
        Actions action = new Actions(driver);
        action.moveToElement(element);
        action.click();
        action.build().perform();
    }

    public void focusOnTab() {
        //((JavascriptExecutor) driver).executeScript("window.focus();");
        ((JavascriptExecutor) driver).executeScript("window.focus()");
    }

    public void OpenMail(String Emailid) throws InterruptedException {
        //openNewTab();
        driver.navigate().to("http://yopmail.com/en/");
        driver.findElement(By.xpath("//*[@id='login']")).clear();
        driver.findElement(By.xpath("//*[@id='login']")).sendKeys(Emailid);
        //Thread.sleep(2000L);
        driver.findElement(By.xpath("//*[@id='refreshbut']/button")).click();
        focusOnTab();
        driver.navigate().refresh();
        Thread.sleep(3000L);
//        driver.findElement(By.xpath("//*[@id='mail']//tr[2]//p[1]")).click();

        driver.switchTo().frame(2);
        FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(40, TimeUnit.SECONDS)
                .pollingEvery(1, TimeUnit.SECONDS)
                .ignoring(NoSuchElementException.class);

        wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOfElementLocated((By.xpath("//*[contains(text(),'Dear')]")))));
        text = (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].value", driver.findElement(By.xpath("//*[contains(text(),'Dear')]")));
        System.out.println(text);
        links = driver.findElements(By.tagName("a"));
        System.out.println("Total Links in mail are: " + links.size());


    }

    public void switchToTab() throws InterruptedException {
        String parent = driver.getWindowHandle();
// This will return the number of windows opened by Webdriver and will return Set of Strings
        Set<String> s1 = driver.getWindowHandles();
// Now we will iterate using Iterator
        Iterator<String> I1 = s1.iterator();
        while (I1.hasNext()) {
            String child_window = I1.next();
// Here we will compare if parent window is not equal to child window then we  will close

            if (!parent.equals(child_window)) {
                driver.switchTo().window(child_window);
                System.out.println(driver.switchTo().window(child_window).getTitle());
                Thread.sleep(3000);
                break;
            }

        }

    }

    public void setWebDriverFluentWait(int poolInterval, int timeOutDuration, By by) {
        FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(timeOutDuration, TimeUnit.SECONDS)
                .pollingEvery(poolInterval, TimeUnit.SECONDS)
                .ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOfElementLocated(by)));

    }

    public void impliciteWait() {

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    public void openNewTab() throws InterruptedException {
        if (driver instanceof JavascriptExecutor) {
            ((JavascriptExecutor) driver).executeScript("window.open();");
        }
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        System.out.println("Total opened tabs are: " + tabs.size());
        for (int i = 0; i < tabs.size(); i++) {
            driver.switchTo().window(tabs.get(i));
            break;
        }

    }

    public void popUpWindow() {
        String mainWinHander = driver.getWindowHandle();

// code for clicking button to open new window is ommited

//Now the window opened. So here reture the handle with size = 2
        Set<String> handles = driver.getWindowHandles();

        for (String handle : handles) {
            if (!mainWinHander.equals(handle)) {
                // Here will block for ever. No exception and timeout!
                WebDriver popup = driver.switchTo().window(handle);
                // do something with popup
                popup.close();
            }
        }
    }

    public void getMails(String Emailid) throws InterruptedException {
        driver.navigate().to("http://yopmail.com/en/");
        log4j("I enter yopmail url");
        driver.findElement(By.xpath("//*[@id='login']")).clear();
        log4j("I clear email id text box");
        driver.findElement(By.xpath("//*[@id='login']")).sendKeys(Emailid);

        driver.findElement(By.xpath("//input[@class='sbut']")).click();

        log4j("I opend mail " + " mail id is: " + Emailid);
        Set<String> windows = driver.getWindowHandles();
        int winSize = windows.size();
        System.out.println("Window size is: " + winSize);
        driver.navigate().refresh();
        Thread.sleep(1000L);
        focusOnTab();
        int numberofFrame = driver.findElements(By.xpath("//iframe")).size();
        System.out.println("Number of of frame is: \n" + numberofFrame);
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='ifmail']")));
        links = driver.findElements(By.tagName("a"));
        System.out.println("Total Links in mail are: " + links.size());
        log4j("=================================================================================================================================================================");
        //setWebDriverFluentWait(1, 40, By.xpath("//td[@valign='top']"));
        //waitUntilElelemntShouldBeDisplay(driver, By.xpath("//td[@valign='top']"), 30);
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOfElementLocated(By.id("mailhaut"))));
        //retryingToFindElement(driver.findElement(By.xpath("")), "getText");
        txt = driver.findElement(By.id("mailhaut")).getText();
        log4j("=======================================================================================================EMAIL IS==========================================================\n" + txt);


    }

    public void getMail(String Emailid) throws InterruptedException {
        driver.navigate().to("https://www.mailinator.com/");
        driver.findElement(By.xpath("//*[@id='search']")).sendKeys(Emailid);
//        driver.findElement(By.xpath("//*[@id='inbox_field']")).sendKeys(Emailid);
        driver.findElement(By.xpath("//button[@value='Search for public inbox for free']")).click();
        Thread.sleep(2000L);
        List<WebElement> emailLink = driver.findElements(By.xpath("//*[contains(@id,'row_')]/td[3]"));
        for (i = 0; i < emailLink.size(); i++) {
            System.out.println("Line 550: " + emailLink.get(i).getText());
            if(emailLink.get(i).getText().contains("Congratulations")){
                emailLink.get(i).click();
            }else if(emailLink.get(i).getText().contains("Request to connect with")){
                emailLink.get(i).click();
            }
            else if(emailLink.get(i).getText().contains("Welcome to PayMate! Verify your email address and complete your account setup.")){
                emailLink.get(i).click();
            }
           else if (emailLink.get(i).getText().contains("Verify your email : To activate PayMate account")) {
                emailLink.get(i).click();
            } else if (emailLink.get(i).getText().contains("Action Required")) {
                emailLink.get(i).click();
            } else if (emailLink.get(i).getText().contains("requested payment")) {
                emailLink.get(i).click();
            }
            else if(emailLink.get(i).getText().contains("User credentials for PayMate as Transaction Maker")){
                emailLink.get(i).click();
            }else if(emailLink.get(i).getText().contains("Your PayMate account is ready")){
            }
            else if(emailLink.get(i).getText().contains("User credentials for PayMate as Transaction Approver")){
                emailLink.get(i).click();
            }
            else if(emailLink.get(i).getText().contains("User credentials for PayMate as Payer")){
                emailLink.get(i).click();
            }
            else if(emailLink.get(i).getText().contains("Account activation for sending money")){
                emailLink.get(i).click();
            }
        }
//        driver.findElement(By.xpath("//*[contains(@id,'row_')]/td[4]/a")).click();

        driver.switchTo().frame(driver.findElement(By.id("html_msg_body")));
        links = driver.findElements(By.tagName("a"));
        System.out.println("Total Links in mail are: " + links.size());
//        txt = driver.findElement(By.xpath("//*[@id=\"bodyCell\"]/table/tbody/tr[2]/td/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr/td")).getText();
//        System.out.println("Line 543:"+txt);
        log4j("=================================================================================================================================================================");
        /*WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[@valign='top']"))));
        txt = driver.findElement(By.xpath("//td[@valign='top']")).getText();
       */
        log4j("=======================================================================================================EMAIL IS==========================================================\n" + txt);
        Thread.sleep(2000L);

//        log4j("I opend mail " + " mail id is: " + Emailid);
//        Set<String> windows = driver.getWindowHandles();
//        int winSize = windows.size();
//        System.out.println("Window size is: " + winSize);
//        driver.navigate().refresh();
//        Thread.sleep(1000L);
//        focusOnTab();
//        *//*int numberofFrame = driver.findElements(By.xpath("//iframe")).size();
//        System.out.println("Number of of frame is: \n" + numberofFrame);*//*
//        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='ifmail']")));
//        links = driver.findElements(By.tagName("a"));
//        System.out.println("Total Links in mail are: " + links.size());
//        log4j("=================================================================================================================================================================");
//        //setWebDriverFluentWait(1, 40, By.xpath("//td[@valign='top']"));
//        //waitUntilElelemntShouldBeDisplay(driver, By.xpath("//td[@valign='top']"), 30);
//        WebDriverWait wait = new WebDriverWait(driver, 30);
//        wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[@valign='top']"))));
//        //retryingToFindElement(driver.findElement(By.xpath("")), "getText");
//        txt = driver.findElement(By.xpath("//td[@valign='top']")).getText();
//        log4j("=======================================================================================================EMAIL IS==========================================================\n" + txt);


    }

    public void getEmailAndBody(String Emailid) throws InterruptedException, AWTException {
          //driver.findElement(By.cssSelector("body")).sendKeys(Keys.chord(CONTROL,"t"));
        ((JavascriptExecutor) driver).executeScript("window.open()");
        switchToTab();
//        driver.switchTo().window(tabs.get(1)); //switches to new tab
        driver.navigate().to("https://www.mailinator.com/");
        driver.findElement(By.xpath("//*[@id='addOverlay']")).sendKeys(Emailid);
        driver.findElement(By.xpath("//*[@id='go-to-public']")).click();
        Thread.sleep(2000L);
        driver.findElement(By.xpath("//*[contains(@id,'row_')]/td[4]/a")).click();

        driver.switchTo().frame(driver.findElement(By.id("msg_body")));
        links = driver.findElements(By.tagName("a"));
        System.out.println("Total Links in mail are: " + links.size());
        log4j("=================================================================================================================================================================");
        /*WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[@valign='top']"))));
        txt = driver.findElement(By.xpath("//td[@valign='top']")).getText();
       */
        log4j("=======================================================================================================EMAIL IS==========================================================\n" + txt);
        Thread.sleep(2000L);
        System.out.println("Email i got \n" + "\n\n\n=================================================================================================================================================================");
        waitUntilElelemntShouldBeDisplay(driver, By.xpath("//td[@valign='top']"), 300);
        //setWebDriverFluentWait(1, 40, By.xpath("//td[@valign='top']"));
        waitUntilElelemntShouldBeDisplay(driver,By.xpath("//td[@valign='top']"),20);
        txt = driver.findElement(By.xpath("//td[@valign='top']")).getText();
        System.out.println("Email i got \n" + txt + "\n\n\n=================================================================================================================================================================");
        CloseCurrentTabAndSwitch();

    }

    public void businessIdentityDetailsValidations() {
        Boolean nameOnPan = uploadkyc.getNameOnPan.isDisplayed();
        log4j("Checking Name on Pan field");
        Assert.assertTrue(nameOnPan, "Field not present");

        String nameOnPanLabel = uploadkyc.getNameOnPanLabel.getText();
        Assert.assertEquals(nameOnPanLabel, "Name on PAN *");
        log4j("Name on Pan label is" + nameOnPanLabel);

        log4j("Checking Pan Number field");
        Boolean panNumber = uploadkyc.getEnterPanNumber.isDisplayed();
        Assert.assertTrue(panNumber, "Field not present");

        String enterPanNumberLabel = uploadkyc.getEnterPanNumberLabel.getText();
        Assert.assertEquals(enterPanNumberLabel, "Enter PAN Number *");
        log4j("Enter Pan Number label is" + nameOnPanLabel);

        log4j("Checking Upload Pan Card Image Field");
        Boolean uploadPanImage = uploadkyc.getUploadPanCardImage.isEnabled();
        Assert.assertTrue(uploadPanImage, "Field not enabled");

        String panCardImageLabel = uploadkyc.getUploadPanCardImageLabel.getText();
        Assert.assertEquals(panCardImageLabel, "Upload PAN Card Image*");
        log4j("Upload image guidance text is: " + panCardImageLabel);

        String imageGuidanceText = uploadkyc.getImageTypeGuidanceText.getText();
        Assert.assertEquals(imageGuidanceText, "Upload a PDF, JPG, JPEG, GIF, PNG of PAN Card for upto 2MB size");
        log4j("Upload image guidance text is: " + imageGuidanceText);
    }

    public void businessProofDetailsValidation1() {
        String businessProofDetailsTitle = uploadkyc.getBusinessProffDetailsTitle.getText();
        Assert.assertEquals(businessProofDetailsTitle, "Business Proof Details");

        log4j("Checking Business Document Upload Dropdown values");
        String dropdownValues[] = {"--SELECT--", "GST Certificate", "PF Registration Certificate", "Professional Tax Certificate", "Shop Establishment Certificate"};
        List<WebElement> value = uploadkyc.getBusinnessDocumentDropDownValues;
        int totalvalues = value.size();

        for (int i = 0; i < totalvalues; i++) {
            String valuesAre = value.get(i).getAttribute("innerHTML");
            Assert.assertEquals(valuesAre, dropdownValues[i]);
        }
        log4j("All values are present");


        Boolean businessUploadDocumentField = uploadkyc.getUploadBusinessDocumentField.isEnabled();
        Assert.assertTrue(businessUploadDocumentField, "Field not enabled");

        String businessUploadDocumentLabel = uploadkyc.getUploadBusinessDocumentLabel.getText();
        Assert.assertEquals(businessUploadDocumentLabel, "Upload Business Document*");
        log4j("Business document label text is: " + businessUploadDocumentLabel);
    }

    public void businessProofDetailsValidation2() {
        String businessNameLabel = uploadkyc.getBusinessNameLabel.getText();
        Assert.assertEquals(businessNameLabel, "Business Name *");

        Boolean businessNameField = uploadkyc.getBusinessName.isDisplayed();
        Assert.assertTrue(businessNameField, "Field is not displayed");

        String companyIdentificationLabel = uploadkyc.getCompanyIdentificationNumberLabel.getText();
        Assert.assertEquals(companyIdentificationLabel, "Company Identification Number *");

        Boolean companyIdentificationField = uploadkyc.getCompanyIdentificationNumber.isDisplayed();
        Assert.assertTrue(companyIdentificationField, "Field is Displayed");
    }


    public void businessAddressDetailsValidation() {
        String adderessDetailsTitle = uploadkyc.getAddressDetailsTitle.getText();
        Assert.assertEquals(adderessDetailsTitle, "Address Details");

        Boolean address = uploadkyc.getAddressField.isDisplayed();
        Assert.assertTrue(address, "Field not present");
        String addressLabel = uploadkyc.getAddressLabel.getText();
        Assert.assertEquals(addressLabel, "Address *");

        Boolean cityTextBox = uploadkyc.getCityTextBox.isDisplayed();
        Assert.assertTrue(cityTextBox, "Field is not displayed");
        String cityLabel = uploadkyc.getCityLabel.getText();
        Assert.assertEquals(cityLabel, "City *");

        Boolean pincodeTextBox = uploadkyc.getPinCodeField.isDisplayed();
        Assert.assertTrue(pincodeTextBox, "Field is not displayed");

        String pincodeLabel = uploadkyc.getPinCodeLabel.getText();
        Assert.assertEquals(pincodeLabel, "Pin Code *");

        String stateLabel = uploadkyc.getStateLabel.getText();
        Assert.assertEquals(stateLabel, "State *");

        log4j("Checking state dropdown values");
        String[] stateDropdownValues = {"Select", "Andaman and Nicobar Islands", "Andhra Pradesh", "Arunachal Pradesh", "Assam", "Bihar", "Chandigarh", "Chhattisgarh", "Dadra and Nagar Haveli", "Daman and Diu", "Delhi", "Goa", "Gujarat", "Haryana", "Himachal Pradesh", "Jammu and Kashmir", "Jharkhand", "Karnataka", "Kerala", "Ladakh", "Lakshadweep", "Madhya Pradesh", "Maharashtra", "Manipur", "Meghalaya", "Mizoram", "Nagaland", "Odisha", "Puducherry", "Punjab", "Rajasthan", "Sikkim", "Tamil Nadu", "Telangana", "Tripura", "Uttar Pradesh", "Uttarakhand", "West Bengal"};
        List<WebElement> val = uploadkyc.getStateDropDownValues;
        for (int i = 0; i < val.size(); i++) {
            String valuesAre = val.get(i).getAttribute("innerHTML");
//                    String values = valuesAre.concat("\",");
//                    //String val0 = values.concat('"' + values + '"');
//
//                    System.out.print("\""+values);
            Assert.assertEquals(valuesAre, stateDropdownValues[i]);
//                    u.log4j(valuesAre + dropdownValues[i]);
        }
        log4j("All values are present");

        Boolean uploadButtonField = uploadkyc.getUploadButtonField.isEnabled();
        Assert.assertTrue(uploadButtonField, "Upload button field is not enabled");
        log4j("Upload button Field is enabled");

        Boolean uploadButton = uploadkyc.getUploadButton.isEnabled();
        Assert.assertTrue(uploadButton, "Upload button is not enabled");
        log4j("Upload button is enabled");
    }

    public void transactionDetails() {
        String transactionDetailsTitle = driver.findElement(By.xpath("//*[@class='header']/h2")).getText();
        System.out.println("Transaction Details Page: " + transactionDetailsTitle);

        List<WebElement> listHeading = driver.findElements(By.xpath("//*[@class='mdl-table']//tr/td/strong"));
        int count = 0;
        for (WebElement element : listHeading) {
            String heading = element.getText();
            //System.out.println("-----------------------------------------------------------------------------------------" + heading);
            String data = driver.findElements(By.xpath("//*[@class='mdl-table']//tr/td/span")).get(count).getAttribute("innerText");

            switch (heading) {
                case "Merchant":
                    Assert.assertEquals(data, "PayMate India P. Ltd.", "Invalid merchent name");
                    log4j("I verified merechent name: " + data);
                    break;
                case "Amount":
                    log4j("I verified Amount: " + data);
                    break;
                case "Xpress Charge":
                    log4j("I Xpress charges: " + data);
                    break;
                case "Total":
                    log4j("I verified Total Amount: " + data);
                    break;
                default:
                    Assert.assertTrue(false, "Table heading is missed");
            }

            //System.out.println("-----------------------------------------------------------------------------------------" + data);
            count++;
        }
        List<WebElement> currencyCode = driver.findElements(By.xpath("//*[@class='mdl-data-table__cell--non-numeric tdCurrencyCode']"));
        for (WebElement element1 : currencyCode) {
            String currencyCodeStr = element1.getAttribute("innerText");
            //System.out.println("---------------------------------------------------------------------------------------" + currencyCodeStr);
        }


    }

    public void log4j(String msg) {
        Logger log = Logger.getLogger(Utils.class.getSimpleName());
        PropertyConfigurator.configure("Log4j.properties");
        log.info(msg);
    }

    public void getSelectedDropDown(WebElement element) {
        Select sel = new Select(element);
        //strCurrentValue = sel.getFirstSelectedOption().getText();
        element.click();
        //Print the Currently selected value
        //System.out.println(strCurrentValue);
    }

    public void webdriverWait(int timeToWait, By element) {
        WebDriverWait wait;

        wait = new WebDriverWait(driver, timeToWait);
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
        try {
            if ((wait.until(ExpectedConditions.visibilityOfElementLocated(element)).isDisplayed()))
                System.out.println("Element is displayed within " + timeToWait + " sec");
        } catch (StaleElementReferenceException e) {
            String exe = e.getMessage();
            System.out.println("This is exception message: " + exe);
            timeToWait++;
            System.out.println("Time elapsed " + timeToWait + " sec extra");
        }
    }

    public boolean isFileDownloaded(String downloadPath, String fileName) {
        boolean bool = false;
        File dir = new File(downloadPath);
        File[] dir_contents = dir.listFiles();

        for (int i = 0; i < dir_contents.length; i++) {
            if (dir_contents[i].getName().equals(fileName))
                return bool = true;
        }

        return bool;
    }

    public boolean isAlertPresent() throws InterruptedException {
        try {
            driver.findElement(By.xpath("//span[@class='gb_Ba gbii']")).click();
            Thread.sleep(3000L);
            driver.findElement(By.xpath("//*[contains(@id,'gb_')]")).click();
            Thread.sleep(3000L);
            return true;
        }   // try
        catch (UnhandledAlertException ex) {
            Alert alert = driver.switchTo().alert();
            alert.accept();
            driver.findElement(By.xpath("//span[@class='gb_Ba gbii']")).click();
            Thread.sleep(3000L);
            driver.findElement(By.xpath("//*[contains(@id,'gb_')]")).click();
            Thread.sleep(3000L);
            return false;
        }   // catch
    }   // isAlertPresent()

    public void logOut() throws Exception {
        try {
            driver.findElement(By.xpath("//span[@class='gb_Ba gbii']")).click();
            Thread.sleep(3000L);
            driver.findElement(By.xpath("//*[contains(@id,'gb_')]")).click();
            Thread.sleep(3000L);
        } catch (UnhandledAlertException f) {
            driver.switchTo().alert().accept();
                /*String alertText = alert.getText();
                System.out.println("Alert data: " + alertText);
                alert.accept();*/

        } catch (NoAlertPresentException e) {
            e.printStackTrace();
        }
    }
//isAlertPresent();

/*    public void pmxLogout() throws Exception {
       waitUntilElelemntShouldBeDisplay(driver,By.xpath("//*[@id='navbarDropdown']"),20);
        try {
            driver.findElement(By.xpath("//*[@id='navbarDropdown']")).click();
            Thread.sleep(500L);
            driver.findElement(By.xpath("//*[@class='menu-info logout']")).click();
            Thread.sleep(2000L);
        } catch (UnhandledAlertException f) {
            driver.switchTo().alert().accept();
                *//*String alertText = alert.getText();
                System.out.println("Alert data: " + alertText);
                alert.accept();*//*

        } catch (NoAlertPresentException e) {
            e.printStackTrace();
        }
    }*/

    public void pmxLogout() throws Exception {
        Thread.sleep(10000);
        WebElement profileDropdown = driver.findElement(By.xpath("//*[@id='navbarDropdown']"));
        waitAndClick(profileDropdown);
        Thread.sleep(500L);
        driver.findElement(By.xpath("//*[@class='menu-info logout']")).click();
        Thread.sleep(2000L);
    }


    public void gmailLogOut() throws InterruptedException {
        driver.findElement(By.xpath("//*[@id='view_container']/div/div/div[1]/div/div[2]/div/div[3]")).click();
        Thread.sleep(2000L);
        /*List<WebElement> ele = driver.findElements(By.xpath("//*[@class='EGh9fe']"));
        System.out.println("Elelment size: " + ele.size());
        if (ele.size() != 1) {
            System.out.println("test");
            driver.findElement(By.xpath("//div[contains(text(),'Use another account')]")).click();
        } else {
            //driver.findElement(By.xpath("//*[@class='byb8te']")).click();
            Thread.sleep(3000L);
            driver.findElement(By.xpath("//div[contains(text(),'Use another account')]")).click();
        }*/
        click(driver.findElement(By.xpath("//div[contains(text(),'Use another account')]")), driver);
    }

    /* Get the latest file*/
    public File getLatestFilefromDir(String dirPath) {
        File dir = new File(dirPath);
        File[] files = dir.listFiles();
        if (files == null || files.length == 0) {
            return null;
        }

        File lastModifiedFile = files[0];
        for (int i = 1; i < files.length; i++) {
            if (lastModifiedFile.lastModified() < files[i].lastModified()) {
                lastModifiedFile = files[i];
            }
        }
        return lastModifiedFile;
    }


    /* Check the file from a directory with extension */
    public boolean isFileDownloaded_Ext(String dirPath, String ext) {
        boolean bool = false;
        File dir = new File(dirPath);
        System.out.println("Line number 602: " + dir);
        File[] files = dir.listFiles();
        //System.out.println("Line number 604: "+files.toString());
        if (files == null || files.length == 0) {
            bool = false;
        }
        System.out.println("Line number 608: " + files.length);
        for (int i = 1; i < files.length; i++) {
            // System.out.println("Line number 608: "+files[i].getName().contains(ext));
            if (files[i].getName().contains(ext)) {
                bool = true;
            }
        }
        dir.delete();
        return bool;

    }

    public void readExcel(String filePath, String fileName, String sheetName) throws IOException {

        file = new File(filePath + "" + "" + fileName);
        inputStream = new FileInputStream(file);
        workbook = new HSSFWorkbook(inputStream);
        sheet = (HSSFSheet) workbook.getSheet(sheetName);
        int rowCount = sheet.getLastRowNum();
        System.out.println("Row Count: " + rowCount);
        for (int i = 0; i < rowCount; i++) {
            row = sheet.getRow(i);

            //Create a loop to print cell values in a row

            for (j = 0; j < row.getLastCellNum(); j++) {

                //Print Excel data in console
                String excelValues = row.getCell(j).getStringCellValue();
                System.out.println("Excel values: " + excelValues);

            }

            System.out.println();
        }
        file.delete();

    }

    public void writeExcel(String filePath, String fileName, String[] dataToWrite) throws IOException {

        //Create an object of File class to open xlsx file

        File file = new File(filePath + "\\" + fileName);

        //Create an object of FileInputStream class to read excel file

        FileInputStream inputStream = new FileInputStream(file);

        Workbook workbook = null;

        //Find the file extension by splitting  file name in substring and getting only extension name

        String fileExtensionName = fileName.substring(fileName.indexOf("."));

        //If it is xls file then create object of XSSFWorkbook class

        workbook = new HSSFWorkbook(inputStream);


        //Read excel sheet by sheet name

        Sheet sheet = workbook.getSheet("Sheet1");

        //Get the current count of rows in excel file

        int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum();

        //Get the first row from the sheet

        Row row = sheet.getRow(0);

        //Create a new row and append it at last of sheet

        Row newRow = sheet.createRow(rowCount);

        //Create a loop over the cell of newly created Row
        System.out.println("row.getLastCellNum(): " + row.getLastCellNum());
        for (int j = 0; j < row.getLastCellNum(); j++) {

            //Fill data in row

            Cell cell = newRow.createCell(j);

            cell.setCellValue(dataToWrite[j]);

        }

        //Close input stream

        inputStream.close();

        //Create an object of FileOutputStream class to create write data in excel file

        FileOutputStream outputStream = new FileOutputStream(file);

        //write data in the excel file

        workbook.write(outputStream);

        //close output stream

        outputStream.close();

    }

    public void move(WebElement element) {
        Actions actions = new Actions(driver);
        actions.moveToElement(element).build().perform();
    }

    public void deleteOldFile(String filePath) {
        File file = new File(filePath);

        if (file.delete()) {
            System.out.println("File deleted successfully");
        } else {
            System.out.println("Failed to delete the file, File may be open or there is no file");
        }
    }

    public void getEmailBody() throws InterruptedException {
        System.out.println("Email i got \n" + "\n\n\n=================================================================================================================================================================");
        if(con.signUpButtonEmailList.size()>0){
            waitUntilWebElelemntShouldBeDisplay(driver,con.signUpButtonEmail,5);
            txt = con.signUpButtonEmail.getText();
            System.out.println("Email i got \n" + txt + "\n\n\n=================================================================================================================================================================");
        }else {
//            waitUntilWebElelemntShouldBeDisplay(driver,con.signupUpButtonEmailHdfc,5);
            txt = con.signupUpButtonEmailHdfc.getText();
            System.out.println("Email i got \n" + txt + "\n\n\n=================================================================================================================================================================");
        }
//        waitUntilElelemntShouldBeDisplay(driver, By.xpath("/html/body/table/tbody/tr[2]/td/table/tbody/tr/td/p/a[1]"), 30);
//        waitUntilElelemntShouldBeDisplay(driver, By.xpath("//td[@valign='top']"), 300);
        //setWebDriverFluentWait(1, 40, By.xpath("//td[@valign='top']"));
        //waitUntilElelemntShouldBeDisplay(driver,By.xpath("//td[@valign='top']"),20);
//        txt = driver.findElement(By.xpath("//td[@valign='top']")).getText();
//        txt = driver.findElement(By.xpath("/html/body/table/tbody/tr[2]/td/table/tbody/tr/td/p/a[1]")).getText();
//        System.out.println("Email i got \n" + txt + "\n\n\n=================================================================================================================================================================");
    }

    public void getEmailBodyHDFC() throws InterruptedException {
        System.out.println("Email i got \n" + "\n\n\n=================================================================================================================================================================");
        waitUntilElelemntShouldBeDisplay(driver, By.xpath("/html/body/center/div/table/tbody/tr[2]/td/div/a"), 30);
//        waitUntilElelemntShouldBeDisplay(driver, By.xpath("//td[@valign='top']"), 300);
        //setWebDriverFluentWait(1, 40, By.xpath("//td[@valign='top']"));
        //waitUntilElelemntShouldBeDisplay(driver,By.xpath("//td[@valign='top']"),20);
//        txt = driver.findElement(By.xpath("//td[@valign='top']")).getText();
        txt = driver.findElement(By.xpath("/html/body/center/div/table/tbody/tr[2]/td/div/a")).getText();
        System.out.println("Email i got \n" + txt + "\n\n\n=================================================================================================================================================================");
    }



    public void getEmailBodyYopmail() throws InterruptedException {
        System.out.println("Email i got \n" + "\n\n\n=================================================================================================================================================================");
//        waitUntilElelemntShouldBeDisplay(driver, By.xpath("/html/body/table/tbody/tr[2]//p"), 300);
        waitUntilElelemntShouldBeDisplay(driver, By.xpath("//*[tbody/tr[2]//td/p]"), 300);
/*        setWebDriverFluentWait(1, 40, By.xpath("//*[@id='mailmillieu']//table//tr[2]//p"));
        waitUntilElelemntShouldBeDisplay(driver,By.xpath("//*[@id='mailmillieu']//table//tr[2]//p"),20);*/
        txt = driver.findElement(By.xpath("//*[tbody/tr[2]//td/p]")).getText();
//        txt = driver.findElement(By.xpath("/html/body/table/tbody/tr[2]//p")).getText();
        System.out.println("Email i got \n" + txt + "\n\n\n=================================================================================================================================================================");
    }

    public void pMXLogin(String userName, String password) throws InterruptedException {
        driver.findElement(By.xpath("//input[@name='ctl00$cphContents$txtParanNaam']")).sendKeys(userName);
        log4j("I enter user name: " + userName);
        driver.findElement(By.name("ctl00$cphContents$txtParanShabd")).sendKeys(password);
        log4j("I enter Password: " + password);
        waitElementShouldBeClickable(lp.loginButton);
        lp.loginButton.click();
        log4j("I clicked on login button");
        Thread.sleep(2000L);

    }

    public String getCurrentTime() {

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("hh:mm a");
        LocalDateTime now = LocalDateTime.now();
        String currentTime = dtf.format(now);

        return currentTime;
    }

    public void showAll() throws InterruptedException {
        /*driver.findElement(By.xpath("//*[@name='ContentPlaceHolder1_gvRequestPay_length']")).click();
        Thread.sleep(500L);
        List<WebElement> listShowOptions = driver.findElements(By.xpath("/option"));

        for (WebElement element : listShowOptions) {
            String options = element.getText();

            if (options.equalsIgnoreCase("All")) {
                click(element, driver);
                break;
            }

        }
*/
        Select select = new Select(driver.findElement(By.name("ContentPlaceHolder1_gvRequestPay_length")));
        select.selectByVisibleText("All");


    }

    public void getLinks() {
        List<WebElement> ListOfLinks = driver.findElements(By.xpath("//*[@valign='top']/div/a"));
        for (int j = 0; j < ListOfLinks.size(); j++) {
            linksText = ListOfLinks.get(j).getText();
            String linkToclick = ListOfLinks.get(j).getAttribute("href");
            if (linksText.equals("Login")) {
                System.out.println("User is register contact");
                ListOfLinks.get(j).click();

            } else if (linksText.equals("Register & Pay")) {
                System.out.println("User is not register contact");
                ListOfLinks.get(j).click();
                makePayment();
            } else if (linksText.equals("Quick Pay")) {
                System.out.println("User is not register and request in multi currency");
                ListOfLinks.get(j).click();
            }


        }

    }

    public void getMailAndMakeContactPayment(String Emailid) throws InterruptedException {
        driver.navigate().to("http://yopmail.com/en/");
        driver.findElement(By.xpath("//*[@id='login']")).clear();
        driver.findElement(By.xpath("//*[@id='login']")).sendKeys(Emailid);
        driver.findElement(By.xpath("//input[@class='sbut']")).click();

        Set<String> windows = driver.getWindowHandles();
        int winSize = windows.size();
        System.out.println("Window size is: " + winSize);
        focusOnTab();
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='ifmail']")));
        List<WebElement> ListOfLinks = driver.findElements(By.xpath("//*[@valign='top']/div/a"));
        for (int j = 0; j < ListOfLinks.size(); j++) {
            linksText = ListOfLinks.get(j).getText();
            String linkToclick = ListOfLinks.get(j).getAttribute("href");
            if (linksText.equals("Login")) {

                System.out.println("User is register contact");
                //click(ListOfLinks.get(j), driver);
                driver.navigate().to(linkToclick);
                //util.setWebDriverFluentWait(2, 40, By.xpath("//div[@id='UpnlHome']/div[1] | //*[contains(text(),'Login with')]"));
//                String logintext = lp.verfiyLoginPage.getText();
//                Assert.assertEquals(logintext, "Login with your PayMate Account");
//                System.out.println("////////////////" + driver.getTitle());
//                // driver.getTitle();
//                lp.UserName.sendKeys(Emailid);
//                lp.password.sendKeys("payMate@123");
//                lp.loginButton.click();


            } else if (linksText.equals("Register & Pay")) {
                System.out.println("User is not register contact");
                ListOfLinks.get(j).click();

                //makePayment();
            } else if (linksText.equals("Quick Pay")) {
                System.out.println("User is not register and request in multi currency");
                ListOfLinks.get(j).click();
            }


        }


    }
   /* public void getLinksToRequestPayment() {
        List<WebElement> ListOfLinks = driver.findElements(By.xpath("//*[@valign='top']/div/a"));
        for (int j = 0; j < ListOfLinks.size(); j++) {
            linksText = ListOfLinks.get(j).getText();
            String linkToclick = ListOfLinks.get(j).getAttribute("href");
            if (linksText.equals("Login")) {
                System.out.println("User is register contact");
                ListOfLinks.get(j).click();
                String loginText = driver.findElement(By.xpath("//*[@id='UpnlHome']/div[1]")).getAttribute("innerText");
                if (loginText.equals("Login with your PayMate Account")) {
                    System.out.println("We are on Login page ,Enter user Name and password for Payment");

                }
//&& linksText.equals("Quick Pay")
            } else if (linksText.equals("Register & Pay")) {
                System.out.println("User is not register contact");
                ListOfLinks.get(j).click();
            } else if (linksText.equals("Quick Pay")) {
                System.out.println("User is not register and request in multi currency");
                ListOfLinks.get(j).click();
            }


        }

    }*/

    public void makePayment() {
        focusOnTab();
        List<WebElement> listofType = driver.findElements(By.xpath("//*[@type='submit']"));
        for (int i = 0; i < listofType.size(); i++) {
            String perfromPayment = listofType.get(i).getAttribute("value");
            switch (perfromPayment) {
                case "Get me started":
                    driver.findElement(By.xpath("//input[@id='btnGetStarted']")).click();
                    String email_disabled = driver.findElement(By.xpath("//input[@id='txtEmail']")).getAttribute("disabled");
                    if (email_disabled.equals("disabled")) {
                        System.out.println("Email field is not Editable");
                    }
                    String mobile_disabled = driver.findElement(By.cssSelector("#txtMobile")).getAttribute("disabled");
                    if (email_disabled.equals("disabled")) {
                        System.out.println("Email field is not Editable");
                    }

                    boolean firestName_isEnabled = driver.findElement(By.cssSelector("#txtFirstName")).isEnabled();
                    Assert.assertTrue(firestName_isEnabled, "First name field is not enabled");
                    boolean lastName_isEnabled = driver.findElement(By.cssSelector("#txtLastName")).isEnabled();
                    Assert.assertTrue(lastName_isEnabled, "Last name field is not enabled");
                    WebElement enterPassword = driver.findElement(By.cssSelector("#txtParanShabd"));
                    boolean isEnabled = enterPassword.isEnabled();
                    boolean isDisplayed = enterPassword.isDisplayed();
                    Assert.assertTrue(isDisplayed, "Enter password field is not displayed");
                    Assert.assertTrue(isEnabled, "Enter Password field is not Enabled");
                    enterPassword.sendKeys("Paymate@123");

                    WebElement confirmPassword = driver.findElement(By.cssSelector("#txtConfirmParanShabd"));
                    boolean confirmPassword_isEnabled = confirmPassword.isEnabled();
                    boolean confirmPassword_isDisplayed = confirmPassword.isDisplayed();
                    Assert.assertTrue(confirmPassword_isDisplayed, "Enter password field is not displayed");
                    Assert.assertTrue(confirmPassword_isEnabled, "Enter Password field is not Enabled");
                    confirmPassword.sendKeys("Paymate@123");
                    break;
                case "Login":
                    break;
                case "adklws":
                    break;
            }
        }
    }

    public void PMXLogOut() {
        click(driver.findElement(By.xpath("//*[@id='navbarDropdown']")), driver);
        log4j("I click on Profile Icon ");
        setWebDriverFluentWait(1, 20, By.xpath("//*[@class='menu-info logout']"));
//        click(driver.findElement(By.xpath("//*[@id='navbarSupportedContent']//li[1]/a")), driver);
        click(driver.findElement(By.xpath("//*[@class='menu-info logout']")), driver);
        log4j("I clicked On LogOut Link");
    }

    public void writeFile(String filePath, String fileName) throws IOException {


        File file = new File(filePath + "\\" + fileName);
        FileInputStream inputStream = new FileInputStream(file);
        HSSFWorkbook workbook = null;
        String fileExtensionName = fileName.substring(fileName.indexOf("."));
        System.out.println("File Extension is: " + fileExtensionName);
        try {
            workbook = new HSSFWorkbook(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        sheet = workbook.getSheet("Sheet1");
        row = sheet.getRow(0);
        System.out.println("row.getLastCellNum(): " + row.getLastCellNum());

        inputStream.close();
        FileOutputStream outputStream = new FileOutputStream(file);
        workbook.write(outputStream);
    }

    public void handelCalenderDynamically(int date1, int date2) throws InterruptedException {
        driver.findElement(By.xpath("//div[@class='toggle-card']")).click();
        Thread.sleep(2000L);
        driver.findElement(By.xpath("//input[@id='ContentPlaceHolder1_txtDateRange']")).click();
        Thread.sleep(2000L);
        List<WebElement> rightCalender = driver.findElements(By.xpath("//*[@class='calendar right']/div[2]/table/tbody/tr/td"));

        DateFormat df = new SimpleDateFormat("dd");
        Date todaysDate = new Date();
        System.out.println(df.format(todaysDate));

        for (int i = 0; i < rightCalender.size(); i++) {
            String dates = rightCalender.get(i).getText();
            System.out.println("Date are: " + dates);

            if (dates.equals(date1)) {
                rightCalender.get(i).click();
                break;
            } else {
                System.out.println("Right Date is not matched");
            }
        }

        Thread.sleep(3000);
        List<WebElement> leftCalender = driver.findElements(By.xpath("//*[@class='calendar left']/div[2]/table/tbody/tr/td"));
        for (int j = 0; j < leftCalender.size(); j++) {
            String leftDates = leftCalender.get(j).getText();
            System.out.println("Left dates are: " + leftDates);
            if (leftDates.equals(date2)) {
                leftCalender.get(j).click();
                break;
            } else {
                System.out.println("left Date is not matched");
            }
        }


    }

    public void splitString(String enterStr) {
        String[] str = enterStr.split("to");
        for (int i = 0; i < str.length; i++) {
            System.out.println("Split String is:++++++++++++++++++++++++++++--------------- " + str[i]);
        }
    }

    public void typeText(WebElement ele, String values, WebDriver driver) {
        jse.executeScript("arguments[0].value='values';", ele);
    }

    public void handelMonth(String mont_year) {
        List<WebElement> month_Element = driver.findElements(By.xpath("//*[@class='month']"));
        for (int k = 0; k < month_Element.size(); k++) {
            System.out.println("Month data is: " + month_Element.get(k).getText());
            String month = month_Element.get(k).getText();

            if (month != mont_year) {
                driver.findElement(By.xpath("//*[@class='prev available']")).click();


            }
        }
    }

    public void CloseCurrentTabAndSwitch() {
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());

        System.out.println("Tabs are: " + tabs.size());

        driver.switchTo().window(tabs.get(0));

        focusOnTab();
    }

    public void filter(String enterFilterType) {
        click(driver.findElement(By.xpath("//div[@class='toggle-card']")), driver);

        switch (enterFilterType) {
            case "All Companies":
                click(driver.findElement(By.xpath("//*[@id='PnlMain']/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div/label[1]/i")), driver);
                listCompanyName = driver.findElements(By.xpath("//div[@class='mdl-menu__container is-upgraded is-visible']//li"));
                break;

            case "Date":
                click(driver.findElement(By.id("ContentPlaceHolder1_txtDateRange")), driver);
                getCurrentDataTime();
                click(driver.findElement(By.xpath("//*[@id='bodytag']/div[5]/div[3]/div/button[1]")), driver);
                click(driver.findElement(By.cssSelector("#ContentPlaceHolder1_btnFilter")), driver);

        }
    }

    public String getFileExtension(File imageURL) {
        String name = imageURL.getName();
        int lastIndexOf = name.lastIndexOf(".");
        if (lastIndexOf == -1) {
            return ""; // empty extension
        }
        return name.substring(lastIndexOf);
    }

    public String getHiddenText(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String text = (String) js.executeScript("return arguments[0].value;", element);
        //System.out.println("Hidden text: " + text);
        return text;
    }

    public void mouseMove(WebElement element) {
        Actions action = new Actions(driver);
        action.moveToElement(element).build().perform();
    }

    public void clickDashboardMenu() {
        click(driver.findElement(By.className("sidebar-toggle")),driver);
    }

    public void readPropertiesFile(String fileUrl) throws IOException {
        obj = new Properties();
        ojFile = new FileInputStream(fileUrl);
        obj.load(ojFile);
    }

    public void filter() throws InterruptedException {
        click(driver.findElement(By.xpath("//div[@class='toggle-card']")), driver);
        //driver.findElement(By.xpath("//div[@class='toggle-card']")).click();
        Thread.sleep(2000L);
        //utils.click(driver.findElement(By.cssSelector("#txtDateRange")), driver);
        //waitUntilElelemntShouldBeDisplay(driver, By.cssSelector("#txtDateRange"), 30);

        driver.findElement(By.cssSelector("#txtDateRange")).click();
        //utils.click(driver.findElement(By.xpath("//*[@id='bodytag']/div[5]/div[3]/div/button[1]")), driver);
        Thread.sleep(2000L);
        //waitUntilElelemntShouldBeDisplay(driver, By.xpath("//*[@class='applyBtn btn btn-sm btn-success']"), 30);
        driver.findElement(By.xpath("//*[@class='applyBtn btn btn-sm btn-success']")).click();
        // waitUntilElelemntShouldBeDisplay(driver, By.cssSelector("#btnFilter"), 30);
        Thread.sleep(2000L);
        driver.findElement(By.cssSelector("#btnFilter")).click();
        //utils.click(driver.findElement(By.cssSelector("#btnFilter")), driver);
        Thread.sleep(3000L);

    }
}

