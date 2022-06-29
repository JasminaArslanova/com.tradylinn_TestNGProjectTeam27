package tests.US006;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.TradylinnPage;
import utilities.ConfigReader;
import utilities.Driver;

import java.time.Duration;

public class TradyMethod {
    public static void method() throws InterruptedException {

        TradylinnPage tradyPage = new TradylinnPage();
        Actions actions=new Actions(Driver.getDriver());

        //kullanici url e gider
        Driver.getDriver().get(ConfigReader.getProperty("tradyUrl"));

        //kullanici vendor olarak giris yapar
        tradyPage.girisButonu.click();
        tradyPage.usernameBox.sendKeys(ConfigReader.getProperty("tradyEmail"));
        tradyPage.passBox.sendKeys(ConfigReader.getProperty("tradyPassword"));
        tradyPage.signInLoginButton.click();

        //kullanici hesabıma tıklar ve hesabım sayfasına gider
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Çıkış Yap']")));
        tradyPage.Hesabim.click();

        //kullanici Store Manager sayfasına gider
        tradyPage.storeManagerButton.click();
        //actions.sendKeys(Keys.PAGE_DOWN).build().perform();

        //kullanici ürünler sayfasina gider
        jsClick(tradyPage.products);
        //tradyPage.products.click();
        //actions.sendKeys(Keys.PAGE_DOWN).build().perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='wcfm-products']/tbody/tr[2]/td[1]/input")));

        //kullanici ürün secer
        jsClick(tradyPage.urunSecmeCheckBox);
    }

    public static void jsClick(WebElement element) {
        JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
        jse.executeScript("arguments[0].click();", element);
    }
}


