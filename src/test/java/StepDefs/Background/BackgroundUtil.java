package StepDefs.Background;


import Helpers.GuerbetPropertyManager;
import Helpers.OkHttpUtil;
import StepDefs.Model.AuthentificationResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import okhttp3.*;

public class BackgroundUtil {

  /*
  Method used to  call the Rest API throw POST request
     Params :
       . object to send
       . url to reach by the Post request
   */
  static public Response callPostBearerAuhtRestAPI(Object obj, String url) {
    Response response = null;

    Gson gson = new Gson();
    String json = gson.toJson(obj);

    try {
      OkHttpUtil.init(true);
      OkHttpClient client = OkHttpUtil.getClient();
      RequestBody requestBody = RequestBody
              .create(MediaType.get("application/json; charset=utf-8"), json);

      String token = GuerbetPropertyManager.getInstance().getToken();

      Request request = new Request.Builder()
              .url(url)
              .addHeader("Authorization", "Bearer " + token)
              .post(requestBody)
              .build();
      response = client.newCall(request).execute();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return response;
  }

  /*
  Method used to  call the Rest API throw PUT request
     Params :
       . object to send
       . url to reach by the PUT request
   */
  static public Response callPutBearerAuhtRestAPI(Object obj, String url) {
    Response response = null;

    Gson gson = new Gson();
    String json = gson.toJson(obj);

    try {
      OkHttpUtil.init(true);
      OkHttpClient client = OkHttpUtil.getClient();
      RequestBody requestBody = RequestBody
              .create(MediaType.get("application/json; charset=utf-8"), json);

      String token = GuerbetPropertyManager.getInstance().getToken();

      Request request = new Request.Builder()
              .url(url)
              .addHeader("Authorization", "Bearer " + token)
              .put(requestBody)
              .build();
      response = client.newCall(request).execute();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return response;
  }


  /*
  Method used to  call the Rest API throw GET request
     Params :
       . url to reach by the Get request
   */
  static public Response callGetBearerAuthRestAPI(String url) {
    Response response = null;

    try {
      OkHttpUtil.init(true);
      OkHttpClient client = OkHttpUtil.getClient();

      String token = GuerbetPropertyManager.getInstance().getToken();

      Request request = new Request.Builder()
              .url(url)
              .addHeader("Authorization", "Bearer " + token)
              .get()
              .build();

      response = client.newCall(request).execute();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return response;
  }


  static public Response callPostBasicAuthRestAPI(String credentials, String url) {
    Response response = null;

    try {
      OkHttpUtil.init(true);
      OkHttpClient client = OkHttpUtil.getClient();

      MediaType mediaType = MediaType.parse("application/json");
      RequestBody body = RequestBody.create(mediaType, "");

      Request request = new Request.Builder()
              .url(url)
              .addHeader("Authorization", "Basic " + credentials)
              .post(body)
              .build();

      response = client.newCall(request).execute();

      ObjectMapper mapper = new ObjectMapper();
      AuthentificationResponse authentResponse = mapper.readValue(response.body().string(), AuthentificationResponse.class);
      if(authentResponse.getAccess_token() != null){
        GuerbetPropertyManager.getInstance().initTokenAndTenant(authentResponse.getAccess_token(), credentials);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return response;
  }

  public static List<Map<String, String>> updateLoginPassword(List<Map<String, String>> list) {

    String login = list.get(0).get("login");
    String password = getPassword(login);

    Map<String, String> map = new HashMap<String, String>();
    map.put("login", login);
    map.put("password", password);
    list = new ArrayList<Map<String, String>>();
    list.add(map);
    return list;
  }

  /*
  Password is localized here ( password will be find outside the code)
   */
  private static String getPassword(String login) {
    String pass = "";
    switch (login) {
      case "test":
        pass = "test123!";
        break;
      case "admin":
        pass = "T9/VQXbSbj6_TaC";
        break;
    }
    return pass;
  }
}