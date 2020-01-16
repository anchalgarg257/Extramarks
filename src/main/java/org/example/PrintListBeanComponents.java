package org.example;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class PrintListBeanComponents {
    public static void main(String[] args) {
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

//            JSONObject cityObjcet = (JSONObject) jsonObjcet.get("city");

            JSONArray listObject = (JSONArray) jsonObjcet.get("list");

            System.out.println("Calling setters");

            List<ArrayListBean> list = new ArrayList<>();

            for (int i = 0; i < listObject.length(); i++) {
                JSONObject jsonObject12 = (JSONObject) listObject.get(i);

                ArrayListBean lb = new ArrayListBean();

                lb.setDt(jsonObject12.has("dt") ? jsonObject12.get("dt").toString() : "");
                lb.setHumidity(jsonObject12.get("humidity").toString());

                list.add(lb);

//                System.out.println("Details of JSONObject"+(i+1));
//
//                    System.out.println(jsonObject12.toString());
//                    System.out.println(jsonObject12.get("clouds").toString());
            }

            for (ArrayListBean lb : list) {

                System.out.println(lb.getDt());
            }
                conn.disconnect();

            } catch(MalformedURLException e){

                e.printStackTrace();
                System.out.println(e);

            } catch(IOException e){

                e.printStackTrace();
            }
        }
    }