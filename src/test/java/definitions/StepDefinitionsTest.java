package definitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import org.decimal4j.util.DoubleRounder;
import org.testng.Assert;
import pages.*;
import utils.Browser;


public class StepDefinitionsTest {
    double currentBalance;
    double income;


    @Before
    public void setup(){
        Browser.setup();
    }
    @After
    public void quit(){
        Browser.quit();
    }

    @Given("User is on login page")
    public void user_is_on_login_page() {
        LoginPage.goToPage();
    }

    @When("he enters username and password")
    public void he_enters_username_and_password() {
        LoginPage.inputCredentials();
    }

    @When("clicks on login button")
    public void click_on_login_button() {
        LoginPage.submitLogin();
    }

    @Then("User is navigated to the homepage")
    public void user_is_navigated_to_the_homepage() {
        LoginPage.ensureHomePageIsOpened();
    }

    @Then("clicks on Cash box in the header tab")
    public void clicks_on_cashbox_in_the_header_tab() {
        LoginPage.selectCashboxTab();
    }


    @When("user clicks on new income button")
    public void user_clicks_on_new_income_button() {
        currentBalance = IncomesAndExpenses.getCurrentBalance();
        IncomesAndExpenses.addNewIncomeButtonClick();
    }

    @Then("new income submission form opens")
    public void new_income_submission_form_opens() {
        NewIncomeFormPage.ensureFormPageOpened();
    }

    @Then("user ensures the current date is selected by default")
    public void user_ensures_the_current_date_is_chosen() {
        NewIncomeFormPage.checkDate();
    }

    @Then("Income radio button is selected by default")
    public void income_radio_button_is_selected() {
        NewIncomeFormPage.checkRadioButtonIncome();
    }

    @Then("user types the new amount {string}")
    public void user_types_the_new_amount(String incomeAmount) {
        NewIncomeFormPage.inputNewIncome(incomeAmount);
        income = DoubleRounder.round(Double.parseDouble(incomeAmount), 2);
    }

    @Then("types the payment reason {string}")
    public void types_the_payment_reason(String reason) {
        NewIncomeFormPage.inputPaymentReason(reason);
    }

    @Then("clicks on the Submit button")
    public void clicks_on_the_submit_button() {
        NewIncomeFormPage.submitNewIncome();

    }
    @Then("Checks the confirmation message is displayed")
    public void confirmation_message_is_displayed(){
        NewIncomeFormPage.confirmationMessageIsCorrect();
    }

    @Then("new amount should be successfully added to the total amount")
    public void new_amount_should_be_successfully_added_to_the_total_amount() {
        Assert.assertEquals(DoubleRounder.round((IncomesAndExpenses.getBalance() + income),2), IncomesAndExpenses.getCurrentBalance());
    }
    @Then("{string} error message should appear")
    public void message_should_appear(String string) {
        NewIncomeFormPage.ensureErrorMessageAppeared(string);
    }

    @And("types category {string} in the New Category text field")
    public void typesInTheNewCategoryTextField(String category) {
        NewIncomeFormPage.createNewCategory(category);
    }

    @Then("checks if the new category {string} is now an option in category dropdown list")
    public void checksIfTheNewCategoryIsNowAnOptionInCategoryDropdownList(String category) {
        NewIncomeFormPage.newCategorySuccessfullyAddedCheck(category);
    }


}
