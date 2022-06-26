package tests;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.TradylinnPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class US001 {

    static TradylinnPage tradylinnPage = new TradylinnPage();
    static Actions actions = new Actions(Driver.getDriver());
    static JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();



    public static void vendorUyeOlSayfasinaGit() {
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
        Driver.closeDriver();
    }

    public static String gecerliEmailOlustur() {
        LocalDateTime currentDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
        String formattedDateTime = currentDateTime.format(formatter);
        return "tradylinn" + currentDateTime + "@gmail.com";
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
        ReusableMethods.waitFor(5);
        String actualEmailText = tradylinnPage.vendorRegisterEmailText.getText().replace("*","");
        ReusableMethods.waitFor(5);
        String actualPasswordText = tradylinnPage.vendorRegisterPasswordText.getText().replace("*","");
        ReusableMethods.waitFor(5);
        String actualConfirmPwText = tradylinnPage.vendorRegisterConfirmPwText.getText().replace("*","");
        ReusableMethods.waitFor(5);
        Assert.assertEquals(actualEmailText,expectedEmailText);
        Assert.assertEquals(expectedPasswordText,actualPasswordText);
        Assert.assertEquals(expectedConfirmPwText,actualConfirmPwText);
        ReusableMethods.waitFor(5);
        Assert.assertTrue(tradylinnPage.vendorRegisterEmailTextBox.isEnabled());
        ReusableMethods.waitFor(5);
        Assert.assertTrue(tradylinnPage.vendorRegisterPasswordTextBox.isEnabled());
        ReusableMethods.waitFor(5);
        Assert.assertTrue(tradylinnPage.vendorRegisterConfirmPwTextBox.isEnabled());

    }
    @Test (priority = 1)
    public void testCase002() {
        vendorUyeOlSayfasinaGit();
        //4_gecerli email girer
        ReusableMethods.waitFor(5);
        tradylinnPage.vendorRegisterEmailTextBox.sendKeys(gecerliEmailOlustur());
        //"5_gulch password girer ve strong mesajı çıktığını görür"
        ReusableMethods.waitFor(5);
        tradylinnPage.vendorRegisterPasswordTextBox.sendKeys(ConfigReader.getProperty("gulchPassword"));
        //6_passwordu dogru onaylar
        ReusableMethods.waitFor(5);
        tradylinnPage.vendorRegisterConfirmPwTextBox.sendKeys(ConfigReader.getProperty("gulchPassword"));
        //7_register butonuna basar
        ReusableMethods.waitFor(5);
        js.executeScript("arguments[0].scrollIntoView();", tradylinnPage.vendorRegisterPageButton);
        tradylinnPage.vendorRegisterPageButton.click();
        //8_onay yazısının çıktğını doğrular
        ReusableMethods.waitFor(5);
        Assert.assertTrue(tradylinnPage.registrationSuccessHeader.isDisplayed());
    }
}
