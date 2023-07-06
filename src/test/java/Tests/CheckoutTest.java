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

    @Step("Checkout the product")
    @Test(priority = 1, description = "Checkout")
    public void testOpenLoginPage() throws InterruptedException {
        landingObject = new LandingPage(driver);
        landingObject.openTheDropdown();
        loginObject = landingObject.openLoginpage();
        loginObject.loginWithEmail("abdelbary.nasser@taager.com","BodyTest123#");
        homeObj = loginObject.skipIntro();
        Assert.assertEquals(driver.getCurrentUrl(), "https://taager.com/eg/products");
        homeObj.changeMarketToTMT();
        homeObj.SearchForAProduct("سجادة عالية الامتصاص");
        homeObj.clickOrderNow();
        checkoutObj = new CheckoutPage(driver);
        checkoutObj.PlaceAnOrder("Akaza", "01274567800", "325 safdgfsfda");
    }

}
