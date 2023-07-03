package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class HomePage extends PageBase{

    public HomePage(WebDriver driver) {
        super(driver);
    }

    By searchbar = By.xpath("/html/body/app-root/app-default-layout/mat-sidenav-container/mat-sidenav-content/app-header/app-main-header/div/app-sticky-header/div/app-products-search-bar/form/input");

    By searchIcon = By.xpath("/html/body/app-root/app-default-layout/mat-sidenav-container/mat-sidenav-content/app-header/app-main-header/div/app-sticky-header/div/app-products-search-bar/form/button/i");

    By airpods = By.xpath("/html/body/app-root/app-default-layout/mat-sidenav-container/mat-sidenav-content/div/app-category-products/div/div[2]/div/div[3]/div[2]/div/app-product-card[10]/div/a/img");

    By addToCart = By.xpath("/html/body/app-root/app-default-layout/mat-sidenav-container/mat-sidenav-content/div/app-product-details/div[1]/app-product-details-preview/div[1]/div/app-product-actions/div/section/section[1]/button[1]");

    By cartIcon = By.xpath("/html/body/app-root/app-default-layout/mat-sidenav-container/mat-sidenav-content/app-header/app-main-header/div/app-sticky-header/div/app-shopping-navigation/div/div[1]/a/i");

    By cartnumber = By.xpath("/html/body/app-root/app-default-layout/mat-sidenav-container/mat-sidenav-content/app-header/app-main-header/div/app-sticky-header/div/app-shopping-navigation/div/div[1]/p");

    public WebElement cartN = driver.findElement(cartnumber);
    public void SearchForAProduct(){
        clickButton(searchbar);
        setText(searchbar,"Air Pods M30 Pro");
        clickButton(searchIcon);
        clickButton(airpods);

    }
    public void AddProductToCart(){
        clickButton(addToCart);
        clickButton(cartIcon);
    }

}
