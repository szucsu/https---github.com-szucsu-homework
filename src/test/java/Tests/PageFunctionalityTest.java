package Tests;

import Pages.CheckoutPage;
import Utils.BeforeAfterTests;
import Pages.HomePage;
import Utils.Login;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PageFunctionalityTest extends BeforeAfterTests {


    @Test(groups = {"Test"})
    public void checkProductAddingRemovingFromCatalogView() {
        Login.validLoginUser();

        HomePage.addToCartBikeLightButton().click();
        Assert.assertEquals(HomePage.shoppingCartLink().getText(), "1", "Product is not added to the shopping cart!");

        HomePage.removeFromCartBikeLightButton().click();
        Assert.assertTrue(HomePage.shoppingCartLink().getText().isEmpty(), "Product is not removed from the shopping cart!");
    }

    @Test(groups = {"Test"})
    public void checkProductAddingRemovingFromProductView() {
        Login.validLoginUser();

        HomePage.listOfProducts().get(1).click();
        HomePage.addToCartBikeLightButton().click();
        Assert.assertEquals(HomePage.shoppingCartLink().getText(), "1", "Product is not added to the shopping cart!");

        HomePage.removeFromCartBikeLightButton().click();
        Assert.assertTrue(HomePage.shoppingCartLink().getText().isEmpty(), "Product is not removed from the shopping cart!");
    }

    @Test(groups = {"Test"})
    public void checkProductAddingRemovingFromCart() {
        Login.validLoginUser();

        HomePage.addToCartBikeLightButton().click();
        HomePage.shoppingCartLink().click();
        Assert.assertEquals(HomePage.shoppingCartQuantity().getText(), "1", "Product is not added to the shopping cart!");

        HomePage.removeFromCartBikeLightButton().click();
        Assert.assertTrue(HomePage.shoppingCartLink().getText().isEmpty(), "Product is not removed from the shopping cart!");
    }

    @Test(groups = {"Test"})
    public void checkSuccessfullCheckout() {
        Login.validLoginUser();

        HomePage.addToCartBikeLightButton().click();
        HomePage.shoppingCartLink().click();
        Assert.assertEquals(HomePage.shoppingCartQuantity().getText(), "1", "Product is not added to the shopping cart!");

        HomePage.checkoutButton().click();
        Assert.assertEquals(CheckoutPage.checkoutTitle().getText(), "CHECKOUT: YOUR INFORMATION", "User cannot access the \"Checkout: Your Information\" page!");

        CheckoutPage.firstNameTextField().sendKeys("Alexandru");
        CheckoutPage.lastNameTextField().sendKeys("Suciu");
        CheckoutPage.postalCodeTextField().sendKeys("400494");
        CheckoutPage.continueButton().click();
        Assert.assertEquals(CheckoutPage.checkoutTitle().getText(), "CHECKOUT: OVERVIEW", "User cannot access the \"Checkout: Overview\" page!");

        CheckoutPage.finishButton().click();
        Assert.assertEquals(CheckoutPage.completeMessage().getText(), "THANK YOU FOR YOUR ORDER", "User order was unsuccessful");
    }
}