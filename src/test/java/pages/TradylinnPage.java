package pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;
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
    @FindBy(xpath = "//ul[@id='product_brand']") public List<WebElement> productBrandsList;










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
    @FindBy(xpath = "//input[@id='billing_first_name']") public WebElement firstName;
    @FindBy(xpath = "//input[@id='wcfmmp_user_location']") public WebElement teslimatAdresi;
    @FindBy(xpath = "//input[@id='payment_method_cod']") public WebElement teslimatYontemi;
    @FindBy(xpath = "//button[@id='place_order']") public WebElement siparisiOnayla;
    @FindBy(xpath = "//*[@class='woocommerce-MyAccount-content col-md-9 pt-2']") public WebElement alisVeriseDevam;
    @FindBy(xpath = "//*[text()='Alışverişe Devam Et']") public WebElement alisVeriseDevamButon;
    @FindBy(xpath = "//*[@class='dismissButton']") public WebElement googleOk;
    @FindBy(xpath = "//p[@class='woocommerce-notice woocommerce-notice--success woocommerce-thankyou-order-received order-success']")
    public WebElement thankYouVisible;





















    //91-115 AYHAN
























    //116-140 ALI























    //140-164 MELEK
























    //165-189 MUSTAFA
























    //190-214 RAMAZAN
//ososososo























    //215-239 RAMAZAN
























    //240-   SEHER
















}
