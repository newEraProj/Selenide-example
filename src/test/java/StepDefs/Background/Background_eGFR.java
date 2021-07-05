package StepDefs.Background;

import Helpers.GuerbetPropertyManager;
import StepDefs.Model.PatientDataExtract;
import StepDefs.Model.eGFR;
import com.fasterxml.jackson.databind.ObjectMapper;
import cucumber.api.java.en.*;
import okhttp3.Response;

import java.io.IOException;
import java.util.List;



public class Background_eGFR {
    @Given("^Following last egfr values exist$")
    public void following_last_egfr_values_exist(List <eGFR> egfrValues) {

        String backURL = GuerbetPropertyManager.getInstance().getBackURL();

        for (eGFR egfrValue : egfrValues) {
            int patientInternalId = this.getPatientInternalIdByPatientId(egfrValue.getPatientId());
            BackgroundUtil.callPostBearerAuhtRestAPI(egfrValue, backURL + "/patients/" + patientInternalId+"/egfr");
        }
    }

    private int getPatientInternalIdByPatientId(String patientId) {
        int patientInternalId = -1;
        ObjectMapper mapper = new ObjectMapper();
        String backURL = GuerbetPropertyManager.getInstance().getBackURL();
        Response response = BackgroundUtil.callGetBearerAuthRestAPI(backURL + "/patient-data/"+patientId);
        PatientDataExtract patient = null;
        try {
            patient = mapper.readValue(response.body().string(), PatientDataExtract.class);
            patientInternalId = patient.getId();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return patientInternalId;
    }
}
