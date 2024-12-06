package pl.seleniumdemo.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pl.seleniumdemo.model.User;
import pl.seleniumdemo.pages.HotelSearchPage;
import pl.seleniumdemo.pages.LoggedUserPage;
import pl.seleniumdemo.pages.SignUpPage;


public class SignUpTest extends BaseTest {
    @Test
    public void signUp() {
        String lastName = "Musialska";
        int randomNumber = (int) (Math.random() * 1000);
        String email = "tester" + randomNumber + "@tester.pl";

        HotelSearchPage hotelSearchPage = new HotelSearchPage(driver);
        hotelSearchPage.openSignUpForm();

        SignUpPage signUpPage = new SignUpPage(driver);
        signUpPage.setFirstName("Wiktoria");
        signUpPage.setLastName(lastName);
        signUpPage.setPhone("111222333");
        signUpPage.setEmail(email);
        signUpPage.setPassword("Test1234");
        signUpPage.setConfirmPassword("Test1234");
        signUpPage.signUp();
        LoggedUserPage loggedUserPage = new LoggedUserPage(driver);
        Assert.assertEquals(loggedUserPage.getHeadingText2(), "Hi, Wiktoria Musialska");
        Assert.assertTrue(loggedUserPage.getHeadingText2().contains(lastName));

    }

    @Test
    public void signUp2() {

        String lastName = "Musialska";
        int randomNumber = (int) (Math.random() * 1000);
        String email = "tester" + randomNumber + "@tester.pl";

        HotelSearchPage hotelSearchPage = new HotelSearchPage(driver);
        hotelSearchPage.openSignUpForm();

        SignUpPage signUpPage = new SignUpPage(driver);
        signUpPage.fillSignUpForm("Wiktoria", lastName, "1111111111", email, "tester1234");


        LoggedUserPage loggedUserPage = new LoggedUserPage(driver);
        Assert.assertEquals(loggedUserPage.getHeadingText2(), "Hi, Wiktoria Musialska");
        Assert.assertTrue(loggedUserPage.getHeadingText2().contains(lastName));

    }

    @Test
    public void signUp3() {
        int randomNumber = (int) (Math.random() * 1000);
        String email = "tester" + randomNumber + "@tester.pl";
        User user = new User();
        user.setFirstName("Wiktoria");
        user.setLastName("Musialska");
        user.setPhone("111111111");
        user.setEmail(email);
        user.setPassword("tester123456");

        HotelSearchPage hotelSearchPage = new HotelSearchPage(driver);
        hotelSearchPage.openSignUpForm();

        SignUpPage signUpPage = new SignUpPage(driver);
        signUpPage.fillSignUpForm(user);


        LoggedUserPage loggedUserPage = new LoggedUserPage(driver);
        Assert.assertEquals(loggedUserPage.getHeadingText2(), "Hi, Wiktoria Musialska");
        Assert.assertTrue(loggedUserPage.getHeadingText2().contains(user.getLastName()));

    }
}
