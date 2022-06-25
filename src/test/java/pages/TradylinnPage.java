package pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.Arrays;
import java.util.List;
public class TradylinnPage {
public TradylinnPage(){PageFactory.initElements(Driver.getDriver(),this);}


    //11-30 JASMINA
    @FindBy(linkText="Hesabım") public WebElement hesabimlinktext;
    @FindBy(xpath = "//input[@id='username']") public WebElement usernameBox;
    @FindBy(xpath = "//input[@id='password']") public WebElement passBox;
    @FindBy(xpath = "//button[@name='login']") public WebElement signInLoginButton;
    @FindBy(linkText = "Store Manager") public WebElement storeManagerButton;
    @FindBy(xpath = "(//span[@class='text'])[4]") public WebElement products;
    @FindBy(xpath = "//span[text()='Yeni ekle']") public WebElement addNewProduct;
    @FindBy(xpath = "(//p[@class='wcfm_title wcfm_full_ele'])[2]") public WebElement productBrandsHead;
    @FindBy(xpath = "//strong[text()='Manage Stock?']") public WebElement manageStockHead;
    @FindBy(xpath = "//input[@id='manage_stock']") public WebElement manageStockCheckbox;
    @FindBy(xpath = "//strong[text()='Stock Qty']") public WebElement stockQtyHead;
    @FindBy(xpath = "//input[@id='stock_qty']") public WebElement stockQtytextbox;
    @FindBy(xpath = "//strong[text()='Allow Backorders?']") public WebElement allowBackordersHead;
    @FindBy(xpath = "//select[@id='backorders']") public WebElement backordersDropdown;



    //31-60 AKIF





























    //61-90 EVREN
    @FindBy(xpath = "(//*[@type='submit'])[2]") public WebElement girisYapButonu;
    @FindBy(xpath = "(//*[text()='Siparişler'])[2]") public WebElement siparislerButonu;
    @FindBy(xpath = "(//*[text()='Hesabım'])[2]") public WebElement hesabimText;
    @FindBy(xpath = "(//*[text()='Siparişler'])[3]") public WebElement siparislerText;
    @FindBy(xpath = "//a[@class='woocommerce-Button button btn btn-link btn-underline btn-icon-right']")
    public WebElement urunlereGozAtButtonu;
    @FindBy(xpath = "//*[text()='Mağaza']") public WebElement magazaText;
    @FindBy(xpath = "//*[@class='btn-product-icon product_type_simple add_to_cart_button ajax_add_to_cart']")
    public List<WebElement> sepeteEkle;
    @FindBy(xpath = "(//*[@class='cart-count'])[1]") public WebElement sepet;
    @FindBy(xpath = "//*[@class='widget_shopping_cart_content']") public WebElement sepetVisible;
    @FindBy(xpath = "//a[@class='button wc-forward']") public WebElement sepetiGoruntuleButton;
    @FindBy(xpath = "//a[@class='checkout-button button alt wc-forward']") public WebElement odemeSayfasiButton;
    @FindBy(xpath = "//h3[contains(text(),'Fatura detayları')]") public WebElement faturaDetaylari;



















    //91-115 AYHAN
























    //116-140 ALI























    //140-164 MELEK
























    //165-189 MUSTAFA
























    //190-214 RAMAZAN
//ososososo























    //215-239 RAMAZAN
























    //240-   SEHER
















}
