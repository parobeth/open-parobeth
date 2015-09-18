package com.parobeth.mchase;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;

import static java.lang.Math.abs;

public class GyroscopeController implements SensorEventListener, GameController {

    private static final float EPSILON = 0.1f;
    private SensorManager sensorManager;
    private Sensor sensor;
    private boolean initialised = false;
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

        if (!initialised) {
            init();
            initialised = true;
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
    }

    @Override
    public void onResume() {
        sensorManager.registerListener(this, sensor, SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    public void onPause() {
        sensorManager.unregisterListener(this);
    }

    @Override
    public int getDeltaX() {
        if (abs(currX - midX) < EPSILON) return 0;
        return Float.compare(currX, midX);
    }

    @Override
    public int getDeltaY() {
        if (abs(currY - midY) < EPSILON) return 0;
        return Float.compare(currY, midY);
    }

    @Override
    public String getDebug() {
        return String.format("midX: %05.2f midY: %05.2f currX: %05.2f currY %05.2f", midX, midY, currX, currY);
    }

    private void init() {
        midY = currY;
        midX = currX;
    }
}
