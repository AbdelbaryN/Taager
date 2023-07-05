package Tests;

import Pages.HomePage;
import Pages.LandingPage;
import Pages.LoginPage;
import io.qameta.allure.Step;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddProductToCartTest extends TestBase{

    HomePage homeObj;

    LandingPage landingObject;
    LoginPage loginObject;

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

    @Step("change the market to TMT")
    @Test(priority = 3)
    public void changeMarketToTMT() throws InterruptedException {
        driver.get("https://taager.com/tt/products");
        Thread.sleep(5000);
    }

    @Test(priority = 4)
    public void BrowseItem(){
        homeObj = new HomePage(driver);
        homeObj.SearchForAProduct("سجادة عالية الامتصاص");
    }

    @Test(priority = 5)
    public void AddTocart() throws InterruptedException {
        homeObj.AddProductToCart();
        Thread.sleep(5000);
        Assert.assertEquals(homeObj.cartN.getText(), "1");
    }

    @Test(priority = 6)
    public void DeleteFromCart() throws InterruptedException {
        homeObj.deleteAllItems();
        Thread.sleep(5000);
        Assert.assertEquals(homeObj.cartN.getText(), "0");
    }
}
