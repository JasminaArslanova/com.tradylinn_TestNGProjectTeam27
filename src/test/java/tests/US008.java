package tests;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.TradylinnPage;
import utilities.Driver;

import java.util.Arrays;
import java.util.List;
import static tests.US007.signInMethod;
import static utilities.ReusableMethods.getElementsText;
import static utilities.ReusableMethods.waitFor;


public class US008 {
    static TradylinnPage tradylinPage=new TradylinnPage();
    SoftAssert softAssert = new SoftAssert();
    Actions actions=new Actions(Driver.getDriver());

    @Test
    public void TC001() {
        signInMethod();
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        softAssert.assertTrue(tradylinPage.manageStockHead.getText().contains("Manage Stock"),
                "Head does not contain \"Manage Stock\"");
        softAssert.assertTrue(tradylinPage.manageStockCheckbox.isDisplayed(),
                "\"Manage Stock\" checkbox is not displayed");
        softAssert.assertTrue(tradylinPage.manageStockCheckbox.isEnabled(),
                "\"Manage Stock\" checkbox is not enabled");

        tradylinPage.manageStockCheckbox.click();
        softAssert.assertTrue(tradylinPage.manageStockCheckbox.isSelected(),
                "\"Manage Stock\" checkbox is not selected");

        softAssert.assertAll();
    }

    @Test (dependsOnMethods = "TC001")
    public void TC002() {
        softAssert.assertTrue(tradylinPage.stockQtyHead.getText().contains("Stock Qty"),
                "Head does not contain \"Stock Qty\"");
        softAssert.assertTrue(tradylinPage.stockQtytextbox.isDisplayed(),
                "\"Stock Qty\" textbox is not displayed\"");
        softAssert.assertTrue(tradylinPage.stockQtytextbox.isEnabled(),
                "\"Stock Qty\" textbox is not enabled\"");
         waitFor(3);
        tradylinPage.stockQtytextbox.clear();
        tradylinPage.stockQtytextbox.sendKeys("10");

        softAssert.assertAll();
    }

    @Test(dependsOnMethods = "TC001")
    public void TC003() {
        Select select=new Select(tradylinPage.backordersDropdown);
        softAssert.assertTrue(tradylinPage.allowBackordersHead.getText().contains("Allow Backorders"),
                "Head does not contain \"Allow Backorders\"");

        List<WebElement> actualOptionList=select.getOptions();
        List<String> optionList=getElementsText(actualOptionList);
        List<String> expectedOptionList= Arrays.asList("Do not Allow","Allow, but notify customer","Allow");

        for (String each:expectedOptionList) {
            softAssert.assertTrue(optionList.contains(each),"Option List does not contain "+each+" ");
            select.selectByVisibleText(each);
            softAssert.assertTrue(select.getFirstSelectedOption().getText().contains(each),
                    " "+each+" option is not selected");
        }
        softAssert.assertAll();
    }
}
