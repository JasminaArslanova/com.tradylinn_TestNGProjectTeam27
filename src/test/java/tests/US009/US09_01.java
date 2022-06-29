package tests.US009;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TradylinnPage;
import utilities.Driver;
import utilities.ReusableMethods;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

public class US09_01 {

    TradylinnPage trdPage = new TradylinnPage();

    @Test
    public void testUS09() throws InterruptedException, AWTException {

        // Siteye ve hesabıma giriş yapılır
        TradylinnGiris.trdGiris();

        //_Daha sonra Hesabım linkine tikla
        trdPage.hesabimLinki.click();

        // hesabına giriş yaptığını doğrular
        String expectedUrl = "https://tradylinn.com/my-account-2/";
        String actualUrl = Driver.getDriver().getCurrentUrl();
        Assert.assertTrue(actualUrl.equals(expectedUrl));

        // store manager linkine tikla

        trdPage.storeManager.click();

        //_Çıkan menude Ürünlere tikla
        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        trdPage.urunler.click();

        //_Ardından yeni ekle botonuna tikla ve shipping seçimi için asgari ürün bilgilerini gir
        ReusableMethods.waitFor(8);
        trdPage.yeniEkle.click();
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitFor(5);

        trdPage.productTitle.sendKeys("Tornavida");
        trdPage.fiyat.sendKeys("25");

        // Büyük resmi seç
        trdPage.bigPicture.click();
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("window.scrollBy(0,200)");
        trdPage.uploadFile.click();
        Thread.sleep(2000);
        Robot rb = new Robot();
        StringSelection str = new StringSelection("\"C:\\Users\\Akif\\Desktop\\tornavida.jpg\"");
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str, null);
        rb.keyPress(KeyEvent.VK_CONTROL);
        rb.keyPress(KeyEvent.VK_V);
        rb.keyRelease(KeyEvent.VK_CONTROL);
        rb.keyRelease(KeyEvent.VK_V);
        rb.keyPress(KeyEvent.VK_ENTER);
        rb.keyRelease(KeyEvent.VK_ENTER);
        // User selects product photo and click open button
        // User waits for uploading file
        Thread.sleep(8000);
        // User clicks "ADD TO GALLERY" button
        trdPage.resimSec.click();


        ReusableMethods.waitFor(15);
        JavascriptExecutor js1 = (JavascriptExecutor) Driver.getDriver();
        js1.executeScript("arguments[0].click()", trdPage.smallPicture);

        Thread.sleep(10000);
        trdPage.thumbnail.click();
        trdPage.addToGalleryButtonn.click();

        ReusableMethods.switchToWindow("Manage Product");
        ReusableMethods.waitFor(4);

        // kategoriye tikla
        trdPage.kategori.click();

        //_Açılan sayfanın en altında shipping'e tıkla
        ReusableMethods.waitFor(10);
        js.executeScript("window.scrollBy (0,1100)");


        ReusableMethods.waitFor(8);
        trdPage.shippingClick.click();
        ReusableMethods.waitFor(5);

        //_sağ tarafta açılan kilo, boyut ve teslimat süresi bilgilerini doldur
        trdPage.weight.clear();
        trdPage.weight.sendKeys("25");

        trdPage.length.clear();
        trdPage.length.sendKeys("5");

        trdPage.width.clear();
        trdPage.width.sendKeys("5");

        trdPage.height.clear();
        trdPage.height.sendKeys("5");

        Select select = new Select(trdPage.processingTime);
        select.selectByVisibleText("1-3 business days");

        //_Bilgileri Kaydet botununa basarak veri tabanına gönder
        js.executeScript("window.scrollBy (0,200)");
        ReusableMethods.waitFor(3);
        trdPage.submit.click();

        // Kaydın basarılı olduguna dair suscees mesajını görüntüle

        Assert.assertTrue(trdPage.kayitBasarili.isDisplayed());


    }
}
