package StepDefs.Background;

import Helpers.GuerbetPropertyManager;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonObject;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import okhttp3.Response;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.*;

public class BackgroundOthers {

    String backURL = GuerbetPropertyManager.getInstance().getBackURL();
    String siteId = GuerbetPropertyManager.getInstance().getSiteId();

    @Given("^Database is empty$")
    public void cleanDatabase(){
        //Clean database in backend
        String [] exclude = {"Profile","User"};

        BackgroundUtil.callPostBearerAuhtRestAPI(exclude,backURL + "/api/cleanDatabasesExcept");

        //Clean databases in EAI (drop and create)
        String backURLWithBackend = StringUtils.removeEnd(backURL, "/backend");
        String encodedCredentials = GuerbetPropertyManager.getInstance().getEncodedCredentials();
        BackgroundUtil.callPostBasicAuthRestAPI(encodedCredentials,backURLWithBackend + "/api/eai/actions/database/1337all1337/drop");
        BackgroundUtil.callPostBasicAuthRestAPI(encodedCredentials,backURLWithBackend + "/api/eai/actions/database/1337all1337/create");


        //Set default datas in the backend
        initDefaultDatas();
    }

    public void initDefaultDatas(){
        initDefautSites();
        initDefaultTimeout();
        initDefaultProtocolInformations();
        initDefaultLicense();
        initClinicalSettings();
    }

    private void initDefautSites() {
        //Add a first site
        Map<String,Object> site = new HashMap<>();
        site.put("address","13 rue de la Paix 38000 Grenoble" );
        site.put("comments","A comment...");
        site.put("contactName","Mr Contactor");
        site.put("email","contactor@mail.com");
        site.put("lang","en-US");
        site.put("name","Hospital Hauto");
        site.put("phoneNumber","04 05 06 07 08");
        site.put("isDeletable",false);
        BackgroundUtil.callPostBearerAuhtRestAPI(site,backURL + "/config/sites");
    }

    private void initDefaultTimeout() {
        //Set timeout
        Map<String,Integer> timeout = new HashMap<>();
        timeout.put("web",60);
        timeout.put("mobile",60);
        BackgroundUtil.callPutBearerAuhtRestAPI(timeout,backURL + "/config/timeout");
    }

    private void initDefaultProtocolInformations() {
        //Add default library
        Map<String,String> library = new HashMap<>();
        library.put("name","Medex library");
        BackgroundUtil.callPostBearerAuhtRestAPI(library,backURL + "/config/sites/"+siteId+"/protocol-libraries");

        //Add default family
        Map<String,Object> family = new HashMap<>();
        family.put("hasProtocols",false);
        family.put("name","Cardiac");
        BackgroundUtil.callPostBearerAuhtRestAPI(family,backURL + "/config/sites/"+siteId+"/protocol-families");
    }

    private void initDefaultLicense() {

        try {
            //Set License
            Map<String,String> license = new HashMap<>();
            license.put("core","ewogICAiQ3JlYXRpb25EYXRlVGltZSI6ICIyMDIwLTAzLTA0IDEwOjMyOjMyIiwKICAgInRlbmFudElEIjogIjExMTExMSIsCiAgICJ0ZW5hbnROYW1lIjoiTXlUZW5hbnQiLAogICAiY29yZU1vbnRoZXNWYWxpZGl0eSI6IDI0Cn0=.DDH4cteFMsUTGQqhzyMcwzECj2fQ8w7YyHwaZO0PRdVTNhsvR1Jr/s7E/wZcz4BjZbgv7nAKs5VngafCy4KzOAZE+tjrHOMYiG6KIPiZtGuVerV0tKdLjDNAOucT3vNqONP1vefmP75Zfu4PwECVoIdE5Hac/4g0Qpyo6BnXWas=");
            license.put("analytics","ewogICAiQ3JlYXRpb25EYXRlVGltZSI6ICIyMDIwLTAzLTA0IDEwOjMyOjMyIiwKICAgInRlbmFudElEIjogIjExMTExMSIsCiAgICJ0ZW5hbnROYW1lIjoiTXlUZW5hbnQiLAogICAiYW5hbHl0aWNzRW5hYmxlIjoidHJ1ZSIKfQ==.hmNA/g/3LpJyaIeNGLlAneX4hHfwqBcaOSgBe9ajkXvsP3qbKZiGHDitmP9hfMosto1YuLVqj8iPt1M7vM1AaOkL3+Ha8VMpUniNh1Av76mZsHiyKfgd8WSJYjqoziSqkflj7KR59eZ5ImAagc/sh5MqXvgsHMSlTXUNamM8qy0=");
            license.put("injectors","ewogICAiQ3JlYXRpb25EYXRlVGltZSI6ICIyMDIwLTAzLTA0IDEwOjMyOjMyIiwKICAgInRlbmFudElEIjogIjExMTExMSIsCiAgICJ0ZW5hbnROYW1lIjoiTXlUZW5hbnQiLAogICAibWF4Q29ubmVjdGVkSW5qZWN0b3JzIjogNgp9.an7mdBFd5BZBux+NfqqziGWYh6vZBF0lIgNGn3IgQGb0/4i9N0uRwJaqQ4wx8XXgQTtvffB/BCZPAn7P2+DNZWWnDMqFeZZhQLozXJV50XeWqusCQlYiWPWCOi2VNKloUV0Hvd7gWGT7asaxuMdvxYnU+WKYT1kNvp6IS2EczkM=");
            license.put("clientId","-----BEGIN PUBLIC KEY-----\nMIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQC7repdjrQgZm0dc9yykwoZLFzy\nOsvVH6jed6B4aMiv1nlVLcQOU+wNoPcWvbZpQYM7J6UEDq6nVcra6h6oT1MDfraq\n2q1lQYONsXh8brPbd4bu3UmWgQqqd8uTYi4tAGSVmy8EWtEJ20TAKm2RXNO2CYRx\nZ8ZOxIUb21SWsvpzjQIDAQAB\n-----END PUBLIC KEY-----");
            BackgroundUtil.callPutBearerAuhtRestAPI(license,backURL + "/config/license");

            //Get License
            Response response = BackgroundUtil.callGetBearerAuthRestAPI(backURL + "/config/license");

            //Retrieved informations
            ObjectMapper mapper = new ObjectMapper();
            Map<String,String> licenseResult = mapper.readValue(response.body().string(), Map.class);
            String licenseCoreId = licenseResult.getOrDefault("coreId", null);
            String licenseAnalyticsId = licenseResult.getOrDefault("analyticsId", null);
            String licenseInjectorsId = licenseResult.getOrDefault("injectorsId", null);

            //Activate license
            Map<String,Object> activate = new HashMap<>();
            activate.put("validityDate","2032-01-01");
            activate.put("analytics",true);
            activate.put("maxInjectors",50);
            activate.put("coreId",licenseCoreId);
            activate.put("analyticsId",licenseAnalyticsId);
            activate.put("injectorsId",licenseInjectorsId);
            BackgroundUtil.callPostBearerAuhtRestAPI(activate,backURL + "/config/license/activate");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void initClinicalSettings() {
        //display settings
        Map<String,Object> displaySettings = new HashMap<>();
        JsonObject compatibilityProductModality = new JsonObject();
        compatibilityProductModality.addProperty("enabled", false);
        displaySettings.put("compatibilityProductModality",compatibilityProductModality);

        JsonObject pressureUnit = new JsonObject();
        pressureUnit.addProperty("defaultUnit", "bar");
        displaySettings.put("pressureUnit",pressureUnit);

        JsonObject worklistTimeframe = new JsonObject();
        worklistTimeframe.addProperty("beginTime", 200);
        worklistTimeframe.addProperty("endTime", 200);
        displaySettings.put("worklistTimeframe",worklistTimeframe);
        BackgroundUtil.callPutBearerAuhtRestAPI(displaySettings,backURL + "/config/sites/"+siteId+"/display-settings");

        //clearance settings
        Map<String,Object> clearanceSettings = new HashMap<>();
        clearanceSettings.put("adultUseMethod","MDRD");
        clearanceSettings.put("egfrLevels",new int[]{ 20,80,120 });
        clearanceSettings.put("pediatricUseMethod","CKD-EPI");
        clearanceSettings.put("scrLevels",new int[]{ 2,4,8,12 });
        clearanceSettings.put("scrUnit","mg/dL");
        clearanceSettings.put("validityPeriod",90);
        BackgroundUtil.callPutBearerAuhtRestAPI(clearanceSettings,backURL + "/config/sites/"+siteId+"/clearance-settings");

        //other parameters
        Map<String,Object> otherParam = new HashMap<>();
        JsonObject closureFields = new JsonObject();
        closureFields.addProperty("checkId", true);
        closureFields.addProperty("contrastProduct", true);
        closureFields.addProperty("injection", true);
        otherParam.put("closureFields",closureFields);
        otherParam.put("maxPediatricAge",17);
        otherParam.put("timeBetweenInjections",90);
        BackgroundUtil.callPutBearerAuhtRestAPI(otherParam,backURL + "/config/sites/"+siteId+"/other-clinical-parameters");
    }
}