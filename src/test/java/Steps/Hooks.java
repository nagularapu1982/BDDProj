package Steps;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Hooks {

    static WebDriver driver;
    @Before
    public void BeforeSteps() {
        System.out.println("Launching  the application");
        System.setProperty("webdriver.chrome.driver","src/test/resources/Drivers/chromedriver-32.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.motors.co.uk");

    }

    @After
    public void AfterSteps() throws InterruptedException {
        Thread.sleep(4000);
        driver.quit();


    }
}

