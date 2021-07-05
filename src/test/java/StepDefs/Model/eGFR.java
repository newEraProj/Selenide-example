package StepDefs.Model;

import java.util.Date;

public class eGFR {

    private String patientId;
    private String clearanceColor;
    private float clearanceLevel;
    private String methodName;
    private String testDate;
    private String unit;

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

}
