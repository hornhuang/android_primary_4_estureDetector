package com.entry.android_primary_4_esturedetector;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.entry.android_primary_4_esturedetector.gesture.GestureDetectorActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView mGestureDetector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mGestureDetector = findViewById(R.id.gesture_detector);
        mGestureDetector.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.gesture_detector:
                GestureDetectorActivity.actionstart(MainActivity.this);
                break;
        }
    }
}
