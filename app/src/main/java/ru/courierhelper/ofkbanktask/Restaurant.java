package ru.courierhelper.ofkbanktask;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Ivan on 24.05.17.
 */

public class Restaurant {
    @SerializedName("title")
    @Expose
    String title;
    @SerializedName("address")
    @Expose
    String address;
    @SerializedName("lat")
    @Expose
    float lat;
    @SerializedName("lon")
    @Expose
    float lon;
    @SerializedName("wifi")
    @Expose
    boolean wifi;
    @SerializedName("parking")
    @Expose
    boolean parking;
    @SerializedName("averageCheck")
    @Expose
    int averageCheck;
    @SerializedName("cuisine")
    @Expose
    String cuisine;
    @SerializedName("workingTime")
    @Expose
    String workingTime;
    @SerializedName("phone")
    @Expose
    String phone;
    @SerializedName("orderDelay")
    @Expose
    int orderDelay;
    @SerializedName("orderEnabled")
    @Expose
    boolean orderEnabled;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public float getLat() {
        return lat;
    }

    public void setLat(float lat) {
        this.lat = lat;
    }

    public float getLon() {
        return lon;
    }

    public void setLon(float lon) {
        this.lon = lon;
    }

    public boolean isWifi() {
        return wifi;
    }

    public void setWifi(boolean wifi) {
        this.wifi = wifi;
    }

    public boolean isParking() {
        return parking;
    }

    public void setParking(boolean parking) {
        this.parking = parking;
    }

    public int getAverageCheck() {
        return averageCheck;
    }

    public void setAverageCheck(int averageCheck) {
        this.averageCheck = averageCheck;
    }

    public String getCuisine() {
        return cuisine;
    }

    public void setCuisine(String cuisine) {
        this.cuisine = cuisine;
    }

    public String getWorkingTime() {
        return workingTime;
    }

    public void setWorkingTime(String workingTime) {
        this.workingTime = workingTime;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getOrderDelay() {
        return orderDelay;
    }

    public void setOrderDelay(int orderDelay) {
        this.orderDelay = orderDelay;
    }

    public boolean isOrderEnabled() {
        return orderEnabled;
    }

    public void setOrderEnabled(boolean orderEnabled) {
        this.orderEnabled = orderEnabled;
    }
}
