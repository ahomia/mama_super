package appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Created by axomia on 18.06.2017.
 */
public class ShopHelper extends HelperBase {
    public ShopHelper(WebDriver wd) {
        super(wd);
    }

    public List<WebElement> productList() {
        return listOfElements(By.xpath("//li[@class='product column shadow hover-light']"));
    }

    public boolean areStickerPresent(WebElement element) {
        return areElementPresents(element,
                By.xpath("//div[contains(@class,'sticker')]"));
    }
}
