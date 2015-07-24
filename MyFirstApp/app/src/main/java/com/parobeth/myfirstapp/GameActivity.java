package com.parobeth.myfirstapp;

import android.os.Handler;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.TextView;


public class GameActivity extends ActionBarActivity {

    private static final int REFRESH_RATE_MS = 1_000;

    private static final int NUMBER_OF_MOVES = 60;
    private static final int ROWS = 10;
    private static final int COLUMNS = 20;

    private Handler timedHandler = new Handler();
    private TextView testText;

    private TextView[] rows = new TextView[ROWS];


    private Runnable gameLoop = new Runnable() {
        // TODO: pause
        @Override
        public void run() {
            testText.setText(
                    (GlobalContext.GAME_CONTROLLER.getDeltaX() < 0 ? "LEFT " : "RIGHT ") +
                     (GlobalContext.GAME_CONTROLLER.getDeltaY() < 0 ? "UP" : "DOWN")
            );

            timedHandler.postDelayed(this, REFRESH_RATE_MS);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        LinearLayout layout = (LinearLayout) findViewById(R.id.gameLayout);

        for (int i = 0; i < ROWS; ++i) {
            layout.addView(rows[i]);
        }

        testText = (TextView) findViewById(R.id.test);
        gameLoop.run();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_game, menu);
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

    @Override
    protected void onResume() {
        super.onResume();
        GlobalContext.GAME_CONTROLLER.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        GlobalContext.GAME_CONTROLLER.onPause();
    }
}
