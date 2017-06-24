package appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by axomia on 18.06.2017.
 */
public class ShopHelper extends HelperBase {
    public ShopHelper(WebDriver wd) {
        super(wd);
    }
    private Pattern rgba = Pattern.compile("rgba\\((\\d{1,3}), (\\d{1,3}), (\\d{1,3}),.*");

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

    public String duckRegularLine() {
        return wd.findElement(By.xpath(".//s[@class='regular-price']")).getCssValue("text-decoration-line");
    }
    public String duckRegularLine(WebElement element) {
        return element.findElement(By.xpath(".//s[@class='regular-price']")).getCssValue("text-decoration-line");
    }
    public String duckCampaignBold(WebElement element){
        return element.findElement(By.xpath(".//strong[@class='campaign-price']")).getCssValue("font-weight");
    }

    public String duckCampaignBold() {
        return wd.findElement(By.xpath(".//strong[@class='campaign-price']")).getCssValue("font-weight");
    }
    public String duckCampaignColor() {
        return wd.findElement(By.xpath(".//strong[@class='campaign-price']")).getCssValue("color");
    }
    public List<Integer> duckRegularSize() {
        List<Integer> duckRegularSize=new ArrayList<Integer>();
        duckRegularSize.add(wd.findElement(By.xpath(".//s[@class='regular-price']")).getSize().getHeight());
        duckRegularSize.add(wd.findElement(By.xpath(".//s[@class='regular-price']")).getSize().getWidth());
        return duckRegularSize;    }

    public List<Integer> duckRegularSize(WebElement element) {
        List<Integer> duckRegularSize=new ArrayList<Integer>();
        duckRegularSize.add(element.findElement(By.xpath(".//s[@class='regular-price']")).getSize().getHeight());
        duckRegularSize.add(element.findElement(By.xpath(".//s[@class='regular-price']")).getSize().getWidth());
        return duckRegularSize;
    }
    public List<Integer> duckCampaignSize(WebElement element){
        List<Integer> duckCampaignSize=new ArrayList<Integer>();
        duckCampaignSize.add(element.findElement(By.xpath(".//strong[@class='campaign-price']")).getSize().getHeight());
        duckCampaignSize.add(element.findElement(By.xpath(".//strong[@class='campaign-price']")).getSize().getWidth());
        return duckCampaignSize;
    }

    public List<Integer> duckCampaignSize() {
        List<Integer> duckCampaignSize=new ArrayList<Integer>();
        duckCampaignSize.add(wd.findElement(By.xpath(".//strong[@class='campaign-price']")).getSize().getHeight());
        duckCampaignSize.add(wd.findElement(By.xpath(".//strong[@class='campaign-price']")).getSize().getWidth());
        return duckCampaignSize;
    }


    public List<Integer> rgbList(String rgb) {
        Matcher matcher = rgba.matcher(rgb);
        List<Integer> rgbList=new ArrayList<Integer>();
        if (matcher.matches()) {
            rgbList.add(Integer.parseInt(matcher.group(1)));
            rgbList.add(Integer.parseInt(matcher.group(2)));
            rgbList.add(Integer.parseInt(matcher.group(3)));
        }
        return rgbList;

    }
}
