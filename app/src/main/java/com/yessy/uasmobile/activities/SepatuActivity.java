package com.yessy.uasmobile.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.yessy.uasmobile.R;

public class SepatuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sepatu);
    }

    public void handleExit(View view) {
        finish();
    }
}
