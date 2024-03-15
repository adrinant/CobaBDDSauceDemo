package org.example.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class InventoryPage {

    public static WebDriver webDriver;

    public InventoryPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        webDriver = driver;
    }

    @FindBy(xpath = "//select[@class='product_sort_container']")
    private WebElement sortProduct;

    @FindBy(xpath = "//div[@id='shopping_cart_container']/a[1]")
    private WebElement shoppingCartIcon;


    public void selectSortProduct(String textSortBy){
        Select select = new Select(sortProduct);
        select.selectByVisibleText(textSortBy);
    }

    public void clickAddtoCartItem(String itemTitle){
        String button = "//div[.='"+itemTitle+"']/ancestor::div[@class='inventory_item_description']//button";
        webDriver.findElement(By.xpath(button)).click();
    }

    public void selectShoppingCartIcon(){
        shoppingCartIcon.click();
    }


}
