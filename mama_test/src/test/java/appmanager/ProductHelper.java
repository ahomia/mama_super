package appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by axomia on 26.06.2017.
 */
public class ProductHelper extends HelperBase {
    public ProductHelper(WebDriver wd) {
        super(wd);
    }

    public void addToCart() {
        if (areElementPresents(By.cssSelector("div.buy_now td.options"))) {
            selectDropdown(By.cssSelector("select[name='options[Size]']"), "Small");
        }
            click(By.name("add_cart_product"));

    }
}
