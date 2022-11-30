package pageFactory;

import baseClass.mainDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import step_definitions.Hooks;

import java.util.List;

public class uploadKyc_POM
{
    //DashBoard upload kyc link
    @FindBy(xpath = "//a[contains(text(),'Upload your KYC ')]")
    public WebElement getUploadKycLink;

    //Business type on uploaded documents page
    @FindBy(xpath = "//input[@id='ddlBusinessType_select']")
    public WebElement getBusinessType;

    //Upload Kyc title
    @FindBy(xpath = "//h1[contains(text(),'Uploaded Documents')]")
    public WebElement getkycTitle;

    //Click on business setting
    @FindBy(xpath = "//a[contains(text(),'Business Settings')]")
    public WebElement getbusinessSettings;

    //kyc link from business settings
    @FindBy(linkText = "Uploaded Documents")
    public WebElement getuploadKyc;
    //click business type down values
    @FindBy(xpath = "//i[@class='mdl-icon-toggle__label material-icons']")
    public WebElement getDropDownClick;
    //business type values
    @FindBy(xpath = "//ul[@name='ctl00$ContentPlaceHolder1$ddlBusinessType']/li")
    public List<WebElement> getBusinessDropDownValues;
    //Individuals business fileds
    //compnay details text
    @FindBy(xpath ="//*[@class='card']/div/div" )
    public  WebElement getCompanyDetailsText;

    //Name on pan text box
    @FindBy(xpath = "//input[@id='ContentPlaceHolder1_txtPanName']")
    public WebElement getNameOnPan;

    @FindBy(xpath = "//*[@id='ContentPlaceHolder1_lblPANCardName']")
    public WebElement panName;

    @FindBy(id = "ContentPlaceHolder1_lblPANNo")
    public WebElement panNumber;

    @FindBy(id = "ContentPlaceHolder1_imgPAN")
    public WebElement panImg;

    @FindBy(id = "ContentPlaceHolder1_imgBD")
    public WebElement businessDetailsImg;

    @FindBy(id = "ContentPlaceHolder1_lblAddress")
    public WebElement addressField;

    @FindBy(id = "ContentPlaceHolder1_lblCity")
    public WebElement cityField;

    @FindBy(id = "ContentPlaceHolder1_lblState")
    public WebElement stateField;

    @FindBy(id = "ContentPlaceHolder1_lblPinCode")
    public WebElement pincodeField;

    @FindBy(id = "ContentPlaceHolder1_imgAddress")
    public WebElement addressDocImg;

    //Name on pan label
    @FindBy(xpath = "//label[contains(text(),'Name on PAN')]")
    public WebElement getNameOnPanLabel;

    //Enter pan  number text box
    @FindBy(xpath = "//input[@id='ContentPlaceHolder1_txtPanNumber']")
    public WebElement getEnterPanNumber;

    //Name on pan number text box label
    @FindBy(xpath = "//label[contains(text(),'Enter PAN Number')]")
    public WebElement getEnterPanNumberLabel;

    //Upload Pan card image text box

    @FindBy(xpath = "//input[@id='ContentPlaceHolder1_fuPanCard']")
    public WebElement getUploadPanCardImage;
    //upload pan card image label
    @FindBy(xpath = "//label[@id='lblUploadPAN']")
    public WebElement getUploadPanCardImageLabel;
    //image type guidance text
    @FindBy(xpath = "//span[contains(text(),'Upload a PDF, JPG, JPEG, GIF, PNG of PAN Card for upto 2MB size')]")
    public WebElement getImageTypeGuidanceText;
    //upload business documnet dropdown
    @FindBy(xpath = "//select[@id='ddlUploadBusiness']")
    public WebElement getBusinessDocumnetDropDown;
    //Business document droDown values

    @FindBy(xpath = "//ul[@id='ddlUploadBusiness_select']/li")
    public List<WebElement> getBusinnessDocumentDropDownValues;

    @FindBy(xpath = "//ul[@id = 'ddlUploadBusiness_select']/li[2]")
    public WebElement getBusinnessDocumentDropDownValue;

    @FindBy(id = "ddlUploadBusiness_select")
    public WebElement selectBusinessDoc;

    @FindBy(xpath = "//*[@id='ContentPlaceHolder1_Individuals']/div/label[1]/i")
    public WebElement businessDocDownArrow;

    @FindBy(xpath = "//*[@id='ContentPlaceHolder1_dvAddressEdit']//div[3]/div/label[1]/i")
    public WebElement stateDownArrow;

    @FindBy(xpath = "//*[@id='ContentPlaceHolder1_dvAddressEdit']//div[5]/div/label[1]/i")
    public WebElement addrDocDownArrow;

    @FindBy(xpath = "//ul[@id = 'ddlState_select']/li[2]")
    public WebElement selectState;

    @FindBy(xpath = "//ul[@id = 'ddlUploadAddress_select']/li[2]")
    public WebElement selectAddrDoc;

//Business documnet dropdown label
    @FindBy(xpath = "//*[@id='ContentPlaceHolder1_Individuals']/div/label")
    public WebElement getBusinessDocumnetDropDownLabel;

    //Business Proof Details Title
    @FindBy(xpath = "//div[contains(text(),'Business Proof details')]")
    public WebElement getBusinessProffDetailsTitle;

    //Upload business document
    @FindBy(xpath = "//*[@id='ContentPlaceHolder1_fupUploadDoc']")
    public WebElement getUploadBusinessDocumentField;

    //Upload business document label
    @FindBy(xpath = "//label[@id='lblUploadBD']")
    public WebElement getUploadBusinessDocumentLabel;

    //Address Deatls page
//Address details page title
    @FindBy(xpath = "//div[contains(text(),'Address details')]")
    public WebElement getAddressDetailsTitle;

    //Address text box
    @FindBy(xpath = "//input[@id='ContentPlaceHolder1_txtAddress']")
    public  WebElement getAddressField;

    //Address label
    @FindBy(xpath = "//div[@class='mdl-textfield mdl-js-textfield mdl-textfield--floating-label is-upgraded']//label[@class='mdl-textfield__label'][contains(text(),'Address')]")
    public WebElement getAddressLabel;

    //City text box
    @FindBy(xpath = "//input[@id='ContentPlaceHolder1_txtCity']")
    public WebElement  getCityTextBox;

    //City text box label
    @FindBy(xpath = "//label[contains(text(),'City')]")
    public WebElement getCityLabel;

    @FindBy(xpath = "//label[contains(text(),'State')]")
    public WebElement getStateLabel;

    //state dropDown
    @FindBy(xpath = "//input[@id='ddlState_select']")
    public WebElement getDropDown;

    //state drop down values
    @FindBy(xpath = "//ul[@id='ddlState_select']/li")
    public List<WebElement> getStateDropDownValues;

    //pin code
    @FindBy(xpath = "//input[@id='ContentPlaceHolder1_txtPinCode']")
    public WebElement getPinCodeField;

    //pin cdoe label
    @FindBy(xpath = "//label[contains(text(),'Pin Code')]")
    public WebElement getPinCodeLabel;

    //Upload address document label
    @FindBy(xpath = "//label[contains(text(),'Upload Address Document')]")
    public WebElement getUploadAddressDocumentLabel;

    //upload address document droDown
    @FindBy(id = "ContentPlaceHolder1_fuAddressDoc")
    public WebElement getUploadAddressDocument;

    //upload address document dropdown values
    @FindBy(xpath = "//ul[@id='ddlUploadAddress_select']/li")
    public List<WebElement> getUploadAddressDropDownValues;

    //upload document text box
    @FindBy(xpath = "//input[@id='ContentPlaceHolder1_fuAddressDoc']")
    public WebElement getUploadDocumnetTextBox;

    //upload document label
    @FindBy(xpath = "//label[@id='lblUploadAD']")
    public WebElement getUploadDocumnetLabel;

    //upload Button
    @FindBy(css = "#ContentPlaceHolder1_btnSubmit")
    public  WebElement getUploadButton;

    @FindBy(xpath = "//*[text()='The KYC verification process may take up to 2 working days.']")
    public  WebElement uploadValMsg;

    //upload Button Field
    @FindBy(xpath = "//*[@id='ContentPlaceHolder1_cvValidateAddressFile']")
    public  WebElement getUploadButtonField;

    //Companies
    //Business Name Field Label
    @FindBy(xpath = "//label[contains(text(),'Business Name')]")
    public WebElement getBusinessNameLabel;

    //Business Name Field
    @FindBy(xpath = "//*[@id='ContentPlaceHolder1_CIN']/div[1]/div")
    public WebElement getBusinessName;

    @FindBy(xpath = "//*[@id='ContentPlaceHolder1_LLP']/div[1]/div")
    public WebElement getBusinessNameLLP;


    //Company identification number
    @FindBy(xpath = "//input[@id='ContentPlaceHolder1_txtCIN']")
    public WebElement getCompanyIdentificationNumber;

    //company identification number label
    @FindBy(xpath = "//label[contains(text(),'Company Identification Number')]")
    public WebElement getCompanyIdentificationNumberLabel;

    //LLP identification  number
    @FindBy(xpath = "//input[@name='ctl00$ContentPlaceHolder1$txtLLP']")
    public WebElement getLlpIdentificationNumber;

    //Llp identification number label
    @FindBy(xpath = "//label[contains(text(),'LLP Identification Number')]")
    public WebElement getGetLlpIdentificationNumberLabel;



    //error message
    @FindBy(xpath = "//label[@class='mdl-textfield__label']")
    public List<WebElement> getErrorMsg;
    public uploadKyc_POM(WebDriver driver) {
        driver = Hooks.driver;
        PageFactory.initElements(driver, this);
    }
}
