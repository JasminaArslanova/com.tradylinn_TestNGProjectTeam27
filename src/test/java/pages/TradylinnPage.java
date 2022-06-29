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
    @FindBy(xpath = "//span[contains(text(),'Giriş Yap')]") public static WebElement girisButonu;
    @FindBy(xpath = "//*[@id='wcfm-products']/tbody/tr[2]/td[1]/input") public WebElement urunSecmeCheckBox;
    @FindBy(xpath = "(//a[contains(text(),'Hesabım')])[1]") public static WebElement Hesabim;
    @FindBy(xpath = "//*[@id='wcfm-products']/tbody/tr[2]/td[12]/a[5]/span")  public WebElement duzenleButonu;
    @FindBy (xpath = " //*[@id=\"wcfm-products\"]/tbody/tr[2]/td[8]/a") public WebElement actualKategori;
    @FindBy(xpath = "//*[@id='product_cats_checklist']/li[1]/input") public WebElement besinTakviyeleri;
    @FindBy(xpath = "//*[@id='product_cats_checklist']/li[3]/input") public WebElement cokSatanlar;
    @FindBy(xpath = "//*[@id='product_cats_checklist']/li[5]/input") public WebElement eleElo;
    @FindBy(xpath = "//*[@id='product_cats_checklist']/li[6]/input") public WebElement evYasam;
    @FindBy(xpath = "//*[@id='product_cats_checklist']/li[9]/input") public WebElement indirimliUrun;
    @FindBy(xpath = "//*[@id='product_cats_checklist']/li[10]/input") public WebElement kiMuFi;
    @FindBy(xpath = "//*[@id='product_cats_checklist']/li[11]/input") public WebElement koKi;
    @FindBy(xpath = "//*[@id='product_cats_checklist']/li[13]/input") public WebElement modaGiyim;
    @FindBy(xpath = "//*[@id='product_cats_checklist']/li[16]/input") public WebElement oyuncak;
    @FindBy(xpath = "//*[@id='product_cats_checklist']/li[19]/input") public WebElement takiAks;
    @FindBy(xpath = "//*[@id='product_cats_checklist']/li[21]/input") public WebElement yeniUrun;
    @FindBy (xpath = "//input[@name='submit-data']") public WebElement submitButonu;







    //116-140 ALI
    @FindBy(xpath = "//*[text()='Üye Ol']") public WebElement uyeOlHeaderButton;
    @FindBy(xpath = "//button[@name='register']") public WebElement kayitOlPopUpButton;
    @FindBy(xpath = "//a[@class='register_as_vendor']") public WebElement registerAsVendorLinkText;
    @FindBy(xpath = "//h2[@class='page-title']") public WebElement vendorRegisterBaslik;
    @FindBy(xpath = "//p[@class='user_email wcfm_ele wcfm_title']") public WebElement vendorRegisterEmailText;
    @FindBy(xpath = "//input[@id='user_email']") public WebElement vendorRegisterEmailTextBox;
    @FindBy(xpath = "//p[@class='passoword wcfm_ele wcfm_title']") public WebElement vendorRegisterPasswordText;
    @FindBy(xpath = "//input[@id='passoword']") public WebElement vendorRegisterPasswordTextBox;
    @FindBy(xpath = "//p[@class='confirm_pwd wcfm_ele wcfm_title']") public WebElement vendorRegisterConfirmPwText;
    @FindBy(xpath = "//input[@id='confirm_pwd']") public WebElement vendorRegisterConfirmPwTextBox;
    @FindBy(xpath = "//input[@id='wcfm_membership_register_button']") public WebElement vendorRegisterPageButton;
    @FindBy(xpath = "//div[@class='wcfm-message wcfm-error']") public WebElement requiredFieldUyariMesaji;
    @FindBy(xpath = "//h2[@class='wcfm_registration_form_heading']") public WebElement registrationSuccessHeader;










    //140-164 MELEK
























    //165-189 MUSTAFA
























    //190-214 RAMAZAN
//ososososo























    //215-239 RAMAZAN
























    //240-   SEHER
















}
