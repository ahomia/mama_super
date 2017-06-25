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
        for (int i=1;i<=3;i++){
            app.shop().openDuck();
            app.product().addToCart();
            app.cart().waitForAdditingProduct(i);
            app.shop().goToTheHomePage();
        }

        app.shop().goToTheBacket();
        for (int i=2;i>=0;i--) {
            app.cart().deleteProductFromTheCart();
            app.cart().waitForDelletingProduct(i);
        }


    }


    @After
    public void stop() {

        //app.stop();
    }
}
