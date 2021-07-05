package StepDefs.Model;

import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Station {

    private String id;
    private String name;
    private String modalityType;
    private String manufacturer;
    private String model;
    private Boolean aetitleFilter;
    private Boolean scheduledNameFilter;
    private Boolean spsLocationFilter;
    private Boolean modalityTypeFilter;
    private Boolean favorite;
    private String zoneId = null;
    private String siteId;
    private ArrayList<String> networkPeersId = new ArrayList<>();
    private ArrayList<String> zones = new ArrayList<>();

    private List<Injector> injectors;
    private String gsonInjectors;

    public String getGsonInjectors() {
        return gsonInjectors;
    }

    public void setGsonInjectors(String gsonInjectors) {
        this.gsonInjectors = gsonInjectors;
    }

    public String getSiteId() {
        return siteId;
    }

    public void setSiteId(String siteId) {
        this.siteId = siteId;
    }



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getModalityType() {
        return modalityType;
    }

    public void setModalityType(String modalityType) {
        this.modalityType = modalityType;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Boolean getAetitleFilter() {
        return aetitleFilter;
    }

    public void setAetitleFilter(Boolean aetitleFilter) {
        this.aetitleFilter = aetitleFilter;
    }

    public Boolean getScheduledNameFilter() {
        return scheduledNameFilter;
    }

    public void setScheduledNameFilter(Boolean scheduledNameFilter) {
        this.scheduledNameFilter = scheduledNameFilter;
    }

    public Boolean getSpsLocationFilter() {
        return spsLocationFilter;
    }

    public void setSpsLocationFilter(Boolean spsLocationFilter) {
        this.spsLocationFilter = spsLocationFilter;
    }

    public Boolean getModalityTypeFilter() {
        return modalityTypeFilter;
    }

    public void setModalityTypeFilter(Boolean modalityTypeFilter) {
        this.modalityTypeFilter = modalityTypeFilter;
    }

    public Boolean getFavorite() {
        return favorite;
    }

    public void setFavorite(Boolean favorite) {
        this.favorite = favorite;
    }

    public String getZoneId() {
        return zoneId;
    }

    public void setZoneId(String zoneId) {
        this.zoneId = zoneId;
    }

    public ArrayList<String> getNetworkPeersId() {
        return networkPeersId;
    }

    public void setNetworkPeersId(ArrayList<String> networkPeersId) {
        this.networkPeersId = networkPeersId;
    }

    public ArrayList<String> getZones() {
        return zones;
    }

    public void setZones(ArrayList<String> zones) {
        this.zones = zones;
    }

    public List<Injector> getInjectors() {
        return injectors;
    }

    public void setInjectors(List<Injector> injectors) {
        this.injectors = injectors;
    }

    static public List<Injector> transformToInjectorList(String gsoNinjectors) {

        if ( gsoNinjectors!= null && gsoNinjectors.length()>0) {
            Gson gson = new Gson();
            return Arrays.asList(gson.fromJson(gsoNinjectors, Injector[].class));
        }
        return null;
    }
}

