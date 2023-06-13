package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.time.Duration;

public class LoginPage extends PageBase{
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "button.btn.auth-btn.change-type-btn.body2--medium")
    WebElement LoginWithEmail;

    @FindBy(css = "input.form-control.body2--medium.ng-untouched.ng-pristine.ng-invalid.ng-star-inserted")
    WebElement email;

    @FindBy(css = "input.form-control.body2--medium.ng-untouched.ng-pristine.ng-invalid")
    WebElement password;

    @FindBy(css = "button.btn.auth-btn.register-btn.body2--medium")
    WebElement loginBtn;

    @FindBy(css = "button.dialog__action-btn.body1--medium")
    WebElement letsStart;

    @FindBy(css = "div.body2--medium.wrapper__footer__button__text.ng-star-inserted")
    WebElement next1;

    @FindBy(css = "div.wrapper__footer__button.ng-star-inserted")
    WebElement next2;

    @FindBy(css = "div.wrapper__footer__button.ng-star-inserted")
    WebElement next3;

    @FindBy(css = "div.wrapper__footer__button.ng-star-inserted")
    WebElement next4;

    @FindBy(css = "p.caption2--regular.content-medium-color")
    WebElement BackToMain;

    public void skipIntro(){
        clickButton(letsStart);
        clickButton(next1);
        clickButton(next2);
        clickButton(next3);
        clickButton(next4);
        clickButton(BackToMain);
    }

    public void loginWithEmail(String Email, String Pass){
        clickButton(LoginWithEmail);
        setText(email, Email);
        setText(password, Pass);
        clickButton(loginBtn);
    }
}
