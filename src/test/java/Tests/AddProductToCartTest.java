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

    @Step("Add products to the cart")
    @Test(priority = 1)
    public void AddProductsToTheCart() throws InterruptedException {
        landingObject = new LandingPage(driver);
        landingObject.openTheDropdown();
        loginObject = landingObject.openLoginpage();
        loginObject.loginWithEmail("abdelbary.nasser@taager.com","BodyTest123#");
        homeObj = loginObject.skipIntro();
        Assert.assertEquals(driver.getCurrentUrl(), "https://taager.com/eg/products");
        homeObj.changeMarketToTMT();
        homeObj.SearchForAProduct("سجادة عالية الامتصاص");
        homeObj.AddProductToCart();
        Thread.sleep(5000);
        //Assert.assertEquals(homeObj.cartN.getText(), "1");
        homeObj.deleteAllItems();
        Thread.sleep(5000);
        //Assert.assertEquals(homeObj.cartN.getText(), "0");
    }

}
