package pl.seleniumdemo.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pl.seleniumdemo.pages.HotelSearchPage;
import pl.seleniumdemo.pages.ResultsPage;

import java.time.Duration;

public class HotelSearch2Scenario extends BaseTest {
@Test
public void hotelSearch2Scenario(){

    HotelSearchPage hotelSearchPage = new HotelSearchPage(driver);
    hotelSearchPage.setDates("25/04/2021", "30/04/2021");
    hotelSearchPage.setTravellers(0,1);
    hotelSearchPage.performSearch();

    ResultsPage resultsPage = new ResultsPage(driver);
    Assert.assertTrue(resultsPage.resultHeading.isDisplayed());
    Assert.assertEquals(resultsPage.getHeadingText(),"No Results Found");
    }}
