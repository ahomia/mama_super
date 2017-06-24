package tests;

import model.Account;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by axomia on 24.06.2017.
 */
public class CreateNewAccountTest extends TestBase {
      public final static Account  account=
            new Account().withTaxId(RandomStringUtils.randomNumeric(5)).withFirstname(RandomStringUtils.randomAlphabetic(5))
                    .withLastname(RandomStringUtils.randomAlphabetic(5)).withAddress1(RandomStringUtils.randomAlphanumeric(4))
                    .withPostcode(RandomStringUtils.randomNumeric(5)).withCity(RandomStringUtils.randomAlphabetic(5))
                    .withPhone(RandomStringUtils.randomNumeric(9))
                    .withEmail("mama"+RandomStringUtils.randomNumeric(6)+"@mail.ru")
                    .withPassword(RandomStringUtils.randomNumeric(6)+RandomStringUtils.randomNumeric(9));
    @Before
    public void init()  {
        app.init();
        }



@Test
    public void createNewAccountTest(){
        app.shop().goTotheNewAccountForm();
        app.shop().fillNewAccount(account);
        app.shop().logout();
        app.shop().wait5();
        app.shop().login(account.getEmail(),account.getPassword());
        app.shop().wait5();
        app.shop().logout();

}

@After
  public void stop() {
     app.stop();
    }

}
