package StepDefs.Background;

import Helpers.GuerbetPropertyManager;
import com.fasterxml.jackson.databind.ObjectMapper;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import okhttp3.Response;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.util.*;

public class BackgroundLogin {

    @Given("^Log with \"([^\"]*)\" IAM login$")
    public void log_with_IAM_login(String login) throws Throwable {
        Map<String,String> map = new HashMap<String,String>();
        map.put("login", login);
        map.put("password", "");
        ArrayList<Map<String, String>> list = new ArrayList<Map<String, String>>();
        list.add( map );
        DataTable dt = DataTable.create(list);
        this.log_with_IAM_login(dt);
    }

    @Given("^Log with IAM login$")
    public void log_with_IAM_login(DataTable loginInformations) throws Exception {
        String backURL = GuerbetPropertyManager.getInstance().getBackURL();

        //use credential to "login:password" in base64
        List<Map<String, String>> list = loginInformations.asMaps(String.class, String.class);

        list = BackgroundUtil.updateLoginPassword( list );

        String login = list.get(0).get("login");
        String password = list.get(0).get("password");

        String credentials = login+":"+password;
        String encodedCredentials = Base64.getEncoder().encodeToString(credentials.getBytes());

        BackgroundUtil.callPostBasicAuthRestAPI(encodedCredentials,backURL + "/login");
    }

}