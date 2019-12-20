package com.yessy.uasmobile.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.yessy.uasmobile.R;
import com.yessy.uasmobile.model.Security;
import com.yessy.uasmobile.model.User;

public class LoginActivity extends AppCompatActivity {

    EditText etUsername,etPassword;
    Button btnLogin;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etUsername = findViewById(R.id.edt_login_username);
        etPassword = findViewById(R.id.edt_login_password);
        btnLogin = findViewById(R.id.btn_login);
        databaseReference = FirebaseDatabase.getInstance().getReference("User");

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String pwd = null;
                try {
                    pwd = Security.encrypt(etPassword.getText().toString());
                } catch (Exception e) {
                    e.printStackTrace();
                }
                logIn(etUsername.getText().toString(), pwd);
            }
        });
    }

    private void logIn(final String username, final String password) {
        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.child(username).exists()) {
                    if (!username.isEmpty()) {
                        User login = dataSnapshot.child(username).getValue(User.class);
                        if (login.getPassword().equals(password)) {
                            Toast.makeText(LoginActivity.this, "Login Success", Toast.LENGTH_LONG).show();
                            Intent intphto = new Intent(getApplicationContext(), SewaActivity.class);
                            startActivity(intphto);
                        } else {
                            Toast.makeText(LoginActivity.this, "Password Incorrect", Toast.LENGTH_LONG).show();
                        }
                    } else {
                        Toast.makeText(LoginActivity.this, "User is not register", Toast.LENGTH_LONG).show();
                    }
                } else {
                    Toast.makeText(LoginActivity.this, "User is not register", Toast.LENGTH_LONG).show();

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
