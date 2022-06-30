package tests;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import pages.TradylinnPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.List;

public class US010 {
    static TradylinnPage tradylinnPage = new TradylinnPage();

    public static void storeGiris() {
        TradylinnPage trdPage= new TradylinnPage();
        Driver.getDriver().get(ConfigReader.getProperty("tradylinnUrl"));
        ReusableMethods.waitFor(3);
        tradylinnPage.girisYapButon.click();
        ReusableMethods.waitFor(3);
        tradylinnPage.emailKutusu.sendKeys(ConfigReader.getProperty("usermail"));
        ReusableMethods.waitFor(3);
        tradylinnPage.passwordKutusu.sendKeys(ConfigReader.getProperty("userpass"));
        ReusableMethods.waitFor(3);
        tradylinnPage.ikinciGirisYapButonu.click();
        ReusableMethods.waitFor(3);
        ReusableMethods.waitFor(10);
        tradylinnPage.hesabimLinki.click();
    }

    @Test
    public void TC_001_ve_TC_002(){

        //TC_001
        //ReusableMethods.tradylinnStoreManager();
        storeGiris();
        ReusableMethods.waitFor(3);

        JavascriptExecutor js1 = (JavascriptExecutor) Driver.getDriver(); //sayfayı asagı kaydır
        js1.executeScript("window.scrollBy(0,250)");
        tradylinnPage.storeManagerButton.click();
        ReusableMethods.waitFor(3);
        tradylinnPage.storeManager.click();
        ReusableMethods.waitFor(3);

        js1.executeScript("window.scrollBy(0,300)");
        tradylinnPage.urunlerTextLink.click();
        tradylinnPage.urunlerTextLink.clear();
        ReusableMethods.waitFor(3);

        tradylinnPage.yeniEkle.click();
        ReusableMethods.waitFor(3);

        JavascriptExecutor js2 = (JavascriptExecutor) Driver.getDriver(); //sayfayı asagı kaydır
        js2.executeScript("window.scrollBy(0,1100)");
        tradylinnPage.attributes.click();
        ReusableMethods.waitFor(3);

        tradylinnPage.attributes_Color.click();
        ReusableMethods.waitFor(3);

        Select select1 = new Select(tradylinnPage.ddColor);
        List<WebElement> colors = select1.getOptions();
        for (WebElement each : colors
        ) {
            each.click();
            System.out.println(each.getText());


            //TC_002
            tradylinnPage.attributes_Size.click();
            ReusableMethods.waitFor(3);

            Select select2 = new Select(tradylinnPage.ddSize);
            List<WebElement> size = select2.getOptions();
            for (WebElement each2 : size) {
                each.click();
                System.out.println(each2.getText());
            }
        }
    }
}
