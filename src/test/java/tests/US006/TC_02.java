package tests.US006;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TradylinnPage;
import utilities.Driver;

import java.io.IOException;

public class TC_02 {

    @Test
    public void test2() throws InterruptedException, IOException {

        TradylinnPage tradyPage = new TradylinnPage();
        Actions actions=new Actions(Driver.getDriver());

        TradyMethod.method();

        // Not ürün sayfasında sonrasinda kategori degisimini asssert edebilmik için
        // ilk kategori degisimindden onceki kategori handle edildi
        String expectedKategori= "Çok Satanlar";
        String ilkKategori= tradyPage.actualKategori.getText();

        // ilk kategori screenShot alinir
        actions.sendKeys(Keys.PAGE_DOWN).build().perform();
        Thread.sleep(3000);
        TradyMethod.getScreenshot("ilkKategoriBesin"); // Kategori ilk halde ürünlerde kategori ekran goruntusu

        //kullanici düzenle butonuna tiklar
        TradyMethod.jsClick(tradyPage.duzenleButonu);

        // eski kategori checkbox'ını kaldırıyoruz

        Thread.sleep(2000); // Eski kategori kaldirildigini görebilmek içim beklettik

        // ilk olarak eski kategoride ki cehckbox click kaldırılır
        for (int i = 1; i <23 ; i++) {
            if (Driver.getDriver().findElement(By.xpath("//*[@id='product_cats_checklist']/li[" + i + "]/input")).isSelected()) {
                TradyMethod.jsClick(Driver.getDriver().findElement(By.xpath("//*[@id='product_cats_checklist']/li[" + i + "]/input")));
            }
        }
        // ikinci  olarak yeni kategoride ki expectedKategori degeri cehckbox'i kliklenir
        TradyMethod.jsClick(tradyPage.cokSatanlar);

        Thread.sleep(5000); // Yeni kategori tıklandigini görebilmek içim beklettik

        //kullanici submit butonuna tıklayıp kaydeder
        TradyMethod.jsClick(tradyPage.submitButonu);
        Thread.sleep(10000);

        //kullanici ürünler sayfasina geri döner
        TradyMethod.jsClick(tradyPage.products);

        // son kategori screenShot alinir
        actions.sendKeys(Keys.PAGE_DOWN).build().perform();
        Thread.sleep(3000);
        TradyMethod.getScreenshot("sonKategori");// Kategori degistikten sonra ürünlerde kategori ekran goruntusu

        // Not ürün sayfasında sonrasinda kategori degisimini asssert edebilmik için
        // kategori degisimindden sonraki actualKategori handle edildi
        String actualKategori= tradyPage.actualKategori.getText();

        //kullanici seçilen ürünün kategorisinin degistigini test eder
        Assert.assertEquals(expectedKategori,actualKategori);
        Assert.assertTrue(actualKategori!=ilkKategori);
    }

}
