package com.successfactor.caf.service.build.trigger.actions;

import com.google.gson.Gson;
import com.successfactor.caf.service.build.trigger.datamodel.CarStatus;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.json.JSONException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpUtils {

    public HttpResponse postSimple(String url, String body) {

        HttpClient httpClient = HttpClientBuilder.create().build();

        try {

            HttpPost request = new HttpPost(url);
            StringEntity params = new StringEntity("payload=" + body);
            request.addHeader("content-type", "application/x-www-form-urlencoded");
            request.setEntity(params);
            HttpResponse response = httpClient.execute(request);

            //handle response here...
            System.out.println(response);
            return response;

        } catch (Exception ex) {

            //handle exception here
            ex.printStackTrace();

        } finally {
        }

        return null;
    }

    public static void main(String[] args) throws IOException, JSONException {

        HttpUtils util = new HttpUtils();
        util.getVolRawObject();
    }

    public CarStatus getVolRawObject() throws IOException, JSONException {

        String url = "https://vocapi-cn.wirelesscar.net/customerapi/rest/v3.0/vehicles/" + System.getenv("VOLVO_NAME") + "/status";
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("X-Device-Id", "Device");
        con.setRequestProperty("X-OS-Type", "Android");
        con.setRequestProperty("X-Originator-Type", "App");
        con.setRequestProperty("X-OS-Version", "22");
        con.setRequestProperty("Content-Type", "application/json");
        con.setRequestProperty("Authorization", System.getenv("VOLVO_TOKEN"));

        int responseCode = con.getResponseCode();
        System.out.println("\nSending 'GET' request to URL : " + url);
        System.out.println("Response Code : " + responseCode);
        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        Gson gson = new Gson();
        CarStatus car = gson.fromJson(response.toString(), CarStatus.class);
        System.out.println(car.getAverageSpeed());
        return car;
    }

}
