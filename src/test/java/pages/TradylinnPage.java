package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class TradylinnPage {
public TradylinnPage(){PageFactory.initElements(Driver.getDriver(),this);}

    //Jasmina
    @FindBy(linkText="Hesabım")
    public WebElement hesabimlinktext;
}
