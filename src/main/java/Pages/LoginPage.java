package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.time.Duration;

public class LoginPage extends PageBase{
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    By LoginWithEmail = By.cssSelector("button.btn.auth-btn.change-type-btn.body2--medium");

    By email = By.cssSelector("input.form-control.body2--medium.ng-untouched.ng-pristine.ng-invalid.ng-star-inserted");

    By password = By.cssSelector("input.form-control.body2--medium.ng-untouched.ng-pristine.ng-invalid");

    By loginBtn = By.cssSelector("button.btn.auth-btn.register-btn.body2--medium");

    /*
     * Skip intro
     * */

    By letsStart = By.cssSelector("button.dialog__action-btn.body1--medium");

    By next1 = By.cssSelector("div.body2--medium.wrapper__footer__button__text.ng-star-inserted");

    By next2 = By.cssSelector("div.wrapper__footer__button.ng-star-inserted");

    By next3 = By.cssSelector("div.wrapper__footer__button.ng-star-inserted");

    By next4 = By.cssSelector("div.wrapper__footer__button.ng-star-inserted");

    By BackToMain = By.cssSelector("p.caption2--regular.content-medium-color");

    public void loginWithEmail(String Email, String Pass){
        clickButton(LoginWithEmail);
        setText(email, Email);
        setText(password, Pass);
        clickButton(loginBtn);
    }

    public HomePage skipIntro(){
        clickButton(letsStart);
        clickButton(next1);
        clickButton(next2);
        clickButton(next3);
        clickButton(next4);
        clickButton(BackToMain);
        return new HomePage(driver);
    }
}
