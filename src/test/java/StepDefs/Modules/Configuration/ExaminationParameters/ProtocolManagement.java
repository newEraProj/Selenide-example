package StepDefs.Modules.Configuration.ExaminationParameters;

import Helpers.SelectorsHelpers;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.java.eo.Se;
import org.openqa.selenium.By;

public class ProtocolManagement {
    @Given("^Go to examination parameters$")
    public void go_to_examination_parameters() {
        Selenide.$(SelectorsHelpers.e2eSelector("config", "menu", "examination-parameters")).click();
    }

    @When("^The protocol library is a flat list$")
    public void the_protocol_library_is_a_flat_list() {
        Selenide.$("[e2e-id='config menu page protocols list']").isDisplayed();
    }

    @Then("^Click on edit the protocol$")
    public void click_on_edit_the_protocol() {
        Selenide.$("[e2e-id='config menu page protocols protocol header edit']").click();
    }

    @Then("^Click on reset the protocol creation form$")
    public void click_on_reset_the_protocol_creation_form() {
        Selenide.$(SelectorsHelpers.e2eSelector("config", "menu", "reset-button")).click();
    }

    @Then("^Click on Cancel$")
    public void click_on_Cancel() {
        Selenide.$("[e2e-id='config menu page protocol-edition-modal confirm-modal cancel-button button']").click();
    }

    @Given("^Open the injection library create a new protocol\\. Fill in all mandotory filed and save the protocol$")
    public void open_the_injection_library_create_a_new_protocol_Fill_in_all_mandotory_filed_and_save_the_protocol() {
        Selenide.$("[e2e-id=config-link]").click();
        Selenide.$("[e2e-id='config menu injection-protocols']").click();
        Selenide.$("[e2e-id='config menu page protocols create-button button']").click();

        Selenide.$("[e2e-id='config menu page protocol-edition-modal modal name-input']").sendKeys(""); //name field
        Selenide.$("[e2e-id='config menu page protocol-edition-modal modal procedures-input input']").sendKeys("C"); // typing C in procedures field
        Selenide.$(By.xpath("//*[@id=\"procedures-card\"]/div[2]/app-procedures-input/div/div[2]/ul/li[1]/span[2]")).click(); // procedure shoosing
        Selenide.$(By.cssSelector("[e2e-id~='protocol-edition-modal'][e2e-id~='minWeight-input']")).sendKeys("30");//min weight
        Selenide.$(By.cssSelector("[e2e-id~='protocol-edition-modal'][e2e-id~='maxWeight-input']")).sendKeys("45");//max weight

        Selenide.$("[e2e-id='config menu page protocol-edition-modal modal min-bmi-input']").sendKeys("17");//min BMI range
        Selenide.$("[e2e-id='config menu page protocol-edition-modal modal max-bmi-input']").sendKeys("21");//max BMI range


        Selenide.$("[e2e-id='config menu page protocol-edition-modal modal peak-pressure-input']").sendKeys("200"); // peak pressure
        Selenide.$("[e2e-id='config menu page protocol-edition-modal modal injection-delay-input']").sendKeys("10"); //injection delay
        Selenide.$("[e2e-id='config menu page protocol-edition-modal modal scan-delay-input']").sendKeys("20"); // scan delay

        //phase fields
        Selenide.$("[e2e-id='config menu page protocol-edition-modal modal injection-delay-input']").sendKeys("10"); //injection delay
        Selenide.$("[e2e-id='config menu page protocol-edition-modal modal scan-delay-input']").sendKeys("20"); // scan delay
        Selenide.$("[e2e-id='config menu page protocol-edition-modal modal catheter-5']").click(); // cathether size
        Selenide.$("[e2e-id='config menu page protocol-edition-modal modal 'peak-pressure' + PSI']"); // unit choosing PSI
        Selenide.$("[e2e-id='config menu page protocol-edition-modal modal concentration-unit-mmol/mL']").click();//unit mg/mL choosing

        Selenide.$("[e2e-id='config menu page protocol-edition-modal modal save-button button']").shouldBe(Condition.enabled).click();
        System.out.println("Unable save the protocol ");
        System.out.println("");

    }

    @Given("^Go to the protocol library and delete an injection protocol from the list$")
    public void go_to_the_protocol_library_and_delete_an_injection_protocol_from_the_list() {
        Selenide.$("[e2e-id=config-link]").click(); //link to config page

        Selenide.$("[e2e-id='config menu injection-protocols']").click();

        Selenide.$(By.xpath("/html/body/app-root/div/div/main/app-config/div/div/div/ng-component/div/div[1]/div[2]/table/tbody/tr[1]/td")).click();

        Selenide.$("[e2e-id='config menu page protocols protocol header delete']").click();
    }

    @When("^Cancel the pop-up message$")
    public void cancel_the_pop_up_message() {
        Selenide.$("[e2e-id='config menu page delete-modal cancel-button button']").click();
    }

    @Then("^The injection protocol isn't deleted$")
    public void the_injection_protocol_isn_t_deleted() {
        Selenide.$(By.xpath("/html/body/app-root/div/div/main/app-config/div/div/div/ng-component/div/div[1]/div[2]/table/tbody/tr[1]/td")).isDisplayed();
    }

    @Then("^Delete the protocol\\. Confirm the pop-up$")
    public void delete_the_protocol_Confirm_the_pop_up() {
        Selenide.$("[e2e-id='config menu page protocols protocol header delete']").click();
        Selenide.$("[e2e-id='config menu page delete-modal delete-button button']").click();
    }

    @Then("^The injection protocol is deleted$")
    public void the_injection_protocol_is_deleted() {
        Selenide.$("[e2e-id='config menu page protocols list']").shouldNotHave(Condition.text("CCT"));
    }

    @Given("^Go to the protocol library, open a protocol\\. Duplicate it$")
    public void go_to_the_protocol_library_open_a_protocol_Duplicate_it() {
        Selenide.$("[e2e-id=config-link]").click(); //link to config page
        Selenide.$("[e2e-id='config menu injection-protocols']").click();
        Selenide.$("[e2e-id='config menu page protocols list  active']").click();
        Selenide.$("[e2e-id='config menu page protocols protocol header duplicate']").click();
    }
    //


    @Given("^Go to Protocol management screen$")
    public void go_to_Protocol_management_screen() {
        Selenide.$(SelectorsHelpers.e2eSelector("config", "injection-protocols")).click();
    }

    @Given("^Click add new protocol on protocol management screen$")
    public void click_add_new_protocol_on_protocol_management_screen() {
        Selenide.$(SelectorsHelpers.e2eSelector("config", "create-protocol-action")).click();
    }

    @When("^Set the weight range min =\"([^\"]*)\" kg, max= \"([^\"]*)\" kg on protocol creation modal$")
    public void set_the_weight_range_min_kg_max_kg_on_protocol_creation_modal(String arg1, String arg2) {
        Selenide.$(SelectorsHelpers.e2eSelector("minWeight-input")).clear();
        Selenide.$(SelectorsHelpers.e2eSelector("minWeight-input")).sendKeys(arg1);
        Selenide.$(SelectorsHelpers.e2eSelector("maxWeight-input")).clear();
        Selenide.$(SelectorsHelpers.e2eSelector("maxWeight-input")).sendKeys(arg2);
    }


    @When("^Type \"([^\"]*)\" in procedures on protocol creation modal$")
    public void type_in_procedures_on_protocol_creation_modal(String arg1) {
        Selenide.$(SelectorsHelpers.e2eSelector("config", "menu", "page", "protocol-edition-modal", "modal", "procedures-input", "input")).clear();
        Selenide.$(SelectorsHelpers.e2eSelector("config", "menu", "page", "protocol-edition-modal", "modal", "procedures-input", "input")).sendKeys(arg1);
        Selenide.$(SelectorsHelpers.e2eSelector("config", "menu", "page", "protocol-edition-modal", "modal", "procedures-input", "input")).click();
    }

    @Then(("^The following procedures types are screened \"([^\"]*)\" on protocol creation modal$"))
    public void the_following_procedures_types_are_screened_on_protocol_creation_modal(String arg1) {
        String[] procedures_types = arg1.split(",");
        for (String dt : procedures_types) {

            Selenide.$(SelectorsHelpers.e2eSelector("protocol-edition-modal", "modal"))
                    .shouldHave(Condition.text(dt));
        }
    }

    @Then("^Pediatric age limit is screened and equals to \"([^\"]*)\" on protocol creation modal$")
    public void pediatric_age_limit_is_screened_and_equals_to_on_protocol_creation_modal(String arg1) {
        Selenide.$(SelectorsHelpers.e2eSelector("protocol-edition-modal", "modal"))
                .shouldHave(Condition.text("Pediatric age limit is " + arg1 + " years"));
    }

    @When("^Switch on button pediatic use on protocol creation modal$")
    public void switch_on_button_pediatic_use_on_protocol_creation_modal() {
        Selenide.$(SelectorsHelpers.e2eSelector("config", "menu", "page", "protocol-edition-modal", "modal", "pediatric-input")).doubleClick();
    }

    @Then("^BMI section is disappeared on protocol creation modal$")
    public void bmi_section_is_disappeared_on_protocol_creation_modal() {
        Selenide.$("min-bmi-input").shouldNotBe(Condition.visible);
    }

    @Given("^Set the BMI range to \"([^\"]*)\" - \"([^\"]*)\" on protocol creation modal$")
    public void set_the_BMI_range_to_on_protocol_creation_modal(String min, String max) {
        Selenide.$(SelectorsHelpers.e2eSelector("config", "menu", "page", "modal", "min-bmi-input")).clear();
        Selenide.$(SelectorsHelpers.e2eSelector("config", "menu", "page", "modal", "max-bmi-input")).clear();

        Selenide.$(SelectorsHelpers.e2eSelector("config", "menu", "page", "modal", "min-bmi-input")).sendKeys(min);
        Selenide.$(SelectorsHelpers.e2eSelector("config", "menu", "page", "modal", "max-bmi-input")).sendKeys(max);
    }

    @Given("^Click on protocol creation modal$")
    public void click_on_protocol_creation_modal() {
        Selenide.$(SelectorsHelpers.e2eSelector("protocol-edition-modal", "modal")).click();
    }

    @Then("^The BMI range is edited to \"([^\"]*)\" - \"([^\"]*)\" on protocol creation modal$")
    public void the_BMI_range_is_edited_to_on_protocol_creation_modal(String min, String max) {
        Selenide.$(SelectorsHelpers.e2eSelector("config", "menu", "page", "modal", "min-bmi-input")).shouldHave(Condition.value(min));
        Selenide.$(SelectorsHelpers.e2eSelector("config", "menu", "page", "modal", "max-bmi-input")).shouldHave(Condition.value(max));
    }

    @Then("^There is an error message \"([^\"]*)\" on protocol creation modal$")
    public void there_is_an_error_message_on_protocol_creation_modal(String arg1) {
        Selenide.$(SelectorsHelpers.e2eSelector("protocol-edition-modal", "modal")).shouldHave(Condition.text(arg1));
    }

    @Given("^Set name to \"([^\"]*)\" on protocol creation modal$")
    public void set_name_to_on_protocol_creation_modal(String name) {
        Selenide.$(SelectorsHelpers.e2eSelector("config", "menu", "name-input")).click();
        Selenide.$(SelectorsHelpers.e2eSelector("config", "menu", "name-input")).clear();
        Selenide.$(SelectorsHelpers.e2eSelector("config", "menu", "name-input")).sendKeys(name);
    }

    @Given("^Set peak pressure value to \"([^\"]*)\" on protocol creation modal$")
    public void set_peak_pressure_value_to_on_protocol_creation_modal(String value) {
        Selenide.$(SelectorsHelpers.e2eSelector("config", "menu", "peak-pressure-input")).click();
        Selenide.$(SelectorsHelpers.e2eSelector("config", "menu", "peak-pressure-input")).clear();
        Selenide.$(SelectorsHelpers.e2eSelector("config", "menu", "peak-pressure-input")).sendKeys(value);
    }

    @Then("^Every field are empty except the peak pressure unit set to \"([^\"]*)\"$")
    public void every_field_are_empty_except_the_peak_pressure_unit_set_to(String unit) {
        Selenide.$(SelectorsHelpers.e2eSelector("config", "menu", "name-input")).shouldBe(Condition.empty);
        Selenide.$(SelectorsHelpers.e2eSelector("config", "menu", "page", "modal", "min-bmi-input")).shouldBe(Condition.empty);
        Selenide.$(SelectorsHelpers.e2eSelector("config", "menu", "page", "modal", "max-bmi-input")).shouldBe(Condition.empty);
        Selenide.$(SelectorsHelpers.e2eSelector("minWeight-input")).shouldBe(Condition.empty);
        Selenide.$(SelectorsHelpers.e2eSelector("maxWeight-input")).shouldBe(Condition.empty);
        Selenide.$(SelectorsHelpers.e2eSelector("config", "peak-pressure-unit-option-" + unit)).shouldBe(Condition.enabled);
    }

    @Then("^An error message should be displayed on min weight field on protocol creation modal$")
    public void an_error_message_should_be_displayed_on_min_weight_field_on_protocol_creation_modal() {
        Selenide.$(SelectorsHelpers.e2eSelector("protocol-edition-modal", "min-weight-error")).isDisplayed();
    }

    @Then("^An error message should be displayed on max weight field on protocol creation modal$")
    public void an_error_message_should_be_displayed_on_max_weight_field_on_protocol_creation_modal() {
        Selenide.$(SelectorsHelpers.e2eSelector("protocol-edition-modal", "max-weight-error")).isDisplayed();
    }

    @Then("^An error message should be displayed on patient block on protocol creation modal$")
    public void an_error_message_should_be_displayed_on_patient_block_on_protocol_creation_modal() {
        Selenide.$(SelectorsHelpers.e2eSelector("protocol-edition-modal", "patient-error")).isDisplayed();
    }

    @Given("^Add phase on protocol creation modal$")
    public void add_phase_on_protocol_creation_modal() throws InterruptedException {
        Thread.sleep(1000); // using sleep here to wait for button be interactive
        Selenide.$(SelectorsHelpers.e2eSelector("config", "menu", "add-phase-action")).shouldBe(Condition.visible).click();
    }

    @When("^There is no default value for product type in the phase on protocol creation modal$")
    public void there_is_no_default_value_for_product_type_in_the_phase_on_protocol_creation_modal() {
        Selenide.$(SelectorsHelpers.e2eSelector("config", "menu", "modal", "phase-product-select")).shouldBe(Condition.disabled);
    }

    @Then("^Set the type of phase to Injection on protocol creation modal$")
    public void set_the_type_of_phase_to_Injection_on_protocol_creation_modal() {
        Selenide.$(SelectorsHelpers.e2eSelector("config", "phase-types-injection")).click();
    }

    @Then("^Click on product on phase on protocol creation modal$")
    public void click_on_product_on_phase_on_protocol_creation_modal() {
        Selenide.$(SelectorsHelpers.e2eSelector("config", "menu", "phase-product-select")).shouldBe(Condition.enabled).click();
    }

    @Then("^Product should have following values: \"([^\"]*)\" on phase on protocol creation modal$")
    public void product_should_have_following_values_on_phase_on_protocol_creation_modal(String productsTypes) {
        Selenide.$(SelectorsHelpers.e2eSelector("config", "menu", "phase-product-select", "product-contrast")).shouldBe(Condition.visible);
        Selenide.$(SelectorsHelpers.e2eSelector("config", "menu", "phase-product-select", "product-saline")).shouldBe(Condition.visible);
    }

    @Then("^Click on the types of injection product  in the phase on protocol creation modal$")
    public void click_on_the_types_of_injection_product_in_the_phase_on_protocol_creation_modal() {
        Selenide.$(SelectorsHelpers.e2eSelector("config", "menu", "phase-type-select")).click();
    }

    @Then("^The following phase types should be presented : \"([^\"]*)\" on protocol creation screen$")
    public void the_following_phase_types_should_be_presented_on_protocol_creation_screen(String procedureTypes) {
        Selenide.$(SelectorsHelpers.e2eSelector("config", "menu", "phase-types-injection")).shouldBe(Condition.visible);
        Selenide.$(SelectorsHelpers.e2eSelector("config", "menu", "phase-types-pause")).shouldBe(Condition.visible);
        Selenide.$(SelectorsHelpers.e2eSelector("config", "menu", "phase-types-wait")).shouldBe(Condition.visible);
        Selenide.$(SelectorsHelpers.e2eSelector("config", "menu", "phase-types-optibolus")).shouldBe(Condition.visible);
        Selenide.$(SelectorsHelpers.e2eSelector("config", "menu", "phase-types-timingbolus")).shouldBe(Condition.visible);
    }

    @When("^Set flowrate to \"([^\"]*)\" on protocol creation modal$")
    public void set_flowrate_to_on_protocol_creation_modal(String flowrate) {
        Selenide.$(SelectorsHelpers.e2eSelector("config", "menu", "flow-rate-input")).clear();
        Selenide.$(SelectorsHelpers.e2eSelector("config", "menu", "flow-rate-input")).sendKeys(flowrate);
    }

    @Then("^the flowrate value is presented and should be \"([^\"]*)\"$")
    public void the_flowrate_value_is_presented_and_should_be(String flowrate) {
        Selenide.$(SelectorsHelpers.e2eSelector("config", "menu", "flow-rate-input")).shouldHave(Condition.value(flowrate));
    }

    @When("^Set volume to \"([^\"]*)\" on protocol creation modal$")
    public void set_volume_to_on_protocol_creation_modal(String volume) {
        Selenide.$(SelectorsHelpers.e2eSelector("config", "menu", "modal", "volume-input")).clear();
        Selenide.$(SelectorsHelpers.e2eSelector("config", "menu", "modal", "volume-input")).sendKeys(volume);
    }

    @Then("^The volume value is presented and equals to\"([^\"]*)\" with unit mL on protocol creation modal$")
    public void the_volume_value_is_presented_and_equals_to_with_unit_mL_on_protocol_creation_modal(String volume) {
        Selenide.$(SelectorsHelpers.e2eSelector("config", "menu", "modal", "volume-input")).shouldHave(Condition.value(volume));
    }

    @Then("^The error message should be Value cannot exceed (\\d+) on flowrate section on protocol creation modal$")
    public void the_error_message_should_be_Value_cannot_exceed_on_flowrate_section_on_protocol_creation_modal(int arg1) {
        Selenide.$(SelectorsHelpers.e2eSelector("config", "menu", "flowrate-error-2")).shouldBe(Condition.visible);
    }

    @Then("^The error message should be Value cannot be lower than (\\d+)\\.(\\d+) on flowrate section on protocol creation modal$")
    public void the_error_message_should_be_Value_cannot_be_lower_than_on_flowrate_section_on_protocol_creation_modal(int arg1, int arg2) {
        Selenide.$(SelectorsHelpers.e2eSelector("config", "menu", "flowrate-error-1")).shouldBe(Condition.visible);
    }

    @Then("^The duration field should be empty on protocol creation modal$")
    public void the_duration_field_should_be_empty_on_protocol_creation_modal() {
        Selenide.$(SelectorsHelpers.e2eSelector("config", "menu", "duration-input")).shouldBe(Condition.empty);
    }

    @Then("^The duration field should be \"([^\"]*)\" on protocol creation modal$")
    public void the_duration_field_should_be_on_protocol_creation_modal(String duration) {
        Selenide.$(SelectorsHelpers.e2eSelector("config", "menu", "duration-input")).shouldHave(Condition.value(duration));
    }

    @Given("^Set product to \"([^\"]*)\" on the phase on protocol creation modal$")
    public void set_product_to_on_the_phase_on_protocol_creation_modal(String product) {
        Selenide.$(SelectorsHelpers.e2eSelector("config", "menu", "page", "product-" + product)).click();
    }

    @Then("^The folowing percentage of contrast:(\\d+),(\\d+),(\\d+),(\\d+),(\\d+),(\\d+),(\\d+) should be availible on protocol creation modal$")
    public void the_folowing_percentage_of_contrast_should_be_availible_on_protocol_creation_modal(int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7) {
        Selenide.$(SelectorsHelpers.e2eSelector("config", "menu", "phase-contrast-rate-select")).click();
        Selenide.$(SelectorsHelpers.e2eSelector("config", "menu", "contrast-rate20")).shouldBe(Condition.visible);
        Selenide.$(SelectorsHelpers.e2eSelector("config", "menu", "contrast-rate30")).shouldBe(Condition.visible);
        Selenide.$(SelectorsHelpers.e2eSelector("config", "menu", "contrast-rate40")).shouldBe(Condition.visible);
        Selenide.$(SelectorsHelpers.e2eSelector("config", "menu", "contrast-rate50")).shouldBe(Condition.visible);
        Selenide.$(SelectorsHelpers.e2eSelector("config", "menu", "contrast-rate60")).shouldBe(Condition.visible);
        Selenide.$(SelectorsHelpers.e2eSelector("config", "menu", "contrast-rate70")).shouldBe(Condition.visible);
        Selenide.$(SelectorsHelpers.e2eSelector("config", "menu", "contrast-rate80")).shouldBe(Condition.visible);
    }

    @Then("^You can't add more than (\\d+) phases$")
    public void you_can_t_add_more_than_phases(int arg1) {
        Selenide.$(SelectorsHelpers.e2eSelector("config", "menu", "add-phase-action")).shouldBe(Condition.disappear);
    }

    @When("^Add (\\d+) th phase on protocol creation modal$")
    public void add_th_phase_on_protocol_creation_modal(int arg1) {
        Selenide.$(SelectorsHelpers.e2eSelector("config", "menu", "add-phase-action")).shouldBe(Condition.disappear);
    }

    @Given("^Set contrast rate to \"([^\"]*)\" on phase on protocol creation modal$")
    public void set_contrast_rate_to_on_phase_on_protocol_creation_modal(String rate) {
        Selenide.$(SelectorsHelpers.e2eSelector("config", "menu", "contrast-rate" + rate)).click();
    }

    @When("^Set the type of phase to Pause on phase on protocol creation modal$")
    public void set_the_type_of_phase_to_Pause_on_phase_on_protocol_creation_modal() {
        Selenide.$(SelectorsHelpers.e2eSelector("config", "phase-2", "phase-type-select", "phase-types-pause")).click();
    }

    @Then("^The fields product, flowrate, volume, contrast and duration should be reset on phase on protocol creation modal$")
    public void the_fields_product_flowrate_volume_contrast_and_duration_should_be_reset_on_phase_on_protocol_creation_modal() {
        Selenide.$(SelectorsHelpers.e2eSelector("config", "menu", "phase-product-select")).shouldHave(Condition.value(""));
        Selenide.$(SelectorsHelpers.e2eSelector("config", "menu", "flow-rate-input")).shouldHave(Condition.value(""));
        Selenide.$(SelectorsHelpers.e2eSelector("config", "menu", "volume-input")).shouldHave(Condition.value(""));
        Selenide.$(SelectorsHelpers.e2eSelector("config", "menu", "phase-contrast-rate-select")).shouldHave(Condition.value(""));
        Selenide.$(SelectorsHelpers.e2eSelector("config", "menu", "duration-input")).shouldHave(Condition.value(""));
    }

    @Then("^The fields product, flowrate, volume and contrast should be disabled$")
    public void the_fields_product_flowrate_volume_and_contrast_should_be_disabled() {
        Selenide.$(SelectorsHelpers.e2eSelector("config", "menu", "phase-product-select")).shouldBe(Condition.disabled);
        Selenide.$(SelectorsHelpers.e2eSelector("config", "menu", "flow-rate-input")).shouldBe(Condition.disabled);
        Selenide.$(SelectorsHelpers.e2eSelector("config", "menu", "volume-input")).shouldBe(Condition.disabled);
        Selenide.$(SelectorsHelpers.e2eSelector("config", "menu", "phase-contrast-rate-select")).shouldBe(Condition.disabled);

        Selenide.$(SelectorsHelpers.e2eSelector("config", "menu", "duration-input")).shouldBe(Condition.enabled);
    }

    @Given("^Choose protocol \"([^\"]*)\" on protocol management screen$")
    public void choose_protocol_on_protocol_management_screen(String protocolName) {
        Selenide.$(SelectorsHelpers.e2eSelector("config", "menu", "protocols", "library")).find(".clr-treenode-caret").click();
        Selenide.$(SelectorsHelpers.e2eSelector("config", "menu", "protocols", "family")).find(".clr-treenode-caret").click();
        Selenide.$$(SelectorsHelpers.e2eSelector("config", "show-protocol-button")).find(Condition.text(protocolName)).click();
        Selenide.$$(SelectorsHelpers.e2eSelector("config", "show-protocol-button")).find(Condition.text(protocolName)).shouldBe(Condition.visible);
    }

    @When("^Click delete on protocol management screen$")
    public void click_delete_on_protocol_management_screen() {
        Selenide.$(SelectorsHelpers.e2eSelector("config", "protocol", "header", "delete")).click();
    }

    @Then("^A deletion pop-up should be displayed on protocol management screen$")
    public void a_deletion_pop_up_should_be_displayed_on_protocol_management_screen() {
        Selenide.$(SelectorsHelpers.e2eSelector("config", "delete-modal")).shouldBe(Condition.visible);
    }

    @When("^Cancel deletion pop up on protocol management screen$")
    public void cancel_deletion_pop_up_on_protocol_management_screen() {
        Selenide.$(SelectorsHelpers.e2eSelector("config", "delete-modal", "cancel-button")).click();
    }

    @Then("^The procedure \"([^\"]*)\" should not be deleted on protocol management screen$")
    public void the_procedure_should_not_be_deleted_on_protocol_management_screen(String protocolName) throws Throwable {
        Selenide.$$(SelectorsHelpers.e2eSelector("config", "show-protocol-button")).find(Condition.text(protocolName)).shouldBe(Condition.visible);
    }

    @When("^Confirm deletion pop-up on protocol management screen$")
    public void confirm_deletion_pop_up_on_protocol_management_screen() {
        Selenide.$(SelectorsHelpers.e2eSelector("config", "delete-modal", "delete-button")).click();
    }

    @Then("^The procedure \"([^\"]*)\" should be deleted on protocol management screen$")
    public void the_procedure_should_be_deleted_on_protocol_management_screen(String protocolName) {
        Selenide.$$(SelectorsHelpers.e2eSelector("config", "show-protocol-button")).find(Condition.text(protocolName)).shouldNotBe(Condition.visible);
    }

    @Given("^Edit protocol on protocol management screen$")
    public void edit_protocol_on_protocol_management_screen() {
        Selenide.$(SelectorsHelpers.e2eSelector("config", "protocol", "header", "edit")).click();
    }

    @Given("^Add phase to protocol on protocol creation modal$")
    public void add_phase_to_protocol_on_protocol_creation_modal() {
        Selenide.$(SelectorsHelpers.e2eSelector("config", "protocol-edition-modal", "add-phase-action", "add-phase-action")).click();
    }

    @Given("^Set \"([^\"]*)\" type of protocol on protocol creation modal$")
    public void set_type_of_protocol_on_protocol_creation_modal(String phaseType) {
        Selenide.$(SelectorsHelpers.e2eSelector("config", "protocol-edition-modal", "phase-2", "phase-type-select")).click();
        Selenide.$(SelectorsHelpers.e2eSelector("config", "protocol-edition-modal", "phase-2", "phase-types-" + phaseType)).click();
    }

    @Given("^Set \"([^\"]*)\" as product of phase on protocol creation modal$")
    public void set_as_product_of_phase_on_protocol_creation_modal(String product) {
        Selenide.$(SelectorsHelpers.e2eSelector("config", "phase-2", "phase-product-select")).click();
        Selenide.$(SelectorsHelpers.e2eSelector("config", "phase-2", "phase-product-select", "product-" + product)).click();
    }

    @Given("^Set \"([^\"]*)\" as flowrate of phase on protocol creation modal$")
    public void set_as_flowrate_of_phase_on_protocol_creation_modal(String flowrate) {
        Selenide.$(SelectorsHelpers.e2eSelector("config", "protocol-edition-modal", "phase-2", "flow-rate-input")).click();
        Selenide.$(SelectorsHelpers.e2eSelector("config", "protocol-edition-modal", "phase-2", "flow-rate-input")).sendKeys(flowrate);
    }

    @Given("^Set \"([^\"]*)\" as volume of phase on protocol creation modal$")
    public void set_as_volume_of_phase_on_protocol_creation_modal(String volume) {
        Selenide.$(SelectorsHelpers.e2eSelector("config", "protocol-edition-modal", "phase-2", "volume-input")).click();
        Selenide.$(SelectorsHelpers.e2eSelector("config", "protocol-edition-modal", "phase-2", "volume-input")).sendKeys(volume);
    }

    @Given("^Set \"([^\"]*)\" as contrast of phase on protocol creation modal$")
    public void set_as_contrast_of_phase_on_protocol_creation_modal(String contrast) {
        Selenide.$(SelectorsHelpers.e2eSelector("config", "protocol-edition-modal", "phase-2", "contrast-rate-select")).click();
        Selenide.$(SelectorsHelpers.e2eSelector("config", "protocol-edition-modal", "phase-2", "contrast-rate" + contrast)).click();
    }

    @Given("^Save protocol on protocol creation modal$")
    public void save_protocol_on_protocol_creation_modal() {
        Selenide.$(SelectorsHelpers.e2eSelector("config", "protocol-edition-modal", "save-button")).click();
    }

    @Then("^Protocol \"([^\"]*)\" should be saved on protocol management screen$")
    public void protocol_should_be_saved_on_protocol_management_screen(String protocolName) {
        Selenide.$$(SelectorsHelpers.e2eSelector("config", "protocol", "header")).find(Condition.text(protocolName));
    }

    @Given("^Set peak preassure value to \"([^\"]*)\" on protocol creation modal$")
    public void set_peak_preassure_value_to_on_protocol_creation_modal(String peakPreassure) {
        Selenide.$(SelectorsHelpers.e2eSelector("config", "peak-pressure-input")).sendKeys(peakPreassure);
    }

    @Then("^The duration should be enabled on phase on protocol creation modal$")
    public void the_duration_should_be_enabled_on_phase_on_protocol_creation_modal() {
        Selenide.$(SelectorsHelpers.e2eSelector("config", "menu", "duration-input")).shouldBe(Condition.enabled);
    }

    @Then("^The field Contrast rate should be empty on protocol creation modal$")
    public void the_field_Contrast_rate_should_be_empty_on_protocol_creation_modal() {
        Selenide.$(SelectorsHelpers.e2eSelector("phase-contrast-rate-select")).shouldBe(Condition.disabled);
    }
    @Then("^The field Contrast rate should be editable on protocol creation modal$")
    public void the_field_Contrast_rate_should_be_editable_on_protocol_creation_modal(){
        Selenide.$(SelectorsHelpers.e2eSelector("phase-contrast-rate-select")).shouldBe(Condition.enabled);
    }
    @Then("^The field Contrast rate should be \"([^\"]*)\" and not editable$")
    public void the_field_Contrast_rate_should_be_and_not_editable(String contrast){
        Selenide.$(SelectorsHelpers.e2eSelector("phase-contrast-rate-select")).shouldHave(Condition.value(contrast)).shouldBe(Condition.disabled);
    }
    @When("^Set duration on phase to \"([^\"]*)\"on protocol creation modal$")
    public void set_duration_on_phase_to_on_protocol_creation_modal(String duration){
        Selenide.$(SelectorsHelpers.e2eSelector("config", "menu phase-2", "duration-input")).sendKeys(duration);
    }
    @When("^Set  the type of phase to Wait on protocol creation modal$")
    public void set_the_type_of_phase_to_Wait_on_protocol_creation_modal(){
        Selenide.$(SelectorsHelpers.e2eSelector("config","phase-1", "phase-type-select", "phase-types-wait")).click();
    }

    }



