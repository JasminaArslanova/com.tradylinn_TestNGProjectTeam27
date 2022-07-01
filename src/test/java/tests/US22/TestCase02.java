package tests.US22;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TradylinnPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

import java.time.Duration;

public class TestCase02 extends TestBaseRapor {
    static TradylinnPage tradylinPage = new TradylinnPage();
    Actions actions = new Actions(Driver.getDriver());


    @Test
    public void TC002() throws InterruptedException {
        US16.TC01.girisMethod();
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        //  "Tumunu gor" linkine tikla
        tradylinPage.indirimliUrunlerTumunuGor.click();
        extentTest.info("indirimli urunler Tümünü gör linkine tıkandı.");

        //  Acilan sayfada default olarak "Varsayilan Siralama" seceneginin bulundugunu test et
        String defaultDropDownStr = tradylinPage.dropDown.getText();
        System.out.println(defaultDropDownStr);
        Assert.assertTrue(defaultDropDownStr.trim().startsWith("Varsayılan"));
        extentTest.info("Varsayılan seçeneği seçildi");

        //  "En cok incelenene gore sirala" seceneginin ulasilabilir oldugunu test et
        Select select = new Select(tradylinPage.dropDown);
        select.selectByVisibleText("En çok incelenene göre sırala");
        String currentUrl = Driver.getDriver().getCurrentUrl();
        System.out.println(currentUrl);
        Assert.assertTrue(currentUrl.endsWith("popularity"));
        extentTest.info("En çok incelenene göre sırala");

        //  "En cok oy alana gore siral" seceneginin ulasilabilir oldugunu test et
        select.selectByVisibleText("En çok oy alana göre sırala");
        currentUrl = Driver.getDriver().getCurrentUrl();
        System.out.println(currentUrl);
        Assert.assertTrue(currentUrl.endsWith("rating"));
        extentTest.info("En çok oy alana göre sırala");

        //  "En yeniye gore" seceneginin ulasilabilir oldugunu test et
        select.selectByVisibleText("En yeniye göre sırala");
        currentUrl = Driver.getDriver().getCurrentUrl();
        System.out.println(currentUrl);
        Assert.assertTrue(currentUrl.endsWith("date"));
        extentTest.info("En yeniye göre sırala");

        //  "Fiyata gore sirala: Dusukten yuksege" seceneginin ulasilabilir oldugunu test et
        select.selectByVisibleText("Fiyata göre sırala: Düşükten yükseğe");
        currentUrl = Driver.getDriver().getCurrentUrl();
        System.out.println(currentUrl);
        Assert.assertTrue(currentUrl.endsWith("price"));
        extentTest.info("Fiyata göre sırala: Düşükten yükseğe");

        //  "Fiyata gore sirala:Yuksekten dusuge" seceneginin ulasilabilir oldugunu test et
        select.selectByVisibleText("Fiyata göre sırala: Yüksekten düşüğe");
        currentUrl = Driver.getDriver().getCurrentUrl();
        System.out.println(currentUrl);
        Assert.assertTrue(currentUrl.endsWith("price-desc"));
        extentTest.pass("Fiyata göre sırala: Yüksekten düşüğe");

        //  sayfayi kapat
        Driver.closeDriver();
    }
}

