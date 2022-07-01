package tests.US22;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import pages.TradylinnPage;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

import java.io.IOException;
import java.util.List;

public class TestCase03 extends TestBaseRapor {
    static TradylinnPage tradylinPage = new TradylinnPage();
    Actions actions = new Actions(Driver.getDriver());

    @Test
    public void test01() throws InterruptedException, IOException {
        //-Kullanıcı https://tradylinn.com adresine gider
        //-Giriş yap linkine tıklar
        //-Kullanıcı adını girer ve şifreyi girer
        //- Giriş yap butonuna tıklar
        //-Giriş yapıldığını test eder.
        US16.TC01.girisMethod();
        actions.sendKeys(Keys.PAGE_DOWN).perform();

        //-İndirimli ürünler tümünü gör linkine tıklar
        tradylinPage.indirimliUrunlerTumunuGor.click();
        extentTest.info("İndirimli urunler tümünü gör linkine tıklandı");

        //-Kullanıcı fiyata göre sırala:Düşükten yükseğe  seçeneğine tıklar,
        Select select1=new Select(tradylinPage.dropDownn2);
        select1.selectByVisibleText("Show 36");

        Select select=new Select(tradylinPage.dropDown);
        select.selectByVisibleText("Fiyata göre sırala: Düşükten yükseğe");
        extentTest.info("Fiyata göre sırala: Düşükten yükseğe seçeneği seçildi");

        List<WebElement> Fiyat=Driver.getDriver().findElements(By.xpath("//span[@class='price']"));
        extentTest.info("ürün fiyatları listeye atıldı ");


        for (WebElement each : Fiyat) {
            String fiyatStr = each.getText().replaceAll("₺", "  ");
            System.out.print(fiyatStr);

        }

        JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
        jse.executeScript("document.body.style.zoom='50%'");
        ReusableMethods.getScreenshot("US22");
        extentTest.pass("Fiyata göre sırala: Düşükten yükseğe yapıldığı test edildi");

        //  sayfayi kapat
        Driver.closeDriver();

        //-Kullanıcı fiyata göre sırala :düşükten yükseğe yapıldığını test eder





    }
}
