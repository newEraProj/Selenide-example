package StepDefs.Model;

import com.google.gson.Gson;
import java.util.Arrays;
import java.util.List;
import javax.print.DocFlavor;
import java.util.ArrayList;

public class Injection_protocol {

    private String name;
    private boolean pediatricUse;
    private String weightRange;
    private ArrayList<Integer> stations;
    private ArrayList<String> injectorModels;
    private ArrayList<Integer> procedureTypes;
    private int catheter;
    private Integer injectionDelay=null;
    private Integer scanDelay=null;
    private int concentrationValue;
    private String concentrationUnit;
    private int peakPressureValue;
    private String peakPressureUnit;
    private String container;
    private String jsonlibrary;
    private String jsonphases;
    private String editionAuthor;
    private String editionDate;
    private Library library;
    private Family family;
    private List<Phase> phases;
    private String jsonfamily;

    public void setFamily(Family family) {
        this.family = family;
    }

    public void setPhases(List<Phase> phases) {
        this.phases = phases;
    }

    public String getJsonlibrary() {
        return jsonlibrary;
    }

    public void setJsonlibrary(String jsonlibrary) {
        this.jsonlibrary = jsonlibrary;
    }

    public String getJsonfamily() {
        return jsonfamily;
    }

    public void setJsonfamily(String jsonfamily) {
        this.jsonfamily = jsonfamily;
    }

    public String getJsonphases() {
        return jsonphases;
    }

    public void setJsonphases(String jsonphases) {
        this.jsonphases = jsonphases;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isPediatricUse() {
        return pediatricUse;
    }

    public void setPediatricUse(boolean pediatricUse) {
        this.pediatricUse = pediatricUse;
    }

    public String getWeightRange() {
        return weightRange;
    }

    public void setWeightRange(String weightRange) {
        this.weightRange = weightRange;
    }

    public ArrayList<Integer> getStations() {
        return stations;
    }

    public void setStations(ArrayList<Integer> stations) {
        this.stations = stations;
    }

    public ArrayList<String> getInjectorModels() {
        return injectorModels;
    }

    public void setInjectorModels(ArrayList<String> injectorModels) {
        this.injectorModels = injectorModels;
    }

    public ArrayList<Integer> getProcedureTypes() {
        return procedureTypes;
    }

    public void setProcedureTypes(ArrayList<Integer> procedureTypes) {
        this.procedureTypes = procedureTypes;
    }

    public Integer getInjectionDelay() {
        return injectionDelay;
    }

    public void setInjectionDelay(Integer injectionDelay) {
        this.injectionDelay = injectionDelay;
    }

    public Integer getScanDelay() {
        return scanDelay;
    }

    public void setScanDelay(Integer scanDelay) {
        this.scanDelay = scanDelay;
    }

    public int getConcentrationValue() {
        return concentrationValue;
    }

    public void setConcentrationValue(int concentrationValue) {
        this.concentrationValue = concentrationValue;
    }

    public String getConcentrationUnit() {
        return concentrationUnit;
    }

    public void setConcentrationUnit(String concentrationUnit) {
        this.concentrationUnit = concentrationUnit;
    }

    public int getPeakPressureValue() {
        return peakPressureValue;
    }

    public void setPeakPressureValue(int peakPressureValue) {
        this.peakPressureValue = peakPressureValue;
    }

    public String getPeakPressureUnit() {
        return peakPressureUnit;
    }

    public void setPeakPressureUnit(String peakPressureUnit) {
        this.peakPressureUnit = peakPressureUnit;
    }

    public String getContainer() {
        return container;
    }

    public void setContainer(String container) {
        this.container = container;
    }

    public Library getLibrary() {
        return library;
    }

    public void setLibrary(Library library) {
        this.library = library;
    }


    public String getEditionAuthor() {
        return editionAuthor;
    }

    public void setEditionAuthor(String editionAuthor) {
        this.editionAuthor = editionAuthor;
    }

    public String getEditionDate() {
        return editionDate;
    }

    public void setEditionDate(String editionDate) {
        this.editionDate = editionDate;
    }


    public int getCatheter() {
        return catheter;
    }

    public void setCatheter(int catheter) {
        this.catheter = catheter;
    }

    public void transformJsonFields() {
        Gson gson = new Gson();

        setFamily(gson.fromJson(jsonfamily, Family.class));
        setLibrary(gson.fromJson(jsonlibrary, Library.class));
        setPhases(Arrays.asList(gson.fromJson(jsonphases, Phase[].class)));

        setJsonfamily(null);
        setJsonphases(null);
        setJsonlibrary(null);

    }
}


