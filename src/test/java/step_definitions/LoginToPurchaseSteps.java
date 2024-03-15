package step_definitions;

import hooks.Hooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pageObject.CheckoutPage;
import org.example.pageObject.InventoryPage;
import org.example.pageObject.LoginPage;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class LoginToPurchaseSteps {

    private final WebDriver driver = Hooks.driver;
    LoginPage loginPage = new LoginPage(driver);
    InventoryPage inventoryPage = new InventoryPage(driver);
    CheckoutPage checkoutPage = new CheckoutPage(driver);

    @Given("User open the saucedemo website")
    public void userOpenTheWebsiteSaucedemo() {
        Assert.assertTrue(loginPage.verifyLoginPage());
    }

    @When("User input {string} as a userName {string} as a password")
    public void credential(String userName, String password){
        loginPage.inputFieldUserName(userName);
        loginPage.inputFieldPassword(password);
        loginPage.clickLoginButton();
    }

    @Then("User redirected to inventory page")
    public void userRedirectedToInventoryPage() {
        Assert.assertTrue(loginPage.verifyInventoryContainer());
    }

    @And("User sort product by {string}")
    public void userSortProductBy(String textSortBy) {
        inventoryPage.selectSortProduct(textSortBy);
    }
    @And("User add to cart button for {string}")
    public void userAddToCartButtonFor(String itemTitle) {
        inventoryPage.clickAddtoCartItem(itemTitle);
    }
    @Then("User click shopping cart badge")
    public void userClickShoppingCartBadge() {
        inventoryPage.selectShoppingCartIcon();
    }
    @And("User remove {string} from shopping cart")
    public void userRemoveFromShoppingCart(String itemTitle) {
        checkoutPage.clickRemoveFromCart(itemTitle);
    }
    @And("User click Checkout button")
    public void userClickCheckoutButton() {
        checkoutPage.clickCheckoutButton();
    }
    @Then("User redirected to Checkout Step One page")
    public void userRedirectedToCheckoutStepOnePage() {
        Assert.assertTrue(checkoutPage.verifyCheckoutOnePage());
    }

    @And("User input {string} as FirstName {string} as LastName {string} as ZipCode")
    public void userInputAsFirstNameAsLastNameAsZipCode(String firstName, String lastName, String zipCode) {
        checkoutPage.inputCheckoutInfo(firstName,lastName,zipCode);
    }
    @And("User click Continue button")
    public void userClickContinueButton() {
        checkoutPage.clickContinueButton();
    }
    @Then("User redirected to Checkout Step Two page")
    public void userRedirectedToCheckoutStepTwoPage() {
        Assert.assertTrue(checkoutPage.verifySummaryTotal());
    }
    @And("User click Finish button")
    public void userClickFinishButton() {
        checkoutPage.clickFinishButton();
    }

    @Then("User redirected to Checkout Complete page")
    public void userRedirectedToCheckoutCompletePage() {
        Assert.assertTrue(checkoutPage.verifyThankYou());
    }
}
