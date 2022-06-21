package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class TradylinnPage {
public TradylinnPage(){PageFactory.initElements(Driver.getDriver(),this);}

    //Jasmina
    @FindBy(linkText="Hesabım") public WebElement hesabimlinktext;
    @FindBy(xpath = "//input[@id='username']") public WebElement usernameBox;
    @FindBy(xpath = "//input[@id='password']") public WebElement passBox;
    @FindBy(xpath = "//button[@name='login']") public WebElement signInLoginButton;
    @FindBy(linkText = "Store Manager") public WebElement storeManagerButton;
    @FindBy(xpath = "(//span[@class='text'])[4]") public WebElement products;
    @FindBy(xpath = "//span[text()='Yeni ekle']") public WebElement addNewProduct;
}
