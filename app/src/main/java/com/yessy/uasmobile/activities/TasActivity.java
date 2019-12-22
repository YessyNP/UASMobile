package com.yessy.uasmobile.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.yessy.uasmobile.R;

public class TasActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tas);
    }

    public void handleExit(View view) {
        finish();
    }
}
