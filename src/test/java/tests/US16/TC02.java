package tests.US16;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TradylinnPage;
import utilities.Driver;
import utilities.TestBaseRapor;

import java.nio.file.Files;
import java.nio.file.Paths;

public class TC02 extends TestBaseRapor {
    static TradylinnPage tradylinPage=new TradylinnPage();
  JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
    @Test
    public void testCase02() throws InterruptedException {
        //Kullanıcı https://tradylinn.com adresine gider
        //Giriş yap linkine tıklar
        //Kullanıcı adını girer ve şifreyi girer
        // Giriş yap butonuna tıklar
        //Giriş yapıldığını test eder.
       TC01.girisMethod();

        //Hesabım yazısına tıklar
        tradylinPage.hesabim.click();
        extentTest.info("Hesabim linkine tiklandi");
        //Store Manager tıklar
        tradylinPage.storeManager1.click();
        extentTest.info("Store Manager butonuna tıklandı");
        Thread.sleep(5000);
        Assert.assertTrue(tradylinPage.storemanagerText.isDisplayed());
        extentTest.info("Magazaya giriş yapıldı");
        //Müşteriler linkine tıklar
        js.executeScript("window.scrollBy(0,500)");
        Thread.sleep(5000);
        tradylinPage.musteriler.click();
        extentTest.info("Müşteriler butonuna tıklandı");
        Assert.assertTrue(tradylinPage.musterilersayfaText.isDisplayed());
        extentTest.info(("Müşteriler sayfası açıldı"));
        Thread.sleep(5000);
        //Pdf butonuna tıklar,pdf olarak dosyanın indiğini test eder
        tradylinPage.pdfButon.click();
        extentTest.info("Pdf butonuna tıklandı");
        String farkliKisim= System.getProperty("user.home");
        String ortakKisim = "\\Downloads\\Store Manager – Tradylinn.pdf";
        String arananDosyaYolu= farkliKisim+ortakKisim;

        // geriye o dosya yolundaki dosyanin var oldugunu assert edelim
        Assert.assertTrue(Files.exists(Paths.get(arananDosyaYolu)));
        extentTest.info("Pdf uzantılı  olarak dosyanın  indirildiği test edildi");


        //Excel butonuna tıklar,excel olarak dosyanın indiğini test eder
        farkliKisim="";
        ortakKisim="";
        arananDosyaYolu="";
        tradylinPage.excelbuton.click();
        extentTest.info("Excel butonuna tıklandı");
        farkliKisim= System.getProperty("user.home");
        ortakKisim = "\\Downloads\\Store Manager – Tradylinn.xlsx";
        arananDosyaYolu= farkliKisim+ortakKisim;
        // geriye o dosya yolundaki dosyanin var oldugunu assert edelim
        Assert.assertTrue(Files.exists(Paths.get(arananDosyaYolu)));
        extentTest.info("Excel uzantılı  olarak dosyanın  indirildiği test edildi");

        //-Csv butonuna tıklar, csv olarak dosyanın indiğini test eder
        farkliKisim="";
        ortakKisim="";
        arananDosyaYolu="";
        tradylinPage.csvbuton.click();
        extentTest.info("Csv butonuna tıklandı");
        farkliKisim= System.getProperty("user.home");
        ortakKisim = "\\Downloads\\Store Manager – Tradylinn.csv";
        arananDosyaYolu= farkliKisim+ortakKisim;
        // geriye o dosya yolundaki dosyanin var oldugunu assert edelim
        Assert.assertTrue(Files.exists(Paths.get(arananDosyaYolu)));
        extentTest.pass("Csv uzantılı  olarak dosyanın  indirildiği test edildi");


     Driver.closeDriver();



    }

}
