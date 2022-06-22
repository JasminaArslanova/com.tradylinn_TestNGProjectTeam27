package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class TradylinnPage {
public TradylinnPage(){PageFactory.initElements(Driver.getDriver(),this);}

    //11-30 JASMINA
    @FindBy(linkText="Hesabım") public WebElement hesabimlinktext;
    @FindBy(xpath = "//input[@id='username']") public WebElement usernameBox;
    @FindBy(xpath = "//input[@id='password']") public WebElement passBox;
    @FindBy(xpath = "//button[@name='login']") public WebElement signInLoginButton;
    @FindBy(linkText = "Store Manager") public WebElement storeManagerButton;
    @FindBy(xpath = "(//span[@class='text'])[4]") public WebElement products;
    @FindBy(xpath = "//span[text()='Yeni ekle']") public WebElement addNewProduct;












    //31-60 AKIF





























    //61-90 EVREN





























    //91-115 AYHAN
























    //116-140 ALI























    //140-164 MELEK
























    //165-189 MUSTAFA
























    //190-214 RAMAZAN
























    //215-239 RAMAZAN
























    //240-   SEHER




}
