package com.example.trainapp.gestureoverlayview;

import android.content.Intent;
import android.gesture.Gesture;
import android.gesture.GestureLibraries;
import android.gesture.GestureLibrary;
import android.gesture.GestureOverlayView;
import android.gesture.Prediction;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.trainapp.Activity.CalculatorActivity;
import com.example.trainapp.R;

import java.util.ArrayList;

public class GestureFindActivity extends AppCompatActivity implements GestureOverlayView.OnGesturePerformedListener, View.OnClickListener {
    public static final String TAG = "GestureFindActivity";
    GestureOverlayView gesturesView;
    TextView txt;
    private ImageButton gesture_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gesture_find);

        gesturesView = findViewById(R.id.gestures);
        gesturesView.addOnGesturePerformedListener(this);
        txt = findViewById(R.id.textView1);

        gesture_back = (ImageButton) findViewById(R.id.train_back);
        gesture_back.setOnClickListener(this);
    }

    @Override
    public void onGesturePerformed(GestureOverlayView gestureOverlayView, Gesture gesture) {
        ArrayList predictions = GestureHelp.getInstance().getFindResult(gesture);
        Log.e(TAG, "onGesturePerformed: " + predictions.size());
        if (predictions.size() > 0) {
            Prediction prediction = (Prediction) predictions.get(0);
            Log.e(TAG, "onGesturePerformed: " + prediction.score);
            if (prediction.score > 2.0) {
                Toast.makeText(this, prediction.name, Toast.LENGTH_SHORT).show();
                txt.append(prediction.name);
            } else {
                Toast.makeText(this, "未识别出！！！", Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        setResult(RESULT_OK, intent);
        GestureFindActivity.this.finish();
    }
}
