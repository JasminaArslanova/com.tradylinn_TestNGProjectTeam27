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
        Driver.getDriver().get(ConfigReader.getProperty("trdUrl"));
        trdPage.girisYapButon.click();
        trdPage.emailKutusu.sendKeys(ConfigReader.getProperty("gecerliEmail"));
        trdPage.passwordKutusu.sendKeys(ConfigReader.getProperty("gecerliPassword"));
        trdPage.ikinciGirisYapButonu.click();
        ReusableMethods.waitFor(10);
    }

}

