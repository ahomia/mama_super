package appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by axomia on 17.06.2017.
 */
public class LoginHelper extends HelperBase {
    public LoginHelper(WebDriver wd) {

        super(wd);
    }


    public void loginAdminka(String username, String password) {
        type(By.name("username"), username);
        type(By.name("password"), password);
        click(By.name("login"));
    }

}
