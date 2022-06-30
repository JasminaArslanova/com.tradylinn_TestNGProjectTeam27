package tests.US006;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.TradylinnPage;
import utilities.ConfigReader;
import utilities.Driver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

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

    public static String getScreenshot(String name) throws IOException {
        // naming the screenshot with the current date to avoid duplication
        String date = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        // TakesScreenshot is an interface of selenium that takes the screenshot
        TakesScreenshot ts = (TakesScreenshot) Driver.getDriver();
        File source = ts.getScreenshotAs(OutputType.FILE);
        // full path to the screenshot location
        String target = System.getProperty("user.dir") + "/target/Screenshots/" + name + date + ".png";
        File finalDestination = new File(target);
        // save the screenshot to the path given
        FileUtils.copyFile(source, finalDestination);
        return target;
    }
}


