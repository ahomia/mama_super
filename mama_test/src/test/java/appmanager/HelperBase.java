package appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.*;
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


    public List<WebElement> listOfElements(By locator) {
        return wd.findElements(locator);
    }
    public WebElement element(By locator) {
        return wd.findElement(locator);
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
    protected int howManyElementPresents(WebElement element, By locator) {
        return element.findElements(locator).size();
    }

    public List<String> sortedList(List<String> lists){
        List<String> listByOrder=new ArrayList<String>();
        for (String list:lists
             ) {
            listByOrder.add(list);
        }
        Arrays.sort(new List[]{listByOrder});
        return listByOrder;
    }
    public void type(By locator, String text) {
        click(locator);
        if (text != null) {
            WebElement element = wd.findElement(locator);
            String existingText = element.getAttribute("value");
            if (!text.equals(existingText)) {
                element.clear();
                element.sendKeys(text);
            }
        }
    }
    public void selectDropdown(By locator, String text) {
        if (isElementPresent(locator)) {
            new Select(wd.findElement(locator)).selectByVisibleText(text);
        }
    }
    protected boolean isElementPresent(By locator) {
        try {
            wd.findElement(locator);
            return true;
        } catch (NoSuchElementException ex) {
            return false;
        }
    }
    public void customClick(By locator){
        new Actions(wd).moveToElement(wd.findElement(locator)).doubleClick().perform();
    }
    public ExpectedCondition<String> anyWindowOtherThan(Set<String> existingWindows) {
        return driver -> {
            Set<String> handles = driver.getWindowHandles();
            handles.removeAll(existingWindows);
            return handles.size() > 0 ? handles.iterator().next() : null;
        };
    }
    public void openExternalLinkAndClose(WebElement element) {
        String originalWindow = wd.getWindowHandle();
        Set<String> existingWindows = wd.getWindowHandles();
        click(element);
        WebDriverWait wait = new WebDriverWait(wd, 15);
        String newWindow = wait.until(anyWindowOtherThan(existingWindows));
        wd.switchTo().window(newWindow);
        wd.close();
        wd.switchTo().window(originalWindow);
    }
    public List<LogEntry> logsList(){
        return wd.manage().logs().get("browser").getAll();
    }
}
