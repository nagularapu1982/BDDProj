package Runners;
import com.cucumber.listener.ExtentProperties;
import com.cucumber.listener.Reporter;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import java.text.SimpleDateFormat;
import java.util.Date;

@RunWith(Cucumber.class)
@CucumberOptions(

        features = "src/test/resources/Features",
        tags = {"@FunctionaFlow"},
        glue= {"Steps"},
       plugin = { "com.cucumber.listener.ExtentCucumberFormatter:"},
       monochrome = true

)

public class TestRunner {
    static String ReportName="NNR";
    static String logFileName = new SimpleDateFormat("yyyyMMddHHmm").format(new Date());
    @BeforeClass
    public static void setup() {
        ExtentProperties extentProperties = ExtentProperties.INSTANCE;
        extentProperties.setReportPath("target/cucumber-reports/Results"+logFileName+".html"); //used same string name to create the file with the same name.
    }
    @AfterClass
    public static void writeExtentReport() {
        Reporter.loadXMLConfig("src/test/resources//extent-config.xml");
    }
}
