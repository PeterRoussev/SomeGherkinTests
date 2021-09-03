package pages;

import org.openqa.selenium.By;
import org.testng.Assert;
import utils.Browser;

public class LoginPage {
    private static final String url = "https://pragmatest.inv.bg/login";
    private static final By emailInputField = By.cssSelector("#loginusername");
    private static final By passwordInputField = By.cssSelector("#loginpassword");
    private static final By submitLoginButton = By.cssSelector("#loginsubmit");
    private static final By cashboxTab = By.cssSelector("#tabs_cashbox a");

    public static void goToPage(){
        Browser.driver.get(url);
    }

    public static void inputCredentials(){
        Browser.driver.findElement(emailInputField).sendKeys("");
        Browser.driver.findElement(passwordInputField).sendKeys("");
    }

    public static void submitLogin(){
        Browser.driver.findElement(submitLoginButton).click();
    }

    public static void selectCashboxTab(){
        Browser.driver.findElement(cashboxTab).click();
    }
    public static void ensureHomePageIsOpened(){
        Assert.assertEquals(Browser.driver.findElement(By.cssSelector("#logo h1")).getText(), "Pragmatest");
    }
}
