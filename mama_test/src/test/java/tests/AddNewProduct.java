package tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.File;

/**
 * Created by axomia on 25.06.2017.
 */
public class AddNewProduct extends TestBase{
    @Before
    public void init() {
        app.initAdmin();
        app.login().loginAdminka("admin", "admin");
    }
@Test
public void AddNewProductTest(){
        app.adminka().goToCatalogPage();
        app.adminka().wait5();
        int before=app.adminka().coutOfProduct();
        app.adminka().openNewProductForm();
        app.adminka().wait5();
        app.adminka().fillGeneralForm(new File("src/test/resources/mama.jpg").getAbsolutePath());
        app.adminka().goToInformationTab();
        app.adminka().wait5();
        app.adminka().fillInformationForm();
        app.adminka().goToPriceTab();
        app.adminka().wait5();
        app.adminka().fillPricesForm();
        app.adminka().saveProduct();
        app.adminka().wait5();
        int after=app.adminka().coutOfProduct();
    Assert.assertEquals(before+1,after);
}
    @After
    public void stop() {
        app.stop();
    }
}
