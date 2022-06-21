package tests;

import org.testng.annotations.Test;
import pages.TradylinnPage;
import utilities.ConfigReader;
import utilities.Driver;

public class US007 {
    TradylinnPage tradylinPage=new TradylinnPage();

    @Test
    public void test01() {
        Driver.getDriver().get(ConfigReader.getProperty("tradylinnUrl"));

        tradylinPage.hesabimlinktext.click();
        tradylinPage.usernameBox.sendKeys(ConfigReader.getProperty("usermail"));
        tradylinPage.passBox.sendKeys(ConfigReader.getProperty("userpass"));
        tradylinPage.signInLoginButton.click();

        tradylinPage.storeManagerButton.click();
        tradylinPage.products.click();
        tradylinPage.addNewProduct.click();
    }

    @Test
    public void test02() {

    }
}
