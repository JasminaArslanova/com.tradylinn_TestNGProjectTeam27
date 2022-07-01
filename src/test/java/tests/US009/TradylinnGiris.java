package tests.US009;

import pages.TradylinnPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class TradylinnGiris {

    public static void main(String[] args) {
        trdGiris();
    }

    public static void trdGiris() {
        TradylinnPage trdPage= new TradylinnPage();
        Driver.getDriver().get(ConfigReader.getProperty("tradyUrl"));
        trdPage.girisYapButon.click();
        trdPage.emailKutusu.sendKeys(ConfigReader.getProperty("tradyEmail"));
        trdPage.passwordKutusu.sendKeys(ConfigReader.getProperty("tradyPassword"));
        trdPage.ikinciGirisYapButonu.click();
        ReusableMethods.waitFor(10);


    }

}

