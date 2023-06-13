package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.time.Duration;

public class LandingPage extends PageBase{
    public LandingPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(css = "i.icon.icon-header-icons-chevron-down")
    WebElement dropdownMenu;

    @FindBy(xpath = "/html/body/div/div[2]/div/div/div/div/button")
    WebElement loginbutton;

    public void openTheDropdown(){
        clickButton(dropdownMenu);
    }
    public void clickOnLogin(){
        clickButton(loginbutton);
    }
}
