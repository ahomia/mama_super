package appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.openqa.selenium.support.ui.ExpectedConditions.numberOfElementsToBe;
import static org.openqa.selenium.support.ui.ExpectedConditions.stalenessOf;
import static org.openqa.selenium.support.ui.ExpectedConditions.textToBePresentInElementLocated;

/**
 * Created by axomia on 26.06.2017.
 */
public class CartHelper extends HelperBase {
    public CartHelper(WebDriver wd) {
        super(wd);
    }

    public void waitForAdditingProduct(Integer count){
        wait.until(textToBePresentInElementLocated((By.cssSelector("div#cart span.quantity")), String.valueOf(count)));
    }
    public void deleteProductFromTheCart(){
        click(By.cssSelector("ul.items button[name=remove_cart_item]"));
    }
    public void waitForDelletingProduct(Integer count){
        if (count>0){
            wait.until(numberOfElementsToBe(By.cssSelector("tr td[style='text-align: center;']"), count));

        }else {
            wait.until(stalenessOf(wd.findElement(By.id("box-checkout-summary"))));
        }
    }
}
