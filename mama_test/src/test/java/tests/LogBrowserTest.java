package tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.logging.LogEntry;

import java.util.List;

/**
 * Created by axomia on 27.06.2017.
 */
public class LogBrowserTest extends TestBase {
    @Before
    public void init(){
        app.initAdmin();
        app.login().loginAdminka("admin", "admin");    }
    @Test
    public void logBrowserTest(){
        app.adminka().goToCatalogPage();
        app.adminka().openCategoryWithProducts();
        List<WebElement> products=app.adminka().listOfProduct();
        for (int i=0;i<products.size();i++){
            app.adminka().click(products.get(i));
            List<LogEntry> logs=app.adminka().logsList();
            Assert.assertTrue(logs.size() ==0);
            app.adminka().back();
            products=app.adminka().listOfProduct();
        }

    }
    @After
    public void stop(){
        app.stop();
    }
}
