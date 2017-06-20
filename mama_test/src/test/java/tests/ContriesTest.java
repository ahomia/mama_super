package tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebElement;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static java.util.Arrays.*;

/**
 * Created by axomia on 20.06.2017.
 */
public class ContriesTest extends TestBase{
    @Before
    public void init() throws Exception {
        app.initAdmin();
        app.login().loginAdminka("admin", "admin");
    }

    @Test
    public void contriesTest(){
        app.adminka().goTotheContriesPage();

        List<WebElement> contriesList=app.adminka().contriesList();

        List<WebElement> timeZonesList=app.adminka().timeZonesList();

        List<String> contriesValuesList=app.adminka().contriesValuesList(contriesList);
       // System.out.println(contriesValuesList.size());

        List<Integer> countOfTimeZones=app.adminka().countOfTimeZonesList(timeZonesList);
       // System.out.println(countOfTimeZones.size());

        List<String> contriesValuesListByOrder= app.adminka().sortedList(contriesValuesList);

        Assert.assertArrayEquals(new List[]{contriesValuesList}, new List[]{contriesValuesListByOrder});

        int countOfContries=countOfTimeZones.size();

        for(int i=0;i<countOfContries;i++){
            if (countOfTimeZones.get(i) >0){

                app.adminka().click(contriesList.get(i));

                List<String> contysTimeZonesList=app.adminka().contriesValuesList(app.adminka().countryTimeZonesList());

                List<String> contysTimeZonesListByOrder= app.adminka().sortedList(contysTimeZonesList);

                Assert.assertArrayEquals(new List[]{contysTimeZonesList}, new List[]{contysTimeZonesListByOrder});

                app.adminka().goTotheContriesPage();

                app.adminka().wait5();

               contriesList=app.adminka().contriesList();


            }
        }
    }

    @Test
    public void geoZonesTest(){
        app.adminka().goTotheGeoZonesPage();
        List<WebElement> geoZonesList=app.adminka().contriesList();
        int countOfGeoZones=geoZonesList.size();
        for (int i=0;i<countOfGeoZones;i++){
            app.adminka().click(geoZonesList.get(i));
            List<WebElement> geoTimeZoneList=app.adminka().geoTimeZonesList();
            List<String> geoTimeZoneValueList=app.adminka().contriesValuesList(geoTimeZoneList);
            List<String> geoTimeZoneValueListByOrder=app.adminka().sortedList(geoTimeZoneValueList);
            Assert.assertArrayEquals(new List[]{geoTimeZoneValueListByOrder}, new List[]{geoTimeZoneValueList});
            app.adminka().goTotheContriesPage();
            app.adminka().wait5();
            geoZonesList=app.adminka().contriesList();

        }


    }
    @After
    public void stop() {
        app.stop();
    }
}
