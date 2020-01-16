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

public class ArrayListComponents {

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

            JSONArray jsonArray = (JSONArray) jsonObjcet.get("list");

            List<ArrayListBean> list = new ArrayList<>();

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject12 = (JSONObject) jsonArray.get(i);

                ArrayListBean lb = new ArrayListBean();

                JSONArray weatherjsonArray = (JSONArray) jsonObject12.get("weather");

                List<WeatherBean> list1 = new ArrayList<>();

                for (int j = 0; j < weatherjsonArray.length(); j++) {
                    JSONObject weatherobject = (JSONObject) weatherjsonArray.get(j);

                    WeatherBean weatherBean = new WeatherBean();

                    weatherBean.setId(weatherobject.has("id") ? weatherobject.get("id").toString() : "");
                    weatherBean.setMain(weatherobject.has("main") ? weatherobject.get("main").toString() : "");

                    list1.add(weatherBean);
                }

                JSONObject tempObjcet = (JSONObject) jsonObject12.get("temp");

                TempBean tempBean = new TempBean();

                tempBean.setDay(tempObjcet.has("day") ? tempObjcet.get("day").toString() : "");
                tempBean.setMax(tempObjcet.has("max") ? tempObjcet.get("max").toString() : "");
                tempBean.setMin(tempObjcet.has("min") ? tempObjcet.get("min").toString() : "");


                lb.setDt(jsonObject12.has("dt") ? jsonObject12.get("dt").toString() : "");
                lb.setPressure(jsonObject12.has("pressure") ? jsonObject12.get("pressure").toString() : "");
                lb.setHumidity(jsonObject12.has("humidity") ? jsonObject12.get("humidity").toString() : "");
                lb.setSpeed(jsonObject12.has("speed") ? jsonObject12.get("speed").toString() : "");
                lb.setDeg(jsonObject12.has("deg") ? jsonObject12.get("deg").toString() : "");
                lb.setClouds(jsonObject12.has("clouds") ? jsonObject12.get("clouds").toString() : "");
                lb.setSnow(jsonObject12.has("snow") ? jsonObject12.get("snow").toString() : "");
                lb.setTempBean(tempBean);
                lb.setList(list1);

                list.add(lb);

            }

            System.out.println("The details of JSON object are:");

                for (ArrayListBean lb : list) {

                    System.out.println(lb.getDt());

                    System.out.println(lb.getTempBean().getDay());
                    System.out.println(lb.getTempBean().getMax());
                    System.out.println(lb.getTempBean().getMin());

                    System.out.println(lb.getPressure());
                    System.out.println(lb.getHumidity());

                    for (WeatherBean weatherBean : lb.getList())
                {
                    System.out.println(weatherBean.getId());
                    System.out.println(weatherBean.getMain());
                }

                    System.out.println(lb.getSpeed());
                    System.out.println(lb.getDeg());
                    System.out.println(lb.getClouds());
                    System.out.println(lb.getSnow());

                }
            }
        catch(MalformedURLException e){

                e.printStackTrace();
                System.out.println(e);

            } catch(IOException e){

                e.printStackTrace();
            }
        }
    }