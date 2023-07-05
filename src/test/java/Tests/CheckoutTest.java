package Tests;

import Pages.CheckoutPage;
import Pages.HomePage;
import Pages.LandingPage;
import Pages.LoginPage;
import io.qameta.allure.Step;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckoutTest extends TestBase{
    HomePage homeObj;

    LandingPage landingObject;
    LoginPage loginObject;

    CheckoutPage checkoutObj;

    @Step("Open login page")
    @Test(priority = 1, description = "Open login page")
    public void testOpenLoginPage() throws InterruptedException {
        landingObject = new LandingPage(driver);
        landingObject.openTheDropdown();
        loginObject = landingObject.openLoginpage();
        Assert.assertEquals(driver.getCurrentUrl(), "https://taager.com/eg/authv2/login");

    }
    @Step("Login with valid credentials")
    @Test(priority = 2)
    public void loginWithValidCredentials(){
        loginObject.loginWithEmail("abdelbary.nasser@taager.com","BodyTest123#");
        homeObj = loginObject.skipIntro();
        Assert.assertEquals(driver.getCurrentUrl(), "https://taager.com/eg/products");
    }

    @Step("change the market to TMT")
    @Test(priority = 3)
    public void changeMarketToTMT() throws InterruptedException {
        driver.get("https://taager.com/tt/products");
        Thread.sleep(5000);
    }

    @Step("Browse Items")
    @Test(priority = 4)
    public void BrowseItem(){
        homeObj = new HomePage(driver);
        homeObj.SearchForAProduct("سجادة عالية الامتصاص");
        homeObj.clickOrderNow();
    }

    @Step("Complete the Checkout")
    @Test(priority = 5)
    public void checkout() throws InterruptedException {
        checkoutObj = new CheckoutPage(driver);
        checkoutObj.PlaceAnOrder("Akaza", "01274567800", "325 safdgfsfda");
    }

}
