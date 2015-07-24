package com.parobeth.myfirstapp;

import android.content.Context;
import android.content.Intent;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;


public class MyActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        TextView mainScreen = (TextView) findViewById(R.id.top);
        mainScreen.setTextSize(40);

        SensorManager sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        GyroscopeController gyroscopeController = GyroscopeController.createGyroscopeControllerIfAvailable(sensorManager);

        if (gyroscopeController == null) {
            mainScreen.setText("No sensor");
            GlobalContext.GAME_CONTROLLER = new DummyController();
        } else {
            mainScreen.setText("Yes sensor");
            GlobalContext.GAME_CONTROLLER = gyroscopeController;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_my, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void start(View view) {
        Intent intent = new Intent(this, GameActivity.class);
        startActivity(intent);
    }
}
