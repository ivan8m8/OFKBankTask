package ru.courierhelper.ofkbanktask;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Ivan on 24.05.17.
 */

public class RestaurantsAdapter extends ArrayAdapter<Restaurant> {
    private List<Restaurant> restaurants;
    private LayoutInflater inflater;
    private Context context;

    private RestaurantsAdapter(List<Restaurant> restaurants, Context context) {
        super(context, 0, restaurants);
        this.restaurants = restaurants;
        this.context = context;
        this.inflater = LayoutInflater.from(context);
    }

    @Nullable
    @Override
    public Restaurant getItem(int position) {
        return restaurants.get(position);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        final ViewHolder viewHolder;
        if (convertView == null){
            View view = inflater.inflate(R.layout.row, parent, false);
            viewHolder = ViewHolder.create((RelativeLayout)view);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        Restaurant item = getItem(position);
        viewHolder.address.setText(item.getAddress());
        viewHolder.name.setText(item.getTitle());
        if (restaurants.get(position).isParking()){
            viewHolder.parking.setTextColor(parent.getResources().getColor(R.color.colorGreen));
        } else {
            viewHolder.parking.setTextColor(parent.getResources().getColor(R.color.colorRed));
        }
        if (restaurants.get(position).isWifi()){
            viewHolder.wifi.setTextColor(parent.getResources().getColor(R.color.colorGreen));
        } else {
            viewHolder.wifi.setTextColor(parent.getResources().getColor(R.color.colorRed));
        }
        return viewHolder.relativeLayout;
    }

    private static class ViewHolder {
        private final RelativeLayout relativeLayout;
        private final TextView name;
        private final TextView address;
        private final TextView wifi;
        private final TextView parking;

        private ViewHolder(RelativeLayout relativeLayout, TextView name, TextView address, TextView wifi, TextView parking) {
            this.relativeLayout = relativeLayout;
            this.name = name;
            this.address = address;
            this.wifi = wifi;
            this.parking = parking;
        }

        private static ViewHolder create(RelativeLayout relativeLayout){
            TextView name = (TextView)relativeLayout.findViewById(R.id.restaurantName);
            TextView address = (TextView)relativeLayout.findViewById(R.id.restaurantAddress);
            TextView wifi = (TextView)relativeLayout.findViewById(R.id.wifi);
            TextView parking = (TextView)relativeLayout.findViewById(R.id.parking);

            return new ViewHolder(relativeLayout, name, address, wifi, parking);
        }
    }
}
