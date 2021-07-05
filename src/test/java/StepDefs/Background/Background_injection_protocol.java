package StepDefs.Background;

import Helpers.GuerbetPropertyManager;
import StepDefs.Model.Injection_protocol;
import cucumber.api.java.en.*;

import java.util.List;

public class Background_injection_protocol {



    @Given("^Following protocols exist$")
    public void following_protocols_exist(List<Injection_protocol> protocols) {
        String backURL = GuerbetPropertyManager.getInstance().getBackURL();
        String siteId = GuerbetPropertyManager.getInstance().getSiteId();

        for (Injection_protocol protocol : protocols) {
            protocol.transformJsonFields();

            BackgroundUtil.callPostBearerAuhtRestAPI(protocol, backURL + "/config/sites/"+siteId+"/protocols");

        }

    }
}
