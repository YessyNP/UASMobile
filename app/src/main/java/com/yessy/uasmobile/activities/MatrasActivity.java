package com.yessy.uasmobile.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.yessy.uasmobile.R;

public class MatrasActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_matras);
    }


    public void handleExit(View view) {
        finish();
    }
}
