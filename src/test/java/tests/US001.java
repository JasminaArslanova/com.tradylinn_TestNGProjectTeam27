package tests;

import com.github.javafaker.Faker;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.TradylinnPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class  US001 extends TestBaseRapor {

    static TradylinnPage tradylinnPage = new TradylinnPage();
    static Actions actions = new Actions(Driver.getDriver());
    SoftAssert softAssert = new SoftAssert();
    static JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
    static Faker faker = new Faker();
    static int beklemeSure = 1;


    public static void vendorUyeOlSayfasinaGit() {
        /*
         1_https://tradiylinn.com/ adresine gider
         2_üye ol'a tıklar
         3_register pop-up'ında oldugunu dogrular
         "4_sign up as a vendor' link textinin erişilebilir
         oldugunu kontrol eder"
     */
        Driver.getDriver().get(ConfigReader.getProperty("tradylinnUrl"));
        ReusableMethods.waitFor(beklemeSure);

        tradylinnPage.uyeOlHeaderButton.click();
        Assert.assertTrue(tradylinnPage.kayitOlPopUpButton.isDisplayed());
        Assert.assertTrue(tradylinnPage.registerAsVendorLinkText.isEnabled());

        //      "5_sign up as a vendor'a tıklar ve regist. sayfasına gider
        tradylinnPage.registerAsVendorLinkText.click();
        //      Registration sayfasında oldugunu dogrular"
        Assert.assertTrue(tradylinnPage.vendorRegisterBaslik.isDisplayed());
    }

    public static String gecerliEmailOlustur() {
        LocalDateTime currentDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
        String formattedDateTime = currentDateTime.format(formatter);
        return "tradylinn" + currentDateTime + "@gmail.com";
    }

    @Test(priority = 0)
    public void testCase001() {
        Driver.getDriver().get(ConfigReader.getProperty("tradylinnUrl"));
        ReusableMethods.waitFor(beklemeSure);
        extentTest=extentReports.createTest("TC001_VendorCanSeeRegistrationPage",
                "Vendor olarak, registration sayfasına gidebilmeli ve sayfadaki email, password, confirm password gorebilmeli");


        js.executeScript("arguments[0].click();", tradylinnPage.uyeOlHeaderButton);
        extentTest.info("Tradylinn uye ol ekranina gidildi");
        // tradylinnPage.uyeOlHeaderButton.click();
        ReusableMethods.waitFor(beklemeSure);
        softAssert.assertTrue(tradylinnPage.kayitOlPopUpButton.isDisplayed());
        extentTest.pass("Uye ol pop-up is displayed");
        ReusableMethods.waitFor(beklemeSure);
        softAssert.assertTrue(tradylinnPage.registerAsVendorLinkText.isEnabled());
        extentTest.pass("Register as Vendor link is enabled");

        //      "5_sign up as a vendor'a tıklar ve regist. sayfasına gider
        tradylinnPage.registerAsVendorLinkText.click();
        //      Registration sayfasında oldugunu dogrular"
        ReusableMethods.waitFor(beklemeSure);
        js.executeScript("arguments[0].scrollIntoView()", tradylinnPage.registerForm);
        softAssert.assertTrue(tradylinnPage.vendorRegisterBaslik.isDisplayed());
        extentTest.pass("Vendor Registration sayfasina gidildi");
        //      "6_Registration sayfasında email yazdigini ve
        //      email textboxun erişilebilir oldugunu kontrol eder"
        //      "7_Registration sayfasında password yazdigini ve
        //      textboxun erişilebilir oldugunu kontrol eder"
        //      "8_Registration sayfasında confirm password yazdigini
        //      textboxun erişilebilir oldugunu kontrol eder"
        String expectedEmailText = "Email";
        String expectedPasswordText = "Password";
        String expectedConfirmPwText = "Confirm Password";
        ReusableMethods.waitFor(beklemeSure);

        String actualEmailText = tradylinnPage.vendorRegisterEmailText.getText().replace("*", "");
        ReusableMethods.waitFor(beklemeSure);
        String actualPasswordText = tradylinnPage.vendorRegisterPasswordText.getText().replace("*", "");
        ReusableMethods.waitFor(beklemeSure);
        String actualConfirmPwText = tradylinnPage.vendorRegisterConfirmPwText.getText().replace("*", "");
        ReusableMethods.waitFor(beklemeSure);
        softAssert.assertEquals(actualEmailText, expectedEmailText);
        extentTest.pass("Email text is correct");
        softAssert.assertEquals(expectedPasswordText, actualPasswordText);
        extentTest.pass("Password text is correct");
        softAssert.assertEquals(expectedConfirmPwText, actualConfirmPwText);
        extentTest.pass("Confirm Password text is correct");
        ReusableMethods.waitFor(beklemeSure);
        softAssert.assertTrue(tradylinnPage.vendorRegisterEmailTextBox.isEnabled());
        extentTest.pass("Email text box is enabled.");
        ReusableMethods.waitFor(beklemeSure);
        softAssert.assertTrue(tradylinnPage.vendorRegisterPasswordTextBox.isEnabled());
        extentTest.pass("Password text box is enabled.");
        ReusableMethods.waitFor(beklemeSure);
        softAssert.assertTrue(tradylinnPage.vendorRegisterConfirmPwTextBox.isEnabled());
        extentTest.pass("Confirm Password text is enabled.");

        softAssert.assertAll();
        Driver.closeDriver();


    }

    @Test(priority = 1)
    public void testCase002() {
        extentTest=extentReports.createTest("TC002_VendorCanRegisterWithCorrectDatas",
                "Vendor olarak, unique, gecerli, gulch bir password girilmeli ve password dogru onaylanmalı üyelik gerceklesmeli");

        Driver.getDriver().get(ConfigReader.getProperty("tradylinnUrl"));
        ReusableMethods.waitFor(beklemeSure);

        tradylinnPage.uyeOlHeaderButton.click();
        extentTest.info("Tradylinn uye ol ekranina gidildi");
        softAssert.assertTrue(tradylinnPage.kayitOlPopUpButton.isDisplayed());
        extentTest.pass("Uye ol pop-up is displayed");
        softAssert.assertTrue(tradylinnPage.registerAsVendorLinkText.isEnabled());
        extentTest.pass("Register as Vendor link is enabled");
        //      "5_sign up as a vendor'a tıklar ve regist. sayfasına gider
        tradylinnPage.registerAsVendorLinkText.click();
        extentTest.info("Vendor Registration sayfasina gidildi");
        //      Registration sayfasında oldugunu dogrular"
        ReusableMethods.waitFor(beklemeSure);
        js.executeScript("arguments[0].scrollIntoView()", tradylinnPage.registerForm);
        softAssert.assertTrue(tradylinnPage.vendorRegisterBaslik.isDisplayed());
        extentTest.pass("Vendor Registration sayfasina gidildi");
        //4_gecerli email girer
        ReusableMethods.waitFor(beklemeSure);
        tradylinnPage.vendorRegisterEmailTextBox.sendKeys(faker.internet().emailAddress());
        extentTest.info("Entered unique email adress.");
        //"5_gulch password girer ve strong mesajı çıktığını görür"
        ReusableMethods.waitFor(beklemeSure);
        tradylinnPage.vendorRegisterPasswordTextBox.sendKeys(ConfigReader.getProperty("gulchPassword"));
        extentTest.info("Entered a gulch password.");
        //6_passwordu dogru onaylar
        ReusableMethods.waitFor(beklemeSure);
        tradylinnPage.vendorRegisterConfirmPwTextBox.sendKeys(ConfigReader.getProperty("gulchPassword"));
        extentTest.info("Password confirmed correctly.");
        //7_register butonuna basar
        js.executeScript("arguments[0].scrollIntoView()", tradylinnPage.vendorRegisterPageButton);
        ReusableMethods.waitFor(beklemeSure);
        js.executeScript("arguments[0].click();", tradylinnPage.vendorRegisterPageButton);
        extentTest.info("Register button clicked.");
        //tradylinnPage.vendorRegisterPageButton.click();
        //8_onay yazısının çıktğını doğrular
        ReusableMethods.waitFor(beklemeSure);
        softAssert.assertTrue(tradylinnPage.registrationSuccessHeader.isDisplayed());
        extentTest.pass("Registered as vendor.");

        softAssert.assertAll();
        Driver.closeDriver();


    }

    @Test(priority = 2)
    public void testCase003() {

        extentTest=extentReports.createTest("TC003_VendorCanNotRegisterWithUsedEmail",
                "Vendor olarak, unique olmayan bir email ile uyelik gerceklesmemeli");

        Driver.getDriver().get(ConfigReader.getProperty("tradylinnUrl"));
        ReusableMethods.waitFor(beklemeSure);

        tradylinnPage.uyeOlHeaderButton.click();
        extentTest.info("Tradylinn uye ol ekranina gidildi");

        softAssert.assertTrue(tradylinnPage.kayitOlPopUpButton.isDisplayed());
        extentTest.pass("Uye ol pop-up is displayed");

        softAssert.assertTrue(tradylinnPage.registerAsVendorLinkText.isEnabled());
        extentTest.pass("Register as Vendor link is enabled");

        //      "5_sign up as a vendor'a tıklar ve regist. sayfasına gider
        tradylinnPage.registerAsVendorLinkText.click();
        extentTest.info("Vendor Registration sayfasina gidildi");
        //      Registration sayfasında oldugunu dogrular"
        ReusableMethods.waitFor(beklemeSure);
        js.executeScript("arguments[0].scrollIntoView()", tradylinnPage.registerForm);
        softAssert.assertTrue(tradylinnPage.vendorRegisterBaslik.isDisplayed());
        extentTest.pass("Vendor Registration sayfasina gidildi");
        // 4_unique olmayan email girer
        ReusableMethods.waitFor(beklemeSure);
        tradylinnPage.vendorRegisterEmailTextBox.sendKeys(ConfigReader.getProperty("usermail"));
        extentTest.info("Entered no-unique email adress.");
        // "5_gulch password girer ve strong mesajı çıktığını görür"
        ReusableMethods.waitFor(beklemeSure);
        tradylinnPage.vendorRegisterPasswordTextBox.sendKeys(ConfigReader.getProperty("gulchPassword"));
        extentTest.info("Entered a gulch password.");
        // 6_passwordu dogru onaylar
        ReusableMethods.waitFor(beklemeSure);
        tradylinnPage.vendorRegisterConfirmPwTextBox.sendKeys(ConfigReader.getProperty("gulchPassword"));
        extentTest.info("Password confirmed correctly.");
        // 7_register butonuna basar
        //js.executeScript("arguments[0].scrollIntoView()", tradylinnPage.vendorRegisterPageButton);
        ReusableMethods.waitFor(beklemeSure);
        js.executeScript("arguments[0].click();", tradylinnPage.vendorRegisterPageButton);
        extentTest.info("Register button clicked.");
        // 8_"already exist" uyarısının çıktğını doğrular
        ReusableMethods.waitFor(beklemeSure);
        softAssert.assertTrue(tradylinnPage.registrationCancelledMessage.isDisplayed());
        softAssert.assertEquals(tradylinnPage.registrationCancelledMessage.getText(), ConfigReader.getProperty("registeredVendorExistMessage"));
        extentTest.pass("Not registered as vendor and 'already exist' message is visible.");
        softAssert.assertAll();
        Driver.closeDriver();


    }

    @Test(priority = 3)
    public void testCase004() {

        extentTest=extentReports.createTest("TC004_VendorCanSeeRegistrationPage",
                "Vendor olarak, unique, gecerli, gulch bir password girilmeli ve password dogru onaylanmadan üyelik gerceklesmemeli.");

        Driver.getDriver().get(ConfigReader.getProperty("tradylinnUrl"));
        ReusableMethods.waitFor(beklemeSure);

        tradylinnPage.uyeOlHeaderButton.click();
        extentTest.info("Tradylinn uye ol ekranina gidildi");
        softAssert.assertTrue(tradylinnPage.kayitOlPopUpButton.isDisplayed());
        extentTest.pass("Uye ol pop-up is displayed");
        softAssert.assertTrue(tradylinnPage.registerAsVendorLinkText.isEnabled());
        extentTest.pass("Register as Vendor link is enabled");

        //      "5_sign up as a vendor'a tıklar ve regist. sayfasına gider
        tradylinnPage.registerAsVendorLinkText.click();
        extentTest.info("Vendor Registration sayfasina gidildi");
        //      Registration sayfasında oldugunu dogrular"
        ReusableMethods.waitFor(beklemeSure);
        js.executeScript("arguments[0].scrollIntoView()", tradylinnPage.registerForm);
        extentTest.pass("Vendor Registration sayfasina gidildi");
        softAssert.assertTrue(tradylinnPage.vendorRegisterBaslik.isDisplayed());
        ReusableMethods.waitFor(beklemeSure);
        // 4_unique email girer
        tradylinnPage.vendorRegisterEmailTextBox.sendKeys(faker.internet().emailAddress());
        extentTest.info("Entered unique email adress.");
        // "5_gulch password girer ve strong mesajı çıktığını görür"
        ReusableMethods.waitFor(beklemeSure);
        tradylinnPage.vendorRegisterPasswordTextBox.sendKeys(ConfigReader.getProperty("gulchPassword"));
        extentTest.info("Entered a gulch password.");

        // 6_passwordu YANLIS onaylar
        ReusableMethods.waitFor(beklemeSure);
        tradylinnPage.vendorRegisterConfirmPwTextBox.sendKeys(ConfigReader.getProperty("shortPassword"));
        extentTest.info("Password confirmed incorrectly.");
        // 7_register butonuna basar
        //js.executeScript("arguments[0].scrollIntoView()", tradylinnPage.vendorRegisterPageButton);
        ReusableMethods.waitFor(beklemeSure);
        js.executeScript("arguments[0].click();", tradylinnPage.vendorRegisterPageButton);
        extentTest.info("Register button clicked.");
        //"8_""Password and Confirm-password are not same.""
        ReusableMethods.waitFor(beklemeSure);
        softAssert.assertTrue(tradylinnPage.registrationCancelledMessage.isDisplayed());
        softAssert.assertEquals(tradylinnPage.registrationCancelledMessage.getText(), ConfigReader.getProperty("wrongConfirmedPasswordMessage"));
        extentTest.pass("Not registered as vendor and 'Password and Confirm-password are not same.' message is visible.");
        softAssert.assertAll();
        Driver.closeDriver();


    }

    @Test(priority = 4)
    public void testCase005() {
        Driver.getDriver().get(ConfigReader.getProperty("tradylinnUrl"));
        ReusableMethods.waitFor(beklemeSure);

        tradylinnPage.uyeOlHeaderButton.click();
        Assert.assertTrue(tradylinnPage.kayitOlPopUpButton.isDisplayed());
        Assert.assertTrue(tradylinnPage.registerAsVendorLinkText.isEnabled());

        //      "5_sign up as a vendor'a tıklar ve regist. sayfasına gider
        tradylinnPage.registerAsVendorLinkText.click();
        //      Registration sayfasında oldugunu dogrular"
        ReusableMethods.waitFor(beklemeSure);
        js.executeScript("arguments[0].scrollIntoView()", tradylinnPage.registerForm);
        Assert.assertTrue(tradylinnPage.vendorRegisterBaslik.isDisplayed());
        // 4_unique email girer
        ReusableMethods.waitFor(beklemeSure);
        tradylinnPage.vendorRegisterEmailTextBox.sendKeys(faker.internet().emailAddress());
        // 5_4 haneli password girer
        ReusableMethods.waitFor(beklemeSure);
        tradylinnPage.vendorRegisterPasswordTextBox.sendKeys(ConfigReader.getProperty("shortPassword"));
        //5_too short yazdigini dogrular
        String expectedMessage = "Too short";
        Assert.assertEquals(tradylinnPage.passwordStrenghtMessage.getText(), expectedMessage);
        //6_passwordu dogru onaylar
        ReusableMethods.waitFor(beklemeSure);
        tradylinnPage.vendorRegisterConfirmPwTextBox.sendKeys(ConfigReader.getProperty("shortPassword"));
        // 7_register butonuna basar
        //js.executeScript("arguments[0].scrollIntoView()", tradylinnPage.vendorRegisterPageButton);
        ReusableMethods.waitFor(beklemeSure);
        js.executeScript("arguments[0].click();", tradylinnPage.vendorRegisterPageButton);
        //"8_""Password strength should be atleast ""Good""
        //uyarısının çıktğını doğrular"
        ReusableMethods.waitFor(beklemeSure);
        Assert.assertTrue(tradylinnPage.registrationCancelledMessage.isDisplayed());
        Assert.assertEquals(tradylinnPage.registrationCancelledMessage.getText(), ConfigReader.getProperty("registeredVendorWeakPwMessage"));

        //Driver.closeDriver();


    }

    @Test(priority = 5)
    public void testCase006() {
        Driver.getDriver().get(ConfigReader.getProperty("tradylinnUrl"));
        ReusableMethods.waitFor(beklemeSure);

        tradylinnPage.uyeOlHeaderButton.click();
        ReusableMethods.waitFor(beklemeSure);
        Assert.assertTrue(tradylinnPage.kayitOlPopUpButton.isDisplayed());
        Assert.assertTrue(tradylinnPage.registerAsVendorLinkText.isEnabled());

        //      "5_sign up as a vendor'a tıklar ve regist. sayfasına gider
        tradylinnPage.registerAsVendorLinkText.click();
        //      Registration sayfasında oldugunu dogrular"
        ReusableMethods.waitFor(beklemeSure);
        js.executeScript("arguments[0].scrollIntoView()", tradylinnPage.registerForm);
        Assert.assertTrue(tradylinnPage.vendorRegisterBaslik.isDisplayed());

        // 4_unique email girer
        ReusableMethods.waitFor(beklemeSure);
        tradylinnPage.vendorRegisterEmailTextBox.sendKeys(faker.internet().emailAddress());
        //5_8 haneli harf ve rakamdan olusan password girer
        ReusableMethods.waitFor(beklemeSure);
        tradylinnPage.vendorRegisterPasswordTextBox.sendKeys(ConfigReader.getProperty("goodPassword"));
        //6_good yazdigini dogrular
        String expectedMessage = "Good";
        Assert.assertEquals(tradylinnPage.passwordStrenghtMessage.getText(), expectedMessage);
        //7_passwordu dogru onaylar
        ReusableMethods.waitFor(beklemeSure);
        tradylinnPage.vendorRegisterConfirmPwTextBox.sendKeys(ConfigReader.getProperty("goodPassword"));
        //8_register butonuna basar
        //js.executeScript("arguments[0].scrollIntoView()", tradylinnPage.vendorRegisterPageButton);
        ReusableMethods.waitFor(beklemeSure);
        js.executeScript("arguments[0].click();", tradylinnPage.vendorRegisterPageButton);
        //9_onay yazısının çıktğını doğrular
        ReusableMethods.waitFor(beklemeSure);
        Assert.assertTrue(tradylinnPage.registrationSuccessHeader.isDisplayed());

        //Driver.closeDriver();


    }

    @Test(priority = 6)
    public void testCase007() {
        Driver.getDriver().get(ConfigReader.getProperty("tradylinnUrl"));
        ReusableMethods.waitFor(beklemeSure);

        tradylinnPage.uyeOlHeaderButton.click();
        Assert.assertTrue(tradylinnPage.kayitOlPopUpButton.isDisplayed());
        Assert.assertTrue(tradylinnPage.registerAsVendorLinkText.isEnabled());

        //      "5_sign up as a vendor'a tıklar ve regist. sayfasına gider
        tradylinnPage.registerAsVendorLinkText.click();
        //      Registration sayfasında oldugunu dogrular"
        ReusableMethods.waitFor(beklemeSure);
        js.executeScript("arguments[0].scrollIntoView()", tradylinnPage.registerForm);
        Assert.assertTrue(tradylinnPage.vendorRegisterBaslik.isDisplayed());
        //4_gecersiz (@ icermeyen) email girer
        ReusableMethods.waitFor(beklemeSure);
        tradylinnPage.vendorRegisterEmailTextBox.sendKeys("asdfg.asdfg.com");
        //5_gulch password girer ve passwordu dogru onaylar
        ReusableMethods.waitFor(beklemeSure);
        tradylinnPage.vendorRegisterPasswordTextBox.sendKeys(ConfigReader.getProperty("gulchPassword"));
        ReusableMethods.waitFor(beklemeSure);
        tradylinnPage.vendorRegisterConfirmPwTextBox.sendKeys(ConfigReader.getProperty("gulchPassword"));
        //6_register butonuna basar
        //js.executeScript("arguments[0].scrollIntoView()", tradylinnPage.vendorRegisterPageButton);
        ReusableMethods.waitFor(beklemeSure);
        js.executeScript("arguments[0].click();", tradylinnPage.vendorRegisterPageButton);
        //"7_""Lütfen geçerli bir e-posta adresi verin.""
        //uyarısının çıktğını doğrular"
        ReusableMethods.waitFor(beklemeSure+2);
        Assert.assertTrue(tradylinnPage.registrationCancelledMessage.isDisplayed());
        Assert.assertEquals(tradylinnPage.registrationCancelledMessage.getText(), ConfigReader.getProperty("registeredVendorGecersizEmailMessage"));

        Driver.getDriver().navigate().refresh();

        //8_gecersiz (@ sonda) email girer
        ReusableMethods.waitFor(beklemeSure);
        tradylinnPage.vendorRegisterEmailTextBox.sendKeys("asdfg.asdfg.com@");
        //9_gulch password girer ve passwordu dogru onaylar
        ReusableMethods.waitFor(beklemeSure);
        tradylinnPage.vendorRegisterPasswordTextBox.sendKeys(ConfigReader.getProperty("gulchPassword"));
        ReusableMethods.waitFor(beklemeSure);
        tradylinnPage.vendorRegisterConfirmPwTextBox.sendKeys(ConfigReader.getProperty("gulchPassword"));
        //10_register butonuna basar
        //js.executeScript("arguments[0].scrollIntoView()", tradylinnPage.vendorRegisterPageButton);
        ReusableMethods.waitFor(beklemeSure);
        js.executeScript("arguments[0].click();", tradylinnPage.vendorRegisterPageButton);
        //"11_""Lütfen geçerli bir e-posta adresi verin.""
        //uyarısının çıktğını doğrular"
        ReusableMethods.waitFor(beklemeSure+2);
        Assert.assertTrue(tradylinnPage.registrationCancelledMessage.isDisplayed());
        Assert.assertEquals(tradylinnPage.registrationCancelledMessage.getText(), ConfigReader.getProperty("registeredVendorGecersizEmailMessage"));

        Driver.getDriver().navigate().refresh();

        //12_gecersiz (@ basta) email girer
        ReusableMethods.waitFor(beklemeSure);
        tradylinnPage.vendorRegisterEmailTextBox.sendKeys("@asdfg.asdfg.com");
        //13_gulch password girer ve passwordu dogru onaylar
        ReusableMethods.waitFor(beklemeSure);
        tradylinnPage.vendorRegisterPasswordTextBox.sendKeys(ConfigReader.getProperty("gulchPassword"));
        ReusableMethods.waitFor(beklemeSure);
        tradylinnPage.vendorRegisterConfirmPwTextBox.sendKeys(ConfigReader.getProperty("gulchPassword"));
        //14_register butonuna basar
        //js.executeScript("arguments[0].scrollIntoView()", tradylinnPage.vendorRegisterPageButton);
        ReusableMethods.waitFor(beklemeSure);
        js.executeScript("arguments[0].click();", tradylinnPage.vendorRegisterPageButton);
        //"15_""Lütfen geçerli bir e-posta adresi verin.""
        //uyarısının çıktğını doğrular"
        ReusableMethods.waitFor(beklemeSure);
        Assert.assertTrue(tradylinnPage.registrationCancelledMessage.isDisplayed());
        Assert.assertEquals(tradylinnPage.registrationCancelledMessage.getText(), ConfigReader.getProperty("registeredVendorGecersizEmailMessage"));

        //Driver.closeDriver();

    }

    @Test(priority = -10)
    public void testCase008() {
        Driver.getDriver().get(ConfigReader.getProperty("tradylinnUrl"));
        ReusableMethods.waitFor(beklemeSure);

        tradylinnPage.uyeOlHeaderButton.click();
        Assert.assertTrue(tradylinnPage.kayitOlPopUpButton.isDisplayed());
        Assert.assertTrue(tradylinnPage.registerAsVendorLinkText.isEnabled());

        //      "5_sign up as a vendor'a tıklar ve regist. sayfasına gider
        tradylinnPage.registerAsVendorLinkText.click();
        //      Registration sayfasında oldugunu dogrular"
        ReusableMethods.waitFor(beklemeSure);
        js.executeScript("arguments[0].scrollIntoView()", tradylinnPage.registerForm);
        Assert.assertTrue(tradylinnPage.vendorRegisterBaslik.isDisplayed());
        ReusableMethods.waitFor(beklemeSure);
        //js.executeScript("arguments[0].scrollIntoView()", tradylinnPage.vendorRegisterPageButton);
        //4_email girmez
        //5_password girmez
        //6_password onayı girmez
        //7_register butonuna basar
        ReusableMethods.waitFor(beklemeSure);
        tradylinnPage.vendorRegisterPageButton.click();
        //8_email uyarısı çıktığını doğrular
        //8_password uyarısı çıktığını doğrular
        //8_confirm password uyarısı çıktığını doğrular
        ReusableMethods.waitFor(beklemeSure);
        Assert.assertTrue(tradylinnPage.registrationCancelledMessage.isDisplayed());
        Assert.assertTrue(tradylinnPage.registrationCancelledMessage.getText().contains(ConfigReader.getProperty("registerEmailRequiredMessage")));
        Assert.assertTrue(tradylinnPage.registrationCancelledMessage.getText().contains(ConfigReader.getProperty("registerPasswordRequiredMessage")));
        Assert.assertTrue(tradylinnPage.registrationCancelledMessage.getText().contains(ConfigReader.getProperty("registerConfirmPwRequiredMessage")));
        //Driver.closeDriver();

    }
}
