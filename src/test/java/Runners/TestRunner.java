package Runners;
import com.cucumber.listener.ExtentProperties;
import com.cucumber.listener.Reporter;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

@RunWith(Cucumber.class)
@CucumberOptions(

        features = "src/test/resources/Features",
        glue= {"Steps"},
       plugin = { "com.cucumber.listener.ExtentCucumberFormatter:"},
//        plugin = {"com.vimalselvam.cucumber.listener.ExtentCucumberFormatter:"},
//        @CucumberOptions( plugin = { "com.vimalselvam.cucumber.listener.ExtentCucumberFormatter:path/report.html"} )
        monochrome = true

)

public class TestRunner {
    static String ReportName="NNR";
    static String logFileName = new SimpleDateFormat("yyyyMMddHHmm'.txt'").format(new Date());
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
