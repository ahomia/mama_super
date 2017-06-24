package appmanager;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.util.*;

/**
 * Created by axomia on 17.06.2017.
 */
public class AdminkaHelper extends HelperBase {
    public AdminkaHelper(WebDriver wd) {
        super(wd);
    }

    public boolean areHeaderPresent() {
        return areElementPresents(By.cssSelector("h1"));
    }

    public List<WebElement> menuList() {
        return listOfElements(By.cssSelector("#app-"));
    }

    public List<WebElement> subMenuList() {
        return listOfElements(By.xpath("//li[@id='app-'and @class='selected']/ul/li[contains(@id,'doc')]"));
    }

    public void goTotheContriesPage(){
        click(By.cssSelector("#app- [href='http://localhost/litecart/admin/?app=countries&doc=countries']"));
    }
    public void goTotheGeoZonesPage(){
        click(By.cssSelector("#app- [href='http://localhost/litecart/admin/?app=geo_zones&doc=geo_zones']"));
    }

    public List<WebElement> contriesList(){
        return listOfElements(By.xpath("//tr[@class='row']/td[5]/a"));

    }
    public List<WebElement> timeZonesList(){
        return listOfElements(By.xpath("//tr[@class='row']/td[6]"));

    }
    public List<WebElement> countryTimeZonesList(){
        return listOfElements(By.xpath("//input[contains(@name,'zones') and contains(@name,'name')]"));

    }

    public List<WebElement> geoTimeZonesList(){
        return listOfElements(By.xpath("//select[contains(@name,'zone_code')]/option[@selected='selected']"));

    }

    public List<String> contriesValuesList(List<WebElement> elements){
        List<String> contriesValuesList=new ArrayList<String>();

        for (WebElement element:elements
             ) {
            contriesValuesList.add(element.getText());

        }
        return contriesValuesList;
    }

    public List<Integer> countOfTimeZonesList(List<WebElement> elements){
        List<Integer> countOfTimeZonesList=new ArrayList<Integer>();

        for (WebElement element:elements
                ) {
            countOfTimeZonesList.add(Integer.parseInt(element.getText()));

        }
        return countOfTimeZonesList;
    }
    public void fillPricesForm() {
       type(By.xpath(".//div[@id='tab-prices']//table//input[@type='number']"),RandomStringUtils.randomNumeric(2));
       selectDropdown(By.cssSelector("select[name='purchase_price_currency_code']"),"US Dollars");
        type(By.xpath(".//div[@id='tab-prices']//tr[2]//input[@type='text']"),RandomStringUtils.randomNumeric(2));
        type(By.xpath(".//div[@id='tab-prices']//tr[3]//input[@type='text']"),RandomStringUtils.randomNumeric(2));

    }



    public void fillInformationForm() {
        selectDropdown(By.cssSelector("select[name=manufacturer_id]"),"ACME Corp.");
        type(By.cssSelector("input[name=keywords"),"mama"+ RandomStringUtils.randomNumeric(6));
        type(By.cssSelector("input[name='short_description[en]']"),"mama"+ RandomStringUtils.randomNumeric(6));
        type(By.cssSelector("div.trumbowyg-editor"),"mama"+ RandomStringUtils.randomNumeric(6));
        type(By.cssSelector("input[name='head_title[en]']"),"mama"+ RandomStringUtils.randomNumeric(6));
        type(By.cssSelector("input[name='meta_description[en]']"),"mama"+ RandomStringUtils.randomNumeric(6));

    }

    public void fillGeneralForm(String filePath) {
        click(By.cssSelector("div#tab-general label"));
        type(By.xpath(".//div[@id='tab-general']//tr[2]//span[@class='input-wrapper']/input[@name='name[en]']"),
                "mama"+ RandomStringUtils.randomNumeric(6));
        type(By.xpath(".//div[@id='tab-general']//tr[3]//input[@name='code']"),
                RandomStringUtils.randomNumeric(5) );
        click(By.xpath(".//div[@id='tab-general']//tr[4]//input[@value='1']"));
        customClick(By.cssSelector("select[name=default_category_id]"));
        click(By.cssSelector("div#tab-general input[value='1-3']"));
        type(By.cssSelector("div#tab-general input[name=quantity]"),"5" );
        customClick(By.cssSelector("div#tab-general select[name=quantity_unit_id]"));
        customClick(By.cssSelector("div#tab-general select[name=delivery_status_id]"));
        selectDropdown(By.cssSelector("div#tab-general select[name=sold_out_status_id]"),"Temporary sold out");
        type(By.cssSelector("input[type=file]"),filePath);


    }
    public void goToCatalogPage(){
        click(By.xpath(".//li[@id='app-']/a[span='Catalog']"));
    }

    public void openNewProductForm(){
        click(By.cssSelector(".button[href='http://localhost/litecart/admin/?category_id=0&app=catalog&doc=edit_product']"));
    }

    public void goToInformationTab(){
        click(By.cssSelector("a[href='#tab-information']"));
    }
    public void goToPriceTab(){
        click(By.cssSelector("a[href='#tab-prices']"));
    }
    public void saveProduct(){
        click(By.cssSelector("button[name=save]"));
    }
    public int coutOfProduct(){
        return wd.findElements(By.cssSelector(".row")).size();
    }
}
