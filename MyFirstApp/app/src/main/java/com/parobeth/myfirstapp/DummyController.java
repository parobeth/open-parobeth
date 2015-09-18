package com.parobeth.myfirstapp;

import java.util.Random;

public class DummyController implements GameController {

    private final int[] VALUES = { -1, 1 };
    private final Random random = new Random();

    @Override
    public void init() {

    }

    @Override
    public void onPause() {

    }

    @Override
    public void onResume() {

    }

    @Override
    public int getDeltaX() {
        return VALUES[random.nextInt(VALUES.length)];
    }

    @Override
    public int getDeltaY() {
        return VALUES[random.nextInt(VALUES.length)];
    }

    @Override
    public String getDebug() {
        return "It's all a bit random";
    }
}
