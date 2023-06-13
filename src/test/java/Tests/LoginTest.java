package Tests;

import Pages.HomePage;
import Pages.LandingPage;
import Pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends TestBase{
    LandingPage landing;
    LoginPage loginobject;

    HomePage homeobject;
    @Test
    public void clickOnLogin(){
        landing = new LandingPage(driver);
        loginobject = new LoginPage(driver);
        homeobject = new HomePage(driver);
        landing.openTheDropdown();
        landing.clickOnLogin();
        loginobject.loginWithEmail("abdelbary.nasser@taager.com","BodyTest123#");
        loginobject.skipIntro();
        Assert.assertEquals(driver.getCurrentUrl(),"https://taager.com/eg/products");
        Assert.assertEquals(homeobject.theMain.getText(),"الرئيسية");
    }
}
