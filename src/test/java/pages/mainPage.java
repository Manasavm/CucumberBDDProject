package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import steps.Hooks;

public class mainPage {
    private static final String URL = "https://www.facebook.com";


    public static void openGooglePage() {
        Hooks.getDriver().get(URL);
    }

    public static void i_print_title_and_URL() {
        Assert.assertTrue(Hooks.getDriver().getCurrentUrl().contains(URL));
    }


//    public void getCartValue(){
//        Hooks.getDriver().findElement(By.cssSelector(".add-to-trolley-main")).click();
//        Hooks.getDriver().findElement(By.cssSelector("a[data-test='component-att-button-basket']")).click();
//        String cartText = Hooks.getDriver().findElement(By.cssSelector("span[class*='ProductCard__productLinePrice']")).getText();
//        String[] splitText = cartText.split(" ");
//        Integer value = Integer.valueOf(splitText[1]);
//        Integer expectedCartValue = value*2;
//        Select select = new Select(Hooks.getDriver().findElement(By.cssSelector("select[data-e2e='product-quantity']")));
//        select.selectByValue("2");
//        Assert.assertEquals(expectedCartValue,Hooks.getDriver().findElement(By.cssSelector("span[class*='ProductCard__productLinePrice']")).getText());
//    }
}
