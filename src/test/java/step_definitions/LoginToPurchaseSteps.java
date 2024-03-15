package step_definitions;

import hooks.Hooks;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pageObject.LoginPage;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class LoginToPurchaseSteps {

    private final WebDriver driver = Hooks.driver;
    LoginPage loginPage = new LoginPage(driver);

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

}
