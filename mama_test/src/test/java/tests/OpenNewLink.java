package tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Created by axomia on 25.06.2017.
 */
public class OpenNewLink extends TestBase {
    @Before
    public void init()  {
        app.initAdmin();
        app.login().loginAdminka("admin", "admin");
    }

    @Test
    public void openLinkTest(){

        app.adminka().goTotheContriesPage();
        app.adminka().wait5();
        app.adminka().openAnyContry();
        List<WebElement> externalLink=app.adminka().externalLink();
        for(int i=0;i<externalLink.size();i++){
            app.adminka().openExternalLinkAndClose(externalLink.get(i));
        }
    }
    @After
    public void stop() {
        app.stop();
    }
}
