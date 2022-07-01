package tests;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.TradylinnPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

import java.util.Arrays;
import java.util.List;
import static utilities.ReusableMethods.waitFor;


public class US007 extends TestBaseRapor {
   static TradylinnPage tradylinPage=new TradylinnPage();
    String[] arr ={"Elegant Auto Group","Green Grass","Node Js","NS8","RED","Skysuite Tech","Sterling"};
    List<String> expectedBrandList= Arrays.asList(arr);
    SoftAssert softAssert = new SoftAssert();
    static Actions actions=new Actions(Driver.getDriver());

    @Test
    public void TC001_VendorCanSeeGivenProductBrands() {
        extentTest=extentReports.createTest("TC001_VendorCanSeeGivenProductBrands",
"Vendor, Add Product sayfasında, Product Brands başlığı altında verilen brand isimlerini görebilmeli");

        signInMethodForUS07_US08();
        extentTest.info("Tradylinn Add product sayfasina gidildi");

        softAssert.assertTrue(tradylinPage.productBrandsHead.isDisplayed(),"Head is not displayed");
        extentTest.pass("Head is displayed");
        softAssert.assertTrue(tradylinPage.productBrandsHead.getText().contains("Product brands"),
                "Head does not contain \"Product brands\"");
        extentTest.pass("Head contains \"Product brands\"");

        for (String each:expectedBrandList) {
            softAssert.assertTrue(Driver.getDriver().findElement(By.xpath("//li[text()='"+each+"']"))
                    .isDisplayed(),""+each+" is not displayed in Brand List");
            extentTest.pass(""+each+" is displayed in Brand List");
        }
        softAssert.assertAll();
    }

    @Test (dependsOnMethods = "TC001_VendorCanSeeGivenProductBrands")
    public void TC002_VendorCanSelectGivenProductBrands() {
        extentTest=extentReports.createTest("TC002_VendorCanSelectGivenProductBrands",
"Vendor, Add Product sayfasında, Product Brands başlığı altında verilen brand'leri seçebilmeli");

        for (String each:expectedBrandList) {
            softAssert.assertTrue(Driver.getDriver()
                    .findElement(By.xpath("//*[@id=\"product_brand\"]/li[text()='"+each+"']/input"))
                    .isDisplayed(),""+each+" checkbox is not displayed");
            extentTest.pass(""+each+" checkbox is displayed in Brand List");

            Driver.getDriver().findElement(By.xpath("//*[@id=\"product_brand\"]/li[text()='"+each+"']/input")).click();
            extentTest.info("Click "+each+"");

            softAssert.assertTrue(Driver.getDriver()
                    .findElement(By.xpath("//*[@id=\"product_brand\"]/li[text()='"+each+"']/input"))
                    .isSelected(),""+each+" checkbox is not selected");
            extentTest.pass(""+each+" checkbox is selected");
        }
        softAssert.assertAll();
    }






    public static void signInMethodForUS07_US08() {
        Driver.getDriver().get(ConfigReader.getProperty("tradylinnUrl"));
        tradylinPage.hesabimlinktext.click();
        tradylinPage.usernameBox.sendKeys(ConfigReader.getProperty("usermail"));
        tradylinPage.passBox.sendKeys(ConfigReader.getProperty("userpass"));
        tradylinPage.signInLoginButton.click();
        waitFor(5);
        tradylinPage.storeManagerButton.click();
        waitFor(3);
        tradylinPage.products.click();
        waitFor(3);
        tradylinPage.addNewProduct.click();
        waitFor(3);
        actions.sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).perform();
        waitFor(2);
    }
}
