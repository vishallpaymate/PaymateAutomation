package baseClass;

import org.openqa.selenium.WebDriver;
import step_definitions.Hooks;

public class mainDriver
{
    public WebDriver driver = Hooks.driver;

    public void iAmOnLoginpage()
    {
        Environments e=new Environments();
    }

}
