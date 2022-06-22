package tests;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TradylinnPage;
import utilities.ConfigReader;
import utilities.Driver;

public class US003 {
    TradylinnPage trady = new TradylinnPage();
    Actions actions = new Actions(Driver.getDriver());
    JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
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
    @Test
    public void test01() {
        Driver.getDriver().get(ConfigReader.getProperty("tradylinnUrl"));
        trady.hesabimlinktext.click();
        trady.usernameBox.sendKeys(ConfigReader.getProperty("usermail"));
        trady.passBox.sendKeys(ConfigReader.getProperty("userpass"));
        try {
            trady.girisYapButonu.click();
        } catch (Exception e) {
            JavascriptExecutor executor = (JavascriptExecutor) Driver.getDriver();
            executor.executeScript("arguments[0].click();", trady.girisYapButonu);
        }
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assert.assertTrue(trady.hesabimText.isDisplayed());
        try {
            trady.siparislerButonu.click();
        } catch (Exception e) {
            JavascriptExecutor executor = (JavascriptExecutor) Driver.getDriver();
            executor.executeScript("arguments[0].click();", trady.siparislerButonu);
        }
        Assert.assertTrue(trady.siparislerText.isDisplayed());
        try {
            trady.urunlereGozAtButtonu.click();
        } catch (Exception e) {
            JavascriptExecutor executor = (JavascriptExecutor) Driver.getDriver();
            executor.executeScript("arguments[0].click();", trady.urunlereGozAtButtonu);
        }
        Assert.assertTrue(trady.magazaText.isDisplayed());
    }
}
