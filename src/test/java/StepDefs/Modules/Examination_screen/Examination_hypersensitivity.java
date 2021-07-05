package StepDefs.Modules.Examination_screen;

import Helpers.SelectorsHelpers;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import java.util.Iterator;
import java.util.List;
import org.junit.Assert;
import org.openqa.selenium.By;

public class Examination_hypersensitivity {



  @Given("^Add an hypersensitivity \"([^\"]*)\" on patient procedure$")
  public void add_an_hypersensitivity_on_patient_procedure(String hypersensibility) throws Throwable {

    // click Add hypersensibility
    Selenide.$(SelectorsHelpers
        .e2eSelector("examination-tab-content", "hypersensitivities" ,"add-hypersensitivity")).click();
    // enter the hypersensibility name
    Selenide.$(SelectorsHelpers
        .e2eSelector("examination-tab-content", "hypersensitivity-form", "hypersensitivities-input",
            "input"))
        .setValue(hypersensibility);
    Selenide.$(SelectorsHelpers
        .e2eSelector("examination-tab-content", "hypersensitivity-form", "hypersensitivities-input",
            "input"))
        .click();
    // click on the right one
    ElementsCollection sl =     Selenide.$$(By.cssSelector(SelectorsHelpers.e2eSelector("examination-tab-content", "hypersensitivity-form", "hypersensitivities-input", "hypersensitivities-input-suggestions-container",
        "hypersensitivity-suggestion") +" em"));
    SelenideElement slElt = find_the_element(sl,hypersensibility.trim());

    if( slElt != null) {
      // select the hypersensibility
      slElt.click();
      // Save
      Selenide.$(SelectorsHelpers
          .e2eSelector("examination-tab-content", "save-button")).click();
    }
    else{
      // error : because hypersensibility not found
      Assert.assertTrue(slElt==null);
    }
  }

  @Then("^The hypersensitivities block displays hypersensitivity \"([^\"]*)\" on patient procedure$")
  public void the_hypersensitivities_block_displays_hypersensitivity_on_patient_procedure(String hypersensibility) throws Throwable {
    hypersensibility = hypersensibility.trim();

    ElementsCollection sl = Selenide.$$(By.cssSelector(SelectorsHelpers.e2eSelector("examination-tab-content", "hypersensitivities", "card")+ " span "));

    Iterator<SelenideElement> iterator  = sl.iterator();
    boolean found = false;
    while(!found && iterator.hasNext()) {
      String str = iterator.next().getText().trim();
       if( str.compareToIgnoreCase(hypersensibility) ==0 ){
         found = true;
       }
    }
    Assert.assertTrue(found);
  }

  @Then("^The declare none button in the hypersensitivity block should not be displayed on patient procedure$")
  public void the_declare_none_button_in_the_hypersensitivity_block_should_not_be_displayed_on_patient_procedure() {
    Selenide.$(SelectorsHelpers.e2eSelector("declare-hypersensitivities-none")).shouldNotBe(Condition.visible);
  }

  @Then("^The declare none button in the hypersensitivity block should be displayed on patient procedure$")
  public void the_declare_none_button_in_the_hypersensitivity_block_should_be_displayed_on_patient_procedure() {
    Selenide.$(SelectorsHelpers.e2eSelector("declare-hypersensitivities-none")).shouldBe(Condition.visible);
  }

  @Then("^The hypersensitivities block should not displayed hypersensitivity \"([^\"]*)\" on patient procedure$")
  public void the_hypersensitivities_block_should_not_not_displayed_hypersensitivity_on_patient_procedure(String hypersensibility) throws Throwable {
    hypersensibility = hypersensibility.trim();
    ElementsCollection sl = Selenide.$$(By.cssSelector("[e2e-id='examination-tab-content hypersensitivities card'] span "));
    Iterator<SelenideElement> iterator  = sl.iterator();
    boolean found = false;
    while(!found && iterator.hasNext()) {
      String str = iterator.next().getText().trim();
      if( str.compareToIgnoreCase(hypersensibility) ==0 ){
        found = true;
        Assert.assertFalse(found);
      }
    }
 }

  @Then("^Information about the product incompatibilities \"([^\"]*)\" should be shown on patient procedure$")
  public void information_about_the_product_incompatibilities_should_be_shown_on_patient_procedure(String productName) {
    Selenide.$$(SelectorsHelpers.e2eSelector("product-title")).find(Condition.text(productName)).shouldBe(Condition.visible);
  }


  @Then("^The hypersensitivities block should displayed none hypersensitivity on patient procedure$")
  public void the_hypersensitivities_block_should_displayed_none_hypersensitivity_on_patient_procedure() throws Throwable {
    ElementsCollection sl = Selenide.$$(By.cssSelector("[e2e-id='examination-tab-content hypersensitivities card'] span "));
    Iterator<SelenideElement> iterator  = sl.iterator();
    Assert.assertFalse(iterator.hasNext());
  }


  @When("^Cancel the remove from the hypersensitivity block on patient procedure$")
  public void cancel_the_remove_from_the_hypersensitivity_block_on_patient_procedure() throws Throwable {
    Selenide.$(SelectorsHelpers.e2eSelector("examination-tab-content","confirm-modal","cancel-button")).click();
  }


  @When("^Remove from the hypersensitivity block the hypersensitivity \"([^\"]*)\" on patient procedure$")
  public void remove_from_the_hypersensitivity_block_the_hypersensitivity_on_patient_procedure(String hypersensibility) throws Throwable {
    hypersensibility = hypersensibility.trim();
    //Page principale patient sans click hypersensibilité => delete
    ElementsCollection sl = Selenide.$$(By.cssSelector("[e2e-id='examination-tab-content hypersensitivities card'] clr-icon "));
    Iterator<SelenideElement> iterator  = sl.iterator();
    boolean found = false;
    while(!found && iterator.hasNext()) {
      SelenideElement sel = iterator.next();
      String str = sel.parent().getText().trim();
      if( str.compareToIgnoreCase(hypersensibility) ==0 ){
        found = true;
        sel.click();
      }
    }
  }

  @When("^Confirm the remove from the hypersensitivity block on patient procedure$")
  public void confirm_the_remove_from_the_hypersensitivity_block_on_patient_procedure() throws Throwable {
    Selenide.$(SelectorsHelpers.e2eSelector("examination-tab-content","confirm-modal","ok-button")).click();
  }


  protected SelenideElement find_the_element( ElementsCollection coll_Elt, String  hypersensibility ) {
    hypersensibility = hypersensibility.trim();

    Iterator<SelenideElement> iterator = coll_Elt.iterator();
    SelenideElement slElt = null;
    while (iterator.hasNext()) {
      slElt =  iterator.next();
      String str = slElt.getText().trim();
      if (str.compareToIgnoreCase(hypersensibility) == 0) {
        return slElt;
      }
    }
    return null;
  }

  @Then("^A confirmation pop-up should be displayed for removing the hypersensitivity on patient procedure$")
  public void a_confirmation_pop_up_should_be_displayed_for_removing_the_hypersensitivity_on_patient_procedure() throws Throwable {
    Selenide.$(SelectorsHelpers.e2eSelector("examination-tab-content","confirm-modal","ok-button")).isDisplayed();
  }

  // ***************************** HYPERSENSIBILITY *************************************

  @Given("^Click on Add an hypersensitivity$")
  public void click_on_Add_an_hypersensitivity() throws Throwable {
    Selenide.$(SelectorsHelpers.e2eSelector("examination-tab-content", "hypersensitivities", "add-hypersensitivity")).click();
  }

  @Then("^The user can select hypersensitivities$")
  public void the_user_can_select_hypersensitivities(List<String> hypersensitivities) throws Exception {
    for (int i = 0; i<hypersensitivities.size(); i++) {
      Selenide.$(SelectorsHelpers.e2eSelector("tabs-list", "examination-tab-content", "hypersensitivities-input", "hypersensitivities-input-suggestions-container", "hypersensitivity-suggestion"+"-"+hypersensitivities.get(i))).shouldBe(Condition.visible);
    }
  }


  @Then("^The hypersensitivities block should displayed hypersensitivity \"([^\"]*)\" on patient procedure$")
  public void the_hypersensitivities_block_should_displayed_hypersensitivity_on_patient_procedure(String hypersensibility) throws Throwable {
    Selenide.$(SelectorsHelpers.e2eSelector("tabs-list", "examination-tab-content", "hypersensitivities", "hypersensitivities-remove-"+hypersensibility)).shouldBe(Condition.visible)
    ;
    /*  // other code to check
        hypersensibility = hypersensibility.trim();

    ElementsCollection sl = Selenide.$$(By.cssSelector(SelectorsHelpers.e2eSelector("examination-tab-content", "hypersensitivities", "card")+ " span "));

    Iterator<SelenideElement> iterator  = sl.iterator();
    boolean found = false;
    while(!found && iterator.hasNext()) {
      String str = iterator.next().getText().trim();
       if( str.compareToIgnoreCase(hypersensibility) ==0 ){
         found = true;
       }
    }
    Assert.assertTrue(found);

     */
  }


}
