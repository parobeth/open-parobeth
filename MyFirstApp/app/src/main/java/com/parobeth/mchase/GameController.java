package com.parobeth.mchase;

public interface GameController {

    void onPause();
    void onResume();
    int getDeltaX();
    int getDeltaY();

    String getDebug();
}
