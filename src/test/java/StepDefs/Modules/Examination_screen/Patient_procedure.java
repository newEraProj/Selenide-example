package StepDefs.Modules.Examination_screen;

import static Helpers.SelectorsHelpers.e2eSelector;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

import Helpers.SelectorsHelpers;
import Helpers.UtilsDate;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Patient_procedure {


    @Then("^A feedback message should be displayed on patient procedure$")
    public void a_feedback_message_should_be_displayed_on_patient_procedure() {
        //verify if feedback message is displayed
        Selenide.$(SelectorsHelpers.e2eSelector("message", "success"))
            .shouldBe(Condition.visible);
    }

    @Then("^A feedback message is displaying$")
    public void a_feedback_message_is_displaying() {
        //verify if feedback message is displayed
        Selenide.$(SelectorsHelpers.e2eSelector("message", "success"))
            .shouldBe(Condition.visible);
    }

    @Then("^A message should be displayed \"([^\"]*)\" on patient procedure$")
    public void a_message_should_be_displayed_on_patient_procedure(String arg1) throws Exception {
        Selenide.$(SelectorsHelpers.e2eSelector("message", "success"))
            .shouldBe(Condition.visible);
    }

    // *****************************  Breastfeeding & pregnancy  *************************************

    @When("^Set the breastfeeding status at \"([^\"]*)\" on patient procedure$")
    public void set_the_breastfeeding_status_at_on_patient_procedure(String status) {
        //select the corresponding status e2e-id="tabs-list examination-tab-content pregnancy examination-pregnancy-form breastfeeding-unknown"
        switch (status){
            case "Yes" :
                Selenide.$(SelectorsHelpers.e2eSelector("pregnancy","breastfeeding-true"))
                    .parent()
                    .click();
                break;
            case "No" :
                Selenide.$(SelectorsHelpers.e2eSelector("pregnancy","breastfeeding-false"))
                    .parent()
                    .click();
                break;
            case "Unknown" :
                Selenide.$(SelectorsHelpers.e2eSelector("pregnancy","breastfeeding-unknown"))
                    .parent()
                    .click();
                break;
        }
    }

    @Then("^The breastfeeding status should be \"([^\"]*)\" on patient procedure$")
    public void the_breastfeeding_status_should_be_on_patient_procedure(String status) {
        //verify that the corresponding status is selected
        switch (status){
            case "Yes" :
                Selenide.$(SelectorsHelpers.e2eSelector("pregnancy","breastfeeding-true"))
                    .shouldBe(Condition.selected);
                break;
            case "No" :
                Selenide.$(SelectorsHelpers.e2eSelector("pregnancy","breastfeeding-false"))
                    .shouldBe(Condition.selected);
                break;
            case "Unknown" :
                Selenide.$(SelectorsHelpers.e2eSelector("pregnancy","breastfeeding-unknown"))
                    .shouldBe(Condition.selected);
                break;
        }
    }

    @When("^Set the pregnancy status at \"([^\"]*)\" on patient procedure$")
    public void set_the_pregnancy_status_at_on_patient_procedure(String status) {
        //select the corresponding status
        switch (status) {
            case "Yes":
                Selenide.$(SelectorsHelpers.e2eSelector("pregnancy", "pregnancy-true"))
                    .parent()
                    .click();
                break;
            case "No":
                Selenide.$(SelectorsHelpers.e2eSelector("pregnancy", "pregnancy-false"))
                    .parent()
                    .click();
                break;
            case "Unknown":
                Selenide.$(SelectorsHelpers.e2eSelector("pregnancy", "pregnancy-unknown"))
                    .parent()
                    .click();
                break;
        }
    }


    @Then("^The pregnancy risk should be disabled on patient procedure$")
    public void the_pregnancy_risk_should_be_disabled_on_patient_procedure() {
        Selenide.$(SelectorsHelpers.e2eSelector("pregnancy", "examination-pregnancy-form"))
            .shouldBe(Condition.disabled);
    }

    @Then("^The pregnancy status should be \"([^\"]*)\" on patient procedure$")
    public void the_pregnancy_status_should_be_on_patient_procedure(String status) {
        //verify that the corresponding status is selected
        switch (status) {
            case "Yes":
                Selenide.$(SelectorsHelpers.e2eSelector("pregnancy", "pregnancy-true"))
                    .shouldBe(Condition.selected);
                break;
            case "No":
                Selenide.$(SelectorsHelpers.e2eSelector("pregnancy", "pregnancy-false"))
                    .shouldBe(Condition.selected);
                break;
            case "Unknown":
                Selenide.$(SelectorsHelpers.e2eSelector("pregnancy", "pregnancy-unknown"))
                    .shouldBe(Condition.selected);
                break;
        }
    }



    @Then("^The patient gender should be \"([^\"]*)\" on patient procedure$")
    public void the_patient_gender_should_be_on_patient_procedure(String gender) throws Throwable {
        Selenide.$(SelectorsHelpers.e2eSelector("tabs-list", "examination-tab-content", "user-gender-birthdate-age")).shouldHave(text("("+(gender.toUpperCase().substring(0,1)+")")));
    }

      // ***************************** HEIGHT / WEIGHT *************************************

    @When("^Update the weight to \"([^\"]*)\" on patient procedure$")
    public void update_the_weight_to_on_patient_procedure(String weight)  {
        Selenide.$(SelectorsHelpers.e2eSelector("tabs-list", "examination-patient-form", "weight")).clear();
        Selenide.$(SelectorsHelpers.e2eSelector("tabs-list", "examination-patient-form", "weight")).setValue(weight);
        // you need to click to outside to focus out of the field
        Selenide.$(SelectorsHelpers.e2eSelector("tabs-list", "examination-patient-form")).click();
    }

    @When("^Update the height to \"([^\"]*)\" on patient procedure$")
    public void update_the_height_to_on_patient_procedure(String height) {
        Selenide.$(SelectorsHelpers.e2eSelector("tabs-list", "examination-patient-form", "height")).clear();
        Selenide.$(SelectorsHelpers.e2eSelector("tabs-list", "examination-patient-form", "height")).setValue(height);
        // you need to click to outside to focus out of the field
        Selenide.$(SelectorsHelpers.e2eSelector("tabs-list", "examination-patient-form")).click();
    }

    @Then("^The patient weight should be \"([^\"]*)\" on patient procedure$")
    public void the_patient_weight_should_be_on_patient_procedure(String weight)  {
        Selenide.$(SelectorsHelpers.e2eSelector("tabs-list", "examination-patient-form", "weight")).equals(Condition.text(weight));
    }

    @Then("^The patient height should be \"([^\"]*)\" on patient procedure$")
    public void the_patient_height_should_be_on_patient_procedure(String height) {
        Selenide.$(SelectorsHelpers.e2eSelector("tabs-list", "examination-patient-form", "height")).equals(Condition.text(height));
    }

    @When("^Update the weight to \"([^\"]*)\" and height to \"([^\"]*)\" on patient procedure$")
    public void update_the_weight_to_and_height_to_on_patient_procedure(String weight, String height) throws Throwable {
        Selenide.$(SelectorsHelpers.e2eSelector("tabs-list", "examination-patient-form", "weight")).setValue(weight);
        Selenide.$(SelectorsHelpers.e2eSelector("tabs-list", "examination-patient-form", "height")).setValue(height);
        // you need to click to outside to focus out of the field
        Selenide.$(SelectorsHelpers.e2eSelector("tabs-list", "examination-patient-form")).click();
    }


    // *****************************  *************************************

    @Then("^The patient name \"([^\"]*)\" firstname \"([^\"]*)\" should be displayed on patient procedure$")
    public void the_patient_name_firstname_should_be_displayed_on_patient_procedure(String name, String firstname) throws Throwable {
        Selenide.$(SelectorsHelpers.e2eSelector("tabs-list", "examination-tab-content", "user-name-id"))
            .shouldHave(text(name));
        Selenide.$(SelectorsHelpers.e2eSelector("tabs-list", "examination-tab-content", "user-name-id"))
            .shouldHave(text(firstname));
    }

    // ***************************** BIRTH *************************************

    @Then("^The patient date of birth should be \"([^\"]*)\" on patient procedure$")
    public void the_patient_date_of_birth_should_be_on_patient_procedure(String birthdate) throws Throwable {
        Selenide.$(SelectorsHelpers.e2eSelector("tabs-list", "examination-tab-content", "user-gender-birthdate-age")).shouldHave(text(birthdate));

    }


    @Then("^The patient age should be \"([^\"]*)\" \"([^\"]*)\" on patient procedure$")
    public void the_patient_age_should_be_on_patient_procedure(String nb, String unit) throws Throwable {
        Selenide.$(SelectorsHelpers.e2eSelector("tabs-list", "examination-tab-content", "user-gender-birthdate-age")).shouldHave(text(""+nb+" "+ unit));
    }

    // *****************************  BMI *************************************


    @Then("^BMI should be \"([^\"]*)\" on patient procedure$")
    public void bmi_should_be_on_patient_procedure(String bmi){
        Selenide.$(e2eSelector("bmi-applicable")).shouldBe(Condition.value(bmi));
    }

    @Then("^BMI should be available on patient procedure$")
    public void bmi_should_be_available_on_patient_procedure()  {
        Selenide.$(SelectorsHelpers.e2eSelector("tabs-list", "bmi-applicable"))
            .shouldBe(Condition.visible);
    }

    @Then("^BMI should not be applicable on patient procedure$")
    public void bmi_should_not_be_applicable_on_patient_procedure()  {
        Selenide.$(SelectorsHelpers.e2eSelector("tabs-list", "bmi-not-applicable")).shouldBe(Condition.visible);
    }

    @Then("^BMI should not be available on patient procedure$")
    public void bmi_should_not_be_available_on_patient_procedure()  {
        Selenide.$(SelectorsHelpers.e2eSelector("tabs-list", "bmi-not-available")).shouldBe(Condition.visible);
    }

    // *****************************  DIV *************************************

    @When("^Go to the worklist$")
    public void go_to_the_worklist() {
        $(e2eSelector("worklist-link")).click();
    }

    @When("^User receiving worklist$")
    public void user_receiving_worklist() {
        $(e2eSelector("procedures", "cell", "patient_id")).click();
    }

    @When("^Select the station \"([^\"]*)\"$")
    public void select_the_station(String stationName) {
        $(e2eSelector("worklist-tab-content", "procedures", "stations-input")).click();
        $$(e2eSelector("worklist-tab-content", "stations-list", "item")).findBy(Condition.text("Station " + stationName)).click();
    }

    @When("^Open the patient procedure \"([^\"]*)\"$")
    public void open_the_patient_procedure(String procedureAN) {
        Selenide.$$(SelectorsHelpers.e2eSelector("worklist-tab-content", "cell", "accessNumber"))
            .find(Condition.text(procedureAN))
            .parent()
            .click();
    }

    @Then("^The patient id should be \"([^\"]*)\" on patient procedure$")
    public void the_patient_id_should_be_on_patient_procedure(String patientId) {
        Selenide.$$(SelectorsHelpers.e2eSelector("tabs-list", "examination-tab-content", "user-name-id"))
            .find(Condition.text(patientId)).shouldBe(Condition.visible);
    }

    @Then("^The station \"([^\"]*)\" should be displayed in procedure$")
    public void the_station_should_be_displayed_in_procedure(String stationName) {
        Selenide.$(SelectorsHelpers.e2eSelector("tabs-list", "injection-protocols", "card", "subtitle-Station "+ stationName)).shouldBe(Condition.visible);
        Selenide.$(SelectorsHelpers.e2eSelector("tabs-list", "injection-protocols", "card", "subtitle-Station "+ stationName)).shouldHave(text(stationName));
    }

    @Then("^The worklist is displayed$")
    public void the_worklist_is_displayed() {
        Selenide.$(SelectorsHelpers.e2eSelector("worklist-tab-content", "datagrid")).shouldBe(Condition.visible);
    }


    @Then("^The pregnancy risk should be enabled on patient procedure$")
    public void the_pregnancy_risk_should_be_enabled_on_patient_procedure() {
        Selenide.$(SelectorsHelpers.e2eSelector("pregnancy", "examination-pregnancy-form"))
            .shouldBe(Condition.enabled);
    }

    @Then("^The patient name \"([^\"]*)\" should be displayed on patient procedure$")
    public void the_patient_name_should_be_displayed_on_patient_procedure(String name) {
        Selenide.$$(SelectorsHelpers.e2eSelector("tabs-list", "examination-tab-content", "user-name-id"))
            .find(Condition.text(name)).shouldBe(Condition.visible);
    }


    @Then("^The procedure description \"([^\"]*)\" should be displayed on patient procedure$")
    public void the_procedure_description_should_be_displayed_on_patient_procedure(String procedureDescription)
        throws Exception {
        // The following condition will not work as the backend is not sending the correct value
        // Selenide.$$(SelectorsHelpers.e2eSelector("tabs-list", "examination-tab-content", "title-info", "name"))
        //  .find(Condition.text(procedureDescription)).shouldBe(Condition.visible);
        throw new Exception("TOdO");
    }

    @Then("^The procedure access number \"([^\"]*)\" should be displayed on patient procedure$")
    public void the_procedure_access_number_should_be_displayed_on_patient_procedure(String accessNumber) {
        Selenide.$$(SelectorsHelpers.e2eSelector("tabs-list", "examination-tab-content", "title-info", "access-number"))
            .find(Condition.text(accessNumber)).shouldBe(Condition.visible);
    }

    @Then("^The procedure date \"([^\"]*)\" should be displayed on patient procedure$")
    public void the_procedure_date_should_be_displayed_on_patient_procedure(String procedureDate) {
        Selenide.$$(SelectorsHelpers.e2eSelector("tabs-list", "examination-tab-content", "scheduled-time"))
            .find(Condition.text(procedureDate)).shouldBe(Condition.visible);
    }

    @Then("^The procedure physician \"([^\"]*)\" should be displayed on patient procedure$")
    public void the_procedure_physician_should_be_displayed_on_patient_procedure(String physician) {
        Selenide.$$(SelectorsHelpers.e2eSelector("tabs-list", "examination-tab-content", "physician"))
            .find(Condition.text(physician)).shouldBe(Condition.visible);
    }

    @Then("^The procedure note \"([^\"]*)\" should be displayed on patient procedure$")
    public void the_procedure_note_should_be_displayed_on_patient_procedure(String notes) {
        Selenide.$$(SelectorsHelpers.e2eSelector("tabs-list", "examination-tab-content", "notes"))
            .find(Condition.text(notes)).shouldBe(Condition.visible);
    }

    @When("^Select the station \"([^\"]*)\" on worklist$")
    public void select_the_station_on_worklist(String stationName)  {
        $(e2eSelector("worklist-tab-content", "procedures", "stations-input")).click();
        $$(e2eSelector("worklist-tab-content", "stations-list", "item")).findBy(Condition.text(stationName)).click();
    }

    @When("^Open the patient procedure \"([^\"]*)\" on worklist$")
    public void open_the_patient_procedure_on_worklist(String procedureAN)  {
        Selenide.$$(SelectorsHelpers.e2eSelector("worklist-tab-content", "cell", "accessNumber"))
            .find(Condition.text(procedureAN))
            .parent()
            .click();
    }


    @Then("^The patient information \"([^\"]*)\" should be enabled on patient procedure$")
    public void the_patient_information_should_be_enabled_on_patient_procedure(String patientId) throws Throwable {
          Selenide.$(SelectorsHelpers.e2eSelector("tabs-list", "examination-tab-content", "user-name-id"))
          .shouldBe(Condition.visible);
            Selenide.$(SelectorsHelpers.e2eSelector("tabs-list", "examination-tab-content", "user-name-id"))
            .shouldHave(text(patientId));
    }



    // *****************************  CHECK IDENTITY *************************************

    @Then("^The patient identity should be \"([^\"]*)\" on patient procedure$")
    public void the_patient_identity_should_be_on_patient_procedure(String checkStatus)  {
        boolean status = checkStatus == "unchecked";
        Selenide.$(SelectorsHelpers.e2eSelector("check-id-"+ (!status))).shouldBe(Condition.visible);
    }

    @When("^Set the patient identity to \"([^\"]*)\" on patient procedure$")
    public void set_the_patient_identity_to_on_patient_procedure(String checkStatus) {
        boolean status = checkStatus == "checked";
        if(status) {
            Selenide.$(SelectorsHelpers.e2eSelector("check-id-false")).click();
        } else {
            Selenide.$(SelectorsHelpers.e2eSelector("check-id-true")).click();
        }
    }


    @Then("^The patient identity should not have medication on patient procedure$")
    public void the_patient_identity_should_not_have_medication_on_patient_procedure() throws Throwable {
        throw new Exception("TODO");
    }

    @When("^Set the patient medication to \"([^\"]*)\" on patient procedure$")
    public void set_the_patient_medication_to_on_patient_procedure(String arg1) throws Throwable {
        throw new Exception("TODO");
    }

    @Then("^The patient medication should be \"([^\"]*)\" on patient procedure$")
    public void the_patient_medication_should_be_on_patient_procedure(String arg1) throws Throwable {
        throw new Exception("TODO");
    }

    @Then("^No medication should be disabled on patient procedure$")
    public void no_medication_should_be_disabled_on_patient_procedure() throws Throwable {
        throw new Exception("TODO");
    }

    @When("^Set the patient medication to one more char on patient procedure$")
    public void set_the_patient_medication_to_one_more_char_on_patient_procedure() throws Throwable {
        throw new Exception("TODO");
    }

    @When("^Set No medication on patient procedure$")
    public void set_No_medication_on_patient_procedure() throws Throwable {
        throw new Exception("TODO");
    }

    @Then("^No medication should be shown on patient procedure$")
    public void no_medication_should_be_shown_on_patient_procedure() throws Throwable {
        throw new Exception("TODO");
    }

    @Then("^No alert icon should be shown on patient procedure$")
    public void no_alert_icon_should_be_shown_on_patient_procedure() throws Throwable {
        throw new Exception("TODO");
    }

    @Then("^No medication should not be shown on patient procedure$")
    public void no_medication_should_not_be_shown_on_patient_procedure() throws Throwable {
        throw new Exception("TODO");
    }

    @When("^Start the procedure \"([^\"]*)\" on patient procedure$")
    public void start_the_procedure_on_patient_procedure(String arg1) throws Throwable {
        throw new Exception("TODO");
    }

    @When("^Close the procedure \"([^\"]*)\" on patient procedure$")
    public void close_the_procedure_on_patient_procedure(String arg1) throws Throwable {
        throw new Exception("TODO");
    }

    @Then("^The patient medication should be disabled$")
    public void the_patient_medication_should_be_disabled() throws Throwable {
        throw new Exception("TODO");
    }

    @Then("^The message \"([^\"]*)\" should be displayed in the injection history on patient procedure$")
    public void the_message_should_be_displayed_in_the_injection_history_on_patient_procedure(String message) {
        Selenide.$$(SelectorsHelpers.e2eSelector("tabs-list", "injection-history-no-data"))
                .find(Condition.text(message)).shouldBe(Condition.visible);
    }


    @When("^Add injection on patient procedure$")
    public void add_injection_on_patient_procedure() throws Throwable {
        throw new Exception("TODO");
    }

    @Then("^The injection should be added on patient procedure$")
    public void the_injection_should_be_added_on_patient_procedure() throws Throwable {
        throw new Exception("TODO");
    }

    @Then("^\"([^\"]*)\" previous injections should be shown in the injection history on patient procedure$")
    public void previous_injections_should_be_shown_in_the_injection_history_on_patient_procedure(String arg1) throws Throwable {
        throw new Exception("TODO");
    }


    @Then("^A button to see the previous injection should be visible$")
    public void a_button_to_see_the_previous_injection_should_be_visible() throws Throwable {
        throw new Exception("TODO");
    }

    @When("^Add a manual injection with volume \"([^\"]*)\" mL on patient procedure$")
    public void add_a_manual_injection_with_volume_ml_on_patient_procedure(String arg1) throws Throwable {
        throw new Exception("TODO");
    }

    @Then("^The manual injection with volume \"([^\"]*)\" mL should be added on patient procedure$")
    public void the_manual_injection_with_volume_ml_should_be_added_on_patient_procedure(String arg1) throws Throwable {
        throw new Exception("TODO");
    }


    @Then("^The modality type should be displayed in the injection history on patient procedure$")
    public void the_modality_type_should_be_displayed_in_the_injection_history_on_patient_procedure() throws Throwable {
        throw new Exception("TODO");
    }

    @Then("^The injection with procedure modality MR should differentiate from other procedures in the injection history on patient procedure$")
    public void the_injection_with_procedure_modality_MR__should_differentiate_from_other_procedures_in_the_injection_history_on_patient_procedure() throws Throwable {
        throw new Exception("TODO");
    }
}

