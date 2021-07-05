package StepDefs.Model;

import java.util.ArrayList;

public class ProcedureType {
    private String modalityType;
    private String name;
    private String stationsNames;
    private Boolean fromRis = false;

    public Boolean getFromRis() {
        return fromRis;
    }

    public void setFromRis(Boolean fromRis) {
        this.fromRis = fromRis;
    }

    public String getModalityType() {
        return modalityType;
    }

    public void setModalityType(String modalityType) {
        this.modalityType = modalityType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStationsNames() {
        return stationsNames;
    }

    public void setStationsNames(String stationsNames) {
        this.stationsNames = stationsNames;
    }

}
