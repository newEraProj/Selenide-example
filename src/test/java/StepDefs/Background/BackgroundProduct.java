package StepDefs.Background;

import Helpers.GuerbetPropertyManager;

import Helpers.UtilsDate;
import StepDefs.Model.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import cucumber.api.java.en.And;
import okhttp3.Response;

import java.io.IOException;
import java.util.List;

public class BackgroundProduct {
    String backURL = GuerbetPropertyManager.getInstance().getBackURL();
    String siteId = GuerbetPropertyManager.getInstance().getSiteId();

    @And("^Following products exist$")
    public void following_products_exist(List<Product> products) {

        for (Product product : products) {
            product.setValidityDate(UtilsDate.getExpirationDate(product.getValidityDate()));
            BackgroundUtil.callPostBearerAuhtRestAPI(product, backURL + "/config/sites/" + siteId + "/products");
        }
    }

    @And("^Following products exist for procedure \"([^\"]*)\"$")
    public void following_products_exist_for_procedure(String procedureAccessNumber, List<Product> products) {
        String procedureId = this.getProcedureIdByAccessNumber(procedureAccessNumber);

        for (Product product : products) {
            product.setValidityDate(UtilsDate.getExpirationDate(product.getValidityDate()));
            BackgroundUtil.callPostBearerAuhtRestAPI(product, backURL + "/examinations/" + procedureId + "/products");
        }
    }

    private String getProcedureIdByAccessNumber(String procedureAccessNumber) {
        String procedureId = "";

        Response response = BackgroundUtil.callGetBearerAuthRestAPI(backURL + "/examinations/" + procedureAccessNumber + "/id");

        ObjectMapper mapper = new ObjectMapper();
        try {
            ParentProcedure parent = mapper.readValue(response.body().string(), ParentProcedure.class);
            procedureId = parent.getId();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return procedureId;
    }


}
