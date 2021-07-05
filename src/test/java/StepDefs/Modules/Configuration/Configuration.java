package StepDefs.Modules.Configuration;

import Helpers.SelectorsHelpers;
import com.codeborne.selenide.Selenide;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

public class Configuration {

    @Given("^Go to the configuration$")
    public void go_to_the_configuration() {
        Selenide.$(SelectorsHelpers.e2eSelector("config-link")).click();
    }


    @When("^Go to Product management$")
    public void go_to_Product_management() throws Throwable {
        Selenide.$(SelectorsHelpers.e2eSelector("product-management")).click();
    }

    @When("^Go to product library$")
    public void go_to_product_library() throws Throwable {
        Selenide.$(SelectorsHelpers.e2eSelector("products")).click();
    }
}