package pl.seleniumdemo.tests;
import org.testng.Assert;
import org.testng.annotations.Test;
import pl.seleniumdemo.pages.HotelSearchPage;
import pl.seleniumdemo.pages.LoggedUserPage;


public class SignUpTest extends BaseTest {

    @Test
    public void signUpTest() {

        String lastName = "Musialska";
        int randomNumber = (int) (Math.random() * 1000);

        LoggedUserPage loggedUserPage = new HotelSearchPage(driver)
                .openSignUpForm()
                .setFirstNameInput("Wiktoria")
                .setLastNameInput(lastName)
                .setPhone("78123456789")
                .setEmail("tester" + randomNumber + "@wp.pl")
                .setPassword("test1890")
                .setConfirmPassword("test1890")
                .signUp();

        Assert.assertTrue(loggedUserPage.getHeadingText().contains(lastName));
        Assert.assertEquals(loggedUserPage.getHeadingText(), "Hi, Wiktoria Musialska");

    }
}
