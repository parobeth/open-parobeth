package com.parobeth.myfirstapp;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;

public class GyroscopeController implements SensorEventListener, GameController {

    private SensorManager sensorManager;
    private Sensor sensor;
    private float midX = 0;
    private float midY = -0.3f;
    private float currX, currY;

    public static GyroscopeController createGyroscopeControllerIfAvailable(SensorManager sensorManager) {
        Sensor sensor = sensorManager.getDefaultSensor(Sensor.TYPE_GAME_ROTATION_VECTOR);

        if (sensor == null) {
            return null;
        } else {
            return new GyroscopeController(sensorManager, sensor);
        }
    }

    private GyroscopeController(SensorManager sensorManager, Sensor sensor) {
        this.sensorManager = sensorManager;
        this.sensor = sensor;
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        currX = event.values[0];
        currY = event.values[1];
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
    }

    public void onResume() {
        sensorManager.registerListener(this, sensor, SensorManager.SENSOR_DELAY_NORMAL);
    }

    public void onPause() {
        sensorManager.unregisterListener(this);
    }

    @Override
    public void init() {
        midY = currY;
        midX = currX;
    }

    @Override
    public int getDeltaX() {
        return Float.compare(currX, midX);
    }

    @Override
    public int getDeltaY() {
        return Float.compare(currY, midY);
    }
}
