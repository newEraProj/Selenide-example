package StepDefs.Modules.Examination_screen;

import Helpers.SelectorsHelpers;
import Helpers.UtilsDate;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.concurrent.TimeUnit;

public class Examination_Product {
    @When("^Add Examination product \"([^\"]*)\" with expiration date = \"([^\"]*)\" and lot number = \"([^\"]*)\" on patient procedure$")
    public void add_Examination_product_with_expiration_date_and_lot_number_on_patient_procedure(String productCode, String expirationDate, String lotNumber){
        Boolean selected;
        this.add_Examination_product_on_patient_procedure(productCode);
        selected = Selenide.$(SelectorsHelpers.e2eSelector("tabs-list", "product-form-" + productCode))
                .isDisplayed();
        String expiryDate = UtilsDate.getExpirationDate(expirationDate);
        if(selected) {
            Selenide.$(SelectorsHelpers.e2eSelector("products", "product-form-" + productCode, "expiration-date")).setValue(expiryDate);
            Selenide.$(SelectorsHelpers.e2eSelector("products", "product-form-" + productCode, "lot")).setValue(lotNumber);
        }
    }

    @When("^Add Examination product \"([^\"]*)\" on patient procedure$")
    public void add_Examination_product_on_patient_procedure(String productCode){
        try {
            // Wait 1 second before put the product code, solves the problem of select that does not display sometimes
            TimeUnit.SECONDS.sleep(1);
            Selenide.$(SelectorsHelpers.e2eSelector("products", "products-input", "input"))
                    .setValue(productCode);
            Selenide.$(SelectorsHelpers.e2eSelector("products-input", "product-suggestion-"+productCode)).click();
            Selenide.$(SelectorsHelpers.e2eSelector("products", "products-input", "input"))
                    .clear();

        }catch (InterruptedException e){
            System.out.println(e);
        }
    }

    @Then("^Examination product \"([^\"]*)\" should be present (\\d+) times on patient procedure$")
    public void examination_product_should_be_present_times_on_patient_procedure(String productCode, int numberOfTimes){
        Selenide.$$(SelectorsHelpers.e2eSelector( "product-form-" + productCode ,"code"))
                .filter(Condition.value(productCode))
                .shouldHaveSize(numberOfTimes);
    }

    @When("^Delete Examination product \"([^\"]*)\"$")
    public void delete_Examination_product(String productCode) {
        Selenide.$(SelectorsHelpers.e2eSelector("tabs-list", "product-form-"+productCode, "delete-action")).click();
    }

    @Then("^The examination product \"([^\"]*)\" should not be visible on patient procedure$")
    public void the_examination_product_should_not_be_visible_on_patient_procedure(String productCode) {
        Selenide.$(SelectorsHelpers.e2eSelector("tabs-list", "product-form-"+productCode, "code")).shouldNotBe(Condition.visible);
    }


    @When("^Set \"([^\"]*)\" in search product on patient procedure$")
    public void set_in_search_product_on_patient_procedure(String productCode) throws Throwable {
        try {
            // Wait 1 second before put the product code, solves the problem of select that does not display sometimes
            TimeUnit.SECONDS.sleep(1);
            Selenide.$(SelectorsHelpers.e2eSelector("products", "products-input", "input"))
                    .setValue(productCode);
        }catch (InterruptedException e){
            System.out.println(e);
        }
    }

    @Then("^No suggestion is proposed in search product on patient procedure$")
    public void no_suggestion_is_proposed_in_search_product_on_patient_procedure() throws Throwable {
        Selenide.$(SelectorsHelpers.e2eSelector("tabs-list", "products-input-suggestions")).shouldBe(Condition.hidden);
    }

    @Then("^Product list is displayed in search product on patient procedure$")
    public void product_list_is_displayed_in_search_product_on_patient_procedure() throws Throwable {
        Selenide.$(SelectorsHelpers.e2eSelector("tabs-list", "products-input-suggestions")).shouldBe(Condition.visible);
    }

    @Then("^Suggestion \"([^\"]*)\" should be displayed in search product on patient procedure$")
    public void suggestion_should_be_displayed_in_search_product_on_patient_procedure(String productCode) throws Throwable {
        Selenide.$(SelectorsHelpers.e2eSelector("products-input", "product-suggestion-"+productCode)).shouldBe(Condition.visible);
    }

    @When("^Set selection \"([^\"]*)\" in search product on patient procedure$")
    public void set_selection_in_search_product_on_patient_procedure(String productCode) throws Throwable {
        Selenide.$(SelectorsHelpers.e2eSelector("products-input", "product-suggestion-"+productCode)).click();
        Selenide.$(SelectorsHelpers.e2eSelector("products", "products-input", "input"))
                .clear();
    }

    @Then("^Product \"([^\"]*)\" should be added on patient procedure$")
    public void product_should_be_added_on_patient_procedure(String productCode) throws Throwable {
        Selenide.$(SelectorsHelpers.e2eSelector("tabs-list", "product-form-"+productCode, "code")).shouldNotBe(Condition.visible);
    }


    @Then("^Products \"([^\"]*)\" and \"([^\"]*)\" should be linked on patient procedure$")
    public void products_and_should_be_linked_on_patient_procedure(String arg1, String arg2) throws Throwable {
        throw new Exception("TODO");
    }

    @Then("^An alert \"([^\"]*)\" is shown for Examination product \"([^\"]*)\" on patient procedure$")
    public void an_alert_is_shown_for_Examination_product_on_patient_procedure(String alert, String productCode) {
        Boolean selected;
        selected = Selenide.$(SelectorsHelpers.e2eSelector("tabs-list", "product-form-" + productCode))
                .isDisplayed();

        if(selected) {
            Selenide.$(SelectorsHelpers.e2eSelector("products", "product-form-" + productCode, "product-error-"+ alert)).isDisplayed();
        }
    }

    @When("^Delete Examination product \"([^\"]*)\" with expiration date = \"([^\"]*)\" and lot number = \"([^\"]*)\" on patient procedure$")
    public void delete_Examination_product_with_expiration_date_and_lot_number_on_patient_procedure(String productCode, String expirationDate, String lotNumber) {
        Boolean selected;
        String expiryDate = UtilsDate.getExpirationDate(expirationDate);
        selected = Selenide.$(SelectorsHelpers.e2eSelector("tabs-list", "product-form-" + productCode, "expiration-date")).is(Condition.text(expiryDate)) &&
                Selenide.$(SelectorsHelpers.e2eSelector("tabs-list", "product-form-" + productCode, "lot")).is(Condition.text(lotNumber));
        if(selected) {
            Selenide.$(SelectorsHelpers.e2eSelector("tabs-list", "product-form-"+productCode, "delete-action")).click();
        }
    }


    @Then("^product \"([^\"]*)\" should have no expiration date and no lot number on patient procedure$")
    public void product_should_have_no_expiration_date_and_no_lot_number_on_patient_procedure(String productCode) {
        Selenide.$(SelectorsHelpers.e2eSelector("tabs-list", "products", "product-form-" + productCode)).shouldBe(Condition.visible);
        Selenide.$(SelectorsHelpers.e2eSelector("tabs-list", "products", "product-form-" + productCode, "expiration-date")).shouldBe(Condition.empty);
        Selenide.$(SelectorsHelpers.e2eSelector("tabs-list", "products", "product-form-" + productCode, "lot")).shouldBe(Condition.empty);
    }


    @Then("^product \"([^\"]*)\" should have displayed with expiration date = \"([^\"]*)\" and lot number = \"([^\"]*)\" on patient procedure$")
    public void product_should_be_displayed_with_expiration_date_and_lot_number_on_patient_procedure(String productCode, String expdate, String lotNum) {
        Selenide.$(SelectorsHelpers.e2eSelector("tabs-list", "products", "product-form-" + productCode)).shouldBe(Condition.visible);
        Selenide.$(SelectorsHelpers.e2eSelector("tabs-list", "products", "product-form-" + productCode, "expiration-date")).shouldBe(Condition.value(expdate));
        Selenide.$(SelectorsHelpers.e2eSelector("tabs-list", "products", "product-form-" + productCode, "lot")).shouldBe(Condition.value(lotNum));
    }

    @When("^Update examination product \"([^\"]*)\" with expiration date = \"([^\"]*)\" and lot number = \"([^\"]*)\" on patient procedure$")
    public void update_examination_product_with_expiration_date_and_lot_number_on_patient_procedure(String productCode, String expirationDate, String lot) {

        String expiryDate = UtilsDate.getExpirationDate(expirationDate);

        Selenide.$(SelectorsHelpers.e2eSelector("tabs-list", "products", "product-form-" + productCode)).shouldBe(Condition.visible);
        Selenide.$(SelectorsHelpers.e2eSelector("tabs-list", "products", "product-form-" + productCode, "expiration-date")).setValue(expiryDate);
        Selenide.$(SelectorsHelpers.e2eSelector("tabs-list", "products", "product-form-" + productCode, "lot")).setValue(lot);
    }

    @Then("^The examination product \"([^\"]*)\" should be added to procedure \"([^\"]*)\" on patient procedure$")
    public void the_examination_product_should_be_added_to_procedure_on_patient_procedure(String productCode, String procedureAN) {
        Selenide.$(SelectorsHelpers.e2eSelector("tabs-list", "products", "product-form-" + productCode, "code")).isDisplayed();
    }

    @When("^Update examination product \"([^\"]*)\" with lot number = \"([^\"]*)\" on patient procedure$")
    public void update_examination_product_with_lot_number_on_patient_procedure(String productCode, String lot) {
        Selenide.$(SelectorsHelpers.e2eSelector("tabs-list", "products", "product-form-" + productCode)).shouldBe(Condition.visible);
        Selenide.$(SelectorsHelpers.e2eSelector("tabs-list", "products", "product-form-" + productCode, "lot")).setValue(lot);
    }

    @Then("^The examination product \"([^\"]*)\" lot number = \"([^\"]*)\" should be displayed to procedure \"([^\"]*)\" on patient procedure$")
    public void the_examination_product_lot_number_should_be_displayed_to_procedure_on_patient_procedure(String productCode, String lot) throws Throwable {
        Selenide.$(SelectorsHelpers.e2eSelector("tabs-list", "products", "product-form-" + productCode, "code")).isDisplayed();
        Selenide.$(SelectorsHelpers.e2eSelector("tabs-list", "products", "product-form-" + productCode, "lot")).equals(Condition.text(lot));
    }
}
