package ru.courierhelper.ofkbanktask;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

/**
 * Created by Ivan on 24.05.17.
 */

public class RetrofitClient {
    private static final String BASE_URL = "http://test.lunchdot.com";

    private static Retrofit getRetrofitInstance() {
        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static ApiService getApiService() {
        return getRetrofitInstance().create(ApiService.class);
    }

    public interface ApiService {
        @GET("/api/restaurant?page=1&perPage=10") // parameters may be not needed
        Call<RestaurantList> getMyJSON();
    }
}
