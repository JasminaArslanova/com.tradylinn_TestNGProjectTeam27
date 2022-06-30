package tests;

import org.apache.poi.ss.formula.functions.T;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TradylinnPage;
import utilities.ConfigReader;
import utilities.Driver;

public class US002 {

    TradylinnPage trady = new TradylinnPage();
    Actions actions = new Actions(Driver.getDriver());
    JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
    /*

Vendor olarak email ve şifre girilmeli ve sistemde My Accout görünmeli
Orders, Downloads, addresses, account details,whislist ve Logout gorulmeli
Dashboard altında ise; Store manager, orders, downloads, addresses , account details, appointments, wishlist
Support tickets, followings ve log out olmali
     */

    @Test
    public void test002() throws InterruptedException {

        //1-tradylinn@hotmail.com sayfasina gidilir /go to tradylinn@hotmail.com page
        Driver.getDriver().get(ConfigReader.getProperty("tradylinnUrl"));

        //2-Giris buttonuna tiklanir
        TradylinnPage.girisButonu.click();

        //3-Username girilir /  Username is entered
        TradylinnPage.username.sendKeys(ConfigReader.getProperty("usermail"));

        //4-Password girilir / Password is entered
        TradylinnPage.password.sendKeys(ConfigReader.getProperty("userpass"));

        //5-Giris buttonna tiklanir / Click the login button
        TradylinnPage.girisButonu2.click();

        //6_hesabıma tıklanır
        Thread.sleep(10000);
        TradylinnPage.Hesabim.click();

        //7-Hesabim yazisinin gorunurlugu kontrol edilir /  Visibility of My Account text is checked
        Thread.sleep(10000);
        Assert.assertTrue(TradylinnPage.myaccount.isDisplayed());

        //8-Store managerin gorunurlugu test edilir / Store manager's visibility is tested
       Assert.assertTrue(TradylinnPage.StoreManager.isDisplayed());

        //9-Orders butonunun gorunurlugu test edilir / The visibility of the Orders button is tested
        Assert.assertTrue(TradylinnPage.Orders.isDisplayed());

        //10-Downloads butonunun gorunurlugu test edilir / The visibility of the Downloads button is tested
        Assert.assertTrue(TradylinnPage.Downloads.isDisplayed());

        //11-Addresses butonunun gorunurlugu test edilir /The visibility of the Addresses button is tested
        Assert.assertTrue(TradylinnPage.Addresses.isDisplayed());

        //12-Account details butonunun gorunurlugu test edilir / The visibility of the Account button is tested
        Assert.assertTrue(TradylinnPage.AccountDetails.isDisplayed());

        //13-Appointments butonunun gorunurlugu test edilir /The visibility of the Appointments button is tested
        Assert.assertTrue(TradylinnPage.Appointments.isDisplayed());

        //14-Whislist butonunun gorunurlugu test edilir /The visibility of the Whislist button is tested
        Assert.assertTrue(TradylinnPage.Whislist.isDisplayed());

        //15-Support tickets butonunun gorunurlugu test edilir /The visibility of the Support button is tested
        Assert.assertTrue(TradylinnPage.SupportTickets.isDisplayed());

        //16-Followings butonunun gorunurlugu test edilir / The visibility of the Followings button is tested
        Assert.assertTrue(TradylinnPage.Followings.isDisplayed());

        //17-Logout butonunun gorunurlugu test edilir / The visibility of the Logout button is tested
        Assert.assertTrue(TradylinnPage.Logout.isDisplayed());

        //18-Orders butonunun gorunurlugu test edilir / The visibility of the Orders button is tested
        Assert.assertTrue(TradylinnPage.Orders2.isDisplayed());

        //19-Downloads butonunun gorunurlugu test edilir / The visibility of the Downloads button is tested
        Assert.assertTrue(TradylinnPage.Downloads2.isDisplayed());

        //20-Addresses butonunun gorunurlugu test edilir /The visibility of the Addresses button is tested
        Assert.assertTrue(TradylinnPage.Addresses2.isDisplayed());

        //21-Account details butonunun gorunurlugu test edilir / The visibility of the Account button is tested
        Assert.assertTrue(TradylinnPage.AccountDetails2.isDisplayed());

        //22-Whislist butonunun gorunurlugu test edilir /The visibility of the Whislist button is tested
        Assert.assertTrue(TradylinnPage.Whislist2.isDisplayed());

        //23-Logout butonunun gorunurlugu test edilir / The visibility of the Logout button is tested
        Assert.assertTrue(TradylinnPage.Logout2.isDisplayed());







    }
}
