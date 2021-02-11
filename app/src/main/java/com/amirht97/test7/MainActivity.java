package com.amirht97.test7;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.amirht97.test7.ServicePouya.JsonActivityPouya;
import com.google.gson.Gson;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONObject;

import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;

public class MainActivity extends AppCompatActivity {

    RecyclerView rcView;
    ArrayList<String> type,path_img;
    ArrayList<Double> lat,lng;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getServiceDetails();

    }

    private void getServiceDetails() {

        AsyncHttpClient client = new AsyncHttpClient();
        client.get("https://pouyaheydari.com/vehicles.json",new JsonHttpResponseHandler(){
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                super.onSuccess(statusCode, headers, response);
                type = new ArrayList<>();
                path_img = new ArrayList<>();
                lat = new ArrayList<>();
                lng = new ArrayList<>();

                Gson gson = new Gson();
                JsonActivityPouya pouya = gson.fromJson(response.toString(),JsonActivityPouya.class);
                for(int i=0; i < pouya.getVehicles().size();i++) {
                    type.add("Type : "+pouya.getVehicles().get(i).getType().toString());
                    lat.add(pouya.getVehicles().get(i).getLat());
                    lng.add(pouya.getVehicles().get(i).getLng());
                    path_img.add(pouya.getVehicles().get(i).getImageUrl());
                }
                init();
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
                super.onFailure(statusCode, headers, throwable, errorResponse);
                Toast.makeText(MainActivity.this, "The Connection is Failed "+statusCode, Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void init() {
        rcView=findViewById(R.id.rcView);
        LinearLayoutManager manager = new LinearLayoutManager(MainActivity.this, RecyclerView.VERTICAL,false);
        rcView.setLayoutManager(manager);
        RecycleAdapter adapter = new RecycleAdapter(type,lat,lng,path_img);
        rcView.setAdapter(adapter);
    }
}