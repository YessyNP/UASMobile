package com.yessy.uasmobile.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.yessy.uasmobile.R;

public class ListBarangActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_barang);
    }

    public void Tenda(View view) {
        Intent intent = new Intent(this, TendaActivity.class);
        startActivity(intent);
    }

    public void Tas(View view) {
        Intent intent = new Intent(this, TasActivity.class);
        startActivity(intent);
    }
}
