package tests;

import com.github.javafaker.Faker;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TradylinnPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

import java.time.Duration;
import java.util.*;

public class US003 extends TestBaseRapor {
    TradylinnPage trady = new TradylinnPage();
    Actions actions = new Actions(Driver.getDriver());
    JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
    Random rnd = new Random();
    Faker faker = new Faker();
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(30));

    public void giris() {
        extentTest = extentReports.createTest("US_003_TC_01", "Sayfaya giris yapilir");
        Driver.getDriver().get(ConfigReader.getProperty("tradylinnUrl"));
        extentTest.info("Tradylinn Sayfasina Gildi");
        trady.hesabimlinktext.click();
        extentTest.info("Hesabim Butonuna Tiklandi");
        trady.usernameBox.sendKeys(ConfigReader.getProperty("usermail"));
        trady.passBox.sendKeys(ConfigReader.getProperty("userpass"));
        extentTest.info("Gecerli username ve password girildi");
        try {
            trady.girisYapButonu.click();
        } catch (Exception e) {
            js.executeScript("arguments[0].click();", trady.girisYapButonu);
        }
        extentTest.info("Giris yap butonuna tiklandi");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assert.assertTrue(trady.hesabimText.isDisplayed());
        extentTest.info("Hesabim sayfasina giris yapildigi goruldu");
        try {
            trady.siparislerButonu.click();
        } catch (Exception e) {
            js.executeScript("arguments[0].click();", trady.siparislerButonu);
        }
        extentTest.info("Siparisler butonuna tiklandi");
        Assert.assertTrue(trady.siparislerText.isDisplayed());
        extentTest.info("Siparisler sayfasina giris yapildigi goruldu");

        if (trady.alisVeriseDevam.isDisplayed()) {
            js.executeScript("arguments[0].click();", trady.alisVeriseDevamButon);
        } else {
            js.executeScript("arguments[0].click();", trady.urunlereGozAtButtonu);
        }

        extentTest.info("Urunlere goz at butonuna tiklandi");
        Assert.assertTrue(trady.magazaText.isDisplayed());
        extentTest.pass("Magaza sayfasina giris yapildigi goruldu");
    }

    @Test
    public void test01() {
        /*
    -US003 --> Orders da Browse products'a gidilmeli
    - url` ye gidilir
    - Giris yap' a tiklanir
    - Gecerli kullanici bilgileri girilir
    - Giris yap' a tiklanir
    - Hesabim sayfasina giris yapildigi test edilir
    - Acilan sayfada siparisler bolumune tiklanir
    - Siparisler sayfasina giris yapildigi test edilir
    - Acilan sayfada Browse Products(Urunlere Goz At) butonuna tiklanir
    - Magaza butonunun gorunur oldugunu test edin
     */
        giris();
    }

    @Test
    public void test02() throws InterruptedException {
        /*
          url` ye gidilir
          Giris yap' a tiklanir
          Gecerli kullanici bilgileri girilir
          Giris yap' a tiklanir
          Hesabim sayfasina giris yapildigi test edilir
          Acilan sayfada siparisler bolumune tiklanir
          Acilan sayfada Browse Products(Urunlere Goz At) butonuna tiklanir
          Magaza butonunun gorunur oldugu test edilir
          Rastgele 5 urun secilir ve sepete eklenir
          Urunlerin sepette gorundugu test edilir
         */
        giris();
        Thread.sleep(2000);
        for (int i = 0; i < 5; i++) {
            js.executeScript("arguments[0].click();", trady.sepeteEkle.get(rnd.nextInt(5)));
        }
        extentTest.info("Rastgele 5 urun sepete eklendi");
        js.executeScript("arguments[0].click();", trady.sepet);
        Thread.sleep(2000);
        Assert.assertTrue(trady.sepetVisible.isDisplayed());
        extentTest.pass("Urunlerin sepete eklendigi goruldu");
        Thread.sleep(10000);
    }

    @Test
    public void test03() throws InterruptedException {
        /*
        url` ye gidilir
        Giris yap' a tiklanir
        Gecerli kullanici bilgileri girilir
        Giris yap' a tiklanir
        Hesabim sayfasina giris yapildigi test edilir
        Acilan sayfada siparisler bolumune tiklanir
        Acilan sayfada Browse Products(Urunlere Goz At) butonuna tiklanir
        Magaza butonunun gorunur oldugu test edilir
        Rastgele 5 urun secilir ve sepete eklenir
        sepetim e clikck yapilir
        sepeti goruntuleye click yapilir
        Sepet sayfasina gidildigi test edilir
        Go To Payment(odeme sayfasi) a click yapilir
        fatura detaylarinin gorunurlugu test edilir
         */

        giris();

        //Thread.sleep(2000);
        //for (int i = 0; i < 5; i++) {
        //    js.executeScript("arguments[0].click();",trady.sepeteEkle.get(rnd.nextInt(5)));
        //}
        //extentTest.info("Rastgele 5 urun sepete eklendi");
        //js.executeScript("arguments[0].click();", trady.sepet);
        //Thread.sleep(2000);
        //Assert.assertTrue(trady.sepetVisible.isDisplayed());
        //Thread.sleep(10000);
        js.executeScript("arguments[0].click();", trady.sepetiGoruntuleButton);
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains("cart"));
        js.executeScript("arguments[0].click();", trady.odemeSayfasiButton);
        Assert.assertTrue(trady.faturaDetaylari.isDisplayed());
    }

    @Test
    public void test04() throws InterruptedException {
        /*
        url` ye gidilir
        Giris yap' a tiklanir
        Gecerli kullanici bilgileri girilir
        Giris yap' a tiklanir
        Hesabim sayfasina giris yapildigi test edilir
        Acilan sayfada siparisler bolumune tiklanir
        Acilan sayfada Browse Products(Urunlere Goz At) butonuna tiklanir
        Magaza butonunun gorunur oldugu test edilir
        Rastgele 5 urun secilir ve sepete eklenir
        sepetim e clikck yapilir
        sepeti goruntuleye click yapilir
        Go To Payment(odeme sayfasi) a click yapilir
        fatura detaylarinin gorunurlugu test edilir
        Tum adres bilgileri girilir
         */
        giris();
        //Thread.sleep(2000);
        //for (int i = 0; i < 5; i++) {
        //    js.executeScript("arguments[0].click();",trady.sepeteEkle.get(rnd.nextInt(5)));
        //}
        //extentTest.info("Rastgele 5 urun sepete eklendi");
        //js.executeScript("arguments[0].click();", trady.sepet);
        //Thread.sleep(2000);
        //Assert.assertTrue(trady.sepetVisible.isDisplayed());
        //Thread.sleep(10000);
        js.executeScript("arguments[0].click();", trady.sepetiGoruntuleButton);
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains("cart"));
        js.executeScript("arguments[0].click();", trady.odemeSayfasiButton);
        Assert.assertTrue(trady.faturaDetaylari.isDisplayed());
        js.executeScript("arguments[0].click();", trady.firstName);
        trady.firstName.clear();
        trady.firstName.sendKeys(faker.name().firstName());
        actions.sendKeys(Keys.TAB).sendKeys(faker.name().lastName())
                .sendKeys(Keys.TAB).sendKeys(faker.name().username()).sendKeys(Keys.TAB)
                .sendKeys(faker.address().fullAddress()).sendKeys(Keys.TAB)
                .sendKeys(faker.address().country()).sendKeys(Keys.TAB)
                .sendKeys(faker.address().zipCode()).sendKeys(Keys.TAB)
                .sendKeys(faker.address().cityName()).sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB).sendKeys(faker.phoneNumber().phoneNumber())
                .sendKeys(Keys.TAB).sendKeys("tradylinn11@gmail.com").sendKeys(Keys.TAB)
                .sendKeys(faker.address().secondaryAddress()).perform();
        Thread.sleep(2000);
        js.executeScript("arguments[0].scrollIntoView(true);", trady.teslimatAdresi);
        Thread.sleep(2000);

    }

    @Test
    public void test05() throws InterruptedException {
        /*
        url` ye gidilir
        Giris yap' a tiklanir
        Gecerli kullanici bilgileri girilir
        Giris yap' a tiklanir
        Hesabim sayfasina giris yapildigi test edilir
        Acilan sayfada siparisler bolumune tiklanir
        Acilan sayfada Browse Products(Urunlere Goz At) butonuna tiklanir
        Magaza butonunun gorunur oldugu test edilir
        Rastgele 5 urun secilir ve sepete eklenir
        sepetim e clikck yapilir
        sepeti goruntuleye click yapilir
        Go To Payment a click yapilir
        fatura detaylarinin gorunurlugu test edilir
        Tum fatura ve tum adres bilgileri girilir
        Teslimat yontemi secilir
        Place order(Siparisi onayla) a tiklanir
        Tesekkur ederiz siparisiniz alinmistir Yazisinin gorunurlugu test edilir
         */
        giris();
        Thread.sleep(2000);
        for (int i = 0; i < 5; i++) {
            js.executeScript("arguments[0].click();", trady.sepeteEkle.get(rnd.nextInt(5)));
        }
        extentTest.info("Rastgele 5 urun sepete eklendi");
        js.executeScript("arguments[0].click();", trady.sepet);
        Thread.sleep(2000);
        Assert.assertTrue(trady.sepetVisible.isDisplayed());
        Thread.sleep(10000);
        js.executeScript("arguments[0].click();", trady.sepetiGoruntuleButton);
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains("cart"));
        js.executeScript("arguments[0].click();", trady.odemeSayfasiButton);
        Assert.assertTrue(trady.faturaDetaylari.isDisplayed());
        js.executeScript("arguments[0].click();", trady.firstName);
        trady.firstName.clear();
        trady.firstName.sendKeys(faker.name().firstName());
        actions.sendKeys(Keys.TAB).sendKeys(faker.name().lastName())
                .sendKeys(Keys.TAB).sendKeys(faker.name().username()).sendKeys(Keys.TAB)
                .sendKeys(faker.address().fullAddress()).sendKeys(Keys.TAB)
                .sendKeys(faker.address().country()).sendKeys(Keys.TAB)
                .sendKeys(faker.address().zipCode()).sendKeys(Keys.TAB)
                .sendKeys(faker.address().cityName()).sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB).sendKeys(faker.phoneNumber().cellPhone())
                .sendKeys(Keys.TAB).sendKeys("tradylinn11@gmail.com").sendKeys(Keys.TAB)
                .sendKeys(faker.address().secondaryAddress()).perform();
        Thread.sleep(2000);
        js.executeScript("arguments[0].scrollIntoView(true);", trady.teslimatAdresi);
        Thread.sleep(2000);
        js.executeScript("arguments[0].click();", trady.googleOk);
        Thread.sleep(2000);
        js.executeScript("arguments[0].click();", trady.teslimatYontemi);
        Thread.sleep(2000);
        js.executeScript("arguments[0].click();", trady.siparisiOnayla);
        Thread.sleep(2000);
        wait.until(ExpectedConditions.visibilityOf(trady.thankYouVisible));
        Assert.assertTrue(trady.thankYouVisible.isDisplayed());


    }
}
