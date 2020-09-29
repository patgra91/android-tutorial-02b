package com.example.helloconstraint2;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String LOG_TAG = MainActivity.class.getSimpleName();
    private int mCount = 0;
    private TextView mShowCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mShowCount = (TextView) findViewById(R.id.show_count);

        Log.d(LOG_TAG,"Message world");
        Log.d("MainActivity", "Hello world");
    }

    public void showToast(View view) {
        Toast toast = Toast.makeText(this, R.string.toast_message, Toast.LENGTH_SHORT);
        toast.show();
    }

    @SuppressLint("ResourceAsColor")
    public void countUp(View view) {
        ++mCount;
        if (mShowCount != null) {
            mShowCount.setText(Integer.toString(mCount));
            if (mCount > 0) {
                Button button = findViewById(R.id.button_zero);
                button.setBackgroundColor(Color.GREEN);
            }
        }

        if ((mCount % 2) == 0) {
            view.setBackgroundResource(R.color.colorPrimary);
        }
        else {
            view.setBackgroundResource(R.color.colorPrimaryDark);
        }
    }

    public void countZero(View view) {
        if (mCount > 0) {
            mCount = 0;
            mShowCount.setText(Integer.toString(mCount));
            view.setBackgroundColor(Color.GRAY);
            Button button = (Button) findViewById(R.id.button_count);
            button.setBackgroundResource(R.color.colorPrimary);
        }
    }
}
