package tests;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.TradylinnPage;
import static tests.US007.signInMethod;


public class US008 {
    static TradylinnPage tradylinPage=new TradylinnPage();
    SoftAssert softAssert = new SoftAssert();

    @Test
    public void TC001() {
        signInMethod();
        softAssert.assertTrue(tradylinPage.manageStockHead.getText().contains("Manage Stock"),
                "Head does not contain \"Manage Stock\"");
        softAssert.assertTrue(tradylinPage.manageStockCheckbox.isDisplayed(),
                "\"Manage Stock\" checkbox is not displayed");
        softAssert.assertTrue(tradylinPage.manageStockCheckbox.isEnabled(),
                "\"Manage Stock\" checkbox is not enabled");

        tradylinPage.manageStockCheckbox.click();
        softAssert.assertTrue(tradylinPage.manageStockCheckbox.isSelected(),
                "\"Manage Stock\" checkbox is not selected");
    }

    @Test (dependsOnMethods = "TC001")
    public void TC002() {
        softAssert.assertTrue(tradylinPage.stockQtyHead.getText().contains("Stock Qty"),
                "Head does not contain \"Stock Qty\"");
        softAssert.assertTrue(tradylinPage.stockQtytextbox.isDisplayed(),
                "\"Stock Qty\" textbox is not displayed\"");
        softAssert.assertTrue(tradylinPage.stockQtytextbox.isEnabled(),
                "\"Stock Qty\" textbox is not enabled\"");

        tradylinPage.stockQtytextbox.sendKeys("10");
    }

    @Test(dependsOnMethods = "TC001")
    public void TC003() {
        Select select=new Select(tradylinPage.backordersDropdown);

        softAssert.assertTrue(tradylinPage.allowBackordersHead.getText().contains("Allow Backorders"),
                "Head does not contain \"Allow Backorders\"");
        softAssert.assertTrue(tradylinPage.backordersDropdown.getText().contains("Do not Allow"),
                "\"Do not Allow\" option is not founded");
        softAssert.assertTrue(tradylinPage.backordersDropdown.getText().contains("Allow, but notify customer"),
                "\"Allow, but notify customer\" option is not founded");
        softAssert.assertTrue(tradylinPage.backordersDropdown.getText().contains("Allow"),
                "\"Allow\" option is not founded");

        select.selectByVisibleText("Do not Allow");
        softAssert.assertTrue(select.getFirstSelectedOption().isSelected());

    }
}
