package tests;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.TradylinnPage;
import utilities.ConfigReader;
import utilities.Driver;
import java.util.Arrays;
import java.util.List;
import static utilities.ReusableMethods.waitFor;

public class US007 {
   static TradylinnPage tradylinPage=new TradylinnPage();
    String[] arr ={"Elegant Auto Group","Green Grass","Node Js","NS8","RED","Skysuite Tech","Sterling"};
    List<String> expectedBrandList= Arrays.asList(arr);
    SoftAssert softAssert = new SoftAssert();
    static Actions actions=new Actions(Driver.getDriver());


    public static void signInMethod() {
        Driver.getDriver().get(ConfigReader.getProperty("tradylinnUrl"));

        tradylinPage.hesabimlinktext.click();
        tradylinPage.usernameBox.sendKeys(ConfigReader.getProperty("usermail"));
        tradylinPage.passBox.sendKeys(ConfigReader.getProperty("userpass"));
        tradylinPage.signInLoginButton.click();
        waitFor(5);
        tradylinPage.storeManagerButton.click();
        waitFor(5);
        tradylinPage.products.click();
        waitFor(5);
        tradylinPage.addNewProduct.click();
        waitFor(5);
        actions.sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN)
                .perform();
        waitFor(5);

    }

    @Test
    public void TC001() {

        signInMethod();
        softAssert.assertTrue(tradylinPage.productBrandsHead.isDisplayed(),"Head is not displayed");
        softAssert.assertTrue(tradylinPage.productBrandsHead.getText().contains("Product brands"),
                "Head does not contain \"Product brands\"");

        for (String each:expectedBrandList) {
            softAssert.assertTrue(Driver.getDriver().findElement(By.xpath("//li[text()='"+each+"']"))
                    .isDisplayed(),"\"+each+\" is not displayed in Brand List");}
        softAssert.assertAll();
    }

    @Test
    public void TC002() {

        for (String each:expectedBrandList) {
            softAssert.assertTrue(Driver.getDriver()
                    .findElement(By.xpath("//*[@id=\"product_brand\"]/li[text()='"+each+"']/input"))
                    .isDisplayed(),"\"+each+\" checkbox is not displayed");
            Driver.getDriver().findElement(By.xpath("//*[@id=\"product_brand\"]/li[text()='"+each+"']/input")).click();
            softAssert.assertTrue(Driver.getDriver()
                    .findElement(By.xpath("//*[@id=\"product_brand\"]/li[text()='"+each+"']/input"))
                    .isSelected(),"\"+each+\" checkbox is not selected");
        }
        softAssert.assertAll();
    }
}
