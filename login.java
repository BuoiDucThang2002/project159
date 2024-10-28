package com.example.androidstudio.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.androidstudio.R;
import com.example.androidstudio.UserDao;
import com.example.androidstudio.dangky;

public class login extends AppCompatActivity {
    private EditText txtusername;
    private EditText txtpassword;
    private Button btnlogin;
    private UserDao userDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);
        txtusername=findViewById(R.id.txtusername);
        txtpassword=findViewById(R.id.txtpassword);
        btnlogin=findViewById(R.id.btnlogin);
        userDao = new UserDao(this);

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username=txtusername.getText().toString().trim();
                String password = txtpassword.getText().toString().trim();
                if (userDao.checkUser(username, password)){
                    Toast.makeText(login.this, "Welcome back!", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(login.this, MainActivity.class);
                    startActivity(intent);

                }
                else {
                    Toast.makeText(login.this, "Invalid credentials. Please try again.", Toast.LENGTH_SHORT).show();
                }
            }
        });
        TextView signInTextView = findViewById(R.id.textView26);
        signInTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Chuyển hướng đến trang đăng nhập
                Intent intent = new Intent(login.this, dangky.class);
                startActivity(intent);
            }
        });




    }
}