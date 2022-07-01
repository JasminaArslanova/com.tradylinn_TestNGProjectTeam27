package tests;

import com.github.javafaker.Faker;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TradylinnPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Random;

public class US004 extends TestBaseRapor {
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
        ReusableMethods.waitFor(2);
        for (int i = 0; i < 5; i++) {
            js.executeScript("arguments[0].click();", trady.sepeteEkle.get(rnd.nextInt(5)));
        }
        extentTest.info("Rastgele 5 urun sepete eklendi");
        js.executeScript("arguments[0].click();", trady.sepet);
        ReusableMethods.waitFor(2);
        Assert.assertTrue(trady.sepetVisible.isDisplayed());
        extentTest.pass("Urunlerin sepete eklendigi goruldu");
        ReusableMethods.waitFor(10);
    }

    @Test
    public void test02() {
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
        Sepeti goruntule butonuna tiklanir
        Arti butonu ile urun miktari arttirilir
        Urunun arttirildigi test edilir
        Eksi butonu ile urun miktari azaltilir
        Urunun azaltildigi test edilir
         */
        giris();
        ReusableMethods.waitFor(2);
        for (int i = 0; i < 5; i++) {
            js.executeScript("arguments[0].click();", trady.sepeteEkle.get(rnd.nextInt(5)));
        }
        extentTest.info("Rastgele 5 urun sepete eklendi");
        js.executeScript("arguments[0].click();", trady.sepet);
        ReusableMethods.waitFor(2);
        Assert.assertTrue(trady.sepetVisible.isDisplayed());
        extentTest.pass("Urunlerin sepete eklendigi goruldu");
        ReusableMethods.waitFor(10);
        try {
            trady.sepetiGoruntuleButton.click();
        } catch (Exception e) {
            js.executeScript("arguments[0].click();", trady.sepetiGoruntuleButton);
        }
        ReusableMethods.waitFor(2);
        trady.artiButonu.click();
        ReusableMethods.waitFor(2);
        String arttirmadanOnce = trady.artidanSonra.getText();
        try {
            trady.yenile.click();
        } catch (Exception e) {
            js.executeScript("arguments[0].click();", trady.yenile);
        }
        ReusableMethods.waitFor(50);
        String arttirdiktanSonra = trady.artidanSonra.getText();
        System.out.println(arttirmadanOnce + " " + arttirdiktanSonra);
        Assert.assertNotEquals(arttirmadanOnce, arttirdiktanSonra);
        trady.eksiButonu.click();
        ReusableMethods.waitFor(2);
        try {
            trady.yenile.click();
        } catch (Exception e) {
            js.executeScript("arguments[0].click();", trady.yenile);
        }
        ReusableMethods.waitFor(50);
        String eksilttiktenSonra = trady.artidanSonra.getText();
        Assert.assertEquals(arttirmadanOnce, eksilttiktenSonra);

    }

    @Test
    public void test03() {
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
        Urunlerin sepette gorundugu test edilir
        sepeti goruntuleye click yapilir
        Urunun stok miktarinin gorunurlugu test edilir
        Arti butonu ile urun miktari arttirilir
        Urunun arttirildigi test edilir
        Eksi butonu ile urun miktari azaltilir
        Urunun azaltildigi test edilir
        Urune tiklanir stok miktarinin gorunur oldugu test edilir
        Stok fazlasi urunun sepete eklenemedigi test edilir ve sepetimden sepeti goguntuleye tiklanir
        Urun miktari arti eksi butonlari ile arttirilir veya azaltilir
        Update cart ile rakamin guncellendigi test edilir
         */
        giris();
        ReusableMethods.waitFor(2);
        for (int i = 0; i < 5; i++) {
            js.executeScript("arguments[0].click();", trady.sepeteEkle.get(rnd.nextInt(5)));
        }
        extentTest.info("Rastgele 5 urun sepete eklendi");
        js.executeScript("arguments[0].click();", trady.sepet);
        ReusableMethods.waitFor(2);
        Assert.assertTrue(trady.sepetVisible.isDisplayed());
        extentTest.pass("Urunlerin sepete eklendigi goruldu");
        ReusableMethods.waitFor(10);
        try {
            trady.sepetiGoruntuleButton.click();
        } catch (Exception e) {
            js.executeScript("arguments[0].click();", trady.sepetiGoruntuleButton);
        }
        ReusableMethods.waitFor(2);
        String arttirmadanOnce = trady.artidanSonra.getText();
        trady.artiButonu.click();
        try {
            trady.yenile.click();
        } catch (Exception e) {
            js.executeScript("arguments[0].click();", trady.yenile);
        }
        ReusableMethods.waitFor(50);
        String arttirdiktanSonra = trady.artidanSonra.getText();
        System.out.println(arttirmadanOnce + " " + arttirdiktanSonra);
        Assert.assertNotEquals(arttirmadanOnce, arttirdiktanSonra);
        trady.eksiButonu.click();
        ReusableMethods.waitFor(2);
        try {
            trady.yenile.click();
        } catch (Exception e) {
            js.executeScript("arguments[0].click();", trady.yenile);
        }
        ReusableMethods.waitFor(50);
        String eksilttiktenSonra = trady.artidanSonra.getText();
        Assert.assertEquals(arttirmadanOnce, eksilttiktenSonra);
        try {
            trady.sepettekiUrun.click();
        } catch (Exception e) {
            js.executeScript("arguments[0].click();", trady.sepettekiUrun);
        }
        String urunTablo = trady.stokTablosu.getText();
        if (urunTablo.contains("adet stokta")){
            System.out.println("Stok miktari goruntulendi");
            String[] stokYazisi = trady.stokMiktari.getText().split(" ");
            System.out.println(stokYazisi[0]);
            trady.urunMiktar.sendKeys(stokYazisi[0] + 1);
            try {
                trady.urunSepeteEkle.click();
            } catch (Exception e) {
                js.executeScript("arguments[0].click();", trady.urunSepeteEkle);
            }
            Assert.assertFalse(trady.urunSepeteEklendiYazisi.isDisplayed());
        }else System.out.println("Stok miktari yok");

        try {
            trady.sepet.click();
        } catch (Exception e) {
            js.executeScript("arguments[0].click();", trady.sepet);
        }

        ReusableMethods.waitFor(2);
        try {
            trady.sepetiGoruntuleButton.click();
        } catch (Exception e) {
            js.executeScript("arguments[0].click();", trady.sepetiGoruntuleButton);
        }
        trady.artiButonu.click();
        ReusableMethods.waitFor(2);
        String artisOncesi = trady.artidanSonra.getText();
        try {
            trady.yenile.click();
        } catch (Exception e) {
            js.executeScript("arguments[0].click();", trady.yenile);
        }
        ReusableMethods.waitFor(45);
        String artisSonrasi = trady.artidanSonra.getText();
        System.out.println(artisOncesi + " " + artisSonrasi);
        Assert.assertNotEquals(artisOncesi, artisSonrasi);

    }
    public void urunEkle() {
        ReusableMethods.waitFor(2);
        for (int i = 0; i < 5; i++) {
            js.executeScript("arguments[0].click();", trady.sepeteEkle.get(rnd.nextInt(5)));
        }
        extentTest.info("Rastgele 5 urun sepete eklendi");
        ReusableMethods.waitFor(20);
        js.executeScript("arguments[0].click();", trady.sepet);
        ReusableMethods.waitFor(2);
        Assert.assertTrue(trady.sepetVisible.isDisplayed());
        extentTest.pass("Urunlerin sepete eklendigi goruldu");
        ReusableMethods.waitFor(2);
        try {
            trady.sepetiGoruntuleButton.click();
        } catch (Exception e) {
            js.executeScript("arguments[0].click();", trady.sepetiGoruntuleButton);
        }
        js.executeScript("arguments[0].click();", trady.sepettekiUrun);

        String urunTablo = trady.stokTablosu.getText();
        if (urunTablo.contains("adet stokta")){
            System.out.println("Stok miktari goruntulendi");
        }else System.out.println("Stok miktari yok");
        Driver.getDriver().navigate().back();
        js.executeScript("arguments[0].click();", trady.sepettekiIkinciUrun);

        String urunTablo2 = trady.stokTablosu.getText();
        if (urunTablo2.contains("adet stokta")){
            System.out.println("Stok miktari goruntulendi");
        }else System.out.println("Stok miktari yok");
        Driver.getDriver().navigate().back();
        js.executeScript("arguments[0].click();", trady.sepettekiUcuncuUrun);

        String urunTablo3 = trady.stokTablosu.getText();
        if (urunTablo3.contains("adet stokta")){
            System.out.println("Stok miktari goruntulendi");
        }else System.out.println("Stok miktari yok");
        Driver.getDriver().navigate().back();
        js.executeScript("arguments[0].click();", trady.sepettekiDorduncuUrun);

        String urunTablo4 = trady.stokTablosu.getText();
        if (urunTablo4.contains("adet stokta")){
            System.out.println("Stok miktari goruntulendi");
        }else System.out.println("Stok miktari yok");
        Driver.getDriver().navigate().back();
        js.executeScript("arguments[0].click();", trady.sepettekiBesinciUrun);

        String urunTablo5 = trady.stokTablosu.getText();
        if (urunTablo5.contains("adet stokta")){
            System.out.println("Stok miktari goruntulendi");
        }else System.out.println("Stok miktari yok");
        ReusableMethods.waitFor(5);
        Driver.getDriver().navigate().back();
    }

    @Test
    public void test04() {
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
        Urunlerin sepette gorundugu test edilir
        sepeti goruntuleye click yapilir
        Urunun stok miktarinin gorunurlugu test edilir
        Clean cart (Temizle) butonuna tiklanir
        Sepetiniz su anda bos yazisinin gorunurlugu test edilir
         */
        giris();
        urunEkle();

        try {
            trady.temizle.click();
        } catch (Exception e) {
            js.executeScript("arguments[0].click();", trady.temizle);
        }
        Assert.assertTrue(trady.sepetBosYazisi.isDisplayed());
    }

    @Test
    public void test05() {
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
        Urunlerin sepette gorundugu test edilir
        sepeti goruntuleye click yapilir
        Urunun stok miktarinin gorunurlugu test edilir
        Sepet sayfasinda kupon seceneginin gorunur oldugu test edilir
         */
        giris();
        urunEkle();
        Assert.assertTrue(trady.kupon.isDisplayed());
        Assert.assertTrue(trady.kupon2.isDisplayed());

    }

    @Test
    public void test06() {
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
        Urunlerin sepette gorundugu test edilir
        sepeti goruntuleye click yapilir
        Urunun stok miktarinin gorunurlugu test edilir
        Alisverise devam et butonunun gorunurlugu test edilir
         */
        giris();
        urunEkle();
        Assert.assertTrue(trady.alisVeriseDevam.isDisplayed());
    }

    @Test
    public void test07() {
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
        Urunlerin sepette gorundugu test edilir
        sepeti goruntuleye click yapilir
        Urunun stok miktarinin gorunurlugu test edilir
        Odeme sayfasina git butonuna tiklanir
        Fatura detaylarinin ve toplam rakamin gorunur oldugu test edilir
         */
        giris();
        urunEkle();
        try {
            trady.odemeSayfasiButton.click();
        } catch (Exception e) {
            js.executeScript("arguments[0].click();", trady.odemeSayfasiButton);
        }
        Assert.assertTrue(trady.faturaDetaylari.isDisplayed());
        Assert.assertTrue(trady.toplamRakam.isDisplayed());

    }
}
