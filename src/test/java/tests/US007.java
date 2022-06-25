package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TradylinnPage;
import utilities.ConfigReader;
import utilities.Driver;

import static utilities.ReusableMethods.waitFor;

public class US007 {
    TradylinnPage tradylinPage=new TradylinnPage();


    public void signInMethod() {
        Driver.getDriver().get(ConfigReader.getProperty("tradylinnUrl"));

        tradylinPage.hesabimlinktext.click();
        tradylinPage.usernameBox.sendKeys(ConfigReader.getProperty("usermail"));
        tradylinPage.passBox.sendKeys(ConfigReader.getProperty("userpass"));
        tradylinPage.signInLoginButton.click();
        //waitFor(10);
        tradylinPage.storeManagerButton.click();
        tradylinPage.products.click();
        tradylinPage.addNewProduct.click();
    }

    @Test
    public void TC001() {
        signInMethod();
        Assert.assertTrue(tradylinPage.productBrandsHead.isDisplayed());
        Assert.assertTrue(tradylinPage.productBrandsHead.getText().contains("Product brands"));


    }
}
