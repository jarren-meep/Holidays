package com.myapplicationdev.android.holidays;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    ListView lv;
    ArrayList<String> al;
    ArrayAdapter<String> aa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        al = new ArrayList<String>();
        al.add("Secular");
        al.add("Ethnic");
        lv = findViewById(R.id.lv1);
        aa = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, al);

        lv.setAdapter(aa);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String type = al.get(i);
                Intent intent = new Intent(getApplicationContext(),Main2Activity.class);
                intent.putExtra("type", type);
                startActivity(intent);
            }
        });
    }
}
