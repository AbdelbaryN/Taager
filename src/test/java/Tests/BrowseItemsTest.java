package Tests;

import Pages.HomePage;
import Pages.LandingPage;
import Pages.LoginPage;
import io.qameta.allure.Step;
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
        Assert.assertEquals(driver.getCurrentUrl(),"https://taager.com/tt/products/644bad0982902600131c05eb?productName=%D8%B3%D8%AC%D8%A7%D8%AF%D8%A9%20%D8%B9%D8%A7%D9%84%D9%8A%D8%A9%20%D8%A7%D9%84%D8%A7%D9%85%D8%AA%D8%B5%D8%A7%D8%B5");
    }

}
