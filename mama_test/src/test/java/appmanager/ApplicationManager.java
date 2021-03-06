package appmanager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.BrowserType;

import java.util.concurrent.TimeUnit;

/**
 * Created by axomia on 17.06.2017.
 */
public class ApplicationManager {
    private String browser;
    WebDriver wd;
    private LoginHelper loginHelper;
    private AdminkaHelper adminkaHelper;
    private ShopHelper shopHelper;
    private CartHelper cartHelper;
    private ProductHelper productHelper;

    public ApplicationManager(String browser) {
        this.browser = browser;
    }

    public void initAdmin() {
        if (browser.equals(BrowserType.FIREFOX)) {
            wd = new FirefoxDriver();
        } else if (browser.equals(BrowserType.CHROME)) {
            wd = new ChromeDriver();
        } else if (browser.equals(BrowserType.IE)) {
            wd = new InternetExplorerDriver();
        }

        wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        wd.get("http://localhost/litecart/admin/.");
        loginHelper = new LoginHelper(wd);
        adminkaHelper = new AdminkaHelper(wd);


    }

    public void init() {
        if (browser.equals(BrowserType.FIREFOX)) {
            wd = new FirefoxDriver();
        } else if (browser.equals(BrowserType.CHROME)) {
            wd = new ChromeDriver();
        } else if (browser.equals(BrowserType.IE)) {
            wd = new InternetExplorerDriver();
        }

        wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        wd.get("http://localhost/litecart/en/");
        loginHelper = new LoginHelper(wd);
        adminkaHelper = new AdminkaHelper(wd);
        shopHelper = new ShopHelper(wd);
        productHelper=new ProductHelper(wd);
        cartHelper=new CartHelper(wd);
    }

    public void stop() {
        wd.quit();
    }

    public LoginHelper login() {
        return loginHelper;
    }

    public AdminkaHelper adminka() {
        return adminkaHelper;
    }

    public ShopHelper shop() {
        return shopHelper;
    }
    public CartHelper cart() {
        return cartHelper;
    }
    public ProductHelper product() {
        return productHelper;
    }
}
