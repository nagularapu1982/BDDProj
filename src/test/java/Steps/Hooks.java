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
        System.out.println("Browser opem");
        System.setProperty("webdriver.chrome.driver","src/test/resources/Drivers/chromedriver-32.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://www.shop.demoqa.com");

    }

    @After

    public void AfterSteps() throws InterruptedException {

        Thread.sleep(4000);
        driver.quit();
//        driver.close();
        System.out.println("after scenario");


    }
}

