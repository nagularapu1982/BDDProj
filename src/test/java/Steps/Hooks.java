package Steps;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Hooks {

    WebDriver driver;
    @Before
    public void BeforeSteps() {
        System.out.println("Beofre the scenario");
    }

    @After
    public void AfterSteps() {
//        driver.quit();
//        driver.close();
        System.out.println("after scenario");


    }
}

