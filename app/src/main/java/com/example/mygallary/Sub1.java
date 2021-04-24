package com.example.mygallary;

import androidx.appcompat.app.AppCompatActivity;
import android.app.ProgressDialog;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;
import android.os.Bundle;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mygallary.ListSelect;
import com.example.mygallary.MyRecyclerViewAdapter;
import com.example.mygallary.MyItem;

import java.util.ArrayList;

import static com.example.mygallary.CommonMethod.isNetworkConnected;

public class Sub1 extends AppCompatActivity {
    private static final String TAG = "main Sub1";

    public static MyItem selItem = null;
    Button button1, button2, button3, button4;
    RecyclerView recyclerView;
    MyRecyclerViewAdapter adapter;
    ArrayList<MyItem> myItemArrayList;

    ListSelect listSelect;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub1);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);

        //리사이클러 뷰 시작
        recyclerView = findViewById(R.id.recyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);

        myItemArrayList = new ArrayList<>();
        adapter = new MyRecyclerViewAdapter(this, myItemArrayList);

        recyclerView.setAdapter(adapter);

        if(isNetworkConnected(this) == true) {
            listSelect = new ListSelect(myItemArrayList, adapter);
            listSelect.execute();
        } else {
            Toast.makeText(this, "인터넷 연결 실패", Toast.LENGTH_SHORT).show();
        }
    }
}









