package StepDefs.Modules.Configuration.ProductManagement;

import Helpers.SelectorsHelpers;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.concurrent.TimeUnit;

public class Recall_Management {

  @When("^Go to Recall management$")
  public void go_to_Recall_management() throws Throwable {
    Selenide.$(SelectorsHelpers.e2eSelector("config", "product-management", "recall-products")).click();
  }

  @When("^Add a recall product \"([^\"]*)\" with lot number \"([^\"]*)\" on Recall management screen$")
  public void add_a_recall_product_with_lot_number_on_Recall_management_screen(String productCode, String lotNumber) throws Throwable {
    Selenide.$(SelectorsHelpers.e2eSelector("config", "recall-products-button-add")).click();
    Selenide.$(SelectorsHelpers.e2eSelector("config", "page", "recall-edition-modal", "products-input")).click();
    Selenide.$(SelectorsHelpers.e2eSelector("config", "page", "recall-edition-modal", "products-input", "input")).setValue(productCode);
    Selenide.$(SelectorsHelpers.e2eSelector("config", "products-input-suggestions", "product-suggestion-"+productCode)).click();
    Selenide.$(SelectorsHelpers.e2eSelector("config", "recall-edition-modal", "recall-lot-number")).click();
    Selenide.$(SelectorsHelpers.e2eSelector("config", "recall-edition-modal", "recall-lot-number")).setValue(lotNumber);
    Selenide.$(SelectorsHelpers.e2eSelector("config", "recall-edition-modal" ,"save-button")).click();
  }

  @Then("^The product \"([^\"]*)\" with lot number \"([^\"]*)\" should be displayed on Recall management screen$")
  public void the_product_with_lot_number_should_be_displayed_on_Recall_management_screen(String productCode, String lotNumber) {
    Selenide.$$(SelectorsHelpers.e2eSelector("config", "datagrid", "row", "cell", "recallProductCode")).find(Condition.text(productCode)).shouldBe(Condition.visible);
    Selenide.$$(SelectorsHelpers.e2eSelector("config", "datagrid", "row", "cell", "lotNumber")).find(Condition.text(lotNumber)).shouldBe(Condition.visible);
  }

}
