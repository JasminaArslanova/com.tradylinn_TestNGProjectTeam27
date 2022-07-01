package US16;

import com.github.javafaker.Faker;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TradylinnPage;
import utilities.Driver;
import utilities.TestBaseRapor;

public class TC03 extends TestBaseRapor {
    static TradylinnPage tradylinPage = new TradylinnPage();
    JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();

    @Test
    public void testcase03() throws InterruptedException {
        //Kullanıcı https://tradylinn.com adresine gider
        //Giriş yap linkine tıklar
        //Kullanıcı adını girer ve şifreyi girer
        // Giriş yap butonuna tıklar
        //Giriş yapıldığını test eder.
        US16.TC01.girisMethod();

        //Hesabım yazısına tıklar
        tradylinPage.hesabim.click();
        extentTest.info("Hesabim linkine tiklandi");

        //Kullanıcı Store Manager tıklar
        tradylinPage.storeManager1.click();
        extentTest.info("Store Manager butonuna tıklandı");
        Thread.sleep(5000);
        Assert.assertTrue(tradylinPage.storemanagerText.isDisplayed());
        extentTest.info("Magazaya giriş yapıldı");
        //Müşteriler linkine tıklar
        js.executeScript("window.scrollBy(0,500)");
        Thread.sleep(15000);
        tradylinPage.musteriler.click();
        extentTest.info("Müşteriler butonuna tıklandı");
        Assert.assertTrue(tradylinPage.musterilersayfaText.isDisplayed());
        extentTest.info(("Müşteriler sayfası açıldı"));

        //Kullanıcı Yeni ekle butonuna tıklar
        tradylinPage.yeniEkleButon.click();
        extentTest.info("Yeni ekle butonuna tıklandı");

        //Kullanıcı müşterinin username girer
        //-Kullanıcı  müşterinin  email girer
        //-Kullanıcı müşterinin  first name girer
        //-Kullanıcı müşterinin last name  girer

        js.executeScript("window.scrollBy(0,500)");
        Thread.sleep(5000);
        Actions actions = new Actions(Driver.getDriver());
        Faker faker = new Faker();
        String fakeMail = faker.internet().emailAddress();
        actions.click(tradylinPage.userName).
                sendKeys(faker.name().username()).
                sendKeys(Keys.TAB).
                sendKeys(fakeMail).sendKeys(Keys.TAB).
                sendKeys(faker.name().firstName()).
                sendKeys(Keys.TAB).
                sendKeys(faker.name().lastName()).perform();

        extentTest.info("Faker ile username ,email,firstname,lastname bilgileri girildi");
        js.executeScript("window.scrollBy(0,1250)");

        //-Kullanıcı Submit butonuna tıklar
        tradylinPage.kaydetButon.click();
        extentTest.info("Submit butonuna tıklandı");

        //-Kullanıcı müşteri bilgilerinin kaydedildiğini test eder
        Assert.assertTrue(tradylinPage.submitonay.isDisplayed());
        extentTest.pass("Müşteri bilgilerinin kaydedildiği test edildi");
        Driver.closeDriver();

    }
}
