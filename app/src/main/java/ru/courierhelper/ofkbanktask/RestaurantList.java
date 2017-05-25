package ru.courierhelper.ofkbanktask;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by Ivan on 24.05.17.
 */

public class RestaurantList {
    @SerializedName("data")
    @Expose
    private ArrayList<Restaurant> restaurants = new ArrayList<>();

    public ArrayList<Restaurant> getRestaurants() {
        return restaurants;
    }

    public void setRestaurants(ArrayList<Restaurant> restaurants) {
        this.restaurants = restaurants;
    }
}
