package baseClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pageFactory.reports_POM;

import java.util.ArrayList;
import java.util.List;




public class BusinessReports extends mainDriver {
    public reports_POM reports_pom = new reports_POM(driver);
    private String name; // private = restricted access
    public ArrayList<String> dataList = new ArrayList<>();
    public ArrayList<String> dataList2 = new ArrayList<>();
    public ArrayList<String> dataList3 = new ArrayList<>();
    public ArrayList<String> dataList4 = new ArrayList<>();
    public ArrayList<String> dataList5 = new ArrayList<>();
    public String data;
    public Boolean field;

    public void getReports(String name, List<WebElement> elements, List<WebElement> heading) {

        for (int i = 0; i < elements.size(); i++) {
            if (name.equals("Company Name") && heading.get(0).getText().equals(name) || name.equals("Company Name") && heading.get(5).getText().equals(name)) {
                if(heading.get(0).getText().equals(name)){
                    data = elements.get(0).getText();
                    return;
                } else {
                    data = elements.get(5).getText();
                    return;
                }

            } else if (name.equals("Reference Code") && heading.get(1).getText().equals(name)) {
                data = elements.get(1).getText();
                return;

            } else if (name.equals("Transaction ID") && heading.get(2).getText().equals(name)) {
                data = elements.get(2).getText();
                field = data.isEmpty();
                return;

            } else if (name.equals("Received Date") && heading.get(3).getText().equals(name)) {
                data = elements.get(3).getText();
                field = data.isEmpty();
                Assert.assertFalse(field, "Field is empty");

            } else if (name.equals("Payment From") && heading.get(4).getText().equals(name)) {
                data = elements.get(4).getText();
                field = data.isEmpty();
                Assert.assertFalse(field, "Field is empty");


            } else if (name.equals("Payment Through") && heading.get(5).getText().equals(name)) {
                data = elements.get(5).getText();
                Assert.assertFalse(field, "Field is empty");

            } else if (name.equals("Payable Amount") && heading.get(6).getText().equals(name)) {
                data = elements.get(6).getText();

            } else if (name.equals("Client Charges")) {
                data = elements.get(7).getText();
                field = data.isEmpty();
                Assert.assertFalse(field, "Field is empty");


            } else if (name.equals("Client Charges GST")) {
                data = elements.get(8).getText();
                field = data.isEmpty();
                Assert.assertFalse(field, "Field is empty");

            } else if (name.equals("Charged Amount")) {
                data = elements.get(9).getText();
                field = data.isEmpty();
                Assert.assertFalse(field, "Field is empty");

            } else if (name.equals("Currency") || name.equals("Currency") && heading.get(6).getText().equals(name) || name.equals("Currency") && heading.get(8).getText().equals(name)) {
                if (heading.get(6).getText().equals(name)) {
                    data = elements.get(6).getText();

                } else if(heading.get(6).getText().equals(name)){
                    data = elements.get(10).getText();

                } else {
                    data = elements.get(8).getText();
                }

            } else if (name.equals("Business Name") && heading.get(0).getText().equals(name) || name.equals("Business Name") && heading.get(1).getText().equals(name)) {
                if(heading.get(0).getText().equals(name)) {
                    data = elements.get(0).getText();
                    field = data.isEmpty();
                    return;
                } else {
                    data = elements.get(1).getText();
                    field = data.isEmpty();
                }
            } else if (name.equals("Transaction ID") && heading.get(1).getText().equals(name) || name.equals("Transaction ID") && heading.get(2).getText().equals(name)) {
                if(heading.get(1).getText().equals(name)){
                    data = elements.get(1).getText();
                    field = data.isEmpty();
                    return;
                }else {
                    data = elements.get(2).getText();
                    field = data.isEmpty();
                }

            } else if (name.equals("Date") && heading.get(2).getText().equals(name)) {
                data = elements.get(2).getText();
                field = data.isEmpty();
                return;

            } else if (name.equals("Invoice No") && heading.get(3).getText().equals(name)) {
                data = elements.get(3).getText();

            } else if (name.equals("Type of Payment") && heading.get(4).getText().equals(name) || name.equals("Type of Payment") && heading.get(6).getText().equals(name)) {
                if(heading.get(4).getText().equals(name)) {
                    data = elements.get(4).getText();
                    field = data.isEmpty();
                    return;

                } else {
                    data = elements.get(4).getText();
                    field = data.isEmpty();
                    return;
                }
            } else if (name.equals("Paid Amount") && heading.get(5).getText().equals(name)) {
                data = elements.get(5).getText();

            } else if (name.equals("Bank Reference No") && heading.get(7).getText().equals(name)) {
                data = elements.get(7).getText();
                field = data.isEmpty();
                return;

            } else if (name.equals("Status") && heading.get(8).getText().equals(name) || name.equals("Status") && heading.get(9).getText().equals(name)) {
               if(heading.get(8).getText().equals(name)){
                   data = elements.get(8).getText();
                   return;
               }
               else {
                   data = elements.get(9).getText();
                   return;
               }

            }else if (name.equals("Actions") && heading.get(9).getText().equals(name) || name.equals("Actions") && heading.get(11).getText().equals(name)) {
                if(heading.get(9).getText().equals(name)){
                    field = elements.get(9).isDisplayed();
                    return;
                } else {
                    field = elements.get(11).isDisplayed();
                    return;
                }


            }else if (name.equals("Reference Code") && heading.get(1).getText().equals(name)) {
                data = elements.get(7).getText();
                field = data.isEmpty();
                return;

            } else if (name.equals("Transaction Date") && heading.get(3).getText().equals(name)) {
                data = elements.get(3).getText();
                field = data.isEmpty();
                return;

            } else if (name.equals("Payment From") && heading.get(4).getText().equals(name)) {
                data = elements.get(4).getText();
                field = data.isEmpty();
                return;

            } else if (name.equals("Received Amount") && heading.get(5).getText().equals(name)) {
                data = elements.get(5).getText();
                return;

            } else if (name.equals("Invoice Number") && heading.get(7).getText().equals(name)) {
                data = elements.get(7).getText();
                return;

            } else if (name.equals("Settlement Amount") && heading.get(8).getText().equals(name)) {
                data = elements.get(8).getText();
                field = data.isEmpty();
                return;

            } else if (name.equals("Bank Reference No") && heading.get(9).getText().equals(name)) {
                data = elements.get(9).getText();
                field = data.isEmpty();
                return;

            } else if (name.equals("Settlement Status") && heading.get(10).getText().equals(name)) {
                data = elements.get(10).getText();
                return;

            }  else if (name.equals("Trx. ID") && heading.get(2).getText().equals(name)) {
                data = elements.get(2).getText();
                field = data.isEmpty();
                return;

            } else if (name.equals("Trx. Date") && heading.get(3).getText().equals(name)) {
                data = elements.get(3).getText();
                field = data.isEmpty();
                return;

            }else if (name.equals("Trx. Time") && heading.get(4).getText().equals(name)) {
                data = elements.get(4).getText();
                field = data.isEmpty();
                return;

            } else if (name.equals("Amount") && heading.get(7).getText().equals(name)) {
                data = elements.get(7).getText();
                field = data.isEmpty();
                return;

            }
        }
    }
}
