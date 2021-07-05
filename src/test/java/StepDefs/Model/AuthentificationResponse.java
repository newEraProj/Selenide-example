package StepDefs.Model;

public class AuthentificationResponse {
    private String token_type;
    private int expires_in;
    private String access_token;
    private String license_expiration_date;


    public String getToken_type() {
        return token_type;
    }

    public void setToken_type(String token_type) {
        this.token_type = token_type;
    }

    public int getExpires_in() {
        return expires_in;
    }

    public void setExpires_in(int expires_in) {
        this.expires_in = expires_in;
    }

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public String getLicense_expiration_date() {
        return license_expiration_date;
    }

    public void setLicense_expiration_date(String license_expiration_date) {
        this.license_expiration_date = license_expiration_date;
    }
}
