package US16;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TradylinnPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class TC01 extends TestBaseRapor {
    static TradylinnPage tradylinPage=new TradylinnPage();
    static JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();

    public static void girisMethod() throws InterruptedException {
        //1-Kullanıcı https://tradylinn.com adresine gider
        //2-Giriş yap linkine tıklar
        //3-Kullanıcı adını girer ve şifreyi girer
        //4- Giriş yap butonuna tıklar
        //5-Giriş yapıldığını test eder.
        extentTest = extentReports.createTest("Sayfaya vendor olarak giriş yapılır.");

        Driver.getDriver().get(ConfigReader.getProperty("tradylinnUrl"));
        extentTest.info("Tradylinn Sayfasina Gildi");

        tradylinPage.girisYap.click();
        extentTest.info("Giriş yap linkine tıklandı");
        tradylinPage.usernameKutusu.sendKeys(ConfigReader.getProperty("usermailgenel"));
        tradylinPage.passworddKutusu.sendKeys(ConfigReader.getProperty("passwordgenel"));
        extentTest.info("Username ve Password girildi");

        try {
            tradylinPage.girisYapButton.click();
        } catch (Exception e) {
            js.executeScript("arguments[0].click();", tradylinPage.girisYapButton);
        }
        extentTest.info("Giris yap butonuna tiklandi");
        Assert.assertTrue(tradylinPage.hesabim.isDisplayed());
        Thread.sleep(15000);
    }

    @Test
    public void testcase01() throws InterruptedException {
        girisMethod();
        //Hesabım yazısına tıklar
        tradylinPage.hesabim.click();
        extentTest.info("Hesabim linkine tiklandi");
        //-Store Manager tıklar
        tradylinPage.storeManager1.click();
        extentTest.info("Store Manager butonuna tıklandı");
        Thread.sleep(5000);
        Assert.assertTrue(tradylinPage.storemanagerText.isDisplayed());
        extentTest.info("Magazaya giriş yapıldı");
        //-Müşteriler linkine  tıklar
        js.executeScript("window.scrollBy(0,500)");
        Thread.sleep(5000);
        tradylinPage.musteriler.click();
        extentTest.info("Müşteriler butonuna tıklandı");
        Assert.assertTrue(tradylinPage.musterilersayfaText.isDisplayed());
        extentTest.info(("Müşteriler sayfası açıldı"));

        js.executeScript("window.scrollBy(0,500)");

        //-Kullanıcı adının görüldüğünü test eder
        Assert.assertTrue(tradylinPage.musteriadi.isDisplayed());
        extentTest.info(("Müşteri adı görüldü"));

        //-Kullanıcı emailinin görüldüğünü test eder

        Assert.assertTrue(tradylinPage.musteriemail.isDisplayed());
        extentTest.info(("Müşterinin emaili görüldü"));
        //-Kullanıcı harcama miktarının görüldüğünü test eder


        Assert.assertTrue(tradylinPage.harcananPara.isDisplayed());
        extentTest.info(("Harcanan para görüldü"));

        //-Kullanıcı son siparişerinin görüldüğünü test eder
        Assert.assertTrue(tradylinPage.sonSiparis.isDisplayed());
        extentTest.pass("Son sipariş görüldü");
        Driver.closeDriver();


    }

}
