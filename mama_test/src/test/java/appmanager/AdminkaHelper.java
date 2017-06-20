package appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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
}
