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

    public int howManyStickerPresent(WebElement element) {
        return howManyElementPresents(element,
                By.xpath(".//div[contains(@class,'sticker')]"));
    }
    public WebElement product(){
        return element(By.xpath("//div[@id='box-campaigns']//li[@class='product column shadow hover-light']"));
    }
    public String duckRegularPrice(WebElement element){
        return element.findElement(By.xpath(".//s[@class='regular-price']")).getAttribute("innerHTML");
    }
    public String duckCampaignPrice(WebElement element){
        return element.findElement(By.xpath(".//strong[@class='campaign-price']")).getAttribute("innerHTML");
    }
    public String duckRegularPrice(){
        return wd.findElement(By.xpath(".//s[@class='regular-price']")).getAttribute("innerHTML");
    }
    public String duckCampaignPrice(){
        return wd.findElement(By.xpath(".//strong[@class='campaign-price']")).getAttribute("innerHTML");
    }
    public String duckRegularColor(WebElement element){
        return element.findElement(By.xpath(".//s[@class='regular-price']")).getCssValue("color");
    }
    public String duckCampaignColor(WebElement element){
        return element.findElement(By.xpath(".//strong[@class='campaign-price']")).getCssValue("color");
    }
    public String duckRegularColor(){
        return wd.findElement(By.xpath(".//s[@class='regular-price']")).getCssValue("color");
    }
    public String duckCampaignColor() {
        return wd.findElement(By.xpath(".//strong[@class='campaign-price']")).getCssValue("color");
    }
}
