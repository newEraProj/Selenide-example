package StepDefs.Modules.Authentification;

import Helpers.GuerbetPropertyManager;
import Helpers.SelectorsHelpers;
import StepDefs.Background.BackgroundUtil;
import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import cucumber.api.DataTable;
import cucumber.api.java.en.*;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.codeborne.selenide.Selenide.open;


public class Authentification {

  @Given("^Log with my credentials$")
  public void log_with_my_credentials(DataTable dt) throws Throwable {
    String frontURL = GuerbetPropertyManager.getInstance().getFrontURL();
    open(frontURL);
    if (Selenide.$(SelectorsHelpers.e2eSelector("sign-in")).isDisplayed()) {
      // get login password as credentials
      List<Map<String, String>> list = dt.asMaps(String.class, String.class);
      list = BackgroundUtil.updateLoginPassword( list );

      String login = list.get(0).get("login");
      String password = list.get(0).get("password");
      // simulate login password and signin
      Selenide.$(SelectorsHelpers.e2eSelector("username")).setValue(login);
      Selenide.$(SelectorsHelpers.e2eSelector("password")).setValue(password);
      Selenide.$(SelectorsHelpers.e2eSelector("sign-in")).click();
    }

    //wait the login modal disappears
    Thread.sleep(6000);

    //if the favorite station modal is opening : set the first station as favorite
    if (Selenide.$(SelectorsHelpers.e2eSelector("favorite-station-edition-modal")).isDisplayed()) {
      Selenide.$(SelectorsHelpers.e2eSelector("favorite-station-edition-modal", "save-button")).click();
    }
  }


  @Given("^Log with my \"([^\"]*)\" credentials$")
  public void log_with_my_credentials(String login) throws Throwable {
    Map<String,String> map = new HashMap<String,String>();
    map.put("login", login);
    map.put("password", "");
    ArrayList<Map<String, String>> list = new ArrayList<Map<String, String>>();
    list.add( map );
    DataTable dt = DataTable.create(list);
    this.log_with_my_credentials(dt);
  }


  @Then("^The user can access to Contrast Care$")
  public void the_user_can_access_to_Contrast_Care() throws Throwable {
        // verify than login modal is no more present
    Selenide.$(SelectorsHelpers.e2eSelector( "sign-in")).shouldNotBe(Condition.visible);
  }
}
