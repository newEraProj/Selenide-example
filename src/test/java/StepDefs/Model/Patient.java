package StepDefs.Model;

import java.util.ArrayList;

public class Patient {

    private String patientId;
    private String firstName;
    private String lastName;
    private String gender;
    private String birthDate;
    private Float weight;
    private Integer height;
    private String pregnancy;
    private String breastfeeding;
    private Boolean isChild;

    private ArrayList<String> hypersensitivities = new ArrayList<>();
    private ArrayList<String> lastEgfrValues = new ArrayList<>();
    private ArrayList<String> lastScrValues = new ArrayList<>();

    public void initEmptyFields(){
        if(hypersensitivities == null){
            hypersensitivities = new ArrayList<>();
        }
        if(lastEgfrValues == null){
            lastEgfrValues = new ArrayList<>();
        }
        if(lastScrValues == null){
            lastScrValues = new ArrayList<>();
        }
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public String getPregnancy() {
        return pregnancy;
    }

    public void setPregnancy(String pregnancy) {
        this.pregnancy = pregnancy;
    }

    public String getBreastfeeding() {
        return breastfeeding;
    }

    public void setBreastfeeding(String breastfeeding) {
        this.breastfeeding = breastfeeding;
    }

    public Boolean getChild() {
        return isChild;
    }

    public void setChild(Boolean child) {
        isChild = child;
    }

    public ArrayList<String> getHypersensitivities() {
        return hypersensitivities;
    }

    public void setHypersensitivities(ArrayList<String> hypersensitivities) {
        this.hypersensitivities = hypersensitivities;
    }

}
