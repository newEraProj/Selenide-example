package Helpers;

import com.auth0.jwt.JWT;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.google.common.io.Resources;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;

public class GuerbetPropertyManager {

    private static GuerbetPropertyManager instance = null;
    private static String backURL;
    private static String frontURL;
    private static String siteId;
    private static String token;
    private static String tenant;
    private static String encodedCredentials;

    public static GuerbetPropertyManager getInstance() {
        if (instance == null) {
            instance = new GuerbetPropertyManager();
        }
        instance.loadData();
        return instance;
    }

    private void loadData() {
        Properties prop = new Properties();
        try {
            URL res = Resources.getResource("configuration.properties");
            prop.load(new FileInputStream(res.getFile()));
        } catch (IOException e) {
            System.out.println("Configuration properties file cannot be found");
        }
        backURL = prop.getProperty("backURL");
        frontURL = prop.getProperty("frontURL");
        siteId = prop.getProperty("siteId");
    }

    public void initTokenAndTenant(String accessToken, String credentials) {
        token = accessToken;

        String encodeTenant = accessToken.split("\\.")[0];

        DecodedJWT decode = JWT.decode(accessToken);
        String decodeTenant = decode.getClaim("wp").asString();

        tenant = decodeTenant;
        encodedCredentials = credentials;
    }

    public String getBackURL() {
        return (tenant != null ? backURL + "/" + tenant : backURL) + "/backend";
    }

    public String getFrontURL() {
        return frontURL;
    }

    public String getSiteId() {
        if (siteId == null) {
            siteId = "1";
        }
        return siteId;
    }

    public static String getToken() {
        return token;
    }

    public static String getTenant() {
        return tenant;
    }

    public static String getEncodedCredentials() {
        return encodedCredentials;
    }

}
