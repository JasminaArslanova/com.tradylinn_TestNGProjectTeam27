package tests;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.TradylinnPage;
import utilities.Driver;
import utilities.TestBaseRapor;
import java.util.Arrays;
import java.util.List;
import static tests.US007.signInMethodForUS07_US08;
import static utilities.ReusableMethods.getElementsText;
import static utilities.ReusableMethods.waitFor;


public class US008 extends TestBaseRapor {
    static TradylinnPage tradylinPage=new TradylinnPage();
    SoftAssert softAssert = new SoftAssert();
    Actions actions=new Actions(Driver.getDriver());

    @Test
    public void TC001_VendorCanSeeManageStockAndClickCheckbox() {
        extentTest=extentReports.createTest("TC001_VendorCanSeeManageStockAndClickCheckbox",
"Vendor, Add Product sayfasında Manage Stock başlığını ve  checkbox'unu görebilimeli, checkbox erişilebilir olmalı, Manage Stock checkbox'ına tıkladığında checkbox'ın seçili olduğunu görebilmeli");

        signInMethodForUS07_US08();
        extentTest.info("Tradylinn Add product sayfasina gidildi");

        actions.sendKeys(Keys.PAGE_DOWN).perform();
        waitFor(3);
        softAssert.assertTrue(tradylinPage.manageStockHead.isDisplayed(),
                "Head is not displayed");
        extentTest.pass("Head is displayed");

        softAssert.assertTrue(tradylinPage.manageStockHead.getText().contains("Manage Stock"),
                "Head does not contain \"Manage Stock\"");
        extentTest.pass("Head contains \"Manage Stock\"");

        softAssert.assertTrue(tradylinPage.manageStockCheckbox.isDisplayed(),
                "\"Manage Stock\" checkbox is not displayed");
        extentTest.pass("\"Manage Stock\" checkbox is displayed");

        softAssert.assertTrue(tradylinPage.manageStockCheckbox.isEnabled(),
                "\"Manage Stock\" checkbox is not enabled");
        extentTest.pass("\"Manage Stock\" checkbox is enabled");

        tradylinPage.manageStockCheckbox.click();
        extentTest.info("Click Manage Stock checkbox");

        softAssert.assertTrue(tradylinPage.manageStockCheckbox.isSelected(),
                "\"Manage Stock\" checkbox is not selected");
        extentTest.pass("\"Manage Stock\" checkbox is selected");

        softAssert.assertAll();
    }

    @Test (dependsOnMethods = "TC001_VendorCanSeeManageStockAndClickCheckbox")
    public void TC002_VendorCanSeeStockQtyAndInputStockQuantity() {
        extentTest=extentReports.createTest("TC002_VendorCanSeeStockQtyAndInputStockQuantity",
"Vendor, Add Product sayfasında Stock Qty başlığını görebilmeli, Stock  Qty texbox'a erişebilmeli ve stok miktarı girebilmeli");

        softAssert.assertTrue(tradylinPage.stockQtyHead.isDisplayed(),
                "Head is not displayed");
        extentTest.pass("Head is displayed");

        softAssert.assertTrue(tradylinPage.stockQtyHead.getText().contains("Stock Qty"),
                "Head does not contain \"Stock Qty\"");
        extentTest.pass("Head contains \"Stock Qty\"");

        softAssert.assertTrue(tradylinPage.stockQtytextbox.isDisplayed(),
                "\"Stock Qty\" textbox is not displayed\"");
        extentTest.pass("\"Stock Qty\" textbox is displayed\"");

        softAssert.assertTrue(tradylinPage.stockQtytextbox.isEnabled(),
                "\"Stock Qty\" textbox is not enabled\"");
        extentTest.pass("\"Stock Qty\" textbox isenabled\"");

         waitFor(3);
        tradylinPage.stockQtytextbox.clear();
        tradylinPage.stockQtytextbox.sendKeys("10");
        extentTest.info("Input to Stock Qty textbox 10");

        softAssert.assertAll();
    }

    @Test(dependsOnMethods = "TC001_VendorCanSeeManageStockAndClickCheckbox")
    public void TC003_VendorCanSeeAllowBackordersAndSelectOptions() {
        extentTest=extentReports.createTest("TC003_VendorCanSeeAllowBackordersAndSelectOptions",
"Vendor, Add Product sayfasında Allow Backorders? başlığını görebilmeli, dropdown'da olan optionları görebilmeli ve seçebilmeli");

        Select select=new Select(tradylinPage.backordersDropdown);

        softAssert.assertTrue(tradylinPage.allowBackordersHead.isDisplayed(),
                "Head is not displayed");
        extentTest.pass("Head is displayed");

        softAssert.assertTrue(tradylinPage.allowBackordersHead.getText().contains("Allow Backorders"),
                "Head does not contain \"Allow Backorders\"");
        extentTest.pass("Head contains \"Allow Backorders\"");

        List<WebElement> actualOptionList=select.getOptions();
        List<String> optionList=getElementsText(actualOptionList);
        List<String> expectedOptionList= Arrays.asList("Do not Allow","Allow, but notify customer","Allow");

        for (String each:expectedOptionList) {
            softAssert.assertTrue(optionList.contains(each),"Option List does not contain "+each+" ");
            extentTest.pass("Option List contains "+each+" ");

            select.selectByVisibleText(each);
            extentTest.info("Select "+each+" ");

            softAssert.assertTrue(select.getFirstSelectedOption().getText().contains(each),
                    " "+each+" option is not selected");
            extentTest.pass(" "+each+" option is selected");

            waitFor(3);
        }
        softAssert.assertAll();
    }
}
