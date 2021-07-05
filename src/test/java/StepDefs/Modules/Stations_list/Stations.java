package StepDefs.Modules.Stations_list;

import Helpers.SelectorsHelpers;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import cucumber.api.java.en.*;
import org.openqa.selenium.By;

public class Stations {
    @When("^Go to the worklist tab$")
    public void go_to_the_worklist_tab() {
        Selenide.$(SelectorsHelpers.e2eSelector("worklist-tab")).click();



{

}
    }
}