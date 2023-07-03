package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.time.Duration;

public class LandingPage extends PageBase{
    public LandingPage(WebDriver driver) {
        super(driver);
    }
    By dropdownMenu = By.xpath("/html/body/app-root/app-logged-out-layout/mat-sidenav-container/mat-sidenav-content/div/div[1]/app-landing-header/div/button/i");

    By loginbutton = By.xpath("/html/body/div/div[2]/div/div/div/div/button");

    public void openTheDropdown() throws InterruptedException {
        Thread.sleep(5000);
        clickButton(dropdownMenu);
    }

    public LoginPage openLoginpage(){
        clickButton(loginbutton);
        return new LoginPage(driver);
    }
}
