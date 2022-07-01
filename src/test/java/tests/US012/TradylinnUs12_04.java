package tests.US012;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TradylinnPage;
import tests.US009.TradylinnGiris;
import utilities.Driver;
import utilities.ReusableMethods;

public class TradylinnUs12_04 {

    TradylinnPage trdPage = new TradylinnPage();

    @Test
    public void testUs12_04() {

        // Siteye ve hesabıma giriş yapılır
        TradylinnGiris.trdGiris();

        //5_Daha sonra Hesabım linkine tikla
        trdPage.hesabimLinki.click();
        ReusableMethods.waitFor(10);

        //6_Hesabına giris yaptıgını doğrula

        String expectedUrl = "https://tradylinn.com/my-account-2/";
        String actualUrl = Driver.getDriver().getCurrentUrl();
        Assert.assertTrue(actualUrl.equals(expectedUrl));
        //7_Hesap detaylarına tikla
        ReusableMethods.waitFor(5);
        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitFor(5);
        trdPage.hesapDetaylari.click();
        //8-Hesap Detayları sayfasının görünür oldugunu test et
        ReusableMethods.waitFor(5);
        String hesapExpectedUrl = "https://tradylinn.com/my-account-2/edit-account/";
        String hesapActualUrl = Driver.getDriver().getCurrentUrl();
        Assert.assertTrue(actualUrl.equals(expectedUrl));

        // 9 E-posta'nın gorunur oldugunu test et
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Assert.assertTrue(trdPage.epostaUpdate.isDisplayed());

        //10_ Hesap Detayları sayfasındaki verileri güncelle

        trdPage.hesapAd.clear();
        trdPage.hesapAd.sendKeys("akif");

        trdPage.hesapSoyad.clear();
        trdPage.hesapSoyad.sendKeys("rencber");

        actions.sendKeys(Keys.PAGE_DOWN).perform();

        trdPage.gorunenAd.clear();
        trdPage.gorunenAd.sendKeys("Tradylinn1");

        trdPage.epostaUpdate.clear();
        trdPage.epostaUpdate.sendKeys("tradylinn11@gmail.com");


        ReusableMethods.waitFor(10);
        trdPage.metinButonu.click();
        trdPage.metinYazisiGonder.sendKeys("Tradylinn.com sitesine hos geldiniz. Keyifli alısverisler dileriz.");
        actions.sendKeys(Keys.PAGE_DOWN).perform();

        trdPage.currentPassword.clear();


        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitFor(10);
        trdPage.hesapKaydetButonu.click();

        //11_ Hesap sayfasındaki bilgilerin güncellendiğini test et

        Assert.assertTrue(trdPage.hesapDetaylariDegistiMesaji.isDisplayed());




    }
}
