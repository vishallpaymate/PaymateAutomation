package step_definitions;

import baseClass.mainDriver;
import pageFactory.requestPayment_POM;

import java.util.BitSet;
import java.util.List;

public class requestPaymentDataToCompare {
    /* public String baseAmount; //req.getBaseAmountFromAcceptRequestFrom.getAttribute("innerText");
     //System.out.println("Base Amount: " + baseAmount);

     public String getBaseAmount() {

         return this.baseAmount;
     }

     public void setBaseAmount(String amount) {
         this.baseAmount = amount;
     }*/
    public List<String> listTitles;
    //public BitSet getCollectionPageData;

    public void setListTitles(List<String> titles) {
        this.listTitles = titles;
    }

    public List<String> getListTitles() {
        return this.listTitles;
    }


}
