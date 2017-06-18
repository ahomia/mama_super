package appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by axomia on 17.06.2017.
 */
public class HelperBase {
    public WebDriver wd;
    protected WebDriverWait wait;

    public HelperBase(WebDriver wd) {
        this.wd = wd;
        this.wait = new WebDriverWait(wd, 10);
    }


    public void click(By locator) {

        wd.findElement(locator).click();
    }

    public void click(WebElement element) {
        element.click();
    }

    public void type(By locator, String text) {
        click(locator);
        wd.findElement(locator).clear();
        wd.findElement(locator).sendKeys(text);
    }

    public List<WebElement> listOfElements(By locator) {
        return wd.findElements(locator);
    }

    public List<WebElement> listOfElements(By locator, WebElement element) {
        return element.findElements(locator);
    }

    public void back() {
        wd.navigate().back();
    }

    public void wait5() {
        wd.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    protected boolean areElementPresents(By locator) {
        return wd.findElements(locator).size() > 0;
    }

    protected boolean areElementPresents(WebElement element, By locator) {
        return element.findElements(locator).size() > 0;
    }
}
