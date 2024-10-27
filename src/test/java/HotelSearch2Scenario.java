import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class HotelSearch2Scenario {
@Test
public void hotelSearch2Scenario(){
    WebDriver driver = new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    driver.manage().window().maximize();
    driver.get("http://www.kurs-selenium.pl/demo/");
    driver.findElement(By.name("checkin")).click();
    driver.findElements(By.xpath("//td[@class='day  active']"))
            .stream()
            .filter(WebElement::isDisplayed)
            .findFirst()
            .ifPresent(WebElement::click);
    driver.findElement(By.name("checkout")).click();
    driver.findElements(By.xpath("//td[@class='day ' and text()='28']"))
            .stream()
            .filter(WebElement::isDisplayed)
            .findFirst()
            .ifPresent(WebElement::click);
    driver.findElement(By.id("travellersInput")).click();
    driver.findElement(By.id("childPlusBtn")).click();
    driver.findElement(By.xpath("//button[text()=' Search']")).click();
    WebElement message=driver.findElement(By.xpath("//h2[text()='No Results Found']"));
    Assert.assertEquals("No Results Found", message.getText());
    }}
