package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import steps.Hooks;

import java.util.List;
import java.util.Random;

public class ProductSearchPage extends BasePage{

    private static String searchProductField = "input[role='combobox']";
    private static String searchSubmitButton="button[type='submit']";
    private static String productList = "div[data-test='component-product-card']";
    private static String addToCart = "button[data-test='component-att-button']";
    private static String goToBasket = "a[data-test='component-att-button-basket']";
    private static String productPrice = "span[data-e2e='product-line-price']";
    private static String productQuantity = "select[data-e2e='product-quantity']";

    public static void openURL() {
        Hooks.getDriver().get(URL);
    }

    public static void searchProduct(String productName){
        Hooks.getDriver().findElement(By.cssSelector(searchProductField)).sendKeys(productName);
        Hooks.getDriver().findElement(By.cssSelector(searchSubmitButton)).click();
    }

    public static void selectRandomProductInList(){
        Random rand = new Random();
        List<WebElement> pList = Hooks.getDriver().findElements(By.cssSelector(productList));
        pList.get(rand.nextInt(pList.size()+1)).click();
    }

    public static void clickAddToCart() throws InterruptedException {
        Thread.sleep(2500);
        Hooks.getDriver().findElement(By.cssSelector(addToCart)).click();
        Thread.sleep(2500);
        Hooks.getDriver().findElement(By.cssSelector(goToBasket)).click();
        Thread.sleep(2000);
    }

    public static void verifyProductPriceWithQuantity(Integer quantity){
       WebElement productValue =  Hooks.getDriver().findElement(By.cssSelector(productPrice));
       String getPrice = productValue.getText();
       String[] split = getPrice.split("£");
       Double expectedPrice = Double.valueOf(split[1])*quantity;
       Select select = new Select(Hooks.getDriver().findElement(By.cssSelector(productQuantity)));
       select.selectByValue(String.valueOf(quantity));
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assert.assertEquals("£"+expectedPrice,productValue.getText());




    }



}
