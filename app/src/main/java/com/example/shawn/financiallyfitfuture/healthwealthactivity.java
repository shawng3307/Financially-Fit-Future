package com.example.shawn.financiallyfitfuture;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.util.JsonReader;
import java.util.*;
import android.util.*;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;

public class healthwealthactivity extends AppCompatActivity {

    private TextView mTextMessage;
    private FloatingActionButton fab;
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_health:
                    mTextMessage.setText("Health");
                    return true;
                case R.id.navigation_wealth:
                    mTextMessage.setText("Wealth");
                    return true;

            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_healthwealthactivity);

        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //launch unity
                Intent i = new Intent(getApplicationContext(), AR_Activity.class);
                startActivity(i);
            }
        });

       // mTextMessage.setText(LoadJSON(getApplicationContext()));
        JSONObject master = parseJSON(LoadJSON(getApplicationContext()));



    }
    public String LoadJSON(Context context){
        String json = null;
        try {
            InputStream is = context.getAssets().open("challenges.json");

            int size = is.available();

            byte[] buffer = new byte[size];

            is.read(buffer);

            is.close();

            json = new String(buffer, "UTF-8");


        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }

    public JSONObject parseJSON(String s){
        JSONObject json = null;
        try{
            json = new JSONObject(s);
        }
        catch(JSONException e){
            e.printStackTrace();
            return null;
        }



        return json;
    }

}
