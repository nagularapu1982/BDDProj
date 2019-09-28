package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class MotorsSearchPage {
    WebDriver driver;
    public MotorsSearchPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//input[@name='PostCode']") public WebElement text_PostCode;
    @FindBy(id = "Make") public WebElement dd__Company;
    @FindBy(xpath = "//header/div[@class='splash__title']") public WebElement ele_Heading;
    @FindBy(xpath = "//*[text()='Search']") public WebElement btn_Search;
    @FindBy(xpath = "//a[@class='item btn']") public List<WebElement> vechile_Results;
    @FindBy(xpath = "//section[@class='sp2 collapse']//button[contains(text(),'Make')]") public WebElement btn_Model;
    @FindBy(xpath = "//span[@class='pgn__text']/span") public WebElement ele_PageCount;
    @FindBy(xpath = "//section[@class='mm']/ul/li/button/p[text()='model']") public WebElement btn_ModelSelection;
    @FindBy(xpath = "//*[@id=\"Makes_Ford\"]/ul/li/button/span") public List<WebElement> list_Models;
    @FindBy(xpath = "//div[@class='vdp-header__vehicle']/h1") public WebElement vehicle_Title;
    @FindBy(xpath = "//div[@class='vdp-header__vehicle']/p") public WebElement vehicle_Varient;
    @FindBy(xpath = "//button[@class='gallery-cta gallery-cta--loc']/span") public WebElement miles_Away;
    @FindBy(xpath = "//footer/button[text()='update']") public WebElement footer_Update;

}
