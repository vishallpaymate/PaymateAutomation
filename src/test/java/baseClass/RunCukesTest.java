package baseClass;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;
import org.apache.commons.io.FileUtils;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import step_definitions.Hooks;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


@RunWith(Cucumber.class)
@CucumberOptions(

        features = {"src/test/resources/features"},
        glue = {"step_definitions"},
        tags = "~@ignore"
)
public class RunCukesTest
{
    @AfterClass
    public static void runReport() {
        Collection<File> jsonFiles = FileUtils.listFiles
                (new File("target/surefire-reports"), new String[]{"json"}, true);
        List<String> jsonPaths = new ArrayList(jsonFiles.size());
        jsonFiles.forEach(file -> jsonPaths.add(file.getAbsolutePath()));
        Configuration config = new Configuration(new File("target"), "PayMate India Pvt Ltd");
        config.setParallelTesting(false);
        ReportBuilder reportBuilder = new ReportBuilder(jsonPaths, config);
        reportBuilder.generateReports();

    }

}

