package org.example;

import java.util.List;

public class ArrayListBean {
    private String dt;
    private String pressure;
    private String humidity;
    private String speed;
    private String deg;
    private String clouds;
    private String snow;
    private TempBean tempBean;
    private List<WeatherBean> list;

    public List<WeatherBean> getList() {
        return list;
    }

    public void setList(List<WeatherBean> list) {
        this.list = list;
    }

    public TempBean getTempBean() {
        return tempBean;
    }

    public void setTempBean(TempBean tempBean) {
        this.tempBean = tempBean;
    }

    public String getDt() {
        return dt;
    }

    public void setDt(String dt) {
        this.dt = dt;
    }

    public String getPressure() {
        return pressure;
    }

    public void setPressure(String pressure) {
        this.pressure = pressure;
    }

    public String getHumidity() {
        return humidity;
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }

    public String getSpeed() {
        return speed;
    }

    public void setSpeed(String speed) {
        this.speed = speed;
    }

    public String getDeg() {
        return deg;
    }

    public void setDeg(String deg) {
        this.deg = deg;
    }

    public String getClouds() {
        return clouds;
    }

    public void setClouds(String clouds) {
        this.clouds = clouds;
    }

    public String getSnow() {
        return snow;
    }

    public void setSnow(String snow) {
        this.snow = snow;
    }
}
