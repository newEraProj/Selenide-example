package StepDefs.Background;

import Helpers.GuerbetPropertyManager;
import Helpers.UtilsDate;
import StepDefs.Model.Procedure;
import StepDefs.Model.ProcedureType;
import StepDefs.Model.ProcedureTypeAPI;
import StepDefs.Model.Station;
import com.fasterxml.jackson.databind.ObjectMapper;
import cucumber.api.java.en.*;
import okhttp3.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BackgroundProcedure {

    String backURL = GuerbetPropertyManager.getInstance().getBackURL();
    String siteId = GuerbetPropertyManager.getInstance().getSiteId();

    @Given("^Following procedures exist for station \"([^\"]*)\"$")
    public void following_procedures_exist(String stationName, List<Procedure> procedures) {

        //first step : retrieved the corresponding station
        String stationId = this.getStationIdByName(stationName);

        //Second step : insert procedures for the station

        for (Procedure procedure : procedures) {
            procedure.setDatetime(UtilsDate.getDateForDatabase(procedure.getDatetime()));

            BackgroundUtil.callPostBearerAuhtRestAPI(procedure, backURL + "/api/procedures/stations/" + stationId);
        }

    }

    @Given("^Following \"([^\"]*)\" procedures exist for station \"([^\"]*)\"$")
    public void following_procedures_exist(int nb, String stationName, List<Procedure> procedures) {
        //take the first and unique procedure to create nb same procedures
        Procedure procedure = procedures.get(0);

        //first step : retrieved the corresponding station
        String stationId = this.getStationIdByName(stationName);
        String accesNumber = procedure.getAccessNumber();
        //Second step : insert nb procedures for the station

        Response response = null;
        for (int i = 1; i <= nb; i++) {
            procedure.setAccessNumber(accesNumber + i);
            procedure.setDatetime(UtilsDate.getDateForDatabase(procedure.getDatetime()));
            BackgroundUtil.callPostBearerAuhtRestAPI(procedure, backURL + "/api/procedures/stations/" + stationId);
        }
    }

    @Given("^Following procedures type exist$")
    public void following_procedures_type_exist(List<ProcedureType> proceduresType) {

        for (ProcedureType procedureType : proceduresType) {
            //first step : retrieved the corresponding station by names
            String[] stationsNames = procedureType.getStationsNames().split(";");
            ArrayList<Integer> stations = new ArrayList<>();
            for (String name : stationsNames) {
                String stationId = this.getStationIdByName(name);
                if(stationId != null && stationId != "") {
                    stations.add(Integer.parseInt(stationId));
                }
            }

            //second step : insert all procedures type
            ProcedureTypeAPI procedureTypeAPI = new ProcedureTypeAPI(
                    procedureType.getModalityType(),
                    procedureType.getName(),
                    stations,
                    procedureType.getFromRis()
            );
            BackgroundUtil.callPostBearerAuhtRestAPI(procedureTypeAPI, backURL + "/config/sites/" + siteId + "/procedure-types");
        }
    }

    private String getStationIdByName(String stationName) {
        String stationId = "";

        ObjectMapper mapper = new ObjectMapper();

        //retrieved the corresponding station
        Response response = BackgroundUtil.callGetBearerAuthRestAPI(backURL + "/config/sites/" + siteId + "/stations");
        List<Station> stations = null;
        try {
            stations = Arrays.asList(mapper.readValue(response.body().string(), Station[].class));
            for (Station station : stations) {
                if (station.getName().equals(stationName)) {
                    stationId = station.getId();
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return stationId;
    }
}


