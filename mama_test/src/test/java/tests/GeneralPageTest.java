package tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.w3c.dom.css.RGBColor;

/**
 * Created by axomia on 21.06.2017.
 */
public class GeneralPageTest extends TestBase {
    @Before
    public void init() throws Exception {
        app.init();
    }


    @Test
    public void generalPageTest() {
        WebElement duckProduct=app.shop().product();
        String regularPriceOnGeneralPage=app.shop().duckRegularPrice(duckProduct);
        String campaingPriceOnGeneralPage=app.shop().duckCampaignPrice(duckProduct);
        String regulerColorOnGeneralPage=app.shop().duckRegularColor(duckProduct);
        Assert.assertEquals(regulerColorOnGeneralPage,regulerColorOnGeneralPage);
        app.shop().click(duckProduct);
        String regularPriceOnProductPage=app.shop().duckRegularPrice();
        String campaingPriceOnProductPage=app.shop().duckCampaignPrice();
        Assert.assertEquals(regularPriceOnGeneralPage, regularPriceOnProductPage);
        Assert.assertEquals(campaingPriceOnGeneralPage,campaingPriceOnProductPage);
    }

    @After
    public void stop() {
        app.stop();
    }
}
