package StepDefs.Model;

import java.util.ArrayList;

public class ProcedureTypeAPI {
    private String modalityType;
    private String name;
    private ArrayList<Integer> stations;
    private Boolean fromRis = false;

    public ProcedureTypeAPI(String modalityType, String name, ArrayList<Integer> stations, Boolean fromRis) {
        this.modalityType = modalityType;
        this.name = name;
        this.stations = stations;
        this.fromRis = fromRis;
    }

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

    public ArrayList<Integer> getStations() {
        return stations;
    }

    public void setStations(ArrayList<Integer> stations) {
        this.stations = stations;
    }
}
