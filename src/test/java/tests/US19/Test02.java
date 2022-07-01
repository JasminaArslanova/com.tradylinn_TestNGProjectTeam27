package tests.US19;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TradylinnPage;
import utilities.Driver;
import utilities.TestBaseRapor;

public class Test02 extends TestBaseRapor {
    static TradylinnPage tradylinPage=new TradylinnPage();
    static JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();

    @Test
    public void test01() throws InterruptedException {
        //Kullanıcı https://tradylinn.com adresine gider
        //Giriş yap linkine tıklar
        //Kullanıcı adını girer ve şifreyi girer
        // Giriş yap butonuna tıklar
        //Giriş yapıldığını test eder.
        US16.TC01.girisMethod();
        //Hesabım yazısına tıklar
        tradylinPage.hesabim.click();
        extentTest.info("Hesabim linkine tiklandi");
        //-Store Manager tıklar
        tradylinPage.storeManager1.click();
        extentTest.info("Store Manager butonuna tıklandı");
        Thread.sleep(5000);
        js.executeScript("window.scrollBy(0,750)");
        Assert.assertTrue(tradylinPage.storemanagerText.isDisplayed());
        extentTest.info("Magazaya giriş yapıldı");
        Thread.sleep(5000);



        //Kullanıcı Takipçilere tıklar
        tradylinPage.takipciler.click();
        extentTest.info("Takipçiler butonuna tıklandı");
        Thread.sleep(5000);
        js.executeScript("window.scrollBy(0,550)");

        //Kullanıcı takipçi isim ve email bilgilerinin görüldüğünü test eder

        Assert.assertTrue(tradylinPage.takipciBilgi.isDisplayed());
        extentTest.pass("Takipçilerin isim ve email bilgilerinin görüldüğü test edildi.");

        Driver.closeDriver();

    }

}
