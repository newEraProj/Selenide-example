package StepDefs.Sprint_3.US_643_Station_configuration.AC_645_User_able_to_delete_station;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import cucumber.api.java.en.*;
import org.openqa.selenium.By;

public class TC_822_User_able_to_delete_station {


    @Given ("^Go to the station library\\. open a station and click on delete\\.$")
    public void go_to_the_station_library_open_a_station_and_click_on_delete() {

        Selenide.$("[e2e-id=config-link]").click(); //link to config page

    }

    @When ("^A confirmation pop-up is displayed after click on delete station$")
    public void a_confirmation_pop_up_is_displayed_after_click_on_delete_station() {
        Selenide.$("clr-dg-action-overflow").click();
        Selenide.$("[e2e-id~='config'][e2e-id~='action-button-Delete']").click();
    }

    @Then ("^Click on cancel$")
    public void click_on_cancel() {
        Selenide.$("[e2e~='cancel-button']").click();
    }

    @Then ("^The station isn't deleted$")
    public void the_station_isn_t_deleted() {
        Selenide.$("[e2e~='row cell modality']").isDisplayed();
    }

    @Then ("^Click on delete and confirm the pop-up$")
    public void click_on_delete_and_confirm_the_pop_up() {
        Selenide.$("clr-dg-action-overflow").click();
        Selenide.$("[e2e-id~='config'][e2e-id~='action-button-Delete']").click();
        Selenide.$("[e2e-id~='ok-button']").click();
    }

    @Then ("^The station is deleted$")
    public void the_station_is_deleted() {
        Selenide.$("[e2e~='row cell modality']").shouldNotBe(Condition.visible);
        System.out.println("Station is deleted");
    }

}