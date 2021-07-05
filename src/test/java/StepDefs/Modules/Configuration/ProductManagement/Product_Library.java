package StepDefs.Modules.Configuration.ProductManagement;

import Helpers.SelectorsHelpers;
import Helpers.UtilsDate;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.concurrent.TimeUnit;

public class Product_Library {

  @When("^Add product \"([^\"]*)\" with drug name \"([^\"]*)\" and type \"([^\"]*)\" family \"([^\"]*)\" container \"([^\"]*)\" concentration \"([^\"]*)\" and volume of \"([^\"]*)\" with validity date \"([^\"]*)\" on product library$")
  public void add_product_with_drug_name_and_type_family_container_concentration_and_volume_of_with_validity_date_on_product_library(String drugCode, String drugName, String type, String family, String container, String concentration, String volume, String validityDate)  {
    // Write code here that turns the phrase above into concrete actions

        Selenide.$(SelectorsHelpers.e2eSelector("products", "button-add")).click();
        Selenide.$(SelectorsHelpers.e2eSelector("config", "page", "product-edition-modal", "product-form-input-code"))
                .setValue(drugCode);
        Selenide.$(SelectorsHelpers.e2eSelector("config", "page", "product-edition-modal", "name-input", "input")).click();
        Selenide.$(SelectorsHelpers.e2eSelector("config", "page", "product-edition-modal", "name-input", "input"))
                .setValue(drugName);
        Selenide.$(SelectorsHelpers.e2eSelector("config", "product-edition-modal", "product-form-input-type")).click();
        Selenide.$(SelectorsHelpers.e2eSelector("config", "product-edition-modal", "product-form-input-type", "product-type-option-"+type)).click();
        Selenide.$(SelectorsHelpers.e2eSelector("config", "product-edition-modal", "product-form-input-family")).click();
        Selenide.$(SelectorsHelpers.e2eSelector("config", "product-edition-modal", "product-form-input-family", "product-family-option-"+family)).click();
        Selenide.$(SelectorsHelpers.e2eSelector("config", "product-edition-modal", "product-form-input-container")).click();
        Selenide.$(SelectorsHelpers.e2eSelector("config", "product-edition-modal", "product-form-input-container", "product-container-option-"+container)).click();
        Selenide.$(SelectorsHelpers.e2eSelector("config", "product-edition-modal", "product-form-input-concentration-value")).click();
        Selenide.$(SelectorsHelpers.e2eSelector("config", "product-edition-modal", "product-form-input-concentration-value")).setValue(concentration);
        Selenide.$(SelectorsHelpers.e2eSelector("config", "product-edition-modal", "product-form-input-volume")).click();
        Selenide.$(SelectorsHelpers.e2eSelector("config", "product-edition-modal", "product-form-input-volume")).setValue(volume);
        Selenide.$(SelectorsHelpers.e2eSelector("config", "product-edition-modal", "product-form-input-date" )).click();
        validityDate = UtilsDate.getDateForBrowser(validityDate);
        Selenide.$(SelectorsHelpers.e2eSelector("config", "product-edition-modal", "product-form-input-date" )).setValue(validityDate);
//      config menu page product-edition-modal modal save-button
      Selenide.$(SelectorsHelpers.e2eSelector("save-button")).click();

  }

  @Then("^The product \"([^\"]*)\" should be displayed on product library$")
  public void the_product_should_be_displayed_on_product_library(String drugCode)  {
//    config menu page products table datagrid row cell code
    Selenide.$$(SelectorsHelpers.e2eSelector("config", "datagrid", "row", "cell", "code"))
            .find(Condition.text(drugCode)).shouldBe(Condition.visible);
  }
}
