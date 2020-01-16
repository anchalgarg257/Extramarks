package org.example;

import org.json.JSONArray;
import org.json.JSONObject;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;

import java.net.URL;


public class MapSampleProgram {

    public static void main(String[] arg) {


        try {

          HttpURLConnection conn = getHttpURLConnection("https://samples.openweathermap.org/data/2.5/forecast/daily?id=524901&lang=zh_cn&appid=b1b15e88fa797225412429c1c50c122a1");
            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + conn.getResponseCode());
            }
            BufferedReader br = new BufferedReader(new InputStreamReader(
                    (conn.getInputStream())));
            String response = getStringFromBufferReader(br);
            JSONObject jsonObjcet = new JSONObject(response);
            getListArray(jsonObjcet);
            conn.disconnect();

        } catch (MalformedURLException e) {

            System.out.println("MalformedURLException " + e.getMessage());
        } catch (IOException e) {

            System.out.println("IOException " + e.getMessage());
        }
    }

    private static void getListArray(JSONObject jsonObjcet) {
        JSONArray listObject = (JSONArray) jsonObjcet.get("list");
        for (int i = 0; i < listObject.length(); i++) {
            JSONObject jsonObject12 = (JSONObject) listObject.get(i);
            System.out.println("Details of JSONObject" + (i + 1));
            System.out.println(jsonObject12.get("dt").toString());
            System.out.println(jsonObject12.get("speed").toString());
        }


    }
    private static HttpURLConnection getHttpURLConnection(String api_url)throws IOException
    {
        URL url = new URL(api_url);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Accept", "application/json");
        return conn;
    }

    private static String getStringFromBufferReader(BufferedReader br)throws IOException
    {
        String buffer;
        StringBuilder sb = new StringBuilder();
        System.out.println("Output from Server .... \n");
        while ((buffer = br.readLine()) != null) {
            sb.append(buffer);
        }
        return sb.toString();
    }
}

