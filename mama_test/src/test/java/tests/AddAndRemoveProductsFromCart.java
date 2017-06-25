package tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebElement;

/**
 * Created by axomia on 25.06.2017.
 */
public class AddAndRemoveProductsFromCart extends TestBase {
    @Before
    public void init()  {
        app.init();
    }

    @Test
    public void AddAndRemoveProductsFromCart(){
        app.shop().openDuck();
        app.shop().addToCart();
        app.shop().waitForAdditingProduct(1);
        app.shop().goToTheHomePage();
        app.shop().openDuck();
        app.shop().addToCart();
        app.shop().waitForAdditingProduct(2);
        app.shop().goToTheHomePage();
        app.shop().openDuck();
        app.shop().addToCart();
        app.shop().waitForAdditingProduct(3);
        app.shop().goToTheBacket();
        app.shop().deleteProductFromTheCart();
        app.shop().waitForDelletingProduct(2);
        app.shop().deleteProductFromTheCart();
        app.shop().waitForDelletingProduct(1);
        app.shop().deleteProductFromTheCart();
        app.shop().waitForDelletingProduct();


    }


    @After
    public void stop() {

        app.stop();
    }
}
