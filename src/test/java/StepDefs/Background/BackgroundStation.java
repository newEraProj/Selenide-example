package StepDefs.Background;

import Helpers.GuerbetPropertyManager;
import StepDefs.Model.Station;
import cucumber.api.java.en.And;
import java.util.ArrayList;
import okhttp3.*;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;

public class BackgroundStation {

    @And("^Following stations exist$")
    public void the_following_patient_exist(List<Station> stations) throws Exception {
        String backURL = GuerbetPropertyManager.getInstance().getBackURL();
        String siteId = GuerbetPropertyManager.getInstance().getSiteId();

        for (Station station : stations){
            station.setInjectors( Station.transformToInjectorList( station.getGsonInjectors()));
            station.setGsonInjectors(null);
            Response response = BackgroundUtil.callPostBearerAuhtRestAPI(station, backURL+"/config/sites/"+siteId+"/stations"  );
        }
    }

}