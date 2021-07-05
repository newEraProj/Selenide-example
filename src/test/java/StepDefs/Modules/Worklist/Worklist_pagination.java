package StepDefs.Modules.Worklist;

import Helpers.SelectorsHelpers;
import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.java.eo.Se;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import static com.codeborne.selenide.Condition.*;

public class Worklist_pagination {
    @When("^User clicking on the next  button$")
    public void user_clicking_on_the_next_button() {
        Selenide.$(By.xpath("//*[@id=\"clr-tab-content-1\"]/app-examination-list/div/app-data-grid/clr-datagrid/clr-dg-footer/clr-dg-pagination/div[3]/button[3]/clr-icon")).click();
        Selenide.$$(By.cssSelector("clr-dg-row")).shouldHaveSize(10);
        System.out.println("There are no 10 rows in the second page to check");
    }
    @When("^Set \"([^\"]*)\" entries per page$")
    public void set_entries_per_page(String arg1){
        SelenideElement pagination = Selenide.$(SelectorsHelpers.e2eSelector("tabs-list","datagrid","pagination","size"));

        pagination.find(By.cssSelector("select")).click();
        pagination.find(By.cssSelector("select")).selectOptionContainingText(arg1);
    }
    @Then("^Not more than \"([^\"]*)\" entries should be screened$")
    public void not_more_than_entries_should_be_screened(String arg1){
        Selenide.$$(By.cssSelector("clr-dg-row")).shouldHave(CollectionCondition.size(Integer.parseInt(arg1)));
    }
    @When("^Click on the next page button$")
    public void click_on_the_next_page_button(){
        Selenide.$(By.className("pagination-next")).click();
    }

    @When("^There are max \"([^\"]*)\" procedures per page screened$")
    public void there_are_max_procedures_per_page_screened(String arg1){
     Selenide.$$(By.cssSelector("clr-dg-row")).shouldHave(CollectionCondition.size(Integer.parseInt(arg1)));

}
    }




