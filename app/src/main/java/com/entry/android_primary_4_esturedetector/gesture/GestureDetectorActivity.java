package com.entry.android_primary_4_esturedetector.gesture;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

import com.entry.android_primary_4_esturedetector.R;
import com.entry.android_primary_4_esturedetector.utils.MyToast;

public class GestureDetectorActivity extends AppCompatActivity {

    private GestureDetector detector;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gesture_detector);

        button = findViewById(R.id.button);

        iniGestureListener();
    }

    @Override
    protected void onResume() {
        button.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return detector.onTouchEvent(event);
            }
        });
        super.onResume();
    }

    private void iniGestureListener(){
        final GestureDetector.SimpleOnGestureListener listener = new GestureDetector.SimpleOnGestureListener(){
            @Override
            public boolean onSingleTapConfirmed(MotionEvent e) {
                MyToast.makeToast(GestureDetectorActivity.this, "single  click!");
                return super.onSingleTapConfirmed(e);
            }

            @Override
            public boolean onDoubleTap(MotionEvent e) {
                MyToast.makeToast(GestureDetectorActivity.this, "double  click down!");
                return super.onDoubleTap(e);
            }

            @Override
            public boolean onDoubleTapEvent(MotionEvent e) {
                switch (e.getActionMasked()){
                    case MotionEvent.ACTION_UP:
                        MyToast.makeToast(GestureDetectorActivity.this, "double  click up!");
                        break;
                }
                return super.onDoubleTapEvent(e);
            }
        };

        new Thread(){
            @Override
            public void run() {
                super.run();
                detector = new GestureDetector(GestureDetectorActivity.this, listener);
            }
        };
    }

    public static void actionstart(Object activity){
        Activity intentActivity = (Activity) activity;
        Intent intent = new Intent(intentActivity, GestureDetectorActivity.class);
        intentActivity.startActivity(intent);
    }
}
