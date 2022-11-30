package baseClass;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

public class Environments extends mainDriver {

    public String env;

    public Environments() {
        java.util.logging.Logger.getLogger("com.gargoylesoftware").setLevel(Level.OFF);
        System.setProperty("org.apache.commons.logging.Log", "org.apache.commons.logging.impl.NoOpLog");

        env = System.getProperty("env");
        if (env == null) {
            env = "qa";
        }

        System.out.println("The test is running on " + env.toUpperCase() + " environment");
        switch (env.toLowerCase()) {

            case "uat":
                driver.navigate().to("https://uat.paymate.co.in/paymatesite/Login.aspx");
                break;

            case "qa":
      /*          driver.navigate().to("https://dev.paymate.in/Beta/PMX3.0/Login.aspx");
                driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);*/
        /*        driver.navigate().to("https://dev.paymate.in/Beta/HDFC/Login.aspx");
                driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);*/
            /*    driver.navigate().to("https://dev.paymate.in/Beta/PMXUAE/");
                driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);*/
//                driver.navigate().to("https://dev.paymate.in/Beta/PayMateAdmin/Login.aspx");
//                driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
//                driver.navigate().to("https://dev.paymate.in/Beta/hdfcadmin/Login.aspx");
                break;

            case "prod":
                driver.navigate().to("https://paymate.in/Login.aspx");
                break;
        }
    }
}
