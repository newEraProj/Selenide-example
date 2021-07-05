package StepDefs.Background;

import Helpers.GuerbetPropertyManager;
import StepDefs.Model.Patient;
import cucumber.api.java.en.Given;

import java.util.ArrayList;
import java.util.List;

public class BackgroundPatient {

    @Given("^Following patients exist$")
    public void following_patient_exist(List<Patient> patients) {
        String backURL = GuerbetPropertyManager.getInstance().getBackURL();

        for (Patient patient : patients) {
            patient.initEmptyFields();
            BackgroundUtil.callPostBearerAuhtRestAPI(patient, backURL + "/api/patients");
        }
    }

}

