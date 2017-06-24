package tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.w3c.dom.css.RGBColor;

import java.util.List;

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
        //Проверка что цвет серый
        String regulerColorOnGeneralPage=app.shop().duckRegularColor(duckProduct);
        List<Integer> rgbList=app.shop().rgbList(regulerColorOnGeneralPage);
        Assert.assertEquals(rgbList.get(0),rgbList.get(1));
        Assert.assertEquals(rgbList.get(1),rgbList.get(2));
        //проверка что надпись зачеркнута
        String regulerStyleOnGeneralPage=app.shop().duckRegularLine(duckProduct);
        Assert.assertEquals("line-through",regulerStyleOnGeneralPage);
        //проверка что аукционная цена красная
        String campaningColorGeneralPade=app.shop().duckCampaignColor(duckProduct);
        List<Integer> rgbCampaningListonGeneralPage=app.shop().rgbList(campaningColorGeneralPade);
        Assert.assertTrue(rgbCampaningListonGeneralPage.get(1)==0&& rgbCampaningListonGeneralPage.get(2)==0);
        //Проверка что цена жирная
        String campaningsPriceBold=app.shop().duckCampaignBold(duckProduct);
        Assert.assertEquals("bold",campaningsPriceBold);
        //геттим размеры
        List<Integer> sizeCampeningGeneralPage=app.shop().duckCampaignSize(duckProduct);
        List<Integer> sizeRegularGeneralPage=app.shop().duckRegularSize(duckProduct);
        //Проверяем что размер ацкционный больше чем решулярный
        Assert.assertTrue(sizeCampeningGeneralPage.get(0)>sizeRegularGeneralPage.get(0)&&
                sizeCampeningGeneralPage.get(1)>sizeRegularGeneralPage.get(1));
        //переход на страницу продукта
        app.shop().click(duckProduct);
        String regularPriceOnProductPage=app.shop().duckRegularPrice();
        String campaingPriceOnProductPage=app.shop().duckCampaignPrice();
        //Проверка что цвет серый
        String regulerColorOnProductPage=app.shop().duckRegularColor();
        List<Integer> rgbProductList=app.shop().rgbList(regulerColorOnProductPage);
        Assert.assertEquals(rgbList.get(0),rgbList.get(1));
        Assert.assertEquals(rgbList.get(1),rgbList.get(2));
        //проверка что надпись зачеркнута
        String regulerStyleOnProductPage=app.shop().duckRegularLine();
        Assert.assertEquals("line-through",regulerStyleOnGeneralPage);
        //проверка,что цена на главной странице и на странице продукта совпадают
        Assert.assertEquals(regularPriceOnGeneralPage, regularPriceOnProductPage);
        Assert.assertEquals(campaingPriceOnGeneralPage,campaingPriceOnProductPage);
        //проверка что аукционная цена красная
        String campaningColorProductPade=app.shop().duckCampaignColor();
        List<Integer> rgbCampaningListonProducPage=app.shop().rgbList(campaningColorProductPade);
        Assert.assertTrue(rgbCampaningListonProducPage.get(1)==0&&rgbCampaningListonProducPage.get(2)==0);
        //Проверка что цена жирная
        String campaningsPriceBodOnProductPage=app.shop().duckCampaignBold();
        Assert.assertEquals("bold",campaningsPriceBodOnProductPage);
        //геттим размеры
        List<Integer> sizeCampeningProductPage=app.shop().duckCampaignSize();
        List<Integer> sizeRegularProductPage=app.shop().duckRegularSize();
        //Проверяем что размер ацкционный больше чем решулярный
        Assert.assertTrue(sizeCampeningProductPage.get(0)>sizeRegularProductPage.get(0)&&
                sizeCampeningProductPage.get(1)>sizeRegularProductPage.get(1));
    }

    @After
    public void stop() {
        app.stop();
    }
}
