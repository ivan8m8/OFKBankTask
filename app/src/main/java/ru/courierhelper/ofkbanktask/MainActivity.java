package ru.courierhelper.ofkbanktask;

import android.app.ProgressDialog;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private ListView listView;

    private ArrayList<Restaurant> restaurants;
    private RestaurantsAdapter restaurantsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.listView);
        restaurants = new ArrayList<>();

        fetchData();
    }

    private void fetchData(){
        if (isInternetAvailable()) {
            final ProgressDialog progressDialog;
            progressDialog = new ProgressDialog(MainActivity.this);
            progressDialog.setTitle("Loading");
            progressDialog.setMessage("Fetching data");
            progressDialog.setCanceledOnTouchOutside(false);
            progressDialog.show();

            RetrofitClient.ApiService apiService = RetrofitClient.getApiService();
            Call<RestaurantList> call = apiService.getMyJSON();

            call.enqueue(new Callback<RestaurantList>() {
                @Override
                public void onResponse(Call<RestaurantList> call, Response<RestaurantList> response) {
                    progressDialog.dismiss();
                    if (response.isSuccessful() ) {
                        restaurants = response.body().getRestaurants();
                        Log.d("KSI", restaurants.get(0).getAddress());
                        restaurantsAdapter = new RestaurantsAdapter(restaurants, MainActivity.this);
                        listView.setAdapter(restaurantsAdapter);
                    }
                }

                @Override
                public void onFailure(Call<RestaurantList> call, Throwable t) {

                }
            });

        }
    }

    private boolean isInternetAvailable() {
        final ConnectivityManager connectivityManager =
                (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        final NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        return networkInfo != null && networkInfo.isConnected();
    }
}
