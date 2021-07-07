package pages;
import org.openqa.selenium.By;
import utils.Browser;

public class IncomesAndExpenses {


    private static double balance;
    private static final By BALANCE = By.xpath("//div[@class=\"s_body selenium-total\"]");
    private static final By NEW_INCOME_BUTTON = By.xpath("//a[@class=\"btn-cashbox-add btn-green selenium-add-chashbox-in\"]");

    public static double getCurrentBalance(){
        String balanceString = Browser.driver.findElement(BALANCE).getText();
        balance = Double.parseDouble(balanceString.replace(" ", ""));
        return balance;
    }

    public static void addNewIncomeButtonClick(){
        Browser.driver.findElement(NEW_INCOME_BUTTON).click();
    }

    public static double getBalance() {
        return balance;
    }





}
