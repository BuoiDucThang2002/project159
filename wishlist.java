package com.example.deso3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    ArrayList<String> dkdbdt = new ArrayList<>(Arrays.asList("Minh Cong","Manh Hoa","Tinnmy","Tuấn Hưng","Hà Vy","Quang Minh"));

    ListView listView;
    Button btnchitiet;
    Button btnxoa;
    int selectedPosition = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        //tham chieu
        listView = findViewById(R.id.dbdt);
        btnxoa = findViewById(R.id.btnXoa);
        btnchitiet = findViewById(R.id.btnchitiet);
        hienthiListView();
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this,"Ban da chon "+dkdbdt.get(i),Toast.LENGTH_SHORT).show();


            }
        });
        btnchitiet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,JsonActivity.class);
                startActivity(intent);

            }
        });
        btnxoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (selectedPosition != -1) {
                    // Xoá mục được chọn
                    dkdbdt.remove(selectedPosition);
                    // Cập nhật ListView
                    hienthiListView();
                    // Đặt lại vị trí được chọn
                    selectedPosition = -1;
                } else {
                    // Nếu không có mục nào được chọn, hiển thị thông báo
                    Toast.makeText(MainActivity.this, "Vui lòng chọn mục để xóa.", Toast.LENGTH_SHORT).show();
                }
            }
        });

            }






    public void hienthiListView(){
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,dkdbdt);
        listView.setAdapter(adapter);
    }
}