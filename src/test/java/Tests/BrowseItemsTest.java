package Tests;

import Pages.HomePage;
import Pages.LandingPage;
import Pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BrowseItemsTest extends TestBase{

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

    @Test(priority = 3)
    public void BrowseItem(){
        homeObj = new HomePage(driver);
        homeObj.SearchForAProduct();
    }

}
