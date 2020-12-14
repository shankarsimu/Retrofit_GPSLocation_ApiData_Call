package com.example.rupeektask;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.pm.PackageManager;
/**
 * Author : Shankar
 * github : https://github.com/shankarsimu/
 * Reach out for this project is available on github
 */




import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private GPSTracker gpsTracker;
    private TextView tvLatitude, tvLongitude, listView;
    private Button button;
    // private  ListView listView;
    RecyclerView recyclerView;
    List<DataModel> dataModelList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvLatitude = (TextView) findViewById(R.id.latTxt);
        tvLongitude = (TextView) findViewById(R.id.longTxt);
//        button = (Button) findViewById(R.id.getLoc);
        recyclerView = (RecyclerView) findViewById(R.id.list);
        dataModelList = new ArrayList<>();

        getLocation();

        try {
            if (ContextCompat.checkSelfPermission(getApplicationContext(), android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this, new String[]{android.Manifest.permission.ACCESS_FINE_LOCATION}, 101);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        //retrofit pulgin
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://www.mocky.io/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiInterface apiInterface = retrofit.create(ApiInterface.class);
        Call<DataJSON> call = apiInterface.getDataModel();

        call.enqueue(new Callback<DataJSON>() {
            @Override
            public void onResponse(Call<DataJSON> call, Response<DataJSON> response) {

                DataJSON dataJSON = response.body();
                dataModelList = new ArrayList<>(Arrays.asList(dataJSON.getData()));

                PutDataInRecyclerView(dataModelList);
            }

            @Override
            public void onFailure(Call<DataJSON> call, Throwable t) {

            }
        });

    }

    private void PutDataInRecyclerView(List<DataModel> dataModelList) {
        DataAdapter dataAdapter = new DataAdapter(this, dataModelList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(dataAdapter);
    }

    public void getLocation() {
        gpsTracker = new GPSTracker(MainActivity.this);
        if (gpsTracker.canGetLocation()) {
            double latitude = gpsTracker.getLatitude();
            double longitude = gpsTracker.getLongitude();
            tvLatitude.setText(String.valueOf(latitude));
            tvLongitude.setText(String.valueOf(longitude));
            Toast.makeText(getApplicationContext(), "" + latitude + "" + longitude, Toast.LENGTH_LONG).show();
        } else {
            gpsTracker.showSettingsAlert();
        }
    }
}