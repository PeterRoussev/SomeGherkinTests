package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import utils.Browser;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class NewIncomeFormPage {
    private static final By NEW_INCOME_PAGE_TITLE = By.xpath("//div[@id=\"headline2\"]/h2");
    private static final By INCOME_RADIO_BUTTON = By.xpath("//input[@value=\"0\"]");
    private static final By CONFIRMATION_MESSAGE = By.xpath("//div[@id=\"okmsg\"]");
    private static final By DATE_FIELD = By.xpath("//input[@id=\"dt1\"]");
    private static final By NEW_INCOME_INPUT_FIELD = By.xpath("//span[@id=\"cashbox_currency\"]/preceding-sibling::input");
    private static final By PAYMENT_REASON_FIELD = By.xpath("//input[@id=\"cbTitle\"]");
    private static final By SUBMIT_BUTTON = By.xpath("//input[@type=\"submit\"]");
    private static final By ERROR_MESSAGE = By.cssSelector("#error");
    private static final By NEW_CATEGORY_INPUT_FIELD = By.cssSelector("input#cashbox-category");
    private static final By CATEGORY_DROPDOWN_LIST = By.cssSelector("select#cashbox-category-selector");

    public static void checkDate(){
        Date date = Calendar.getInstance().getTime();
        DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        String dateToString = dateFormat.format(date);
        String dateField = Browser.driver.findElement(DATE_FIELD).getAttribute("value");
        Assert.assertEquals(dateField, dateToString);
    }
    public static void checkRadioButtonIncome(){
        Assert.assertTrue(Browser.driver.findElement(INCOME_RADIO_BUTTON).isSelected());
    }
    public static void inputNewIncome(String incomeAmount){
        Browser.driver.findElement(NEW_INCOME_INPUT_FIELD).sendKeys(incomeAmount);
    }
    public static void inputPaymentReason(String reason){
        Browser.driver.findElement(PAYMENT_REASON_FIELD).sendKeys(reason);

    }
    public static void submitNewIncome(){
        Browser.driver.findElement(SUBMIT_BUTTON).click();
    }

    public static void confirmationMessageIsCorrect(){
        String message = Browser.driver.findElement(CONFIRMATION_MESSAGE).getText();
        Assert.assertTrue(message.contains("Информацията е добавена успешно."));
    }
    public static void ensureFormPageOpened(){
        Assert.assertEquals(Browser.driver.findElement(NEW_INCOME_PAGE_TITLE).getText(), "Нов приход / разход");
    }

    public static void ensureErrorMessageAppeared(String message){
        String errorMessage = Browser.driver.findElement(ERROR_MESSAGE).getText();
        Assert.assertTrue(errorMessage.contains(message));
    }

    public static void createNewCategory(String category){
        Browser.driver.findElement(NEW_CATEGORY_INPUT_FIELD).sendKeys(category);
    }

    public static void newCategorySuccessfullyAddedCheck(String category){
        Select categoryDropdown = new Select(Browser.driver.findElement(CATEGORY_DROPDOWN_LIST));
        List<WebElement> dropdownList =  categoryDropdown.getOptions();
        ArrayList <String> categories = new ArrayList<>();
        for (WebElement cat : dropdownList) {
            categories.add(cat.getText());
        }
        Assert.assertTrue(categories.contains(category));
    }

}
