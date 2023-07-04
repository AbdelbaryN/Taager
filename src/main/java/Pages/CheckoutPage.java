package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CheckoutPage extends PageBase{
    public CheckoutPage(WebDriver driver) {
        super(driver);
    }


    By fullname = By.xpath("//div[@class=\"form-group\"] /input[@id=\"receiverName\"]");

    By phonenumber = By.xpath("//div[@class=\"form-group\"] /input[@id=\"phoneNumber\"]");

    By province = By.cssSelector("div.c-btn");

    By placeOrder = By.xpath("/html/body/app-root/app-default-layout/mat-sidenav-container/mat-sidenav-content/div/app-product-details/div/app-order/div/div/form/div/div[2]/div/button");

    By address = By.xpath("//div[@class=\"form-group\"] / input[@id=\"streetName\"]");

    By pr1 = By.xpath("/html/body/app-root/app-default-layout/mat-sidenav-container/mat-sidenav-content/div/app-product-details/div/app-order/div/div/form/div/div[1]/div[3]/div/div/angular2-multiselect/div/div[2]/div[3]/div[3]/ul/li[1]");

    public void PlaceAnOrder(String name, String number, String add) throws InterruptedException {
        WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));
        w.until(ExpectedConditions.presenceOfElementLocated(fullname));
        clickButton(fullname);
        setText(fullname, name);
        w.until(ExpectedConditions.presenceOfElementLocated(phonenumber));
        clickButton(phonenumber);
        setText(phonenumber, number);

        /*
        * scrolling
        * */

        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript("window.scrollBy(0,500)", "");

        w.until(ExpectedConditions.presenceOfElementLocated(province));
        clickButton(province);
        w.until(ExpectedConditions.presenceOfElementLocated(pr1));
        clickButton(pr1);
        w.until(ExpectedConditions.presenceOfElementLocated(address));
        clickButton(address);
        setText(address, add);
        w.until(ExpectedConditions.presenceOfElementLocated(placeOrder));
        clickButton(placeOrder);
    }

}

