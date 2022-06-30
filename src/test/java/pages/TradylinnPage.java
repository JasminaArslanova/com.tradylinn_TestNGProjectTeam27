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
    //26-60 AKIF
    @FindBy(xpath = "(//i[@class='w-icon-account']) [1]") public WebElement girisYapButon;
    @FindBy(xpath = "//input[@type='text']") public WebElement emailKutusu;
    @FindBy(xpath = "(//input[@type='password']) [1]") public WebElement passwordKutusu;
    @FindBy(xpath = "(//button[@type='submit']) [1]") public WebElement ikinciGirisYapButonu;
    @FindBy(xpath = "(//a[@href=\"https://tradylinn.com/my-account-2/\"])  [1]") public WebElement hesabimLinki;
    @FindBy(xpath = "//a[@href=\"https://tradylinn.com/store-manager/\"]") public WebElement storeManager;
    @FindBy(xpath = "(//a[@class='wcfm_menu_item ']) [3]") public WebElement urunler;
    @FindBy(id = "add_new_product_dashboard") public WebElement yeniEkle;
    @FindBy (xpath = "//input[@id='pro_title']") public WebElement productTitle;
    @FindBy (xpath = "//input[@id='regular_price']") public WebElement fiyat;
    @FindBy (xpath =  "//img[@id='featured_img_display']") public WebElement bigPicture;
    @FindBy (xpath = "//img[@id='gallery_img_gimage_0_display']") public WebElement smallPicture;
    @FindBy (xpath = "(//*[text()='Add to Gallery'])[3]") public WebElement addToGalleryButtonn;
    @FindBy (xpath = "//button[@id='__wp-uploader-id-1']") public WebElement uploadFile;
    @FindBy (xpath = "//button[@id='__wp-uploader-id-4']") public WebElement uploadFile2;
    @FindBy(xpath = "(//button[@role='tab']) [5]") public WebElement dosyaYukleButonu;
    @FindBy (xpath = "(//button[@type='button']) [86]") public WebElement resimSec;
    @FindBy (xpath = "(//li[@aria-label='tornavida']) [2]") public WebElement thumbnail;
    @FindBy (xpath = "(//button[@id='menu-item-browse']) [2]") public WebElement ortamKutuphanesi;
    @FindBy (xpath = "(//button[@type='button']) [148]") public WebElement addToGallery;
    @FindBy (xpath = "//input[@value='235']") public WebElement kategori;
    @FindBy (xpath = "(//input[@type='button']) [11]") public WebElement viewButton;
    @FindBy(xpath = "(//div[@class='page_collapsible_content_holder']) [8]") public WebElement shippingClick;
    @FindBy(xpath = "//input[@id='weight']") public WebElement weight;
    @FindBy(xpath = "//input[@id='length']") public WebElement length;
    @FindBy(xpath = "//input[@id='width']") public WebElement width;
    @FindBy(xpath = "//input[@id='height']") public WebElement height;
    @FindBy(xpath = "//select[@id='_wcfmmp_processing_time']") public WebElement processingTime;
    @FindBy(xpath = "//input[@id='wcfm_products_simple_submit_button']") public WebElement submit;
    @FindBy (xpath = "//div[@class='wcfm-message wcfm-success']") public WebElement kayitBasarili;
    @FindBy (xpath = "//a[@href=\"#tab-additional_information\"]") public WebElement specification;
    @FindBy (xpath = "//tbody//tr") public List <WebElement> specificationList;
    @FindBy(xpath = "(//p[@class='text-uppercase text-center mb-0']) [1]") public WebElement siparisler;
    @FindBy(xpath = "//tbody//tr") public List<WebElement> siparisListesi;
    @FindBy(xpath = "(//p[@class='text-uppercase text-center mb-0']) [2]") public WebElement indirmeler;
    @FindBy (xpath = "//tbody//tr") public List <WebElement> indirmelerListesi;
    @FindBy(xpath = "(//p[@class='text-uppercase text-center mb-0']) [3]") public WebElement adresler;
    @FindBy(xpath = "//div[@class='woocommerce-Addresses addresses row']") public List<WebElement> adreslerListesi;
    @FindBy(xpath = "(//p[@class='text-uppercase text-center mb-0']) [4]") public WebElement hesapDetaylari;
    @FindBy(xpath = "//input[@id='account_first_name']") public WebElement hesapAd;
    @FindBy(xpath = "//input[@id='account_last_name']") public WebElement hesapSoyad;
    @FindBy (xpath = "//input[@id='account_display_name']") public WebElement gorunenAd;
    @FindBy (xpath = "//input[@id='account_email']") public WebElement epostaUpdate;
    @FindBy (xpath = "//button[@id='user_description-html']") public WebElement metinButonu;
    @FindBy (xpath = "//textarea[@id='user_description']") public WebElement metinYazisiGonder;
    @FindBy (xpath = "//input[@id='password_current']") public WebElement currentPassword;
    @FindBy (xpath = "//input[@id='password_1']") public WebElement newPassword;
    @FindBy (xpath = "//input[@id='password_2']") public WebElement againNewPassword;
    @FindBy (xpath = "(//button[@type='submit']) [2]") public WebElement hesapKaydetButonu;
    @FindBy (xpath = "//div[@class=\"woocommerce-notices-wrapper\"])") public WebElement updateSuccess;
    @FindBy(xpath = "//div[@class='woocommerce-message alert alert-simple alert-icon alert-close-top alert-success']") public WebElement  hesapDetaylariDegistiMesaji;
    //78-114 EVREN
    @FindBy(xpath = "(//*[@type='submit'])[2]") public WebElement girisYapButonu;
    @FindBy(xpath = "(//*[text()='Siparişler'])[2]") public WebElement siparislerButonu;
    @FindBy(xpath = "(//*[text()='Hesabım'])[2]") public WebElement hesabimText;
    @FindBy(xpath = "(//*[text()='Siparişler'])[3]") public WebElement siparislerText;
    @FindBy(xpath = "//a[@class='woocommerce-Button button btn btn-link btn-underline btn-icon-right']") public WebElement urunlereGozAtButtonu;
    @FindBy(xpath = "//*[text()='Mağaza']") public WebElement magazaText;
    @FindBy(xpath = "//*[@class='btn-product-icon product_type_simple add_to_cart_button ajax_add_to_cart']") public List<WebElement> sepeteEkle;
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
    @FindBy(xpath = "//p[@class='woocommerce-notice woocommerce-notice--success woocommerce-thankyou-order-received order-success']") public WebElement thankYouVisible;
    @FindBy(xpath = "(//button[@title='Artı'])[1]") public WebElement artiButonu;
    @FindBy(xpath = "//tbody/tr/td[1]/span[1]/bdi[1]") public WebElement artidanSonra;
    @FindBy(xpath = "(//button[normalize-space()='Sepeti Yenile'])[1]") public WebElement yenile;
    @FindBy(xpath = "(//button[@title='Eksi'])[1]") public WebElement eksiButonu;
    @FindBy(xpath = "//tbody/tr[1]/td[1]/a[1]") public WebElement sepettekiUrun;
    @FindBy(xpath = "//tbody/tr[2]/td[1]/a[1]") public WebElement sepettekiIkinciUrun;
    @FindBy(xpath = "//tbody/tr[3]/td[1]/a[1]") public WebElement sepettekiUcuncuUrun;
    @FindBy(xpath = "//tbody/tr[4]/td[1]/a[1]") public WebElement sepettekiDorduncuUrun;
    @FindBy(xpath = "//tbody/tr[5]/td[1]/a[1]") public WebElement sepettekiBesinciUrun;
    @FindBy(xpath = "(//p[@class='stock in-stock'])[1]") public WebElement stokMiktari;
    @FindBy(xpath = "(//input[@id='quantity_62bcf52055470'])[1]") public WebElement urunMiktar;
    @FindBy(xpath = "(//button[normalize-space()='Sepete Ekle'])[1]") public WebElement urunSepeteEkle;
    @FindBy(xpath = "//*[@class='woocommerce-notices-wrapper']") public WebElement urunSepeteEklendiYazisi;
    @FindBy(xpath = "(//div[@class='summary entry-summary'])[1]") public WebElement stokTablosu;
    @FindBy(xpath = "//button[@name='clear_cart']") public WebElement temizle;
    @FindBy(xpath = "//*[text()='Sepetiniz şu anda boş.']") public WebElement sepetBosYazisi;
    //115-140 AYHAN
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








    //141-164 ALI
    @FindBy(xpath = "//a[@class='register inline-type']") public WebElement uyeOlHeaderButton;
    @FindBy(xpath = "//button[@name='register']") public WebElement kayitOlPopUpButton;
    @FindBy(xpath = "//a[@class='register_as_vendor']") public WebElement registerAsVendorLinkText;
    @FindBy(xpath = "//h2[@class='page-title']") public WebElement vendorRegisterBaslik;
    @FindBy(xpath = "//p[@class='user_email wcfm_ele wcfm_title']") public WebElement vendorRegisterEmailText;
    @FindBy(xpath = "//input[@data-required_message='Email: This field is required.']") public WebElement vendorRegisterEmailTextBox;
    @FindBy(xpath = "//p[@class='passoword wcfm_ele wcfm_title']") public WebElement vendorRegisterPasswordText;
    @FindBy(xpath = "//input[@class='wcfm-text wcfm_ele '][2]") public WebElement vendorRegisterPasswordTextBox;
    @FindBy(xpath = "//p[@class='confirm_pwd wcfm_ele wcfm_title']") public WebElement vendorRegisterConfirmPwText;
    @FindBy(xpath = "//input[@class='wcfm-text wcfm_ele '][3]") public WebElement vendorRegisterConfirmPwTextBox;
    @FindBy(xpath = "//input[@class='wcfm_submit_button']") public WebElement vendorRegisterPageButton;
    @FindBy(xpath = "//div[@class='wcfm-message wcfm-error']") public WebElement requiredFieldUyariMesaji;
    @FindBy(xpath = "//h2[@class='wcfm_registration_form_heading']") public WebElement registrationSuccessHeader;
    @FindBy(xpath = "//div[@class='wcfm-message wcfm-error']") public WebElement registrationCancelledMessage;
    @FindBy(xpath = "//div[@id='password_strength']") public WebElement passwordStrenghtMessage;
    @FindBy(xpath = "//div[@class='wcfm-membership-wrapper']") public WebElement registerForm;
    @FindBy (xpath = "(//span[@class='text'])[4]") public WebElement urunlerTextLink;
    @FindBy (id = "wcfm_products_manage_form_attribute_head") public WebElement attributes;
    @FindBy (id = "attributes_value_1") public WebElement ddColor;
    @FindBy (id = "attributes_value_2") public WebElement ddSize;
    @FindBy (id = "attributes_is_active_1") public WebElement attributes_Color;
    @FindBy (id = "attributes_is_active_2") public WebElement attributes_Size;

    //165-189 MELEK
























    //190-214 MUSTAFA
























    //215-239 RAMAZAN
























    //240-265 RAMAZAN
























    //266-   SEHER


}
