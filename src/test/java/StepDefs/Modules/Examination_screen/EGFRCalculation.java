package StepDefs.Modules.Examination_screen;

import Helpers.SelectorsHelpers;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selectors.byCssSelector;

public class EGFRCalculation {

    //TODO : review double method

    @When("^Open the eGFR manual calculation from the patient procedure$")
    public void open_the_eGFR_manual_calculation_from_the_patient_procedure() {
        Selenide.$(SelectorsHelpers.e2eSelector("examination-tab-content", "clearance-add")).click();
        Selenide.$(SelectorsHelpers.e2eSelector("examination-tab-content", "compute-egfr")).click();
    }
   @When("^Select the \"([^\"]*)\" formula$")
public void select_the_formula(String arg1) {
       Selenide.$(SelectorsHelpers.e2eSelector("examination-tab-content", "method-"+arg1)).click();
   }
    @When("^Set serum unit to \"([^\"]*)\"$")
    public void set_serum_unit_to(String arg1) {
        //TODO implement e2e selector
        Selenide.$$(SelectorsHelpers.e2eSelector("tabs-list","examination-tab-content","scr-unit-selector")).findBy(Condition.text(arg1)).click();
    }
    @When("^Save the result on eGFR calculation screen$")
    public void save_the_result_on_eGFR_calculation_screen() {
        Selenide.$(SelectorsHelpers.e2eSelector("examination-tab", "content button")).click();
    }
    @Then("^The \"([^\"]*)\"last eGFR values are displayed with the value with the good color$")
    public void the_last_eGFR_values_are_displayed_with_the_value_with_the_good_color(String arg1)  {  //TODO implement e2e selector
    }
    @Then("^The first one is Value = \"([^\"]*)\"  colored in \"([^\"]*)\"$")
    public void the_first_one_is_Value_colored_in(String arg1, String arg2)  {    //TODO implement e2e selector
    }
    @Then("^The second one is Value = \"([^\"]*)\" colored in \"([^\"]*)\"$")
    public void the_second_one_is_Value_colored_in(String arg1, String arg2) throws Throwable {      //TODO implement e2e selector
    }
    @Then("^The third one is  Value = \"([^\"]*)\"  colored in \"([^\"]*)\"$")
    public void the_third_one_is_Value_colored_in(String arg1, String arg2) throws Throwable {        //TODO implement e2e selector
    }
    @When("^Click compute eGFR value$")
    public void click_compute_eGFR_value(){
        Selenide.$(SelectorsHelpers.e2eSelector("save-button")).click();
    }


    @Then("^Only the field bellows are display:Serum Creatinine \\(unit \\+ value \\+ date test\\), - Age \\(years \\+months\\),- Gender, - African American fieds should be displayed on eGFR$")
    public void only_the_field_bellows_are_display_Serum_Creatinine_unit_value_date_test_Age_years_months_Gender_African_American_fieds_should_be_displayed_on_eGFR(){
        Selenide.$(byText("Serum Creatinine unit")).isDisplayed();
        Selenide.$(byText("Test date")).isDisplayed();
        Selenide.$(byText("Serum value")).isDisplayed();
        Selenide.$(byText("Serum Creatinine unit")).isDisplayed();
        Selenide.$(byClassName("clr-subtext ng-star-inserted")).isDisplayed();
        Selenide.$(byText("African American")).isDisplayed();
        Selenide.$(byText("Gender")).isDisplayed();
    }

    @Then("^Only the field bellows are display:Serum Creatinine,Age,Gender,African American,IDMS presented$")
    public void only_the_field_bellows_are_display_Serum_Creatinine_Age_Gender_African_American_IDMS_presented() {
        Selenide.$(byText("Serum Creatinine unit")).isDisplayed();
        Selenide.$(byText("African American")).isDisplayed();
        Selenide.$(byText("Gender")).isDisplayed();
        Selenide.$(byClassName("clr-subtext ng-star-inserted")).isDisplayed();
        Selenide.$(byText("IDMS reference method")).isDisplayed();
    }

    @When("^Only the field bellows are display:Serum Creatinine,Height presented$")
    public void only_the_field_bellows_are_display_Serum_Creatinine_Height_presented() {
        Selenide.$(byText("Serum Creatinine unit")).isDisplayed();
        Selenide.$(byText("Height (cm)")).isDisplayed();
    }


    @Then("^Only the field bellows are display:Serum Creatinine,Age,Weight,Gender is presented$")
    public void only_the_field_bellows_are_display_Serum_Creatinine_Age_Weight_Gender_is_presented() {
        Selenide.$(byText("Serum Creatinine unit")).isDisplayed();
        Selenide.$(byText("Gender")).isDisplayed();
        Selenide.$(byClassName("clr-subtext ng-star-inserted")).isDisplayed();
        Selenide.$(byText(" Weight (kg)")).isDisplayed();
    }
    @When("^eGFR calculation is screened$")
    public void egfr_calculation_is_screened(){
        Selenide.$(byText("This information is not intended to replace any clinical judgement")).isDisplayed();
    }

    @Then("^Expand the disclaimer$")
    public void expand_the_disclaimer() {
        Selenide.$(byText("Show more")).click();
    }

    @Then ("^The popups screened hints of calculation$")
    public void the_popups_screened_hints_of_calculation() {
        Selenide.$(byClassName("computation-form__formula-description")).isDisplayed();
    }

    @When ("^The field of Serum creatinine value is presented$")
    public void the_field_of_Serum_creatinine_value_is_presented() {
        Selenide.$(byText("Serum Creatinine unit")).isDisplayed();
    }
    @Then("^A list for the serum creatinine unit is available with mg/dL and umol/L$")
    public void a_list_for_the_serum_creatinine_unit_is_available_with_mg_dL_and_umol_L() {
        Selenide.$$(byId("clr-form-control-6")).filterBy(Condition.text(" mg/dL"));
        Selenide.$$(byId("clr-form-control-6")).filterBy(Condition.text(" µmol/L"));
    }
    @Then("^Reset the form$")
    public void reset_the_form() {
        Selenide.$(By.xpath("/html/body/app-root/div/div/main/app-procedure/app-egfr-modal/clr-modal/div/div[1]/div[2]/div/div[2]/app-computation-form/form/div[2]/fieldset[3]/div/app-button[1]/button")).click();

    }

    @Then("^An error message should be displayed on the height$")
    public void an_error_message_should_be_displayed_on_the_height(){
        Selenide.$(SelectorsHelpers.e2eSelector("height")).shouldHave(Condition.text("This field is required"));
    }

}