package tests;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.TradylinnPage;
import utilities.ConfigReader;
import utilities.Driver;

public class US001 {

    TradylinnPage tradylinnPage = new TradylinnPage();
    Actions actions = new Actions(Driver.getDriver());
    JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();



    public void vendorUyeOlSayfasinaGit() {
        /*
         1_https://tradiylinn.com/ adresine gider
         2_üye ol'a tıklar
         3_register pop-up'ında oldugunu dogrular
         "4_sign up as a vendor' link textinin erişilebilir
         oldugunu kontrol eder"
     */
        Driver.getDriver().get(ConfigReader.getProperty("tradylinnUrl"));
        tradylinnPage.uyeOlHeaderButton.click();
        Assert.assertTrue(tradylinnPage.kayitOlPopUpButton.isDisplayed());
        Assert.assertTrue(tradylinnPage.registerAsVendorLinkText.isEnabled());

        //      "5_sign up as a vendor'a tıklar ve regist. sayfasına gider
        tradylinnPage.registerAsVendorLinkText.click();
        //      Registration sayfasında oldugunu dogrular"
        Assert.assertTrue(tradylinnPage.vendorRegisterBaslik.isDisplayed());
    }

    @Test
    public void testCase001() {
        vendorUyeOlSayfasinaGit();
        //      "6_Registration sayfasında email yazdigini ve
        //      email textboxun erişilebilir oldugunu kontrol eder"
        //      "7_Registration sayfasında password yazdigini ve
        //      textboxun erişilebilir oldugunu kontrol eder"
        //      "8_Registration sayfasında confirm password yazdigini
        //      textboxun erişilebilir oldugunu kontrol eder"
        String expectedEmailText = "Email";
        String expectedPasswordText = "Password";
        String expectedConfirmPwText = "Confirm Password";
        String actualEmailText = tradylinnPage.vendorRegisterEmailText.getText().replace("*","");
        String actualPasswordText = tradylinnPage.vendorRegisterPasswordText.getText().replace("*","");
        String actualConfirmPwText = tradylinnPage.vendorRegisterConfirmPwText.getText().replace("*","");

        Assert.assertEquals(actualEmailText,expectedEmailText);
        Assert.assertEquals(expectedPasswordText,actualPasswordText);
        Assert.assertEquals(expectedConfirmPwText,actualConfirmPwText);

        Assert.assertTrue(tradylinnPage.vendorRegisterEmailTextBox.isEnabled());
        Assert.assertTrue(tradylinnPage.vendorRegisterPasswordTextBox.isEnabled());
        Assert.assertTrue(tradylinnPage.vendorRegisterConfirmPwTextBox.isEnabled());

    }

    /*

     */
}
