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
    
    
    /*
    * Egypt Market
    * */

    By searchbar = By.xpath("/html/body/app-root/app-default-layout/mat-sidenav-container/mat-sidenav-content/app-header/app-main-header/div/app-sticky-header/div/app-products-search-bar/form/input");

    By searchIcon = By.xpath("/html/body/app-root/app-default-layout/mat-sidenav-container/mat-sidenav-content/app-header/app-main-header/div/app-sticky-header/div/app-products-search-bar/form/button/i");

    By airpods = By.xpath("/html/body/app-root/app-default-layout/mat-sidenav-container/mat-sidenav-content/div/app-category-products/div/div[2]/div/div[3]/div[2]/div/app-product-card[10]/div/a/img");

    By addToCart = By.xpath("/html/body/app-root/app-default-layout/mat-sidenav-container/mat-sidenav-content/div/app-product-details/div[1]/app-product-details-preview/div[1]/div/app-product-actions/div/section/section[1]/button[1]");

    By cartIcon = By.xpath("/html/body/app-root/app-default-layout/mat-sidenav-container/mat-sidenav-content/app-header/app-main-header/div/app-sticky-header/div/app-shopping-navigation/div/div[1]/a/i");

    By cartnumber = By.xpath("/html/body/app-root/app-default-layout/mat-sidenav-container/mat-sidenav-content/app-header/app-main-header/div/app-sticky-header/div/app-shopping-navigation/div/div[1]/p");

    public WebElement cartN = driver.findElement(cartnumber);

    By deleteAll = By.xpath("/html/body/app-root/app-default-layout/mat-sidenav-container/mat-sidenav-content/div/app-cart/div/div/div[1]/app-cart-products-table/div/div[1]/button");

    By confirmDelete = By.xpath("/html/body/div[4]/div[2]/div/mat-dialog-container/app-confirm-delete-item/div/div/button[2]/i");

    By ordernow = By.cssSelector("button.action-button.order-now-button.clickable");
    
    
    
    /*
    * Test Market
    * */
    
    By marketDropDown = By.xpath("//span[@class=\"mat-button-wrapper\"] / i[@class=\"icon icon-header-icons-chevron-down countries-dropdown-btn__dropdown-icon\"]");

    By tmtMarket = By.xpath("//*[@id=\"mat-menu-panel-3\"]/div/button[4]");

    By tmtProduct = By.xpath("//*[@id=\"category-products\"]/div[2]/div/div[3]/div[2]/div/app-product-card/div/div/a");



    public void changeMarket(){
        clickButton(marketDropDown);
        clickButton(tmtMarket);
    }

    public void SearchForAProduct(String productName){
        clickButton(searchbar);
        setText(searchbar,productName);
        clickButton(searchIcon);
        //clickButton(airpods);
        clickButton(tmtProduct);

    }

    public void clickOrderNow(){
        clickButton(ordernow);
    }
    public void AddProductToCart(){
        clickButton(addToCart);
        clickButton(cartIcon);
    }

    public void deleteAllItems(){
        clickButton(deleteAll);
        clickButton(confirmDelete);
    }

    public void changeMarketToTMT() throws InterruptedException {
        driver.get("https://taager.com/tt/products");
        Thread.sleep(5000);
    }

}
