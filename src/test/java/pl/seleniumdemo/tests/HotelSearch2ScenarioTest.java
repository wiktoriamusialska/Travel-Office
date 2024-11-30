package pl.seleniumdemo.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pl.seleniumdemo.pages.HotelSearchPage;
import pl.seleniumdemo.pages.ResultsPage;

public class HotelSearch2ScenarioTest extends BaseTest {
    @Test
    public void hotelSearch2ScenarioTest() {
        ResultsPage resultsPage = new HotelSearchPage(driver)
                .setDates("24/04/2021", "25/04/2021")
                .setTravellers(1, 1)
                .performSearch();

        Assert.assertTrue(resultsPage.resultHeading.isDisplayed());
        Assert.assertEquals(resultsPage.getHeadingText(), "No Results Found");
    }
}
