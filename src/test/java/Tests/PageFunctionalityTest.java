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

        //Adding item to cart on the homepage
        HomePage.addToCartBikeLightButton().click();
        Assert.assertEquals(HomePage.shoppingCartLink().getText(), "1", "Product is not added to the shopping cart!");

        //Removing item from cart on the homepage
        HomePage.removeFromCartBikeLightButton().click();
        Assert.assertTrue(HomePage.shoppingCartLink().getText().isEmpty(), "Product is not removed from the shopping cart!");
    }

    @Test(groups = {"Test"})
    public void checkProductAddingRemovingFromProductView() {
        Login.validLoginUser();

        //Adding item to cart on the product view page
        HomePage.listOfProducts().get(1).click();
        HomePage.addToCartBikeLightButton().click();
        Assert.assertEquals(HomePage.shoppingCartLink().getText(), "1", "Product is not added to the shopping cart!");

        //Removing item From cart on the product view page
        HomePage.removeFromCartBikeLightButton().click();
        Assert.assertTrue(HomePage.shoppingCartLink().getText().isEmpty(), "Product is not removed from the shopping cart!");
    }

    @Test(groups = {"Test"})
    public void checkProductAddingRemovingFromCart() {
        Login.validLoginUser();

        //Adding item to cart on the homepage
        HomePage.addToCartBikeLightButton().click();
        Assert.assertEquals(HomePage.shoppingCartQuantity().getText(), "1", "Product is not added to the shopping cart!");

        //Navigate to Checkout page and remove item from cart
        HomePage.shoppingCartLink().click();
        HomePage.removeFromCartBikeLightButton().click();
        Assert.assertTrue(HomePage.shoppingCartLink().getText().isEmpty(), "Product is not removed from the shopping cart!");
    }

    @Test(groups = {"Test"})
    public void checkSuccessfullCheckout() {
        Login.validLoginUser();

        //Adding item to cart on the homepage
        HomePage.addToCartBikeLightButton().click();
        Assert.assertEquals(HomePage.shoppingCartQuantity().getText(), "1", "Product is not added to the shopping cart!");

        //Navigate to Checkout page
        HomePage.shoppingCartLink().click();

        //Provide delivery information
        HomePage.checkoutButton().click();
        Assert.assertEquals(CheckoutPage.checkoutTitle().getText(), "CHECKOUT: YOUR INFORMATION", "User cannot access the \"Checkout: Your Information\" page!");
        CheckoutPage.firstNameTextField().sendKeys("Alexandru");
        CheckoutPage.lastNameTextField().sendKeys("Suciu");
        CheckoutPage.postalCodeTextField().sendKeys("400494");
        CheckoutPage.continueButton().click();
        Assert.assertEquals(CheckoutPage.checkoutTitle().getText(), "CHECKOUT: OVERVIEW", "User cannot access the \"Checkout: Overview\" page!");

        //Finalize checkout
        CheckoutPage.finishButton().click();
        Assert.assertEquals(CheckoutPage.completeMessage().getText(), "THANK YOU FOR YOUR ORDER", "User order was unsuccessful");
    }
}