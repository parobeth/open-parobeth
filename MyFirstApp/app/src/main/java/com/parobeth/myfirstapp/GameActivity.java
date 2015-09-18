package com.parobeth.myfirstapp;

import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.ActionBarActivity;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Random;

import static java.lang.Math.signum;


public class GameActivity extends ActionBarActivity {

    private static final int REFRESH_RATE_MS = 125;

    private static final int ROUND_TIME_MS = 60_000;
    private static final int ROWS = 10;
    private static final int COLUMNS = 20;

    private final Handler timedHandler = new Handler();
    private final Random random = new Random();

    private TextView headerRow;
    private TextView[] rows = new TextView[ROWS];
    private StringBuilder[] grid = new StringBuilder[ROWS];

    private int man_x = COLUMNS / 2;
    private int man_y = ROWS / 2;
    private int score = 0;
    private int timeRemaining = ROUND_TIME_MS;

    private Runnable gameLoop = new Runnable() {
        // TODO: pause
        @Override
        public void run() {

            int m_x = random.nextInt(COLUMNS);
            int m_y = random.nextInt(ROWS);

            grid[m_y].replace(m_x, m_x + 1, "M");
            rows[m_y].setText(grid[m_y]);

            int delta_x = (int)signum(GlobalContext.GAME_CONTROLLER.getDeltaX());
            int delta_y = (int)signum(GlobalContext.GAME_CONTROLLER.getDeltaY());

            grid[man_y].replace(man_x, man_x + 1, " ");
            rows[man_y].setText(grid[man_y]);

            man_x += delta_x;
            if (man_x < 0) man_x = 0;
            if (man_x >= COLUMNS) man_x = COLUMNS - 1;

            man_y -= delta_y;
            if (man_y < 0) man_y = 0;
            if (man_y >= ROWS) man_y = ROWS - 1;

            if(grid[man_y].charAt(man_x) == 'M') {
                ++score;
            }

            grid[man_y].replace(man_x, man_x + 1, "*");
            rows[man_y].setText(grid[man_y]);

            headerRow.setText("Score: " + score + " Time remaining: " + timeRemaining / 1_000 + " " + GlobalContext.GAME_CONTROLLER.getDebug());
            timeRemaining -= REFRESH_RATE_MS;

            if (timeRemaining > 0) {
                timedHandler.postDelayed(this, REFRESH_RATE_MS);
            } else {
                GlobalContext.LAST_SCORE = score;
                finish();
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        setContentView(R.layout.activity_game);

        LinearLayout layout = (LinearLayout) findViewById(R.id.gameLayout);

        headerRow = new TextView(this);
        layout.addView(headerRow);

        StringBuilder blankLine = new StringBuilder(COLUMNS);

        for (int i = 0; i < COLUMNS; ++i) {
            blankLine.append(' ');
        }

        for (int i = 0; i < ROWS; ++i) {
            rows[i] = new TextView(this);
            rows[i].setTypeface(Typeface.MONOSPACE);
            rows[i].setGravity(Gravity.CENTER);
            layout.addView(rows[i]);
            grid[i] = new StringBuilder(blankLine);
        }

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
