package pl.seleniumdemo.tests;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.MediaEntityModelProvider;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pl.seleniumdemo.pages.HotelSearchPage;
import pl.seleniumdemo.pages.ResultsPage;
import pl.seleniumdemo.utils.ExcelReader;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;


public class HotelSearch extends BaseTest{
    @Test
    public void searchHotel() throws IOException {
        ExtentTest test = extentReports.createTest("Search Hotel Test");
        HotelSearchPage hotelSearchPage = new HotelSearchPage(driver);
        hotelSearchPage.setCity("Dubai");
        test.log(Status.PASS, "Setting city done");
        hotelSearchPage.setDates("30/12/2024", "06/01/2025");
        test.log(Status.PASS, "Setting dates done");
        hotelSearchPage.setTravellers(1, 1);
        test.log(Status.PASS, "Setting travellers done");
        hotelSearchPage.performSearch();
        test.log(Status.PASS, "Performing search done");
        test.log(Status.PASS,"Screenshot", MediaEntityBuilder.createScreenCaptureFromPath("src/test/resources/screenshots/Zrzut ekranu 2023-05-06 131638.png").build());

        ResultsPage resultPage = new ResultsPage(driver);
        List<String> hotelNames= resultPage.getHotelNames();
        hotelNames.forEach(System.out::println);
        Assert.assertEquals("Jumeirah Beach Hotel", hotelNames.get(0));
        Assert.assertEquals("Oasis Beach Tower", hotelNames.get(1));
        Assert.assertEquals("Rose Rayhaan Rotana", hotelNames.get(2));
        Assert.assertEquals("Hyatt Regency Perth", hotelNames.get(3));
        test.log(Status.PASS, "Assertions done");
    }
@Test(dataProvider = "data")
    public void searchHotelWithDataProvider(String city,String hotel) {
        HotelSearchPage hotelSearchPage = new HotelSearchPage(driver);
        hotelSearchPage.setCity(city);
        hotelSearchPage.setDates("30/12/2024", "06/01/2025");
        hotelSearchPage.setTravellers(1, 1);
        hotelSearchPage.performSearch();

        ResultsPage resultPage = new ResultsPage(driver);
        List<String> hotelNames= resultPage.getHotelNames();

        Assert.assertEquals(hotelNames.get(0), hotel);

    }
@DataProvider
    public Object[][] data() throws IOException {
        return ExcelReader.readExcel("TestData.xlsx");
    }}
