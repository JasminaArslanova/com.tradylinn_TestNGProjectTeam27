package tests.US22;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TradylinnPage;
import utilities.Driver;
import utilities.TestBaseRapor;

public class TestCase01 extends TestBaseRapor {


    static TradylinnPage tradylinPage=new TradylinnPage();
     JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
    Actions actions = new Actions(Driver.getDriver());


    @Test
    public void testCase01() throws InterruptedException {

        //-Kullanıcı https://tradylinn.com adresine gider
        //-Giriş yap linkine tıklar
        //-Kullanıcı adını girer ve şifreyi girer
        //- Giriş yap butonuna tıklar
        //-Giriş yapıldığını test eder.
        US16.TC01.girisMethod();
        //-Tümünü gör linki görünür olduğunu test edilir.

        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Assert.assertTrue(tradylinPage.TumunuGorYazi.isDisplayed());
        extentTest.info("indirimli urunler sayfasında tumunu gör yazısı görünürlüğü test edildi.");


        //-Kullanıcı indirimli ürünler bölümünden tümünü gör linkine tıklar.
        tradylinPage.indirimliUrunlerTumunuGor.click();
        extentTest.info("indirimli urunler Tümünü gör linkine tıkandı.");

        //-indirimli ürünler ana sayfanın açıldığını test eder
        Assert.assertTrue(tradylinPage.indirimliUrunlerSayfa.isDisplayed());
        extentTest.pass("indirimli urunler Tümünügör sayfasına geçildi.");
        Driver.closeDriver();



    }
}
