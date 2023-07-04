package Tests;

import Pages.CheckoutPage;
import Pages.HomePage;
import Pages.LandingPage;
import Pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckoutTest extends TestBase{
    HomePage homeObj;

    LandingPage landingObject;
    LoginPage loginObject;

    CheckoutPage checkoutObj;

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
        homeObj = loginObject.skipIntro();
        Assert.assertEquals(driver.getCurrentUrl(), "https://taager.com/eg/products");
    }

    @Test(priority = 3)
    public void BrowseItem(){
        homeObj = new HomePage(driver);
        homeObj.SearchForAProduct();
        homeObj.clickOrderNow();
    }

    @Test(priority = 4)
    public void checkout() throws InterruptedException {
        checkoutObj = new CheckoutPage(driver);
        checkoutObj.PlaceAnOrder("Akaza", "01140404000", "325 safdgfsfda");
    }

}
