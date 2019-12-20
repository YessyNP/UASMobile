package com.yessy.uasmobile.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.yessy.uasmobile.R;
import com.yessy.uasmobile.model.Security;
import com.yessy.uasmobile.model.User;

public class CreateAccountActivity extends AppCompatActivity {

    EditText etUsername,  etPassword,  etNewPassword;
    Button regbtn;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);

        etUsername = findViewById(R.id.edt_reset_username);
        etPassword = findViewById(R.id.edt_new_password);
        etNewPassword = findViewById(R.id.edt_new_password2);
        regbtn = findViewById(R.id.btn_reg);
        databaseReference = FirebaseDatabase.getInstance().getReference("User");

        regbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addUser();
            }

            private void addUser() {
                final String username = etUsername.getText().toString();
                final String password = etPassword.getText().toString();
                final String newPassword = etNewPassword.getText().toString();

                if (username.isEmpty() ||   password.isEmpty() || newPassword.isEmpty()){

                    showMessage("Mohon isi semua kolom ");

                }else {

                    User user= new User(username,password,newPassword);

                    databaseReference.child(username).child("username").setValue(username.toString());


                    try {

                        databaseReference.child(username).child("password").setValue(Security.encrypt(password));
                        databaseReference.child(username).child("newPassword").setValue(Security.encrypt(newPassword));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    Toast.makeText(getApplication(),"Success",Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(getApplication(),LoginActivity.class);
                    startActivity(intent);

                }

            }

        });

    }

    private void showMessage(String message) {
        Toast.makeText(getApplicationContext(),message,Toast.LENGTH_LONG).show();
    }


}


