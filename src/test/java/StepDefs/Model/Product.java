package StepDefs.Model;

public class Product {
    private String addedMethod;
    private String code;
    private String concentrationUnit;
    private Integer concentrationValue;
    private String container;
    private String family;
    private String name;
    private String type;
    private String validityDate;
    private Integer volume;

    public String getValidityDate() {
        return validityDate;
    }

    public void setValidityDate(String validityDate) {
        this.validityDate = validityDate;
    }

}
