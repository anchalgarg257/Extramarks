package org.example;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class CityApi {
    public static void main(String[] arg) {

        try {

            URL url = new URL("https://samples.openweathermap.org/data/2.5/forecast/daily?id=524901&lang=zh_cn&appid=b1b15e88fa797225412429c1c50c122a1");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");
            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + conn.getResponseCode());
            }
            BufferedReader br = new BufferedReader(new InputStreamReader(
                    (conn.getInputStream())));
            String buffer;
            StringBuilder sb = new StringBuilder();
            System.out.println("Output from Server .... \n");
            while ((buffer = br.readLine()) != null) {
                sb.append(buffer);
            }
           CityBean cityBean =  getCityObject(sb.toString());
            System.out.println(cityBean.getLat()+"\t"+cityBean.getLon());

        } catch (MalformedURLException e) {

            e.printStackTrace();

        } catch (IOException e) {

            e.printStackTrace();
        }
    }

    /**
     * This method print the values of the cityObject in JSON Response
     * @param response
     */
    private static CityBean getCityObject(String response) {
        JSONObject jsonObjcet = new JSONObject(response);

        JSONObject cityObjcet = (JSONObject) jsonObjcet.get("city");

        CityBean cityBean = new CityBean();
        cityBean.setName(cityObjcet.has("name") ? cityObjcet.getString("name") : "");
        cityBean.setLat(cityObjcet.has("lat") ? cityObjcet.get("lat").toString() : "");
        cityBean.setLon(cityObjcet.has("lon") ? cityObjcet.get("lon").toString() : "");
        return cityBean;

//
//        System.out.println("Details of JSONObject");
//
//        System.out.println(cityBean.getName());
//        System.out.println(cityBean.getLat());
//        System.out.println(cityBean.getLon());
    }
}
