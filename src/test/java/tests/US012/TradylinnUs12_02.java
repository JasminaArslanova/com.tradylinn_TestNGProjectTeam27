package tests.US012;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TradylinnPage;
import tests.US009.TradylinnGiris;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.List;

public class TradylinnUs12_02 {

    TradylinnPage trdPage = new TradylinnPage();

    @Test
    public void testUs12_02() {

        // Siteye ve hesabıma giriş yapılır
        TradylinnGiris.trdGiris();

        //5_Daha sonra Hesabım linkine tikla
        trdPage.hesabimLinki.click();
        ReusableMethods.waitFor(10);

        //6_Hesabına giris yaptıgını doğrula

        String expectedUrl = "https://tradylinn.com/my-account-2/";
        String actualUrl = Driver.getDriver().getCurrentUrl();
        Assert.assertTrue(actualUrl.equals(expectedUrl));


        //6_indirmelere tikla
        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitFor(5);
        trdPage.indirmeler.click();


        //7-indirmeler yapılmıssa bunları listele

        List<WebElement> indirmeler = trdPage.indirmelerListesi;
        for (WebElement each: indirmeler) {
            System.out.println(each.getText());
        }
    }
}
