import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;


public class SignUpTest {
    @Test
    public void signUp() {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("http://www.kurs-selenium.pl/demo/");
        String lastName="Musialska";
        int randomNumber = (int) (Math.random()*1000);
        String email="tester"+randomNumber+"@tester.pl";
        driver.findElements(By.xpath(("//li[@id='li_myaccount']")))
                            .stream()
                            .filter(WebElement::isDisplayed)
                            .findFirst()
                            .ifPresent(WebElement::click);
        driver.findElements(By.xpath("//a[text()='  Sign Up']")).get(1).click();
        driver.findElement(By.name("firstname")).sendKeys("Wiktoria");
        driver.findElement(By.name("lastname")).sendKeys("Musialska");
        driver.findElement(By.name("phone")).sendKeys("111222333");
        driver.findElement(By.name("email")).sendKeys(email);
        driver.findElement(By.name("password")).sendKeys("Test1234");
        driver.findElement(By.name("confirmpassword")).sendKeys("Test1234");
        driver.findElement(By.xpath("//button[@type='submit' and text()=' Sign Up']")).click();
        WebElement heading = driver.findElement(By.xpath("//h3[@class='RTL']"));
        Assert.assertTrue(heading.getText().contains(lastName));
        Assert.assertEquals( heading.getText(),"Hi, Wiktoria Musialska");
        driver.quit();
    }
}
