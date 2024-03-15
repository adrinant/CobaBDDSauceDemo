package org.example.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage {

    public static WebDriver webDriver;

    public CheckoutPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        webDriver = driver;
    }

    @FindBy(xpath = "//button[@id='remove-sauce-labs-bike-light']")
    private WebElement removeSauceLabsBikeLight;

    @FindBy(xpath = "//button[@id='checkout']")
    private WebElement checkoutButton;

    @FindBy(xpath = "//div[@class='checkout_info']")
    private WebElement checkoutInfo;

    @FindBy(xpath = "//input[@id='first-name']")
    private WebElement inputFirstName;
    @FindBy(xpath = "//input[@id='last-name']")
    private WebElement inputLastName;
    @FindBy(xpath = "//input[@id='postal-code']")
    private WebElement inputZipCode;

    @FindBy(xpath = "//input[@id='continue']")
    private WebElement continueButton;

    @FindBy(xpath = "//div[@class='summary_info_label summary_total_label']")
    private WebElement summaryTotal;

    @FindBy(xpath = "//button[@id='finish']")
    private WebElement finishButton;

    @FindBy(xpath = "//img[@alt='Pony Express']")
    private WebElement thankYou;

    public void clickRemoveFromCart(String itemTitle){
        String button = "//div[.='"+itemTitle+"']/ancestor::div[1]/div[@class='item_pricebar']/button";
        webDriver.findElement(By.xpath(button)).click();
    }

    public void clickCheckoutButton(){
        checkoutButton.click();
    }

    public boolean verifyCheckoutOnePage(){
        boolean a = checkoutInfo.isDisplayed();
        boolean b = inputFirstName.isDisplayed();
        return a && b;
    }

    public void inputCheckoutInfo(String firstName, String lastName, String zipCode){
        inputFirstName.sendKeys(firstName);
        inputLastName.sendKeys(lastName);
        inputZipCode.sendKeys(zipCode);
    }

    public void clickContinueButton(){
        continueButton.click();
    }

    public boolean verifySummaryTotal(){
        return summaryTotal.isDisplayed();
    }

    public void clickFinishButton(){
        finishButton.click();
    }

    public boolean verifyThankYou(){
        return thankYou.isDisplayed();
    }

}
