package org.example;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class AnotherApi {

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
                //System.out.println(sb);
                JSONObject jsonObjcet = new JSONObject(sb.toString());

            JSONObject cityObjcet = (JSONObject) jsonObjcet.get("city");


                    System.out.println("Details of JSONObject");
                    System.out.println(cityObjcet.get("geoname_id").toString());
                    System.out.println(cityObjcet.get("name").toString());
                    System.out.println(cityObjcet.get("lat").toString());
                    System.out.println(cityObjcet.get("lon").toString());
                    System.out.println(cityObjcet.get("country").toString());
                    System.out.println(cityObjcet.get("iso2").toString());
                    System.out.println(cityObjcet.get("type").toString());
                    System.out.println(cityObjcet.get("population").toString());
                conn.disconnect();

            } catch (MalformedURLException e) {

                e.printStackTrace();

            } catch (IOException e) {

                e.printStackTrace();
            }
        }
    }