package Tests;

import Pages.HomePage;
import Pages.LandingPage;
import Pages.LoginPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class LoginTest extends TestBase{
    LandingPage landingObject;
    LoginPage loginObject;
    HomePage homeObject;
    @Test(priority = 1)
    public void testOpenLoginPage() throws InterruptedException {
        landingObject = new LandingPage(driver);
        landingObject.openTheDropdown();
        loginObject = landingObject.openLoginpage();
        Assert.assertEquals(driver.getCurrentUrl(), "https://taager.com/eg/authv2/login");

    }
    @Test(priority = 2)
    public void loginWithValidCredentials(){
        loginObject.loginWithEmail("abdelbary.nasser@taager.com","BodyTest123#");
        homeObject = loginObject.skipIntro();
        Assert.assertEquals(driver.getCurrentUrl(), "https://taager.com/eg/products");
    }
}
