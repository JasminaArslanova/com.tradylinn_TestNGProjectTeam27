package tests.US_013;

import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TradylinnPage;
import utilities.ConfigReader;
import utilities.Driver;

public class TradylinnUS013 {


    //TC_01  Kupon kodu verilmeli
    @Test
    public void TradylinnUS013( ) {
        TradylinnPage tradylinnPage = new TradylinnPage();

        //1_Kullanici "https://tradiylinn.com/" adresine gider
        Driver.getDriver().get(ConfigReader.getProperty("tradylinnUrl"));

        // 2_Kullanici "Hesabım" 'I clink eder.
        tradylinnPage.MyAccountButton.click();

        // 3_Kullanici mail adresini ve parolayı girer.
        tradylinnPage.userNameButton.sendKeys(ConfigReader.getProperty("tradylinnValidEmail"));
        tradylinnPage.passwordButton.sendKeys(ConfigReader.getProperty("tradylinnValidPassword"));

        // 4_Kullanici Giriş Yap butonuna tıklar
        tradylinnPage.girisLoginTusu.submit();

        //5_Kullanici giriş yaptıkdan sonra "Hesabım" gorur.
        Assert.assertTrue(tradylinnPage.hesabimYazisi.isDisplayed());

        //6_Kullanici "Store Manager 'e" clink eder.
        tradylinnPage.storeManagerButton.click();

        //7 -Kullanici "Kupunlar" clink eder
        tradylinnPage.kuponlarButton.click();

        //8-Kullanici "yeni ekle" clink eder.
        tradylinnPage.kuponYeniEkleButton.click();

        //9- Kullanici "Add Coupon" başlığının görünür olduğunu doğrular
        Assert.assertTrue(tradylinnPage.AddCouponYazisi.isDisplayed());

        //10 -Kullanici "code " kupon kodunu girer.

        Actions actions = new Actions(Driver.getDriver());
        Faker faker = new Faker();
        actions.
                click(tradylinnPage.codeButton).
                sendKeys(faker.number().digits(5)).

                sendKeys(Keys.TAB).
                sendKeys(faker.expression("iyi alisverisler")).
                sendKeys(Keys.TAB).

                perform();



    }
}