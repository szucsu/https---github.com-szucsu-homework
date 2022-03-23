package Pages;


import Utils.BeforeAfterTests;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginPage extends BeforeAfterTests {

    public static WebElement getUsername() {
        return getDriver().findElement(By.id("user-name"));
    }

    public static WebElement getPassword() {
        return getDriver().findElement(By.id("password"));
    }

    public static WebElement getLoginButton() {
        return getDriver().findElement(By.id("login-button"));
    }
}

