package UIAutomation.Pages;

import UIAutomation.Utils.BeforeAfterTests;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HomePage extends BeforeAfterTests {

    public static WebElement addToCartBikeLightButton() {
        return getDriver().findElement(By.id("add-to-cart-sauce-labs-bike-light"));
    }

    public static WebElement removeFromCartBikeLightButton() {
        return getDriver().findElement(By.id("remove-sauce-labs-bike-light"));
    }

    public static WebElement shoppingCartLink() {
        return getDriver().findElement(By.cssSelector("div#shopping_cart_container > .shopping_cart_link"));
    }

    public static WebElement shoppingCartBadge() {
        return getDriver().findElement(By.cssSelector(".shopping_cart_badge"));
    }

    public static List<WebElement> listOfProducts() {
        return getDriver().findElements(By.cssSelector(".inventory_item"));
    }

    public static WebElement shoppingCartQuantity() {
        return getDriver().findElement(By.cssSelector(".cart_quantity"));
    }

    public static WebElement checkoutButton() {
        return getDriver().findElement(By.id("checkout"));
    }
}