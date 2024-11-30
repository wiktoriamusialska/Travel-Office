package pl.seleniumdemo.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pl.seleniumdemo.pages.HotelSearchPage;

import java.util.List;

public class HotelSearchTest extends BaseTest {
    @Test
    public void searchHotelTest() {
        HotelSearchPage hotelSearchPage = new HotelSearchPage(driver);
        List<String> hotelNames = hotelSearchPage
                .setCity("Dubai")
                .setDates("27/04/2021", "29/04/2021")
                .setTravellers(1, 1)
                .performSearch().getHotelNames();


        hotelNames.forEach(System.out::println);
        Assert.assertEquals("Jumeirah Beach Hotel", hotelNames.get(0));
        Assert.assertEquals("Oasis Beach Tower", hotelNames.get(1));
        Assert.assertEquals("Rose Rayhaan Rotana", hotelNames.get(2));
        Assert.assertEquals("Hyatt Regency Perth", hotelNames.get(3));
    }
}
