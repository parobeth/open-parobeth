package com.parobeth.myfirstapp;

public interface GameController {

    void init();
    void onPause();
    void onResume();
    int getDeltaX();
    int getDeltaY();

    String getDebug();
}
