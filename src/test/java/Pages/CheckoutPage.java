package Pages;

import Utils.BeforeAfterTests;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class CheckoutPage extends BeforeAfterTests {

    public static WebElement checkoutTitle() {
        return getDriver().findElement(By.cssSelector(".title"));
    }

    public static WebElement firstNameTextField() {
        return getDriver().findElement(By.id("first-name"));
    }

    public static WebElement lastNameTextField() {
        return getDriver().findElement(By.id("last-name"));
    }

    public static WebElement postalCodeTextField() {
        return getDriver().findElement(By.id("postal-code"));
    }

    public static WebElement continueButton() {
        return getDriver().findElement(By.id("continue"));
    }

    public static WebElement finishButton() {
        return getDriver().findElement(By.id("finish"));
    }

    public static WebElement completeMessage() {
        return getDriver().findElement(By.cssSelector("div#checkout_complete_container > .complete-header"));
    }

}