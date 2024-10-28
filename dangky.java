package com.example.androidstudio;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.androidstudio.Activity.login;

public class dangky extends AppCompatActivity {
    private EditText txtUsername, txtPassword, txtPasswordAgain;
    private Button btnRegister;
    private UserDao userDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_dangky);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        txtUsername = findViewById(R.id.txtusername);
        txtPassword = findViewById(R.id.txtpassword);
        txtPasswordAgain = findViewById(R.id.txtpasswordagin);
        btnRegister = findViewById(R.id.btnlogin);
        userDao = new UserDao(this);
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = txtUsername.getText().toString().trim();
                String password = txtPassword.getText().toString().trim();
                String passwordAgain = txtPasswordAgain.getText().toString().trim();

                // Kiểm tra điều kiện
                if (password.equals(passwordAgain)) {
                    // Kiểm tra xem tài khoản đã tồn tại chưa
                    if (userDao.isUserExists(username)) {
                        Toast.makeText(dangky.this, "Tài khoản đã tồn tại", Toast.LENGTH_SHORT).show();
                    } else {
                        // Thêm người dùng mới vào cơ sở dữ liệu
                        userDao.addUser(username, password);
                        Toast.makeText(dangky.this, "Đăng ký thành công", Toast.LENGTH_SHORT).show();

                        // Quay về giao diện đăng nhập
                        Intent intent = new Intent(dangky.this, login.class);
                        startActivity(intent);
                        finish(); // Kết thúc activity hiện tại
                    }
                } else {
                    Toast.makeText(dangky.this, "Mật khẩu không khớp", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}