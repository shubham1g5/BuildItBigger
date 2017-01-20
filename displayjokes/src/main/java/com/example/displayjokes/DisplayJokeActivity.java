package com.example.displayjokes;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DisplayJokeActivity extends AppCompatActivity {

    public static final String EXTRA_JOKE = "extra_joke";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_joke);

        if (getIntent() != null) {
            String joke = getIntent().getStringExtra(EXTRA_JOKE);
            ((TextView) findViewById(R.id.jokeTv)).setText(joke);
        }
    }
}
