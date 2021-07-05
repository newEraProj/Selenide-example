package StepDefs.Model;

import Helpers.UtilsDate;

public class Procedure {
    private String patientId;
    private String accessNumber;
    private String datetime;
    private String procedureType;
    private String procedureName;
    private String physician;
    private String note;
    private String status;

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
         this.datetime = datetime;
    }


    public String getAccessNumber() {
        return accessNumber;
    }

    public void setAccessNumber(String accessNumber) {
        this.accessNumber = accessNumber;
    }
}