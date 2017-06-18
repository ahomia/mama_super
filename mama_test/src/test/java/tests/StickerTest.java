package tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Created by axomia on 18.06.2017.
 */
public class StickerTest extends TestBase {
    @Before
    public void init() throws Exception {
        app.init();
    }


    @Test
    public void StickerTest() {

        List<WebElement> productList = app.shop().productList();
        int productSize = productList.size();
        for (int i = 0; i < productSize; i++) {
            app.shop().areStickerPresent(productList.get(i));
            //System.out.println(app.shop().areStickerPresent(productList.get(i)));
        }

    }

    @After
    public void stop() {
        app.stop();
    }
}
